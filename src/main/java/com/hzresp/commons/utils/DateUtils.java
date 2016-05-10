package com.hzresp.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_FORMAT_NOTIME = "yyyy-MM-dd";

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getFormatTime(Date date, String pattern) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			return simpleDateFormat.format(date).toString();
		} catch (Exception e) {
			return "";
		}
	}

	public static Date getFormatDate(String date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			return simpleDateFormat.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date getFormatDate(String date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 偏移时间（分钟）
	 * 
	 * @param date
	 *            时间
	 * @param offset
	 *            偏移量，负数代表往前，正数代表往后
	 * @return
	 */
	public static Date offSetMin(Date date, int offset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, offset);
		return cal.getTime();
	}

	/**
	 * 
	 * @param date
	 * @param field
	 * @param offset
	 * @return
	 */
	public static Date offSet(Date date, int field, int offset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, offset);
		return cal.getTime();
	}

}
