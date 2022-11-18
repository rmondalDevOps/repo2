package com.workflowmanager.testcases;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS54_Work_Page_Manage_attachment_step2  extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS54_Work_Page_Manage_attachment_step2() throws InterruptedException {
		 CommonFunction.waitforHomePagetoload();
		// Click on Design Tab

		msg = "Click on 'Design' Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//In Design - Settings - Groups page, select "Public_1 WMX Role" under Workflow Groups tab.
		//Check on jobupdateAttachments and  jobCreate role and save.
		//Click on Settings tab.
		msg = "Click on Settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The Settings page has three tabs: Groups, Roles and Email Notifications.
		msg = "Verify the Settings page has three tabs: Groups, Roles and Email Notifications.";
		try {
			Design.verifyGroupTabPanel();
			// cfunction.sync(2);
			Design.verifyRoleTabPanel();
			// cfunction.sync(2);
			Design.verifyEmailNotificationTabPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select 'Public 1_WMX Role' from the workflow groups";
		try {
			Design.selectWorkflowGroupFromList("Public_1 WMX Role");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
//No workflow roles are check on for this group except for Public_1 WMX Role.
		
//Check on jobupdateAttachments role and save.
		msg = "Check on \"jobCreate\" and \"jobupdateAttachments\"";
		try {
			Design.enableWorkflowPrivileges1("jobCreate");
			cfunction.sync(2);
			Design.enableWorkflowPrivileges1("jobupdateAttachments");
			cfunction.sync(2);
			//Design.clickOnSaveBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on 'Save' button";
		try {
			Design.clickOnSaveBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Go to Work page.
		msg = "Click on 'Work' Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Open the 'Create Job Panel'
		msg = "Open the 'Create Job Panel'";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//A list of Job Templates is returned
		msg = "Verify The create jobs panel should appear";
		try {
			if(WorkPage.verifyCreateJobPanelVisible()) {
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
		//Click on job template 'AA_attachment'
		msg = "Click on the \"Attachment_test\" job template";
		try {
			if(WorkPage.clickOnJobTemplate("Attachment_test")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Verify toast notification should appear in the top right indicating job creation";
		try {
			String msg1="successfully";
			Design.verifySuccessMsg(msg1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//A new job is created and a custom query tab is opened displaying the new job
		//Click start and proceed on the first step
		msg = "Click start on the first step";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The current step is now Add Attachment_general
		msg = "Verify the job's current step is 'Add Attachment_general'";
		try {
			if(WorkPage.verifyCurrentStepOfJob(jobName, "Add Attachment_general")) {
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
		//Click start for 'Add attachment_general' step
		msg = "Click start for 'Add attachment_general' step";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click Browse and navigate to the testing attachment files.
		msg = "Click Browse and navigate to the \"AOIEdits.zip\" testing attachment file.";
		try {
			WorkPage.selectFileToUpload("AOIEdits.zip");
			//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
//This step alllows to add any supported file types including zip, pdf, doc, xlsx, txt etc.
//Choose a zip file "AOIEdits" and click Open.
//A toast message indicates that the selected file is uploaded to the job. In the step dialog, the file is displayed with Alias, owner, last modified and actions.
//Update the attachment alias into "AOIEdits.zip"
		msg = "Update the attachment alias into \"EditAOI.zip\"";
		try {
			WorkPage.renameUploadedFile3("1","EditAOI.zip");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click Pause in the step dialog.
		msg = "Click \"Pause\" in the step dialog.";
		try {
			WorkPage.clickOnPauseBtn();
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//It returns to the job card.
		//Click start again 
		msg = "Click start again";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The step runs and open the dialog to prompt users: Attachment added in the previous step is still visible and available to download and deleate. Alias cant be updated anymore.  Please add attachments. Browse button is available to allow users to choose job attachment to upload.
		//Click Proceed in the step dialog.
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//It returns to the job card. The job is moved to the next step in the diagram: Add Attachment_blank.
		msg = "Verify the job's current step is 'Add Attachment_blank'";
		try {
			if(WorkPage.verifyCurrentStepOfJob(jobName, "Add Attachment_blank")) {
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
		//Run the step.
		msg = "Run the step.";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The step runs and open the dialog to prompt users: Please add attachments. Browse button is available to allow users to choose job attachment to upload. Attachment added in the previous step is visible and available to download or delete.
		//Click Browse and navigate to the testing attachment files.
		//Choose a excel file "Checklist" and click Open.
		msg = "Click Browse and navigate to the \"Checklist.xlsx\" testing attachment file.";
		try {
			WorkPage.selectFileToUpload("Checklist.xlsx");
			//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Choose another doc file "HelpDoc" and click Open.
		msg = "Click Browse and navigate to the \"HelpDoc.docx\" testing attachment file.";
		try  {
			WorkPage.selectFileToUpload("HelpDoc.docx");
			//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click the download button to download 'Checklist'
		msg = "Click the download button to download 'Checklist'";
		try {
			WorkPage.downloadUploadedFile("2");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Checklist attachment is downloaded succesfully 
		msg = "verify attachments gets downloaded";
		try {
			
			WorkPage.verifyDownloadISSuccessful("Checklist");
			WorkPage.verifyDownloadIsDeleted("Checklist","Checklist.xlsx");
			cfunction.sync(2);
			//WorkPage.clickUploadedFile("1");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click delete icon for 'HelpDoc' 
		msg = "Delete the attachment \"HelpDoc\"";
		try {
			WorkPage.deleteUploadedFile("3");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click Proceed in the step dialog.
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//It returns to the job card. The job is moved to the next step in the diagram: Add Attachment_blank.
		msg = "Verify the job's current step is 'Add Attachment_new_folder'";
		try {
			if(WorkPage.verifyCurrentStepOfJob(jobName, "Add Attachment_new_folder")) {
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
		//It returns to the job card. The job is moved to the next step in the diagram: Add Attachment_new_folder.
		//Run the step
		msg = "Run the step.";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The step runs and open the dialog to prompt users: Please add attachments. Browse button is available to allow users to choose job attachment to upload. There are no existing attachments
		//Click Proceed in the step dialog.
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//It returns to the job card. The job is moved to the next step in the diagram: Add Attachment_blank.
		msg = "Verify the job's current step is 'Add Attachment_user2'";
		try {
			if(WorkPage.verifyCurrentStepOfJob(jobName, "Add Attachment_user2")) {
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
		//It returns to the job card. The job is moved to the next step in the diagram: Add Attachment_user2
		//Run the step.
		msg = "Run the step.";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//You should see attachment
		msg = "Click on 'Design' Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//In Design - Settings - Groups page, select "Public_1 WMX Role" under Workflow Groups tab.
		//Check on jobupdateAttachments and  jobCreate role and save.
		//Click on Settings tab.
		msg = "Click on Settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select 'Public 1_WMX Role' from the workflow groups";
		try {
			Design.selectWorkflowGroupFromList("Public_1 WMX Role");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
//No workflow roles are check on for this group except for Public_1 WMX Role.
		
//Check on jobupdateAttachments role and save.
		msg = "Uncheck on \"jobCreate\" and \"jobupdateAttachments\"";
		try {
			Design.enableWorkflowPrivileges1("jobCreate");
			cfunction.sync(2);
			Design.enableWorkflowPrivileges1("jobupdateAttachments");
			cfunction.sync(2);
			//Design.clickOnSaveBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on 'Save' button";
		try {
			Design.clickOnSaveBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Log out from the web app.
	}
}