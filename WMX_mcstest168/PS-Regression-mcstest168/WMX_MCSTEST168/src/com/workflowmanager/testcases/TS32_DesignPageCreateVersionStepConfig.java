package com.workflowmanager.testcases;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
//import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;

public class TS32_DesignPageCreateVersionStepConfig extends TestBase{
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName=cfunction.getUniqueName("New test delete");
	String expectedCalendarUI= "TS29_CalendarGUI.png";

	public void workflow_TS32_DesignPageCreateVersionStepConfig() throws InterruptedException {
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
		msg = "Drag a couple of steps on to the canvas such that it looks like the diagram below";
		try {
			Design.enterSearchStepTemplate("Create Version");
			// cfunction.ScrollToElement("(//div[@class='ui-accordion-content
			// ui-widget-content'])[4]");
			// String step="TS24_CreateVersion";
			String canvasStep = "BlankCanvas";
			Design.dragStepToCanvas("TS24_CreateVersion", canvasStep);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify step Name text
		msg = "Verify step Name with the text 'Create Version'";
		try {
			boolean check = Design.verifyStepName("Create Version");
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
		// Verify step Description text
		msg = "Verify step description with the text 'Create a version'";
		try {
			Design.clickOnStepDetailAboutTab();
			boolean check = Design.verifyStepDesc("Create a version");
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
		//Verify radio button visible
		msg = "Verify radio button visible";
		try {
			Design.clickOnStepDetailPropertiesTab();
			Design.verifyPrivateRadioBtnVisible();
			Design.verifyPublicRadioBtnVisible();
			Design.verifyProtectedRadioBtnVisible();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Toggle all radio button
		msg = "Toggle 'Public' radio button";
		try {
			Design.clickPublicRadioBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Toggle 'Protected' radio button";
		try {
			Design.clickProtectedRadioBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Toggle 'Private' radio button";
		try {
			Design.clickPrivateRadioBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Verify radio button visible
				msg = "Verify Data Source radio button visible";
				try {
					//Design.clickOnStepDetailPropertiesTab();
					Design.verifyDataSourceRadioBtnVisible(4);
					Design.verifyDataSourceRadioBtnVisible(5);
					Design.verifyDataSourceRadioBtnVisible(6);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Toggle all radio button
				//cfunction.sync(2);
				msg = "Toggle 'Selected Sources:' radio button";
				try {
					Design.clickDataSourceRadioBtn(5);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Toggle 'Arcade Expression' radio button";
				try {
					Design.clickDataSourceRadioBtn(6);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Toggle 'All' radio button";
				try {
					Design.clickDataSourceRadioBtn(4);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				cfunction.sync(2);		
	}
}
