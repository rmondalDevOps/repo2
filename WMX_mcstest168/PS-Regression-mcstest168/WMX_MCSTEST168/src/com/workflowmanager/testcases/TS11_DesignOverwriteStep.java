package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS11_DesignOverwriteStep extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS11_DesignOverwriteStep() throws InterruptedException {

		CommonFunction.waitforHomePagetoload();

		// Click on Design
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

		// Design View Opens & Job Templates panel is selected
		msg = "Design View Opens & Job Templates panel is selected";
		String tabName = "Job Templates";
		try {
			if (Design.verifyTabPanel(tabName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Verify Job Templates panel is populated with results
		msg = "Verify Job Templates panel is populated with results";
		try {
			if (Design.getAllJobsTemplateList() > 0)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the 'Diagrams' icon
		msg = "Click on the 'Diagrams' icon";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The tab panel should switch to display workflow diagrams
		msg = "The tab panel should switch to display workflow diagrams";
		tabName = "Workflow Diagrams";
		try {
			if (Design.verifyTabPanel(tabName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Type 'Extract' in to the search
		String searchText = "Extract";
		msg = "Enter '" + searchText + "' in Search Textbox";
		try {
			Design.enterSearchTextInWorkflow(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify 'Extract' is visible
		msg = "Verify 'Extract Data' is visible";
		int WorkFlowIndex1 = -1;
		String diagram = "Extract Data";
		try {
			WorkFlowIndex1 = Design.getWorkFlowIndex(diagram);
			if (WorkFlowIndex1 > -1)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Extract Data' diagram
		msg = "Click the '" + diagram + "' diagram";
		try {
			Design.clickOnDiagram(diagram);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The header should populate with 'Active - Extract Data'
		msg = "Header is populated with Active - " + diagram;
		String diagramName = "Active - " + diagram;
		try {
			Design.verifyHeader(diagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The diagram should populate with the corresponding canvas
		msg = "Diagram is populated in canvas";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Edit' button
		msg = "Click on 'Edit' button";
		try {
			Design.clickOnEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// The diagram editing page should load
		msg = "The diagram editing page should load";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// The Step Library should be visible
		msg = "The Step Library should be visible";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// URL should contain workflowmanager/design/diagrams/AWT3eyZ0bK1rf86I0bUW"
		String diagramId = "AWT3eyZ0bK1rf86I0bUW";
		msg = "URL should contain workflowmanager/design/diagrams/AWT3eyZ0bK1rf86I0bUW";
		try {
			if (Design.validateUrlChange(diagramId))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		Design.zoomToLevel(86);
		cfunction.sync(2);

		// Search for step 'Open Pro Project Items' in step library
		String fromStep = "Open Pro Project Items";
		String toStep = "QA/QC extracted data";
		msg = "Search for step '" + fromStep + "' in step library";
		try {
			Design.enterSearchStepTemplate(fromStep);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		// Drag an 'Open Pro Project Items' step on to the 'QA/QC extracted data' step
		msg = "Drag an 'Open Pro Project Items' step on to the 'QA/QC extracted data' step";
		try {
			 Design.dragStepToCanvas("TS11_UpdatedDesign", "TS11_OriginalDesign");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		// The 'Overwrite Step' Dialogue should appear
		msg = "The 'Overwrite Step' Dialogue should appear";
		try {
			Design.verifyConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		// Click 'Cancel'
		msg = "Click 'Cancel'";
		try {
			Design.clickCancelOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// The diagram should remain unchanged
		msg = "The diagram should remain unchanged";
		try {
			String imgName = "TS11_OriginalDesign_1280x1024";
			if (SikuliHelp.verifyImageExists(imgName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click the 'QA/QC extracted data' step
		msg = "Click the 'QA/QC extracted data' step";
		try {
			String imgName = "TS11_OriginalDesign_1280x1024";
			SikuliHelp.selectLocationOnMapSikuliClick(imgName);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// In the Step Details panel, the URL section should contain 'Manual Step help
		// url'
		msg = "In the Step Details panel, the URL section should contain 'Manual Step help url'";
		try {
			String URLText = "Manual Step help text";
			if (Design.verifyURLSection(URLText))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Fetch step name and description
		String stepName = "";
		String stepDesc = "";
		try {
			stepName = Design.getStepName();
			stepDesc = Design.getStepDesc();
			System.out.println("==>>>>>Step Name : " + stepName + "     step Desc : " + stepDesc);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		cfunction.sync(5);
		// Drag an 'Open Pro Project Items' step on to the 'QA/QC extracted data' step
		msg = "Drag an 'Open Pro Project Items' step on to the 'QA/QC extracted data' step";
		try {
			 Design.dragStepToCanvas("TS11_UpdatedDesign", "TS11_OriginalDesign");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// The 'Overwrite Step' Dialogue should appear
		msg = "The 'Overwrite Step' Dialogue should appear";
		try {
			Design.verifyConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'Yes'
		msg = "Click 'Yes'";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The Step Details panel should update with an 'Arguments' section
		msg = "The Step Details panel should update with an 'Arguments' section";
		try {
			Design.verifyArgumentSection();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Step Name should remain the same
		msg = "Step Name should remain the same";
		try {
			if (Design.verifyStepName(toStep))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Commented as per mail communication with same. Only Step name should be same
		/*
		 * //Step Description should remain the same msg =
		 * "Step Description should remain the same"; try {
		 * if(Design.verifyStepDesc(stepDesc)) CommonFunction.logStatus("PASS", msg);
		 * else CommonFunction.logStatus("FAIL", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 */
		cfunction.sync(10);
		// The styling of the step should have changed (Color)
		msg = "The styling of the step should have changed (Color)";
		try {
			String imgName = "TS11_UpdatedDesign_1280x1024";
			if (SikuliHelp.verifyImageExists(imgName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Click 'Undo' (< in the header)
		msg = "Click 'Undo' (< in the header)";
		try {
			Design.clickOnUndoButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// The step should revert to its original state
		msg = "The step should revert to its original state";
		try {
			String imgName = "TS11_OriginalDesign_1280x1024";
			if (SikuliHelp.verifyImageExists(imgName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Click 'Redo' (> in the header)
		msg = "Click 'Redo' (> in the header)";
		try {
			Design.clickOnRedoButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		// The step should revert to the overwritten state
		msg = "The step should revert to the overwritten state";
		try {
			String imgName = "TS11_UpdatedDesign_1280x1024";
			if (SikuliHelp.verifyImageExists(imgName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
	}
}
