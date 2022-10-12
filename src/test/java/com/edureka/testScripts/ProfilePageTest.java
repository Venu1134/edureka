package com.edureka.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edureka.base.BaseClass;
import com.edureka.pageObjects.HomePage;
import com.edureka.pageObjects.Indexpage;
import com.edureka.pageObjects.LoginPage;
import com.edureka.pageObjects.ProfilePage;

public class ProfilePageTest extends BaseClass {

	Indexpage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void validateProfilePage() {
		indexPage = new Indexpage();
		loginPage = indexPage.clickOnLoginButton();
		homePage = loginPage.validateByCorrectEmailPassword(prop.getProperty("email"), prop.getProperty("password"));
		profilePage = homePage.navigateToMyProfile();
		Assert.assertTrue(profilePage.validateMyProfileNavBar());
	}
}
