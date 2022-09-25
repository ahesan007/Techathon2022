package framework.TakeCode;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.TakeCode.pageClass.login_pageObject;
import framework.TakeCode.util.BaseClass;
import framework.TakeCode.util.Listener;
import framework.TakeCode.util.logger;
@Listeners(Listener.class)


public class Admin_Login extends BaseClass {

	

	@BeforeMethod 
	public void Setup() throws IOException 
	{
		driver = IntializedDriver(); 
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	@Test
	public void Moderator_login() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().refresh();  
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();  
		driver.navigate().refresh();
		driver.navigate().refresh();
		
		logger.print("Step 1: Launched URL"); 
		login_pageObject object = new login_pageObject(driver);
		
		object.doLogin("moderator", "admin1234");
		logger.print("Step 2: Clicked on Login button"); 
		logger.print("Step 3: Set Username and password"); 
		object.verifyNameAfterLogin("moderator");
		logger.print("Step 4: Verified Moderator after login"); 
	}
}
