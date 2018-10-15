package com.demo.aemLearning.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;


@Component
@Service
public class SlingJCRFetchImpl implements SlingJCRFetch{
	
	@Reference
	private ResourceResolverFactory resolverFactory;

	@Override
	public String getJCRData() {
		
		
		// TODO Auto-generated method stub
		try{
		Map<String, Object> param = new HashMap<String,Object>();
		param.put(ResourceResolverFactory.SUBSERVICE,"writeService");
		ResourceResolver resolver =null;
		resolver = 	resolverFactory.getServiceResourceResolver(param);
	//Resource res =	resolver.getResource("/content/aemLearning/en/pageprop");
	String k = resolver.getUserID().toString();
	//Page page = res.adaptTo(Page.class);
	//Page page  = res.adaptTo(Page.class);
//	String k = page.getPath();
	
	return k;
	
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
		
	}

}
