package com.hzresp.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoneyHelpUtil {
	private final static Logger log = LoggerFactory.getLogger(MoneyHelpUtil.class);

	public static Long Str2Long(String str) {
		try {
			Double d = Double.parseDouble(str);
			return Math.round(d * 100);
		} catch (Exception e) {
			log.info("call  MoneyHelpUtil Str2Long  error 转换错误，输入为" + str);
		}
		return null;
	}

	public static String Long2Str(Long l) {
		try {
			double d = l / 100d;
			return String.valueOf(d);
		} catch (Exception e) {
			log.info("call  MoneyHelpUtil Long2Str  error 转换错误，输入为" + l);
		}
		return null;
	}
}
