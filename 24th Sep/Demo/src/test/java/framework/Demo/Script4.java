package framework.Demo;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.Demo.pageclass.pageClass_script4;
import framework.Demo.util.BaseClass;
import framework.Demo.util.Listener;
import framework.Demo.util.logger;
@Listeners(Listener.class)

public class Script4 extends BaseClass {

	
	String Name;
	String Phone;
	String Department;
	
	String RecordNameToEdit;
	
	String oldName;
	String oldDepartment;
	String oldPhone;
	
	String newName;
	String newDepartment;
	String newPhone;
	
	JSONObject data;
	
	@BeforeTest
	public void jsonReader() throws IOException, ParseException 
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\framework\\Demo\\util\\script4.json");
		Object obj = null;
		obj = (JSONObject) jsonParser.parse(reader);
		JSONObject usersList = (JSONObject) obj;
		data = (JSONObject) usersList.get("testData");	  
	} 
	
	@BeforeMethod 
	public void Setup() throws IOException 
	{
		driver = IntializedDriver(); 
		driver.get(prop.getProperty("script4"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	@Test
	public void AddEmployeeDetails() throws InterruptedException
	{
		logger.print("Step 1: Launched URL");
		Name = (String) data.get("Name");
		Department = (String) data.get("Department");
		Phone = (String) data.get("Phone");

		RecordNameToEdit = (String) data.get("RecordNameToEdit");
		
		oldName = (String) data.get("oldName");
		oldDepartment = (String) data.get("oldDepartment");
		oldPhone = (String) data.get("oldPhone");
		
		newName = (String) data.get("newName");
		newDepartment = (String) data.get("newDepartment");
		newPhone = (String) data.get("newPhone");
		
		pageClass_script4 object = new pageClass_script4(driver);
		
		object.addNew();
		logger.print("Step 2: Clicked on Add new record");
		object.setName(Name);
		logger.print("Step 3: Added Name");
		object.setDepartment(Department);
		logger.print("Step 4: Added Department");
		object.setPhone(Phone);
		logger.print("Step 5: Added Phone number");
		object.addButton();  
		logger.print("Step 6: New record added successfully");
		 
		object.editDetailsButton(RecordNameToEdit);
		logger.print("Step 7: Identfied existing record and Clicked on edit");
		object.editName(oldName,newName);
		logger.print("Step 8: Name edited");
		object.editDepartment(oldDepartment,newDepartment);
		logger.print("Step 9: Department edited");
		object.editPhone(oldPhone,newPhone);
		logger.print("Step 10: Phone number edited");
		object.saveNewDetails(oldPhone); 
		logger.print("Step 11: Clicked on update record, record updated!");
		object.deleteRecord(Phone); 
		logger.print("Step 12: Identified exisitng record and deleted. ");
		logger.print("*Data extracted from JSON file*");
		
		
	}
	
	
}
