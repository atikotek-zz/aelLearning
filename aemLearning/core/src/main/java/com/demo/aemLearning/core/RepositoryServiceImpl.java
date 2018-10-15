package com.demo.aemLearning.core;

import javax.jcr.Repository;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true,metatype=false,label="Hello Ri Pa Bundle")
@Service(value=RepositoryService.class)
public class RepositoryServiceImpl implements RepositoryService{

	private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryServiceImpl.class);
	
	@Reference
	private Repository repository;
	
	@Override
	public String getRepositoryName() {
		// TODO Auto-generated method stub
		return repository.getDescriptor(Repository.REP_NAME_DESC);
	}
		
		@Activate
		protected void activate()
		{
			LOGGER.info("Service Shuruvagide");
		}
		
		@Deactivate
		protected void deactivate()
		{
			LOGGER.info("Service ninthogide");
		}
	
	}


