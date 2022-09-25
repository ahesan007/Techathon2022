package framework.TakeCode;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.TakeCode.pageClass.askQuestion_pageObject;
import framework.TakeCode.pageClass.login_pageObject;
import framework.TakeCode.util.BaseClass;
import framework.TakeCode.util.Listener;
import framework.TakeCode.util.logger;
@Listeners(Listener.class)


public class Ask_Question extends BaseClass {

	

	@BeforeMethod 
	public void Setup() throws IOException 
	{
		driver = IntializedDriver(); 
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	@Test
	public void AskQuestion() throws InterruptedException
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
		
		askQuestion_pageObject question = new askQuestion_pageObject(driver);
		
		question.clickOnAddQuestion();
		logger.print("Step 1: Clicked on Ask Question"); 
		question.doLogin("ali", "123456");
		logger.print("Step 2: Do login"); 
		question.addQue("Test title test test test test", "test test test testtest test test testtest test test testtest"
				+ " test test testtest test test testtest test test testtest test test testtest test test test","Java");
		logger.print("Step 3: Again clicked on Ask Question"); 
		logger.print("Step 4: Added Title"); 
		logger.print("Step 5: Added Body"); 
		logger.print("Step 6: Added Tag"); 
		logger.print("Step 7: QUestion added successfully!"); 
	
	}
} 
