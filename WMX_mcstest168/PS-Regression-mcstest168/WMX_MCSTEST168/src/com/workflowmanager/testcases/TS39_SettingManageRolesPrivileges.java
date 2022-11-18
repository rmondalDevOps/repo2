package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS39_SettingManageRolesPrivileges extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS39_SettingManageRolesPrivileges() throws InterruptedException {
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
		// Go to Roles tab.
		msg = "Click on Role Tab";
		try {
			Design.clickOnRoleTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The left hand side list all the workflow roles. The right hand side list the
		// corresponding workflow privileges associated with the selected role.
		msg = "Verify Role list header and Workflow Privileges list header";
		try {
			Design.verifyRoleListHeader();
			Design.verifyWorkflowPrivilegesListHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click "Create New" next to Roles header to create a new workflow role.
		msg = "Click on 'Create New' to create new Role";
		try {
			Design.clickOnCreateNewRoleBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The right hand side dialog is updated to allow to enter the new role name and
		// list all the available workflow privileges to associate with the new role.
		// The role name is highlighted in red to indicate it is required. The Save
		// button is disabled.
		msg = "Verify The role name is highlighted in red to indicate it is required.";
		try {
			Design.verifyRoleNameError_Tooltip();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click "Discard Changes" to revert the changes to add a new role.
		msg = "Click on 'Discard Changes'S to revert the changes to add a new role.";
		try {
			Design.clickOnDiscardChangesBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// No new role is created. The Roles list has the top one being selected. The
		// Workflow privileges are updated correspondingly to indicate the selected
		// role's privileges.
		// Click "Create New" next to Roles header to create a new workflow role.
		msg = "Click on 'Create New' to create new Role";
		try {
			Design.clickOnCreateNewRoleBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The right hand side dialog is updated to allow to enter the new role name and
		// list all the available workflow privileges to associate with the new role.
		// The role name is highlighted in red to indicate it is required. The Save
		// button is disabled.
		msg = "Verify The role name is highlighted in red to indicate it is required.";
		try {
			Design.verifyRoleNameError_Tooltip();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Enter a new role's name "newRole"
		msg = "Enter the Role's name as 'newRole'";
		try {
			Design.enterRoleName("newRole");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The Save button is enabled.

		// Check on the workflow privilege "jobCreate"
		msg = "Check on the workflow privilege \"jobCreate\"";
		try {
			Design.enableWorkflowPrivileges("jobCreate");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The jobCreate privilege is enabled.
		msg = "Verify The jobCreate privilege is enabled.";
		try {
			Design.verifyEnableWorkflowPrivileges();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click "Select All"
		msg = "Click \"Select All\"";
		try {
			Design.clickOnSelectAllBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click "Deselect All"
		msg = "Click \"Deselect All\"";
		try {
			Design.clickOnSelectAllBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Check on the workflow privilege "jobCreate"
		msg = "Check on the workflow privilege \"jobCreate\"";
		try {
			Design.enableWorkflowPrivileges("jobCreate");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The jobCreate privilege is enabled.
		msg = "Verify The jobCreate privilege is enabled.";
		try {
			Design.verifyEnableWorkflowPrivileges();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click Save.
		msg = "Click Save";
		try {
			Design.clickOnSaveBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(1);
		// A toast message pops to indicate the new role is created. The "newRole" has
		// been inserted into the Workflow Roles list.
		msg = "Verify toast message pop up for updates have been saved successfully";

		try {
			String successMsg = "Group role newRole created successfully";
			if (Design.verifySuccessMsg2(successMsg))
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on another role in the list.
		msg = "Click on another role in the list.";
		try {
			Design.selectRoleFromList("adminAdvanced");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The workflow privileges are updated to reflect the selected role's
		// privileges.
		msg = "Verify the workflow privileges are updated to reflect the selected role's privileges.";
		try {
			Design.verifyEnableWorkflowPrivileges();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on "newRole" again.
		msg = "Click on \"newRole\" again.";
		try {
			Design.selectRoleFromList("newRole");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The "jobCreate" privilege is enabled for the "newRole".
		msg = "Verify The jobCreate privilege is enabled.";
		try {
			Design.verifyEnableWorkflowPrivileges();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click Groups tab.
		msg = "Click Groups tab.";
		try {
			Design.clickOnGroupTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The left hand side list all the workflow groups. The right hand side list the
		// corresponding workflow roles associated with the selected role. By default
		// the first group is selected.
		msg = "Verify workflow groups tab opend";
		try {
			Design.verifyGroupTabOpens();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Scroll down to select "Public 1_WMX Role"
		msg = "Select 'Public 1_WMX Role' from the workflow groups";
		try {
			Design.selectWorkflowGroupFromList("Public_1 WMX Role");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The workflow roles list is refreshed. The "newRole" is available.
		// Check on "newRole" then "Save"
		msg = "Click on \"newRole\"";
		try {
			Design.enableWorkflowPrivileges1("newRole");
			cfunction.sync(2);
			Design.clickOnSaveBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// cfunction.sync(2);
		// The toast message pops to indicate the group roles is updated.
		msg = "Verify toast message pop up for updates have been saved successfully";
		String successMsg1 = "Groups and roles updated successfully";
		try {
			if (Design.verifySuccessMsg1(successMsg1))
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Log out from the web app.
		msg = "Log out of the web app";

		try {
			HomePage.clickOnLogOut();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Log in to the web app as "wmxuser" and check the Coordinate page.
		msg = "Log in to the web app as \"wmxuser\" and check the Coordinate page.";
		try {
			/*driver.close();
			cfunction.sync(10);
			driver.manage().deleteAllCookies();*/
			
		//driver.get("https://mcstest62.esri.com/portal/apps/workflowmanager/");
			cfunction.sync(10);
			LoginPage lp = new LoginPage();
			// lp.loginToApplication1(xls.getCellData("en-us",2, 2),
			// xls.getCellData("en-us", 3,2));
			lp.loginToApplication(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The Create Jobs tab is now enabled for wmxuser.
		msg = "The Create Jobs tab is now enabled for wmxuser.";
		try {
			Design.verifyCreateButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Go to Design - Settings tab.
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
		// Go to Roles tab.
		msg = "Click on Role Tab";
		try {
			Design.clickOnRoleTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The left hand side list all the workflow roles. The right hand side list the
		// corresponding workflow privileges associated with the selected role.
		msg = "Verify Role list header and Workflow Privileges list header";
		try {
			Design.verifyRoleListHeader();
			Design.verifyWorkflowPrivilegesListHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Search for "newRole"
		// The "newRole" is returned and the "jobCreate" privilege is enabled.
		msg = "Click on \"newRole\" again.";
		try {
			Design.selectRoleFromList("newRole");
			Design.verifyEnableWorkflowPrivileges();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Uncheck "jobCreate".
		msg = "Check off the workflow privilege \"jobCreate\"";
		try {
			Design.enableWorkflowPrivileges("jobCreate");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Save the updates.
		msg = "Click Save";
		try {
			Design.clickOnSaveBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// The toast message pops to indicate the role is updated.
		msg = "Verify toast message pop up for updates have been saved successfully";

		try {
			String successMsg = "Group role newRole updated successfully";
			if (Design.verifySuccessMsg2(successMsg))
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click Coordinate page.
		msg = "Click Coordinate page.";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The Create Jobs tab is disabled and no longer available for wmxuser.
		msg = "The Create Jobs tab is now disabled for wmxuser.";
		try {
			Design.verifyCreateButtonDisable();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Log out from the web app
		msg = "Log out of the web app";

		try {
			HomePage.clickOnLogOut();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Log in to the web app as "admin" and check the Coordinate page.
		msg = "Log in to the web app as \"admin\" and check the Coordinate page.";
		try {
			//driver.get("https://mcstest62.esri.com/portal/apps/workflowmanager/");
			cfunction.sync(10);
			LoginPage lp = new LoginPage();
			// lp.loginToApplication1(xls.getCellData("en-us",2, 2),
			// xls.getCellData("en-us", 3,2));
			lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
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
		// Go to Roles tab.
		msg = "Click on Role Tab";
		try {
			Design.clickOnRoleTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The left hand side list all the workflow roles. The right hand side list the
		// corresponding workflow privileges associated with the selected role.
		msg = "Verify Role list header and Workflow Privileges list header";
		try {
			Design.verifyRoleListHeader();
			Design.verifyWorkflowPrivilegesListHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Search for "newRole"
		// The "newRole" is returned and the "jobCreate" privilege is enabled.
		msg = "Click on \"newRole\" again.";
		try {
			Design.selectRoleFromList("newRole");
			Design.verifyEnableWorkflowPrivileges();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click "…" next to Save
		msg = "Click Ellipsis next to Save";
		try {
			Design.clickOnEllipsis2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// A context menu is opened and Delete Role option is available.
		msg = "Verify A context menu is opened and Delete Role option is available";
		try {
			Design.verifyDeleteBtnIsDisplayed1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(20);

		// Click "Delete Role"
		msg = "Click \"Delete \" button";
		try {
			Design.clickOnDeleteBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// A confirmation dialog pops up.
		msg = "Verify A confirmation dialog pops up.";
		try {
			Design.verifyDeleteConfirmationBoxIsDisplayed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click No
		msg = "Click No";
		try {
			Design.clickOnJobTemplateDeleteConfirmationNoBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The role isn't deleted.
		// Click "…" next to Save
		msg = "Click Ellipsis next to Save";
		try {
			Design.clickOnEllipsis2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// A context menu is opened and Delete Role option is available.
		msg = "Verify A context menu is opened and Delete Role option is available";
		try {
			Design.verifyDeleteBtnIsDisplayed1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click "Delete Role"
		msg = "Click \"Delete \" button";
		try {
			Design.clickOnDeleteBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// A confirmation dialog pops up.
		msg = "Verify A confirmation dialog pops up.";
		try {
			Design.verifyDeleteConfirmationBoxIsDisplayed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Yes
		msg = "Click Yes";
		try {
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// A toast message pops to indicate the role is deleted.
		msg = "Verify toast message pop up for updates have been saved successfully";

		try {
			String successMsg = "Group role newRole deleted successfully";
			if (Design.verifySuccessMsg2(successMsg))
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the "newRole" has been removed from the list.
		msg = "Verify the \"newRole\" has been removed from the list.";
		try {
			if (Design.selectRoleFromList("newRole")) {
				CommonFunction.logStatus("FAIL", msg);
			} else {
				CommonFunction.logStatus("PASS", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click Groups tab.
		msg = "Click Groups tab.";
		try {
			Design.clickOnGroupTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The left hand side list all the workflow groups. The right hand side list the
		// corresponding workflow roles associated with the selected role. By default
		// the first group is selected.

		msg = "Verify workflow groups tab opend";
		try {
			Design.verifyGroupTabOpens();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify in the Workflow Roles list that the "newRole" has been removed from
		// the list.
		msg = "Click on \"newRole\"";
		try {
			Design.enableWorkflowPrivileges1("newRole");

			// Design.clickOnSaveBtn1();
			CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		// cfunction.sync(2);
		// Click "Roles" tab and search for "newRole"
		msg = "Click \"Roles\" tab and search for \"newRole\"";
		try {
			Design.clickOnRoleTab();
			cfunction.sync(2);
			Design.enterSearchRoleTextInSearch("newRole");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// No records found. On the Right hand side no workflow privilege is enabled.
		// "Select All" and "Deselect All" options are not available. Save and Discard
		// Changes buttons are disabled.
		msg = "Verify No records found. On the Right hand side no workflow privilege is enabled";
		try {
			if (Design.selectRoleFromList("newRole")) {
				CommonFunction.logStatus("FAIL", msg);
			} else {
				CommonFunction.logStatus("PASS", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
	}
}
