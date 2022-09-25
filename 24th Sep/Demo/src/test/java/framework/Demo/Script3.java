package framework.Demo;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.Demo.pageclass.pageClass_script3;
import framework.Demo.util.BaseClass;
import framework.Demo.util.Listener;
import framework.Demo.util.logger;
@Listeners(Listener.class)
public class Script3 extends BaseClass {

	String Title;
	
	@BeforeMethod 
	public void Setup() throws IOException 
	{
		driver = IntializedDriver(); 
		driver.get(prop.getProperty("script3"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	 
	@Test
	public void iFrames() throws InterruptedException
	{
		logger.print("Step 1: Launched URL");
		pageClass_script3 object = new pageClass_script3(driver);
		
		object.iFrameTab();
		logger.print("Step 2: Clicked on iFrame Tab");
		object.openSeleniumTitle();
		logger.print("Step 3: Clicked on Selenium Online Training");
		Title = object.title;
		logger.print("Step 4: Verified title: "+Title);
		
	} 
}
