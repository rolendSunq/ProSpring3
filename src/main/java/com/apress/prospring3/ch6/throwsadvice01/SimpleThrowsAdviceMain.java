package com.apress.prospring3.ch6.throwsadvice01;

public class SimpleThrowsAdviceMain {

	public static void main(String[] args) {
		ProxingAdvice pa = new ProxingAdvice();
		pa.runExceptions();
	}

}
