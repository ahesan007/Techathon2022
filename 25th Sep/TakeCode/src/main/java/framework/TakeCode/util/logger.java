package framework.TakeCode.util;

import org.testng.Reporter;

public class logger extends BaseClass {

	static String lineSeparator = System.getProperty("line.separator");
	final static String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	
	public static void print(String message) 
	{
		System.setProperty(ESCAPE_PROPERTY, "false");
		Reporter.log("<b>"+message + "</b> <br />");
	}
}


