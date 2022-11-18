package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;


public class TS07_JobTemplateSearchTest extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";


	public void workflow_TS7_JobTemplateSearchTest() throws InterruptedException {

		CommonFunction.waitforHomePagetoload();

		//Click the 'New Job' button on the left panel	
		msg = "Click the 'New Job' button on the left panel";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			cfunction.sync(2);
			Coordinate.clickOnNewJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		int totalJobs = 0;
		try {
			totalJobs = Coordinate.getAllJobsCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cfunction.sync(2);

		//Verify the first job template is 'Attachment Test' 
		String jobTemplateName = "Arcade Symbols";
		int jobTemplateIndex = -1;
		msg = "Verify the first job template is 'Arcade Symbols'";
		try {
			jobTemplateIndex = Coordinate.getJobTemplateIndex(jobTemplateName);
			if( jobTemplateIndex == 0)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Verify the templates are sorted from A-Z
		msg = "Verify the templates are sorted from A-Z";
		try {
			Coordinate.verifyJobList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Hover the cursor over the first job template
		msg = "Hover the cursor over the first job template";
		try {
			Coordinate.hoverOnJobTemplate(jobTemplateIndex);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*//Verify 'Create Default' and 'Advanced' appear
		msg = "Verify 'Create Default' and 'Advanced' appear";
		try {
			if(Coordinate.verifyCreateDefaultAndAdvanced(jobTemplateIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Hover the cursor over 'Create Default'
		msg = "Hover the cursor over 'Create Default'";
		try {
			Coordinate.hoverOnCreateDefault(jobTemplateIndex);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify 'Create Default' is highlighted
		msg = "Verify 'Create Default' is highlighted";
		try {
			if(Coordinate.verifyIfCreateDefaultHighlighted(jobTemplateIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
/*		cfunction.sync(2);

		//Hover the cursor over 'Advanced'
		msg = "Hover the cursor over 'Advanced'";
		try {
			Production.hoverOnAdvanced(jobTemplateIndex);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify 'Advanced' is highlighted
		msg = "Verify 'Advanced' is highlighted";
		try {
			if(Production.verifyIfAdvancedHighlighted(jobTemplateIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);

		//Enter "data" in Search Textbox
		String searchText = xls.getCellData("en-us", 2,9);
		msg = "Enter '"+ searchText +"' in Search Textbox";
		try {
			Coordinate.enterSearchText(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify 'Attachment Test' is visible
		msg = "Verify 'Data Edits Sample' is visible";
		try {
			jobTemplateName = "Data Edits Sample";
			jobTemplateIndex = Coordinate.getJobTemplateIndex(jobTemplateName);
			if( jobTemplateIndex > -1)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Hover the cursor over 'Data Edits Sample'	
		msg = "Hover the cursor over 'Data Edits Sample'";
		try {
			Coordinate.hoverOnTitle(jobTemplateIndex);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify a tooltip appears with 'Data Edits Sample'
		msg = "Verify a tooltip appears with 'Data Edits Sample'";
		try {
			Coordinate.verifyTitleToolTip(jobTemplateIndex, "Data Edits Sample");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Type 'job sites' in to the search	
		searchText = "job sites"; //xls.getCellData("en-us", 2,9);
		msg = "Enter '"+ searchText +"' in Search Textbox";
		try {
			Coordinate.enterSearchText(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify 'Survey Workflow' is visible
		msg = "Verify 'Survey Workflow' is visible";
		try {
			jobTemplateName = "Survey Workflow";
			jobTemplateIndex = Coordinate.getJobTemplateIndex(jobTemplateName);
			if( jobTemplateIndex > -1)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Hover the cursor over 'For surveying job sites'	
		msg = "Hover the cursor over 'For surveying job sites'";
		try {
			Coordinate.hoverOnDescription(jobTemplateIndex);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify a tooltip with matching text appears
		msg = "Verify a tooltip appears with 'For surveying job sites'";
		try {
			Coordinate.verifyTitleToolTip(jobTemplateIndex, "For surveying job sites");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Remove the search text	
		searchText = ""; 
		msg = "Remove the search text";
		try {
			Coordinate.clearSearchText(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify The search is updated to show all job templates again
		msg = "Verify The search is updated to show all job templates again";
		try {
			if(Coordinate.verifyAllJobsVisible(totalJobs))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);	
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*msg = "Deleting Created Job";
		try {
			HomePage.clickOnWork();
			cfunction.sync(2);
			WorkPage.clickOnAllJobs();
			cfunction.sync(2);
			WorkPage.clickOnNewFilterBy();
			cfunction.sync(2);
			WorkPage.clickOnJobDetails(jobName);
			cfunction.sync(2);
			Coordinate.clickEllipsesBtn();
			cfunction.sync(2);
			Coordinate.clickDeleteBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		// 
	}
}
