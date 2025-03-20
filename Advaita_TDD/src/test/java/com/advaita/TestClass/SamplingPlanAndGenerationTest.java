package com.advaita.TestClass;

import Advaita_TDD.Advaita_TDD.FakeData;
import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.pageObjects.SamplingPlanAndGenerationPage;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

import static Advaita_TDD.Advaita_TDD.FakeData.lastName2;

public class SamplingPlanAndGenerationTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SamplingPlanAndGenerationPage SPAG;

	public SamplingPlanAndGenerationTest() throws IOException {
	}

	@BeforeTest
	public void setup() throws AWTException, InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");
		SPAG = new SamplingPlanAndGenerationPage();
	}

	@Test
	public void navToPage() {
		SPAG.navToCreate();
	}

	// Global variables (instance variables)
	private String process=PropertieFileUtil.getSingleTextFromPropertiesFile("process");
	private String subProcess=PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess");
	private String subSubprocess=PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess");
	private String stages= PropertieFileUtil.getSingleTextFromPropertiesFile("samplingStage");
	private String samplingPlaneName= lastName2()+" Samples";
	private String fromDate="01-10-2024";
	private String toDate="11-11-2024";
	private String samplingTo="Admin";
	private String totalDataCall="15";
	private String allSampleCondition="yes";
	private String needCondition="no";
	private String needScheduling="no";


	@Test(invocationCount = 1)
	public void createSampling() {
		SPAG
				.navToCreate()
				.createSampling(process, subProcess, subSubprocess, stages,
						samplingPlaneName, samplingTo, totalDataCall,
						allSampleCondition, needCondition, needScheduling)
				.sampleValidations(stages,process,subProcess,subSubprocess)

		;
	}


	@Test
	public void validateDropdowns(){
		SPAG.validateDropdowns();
	}


	@Test
	public void validateRecordPerPage(){
		SPAG.navigateWithinAlchemy(SamplingPlanAndGenerationPage.samplingPlanAndGeneration);
		SPAG.validateRecordsPerPage();
	}

	@Test
	public void validatePagination(){
		SPAG.navigateWithinAlchemy(SamplingPlanAndGenerationPage.samplingPlanAndGeneration);
		SPAG.validatePagination();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
