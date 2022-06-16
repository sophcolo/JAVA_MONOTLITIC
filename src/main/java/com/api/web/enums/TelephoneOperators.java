package com.api.web.enums;

public enum TelephoneOperators {
	CLARO ("Claro"),
	ETB ("Etb"),
	DIRECTV ("DIRECTV Net"),
	KOLBI ("kölbi"),
	MOVISTAR ("Movistar"),
	VIRGIN ("Virgin Mobile"),
	WOM ("Wom"),
	TIGO ("Tigo");
	
	private final String name;
	
	TelephoneOperators(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
