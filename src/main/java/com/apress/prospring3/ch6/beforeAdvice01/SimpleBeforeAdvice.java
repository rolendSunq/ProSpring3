package com.apress.prospring3.ch6.beforeAdvice01;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("이전 메소드: " + method.getName());
	}
	
	public static void main(String[] args) {
		
		MessageWriter target = new MessageWriter();
		
		// 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		
		// 어드바이스 종류를 셋팅한다. - BeforeAdvice 설정
		pf.addAdvice(new SimpleBeforeAdvice());
		
		// 어드바이스가 적용될 대상을 설정한다.
		pf.setTarget(target);
		
		// AOP가 적용된 MessageWriter를 가져온다.
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		
		// 메세지 작성
		proxy.writeMessage();
	}

}
