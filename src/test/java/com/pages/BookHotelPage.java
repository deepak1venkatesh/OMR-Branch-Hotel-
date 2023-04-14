package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

import io.cucumber.datatable.DataTable;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2013
 * @see Used to create reusable locators for BookHotelPage
 */
public class BookHotelPage extends Baseclass
{

public BookHotelPage()
{
		PageFactory.initElements(driver, this);
}

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

@FindBy(xpath="//h3[text()='Hotel Booking']")
private WebElement typeselection;

public WebElement getTypeselection() {
	return typeselection;
}
public WebElement getCarddtypeName() {
	return CarddtypeName;
}

public WebElement getBookHotelsucessmsg() {
	return BookHotelsucessmsg;
}

public WebElement getBtnClkContinue() {
	return btnClkContinue;
}

public WebElement getLoginSuccessMsg() {
	return LoginSuccessMsg;
}

public WebElement getBtnlogin() {
	return btnlogin;
}

public WebElement getTxtUserName() {
	return txtUserName;
}

public WebElement getTxtPassword() {
	return txtPassword;
}

public WebElement getUpisubmitbutton() {
	return upisubmitbutton;
}

public WebElement getUpiId() {
	return upiId;
}

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

public void bookhotelcommon(String salutation,String firstname,String lastname,String phoneno,String email,String GstRegistrationNo,String companyname,String companyaddress,String otherrequest) 
{
elementclick(getTypeselection());
elementclick(getClickbymyself());
selectDropDownByText(getSalutation(), salutation);
elementSendKeys(getFirstname(), firstname);
elementSendKeys(getLastname(), lastname);
elementSendKeys(getPhoneno(), phoneno);
elementSendKeys(getEmail(), email);
elementclick(getClickGst());
elementSendKeys(getGstRegistrationNo(), GstRegistrationNo);
elementSendKeys(getCompanyname(), companyname);
elementSendKeys(getCompanyaddress(), companyaddress);
elementclick(getClickGst());
elementclick(getClicklatearrival());
elementSendKeys(getOtherrequest(), otherrequest); //error//
elementclick(clickpaymentmode);
}

public void bookHotelByCardPayment(String salutation,String firstname,String lastname,String phoneno,String email,String GstRegistrationNo,String companyname,String companyaddress,String otherrequest,String cardtype)
{
	bookhotelcommon(salutation, firstname, lastname, phoneno, email, GstRegistrationNo, companyname, companyaddress, otherrequest);
	elementclick(getClicksubmit());
	selectDropDownByText(getCardtype(), cardtype);
	elementclick(getClicksubmit());
}

public void bookHotelByUpiPayment(String salutation,String firstname,String lastname,String phoneno,String email,String GstRegistrationNo,String companyname,String companyaddress,String otherrequest,String upiId)
{
	bookhotelcommon(salutation, firstname, lastname, phoneno, email, GstRegistrationNo, companyname, companyaddress, otherrequest);
	elementclick(getUpisubmitbutton());
	elementSendKeys(getUpiId(), upiId);
	elementclick(getClicksubmit());
}

public void logincommonstep(String username, String password) 
{
	elementSendKeys(getTxtUserName(), username);
	elementSendKeys(getTxtPassword(), password);
}

public void login(String username, String password) 
{
	logincommonstep(username, password);
	elementclick(getBtnlogin());
}	

public String SuccessMsg()
{
	String actLoginSuccessMsg=elementGetText(getLoginSuccessMsg());
	return actLoginSuccessMsg;
}

private void selecthotel() 
{
	elementclick(getBtnClkContinue());
}

public void acceptAlert() 
{
	clickOkAlert();
}

public String HotelBookSuccess()
{
	String actsuccessmsg = elementGetText(getBookHotelsucessmsg());
	return actsuccessmsg;
	
}

public void enterfirst5details(String salutation,String firstname,String lastname,String phoneno,String email)
{
	giveImplicitWait(10);
	elementclick(getClickbymyself());
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

public void SelectAndEnterUpiDetails(String upiID)
{
	elementclick(getUpisubmitbutton());
	elementSendKeys(getUpiId(), upiID);
	elementclick(getClicksubmit());
}

}
