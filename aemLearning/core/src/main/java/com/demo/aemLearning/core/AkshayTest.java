package com.demo.aemLearning.core;

import com.adobe.cq.sightly.WCMUsePojo;

public class AkshayTest extends WCMUsePojo {

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		
	getCG();
	
	}

	
	
	public String getCG(){
		
		return getComponent().getComponentGroup();
		}
}


