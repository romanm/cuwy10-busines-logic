package org.cuwy10.blogic;

import static org.junit.Assert.assertEquals;

import org.joda.time.Duration;
import org.joda.time.MutableDateTime;
import org.junit.Test;

public class DayTimeSettingTest {
	String startHHMM = "09:25";
	int hh = new Integer(9);
	int mm = new Integer(25);
	int malProDay = 4;
	
	@Test
	public void setMalProDayTest(){
		DayTimeSetting dayTimeSetting = setStartHHMM();
		int malProDayHourPeriod = 24/malProDay;
		assertEquals(6, malProDayHourPeriod);
		MutableDateTime[] malProDayDateTime = dayTimeSetting.getMalProDay(malProDay);
		assertEquals(malProDay, malProDayDateTime.length);
		int i = 0;
		for (MutableDateTime mutableDateTime : malProDayDateTime) {
			Duration duration = new Duration(dayTimeSetting.getStartDateTime(),mutableDateTime);
			int hours = duration.toStandardHours().getHours();
			assertEquals(hours, i*malProDayHourPeriod);
			i++;
		}		
	}
	@Test
	public void setStartHHMMTest(){
		DayTimeSetting dayTimeSetting = setStartHHMM();
		
		assertEquals(startHHMM, dayTimeSetting.getStartHHMM());
		
		assertEquals(hh, dayTimeSetting.getStartHourOfDay());
		assertEquals(mm, dayTimeSetting.getStartMinuteOfHour());

		assertEquals(hh, dayTimeSetting.getStartDateTime().getHourOfDay());
		assertEquals(mm, dayTimeSetting.getStartDateTime().getMinuteOfHour());
	}
	private DayTimeSetting setStartHHMM() {
		DayTimeSetting dayTimeSetting = new DayTimeSetting();
		dayTimeSetting.setStartHHMM(startHHMM);
		return dayTimeSetting;
	}
	@Test
	public void setStartHHMMDefaultTest(){
		DayTimeSetting dayTimeSetting = new DayTimeSetting();
		assertEquals("08:00", dayTimeSetting.getStartHHMM());
		
		assertEquals(8, dayTimeSetting.getStartHourOfDay());
		assertEquals(0, dayTimeSetting.getStartMinuteOfHour());
		
		assertEquals(8, dayTimeSetting.getStartDateTime().getHourOfDay());
		assertEquals(0, dayTimeSetting.getStartDateTime().getMinuteOfHour());
		
	}
}
