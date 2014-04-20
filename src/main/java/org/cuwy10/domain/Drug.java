package org.cuwy10.domain;


public class Drug extends TaskMed{
	public Drug(String drugName) {
		if(null==drugName)
			new RuntimeException();
		if(drugName.length()==1)
			drugName="drug "+drugName;
		this.drugName=drugName;
	}

	String drugName;
	@Override
	public String toString() {
		return drugName;
	}
}
