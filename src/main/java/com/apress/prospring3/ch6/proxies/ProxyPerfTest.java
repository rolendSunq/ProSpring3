package com.apress.prospring3.ch6.proxies;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {

	public static void main(String[] args) {
		ISimpleBean target = new SimpleBean();
		
		Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());
		runCglibTests(advisor, target);
		runCglibFrozenTests(advisor, target);
		runJdkTests(advisor, target);
	}

	private static void runJdkTests(Advisor advisor, ISimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setInterfaces(new Class[]{ISimpleBean.class});
		ISimpleBean proxy = (ISimpleBean) pf.getProxy();
		System.out.println("JDK 검사 진행중");
		test(proxy);
	}

	private static void runCglibFrozenTests(Advisor advisor, ISimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setProxyTargetClass(true);
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setFrozen(true);
		
		ISimpleBean proxy = (ISimpleBean) pf.getProxy();
		System.out.println("CGLIB (프로즌) 검사 진행중");
		test(proxy);
	}

	private static void runCglibTests(Advisor advisor, ISimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setProxyTargetClass(true);
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		
		ISimpleBean proxy  = (ISimpleBean) pf.getProxy();
		System.out.println("CGLIB (표준) 검사 진행중");
		test(proxy);
	}

	private static void test(ISimpleBean bean) {
		long before = 0;
		long after = 0;
		
		// 테스트 1: 어드바이스 적용 메서드 테스트
		System.out.println("Advised Method 검사");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) {
			bean.advised();
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("경과 시간: " + (after - before) + " ms");
		
		// 테스트 2: 어드바이스 비적용 메서드 테스트
		System.out.println("Unadvised Method 검사");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) {
			bean.unadvised();
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("경과 시간: " + (after - before) + " ms");
		
		// 테스트 3: equals() 메서드 테스트
		System.out.println("equals() Method 검사");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) {
			bean.equals(bean);
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("경과 시간: " + (after - before) + " ms");
		
		// 테스트 4: hashCode() 메서드 테스트
		System.out.println("hashCode() Method 검사");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) {
			bean.hashCode();
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("경과 시간: " + (after - before) + " ms");
		
		// 테스트 5: Advised의 메서드 테스트
		Advised advised  = (Advised)bean;
		System.out.println("Advised.getProxyTargetClass() Method 검사");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) {
			advised.getTargetClass();
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("경과 시간: " + (after - before) + " ms");
		System.out.println(">>>\n");
	}
	
}
