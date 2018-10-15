package com.demo.aemLearning.core;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component 
@Service
public class KeyServiceImpl implements KeyService {
	


	@Override
	public String getName() {
		return "John";
	}

	@Override
	public String getDevStatus() {
		// TODO Auto-generated method stub
		return "Analyst";
	}
	
	public String getWholeData(){
		String k = this.getName();
		String l = this.getDevStatus();
		return k + "is a AEM Dev with status"  +l;
	}

}
