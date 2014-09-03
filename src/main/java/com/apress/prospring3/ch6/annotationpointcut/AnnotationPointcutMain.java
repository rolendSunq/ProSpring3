package com.apress.prospring3.ch6.annotationpointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutMain {

	public static void main(String[] args) {
		SampleAnnotationBean target = new SampleAnnotationBean();
		
		// 어드바이저 생성
		AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forClassAnnotation(AdviceRquired.class);
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
		
		// 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		SampleAnnotationBean proxy  = (SampleAnnotationBean) pf.getProxy();
		
		proxy.foo(100);
		proxy.bar();
	}

}
