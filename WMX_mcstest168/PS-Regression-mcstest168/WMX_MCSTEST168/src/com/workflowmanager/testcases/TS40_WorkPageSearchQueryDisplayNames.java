package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS40_WorkPageSearchQueryDisplayNames extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS40_WorkPageSearchQueryDisplayNames() throws InterruptedException {
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
		cfunction.sync(2);
		Design.setting_Button_Loading();
		cfunction.sync(7);
		// Settings tab.
		msg = "Click on Settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The Settings page has three tabs: Groups, Roles and Email Notifications.
		msg = "Verify the Settings page has three tabs: Groups, Roles and Email Notifications.";
		try {
			Design.verifyGroupTabPanel();
			// cfunction.sync(2);
			Design.verifyRoleTabPanel();
			// cfunction.sync(2);
			Design.verifyEmailNotificationTabPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Shared Searches, and click on All Jobs Search query.
		msg = "Click on Shared Searches";
		try {
			Design.clickOnSharedSearchesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The all jobs search query information populates the view.
		// Edit the display names for a few catergories by adding 123 to the end of the
		// name. i.e assignedTo --> assignedTo123
		msg = "Edit the display names for a few catergories by adding 123";
		try {
			Design.enterInputIntofield("assignedTo123");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Save
		msg = "Click Save";
		try {
			Design.clickOnSaveBtnOfSharedSearched();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(1);

		// Navigate to the Work Page.
		// Click on Work Tab
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Work page opens with jobs available.
		// Verify Work tab is opened.
		msg = "Verify Work tab is opened";
		try {
			if (WorkPage.verifyWorkTabOpen())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the All Jobs Search Query
		msg = "Click on the All Jobs";
		try {
			WorkPage.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// "The Display names for the modified categories are shown correctly with 123
		// added to the end."
		msg = "Verify the Display names for the modified categories are shown correctly with 123 added to the end.";
		try {
		if(	WorkPage.verifyAssignedHeaderText("assignedTo123")) {
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

		// Click on the My Jobs Search Query
		msg = "Click on the My Jobs";
		try {
			WorkPage.clickOnMyJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// All the Display Names are for the My Jobs search query are shown that are
		// unchanged from the display fields.

		msg = "Verify all the Display Names are for the My Jobs search query are shown that are unchanged from the display fields";
		try {
			if(WorkPage.verifyAssignedHeaderText("CURRENT STEP")) {
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
	}
}