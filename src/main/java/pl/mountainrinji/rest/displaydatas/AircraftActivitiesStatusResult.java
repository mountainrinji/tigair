package pl.mountainrinji.rest.displaydatas;

public class AircraftActivitiesStatusResult {
	
	private RowConfigurationDisplayData rowConfiguration;
	private AircraftActivityStatusDisplayData aircraftActivityStatus;
	private AircraftDisplayData aircraft;
	private ActivityDisplayData activity;
	private Part engine;
	private Part propeller;
	
	public AircraftActivityStatusDisplayData getAircraftActivityStatus() {
		return aircraftActivityStatus;
	}
	public void setAircraftActivityStatus(AircraftActivityStatusDisplayData aircraftActivityStatus) {
		this.aircraftActivityStatus = aircraftActivityStatus;
	}
	public AircraftDisplayData getAircraft() {
		return aircraft;
	}
	public void setAircraft(AircraftDisplayData aircraft) {
		this.aircraft = aircraft;
	}
	public ActivityDisplayData getActivity() {
		return activity;
	}
	public void setActivity(ActivityDisplayData activity) {
		this.activity = activity;
	}
	public RowConfigurationDisplayData getRowConfiguration() {
		return rowConfiguration;
	}
	public void setRowConfiguration(RowConfigurationDisplayData rowConfiguration) {
		this.rowConfiguration = rowConfiguration;
	}
	public Part getEngine() {
		return engine;
	}
	public void setEngine(Part engine) {
		this.engine = engine;
	}
	public Part getPropeller() {
		return propeller;
	}
	public void setPropeller(Part propeller) {
		this.propeller = propeller;
	}
	
	
	
}
