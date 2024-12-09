package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.Pagination;
import com.google.common.util.concurrent.Uninterruptibles;

import Advaita_TDD.Advaita_TDD.FakeData;

public class StagePage extends TestBase{
	SoftAssert softAssert = new SoftAssert();

	@FindBy(xpath = "//span[normalize-space()='Workflow Design']//parent::a")
	public WebElement workFlowDesignButton;

	@FindBy(xpath = "//button[normalize-space()='Stages']")
	public WebElement stagesTab;

	@FindBy(id = "text_search")
	public WebElement searchBox;

	@FindBy(xpath = "//img[@alt='filter_search']//parent::button")
	public WebElement searchButton;

	@FindBy(xpath = "//table//tbody//tr//td[1]")
	public WebElement stageName;

	@FindBy(id = "filter_date")
	public WebElement datePicker;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_year']")
	public WebElement yearDropdown;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_year']//div[text()='2024']")
	public WebElement year;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_month']")
	public WebElement monthDropdown;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_month']//div[text()='June']")
	public WebElement month;

	@FindBy(xpath = "//div[@class='xdsoft_calendar']//..//td//div[text()='21']")
	public WebElement day;

	@FindBy(xpath = "//h6[normalize-space()='Clear All Filters']")
	public WebElement clearAllfilter;

	@FindBy(xpath = "(//button[@class='xdsoft_prev'])[1]")
	public WebElement datePickerPrevButton;

	@FindBy(xpath = "(//button[@class='xdsoft_next'])[1]")
	public WebElement datePickerNxtButton;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_month']//div[contains(@class,'xdsoft_option ')]")
	public List<WebElement> listOfMonths;

	@FindBy(xpath = "(//div[@class='dataset_table']//tbody//tr//td[1]//a)")
	public List<WebElement> listOfDataSet;

	@FindBy(xpath = "//h2[normalize-space()='Refresh']")
	public WebElement refresh;

	@FindBy(xpath = "//input[@type='radio' and @id='In progress']")
	public WebElement inProgressRadioButton;

	@FindBy(xpath = "//input[@type='radio' and @id='Resolved']")
	public WebElement resolvedRadioButton;

	@FindBy(xpath = "//input[@type='radio' and @data-info='AUTO']")
	public WebElement autoRadioButton;

	@FindBy(xpath = "//input[@type='radio' and @data-info='Manual']")
	public WebElement manualRadioButton;

	@FindBy(css = ".pagination li:not(.next):not(.prev)")
	public By paginationLocator;

	@FindBy(xpath = "//img[@alt='rgt_arrow']")
	public WebElement rightArrow;

	@FindBy(xpath = "//img[@alt='left_arrow']")
	public WebElement leftArrow;

	@FindBy(xpath = "//img[@alt='delete-icon ']")
	public List<WebElement> deleteButtons;

	@FindBy(xpath="//button[normalize-space()='Delete']")
	public WebElement confirmationdeleteButton;

	@FindBy(xpath="//span[@id='change_msg']")
	public WebElement deleteSuccessMsg;

	@FindBy(xpath="(//button[normalize-space()='Continue'])[1]")
	public WebElement deleteSuccessButton;

	@FindBy(xpath = "//img[@title='Duplicate Stage']")
	public List<WebElement> duplicateButtons;

	@FindBy(xpath="(//button[@type='submit'])[2]")
	public WebElement duplicateYesButton;

	@FindBy(xpath="//span[@id='change_msg']")
	public WebElement duplicateSuccessConfirmMessage;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public WebElement duplicateContinueButton;

	@FindBy(xpath = "//img[@alt='table-edit' and @class='img-fluid stages_edit delete-dataset']")
	public List<WebElement> editButtons;

	@FindBy(xpath = "//input[@id='stage_name']")
	public WebElement editStageName;

	@FindBy(xpath = "//select[@id='process']")
	public WebElement editProcess;

	@FindBy(xpath = "//select[@id='sub_process']")
	public WebElement editSubProcess;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public WebElement editSubSubProcess;

	@FindBy(xpath = "//select[@id='calculation_type']")
	public WebElement editCalculationType;

	@FindBy(xpath = "//div[contains(@class,'sectionA')]//a[normalize-space()='edit']")
	public WebElement sectionAEditButton;

