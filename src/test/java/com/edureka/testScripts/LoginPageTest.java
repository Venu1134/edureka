package com.edureka.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edureka.base.BaseClass;
import com.edureka.pageObjects.HomePage;
import com.edureka.pageObjects.Indexpage;
import com.edureka.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass {

	Indexpage indexPage;
	LoginPage loginPage;
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
	public void loginTestWithValidEmailPassword() {
		indexPage = new Indexpage();
		loginPage = indexPage.clickOnLoginButton();
		homePage = loginPage.validateByCorrectEmailPassword(prop.getProperty("email"), prop.getProperty("password"));
		homePage.validateUserImageDisplayed();
	}
	
	@Test
	public void loginTestWithoutEmailPassword() {
		indexPage = new Indexpage();
		loginPage = indexPage.clickOnLoginButton();
		loginPage.validateByWithoutEmailPassword(prop.getProperty(" "), prop.getProperty(" "));
		Assert.assertTrue(loginPage.validateEmailErrorMessage());
		Assert.assertTrue(loginPage.validatePasswordErrorMessage());
	}
}
