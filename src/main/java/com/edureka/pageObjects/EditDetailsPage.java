package com.edureka.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eGov.actionDriver.ActionClass;
import com.edureka.base.BaseClass;

public class EditDetailsPage extends BaseClass {

	public EditDetailsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="fullName")
	private WebElement fullNameTextField;
	
	@FindBy(xpath="//span[contains(text(),'Internet')]")
	private WebElement experience;
	
	@FindBy(xpath="//*[@class='ngx-dropdown-list-container']//*[@tabindex='-1']")
	private List<WebElement> experienceDropDown;
	
	@FindBy(xpath="//*[contains(text(),'Industry* ')]")
	private WebElement Industry;
	
	@FindBy(xpath="//*[@class='ngx-dropdown-list-container']//*[@tabindex='-1']")
	private List<WebElement> IndustryDropDown;
	
	@FindBy(id="designation")
	private WebElement designationTextField;
	
	@FindBy(xpath="//span[contains(text(),'India-IST-Asia/Kolkata')]")
	private WebElement timeZone;
	
	@FindBy(name="//*[@name='search-text']")
	private WebElement timeZoneSearchField;
	
	@FindBy(xpath="//*[@class='ngx-dropdown-list-container']//*[@tabindex='-1']")
	private List<WebElement> timeZoneDropDown;
	
	@FindBy(xpath="//*[contains(text(),'Save and Continue')]")
	private WebElement saveButton;
	
	public void enterUserName(String fullName) {
		ActionClass.type(fullNameTextField, fullName);
	}
	
	public void enterProfessionalDetails(String Experience, String industry, String Designation) {
		ActionClass.click(getDriver(), experience);
		List<WebElement> experienceDropDownList = experienceDropDown;
		for (int i = 0; i < experienceDropDownList.size(); i++) {
	        String temp = experienceDropDownList.get(i).getText();
	        if (temp.equalsIgnoreCase(Experience)) {
	        	experienceDropDownList.get(i).click();             
	            break;
	        }
	    }
		
		ActionClass.click(getDriver(), Industry);
		List<WebElement> industryDropDownList = IndustryDropDown;
		for(int i=0; i<industryDropDownList.size(); i++) {
			String temp = industryDropDownList.get(i).getText();
			if(temp.equalsIgnoreCase(industry)) {
				industryDropDownList.get(i).click();
				break;
			}
		}
		
		ActionClass.type(designationTextField, Designation);
		
	}
	
	public ProfilePage clickOnSaveButton() {
		ActionClass.click(getDriver(), saveButton);
		return new ProfilePage();
	}
//	public void selectTimeZone(String TimeZoneShort, String TimeZoneFull) {
//		ActionClass.click(getDriver(), timeZone);
//		ActionClass.type(timeZoneSearchField, TimeZoneShort);
//		List<WebElement> timeZoneDropDownList = timeZoneDropDown;
//		for (int i=0; i<timeZoneDropDownList.size(); i++) {
//			String temp = timeZoneDropDownList.get(i).getText();
//			if(temp.equalsIgnoreCase(TimeZoneFull)) {
//				timeZoneDropDownList.get(i).click();
//				break;
//			}
//		}
//	}
}
