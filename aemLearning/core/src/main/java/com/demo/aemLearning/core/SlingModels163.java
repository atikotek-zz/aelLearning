package com.demo.aemLearning.core;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;

@Model(adaptables=SlingHttpServletRequest.class)
public class SlingModels163 {
	
//	@ScriptVariable(name="currentPage")
//	Page page;
//	
//	public String getPagePath(){
//		
//		return page.getPath();
//	}
	
	@RequestAttribute(name = "color")
    String param;


    public String getParam() {
       return param;
   }
	

}
