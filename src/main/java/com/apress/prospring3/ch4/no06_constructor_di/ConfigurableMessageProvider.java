package com.apress.prospring3.ch4.no06_constructor_di                                                                                                                                          ;

public class ConfigurableMessageProvider {
	private String message;
	
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
