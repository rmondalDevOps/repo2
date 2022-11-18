package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS38_WorkPageDeleteJob_test  extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	
	public void workflow_TS38_WorkPageDeleteJob_test() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Work Tab
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify Work tab is opened. 
		msg = "Verify Work tab is opened";
		try {
			if(WorkPage.verifyWorkTabOpen())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Create a new job by clicking on a job  in the left panel. 
		msg = "Click on the right triangle to expand the left panel";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on template to create job Data Edits Sample
		String Jobname="Data Edits Sample";
		msg = "Click on "+Jobname+" template to a create job";
		
		try {
			Coordinate.clickCreateDefaultOfTemplatePresent(Jobname);
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
			Coordinate.verifySuccessMsg(successMsg);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//A new job should be created and shown.
		msg = "Open Right Panel";
		try {
			WorkPage.clickOnCollapseRightPane();
			//WorkPage.clickOnJobDetails(jobName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify a new job should be created and shown";
		try {
			//WorkPage.clickOnCollapseRightPane();
			WorkPage.clickOnJobDetails(jobName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		//Open the Job Panel on the right 
		//The job panel opens up with all the job properties
		//Click the ellipses button on the bottom of Job panel
		msg = "Click on Ellipses button";

		try {
			
			Coordinate.clickEllipsesBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		//A list with show job id, delete job and Upgrade Job is displayed
		//Click Delete Job
		msg = "Click on Delete button";

		try {
			Coordinate.clickDeleteBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Select No to exit prompt.
		msg = "Select No to delete the job";

		try {
			Coordinate.clickDeleteConfirmBtnNo();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//job still exists.
		//Click the ellipses button on the bottom of Job panel
				msg = "Click on Ellipses button";

				try {
					Coordinate.clickEllipsesBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//A list with show job id, delete job and Upgrade Job is displayed
				//Click Delete Job
				msg = "Click on Delete button";

				try {
					Coordinate.clickDeleteBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Select Yes to delete the job
		msg = "Select Yes to delete the job";

		try {
			Coordinate.clickDeleteConfirmBtnYes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);
		//Green toast notification is displayed : "job deleted successfully"
		msg = "Verify Green toast notification is displayed : \"job deleted successfully\"";

		try {
			String successMsg = "job deleted successfully";
			Coordinate.verifySuccessMsg(successMsg);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
















}
}