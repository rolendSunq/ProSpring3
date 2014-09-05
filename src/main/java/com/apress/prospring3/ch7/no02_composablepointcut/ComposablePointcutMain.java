package com.apress.prospring3.ch7.no02_composablepointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.apress.prospring3.ch6.beforeAdvice02.SimpleBeforeAdvice;

public class ComposablePointcutMain {

	public static void main(String[] args) {
		// 타깃 생성
		SampleBean target = new SampleBean();
		
		ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE, new GetterMethodMatcher());
		
		System.out.println("검사 1");
		SampleBean proxy = getProxy(pc, target);
		testInvoke(proxy);
		
		System.out.println("검사 2");
		pc.union(new SetterMethodMatcher());
		proxy = getProxy(pc, target);
		testInvoke(proxy);
		
		System.out.println("검사 3");
		pc.intersection(new GetgAgeMethodMatcher());
		proxy = getProxy(pc, target);
		testInvoke(proxy);
	}

	private static void testInvoke(SampleBean proxy) {
		proxy.getAge();
		proxy.getName();
		proxy.setName("RolendSunq");
	}

	private static SampleBean getProxy(ComposablePointcut pc, SampleBean target) {
		// 어드바이저 생성
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
		
		// 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		
		return (SampleBean) pf.getProxy();
	}

}
