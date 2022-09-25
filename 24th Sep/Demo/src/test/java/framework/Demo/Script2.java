package framework.Demo;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.Demo.pageclass.pageClass_script2;
import framework.Demo.util.BaseClass;
import framework.Demo.util.Listener;
import framework.Demo.util.logger;
@Listeners(Listener.class)
public class Script2 extends BaseClass{

	String selectedFromDate;
	String selectedToDate;
	String TodayDate;
	
	@BeforeMethod 
	public void Setup() throws IOException 
	{
		driver = IntializedDriver(); 
		driver.get(prop.getProperty("script2"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	@Test
	public void DatePicker() throws InterruptedException
	{ 
		logger.print("Step 1: Launched URL");
		pageClass_script2 object =new pageClass_script2(driver);
		
		object.today();
		TodayDate = object.day;
		logger.print("Step 2: Today's date is: "+TodayDate);
		
		object.selectFromDate(); 
		selectedFromDate = object.finalFromDate;
		System.out.println("Selected From Date: "+selectedFromDate);
		logger.print("Step 3: Selected TodayDate + 4 days, as From Date: "+selectedFromDate );
		object.selectToDate();
		selectedToDate = object.finalToDate;
		logger.print("Step 4: Selected FromDate + 5 days, as TO Date: "+selectedToDate );
		
	}
}
