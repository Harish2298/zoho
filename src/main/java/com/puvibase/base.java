package com.puvibase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {// reusable methods are known as baseclass
					// WebElement and WebDriver methods are hidden as reusable methods in baseclass
					// java concept--> Inheritance-> single Inheritance and hierarchical Inheritance
	public static WebDriver driver = null;
	public static Select s;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor j;

	public static WebDriver browserLaunch(String value) {
		if (value.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver", "chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (value.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();

		} else if (value.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void url(String value) {
		driver.get(value);
	}

// navigation methods
	public static void navigateTo(String value) {
		driver.navigate().to(value);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void naviRefersh() {
		driver.navigate().refresh();
	}

	public static void naviforward() {
		driver.navigate().forward();
	}

	public static void impli(int number) {
		driver.manage().timeouts().implicitlyWait(number, TimeUnit.SECONDS);
	}

	public static void thread(int number) throws InterruptedException {
		number = number * 1000;
		Thread.sleep(number);
	}

	public static void explicit() {// element not visible exception
		WebDriverWait p = new WebDriverWait(driver, 50);
		p.until(ExpectedConditions.alertIsPresent()).accept();

	}

	public static void alertAccept() {
		driver.switchTo().alert().accept();
	}

	public static void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	public static void alertSendKey(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void alertText() {
		driver.switchTo().alert().getText();
	}

	public static void select(WebElement element, int number, String value) {
		s = new Select(element);
		if (value.equalsIgnoreCase("selectByIndex")) {
			s.selectByIndex(number);

		} else if (value.equalsIgnoreCase("selectByValue")) {
			s.selectByValue(value);

		} else if (value.equalsIgnoreCase("selectByVisibleText")) {
			s.selectByVisibleText(value);

		} else if (value.equalsIgnoreCase("deselectAll")) {
			s.deselectAll();

		} else if (value.equalsIgnoreCase("deselectByVisibleText")) {
			s.deselectByVisibleText(value);

		} else if (value.equalsIgnoreCase("deselectByValue")) {
			s.deselectByValue(value);

		} else if (value.equalsIgnoreCase("deselectByIndex")) {
			s.deselectByIndex(number);

		} else if (value.equalsIgnoreCase("getOptions")) {
			List<WebElement> options = s.getOptions();

		} else if (value.equalsIgnoreCase("getFirstSelectedOption")) {
			WebElement firstSelectedOption = s.getFirstSelectedOption();

		} else if (value.equalsIgnoreCase("isMultiple")) {
			boolean multiple = s.isMultiple();

		} else if (value.equalsIgnoreCase("getAllSelectedOptions")) {
			List<WebElement> options = s.getAllSelectedOptions();

		}
	}

	public static void actionCc(WebElement element, String value) {
		a = new Actions(driver);
		if (value.equalsIgnoreCase("contextClick")) {
			a.contextClick(element).build().perform();

		} else if (value.equalsIgnoreCase("click")) {
			a.click(element).build().perform();
			;

		} else if (value.equalsIgnoreCase("doubleClick")) {
			a.doubleClick().build().perform();

		} else if (value.equalsIgnoreCase("dragAndDrop")) {
			a.dragAndDrop(element, element).build().perform();

		} else if (value.equalsIgnoreCase("keyDown")) {
			a.keyDown(element, value).build().perform();

		} else if (value.equalsIgnoreCase("keyUp")) {
			a.keyUp(element, value).build().perform();

		} else if (value.equalsIgnoreCase("moveToElement")) {
			a.moveToElement(element).build().perform();

		} else if (value.equalsIgnoreCase("release")) {
			a.release().build().perform();

		} else if (value.equalsIgnoreCase("clickAndHold")) {
			a.clickAndHold(element).build().perform();
		}
	}

	public static void robot(WebElement element, String value) throws AWTException {
		r = new Robot();
		if (value.contains("Enter")) {
			r.keyPress(KeyEvent.VK_ENTER);

		} else if (value.contains("Down")) {
			r.keyPress(KeyEvent.VK_DOWN);

		} else if (value.contains("Up")) {
			r.keyPress(KeyEvent.VK_UP);

		} else if (value.contains("Delete")) {
			r.keyPress(KeyEvent.VK_DELETE);

		} else if (value.contains("Tab")) {
			r.keyPress(KeyEvent.VK_TAB);

		}
	}

	public static void keyRelease(String value) {
		if (value.contains("Enter")) {
			r.keyRelease(KeyEvent.VK_ENTER);

		} else if (value.contains("Tab")) {
			r.keyRelease(KeyEvent.VK_TAB);

		} else if (value.contains("Down")) {
			r.keyRelease(KeyEvent.VK_DOWN);

		} else if (value.contains("Up")) {
			r.keyRelease(KeyEvent.VK_UP);

		}

	}

	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void screenShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("/Users/r.harish/eclipse-workspace/Zoho/screenShot" + name + ".png ");
		FileUtils.copyFile(source, destination);
	}
	public static void javascriptScroll(WebElement element) {
	    j = (JavascriptExecutor)driver;
	   
		j.executeScript("arguments[0].scrollIntoView();",element );
	}
	public static void javaScroll(WebElement element, int x, int y) {
		j.executeScript("windows.scrollBy(x,y);", element);
	}
	public static void javaNormal(WebElement element) {
		j.executeScript("window.scroll(0,0);", element);
	}
	public static void javaClick(WebElement element) {
		j.executeScript("arguments[0].click();", element);
	}
	public static void close() {
		driver.close();
	}
    public static void quit() {
    	driver.quit();
    }
    public static void clickOnElement(WebElement element) {
    	element.click();
    }
    public static void currentUrl() {
    	driver.getCurrentUrl();
    }
    public static void getText(WebElement element) {
    element.getText();
    }	
//    public static void fram	
//    	
//    	
//    }
	// sendKeys, screenShot, JavascriptExecutor, close, quit, clear, click, getText,
	// getCurrentUrl
    // windowHandling,frames.	 

}
