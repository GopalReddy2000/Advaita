package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;

public class DocumentNamePage extends TestBase {

    @FindBy(xpath="//a[contains(@href,'document_name') and not(contains(@href,'_create'))]")
    WebElement documentNames;

    @FindBy(linkText="+ Create")
    WebElement documentNamesCreate;

    @FindBy(id="group_name")
    WebElement documentNameInputField;

    @FindBy(xpath="//button[text()='Create']")
    WebElement createButton;

    @FindBy(xpath="//button[text()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath="//select[@name='filter_document_names']")
    WebElement documentSearchDropdown;

    @FindBy(xpath="//img[@alt='filter_search' and @class='img-fluid']")
    WebElement searchButton;

    @FindBy(xpath="//img[@class='filter_search']")
    WebElement clearAllFilter;

    @FindBy(css="img.delete_groupdata")
    WebElement delete;

    @FindBy(css="img.edit_documentdata")
    WebElement edit;

    @FindBy(xpath="//td[1]")
    public List<WebElement> tableRecords;

    @FindBy(xpath="//button[text()='Delete']")
    WebElement confirmationDelete;

    @FindBy(xpath="//button[text()=' Update ']")
    WebElement update;

    

    UserSetupPage userSetupPage=new UserSetupPage();
    public DocumentNamePage()
    {
        PageFactory.initElements(driver,this);
    }

    public DocumentNamePage navToDocumentNames()
    {
        navigateWithinUserSetup(documentNames);

        return this;
    }

    public DocumentNamePage createDocument(String documentName)
    {
        documentNamesCreate.click();
        sendKeys(documentNameInputField,documentName);
        createButton.click();
        unWait(1);
        userSetupPage.continueButton.click();

        jsWindowsScrollIntoView(tableRecords.get(tableRecords.size()-1));
        unWait(1);
        String actualRecord =tableRecords.get(tableRecords.size()-1).getText();

        assertEquals(documentName,actualRecord);

        return this;
    }
    public String actualRecord;
    public DocumentNamePage validateInUserSetupPage(String documentName)
    {
        navigateWithinUserSetup(userSetupPage.userManagement);
        userSetupPage.userMappingbutton.click();
        userSetupPage.userDocuments.click();
        Select select=new Select(userSetupPage.userDocumentsDropdown.get(0));
        actualRecord=select.getOptions().get(select.getOptions().size()-1).getText();
        ;
        return this;
    }

    public DocumentNamePage tableActions(String usernameToDoAction )
    {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : rows) {

            WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));
            try {
                if (usernameToDoAction.equals(usernameColumn.getText())) {

                    WebElement deleteButton = row.findElement(By.xpath(".//img[@alt='delete-icon ']"));
                    deleteButton.click();
                    confirmationDelete.click();
                    unWait(1);
                    Assert.assertTrue(userSetupPage.continueButton.isDisplayed());
                    userSetupPage.continueButton.click();
                    System.out.println(usernameToDoAction + " Successfully Deleted");
                    break;

                }else {
                    System.out.println(usernameToDoAction+" Is not Found");
                }
            }catch (NoSuchElementException e)
            {
                System.out.println(e.getMessage());
            }
        }

        return this;
    }


    public DocumentNamePage editAndVerify(String usernameToDoAction, String newName) {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        boolean isEdited = false;

        for (WebElement row : rows) {
            WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

            if (usernameToDoAction.equals(usernameColumn.getText())) {
                WebElement editButton = row.findElement(By.xpath(".//img[@alt='table-edit']"));
                editButton.click();
                sendKeys(documentNameInputField, newName);
                update.click();
                unWait(1);
                userSetupPage.continueButton.click();
                isEdited = true;
                break;
            }
        }

        if (!isEdited) {
            System.out.println(usernameToDoAction + " not found in the table.");
            return this;
        }

        boolean verificationResult = driver.findElements(By.xpath("//table/tbody/tr/td[1][text()='" + usernameToDoAction + "']")).isEmpty() &&
                !driver.findElements(By.xpath("//table/tbody/tr/td[1][text()='" + newName + "']")).isEmpty();

        if (verificationResult) {
            Assert.assertTrue(true);
            System.out.println("Verification Passed: " + usernameToDoAction + " is not found and " + newName + " is found.");

        } else {
            Assert.fail();
            System.out.println("Verification Failed: " + usernameToDoAction + " might still be present or " + newName + " not found.");
        }

        return this;
    }


    public DocumentNamePage search(String searchText)
    {
        try {
            selectByVisibleText(documentSearchDropdown,searchText);
            searchButton.click();

        }catch (NoSuchElementException e)
        {
            throw new NoSuchElementException("There is no such Record as: "+searchText);
        }
        return this;
    }


}
