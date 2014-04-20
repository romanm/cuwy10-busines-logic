package org.cuwy10.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTime {
	private String dayEx,timeEx;
	private int malProDay;
	private static String pattern = "(\\d+) (malProDay)";
	private static Pattern r = Pattern.compile(pattern);

	public void setTimeEx(String timeEx) {
		this.timeEx=timeEx;
	    Matcher m = r.matcher(timeEx);
	    if (m.find( )) {
	    	Integer valueOf = Integer.valueOf(m.group(1));
	    	malProDay=valueOf;
	    }
	}

	public int getMalProDay() {
		return malProDay;
	}

	public String getTimeEx() {
		return timeEx;
	}
}
