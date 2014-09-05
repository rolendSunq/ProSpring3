package com.apress.prospring3.ch2.no04_helloworld;

public class HelloWorldDecoupledWithFactory {

	public static void main(String[] args) {
		MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
		MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
		mr.setMessageProvider(mp);
		mr.render();
	}

}
