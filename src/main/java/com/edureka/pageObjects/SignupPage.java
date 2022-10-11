package com.edureka.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.actionDriver.ActionClass;
import com.edureka.base.BaseClass;

public class SignupPage extends BaseClass{

	public SignupPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="sg_popup_email")
	private WebElement emailTextField;
	
	@FindBy(id="sg_popup_phone_no")
	private WebElement phoneNumberTextField;
	
	@FindBy(xpath="//*[@class='inputfld captcha_parent_input']//*[@class='number_prefix']")
	private WebElement contryCode;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	private WebElement signupButton;
	
	@FindBy(className="login-vd")
	private WebElement loginButton;
	
	public void enterEmailID(String email) {
		ActionClass.type(emailTextField, email);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		ActionClass.type(phoneNumberTextField, mobileNumber);
	}
	
	public void selectCountryCode(String contrycode) {
		ActionClass.selectByVisibleText(contrycode, contryCode);
	}
	
	public PasswordCreationPage clickOnsignupButton() {
		ActionClass.click(getDriver(), signupButton);
		return new PasswordCreationPage();
	}
	
	public void clickOnlogin() {
		ActionClass.click(getDriver(), loginButton);
	}
}
