package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS79_DesignPage_CreateAndUpdateAutomatedActionsJobTemplate extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS79_DesignPage_CreateAndUpdateAutomatedActionsJobTemplate() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on Job Templates
		msg = "Click on Job Templates";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on 'Create New'
		msg = "Click on 'Create New'";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the new job template is displayed.
		msg = "Verify the new job template is displayed. ";
		try {
			if (Design.verifyNewJobTempate())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify in Profile tab, only "STATE" field is automatically populated with
		// "Active".
		msg = "Verify in Profile tab, only 'STATE' field is automatically populated with 'Active'";
		try {
			if (Design.verifyState("Active"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Job Template name 'Test Template'
		msg = "Enter Job Template name 'Test Template'";
		String jobTemplateName = jobTemplateName2;
		// String jobTemplateName = "Test Template";
		try {
			Design.enterJobTemplateName(jobTemplateName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// From 'Current Workflow Diagram' dropdown select 'Data Edits Simple'
		String selectText = "Create Job Auto Execution";
		msg = "From 'Current Workflow Diagram' dropdown select '" + selectText + "'";
		try {
			Design.selectCurrentWorkflowDiagram(selectText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the diagram is displayed in "PREVIEW".
		msg = "Verify the diagram is displayed in PREVIEW";
		try {
			if (Design.verifyDiagramIsDisplayed())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Go to Automated Action tab and click Add Activity under Job Activities
		// section.
		msg = "Click on 'Automated Action' tab";
		try {
			Design.clickOnAutomatedAction();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on Add Activity
		msg = "Click on 'Add Activity";
		try {
			Design.clickOnAddActivity();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job activity is inserted.
		// Open Type drop down
		msg = "Click on the drop down under 'TYPE' ";
		try {
			Design.clickTYPEDropdown();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify that the available types are: Add Comment, Assign Job, Close Job,
		// Create Job, Delete Job, Set Current Step.
		msg = "Verify that the available types are: Add Comment, Assign Job, Close Job, Create Job, Delete Job, Set Current Step.";
		String requestTypes[] = { "Add Comment", "Assign Job", "Close Job", "Create Job", "Delete Job",
				"Set Current Step" };
		try {
			if (Design.verifyTYPEdrpdwnList(requestTypes)) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Choose one activity type in drop down: Create Job
		msg = "Choose one activity type in drop down: Create Job";
		String requestType = "Create Job";
		try {
			if (Design.selectTYPEdrpdwnList(requestType)) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Choose Action from the drop down: Send Email Notification
		msg = "Choose Action from the drop down: Send Email Notifications";

		try {
			Design.openActionDropdownMenu();
			cfunction.sync(2);
			Design.selectActionFromDropdown("Send Email Notifications");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Open Template drop down
		msg = "Open Template drop down";

		try {
			Design.openTemplateDropdownMenu();
			// Design.selectActionFromDropdown("Send Email Notification");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Choose an email template.
		msg = "Choose an \"email template\".";

		try {
			// Design.openActionDropdownMenu();
			if(Design.selectTemplateFromDropdown("Test Template")) {
			CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Save the job template.
		msg = "Click on 'Save' to save the job template";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// cfunction.sync(2);
		// Verify the job template is created, verify the automated action is saved in
		// the template.
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
		msg = "Click on 'Automated Action' tab";
		try {
			Design.clickOnAutomatedAction();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Update the template by adding another job activity.
		msg = "Update the template by adding another job activity.";
		try {
			Design.clickOnAddActivity1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Do not save the template and go to a different tab of job template, i.e.
		// Profile.
		msg = "Click on Profile tab";
		try {
			Design.clickOnProfile();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Return to Automated Action tab.
		msg = "Click on 'Automated Action' tab";
		try {
			Design.clickOnAutomatedAction();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the previous update still persists, the added job activity is still existing.
		// Click on a different job template
		msg = "Select job template";
		try {
			Design.clickOnJobTemplate("Attachment_Selenium");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Get the prompt to save the edits.
		msg = "Verify prompt to save the edits.";
		try {
			if (Design.verifyConfirmDialog()) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Choose yes to save the updates in the job template.
		msg = "Select yes to save the updates in the job template.";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the saved job template again.
		msg = "Select job template";
		try {
			Design.clickOnJobTemplate(jobTemplateName2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on 'Automated Action' tab";
		try {
			Design.clickOnAutomatedAction();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the newly added job activity is saved.
		// Delete the added job activity.
		msg = "Delete the added job activity.";
		try {
			Design.hoverDeleteActivitybtn(2);
			cfunction.sync(2);
			Design.clickDeleteActivitybtn(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Update the activity type for existing activity from Create Job to Close Job.
		msg = "Choose one activity type in drop down: Close Job";
		// String requestType = "Close Job";
		try {
			Design.clickTYPEDropdown();
			cfunction.sync(2);
			if (Design.selectTYPEdrpdwnList("Close Job")) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Save the job template.
		msg = "Click on 'Save' to save the job template";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// cfunction.sync(2);
		// Verify the job template is created, verify the automated action is saved in
		// the template.
		msg = "Verify Success message is displayed.";
		//String successMsg = "Job template: "+ jobTemplateName+" created successfully";
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
		// Verify the deletion and update of type are saved.
	}
}
