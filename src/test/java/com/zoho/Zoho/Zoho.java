package com.zoho.Zoho;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoho {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Zoho/Driver/chromedriver");

		WebDriver p = new ChromeDriver();
		p.manage().window().maximize();

		p.get("https://www.zoho.com/");

		WebElement signup = p.findElement(By.xpath("//a[@class='zh-signup']"));
		signup.click();

		WebElement username = p.findElement(By.xpath("//input[@type='email']"));
		username.sendKeys("harish@123");

		WebElement password = p.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("harish1234");

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

}
