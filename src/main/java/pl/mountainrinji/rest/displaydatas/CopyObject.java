package pl.mountainrinji.rest.displaydatas;

import java.util.List;

public class CopyObject {

	List<AircraftActivitiesStatusResult> addedRecords;
	String source;
	String target;
	public List<AircraftActivitiesStatusResult> getAddedRecords() {
		return addedRecords;
	}
	public void setAddedRecords(List<AircraftActivitiesStatusResult> addedRecords) {
		this.addedRecords = addedRecords;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public CopyObject(List<AircraftActivitiesStatusResult>  addedRecords, String source, String target) {
		super();
		this.addedRecords = addedRecords;
		this.source = source;
		this.target = target;
	}
	
	public CopyObject() {
		
	}
	
	
}
