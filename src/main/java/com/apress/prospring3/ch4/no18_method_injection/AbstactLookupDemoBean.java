package com.apress.prospring3.ch4.no18_method_injection;

public abstract class AbstactLookupDemoBean implements DemoBean{

	public abstract MyHelper getMyHelper();

	@Override
	public void someOperation() {
		getMyHelper().doSomethingHelpful();
	}

}
