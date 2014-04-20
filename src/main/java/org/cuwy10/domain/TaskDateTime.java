package org.cuwy10.domain;

import org.joda.time.MutableDateTime;

/**
 * Calendar date and his medical task 
 * @author roman
 * 
 */
public class TaskDateTime extends MutableDateTime{
	private TaskMed taskM;
//	private MutableDateTime date;
	public TaskDateTime(MutableDateTime date, Drug taskM) {
		super(date);
//		this.date=date;
		this.taskM=taskM;
	}
	public String toString() {
		return super.toString()+" "+taskM;
	}
	
}
