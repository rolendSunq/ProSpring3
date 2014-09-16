package com.apress.prospring3.ch4.no18_method_injection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no18_method_injection/app-context-method_injection.xml");
		ctx.refresh();
		
		DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
		DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean");
		
		displayInfo(standardBean);
		displayInfo(abstractBean);
	}

	private static void displayInfo(DemoBean bean) {
		MyHelper helper1 = bean.getMyHelper();
		MyHelper helper2 = bean.getMyHelper();
		
		System.out.println("Helper instance 와 같나?: " + (helper1 == helper2));
		
		StopWatch stopWath = new StopWatch();
		stopWath.start("lookupDemo");
		
		for (int i = 0; i < 100000; i++) {
			MyHelper helper = bean.getMyHelper();
			helper.doSomethingHelpful();
		}
		
		stopWath.stop();
		
		System.out.println("100000 gets took " + stopWath.getTotalTimeMillis() + " ms");
	}

}
