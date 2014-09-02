package com.apress.prospring3.ch6.beforeAdvice03;

public class BeforAdvieceMain {
	public static void main(String[] args) {
		BeforAdviceRun run = new BeforAdviceRun();
		run.productBeforAdvice(new SimpleBeforeAdvice(), new MessageWriter());
	}
}
