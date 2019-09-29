package com.apress.prospring3.ch4.no06_constructor_di;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingConstructorDiMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no06_constructor_di/app-context-constructor-di.xml");
		ctx.refresh();
		
		ConfigurableMessageProvider messageProvider = ctx.getBean("messageProvider", ConfigurableMessageProvider.class);
		System.out.println(messageProvider.getMessage());
	}

}
