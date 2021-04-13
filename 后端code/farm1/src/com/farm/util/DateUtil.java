package com.farm.util;

public class DateUtil {

	public static java.sql.Timestamp u2s(java.util.Date d) {
		if (null == d)
			return null;
		return new java.sql.Timestamp(d.getTime());
	}


	public static java.util.Date s2u(java.sql.Timestamp t) {
		if (null == t)
			return null;
		return new java.util.Date(t.getTime());
	}
}

