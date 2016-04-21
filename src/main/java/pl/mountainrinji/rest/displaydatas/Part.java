package pl.mountainrinji.rest.displaydatas;

public class Part {

	private String model;
	private String serialNo;
	private String manufacturedYear;
	private String typeCertificate;
	private Integer totalTime;
	private Integer totalTimeSinceOverhaul;
	
	
	
	public Part(String model, String serialNo, String manufacturedYear, String typeCertificate, Integer totalTime,
			Integer totalTimeSinceOverhaul) {
		super();
		this.model = model;
		this.serialNo = serialNo;
		this.manufacturedYear = manufacturedYear;
		this.typeCertificate = typeCertificate;
		this.totalTime = totalTime;
		this.totalTimeSinceOverhaul = totalTimeSinceOverhaul;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getManufacturedYear() {
		return manufacturedYear;
	}
	public void setManufacturedYear(String manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}
	public String getTypeCertificate() {
		return typeCertificate;
	}
	public void setTypeCertificate(String typeCertificate) {
		this.typeCertificate = typeCertificate;
	}
	public Integer getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}
	public Integer getTotalTimeSinceOverhaul() {
		return totalTimeSinceOverhaul;
	}
	public void setTotalTimeSinceOverhaul(Integer totalTimeSinceOverhaul) {
		this.totalTimeSinceOverhaul = totalTimeSinceOverhaul;
	}
	
	
}
