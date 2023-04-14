package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Execution steps for BookHotelStep feature file
 */
public class TC4_BookHotelStep extends Baseclass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Used to open Browser and URL
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("User is on the OMR Branch login page")
	public void user_is_on_the_omr_branch_login_page() throws FileNotFoundException, IOException {
		getdriver(getPropertyFileValue("browser"));
		launchUrl(getPropertyFileValue("url"));
		maximizeWindow();
		giveImplicitWait(10);
	}

	/**
	 * @see used to enter the username and password
	 * @param username
	 * @param password
	 */
	@When("User enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		pom.getBookhotelpage().login(username, password);
	}

	/**
	 * @see Used to accept alert
	 */
	@When("User accept the alert")
	public void user_accept_the_alert() {
		pom.getBookhotelpage().acceptAlert();
	}

	/**
	 * @see Used to verify the success message
	 * @param HotelNameSuccess
	 */
	@Then("User should verify success message {string} after accepting the alert and save the hotel name")
	public void user_should_verify_success_message_after_accepting_the_alert_and_save_the_hotel_name(
			String HotelNameSuccess) {
		pom.getBookhotelpage().HotelBookSuccess().contains(HotelNameSuccess);
	}

	/**
	 * @see Used to enter the Guest details
	 * @param salutation
	 * @param firstname
	 * @param lastname
	 * @param phoneno
	 * @param email
	 */
	@When("User enters Guest details {string},{string},{string},{string} and {string}")
	public void user_enters_guest_details_and(String salutation, String firstname, String lastname, String phoneno,
			String email) {
		pom.getBookhotelpage().enterfirst5details(salutation, firstname, lastname, phoneno, email);
	}

	/**
	 * @see Used to enter the GST details
	 * @param gstRegistrationNo
	 * @param companyName
	 * @param companyAddress
	 */
	@When("User enters GST details {string},{string} and {string}")
	public void user_enters_gst_details_and(String gstRegistrationNo, String companyName, String companyAddress) {
		pom.getBookhotelpage().entergstdetails(gstRegistrationNo, companyName, companyAddress);
	}

	/**
	 * @see used to click any checkbox and enter the special request
	 * @param requestBox
	 */
	@When("User click any checkbox request and enters special request {string}")
	public void user_click_any_checkbox_request_and_enters_special_request(String requestBox) {
		pom.getBookhotelpage().ClickRequest(requestBox);
	}

	/**
	 * @see Used to enter the payment details and its type
	 * @param cardType
	 * @param dataTable
	 */
	@When("User enters payment details and select {string}")
	public void user_enters_payment_details_and_select(String cardType, io.cucumber.datatable.DataTable dataTable) {
		pom.getBookhotelpage().SelectAndEnterPaymentDetail(cardType, dataTable);
	}

	/**
	 * @see User should verify success message
	 * @param Expected
	 */
	@Then("User should verify success message {string} after booking and save the order id")
	public void user_should_verify_success_message_after_booking_and_save_the_order_id(String ExpectedMessage) {
		Assert.assertEquals("Verify Success Message", ExpectedMessage, pom.getBookingconfirmationpage().bookingSuccessMsg());
		String ActualSuccessMessage = (String) pom.getBookingconfirmationpage().bookingSuccessMsg();
		
		HooksClass.sc.log("Verify Success message Expected Message : " + ExpectedMessage + " Actual Message : " + ActualSuccessMessage);
	}

	/**
	 * @see User enter the payment details of UPI
	 * @param upiID
	 */
	@When("User enters payment details with UPI ID {string}")
	public void user_enters_payment_details_with_upi_id(String upiID) {
		pom.getBookhotelpage().SelectAndEnterUpiDetails(upiID);
	}

}
