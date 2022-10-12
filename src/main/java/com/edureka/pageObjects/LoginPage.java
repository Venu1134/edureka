package com.edureka.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eGov.actionDriver.ActionClass;
import com.edureka.base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="si_popup_email")
	private WebElement emailID;
	
	@FindBy(id="si_popup_passwd")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement LoginButton;
	
	@FindBy(id="emailErrorr")
	private WebElement emailErrorMessage;
	
	@FindBy(id="passwdErrorr")
	private WebElement passwordErrorMessage;
	
	public HomePage validateByCorrectEmailPassword(String Email, String Password) {
		emailID.clear();
		ActionClass.type(emailID, Email);
		password.clear();
		ActionClass.type(password, Password);
		ActionClass.click(getDriver(), LoginButton);
		return new HomePage();
	}
	
	public HomePage validateByWithoutEmailPassword(String Email, String Password) {
		emailID.clear();
		ActionClass.type(emailID, Email);
		password.clear();
		ActionClass.type(password, Password);
		ActionClass.click(getDriver(), LoginButton);
		return new HomePage();
	}
	
	public boolean validateEmailErrorMessage() {
		return ActionClass.isDisplayed(getDriver(), emailErrorMessage);
	}
	
	public boolean validatePasswordErrorMessage() {
		return ActionClass.isDisplayed(getDriver(), passwordErrorMessage);
	}
}
