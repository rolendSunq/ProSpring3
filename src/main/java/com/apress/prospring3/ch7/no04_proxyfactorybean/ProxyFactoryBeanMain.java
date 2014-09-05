package com.apress.prospring3.ch7.no04_proxyfactorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:com/apress/prospring3/ch7/no04_proxyfactorybean/ProxyFactoryBean.xml");
		ctx.refresh();
		
		MyBean bean1 = (MyBean)ctx.getBean("myBean1");
		MyBean bean2 = (MyBean)ctx.getBean("myBean2");
		
		System.out.println("Bean 1");
		bean1.execute();
		
		System.out.println("\nBean 2");
		bean2.execute();
	}
}
