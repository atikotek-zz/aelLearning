package com.demo.aemLearning.core;

import javax.jcr.Repository; 
import javax.jcr.SimpleCredentials; 
import javax.jcr.Node; 
  
import org.apache.jackrabbit.commons.JcrUtils; 
  
    
public class AccessJcr { 
  
    
public static void main(String[] args) throws Exception { 
  
try { 
  
    //Create a connection to the CQ repository running on local host 
    Repository repository = JcrUtils.getRepository("http://localhost:4502/crx/server");
    
   //Create a Session
   javax.jcr.Session session = repository.login( new SimpleCredentials("admin", "admin".toCharArray())); 
  
  //Create a node that represents the root node
  Node root = session.getRootNode(); 
  
  // Store content 
  Node adobe = root.addNode("tikoti"); 
  Node day = adobe.addNode("avi"); 
  day.setProperty("message", "Adobe CQ is part of the Adobe Digital Marketing Suite!"); 
     
  
  // Retrieve content 
  Node node = root.getNode("tikoti/day"); 
  System.out.println(node.getPath()); 
  System.out.println(node.getProperty("message").getString()); 
  
  // Save the session changes and log out
  session.save(); 
  session.logout();
  }
 catch(Exception e){
  e.printStackTrace();
  }
 } 
}
