package com.w2a.zoho.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.w2a.zoho.utilities.Constants;
import com.w2a.zoho.utilities.DataUtil;
import com.w2a.zoho.utilities.DriverManager;
import com.w2a.zoho.PageObjects.ZohoHomePage;
import com.w2a.zoho.PageObjects.ZohoLoginPage;
import com.w2a.zoho.utilities.DataProviders;
import com.w2a.zoho.utilities.ExcelReader;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void loginTest(Hashtable<String,String> data) {
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com/");
		ZohoLoginPage login = home.gotoLogin();
		login.doLoginAsInvalidUser(data.get("username"), data.get("password"));
		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		logInfo("Login Test Completed");		
		quit();
		
	}

}
