package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS66_WorkPage_RunGPServiceStepWithVisibleParameters extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS66_WorkPage_RunGPServiceStepWithVisibleParameters() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
	
		msg = "Click on 'Work' Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Log into the web app click on Work Tab
		//Work tab is opened. My Jobs tab is by default set as active tab with my jobs returned.
		msg = "Click the 'Create' button";
		try {
			WorkPage.clickCreateBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter 'GP Visible Parameter' in Search Textbox";
		try {
			Coordinate.enterSearchText("GP Visible Parameter");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The job template is returned.
		msg = "Verify 'GP Visible Parameter' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent("GP Visible Parameter"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on the "GP Visible Parameter" job template to create a new job.
		msg = "Click the 'GP Visible Parameter' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("GP Visible Parameter");
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
		//The new job card is displayed in the Work page.
		//Run step "Run GP  Service - Echo"
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
		//The step dialog is opened, it displays 5 visible parameters set in the step: FLOAT IN = 10.9, DATE IN, BOOL IN = True, STRING IN = Default string, INTEGER IN = 1=
		//Click Cancel.
				msg = "Click on Cancel button";
				try {
					WorkPage.clickOnPauseBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The step dialog is closed and return to the job card, the current step is still "Run GP Service - Echo"
		//Run the step again.
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
		//The step dialog is opened, it displays 5 visible parameters set in the step: FLOAT IN = 10.9, DATE IN, BOOL IN = True, STRING IN = Default string, INTEGER IN = 1
		//Update the INTEGER IN = 5
				msg = "Update the 'INTEGER IN = 5'";
				try {
					WorkPage.enterIntegerIN_Value("5");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The new value is populated.
		//Click Proceed.
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The step dialog is closed and return to the job card. The GP service is running. Once GP service is complete, the workflow moves to the next step - "Run GP Service - Delay"
		//Run step "Run GP  Service - Delay"
				msg = "Run step \"Run GP  Service - Delay\"";
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
		//The step dialog is opened, it displays 1 visible parameters set in the step: DELAY TIME (IN Seconds). 
				msg = "Verify visible parameter set in the step: \"DELAY TIME (IN SECONDS)\"";
				try {
					if(WorkPage.verifyParameterText("Delay Time (in seconds)")) {
						CommonFunction.logStatus("PASS", msg);
					}else {
					CommonFunction.logStatus("FAIL", msg);}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The entry box indicates *required.
		//The proceed button is disabled.
				msg = "Verify Proceed button is disabled.";
				try {
					if (WorkPage.verifyProceedIsDisable()) {
						CommonFunction.logStatus("PASS", msg);
					} else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Move the cursor away
		//The parameter entry box is highlighted in red to indicate this is a required parameter.
		//Enter DELAY TIME (IN Seconds) = 2 then 
				msg = "Enter DELAY TIME (IN Seconds) = 2";
				try {
					WorkPage.enterParameterInput("2");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//click Proceed.
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//The step dialog is closed and return to the job card. The GP service is running. Once GP service is complete, the workflow moves to the next step - "Manual Step"
		//Log out the application.
				msg = "Click on Log out";
				try {
					HomePage.clickOnLogOut();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
	}
}
