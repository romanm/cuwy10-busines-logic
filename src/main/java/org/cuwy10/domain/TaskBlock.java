package org.cuwy10.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskBlock extends TaskMed{
	private List<Drug> drugs;

	public List<Drug> getDrugs() {
		if(null==drugs)
			drugs= new ArrayList<Drug>();
		return drugs;
	}
}
