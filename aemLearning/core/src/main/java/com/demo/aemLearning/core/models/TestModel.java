package com.demo.aemLearning.core.models;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;



@Model(adaptables=Resource.class)
public class TestModel {
	
	
	public Map<String, String> getMap(){
		Map<String,String> map = new HashMap<>();
		map.put("1","test1");
		map.put("2","test2");
		return map;
	}

}
