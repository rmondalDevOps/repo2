package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS76_DesignPage_StepSchedulingConfigurationTest_6 extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS76_DesignPage_StepSchedulingConfigurationTest_6() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
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
		msg = "Search for " + diagramName + " workflow diagram in the list";
		try {
			Design.enterSearchText_Diagram(diagramName);
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
		msg = " Click '-' button";
		try {
			Design.clickOnMinusSign();
			cfunction.sync(2);
			Design.clickOnMinusSign();
			cfunction.sync(2);
			Design.clickOnMinusSign();
			cfunction.sync(2);
			Design.clickOnMinusSign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Add a new "Manual Step"
		msg = "Add a new \"Manual Step\"";
		if (browser.equalsIgnoreCase("firefox")) {
			try {
				
				SikuliHelp.selectLocationOnMapSikuliClick("TS73_ManualStepD_Firefox_1366x768");
				cfunction.sync(2);
				SikuliHelp.selectLocationOnMapSikuliClick("TS15_bottombluearrow_1366x768");
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		}
		else{
			try {
		
			SikuliHelp.selectLocationOnMapSikuliClick("TS73_ManualStepD_1366x768");
			cfunction.sync(2);
			SikuliHelp.selectLocationOnMapSikuliClick("TS15_bottombluearrow_1366x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		// cfunction.sync(2);
		cfunction.sync(2);
		msg = "Enter Step name as \"Manual Step E\"";
		try {
			Design.enterStepName("Manual Step E");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// In Step Details - Options tab choose "Run on a schedule" option.
		msg = "In Step Details - Options tab choose \"Run on a schedule\" option.";
		try {
			Design.clickOnStepDetailOptionTab();
			Design.clickOnRunOnScheduleExecutesBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The option is expanded and provides 3 options: Wait a period of time, Wait
		// until a specific time and Wait until an exact time defined by an arcade
		// expression.
		msg = "Verify Run On Schedule window expands";
		try {
			if (Design.verifyRunOnSceduleExpands()) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Add a new "Manual Step"
		// In Step Details - Options tab choose "Run on a schedule" option.
		// The option is expanded and provides 3 options: Wait a period of time, Wait
		// until a specific time and Wait until an exact time defined by an arcade
		// expression.
		// Click radio button on "Wait until an exact time defined by an arcade
		// expression".
		msg = "Click radio button on \"Wait until an exact time defined by an arcade expression\".";
		try {
			Design.clickOnWaitUntilAnExactTimeRadioBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The option is expanded to prompt to enter the arcade expression.
		// Enter arcade expression: jobStartedDate($job)
		msg = "Enter arcade expression: jobStartedDate($job).";
		try {
			Design.enterArcadeInput("jobStartedDate($job)");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The expression is entered.
		// Click on the previous manual step.
		// Verify the previous edits are saved in the dialog.
		// Enter a name for the new diagram
		// Save the diagram
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
		// Activate the diagram without creating the job template with same name.
		msg = "Click on Activate Button";
		try {
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		msg = "Click Yes button of confirmation to create job tamplate";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Go back to the list of diagram in Design page.
		// Navigate to the newly created diagram and edit it.
		// Verify each step in Options tab that the schedulings have been saved properly
		// as previously entered.
	}
}
