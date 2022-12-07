package com.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Sdp {//singleTon design pattern
	public WebDriver t = null;
	public Inputs ip;
	public Submit st;
	
	public Inputs getInputs() {
		if(ip==null) {
			ip = new Inputs(t);
		}return ip;
	}
	public Submit getSubmit() {
		if(st==null) {
			st=new Submit(t);
		}return st;
	}
	public Sdp(WebDriver c) {
		this.t=c;
		PageFactory.initElements(c, this);
		
	}

}
