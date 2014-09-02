package com.apress.prospring3.ch6.afterreturning03;

import java.lang.reflect.Method;

import org.hibernate.ejb.criteria.ValueHandlerFactory.LongValueHandler;
import org.springframework.aop.AfterReturningAdvice;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
			// Object 형으로 리턴 값을 가져왔기 때문에 KeyGenerator의 멤버 타입으로 형 변환 해야한다.
			long key = ((Long) returnValue).longValue();
			
			if (key == KeyGenerator.WEAK_KEY) {
				throw new SecurityException("Key Generator가 취약한 키를 생성했습니다. 다시 시도하세요.");
			}
		}
	}

}
