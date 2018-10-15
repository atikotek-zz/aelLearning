package com.demo.aemLearning.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
   
import javax.jcr.Node; 
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service; 
   
   
//This is a component so it can provide or consume services
@Component
   
@Service
public class NodePassingImpl implements NodePassing {
     
    /** Default log. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
     
    public String propertyToMyString(Node n) 
    {
         
        
        try
        {
            //Read the jcr:createdBy prop
            String user = n.getProperty("jcr:createdBy").getString();
            log.info("User is "+user);
            return user; 
             
             
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
        return null ; 
         
    }
 
}