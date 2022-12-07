package com.zohoDatadriven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testzoho {

	public static void zoho() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Zoho/Driver/chromedriver");
		WebDriver p = new ChromeDriver();
		p.manage().window().maximize();

		p.get("https://www.zoho.com/");

		WebElement signup = p.findElement(By.xpath("//a[@class='zh-signup']"));
		signup.click();
        Thread.sleep(3000);
		 WebElement username = p.findElement(By.xpath("//input[@type='email']"));
		 String user = Datadrivenzoho.allData("zoho",0,1);
		 username.sendKeys(user);
		 
		Thread.sleep(3000);
		WebElement password = p.findElement(By.xpath("//input[@type='password']"));
		String pass  = Datadrivenzoho.allData("zoho",1,1);
		password.sendKeys(pass);
		
		WebElement agree = p.findElement(By.xpath("//span [@id='signup-termservice']"));
		agree.click();

		Thread.sleep(3000);
		WebElement submit = p.findElement(By.xpath("//input [@type='submit']"));
		submit.click();

		TakesScreenshot r = (TakesScreenshot) p;
		File v = r.getScreenshotAs(OutputType.FILE);
		File b = new File("/Users/r.harish/eclipse-workspace/Selinum/Screenshot.zoho.png");
		FileUtils.copyFile(v, b);

	}
	public static void main(String[] args) throws IOException, InterruptedException {
		zoho();
	}
	}
	
	
	


