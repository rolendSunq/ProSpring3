package com.apress.prospring3.ch7.no05_introductions;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/*
 * 믹스인용 어드바이저의 생성
 * 
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor{
	public IsModifiedAdvisor() {
		super(new IsModifiedMixin());
	}
}
