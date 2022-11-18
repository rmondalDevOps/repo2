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



public class TS21_DeleteJobTemplate extends TestBase{ 
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName=cfunction.getUniqueName("New test Delete");

	public void workflow_TS21_DeleteJobTemplateSuccess() throws InterruptedException {
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

		// Verify diagram panel is selected and populated with results
		cfunction.sync(2);
		msg = "Verify 'Workflow Diagrams' panel list populated with results";
		try {
			Design.verifyTabPanel("Workflow Diagrams");
			Design.getAllJobsTemplateList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//Click on the 'Job Template' icon
		cfunction.sync(2);
		msg = "Click on the 'Job Template' icon";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//Verify tab panel should switch to Job Templates
		cfunction.sync(2);
		msg = "Verify tab panel should switch to Job Templates";
		try {
			Design.verifyTabPanel("Job Templates");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Click on 'Create New'
		cfunction.sync(2);
		msg = "Click on 'Create New'";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Verify a new job template should open
		
		//Name the new job Template as 'New test delete'
		cfunction.sync(2);
		msg = "Enter Job Template name 'New test delete'";
		String jobTemplateName = xls.getCellData("en-us", 2,10);
		//String jobTemplateName = "Test Template";
		try {
			Design.enterJobTemplateName(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Assign a workflow diagram from drop down for 'Current Workflow Diagram'
		cfunction.sync(2);
		String selectText = xls.getCellData("en-us", 3,10);
		msg = "From 'Current Workflow Diagram' dropdown select '"+ selectText + "'";
		try {
			Design.selectCurrentWorkflowDiagram(selectText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Click on the save button
		cfunction.sync(2);
		msg = "Click on the save button";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
				
		//Verify save button gets disabled
		cfunction.sync(2);
		msg = "Verify save button gets disabled";
		try {
			boolean check = Design.verifySaveBtnIsDisabled();
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
		//Click on the ellipsis next to the save button
		cfunction.sync(2);
		msg = "Click on the ellipsis next to the save button";
		try {
			Design.clickOnEllipsis3();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//Delete job template button should be visible
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
		//Click on delete button
		cfunction.sync(2);
		msg = "Click on delete button";
		try {
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			//cfunction.sync(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//Verify Job Template deleted successfully toast notification visible
		//cfunction.sync(2);
		msg="Verify the notification text";
		String successMsg = "Job template deleted successfully";
		try {
			if(Design.verifySuccessMsg(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify New job delete template removed from the job template list
		cfunction.sync(2);
		msg = "Verify 'New test delete' template removed from the job template list";
		try {
			boolean check = Design.verifyJobTemplate(uniqueName);
			if (check) {
				CommonFunction.logStatus("FAIL", msg);
			}

			else {
				CommonFunction.logStatus("PASS", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		
	
		
	}

	public void workflow_TS21_DeleteJobTemplateFail() throws InterruptedException {
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

		// Verify diagram panel is selected and populated with results
		cfunction.sync(2);
		msg = "Verify 'Workflow Diagrams' panel list populated with results";
		try {
			Design.verifyTabPanel("Workflow Diagrams");
			Design.getAllJobsTemplateList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click on the 'Job Template' icon
		cfunction.sync(2);
		msg = "Click on the 'Job Template' icon";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify tab panel should switch to Job Templates
		cfunction.sync(2);
		msg = "Verify tab panel should switch to Job Templates";
		try {
			Design.verifyTabPanel("Job Templates");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click on 'Create New'
		cfunction.sync(2);
		msg = "Click on 'Create New'";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Verify a new job template should open

		// Name the new job Template as 'New test delete'
		cfunction.sync(2);
		msg = "Enter Job Template name 'New test delete'";
		String jobTemplateName = xls.getCellData("en-us", 2, 10);
		// String jobTemplateName = "Test Template";
		try {
			Design.enterJobTemplateName(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Assign a workflow diagram from drop down for 'Current Workflow Diagram'
		cfunction.sync(2);
		String selectText = xls.getCellData("en-us", 3, 10);
		msg = "From 'Current Workflow Diagram' dropdown select '" + selectText + "'";
		try {
			Design.selectCurrentWorkflowDiagram(selectText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click on the save button
		cfunction.sync(2);
		msg = "Click on the save button";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Verify save button gets disabled
		cfunction.sync(2);
		msg = "Verify save button gets disabled";
		try {
			boolean check = Design.verifySaveBtnIsDisabled();
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
		// Click on coordinate tab
		cfunction.sync(2);
		msg = "Click on coordinate tab";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Coordinate page is loaded
		cfunction.sync(2);
		msg = "Verify coordinate page is loaded";
		cfunction.sync(2);
		try {
			//String URL = "https://mcstest62.esri.com/portal/apps/workflowmanager/554a740a715245118d322adf53c010db/coordinate";
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
		// Click on 'Create Jobs'
		cfunction.sync(2);
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
		msg = "Verify job template list gets populated 'New test delete'";
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
		msg = "Click on 'Create Default' button of 'New test delete' job template";
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
		// Clik on Design tab
		cfunction.sync(2);
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Verify diagram panel is selected and populated with results
		cfunction.sync(2);
		msg = "Verify 'Workflow Diagrams' panel list populated with results";
		try {
			Design.verifyTabPanel("Workflow Diagrams");
			Design.getAllJobsTemplateList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click on the 'Job Template' icon
		cfunction.sync(2);
		msg = "Click on the 'Job Template' icon";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify tab panel should switch to Job Templates
		cfunction.sync(2);
		msg = "Verify tab panel should switch to Job Templates";
		try {
			Design.verifyTabPanel("Job Templates");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Find job template 'New test delete'
		cfunction.sync(2);
		msg = "Click on Job template 'New test delete'";
		try {

			boolean check = Design.clickOnJobTemplate(uniqueName);
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
		// Click on the ellipsis next to the save button
		cfunction.sync(2);
		msg = "Click on the ellipsis next to the save button";
		try {
			Design.clickOnEllipsis3();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Delete job template button should be visible
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
			//cfunction.sync(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify error message displayed saying'Unable to delete job template: Job template was not deleted, job template used in jobs'
		//cfunction.sync(2);
		msg="Verify error message displayed saying'Unable to delete job template: Job template being used in jobs";
		String successMsg = "Unable to delete";
		try {
			if(Design.verifySuccessMsg1(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//Deleting Job and Job template created during test case execution
		cfunction.sync(2);
		msg = "Click on coordinate";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on My Jobs";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			cfunction.sync(2);
			Coordinate.clickOnAllJob();
			Coordinate.clickOnMyJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select newly created Job";
		try {
			Coordinate.selectNewlyCreatedJob(jobName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Ellipse button";
		try {
			Coordinate.clickEllipsesBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on delete button";
		try {
			Coordinate.clickDeleteBtn();
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on yes button od confirmation dialog box";
		try {			
			Coordinate.clickDeleteConfirmBtnYes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on design";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Job template icon";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select job template";
		try {
			Design.clickOnJobTemplate(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on ellipse";
		try {
			Design.clickOnEllipsis3();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on delete button";
		try {
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(5);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	

	}
}
