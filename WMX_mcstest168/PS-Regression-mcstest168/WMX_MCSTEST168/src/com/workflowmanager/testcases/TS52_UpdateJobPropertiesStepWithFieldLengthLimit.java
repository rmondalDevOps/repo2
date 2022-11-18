package com.workflowmanager.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;


public class TS52_UpdateJobPropertiesStepWithFieldLengthLimit extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String jobName="Edit Job Properties_Field Length";
	String msg = "";
	public void workflow_TS52_UpdateJobPropertiesStepWithFieldLengthLimit() throws InterruptedException {
		 CommonFunction.waitforHomePagetoload();
		// Click on Design Tab

		msg = "Click on work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify Work tab is opened. 
				msg = "Verify Work tab is opened";
				try {
					if(WorkPage.verifyWorkTabOpen())
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Verify My Jobs tab is by default set as active tab with my jobs returned.
				msg = "Verify All Jobs tab is by default set as active tab with my jobs returned";
				try {
					if(WorkPage.verifyAllJobsActive())
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

				//Expand Custom Search.
				msg = "Expand Custom Search";
				try {
					WorkPage.clickOnCustomeSearchIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

				//The custom search box is expanded to allow to enter search query.
				msg = "Verify the custom search box is expanded to allow to enter search query";
				try {
					WorkPage.clickOnCustomSearchInput();
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

				//Verify the custom query textbox is empty : as per new changes in build(as discussed with Xiaomeng)
				msg = "Verify the custom query textbox is empty";
				try {
					if(WorkPage.verifyCustomQueryCleared())
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//In Custom Search enter jobName = 'Update Job Properties_Field Length'
				msg = "Enter new search query Search in the custom search box";
				try {
					String query = "jobName = 'Edit Job Properties_Field Length'";
					WorkPage.enterCustomSearch(query);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Hit Enter.
				msg = "Hit Enter";
				try {
					cfunction.pressEnterKey();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The job for this test is returned. The current step is Update Job Properties
				msg = "Verify the job's current step is 'Update Job Properties'";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName, "Update Job Properties")) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Collapse the Create Job Panel on the left and Job Details Panel on the right, if they are expanded.
		//The job tile is expanded to full length in the Work page.
		//Run Update Job Properties step.
				msg = "Click \"start step\" button for the job";
				try {
					if(WorkPage.clickOnStartStepOfJob(jobName)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The step is running and the job properties step dialog is opened. Verify that the job properties to be updated are displayed as the screenshot.
				msg = "Verify job properties step dialog is opened";
				try {
					if(WorkPage.verifyJobPropertiesStepDialogVisible()) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//The properties listed in the screenshot are sorted by rows in this order: Integer, string2, string3, and string4, domain1, string2, string3 and string4. The 2 properties in each row are aligned to the top. 
		//Verify the integer and domain1 properties entry boxes do not have the character counter. Other string fields are have a character counter for the number of the characters entered.
		//Verify String 2 properties in both left and right have the length limit less or equal to 50 so the entry box displays in one row.
				msg = "Verify String 2 properties in both left and right have the length limit less or equal to 50 so the entry box displays in one row.";
				try {
					if(WorkPage.verifyMaximumLength("0/50",1,"1")) {
						if(WorkPage.verifyMaximumLength("0/50",4,"1")) {
								CommonFunction.logStatus("PASS", msg);
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		
				
		//Verify String 3 properties in both left and right have the length limit less than 149 so the entry box displays in two row.
		
				msg = "Verify String 3 properties in both left and right have the length limit less than 149 so the entry box displays in two row.";
				try {
					if(WorkPage.verifyMaximumLength("0/149",2, "2")) {
						if(WorkPage.verifyMaximumLength("0/149",5,"2")) {
								CommonFunction.logStatus("PASS", msg);
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Verify String 4 properties in both left and right have the length limit greater or equal to 150 so the entry box displays in three row.
				msg = "Verify String 4 properties in both left and right have the length limit greater or equal to 150 so the entry box displays in three row.";
				try {
					if(WorkPage.verifyMaximumLength("0/150",3,"3")) {
						if(WorkPage.verifyMaximumLength("0/150",6,"3")) {
								CommonFunction.logStatus("PASS", msg);
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Fill in the Integer and Domain1 properties.
				msg = "Fill in the Integer.";
				try {
					WorkPage.enterIntegerInput("10");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Fill in the Integer and Domain1 properties.
				msg = "Fill in the Domain1 properties.";
				try {
					WorkPage.enterDomain1Input("Ten");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click on any string property but do not enter any value and click away.
				msg = "Click on any string property but do not enter any value and click away.";
				try {
					WorkPage.clickTextArea("1");
					WorkPage.clickIntegerTextArea();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//The string property is highlighted in red with "!" to indicate it's a required property and cannot be empty.
				msg = "Verify The string property is highlighted in red with \"!\" to indicate it's a required property and cannot be empty.";
				try {
					if(WorkPage.verifyErrorHighlighted()) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//In this case the Proceed button for the step is disabled.
		//
				msg = "Fill in both String2 properties.";
				try {
					String text= "test test test test test test test test test tes50";
					String text1= "test test test test test tes30";
					WorkPage.enterTextArea("1",text);
					WorkPage.enterTextArea("4",text1);
						CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Once reaching the field length limit, the character counter is turning into red to indicate length limit is reached.
				msg = "Verify Once reaching the field length limit, the character counter is turning into red to indicate length limit is reached.";
				try {
					if(WorkPage.verifyCountHighlightedRed(2)) {
						if(WorkPage.verifyCountHighlightedRed(5)){
							CommonFunction.logStatus("PASS", msg);
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//User is no longer able to enter more characters.
		//Fill in both String3 properties. 
				msg = "Fill in both String3 properties.";
				try {
					String text= "test test test test test test test test test test test test test test test test test test test test test test test test test test test test test t149";
					String text1= "test test test test test test test test test test test test test test test test test test test te100";
					WorkPage.enterTextArea("2",text);
					WorkPage.enterTextArea("5",text1);
						CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Once two rows have been filled, a scroll is shown to allow scroll down to see more characters. 
				//Once three rows have been filled, a scroll is shown to allow scroll down to see more characters. 
				
				msg = "Verify Once reaching the field length limit, the character counter is turning into red to indicate length limit is reached.";
				try {
					if(WorkPage.verifyCountHighlightedRed(3)) {
						if(WorkPage.verifyCountHighlightedRed(6)){
							CommonFunction.logStatus("PASS", msg);
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//User is no longer able to enter more characters.
		//Fill in both String4 properties. 
				msg = "Fill in both String4 properties.";
				try {
					String text= "test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test te200";
					String text1= "test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test te250";
					WorkPage.enterTextArea("3",text);
					WorkPage.enterTextArea("6",text1);
						CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);		
		//Once three rows have been filled, a scroll is shown to allow scroll down to see more characters. 
		//Once reaching the field length limit, the character counter is turning into red to indicate length limit is reached. 
				msg = "Verify Once reaching the field length limit, the character counter is turning into red to indicate length limit is reached.";
				try {
					if(WorkPage.verifyCountHighlightedRed(4)) {
						if(WorkPage.verifyCountHighlightedRed(7)){
							CommonFunction.logStatus("PASS", msg);
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//User is no longer able to enter more characters.
		//Click Proceed once all properties are entered with values.
				msg = "Click Proceed once all properties are entered with values.";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Verified the property values in the job details panel.
		//Log out from the web app.

	}

}
