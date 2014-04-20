package org.cuwy10.blogic;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.cuwy10.domain.DayTime;
import org.cuwy10.domain.Drug;
import org.cuwy10.domain.TaskBlock;
import org.cuwy10.domain.TaskDateTime;
import org.joda.time.Duration;
import org.junit.Test;

public class TaskBlockCreatorTest {

	@Test
	public void simpleMalProDay(){
		TaskBlockCreator taskBlockCreator = new TaskBlockCreator();
		taskBlockCreator.setTaskBlock(new TaskBlock());
		TaskBlock taskBlock = taskBlockCreator.getTaskBlock();
		Drug drugA = new Drug("A");
		taskBlock.getDrugs().add(drugA);
		
		String timeEx = "3 malProDay";
		DayTime dayTime = new DayTime();
		dayTime.setTimeEx(timeEx);
		drugA.getDayTimes().add(dayTime);
		
		taskBlockCreator.calcTimes();
		Set<TaskDateTime> taskDateTimes = taskBlockCreator.getTaskDateTimes();
		int size = taskDateTimes.size();
		assertEquals(3, size);
		int malProDay = dayTime.getMalProDay();
		int malProDayHourPeriod = 24/malProDay;
		TaskDateTime firstTaskDateTime=null;
		int i = 0;
		for (TaskDateTime taskDateTime : taskDateTimes) {
			if(null==firstTaskDateTime)
				firstTaskDateTime=taskDateTime;
			System.out.println(taskDateTime);
			Duration duration = new Duration(firstTaskDateTime, taskDateTime);
			int hours = duration.toStandardHours().getHours();
			assertEquals(hours, i*malProDayHourPeriod);
			i++;
		}
	}

}
