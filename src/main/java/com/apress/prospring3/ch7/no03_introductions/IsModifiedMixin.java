package com.apress.prospring3.ch7.no03_introductions;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.util.ReflectionUtils.MethodCallback;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified{
	
	private boolean isModified = false;
	private Map<Method, Method> methodCache = new HashMap<Method, Method>();
	

	@Override
	public boolean isModified() {
		return isModified;
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		if (!isModified) {
			if ((invocation.getMethod().getName().startsWith("set")) && (invocation.getArguments().length == 1)) {
				// 값이실제로 변했는지 확인하기 위해 대응되는 get 메서드 호출
				Method getter = getGetter(invocation.getMethod());
				
				if (getter != null) {
					// 수정 검사는 쓰기 전용 메서드에서는 중요하지 않다.
					Object newVal = invocation.getArguments()[0];
					Object oldVal = getter.invoke(invocation.getThis(), null);
					
					if ((newVal == null) && (oldVal != null)) {
						isModified = false;
					} else if ((newVal == null) && (oldVal != null)) {
						isModified = true;
					} else if ((newVal != null) && (oldVal == null)) {
						isModified = true;
					} else {
						isModified = (!newVal.equals(oldVal));
					}
				}
			}
		}
		return super.invoke(invocation);
	}

	private Method getGetter(Method setter) {
		Method getter = null;
		
		// 캐시 재조회 시도
		getter = (Method) methodCache.get(setter);
		
		if (getter != null) {
			return getter;
		}
		
		String getterName = setter.getName().replaceFirst("set", "get");
		
		try {
			getter = setter.getDeclaringClass().getMethod(getterName, null);
			
			// 캐시 게터
			synchronized (methodCache) {
				methodCache.put(setter, getter);
			}
			
			return getter;
		} catch (NoSuchMethodException e) {
			// 읽기 전용
			return null;
		}
	}

}
