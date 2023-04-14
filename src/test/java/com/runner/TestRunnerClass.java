package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.Baseclass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false,monochrome=true,tags="@MyBookings",features="src\\test\\resources\\Features",glue="com.stepdefinition",plugin = {
		"pretty", "json:target/index.json" })
public class TestRunnerClass extends Baseclass
{
@AfterClass	
public static void afterClass() 
{
Reporting.generateJVMreport(getprojectpath()+"\\target\\index.json");
}
}
