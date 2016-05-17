package pl.mountainrinji.db.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@Table(name="activity")
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="action_type")
	private String actionType;

	@Column(name="activity_name")
	private String activityName;

	@Column(name="activity_type")
	private String activityType;
	
	@Column(name="activity_part")
	private String activityPart;

	@Column(name="calendar_interval")
	private Integer calendarInterval;

	@Column(name="cycles_interval")
	private Integer cyclesInterval;
	
	@Column(name="special_interval")
	private String specialInterval;

	@Column(name="extention_calendar_interval")
	private Double extentionCalendarInterval;

	@Column(name="extention_cycles_interval")
	private Integer extentionCyclesInterval;

	@Column(name="extention_hours_interval")
	private Integer extentionHoursInterval;

	@Column(name="hours_interval")
	private Integer hoursInterval;

	@Column(name="maintenance_instruction")
	private String maintenanceInstruction;

	@Column(name="maintenance_instruction_ref")
	private String maintenanceInstructionRef;

	@Column(name="part_no")
	private String partNo;
	
	@Column(name="deprecated")
	private Boolean deprecated;

	private String source;
	
	@Column(name="description") 
	private String description;


	//bi-directional many-to-one association to AircraftActivityStatus
	@OneToMany(mappedBy="activity")
	@JsonIgnore
	private List<AircraftActivityStatus> aircraftActivityStatuses;

	
	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Activity() {
	}

	
	
	public Boolean getDeprecated() {
		return deprecated;
	}



	public void setDeprecated(Boolean deprecated) {
		this.deprecated = deprecated;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityType() {
		return this.activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Integer getCalendarInterval() {
		return this.calendarInterval;
	}

	public void setCalendarInterval(Integer calendarInterval) {
		this.calendarInterval = calendarInterval;
	}

	public Integer getCyclesInterval() {
		return this.cyclesInterval;
	}

	public void setCyclesInterval(Integer cyclesInterval) {
		this.cyclesInterval = cyclesInterval;
	}

	public Double getExtentionCalendarInterval() {
		return this.extentionCalendarInterval;
	}

	public void setExtentionCalendarInterval(Double extentionCalendarInterval) {
		this.extentionCalendarInterval = extentionCalendarInterval;
	}

	public Integer getExtentionCyclesInterval() {
		return this.extentionCyclesInterval;
	}

	public void setExtentionCyclesInterval(Integer extentionCyclesInterval) {
		this.extentionCyclesInterval = extentionCyclesInterval;
	}

	public Integer getExtentionHoursInterval() {
		return this.extentionHoursInterval;
	}

	public void setExtentionHoursInterval(Integer extentionHoursInterval) {
		this.extentionHoursInterval = extentionHoursInterval;
	}

	public Integer getHoursInterval() {
		return this.hoursInterval;
	}

	public void setHoursInterval(Integer hoursInterval) {
		this.hoursInterval = hoursInterval;
	}

	public String getSpecialInterval() {
		return specialInterval;
	}

	public void setSpecialInterval(String specialInterval) {
		this.specialInterval = specialInterval;
	}

	public String getMaintenanceInstruction() {
		return this.maintenanceInstruction;
	}

	public void setMaintenanceInstruction(String maintenanceInstruction) {
		this.maintenanceInstruction = maintenanceInstruction;
	}

	public String getMaintenanceInstructionRef() {
		return this.maintenanceInstructionRef;
	}

	public void setMaintenanceInstructionRef(String maintenanceInstructionRef) {
		this.maintenanceInstructionRef = maintenanceInstructionRef;
	}

	public String getPartNo() {
		return this.partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public String getActivityPart() {
		return activityPart;
	}

	public void setActivityPart(String activityPart) {
		this.activityPart = activityPart;
	}

	public List<AircraftActivityStatus> getAircraftActivityStatuses() {
		return this.aircraftActivityStatuses;
	}

	public void setAircraftActivityStatuses(List<AircraftActivityStatus> aircraftActivityStatuses) {
		this.aircraftActivityStatuses = aircraftActivityStatuses;
	}

	public AircraftActivityStatus addAircraftActivityStatus(AircraftActivityStatus aircraftActivityStatus) {
		getAircraftActivityStatuses().add(aircraftActivityStatus);
		aircraftActivityStatus.setActivity(this);

		return aircraftActivityStatus;
	}

	public AircraftActivityStatus removeAircraftActivityStatus(AircraftActivityStatus aircraftActivityStatus) {
		getAircraftActivityStatuses().remove(aircraftActivityStatus);
		aircraftActivityStatus.setActivity(null);

		return aircraftActivityStatus;
	}
	
	

}