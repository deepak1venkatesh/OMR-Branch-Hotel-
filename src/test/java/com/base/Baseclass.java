package com.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/** 
 * @author Deepak Venkatesh PS
 * @date 22/03/2023
 * @see Used to maintain the reusable methods
 */
public class Baseclass 
{	
	public static WebDriver driver;
	static Actions actions;
	static Select select;
	static JavascriptExecutor executor;
	
	/**
	 * @return String
	 * @See used to get the project path
	 */
	public static String getprojectpath()
	{
		String path=System.getProperty("user.dir");
		return path;
	}
	
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see Used to Get the Property File Value
	 */
	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException
	{	
		Properties properties=new Properties();
		properties.load(new FileInputStream("C:\\Users\\Admin\\Desktop\\eclipse\\OMRBranchHotelAutomation\\config\\config.properties"));
		Object object=properties.get(key);
		String value=(String) object;
		return value;
	}
	
	/**
	 * @See used to select the browser type
	 */
	public static void getdriver(String browserType)
	{
		switch (browserType) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
		    option.addArguments("--remote-allow-origins=*");
		    driver = new ChromeDriver(option);
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			break;
			
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default:
			break;
		}
	}

	/**
	 * @See Used to launch the chrome Browser
	 */
	public static void launchChromeBrowser() 
	{		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	
	/**
	 * @See Used to launch the URL
	 */
	public static void launchUrl(String url) 
	{
	driver.get(url);
	}
	
	/**
	 * 
	 * @return String
	 * @see Used to Get the Current URL
	 */
	public String getApplnCurrentUrl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
	}

	/**
	 * @See Used to maximize the window
	 */
	public static void maximizeWindow() {
	driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param url
	 * @see Used to Navigate to specific URL
	 */
	public void navigateLaunchUrl(String url) {
	driver.navigate().to(url);

	}

	/**
	 * @see Used to navigate backward
	 */
	public void backward() {
	driver.navigate().back();
	}

	/**
	 * @see Used to navigate backward
	 */
	public void forward() {
	driver.navigate().forward();
	}

	
	/**
	 * @see Used to refresh the page
	 */
	public void refresh() {
	driver.navigate().refresh();
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @see Used to send the data in the given element
	 */
	public void elementSendKeys(WebElement element, String data) {
	element.sendKeys(data);
	}

	/**
	 * @param element
	 * @param data
	 * @see Used to send the data in the given element and press Enter
	 */
	public void elementSendKeysWithEnterKey(WebElement element, String data) {
	element.sendKeys(data,Keys.ENTER);
	}

	/**
	 * @param element
	 * @see Used to clear the Enter data element
	 */
	public void toClearEnterData(WebElement element) {
	element.clear();
	}

	/**
	 * @param element
	 * @see Used to click the given element
	 */
	public void elementclick(WebElement element) {
	element.click();
	}

	/**
	 * @param attributevalue
	 * @return WebElement
	 * @see Used to locate WebElement by id
	 */
	public WebElement locatorById(String attributevalue) {
	WebElement element = driver.findElement(By.id(attributevalue));
	return element;
	}

	/**
	 * @param attributevalue
	 * @return WebElement
	 * @see Use to locate WebElement by Name
	 */
	public WebElement locatorByName(String attributevalue) {
	WebElement element = driver.findElement(By.name(attributevalue));
	return element;
	}

	/**
	 * @param attributevalue
	 * @return WebElement
	 * @see Used to locate WebElement By Class Name
	 */
	public WebElement locatorByClassName(String attributevalue) {
	WebElement element = driver.findElement(By.className(attributevalue));
	return element;
	}

	/**
	 * @param xpathExpression
	 * @return WebElement
	 * @see Used to locate WebElement By Xpaths
	 */
	public WebElement locatorByXpath(String xpathExpression) {
	WebElement element = driver.findElement(By.xpath(xpathExpression));
	return element;
	}

	/**
	 * @param attributeValue
	 * @return WebElement
	 * @see Used to locate WebElement By TagName
	 */
	public WebElement locatorByTagName(String attributeValue) {
	WebElement element = driver.findElement(By.tagName(attributeValue));
	return element;
	}

	/**
	 * @param attributenName
	 * @return List<WebElement>
	 * @see Used to find the multiple WebElements
	 */
	public List<WebElement> findMultipleElements(String attributenName) {
	List<WebElement> findElements = driver.findElements(By.tagName(attributenName));
	return findElements;
	}

	/**
	 * @param element
	 * @return String
	 * @see Used to get the Text From WebElement
	 */
	public String elementGetText(WebElement element) {
	String text = element.getText();
	return text;
	}

	/**
	 * @param element
	 * @param attributename
	 * @return String
	 * @see Used to get Attribute from WebElement using name
	 */
	public String elementGetAttribute(WebElement element, String attributename) {
	String text = element.getAttribute(attributename);
	return text;
	}

	/**
	 * @param element
	 * @return String
	 * @see Used to get Attribute from WebElement
	 */
	public String elementGetAttribute(WebElement element) 
	{
	String text = element.getAttribute("value");
	return text;
	}

	/**
	 * @see Used to Accept the alert
	 */
	public void clickOkAlert() {
	Alert alert = driver.switchTo().alert();
	alert.accept();
	}

	/**
	 * @see Used to Cancel The Alert
	 */
	public void clickCancelAlert() {
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
	}

	/**
	 * @param data
	 * @see Used to enter the data in the alert box
	 */
	public void enterTextAlert(String data) {
	Alert alert = driver.switchTo().alert();
	alert.sendKeys(data);
	}

	/**
	 * @return String
	 * @see Used to get the Text from the Alert
	 */
	public String getTextAlert() {
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	System.out.println(text);
	return text;
	}

	/**
	 * @param element
	 * @see Used to move the cursor to the specified element
	 */
	public void mouseOverAction(WebElement element) {
	actions = new Actions(driver);
	actions.moveToElement(element).perform();
	}

	/**
	 * @param from
	 * @param to
	 * @see Used To drag and drop the Element
	 */
	public void dragAndDrop(WebElement from, WebElement to) {
	actions = new Actions(driver);
	actions.dragAndDrop(from, to).perform();
	}

	/**
	 * @param element
	 * @see Used To RightClick the specified Element
	 */
	public void rightClick(WebElement element) {
	actions = new Actions(driver);
	actions.contextClick(element).perform();
	}

	/**
	 * @param element
	 * @see Used To Double click the specified element
	 */
	public void doubleClick(WebElement element) {
	actions = new Actions(driver);
	actions.doubleClick(element).perform();
	}

	/**
	 * @param element
	 * @param text
	 * @see Used To Select the Drop Down Using the Text
	 */
	public void selectDropDownByText(WebElement element, String text) {
	select = new Select(element);
	select.selectByVisibleText(text);
	}

	/**
	 * @param element
	 * @param index
	 * @see Used To Select the Drop Down Using the Index
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
	select = new Select(element);
	select.selectByIndex(index);
	}

	/**
	 * @param element
	 * @param value
	 * @see Used To Select the Drop Down Using the Value
	 */
	public void selectDropDownByValue(WebElement element, String value) {
	select = new Select(element);
	select.selectByValue(value);
	}

	/**
	 * @param element
	 * @param text
	 * @see Used To DeSelect the dropdown by Text
	 */
	public void deselectDropDownByText(WebElement element, String text) {
	select = new Select(element);
	select.deselectByVisibleText(text);
	}

	/**
	 * @param element
	 * @param index
	 * @see Used To DeSelect the dropdown by Index
	 */
	public void deselectDropDownByIndex(WebElement element, int index) {
	select = new Select(element);
	select.deselectByIndex(index);
	}

	/**
	 * @param element
	 * @param value
	 * @see Used To DeSelect the dropdown by Value
	 */
	public void deselectDropDownByValue(WebElement element, String value) {
	select = new Select(element);
	select.deselectByValue(value);
	}

	/**
	 * @param element
	 * @return boolean
	 * @see Used To Check the Element has multiple options
	 */
	public boolean selectMultipleElement(WebElement element) {
	select = new Select(element);
	boolean multiple = select.isMultiple();
	return multiple;
	}

	/**
	 * @param element
	 * @return List<WebElement>
	 * @see Used To get All options in the WebElement
	 */
	public List<WebElement> getAllOptionInElement(WebElement element) {
	select = new Select(element);
	List<WebElement> listoption = select.getOptions();
	return listoption;
	}

	/**
	 * @param element
	 * @return List<WebElement>
	 * @see Used To select all the options using WebElement
	 */
	public List<WebElement> selectAllOption(WebElement element) {
	select = new Select(element);
	List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
	return allSelectedOptions;
	}

	/**
	 * @param element
	 * @return WebElement
	 * @see Used To Display The First Selected option
	 */
	public WebElement getFirstSelectOption(WebElement element) {
	select = new Select(element);
	WebElement firstSelectedOption = select.getFirstSelectedOption();
	return firstSelectedOption;
	}

	/**
	 * @return String
	 * @see Used to Get the Parent Window ID
	 */
	public String getParentWindowId() {
	String parentId = driver.getWindowHandle();
	return parentId;
	}

	/**
	 * @return Set<String>
	 * @see Used to Get All Window ID
	 */
	public Set<String> getAllWindowID() {
	Set<String> allWindowID = driver.getWindowHandles();
	return allWindowID;
	}

	/**
	 * @param parentId
	 * @see Used to switch to Parent ID
	 */
	public void switchParentId(String parentId) {
	driver.switchTo().window(parentId);
	}

	/**
	 * @param attributeValue
	 * @return WebElement
	 * @see Used to Find Frame By ID
	 */
	public WebElement findFrameById(String attributeValue) {
	WebElement frameId = driver.findElement(By.id(attributeValue));
	return frameId;
	}

	/**
	 * @param attributeValue
	 * @return WebElement
	 * @see Used to Find Frame By Name
	 */
	public WebElement findFrameByname(String attributeValue) {
	WebElement frameName = driver.findElement(By.name(attributeValue));
	return frameName;
	}

	/**
	 * @param attributeValue
	 * @return WebElement
	 * @see Used to find Frame By Class Name
	 */
	public WebElement findFrameByClassName(String attributeValue) {
	WebElement frameClassName = driver.findElement(By.className(attributeValue));
	return frameClassName;
	}

	/**
	 * @param XpathExpression
	 * @return WebElement
	 * @see Used to Find Frame By Xpath
	 */
	public WebElement findFrameByXpath(String XpathExpression) {
	WebElement frameXpath = driver.findElement(By.id(XpathExpression));
	return frameXpath;
	}

	/**
	 * @param index
	 * @return WebDriver
	 * @see Used to Switch Frame By Index
	 */
	public WebDriver switchFrameByIndex(int index) {
		driver.switchTo().defaultContent();
	WebDriver frame = driver.switchTo().frame(index);
	return frame;
	}

	/**
	 * @param nameorid
	 * @return WebElement
	 * @see Used to Switch Frame By Name or ID
	 */
	public WebDriver switchFrameByNameorId(String nameorid) {
	WebDriver frame = driver.switchTo().frame(nameorid);
	return frame;
	}

	/**
	 * @param element
	 * @return WebDriver
	 * @see Used to Switch Frame By Element
	 */
	public void switchFrameByElement(WebElement element) {
	driver.switchTo().defaultContent();
	driver.switchTo().frame(element);
	
	}

	/**
	 * @param element
	 * @param text
	 * @see Used to Send Keys using Java Script Executor
	 */
	public void sendKeysbyJS(WebElement element, String text) {
		executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}
	
	/**
	 * @param element
	 * @see Used to Click an WebElement using Java Script Executor
	 */
	public void clickbyJs(WebElement element) {
		executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()", element);
	}
	
	public void defaultframe(WebElement element)
	{
		driver.switchTo().frame(element);
	}

	public void defaultcontent()
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * @param pixel
	 * @see Used to Scroll Down By Pixel
	 */
	public void scrolDownByPixel(int pixel) {// pixel should be positive value
	executor.executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * @param pixel
	 * @see Used to Scroll By pixel
	 */
	public void scrolUpByPixel(int pixel) {// pixel should be negative value
	executor.executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * @param element
	 * @see Used to Scroll Down By Element
	 */
	public void scrolDownByElement(WebElement element) {
	executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * @param element
	 * @see Used to Scroll By Element
	 */
	public void scrolUpByElement(WebElement element) {
	executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	/**
	 * @param time
	 * @see Used for Implicit Wait
	 */
	public static void giveImplicitWait(long time) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	/**
	 * @param time
	 * @see Used for Explicit Wait
	 */
	public void giveExplicitWait(long time) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	}

	/**
	 * @param time
	 * @param text
	 * @return WebElement
	 * @see Used to make Explicit Wait for specific element
	 */
	public WebElement locateElementByExplicitWait(long time, String text) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(text)));
	return element;
	}

	/**
	 * @param seconds
	 * @throws InterruptedException
	 * @see Used for Sleep 
	 */
	public void giveSleep(long seconds) throws InterruptedException {
	Thread.sleep(seconds);
	}

	/**
	 * @param path
	 * @throws IOException
	 * @see Used for taking Screenshot 
	 */
	public void screenshot(String path) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
	System.out.println(screenshotAs);
	File file = new File(path);
	FileUtils.copyFile(screenshotAs, file);
	}

	/**
	 * @see Used to Quit 
	 */
	public static void toQuit() {
	driver.quit();
	}

	/**
	 * @see
	 */
	public static void toClose() {
	driver.close();
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void setPropertyFile(String key, String value) throws FileNotFoundException, IOException {

		FileInputStream input = new FileInputStream(getprojectpath() + "\\Config\\config.properties");
		Properties properties = new Properties();
		properties.load(input);
		properties.setProperty(key, value);

		FileOutputStream output = new FileOutputStream(getprojectpath() + "\\Config\\config.properties");
		properties.store(output, "OMR Branch Hotel Automation");
		output.close();

	}
	
	/**
	 * 
	 * @param key
	 */
	public void deleteDataInPropertyFile(String key) {
		Properties properties = new Properties();
		properties.remove(key);

	}
	
	/**
	 * 
	 * @return
	 */
	public byte[] screenshots() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] projectImage = screenshot.getScreenshotAs(OutputType.BYTES);
		return projectImage;
	}
}
