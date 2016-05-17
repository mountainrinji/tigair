package pl.mountainrinji;

public enum Aircraft {
	
	SPFYZ ("SP-FYZ", 1),
	PHUSA ("PH-USA", 2),
	SPDTQ ("SP-DTQ", 3);	
	
	private String registrationMark;
	private Integer aicraftDbId;
	
	Aircraft(String r, Integer i) {
		registrationMark = r;
		aicraftDbId = i;
	}
	
	public static Integer getDbIdForRegistration(String regmark) {
		regmark = regmark.replace("-", "");
		return Aircraft.valueOf(regmark).aicraftDbId;
	}

}
