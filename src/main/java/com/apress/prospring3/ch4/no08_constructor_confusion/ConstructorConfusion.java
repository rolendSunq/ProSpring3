package com.apress.prospring3.ch4.no08_constructor_confusion;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorConfusion {

	private String someValue;
	
	public ConstructorConfusion(String someValue) {
		System.out.println("ConstructorConfusion(String) 호출됨.");
		this.someValue = someValue;
	}
	
	public ConstructorConfusion(int someValue) {
		System.out.println("ConstructorConfusion(int) 호출됨.");
		this.someValue = "Number: " + Integer.toString(someValue);
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no08_constructor_confusion/app-context-constructor_confusion.xml");
		ctx.refresh();
		
		ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
		System.out.println(cc);
	}
	
	@Override
	public String toString() {
		return someValue;
	}
}
