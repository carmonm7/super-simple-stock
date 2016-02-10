package com.sss.app.arch.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Functionality useful to work with dates.
 */
public class DatesUtils {

	public DatesUtils() {
		// Empty constructor
	}

	public Date getNowMovedMinutes(int minutes) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, minutes);
		return now.getTime();
	}
}
