package com.apress.prospring3.ch2.no03_helloworld;

public class HelloWorldDecoupled {

	public static void main(String[] args) {
		MessageRenderer mr = new StandardOutMessageRenderer();
		MessageProvider mp = new HelloWorldMessageProvider();
		mr.setMessageProvider(mp);
		mr.render();
	}

}
