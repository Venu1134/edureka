package com.edureka.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edureka.base.BaseClass;
import com.edureka.pageObjects.HomePage;
import com.edureka.pageObjects.Indexpage;
import com.edureka.pageObjects.PasswordCreationPage;
import com.edureka.pageObjects.SignupPage;

public class SignUpPageTest extends BaseClass {
	
	Indexpage indexPage;
	SignupPage signupPage;
	PasswordCreationPage passwordCreationPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void signupTest() {
		indexPage = new Indexpage();
		signupPage = indexPage.clickOnSignUpButton();
		signupPage.enterEmailID(prop.getProperty("email"));
		signupPage.enterMobileNumber(prop.getProperty("mobileNumber"));
		passwordCreationPage = signupPage.clickOnsignupButton();
		passwordCreationPage.enterPassword(prop.getProperty("password"));
		homePage = passwordCreationPage.clickOnStartLearningButton();
		Assert.assertTrue(homePage.validateUserImageDisplayed());
	}

}
