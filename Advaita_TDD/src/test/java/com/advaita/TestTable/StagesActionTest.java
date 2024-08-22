package com.advaita.TestTable;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.StagesActions;

public class StagesActionTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	StagesActions stagesActions;
	StagesActionTest()
	{
		super();
	}
	@BeforeTest
	public void setup() throws AWTException, InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");
		stagesActions=new StagesActions();
	}
	
	@Test
	public void test()
	{
		stagesActions.navtoStages();
	}

}
