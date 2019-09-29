package com.apress.prospring3.ch7.no05_introductions;

import org.springframework.context.support.GenericXmlApplicationContext;

public class IntroductionConfigMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:com/apress/prospring3/ch7/no05_introductions/introductions.xml");
		ctx.refresh();
		
		TargetBean bean = (TargetBean) ctx.getBean("bean");
		IsModified mod = (IsModified) bean;
		
		// 인터페이스 테스트
		System.out.println("TargetBean 인가?: " + (bean instanceof TargetBean));
		System.out.println("IsModified 인가?: " + (bean instanceof IsModified));
		
		// IsModified 구현체 테스트
		System.out.println("수정되었나?: " + mod.isModified());
		bean.setName("Rolend Sunq");
		System.out.println("수정되었나?: " + mod.isModified());
		bean.setName("Rob Harrop");
		System.out.println("수정되었나?: " + mod.isModified());
	}

}
