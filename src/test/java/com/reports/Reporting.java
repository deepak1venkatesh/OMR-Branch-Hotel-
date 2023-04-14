package com.reports;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Deepak Venkatesh PS
 * @date 11-04-2023
 * @see Used to Generate Reports
 */

public class Reporting 
{
	
public static void generateJVMreport(String jsonfile)
{
	File reportLoc=new File(System.getProperty("user.dir")+"\\target");
	
	Configuration configuration = new Configuration(reportLoc,"OMRBranchHotel");
	configuration.addClassifications("platform", "windows 10");
	configuration.addClassifications("Sprint", "27");
	configuration.addClassifications("Author", "Deepak Venkatesh PS");
	List<String> l=new LinkedList<String>();
	l.add(jsonfile);
	
	ReportBuilder builder=new ReportBuilder(l,configuration);
	builder.generateReports();
	
	
	
}
}
