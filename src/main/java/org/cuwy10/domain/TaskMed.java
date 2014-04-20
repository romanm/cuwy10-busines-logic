package org.cuwy10.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskMed {
	private  List<DayTime> dayTimes;

	public List<DayTime> getDayTimes() {
		if(null==dayTimes)
			dayTimes=new ArrayList<DayTime>();
		return dayTimes;
	}
}
