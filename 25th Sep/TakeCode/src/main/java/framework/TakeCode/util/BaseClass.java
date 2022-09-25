package framework.TakeCode.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public static WebDriver driver;
	public Properties prop;
	public String serviceName;
	public String Dates;
	public String DealerName;
	
	public WebDriver IntializedDriver() throws IOException {
		prop = new Properties();
		String PropPath = System.getProperty("user.dir")+"\\src\\main\\java\\framework\\TakeCode\\util\\URL.properties";
		FileInputStream fis = new FileInputStream(PropPath);
		prop.load(fis);
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		driver.manage().window().maximize(); 

		return driver;
	}
	


//	@AfterMethod
//	public void teardown() 
//	{
//		driver.close(); 
//		driver.quit();
//	}
	
	
}
