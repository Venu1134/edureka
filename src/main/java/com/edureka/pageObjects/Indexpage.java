package com.edureka.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eGov.actionDriver.ActionClass;
import com.ics.base.BaseClass;

public class Indexpage extends BaseClass{

	public Indexpage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(className="signup_click signup-vd giTrackElementHeader ")
	private WebElement signUpButton;
	
	@FindBy(id="search-input")
	private WebElement searchTextField;
	
	@FindBy(xpath="//body/nav[1]/div[2]/ul[1]/li[8]/a[1]")
	private WebElement softwareTesting;
	
	public void clickOnSignUpButton() {
		ActionClass.click(getDriver(), signUpButton);
	}
}
