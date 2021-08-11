package com.coeding.mvc.bind;

/**
 * Controller
 * 	know what need
 * @author Administrator
 *
 */
public interface DataBinding {
//	Map<String,Object> getDataBinders();
	
	/**
	 * 
	 * @return	{	"dataName", type of data,
	 * 				"dataName", type of data,
	 * 				...
	 * 			}
	 * 	like {key:value}
	 */
	Object[] getDataBinders();
}
