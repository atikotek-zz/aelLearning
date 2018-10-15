package com.demo.aemLearning.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component(immediate=true,metatype=false)

@Service(value=HandleForm.class)
public class HandleFormImpl implements HandleForm {
	
	
	@Reference
	private ResourceResolverFactory resolverFactory;

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<String> injestFormData(String First, String Last, String City, String Address) {
		// TODO Auto-generated method stub	          
	        //Simply write out the values that are posted from the AEM form to the AEM log file
	        log.info("Data posted from the AEM EXAMPLE form - First: "+First +" Last: "+Last +" City: "+City +" Address "+Address) ;

//	        try
//	        {
//	             
//	   			//ResourceResolver resourceResolver = resolverFactory.getAdministrativeResourceResolver(null);
//	            //session = resourceResolver.adaptTo(Session.class);
//	             
//	        	Map<String, Object> param = new HashMap<String, Object>();
//	        	param.put(ResourceResolverFactory.SUBSERVICE, "writeService");
//	        	ResourceResolver resolver = null;
//	        	
//	        	    //Invoke the adaptTo method to create a Session 
//	        	    resolver = resolverFactory.getServiceResourceResolver(param);
//	        	    Resource resource = resolver.getResource("");
//	        	    if(resource.hasChildren()){
//	        	    			Iterator<Resource> itr = resource.listChildren();
//	        	    			List<String> list = new ArrayList<>();
//	        	    			
//	        	    			while(itr.hasNext()){
//	        	    				Resource res = itr.next();
//	        	    				res.getValueMap().get("First").toString();
//	        	    				res.getValueMap().get("Last").toString();
//	        	    				
//	        	    			Map<String,String> m = new HashMap<>();
//	        	    			
//	        	    			m.put("First", res.getValueMap().get("First").toString());
//	        	    			m.put("Last", res.getValueMap().get("Last").toString());
//	        	    			
//	        	    			list.add(m.toString());
//	        	    			}
//	        	    		return list;	
//	        	    }
//	        }catch (Exception e)
//	                {
//	                    e.printStackTrace(); 
//	                }
			return null;
			
	
	
	
	
	        
	
	
	
	}
	
	
	
	
	
	

}
