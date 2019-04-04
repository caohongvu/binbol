package com.binbol.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

	public static String hash(String source) {
		String hash = DigestUtils.md5DigestAsHex(source.getBytes());
		return hash;
	}
}
