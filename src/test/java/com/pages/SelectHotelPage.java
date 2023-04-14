package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Used to create reusable locators for SelectHotelPage
 *
 */
public class SelectHotelPage extends Baseclass

{
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement SelectHotel;

	@FindBy(xpath = "(//a[text()='Continue'])[1]")
	private WebElement btnClkContinue;

	@FindBy(xpath="//label[text()='Price High to low']")
	private WebElement hightolowelement;
	
	@FindBy(className="total-prize")
	private List<WebElement> txtTotalPrize;

	@FindBy(xpath="//div[@class='col-md-5 hotel-suites']//h5")
	private List<WebElement> txtHotelName;

	@FindBy(className="total-prize")
	private List<WebElement> txtTotalPrizeAfterSort;
	
	@FindBy(xpath= "//h5[contains(text(),'Select')]")
	private WebElement successMsgSelectHotel;
	
	@FindBy(xpath = "//a[text()='Standard/Deluxe/Suite']")
	private WebElement threeRoomtypeMsg;
	
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
	
	@FindBy(id = "searchBtn")
	private WebElement btnsearch;
	
	@FindBy(id="hotelsearch_iframe")
	private WebElement frame2;
	
	@FindBy(xpath="//h2[contains(text(),'Book Hotel')]")
	private WebElement BookHotelsucessmsg;
	
	@FindBy(xpath = "//div[@class='fliter_box_inner mb-4']//h5")
	private List<WebElement> HotelNameRoomType;
	
	@FindBy(xpath="//h3[text()='Hotel Booking']")
	private WebElement typeselection;

	public WebElement getTypeselection() {
		return typeselection;
	}
	
	public List<WebElement> getHotelNameRoomType() {
		return HotelNameRoomType;
	}

	public WebElement getBookHotelsucessmsg() {
		return BookHotelsucessmsg;
	}
	
	public WebElement getBtnsearch() {
		return btnsearch;
	}

	public WebElement getState() 
	{
		return state;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getFrame2() {
		return frame2;
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
	
	
	public WebElement getThreeRoomtypeMsg() {
		return threeRoomtypeMsg;
	}

	public WebElement getSuccessMsgSelectHotel() 
	{
		return successMsgSelectHotel;
	}

	public WebElement getSelectHotel() {
		return SelectHotel;
	}

	public WebElement getBtnClkContinue() {
		return btnClkContinue;
	}

	public WebElement getHightolowelement() {
		return hightolowelement;
	}

	public List<WebElement> getTxtTotalPrize() {
		return txtTotalPrize;
	}

	public List<WebElement> getTxtHotelName() {
		return txtHotelName;
	}

	public List<WebElement> getTxtTotalPrizeAfterSort() {
		return txtTotalPrizeAfterSort;
	}
	
	private void selecthotel() 
	{
		elementclick(getBtnClkContinue());
	}
	
	public void acceptAlert() 
	{
		clickOkAlert();
	}
	
	private void dismissHotel() 
	{
		selecthotel();
		clickCancelAlert();
	}
	
	private boolean sortHotelPrizeHighToLow() 
	{
		List<String> List1= new LinkedList<String>();
		for(WebElement element:getTxtTotalPrize())
		{
		String text=element.getText().replaceAll("$ ,", "");	
		List1.add(text);
		}
		elementclick(getHightolowelement());
		
		List<String> List2=new ArrayList<String>();
		
		for(WebElement element : getTxtTotalPrizeAfterSort())
		{
			String text=element.getText().replaceAll("$ ," ,"");
			List2.add(text);
		}
		Collections.sort(List1);
		Collections.reverse(List1);
		boolean res=List1.equals(List2);
		return res;
	}
	
	public List<Boolean> verifyHotelNameEndsWith(String roomType)
	{
		List<Boolean> roomfilter=new ArrayList<Boolean>();
		for(WebElement element: getTxtHotelName())
		{
			String text=element.getText();
			boolean endswith=text.endsWith(roomType);
			roomfilter.add(endswith);
		}
		return roomfilter;
	}
	
	public String SucessMsgHotel()
	{
		String actSuccessmsgHotel=elementGetText(getSuccessMsgSelectHotel());
		return actSuccessmsgHotel;
	}
	
	public String threeRoomTypeMsg()
	{
		String acttreeroommsg=elementGetText(getThreeRoomtypeMsg());
		System.out.println(acttreeroommsg);
		return acttreeroommsg;
	}
	
	public void SelectHotelPageOk()
	{
		elementclick(getBtnClkContinue());
	}
	
	public void clickbutton() {
		defaultframe(frame2);
		elementclick(getBtnsearch());
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
	
	public void enterallfields(String state, String city, String roomType, String checkin, String checkout, String noofRooms, String noofadults, String noofkids) {
		explorehotelcommonstep(state, city, checkin, checkout, noofRooms, noofadults);
		selectDropDownByText(getRoomtype(), roomType);
		elementSendKeys(getChild(), noofkids);
		clickbutton();
	}
	
	public String HotelBookSuccess()
	{
    	String actsuccessmsg = elementGetText(getBookHotelsucessmsg());
		return actsuccessmsg;
		
	}
	
	public void DismissAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void SortButtonClick()
	{
		elementclick(getHightolowelement());
	}
	
	public List<Integer> Expsortedamount() 
	{
		List<Integer> li=new ArrayList<Integer>();
		
		for (WebElement y : getTxtTotalPrize()) 
		{
			String before = y.getText();
			String replaceAll = before.replace("$ ", "");
			String replaceAll2 = replaceAll.replace(",", "");
			int parseInt = Integer.parseInt(replaceAll2);
			li.add(parseInt);
			Collections.sort(li);
			Collections.reverse(li);
			
			
		}
		return li;		
	}
	
	public List<Integer> Actsortedamount() throws InterruptedException 
	{	
		List<Integer> li2=new ArrayList<Integer>();
		Thread.sleep(2000);
			for (WebElement x : getTxtTotalPrize()) 
			{
				String before1 = x.getText();
				String replaceAll1 = before1.replace("$ ", "");
				String replaceAll3 = replaceAll1.replace(",", "");
				System.out.println(replaceAll3);
				int parseInt = Integer.parseInt(replaceAll3);
				li2.add(parseInt);
				
			}
			return li2;		
	}
	
	
	public List<Boolean> VerifyHotelNameEndsWith(String hotelnameroomtype)
	{
		List<Boolean> booleanlist = new ArrayList<Boolean>();
		
		for(WebElement hoteltype:getHotelNameRoomType())
		{
			String s1=elementGetText(hoteltype);
			boolean check=s1.contains(hotelnameroomtype);
			booleanlist.add(check);
			System.out.println(booleanlist);
		}
		
		return booleanlist;
		
	}
}
