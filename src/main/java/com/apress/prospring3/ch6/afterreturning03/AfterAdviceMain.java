package com.apress.prospring3.ch6.afterreturning03;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceMain {

	public static void main(String[] args) {
		KeyGenerator keyGen = getKeyGenerator();
		
		for (int i = 0; i < 10; i++) {
			try {
				long key = keyGen.getKey();
				System.out.println("Key: " + key);
			} catch (SecurityException ex) {
				System.out.println("취약한 키가 생성되었습니다.");
			}
		}
	}

	private static KeyGenerator getKeyGenerator() {
		KeyGenerator target = new KeyGenerator();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new WeakKeyCheckAdvice());
		pf.setTarget(target);
		return (KeyGenerator) pf.getProxy();
	}

}
