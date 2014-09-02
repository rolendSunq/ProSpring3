package com.apress.prospring3.ch6.aroundadvice01;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingMain {

	public static void main(String[] args) {
		WorkerBean bean = getWorkerBean();
		bean.doSumeWork(10000000);
	}

	private static WorkerBean getWorkerBean() {
		WorkerBean target = new WorkerBean();
		
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new ProfilingInterceptor());
		factory.setTarget(target);
		
		return (WorkerBean) factory.getProxy();
	}

}
