package com.demo.aemLearning.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;

@Component
@Service
@Property(name = "process.label",value ="XMLWF Process")
public class XmlDataRead implements WorkflowProcess {
	
	@Reference
    private ResourceResolverFactory resolverFactory;
	
	private  Logger log = LoggerFactory.getLogger(XmlDataRead.class);
	
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2)
    {
    Session session = arg1.getSession();
    String updatedAsset =arg0.getWorkflowData().getPayload().toString();
    try
    {
    	Map<String, Object> param = new HashMap<String, Object>();
    	param.put(ResourceResolverFactory.SUBSERVICE, "writeService");
    	ResourceResolver resolver = null;
    	
    	    //Invoke the adaptTo method to create a Session 
    	    resolver = resolverFactory.getServiceResourceResolver(param);
    	    //session = resolver.adaptTo(Session.class);
    }
    catch (Exception e)
    {
        e.printStackTrace(); 
    }
    }}
