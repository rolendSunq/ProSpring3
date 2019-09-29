package com.apress.prospring3.ch4.no13_inject_parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
	
	@Value("#{injectSimpleConfig.name}")
	private String name;
	
	@Value("#{injectSimpleConfig.age}")
	private int age;
	
	@Value("#{injectSimpleConfig.height}")
	private float height;
	
	@Value("#{injectSimpleConfig.programmer}")
	private boolean programmer;
	
	@Value("#{injectSimpleConfig.ageInSeconds}")
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no13_inject_parameter/app-context-inject_parameter.xml");
		ctx.refresh();
		
		InjectSimpleSpel  simple = (InjectSimpleSpel) ctx.getBean("injectSimpleSpel");
		System.out.println(simple);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("이름: " + name + "\r\n");
		sb.append("나이: " + age + "\r\n");
		sb.append("Age in Seconds: " + ageInSeconds + "\r\n");
		sb.append("키: " + height + "\r\n");
		sb.append("개발자 입니까?: " + programmer + "\r\n");
		return sb.toString();
	}
}
