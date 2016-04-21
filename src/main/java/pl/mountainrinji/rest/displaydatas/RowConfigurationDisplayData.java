package pl.mountainrinji.rest.displaydatas;

public class RowConfigurationDisplayData {

	private static Integer YELLOW_TRESHHOLD_HOURS = 10;
	private static Integer RED_TRESHHOLD_HOURS = 5;
	
	private static Integer YELLOW_TRESHHOLD_DAYS = 30;
	private static Integer RED_TRESHHOLD_DAYS = 10;
	
	private static Integer YELLOW_TRESHHOLD_CYCLES = 15;
	private static Integer RED_TRESHHOLD_CYCLES = 7;
	
	private String rowClass;

	public RowConfigurationDisplayData(AircraftActivityStatusDisplayData activityStatus) {
		determineRowClass(activityStatus);
	}
	
	private void determineRowClass(AircraftActivityStatusDisplayData activityStatus) {
		rowClass = "";
		
		if (activityStatus.getHoursLeft() <= YELLOW_TRESHHOLD_HOURS ||
				activityStatus.getDaysLeft() <= YELLOW_TRESHHOLD_DAYS ||
				activityStatus.getCyclesLeft() <= YELLOW_TRESHHOLD_CYCLES) {
			rowClass = "yellow-warning";
		}
		
		if (activityStatus.getHoursLeft() <= RED_TRESHHOLD_HOURS ||
				activityStatus.getDaysLeft() <= RED_TRESHHOLD_DAYS ||
				activityStatus.getCyclesLeft() <= RED_TRESHHOLD_CYCLES) {
			rowClass = "red-warning";
		}
		
	}

	public String getRowClass() {
		return rowClass;
	}

	public void setRowClass(String rowClass) {
		this.rowClass = rowClass;
	}
	
	
	
}
