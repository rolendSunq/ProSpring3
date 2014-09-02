package com.apress.prospring3.ch6.aroundadvice01;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class ProfilingInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch sw = new StopWatch();
		// 메서드 호출 전, stopWath 시작. 
		sw.start(invocation.getMethod().getName());
		
		// 메서드 호출: proceed()
		Object returnValue = invocation.proceed();
		
		// 메서드 호출 후
		sw.stop();
		dumpInfo(invocation, sw.getTotalTimeMillis());
		return returnValue;
	}

	private void dumpInfo(MethodInvocation invocation, long ms) {
		Method m = invocation.getMethod();
		Object target = invocation.getThis();
		Object[] args = invocation.getArguments();
		
		System.out.println("메소드가 실행됨: " + m.getName());
		System.out.println("오브젝트의 타입: "  + target.getClass().getName());
		System.out.println("인수들: " );
		for (int i = 0; i < args.length; i++) {
			System.out.print("	>" + args[i]);
		}
		System.out.println("\n");
		System.out.println("가져온 시간: " + ms + " ms");
	}

}
