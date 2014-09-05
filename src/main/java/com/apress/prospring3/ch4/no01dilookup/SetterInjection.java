package com.apress.prospring3.ch4.no01dilookup;

public class SetterInjection {
	
	private Dependency dependency;
	
	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
}
