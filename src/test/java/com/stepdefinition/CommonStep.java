package com.stepdefinition;

import org.junit.Assert;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Used to maintain common steps for the projects
 *
 */
public class CommonStep extends Baseclass
{
PageObjectManager pom=new PageObjectManager();

/**
 * @see Used to verify success message after login
 * @param expLoginSuccessMessage
 */
@Then("User should verify Success message after login {string}")
public void user_should_verify_success_message_after_login(String expLoginSuccessMessage) 
{
	String ActualsuccessMsg = pom.getExplorehotelpage().SuccessMsg();
	Assert.assertEquals("Verify after login success message", expLoginSuccessMessage, pom.getExplorehotelpage().SuccessMsg());
	HooksClass.sc.log("Verify Error Message Expected Value : " + expLoginSuccessMessage + " Actual Value : " + ActualsuccessMsg);
}
//
//
@Then("User should verify success message {string}")
public void user_should_verify_success_message(String Successname) 
{
}





}
