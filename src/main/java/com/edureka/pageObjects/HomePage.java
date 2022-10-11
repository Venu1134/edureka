package com.edureka.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eGov.actionDriver.ActionClass;
import com.edureka.base.BaseClass;

public class HomePage extends BaseClass{

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(className="user_image")
	private WebElement userImage;
	
	public boolean validateUserImageDisplayed() {
		return ActionClass.isDisplayed(getDriver(), userImage);
	}
}
