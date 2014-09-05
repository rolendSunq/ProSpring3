package com.apress.prospring3.ch4.no01dilookup;

public class ContextualizedDependencyLookup implements ManagedComponent {
	
	private Dependency dependency;
	
	@Override
	public void performLookup(Container container) {
		this.dependency = (Dependency) container.getDependency("myDependency");
	}

}
