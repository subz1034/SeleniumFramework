package com.test.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.page.TestClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogicClass {

	WebDriver driver;
	TestClass testObject;

	@BeforeSuite
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeTest
	void setupTest() {
		driver = new ChromeDriver();
		testObject = new TestClass(driver);
		driver.get("file:///C:/Users/drnis/git/SeleniumFramework/Resolver_TestFramework/src/test/resources/QE-index.html");
		
	}
	
	@AfterTest
	void afterTest() {
		System.out.println("****************************");
	}

	@AfterSuite
	void teardown() {
		driver.quit();
	}

	/*
	 * Exercise 1
	 * Assert that both the email address and password inputs are present as well as the login button
	 * Enter in an email address and password combination into the respective fields
	 */
	@Test
	void test1() {
		try {

			System.out.println("************Test 1****************");
			String title = driver.getTitle();
			System.out.println("Title : " + title);

			testObject.verifyTestPageElementsAndLogin(driver);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * In the test 2 div, assert that there are three values in the listgroup
	 * Assert that the second list item's value is set to "List Item 2"
	 * Assert that the second list item's badge value is 6
	 */
	@Test
		void test2() {
		try {
			System.out.println("************Test 2****************");
			testObject.verifyTestPageListItems(driver);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * In the test 3 div, Assert that "Option 1" is the default selected value
	 * Select "Option 3" from the select list
	 */
	@Test
	void test3() {
		try {

			System.out.println("************Test 3****************");
			testObject.verifyTestPageSelectDropdown(driver);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * In the test 4 div, assert that the first button is enabled and that the second button is disabled
	 */
	@Test
	void test4() {
		try {

			System.out.println("************Test 4****************");

			testObject.verifyTestPageSelectButtons(driver);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * In the test 5 div, wait for a button to be displayed (note: the delay is random) and then click it
	 * Once you've clicked the button, assert that a success message is displayed
	 * Assert that the button is now disabled
	 */
	@Test
	void test5() {
		try {

			System.out.println("************Test 5****************");
			testObject.verifyTestPageWaitAndClickButton(driver);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Write a method that allows you to find the value of any cell on the grid
	 * Use the method to find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner)
	 * Assert that the value of the cell is "Ventosanzap"
	 */
	@Test
	void test6() {
		try {

			System.out.println("************Test 6****************");

			testObject.verifyTestPageTable(driver);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
