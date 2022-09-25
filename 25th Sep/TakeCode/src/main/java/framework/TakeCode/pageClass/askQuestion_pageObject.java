package framework.TakeCode.pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import framework.TakeCode.util.Base;

public class askQuestion_pageObject extends Base{

	public askQuestion_pageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By addQuestion = By.xpath("//a[normalize-space()='Ask Question']");
	private By login = By.xpath("//a[normalize-space()='Log in']");
	private By logInButton = By.xpath("//button[normalize-space()='Log in']");
	private By setUsername = By.xpath("//input[@name='username']");
	private By setPassword = By.xpath("//input[@name='password']");
	private By setTitle = By.xpath("//input[@name='title']");
	private By setBody = By.xpath("//textarea[@name='text']");
	private By setTag = By.xpath("//input[@placeholder='Add a tag']");
	private By Reviewyourquestion = By.xpath("//button[normalize-space()='Review your question']");
	
	
	public void doLogin(String user, String pass) throws InterruptedException
	{
		Thread.sleep(2000);
		clickAction(logInButton);
		
		setValue(setUsername, user);
		setValue(setPassword, pass);
		Thread.sleep(3000);
		clickAction(logInButton);	
	}
	public void clickOnAddQuestion() throws InterruptedException
	{
		Thread.sleep(2000);
		clickAction(addQuestion);
		Thread.sleep(1000);
		clickAction(login);
	}
	
	public void addQue(String title, String body, String tag) throws InterruptedException
	{
		Thread.sleep(2000);
		clickAction(addQuestion);
		Thread.sleep(1000);
		setValue(setTitle,title);
		Thread.sleep(1000);
		setValue(setBody,body);
		Thread.sleep(1000);
		setValue(setTag,tag);
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
//		clickAction(Reviewyourquestion);
	}
}
