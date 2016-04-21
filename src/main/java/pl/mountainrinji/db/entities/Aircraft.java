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
	private Integer totalTime;
	
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
	private Integer engineTotalTime;
	
	@Column(name="engine_time_since_overhaul")
	private Integer engineTimeSinceOverhaul;
	
	@Column(name="propeller_model")
	private String propellerModel;
	
	@Column(name="propeller_serial_no")
	private String propellerSerialNo;
	
	@Column(name="propeller_manufactured_year")
	private String propellerManufacturedYear;
	
	@Column(name="propeller_type_certificate")
	private String propellerTypeCertificate;
	
	@Column(name="propeller_total_time")
	private Integer propellerTotalTime;
	
	@Column(name="propeller_time_since_overhaul")
	private Integer propellerTimeSinceOverhaul;

	//bi-directional many-to-one association to AircraftActivityStatus
	@OneToMany(mappedBy="aircraft")
	@JsonIgnore
	private List<AircraftActivityStatus> aircraftActivityStatuses;

	public Aircraft() {
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

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
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

	public Integer getEngineTotalTime() {
		return engineTotalTime;
	}

	public void setEngineTotalTime(Integer engineTotalTime) {
		this.engineTotalTime = engineTotalTime;
	}

	public Integer getEngineTimeSinceOverhaul() {
		return engineTimeSinceOverhaul;
	}

	public void setEngineTimeSinceOverhaul(Integer engineTimeSinceOverhaul) {
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

	public Integer getPropellerTotalTime() {
		return propellerTotalTime;
	}

	public void setPropellerTotalTime(Integer propellerTotalTime) {
		this.propellerTotalTime = propellerTotalTime;
	}

	public Integer getPropellerTimeSinceOverhaul() {
		return propellerTimeSinceOverhaul;
	}

	public void setPropellerTimeSinceOverhaul(Integer propellerTimeSinceOverhaul) {
		this.propellerTimeSinceOverhaul = propellerTimeSinceOverhaul;
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