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
	
	@FindBy(xpath="//*[@data-button-name='Login']")
	private WebElement loginButton;
	
	public SignupPage clickOnSignUpButton() {
		ActionClass.click(getDriver(), signUpButton);
		return new SignupPage();
	}
	
	public void clickOnLoginButton() {
		ActionClass.click(getDriver(), loginButton);
	}
}
