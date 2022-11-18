package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS64_WorkPageAutoExecutionAtJobCreation extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS64_WorkPageAutoExecutionAtJobCreation() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
	
		//In Manage tab - Job List View table select a job.
		msg = "Click on 'Work' Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click the 'Create' button";
		try {
			WorkPage.clickCreateBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter 'Create Job Auto Execution' in Search Textbox";
		try {
			Coordinate.enterSearchText("Create Job Auto Execution");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify 'Create Job Auto Execution' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent("Create Job Auto Execution"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
				//Click the Open Web App Test job template
		msg = "Click the 'Create Job Auto Execution' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Create Job Auto Execution");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify New Job created successfully
				msg = "Verify New Job created successfully";
				try {

					if(Coordinate.verifySuccessMsg("successful"))
					CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				//Verify job card is opened in Custom job query tab in Work page.
				msg = "Verify job card is opened in Custom job query tab in Work page.";
				try {
					if(WorkPage.verifyCustomQueryTab())
						CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Verify that the first manual step in the job is automatically run.
				//Verify The step dialog is open and waiting for user either Proceed or Pause.
				msg = "Verify job card is opened in Custom job query tab in Work page.";
				try {
					if(WorkPage.verifyProceedIsVisible())
						CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
	}

}
