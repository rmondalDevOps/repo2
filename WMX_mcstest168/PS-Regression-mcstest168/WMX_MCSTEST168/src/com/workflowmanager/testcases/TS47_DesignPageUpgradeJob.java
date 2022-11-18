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


public class TS47_DesignPageUpgradeJob extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String DiagramName = cfunction.getUniqueName("Test1 ");
	//String DiagramName = "Manual Step 3";
	String msg = "";
	public void workflow_TS47_DesignPageUpgradeJob() throws InterruptedException {
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
		//Click on create new button
				msg = "Click on Create New button";
				try {
					Design.clickOnCreateNewBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter Diagram Name
				msg = "Enter diagram name as '"+DiagramName+"'";
				try {
					Design.enterDiagramName(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter Diagram description
				msg = "Enter diagram description as 'Test description'";
				try {
					Design.enterDiagramDescription("Test Description");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Add a new manual step to the diagram and name it manual step 1
				msg = "Add a new manual step to the diagram and name it manual step 1";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS47_StartStep_1280x768");
					cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
					Design.enterStepName("Manual Step 1");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
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
				//Give the diagram a name and click Activate
				msg = "Click on Activate Button";
				try {
					Design.clickOnActivateWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Yes on the dialog
				msg = "Click Yes button of confirmation to create job tamplate";
				try {
					Design.clickYesOnConfirmDialog();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The job template page is now displayed
				msg = "Job Template panel will be displayed with the new job template '"+DiagramName;
				try {
					Design.verifyJobTemplateHeader(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Save to save the job Template
				msg = "Click Save";
				try {
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Go to the work page
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click on the 'Create job' panel
				msg = "Click on the left create button to expand the left panel";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//All the existing job templates are displayed.
				msg = "Click on "+DiagramName+" template to a create job";
				
				try {
					Coordinate.clickCreateDefaultOfTemplatePresent(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				// 'Job created successfully should appear in a toast notification
				msg = "Verify Job should be created successfully";

				try {
					String successMsg = "successfully";
					if(Coordinate.verifySuccessMsg(successMsg)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else{
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				//A new custom search tab is added with the newly created job
				//Run the first step in the job 
				/*msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();

				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				//Open the Job Panel on the right
				msg = "Open the Job Panel on the right";
				try {
					WorkPage.clickOnCollapseSummaryBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				/*//The job panel opens up with all the job properties
				
				//Click the elipses button on the bottom of Job panel
				msg = "Click the ellipses button on the bottom of Job panel";
				try {
					Coordinate.clickEllipsesBtn2();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//A list with show job id, delete job and Upgrade Job is displayed
				//Click Upgrade Job
				msg = "Click Upgrade Job";
				try {
					Coordinate.clickUpgradeJob();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}*/
				msg="Verify Upgrade Job is enabled after after clicking on Ellipse and click on Upgrade ";
				try {
					Coordinate.clickEllipseVerifyUpgradePresence1(msg);
					///CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				//A green message is displayed ' JobsUpgraded successfully'
				/*msg = "A green message is displayed ' JobsUpgraded successfully";

				try {
					String successMsg = "successfully";
					if(Coordinate.verifySuccessMsg1(successMsg)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else{
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
*/				//Go back to Design Page. 
				msg = "Click on Design Tab";
				try {
					HomePage.clickOnDesign();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Edit the diagram you previously create. Rename Manual step 1 to Manual Step A. Click Activate
				msg = "Select the prviously created diagram";
				msg = "Enter '"+ DiagramName +"' in Search Textbox";
				try {
					Design.enterSearchText_Diagram(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);
				msg = "Click on Edit button";
				try {
					Design.clickOnEditBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on \"Manual Step 1\"";
				if (browser.equalsIgnoreCase("firefox")) {
					try {
						
						SikuliHelp.selectLocationOnMapSikuliClick("TS47_ManualStep1_FF_1280x768");
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}}
				else {
					try {
				
					SikuliHelp.selectLocationOnMapSikuliClick("TS47_ManualStep1_1280x768");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}}
				cfunction.sync(2);
				msg = "Remane \"Manual Step 1\" to \"Manual Step A\"";
				try {
					Design.enterStepName("Manual Step A");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on Activate Button";
				try {
					Design.clickOnActivateWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The Diagram is now saved
				/*msg = "Click on Save Button";
				try {
					Design.clickOnSaveWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				//Go back to Work Page and find the job you previously created.
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Navigate to the previously created Job";
				try {
					WorkPage.clickOnNewFilterBy();
					cfunction.sync(15);
					if(WorkPage.scrollToJob(jobName)) {
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
				//The resume and resume button are displayed on the job
				//Click on the upgrade job button on the job panel for this job
				//Open the Job Panel on the right
				msg = "Open the Job Panel on the right";
				try {
					WorkPage.clickOnCollapseSummaryBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click the elipses button on the bottom of Job panel
				/*msg = "Click the ellipses button on the bottom of Job panel";
				try {
					Coordinate.clickEllipsesBtn2();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Upgrade Job
				msg = "Click Upgrade Job";
				try {
					Coordinate.clickUpgradeJob();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}*/
				msg="Verify Upgrade Job is disabled after after clicking on Ellipse and click on Upgrade ";
				try {
					Coordinate.clickEllipseVerifyUpgradePresence2(msg);
					//CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				//A red error toast notification is displayed. ' Unable to upgrade job. No jobs were upgraded, Jobs were running.'
				/*msg = "A red error toast notification is displayed. ' Unable to upgrade job. No jobs were upgraded, Jobs were running.'";

				try {
					String successMsg = "Unable";
					if(Coordinate.verifySuccessMsg1(successMsg)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else{
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
*/				//Click Resume and Proceed. Click on Upgrade Job button on the job panel
				
				msg = "Click Resume and Proceed. Click on Upgrade Job button on the job panel";
				try {
					if(WorkPage.clickOnresumeStepOfJob(jobName)) {
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
				msg = "Click on pause button";
				try {
					WorkPage.clickOnPauseBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
			/*	msg = "Click the ellipses button on the bottom of Job panel";
				try {
					Coordinate.clickEllipsesBtn2();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//A list with show job id, delete job and Upgrade Job is displayed
				//Click Upgrade Job
				msg = "Click Upgrade Job";
				try {
					Coordinate.clickUpgradeJob();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}*/
				msg="Verify Upgrade Job is enabled after after clicking on Ellipse and click on Upgrade ";
				try {
					Coordinate.clickEllipseVerifyUpgradePresence1(msg);
					///CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				//A green message is displayed ' JobsUpgraded successfully'
				/*msg = "A green message is displayed ' JobsUpgraded successfully";

				try {
					String successMsg = "successfully";
					if(Coordinate.verifySuccessMsg1(successMsg)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else{
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
*/				//Go back to the design page and edit the diagram created previously 
				//Go back to Design Page. 
				msg = "Click on Design Tab";
				try {
					HomePage.clickOnDesign();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Edit the diagram you previously create. Rename Manual step 1 to Manual Step A. Click Activate
				msg = "Select the prviously created diagram";
				msg = "Enter '"+ DiagramName +"' in Search Textbox";
				try {
					Design.enterSearchText_Diagram(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);
				msg = "Click on Edit button";
				try {
					Design.clickOnEditBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on \"Manual Step A\"";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS47_ManualStepA_1280x768");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Delete Manual Step A from the diagram. Click Activate
				msg = "Delete \"Manual Step A\"";
				try {
					Actions action = new Actions(driver); 
					action.sendKeys(Keys.DELETE).build().perform();
					cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS47_StartStep_1280x768");
					/*cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");*/
					cfunction.sync(2);
					SikuliHelp.hoveronLocationSikuli("PathStart_1280x768");
					cfunction.sync(2);
					Design.dragStepToCanvas("PathDown", "TS47_ManualStep2");
					cfunction.sync(2);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on Activate Button";
				try {
					Design.clickOnActivateWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The Diagram is now saved
				msg = "Click on Save Button";
				try {
					Design.clickOnSaveWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Go back to the Work Page and find the job that was created previously
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Navigate to the previously created Job";
				try {
					WorkPage.clickOnNewFilterBy();
					cfunction.sync(15);
					if(WorkPage.scrollToJob(jobName)) {
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
				//Select the job in the job list and click Upgrade Job in the job Panel
				msg = "Open the Job Panel on the right";
				try {
					WorkPage.clickOnCollapseSummaryBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*//Click the elipses button on the bottom of Job panel
				msg = "Click the ellipses button on the bottom of Job panel";
				try {
					Coordinate.clickEllipsesBtn2();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Upgrade Job
				msg = "Click Upgrade Job";
				try {
					Coordinate.clickUpgradeJob();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}*/
				msg="Verify Upgrade Job is disabled after after clicking on Ellipse ";
				try {
					Coordinate.clickEllipseVerifyUpgradePresence2(msg);
					//CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				//A red error toast notification is displayed. ' Unable to upgrade job. No jobs were upgraded, Jobs were running.'
				/*msg = "A red error toast notification is displayed. ' Unable to upgrade job. No jobs were upgraded, Jobs were running.'";

				try {
					String successMsg = "Unable";
					if(Coordinate.verifySuccessMsg1(successMsg)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else{
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
*/				
	}
}
