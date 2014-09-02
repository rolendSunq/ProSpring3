package com.apress.prospring3.ch6.security01;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
	public static void main(String[] args) {
		// 보안 메니저 가져오기
		SecurityManager mgr = new SecurityManager();
		
		// 빈 가져오기
		SecureBean bean = getSecureBean();
		
		// Clarence로 로그인 시도
		mgr.login("clarence", "pwd");
		bean.writeSecureMessage();
		mgr.logout();
		
		// janm으로 로그인 시도
		try {
			mgr.login("janm", "pwd");
			bean.writeSecureMessage();
		} catch (SecurityException ex) {
			System.out.println("예외 주의: " + ex.getMessage());
		} finally {
			mgr.logout();
		}
		
		// 인증 정보 없이 로그인 시도
		try {
			bean.writeSecureMessage();
		} catch (SecurityException ex) {
			System.out.println("예외 주의: " + ex.getMessage());
		} finally {
			mgr.logout();
		}
	}

	private static SecureBean getSecureBean() {
		// 타깃 생성
		SecureBean target = new SecureBean();
		
		// 어드바이스 생성
		SecurityAdvice advice = new SecurityAdvice();
		
		// 프록시 가져오기
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice);
		SecureBean proxy = (SecureBean)factory.getProxy();
		return proxy;
	}
}
