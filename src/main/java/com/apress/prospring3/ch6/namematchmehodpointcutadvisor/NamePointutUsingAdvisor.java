package com.apress.prospring3.ch6.namematchmehodpointcutadvisor;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NamePointutUsingAdvisor {
	public static void main(String[] args) {
		NameBean target = new NameBean();
		
		// 어드바이저 생성
		NameMatchMethodPointcutAdvisor advisor =  new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
		advisor.addMethodName("foo");
		advisor.addMethodName("bar");
		
		// 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisors(advisor);
		NameBean proxy = (NameBean) pf.getProxy();
		
		proxy.foo();
		proxy.foo(999);
		proxy.bar();
		proxy.yup();
	}
}
