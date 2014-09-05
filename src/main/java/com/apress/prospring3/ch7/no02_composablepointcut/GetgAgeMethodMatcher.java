package com.apress.prospring3.ch7.no02_composablepointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcher;

public class GetgAgeMethodMatcher extends StaticMethodMatcher {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "getAge".equals(method.getName());
	}

}
