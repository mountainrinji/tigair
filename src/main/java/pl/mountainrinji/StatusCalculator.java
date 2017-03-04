package pl.mountainrinji;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.mountainrinji.db.entities.AircraftActivityStatus;
import pl.mountainrinji.rest.displaydatas.AircraftActivityStatusDisplayData;
import pl.mountainrinji.rest.displaydatas.RowConfigurationDisplayData;

@Service
public class StatusCalculator extends BaseMailSender {
	
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
			sendEmail("[" + regmark + "-TODO] Czynnosci do wykonania", map.get(regmark).toString(), "leszczyfon@gmail.com");
		}
		
		
	}

	private void calculateDueDatesAndSaveThem(AircraftActivityStatus aas) {
		AircraftActivityStatusDisplayData aasdd = getAASDDForAAS(aas);
		
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
}
