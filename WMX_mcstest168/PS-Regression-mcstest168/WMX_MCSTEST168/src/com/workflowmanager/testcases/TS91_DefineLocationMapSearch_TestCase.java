package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS91_DefineLocationMapSearch_TestCase extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflowManager_DefineLocationMapSearch_TestCase() {

		// Click on Design
		msg = "Clicked on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on create new diagram
		msg = "Click on create new diagram";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Create new diagram name and description
		msg = "Create new diagram name";
		try {
			Design.enterDiagramName("Test Diagram Name");
			Design.enterDiagramDescription("Test Diagram Description");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Search Step Template 'Update Job Properties'
		msg = "Search Step Template 'Update Job Properties'";
		try {
			Design.enterSearchStepTemplate("Update Job Properties");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Drag and Drop Update Job Properties to Canvas
		msg = "Drag and Drop Update Job Properties to Canvas";
		try {
			SikuliHelp.dragNDrop("TS91_DragUpdateJobProperties_1280x768", "TS91_DropUpdateJobProperties_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Add New Job Property
		msg = "Add New Job Property";
		try {
			Design.clickOnAddNewJobProp();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter the text 'caliurbanareas.globalid' in new job Property
		msg = "Enter the text 'caliurbanareas.globalid' in new job Property";
		try {
			Design.enterJobPropInput(3, "caliurbanareas.globalid");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Connect paths of \"Start/End\" and \"Update Job Properties\" steps
		msg = "Connect paths of \"Start/End\" and \"Update Job Properties\" steps";
		try {

			SikuliHelp.hoveronLocationSikuli("PathStart_1280x768");
			cfunction.sync(2);
			Design.dragStepToCanvas("PathDown", "PathEnds");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		// Search Step Template 'Define Location'
		msg = "Search Step Template 'Define Location'";
		try {
			Design.enterSearchStepTemplate("Define Location");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Drag and Drop Define Location to Canvas
		msg = "Drag and Drop Define Location to Canvas";
		try {
			SikuliHelp.dragNDrop("TS91_DragUpdateJobProperties_1280x768", "TS91_DropDefineLocation_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select Drop-down option 'Polygon'
		msg = "Select Drop-down option Polygon";
		try {
			Design.selectFromJobLocationGeomatryDrpdwn("Polygon");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter Text in ArcGISPro
		msg = "Enter Text in ArcGISPro";
		try {
			Design.enterTextArcGISPro(
					"https://solutions.maps.arcgis.com/home/item.html?id=b6d2a1a1a782497a8453006189a270fa");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter Text in Search
		msg = "Enter Text in Search";
		try {
			Design.enterTextInSearch("jobExtendedProperty($job,'caliurbanareas','NAME')");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Connect paths of \"Update Job Properties\" and \"Define Location \" steps
		msg = "Connect paths of \"Update Job Properties\" and \"Define Location\" steps";
		try {

			SikuliHelp.hoveronLocationSikuli("TS91_HoverUpdateJobProp_1280x768");
			cfunction.sync(2);
			Design.dragStepToCanvas("PathDown", "CreateVersionPathEnd");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		// Search Step Template 'Manual Step'
		msg = "Search Step Template 'Manual Step'";
		try {
			Design.enterSearchStepTemplate("Manual Step");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Drag and Drop Manual Step to Canvas
		msg = "Drag and Drop Manual Step to Canvas";
		try {
			SikuliHelp.dragNDrop("TS91_DragManualStep_1280x768", "TS91_DropDefineLocation_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//

		msg = "Connect paths of \"Create Version\" and \"Define Location\" steps";
		try {

			SikuliHelp.hoveronLocationSikuli("HoverOnDefineLocation_1280x768");
			cfunction.sync(2);
			Design.dragStepToCanvas("PathDown", "TS91_DefineLocationPathEnd");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Save
		msg = "Click Save button";
		try {
			Design.clickOnSave1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Activate
		msg = "Click Activate button";
		try {
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		
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

		/*// Click on Back button in Design Page
		msg = "Click on Back button in Design Page";
		try {
			Design.clickOnBack();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		// Click on Job Templates
		msg = "Click on Create New Job Templates";
		try {
			Design.ClickOnCreateNewJobTemplates();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		

		// Enter Job Template Name
		msg = "Enter Job Template Name";
		try {
			Design.enterJobTemplateName("Test Diagram Name");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter Job Name
				msg = "Enter Job Name";
				try {
					Design.enterJobName("Test Job Name");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		

	}

}
