package framework.Demo.pageclass;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Demo.util.Base;

public class pageClass_script4 extends Base{

	public pageClass_script4(WebDriver driver) {
		super(driver);
		
	}
	
	
	private WebElement switchGlobalTab = driver.findElement(By.xpath("//iframe[@id='previewiframe']"));
	private By addNewButton = By.xpath("//h2[normalize-space()='Employee Details']//following::button");
	private By setName = By.xpath("//input[@id='name']");
	private By setDepartment = By.xpath("//input[@id='department']");
	private By setPhone = By.xpath("//input[@id='phone']");
	private By addButton = By.xpath("//input[@id='phone']//following::a[1]");
	private By editRecordButton; 
	private By editName; 
	private By editDepartment; 
	private By editPhone;  
	private By saveEdit;  
	private By delete;  
	
	public void addNew() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.switchTo().frame(switchGlobalTab);
		Thread.sleep(2000);
		clickAction(addNewButton);
	}
	
	public void setName(String name) throws InterruptedException
	{
		Thread.sleep(1000);
		setValue(setName, name);
	}
	
	public void setPhone(String phone) throws InterruptedException
	{
		Thread.sleep(1000);
		setValue(setPhone, phone);
	}
	
	public void setDepartment(String department) throws InterruptedException
	{
		Thread.sleep(1000);
		setValue(setDepartment, department);
	}
	
	public void addButton() throws InterruptedException
	{
		Thread.sleep(1000); 
		clickJS(addButton);
	}
	
	public void editDetailsButton(String NameToEdit) throws InterruptedException
	{
		Thread.sleep(2000); 
		editRecordButton = By.xpath("//td[normalize-space()='"+NameToEdit+"']//following::a[@class='edit'][1]");
		clickJS(editRecordButton);
	}
	
	public void editName(String oldName, String newName) throws InterruptedException
	{
		Thread.sleep(1000);
		editName = By.xpath("//input[@value='"+oldName+"']");
		setValue(editName, newName);
	}
	
	public void editDepartment(String oldDepartment, String newDepartment) throws InterruptedException
	{
		Thread.sleep(1000);
		editDepartment = By.xpath("//input[@value='"+oldDepartment+"']");
		setValue(editDepartment, newDepartment);
	}
	
	public void editPhone(String oldPhone, String newPhone) throws InterruptedException
	{
		Thread.sleep(1000);
		editPhone = By.xpath("//input[@value='"+oldPhone+"']");
		setValue(editPhone, newPhone);
	} 
	
	public void saveNewDetails(String oldPhone) throws InterruptedException
	{
		Thread.sleep(1000);
		saveEdit = By.xpath("//input[@value='"+oldPhone+"']//following::a[1]");
		clickJS(saveEdit);
	} 
	
	public void deleteRecord(String firstPhone) throws InterruptedException
	{
		Thread.sleep(2000);
		delete = By.xpath("//td[normalize-space()='"+firstPhone+"']//following::a[3]");
		clickJS(delete);
	} 
} 
