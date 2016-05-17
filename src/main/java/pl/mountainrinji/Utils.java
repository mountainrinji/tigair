package pl.mountainrinji;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.springframework.util.StringUtils;

import pl.mountainrinji.rest.displaydatas.AircraftActivityStatusDisplayData;

public class Utils {

	public static String convertDate(Date date) {
		if (date == null) {
			return "---";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}
	
	public static Date convertString(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.parse(strDate);
	}
	
	public static String convertActionType(String actionType) {
		if (actionType.equals("O")) {
			return "actionType_overhaul";
		}
		
		if (actionType.equals("R")) {
			return "actionType_replace";
		}
		
		if (actionType.equals("I")) {
			return "actionType_inspect";
		}
		
		if (actionType.equals("L")) {
			return "actionType_lubricate";
		}
		
		if (actionType.equals("C")) {
			return "actionType_clean";
		}
		
		if (actionType.equals("S")) {
			return "actionType_oncondition";
		}
		
		if (actionType.equals("N")) {
			return "actionType_renew";
		}
		
		if (actionType.equals("T")) {
			return "actionType_test";
		}
		
		if (actionType.equals("E")) {
			return "actionType_escalate";
		}
		
		if (actionType.equals("X")) {
			return "actionType_notRecognized";
		}
		
		if (StringUtils.isEmpty(actionType)) {
			return "";
		}
		
		return "Nie znaleziono odpowiednika dla activity.actionType";
	}
	
	public static String getDifferenceBetweenObjects(Integer value1, Integer value2) {
		String result = "";
		if (value1 != null && value2 != null) {
			Integer difference = value1 - value2;
			result = result + difference;
		} else {
			result = "---";
		}
		
		return result;
	}
	
	public static String getDifferenceBetweenObjects(Date date1, Date date2) {
		String daysDifferenceStr = "";
		if (date1 != null && date2 != null) {
			LocalDate locDate1 = new LocalDate(date1);
			LocalDate locDate2 = new LocalDate(date2);
			Integer difference = Days.daysBetween(locDate2, locDate1).getDays();
			daysDifferenceStr = daysDifferenceStr + difference;
		} else {
			daysDifferenceStr = "---";
		}
		
		return daysDifferenceStr;
	}

	public static String getUsualIntervalColumnCss(String specialInterval) {
		if (StringUtils.isEmpty(specialInterval)) {
			return "visibleSection";
		}
		
		return "notVisibleSection";
	}

	public static String getSpecialIntervalColumnCss(String specialInterval) {
		if (StringUtils.isEmpty(specialInterval)) {
			return "notVisibleSection";
		}
		
		return "visibleSection";
	}
	
	
	private static final long HOURS = 1 * 60 * 60 * 1000;
	private static final long MINUTES = 1 * 60 * 1000;
	private static String getStringFromMillis(long millis) {
		long hours = millis / HOURS;
		long minutes = (millis - hours * HOURS) / MINUTES;
		
		String hoursPart = "";
		String mintesPart = "";
		if (Math.abs(hours) < 10) {
			hoursPart = "0" + Math.abs(hours);
		} else {
			hoursPart = Math.abs(hours) + "";
		}
		
		if (Math.abs(minutes) < 10) {
			mintesPart = "0" + Math.abs(minutes);
		} else {
			mintesPart = Math.abs(minutes) + "";
		}
		
		String sign = "";
		if (hours < 0 || minutes < 0) {
			sign = "-";
		}
		
		return sign + hoursPart + ":" + mintesPart;
	}
	
	
	public static String addTimes(String time1, String time2) {
		String [] time1Parts = time1.split(":");
		String [] time2Parts = time2.split(":");
		DateTime datetime1 = new DateTime(1970,1,1,0,0, DateTimeZone.UTC);
		datetime1 = datetime1.plusHours(Integer.parseInt(time1Parts[0]));
		datetime1 = datetime1.plusMinutes(Integer.parseInt(time1Parts[1]));
		datetime1 = datetime1.plusHours(Integer.parseInt(time2Parts[0]));
		datetime1 = datetime1.plusMinutes(Integer.parseInt(time2Parts[1]));
		
		
		return getStringFromMillis(datetime1.getMillis());
	}
	
	public static String substractTimes(String time1, String time2) {
		String [] time1Parts = time1.split(":");
		String [] time2Parts = time2.split(":");
		DateTime datetime1 = new DateTime(1970,1,1,0,0, DateTimeZone.UTC);
		datetime1 = datetime1.plusHours(Integer.parseInt(time1Parts[0]));
		datetime1 = datetime1.plusMinutes(Integer.parseInt(time1Parts[1]));
		datetime1 = datetime1.minusHours(Integer.parseInt(time2Parts[0]));
		datetime1 = datetime1.minusMinutes(Integer.parseInt(time2Parts[1]));
		
		
		return getStringFromMillis(datetime1.getMillis());
	}
	
	public static long getMillisFromTime(String time1) {
		String [] time1Parts = time1.split(":");
		return Long.parseLong(time1Parts[0]) * 60 * 60 * 1000 + Long.parseLong(time1Parts[1]) * 60 * 1000;
	}
	
	public static String constructActivityId(AircraftActivityStatusDisplayData aasdd) {
		return aasdd.getRoot().getAircraft().getName() + "/" + aasdd.getRoot().getActivity().getActivityPart() + "/" + aasdd.getRoot().getActivity().getId();
	}
}
