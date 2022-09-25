package framework.Demo.pageclass;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.Demo.util.Base;



public class pageClass_script1 extends Base{

	public pageClass_script1(WebDriver driver) {
		super(driver);
		
	}

	private By uploadImage = By.xpath("//p[normalize-space()='Profile Pic']//following::input[@name='file-553']");
	private By setName = By.xpath("//input[@id='g2599-name']");
	private By setEmail = By.xpath("//input[@id='g2599-email']");
	private By setWebsite = By.xpath("//input[@id='g2599-website']");
	private By selectExp = By.xpath("//select[@id='g2599-experienceinyears']");
	private By setComment = By.xpath("//textarea[@id='contact-form-comment-g2599-comment']");
	private By submitButton = By.xpath("//button[normalize-space()='Submit']");
	 
	private By selectExperties;
	private By selectEducation;

	private By verifyName = By.xpath("//div[@id='contact-form-2599']//p[1]");
	private By verifyEmail = By.xpath("//div[@id='contact-form-2599']//p[2]");
	private By verifyWebsite = By.xpath("//div[@id='contact-form-2599']//p[3]");
	private By verifyExp = By.xpath("//div[@id='contact-form-2599']//p[4]");
	private By verifyExpertis = By.xpath("//div[@id='contact-form-2599']//p[5]");
	private By verifyEducation = By.xpath("//div[@id='contact-form-2599']//p[6]");
	private By verifyComments = By.xpath("//div[@id='contact-form-2599']//p[7]");
	private By scrollExp = By.xpath("//label[normalize-space()='Experience (In Years)(required)']");
	private By scrollEducation = By.xpath("//label[normalize-space()='Education']");
	private By banner = By.xpath("(//div[@class='panel-content fade'])[1]");
	
	public void uploadImage() throws InterruptedException, IOException
	{
//		if(isElementDisplayed(banner))
//		{
//			ScrollByJSIndex();
//		}
		Thread.sleep(4000);
		clickAction(uploadImage);
		Runtime.getRuntime().exec("C:\\Users\\ASUS\\Desktop\\TestNG\\uploadImage.exe");
		
	}
	
	public void setName(String name) throws InterruptedException
	{
		Thread.sleep(6000);
		setValue(setName, name);
	}
	
	public void setEmail(String email) throws InterruptedException
	{
		Thread.sleep(1000);
		setValue(setEmail, email);
	}
	
	public void setWebsite(String website) throws InterruptedException
	{
		Thread.sleep(1000);
		setValue(setWebsite, website);
	}
	
	public void setExperience(String exp) throws InterruptedException
	{
		Thread.sleep(1000);
		selectValueFromDropDown(selectExp, exp);
		Thread.sleep(1000);
		ScrollByJS(scrollExp);
	}
	
	public void setExpertise(String experties) throws InterruptedException
	{
		Thread.sleep(2000);
		selectExperties = By.xpath("//input[@value='"+experties+"']");
		clickAction(selectExperties); 
		
	}
	 
	public void setEducation(String education) throws InterruptedException
	{
		Thread.sleep(1000);
		selectEducation = By.xpath("//input[@value='"+education+"']");
		clickAction(selectEducation);
		Thread.sleep(1000);
		ScrollByJS(scrollEducation);
	}
	
	public void setComment(String comments) throws InterruptedException
	{
		Thread.sleep(1000);
		setValue(setComment, comments);
	}
	
	public void submit() throws InterruptedException
	{
		Thread.sleep(2000);
		clickAction(submitButton);
		Thread.sleep(2000);
	}
	
	public void verifyData(String name, String email, String website, String experience, String expertise, String education, String comments) throws InterruptedException
	{
		Thread.sleep(4000);
		String checkName = getText(verifyName);
		if(checkName.contains(name))
		{
			isElementDisplayed(verifyName);
			assertTrue(true, "Name verified");
		}
		String checkEmail = getText(verifyEmail);
		if(checkEmail.contains(email))
		{
			isElementDisplayed(verifyEmail);
			assertTrue(true, "Email verified");
		}
		
		String checkWebsite = getText(verifyWebsite);
		if(checkWebsite.contains(website))
		{
			isElementDisplayed(verifyWebsite);
			assertTrue(true, "Website verified");
		}
		
		String checkExperience = getText(verifyExp);
		if(checkExperience.contains(experience))
		{
			isElementDisplayed(verifyExp);
			assertTrue(true, "Experience verified");
		}
		
		String checkExpertise = getText(verifyExpertis);
		if(checkExpertise.contains(expertise))
		{
			isElementDisplayed(verifyExpertis);
			assertTrue(true, "Expertise verified");
		}
		
		String checkEducation = getText(verifyEducation);
		if(checkEducation.contains(education))
		{
			isElementDisplayed(verifyEducation);
			assertTrue(true, "Education verified");
		}
		String checkComments = getText(verifyComments);
		
		if(checkComments.contains(comments))
		{
			isElementDisplayed(verifyComments);
			assertTrue(true, "Comments verified");
		}
	}
} 
