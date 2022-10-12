package com.edureka.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eGov.actionDriver.ActionClass;
import com.edureka.base.BaseClass;

public class ProfilePage extends BaseClass {

	public ProfilePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[contains(text(),'My Profile')]")
	private WebElement myProfileNavBar;
	
	@FindBy(xpath="//*//div[2]/div[1]/div[1]/a[1]/i[1]")
	private WebElement personalDetailsEdit;
	
	@FindBy(xpath="//*[contains(text(),'Career Services')]")
	private WebElement careerServices;
	
	public boolean validateMyProfileNavBar() {
		return ActionClass.isDisplayed(getDriver(), myProfileNavBar);
	}
	
	public EditDetailsPage clickOnEditPersonalDetails() {
		ActionClass.click(getDriver(), personalDetailsEdit);
		return new EditDetailsPage();
	}
	
	public void clickOnCareerServices() {
		ActionClass.click(getDriver(), careerServices);
	}
}
