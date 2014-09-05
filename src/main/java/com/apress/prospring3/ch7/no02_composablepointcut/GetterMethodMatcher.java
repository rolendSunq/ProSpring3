package com.apress.prospring3.ch7.no02_composablepointcut;

import java.lang.reflect.Method;

import org.springframework.aop.MethodMatcher;
import org.springframework.aop.support.StaticMethodMatcher;

public class GetterMethodMatcher extends StaticMethodMatcher {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return (method.getName().startsWith("get"));
	}

}
