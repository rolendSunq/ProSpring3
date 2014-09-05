package com.apress.prospring3.ch4.no04_declarespringcomponent;

import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello World";
	}

}
