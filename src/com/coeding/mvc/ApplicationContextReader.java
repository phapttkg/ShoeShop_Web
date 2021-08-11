package com.coeding.mvc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.reflections.Reflections;// for Annotation by google 

import com.coeding.mvc.annotation.Component;

/**
 * 
 * 1. read "application-context.properties"
 * 2. create instances
 * 3. save object
 * 		Map<String,Object>
 *  
 * @author Administrator
 *
 */
public class ApplicationContextReader {
	HashMap<String,Object> objTable;
	
	public ApplicationContextReader(String filepath) {
		System.out.println("ApplicationContextReader from "+filepath);
		 objTable = new  HashMap<String, Object>();
		 // key=value
		Properties props = new Properties();
		try {
			props.load( new FileReader(filepath) );
			prepareObjects(props);
			prepareAnntationObjects();//@Component
			injectDependencySetter();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void prepareAnntationObjects() {
		Reflections reflector = new Reflections("com.coeding.mvc");
		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Component.class);
		for(Class<?> clazz : list) {
			String key = clazz.getAnnotation(Component.class).value();
			try {
				objTable.put(key, clazz.getConstructor(null).newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(key + " <--" + objTable.get(key));
		}
	}

	private void injectDependencySetter() {
		for(String key : objTable.keySet()) {
			if( key.startsWith("jndi.") ) {
				// DataSource has no setter, 
			}else {
				callSetter(objTable.get(key));
			}
		}
		
	}

	private void callSetter(Object object) {
		// find setter
		Object dependency = null;
		for(Method method : object.getClass().getMethods() ) {
			if(method.getName().startsWith("set")) {
				// all setter for field, then has one parameter
				dependency = findObject(method.getParameterTypes()[0]);
				if( dependency != null ) {
					// .setDataSource(ds);
					try {
						method.invoke(object, dependency);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private Object findObject(Class<?> class1) {
		for(Object object : objTable.values()) {
			// class1 is method.getParameterTypes()[0]
			if(class1.isInstance(object)) {
				return object;// send to setter
			}
		}
		return null;
	}

	private void prepareObjects(Properties props) {
		try {
			Context ctx = new InitialContext();
			
			for(Object item : props.keySet()) {
				String key = (String)item;
				String value = props.getProperty(key);
				if(key.startsWith("jndi.")) {
					objTable.put(key, ctx.lookup(value));
				}else {
					// create instance with String class name
					// package.className
					try {
						objTable.put(key, 
								Class.forName(value).newInstance());
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				System.out.println(key + " <--" + objTable.get(key));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}//JNDI for DBCP
		
	}

	public Object getBean(String key) {
		// <String,Object>
		// bean is object managed by framework
		return objTable.get(key);
	}

}











