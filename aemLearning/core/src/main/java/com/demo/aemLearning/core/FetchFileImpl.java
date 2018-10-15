package com.demo.aemLearning.core;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Reference;


import javax.jcr.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node; 
   
//Sling Imports
import org.apache.sling.api.resource.ResourceResolverFactory ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;

import org.apache.sling.api.resource.ResourceResolver; 
   
 
@Component(immediate=true,metatype=false,enabled=true)
@Service(value=FetchFile.class)
public class FetchFileImpl implements FetchFile {
	
	private static final Logger log = LoggerFactory.getLogger(FetchFileImpl.class);
     
    private Session session;
     
    //Inject a Sling ResourceResolverFactory
     @Reference
     private ResourceResolverFactory resolverFactory;
    //Reads a local  Folder for an XML file and places it the AEM JCR
    //This service is invoked by an AEM Scheduler Service every 5 mins 
     
    public void getXMLFile() 
    {
    	log.info("Into GetXml method");
        InputStream fis = null;
        try
        {
        //Read the XML file from the specified Watched Folder
        File file = new File("D:/Fetch/example.xml");
        fis = new FileInputStream(file);
         log.info("file fetched");
        //Post to the AEM JCR
        sendToJCR(fis); 
         
         
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
        }
     
     
    //Write the XML file to the AEM JCR
    private String sendToJCR(InputStream is)
    {
    	log.info("into sendtojcr method");
        try
        {
             
             
            
			//ResourceResolver resourceResolver = resolverFactory.getAdministrativeResourceResolver(null);
            //session = resourceResolver.adaptTo(Session.class);
             
        	Map<String, Object> param = new HashMap<String, Object>();
        	param.put(ResourceResolverFactory.SUBSERVICE, "writeService");
        	ResourceResolver resolver = null;
        	
                
        	    //Invoke the adaptTo method to create a Session 
        	    resolver = resolverFactory.getServiceResourceResolver(param);
        	    session = resolver.adaptTo(Session.class);
        	
            //create a unique file name so no two file names are the same
            String fileName = "Example_XML_" +java.util.UUID.randomUUID() +".xml";
             
            String path = "/content/xml-files"; 
             
                     
            Node node = session.getNode(path);  //Get the client lib node in which to write the posted file
            javax.jcr.ValueFactory valueFactory = session.getValueFactory();
            
            
           javax.jcr.Binary contentValue = valueFactory.createBinary(is);       
           
            Node fileNode = node.addNode(fileName, "nt:file"); 
            fileNode.addMixin("mix:referenceable"); 
            Node resNode = fileNode.addNode("jcr:content", "nt:resource"); 
            //resNode.setProperty("jcr:mimeType", mimetype); 
            resNode.setProperty("jcr:data", contentValue); 
            Calendar lastModified = Calendar.getInstance(); 
            lastModified.setTimeInMillis(lastModified.getTimeInMillis()); 
            resNode.setProperty("jcr:lastModified", lastModified); 
            session.save();            
            session.logout();
                    
           File file = resolver.adaptTo(File.class);
            String title = file.getName(); // Get the title of the web page
            return title ;
            }
         
         
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
		return null;
        
        
    }

}


