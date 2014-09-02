package com.apress.prospring3.ch6.throwsadvice01;

import org.springframework.aop.framework.ProxyFactory;

public class ProxingAdvice {
	private ErrorBean errorBean;
	private ProxyFactory proxyFactory;
	
	public ProxingAdvice() {
		errorBean = new ErrorBean();
		proxyFactory = new ProxyFactory();
	}
	
	private void setProxyAdvice() {
		proxyFactory.setTarget(errorBean);
		proxyFactory.addAdvice(new SimpleThrowsAdvice());
	}
	
	private ErrorBean getErrorBeanProxy() {
		return (ErrorBean) proxyFactory.getProxy();
	}
	
	public void runExceptions() {
		setProxyAdvice();
		ErrorBean proxy = getErrorBeanProxy();
		
		try {
			proxy.errorProneMethod();
		} catch (Exception ignored) {}
		
		try {
			proxy.otherErrorProneMethod();
		} catch (Exception ignored) {}
	}
}
