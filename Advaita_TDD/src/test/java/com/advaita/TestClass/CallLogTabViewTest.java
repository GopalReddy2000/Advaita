package com.advaita.TestClass;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.CallLogTabView;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class CallLogTabViewTest extends TestBase
{
    LoginPage loginPage;
    HomePage homePage;
    CallLogTabView callLogTabView;
    CallLogTabViewTest()
    {
        super();
    }
    @BeforeTest
    public void setup() throws AWTException, InterruptedException {
        initialization();
        loginPage=new LoginPage();
        homePage = loginPage.login("Capture_admin", "Qwerty@123");
        callLogTabView = new CallLogTabView();
    }
    @Test
    public void callLogTabViewTest()
    {
        callLogTabView.navigation();
    }

}
