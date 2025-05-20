package com.advaita.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;

public class DynamicXpath extends TestBase {

	public static WebElement dataSetField(int dataSetFieldIndex) {

		String xpath = String.format("//input[@name='form-%d-dataset_fieldname']", dataSetFieldIndex);
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement dataSetLabelField(int dataSetLabelFieldIndex) {

		String xpath = String.format("//input[@name='form-%d-ds_field_label']", dataSetLabelFieldIndex);
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement dataSetTypeDropDown(int dataSetTypeDropDownIndex) {

		String xpath = String.format("//select[@name='form-%d-ds_field_type']", dataSetTypeDropDownIndex);
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement dataSetMaxLength(int dataSetMaxLengthIndex) {

		String xpath = String.format("//input[@name='form-%d-ds_field_value']", dataSetMaxLengthIndex);
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement dataSetMandatoryDropDown(int dataSetMandatoryDropDownIndex) {

		String xpath = String.format("//select[@name='form-%d-ds_is_mandatory']", dataSetMandatoryDropDownIndex);
		return driver.findElement(By.xpath(xpath));
	}
	
	
//Example for String
	
	
	String someString = "gdsusdy";
	String xpath = String.format("//select[@name='form-%s-ds_field_type']", someString);
	

}
