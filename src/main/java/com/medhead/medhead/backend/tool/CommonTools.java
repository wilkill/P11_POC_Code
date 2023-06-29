package com.medhead.medhead.backend.tool;

public enum CommonTools {

	/**
	 * Tag for the singleton
	 */
	INSTANCE;
	
	
	/**
	 * 
	 * Method : to get the real class name
	 * 
	 * @param _class
	 * @return String
	 */
	public String getClassName(Class<?> _class) {
		return _class.getName().substring(_class.getName().lastIndexOf(".") + 1);
	}
	
	
}
