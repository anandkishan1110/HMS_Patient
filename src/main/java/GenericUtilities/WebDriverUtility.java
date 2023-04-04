package GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 * @author kishan
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used for wait for page load
	 * @param driver
	 * @author kishan
	 */
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait until element to be visisble
	 * @param driver
	 * @param element
	 * @author kishan
	 */
	public void elementTobeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	
	/**
	 * This method is used to select data from dropdown using value
	 * @param element
	 * @param value
	 * @author kishan
	 */
	public void select(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select data from dropdown using index
	 * @param element
	 * @param index
	 * @author kishan
	 */
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	
	/**
	 * This method is used to select data from dropdown using visible text
	 * @param visibleText
	 * @param element
	 * @author kishan
	 */
	public void select(String visibleText,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	
	/**
	 * This method is used to perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	
	/**
	 * This method is used to drag and drop the element
	 * @param driver
	 * @param src
	 * @param dst
	 * @author kishan
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst);   
	}
	
	/**
	 * This used to double click 
	 * @param driver
	 * @author kishan
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * This method is used for right click on webpage
	 * @param driver
	 * @author kishan
	 */
	public void rightClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method is used for right click on element
	 * @param driver
	 * @param element
	 * @author kishan
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method is used for enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will press enter key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver)throws Throwable
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		
		
	}
	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws Throwable
	 */
	
	public void enterRelease(WebDriver driver)throws Throwable
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to switch the frame based on index
	 * @param driver
	 * @param index
	 * @author kishan
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used accept alert popup
	 * @param driver
	 * @author kishan
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public String getTextAlert(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * This method is used to dismiss alert popup
	 * @param driver
	 * @author kishan
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver,String partialTitle)
	{
		//Step 1:use getWindowHandles to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//Step 2:iterator through the windows
		Iterator<String> it = windows.iterator();
		
		//step 3:check weather there is next window
		while(it.hasNext())
		{
			//step 4:capture current window id
			String winId=it.next();
			
			//step 5:Switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step 6:check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This method is used to take screen sshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenShotName+".png";
		File dst=new File(path);
		FileUtils.copyFile(src, dst);
		return path;
	}
	
	/**
	 * This method is used to perform random scroll
	 * @param driver
	 * @author kishan
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,800)","");
	}
	
	/**
	 * This method will help to scroll until element is found
	 * @param driver
	 * @param element
	 * @author kishan
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor j=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
	    j.executeScript("window.scrollBy(0,"+y+")", element);
		
	}
	public void notifications()
	{
                ChromeOptions cp = new ChromeOptions();
		      cp.addArguments("---handled--");
	 }
}
