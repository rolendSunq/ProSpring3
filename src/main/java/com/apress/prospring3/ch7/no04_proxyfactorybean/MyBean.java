package com.apress.prospring3.ch7.no04_proxyfactorybean;

public class MyBean {
	private MyDependency dep;
	
	public void execute() {
		dep.foo();
		dep.bar();
	}
	
	public void setDep(MyDependency dep) {
		this.dep = dep;
	}
}
