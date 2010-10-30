package com.xylon.common;

import java.util.regex.Pattern;

public class StringUtils {
	public static boolean isNotEmpty(String str){
		if(null != str && str.length() > 0){
			return true;
		}
		return false;
	}
	
	public static boolean isNumber(String str){
		String reg = "[0-9]+";
		if(isNotEmpty(str)){
			if(Pattern.compile(reg).matcher(str).matches()){
				return true;
			}
		}
		return false;
	}
}
