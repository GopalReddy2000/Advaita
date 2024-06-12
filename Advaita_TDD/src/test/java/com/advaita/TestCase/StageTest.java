package com.advaita.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.StagePage;

public class StageTest extends TestBase {

	StagePage sp;
	LoginPage lp;
	HomePage hp;

	StageTest() {
		super();
	}

	@BeforeTest
	public void setup() throws Exception {
		initialization();
		lp = new LoginPage();
		hp = lp.login("Capture_admin", "Qwerty@123");
		sp = new StagePage();
	}

	@Test
	public void navigation() {
		sp.CommonNavigation();
	}

	@Test
	public void testExistingStagenameWithoutDatePicker() {
		sp.existingStageNameWitoutDatePicker();
		sp.validateStageName("In Progress");
		
	}

	@Test
	public void testSearchOnlyWithDatePicker() {
		sp.searchOnlyWithDatePicker();
	}

	@Test
	public void testClearAllFilters() {
		sp.clearAllFilters();
	}

	@Test
	public void testPagination()
	{
		sp.pagination();
	}
	
	
	@Test
	public void testMonthsInDatePicker() throws InterruptedException
	{
		sp.monthsInDatePicker();
	}
	
	@Test
	public void testViewingCreatedStage()
	{
		sp.viewingCreatedStage();
		
	}
	
	@Test
	public void testVerifyViewRadioButtons()
	{
		sp.verifyViewRadioButtons();
	}
	
	@Test
	public void testNumberOfStagesListed()
	{
		sp.numberOfStagesListed();
		
	}
	
	
	
	
	@Test
	public void testEditButtons()
	{
		sp.editButtons();
	}
	
	
	@Test
	public void testDuplicate()
	{
		sp.duplicateFunction();
	}
	
	@Test
	public void testDelete()
	{
		sp.deleteFunction();
		
	}
	
	@Test
	public void testDataCount()
	{
		sp.editStageForm();
	}
	
	
	@AfterTest
	public void tearDown() {

		driver.manage().window().maximize();
		driver.quit();
	}

}
