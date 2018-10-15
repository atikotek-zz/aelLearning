package com.demo.aemLearning.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
  
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
  
  
  
  
@SlingServlet(paths="/bin/slingmodel", methods="GET")
public class SlingModelFetchServlet extends SlingAllMethodsServlet{
  
    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Reference
    ResourceResolverFactory resourceResolverFactory;    
    ResourceResolver resourceResolver;
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws ServletException,IOException{
        logger.info("inside sling model test servlet");
        response.setContentType("text/html");
        
        
        try {
        	Map<String, Object> param = new HashMap<String, Object>();
         	param.put(ResourceResolverFactory.SUBSERVICE, "writeService");
         	ResourceResolver resolver = null;
         	
                 
         	    //Invoke the adaptTo method to create a Session 
         	    resolver = resourceResolverFactory.getServiceResourceResolver(param);
         	    
            //resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
            Resource resource = resourceResolver.getResource("/content/testsling/slingmodel");
            ValueMap valueMap=resource.adaptTo(ValueMap.class);
              
            response.getWriter().write("Output from ValueMap is First Name: "+valueMap.get("firstName").toString()+" Last Name: "+valueMap.get("lastName").toString()+" Technology: "+valueMap.get("technology").toString()+"");
              
            SlingModelFetch smf = resource.adaptTo(SlingModelFetch.class);
            response.getWriter().write("Output from Sling Model is First Name: "+smf.getFirstName()+" Last Name: "+smf.getLastName()+" Technology: "+smf.getTechnology());
                      
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        finally{
            if(resourceResolver.isLive())
                resourceResolver.close();
        }
          
      
    }
  
}
