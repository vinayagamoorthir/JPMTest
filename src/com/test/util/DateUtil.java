package com.test.jpmorgan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getDate(String time) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("H:m");
		Date date = null;
		try {
			date = formatter.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	
	public static int compare(String date1, String date2) throws Exception{
		Date r1 = DateUtil.getDate(date1);
		Date r2 = DateUtil.getDate(date2);
		 return r1.compareTo(r2);

	}
	public static boolean isDateMatched(String transactDate, String exchangeDate)
			throws Exception {

		Date trans = DateUtil.getDate(transactDate);
		Date exch = DateUtil.getDate(exchangeDate);

		if (exch.compareTo(trans) > 0) {
			return true;
		}
		return false;

	}
}
