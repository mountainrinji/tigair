package pl.mountainrinji.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.mountainrinji.db.entities.Activity;
import pl.mountainrinji.db.entities.Aircraft;
import pl.mountainrinji.db.entities.AircraftActivityStatus;
import pl.mountainrinji.rest.displaydatas.ActivityDisplayData;
import pl.mountainrinji.rest.displaydatas.AircraftActivitiesStatusResult;
import pl.mountainrinji.rest.displaydatas.AircraftActivityStatusDisplayData;
import pl.mountainrinji.rest.displaydatas.AircraftDisplayData;
import pl.mountainrinji.rest.displaydatas.Part;
import pl.mountainrinji.rest.displaydatas.RowConfigurationDisplayData;

@Service
public class AircraftActivityStatusDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<AircraftActivityStatus> getAllActivityStatuses() {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(AircraftActivityStatus.class);
		List<AircraftActivityStatus> list = createCriteria.list();
		return list;
	}
	
	@Transactional
	public String getAircraftActivitiesExecution(String registrationMark, String activityPart, String activityType) throws JSONException, JsonProcessingException {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(AircraftActivityStatus.class);
		createCriteria.createAlias("activity", "activity");
		createCriteria.add(Restrictions.eq("activity.activityPart", activityPart));
		createCriteria.add(Restrictions.eq("activity.activityType", activityType));
		
		createCriteria.createAlias("aircraft", "aircraft");
		createCriteria.add(Restrictions.eq("aircraft.name", registrationMark));
		List<AircraftActivityStatus> list = createCriteria.list();
		return new ObjectMapper().writeValueAsString((constructResultList(list)));
	}
	
	private List<AircraftActivitiesStatusResult> constructResultList(List<AircraftActivityStatus> list) {
		List<AircraftActivitiesStatusResult> convertedList = new ArrayList<AircraftActivitiesStatusResult>();
		for (AircraftActivityStatus aas : list) {
			AircraftActivitiesStatusResult result = new AircraftActivitiesStatusResult();
			result.setActivity(new ActivityDisplayData(aas.getActivity()).calculateValues());
			result.setAircraft(new AircraftDisplayData(aas.getAircraft()));
			result.setAircraftActivityStatus(new AircraftActivityStatusDisplayData(aas).calculateValues());
			result.setRowConfiguration(new RowConfigurationDisplayData(result.getAircraftActivityStatus()));
			result.setEngine(new Part(aas.getAircraft().getEngineModel(), 
					aas.getAircraft().getEngineSerialNo(),
					aas.getAircraft().getEngineManufacturedYear(), 
					aas.getAircraft().getEngineTypeCertificate(), 
					aas.getAircraft().getEngineTotalTime(), 
					aas.getAircraft().getEngineTimeSinceOverhaul()));
			result.setPropeller(new Part(aas.getAircraft().getPropellerModel(), 
					aas.getAircraft().getPropellerSerialNo(),
					aas.getAircraft().getPropellerManufacturedYear(), 
					aas.getAircraft().getPropellerTypeCertificate(), 
					aas.getAircraft().getPropellerTotalTime(), 
					aas.getAircraft().getPropellerTimeSinceOverhaul()));
			
			if (result.getActivity().getRoot().getDeprecated() == true && result.getAircraft().getRoot().getShowDeprecated() == false) {
				continue;
			}
			convertedList.add(result);
		}
		
		return convertedList;
	}

	private JSONArray mapToJsonArray(List<AircraftActivityStatus> list) throws JSONException {
		JSONArray array = new JSONArray();
		for (AircraftActivityStatus aas : list) {
			JSONObject jsob = new JSONObject();
			jsob.put("aircraft_name", aas.getAircraft().getName());
			jsob.put("activity_name", aas.getActivity().getActivityName());
			jsob.put("activity_executed_hours", aas.getExecutedHours());
			array.put(jsob);
		}
		
		return array;
	}
}
