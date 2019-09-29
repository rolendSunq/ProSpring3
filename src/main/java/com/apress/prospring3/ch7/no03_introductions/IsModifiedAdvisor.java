package com.apress.prospring3.ch7.no03_introductions;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/*
 * 믹스인용 어드바이저의 생성
 * 
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor{
	private static final long serialVersionUID = -5808137140320552826L;

	public IsModifiedAdvisor() {
		super(new IsModifiedMixin());
	}
}
