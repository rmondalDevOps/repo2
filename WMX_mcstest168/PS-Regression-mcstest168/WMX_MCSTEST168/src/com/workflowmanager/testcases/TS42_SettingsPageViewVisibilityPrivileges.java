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
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS42_SettingsPageViewVisibilityPrivileges extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS42_SettingsPageViewVisibilityPrivileges() throws InterruptedException {
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
		Design.setting_Button_Loading();
		cfunction.sync(7);
		cfunction.sync(2);
		//Click on Settings tab.
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
		//Click on Roles tab.
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
		//The right hand side dialog is updated to allow to enter the new role name and
		//list all the available workflow privileges to associate with the new role. 
		//The role name is highlighted in red to indicate it is required. The Save button is disabled.
				msg = "Verify The role name is highlighted in red to indicate it is required.";
				try {
					Design.verifyRoleNameError_Tooltip();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Enter a new role's name "testVisibility"
				msg = "Enter the Role's name as 'testVisibility'";
				try {
					Design.enterRoleName("testVisibility");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The Save button is enabled.
		//Check on the workflow privileges: 'viewCoordinatePage',
				msg = "Check on the workflow privilege \"viewCoordinatePage\"";
				try {
					Design.enableWorkflowPrivileges("viewManagePage");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//'viewJobCreatePanel'
				msg = "Check on the workflow privilege \"viewJobCreatePanel\"";
				try {
					Design.enableWorkflowPrivileges("viewCreatePanel");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//viewJobPanelAttachments,
				msg = "Check on the workflow privilege \"viewJobPanelAttachments\"";
				try {
					Design.enableWorkflowPrivileges("viewDetailsPanelAttachments");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//viewJobPanelDetails,
				msg = "Check on the workflow privilege \"viewJobPanelDetails\"";
				try {
					Design.enableWorkflowPrivileges("viewDetailsPanelProperties");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//viewJobPanelDiagram,
				msg = "Check on the workflow privilege \"viewJobPanelDiagram\"";
				try {
					Design.enableWorkflowPrivileges("viewDetailsPanelDiagram");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//viewJobPanelLocation 
				msg = "Check on the workflow privilege \"viewJobPanelLocation\"";
				try {
					Design.enableWorkflowPrivileges("viewDetailsPanelLocation");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//and viewWorkPage
				msg = "Check on the workflow privilege \"viewWorkPage\"";
				try {
					Design.enableWorkflowPrivileges("viewWorkPage");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		
		//The visibility privileges are enabled.
				msg = "The visibility privileges are enabled.";
				try {
					Design.verifyEnableWorkflowPrivileges();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click Save.
				msg = "Click Save";
				try {
					Design.clickOnSaveBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(1);
		//A toast message pops to indicate the new role is created. The "testVisibility" 
		//has been inserted into the Workflow Roles list.
				msg = "Verify toast message pop up for created have been saved successfully";

				try {
					String successMsg = "Group role testVisibility created successfully";
					if (Design.verifySuccessMsg2(successMsg))
						CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click Groups tab.
				msg = "Click Groups tab.";
				try {
					Design.clickOnGroupTab();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The left hand side list all the workflow groups. The right hand side
		//list the corresponding workflow roles associated with the selected role.
		//By default the first group is selected.
				msg = "Verify workflow groups tab opend";
				try {
					Design.verifyGroupTabOpens();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Scroll down to select "NishiMishra"
				msg = "Select 'NishiMishra' from the workflow groups";
				try {
					Design.selectWorkflowGroupFromList("NishiMishra");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The workflow roles list is refreshed. The "testVisibility" is available and unchecked.
		//Check on "testVisibility" 
				msg = "Check on \"testVisibility\" ";
				try {
					Design.enableWorkflowPrivileges1("testVisibility");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//and check off "viewVisibility" 
				msg = "Check off \"viewVisibility\" ";
				try {
					Design.enableWorkflowPrivileges1("viewVisibility");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click Save";
				try {
					Design.clickOnSaveBtn1();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(1);
		//A toast message pops to indicate the new role is created. The "testVisibility" 
		//has been inserted into the Workflow Roles list.
				msg = "Verify toast message pop up for updates have been saved successfully";

				try {
					String successMsg = "Group and role updated successfully";
					if (Design.verifySuccessMsg(successMsg))
						CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Go to Roles tab and update "testVisiblity" privileges by 
		//checking off "viewCoordinatePage" and 
		//check off"viewWorkPage"
				msg = "Click on Role Tab";
				try {
					Design.clickOnRoleTab();
					Design.enableWorkflowPrivileges("viewManagePage");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click on "Save".
				//Click Save.
				msg = "Click Save";
				try {
					Design.clickOnSaveBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(1);
		//The role's privileges are updated.
				/*msg = "Verify toast message pop up for created have been saved successfully";

				try {
					String successMsg = "Group role testVisibility created successfully";
					if (Design.verifySuccessMsg1(successMsg))
						CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}*/
				cfunction.sync(2);
		//Log out from the web app.
				msg = "Log out the application";
				try {
					HomePage.clickOnLogOut();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Log in to the web app as "nmishra"Password "JobTracking102"
				msg = "Log in to the web app as \"nmishra\"";
				try {
					LoginPage  lp = new LoginPage();
					lp.loginToApplication1(xls.getCellData("en-us",2, 13), xls.getCellData("en-us", 3,12));
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				cfunction.sync(2);
		// The Coordinate and Work pages are not available.
				msg = "The Coordinate and Work pages are not available.";
				cfunction.sync(2);
				try {
					//String URL = "https://mcstest62.esri.com/portal/apps/workflowmanager/554a740a715245118d322adf53c010db/coordinate";
					boolean check = HomePage.verifyLandingPage();
					if (check) {
						CommonFunction.logStatus("FAIL", msg);
					}

					else {
						CommonFunction.logStatus("PASS", msg);
					}

				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Repeat the above steps by updating the "testVisiblity" role's privileges
		//and verify the visibility of web app tabs.
		//1. Only check off viewCreateJobPanel. Check on the other 6 view privileges.
		//Verify Create Job tab is not visible in both Coordinate page and Work page.
		//2. Check on viewCoordinatePage, viewCreateJobPanel and viewWorkPage. Check off the other 4 view  privileges.
		//Verify the job details panel including job diagram, job location and job attachments are all not visible. The job details panel isn't available to expand in both Coordinate and Work page when clicking on a job.
		//3. Check on viewCoordinatePage, viewCreateJobPanel, viewWorkPage, viewJobDetailsPanel and viewJobAttachment. Check off viewJobDiagram and viewJobLocation privileges.
		//Verify the job details panel and job attachments are visible when clicking on a job in Job List in Coordinate page and clicking on job card in Work page. Verify the tab for viewing job location and diagram is not visible.
		//4. Check on viewCoordinatePage, viewCreateJobPanel, viewWorkPage, viewJobDetailsPanel, viewJobAttachment and viewJobDiagram. Check off viewJobLocation privileges.
		//Verify the job details panel and job attachments are visible when clicking on a job in Job List in Coordinate page and clicking on job card in Work page. The 2nd tab in job details panel only displays job diagram. The job loation section is not visible.
		//5. Check on viewCoordinatePage, viewCreateJobPanel, viewWorkPage, viewJobDetailsPanel, viewJobAttachment and viewJobLocation. Check off viewJobDiagram privileges.
		//Verify the job details panel and job attachments are visible when clicking on a job in Job List in Coordinate page and clicking on job card in Work page. The 2nd tab in job details panel only displays job location. The job diagram section is not visible.
		//Once the tests are done, go to Design - Settings- Roles to delete "testVisiblity" role and in Groups tab, update "nmishra" group by checking on "viewVisibility" role.

	}

}
