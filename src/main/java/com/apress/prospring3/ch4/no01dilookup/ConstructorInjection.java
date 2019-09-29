package com.apress.prospring3.ch4.no01dilookup;

public class ConstructorInjection {
	
	@SuppressWarnings("unused")
	private Dependency dependency;
	
	public ConstructorInjection(Dependency dependency) {
		this.dependency = dependency;
	}
}