	@FindBy(xpath = "(//div[contains(@class,'sectionb')]//a[normalize-space()='edit'])[1]")
	public WebElement sectionBEditButton1;

	@FindBy(xpath = "(//div[contains(@class,'sectionb')]//a[normalize-space()='edit'])[2]")
	public WebElement sectionBEditButton2;

	@FindBy(xpath = "//select[@id='sectionA_metadata_id']")
	public WebElement sectionAMetaDataDropDown;

	@FindBy(xpath = "//div[@class='row employees-list']//label")
	public List<WebElement> sectionAMetaDataCheckBoxes;

	@FindBy(xpath = "(//a[normalize-space()='Add'])[4]")
	public WebElement sectionAMetaDataAdd;

	@FindBy(xpath = "//div[contains(@class,'dynamic_data_')]//div")
	public List<WebElement> sectionADisplayedCheckBox;

	@FindBy(xpath = "//button[@data-type='minus']//span")
	public WebElement addBlockMinus;

	@FindBy(xpath = "//button[@data-type='plus']//span")
	public WebElement addBlockPlus;

	@FindBy(xpath = "//input[@id='quantity']")
	public WebElement blockNumber;

	@FindBy(xpath = "(//a[normalize-space()='Add'])[5]")
	public WebElement sectionBMetaDataAdd;

	@FindBy(xpath = "//select[@id='sectionB_metadata_id']")
	public WebElement sectionB1MetaDataDropDown;

	@FindBy(xpath = "//div[@class='row employees-list']//label")
	public List<WebElement> sectionBMetaDataCheckBoxes;


	@FindBy(xpath = "//div[contains(@class,'section_Bblock_addappend_1')]//div//label")
	public List<WebElement> sectionB1DisplayedCheckBox;



	@FindBy(xpath = "(//div[@class='block-name scrollBox align-items-start stagecreate2-blockpad employee-blockname'])[2]//div//div//div")
	public List <WebElement> sectionBFirstBlockLabel ;

	@FindBy(xpath = "(//div[@class='block-name scrollBox align-items-start stagecreate2-blockpad employee-blockname'])[1]//div//div//div//h6")
	public List <WebElement> sectionBFirstBlockValue ;

	@FindBy(xpath = "(//ul[@id='pills-tab'])[2]//button")
	public WebElement sectionCButton ;


	@FindBy(xpath = "//div[@class='optional-check']//input")
	public List<WebElement> actionCheckBoxes ;

	@FindBy(xpath = "//div[@class='optional-check']//label")
	public List<WebElement> actionCheckBoxesLabel ;

	@FindBy(xpath = "//input[@id='sectionACheckbox']/following-sibling::span")
	public WebElement secAActToggleBtn;

	@FindBy(xpath = "//div[@id='sectionADropdown']")
	public WebElement ToggleBtnAState;

	@FindBy(xpath = "//select[@id='scrollbar_preference_a']")
	public WebElement secAActDropdown;

	@FindBy(xpath = "//input[@id='SectionAMinimized']/following-sibling::span")
	public WebElement secAActMinimized;

	@FindBy(xpath = "//input[@id='sectionBCheckbox']/following-sibling::span")
	public WebElement secBActToggleBtn;

	@FindBy(xpath = "//div[@id='sectionBDropdown']")
	public WebElement ToggleBtnBState;

	@FindBy(xpath = "//select[@id='scrollbar_preference_b' and @name='scrollbar_preference_b']")
	public WebElement secBActDropdown;

	@FindBy(xpath = "//input[@id='SectionBMinimized']/following-sibling::span")
	public WebElement secBActMinimized;

	@FindBy(xpath = "//input[@id='sectionCCheckbox']/following-sibling::span")
	public WebElement secCActToggleBtn;

	@FindBy(xpath = "//div[@id='sectionCDropdown']")
	public WebElement ToggleBtnCState;

	@FindBy(xpath = "//select[@id='scrollbar_preference_b' and @name='scrollbar_preference_c']")
	public WebElement secCActDropdown;

	@FindBy(xpath = "//input[@id='MasterFormCheckbox']/following-sibling::span")
	public WebElement masterFormToggleButton;

	//	Disposition Auto WebElements
	@FindBy(xpath = "//label[normalize-space()='AUTO']//input")
	public WebElement dispositionAutoRadioBtn;

