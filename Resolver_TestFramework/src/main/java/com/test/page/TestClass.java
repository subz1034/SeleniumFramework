package com.test.page;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestClass {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	@FindBy(xpath = "//*[@id='inputEmail']")

	WebElement testPageUserName;

	@FindBy(xpath = "//*[@id='inputPassword']")

	WebElement testPagePassword;

	@FindBy(xpath = "//button[text()='Sign in']")

	WebElement testPageSignInBtn;

	@FindBy(xpath = "//h2[text()='Sample Login']")

	WebElement testPageHeading;

	@FindBy(xpath = "//ul[@class='list-group']/li[contains(text(),'List Item 2')]")

	WebElement testPageListItem2;

	@FindBy(xpath = "//ul[@class='list-group']/li[contains(text(),'List Item 2')]/span")

	WebElement testPageListItemBadge2;

	@FindBy(xpath = "//*[@id=\"test-2-div\"]")

	WebElement testPageListItem;

	@FindBy(xpath = "//*[@id=\"test-3-div\"]")

	WebElement testPageDropDown;

	@FindBy(xpath = "//*[@id=\"test-4-div\"]")

	WebElement testPageButtonItem;

	@FindBy(xpath = "//*[@id=\"test-5-div\"]")

	WebElement testPageSimpleButtonItem;

	@FindBy(xpath = "//*[@id=\"test-6-div\"]")

	WebElement testPageTableElement;

	@FindBy(xpath = "//*[@id=\"dropdownMenuButton\"]")

	WebElement testPageDropdownMenuButton;

	@FindBy(xpath = "//a[text()=\"Option 3\"]")

	WebElement testPageDropdownMenuOption3;

	@FindBy(xpath = "//*[@class=\"btn btn-lg btn-primary\"]")

	WebElement testPageButtonPrimary;

	@FindBy(xpath = "//*[@class=\"btn btn-lg btn-secondary\"]")

	WebElement testPageButtonSecondary;

	@FindBy(xpath = "//*[@id=\"test5-button\"]")

	WebElement testPageWaitButton;

	@FindBy(xpath = "//*[@id=\"test5-alert\"]")

	WebElement testPageWaitButtonAlert;

	@FindBy(xpath = "//*[@class=\"table table-bordered table-dark\"]")

	WebElement testPageTableField;
	
	@FindBy(xpath = "//*[@class=\"table table-bordered table-dark\"]//tbody/tr")

	WebElement testPageTableBodyRow;
	
	@FindBy(xpath = "//*[@class=\"table table-bordered table-dark\"]//tbody/tr[1]/td")

	WebElement testPageTableBodyCol;
	
	

	public TestClass(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Assert that both the email address and password inputs are present as well as
	// the login button

	public void verifyTestPageElementsAndLogin(WebDriver driver) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(testPageHeading));
		System.out.println("Page Heading is : " + testPageHeading.getText());

		testPageUserName.sendKeys("Resolver@gmail.com");
		testPagePassword.sendKeys("Resolver");
		testPageSignInBtn.click();

		Thread.sleep(5000);

	}

	/*
	 * Assert that there are three values in the listgroup Assert that the second
	 * list item's value is set to "List Item 2" Assert that the second list item's
	 * badge value is 6
	 */

	public void verifyTestPageListItems(WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", testPageListItem);

		int listItemSize = driver.findElements(By.xpath("//ul[@class='list-group']/li")).size();
		Assert.assertEquals(listItemSize, 3, "Size of ListItem is not matching");

		Assert.assertTrue(testPageListItem2.getText().trim().contains("List Item 2"),
				"Second list item's value is not matching");

		Assert.assertEquals(testPageListItemBadge2.getText(), "6", "Badge Value  of Second List item is not matching");
		
		System.out.println("Badge Value is :"+testPageListItemBadge2.getText());

		Thread.sleep(5000);

	}

	/*
	 * In the test 3 div, assert that "Option 1" is the default selected value
	 * Select "Option 3" from the select list
	 */

	public void verifyTestPageSelectDropdown(WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", testPageDropDown);

		Assert.assertEquals(testPageDropdownMenuButton.getText().trim(), "Option 1",
				"Default value of Dropdown Menubutton item is not matching");

		testPageDropdownMenuButton.click();
		testPageDropdownMenuOption3.click();

		Assert.assertEquals(testPageDropdownMenuButton.getText().trim(), "Option 3",
				"Value of Dropdown Menubutton item is not matching");
		
		System.out.println("DropDown Menubutton Value is :"+testPageDropdownMenuButton.getText().trim());

		Thread.sleep(5000);

	}

	/*
	 * In the test 4 div, assert that the first button is enabled and that the
	 * second button is disabled
	 */

	public void verifyTestPageSelectButtons(WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", testPageButtonItem);

		Assert.assertEquals(testPageButtonPrimary.isEnabled(), true, "Primary button is not enabled");
		Assert.assertEquals(testPageButtonSecondary.isEnabled(), false, "Secondary button is enabled");
		
		System.out.println("Both Buttons are verified");

		Thread.sleep(5000);

	}

	/*
	 * In the test 5 div, wait for a button to be displayed (note: the delay is
	 * random) and then click it Once you've clicked the button, assert that a
	 * success message is displayed Assert that the button is now disabled
	 */

	public void verifyTestPageWaitAndClickButton(WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", testPageSimpleButtonItem);

		wait.until(ExpectedConditions.elementToBeClickable(testPageWaitButton));
		Assert.assertEquals(testPageWaitButton.isEnabled(), true, "Wait button is not enabled");
		testPageWaitButton.click();
		testPageWaitButtonAlert.isDisplayed();
		Assert.assertEquals(testPageWaitButtonAlert.getText().trim(), "You clicked a button!",
				"Alert message is not displayed");
		System.out.println("Alert message :"+testPageWaitButtonAlert.getText().trim());
		Assert.assertEquals(testPageWaitButton.isEnabled(), false, "Wait button is enabled");

		Thread.sleep(5000);

	}

	/*
	 * Write a method that allows you to find the value of any cell on the grid Use
	 * the method to find the value of the cell at coordinates 2, 2 (staring at 0 in
	 * the top left corner) Assert that the value of the cell is "Ventosanzap"
	 */

	public void verifyTestPageTable(WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", testPageTableElement);
		Assert.assertEquals(getCellValueFromTable(2, 2), "Ventosanzap", "Cell value is not matching");

		Thread.sleep(5000);

	}

	public String getCellValueFromTable(int row,int col) {

		String value="";
		int rowCount=driver.findElements(By.xpath("//*[@class=\"table table-bordered table-dark\"]//tbody/tr")).size();
		int colCount=driver.findElements(By.xpath("//*[@class=\"table table-bordered table-dark\"]//tbody/tr[1]/td")).size();
		
		if(row<rowCount && col<colCount)
		{	
			row=row+1;
			col=col+1;
			value=driver.findElement(By.xpath("//*[@class='table table-bordered table-dark']//tbody/tr["+row+"]/td["+col+"]")).getText();
			System.out.println("Value inside cell is :"+value);
		}
		else {
			value=null;
		}
		
		return value;

	}

}
