package pl.mountainrinji.db.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the aircraft_activity_status database table.
 * 
 */
@Entity
@Table(name="aircraft_activity_status")
@NamedQuery(name="AircraftActivityStatus.findAll", query="SELECT a FROM AircraftActivityStatus a")
public class AircraftActivityStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="additional_notes")
	private String additionalNotes;

	private String crs;

	@Column(name="executed_cycles")
	private Integer executedCycles;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="executed_date")
	private Date executedDate;

	@Column(name="executed_hours")
	private String executedHours;

	@Column(name="extension_calendar")
	private Integer extensionCalendar;

	@Column(name="extension_cycles")
	private Integer extensionCycles;

	@Column(name="extension_hours")
	private Integer extensionHours;

	@Column(name="next_execution_cycles")
	private Integer nextExecutionCycles;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="next_execution_date")
	private Date nextExecutionDate;

	@Column(name="next_execution_hours")
	private String nextExecutionHours;

	@Column(name="serial_no")
	private String serialNo;
	
	@Column(name="aircraft_id")
	private Integer aircraftId;
	
	@Column(name="activity_id")
	private Integer activityId;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="activity_id", insertable=false, updatable=false)
	private Activity activity;

	//bi-directional many-to-one association to Aircraft
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="aircraft_id", insertable=false, updatable=false)
	private Aircraft aircraft;

	public AircraftActivityStatus() {
	}

	
	
	public Integer getAircraftId() {
		return aircraftId;
	}



	public void setAircraftId(Integer aircraftId) {
		this.aircraftId = aircraftId;
	}



	public Integer getActivityId() {
		return activityId;
	}



	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdditionalNotes() {
		return this.additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public String getCrs() {
		return this.crs;
	}

	public void setCrs(String crs) {
		this.crs = crs;
	}

	public Integer getExecutedCycles() {
		return this.executedCycles;
	}

	public void setExecutedCycles(Integer executedCycles) {
		this.executedCycles = executedCycles;
	}

	public Date getExecutedDate() {
		return this.executedDate;
	}

	public void setExecutedDate(Date executedDate) {
		this.executedDate = executedDate;
	}

	public String getExecutedHours() {
		return this.executedHours;
	}

	public void setExecutedHours(String executedHours) {
		this.executedHours = executedHours;
	}

	public Integer getExtensionCalendar() {
		return this.extensionCalendar;
	}

	public void setExtensionCalendar(Integer extensionCalendar) {
		this.extensionCalendar = extensionCalendar;
	}

	public Integer getExtensionCycles() {
		return this.extensionCycles;
	}

	public void setExtensionCycles(Integer extensionCycles) {
		this.extensionCycles = extensionCycles;
	}

	public Integer getExtensionHours() {
		return this.extensionHours;
	}

	public void setExtensionHours(Integer extensionHours) {
		this.extensionHours = extensionHours;
	}

	public Integer getNextExecutionCycles() {
		return this.nextExecutionCycles;
	}

	public void setNextExecutionCycles(Integer nextExecutionCycles) {
		this.nextExecutionCycles = nextExecutionCycles;
	}

	public Date getNextExecutionDate() {
		return this.nextExecutionDate;
	}

	public void setNextExecutionDate(Date nextExecutionDate) {
		this.nextExecutionDate = nextExecutionDate;
	}

	public String getNextExecutionHours() {
		return this.nextExecutionHours;
	}

	public void setNextExecutionHours(String nextExecutionHours) {
		this.nextExecutionHours = nextExecutionHours;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Aircraft getAircraft() {
		return this.aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

}