package com.apress.prospring3.ch4.no11_inject_parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
	
	@Value("Rolend Sunq")
	private String name;
	
	@Value("40")
	private int age;
	
	@Value("1.75")
	private float height;
	
	@Value("true")
	private boolean programmer;
	
	@Value("1103760000")
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no11_inject_parameter/app-context-inject_parameter.xml");
		ctx.refresh();
		
		InjectSimple  injectSimple = (InjectSimple) ctx.getBean("injectSimple");
		System.out.println(injectSimple);
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
