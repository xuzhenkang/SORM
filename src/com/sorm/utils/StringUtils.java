package com.sorm.utils;

public class StringUtils {
	public static String firstChar2UpperCase(String str) {
		return str.toUpperCase().charAt(0) + str.substring(1);
	}
}
