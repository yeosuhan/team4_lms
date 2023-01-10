package com.team4.myapp.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Today {
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String today = sdf.format(new Date());
		
		return today;
	}

}
