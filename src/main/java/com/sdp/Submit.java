package com.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Submit {
	public WebDriver p;
	
	@FindBy(xpath = "//span [@id='signup-termservice']")
	private WebElement agree ;

	@FindBy(xpath = "//input [@type='submit']")
	private WebElement submit ;

	public WebElement getAgree() {
		return agree;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	
	public Submit(WebDriver p) {
		this.p=p;
		PageFactory.initElements(p,this);
	}

	
	
}
