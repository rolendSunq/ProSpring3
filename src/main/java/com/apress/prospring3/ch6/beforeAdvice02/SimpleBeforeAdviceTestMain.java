package com.apress.prospring3.ch6.beforeAdvice02;

import org.springframework.aop.framework.ProxyFactory;

public class SimpleBeforeAdviceTestMain {

	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		
		ProxyFactory pf = new ProxyFactory();
		
		pf.addAdvice(new SimpleBeforeAdvice());
		pf.setTarget(target);
		
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		
		proxy.writeMessage();
	}

}
