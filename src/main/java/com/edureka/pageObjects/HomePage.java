package com.edureka.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.actionDriver.ActionClass;
import com.edureka.base.BaseClass;

public class HomePage extends BaseClass{

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(className="user_image")
	private WebElement userImage;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	private WebElement myProfile;
	
	public boolean validateUserImageDisplayed() {
		return ActionClass.isDisplayed(getDriver(), userImage);
	}
	
	public ProfilePage navigateToMyProfile() {
		ActionClass.click(getDriver(), userImage);
		ActionClass.click(getDriver(), myProfile);
		return new ProfilePage();
	}
}
