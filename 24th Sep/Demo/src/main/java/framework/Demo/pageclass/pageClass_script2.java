package framework.Demo.pageclass;



import static org.testng.Assert.assertFalse;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Demo.util.Base;

public class pageClass_script2 extends Base{

	public pageClass_script2(WebDriver driver) {
		super(driver);
		
	}

	private By selectMonth = By.xpath("//select[@aria-label='Select month']");
	private By inputFromdate = By.xpath("//input[@id='from']");
	private By inputTodate = By.xpath("//input[@id='to']");
	private WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	String month;
	public static String day;
	public static String finalFromDate;
	public static String finalToDate;
	private By selectDate; 
	
	
	public  String today()
	{
		 LocalDate today = LocalDate.now();
		 day = Integer.toString(today.getDayOfMonth());
		 return day ;
	} 
	
	public String selectFromDate() throws InterruptedException
	{
		
		LocalDate today = LocalDate.now();
		
		 LocalDate dayplus = today.plusDays(4);
		  
		 int monthInt = dayplus.getMonthValue();
		   
		  if(monthInt == 9) {
			  month = "Sep";
		  }
		  else if(monthInt == 10) {
			  month = "Oct";
		  }
		  else if(monthInt == 11) {
			  month = "Nov";
		  }
		  else if(monthInt == 12) {
			  month = "Dec";	  
		  }
		  else
		  {
			  assertFalse(true);
		  }
		  
		  
		int day = dayplus.getDayOfMonth();
	
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		clickAction(inputFromdate);
		Thread.sleep(2000); 
		selectValueFromDropDown(selectMonth, month);
		Thread.sleep(3000);
		selectDate = By.xpath("(//table[@class='ui-datepicker-calendar']//a[@data-date='"+day+"'])[1]");
		
		if(isElementDisplayed(selectDate))
		{
			Thread.sleep(2000);
			clickJS(selectDate);
		}
		
		finalFromDate = getTextFromInputField(inputFromdate);
		return finalFromDate;
		
	}
	
	
	public String selectToDate() throws InterruptedException
	{
		LocalDate today = LocalDate.now();
		
		 LocalDate dayplus = today.plusDays(9);
		
		 int monthInt = dayplus.getMonthValue();
		  
		  if(monthInt == 9) {
			  month = "Sep";
		  }
		  else if(monthInt == 10) {
			  month = "Oct";
		  }
		  else if(monthInt == 11) {
			  month = "Nov";
		  }
		  else if(monthInt == 12) {
			  month = "Dec";	  
		  }
		  else
		  {
			  assertFalse(true);
		  }
		  
		int day = dayplus.getDayOfMonth();
		
		Thread.sleep(2000);
		clickAction(inputTodate);
		
		Thread.sleep(2000); 
		selectValueFromDropDown(selectMonth, month);
		Thread.sleep(3000);
		selectDate = By.xpath("(//table[@class='ui-datepicker-calendar']//a[@data-date='"+day+"'])[1]");
		
		if(isElementDisplayed(selectDate))
		{
			Thread.sleep(2000);  
			clickJS(selectDate);
		}
		
		finalToDate = getTextFromInputField(inputTodate);
		return finalToDate;
	}
} 
