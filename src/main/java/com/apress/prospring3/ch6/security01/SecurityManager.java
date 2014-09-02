package com.apress.prospring3.ch6.security01;

public class SecurityManager {
	private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();
	public void login(String userName, String password) {
		// 모든 인증 정보가 유효하다고 가정한다.
		threadLocal.set(new UserInfo(userName, password));
	}
	
	public void logout() {
		threadLocal.set(null);
	}
	
	public UserInfo getLoggedOnUser() {
		return threadLocal.get();
	}
}
