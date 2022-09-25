package framework.TakeCode;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.TakeCode.pageClass.login_pageObject;
import framework.TakeCode.pageClass.registration_pageObject;
import framework.TakeCode.util.BaseClass;
import framework.TakeCode.util.Listener;
import framework.TakeCode.util.logger;
@Listeners(Listener.class)

public class Registration extends BaseClass {

	

	@BeforeMethod 
	public void Setup() throws IOException 
	{
		driver = IntializedDriver(); 
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	@Test
	public void registration() throws InterruptedException
	{
		
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		
		registration_pageObject object = new registration_pageObject(driver);
		logger.print("Step 1: Launched URL"); 
		
		object.doRegister("Cherry", "Cherry@gmail.com", "123456", "123456");
		logger.print("Step 2: Clicked on SignUp"); 
		logger.print("Step 3: Added Name"); 
		logger.print("Step 4: Added Email"); 
		logger.print("Step 5: Added Password"); 
		logger.print("Step 6: Added Confirm Password"); 
		logger.print("Step 7: Clicked on sign up"); 
		logger.print("Step 8: New user created successfully!"); 
	
	}
}
