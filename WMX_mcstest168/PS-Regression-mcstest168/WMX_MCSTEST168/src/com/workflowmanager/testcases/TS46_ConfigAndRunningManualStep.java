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

public class TS46_ConfigAndRunningManualStep extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String DiagramName = cfunction.getUniqueName("Test ");
	String msg = "";

	public void workflow_TS46_ConfigAndRunningManualStep() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		// Click on Design Tab

		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on create new button
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Enter Diagram Name
		msg = "Enter diagram name as '" + DiagramName + "'";
		try {
			Design.enterDiagramName(DiagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Enter Diagram description
		msg = "Enter diagram description as 'Test description'";
		try {
			Design.enterDiagramDescription("Test Description");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Add a new manual step to the diagram and name it manual step 1
		msg = "Add a new manual step to the diagram and name it manual step 1";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick("TS44_StartStep_1280x768");
			cfunction.sync(2);
			SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
			Design.enterStepName("Manual Step 1");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// "Check boxes for 'Automatically Execute' and ' Can be Skipped'
		msg = "Check boxes for 'Automatically Execute' and ' Can be Skipped'";
		try {
			Design.clickOnStepDetailOptionTab();
			Design.clickOnOptionRadioBtn1();
			Design.clickOnOptionRadioBtn2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Set 'User Prompt' under Logic to be blank."
		msg = "Set 'User Prompt' under Logic to be blank.";
		try {
			Design.clickOnStepDetailPropertiesTab();
			Design.enterUserPromptInput1("");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click the bottom arrow to add a new manual step to the canvas - Manual step 2
		msg = "Click the bottom arrow to add a new manual step to the canvas - Manual step  2";
		try {

			SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
			Design.enterStepName("Manual Step 2");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// "Check box for 'Automatically Execute'
		msg = "Check box for 'Automatically Execute";
		try {
			Design.clickOnStepDetailOptionTab();
			Design.clickOnOptionRadioBtn1();
			cfunction.sync(2);
			Design.clickOnOptionRadioBtn2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Set 'User Prompt' under Logic to be ' This is a very big user prompt to make
		// sure that the data is being displayed correctly. Ideally, we only show 2
		// lines of user prompt on the manual step. The rest should be displayed using
		// ellipses'"
		msg = "Set 'User Prompt' under Logic to be ' This is a very big user prompt to make sure that the data is being displayed correctly. Ideally, we only show 2 lines of user prompt on the manual step. The rest should be displayed using ellipses'";
		try {
			String text="Set 'User Prompt' under Logic to be ' This is a very big user prompt to make sure that the data is being displayed correctly. Ideally, we only show 2 lines of user prompt on the manual step. The rest should be displayed using ellipses'";
			Design.clickOnStepDetailPropertiesTab();
			Design.enterUserPromptInput1(text);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click the bottom arrow to add a new manual step to the canvas - Manual step 3
		msg = "Click the bottom arrow to add a new manual step to the canvas - Manual step  3";
		try {

			SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
			Design.enterStepName("Manual Step 3");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// "Check box for 'Can be skipped' "
		msg = "Click on Activate Button";
		try {
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// There will be a pop up to create a new 'Job Template'
		// Click Yes on the dialog
		msg = "Click Yes button of confirmation to create job tamplate";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The job template page is now displayed
		msg = "Job Template panel will be displayed with the new job template '" + DiagramName + "Path arcade test'";
		try {
			Design.verifyJobTemplateHeader(DiagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click Save to save the job Template
		msg = "Click Save";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Go to the work page
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the 'Create job' panel
		msg = "Click on the left create button to expand the left panel";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// All the existing job templates are displayed.
		msg = "Click on " + DiagramName + " template to a create job";

		try {
			Coordinate.clickCreateDefaultOfTemplatePresent(DiagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// cfunction.sync(2);
		// 'Job created successfully should appear in a toast notification
		msg = "Verify Job should be created successfully";

		try {
			String successMsg = "successfully";
			Coordinate.verifySuccessMsg(successMsg);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// A new custom search tab is added with the newly created job
		// Run the first step in the job
		/*msg = "Run \"Start/End\" step for the job";
		try {
			WorkPage.clickOnStartBtn();

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// The job tile flips to show the user prompt and step help. Proceed and Pause
		// buttons are displayed
		// Click the Proceed button.
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Manual Step 1 is already in progress with the job tile displaying the user
		// prompt and step help and Proceed and Pause buttons
		// Click the Proceed button.
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Manual Step 2 is already in progress with the job tile displaying the user
		// prompt and step help and Proceed and Pause button
		// Click Pause button
		msg = "Click on Pause button";
		try {
			WorkPage.clickOnPauseBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The job tile flips back to its original state displaying job information
		// Click the start button for the Manual Step 2
		msg = "Click the start button for the Manual Step 2";
		try {
			WorkPage.clickOnStartBtn();

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The job tile flips to show the user prompt and step help. Proceed and Pause
		// buttons are displayed. Make sure the user prompt has tooltip to display the
		// message that gets cut off
		// Click Proceed
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Job tile flips back to the original state and the current step is now Manual
		// Step 3
		// Click Finish
		/*msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// Manual Step 1 is already in progress with the job tile displaying the user
		// prompt and step help and Proceed and Pause buttons
		// Click the Proceed button.
		/*msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// Job is now complete and the Dismiss button is displayed
		msg = "Job is now complete and the Dismiss button is displayed";
		try {
			WorkPage.verifyDismissJobTileButtonVisible();
			WorkPage.clickOnDismissJobTileButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
	}
}
