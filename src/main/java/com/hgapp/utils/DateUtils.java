package com.hgapp.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class DateUtils {
	public static String convertDateToString(LocalDate date) {

		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
		return newFormat.format(date);

	}

	public static int getMontDifference(LocalDate startDate, LocalDate endDate) {
		Period period = Period.between(startDate, endDate);
		return period.getMonths();

	}
	public static int getDays(LocalDate startDate, LocalDate endDate) {
		Period period = Period.between(startDate, endDate);
		return period.getDays();

	}

}
