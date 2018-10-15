package com.demo.aemLearning.core;

import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.AccessDeniedException;
import javax.jcr.InvalidItemStateException;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.ReferentialIntegrityException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.UnsupportedRepositoryOperationException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetManager;

@Component(immediate=true,metatype=false,enabled=true)
@Service(value=XmlFromDamInterface.class)
public class XmlFromDam implements XmlFromDamInterface {

	private static final Logger log = LoggerFactory.getLogger(XmlFromDam.class);
	
	private Session session;
    
    //Inject a Sling ResourceResolverFactory
     @Reference
     private ResourceResolverFactory resolverFactory;
     
	@Override
	public String getFile() {
	
		
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
		
        	    AssetManager manager = resolver.adaptTo(AssetManager.class);
        	
        Asset resource = manager.getAssetForBinary("/content/dam/xmlFileFolder");
		sendToJCR(resource);
	
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
		return null;
	}
	
	private void sendToJCR(Asset resource) {
		
		String fileName = "Example_XML_" +java.util.UUID.randomUUID() +".xml";
        
        String path = "/content/fromDamFetched"; 
        
        Node node = null;
		try {
			node = session.getNode(path);
		} catch (PathNotFoundException e) {
			
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		}  //Get the client lib node in which to write the posted file
        javax.jcr.ValueFactory valueFactory = null;
		try {
			valueFactory = session.getValueFactory();
		} catch (UnsupportedRepositoryOperationException e) {
		
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		}
        
        
       javax.jcr.Binary contentValue = null;
	try {
		contentValue = valueFactory.createBinary((InputStream) resource);
	} catch (RepositoryException e1) {
		
		e1.printStackTrace();
	}       
       
        Node fileNode = null;
		try {
			fileNode = node.addNode(fileName, "nt:file");
		} catch (ItemExistsException e) {
			
			e.printStackTrace();
		} catch (PathNotFoundException e) {
		
			e.printStackTrace();
		} catch (NoSuchNodeTypeException e) {
			
			e.printStackTrace();
		} catch (LockException e) {
		
			e.printStackTrace();
		} catch (VersionException e) {
			
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		} 
        try {
			fileNode.addMixin("mix:referenceable");
		} catch (NoSuchNodeTypeException e) {
			
			e.printStackTrace();
		} catch (VersionException e) {
			
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			
			e.printStackTrace();
		} catch (LockException e) {
			
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		} 
        Node resNode = null;
		try {
			resNode = fileNode.addNode("jcr:content", "nt:resource");
		} catch (ItemExistsException e) {
			
			e.printStackTrace();
		} catch (PathNotFoundException e) {
			
			e.printStackTrace();
		} catch (NoSuchNodeTypeException e) {
			
			e.printStackTrace();
		} catch (LockException e) {
			
			e.printStackTrace();
		} catch (VersionException e) {
			
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
		
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		} 
        //resNode.setProperty("jcr:mimeType", mimetype); 
        try {
			resNode.setProperty("jcr:data", contentValue);
		} catch (ValueFormatException e) {
		
			e.printStackTrace();
		} catch (VersionException e) {
			
			e.printStackTrace();
		} catch (LockException e) {
			
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		} 
        Calendar lastModified = Calendar.getInstance(); 
        lastModified.setTimeInMillis(lastModified.getTimeInMillis()); 
        try {
			resNode.setProperty("jcr:lastModified", lastModified);
		} catch (ValueFormatException e) {
			
			e.printStackTrace();
		} catch (VersionException e) {
			
			e.printStackTrace();
		} catch (LockException e) {
			
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		} 
        try {
			session.save();
		} catch (AccessDeniedException e) {
			
			e.printStackTrace();
		} catch (ItemExistsException e) {
			
			e.printStackTrace();
		} catch (ReferentialIntegrityException e) {
			
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			
			e.printStackTrace();
		} catch (InvalidItemStateException e) {
			
			e.printStackTrace();
		} catch (VersionException e) {
		
			e.printStackTrace();
		} catch (LockException e) {
			
			e.printStackTrace();
		} catch (NoSuchNodeTypeException e) {
			
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		}            
        session.logout();
	}

}
