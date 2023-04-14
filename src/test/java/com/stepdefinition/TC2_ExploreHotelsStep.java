package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Execution steps for ExploreHotel Feature File
 *
 */
public class TC2_ExploreHotelsStep extends Baseclass
{
	PageObjectManager pom=new PageObjectManager();

	/**
	 * @see Used to enter username and password
	 * @param username
	 * @param password
	 */
	@When("User login {string} and {string}")
	public void user_login_and(String username, String password) 
	{
		pom.getExplorehotelpage().login(username, password);
	}
	
	/**
	 * @see Used to enter all the details in Search hotel page 
	 * @param state
	 * @param city
	 * @param roomType
	 * @param checkin
	 * @param checkout
	 * @param noofRooms
	 * @param noofadults
	 * @param noofkids
	 */
	@When("User search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_search_hotel_and(String state, String city, String roomType, String checkin, String checkout, String noofRooms, String noofadults, String noofkids) 
	{
		pom.getExplorehotelpage().enterallfields(state, city, roomType, checkin, checkout, noofRooms, noofadults, noofkids);
		
	}
	
	/**
	 * @see Used to open Browser and URL
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("User is on OMR branch hotel page")
	public void user_is_on_omr_branch_hotel_page() throws FileNotFoundException, IOException 
	{
		getdriver(getPropertyFileValue("browser"));
		launchUrl(getPropertyFileValue("url"));
		maximizeWindow();
		giveImplicitWait(10);
	}
	/**
	 * @see Used to Enter the Location details of the Hotel
	 * @param state
	 * @param city
	 * @param checkin
	 * @param checkout
	 * @param noofRooms
	 * @param noofadults
	 */
	@When("User search hotel {string},{string},{string},{string},{string} and {string}")
	public void user_search_hotel_and(String state, String city, String checkin, String checkout, String noofRooms, String noofadults) 
	{
		pom.getExplorehotelpage().entermandatoryfields(state, city, checkin, checkout, noofRooms, noofadults);
		
	}
	
	/**
	 * @see Used to click Search button
	 */
	@When("User click search button")
	public void user_click_search_button() 
	{
		pom.getExplorehotelpage().nofieldsEntered();
	}
	
	/**
	 * @see Used to verify 6 error messagess
	 * @param errormessagestate
	 * @param errormessagecity
	 * @param errormessagecheckin
	 * @param errormessagecheckout
	 * @param errormessagenoofroom
	 * @param errormessagenoofadults
	 */
	@Then("User should verify six error message {string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_error_message_and(String errormessagestate, String errormessagecity, String errormessagecheckin, String errormessagecheckout, String errormessagenoofroom, String errormessagenoofadults) 
	{
//		Assert.assertEquals("Verify State error message", errormessagestate, pom.getExplorehotelpage().stateErrorMsg());
//		Assert.assertEquals("Verify City error message", errormessagecity, pom.getExplorehotelpage().cityerrorMsg());
//		Assert.assertEquals("Verify ChkInDate error message", errormessagecheckin, pom.getExplorehotelpage().ChkInErrorMsg());
//		Assert.assertEquals("Verify ChkOutDate error message", errormessagecheckout, pom.getExplorehotelpage().ChkOutErrorMsg());
//		Assert.assertEquals("Verify NoofRooms error message", errormessagenoofroom, pom.getExplorehotelpage().noofroomsErrorMsg());
//		Assert.assertEquals("Verify NoofAdults error message", errormessagenoofadults, pom.getExplorehotelpage().noofAdultsErrorMsg());
		
		List<String> ActualErrorMSG = pom.getExplorehotelpage().ActSixErrorMsg();
		List<String> ExpErrorMSG = pom.getExplorehotelpage().ExpSixErrorMsg(errormessagestate, errormessagecity, errormessagecheckin, errormessagecheckout, errormessagenoofroom, errormessagenoofadults);
		Assert.assertEquals("Verify Six Error Message", pom.getExplorehotelpage().ExpSixErrorMsg(errormessagestate, errormessagecity, errormessagecheckin, errormessagecheckout, errormessagenoofroom, errormessagenoofadults),pom.getExplorehotelpage().ActSixErrorMsg() );
		
		HooksClass.sc.log("Verify Error Message Expected Message : " + ExpErrorMSG + " Actual Message : " + ActualErrorMSG);
	}
	
	/**
	 * @see Used to enter the details of room type
	 * @param state
	 * @param city
	 * @param roomType
	 * @param roomType1
	 * @param roomType2
	 * @param checkin
	 * @param checkout
	 * @param noofRooms
	 * @param noofadults
	 * @param noofkids
	 */
	@When("User search hotel {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_search_hotel_and(String state, String city, String roomType,String roomType1,String roomType2, String checkin, String checkout, String noofRooms, String noofadults, String noofkids) 
	{
		pom.getExplorehotelpage().ThreeRoomTypeEnter(state, city, roomType, roomType1, roomType2, checkin, checkout, noofRooms, noofadults, noofkids);
	}

	/**
	 * @see verify the success messages
	 * @param successmessagefilter
	 */
	@Then("User should verify the success message filter room type {string}")
	public void user_should_verify_the_success_message_filter_room_type(String successmessagefilter) 
	{
		String ActualSuccessMessage = pom.getSelecthotelpage().threeRoomTypeMsg();
		Assert.assertEquals("Verify 3 room type message",successmessagefilter , pom.getSelecthotelpage().threeRoomTypeMsg());
		HooksClass.sc.log("Verify Success Message Expected Value : " + successmessagefilter + " Actual Message : " + ActualSuccessMessage);
	}

	








}
