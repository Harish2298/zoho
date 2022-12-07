package com.StepDefintion;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Runner.Zohorunner;
import com.sdp.Sdp;
import com.zoho.property.ConfigurationHelper;
import com.zohoDatadriven.Datadrivenzoho;

import ZohoBaseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ZohoStepDef extends BaseClass {
	public static WebDriver p=Zohorunner.p;
	Sdp zoho = new Sdp(p);
	
	@Given("user Launch The Application")
	public void user_launch_the_application() throws IOException {
		//p.manage().window().maximize();
		
		String Url = ConfigurationHelper.getInstance().getUrl();
		url(Url);
		//p.get("https://www.zoho.com/");
	}

	@When("user Enter The Login Informations")
	public void user_enter_the_login_informations() throws InterruptedException, IOException {
//		WebElement signup = p.findElement(By.xpath("//a[@class='zh-signup']"));
//		//signup.click();
//		clickOnElement(signup);
		clickOnElement(zoho.getInputs().getSignup());
		
        //Thread.sleep(3000);
		threadSleep();
//		 WebElement username = p.findElement(By.xpath("//input[@type='email']"));
//		//String user = Datadrivenzoho.allData("zoho",0,1);
//		//username.sendKeys(user);
//		 sendKeys(username,"hari@gmail.com");
		String sheet = ConfigurationHelper.getInstance().getSheet();
		String user = Datadrivenzoho.allData(sheet,0,1);
		//sendKeys(zoho.getInputs().getUsername(),"hp@1436");
		sendKeys(zoho.getInputs().getUsername(),user);
		 
		 
		//Thread.sleep(3000);
		 threadSleep();
//		WebElement password = p.findElement(By.xpath("//input[@type='password']"));
		String pass  = Datadrivenzoho.allData(sheet,1,1);
//		//password.sendKeys(pass);
//		sendKeys(password, "hari");
		 sendKeys(zoho.getInputs().getPassword(),pass);
	}

	@When("user Click The Sign")
	public void user_click_the_sign() {
//		WebElement agree = p.findElement(By.xpath("//span [@id='signup-termservice']"));
//		//agree.click();
//		clickOnElement(agree);
		clickOnElement(zoho.getSubmit().getAgree());
	}

	@When("user Get The Invalid Credential Input")
	public void user_get_the_invalid_credential_input() throws InterruptedException {
		//Thread.sleep(3000);
		threadSleep();
//		WebElement submit = p.findElement(By.xpath("//input [@type='submit']"));
//		//submit.click();
//		clickOnElement(submit);
		clickOnElement(zoho.getSubmit().getSubmit());
	}

	@Then("user Get The Screenshot Of The Current Page")
	public void user_get_the_screenshot_of_the_current_page() throws IOException {
//		TakesScreenshot r = (TakesScreenshot) p;
//		File v = r.getScreenshotAs(OutputType.FILE);
//		File b = new File("/Users/r.harish/eclipse-workspace/Selinum/Screenshot/zoho.png");
//		FileUtils.copyFile(v, b); 
		screenshot("zoho");
	}

}
