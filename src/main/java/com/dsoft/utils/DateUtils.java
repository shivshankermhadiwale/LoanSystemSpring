package com.dsoft.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DateUtils {
	public static String convertDateToString(LocalDate date) {
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
		return newFormat.format(date);
		
	}

}
