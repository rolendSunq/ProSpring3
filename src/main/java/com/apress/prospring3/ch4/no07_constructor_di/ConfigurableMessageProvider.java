package com.apress.prospring3.ch4.no07_constructor_di                                                                                                                                          ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider{
	private String message;
	
	@Autowired
	public ConfigurableMessageProvider(@Value("이것은 구성 메세지 입니다.") String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
