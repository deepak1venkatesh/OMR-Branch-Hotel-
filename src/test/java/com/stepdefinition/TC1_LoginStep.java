package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Execution steps for Login Feature File
 *
 */
public class TC1_LoginStep extends Baseclass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Used to Open Browser and URL
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("User is on the OMR Branch Hotel Page")
	public void user_is_on_the_omr_branch_hotel_page() throws FileNotFoundException, IOException 
	{
		getdriver(getPropertyFileValue("browser"));
		launchUrl(getPropertyFileValue("url"));
		maximizeWindow();
		giveImplicitWait(10);
	}

	/**
	 * @see Used to enter username,password
	 * @param username
	 * @param password
	 */
	@When("User enters {string},{string}")
	public void user_enters(String username, String password) {
		pom.getLoginpage().login(username, password);
	}

	/**
	 * @see Used to enter username,password and click using enter key
	 * @param username
	 * @param password
	 */
	@When("User enters {string},{string} with enter key")
	public void user_enters_with_enter_key(String username, String password) {
		pom.getLoginpage().loginwithenterkey(username, password);
	}

	/**
	 * @see User to Verify the error message
	 * @param errormessage
	 */
	@Then("User should verify error message after login {string}")
	public void user_should_verify_error_message_after_login(String errormessage) {
		String Actualerrormsg = pom.getLoginpage().errormsg();
		System.out.println(pom.getLoginpage().errormsg());
		Assert.assertTrue("Verify Error Message", Actualerrormsg.contains(errormessage));
		HooksClass.sc.log("Verify Error Message Expected Value : " + errormessage + " Actual Value : " + Actualerrormsg);
	}

}
