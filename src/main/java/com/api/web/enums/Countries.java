package com.api.web.enums;

public enum Countries {
	ARG ("Argentina"),
	BOL ("Bolivia"),
	BRA ("Brazil"),
	COL ("Colombia"),
	CTR ("Costarica"),
	CAN ("Canada"),
	HON ("Honduras"),
	PAR ("Paraguay"),
	PER ("Peru"),
	PUE ("Puerto Rico"),
	SAL ("Salvador"),
	USA ("Estados Unidos"),
	URU ("Uruguay"),
	VEN ("Venezuela");
	
	private final String name;
	
	Countries(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
