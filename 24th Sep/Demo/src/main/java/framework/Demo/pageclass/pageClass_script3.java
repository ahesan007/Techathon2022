package framework.Demo.pageclass;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Demo.util.Base;

public class pageClass_script3 extends Base{

	public pageClass_script3(WebDriver driver) {
		super(driver);
		
	}

	private By iFrameTab = By.xpath("//li[@id='iFrame']");
	
	private By clickImage = By.xpath("//img[@alt='Selenium Online Training']");
	
	private By seleniumTitle = By.xpath("//h1[normalize-space()='Selenium 3.0 Training']");
	
	private WebElement switchGlobalTab = driver.findElement(By.xpath("//iframe[@name='globalSqa']"));
	public static String title;
	
	public void iFrameTab() throws InterruptedException
	{
		Thread.sleep(2000);
		clickAction(iFrameTab);
		Thread.sleep(1000);
		driver.switchTo().frame(switchGlobalTab);
		Thread.sleep(3000);
		clickJS(clickImage); 
		
		
	} 
	
	public String openSeleniumTitle()
	{
		if(isElementDisplayed(seleniumTitle))
		{
			 title = getText(seleniumTitle);
			assertEquals(title, "Selenium 3.0 Training");
		}
		return title;
	}
} 
