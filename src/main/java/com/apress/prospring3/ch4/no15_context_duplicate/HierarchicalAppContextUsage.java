package com.apress.prospring3.ch4.no15_context_duplicate;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {

	public static void main(String[] args) {
		GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
		parent.load("classpath:ch4/no15_context_duplicate/app-context-parent.xml");
		parent.refresh();
		
		@SuppressWarnings("resource")
		GenericXmlApplicationContext child = new GenericXmlApplicationContext();
		child.load("classpath:ch4/no15_context_duplicate/app-context-child.xml");
		child.setParent(parent);
		child.refresh();
		
		SimpleTarget target1 = (SimpleTarget) child.getBean("target1"); 
		SimpleTarget target2 = (SimpleTarget) child.getBean("target2"); 
		SimpleTarget target3 = (SimpleTarget) child.getBean("target3");
		
		System.out.println(target1.getVal());
		System.out.println(target2.getVal());
		System.out.println(target3.getVal());
	}

}
