package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS57_ManualStepWorkflowTest extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS57_ManualStepWorkflowTest() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click Create Jobs Button
				msg = "Click Create Jobs Button";
				try {
					Coordinate.clickOnCollapseLeftPanel1();
					Coordinate.clickOnNewJob();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Click on "Update Properties Work" job template.
				msg = "Click on \"Manual Workflow Test\" job template.";
				try {
					Coordinate.clickCreateDefaultOfTemplatePresent("Manual Workflow Test");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				//A toast message indicates that the new job is created.
				msg = "A toast message indicates that the new job is created.";
				try {
					if(Coordinate.verifySuccessMsg("successfully")) {
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
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on the 'NEW' filter by";
				try {
					WorkPage.clickOnNewFilterBy();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				// Click on the job created in previous steps
				msg = "Click on the job created in previous steps";
				try {
					WorkPage.clickOnJobDetails(jobName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify the job's current step is 'Start Both'";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName, "Start Both")) {
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
		//Click the Start step button
				msg = "Run \"Start Step\" step for the job";
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
		//"There should be a prompt visible at the top of the job tile "
		//"This prompt should be visible and take up two lines on the tile."
		//"Step help should be visible at the bottom of the job tile "
		//"Please click the proceed button to continue with the workflow"""
				msg = "Verify Prompt message";
				try {
					WorkPage.verifyPromptText("This prompt should be visible and take up two lines on the tile.");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify help message";
				try {
					WorkPage.verifyPromptText2("Please click the proceed button to continue with the workflow");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Proceed
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//"The next step should run automatically.It should display 'This is a long prompt with no help.' 
		//over and over until the card is filled"
				msg = "Verify Prompt message";
				try {
					WorkPage.verifyPromptText("This is a long prompt with no help.");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Pause
				msg = "Click \"Pause\" in the step dialog.";
				try {
					WorkPage.clickOnPauseBtn();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The job tile should return to the initial state with the 'Start Prompt' current step
				msg = "Verify the job's current step is \"Start Prompt\"";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName, "Start Prompt")) {
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
		//Click the Start step button
				msg = "Click the \"Start\" step button";
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
		//It should expand with the prompt that was visible before
		//Click Proceed
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//"The next step should run automatically.It should display 
		//'This is a long help text with no prompt.'
		//over and over until the card is filled with the step help styling"
				msg = "Verify help message";
				try {
					WorkPage.verifyPromptText2("This is a long help text with no prompt.");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click the Start step button
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The job tile should return to the initial state with the 'Start None' current step
				msg = "Verify the job's current step is 'Start None'";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName, "Start None")) {
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
				msg = "Click the \"Start\" step button";
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
		//Click Proceed
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The job tile should not expand and the next step 'Manual Both' should run instead
				/*msg = "Verify the job's current step is 'Start None'";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName, "Manual Both")) {
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
				//Run step
				msg = "Click the \"Start\" step button";
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
				cfunction.sync(2);*/
				msg = "Verify Prompt message";
				try {
					WorkPage.verifyPromptText("This is a long prompt with no help.");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click Proceed
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//"There should be a prompt visible at the top of the job tile "
		//"This prompt should be visible and take up two lines on the tile." 
		//"Step help should be visible at the bottom of the job tile "
		//"Please click the proceed button to continue with the workflow"""
				msg = "Verify Prompt message";
				try {
					WorkPage.verifyPromptText2("This is a long help text with no prompt.");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Proceed
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//"The next step should run automatically.It should display 
		//'This is a long prompt with no help.' over and over until the card is filled"
		
				/*msg = "Verify Prompt message";
				try {
					WorkPage.verifyPromptText("This is a long prompt with no help.");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Proceed
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//"The next step should run automatically.It should display 
		//'This is a long help text with no prompt.' 
		//over and over until the card is filled with the step help styling"
				/*msg = "Verify Prompt message";
				try {
					WorkPage.verifyPromptText("This is a long help text with no prompt.");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Proceed
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//The job tile should return to the initial state with the 'Start None' current step
				msg = "Verify the job's current step is 'Manual None'";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName, "Manual None")) {
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
		//Click the Start step button
				msg = "Click the \"Start\" step button";
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
				msg = "Verify Dismiss message";
				
				try {
					String message = "has completed, and there are no further active steps assigned to you.";
					if(WorkPage.verifyDismissMessage(message)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//"The job tile should enter the 'dismiss' state"
			msg = "Verify The job tile should enter the 'dismiss' state";
			try {
				WorkPage.verifyDismissJobTileButtonVisible();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Click the Dismiss button
			msg = "Click the \"Dismiss\" button";
			try {
				WorkPage.clickOnDismissJobTileButton();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//The job tile should be removed from the pane
	}
}
