package com.apress.prospring3.ch4.no03_declarespringcomponent;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponentsMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no03_declarespringcomponent/app-context.xml");
		ctx.refresh();
		
		MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
		System.out.println(messageProvider.getMessage());
	}

}
