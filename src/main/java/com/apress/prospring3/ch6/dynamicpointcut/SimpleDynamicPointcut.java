package com.apress.prospring3.ch6.dynamicpointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
	// 메서드 검사
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("Static check for " + method.getName());
		return ("foo".equals(method.getName()));
	}
	
	// 인자 검사
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		System.out.println("Dynamic check for " + method.getName());
		int x = ((Integer) args[0]).intValue();
		return (x != 100);
	}
	
	// getClassFilter를 사용함으로 메서드 일치 여부를 비교하는 메서드에서 클래스 검사를 하지 않아도 된다.
	// 동적 검사에서 매우 중요하다.
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			
			// 클래스 검사
			@Override
			public boolean matches(Class<?> clazz) {
				return (clazz == SampleBean.class);
			}
		};
	}

}
