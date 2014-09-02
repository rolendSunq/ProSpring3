package com.apress.prospring3.ch6.aroundadvice01;

public class WorkerBean {
	public void doSumeWork(int noOfTimes) {
		for (int i = 0; i < noOfTimes; i++) {
			work();
		}
	}

	private void work() {
		System.out.print("");
	}
}
