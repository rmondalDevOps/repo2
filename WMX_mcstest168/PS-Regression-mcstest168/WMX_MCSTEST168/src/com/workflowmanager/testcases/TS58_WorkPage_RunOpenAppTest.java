package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS58_WorkPage_RunOpenAppTest extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS58_WorkPage_RunOpenAppTest() throws InterruptedException {
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
				//Click the 'Create' button
		msg = "Click the 'Create' button";
		try {
			WorkPage.clickCreateBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
				//A list of job templates should become visible in the Create panel
				//Search for 'Open Web App Test'
		msg = "Enter 'Open Web App Test' in Search Textbox";
		try {
			Coordinate.enterSearchText("Open Web App Test");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
				//The Open Web App Test should become visible
		msg = "Verify 'Open Web App Test' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent("Open Web App Test"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
				//Click the Open Web App Test job template
		msg = "Click the 'Open Web App Test' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Open Web App Test");
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

					Coordinate.verifySuccessMsg("successful");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//"A job should be created and visible in the panel'Open Web App'' should be the current step"
				//Click the Collapse panel button
				msg = "Click the Collapse panel button";
				try {

					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The Create panel should collapse and no longer be visible
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
				//"The app should open in an 'embedded' state within WMX The Details panel should be visible The Pause and Finish buttons should be visible at the bottom of the panel"
				msg = "The selected job's details panel is opened on the right hand side.";
				try {
					if(WorkPage.verifyJobDetailWindow(jobName)) {
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
				//Click the Pause button
				msg = "Click the Pause button";
				try {

					WorkPage.clickOnPauseBtn1();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//"The embedded app should close The job tile should be visible in the initial state The 'Details' panel should not be open"
				msg = "Verify the 'Details' panel should not be open";
				try {
					if(WorkPage.verifyJobDetailWindow(jobName)) {
					CommonFunction.logStatus("FAIL", msg);
					}
					else {
						CommonFunction.logStatus("PASS", msg);
					}
				} catch (Exception e) {
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
				//"The app should open in an 'embedded' state within WMX The Details panel should be visible with all of its elements"
				msg = "The selected job's details panel is opened on the right hand side.";
				try {
					if(WorkPage.verifyJobDetailWindow(jobName)) {
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
				//Click the Diagram & Map tab
				msg = "Click on Diagram & Map";
				try {
					WorkPage.clickOnDiagramMap();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);
				//The Details panel should switch to show the Diagram and Map tab and its associated info
				/*msg = "Verify the Details panel should switch to show the Diagram and Map tab";
				try {
					WorkPage.verifyDiagramTabInputText("Diagram");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				//Click the Attachments tab
				msg = "Click on Attachments tab";
				try {
					WorkPage.clickOnAttachment();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);
				//The Details panel should switch to show the Attachments tab and its associated info
				//Click the 'Collapse Panel' button at the top right of the Details panel
				msg = "Click the 'Collapse Panel' button at the top right of the Details panel";
				try {
					WorkPage.clickCollapseJobDetailBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);
				//"The Details panel should collapse down to a smaller widget The widget should have the job name and the pause, complete, and expand buttons"
				msg = "Verify the Details panel should collapse down to a smaller widget";
				try {
					if(WorkPage.verifyCollapsedJobDetailWidegetVisible()) {
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
				//Click the Complete Step button
				msg = "Click the 'Complete Step' button";
				try {
					WorkPage.clickCompleteBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg, 4706);
				}

				cfunction.sync(2);
				//"The embedded app should close The job tile should be visible in the dismissable state The 'Details' panel should not be open"
				msg = "Verify Dismiss message";
				try {
					String message = "Open Web App has completed, and there are no further active steps assigned to you.";
					if(WorkPage.verifyDismissMessage(message)) {
					CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg, 4706);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg, 4706);
				}
				cfunction.sync(2);
				//Click on the 'Dismiss Job Tile' button
				msg = "Click on the 'Dismiss Job Tile' button";
				try {
					WorkPage.clickOnDismissJobTileButton();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg, 4706);
				}

				cfunction.sync(2);

	}
}
