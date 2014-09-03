package com.apress.prospring3.ch6.staticpointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutMain {
	public static void main(String[] args) {
		BeanOne one = new BeanOne();
		BeanTwo two = new BeanTwo();
		
		BeanOne proxyOne;
		BeanTwo proxyTwo;
		
		// 포인트컷, 어드바이스, 어드바이저 생성
		Pointcut pc = new SimpleStaticPointcut();
		Advice advice = new SimpleAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		
		// BeanOne 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(one);
		proxyOne = (BeanOne)pf.getProxy();
		
		// BeanTwo 프록시 생성
		pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(two);
		proxyTwo = (BeanTwo)pf.getProxy();
		
		proxyOne.foo();
		proxyTwo.foo();
		
		proxyOne.bar();
		proxyTwo.bar();
	}
}
