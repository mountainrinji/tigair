package pl.mountainrinji.db.dao;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import pl.mountainrinji.Utils;
import pl.mountainrinji.db.entities.FlightHistory;

import org.springframework.transaction.annotation.Propagation;

@Service
public class FlightHistoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addFlightTime(Integer aircraftId, String flightTime, String date) {
		FlightHistory fh = new FlightHistory();
		fh.setAircraftId(aircraftId);
		fh.setDate(getDateOfFlight(date));
		fh.setFlightTime(flightTime);
		sessionFactory.getCurrentSession().save(fh);
	}

	private Date getDateOfFlight(String date) {
		if (StringUtils.isEmpty(date)) {
			return new Date();
		} else {
			String splitter = "Data:";
			
			if (!date.contains("Data:")) {
				splitter = "Data";
			}
			String [] array = date.split(splitter);
			for (int i=0; i < array.length; i++) {
				String part = array[i].trim();
				if (!StringUtils.isEmpty(part)) {
					try {
						Date dateOfFlight = Utils.convertString(part);
						return dateOfFlight;
					} catch (Exception ex) {
						System.out.println("Parsing date not succeeded...");
						continue;
					}
				}
			}
		}
		return new Date();
	}
}