	@FindBy(xpath = "//label[normalize-space()='AUTO']//span")
	public WebElement dispositionAutoRadioBtnState;

	@FindBy(xpath = "//label[normalize-space()='Within Process']//input")
	public WebElement dispositionAutoWithInRadioBtn;

	@FindBy(xpath = "//label[normalize-space()='Outside Process']//input")
	public WebElement dispositionAutoOutsideRadioBtn;

	@FindBy(xpath = "//select[@id='stage_name_deposion']")
	public WebElement dispositionAutoWithInDropdown;

	@FindBy(xpath = "//select[@id='deposition_process']")
	public WebElement dispositionAutoOutsideProcessDropdown;

	@FindBy(xpath = "//select[@id='deposition_sub_process']")
	public WebElement dispositionAutoOutsideSubProcessDropdown;

	@FindBy(xpath = "//select[@id='deposition_s_sub_process']")
	public WebElement dispositionAutoOutsideSubSubProcessDropdown;

	@FindBy(xpath = "//select[@id='is_company_stages']")
	public WebElement dispositionAutoOutsideStagesDropdown;

	//	Disposition Manual WebElements

	@FindBy(xpath = "//label[normalize-space()='Manual']//input")
	public WebElement dispositionManualRadioBtn;

	@FindBy(xpath = "//input[@id='is_default_stage']")
	public WebElement dispositionManualEnableStageToggle;

	@FindBy(xpath = "//label[normalize-space()='Within Process']//input")
	public WebElement dispositionManualWithInRadioBtn;

	@FindBy(xpath = "//label[normalize-space()='Outside Process']//input")
	public WebElement dispositionManualOutsideRadioBtn;

	@FindBy(xpath = "//select[@id='stage_name_deposion']")
	public WebElement dispositionManualWithInStages;

	@FindBy(xpath = "//select[@id='deposition_process']")
	public WebElement dispositionManualOutsideProcessDropdown;

	@FindBy(xpath = "//select[@id='deposition_sub_process']")
	public WebElement dispositionManualOutsideSubProcessDropdown;

	@FindBy(xpath = "//select[@id='deposition_s_sub_process']")
	public WebElement dispositionManualOutsideSubSubProcessDropdown;

	@FindBy(xpath = "//select[@id='is_company_stages']")
	public WebElement dispositionManualOutsideStages;
	
	@FindBy(id = "submt_single")
	public WebElement editSave;

	@FindBy(xpath = "(//button[normalize-space()='Continue'])[1]")
	public WebElement editSuccessContinue;

	@FindBy(xpath = "//img[@class='arrow-left']//parent::a")
	public WebElement editBackButton;

	@FindBy(xpath = "//div[contains(@class,'table_footer d-flex align')]//p")
	public WebElement showingOf;

	@FindBy(xpath = "//a[contains(@class,'page-link') and not(img[@alt='rgt_arrow'] or img[@alt='left_arrow'])]")
	public List<WebElement> tablePages;

//	Varibles------------------>
	
	String block1SelectedProcessDropdown;
	
	String block1SelectedSubProcessDropdown;
	
	String block1SelectedSubSubProcessDropdown;
	
	String SelectedSectionAMetadata;
	
	String SelectedSecBMetaData;
	
	String SelectedSecBMetaData2;
	
	String selectedDropdown;
	
	String selectedManualWithinStages;
	
	String selectedManualOutsideProcessDropdown;
	
	String selectedManualOutsideSubProcess;
	
	String selectedManualOutsideSubSubProcess;
	
	String SelectedManualOutsideStages;
	
	String selectedAutoWithInStages;
	
	String SelectedSectionADropdownInPreferences;
	
	String SelectedSectionBDropdownInPreferences;
	
	String SelectedSectionCDropdownInPreferences;
	
	String selectedAutoOutsideProcessDropdown;
	
	String selectedAutoOutsideSubProcessDropdown;
	
	String selectedAutoOutsideSubSubProcessDropdown;
	
	String selectedAutoOutsideStagesDropdown;
	
	List<String> ActualStrings;
	
	HashSet<String> SelectedCheckBoxesDisplayedInA;
	
