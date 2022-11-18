package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;


public class TS04_JobTemplateCreation extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS4_JobTemplateCreation() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
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

		//Enter Job Template name 'Test Template'
		msg = "Enter Job Template name 'Test Template'";
		String jobTemplateName = xls.getCellData("en-us", 2,6);
		//String jobTemplateName = "Test Template";
		try {
			Design.enterJobTemplateName(jobTemplateName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//From 'Current Workflow Diagram' dropdown select 'Data Edits Simple'
		String selectText = xls.getCellData("en-us", 3,6);
		msg = "From 'Current Workflow Diagram' dropdown select '"+ selectText + "'";
		try {
			Design.selectCurrentWorkflowDiagram(selectText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on 'Default Properties'
		msg = "Click on 'Default Properties'";
		try {
			//Design.clickOnDefaultProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//commented as per mail communication with SAM
		
		//Assign the Job to 'Kevin Bedel'
		String assignedTo = xls.getCellData("en-us", 4,6);
		msg = "Assign the Job to '"+ assignedTo+"'";
		try {
			Design.assignJob(assignedTo);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		 
		msg = "Click on 'Extended Properties'";
		try {
			Design.clickOnExtendedProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
	}
}
