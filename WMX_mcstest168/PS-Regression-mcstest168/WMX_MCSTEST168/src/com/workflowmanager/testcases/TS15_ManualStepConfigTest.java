package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS15_ManualStepConfigTest extends TestBase {


	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS15_ManualStepConfigTest() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();

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
		//Click on Job Templates
		msg = "Click on Job Templates";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Design View Opens & Job Templates panel is selected
		msg = "Design View Opens & Job Templates panel is selected";
		String tabName = "Job Templates";
		try {
			if(Design.verifyTabPanel(tabName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		//Verify Job Templates panel is populated with results
		msg = "Verify Job Templates panel is populated with results";
		try {
			if(Design.getAllJobsTemplateList() > 0)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on the 'Diagrams' icon
		msg = "Click on the Diagrams icon";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// The tab panel should switch to display workflow diagrams
		msg = "Tab panel should switch to display workflow diagrams";
		tabName = "Workflow Diagrams";
		try {
			if(Design.verifyTabPanel(tabName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click 'Create New'
		msg = "Click 'Create New'";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// A new diagram should open with a single step on the canvas
		msg= "A new diagram should open with a single step on the canvas";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Start/End' step
		msg = "Click the 'Start/End' step";
		String imgName ="TS15_stepEnd_1366x768";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick(imgName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 4 blue arrows should appear
		msg = "4 blue arrows should appear";
		String imgName1 = "TS15_bluearrow_1366x768";
		try {
			if(SikuliHelp.verifyImageExists(imgName1))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the bottom blue arrow
		msg = "Click the bottom blue arrow";
		String imgName2 ="TS15_bottombluearrow_1366x768";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick(imgName2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Step details panel should open
		msg ="Step details panel should open";
		String title = "Step Details";
		try {
			if(Design.verifyStepDetailsHeader(title))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Step Name should be with the text 'Manual Step'
		msg = "Step Name should be with the text 'Manual Step'";
		String stepName = "Manual Step";
		try {
			if(Design.verifyStepName(stepName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Step Description should be with the text 'Step to indicate manual work, with no additional logic'
		msg = "Step Description matched ";
		String stepDesc = "Step to indicate manual work, with no additional logic";
		try {
			Design.clickOnStepDetailAboutTab();
			if(Design.verifyStepDesc(stepDesc))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Automatically executes' box under Options
		msg = "Click the 'Automatically executes' box under Options";
		try {
			Design.clickOnStepDetailOptionTab();
			Design.clickOnAutomaticallyexecutesBox1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// It should become checked
		msg = "Automatically executes should become checked";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Automatically executes' box under Options
		msg = "Click the 'Automatically executes' box under Options";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// It should return to its previous state
		msg = "Return to its previous state";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Can be skipped' box under Options
		msg = "Click the 'Can be skipped' box under Options";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// It should become checked
		msg = "'Can be skipped'should become checked";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Double click the Manual step
		msg = "Double click the Manual step";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The name should become editable on the step
		msg = "The name should become editable on the step";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Type The name should update on the step and in the step details panel
		////*[@id='workflowDiagram']/textarea
		msg = "Type The name should update on the step and in the step details panel";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The name should update on the step and in the step details panel
		msg = "The name should update on the step and in the step details panel";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Replace the Step Description text with 'Head to job site and perform survey'
		msg = "Replace the Step Description text with 'Head to job site and perform survey'";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The field should be editable and display the new text
		msg = "The field should be editable and display the new text";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on the diagram
		msg = "Click on the diagram";
		try {
			Design.clickOnWorkflowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The Diagram Settings panel should appear
		msg = "The Diagram Settings panel should appear";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on the 'Field Data Collection' step
		msg = "Click on the 'Field Data Collection' step";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The step name, step description, and 'Can be skipped' checkbox should still be in their updated states
		msg = "The step name, step description, and 'Can be skipped' checkbox should still be in their updated states";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
	}



}
