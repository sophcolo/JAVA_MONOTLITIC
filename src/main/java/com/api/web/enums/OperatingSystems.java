package com.api.web.enums;

public enum OperatingSystems {
	ANDROID ("Android"),
	IOS ("iOS"),
	WINDOWS ("Windows Phone");
	
	private final String name;
	
	OperatingSystems(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}