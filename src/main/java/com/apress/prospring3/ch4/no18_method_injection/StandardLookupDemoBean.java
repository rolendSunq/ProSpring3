package com.apress.prospring3.ch4.no18_method_injection;

public class StandardLookupDemoBean implements DemoBean {
	
	private MyHelper myHelper;
	

	public void setMyHelper(MyHelper myHelper) {
		this.myHelper = myHelper;
	}

	@Override
	public MyHelper getMyHelper() {
		return this.myHelper;
	}

	@Override
	public void someOperation() {
		myHelper.doSomethingHelpful();
	}

}
