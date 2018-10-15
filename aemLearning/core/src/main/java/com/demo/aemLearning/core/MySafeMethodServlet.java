package com.demo.aemLearning.core;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

@SlingServlet(paths="/bin/company/repo",methods="GET")
public class MySafeMethodServlet extends SlingSafeMethodsServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(SlingHttpServletRequest req,SlingHttpServletResponse rsp)throws ServletException,IOException
	{
	rsp.setHeader("Content-Type", "application/json");
	rsp.getWriter().print("{\"coming\":\"soon\"}");
	}
}
