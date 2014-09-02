package com.apress.prospring3.ch6.afterreturning02;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("이후 메소드 실행: " + method.getName());
		System.out.println(new PeaceSells("미국"));
	}

}
