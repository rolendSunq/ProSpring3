package com.apress.prospring3.ch4.no14_inject_bean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {
	
	private Oracle oracle;

	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no14_inject_bean/app-context-inject_bean.xml");
		ctx.refresh();
		
		InjectRef injectRef = (InjectRef) ctx.getBean("injectRef");
		System.out.println(injectRef);
	}
	
	@Override
	public String toString() {
		return oracle.defineMeaningOfLife();
	}
}
