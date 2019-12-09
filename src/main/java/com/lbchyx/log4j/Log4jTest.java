package com.lbchyx.log4j;

import org.apache.log4j.*;

/**
 * log4j参考文献
 * https://www.cnblogs.com/ITEagle/archive/2010/04/23/1718365.html
 */
public class Log4jTest {
	static Logger logger = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		logger.info("log --- info");
		logger.debug("log --- debug");
		logger.error("log --- error");
	}



}
