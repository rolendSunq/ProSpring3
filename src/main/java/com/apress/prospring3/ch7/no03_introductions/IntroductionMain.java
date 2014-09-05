package com.apress.prospring3.ch7.no03_introductions;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionMain {

	public static void main(String[] args) {
		// 타깃 생성
		TargetBean target = new TargetBean();
		target.setName("Rolend Sunq");
		
		// 어드바이저 생성
		IntroductionAdvisor advisor = new IsModifiedAdvisor();
		
		// 프록시 생성
		ProxyFactory pf  = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setOptimize(true);
		
		TargetBean proxy = (TargetBean) pf.getProxy();
		IsModified proxyInterface = (IsModified)proxy;
		
		// 인터페이스 테스트
		System.out.println("Is TargetBean?: " + (proxy instanceof TargetBean));
		System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
		
		// IsModified 구현체 테스트
		System.out.println("수정되었습니까?: " + proxyInterface.isModified());
		proxy.setName("Rolend Sunq");
		System.out.println("수정되었습니까?: " + proxyInterface.isModified());
		proxy.setName("Rob Harrop");
		System.out.println("수정되었습니까?: " + proxyInterface.isModified());
	}

}
