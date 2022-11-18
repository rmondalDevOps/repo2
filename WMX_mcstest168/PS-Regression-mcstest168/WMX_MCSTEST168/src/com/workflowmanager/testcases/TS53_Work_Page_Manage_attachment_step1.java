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

public class TS53_Work_Page_Manage_attachment_step1  extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS53_Work_Page_Manage_attachment_step1() throws InterruptedException {
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
				msg = "Click on \"jobupdateAttachments\"";
				try {
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
		//This will grant the wmxuser with manage job attachment privileges.
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
		//Enter job_name = 'Attachment Test' om custom search
				msg = "Expand Custom Search";
				try {
					WorkPage.clickOnCustomeSearchIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter \"job_name = 'Attachment Test'\" om custom search";
				try {
					String query = "job_name = 'Attachment Test'";
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
		//The job named "Attachment Test" is returned.
		//Run first step Add Attachment - All Types
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The step runs and open the dialog to prompt users: Please add attachments. Browse button is available to allow users to choose job attachment to upload.
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
				msg = "Update the attachment alias into \"AOIEdits.zip\"";
				try {
				//	WorkPage.renameUploadedFile("1","EditAOI.zip");
					WorkPage.renameUploadedFile3("1","EditAOI.zip");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//The alias is updated.
		//Click Proceed in the step dialog.
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//It returns to the job card. The job is moved to the next step in the diagram: Add Attachment - Certain Types.
		msg = "Verify the job's current step is 'Add Attachment - Certain Types'";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Attachment Test", "Add Attachment - Certain Types")) {
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
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The step runs and open the dialog to prompt users: Please add attachments. Browse button is available to allow users to choose job attachment to upload.
		//Click Browse and navigate to the testing attachment files.
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
		//This step alllows to add the file types only configured in the step includingpdf, txt, doc and xlsx.
		//Choose a excel file "Checklist" and click Open.
		//A toast message indicates that the selected file is uploaded to the job. In the step dialog, the file is displayed with Alias, owner, last modified and actions.
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
		//A toast message indicates that the selected file is uploaded to the job. In the step dialog, the file is displayed with Alias, owner, last modified and actions.
		//Choose another pdf file "README" and click Open.
				msg = "Click Browse and navigate to the \"README.pdf\" testing attachment file.";
				try {
					WorkPage.selectFileToUpload("README.pdf");
					//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A toast message indicates that the selected file is uploaded to the job. In the step dialog, the file is displayed with Alias, owner, last modified and actions.
		//Rename the alias of each file as Checklist.xlsx, README.pdf, and HelpDoc.docx
				msg = "Rename the alias of each file as Checklist.xlsx, README.pdf, and HelpDoc.docx";
				try {
					WorkPage.renameUploadedFile("1","Checklist.xlsx");
					cfunction.sync(2);
					WorkPage.renameUploadedFile("2","HelpDoc.docx");
					cfunction.sync(2);
					WorkPage.renameUploadedFile("3","README.pdf");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The alias are updated.
		//Delete the attachment "README.pdf"
				msg = "Delete the attachment \"README.pdf\"";
				try {
					WorkPage.deleteUploadedFile("6");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A toast message indicates that the attachment is deleted from the job.
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
		//It returns to the job card.  Current step is still Add Attachment - Certain Types
				msg = "Verify the job's current step is 'Add Attachment - Certain Types'";
				try {
					if(WorkPage.verifyCurrentStepOfJob("Attachment Test", "Add Attachment - Certain Types")) {
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
		//Click on the job card and make sure the job details panel is expanded.
				msg = "Click on the job card.";
				try {
					WorkPage.clickOnJobDetails("Attachment Test");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on the job details panel is expanded.";
				try {
					WorkPage.clickOnCollapseRightPane();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click on Attachment icon to open the job attachment tab.
				msg = "Click on Attachment icon to open the job attachment tab.";
				try {
					WorkPage.clickOnAttachment();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//It lists two folders: Folder1 and Folder2. Folder1 has the AOIEdits.zip file uploaded in the first attachment step. Folder2 has Checklist.xlsx and HelpDoc.docx uploaded in the 2nd attachment step.
		//Hover over the "EditAOI.zip" attachment.
				msg = "Hover over the \"EditAOI.zip\" attachment.";
				try {
					WorkPage.hoverUploadedFile("1");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//There is an "i" information icon availabe. The attachment file name becomes a hyperlink. The Delete icon is available.
		//Hover over the "i" icon
				msg = "Hover over the \"i\" icon";
				try {
					WorkPage.hover_i_Icon("1");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//It displays the tooltips with last modified user and date.
				/*msg = "It displays the tooltips with last modified user and date.";
				try {
					String currentDate = CommonFunction.currentDate();
					if(WorkPage.verify_i_IconToolTip(currentDate)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//Click on the hyperlink of the file name
				msg = "Click on the hyperlink of the file name";
				try {
					
					WorkPage.hoverUploadedFile("1");
					cfunction.sync(2);
					WorkPage.clickUploadedFile("1");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//It downloads the attachment file into local. Verify the downloaded attachment file is opened properly.
				msg = "verify attachments gets downloaded";
				try {
					
					WorkPage.verifyDownloadISSuccessful("EditAOI.zip");
					WorkPage.verifyDownloadIsDeleted("EditAOI.zip","EditAOI.zip.zip");
					cfunction.sync(2);
					WorkPage.clickUploadedFile("1");
					msg = "verify attachments gets downloaded";
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click on the job card and make sure the job details panel is expanded.
		//Click on Attachment icon to open the job attachment tab.
		//It lists two folders: Folder1 and Folder2. Folder1 has the AOIEdits.zip file uploaded in the first attachment step. Folder2 has Checklist.xlsx and HelpDoc.docx uploaded in the 2nd attachment step.
		//Hover over the "Checklist.xlsx" attachment.
				msg = "Hover over the \"Checklist.xlsx\" attachment.";
				try {
					WorkPage.hoverUploadedFile("2");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//There is an "i" information icon availabe. The attachment file name becomes a hyperlink. The Delete icon is available.
		//Hover over the "i" icon
				msg = "Hover over the \"i\" icon";
				try {
					WorkPage.hover_i_Icon("2");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//It displays the tooltips with last modified user and date.
				/*msg = "It displays the tooltips with last modified user and date.";
				try {
					String currentDate = CommonFunction.currentDate();
					if(WorkPage.verify_i_IconToolTip(currentDate)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				//Hover over the "HelpDoc.docx" attachment.
				msg = "Hover over the \"HelpDoc.docx\" attachment.";
				try {
					WorkPage.hoverUploadedFile("3");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//There is an "i" information icon availabe. The attachment file name becomes a hyperlink. The Delete icon is available.
		//Hover over the "i" icon
				msg = "Hover over the \"i\" icon";
				try {
					WorkPage.hover_i_Icon("3");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//It displays the tooltips with last modified user and date.
				/*msg = "It displays the tooltips with last modified user and date.";
				try {
					String currentDate = CommonFunction.currentDate();
					if(WorkPage.verify_i_IconToolTip(currentDate)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//Hover over the "AOIEdits.zip" file in Folder 1 and click Delete.
				msg = "Hover over the \"AOIEdits.zip\" file in Folder 1 and click Delete.";
				try {
					WorkPage.hoverUploadedFile("1");
					cfunction.sync(2);
					WorkPage.hoverUploadDeleteBtn("1");
					WorkPage.clickUploadDeleteBtn("1");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//A confirmation to delete the job attachment pops up.
				msg = "A confirmation to delete the job attachment pops up.";
				try {
					if(Design.verifyConfirmDialog()) {
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
		//Click No
				msg = "Click No";
				try {
					Design.clickCancelOnConfirmDialog();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The attachment is not deleted.
		//Hover over the "AOIEdits.zip" file in Folder 1 and click Delete.
				msg = "Hover over the \"AOIEdits.zip\" file in Folder 1 and click Delete.";
				try {
					WorkPage.hoverUploadedFile("1");
					cfunction.sync(2);
					WorkPage.hoverUploadDeleteBtn("1");
					WorkPage.clickUploadDeleteBtn("1");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A confirmation to delete the job attachment pops up.
				msg = "A confirmation to delete the job attachment pops up.";
				try {
					if(Design.verifyConfirmDialog()) {
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
		//Click Yes
				msg = "Click Yes";
				try {
					Design.clickYesOnConfirmDialog();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A toast message indicates that the attachment is deleted from the job. The Folder1 is removed from the job details panel.
				/*msg = "Verify a toast message indicates that the attachment is deleted from the job.";
				try {
					WorkPage.verifySuccessMsg("updated");
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				//In Design - Settings - Groups page, select "Public_1 WMX Role" under Workflow Groups tab.
		//Uncheck on "jobUpdateAttachment" role for group Public_1 WMX Role and save.
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
						msg = "Uncheck on \"jobupdateAttachments\"";
						try {
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
		//Go to Work page and search for the previous job.
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
				//Enter job_name = 'Attachment Test' om custom search
						msg = "Expand Custom Search";
						try {
							WorkPage.clickOnCustomeSearchIcon();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Enter \"job_name = 'Attachment Test'\" om custom search";
						try {
							String query = "job_name = 'Attachment Test'";
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
		//Click on the job card and open the job details panel as needed.
						msg = "Click on the job card.";
						try {
							WorkPage.clickOnJobDetails("Attachment Test");
							CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Click on the job details panel is expanded.";
						try {
							WorkPage.clickOnCollapseRightPane();
							CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						//Click on Attachment tab.
						msg = "Click on Attachment icon to open the job attachment tab.";
						try {
							WorkPage.clickOnAttachment();
							CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		//The job's attachments in Folder2 are visible.
		//Hover over the job attachments.
						msg = "Hover over the \"Checklist.xlsx\" attachment.";
						try {
							WorkPage.hoverUploadedFile("1");
							CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		//Delete isn't available due to missing the privilege of jobUpdateAttachment.
		//Log out from the web app.

	}
}
