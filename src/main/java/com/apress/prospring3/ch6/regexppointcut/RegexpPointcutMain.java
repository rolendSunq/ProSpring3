package com.apress.prospring3.ch6.regexppointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;


public class RegexpPointcutMain {

	public static void main(String[] args) {
		RegexpBean target = new RegexpBean();
		
		// 어드바이저 생성
		JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
		pc.setPattern(".*foo.*");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
		
		// 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		RegexpBean proxy = (RegexpBean) pf.getProxy();
		
		proxy.foo1();
		proxy.foo2();
		proxy.bar();
	}

}
