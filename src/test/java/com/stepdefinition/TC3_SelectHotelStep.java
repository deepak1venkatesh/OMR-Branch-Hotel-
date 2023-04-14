package com.stepdefinition;

import java.util.List;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Execution steps for Select Hotel feature file
 *
 */
public class TC3_SelectHotelStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Used to select hotel and accept alert
	 */
	@When("User select hotel and accepting the alert")
	public void user_select_hotel_and_accepting_the_alert() {
		pom.getSelecthotelpage().SelectHotelPageOk();
	}

	/**
	 * @see Used to verify success message
	 * @param SelecthotelSuccessMsg
	 */
	@Then("User should verify success message {string} after accepting the alert message and save the hotel name")
	public void user_should_verify_success_message_after_accepting_the_alert_message_and_save_the_hotel_name(
			String SelecthotelSuccessMsg) {
		pom.getSelecthotelpage().acceptAlert();
		Assert.assertTrue("Verify Book Hotel Message",
				pom.getSelecthotelpage().HotelBookSuccess().contains(SelecthotelSuccessMsg));
	}

	/**
	 * @see Used to select hotel room details
	 * @param state
	 * @param city
	 * @param roomType
	 * @param checkin
	 * @param checkout
	 * @param noofRooms
	 * @param noofadults
	 * @param noofkids
	 */
	@When("User select hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_select_hotel_and(String state, String city, String roomType, String checkin, String checkout,
			String noofRooms, String noofadults, String noofkids) {
		pom.getSelecthotelpage().enterallfields(state, city, roomType, checkin, checkout, noofRooms, noofadults,
				noofkids);
	}

	/**
	 * @see Used to select hotel
	 */
	@When("User select hotel")
	public void user_select_hotel() {
		pom.getSelecthotelpage().SelectHotelPageOk();
	}

	/**
	 * @see used to dismiss the alert
	 */
	@When("User Dismiss the alert")
	public void user_dismiss_the_alert() {
		pom.getSelecthotelpage().DismissAlert();
	}

	/**
	 * @see Used to sort the price from high to low using radio button
	 */
	@When("User select the radio button sort price High to Low")
	public void user_select_the_radio_button_sort_price_high_to_low() {
		pom.getSelecthotelpage().SortButtonClick();
	}

	/**
	 * @see Used to verify the sorted Hotel prices
	 * @throws InterruptedException
	 */
	@Then("User should verify the sorted prices of the hotel listed from high to low")
	public void user_should_verify_the_sorted_prices_of_the_hotel_listed_from_high_to_low()
			throws InterruptedException {
		List<Integer> ExpectedPrize = pom.getSelecthotelpage().Expsortedamount();
		List<Integer> ActualPrize = pom.getSelecthotelpage().Actsortedamount();
		Assert.assertEquals("Verify High to low price", ExpectedPrize, ActualPrize);
		HooksClass.sc.log("Verify Sorted prices Expected price : " + ExpectedPrize + " Actual price : " + ActualPrize);
	}

	/**
	 * @see Used to enter the hotel requirement details
	 * @param state
	 * @param city
	 * @param roomType
	 * @param checkin
	 * @param checkout
	 * @param noofRooms
	 * @param noofadults
	 * @param noofkids
	 */
	@When("User select hotel {string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_select_hotel(String state, String city, String roomType, String checkin, String checkout,
			String noofRooms, String noofadults, String noofkids) {
		pom.getSelecthotelpage().enterallfields(state, city, roomType, checkin, checkout, noofRooms, noofadults,
				noofkids);
	}

	/**
	 * @see Used to verify success message
	 * @param SelecthotelMsg
	 */
	@Then("User should verify success message {string} after search")
	public void user_should_verify_success_message_after_search(String SelecthotelMsg) {
		Assert.assertEquals("Verify Success message Select Hotel", SelecthotelMsg,
				pom.getSelecthotelpage().SucessMsgHotel());
		String ActualSuccessMsg = pom.getSelecthotelpage().SucessMsgHotel();
		HooksClass.sc.log("Verify Success message Expected Message : " + SelecthotelMsg + " Actual Message : " + ActualSuccessMsg);
	}

	/**
	 * @see use to verify the filtered room type
	 * @param hotelnameroomtype
	 */
	@Then("User should verify filtered room type ends with {string}")
	public void user_should_verify_filtered_room_type_ends_with(String hotelnameroomtype) {
		List<Boolean> HotelNameTypeEnds = pom.getSelecthotelpage().VerifyHotelNameEndsWith(hotelnameroomtype);
		Assert.assertFalse("Verify hotel name ends with room type", HotelNameTypeEnds.contains(false));
	}

	/**
	 * @see Used verify success messge after search
	 * @param successmessage
	 */
	@Then("User should verify success message after search {string}")
	public void user_should_verify_success_message_after_searchs(String successmessage) {
		Assert.assertEquals("Verify after search success message", successmessage,
				pom.getSelecthotelpage().SucessMsgHotel());
		String ActualSuccesMsg = pom.getSelecthotelpage().SucessMsgHotel();
		HooksClass.sc.log("Verify Success message Expected Message : " + successmessage + " Actual Message : " + ActualSuccesMsg);
	}

}
