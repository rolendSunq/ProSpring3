package com.apress.prospring3.ch6.throwsadvice01;

public class ErrorBean {
	public void errorProneMethod() throws Exception {
		throw new Exception("Foo");
	}
	
	public void otherErrorProneMethod() throws IllegalArgumentException {
		throw new IllegalArgumentException("Bar");
	}
}
