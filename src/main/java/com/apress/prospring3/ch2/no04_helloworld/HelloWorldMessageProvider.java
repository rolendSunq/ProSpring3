package com.apress.prospring3.ch2.no04_helloworld;

public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello World";
	}

}
