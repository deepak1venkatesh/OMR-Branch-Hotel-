package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Used to create reusable locators for ExploreHotelPage
 *
 */
public class ExploreHotelPage extends Baseclass {
	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='Explore Hotels']")
	private WebElement successMsgExploreHotel;
	
	@FindBy(xpath= "//h5[contains(text(),'Select')]")
	private WebElement successMsgSelectHotel;

	public WebElement getSuccessMsgSelectHotel() 
	{
		return successMsgSelectHotel;
	}

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "room_type")
	private WebElement roomtype;

	@FindBy(name = "check_in")
	private WebElement txtcheckin;

	@FindBy(name = "check_out")
	private WebElement txtcheckout;

	@FindBy(id = "no_rooms")
	private WebElement roomno;

	@FindBy(id = "no_adults")
	private WebElement adults;

	@FindBy(id = "no_child")
	private WebElement child;

	@FindBy(id = "invalid-state")
	private WebElement errormessagestate;

	@FindBy(id = "invalid-city")
	private WebElement errormessagecity;

	@FindBy(xpath="//div[text()='Please select Check-in date']")
	private WebElement errormessagecheckin;

	@FindBy(xpath="//div[text()='Please select Check-out date']")
	private WebElement errormessagecheckout;

	@FindBy(id = "invalid-no_rooms")
	private WebElement errormessagenoofroom;

	@FindBy(id = "invalid-no_adults")
	private WebElement errormessagenoofadults;

	@FindBy(id = "hotelsearch_iframe")
	private WebElement framesearch;

	@FindBy(id = "searchBtn")
	private WebElement btnsearch;

	@FindBy(xpath = "//iframe[@class='iframe']")
	private WebElement frameid;
	
	@FindBy(xpath="//a[contains(text(),'Welcome')]")
	private WebElement LoginSuccessMsg;

	@FindBy(id = "email")
	private WebElement txtUserName;

	@FindBy(id = "pass")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnlogin;

	@FindBy(id="hotelsearch_iframe")
	private WebElement frame2;
	
	@FindBy(xpath="//h3[text()='Hotel Booking']")
	private WebElement typeselection;

	public WebElement getTypeselection() {
		return typeselection;
	}

	public WebElement getFrame2() {
		return frame2;
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

	public WebElement getLoginSuccessMsg() 
	{
		return LoginSuccessMsg;
	}

	public WebElement getFrameid() {
		return frameid;
	}

	public WebElement getSuccessMsgExploreHotel() {
		return successMsgExploreHotel;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}

	public WebElement getTxtcheckin() {
		return txtcheckin;
	}

	public WebElement getTxtcheckout() {
		return txtcheckout;
	}

	public WebElement getRoomno() {
		return roomno;
	}

	public WebElement getAdults() {
		return adults;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getErrormessagestate() {
		return errormessagestate;
	}

	public WebElement getErrormessagecity() {
		return errormessagecity;
	}

	public WebElement getErrormessagecheckin() {
		return errormessagecheckin;
	}

	public WebElement getErrormessagecheckout() {
		return errormessagecheckout;
	}

	public WebElement getErrormessagenoofroom() {
		return errormessagenoofroom;
	}

	public WebElement getErrormessagenoofadults() {
		return errormessagenoofadults;
	}

	public WebElement getFramesearch() {
		return framesearch;
	}

	public WebElement getBtnsearch() {
		return btnsearch;
	}

	public void explorehotelcommonstep(String state, String city, String checkin, String checkout, String noofRooms,
			String noofadults) {
		elementclick(getTypeselection());
		selectDropDownByValue(getState(), state);
		selectDropDownByValue(getCity(), city);
		sendKeysbyJS(getTxtcheckin(), checkin);
		sendKeysbyJS(getTxtcheckout(), checkout);
		selectDropDownByText(getRoomno(), noofRooms);
		selectDropDownByText(getAdults(), noofadults);
		
	}

	public void clickbutton() {
		defaultframe(frame2);
		elementclick(getBtnsearch());
	}

	public void enterallfields(String state, String city, String roomType, String checkin, String checkout, String noofRooms, String noofadults, String noofkids) {
		explorehotelcommonstep(state, city, checkin, checkout, noofRooms, noofadults);
		selectDropDownByText(getRoomtype(), roomType);
		elementSendKeys(getChild(), noofkids);
		clickbutton();
	}

	public void entermandatoryfields(String state, String city, String checkin, String checkout, String noofrooms,
			String noofadults) {
		explorehotelcommonstep(state, city, checkin, checkout, noofrooms, noofadults);
		clickbutton();
	}

	public void nofieldsEntered() {
		giveImplicitWait(10);
		elementclick(getTypeselection());
		defaultframe(frame2);
		elementclick(getBtnsearch());
	}
	
	public String SuccessMsg()
	{
		String actLoginSuccessMsg=elementGetText(getLoginSuccessMsg());
		return actLoginSuccessMsg;
	}
	
	public void logincommonstep(String username, String password) {
		elementSendKeys(getTxtUserName(), username);
		elementSendKeys(getTxtPassword(), password);
	}

	public void login(String username, String password) {
		logincommonstep(username, password);
		elementclick(getBtnlogin());
	}	
		
	public String stateErrorMsg()
	{
		defaultcontent();
		String stateerrormessage=elementGetText(getErrormessagestate());
		return stateerrormessage;
	}
	
	public String cityerrorMsg()
	{
		String cityErrorMsg=elementGetText(getErrormessagecity());
		return cityErrorMsg;
	}
	
	public String ChkInErrorMsg()
	{
		String ChkInMsg=elementGetText(getErrormessagecheckin());
		return ChkInMsg;
	}
	
	public String ChkOutErrorMsg()
	{
		String ChkOutMsg=elementGetText(getErrormessagecheckout());
		return ChkOutMsg;
	}
	
	public String noofroomsErrorMsg()
	{
		String noofroomsErrorMsg=elementGetText(getErrormessagenoofroom());
		return noofroomsErrorMsg;
	}
		
	public String noofAdultsErrorMsg()
	{
		String noofAdultsErrorMsg=elementGetText(getErrormessagenoofadults());
		return noofAdultsErrorMsg;
	}
	
	public List<String> ExpSixErrorMsg(String errormessagestate,String errormessagecity,String errormessagecheckin,String errormessagecheckout,String errormessagenoofroom,String errormessagenoofadults)
	{
		giveImplicitWait(30);
		List<String> li=new ArrayList<String>();
		li.add(errormessagestate);
		li.add(errormessagecity);
		li.add(errormessagecheckin);
		li.add(errormessagecheckout);
		li.add(errormessagenoofroom);
		li.add(errormessagenoofadults);
		
		return li;
		
	}
	
	public List<String> ActSixErrorMsg()
	{
		List<String> li=new ArrayList<String>();
		li.add(stateErrorMsg());
		li.add(cityerrorMsg());
		li.add(ChkInErrorMsg());
		li.add(ChkOutErrorMsg());
		li.add(noofroomsErrorMsg());
		li.add(noofAdultsErrorMsg());
		System.out.println(li);
		return li;
	}
	
	public void ThreeRoomTypeEnter(String state, String city, String roomType,String roomType1,String roomType2, String checkin, String checkout, String noofRooms, String noofadults, String noofkids) 
	{
	explorehotelcommonstep(state, city, checkin, checkout, noofRooms, noofadults);
	selectDropDownByText(getRoomtype(), roomType);
	selectDropDownByText(getRoomtype(), roomType1);
	selectDropDownByText(getRoomtype(), roomType2);
	elementSendKeys(getChild(), noofkids);
	defaultframe(frameid);
	elementclick(btnsearch);
	}
	
	
}

