package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;

public class TS80_ManagePagePopupAndZoom extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS80_ManagePagePopupAndZoom() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		msg = "Expand the View dropdown and click Map & List view";
		try {
			Coordinate.selectUpdateViewFromDropdown("Map & List");
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select \"Data Edits Job 1\" in Job List view.";
		try {
			if(Coordinate.clickOnJobListEntry("Data Edits Job 1")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The job's point location is highlighted in the map.
		//Hover over the Action column for selected job in the Job List view and "Zoom to loctaion" option is availabe. Click it.
		msg = "Hover over the Action column for selected job in the Job List view.";
		try {
			Coordinate.hoverOnActionList(1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//cfunction.sync(2);
		msg = "Click \"Zoom to loctaion\" option is availabe. Click it.";
		try {
			Coordinate.clickOnActionList(1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		msg = "Verify the map view zooms to the job's location.";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick("TS80_ClickPointOnMap_1280x768");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Log into Workflow Manager and select a Workflow Item.   The Manage Page should open.
		//In the map panel, line and polygon (but not multipoint) job locations should have labels. 
		//" Ensure the View setting (bottom-right) is set to Map & List. 
		//Hover over a job in the job list."
		//On the left side of the row, a zoom-to-location button appears.
		//Click on the zoom-to-location button.
		//The map view zooms to the job's location. 
		//Click on the job's location in the map view. 
		//A popup appears containing a table of the job's properties. 
		//In the popup menu, click the Dock button in the top-right corner.
		msg = "Click the Dock button in the top-right corner..";
		try {
			if(browser.equals("Firefox")) {
				//SikuliHelp.dragndropSikuli("TS_80Redland_Heights_ScrollFirefox", "TS_80To_ScrolFirefox", true);
				SikuliHelp.dragndropSikuli("TS_80Redland_Heights_Scroll", "TS_80To_Scroll", true);
			}
			else {
				SikuliHelp.dragndropSikuli("TS_80Redland_Heights_Scroll", "TS_80To_Scroll", true);
			}
			
			cfunction.sync(10);
			Coordinate.clickOnDockBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The popup menu docks to the right side of the map view. 
		//"In the bottom-left corner of the popup menu, click the Select button. "
		msg = "Click \"Select\" option in the pop-up window.";
		try {
			Coordinate.clickOnSelectBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The job is selected in the Job List, and its information appears in the Job Details panel. 
		msg = "The corresponding job is selected in the Job List view: \"Data Edits Job 1\"";
		try {
			Coordinate.verifyJobNameAtInfoPanel("Data Edits Job 1");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Zoom out, then click the zoom button at the bottom of the popup menu.";
		try {
			Coordinate.clickOnZoomToAllBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click \"Zoom\" option in the pop-up window.";
		try {
			Coordinate.clickOnZoomBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Zoom out, then click the zoom button at the bottom of the popup menu. 
		//The map view zooms back to the job location.
}
}