package pl.mountainrinji.db.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the aircraft database table.
 * 
 */
@Entity
@Table(name="aircraft")
@NamedQuery(name="Aircraft.findAll", query="SELECT a FROM Aircraft a")
public class Aircraft implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String make;

	@Column(name="manufactured_date")
	private String manufacturedDate;

	private String model;

	private String name;

	@Column(name="serial_no")
	private String serialNo;

	@Column(name="type_certificate")
	private String typeCertificate;
	
	@Column(name="total_time")
	private String totalTime;
	
	@Column(name="total_cycles")
	private Integer totalCycles;
	
	@Column(name="engine_model")
	private String engineModel;
	
	@Column(name="engine_serial_no")
	private String engineSerialNo;
	
	@Column(name="engine_manufactured_year")
	private String engineManufacturedYear;
	
	@Column(name="engine_type_certificate")
	private String engineTypeCertificate;
	
	@Column(name="engine_total_time")
	private String engineTotalTime;
	
	@Column(name="engine_time_since_overhaul")
	private String engineTimeSinceOverhaul;
	
	@Column(name="propeller_model")
	private String propellerModel;
	
	@Column(name="propeller_serial_no")
	private String propellerSerialNo;
	
	@Column(name="propeller_manufactured_year")
	private String propellerManufacturedYear;
	
	@Column(name="propeller_type_certificate")
	private String propellerTypeCertificate;
	
	@Column(name="propeller_total_time")
	private String propellerTotalTime;
	
	@Column(name="propeller_time_since_overhaul")
	private String propellerTimeSinceOverhaul;
	
	@Column(name="show_deprecated") 
	private Boolean showDeprecated;
	
	@Column(name="show_description") 
	private Boolean showDescription;
	
	@Column(name="show_maintenance_instruction") 
	private Boolean showMaintenanceInstruction;
	
	@Column(name="show_maintenance_reference") 
	private Boolean showMaintenanceReference;
	
	@Column(name="show_source") 
	private Boolean showSource;
	
	@Column(name="summary_date")
	private String summaryDate;
	
	@Column(name="summary_recipients")
	private String summaryRecipients;
	
	
	

	//bi-directional many-to-one association to AircraftActivityStatus
	@OneToMany(mappedBy="aircraft")
	@JsonIgnore
	private List<AircraftActivityStatus> aircraftActivityStatuses;

	public Aircraft() {
	}

	
	
	public Boolean getShowDescription() {
		return showDescription;
	}



	public void setShowDescription(Boolean showDescription) {
		this.showDescription = showDescription;
	}



	public Boolean getShowMaintenanceInstruction() {
		return showMaintenanceInstruction;
	}



	public void setShowMaintenanceInstruction(Boolean showMaintenanceInstruction) {
		this.showMaintenanceInstruction = showMaintenanceInstruction;
	}



	public Boolean getShowMaintenanceReference() {
		return showMaintenanceReference;
	}



	public void setShowMaintenanceReference(Boolean showMaintenanceReference) {
		this.showMaintenanceReference = showMaintenanceReference;
	}



	public Boolean getShowSource() {
		return showSource;
	}



	public void setShowSource(Boolean showSource) {
		this.showSource = showSource;
	}



	public Boolean getShowDeprecated() {
		return showDeprecated;
	}



	public void setShowDeprecated(Boolean showDeprecated) {
		this.showDeprecated = showDeprecated;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getManufacturedDate() {
		return this.manufacturedDate;
	}

	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getTypeCertificate() {
		return this.typeCertificate;
	}

	public void setTypeCertificate(String typeCertificate) {
		this.typeCertificate = typeCertificate;
	}

	public List<AircraftActivityStatus> getAircraftActivityStatuses() {
		return this.aircraftActivityStatuses;
	}

	public void setAircraftActivityStatuses(List<AircraftActivityStatus> aircraftActivityStatuses) {
		this.aircraftActivityStatuses = aircraftActivityStatuses;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	
	

	public Integer getTotalCycles() {
		return totalCycles;
	}

	public void setTotalCycles(Integer totalCycles) {
		this.totalCycles = totalCycles;
	}

	
	
	public String getEngineModel() {
		return engineModel;
	}

	public void setEngineModel(String engineModel) {
		this.engineModel = engineModel;
	}

	public String getEngineSerialNo() {
		return engineSerialNo;
	}

	public void setEngineSerialNo(String engineSerialNo) {
		this.engineSerialNo = engineSerialNo;
	}

	public String getEngineManufacturedYear() {
		return engineManufacturedYear;
	}

	public void setEngineManufacturedYear(String engineManufacturedYear) {
		this.engineManufacturedYear = engineManufacturedYear;
	}

	public String getEngineTypeCertificate() {
		return engineTypeCertificate;
	}

	public void setEngineTypeCertificate(String engineTypeCertificate) {
		this.engineTypeCertificate = engineTypeCertificate;
	}

	public String getEngineTotalTime() {
		return engineTotalTime;
	}

	public void setEngineTotalTime(String engineTotalTime) {
		this.engineTotalTime = engineTotalTime;
	}

	public String getEngineTimeSinceOverhaul() {
		return engineTimeSinceOverhaul;
	}

	public void setEngineTimeSinceOverhaul(String engineTimeSinceOverhaul) {
		this.engineTimeSinceOverhaul = engineTimeSinceOverhaul;
	}

	public String getPropellerModel() {
		return propellerModel;
	}

	public void setPropellerModel(String propellerModel) {
		this.propellerModel = propellerModel;
	}

	public String getPropellerSerialNo() {
		return propellerSerialNo;
	}

	public void setPropellerSerialNo(String propellerSerialNo) {
		this.propellerSerialNo = propellerSerialNo;
	}

	public String getPropellerManufacturedYear() {
		return propellerManufacturedYear;
	}

	public void setPropellerManufacturedYear(String propellerManufacturedYear) {
		this.propellerManufacturedYear = propellerManufacturedYear;
	}

	public String getPropellerTypeCertificate() {
		return propellerTypeCertificate;
	}

	public void setPropellerTypeCertificate(String propellerTypeCertificate) {
		this.propellerTypeCertificate = propellerTypeCertificate;
	}

	public String getPropellerTotalTime() {
		return propellerTotalTime;
	}

	public void setPropellerTotalTime(String propellerTotalTime) {
		this.propellerTotalTime = propellerTotalTime;
	}

	public String getPropellerTimeSinceOverhaul() {
		return propellerTimeSinceOverhaul;
	}

	public void setPropellerTimeSinceOverhaul(String propellerTimeSinceOverhaul) {
		this.propellerTimeSinceOverhaul = propellerTimeSinceOverhaul;
	}

	
	
	public String getSummaryDate() {
		return summaryDate;
	}



	public void setSummaryDate(String summaryDate) {
		this.summaryDate = summaryDate;
	}



	public String getSummaryRecipients() {
		return summaryRecipients;
	}



	public void setSummaryRecipients(String summaryRecipients) {
		this.summaryRecipients = summaryRecipients;
	}



	public AircraftActivityStatus addAircraftActivityStatus(AircraftActivityStatus aircraftActivityStatus) {
		getAircraftActivityStatuses().add(aircraftActivityStatus);
		aircraftActivityStatus.setAircraft(this);

		return aircraftActivityStatus;
	}

	public AircraftActivityStatus removeAircraftActivityStatus(AircraftActivityStatus aircraftActivityStatus) {
		getAircraftActivityStatuses().remove(aircraftActivityStatus);
		aircraftActivityStatus.setAircraft(null);

		return aircraftActivityStatus;
	}

}