package com.demo.aemLearning.core;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component(metatype=false)
@Service
public class OsgiTestImpl implements OsgiTest {

	@Override
	public String getOsgiName() {
		// TODO Auto-generated method stub
		return "Kuls";
	}

	@Override
	public String getOsgiService() {
		// TODO Auto-generated method stub
		return "Avis";
	}

	@Override
	public String getOsgiData() {
		// TODO Auto-generated method stub
		
		String k = this.getOsgiName();
		String L = this.getOsgiService();
		return k+L;
	}

}
