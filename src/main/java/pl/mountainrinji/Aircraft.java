package pl.mountainrinji;

public enum Aircraft {
	
	SPFYZ ("SP-FYZ", 3),
	PHUSA ("PH-USA", 2),
	SPDTQ ("SP-DTQ", 1);	
	
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
