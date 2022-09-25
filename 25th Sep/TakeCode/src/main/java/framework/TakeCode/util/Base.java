package framework.TakeCode.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    protected WebDriver driver;
    WebDriverWait wait;
    
    public Base(WebDriver driver) {
    	this.driver = driver;
    	wait = new WebDriverWait(driver, Duration.ofSeconds(17));
	}
	
	public WebElement getElement(By by) {
		return driver.findElement(by);
	}
	
	public List<WebElement> getElements(By by) {
		return driver.findElements(by);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl(); 
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void setValue(By by, String value) {
		
		WebElement element = waitVisibilityOfElement(by);
		element.clear();
		element.sendKeys(value);;
	}
	
	
	public void clickWithFluentWait(final By by) {
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofSeconds(5))
		        .ignoring(NoSuchElementException.class);
		

		WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(by);
		     }
		   });
		element.click();
	}
	
	public void click(By by) {
		
		waitVisibilityOfElement(by).click();
	}
	
	public void hoverAction(By by) {
	    	
	    	waitVisibilityOfElement(by);
	    	Actions act= new Actions(driver);
			
			act.moveToElement(driver.findElement(by)).build().perform();
	    	
	    }
	public void clickAction(By by) { 
	    	
	    	waitVisibilityOfElement(by);
	    	Actions act= new Actions(driver);
	   
	    	act.moveToElement(driver.findElement(by)).click().build().perform();
	    	
	    }
	public void tabAction() { 
		
		
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.ENTER);
		
	}
		
	
	public boolean elementToBeClick(By by) {
	
		return wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
	}
	public void switchToAlert(WebDriver driver, String note) {

		driver.switchTo().alert().sendKeys(note);
	}
	
	public void selectValueFromDropDown(By by, String value) {
		
		WebElement element = waitVisibilityOfElement(by);
		
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public void deSelectValueFromDropDown(By by, String value) {
		
		WebElement element = waitVisibilityOfElement(by);
		
		Select select = new Select(element);
		select.deselectByVisibleText(value);
	}
	
	public void checkCheckBoxOrRadio(By by, boolean check) {
		
		WebElement element = waitVisibilityOfElement(by);
		if (check) {
			if (!element.isSelected()) {
				element.click();
			}
		}
		else {
			if (element.isSelected()) {
				element.click();
			}
		} 
	}
	
	public String getText(By by) {
		return waitVisibilityOfElement(by).getText();
	}
	public String getTextFromInputField(By by) {
		
		WebElement element = driver.findElement(by);
		String textValue = element.getAttribute("value");
		return textValue;
	}
	
	
	public boolean isElementDisplayed(By by) {
		 
			 try {
				return waitVisibilityOfElement(by).isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

			
	}
	
	public boolean isEnabled(By by) {
		return waitVisibilityOfElement(by).isEnabled();
	}

	
	public boolean isSelected(By by) {
		return waitVisibilityOfElement(by).isSelected();
	}
	
	public String getCurrentTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}
	
	public WebElement waitVisibilityOfElement(By by) {
		
        WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        highLightElement(driver, element); 
        return element; 
    }
	
	public void highLightElement(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
	}
	
	public void waitForElementNotVisible(By by) {
		if (isElementDisplayed(by)) {
	        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(by)));
	    }
	}

	public void waitForPageLoad() {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(
				new Function<WebDriver, Object>() {
					public Object apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
					}
				}); 
	}

	public static ExpectedCondition<Boolean> waitForAjaxCalls() {
		return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
            }
       };   
	 }
	
	public void clickJS(By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void ScrollByJS(By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("return arguments[0].scrollIntoView();",element);
	}
	public void ScrollByJSIndex() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,50)", "");
	}
	
	public void SwitchTabByIndex(int index)
	{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(index));
	}
	public void openNewTab()
	{
		((JavascriptExecutor) driver).executeScript("window.open()");
	}
	
	public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
		String cHandle = driver.getWindowHandle();
	    String newWindowHandle = null;
	    Set<String> allWindowHandles = driver.getWindowHandles();

	    //Wait for 20 seconds for the new window and throw exception if not found
	    for (int i = 0; i < 20; i++) 
	    {
	        if (allWindowHandles.size() > 1) 
	        {
	            for (String allHandlers : allWindowHandles)
	            {
	                if (!allHandlers.equals(cHandle))
	                	newWindowHandle = allHandlers;
	            }
	            driver.switchTo().window(newWindowHandle);
	            break;
	        } 
	        else  
	        {
	            Thread.sleep(1000);
	        }
	    }
	    if (cHandle == newWindowHandle) 
	    {
	        throw new RuntimeException(
	                "Time out - No window found");
	    }
	}
		
}

