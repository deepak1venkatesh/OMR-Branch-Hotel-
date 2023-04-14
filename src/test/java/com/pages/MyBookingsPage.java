package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Baseclass;

import io.cucumber.datatable.DataTable;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Used to create reusable locators for MyBookingsPage
 *
 */
public class MyBookingsPage extends Baseclass
{
public MyBookingsPage()
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@class='icoTwitter mr-2 dropdown-toggle']")
private WebElement WelcomeUser;

@FindBy(name = "search")
private WebElement txtSearch;

@FindBy(xpath="//a[text()='My Account']")
private WebElement MyAccount;

@FindBy(xpath="//a[text()='My Bookings']")
private WebElement MyBookings;

@FindBy(xpath="(//input[@type='text'])[1]")
private WebElement SearchBookingId;

@FindBy(xpath="(//a[text()='Cancel'])[1]")
private WebElement btnCancel;

@FindBy(id="own")
private WebElement clickbymyself;

@FindBy(name="title")
private WebElement Salutation;

@FindBy(id="first_name")
private WebElement firstname;

@FindBy(id="last_name")
private WebElement lastname;

@FindBy(id="user_phone")
private WebElement phoneno;

@FindBy(id="user_email")
private WebElement email;

@FindBy(id="gst")
private WebElement clickGst;

@FindBy(id="gst_registration")
private WebElement GstRegistrationNo;

@FindBy(id="company_name")
private WebElement companyname;

@FindBy(id="company_address")
private WebElement companyaddress;

@FindBy(id="step1next")
private WebElement clicknext;

@FindBy(id="smoking")
private WebElement clicksmoking;

@FindBy(id="late")
private WebElement clicklatearrival;

@FindBy(id="bed")
private WebElement clickextrabed;

@FindBy(id="other_request")
private WebElement otherrequest;

@FindBy(id="step2next")
private WebElement clicknext2;

@FindBy(xpath="//h5[text()='Credit/Debit/ATM Card']")
private WebElement clickpaymentmode;

@FindBy(id="payment_type")
private WebElement paymenttype;

@FindBy(id="card_no")
private WebElement cardtype;

@FindBy(id="card_name")
private WebElement nameoncard;

@FindBy(id="card_month")
private WebElement cardmonth;

@FindBy(id="card_year")
private WebElement cardyear;

@FindBy(id="cvv")
private WebElement cvv;

@FindBy(id="submitBtn")
private WebElement clicksubmit;

@FindBy(xpath="//h5[text()='UPI']")
private WebElement upisubmitbutton;

@FindBy(id="upi_id")
private WebElement upiId;

@FindBy(id = "email")
private WebElement txtUserName;

@FindBy(id = "pass")
private WebElement txtPassword;

@FindBy(xpath = "//button[text()='Login']")
private WebElement btnlogin;

@FindBy(xpath="//a[contains(text(),'Welcome')]")
private WebElement LoginSuccessMsg;

@FindBy(xpath = "(//a[text()='Continue'])[1]")
private WebElement btnClkContinue;

@FindBy(xpath="//h2[contains(text(),'Book Hotel')]")
private WebElement BookHotelsucessmsg;

@FindBy(id="card_type")
private WebElement CarddtypeName;

@FindBy(xpath = "//a[@data-testid='username']")
private WebElement ClickWelcome;

@FindBy(xpath = "//div[@class='fliter_box_inner mb-4']//h5")
private WebElement txtHotelName;

@FindBy(xpath = "//h2[contains(text(),'Book Hotel')]")
private static WebElement txtBookHotelSuccessMsg;

@FindBy(xpath = "//a[contains(text(),'Cancel')]")
private WebElement CancelID;

@FindBy(xpath = "//li[contains(text(),'Your booking')]")
private WebElement txtCancelBooking;

@FindBy(xpath="//h3[text()='Hotel Booking']")
private WebElement typeselection;

@FindBy(xpath="//div[@class='room-code']//span")
private WebElement Cancelbookingcode;

public WebElement getCancelbookingcode() {
	return Cancelbookingcode;
}


public WebElement getTypeselection() {
	return typeselection;
}


public WebElement getTxtCancelBooking() {
	return txtCancelBooking;
}

public WebElement getCancelID() {
	return CancelID;
}

public WebElement getTxtSearch() {
	return txtSearch;
}

public static WebElement getTxtBookHotelSuccessMsg() {
	return txtBookHotelSuccessMsg;
}

public WebElement getTxtHotelName() {
	return txtHotelName;
}

public WebElement getClickWelcome() {
	return ClickWelcome;
}

public WebElement getClickMyAccount() {
	return ClickMyAccount;
}

public WebElement getClickMyBookings() {
	return ClickMyBookings;
}

@FindBy(xpath = "//a[contains(text(),'My Account')]")
private WebElement ClickMyAccount;

@FindBy(xpath = "//a[contains(text(),'My Bookings')]")
private WebElement ClickMyBookings;

public WebElement getClickbymyself() {
	return clickbymyself;
}

public WebElement getSalutation() {
	return Salutation;
}

