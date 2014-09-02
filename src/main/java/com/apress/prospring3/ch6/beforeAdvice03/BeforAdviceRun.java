package com.apress.prospring3.ch6.beforeAdvice03;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;



public class BeforAdviceRun {
	private ProxyFactory pf;
	private MessageWriter mw;
	
	public BeforAdviceRun() {
		pf = new ProxyFactory();
		mw = new MessageWriter();
	}
	
	public BeforAdviceRun(ProxyFactory pf, MessageWriter mw) {
		this.pf = pf;
		this.mw = mw;
	}
	
	public void setBeforeAdvice(Object obj, Object target) {
		pf.addAdvice((Advice) obj);
		pf.setTarget(target);
	}
	
	public void setMessage() {
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		proxy.writeMessage();
	}
	
	public void productBeforAdvice(Object obj, Object target) {
		setBeforeAdvice(obj, target);
		setMessage();
	}
}
