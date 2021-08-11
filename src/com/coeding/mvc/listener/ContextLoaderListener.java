package com.coeding.mvc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.coeding.mvc.ApplicationContextReader;

/**
 * Application Lifecycle Listener implementation class ContextLoaderListener
 * have to regist in Container
 * why ?	be occurred by container
 * 
 * 1. <listner>	in web.xml
 * 2. annotation
 * 
 * url-pattern ? khong co
 * 
 * select with <Interface>
 * 
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	static ApplicationContextReader applicationcontext;
	
	public static ApplicationContextReader getApplicationContext() {
		return applicationcontext;
	}
	
    public ContextLoaderListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("application exit");
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO when application start
    	System.out.println("application start");
    	ServletContext context = arg0.getServletContext();
    	// real path on Disk
    	String proppath = context.getRealPath(
    			context.getInitParameter("contextConfigLocation")// from web.xml
    			);
    	applicationcontext = new ApplicationContextReader(proppath);
    }
	
}
