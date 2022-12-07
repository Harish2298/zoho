package com.puvibase;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	import java.util.logging.FileHandler;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.mongodb.client.model.ReturnDocument;

	public class FullBase {
//	        Reusable methods are known as BaseClass
//	        src/main--->used to maintain reusable methods
	//   WebDriver and WebElement methods are hidden as reusable methods in BaseClass.
	// Java Concept--------->Inheritance
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static Actions ref;
	public static Robot rt;
	public static WebDriver browserLaunch(String value) {
	if(value.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\puvana\\eclipse-workspace\\Zoho_maven\\driver\\chromedriver.exe");
	            driver=new ChromeDriver();
	}else if(value.equalsIgnoreCase("edge")) {
	System.setProperty("webdriver.edge.driver","C:\\Users\\puvana\\eclipse-workspace\\Zoho_maven\\driver\\edgedriver.exe");
	            driver=new EdgeDriver();
	}else if(value.equalsIgnoreCase("qecko")) {
	System.setProperty("webdriver.qecko.driver","C:\\Users\\puvana\\eclipse-workspace\\Zoho_maven\\driver\\edgedriver.exe");
	            driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	return driver;
	}
	public static void sendKeys(WebElement element,String value) {
	element.sendKeys(value);

	}
	public static void clear(WebElement element) {
	element.clear();
	}

	public static void getUrl(String value) {
	driver.get(value);

	}
	public static void getCurrentUrl(String value) {
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	}
	public static void getTitle(String Value) {
	String title = driver.getTitle();
	System.out.println(title);
	}
	//ConditionalMethods/Conditionalcommands
	public static void isDisplayed(WebElement element) {
	System.out.println(element.isDisplayed());//returns in Boolean
	}
	public static void isEnabled(WebElement element) {
	Boolean check=element.isEnabled();
	System.out.println(check);
	}
	public static void isSelected(WebElement element) {
	Boolean check=element.isSelected();
	System.out.println(check);
	}
	//Navigation Methods
	public static void navigateTo(String value) {
	driver.navigate().to(value);

	}
	public static void navigateBack() {
	driver.navigate().back();
	}
	public static void navigateForward() {
	driver.navigate().forward();
	}
	public static void navigateRefresh() {
	driver.navigate().refresh();
	}
	//wait
	public static void implictity() {//NoSuchElementException
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	public static void explicity(WebElement element) {//ElementNotVisibleException
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void fluent() {//ExpectedConditions
	Wait wait=new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(Exception.class);
	}
	//Thread
	public static void thread(int number) throws InterruptedException {
	Thread.sleep(number);
	}
	//Alert
	public static void alertAccept() {
	driver.switchTo().alert().accept();
	}
	public static void alertDismiss() {
	driver.switchTo().alert().dismiss();
	}
	public static void alertSendkey(String value) {
	Alert ref=driver.switchTo().alert();
	ref.sendKeys(value);
	ref.accept();
	}
	public static void alertGetText() {

	String ref=driver.switchTo().alert().getText();
	System.out.println(ref);

	}
	//Select
	public static void selectByIndex(WebElement element,int number) {
	Select s=new Select(element);
	s.selectByIndex(number);
	}
	public static void selectByValue(WebElement element,String value) {
	Select s=new Select(element);
	s.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element,String value) {
	Select s=new Select(element);
	s.selectByVisibleText(value);
	}
	public static void getOptions(WebElement element) {
	Select s=new Select(element);
	List<WebElement> options=s.getOptions();
	for(WebElement option:options) {
	String str=option.getText();
	System.out.println(str);
	}
	}
	public static void getFirstSelectedOption(WebElement element) {
	Select s=new Select(element);
	WebElement we = s.getFirstSelectedOption();
	System.out.println(we.getText());
	}
	public static void getAllSelectedOption(WebElement element) {
	Select s=new Select(element);
	List<WebElement> opt=s.getAllSelectedOptions();
	for(WebElement option:opt) {
	System.out.println(option.getText());
	}
	}
	public static void isMultiple(WebElement element) {
	Select s=new Select(element);
	boolean check=s.isMultiple();
	System.out.println(check);

	}
	public static void deselectByIndex(WebElement element,int number) {
	Select s=new Select(element);
	s.deselectByIndex(number);
	}
	public static void deselectByValue(WebElement element,String value) {
	Select s=new Select(element);
	s.deselectByValue(value);
	}
	public static void deselectByVisibleText(WebElement element,String Value) {
	Select s=new Select(element);
	s.deselectByVisibleText(Value);
	}
	public static void deselectAll(WebElement element) {
	Select s=new Select(element);
	s.deselectAll();
	}
	//JavascriptExecutor
	public static void scrollIntoViewjs(WebElement element) {//-----1
	js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public static void clickjs(WebElement element) {//--------2
	js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",element);
	}
	public static void scrollDownjs() {//--------3
	js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1300);");
	}
	public static void scrollUpjs() {//------------4
	js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,-1000);");
	}
	public static void scrollstartingpoint() {//----------5
	js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,0);");
	}
	public static void refreshjs() {//---------6
	js=(JavascriptExecutor) driver;
	js.executeScript("history.go(0)");
	}
	public static void getTitlejs() {//---------7
	js=(JavascriptExecutor) driver;
	String string = js.executeScript("return document.title;").toString();
	System.out.println(string);
	}
	public static void scrollByHorizontal() {//------8
	js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(1000,0);");
	}
	public static void navigatejs(String value) {//-----9(not sure)
	js=(JavascriptExecutor) driver;
	js.executeScript("window.location="+ value+"");
	}
	public static void getTextjs(WebElement element) {//---------10
	js=(JavascriptExecutor) driver;
	String string = js.executeScript("return argumenets[0].innerHTML",element).toString();
	System.out.println(string);
	}
	public static void getUrljs() {//---------11
	js=(JavascriptExecutor) driver;
	Object url = js.executeScript("return document.URL;");
	System.out.println(url);

	}
	public static void getEntireWebsiteText() {//------------12
	js=(JavascriptExecutor) driver;
	String string = js.executeScript("return document.documentElement.innerText;").toString();
	System.out.println(string);
	}
	public static void alertjs() {//-------13--alert(juzToKnown)
	js=(JavascriptExecutor) driver;
	js.executeScript("alert('helloooo puv');");
	}
	//Actions--->class
	public static void contextClick(WebElement element) {
	ref=new Actions(driver);
	ref.contextClick(element).build().perform();
	}
	public static void onlyContextClick() {
	ref=new Actions(driver);
	ref.clickAndHold().build().perform();
	}
	public static void doubleContextClick(WebElement element) {
	ref=new Actions(driver);
	ref.doubleClick(element).build().perform();
	}
	public static void onlyDoubleContextClick() {
	ref=new Actions(driver);
	ref.doubleClick().build().perform();
	}
	public static void moveToElement(WebElement element) {
	ref=new Actions(driver);
	ref.moveToElement(element).build().perform();
	}
	public static void dragAndDrop(WebElement element,WebElement element1) {
	ref=new Actions(driver);
	ref.dragAndDrop(element, element1).build().perform();
	}
	public static void release() {
	ref=new Actions(driver);
	ref.release();
	}
	public static void clickAndHold(WebElement element) {
	ref=new Actions(driver);
	ref.clickAndHold(element).build().perform();
	}
	//Robot
	public static void vkDown(String value) throws AWTException {
	rt=new Robot();
	if(value.equalsIgnoreCase("Down")) {
	rt.keyPress(KeyEvent.VK_DOWN);
	}else if(value.equalsIgnoreCase("Tab")) {
	rt.keyPress(KeyEvent.VK_TAB);
	}else if(value.equalsIgnoreCase("Enter")) {
	rt.keyPress(KeyEvent.VK_ENTER);
	}
	}
	//Frames
	public static void frameIndex(int data) {
	driver.switchTo().frame(data);
	}
	public static void frameXpath(WebElement element) {
	driver.switchTo().frame(element);
	}
	public static void frameIdName(String value) {
	driver.switchTo().frame(value);

	}
	public static void parentFrame() {//previous frame
	driver.switchTo().parentFrame();
	}
	public static void defaultContext() {//main frame
	driver.switchTo().defaultContent();
	}
	//WindowHandling
	public static void getWindowHandle() {
	String windowHandle = driver.getWindowHandle();
	System.out.println(windowHandle);
	}
	public static void getWindowHandles(String value,WebElement element) {//not sure yet, its based on condition
	Set<String> handles = driver.getWindowHandles();
	for (String string : handles) {
	if(driver.switchTo().window(string).getTitle().equalsIgnoreCase(value)){
	element.click();
	}
	}
	}
	//takeScreenShot
	public static void takeScreenshot(String filename) throws IOException {
	TakesScreenshot tc=(TakesScreenshot) driver;
	File source=tc.getScreenshotAs(OutputType.FILE);
	File destination=new File("C:\\Users\\puvana\\eclipse-workspace\\Zoho_maven\\screen"+filename+".png");
	FileUtils.copyFile(source, destination);
	}
	public static void close() {
	driver.close();
	}
	public static void quit() {
	driver.quit();

	}

}
