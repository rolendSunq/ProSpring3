package com.apress.prospring3.ch4.no04_declarespringcomponent;

public interface MessageRenderer {
	public void render();
	public void setMessageProvider(MessageProvider provider);
	public MessageProvider getMessageProvider();
}
