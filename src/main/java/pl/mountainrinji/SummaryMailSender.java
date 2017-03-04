package pl.mountainrinji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;

import pl.mountainrinji.db.dao.AircraftActivityStatusDAO;
import pl.mountainrinji.db.dao.AircraftDAO;
import pl.mountainrinji.db.entities.Aircraft;
import pl.mountainrinji.db.entities.AircraftActivityStatus;

@Service
public class SummaryMailSender extends BaseMailSender {

	@Autowired
	private AircraftDAO aircraftDao;
	
	@Autowired
	private AircraftActivityStatusDAO aircraftActivityStatusDao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void sendSummaryEmail() throws JsonProcessingException {
		int i = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		List<Aircraft> aircraftsForSummaryDate = aircraftDao.getAircraftsForSummaryDate(i + "");
		
		for (Aircraft a : aircraftsForSummaryDate) {
			sendSummaryForAircraft(a);
		}
	}

	private void sendSummaryForAircraft(Aircraft a) {
		List<AircraftActivityStatus> allActivityStatusesForAircraft = aircraftActivityStatusDao.getAllActivityStatusesForAircraft(a.getId());
		List<AircraftActivityStatus> dones = new ArrayList<AircraftActivityStatus>();
		List<AircraftActivityStatus> todos = new ArrayList<AircraftActivityStatus>();
		for (int i=0; i < allActivityStatusesForAircraft.size(); i++) {
			AircraftActivityStatus aas = allActivityStatusesForAircraft.get(i);
			isDone(aas, dones);
			isTodo(aas, todos);
		}
		
	}

	private void isTodo(AircraftActivityStatus aas, List<AircraftActivityStatus> todos) {
		// TODO Auto-generated method stub
		
	}

	private void isDone(AircraftActivityStatus aas, List<AircraftActivityStatus> dones) {
		Date executedDate = aas.getExecutedDate();
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_MONTH, 1);
		Calendar monthEnd = (Calendar) now.clone();
		monthEnd.add(Calendar.DAY_OF_MONTH, -1);
		Calendar monthStart = (Calendar) monthEnd.clone();
		monthStart.set(Calendar.DAY_OF_MONTH, 1);
		
		if (executedDate.before(monthEnd.getTime()) && executedDate.after(monthStart.getTime())) {
			dones.add(aas);
		}
	}
	
}
