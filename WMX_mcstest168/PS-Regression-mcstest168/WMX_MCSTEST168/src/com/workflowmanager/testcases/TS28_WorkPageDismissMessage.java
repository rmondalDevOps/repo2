package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS28_WorkPageDismissMessage extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName=cfunction.getUniqueName("New test delete");
	String expectedImage="TS28_JobsMissing.png";
	public void workflow_TS28_WorkPageDismissMessage() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		// Click on Design Tab
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
		// Go to Work page, in My Jobs query, navigate to the job "Dismiss_JobClose"
		/*msg = "Click on 'All Jobs' Tab";
		try {
			WorkPage.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// Navigate to the job "Dismiss_JobClose"
		msg = "Navigate to the job 'Dismiss_JobClosed'";
		try {
			if(WorkPage.scrollToJob("Dismiss_JobClosed")) {
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
		// Verify the job's current step is "End".
		msg = "Verify the job's current step is 'End'";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Dismiss_JobClosed", "End")) {
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
		// Run "End" step for the job
		msg = "Run \"End\" step for the job";
		try {
			if(WorkPage.clickOnStartStepOfJob("Dismiss_JobClosed")) {
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
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='text-white btnText-withToolTip']");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Verify Dismiss message should be 'End has completed, and there are no futher
		// active steps assigned to you. A Dismiss Job Tile button is available'
		msg = "Verify Dismiss message";
		
			try {
				String message = "End has completed, and there are no further active steps assigned to you.";
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
		// Click on Dismiss Job Tile button.
		msg = "Click on Dismiss Job Tile button";
		try {
			WorkPage.clickOnDismissJobTileButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Job tile should be removed from the current job query.
		msg = "Job tile should be removed from the current job query.";
		try {
			if (WorkPage.scrollToJob("Dismiss_JobClosed")) {
				CommonFunction.logStatus("FAIL", msg);
			} else {
				CommonFunction.logStatus("PASS", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(2);
		// In My Jobs query, navigate to the job "Dismiss_Job1"
		msg = "Navigate to the job \"Dismiss_Job1\"";
		try {
			if(WorkPage.scrollToJob("Dismiss_Job1")) {
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
		// Verify job current step should be "Start".
		msg = "Verify job current step should be \"Start\".";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Dismiss_Job1", "Start")) {
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
		// Run "Start" step.
		msg = "Run \"Start\" step for the job";
		try {
			if(WorkPage.clickOnStartStepOfJob("Dismiss_Job1")) {
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
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='text-white btnText-withToolTip']");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify Dismiss message'Start has completed, and there are no futher active
		// steps assigned to you.
		msg = "Verify Dismiss message";
		try {
			String message = "Start has completed, and there are no further active steps assigned to you.";
			if(WorkPage.verifyDismissMessage(message)) {
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
		msg = "Click on Dismiss Job Tile button";
		try {
			WorkPage.clickOnDismissJobTileButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Job tile should be removed from the current job query.
		msg = "Job tile should be removed from the current job query.";
		try {
			if (WorkPage.scrollToJob("Dismiss_Job1")) {
				CommonFunction.logStatus("FAIL", msg);
			} else {
				CommonFunction.logStatus("PASS", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(2);
		
		//Click on 'All Jobs' tab
		msg = "Click on 'All Jobs' Tab";
		try {
			HomePage.clickOnCoordinate();
			cfunction.waitforpagetoload();
			HomePage.clickOnWork();
			cfunction.waitforpagetoload();
			WorkPage.clickOnAllJobs();
			cfunction.waitforpagetoload();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// In All Jobs query, navigate to the job "Dismiss_Job2"
		msg = "Navigate to the job \"Dismiss_Job2\"";
		try {
			if(WorkPage.scrollToJob("Dismiss_Job2")) {
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
		// The job's current step is "Start".
		msg = "Verify job current step should be \"Start\".";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Dismiss_Job2", "Start")){
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
		// Run "Start" step.
		msg = "Run \"Start\" step for the job";
		try {
			if(WorkPage.clickOnStartStepOfJob("Dismiss_Job2")) {
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
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='text-white btnText-withToolTip']");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify Dismiss message should be 'Start has completed, and there are no
		// futher active steps assigned to you.
		msg = "Verify Dismiss message";
		try {
			String message = "Start has completed, and there are no further active steps assigned to you.";
			if(WorkPage.verifyDismissMessage(message)) {
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
		// Click on Return to Job button.
		msg = "Click on Return to Job button";
		try {
			WorkPage.clickOnReturnToJobButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify job tile should not removed from the current job query.
		msg = "Job tile should not be removed from the current job query.";
		try {
			boolean check;
			if (check = WorkPage.scrollToJob("Dismiss_Job2")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the current step of the job is "Step assigned to other" and it is
		// assigned to "Aarthi D"
		msg = "Verify job current step should be \"Step assigned to other\".";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Dismiss_Job2", "Step assigned to other")) {
			//WorkPage.verifyJobAssisgnmentName("Aarthi D");
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
		msg = "Verify job assigned to \"Aarthi D\"";
		try {
			WorkPage.clickOnCollapseRightPane();
			if(WorkPage.verifyJobAssignmentName("Aarthi D")) {
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
		// In My Jobs query, navigate to the job "Dismiss_Parallel_Job1"
		//Click on 'My Jobs' tab
		msg = "Click on 'My Jobs' tab";
		try {
			WorkPage.clickOnMyJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "Navigate to the job \"Dismiss_Parallel_Job1\"";
		try {
			cfunction.waitforpagetoload();
			if(WorkPage.scrollToJob("Dismiss_Parallel_Job1")) {
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
		// Verify the job current step is "Start".
		msg = "Verify job current step should be \"Start\".";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Dismiss_Parallel_Job1", "Start")) {
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
		// Run "Start" step.
		msg = "Run \"Start\" step for the job";
		try {
			if(WorkPage.clickOnStartStepOfJob("Dismiss_Parallel_Job1")) {
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
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='text-white btnText-withToolTip']");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the job tile is refreshed to show the current step "My Step".
		msg = "Verify job current step should be \"My Step\".";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Dismiss_Parallel_Job1", "My Step")) {
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
		// Run "My Step".
		msg = "Run \"Start\" step for the job";
		try {
			if(WorkPage.clickOnStartStepOfJob("Dismiss_Parallel_Job1")) {
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
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='text-white btnText-withToolTip']");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify Dismiss message should be 'My Step has completed, and there are no
		// futher active steps assigned to you.'
		msg = "Verify Dismiss message";
		try {
			String message = "My Step has completed, and there are no further active steps assigned to you";
			if(WorkPage.verifyDismissMessage(message)) {
			CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click on Dismiss Job Tile button.
		msg = "Click on Dismiss Job Tile button";
		try {
			WorkPage.clickOnDismissJobTileButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify job tile should be removed from the current job query.
		msg = "Job tile should be removed from the current job query.";
		try {
			boolean check;
			if (check = WorkPage.scrollToJob("Dismiss_Parallel_Job1")) {
				CommonFunction.logStatus("FAIL", msg);
			} else {
				CommonFunction.logStatus("PASS", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(2);
		// In All Jobs query,
		msg = "Click on 'All Jobs' Tab";
		try {
			HomePage.clickOnCoordinate();
			cfunction.waitforpagetoload();
			HomePage.clickOnWork();
			cfunction.waitforpagetoload();
			WorkPage.clickOnAllJobs();
			cfunction.waitforpagetoload();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//navigate to the job "Dismiss_Parallel_Job2"
		msg = "Navigate to the job 'Dismiss_Parallel_Job2'";
		try {
			if(WorkPage.scrollToJob("Dismiss_Parallel_Job2")) {
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
		// Verify the job current step should be "Start".
		msg = "Verify the job's current step is 'Start'";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Dismiss_Parallel_Job2", "Start")) {
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
		// Run "Start" step for the job
		msg = "Run \"Start\" step for the job";
		try {
			if(WorkPage.clickOnStartStepOfJob("Dismiss_Parallel_Job2")) {
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
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='text-white btnText-withToolTip']");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Verify the job tile is refreshed to show the current parallel step drop
		// downs: My Steps and Other's Step.
		msg = "Verify the current parallel step dropdowns visible";
		try {
			WorkPage.verifyStepDrpdwnVisible();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		
		// Select "Other's Steps" in current step drop down.
		msg = "Select \"Other's Steps\" in current step drop down.";
		try {
			WorkPage.selectValueFromDropdown("Other's Step");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Run button is disabled
		// Select My Steps in current step drop down.
		msg = "Select \"My Steps\" in current step drop down.";
		try {
			WorkPage.selectValueFromDropdown("My Step");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Run button is enabled
		// Run "My Step".
		msg = "Run \"My Step\" step for the job";
		try {
			if(WorkPage.clickOnStartStepOfJob("Dismiss_Parallel_Job2")) {
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
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='text-white btnText-withToolTip']");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify Dismiss message should be 'My Step has completed, and there are no
		// futher active steps assigned to you. Another Return to Job button is
		// available.
		msg = "Verify Dismiss message";
		try {
			String message = "My Step has completed, and there are no further active steps assigned to you.";
			if(WorkPage.verifyDismissMessage(message)) {
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
		// Click on Return to Job button.
		msg = "Click on Return to Job button";
		try {
			WorkPage.clickOnReturnToJobButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify job tile should not removed from the current job query.
		msg = "Job tile should not be removed from the current job query.";
		try {
			boolean check;
			if (check = WorkPage.scrollToJob("Dismiss_Parallel_Job2")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the current step of the job is "Step assigned to other" and it is
		// assigned to "Aarthi D"

		msg = "Verify job current step should be \"Other's Step\".";
		try {
			if(WorkPage.verifyCurrentStepOfJob("Dismiss_Parallel_Job2", "Other's Step")) {
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
		msg = "Verify job assigned to \"Aarthi D\"";
		try {
			WorkPage.clickOnCollapseRightPane();
			if(WorkPage.verifyJobAssignmentName("Aarthi D")) {
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
		

	}
}