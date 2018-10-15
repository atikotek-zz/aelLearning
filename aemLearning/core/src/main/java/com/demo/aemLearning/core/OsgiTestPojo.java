package com.demo.aemLearning.core;

import com.adobe.cq.sightly.WCMUsePojo;

public class OsgiTestPojo extends WCMUsePojo {
protected String details;
	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		
		OsgiTest o =getSlingScriptHelper().getService(OsgiTest.class);
		details = o.getOsgiData();
		
		
	}
	
	public String getDetails(){
		
		return this.details;
	}

}