public WebElement getFirstname() {
	return firstname;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getPhoneno() {
	return phoneno;
}

public WebElement getEmail() {
	return email;
}

public WebElement getClickGst() {
	return clickGst;
}

public WebElement getGstRegistrationNo() {
	return GstRegistrationNo;
}

public WebElement getCompanyname() {
	return companyname;
}

public WebElement getCompanyaddress() {
	return companyaddress;
}

public WebElement getClicknext() {
	return clicknext;
}

public WebElement getClicksmoking() {
	return clicksmoking;
}

public WebElement getClicklatearrival() {
	return clicklatearrival;
}

public WebElement getClickextrabed() {
	return clickextrabed;
}

public WebElement getOtherrequest() {
	return otherrequest;
}

public WebElement getClicknext2() {
	return clicknext2;
}

public WebElement getClickpaymentmode() {
	return clickpaymentmode;
}

public WebElement getPaymenttype() {
	return paymenttype;
}

public WebElement getCardtype() {
	return cardtype;
}

public WebElement getNameoncard() {
	return nameoncard;
}

public WebElement getCardmonth() {
	return cardmonth;
}

public WebElement getCardyear() {
	return cardyear;
}

public WebElement getCvv() {
	return cvv;
}

public WebElement getClicksubmit() {
	return clicksubmit;
}

public WebElement getUpisubmitbutton() {
	return upisubmitbutton;
}

public WebElement getUpiId() {
	return upiId;
}

public WebElement getTxtUserName() {
	return txtUserName;
}

public WebElement getTxtPassword() {
	return txtPassword;
}

public WebElement getBtnlogin() {
	return btnlogin;
}

public WebElement getLoginSuccessMsg() {
	return LoginSuccessMsg;
}

public WebElement getBtnClkContinue() {
	return btnClkContinue;
}

public WebElement getBookHotelsucessmsg() {
	return BookHotelsucessmsg;
}

public WebElement getCarddtypeName() {
	return CarddtypeName;
}

public WebElement getWelcomeUser() {
	return WelcomeUser;
}

public WebElement getMyAccount() {
	return MyAccount;
}

public WebElement getMyBookings() {
	return MyBookings;
}

public WebElement getSearchBookingId() {
	return SearchBookingId;
}

public WebElement getBtnCancel() {
	return btnCancel;
}

public void myBookings(String bookingid) 
{
elementclick(getWelcomeUser());
elementclick(getMyAccount());
elementclick(getMyBookings());

elementSendKeys(getSearchBookingId(), bookingid);

elementclick(getBtnCancel());
clickCancelAlert();
}

public void acceptAlert() 
{
	clickOkAlert();
}

public void enterfirst5details(String salutation,String firstname,String lastname,String phoneno,String email) 
{
	elementclick(getClickbymyself());
	giveImplicitWait(10);
	selectDropDownByText(getSalutation(), salutation);
	elementSendKeys(getFirstname(), firstname);
	elementSendKeys(getLastname(), lastname);
	elementSendKeys(getPhoneno(), phoneno);
	elementSendKeys(getEmail(), email);
}

public void entergstdetails(String gstRegistrationNo,String companyName,String companyAddress)
{
	elementclick(getClickGst());
	elementSendKeys(getGstRegistrationNo(), gstRegistrationNo);
	elementSendKeys(getCompanyname(), companyName);
	elementSendKeys(getCompanyaddress(), companyAddress);
	elementclick(getClicknext());
}

public void ClickRequest(String requestBox)
{
elementclick(getClicksmoking());
elementclick(getClickextrabed());
elementclick(getClicklatearrival());
elementSendKeys(getOtherrequest(), requestBox);
elementclick(getClicknext2());
}

public void SelectAndEnterPaymentDetail(String cardType,DataTable dataTable)
{
	elementclick(getClickpaymentmode());
	List<Map<String,String>> asMaps=dataTable.asMaps();
	Map<String,String> details=asMaps.get(0);
	String selectcard=details.get("cardName");
	String CardNo=details.get("cardNo");
	String NameOntheCard=details.get("nameoncar");
	String MonthOnCard=details.get("month");
	String YearOnTheCard=details.get("year");
	String CVVonTheCard=details.get("cvv");
	
	selectDropDownByText(getPaymenttype(), cardType);
	selectDropDownByText(getCarddtypeName(), selectcard);
	elementSendKeys(getCardtype(), CardNo);
	elementSendKeys(getNameoncard(), NameOntheCard);
	selectDropDownByText(getCardmonth(), MonthOnCard);
	selectDropDownByText(getCardyear(), YearOnTheCard);
	elementSendKeys(getCvv(), CVVonTheCard);
	elementclick(getClicksubmit());	
}

public void navigateMyBooking()
{
	elementclick(ClickWelcome);
	elementclick(ClickMyAccount);
	elementclick(ClickMyBookings);
}

public String bookedHotelName() throws FileNotFoundException, IOException {
	String expectedHotelName = getPropertyFileValue("HotelName");
	return expectedHotelName;

}

public String hotelNameVerification() {
	String hotelName = elementGetText(getTxtHotelName());
	String hotelName2=hotelName.replace(" Deluxe","");
	return hotelName2;

}

public void CancelbookingID() throws FileNotFoundException, IOException
{
	elementSendKeys(getTxtSearch(), getPropertyFileValue("OrderId"));
//	elementclick(getCancelID());
	new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Cancel')]"))).click();
//	WebElement btnCancel = driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"));
//	btnCancel.click();
	acceptAlert();
}

public String CancelBookingMsg()
{
	String CancelMsg=elementGetText(getTxtCancelBooking());
	return CancelMsg;
}

public static String orderID=null;
public String verifyOrderId() 
{
String cancelorderid=elementGetText(getCancelbookingcode());
String[] split=cancelorderid.split("#");
for (String s : split) 
{
System.out.println(s);
orderID=s;
}
return orderID;
}
}
