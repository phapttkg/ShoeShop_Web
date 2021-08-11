package com.coeding.mvc.bind;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ServletRequestDataBinder {

	/**
	 * TODO: 1. find request parameter with dataName 
	 * TODO: 2. create instance of dataType 
	 * 			Primitive(have no member) 
	 * 			Reference(Class has member, setter) 
	 * TODO: 3. set field value from request parameter
	 */
	public static Object bind(HttpServletRequest request, 
			Class<?> dataType, String dataName) {
		if (isPrimitive(dataType)) {
			// no fields
			return createObject(dataType, request.getParameter(dataName));
		}
		//title=thisistitlevalue&name=i'mwriter&content=bulabula
		Set<String> paramNames = request.getParameterMap().keySet();
		// title, name, content
		Object dataObj = null;
		try {
			dataObj = dataType.newInstance();
			// ArticleVO.class
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Method setter = null;
		for(String fieldName : paramNames) {
			// setTitle(value), setName, setContent
			System.out.println(fieldName);
			setter = findSetter(dataType, fieldName);// set{fieldName}
			if( setter != null) {
				// setTitle(String arg)
				try {
					setter.invoke(dataObj, 
							createObject(
									setter.getParameterTypes()[0], 
									request.getParameter(fieldName)
							)
					);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return dataObj;
	}

	private static Method findSetter(Class<?> dataType, String fieldName) {
		// setter is method, set{FieldName}
		Method[] methods = dataType.getMethods();
		String pName = null;
		for(Method m : methods) {
			if( !m.getName().startsWith("set") ) {
				continue;
			}
			// set~~
			pName = m.getName().substring(3);
			if( pName.toLowerCase().equals(fieldName.toLowerCase())) {
				return m;
			}
		}
		return null;
	}

	private static Object createObject(Class<?> dataType, String parameter) {
		// create instance
		// TODO: replace deprecated constructors
		if(dataType.getName().equals("int")  || dataType == Integer.class ) {
			// String -> Integer
			return new Integer(Integer.parseInt(parameter));
		}else if(dataType.getName().equals("long")  || dataType == Long.class) {
			return new Long(parameter);
		}else if(dataType.getName().equals("float")  || dataType == Float.class){
			return new Float(parameter);	
		}else if(dataType.getName().equals("double")  || dataType == Double.class) {
			return new Double(parameter);	
		}else if(dataType.getName().equals("byte")  || dataType == Byte.class) {
			return new Byte(parameter);	
		}else if(dataType.getName().equals("short")  || dataType == Short.class) {
			return new Short(parameter);	
		}else if(dataType.getName().equals("boolean")  || dataType == Boolean.class) {
			return new Boolean(parameter);	
		}else if(dataType == Date.class) {
			return new Date(parameter);
		}else {
			return parameter;
		}
	}

	private static boolean isPrimitive(Class<?> dataType) {
		// has no setter : getMethods() has no setter
		// VO has setter
		if(// Wrapper class
			dataType.getName().equals("int")  || dataType == Integer.class ||
			dataType.getName().equals("long")  || dataType == Long.class ||
			dataType.getName().equals("float")  || dataType == Float.class ||
			dataType.getName().equals("double")  || dataType == Double.class ||
			dataType.getName().equals("byte")  || dataType == Byte.class ||
			dataType.getName().equals("short")  || dataType == Short.class ||
			dataType.getName().equals("char")  || dataType == Character.class ||
			dataType.getName().equals("boolean")  || dataType == Boolean.class ||
			dataType == String.class  ||
			dataType == Date.class
				) {
			return true;
		}
		return false;
	}

}
