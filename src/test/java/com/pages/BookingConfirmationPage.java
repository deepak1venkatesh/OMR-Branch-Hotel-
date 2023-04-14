package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023	
 * @see Used to create reusable locators for BookingConfirmationPage
 *
 */
public class BookingConfirmationPage extends Baseclass
{
public BookingConfirmationPage()
{
PageFactory.initElements(driver, this);	
}

@FindBy(xpath="//h2[@name='booking-code']//strong")
private WebElement orderid;

@FindBy(xpath="//h2[contains(text(),'Booking')]")
private WebElement bookingmsg;

@FindBy(xpath = "//h2[contains(text(),'Book Hotel')]")
private static WebElement txtBookHotelSuccessMsg;

@FindBy(xpath = "(//strong)[2]")
private static WebElement BookHotelName;



public static WebElement getBookHotelName() {
	return BookHotelName;
}

public static WebElement getTxtBookHotelSuccessMsg() {
	return txtBookHotelSuccessMsg;
}

public WebElement getBookingmsg() {
	return bookingmsg;
}

public WebElement getOrderid() {
	return orderid;
}

public void getorderid() 
{
String orderid=elementGetText(getOrderid()).replace("#", "");
System.out.println(orderid);
}

public CharSequence bookingSuccessMsg() {
	String bkngSucMsg = elementGetText(getBookingmsg());
	CharSequence subSequence = bkngSucMsg.subSequence(12, 32);
	System.out.println(bkngSucMsg);
	return subSequence;

}

public String saveHotelName() throws FileNotFoundException, IOException {
	String hotelNameFull = elementGetText(getBookHotelName());
	String hotelName = hotelNameFull.replace("Book Hotel - ", "");
	deleteDataInPropertyFile("HotelName");
	setPropertyFile("HotelName", hotelName);
	return hotelName;
}

public String saveOrderId() throws FileNotFoundException, IOException {
	String orderId = elementGetText(getOrderid()).substring(0, 11).replace("#", "");
	System.out.println("Order ID--"+orderId);
	deleteDataInPropertyFile("OrderId");
	setPropertyFile("OrderId", orderId);
	return orderId;
}

public static String bookingId;
public String bookconformpage() 
{
String getText = elementGetText(getOrderid());
String[] orderid=getText.split("#");
for (String s : orderid) 
{
bookingId=s;	
}
return bookingId;
}
}
