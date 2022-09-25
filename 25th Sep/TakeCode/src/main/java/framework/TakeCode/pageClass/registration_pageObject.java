package framework.TakeCode.pageClass;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.TakeCode.util.Base;

public class registration_pageObject extends Base {

	public registration_pageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By SignUpButton = By.xpath("//button[normalize-space()='Sign up']");
	private By setUsername = By.xpath("//input[@name='username']");
	private By setEmail = By.xpath("//input[@name='email']");
	private By setPassword = By.xpath("//input[@name='password']");
	private By setConfirmPass = By.xpath("//input[@name='passwordConfirmation']");
	private By  SignUpButton2 = By.xpath("(//button[normalize-space()='Sign up'])[2]");
	private By  verifyName = By.xpath("//div[@class='header_userInfo__3FIdZ']");
	
	
	public void doRegister(String name, String email, String pass, String confirmPass) throws InterruptedException
	{
		Thread.sleep(2000);
		
		clickAction(SignUpButton);
		Thread.sleep(1000);
		setValue(setUsername, name);
		Thread.sleep(1000);
		setValue(setEmail, email);
		Thread.sleep(1000);
		setValue(setPassword,pass);
		Thread.sleep(1000);
		setValue(setConfirmPass, confirmPass);
		Thread.sleep(1000);
		clickAction(SignUpButton2);
		Thread.sleep(1000);
		
		isElementDisplayed(verifyName);
		
	}
	
}
