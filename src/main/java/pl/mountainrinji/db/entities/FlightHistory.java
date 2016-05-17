package pl.mountainrinji.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the flight_history database table.
 * 
 */
@Entity
@Table(name="flight_history")
@NamedQuery(name="FlightHistory.findAll", query="SELECT f FROM FlightHistory f")
public class FlightHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="aircraft_id")
	private int aircraftId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="flight_time")
	private String flightTime;

	public FlightHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAircraftId() {
		return this.aircraftId;
	}

	public void setAircraftId(int aircraftId) {
		this.aircraftId = aircraftId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFlightTime() {
		return this.flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

}