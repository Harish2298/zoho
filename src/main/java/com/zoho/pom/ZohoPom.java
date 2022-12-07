package com.zoho.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZohoPom {
	public WebDriver p=null;
	
@FindBy(xpath = "//a[@class='zh-signup']")
private WebElement signup ;

@FindBy(xpath = "//input[@type='email']")
private WebElement username ;

@FindBy(xpath = "//input[@type='password']")
private WebElement password ;

@FindBy(xpath = "//span [@id='signup-termservice']")
private WebElement agree ;

@FindBy(xpath = "//input [@type='submit']")
private WebElement submit ;

public WebElement getSignup() {
	return signup;
}

public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getAgree() {
	return agree;
}

public WebElement getSubmit() {
	return submit;
}
	
	public ZohoPom(WebDriver p) {
		this.p=p;
		PageFactory.initElements(p, this);
		
	}

}
