package com.apress.prospring3.ch7.no01_controlflowpointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowMain {
	public static void main(String[] args) {
		ControlFlowMain ex = new ControlFlowMain();
		ex.run();
	}

	private void run() {
		TestBean target = new TestBean();
		
		// 어드바이저 생성
		Pointcut pc = new ControlFlowPointcut(ControlFlowMain.class);
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
		
		// 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		
		TestBean proxy = (TestBean) pf.getProxy();
		
		System.out.println("일반 invoke 시도.");
		proxy.foo();
		System.out.println("ControlFlowMain.test() 아래에서 시도");
		test(proxy);
	}

	private void test(TestBean bean) {
		bean.foo();
	}
}
