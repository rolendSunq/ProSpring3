package com.apress.prospring3.ch4.no17_collection_injection;

import org.springframework.stereotype.Service;

@Service("oracle")
public class BookwormOracle implements Oracle {

	@Override
	public String defineMeaningOfLife() {
		return "백과사전은 돈을 낭비하는 것이다 - 인터넷을 사용하라.";
	}

}
