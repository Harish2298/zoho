package ZohoBaseClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	 public static WebDriver p=null;
	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	public static void threadSleep() throws InterruptedException {
		Thread.sleep(3000);
	}
	 public static WebDriver browserLaunch(String value) {
		if(value.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Zoho/Driver/chromedriver");
			 p = new ChromeDriver();
		}else if(value.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "/Users/r.harish/eclipse-workspace/Zoho/Driver/edgedriver");
			 p = new EdgeDriver();
		}else if(value.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver", "/Users/r.harish/eclipse-workspace/Zoho/Driver/geckodriver");
			 p = new FirefoxDriver();
			 
		}
		p.manage().window().maximize();
		return p;
		
	}
	public static void close() {
		p.close();
	}
	public static void url(String value) {
		p.get(value);
	}
	public static void screenshot(String name) throws IOException {
		TakesScreenshot r = (TakesScreenshot) p;
		File v = r.getScreenshotAs(OutputType.FILE);
		File b = new File("/Users/r.harish/eclipse-workspace/Selinum/Screenshot/"+name + ".png");
		FileUtils.copyFile(v, b);
	}
}
