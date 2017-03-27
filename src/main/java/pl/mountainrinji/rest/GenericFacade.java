package pl.mountainrinji.rest;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.hibernate.Session;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import pl.mountainrinji.SummaryMailSender;
import pl.mountainrinji.db.dao.AircraftActivityStatusDAO;
import pl.mountainrinji.db.dao.AircraftDAO;
import pl.mountainrinji.rest.displaydatas.AircraftActivitiesStatusResult;
import pl.mountainrinji.rest.displaydatas.CopyObject;
import pl.mountainrinji.spring.ApplicationContextProvider;

@Path("/genericFacade")
public class GenericFacade {
	
	@PUT
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object update(AircraftActivitiesStatusResult object) throws ParseException {
		/*try {
			((SummaryMailSender)ApplicationContextProvider.getApplicationContext().getBean(SummaryMailSender.class)).sendSummaryEmail();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        getAircraftActivityStatusDAO().save(object);
        return "";
    }
	
	@POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object create(AircraftActivitiesStatusResult object) throws ParseException {
		
        //getAircraftActivityStatusDAO().save(object);
        return "";
    }
	
	@PUT
    @Path("/copy")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String copy(CopyObject object) throws ParseException {
		
        return "";
    }
	
    
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newBulletin")
	public Response newBulletin(Object bulletin) {
		
		return null;
	}
    
    @GET
    @Path("/getJavaActivitiesStatus")
    @Produces(MediaType.TEXT_PLAIN)
    public String getActivitiesStatus(@QueryParam("activityId") String activityId) {
    	//AircraftDAO dao = (AircraftDAO) ApplicationContextProvider.getApplicationContext().getBean(AircraftDAO.class);
    	//return dao.getFirstAircraftName();
    	
    	return "Java returns - activities up to date" + activityId;
    }
    
    @GET
    @Path("/getAircraftActivitiesExecution")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAircraftActivitiesExecution(
    		@QueryParam("regmark") String registrationMark,
    		@QueryParam("activityPart") String activityPart,
    		@QueryParam("activityType") String activityType) throws JSONException, JsonProcessingException {
    	Response response = Response.ok(getAircraftActivityStatusDAO().getAircraftActivitiesExecution(registrationMark, activityPart, activityType)).build();
    	return response;
    }
    
    @GET
    @Path("/getAircraftData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAircraftData(@QueryParam("regmark") String registrationMark) throws JSONException, JsonProcessingException {
    	return Response.ok(getAircraftDAO().getAircraftData(registrationMark)).build();
    }
    
    private AircraftActivityStatusDAO getAircraftActivityStatusDAO() {
    	return (AircraftActivityStatusDAO) ApplicationContextProvider.getApplicationContext().getBean(AircraftActivityStatusDAO.class);
    }
    
    private AircraftDAO getAircraftDAO() {
    	return (AircraftDAO) ApplicationContextProvider.getApplicationContext().getBean(AircraftDAO.class);
    }

    
    
}
