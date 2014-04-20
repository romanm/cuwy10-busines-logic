package org.cuwy10.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayTimeTest {

	@Test
	public void simpleMalProDay(){
		String timeEx = "2 malProDay";
		DayTime dayTime = new DayTime();
		dayTime.setTimeEx(timeEx);
		assertEquals(2, dayTime.getMalProDay());
		assertEquals(timeEx, dayTime.getTimeEx());
	}
}