	HashSet<String> SelectedCheckBoxesDisplayedInB1;
	HashSet<String> SelectedCheckBoxesDisplayedInB2;
	HashSet<String> checkedActions;

	FakeData fake;
	public StagePage() {
		PageFactory.initElements(driver, this);
		fake= new FakeData();
	}

//	Action Preferences Utils------------------------------->
	public void sectionDropdown(Select section,String selectedDropdown)
	{

		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		selectedDropdown = section.getFirstSelectedOption().getText();
		System.out.println("Default Selected Options: "+selectedDropdown);

		if(selectedDropdown.equals("Vertical"))
		{
			selectDropdownOption(section, "Horizontal");
//			selectedDropdown="Horizontal";

		}else if(selectedDropdown.equals("Horizontal"))
		{
			selectDropdownOption(section, "Vertical");
//			selectedDropdown="Vertical";
		}

	}

	public void toggleToggleButton(WebElement toggleButtonState,WebElement toggleButton,String section)
	{
		String toggleBtnState=toggleButtonState.getAttribute("style");

		if(toggleBtnState.contains("none"))
		{
			System.out.println("The "+ section +" toggle button is not toggled");
			jsClick(toggleButton) ;
			System.out.println("The "+ section +" toggle button is toggled now");
		}else
		{
			System.out.println("The "+ section +" toggle button is toggled");

		}
	}



	public void clickCheckBoxes(List<WebElement> Checkboxes)
	{
		for(int i=0;i<=4;i++)
		{
			int chechBoxIndexes=getRandomIndex(Checkboxes);
			jsClick(Checkboxes.get(chechBoxIndexes));
		}
	}

	//	Dropdown Utils------------------------->

