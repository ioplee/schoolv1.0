package com.hzresp.commons.utils;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PercentUtil {
	private final static Logger log = LoggerFactory.getLogger(PercentUtil.class);

	private final static DecimalFormat f = new DecimalFormat("0.00");

	public static Integer Str2Percent(String str) {
		try {
			Double d = Double.parseDouble(str);
			return (int) Math.round(d * 100);
		} catch (Exception e) {
			log.info("call  PercentUtil Str2Percent  error 转换错误，输入为" + str);
		}
		return null;
	}

	public static String Percent2Str(Integer i) {
		try {
			Double d = (double) (i / 100d);
			return f.format(d);
		} catch (Exception e) {
			log.info("call  PercentUtil Percent2Str  error 转换错误，输入为" + i);
		}
		return null;
	}
}
