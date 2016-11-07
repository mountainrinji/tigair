package pl.mountainrinji;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javassist.compiler.ast.Pair;
import pl.mountainrinji.db.dao.AircraftActivityStatusDAO;
import pl.mountainrinji.db.entities.AircraftActivityStatus;
import pl.mountainrinji.rest.displaydatas.AircraftActivityStatusDisplayData;
import pl.mountainrinji.rest.displaydatas.RowConfigurationDisplayData;
import pl.mountainrinji.spring.ApplicationContextProvider;

@Service
public class StatusCalculator {

	private AircraftActivityStatusDAO aasDao;
	
	private Map<String, StringBuffer> reds = new HashMap<String, StringBuffer>();
	private Map<String, StringBuffer> yellows = new HashMap<String, StringBuffer>();
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void checkStatusesAndSendEmails() {
		
		try {
			reds = new HashMap<String, StringBuffer>();
			yellows = new HashMap<String, StringBuffer>();
			
			List<AircraftActivityStatus> activities = getAasDao().getAllActivityStatuses();
			
			for (int index = 0; index < activities.size(); index++) {
				AircraftActivityStatus aas = activities.get(index);
				if (aas != null && aas.getActivity().getDeprecated() != true) {
					calculateDueDatesAndSaveThem(activities.get(index));
				}
			}
			
			prepareAndSendEmails();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void sendEmail(String registration, String body) {
		final String username = "tigair.tt@gmail.com";
		final String password = "1qa2ws#ED";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tigair.tt@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("leszczyfon@gmail.com"));
			message.setSubject("[" + registration + "-TODO");
			message.setContent(body, "text/html; charset=utf-8");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void prepareAndSendEmails() {
		Map<String, StringBuffer> map = new HashMap<String, StringBuffer>();
		
		for (String regmark : this.reds.keySet()) {
			map.put(regmark, this.reds.get(regmark));
		}
		
		for (String regmark : this.yellows.keySet()){
			if (!map.containsKey(regmark)) {
				map.put(regmark, this.yellows.get(regmark));
			} else {
				map.get(regmark).append("<br><br>").append(this.yellows.get(regmark));
			}
		}

		for (String regmark : map.keySet()) {
			sendEmail(regmark, map.get(regmark).toString());
		}
		
		
	}

	private void calculateDueDatesAndSaveThem(AircraftActivityStatus aas) {
		
		String hoursLeftStr = "---";
		long hoursLeftInMillis = Long.MAX_VALUE;
		String daysLeftStr = "---";
		Integer daysLeft = Integer.MAX_VALUE;
		String cyclesLeftStr = "---";
		Integer cyclesLeft = Integer.MAX_VALUE;
		
		
		if (aas.getActivity().getHoursInterval() != null) {
			hoursLeftStr = Utils.substractTimes(aas.getNextExecutionHours(), aas.getAircraft().getTotalTime());
			hoursLeftInMillis = Utils.getMillisFromTime(hoursLeftStr);
		}
		
		if (aas.getActivity().getCalendarInterval() != null) {
			daysLeftStr = Utils.getDifferenceBetweenObjects(aas.getNextExecutionDate(), new Date());
			daysLeft = Integer.parseInt(daysLeftStr);
		}
		
		if (aas.getActivity().getCyclesInterval() != null) {
			cyclesLeftStr = Utils.getDifferenceBetweenObjects(aas.getNextExecutionCycles(), aas.getAircraft().getTotalCycles());
			cyclesLeft = Integer.parseInt(cyclesLeftStr);
		}
		
		AircraftActivityStatusDisplayData aasdd = new AircraftActivityStatusDisplayData(aas);
		aasdd.setHoursLeft(hoursLeftInMillis);
		aasdd.setDaysLeft(daysLeft);
		aasdd.setCyclesLeft(cyclesLeft);
		aasdd.setHoursLeftStr(hoursLeftStr);
		aasdd.setDaysLeftStr(daysLeftStr);
		aasdd.setCyclesLeftStr(cyclesLeftStr);
		
		RowConfigurationDisplayData rcdd = new RowConfigurationDisplayData(aasdd);
		String rowClass = rcdd.getRowClass();
		
		if (rowClass.equals("yellow-warning") && aas.getYellowWarningCounter() < 2) {
			addWarning(this.yellows, "yellow", aasdd);
			updateCounter("yellow", aas.getYellowWarningCounter() + 1, aas);
		} else if (rowClass.equals("red-warning") && aas.getRedWarningCounter() < 2) {
			addWarning(this.reds, "red", aasdd);
			updateCounter("red", aas.getRedWarningCounter() + 1, aas);
		}
	}

	private void updateCounter(String color, Integer newCounter, AircraftActivityStatus aas) {
		if (color.equals("yellow")) {
			aas.setYellowWarningCounter(newCounter);
		} else {
			aas.setRedWarningCounter(newCounter);
		}
		getAasDao().update(aas);
	}
	
	private void addWarning(Map<String, StringBuffer> map, String rowClass, AircraftActivityStatusDisplayData aasdd) {
		if (!map.containsKey(aasdd.getRoot().getAircraft().getName())) {
			map.put(aasdd.getRoot().getAircraft().getName(), constructHeader(rowClass));
		}
		
		map.get(aasdd.getRoot().getAircraft().getName()).append(constructRow(rowClass, aasdd));
		
		
	}

	private String constructRow(String rowClass, AircraftActivityStatusDisplayData aasdd) {
		String row = "";
		row = row + "<tr style=\"background-color:" + rowClass + ";\">"
				+ "<td>" + Utils.constructActivityId(aasdd) + "</td>"
				+ "<td>" + aasdd.getRoot().getActivity().getActivityName() + "</td>"
			    + "<td>" + aasdd.getRoot().getActivity().getDescription() + "</td>"
				+ "<td>" + (aasdd.getRoot().getNextExecutionDate() == null ? "---" : aasdd.getRoot().getNextExecutionDate() ) + "</td>"
				+ "<td>" + (aasdd.getRoot().getNextExecutionHours() == null ? "---" : aasdd.getRoot().getNextExecutionHours() ) + "</td>"
				+ "<td>" + (aasdd.getRoot().getNextExecutionCycles() == null ? "---" : aasdd.getRoot().getNextExecutionCycles() ) + "</td>"
				+ "<td>" + aasdd.getDaysLeftStr() + "</td>"
				+ "<td>" + aasdd.getHoursLeftStr() + "</td>"
				+ "<td>" + aasdd.getCyclesLeftStr() + "</td>"
				+ "</tr>";
		
		return row;
	}

	private StringBuffer constructHeader(String rowClass) {
		StringBuffer sb = new StringBuffer();
		
		if (rowClass.equals("red")) {
			sb.append("Następujące czynności okresowe wymagają niezwłocznego wykonania:\n\n");
		} else if (rowClass.equals("yellow")) {
			sb.append("Termin nastepujacych czynności okresowych wygasa wkrótce:\n\n");
		}
		
		sb.append("<table style=\"border-size:1px;\"><thead><tr>"
				+ "<th>Ident. zadania</th>"
				+ "<th>Nazwa</th>"
				+ "<th>Opis</th>"
				+ "<th>Data wygaśnięcia</th>"
				+ "<th>Nalot wygaśnięcia</th>"
				+ "<th>Cykle wygaśnięcia</th>"
				+ "<th>Pozostało dni</th>"
				+ "<th>Pozostało godzin</th>"
				+ "<th>Pozostało cykli</th>"
				+ "</tr></thead><tbody>");
		return sb;
	}

	private AircraftActivityStatusDAO getAasDao() {
		if (aasDao == null) {
			aasDao = ApplicationContextProvider.getApplicationContext().getBean(AircraftActivityStatusDAO.class);
		}
		
		return aasDao;
	}
}
