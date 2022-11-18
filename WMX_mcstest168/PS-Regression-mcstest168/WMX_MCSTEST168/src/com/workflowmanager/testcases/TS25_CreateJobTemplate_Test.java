package com.workflowmanager.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;
import com.workflowmanager.pages.Coordinate;

public class TS25_CreateJobTemplate_Test extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	//String workflowDiagramName = cfunction.getUniqueName(xls.getCellData("en-us", 2,11));
	String msg = "";
	public void workflow_TS25_CreateJobTemplate() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//System.out.println("this is a 22 test case variable   " + TestBase.workflowDiagramName);
		//Click on Design
				msg = "Click on Design Tab";
				try {
					HomePage.clickOnDesign();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}	
				cfunction.sync(2);
				//Click on Job Templates
				msg = "Click on Job Templates";
				try {
					Design.clickOnJobTemplatesIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click on 'Create New'
				msg = "Click on 'Create New'";
				try {
					Design.clickOnCreateNewBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				msg = "Enter Job Template name as: "+workflowDiagramName;
				//String jobTemplateName = "Sample diagram";
				//String jobTemplateName = "Test Template";
				try {
					Design.enterJobTemplateName(workflowDiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				String selectText = xls.getCellData("en-us", 3,6);
				msg = "From 'Current Workflow Diagram' dropdown select "+selectText;
				try {
					Design.selectCurrentWorkflowDiagram(selectText);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Set the Job Priority to High
				msg = "Set the Job Priority to 'High'";
				try {
					Design.openDropDownMenuOfPriority();
					Design.selecPriority("High");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Toggle the checkboxes for start date and end date
				msg = "Toggle the checkboxes for start date and end date";
				try {
					Design.clickJobStartDateCheckbox();
					cfunction.sync(2);
					Design.clickJobEndDateCheckbox();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Click the assigned to dropdown and select Aarthi D
				msg = "Click the assigned to dropdown and select 'Aarthi D'";
				try {
					Design.assignJob("Aarthi D");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click the category dropdown and select Test Case
				msg = "Click the category dropdown and select 'Test Case'";
				try {
					Design.selectCategory("Test Case");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//"For summary type 'Test summary'
				msg = "Ener Job Template Summary as 'Test Summary'";
				try {
					Design.enterJobTemplateSummary("Test Summary");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//For description type 'Test description'"
				msg = "Enter Default Job Description as 'Test description'";
				try {
					Design.enterDefaultJobDescription("Test Description");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Click save
				msg = "Click 'save' button";
				try {
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Editing workflow diagram name for Firefox execution
				workflowDiagramName=workflowDiagramName+"_1";
	}
	}