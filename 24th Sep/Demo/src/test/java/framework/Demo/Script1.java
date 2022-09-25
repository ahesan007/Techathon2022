package framework.Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.Demo.pageclass.pageClass_script1;
import framework.Demo.util.BaseClass;
import framework.Demo.util.Listener;
import framework.Demo.util.ReadingExcel;
import framework.Demo.util.logger;
@Listeners(Listener.class)

public class Script1 extends BaseClass {

	
	Sheet sheet;
	ReadingExcel ReadingExcel;
	String Name;
	String Email;
	String Website;
	String Experience;
	String Expertise;
	String Education;
	String Comments;
	       
	
	@BeforeTest
	public void excelReader() throws IOException  {

		ReadingExcel = new ReadingExcel();
	    ReadingExcel.ReadingExcelforScript1();
	    sheet = ReadingExcel.workbook.getSheetAt(0);
	  
	} 
	

	@BeforeMethod 
	public void Setup() throws IOException 
	{
		driver = IntializedDriver(); 
		driver.get(prop.getProperty("script1"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
 
	@Test    
	public void  Form() throws IOException, InterruptedException
	{
		 
		Name =ReadingExcel.getCellValue(sheet, 1, 0);
		Email =ReadingExcel.getCellValue(sheet, 1, 1);
		Website =ReadingExcel.getCellValue(sheet, 1, 2);
		Experience =ReadingExcel.getCellValue(sheet, 1, 3);
		Expertise =ReadingExcel.getCellValue(sheet, 1, 4);
		Education =ReadingExcel.getCellValue(sheet, 1, 5);
		Comments =ReadingExcel.getCellValue(sheet, 1, 6);
		
		pageClass_script1 pageClass = new pageClass_script1(driver);
		
		logger.print("Step 1: Launched URL"); 
		//upload image code is working but it will not work in other system
//		pageClass.uploadImage(); 
//		logger.print("Step 2: Select Image from system");
//		logger.print("Step 3: Image uploaded successfully");
		pageClass.setName(Name);
		logger.print("Step 2: Added Name");
		pageClass.setEmail(Email);
		logger.print("Step 3: Added Email");
		pageClass.setWebsite(Website); 
		logger.print("Step 4: Added Website");
		pageClass.setExperience(Experience); 
		logger.print("Step 5: Added Experience");
		pageClass.setExpertise(Expertise);
		logger.print("Step 6: Added Expertise");  
		pageClass.setEducation(Education);
		logger.print("Step 7: Added Education");
		pageClass.setComment(Comments);
		logger.print("Step 8: Added Comment");
		pageClass.submit();
		logger.print("Step 9: Clicked on submit");
		pageClass.verifyData(Name, Email,Website,Experience,Expertise,Education,Comments);
		logger.print("Step 10: Verified all the submitted details");
		logger.print("*Data extracted from excel file*");
		
	} 
	
	
	
}   
