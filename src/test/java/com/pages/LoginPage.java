package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Used to create reusable locators for LoginPage
 */
public class LoginPage extends Baseclass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtUserName;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnlogin;

	@FindBy(xpath = "//b[contains(text(),'Invalid')]")
	public WebElement LoginErrorMsg;
	
	@FindBy(xpath="//b[contains(text(),'User does not exist')]")
	public WebElement LoginErrorMsg2;
	
	

	public WebElement getLoginErrorMsg2() {
		return LoginErrorMsg2;
	}

	public WebElement getLoginErrorMsg() {
		return LoginErrorMsg;
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

	public void logincommonstep(String username, String password) {
		elementSendKeys(getTxtUserName(), username);
		elementSendKeys(getTxtPassword(), password);
	}

	public void login(String username, String password) {
		logincommonstep(username, password);
		elementclick(getBtnlogin());
	}

	public void loginwithenterkey(String username, String password) {
		elementSendKeys(getTxtUserName(), username);
		elementSendKeysWithEnterKey(getTxtPassword(), password);
	}

	public String errormsg() {
		String actLoginErrorMsg = elementGetText(getLoginErrorMsg());
		return actLoginErrorMsg;
	}

}
