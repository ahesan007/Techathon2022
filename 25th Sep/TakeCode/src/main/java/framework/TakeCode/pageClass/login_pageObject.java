package framework.TakeCode.pageClass;


import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.TakeCode.util.Base;

public class login_pageObject extends Base{

	public login_pageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By logInButton = By.xpath("//button[normalize-space()='Log in']");
	private By setUsername = By.xpath("//input[@name='username']");
	private By setPassword = By.xpath("//input[@name='password']");
	private By logInButton2 = By.xpath("(//button[normalize-space()='Log in'])[2]");
	private By logoutButton = By.xpath("//button[normalize-space()='log out']");
	private By verifyName;
	
	public void doLogin(String user, String pass) throws InterruptedException
	{
		Thread.sleep(2000);
		clickAction(logInButton);
		
		setValue(setUsername, user);
		setValue(setPassword, pass);
		Thread.sleep(1000);
		clickAction(logInButton2);	
	}
	
	public void verifyNameAfterLogin(String user)
	{
		verifyName = By.xpath("//span[normalize-space()='"+user+"!']");
		
		if(isElementDisplayed(verifyName))
		{
			assertTrue(true, "UserName is worng...");
		}
		else
		{
			assertFalse(true, "UserName is worng...");
		}
	}  
	
	public void logout() throws InterruptedException
	{
		Thread.sleep(2000);
		clickAction(logoutButton);
	}
}
