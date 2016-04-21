package pl.mountainrinji;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.util.StringUtils;

public class Utils {

	public static String convertDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
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
}
