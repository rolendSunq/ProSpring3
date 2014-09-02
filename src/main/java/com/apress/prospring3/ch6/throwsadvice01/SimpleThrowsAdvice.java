package com.apress.prospring3.ch6.throwsadvice01;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
/*
 * ThrowsAdvice인터페이스는 마커인터페이스로 
 * 스프링에게 어느 특정 Exception이라는 것을 알려주기만 하면 된다.
 * 이런 특수성으로 ThrowsAdvice인터페이스를 상속받는 클래스는 메소드 오버로드할 것이 없다.
 * -- throws 어드바이스가 잡아낼 Exception 타입을 정확히 지정할 수 있게 스프링이 타입지정 throws 어드바이스를 지원하기 때문이다.
 * -- 이런 작업을 수행하는 것은 리플렉션을 사용해 특정 시그니처를 갖고 있는 메서드를 감지하고 있기 때문이다.
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("***");
		System.out.println("일반적인 예외 감지");
		System.out.println("Caught: " + ex.getClass().getName());
		System.out.println("***\n");
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) throws Throwable{
		System.out.println("***");
		System.out.println("허용하지 않는 인수 예외 감지");
		System.out.println("Caught: " + ex.getClass().getName());
		System.out.println("Method: " + method.getName());
		System.out.println("***\n");
	}
}