	public static void selectDropdownOption(Select dropdown, String option) {
		System.out.println("Selected option before: " + dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText(option);
		System.out.println("Selected option after: " + dropdown.getFirstSelectedOption().getText());
		
	}

	public static void selectDropdownOptionByIndex(Select dropdown, int index) {
		System.out.println("Selected option before: " + dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(index);
		System.out.println("Selected option after: " + dropdown.getFirstSelectedOption().getText());
		
		
	}

	//	<----------------------------Dropdown Utils

//	RandomIndexGenearator
	public static int getRandomIndex(List<?> list) {
		if (list == null || list.isEmpty()) {
			throw new IllegalArgumentException("List must not be null or empty");
		}

		return ThreadLocalRandom.current().nextInt(list.size());
	}


	public void CommonNavigation() {
		click(driver,workFlowDesignButton);
		click(driver,stagesTab);

	}

	public void existingStageNameWitoutDatePicker()
	{
		CommonNavigation();
		searchBox.sendKeys("In Progress");
		click(driver,searchButton);
		Assert.assertEquals(stageName.getText(),"In Progress");

	}

	public void searchOnlyWithDatePicker()
	{
		CommonNavigation();
		click(driver,datePicker);
		click(driver,yearDropdown);
		click(driver,year);
		click(driver,monthDropdown);
		click(driver,month);
		click(driver,day);
		click(driver,searchButton);
	}
	

	public void clearAllFilters()
	{
		CommonNavigation();
		String value=stageName.getText();
		searchBox.sendKeys("In Progress");
		click(driver,searchButton);
		String value0=stageName.getText();
		assertEquals(value0, "In Progress");
		click(driver,clearAllfilter);
		String value1=stageName.getText();
		assertEquals(value, value1);
	}

	public void pagination()
	{
		CommonNavigation();

		Pagination.paginate(driver, rightArrow, leftArrow);

	}


	public void monthsInDatePicker() throws InterruptedException {
		CommonNavigation();
		click(driver,datePicker);
		wait.until(ExpectedConditions.visibilityOf(monthDropdown));
		click(driver,monthDropdown);
		Thread.sleep(1000);
		//		js.executeScript("arguments[0].style.display = 'block';", listOfMonths);
		List <String> capturedMonths=new ArrayList<>();
		for(int i=0;i<listOfMonths.size();i++)
		{
			//			String executorScript = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
			//					+ "var elementTop = arguments[0].getBoundingClientRect().top;"
			//					+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
			Object monthObject=js.executeScript("return arguments[0].innerText;",listOfMonths.get(i));
			String month=(String) monthObject;
			System.out.println(month);
			capturedMonths.add(month);


			//			var xpathResult = document.evaluate('//div[@class="xdsoft_label xdsoft_month"]//div[contains(@class,"xdsoft_option ")]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);
		}

		
		List<String> expectedMonths = List.of(
				"January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" );


		Assert.assertEquals(capturedMonths, expectedMonths,
				"The captured months should match the expected months");

	}

	public void viewingCreatedStage()
	{
		CommonNavigation();

		List<WebElement> StageNames=listOfDataSet;

		int randomIndex = ThreadLocalRandom.current().nextInt(StageNames.size());
		WebElement st=StageNames.get(0);

		wait.until(ExpectedConditions.elementToBeClickable(st));
		click(driver,st);

		//		Assert RefreshButton is Enabled
		assertTrue(refresh.isEnabled());

		for(WebElement blockText:sectionBFirstBlockLabel)
		{
			jsClick(sectionBFirstBlockLabel.get(0));
			String label = blockText.findElement(By.tagName("label")).getText();
			String value = blockText.findElement(By.tagName("h6")).getText();
			System.out.println(label + " : " + value);
			System.out.println(sectionCButton.getText());
			sectionCButton.click();


		}



		js.executeScript("arguments[0].scrollIntoView(true);", manualRadioButton);
		assertTrue(!manualRadioButton.isEnabled());
		js.executeScript("arguments[0].scrollIntoView(true);", autoRadioButton);
		assertTrue(!autoRadioButton.isEnabled());


	}



	public void numberOfStagesListed()
	{
		CommonNavigation();
		System.out.println(listOfDataSet.size());
		String a =showingOf.getText();
		String b=a.substring(a.indexOf("to")+3,a.indexOf("of")-1);
		System.out.println(a);
		int numberOfRecords= Integer.parseInt(b);
		assertEquals(listOfDataSet.size(), numberOfRecords);
	}


	public void duplicateFunction()
	{
		CommonNavigation();

		String beforeRecord=driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']")).getText();
		System.out.println(beforeRecord);

		int beforeDuplicateRecord=extractNumber(beforeRecord)+1;

		int randomIndex = ThreadLocalRandom.current().nextInt(duplicateButtons.size());

		WebElement dpb=duplicateButtons.get(randomIndex);
		WebElement stn=listOfDataSet.get(randomIndex);
		click(driver, dpb);

		duplicateYesButton.click();
		duplicateContinueButton.click();

		driver.navigate().refresh();

		String afterDup= driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']")).getText();
		System.out.println(afterDup);

		assertNotNull(afterDup);

		int afterDuplicateRecord=extractNumber(afterDup);

		assertEquals(beforeDuplicateRecord,afterDuplicateRecord);

	}

	public void deleteFunction()
	{
		CommonNavigation();

		String beforeDeleteRecord=driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']")).getText();
		System.out.println(beforeDeleteRecord);
		int beforeDelRecord =extractNumber(beforeDeleteRecord)-1;


		int randomIndex = ThreadLocalRandom.current().nextInt(deleteButtons.size());

		WebElement db=deleteButtons.get(randomIndex);
		assertTrue(db.isEnabled(),"Delete Button is not Enabled"+db);

		click(driver, db);

		confirmationdeleteButton.click();
		deleteSuccessButton.click();

		driver.navigate().refresh();

		String afterDel= driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']")).getText();
		System.out.println(afterDel);

		assertNotNull(afterDel);

		int afterDupRecord =extractNumber(afterDel);

		assertEquals(beforeDelRecord,afterDupRecord);

	}

	public void editButtons()
	{
		CommonNavigation();

		int randomPageIndex=getRandomIndex(tablePages);

		click(driver, tablePages.get(randomPageIndex));

		int randomIndexForEditButton = getRandomIndex(editButtons);
		WebElement editbtn=editButtons.get(randomIndexForEditButton);

		assertTrue(editbtn.isEnabled(),"Edit Button is not Enabled"+editbtn);

	}


	public void editStageNavigation()
	{
		CommonNavigation();

		int randomPageIndex=getRandomIndex(tablePages);

		click(driver, tablePages.get(randomPageIndex));

		int randomIndex = getRandomIndex(editButtons);

		click(driver, editButtons.get(randomIndex));

	}

	
	public void editStageForm()
	{
		CommonNavigation();

		int randomIndex = getRandomIndex(editButtons);

		click(driver, editButtons.get(1));


		System.out.println(editStageName.getText());
		String renaming=fake.lastName1();
		//		String renaming=generateRandomAlphabeticString(5);
		editStageName.clear();
		editStageName.sendKeys(renaming);



		//Selecting process Dropdown
		Select processDropdown = new Select(editProcess);
		selectDropdownOption(processDropdown, "CAPTURE");
		block1SelectedProcessDropdown=processDropdown.getFirstSelectedOption().getText();

		//Selecting Sub process Dropdown

		Select subProcessDropdown = new Select(editSubProcess);
		selectDropdownOptionByIndex(subProcessDropdown, 1);
		block1SelectedSubProcessDropdown=subProcessDropdown.getFirstSelectedOption().getText();
		//Selecting sub sub process Dropdown

		Select subSubProcessDropdown = new Select(editSubSubProcess);
		selectDropdownOptionByIndex(subSubProcessDropdown, 1);
		block1SelectedSubSubProcessDropdown=subSubProcessDropdown.getFirstSelectedOption().getText();


		Select calculation= new Select( editCalculationType);
		List<WebElement> calOptions=calculation.getOptions();

		ActualStrings=new ArrayList<>();
		for(WebElement options:calOptions)
		{
			String text=options.getText();
			System.out.println(
					options.getText());
			ActualStrings.add(text);

		}

		List<String> expectedStrings = List.of("Question Wise","Parameter Wise","Domain Wise");

		Assert.assertEquals(expectedStrings, ActualStrings);


		jsClick(sectionAEditButton);
		Select sectionAMetaData = new Select(sectionAMetaDataDropDown);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		selectDropdownOption(sectionAMetaData, "PVSL Capture Form_metadata");
		SelectedSectionAMetadata=sectionAMetaData.getFirstSelectedOption().getText();
		clickCheckBoxes(sectionAMetaDataCheckBoxes);

		jsClick(sectionAMetaDataAdd);


		SelectedCheckBoxesDisplayedInA=new HashSet<>();
		for(int a=0;a<	sectionADisplayedCheckBox.size();a++)
		{
			wait.until(ExpectedConditions.visibilityOf(sectionADisplayedCheckBox.get(a)));
			Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
			SelectedCheckBoxesDisplayedInA.add(sectionADisplayedCheckBox.get(a).getText());
			System.out.println("Section A CheckedBoxes: "+(a+1)+sectionADisplayedCheckBox.get(a).getText());
		}


		int blocks=Integer.parseInt(blockNumber.getAttribute("value")) ;

		if(blocks==2)
		{
			System.out.println("Number of Blocks: "+blocks);

		}else if(blocks>2)
		{
			addBlockMinus.click();
			System.out.println("Number of Blocks: "+blocks);
		}
		else if(blocks<2)
		{
			addBlockPlus.click();
			System.out.println("Number of Blocks: "+blocks);
		}


		//		Section B
		jsClick(sectionBEditButton1);

		Select sectionBMetaData1 = new Select(sectionB1MetaDataDropDown);
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		selectDropdownOption(sectionBMetaData1, "PVSL_Capture Customer Info_metadata");
		SelectedSecBMetaData=sectionBMetaData1.getFirstSelectedOption().getText();

		clickCheckBoxes(sectionBMetaDataCheckBoxes);
		jsClick(sectionBMetaDataAdd);


		 SelectedCheckBoxesDisplayedInB1=new HashSet<>();
		for(int a=0;a<	sectionB1DisplayedCheckBox.size();a++)
		{
			Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
			SelectedCheckBoxesDisplayedInB1.add(sectionB1DisplayedCheckBox.get(a).getText());
			System.out.println("Section B Block CheckedBoxes: "+(a+1)+sectionB1DisplayedCheckBox.get(a).getText());
		}

		//		Section B Block 2
		jsClick(sectionBEditButton2);


		Select sectionBMetaData2 = new Select(sectionB1MetaDataDropDown);
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		selectDropdownOption(sectionBMetaData2, "PVSL_Capture Form Final_metadata");
		SelectedSecBMetaData2=sectionBMetaData2.getFirstSelectedOption().getText();


		clickCheckBoxes(sectionBMetaDataCheckBoxes);

		jsClick(sectionBMetaDataAdd);


		SelectedCheckBoxesDisplayedInB2=new HashSet<>();
		for(int a=0;a<	sectionB1DisplayedCheckBox.size();a++)
		{
			Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
			SelectedCheckBoxesDisplayedInB2.add(sectionB1DisplayedCheckBox.get(a).getText());
			System.out.println("Section B 2nd Block CheckedBoxes: "+(a+1)+sectionB1DisplayedCheckBox.get(a).getText());
		}

		/*
		 * actionCheckBox();
		 * 
		 * secPreferences();
		 * 
		 * disposition();
		 */

		//		editSave.click();
		//		wait.until(ExpectedConditions.visibilityOf(editSuccessContinue));
		//		editSuccessContinue.click();
		//
		//		click(driver, editBackButton);
		//
		//		assertEquals(listOfDataSet.get( randomIndex).getText(), renaming);
		//		


	}

	public void actionCheckBox()
	{
		CommonNavigation();
		click(driver, editButtons.get(0));

		//		js.executeScript("arguments[0].scrollIntoView(true);", actionCheckBoxes.get(5));

		clickCheckBoxes(actionCheckBoxes);

		checkedActions=new HashSet<>();
		for(int c=0;c<actionCheckBoxes.size();c++)
		{

			if(actionCheckBoxes.get(c).isSelected())
			{
				System.out.println("Actions Checked: "+actionCheckBoxesLabel.get(c).getText()); 
				checkedActions.add(actionCheckBoxesLabel.get(c).getText());
			}
		}

	}

	public void secPreferences()
	{
		CommonNavigation();
		click(driver, editButtons.get(0));

		toggleToggleButton(ToggleBtnAState,secAActToggleBtn,"Section A");

		Select sectionADropdown = new Select(secAActDropdown);
		sectionDropdown(sectionADropdown,"selectedDropdownSectionA");
		SelectedSectionADropdownInPreferences=sectionADropdown.getFirstSelectedOption().getText();
		
		toggleToggleButton(ToggleBtnBState,secBActToggleBtn,"Section B");

		Select sectionBDropDown = new Select(secBActDropdown);
		sectionDropdown(sectionBDropDown,"selectedDropdownSectionB");
		SelectedSectionBDropdownInPreferences=sectionBDropDown.getFirstSelectedOption().getText();
		toggleToggleButton(ToggleBtnCState,secCActToggleBtn,"Section C");

		Select sectionCDropDown = new Select(secCActDropdown);
		sectionDropdown(sectionCDropDown,"selectedDropdownSectionC");
		SelectedSectionCDropdownInPreferences=sectionCDropDown.getFirstSelectedOption().getText();

	}


	public void disposition()
	{
		CommonNavigation();
		click(driver, editButtons.get(0));
		//	Disposition Auto or Manual
		if(dispositionAutoRadioBtn.isSelected())
		{
			//		Modifying to Manual if Auto Selected
			System.out.println(dispositionManualRadioBtn.isSelected()+" Disposition Auto Radio Button Was Selected");
			jsClick(dispositionManualRadioBtn);
			System.out.println(dispositionManualRadioBtn.isSelected()+" Disposition Manual Radio Button is Selected");

			//		Enabling Stages In Manual 
			if(dispositionManualEnableStageToggle.isSelected()) {
				System.out.println(dispositionManualEnableStageToggle.isSelected()+" Enable Stages is selected");
			}else {
				jsClick(dispositionManualEnableStageToggle);
				System.out.println(dispositionManualEnableStageToggle.isSelected()+" Enable Stages was not selected, selected now");
				
				if (dispositionManualOutsideRadioBtn.isSelected()) {
//					Editing if Manual Outside Process is Selected
					jsClick(dispositionManualWithInRadioBtn);

					Select ManualWithInStages= new Select(dispositionManualWithInStages);

					selectDropdownOptionByIndex(ManualWithInStages, getRandomIndex(ManualWithInStages.getOptions()));
					selectedManualWithinStages=ManualWithInStages.getFirstSelectedOption().getText();
				}
				else {
//					Editing as Auto if Manual Within Process is Selected
					jsClick(dispositionManualOutsideRadioBtn);
					
					Select ManualOutsideProcess=new Select(dispositionManualOutsideProcessDropdown);
					selectDropdownOption(ManualOutsideProcess, "CAPTURE");
					selectedManualOutsideProcessDropdown=ManualOutsideProcess.getFirstSelectedOption().getText();
					
					Select ManualOutsideSubProcess=new Select(dispositionManualOutsideSubProcessDropdown);
					selectDropdownOptionByIndex(ManualOutsideSubProcess, 1);
					selectedManualOutsideSubProcess=ManualOutsideSubProcess.getFirstSelectedOption().getText();
					
					Select ManualOutsideSubSubProcess=new Select(dispositionManualOutsideSubSubProcessDropdown);
					selectDropdownOptionByIndex(ManualOutsideSubSubProcess, 1);
					selectedManualOutsideSubSubProcess=ManualOutsideSubSubProcess.getFirstSelectedOption().getText();
					
					Select ManualOutsideStages= new Select(dispositionManualOutsideStages);
					selectDropdownOptionByIndex(ManualOutsideStages, getRandomIndex(ManualOutsideStages.getOptions()));
					SelectedManualOutsideStages=ManualOutsideStages.getFirstSelectedOption().getText();
					
				}
			}

		}else {
			//		Modifying to Auto if Manual Selected

			System.out.println(dispositionAutoRadioBtn.isSelected()+" Disposition Manual Radio Button Was Selected");
			jsClick(dispositionAutoRadioBtn);
			System.out.println(dispositionAutoRadioBtn.isSelected()+" Disposition Auto Radio Button is Selected");

			if(dispositionAutoOutsideRadioBtn.isSelected()) {
			jsClick(dispositionAutoWithInRadioBtn);
			
			Select autoWithInStages= new Select(dispositionAutoWithInDropdown);
			selectDropdownOptionByIndex(autoWithInStages, getRandomIndex(autoWithInStages.getOptions()));
			selectedAutoWithInStages=autoWithInStages.getFirstSelectedOption().getText();
			
			}else {
				
				jsClick(dispositionAutoOutsideRadioBtn);
				Select autoOutsideProcessDropdown=new Select(dispositionAutoOutsideProcessDropdown);
				selectDropdownOption(autoOutsideProcessDropdown, "CAPTURE");
				selectedAutoOutsideProcessDropdown=autoOutsideProcessDropdown.getFirstSelectedOption().getText();
				
				Select autoOutsideSubProcessDropdown=new Select(dispositionAutoOutsideSubProcessDropdown);
				selectDropdownOptionByIndex(autoOutsideSubProcessDropdown, 1);
				selectedAutoOutsideSubProcessDropdown=autoOutsideSubProcessDropdown.getFirstSelectedOption().getText();
				
				Select autoOutsideSubSubProcessDropdown=new Select(dispositionAutoOutsideSubSubProcessDropdown);
				selectDropdownOptionByIndex(autoOutsideSubSubProcessDropdown, 1);
				selectedAutoOutsideSubProcessDropdown=autoOutsideSubSubProcessDropdown.getFirstSelectedOption().getText();
				
				Select autoOutsideStagesDropdown=new Select(dispositionAutoOutsideStagesDropdown);
				selectDropdownOptionByIndex(autoOutsideStagesDropdown, getRandomIndex(autoOutsideStagesDropdown.getOptions()));
				selectedAutoOutsideStagesDropdown=autoOutsideStagesDropdown.getFirstSelectedOption().getText();

			}
			
		}

	}

	public void editSectionAAndB()
	{
		CommonNavigation();

		click(driver, editButtons.get(getRandomIndex(editButtons)));

		jsClick(sectionAEditButton);

		Select sectionMetaData = new Select(sectionAMetaDataDropDown);
		System.out.println(sectionMetaData.getOptions().size());
		System.out.println(sectionMetaData.getFirstSelectedOption().getText());
		;		softAssert.assertFalse(sectionMetaData.getFirstSelectedOption().getText().equals("Select Metadata"),
				"MetaData is not selected; the default selected option is 'Select Metadata'");

		for(WebElement metaData:sectionMetaData.getOptions())
		{
			System.out.println(metaData.getText());
		}

		softAssert.assertAll();

	}




}
