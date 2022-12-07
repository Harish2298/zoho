package com.TestNg;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zohoDatadriven.Datadrivenzoho;

import ZohoBaseClass.BaseClass;

public class Zoho_TestNG extends BaseClass{
	WebDriver p = null;
	@Test(priority = -2)
	private void browserLaunch() {
	System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Zoho/Driver/chromedriver");
    //ChromeOptions zoho = new ChromeOptions();
   //  zoho.addArguments("start-maximized");
     //p = new ChromeDriver();
	p=browserLaunch("chrome");	

	}
	@Test(priority = -1)
	private void getUrl() {
		//p.get("https://www.zoho.com/");
url("https://www.zoho.com/");
	}
	@Test(priority = 0)
	private void signUp() throws InterruptedException {
		WebElement signup = p.findElement(By.xpath("//a[@class='zh-signup']"));
		//signup.click();
       clickOnElement(signup);
	}
	@Test( dependsOnMethods = "signUp",timeOut = 5000)
	private void userDetails() throws IOException, InterruptedException {
		WebElement username = p.findElement(By.xpath("//input[@type='email']"));
		 //String user = Datadrivenzoho.allData("zoho",0,1);
		// username.sendKeys("hp@gmail.com");
		 sendKeys(username, "hp@gmail.com");
		Thread.sleep(3000);
		WebElement password = p.findElement(By.xpath("//input[@type='password']"));
		//String pass  = Datadrivenzoho.allData("zoho",1,1);
		//password.sendKeys("HP@1436");
		sendKeys(password,"HP@1436" );
		
	}
	@Test( dependsOnMethods = "userDetails",  invocationCount = 1)
	private void checkBox() {
		WebElement agree = p.findElement(By.xpath("//span [@id='signup-termservice']"));
		//agree.click();
		clickOnElement(agree);
	}
	@Test(timeOut = 5000,dependsOnMethods = "checkBox")
	private void submit() throws InterruptedException {
		Thread.sleep(3000);
		WebElement submit = p.findElement(By.xpath("//input [@type='submit']"));
		//submit.click();
		clickOnElement(submit);
		Thread.sleep(1000);
	}
	@Test(enabled = false)
	private void takeScreenshot() throws IOException {
//		TakesScreenshot r = (TakesScreenshot) p;
//		File v = r.getScreenshotAs(OutputType.FILE);
//		File b = new File("/Users/r.harish/eclipse-workspace/Selinum/Screenshot.zoho.png");
//		FileUtils.copyFile(v, b);
		screenshot("Zoho");
	}
	
	

}
