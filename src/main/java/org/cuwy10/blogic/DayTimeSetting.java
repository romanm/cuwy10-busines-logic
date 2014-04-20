package org.cuwy10.blogic;

import org.joda.time.MutableDateTime;

public class DayTimeSetting {
	private String startHHMM="08:00";
	private Integer startHourOfDay;
	private Integer startMinuteOfHour;
	private MutableDateTime startDateTime;
	private MutableDateTime[] malProDayDateTime;

	public DayTimeSetting(){
		setStartHHMM(startHHMM);
	}

	public MutableDateTime getStartDateTime() {
		return startDateTime;
	}
	public int getStartMinuteOfHour() { return startMinuteOfHour; }
	public int getStartHourOfDay() { return startHourOfDay; }
	public String getStartHHMM() { return startHHMM; }

	private void setStartHHMM(int startHourOfDay, int startMmOfhh) {
		this.startHourOfDay = startHourOfDay;
		this.startMinuteOfHour = startMmOfhh;
	}
	public void setStartHHMM(String startHHMM) {
		this.startHHMM = startHHMM;
		String[] split = startHHMM.split(":");
		String hhOfDayStr = split[0];
		String mmOfhhStr = split[1];
		setStartHHMM(Integer.valueOf(hhOfDayStr), Integer.valueOf(mmOfhhStr));
		startDateTime = new MutableDateTime();
		startDateTime.setHourOfDay(getStartHourOfDay());
		startDateTime.setMinuteOfHour(getStartMinuteOfHour());
	}

	public MutableDateTime[] getMalProDay(int malProDay) {
		malProDayDateTime=new MutableDateTime[malProDay];
		int malProDayHourPeriod = 24/malProDay;
		for (int i = 0; i < malProDay; i++) {
			MutableDateTime malDateTime = (MutableDateTime) startDateTime.clone();
			malDateTime.addHours(i*malProDayHourPeriod);
			malProDayDateTime[i]=malDateTime;
		}

		return malProDayDateTime;
	}
}
