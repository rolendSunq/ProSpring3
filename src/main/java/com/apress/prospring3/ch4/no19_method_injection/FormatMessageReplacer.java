package com.apress.prospring3.ch4.no19_method_injection;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class FormatMessageReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		if (isFormatMessageMethod(method)) {
			String msg = (String) args[0];
			return "<h2>" + msg + "</h2>";
		} else {
			throw new IllegalArgumentException("메소드를 구현할 수 없습니다. 메소드: "  + method.getName());
		}
	}

	private boolean isFormatMessageMethod(Method method) {
		// 인자 개수가 정확한지 확인
		if (method.getParameterTypes().length != 1) {
			return false;
		}
		
		// 메서드 이름을 확인
		if (!("formatMessage".equals(method.getName()))) {
			return false;
		}
		
		// 반환 타입을 확인
		if (method.getReturnType() != String.class) {
			return false;
		}
		
		// 인자타입이 정확한지 확인
		if (method.getParameterTypes()[0] != String.class) {
			return false;
		}
		
		return true;
	}

}
