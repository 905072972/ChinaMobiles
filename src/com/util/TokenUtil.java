package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenUtil {
	private TokenUtil() {
	}

	private static final TokenUtil instance = new TokenUtil();

	public static TokenUtil getInstance() {
		return instance;
	};

	public String makeToken() throws NoSuchAlgorithmException {
		String token = (System.currentTimeMillis() + new Random()
				.nextInt(999999999))+ "";
		MessageDigest md;
		md = MessageDigest.getInstance("md5");
		byte md5[] = md.digest(token.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(md5);

	}
}
