package pl.mountainrinji.rest.displaydatas;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import pl.mountainrinji.Utils;
import pl.mountainrinji.db.entities.Activity;

public class ActivityDisplayData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Activity root;
	
	private String actionTypeStr = "";
	
	private String hoursIntervalStr = "";
	private String calendarIntervalStr = "";
	private String cyclesIntervalStr = "";
	
	private String usualIntervalColumnCss;
	private String specialIntervalColumnCss;
	
	public String getUsualIntervalColumnCss() {
		return usualIntervalColumnCss;
	}

	public void setUsualIntervalColumnCss(String usualIntervalColumnCss) {
		this.usualIntervalColumnCss = usualIntervalColumnCss;
	}

	public String getSpecialIntervalColumnCss() {
		return specialIntervalColumnCss;
	}

	public void setSpecialIntervalColumnCss(String specialIntervalColumnCss) {
		this.specialIntervalColumnCss = specialIntervalColumnCss;
	}

	public String getHoursIntervalStr() {
		return hoursIntervalStr;
	}

	public void setHoursIntervalStr(String hoursInterval) {
		this.hoursIntervalStr = hoursInterval;
	}

	public String getCalendarIntervalStr() {
		return calendarIntervalStr;
	}

	public void setCalendarIntervalStr(String calendarInterval) {
		this.calendarIntervalStr = calendarInterval;
	}

	public String getCyclesIntervalStr() {
		return cyclesIntervalStr;
	}

	public void setCyclesIntervalStr(String cyclesInterval) {
		this.cyclesIntervalStr = cyclesInterval;
	}

	public ActivityDisplayData(Activity activity) {
		this.root = activity;
	}

	public Activity getRoot() {
		return root;
	}

	public void setRoot(Activity root) {
		this.root = root;
	}
	

	public String getActionTypeStr() {
		return actionTypeStr;
	}

	public void setActionTypeStr(String actionTypeStr) {
		this.actionTypeStr = actionTypeStr;
	}
	
	public ActivityDisplayData calculateValues() {
		
		
		actionTypeStr = Utils.convertActionType(root.getActionType());
		hoursIntervalStr = Utils.getDifferenceBetweenObjects(root.getHoursInterval(), 0);
		calendarIntervalStr = Utils.getDifferenceBetweenObjects(root.getCalendarInterval(), 0);
		cyclesIntervalStr = Utils.getDifferenceBetweenObjects(root.getCyclesInterval(), 0);
		
		usualIntervalColumnCss = Utils.getUsualIntervalColumnCss(root.getSpecialInterval());
		specialIntervalColumnCss = Utils.getSpecialIntervalColumnCss(root.getSpecialInterval());
		return this;
	}
	

}
