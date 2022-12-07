package com.Runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdp.Sdp;
import com.zoho.property.ConfigurationHelper;

import ZohoBaseClass.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/r.harish/eclipse-workspace/Zoho/src/test/java/com/feature/zoho.feature",
glue="com.StepDefintion",monochrome = true,                 // source code management tool
plugin= {"pretty",
		"html:Report/htmlReport.html",
		"json:Report/jsonreport.json",
		"junit:Report/junitReport.xml"}
		//"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"
		)

public class Zohorunner {
	
	public static WebDriver p;

	@BeforeClass
public static  void setUp() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Zoho/Driver/chromedriver");
//		 p = new ChromeDriver();
		String browser = ConfigurationHelper.getInstance().getBrowser();
        p= BaseClass.browserLaunch(browser);
  // Sdp zoho = new Sdp(p);
}	
	@AfterClass
	public static void tearDown() {
		//p.close();
      BaseClass.close();
	}
	
	
}
