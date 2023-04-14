package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;


import com.base.Baseclass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 12-04-2023
 * @see Used for before and after method scenario
 */
public class HooksClass extends Baseclass
{
	static Scenario sc;
	
	/**
	 * @see Used to define before scenario method
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Before
	public void beforeScenario(Scenario scenario) throws FileNotFoundException, IOException 
	{
		sc=scenario;
	}
	
	/**
	 * @see Used to define after scenario methods
	 * @param scenario
	 * @throws InterruptedException 
	 */
	@After
	public void afterScenario(Scenario scenario) throws InterruptedException 
	{
		boolean failed=sc.isFailed();
		if(failed)
		{
		sc.attach(screenshots(),"image/png","Every Scenario");
		}
		toClose();
	}
}
