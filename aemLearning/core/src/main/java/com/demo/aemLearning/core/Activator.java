package com.demo.aemLearning.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator{

	private static final Logger LOGGER = LoggerFactory.getLogger(Activator.class);
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
	
		LOGGER.info("Bundle Shuruvagide started from aemLearning");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("Bundle Nintide stopped from aemLearning");
	}
	
	

}
