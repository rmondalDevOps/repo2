package com.workflowmanager.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.Coordinate;

public class TS27_DeleteDiagram_Test extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName=cfunction.getUniqueName("New test delete");

	public void workflow_TS27_DeleteDiagramSuccess() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		// Click on Design Tab
		cfunction.sync(2);
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Diagram panel is selected and populated with results
		msg = "Workflow Diagrams list populated with results";
		try {
			Design.getAllDiagramList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'Create New'
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// A diagram canvas is opened up
		msg = "A new diagram should open with a single step on the canvas";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Name the new workflow diagram 'New test delete'
		msg = "Enter diagram name as :"+uniqueName;
		try {
			Design.enterDiagramName(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		// Activate the workflow diagram
		msg = "Click Activate button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='c-panel__sectionLabel c-panel__sectionLabel--spatialData']");
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// A dialog asking ' Create Job Template' will be displayed.
		// Click 'No' on the dialog
		msg = "Click No button of confirmation to create job tamplate";
		try {
			Design.clickCancelOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The canvas with the diagram will be displayed
		msg = "The canvas with the diagram will be displayed";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Click 'Back'
		msg = "Click 'Back' button";
		try {
			Design.clickOnBack();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'No' on the dialog
		/*msg = "Click No button of confirmation to create job tamplate";
		try {
			Design.clickCancelOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// The workflow Diagram panel is displayed populated with results
		msg = "Workflow Diagrams list populated with results";
		try {
			Design.getAllDiagramList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Search for ' New test delete' workflow diagram in the list
		msg = "Search for "+uniqueName+" workflow diagram in the list";
		try {
			Design.enterSearchText_Diagram(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click the elipses(…) on the bottom right side for this diagram
		msg = "Click on the ellipsis next to the Edit button";
		try {
			Design.clickOnEllipsis1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Delete job template button should be visible";
		try {
			boolean check = Design.verifyDeleteBtnIsDisplayed();
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
		// Click on delete button
		cfunction.sync(2);
		msg = "Click on delete button";
		try {
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			// cfunction.sync(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Diagram is deleted successfully toast notification will be listed and the
		// workflow diagram list will be refreshed
		msg = "Verify Workflow diagram is deleted successfully toast notification Visible";
		String successMsg = "Workflow diagram deleted successfully";
		try {
			if (Design.verifySuccessMsg(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

	}

	public void workflow_TS27_DeleteDiagramFail() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		// Click on Design Tab
		cfunction.sync(2);
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Diagram panel is selected and populated with results
		msg = "Workflow Diagrams list populated with results";
		try {
			Design.getAllDiagramList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'Create New'
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// A diagram canvas is opened up
		msg = "A new diagram should open with a single step on the canvas";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Name the new workflow diagram 'New test delete'
		msg = "Enter diagram name as "+uniqueName;
		try {
			Design.enterDiagramName(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Activate the workflow diagram
		msg = "Click Activate button";
		try {
			cfunction.Commmon_Click("xpath", "//span[@class='c-panel__sectionLabel c-panel__sectionLabel--spatialData']");
			
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// A dialog asking ' Create Job Template' will be displayed.
		// Click 'No' on the dialog
		msg = "Click 'Yes' button of confirmation to create job tamplate";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Job Template panel will be displayed with the new job template 'New Test
		msg = "Job Template panel will be displayed with the new job template "+uniqueName;
		try {
			Design.getAllJobsTemplateList();
			Design.verifyJobTemplateHeader(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Save the job Template
		msg = "Save the job Template";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// The save button will be disabled
		msg = "The save button should be disabled";
		try {
			Design.verifySaveBtnIsDisabled();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Click on the coordinate page
		msg = "Click on the coordinate page";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// The coordinate page is displayed
		msg = "Verify the coordinate page is displayed";
		cfunction.sync(2);
		try {
			//String URL = "https://mcstest62.esri.com/portal/apps/workflowmanager/364c8e3bb107476794dad79370fad5ba/coordinate";
			boolean check = HomePage.verifyLandingPage();
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
		cfunction.sync(2);
		// Click on Create jobs < Create new job for job template 'New test delete'
		msg = "Click on 'Create Jobs'";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			Coordinate.clickOnNewJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify job template list gets populated 'New test delete'
		cfunction.sync(2);
		msg = "Verify job template list gets populated "+uniqueName;
		try {

			boolean check = Coordinate.verifyTemplateIsPresent(uniqueName);
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

		// Click on 'Create Default' button of 'New test delete' job template
		cfunction.sync(2);
		msg = "Click on "+uniqueName+" job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent(uniqueName);
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
		//Verify New Job created successfully
		msg = "Verify New Job created successfully";
		try {
			
			Coordinate.verifySuccessMsg("successful");
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Click on Design Tab
		cfunction.sync(2);
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Diagram panel is selected and populated with results
		msg = "Workflow Diagrams list populated with results";
		try {
			Design.getAllDiagramList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Find workflow diagram 'New test delete'
		msg = "Find workflow diagram "+uniqueName;
		try {
			Design.enterSearchText_Diagram(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on the ellipsis next to the Edit button";
		try {
			Design.clickOnEllipsis1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Delete job template button should be visible";
		try {
			boolean check = Design.verifyDeleteBtnIsDisplayed();
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
		cfunction.sync(2);
		// Click on delete button
		
		msg = "Click on delete button";
		try {
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			// cfunction.sync(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// error message displayed saying'Unable to delete job template: Job template being used in jobs'
		
		msg ="Verify error message displayed saying'Unable to delete job template: Job template being used in jobs";
		String successMsg = "Unable to delete";
		try {
			if (Design.verifySuccessMsg1(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*cfunction.sync(5);
		// Deleting the created job, template and diagram for fresh run
		msg ="Deleting the created job, template and diagram for next fresh run";
		try {
			HomePage.clickOnCoordinate();
			cfunction.sync(2);
			Coordinate.selectNewlyCreatedJob(jobName);
			//Coordinate.clickOnJobNameHeader();
			cfunction.sync(2);
			//Coordinate.selectFirstJob();
			cfunction.sync(2);
			Coordinate.clickEllipsesBtn();
			cfunction.sync(2);
			Coordinate.clickDeleteBtn();
			Coordinate.clickDeleteConfirmBtnYes();
			cfunction.sync(2);
			HomePage.clickOnDesign();
			cfunction.sync(2);
			Design.clickOnJobTemplatesIcon();
			cfunction.sync(2);
			Design.clickOnJobTemplate(uniqueName);
			cfunction.sync(2);
			Design.clickOnEllipsis();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			cfunction.sync(2);
			Design.clickOnDiagramsIcon();
			cfunction.sync(2);
			Design.enterSearchText_Diagram(uniqueName);
			cfunction.sync(2);
			Design.clickOnEllipsis1();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			//cfunction.sync(2);
			try {
				if (Design.verifySuccessMsg(successMsg))
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		
	}
}