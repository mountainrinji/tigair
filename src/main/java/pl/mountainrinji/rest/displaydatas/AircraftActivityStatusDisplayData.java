package pl.mountainrinji.rest.displaydatas;

import java.util.Date;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import pl.mountainrinji.Utils;
import pl.mountainrinji.db.entities.Activity;
import pl.mountainrinji.db.entities.AircraftActivityStatus;

public class AircraftActivityStatusDisplayData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AircraftActivityStatus root;
	private String executedDateStr;
	private String executedCyclesStr;
	private String nextExecutionHoursStr;
	private String nextExecutionDateStr;
	private String nextExecutionCyclesStr;
	private String hoursLeftStr = "";
	private String daysLeftStr = "";
	private String cyclesLeftStr = "";
	
	// For styling purposes:
	private Integer hoursLeft = Integer.MAX_VALUE;
	private Integer daysLeft = Integer.MAX_VALUE;
	private Integer cyclesLeft = Integer.MAX_VALUE;
	
	
	
	public AircraftActivityStatusDisplayData(AircraftActivityStatus aircraftActivityStatus) {
		this.root = aircraftActivityStatus;
	}

	public AircraftActivityStatus getRoot() {
		return root;
	}

	public void setRoot(AircraftActivityStatus root) {
		this.root = root;
	}

	public String getExecutedDateStr() {
		return executedDateStr;
	}
	 

	public void setExecutedDateStr(String executedDateStr) {
		this.executedDateStr = executedDateStr;
	}
	
	
	public String getNextExecutionDateStr() {
		return nextExecutionDateStr;
	}

	public void setNextExecutionDateStr(String nextExecutionDateStr) {
		this.nextExecutionDateStr = nextExecutionDateStr;
	}

	

	public String getHoursLeftStr() {
		return hoursLeftStr;
	}

	public void setHoursLeftStr(String hoursLeftStr) {
		this.hoursLeftStr = hoursLeftStr;
	}

	public String getDaysLeftStr() {
		return daysLeftStr;
	}

	public void setDaysLeftStr(String daysLeftStr) {
		this.daysLeftStr = daysLeftStr;
	}

	public String getCyclesLeftStr() {
		return cyclesLeftStr;
	}

	public void setCyclesLeftStr(String cyclesLeftStr) {
		this.cyclesLeftStr = cyclesLeftStr;
	}

	public Integer getHoursLeft() {
		return hoursLeft;
	}

	public void setHoursLeft(Integer hoursLeft) {
		this.hoursLeft = hoursLeft;
	}

	public Integer getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(Integer daysLeft) {
		this.daysLeft = daysLeft;
	}

	public Integer getCyclesLeft() {
		return cyclesLeft;
	}

	public void setCyclesLeft(Integer cyclesLeft) {
		this.cyclesLeft = cyclesLeft;
	}
	
	

	public String getExecutedCyclesStr() {
		return executedCyclesStr;
	}

	public void setExecutedCyclesStr(String executedCyclesStr) {
		this.executedCyclesStr = executedCyclesStr;
	}
	
	

	public String getNextExecutionCyclesStr() {
		return nextExecutionCyclesStr;
	}

	public void setNextExecutionCyclesStr(String nextExecutionCyclesStr) {
		this.nextExecutionCyclesStr = nextExecutionCyclesStr;
	}
	
	

	public String getNextExecutionHoursStr() {
		return nextExecutionHoursStr;
	}

	public void setNextExecutionHoursStr(String nextExecutionHoursStr) {
		this.nextExecutionHoursStr = nextExecutionHoursStr;
	}

	public AircraftActivityStatusDisplayData calculateValues() {
		executedDateStr = Utils.convertDate(root.getExecutedDate());
		executedCyclesStr = Utils.getDifferenceBetweenObjects(root.getExecutedCycles(), 0);
		nextExecutionHoursStr = root.getActivity().getHoursInterval() != null ? 
				Utils.getDifferenceBetweenObjects(root.getNextExecutionHours(), 0) : "---";
		nextExecutionDateStr = root.getActivity().getCalendarInterval() != null ?
				Utils.convertDate(root.getNextExecutionDate()) : "---";
		nextExecutionCyclesStr = root.getActivity().getCyclesInterval() != null ?
				Utils.getDifferenceBetweenObjects(root.getNextExecutionCycles(), 0) : "---";
		hoursLeftStr = root.getActivity().getHoursInterval() != null ? 
				Utils.getDifferenceBetweenObjects(root.getNextExecutionHours(), root.getAircraft().getTotalTime()) : "---";
		daysLeftStr = root.getActivity().getCalendarInterval() != null ?
				Utils.getDifferenceBetweenObjects(root.getNextExecutionDate(), new Date()) : "---";
		cyclesLeftStr = root.getActivity().getCyclesInterval() != null ?
				Utils.getDifferenceBetweenObjects(root.getNextExecutionCycles(), root.getAircraft().getTotalCycles()) : "---";
		
		return this;
	}
	
	

}
