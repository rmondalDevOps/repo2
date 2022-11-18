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
import com.workflowmanager.pages.WorkPage;

public class TS41_UpdateDomainExtendedPropertiesJobTemplate extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS41_UpdateDomainExtendedPropertiesJobTemplate() throws InterruptedException {
		// CommonFunction.waitforHomePagetoload();
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
		// Click on Job Templates
		msg = "Click on Job Templates";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on Design Tab
		// Verify Design page is open
		// Click on the job template created in the Create Domain test.
		// Click on Job Templates
		msg = "Click on the job template created in the Create Domain test.";
		try {
			Design.clickJobTemplateName(jobTemplateName1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify Domain job template is open
		msg = "Verify Domain job template is open";
		try {
			if (Design.verifyJobTemplateHeader(jobTemplateName1)) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on "Extended Properties" tab.
		msg = "Click on 'Extended Properties' tab";
		try {
			Design.clickOnExtendedProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the pencil icon to edit domain_int
		msg = "Click on the pencil icon to edit EXTPROPDMN1";
		try {
			Design.clickFirstEditDomainBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify Edit Domain dialog is opened
		msg = "Verify Edit Domain dialog is opened";
		try {
			Design.verifyEditDomainDialogOpen();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Delete a coded value: Zero, 0
		msg = "Delete a coded value: Zero, 0";
		try {
			Design.deleteCodeEntry("4");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Add a new coded value: Four, 40
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		msg = "Enter value as 'Four'";
		try {
			Design.enterEditDomainValues(7, "Four");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter code
		msg = "Enter code as '40'";
		try {
			Design.enterEditDomainValues(8, "40");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Update an existing coded value from Two, 20 to Double, 20
		msg = "Update an existing coded value from Two, 20 to Double, 20";
		try {
			Design.enterEditDomainValues(3, "Double");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Second code
		msg = "Enter code";
		try {
			Design.enterEditDomainValues(4, "20");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click Save
		msg = "Click on Save Button";
		try {
			Design.ClickOnSaveBtnOfDomain();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The pop-up dialog is closed and return to job template Extended Properties
		// tab. The first code is by default selected in the drop down as the domain
		// extended property's default value.
		// Open the drop down.
		msg = "Open the drop down.";
		try {
			Design.openDefaultValueDropdown("5");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Do not select a default value for domain_int
		msg = "Do not select a default value for EXTPROPDMN1";
		try {
			Design.openDefaultValueDropdown("5");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// make sure the "REQUIRED" is checked on.
		// Click on the pencil icon to edit domain_double
		msg = "Click on the pencil icon to edit EXTPROPDMN2";
		try {
			Design.clickSecondEditDomainBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify The Edit Domain dialog is opened.
		msg = "Verify The Edit Domain dialog is opened.";
		try {
			Design.verifyEditDomainDialogOpen();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Delete a coded value: Wednesday, 3.5
		msg = "Delete a coded value: Wednesday, 3.5";
		try {
			Design.deleteCodeEntry("3");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Add a new coded value: Sunday, 0.5
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		msg = "Enter third value";
		try {
			Design.enterEditDomainValues(5, "Sunday");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter third code
		msg = "Enter third code";
		try {
			Design.enterEditDomainValues(6, "0.5");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Update an existing coded value from Tuesday, 2.5 to Thursday 3.75
		msg = "Update first value";
		try {
			Design.enterEditDomainValues(1, "Thursday");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter first code
		msg = "Enter first code";
		try {
			Design.enterEditDomainValues(2, "3.75");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Reorder the coded values.
		// Click Save
		msg = "Click on Save Button";
		try {
			Design.ClickOnSaveBtnOfDomain();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The pop-up dialog is closed and return to job template Extended Properties
		// tab. The first code is by default selected in the drop down as the domain
		// extended property's default value.
		// Open the drop down.
		msg = "Open the drop down.";
		try {
			Design.openDefaultValueDropdown("6");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Do not select a default value for domain_int
		msg = "Do not select a default value for EXTPROPDMN2";
		try {
			Design.openDefaultValueDropdown("6");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// make sure the "REQUIRED" is NOT checked on.
		msg = "Check off the 'Required' box";
		try {
			Design.clickOnCheckBox(6);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the pencil icon to edit domain_string
		msg = "Click on the pencil icon to edit EXTPROPDMN3";
		try {
			Design.clickThirdEditDomainBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify The Edit Domain dialog is opened.
		msg = "Verify The Edit Domain dialog is opened.";
		try {
			Design.verifyEditDomainDialogOpen();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Delete a coded value: Delta, D
		msg = "Delete a coded value: Delta, D";
		try {
			Design.deleteCodeEntry("4");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Add a new coded value: Sigma, S
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		msg = "Enter value as 'Sigma'";

		try {
			Design.enterEditDomainValues(7, "Sigma");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter code
		msg = "Enter code as 'S'";
		try {
			Design.enterEditDomainValues(8, "S");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Update an existing coded value from Omega, O to Gamma, G
		msg = "Update an existing coded value from Two, 20 to Gamma, G";
		try {
			Design.enterEditDomainValues(3, "Gamma");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Second code
		msg = "Enter code";
		try {
			Design.enterEditDomainValues(4, "G");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Reorder the coded values.
		// Click Save
		msg = "Click on Save Button";
		try {
			Design.ClickOnSaveBtnOfDomain();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// The pop-up dialog is closed and return to job template Extended Properties
		// tab. The first code is by default selected in the drop down as the domain
		// extended property's default value.
		// Open the drop down.
		msg = "Open the drop down.";
		try {
			Design.openDefaultValueDropdown("7");
			Design.selectValueFromDropDown("Gamma");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// The updates in coded value and reorder are saved.
		// Select another default value from the drop down list.

		msg = "Click on 'Save' to save the job template";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Verify a message pops up "Do you want to proceed?"
		msg = "Verify a message pops up 'Do you want to proceed?'";
		try {
			if (Design.verifySaveDialog("Do you want to proceed?"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click Save on the proceed confirmation message.
		msg = "Click Save on the proceed confirmation message";
		try {
			Design.ClickOnSaveDialog_SaveBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// cfunction.sync(2);
		// Verify a progress bar is shown indicating the saving process.
		msg = "Verify a progress bar is shown indicating the saving process";
		try {
			if (Design.verifyProgressBar("Saving your changes..."))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// cfunction.sync(2);
		// Verify Success message is displayed.
		msg = "Verify Success message is displayed.";
		String successMsg = "Job template: " + jobTemplateName + " created successfully";
		try {
			if (Design.verifySuccessMsg(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// verify the extend property table and extended properties are populated as
		// updated.
		/*****************************************************************
		
		*****************************************************************/
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
		// Click on Diagram in left menu
		msg = "Click on Diagram in left menu";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on create new button
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Enter Diagram Name
		msg = "Enter diagram name as 'Sample Diagram'";
		String diagramName = "Test Diagram";
		try {
			Design.enterDiagramName(diagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Enter Diagram description
		msg = "Enter diagram description as 'Sample description'";
		try {
			Design.enterDiagramDescription("Sample Description");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Add the first step in the diagram as "Update Job Properties" step.
		msg = "Add the first step in the diagram as \"Update Job Properties\" step";
		try {
			//Design.clickOnStepLibrary();
			//cfunction.Commmon_Click("xpath", "//div[@id='ui-accordiontab-5-content']");
			// SikuliHelp.selectLocationOnMapSikuliClick("TS41_UpdateJobProp_1280x768");
			Design.enterSearchStepTemplate("Update Job Properties");
			String canvasStep = "BlankCanvas";
			if(browser.equals("Firefox")) {
				Design.dragStepToCanvas("TS41_UpdateJobProp_Firefox", canvasStep);
			}else {
			Design.dragStepToCanvas("TS41_UpdateJobProp", canvasStep);
			}

			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Configure the job properties to be updated in the step as:
		// domaintable1.domain_int, domaintable1.domain_double, and
		// domaintable2.domain_string
		msg = "Configure the job properties to be updated in the step as: extproptab1.extpropdomain1";
		try {
			Design.enterJobPropInput(1, "extproptab1.extpropdomain1");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Configure the job properties to be updated in the step as: extproptab1.extpropdomain2";
		try {
			Design.enterJobPropInput(2, "extproptab1.extpropdomain2");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Add New Job Property button";
		try {
			Design.clickOnAddNewJobProp();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Configure the job properties to be updated in the step as: extproptab2.extpropdomain3";
		try {
			Design.enterJobPropInput(3, "extproptab2.extpropdomain3");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		msg = "Click on the down arrow of Update Job Properties";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
			cfunction.sync(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Join Paths";
		try {
			SikuliHelp.hoveronLocationSikuli("TS41_HoverOnStart_1280x768");
			cfunction.sync(2);
			Design.dragStepToCanvas("PathDown", "TS41_PathEnd");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Save
		msg = "Click Save button";
		try {
			Design.clickOnSaveDiagramButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Activate
		msg = "Click Activate button";
		try {
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		// Click Yes
		msg = "Click Yes button of confirmation to create job tamplate";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on the job template created in the Create Domain test.";
		try {
			Design.clickJobTemplateName(jobTemplateName1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on No button of dialog
		msg = "Click on No button of dialog";
		try {
			Design.clickCancelOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Replace the job template "Job Template_Domain" diagram with the newly created
		// one.
		msg = "From 'Current Workflow Diagram' dropdown select '" + diagramName + "'";
		try {
			Design.selectCurrentWorkflowDiagram(diagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click Save
		msg = "Click on 'Save' to save the job template";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(30);
		// Verify the updated diagram is saved
		/*********************************************************************************
		 * Running the steps form work page
		 *********************************************************************************/
		// in Work page, create a job using Job Template_Domain job template.
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on the create  to expand the left panel";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on template to create job Data Edits Sample
		//String jobTemplateName1 = "Domain Extended Prop_2020_07_20_0244";
		msg = "Click on " + jobTemplateName1 + " template to a create job";

		try {
			Coordinate.clickCreateDefaultOfTemplatePresent(jobTemplateName1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Verify Job should be created successfully";

		try {
			String successMsg1 = "successfully";
			Coordinate.verifySuccessMsg(successMsg1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Run the first step in the job to open Update Job Properties step.
		//This step is removed as per new updates
		/*msg = "Run \"End\" step for the job";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		/*msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// This step is removed as per new update
		/*msg = "Run \"End\" step for the job";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// It lists three domain extended properties:
		// domain_int has no default value and marked as required;
		// domain_double has no default value but doesn't mark as required;
		// domain_string has a default value as selected in the previous test.
		// The Proceed button is disabled.
		msg = "Proceed button is disabled.";
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
		// Click on domain_int drop down but do not select any value.
		msg = "Click on EXTPROPDMN1 drop down but do not select any value.";
		try {
			WorkPage.openDropDown(1);
			WorkPage.clickOnTitle();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The entry box of domain_int is highlighted in red to indicate this is
		// required. Proceed button stays disabled.
		msg = "VerifyThe entry box of EXTPROPDMN1 is highlighted in red to indicate this is required.";
		try {
			WorkPage.verifyBlankFieldIndicateRed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select a value for domain_int from the drop down.
		msg = "Select a value for EXTPROPDMN1 from the drop down.";
		try {
			WorkPage.selectCategory("One", 1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select a value for EXTPROPDMN3 from the drop down.";
		try {
			WorkPage.selectCategory("Agricultural", 3);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Proceed button is enabled.
		msg = "Proceed button is enabled.";
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

		// Select a value for domain_double from the drop down.
		msg = "Select a value for EXTPROPDMN2 from the drop down.";
		try {
			WorkPage.selectCategory("Thursday", 2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Select another value for domain_string from the drop down.
		msg = "Select another value for EXTPROPDMN3 from the drop down.";
		try {
			WorkPage.selectCategory("Agricultural", 3);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Proceed.
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Dismiss button";
		try {
			WorkPage.clickOnDismissJobTileButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The domain values are updated in the job.
		// To verify, click on the job card one more time to refresh the job details
		// panel.
		// Verify the codes are updated correspondingly to the selected coded values
		// from the step.

	}

}
