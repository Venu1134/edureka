package com.edureka.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eGov.actionDriver.ActionClass;
import com.edureka.base.BaseClass;

public class PasswordCreationPage extends BaseClass{

	public PasswordCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="signup_password")
	private WebElement passwordTextField;
	
	@FindBy(className="clik_btn_log btn-block sg_submit")
	private WebElement startLearningButton;
	
	public void enterPassword(String password) {
		ActionClass.type(passwordTextField, password);
	}
	
	public HomePage clickOnStartLearningButton() {
		ActionClass.click(getDriver(), startLearningButton);
		return new HomePage();
	}
}
