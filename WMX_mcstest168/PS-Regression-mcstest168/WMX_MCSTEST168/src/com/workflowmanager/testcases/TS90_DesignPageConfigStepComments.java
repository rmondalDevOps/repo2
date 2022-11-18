package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;


public class TS90_DesignPageConfigStepComments extends TestBase{
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS90_DesignPageConfigStepComments() throws InterruptedException {
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
		//Click on Diagram in left menu
		msg = "Click on Diagram in left menu";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on create new button
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enter Diagram Name
		msg = "Enter diagram name as 'Sample Diagram'";
		try {
			Design.enterDiagramName("sample diagram");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enter Diagram description
		msg = "Enter diagram description as 'Sample description'";
		try {
			Design.enterDiagramDescription("test Description");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Search for step Question in step library";
		try {
			Design.enterSearchStepTemplate("Question");
			String canvasStep = "BlankCanvas_1280x768";
			SikuliHelp.dragNDrop("Question_1280x768", canvasStep);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Drag and drop update job properties";
		try {
			Design.enterSearchStepTemplate("Update Job Properties");
			SikuliHelp.dragNDrop("TS91_DragUpdateJobProperties_1280x768", "Question_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Connect paths of Question and update job properties";
		try {
			SikuliHelp.hoveronLocationSikuli("Question");
			cfunction.sync(5);
			//SikuliHelp.selectLocationOnMapSikuliClick("TS1_TC1_Flow_new_1280x768");
			Design.dragStepToCanvas("TS1_TC1_fromLineQuestion_new2", "TS1_TC1_toLineQuestion_new2");
			cfunction.sync(2);
			//Design.connectSteps();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		
		
	
	}
}
