package com.apress.prospring3.ch6.afterreturning02;

import org.springframework.aop.framework.ProxyFactory;

public class AdjustAfterReturning {
	private ProxyFactory pf;
	
	public AdjustAfterReturning() {
		pf = new ProxyFactory();
		setAfterReturning();
	}
	
	private void setAfterReturning() {
		pf.addAdvice(new SimpleAfterReturningAdvice());
		pf.setTarget(new MessageWriter());
	}
	
	private void printMessage() {
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		proxy.writeMessage();
	}
	
	public void runMessage() {
		printMessage();
	}
}
