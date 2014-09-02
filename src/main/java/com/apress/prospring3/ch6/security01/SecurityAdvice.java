package com.apress.prospring3.ch6.security01;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {

	private SecurityManager securityManager;
	
	public SecurityAdvice() {
		this.securityManager = new SecurityManager();
	}
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		UserInfo user = securityManager.getLoggedOnUser();
		
		if (user == null) {
			System.out.println("사용자는 인증되지 않음.");
			throw new SecurityException("이 메소드를 호출하기 전에 로그인해야합니다." + method.getName());
		} else if ("clarence".equals(user.getUserName())) {
			System.out.println("좋아요 - 로그인 한 사용자는 클라렌스입니다!");
		} else {
			System.out.println("로그인 한 사용자는 " + user.getUserName() + " 좋지 않습니다: (");
			throw new SecurityException("사용자 " + user.getUserName() + " 메소드 접근에 허용하지 않습니다.)");
		}
	}
}
