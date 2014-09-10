package com.apress.prospring3.ch4.no05_declarespringcomponent;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingSetterInjectionMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no05_declarespringcomponent/app-context-annotation.xml");
		ctx.refresh();
		
		MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
	}

}
