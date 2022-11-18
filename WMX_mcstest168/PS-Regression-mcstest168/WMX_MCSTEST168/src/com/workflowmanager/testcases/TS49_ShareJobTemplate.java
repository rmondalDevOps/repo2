package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS49_ShareJobTemplate  extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS49_ShareJobTemplate() throws InterruptedException {
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
				msg = "Click on \"Extract Data\" Job Template from the list";
				try {
					Design.clickJobTemplateName("Extract Data");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Click on the 'Sharing' tab
				msg = "Click on the 'Sharing' tab";
				try {
					Design.clickOnSharingTAb();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Click on the 'Groups' radio button
				msg = "Click on the 'Groups' radio button";
				try {
					Design.clickOnGroupRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//"Groups should indicate that it was selected The group selection table should appear The text prompt 'Please select at least one group' should be visible See second image in references"
				msg = "Verify The text prompt 'Please select at least one group' should be visible";
				try {
					if(Design.verifyPromptTextVisible()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click on 'Deselect All'
				msg = "Click on 'Deselect All'";
				try {
					Design.clickSelectAllOrDeselectAllBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//"The save button should disable None of the groups should be selected 'No Group is selected.' warning should appear"
				msg = "Verify the Error text should be visible";
				try {
					if(Design.verifyErrorTextVisible()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click on 'Select All'
				msg = "Click on 'Select All'";
				try {
					Design.clickSelectAllOrDeselectAllBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//"The save button should enable All of the groups should be selected The warning should no longer be visible"
				msg = "Verify the Error text should not be visible";
				try {
					if(Design.verifyErrorTextVisible()) {
						CommonFunction.logStatus("FAIL", msg);
					}else {
						CommonFunction.logStatus("PASS", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click on 'Deselect All'
				msg = "Click on 'Deselect All'";
				try {
					Design.clickSelectAllOrDeselectAllBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click the 'Shared To' checkbox for only the admin group
				
				msg = "Click the 'Shared To' checkbox for 'AarthiDwarakanath'";
				try {
					Design.clickOnGroupNameCheckbox("AarthiDwarakanath");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click 'Save'
				msg = "Click 'Save'";
				try {
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				//It should be successful
				msg = "Verify Success message is displayed.";
				String successMsg = "Job template updated successfully";
				try {
					if (Design.verifySuccessMsg(successMsg))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Navigate to the Work page
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
				//On the Create panel
				msg = "Click on the left create button to expand the left panel";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Seach for 'Extract Data'
				msg = "Seach for 'Extract Data'";

				try {
					Coordinate.clickCreateDefaultOfTemplatePresent("Extract Data");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//It should be visible
				msg="Verify 'Extract Data' is visible";
				
				try {
					Coordinate.selectTemplateFromList("Extract Data");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Log Out
				msg="Log out of the web app";
				
				try {
					HomePage.clickOnLogOut();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Sign in as another use with job creation privileges
				msg="Log in as 'wmxuser'";
				
				try {
					LoginPage  lp = new LoginPage();
					lp.loginToApplication(xls.getCellData("en-us",2, 12), xls.getCellData("en-us", 3,12));	
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
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
				//On the Create panel
				msg = "Click on the left create button to expand the left panel";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Search for 'Extract Data'
				msg = "Seach for 'Extract Data'";

				try {
					Coordinate.clickCreateDefaultOfTemplatePresent("Extract Data");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//It should not be visible
				msg="Verify 'Extract Data' is not visible";
				
				try {
					if(Coordinate.selectTemplateFromList("Extract Data")) {
					CommonFunction.logStatus("FAIL", msg);
					}else {
						CommonFunction.logStatus("PASS", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

}
}
