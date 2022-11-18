package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.Coordinate;


public class TS01_CreateNewJob extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String jobTemplateName = cfunction.getUniqueName(xls.getCellData("en-us", 2,3));
	String msg = "";

	public void workflow_TS1_CreateNewJob() throws InterruptedException {
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

		//Enter Job Template name 'Some Job Template'
		//String jobTemplateName = xls.getCellData("en-us", 2,3);
		msg = "Enter Job Template name '"+ jobTemplateName +"'";
		try {
			Design.enterJobTemplateName(jobTemplateName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//From 'Current Workflow Diagram' dropdown select 'Data Edits Simple'
		String selectText = "Data Edits Sample";
		msg = "From 'Current Workflow Diagram' dropdown select '"+ selectText + "'";
		try {
			Design.selectCurrentWorkflowDiagram(selectText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*//Click on 'Default Properties'
		msg = "Click on 'Default Properties'";
		try {
			Design.clickOnDefaultProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		//commented as per mail communication with SAM
		//Assign the Job to 'Kevin Bedel'
		String assignedTo = xls.getCellData("en-us", 4,3);
		msg = "Assign the Job to '"+ assignedTo+"'";
		try {
			Design.assignJob(assignedTo);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//workaround for UI distortion on VNC, Save is not visible
		cfunction.pressTAB(6);
		
		//Click on Save Button
		msg = "Click on Save Button";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Verify Success message is displayed.
		msg = "Verify Success message is displayed.";
		String successMsg = "Job template: "+ jobTemplateName+" created successfully";
		try {
			if(Design.verifySuccessMsg(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//commented as the messages would be toast msg, will close automatically
		/*//Click on OK.
		msg = "Click on X button";
		try {
			Design.clickOnXBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		//Click on Production tab
		msg = "Click on Production tab";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Click on 'New Job' Tab
		msg = "Click on 'New Job' Tab";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			cfunction.sync(2);
			Coordinate.clickOnNewJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enter "Some" in Search Textbox
		String searchText = xls.getCellData("en-us", 3,3);
		msg = "Enter '"+ searchText +"' in Search Textbox";
		try {
			Coordinate.enterSearchText(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify 'Some Job Template' is displayed in the list
		msg = "Verify '"+ jobTemplateName +"' is displayed in the list";
		try {
			if(Coordinate.verifyJobIsPresent(jobTemplateName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

	}
}
