package pl.mountainrinji.rest;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import pl.mountainrinji.db.dao.AircraftActivityStatusDAO;
import pl.mountainrinji.db.dao.AircraftDAO;
import pl.mountainrinji.spring.ApplicationContextProvider;

@Path("/genericFacade")
public class GenericFacade {
	
	
    
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
    		@QueryParam("activityPart") String activityPart,
    		@QueryParam("activityType") String activityType) throws JSONException, JsonProcessingException {
    	Response response = Response.ok(getAircraftActivityStatusDAO().getAircraftActivitiesExecution(activityPart, activityType)).build();
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
