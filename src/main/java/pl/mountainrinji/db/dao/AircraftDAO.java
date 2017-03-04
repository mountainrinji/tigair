package pl.mountainrinji.db.dao;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.mountainrinji.db.entities.Aircraft;

@Service
public class AircraftDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public String getAircraftData(String registrationMark) throws JsonProcessingException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Aircraft.class);
		criteria.add(Restrictions.eq("name", registrationMark));
		Aircraft af = (Aircraft) criteria.list().get(0);
		af.setAircraftActivityStatuses(null);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(af);
	}
	
	@Transactional
	public Aircraft getAircraft(String registrationMark) throws JsonProcessingException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Aircraft.class);
		criteria.add(Restrictions.eq("name", registrationMark));
		Aircraft af = (Aircraft) criteria.list().get(0);
		return af;
	}
	
	@Transactional
	public List getAircraftsForSummaryDate(String day) throws JsonProcessingException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Aircraft.class);
		criteria.add(Restrictions.eq("summaryDate", day));
		return criteria.list();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateAircraft(Aircraft a) {
		sessionFactory.getCurrentSession().saveOrUpdate(a);
	}
}
