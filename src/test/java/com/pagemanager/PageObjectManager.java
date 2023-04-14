package com.pagemanager;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmationPage;
import com.pages.ExploreHotelPage;
import com.pages.LoginPage;
import com.pages.MyBookingsPage;
import com.pages.SelectHotelPage;
/**
 * 
 * @author Deepak Venkatesh PS
 * @date 22/03/2023
 * @see Used to Create Objects for the pages
 *
 */
public class PageObjectManager 
{
private LoginPage loginpage;
private ExploreHotelPage explorehotelpage;
private SelectHotelPage selecthotelpage;
private BookHotelPage bookhotelpage;
private BookingConfirmationPage bookingconfirmationpage;
private MyBookingsPage mybookingspage;

/**
 *@see Used to Create object for LoginPage
 */
public LoginPage getLoginpage() 
{
	return (loginpage==null)?loginpage=new LoginPage() :loginpage;
}

/**
 * @see Used to create object for ExploreHotelPage
 */
public ExploreHotelPage getExplorehotelpage() 
{
	return (explorehotelpage==null)?explorehotelpage=new ExploreHotelPage():explorehotelpage;
}

/**
 * @see Used to create object for SelectHotelPage
 */
public SelectHotelPage getSelecthotelpage() 
{
	return (selecthotelpage==null)?selecthotelpage=new SelectHotelPage():selecthotelpage;
}

/**
 * @see Used to create object for BookHotelPage
 */
public BookHotelPage getBookhotelpage() 
{
	return (bookhotelpage==null)?bookhotelpage=new BookHotelPage():bookhotelpage;
}

/**
 * @see Used to Create object for BookingConfirmationPage
 */
public BookingConfirmationPage getBookingconfirmationpage() 
{
	return (bookingconfirmationpage==null)?bookingconfirmationpage=new BookingConfirmationPage():bookingconfirmationpage;
}

/**
 * @see Used  to Create object for GetMyBookingsPage
 */
public MyBookingsPage getMybookingspage() 
{
	return (mybookingspage==null)?mybookingspage=new MyBookingsPage():mybookingspage;
}





}
