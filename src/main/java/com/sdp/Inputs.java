package com.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inputs {
	public WebDriver p;
	
	@FindBy(xpath = "//a[@class='zh-signup']")
	private WebElement signup ;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement username ;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password ;
	
	public WebElement getSignup() {
		return signup;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}
	public Inputs(WebDriver p) {
		this.p=p;
		PageFactory.initElements(p,this);
	}

}
