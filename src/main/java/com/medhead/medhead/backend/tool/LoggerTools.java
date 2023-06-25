package com.medhead.medhead.backend.tool;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum LoggerTools {

	/**
	 * Tag for the singleton
	 */
	INSTANCE;


	/**
	 * Tag for the string concatenation
	 */
	private StringBuffer _SB = new StringBuffer();


	/**
	 * Tag for the string WebAppName
	 */
	private String _webAppName ="";


	/**
	 * Method Init WebAppName for logger
	 * 
	 * @param webAppName
	 * @return 
	 */
	public void init(String webAppName) {
		_webAppName = webAppName;
		logInfo(LoggerTools.class.getName(),"Init LoggerTools");
	}

	/**
	 * Method to add log on INFO level
	 * 
	 * @param className
	 * @param msg
	 */
	public void logInfo(String className, String msg) {
		// tag for the class name logger
		String loggerName = "none";

		if (className.endsWith("Controller"))
			loggerName = "Controller";
		else if (className.endsWith("Repository"))
			loggerName = "Repository";
		else if (className.endsWith("Tools"))
			loggerName = "Tools";
		else if (className.endsWith("Api"))
			loggerName = "Api";
		else
			loggerName = "Common";

		Logger logger = LoggerFactory.getLogger(loggerName);

		this._SB.delete(0, this._SB.length());
		this._SB.append("[");
		this._SB.append(_webAppName);
		this._SB.append("] - [");
		this._SB.append(className);
		this._SB.append("] - ");
		this._SB.append(msg);
		this._SB.append(" - line:");
		this._SB.append(Thread.currentThread().getStackTrace()[2].getLineNumber());

		// we trace the line
		logger.info(this._SB.toString());

	}


	/**
	 * Method to add log on WARN level
	 * 
	 * @param className
	 * @param msg
	 */
	public void logWarn(String className, String msg) {
		// tag for the class name logger
		String loggerName = "none";

		if (className.endsWith("Controller"))
			loggerName = "Controller";
		else if (className.endsWith("Repository"))
			loggerName = "Repository";
		else if (className.endsWith("Tools"))
			loggerName = "Tools";
		else if (className.endsWith("Api"))
			loggerName = "Api";
		else
			loggerName = "Common";

		Logger logger = LoggerFactory.getLogger(loggerName);

		this._SB.delete(0, this._SB.length());
		this._SB.append("[");
		this._SB.append(_webAppName);
		this._SB.append("] - [");
		this._SB.append(className);
		this._SB.append("] - ");
		this._SB.append(msg);
		this._SB.append(" - line:");
		this._SB.append(Thread.currentThread().getStackTrace()[2].getLineNumber());

		// we trace the line
		logger.warn(this._SB.toString());

	}

	/**
	 * Method to add log on ERROR level
	 * 
	 * @param className
	 * @param msg
	 */
	public void logError(String className, String msg) {
		// tag for the class name logger
		String loggerName = "none";

		if (className.endsWith("Controller"))
			loggerName = "Controller";
		else if (className.endsWith("Repository"))
			loggerName = "Repository";
		else if (className.endsWith("Tools"))
			loggerName = "Tools";
		else if (className.endsWith("Api"))
			loggerName = "Api";
		else
			loggerName = "Common";

		Logger logger = LoggerFactory.getLogger(loggerName);

		this._SB.delete(0, this._SB.length());
		this._SB.append("[");
		this._SB.append(_webAppName);
		this._SB.append("] - [");
		this._SB.append(className);
		this._SB.append("] - ");
		this._SB.append(msg);
		this._SB.append(" - line:");
		this._SB.append(Thread.currentThread().getStackTrace()[2].getLineNumber());

		// we trace the line
		logger.error(this._SB.toString());

	}

	/**
	 * Method to add log on DEBUG level
	 * 
	 * @param className
	 * @param msg
	 */
	public void logdebug(String className, String msg) {
		// tag for the class name logger
		String loggerName = "none";

		if (className.endsWith("Controller"))
			loggerName = "Controller";
		else if (className.endsWith("Repository"))
			loggerName = "Repository";
		else if (className.endsWith("Tools"))
			loggerName = "Tools";
		else if (className.endsWith("Api"))
			loggerName = "Api";
		else
			loggerName = "Common";

		Logger logger = LoggerFactory.getLogger(loggerName);

		this._SB.delete(0, this._SB.length());
		this._SB.append("[");
		this._SB.append(_webAppName);
		this._SB.append("] - [");
		this._SB.append(className);
		this._SB.append("] - ");
		this._SB.append(msg);
		this._SB.append(" - line:");
		this._SB.append(Thread.currentThread().getStackTrace()[2].getLineNumber());

		// we trace the line
		logger.debug(this._SB.toString());

	}

}
