package com.demo.aemLearning.core.servlets;

import java.io.IOException;

import javax.jcr.Repository;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.jackrabbit.oak.commons.json.JsonObject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;


//@Component(service = Servlet.class,
@SlingServlet(paths = {"/bin/avinash"}, methods = { "GET" })
//property = {
//        //Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
//        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
//        "sling.servlet.paths=" + "/bin/avinash",
//        //"sling.servlet.extensions=" + "sample",
//})



public class ServletsLearning extends SlingAllMethodsServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Reference     
	private Repository repository; 
@SuppressWarnings("deprecation")
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
	
	//response.getWriter().print("hi..testing servlet with RTypes");
	
	 
	                  response.setContentType("application/json");
	                  String keys[] = repository.getDescriptorKeys();         
	                  @SuppressWarnings("deprecation")
					JSONObject jsonobject = new JSONObject();           
	                  for(int i=0;i<keys.length;i++)
	                  {
	                	  try{
	                		  jsonobject.put(keys[i],repository.getDescriptor(keys[i]));  
	                	  }catch(JSONException e){
	                		  e.printStackTrace();
	                	  }
	                	  
	                	  }
	                  
response.getWriter().println(jsonobject.toString());}
}
	                		  