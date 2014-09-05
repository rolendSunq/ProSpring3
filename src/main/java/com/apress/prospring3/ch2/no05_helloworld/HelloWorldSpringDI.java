package com.apress.prospring3.ch2.no05_helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring3.ch2.no05_helloworld.MessageRenderer;

public class HelloWorldSpringDI {

	public static void main(String[] args) {
		// 스프링 ApplicationContext 초기화
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/apress/prospring3/ch2/no05_helloworld/conf/app-context.xml");
		MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
		mr.render();
	}

}
