package com.apress.prospring3.ch2.no04_helloworld;

public class StandardOutMessageRenderer implements MessageRenderer {
	
	private MessageProvider messageProvider = null;

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("당신은 messageProvider클래스의 속성을 설정해야합니다:" + StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
