package com.apress.prospring3.ch6.annotationpointcut;

public class SampleAnnotationBean {
	
	@AdviceRquired
	public void foo(int x) {
		System.out.println("Invoked foo() with: " + x);
	}
	
	public void bar() {
		System.out.println("Invoked bar()");
	}
}
