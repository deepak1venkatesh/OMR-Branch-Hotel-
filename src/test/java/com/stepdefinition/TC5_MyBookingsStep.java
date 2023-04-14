package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;
import com.pages.MyBookingsPage;

import io.cucumber.java.en.*;

/**
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Execution steps for MyBookingsStep
 *
 */
public class TC5_MyBookingsStep extends Baseclass
{
	PageObjectManager pom=new PageObjectManager();
	
//	String Bookconformpage=pom.getBookingconfirmationpage().bookconformpage();

	/**
	 * @see To open Browser and URL
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("User is on the OMR Branch Hotel login page")
	public void user_is_on_the_omr_branch_hotel_login_page() throws FileNotFoundException, IOException 
	{
		getdriver(getPropertyFileValue("browser"));
		launchUrl(getPropertyFileValue("url"));
		maximizeWindow();
		giveImplicitWait(10);
	}
	
	/**
	 * @see Used to accept the alert
	 */
	@When("accept the alert")
	public void accept_the_alert() 
	{
		pom.getMybookingspage().acceptAlert();
	}
	
	/**
	 * @see Used to enter the guest details
	 * @param salutation
	 * @param firstname
	 * @param lastname
	 * @param phoneno
	 * @param email
	 */
	@When("User enters the Guest details {string} ,{string}, {string} , {string}, {string}")
	public void user_enters_the_guest_details(String salutation, String firstname, String lastname, String phoneno, String email) 
	{
		pom.getMybookingspage().enterfirst5details(salutation, firstname, lastname, phoneno, email);
	}
	
	/**
	 * @see Used to enter the GST details
	 * @param gstRegistrationNo
	 * @param companyName
	 * @param companyAddress
	 */
	@When("User enter the GST details {string} ,{string}, {string}")
	public void user_enter_the_gst_details(String gstRegistrationNo, String companyName, String companyAddress) 
	{
		pom.getMybookingspage().entergstdetails(gstRegistrationNo, companyName, companyAddress);
	}
	
	/**
	 * @see Used to click request checkbox and enter the request
	 * @param requestBox
	 */
	@When("User clicks any request checkbox and Enter the requests {string}")
	public void user_clicks_any_request_checkbox_and_enter_the_requests(String requestBox) 
	{
		pom.getMybookingspage().ClickRequest(requestBox);
	}
	/**
	 * @see Used to select the payment type and payment details
	 * @param cardType
	 * @param dataTable
	 */
	@When("User enter the payment type and card details with {string}")
	public void user_enter_the_payment_type_and_card_details_with(String cardType, io.cucumber.datatable.DataTable dataTable) 
	{
		pom.getMybookingspage().SelectAndEnterPaymentDetail(cardType, dataTable);
	}
	
	/**
	 * @see Used to verify success message
	 * @param Expected
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Then("User should verify the success message {string} and save the booking id")
	public void user_should_verify_the_success_message_and_save_the_booking_id(String Expected) throws FileNotFoundException, IOException 
	{
		Assert.assertEquals("Verify Success Message",Expected,pom.getBookingconfirmationpage().bookingSuccessMsg());
		String ExpectedMessage = (String) pom.getBookingconfirmationpage().bookingSuccessMsg();
		HooksClass.sc.log("Verify Success message Expected Message : " + Expected + " Actual Message : " + ExpectedMessage);
		pom.getBookingconfirmationpage().saveHotelName();
		pom.getBookingconfirmationpage().saveOrderId();
	}
	/**
	 * @see Used to navigate to my bookings page
	 */
	@When("User navigate to my bookings page")
	public void user_navigate_to_my_bookings_page() 
	{
		pom.getMybookingspage().navigateMyBooking();
	}
	
	/**
	 * @see Used to verify the Hotel name
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Then("User should verify booked hotel name in My bookings page")
	public void user_should_verify_booked_hotel_name_in_my_bookings_page() throws FileNotFoundException, IOException 
	{
		Assert.assertEquals("Verify the Hotel Name", pom.getMybookingspage().bookedHotelName(), pom.getMybookingspage().hotelNameVerification());
		String ExpectedMSG = pom.getMybookingspage().bookedHotelName();
		String ActualMSG = pom.getMybookingspage().hotelNameVerification();
		HooksClass.sc.log("Verify Success message Expected Message : " + ExpectedMSG + " Actual Message : " + ActualMSG);
	}
	/**
	 * @see Used to cancel booked hotel through order id
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User cancel the booked hotel through order id")
	public void user_cancel_the_booked_hotel_through_order_id() throws FileNotFoundException, IOException 
	{
		pom.getMybookingspage().CancelbookingID();
	}
	
	/**
	 * @see Used to verify cancel booking success message
	 * @param CancelMsg
	 */
	@Then("User should verify cancel booking success message {string}")
	public void user_should_verify_cancel_booking_success_message(String CancelMsg) 
	{
		Assert.assertEquals("Verify Cancel Booking", CancelMsg, pom.getMybookingspage().CancelBookingMsg());
		String ActualMSG = pom.getMybookingspage().CancelBookingMsg();
		HooksClass.sc.log("Verify Cancel Booking Success message Expected Message : " + CancelMsg + " Actual Message : " + ActualMSG);
	}

	
	/**
	 * @see Used to verify order id
	 */
	@Then("User Should verify the orderID")
	public void user_should_verify_the_order_id() 
	{
		String ActOrderID=pom.getMybookingspage().verifyOrderId();
		Assert.assertEquals("Verify Booked Order ID", MyBookingsPage.orderID, ActOrderID);
		HooksClass.sc.log("Verify Booked Order ID Expected Message : " + MyBookingsPage.orderID + " Actual Message : " + ActOrderID);
	}




}
