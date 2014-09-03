package com.apress.prospring3.ch6.aspectjexppointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectjexpPointcutMain {

	public static void main(String[] args) {
		AspectjexpBean target = new AspectjexpBean();
		
		// 어드바이저 생성
		AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
		pc.setExpression("execution(* foo*(..))");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
		
		// 프록시 생성
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		AspectjexpBean proxy = (AspectjexpBean) pf.getProxy();
		
		proxy.foo1();
		proxy.foo2();
		proxy.bar();
	}

}
