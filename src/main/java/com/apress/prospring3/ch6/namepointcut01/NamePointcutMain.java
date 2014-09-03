package com.apress.prospring3.ch6.namepointcut01;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;


public class NamePointcutMain {

	public static void main(String[] args) {
		NameBean target = new NameBean();
		
		// 어드바이저 생성
		NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
		pc.addMethodName("foo");
		pc.addMethodName("bar");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
		
		// 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		NameBean proxy = (NameBean) pf.getProxy();
		
		proxy.foo();
		proxy.foo(999);
		proxy.bar();
		proxy.yup();
	}

}
