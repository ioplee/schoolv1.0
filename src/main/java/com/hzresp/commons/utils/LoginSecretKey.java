package com.hzresp.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.shangban.utils.MD5;

/**
 * @ClassName: LoginSecretKey
 * @Description: 密文加密
 * @author lijiabei
 * @date 2014年12月12日 下午4:43:19
 */
public class LoginSecretKey {

	/** 盐 */
	private static String SECRET_SALT = "SBKJ_1234";

	public static String generateKey(Long userId) {
		if (null != userId) {
			SimpleDateFormat sdf = new SimpleDateFormat("Myy");
			String dayKey = sdf.format(new Date());
			long userKey = (userId * 2 + 987) / 19 + 22;
			return MD5.compute(SECRET_SALT + userKey + dayKey);
		} else {
			return null;
		}
	}

}
