package com.apress.prospring3.ch4.no19_method_injection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MehodReplacementMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no19_method_injection/app-context-method_injection.xml");
		ctx.refresh();
		
		ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
		ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");
		
		displayInfo(replacementTarget);
		displayInfo(standardTarget);
	}

	private static void displayInfo(ReplacementTarget target) {
		System.out.println(target.formatMessage("Hello World!"));
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("perfTest");
		
		for (int i = 0; i < 1000000; i++) {
			String out = target.formatMessage("foo");
		}
		
		stopWatch.stop();
		
		System.out.println("1000000 invocation took: " + stopWatch.getTotalTimeMillis());
		
	}

}
