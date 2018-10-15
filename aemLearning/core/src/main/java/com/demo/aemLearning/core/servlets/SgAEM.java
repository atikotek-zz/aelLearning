package com.demo.aemLearning.core.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@SuppressWarnings("serial")
@SlingServlet(paths={"/bin/gson"},methods={("GET")})
public class SgAEM extends SlingSafeMethodsServlet {
	
	@Override
	protected void doGet(final SlingHttpServletRequest req,final SlingHttpServletResponse res) throws ServletException,IOException{
		
		String k=null;
		
		Resource resource = req.getResourceResolver().getResource("/content/aemLearning/en");

	Iterator<Resource> itr	= resource.listChildren();
	List<String> list = new ArrayList<>();
	while(itr.hasNext())
	{
		Resource rs = itr.next();
       k =	rs.getName();	
      list.add(k);
	}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
res.getWriter().println(gson.toJson(list));//gson annotations available: @Expose,@SerializedName,@since,@until,@JsonAdapter		
	}	
}
