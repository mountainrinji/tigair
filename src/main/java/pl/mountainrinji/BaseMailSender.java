package pl.mountainrinji;

import java.net.InetAddress;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pl.mountainrinji.db.dao.AircraftActivityStatusDAO;
import pl.mountainrinji.db.dao.AircraftDAO;
import pl.mountainrinji.db.entities.AircraftActivityStatus;
import pl.mountainrinji.rest.displaydatas.AircraftActivityStatusDisplayData;
import pl.mountainrinji.spring.ApplicationContextProvider;

public class BaseMailSender {
	
	private AircraftActivityStatusDAO aasDao;
	private AircraftDAO aircraftDao;

	protected void sendEmail(String subject, String body, String toAddresses) {

		body = attachHostInfo(body);
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
					InternetAddress.parse(toAddresses));
			message.setSubject(subject);
			message.setContent(body, "text/html; charset=utf-8");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private String attachHostInfo(String body) {
		InetAddress ip;
		
		try {
			ip = InetAddress.getLocalHost();
			body = body + "<br><br><br><br><br>-------------------------------------------------------------------------<br>"
					+ "<br>Detale pod adresem: http://" + ip.getHostAddress() + ":8080/tigair/content/index.html";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return body;
		
	}
	
	protected AircraftActivityStatusDisplayData getAASDDForAAS(AircraftActivityStatus aas) {
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
		
		return aasdd;
	}
	
	protected String constructRow(String rowClass, AircraftActivityStatusDisplayData aasdd) {
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
	
	protected AircraftActivityStatusDAO getAasDao() {
		if (aasDao == null) {
			aasDao = ApplicationContextProvider.getApplicationContext().getBean(AircraftActivityStatusDAO.class);
		}
		
		return aasDao;
	}
	
	protected AircraftDAO getAircraftDao() {
		if (aircraftDao == null) {
			aircraftDao = ApplicationContextProvider.getApplicationContext().getBean(AircraftDAO.class);
		}
		
		return aircraftDao;
	}
}
