package com.priest.ytb.utils;

import org.apache.commons.lang3.StringUtils;

public class TimeUtils {
	
	public static String getTimeString(Double time) {
		String result = "";
		Integer intTime = time.intValue();
		Integer hour = intTime / 3600;
		if (hour != null && hour != 0) {
			if (StringUtils.length(String.valueOf(hour)) == 1 ) {
				result += "0" + hour + ":";
			} else {
				result += hour + ":";
			}
			intTime = intTime % 3600;
		} else {
			result += "00:";
		}
		
		Integer minute = intTime / 60;
		if (minute != null && minute != 0) {
			if (StringUtils.length(String.valueOf(minute)) == 1 ) {
				result += "0" + minute + ":";
			} else {
				result += minute + ":";
			}
			intTime = intTime % 60;
		} else {
			result += "00:";
		}
		
		if (intTime > 0) {
			if (StringUtils.length(String.valueOf(intTime)) == 1 ) {
				result += "0" + intTime;
			} else {
				result += intTime;
			}
		} else {
			result += "00";
		}
		
		return result;
	}
}
