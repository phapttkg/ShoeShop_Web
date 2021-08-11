package com.coeding.mvc.controller;

import java.util.Map;

/**
 * Controller pattern
 * - interface to connect with DispatcherServlet
 * @author Administrator
 * @return view name : JSP
 * @arg data to process
 * 
 * Object's child	Object obj = new AnyClass();
 * List<Object> -> select one ?
 * for(){
 * 	// element's type : String, Blogger, Article
 * 	if( ){ }
 * }
 */

public interface Controller {
	String execute(Map<String, Object> model) throws Exception;
}
