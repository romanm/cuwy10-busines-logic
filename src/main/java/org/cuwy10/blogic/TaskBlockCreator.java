package org.cuwy10.blogic;

import java.util.Set;
import java.util.TreeSet;

import org.cuwy10.domain.DayTime;
import org.cuwy10.domain.Drug;
import org.cuwy10.domain.TaskBlock;
import org.cuwy10.domain.TaskDateTime;
import org.joda.time.MutableDateTime;

public class TaskBlockCreator {
	DayTimeSetting dayTimeSetting = new DayTimeSetting();
	public DayTimeSetting getDayTimeSetting() {
		return dayTimeSetting;
	}
	TaskBlock taskBlock;
	public TaskBlock getTaskBlock() {
		return taskBlock;
	}
	public void setTaskBlock(TaskBlock taskBlock) {
		this.taskBlock = taskBlock;
	}
	/**
	 * Calculated times of drug and labor.
	 */
	Set<TaskDateTime> taskDateTimes ;
	public Set<TaskDateTime> getTaskDateTimes() {
		if(null==taskDateTimes)
			taskDateTimes=new TreeSet<TaskDateTime>();
		return taskDateTimes;
	}
	public void calcTimes() {
		Set<TaskDateTime> taskDateTimes2 = getTaskDateTimes();
		for (Drug drug : taskBlock.getDrugs()) 
			for (DayTime drugDayTime : drug.getDayTimes()) {
				int malProDay = drugDayTime.getMalProDay();
				MutableDateTime[] malProDayDateTime = dayTimeSetting.getMalProDay(malProDay);
				for (MutableDateTime mutableDateTime : malProDayDateTime) {
					TaskDateTime taskDateTime = new TaskDateTime(mutableDateTime,drug);
					taskDateTimes2.add(taskDateTime);
				}
			}
	}
}
