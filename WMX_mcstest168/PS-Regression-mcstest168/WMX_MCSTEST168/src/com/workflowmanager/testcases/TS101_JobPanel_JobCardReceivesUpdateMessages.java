package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS101_JobPanel_JobCardReceivesUpdateMessages {

	CommonFunction cfunction = new CommonFunction();

	String msg = "";

	public void workflow_TS101_JobPanel_JobCardReceivesUpdateMessages() throws InterruptedException {

		CommonFunction.waitforHomePagetoload();

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

		// Search Attachment_Selenium
		msg = "Search Attachment_Selenium";
		try {
			Design.enterSearchText_Diagram("Attachment_Selenium");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Duplicate Diagram
		msg = "Click on Duplicate Diagram";
		try {
			Design.duplicateTheTemplate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Attachment_Selenium - Copy
		msg = "Attachment_Selenium - Copy";
		try {
			Design.enterSearchText_Diagram("Attachment_Selenium - Copy");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Edit
		msg = "Click on Edit";
		try {
			Design.clickOnEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Activate
		msg = "Click Activate button";
		try {
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// Click Yes button of confirmation to Activate
		msg = "Click Yes button of confirmation to Activate";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Navigate to Work Page
		msg = "Navigate to Work Page";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Yes Click Yes button of confirmation to create job template
		msg = "Click Yes button of confirmation to create job template";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Create button
		msg = "Click Create button";
		try {
			WorkPage.clickCreateBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Search Templates Click On JobTemplate in Search Result
		msg = "Click On JobTemplate in Search Result";
		try {
			// WorkPage.clickOnJobTemplate("Execute GP Service");
			WorkPage.clickOnJobTemplate("Attachment_Selenium - Copy");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Details button
		msg = "Click Details button";
		try {
			WorkPage.clickExpandDetailsBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Edit Job Details
		msg = "Click Edit Job Details";
		try {
			WorkPage.clickEditJobDetails();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Select Drop-down on Priority
		msg = "Select Drop-down on Priority";
		try {
			WorkPage.selectPriorityDropDown("Medium");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Select Drop-down on Status
		msg = "Select Drop-down on Status";
		try {
			WorkPage.selectStatusDropDown("Ready");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Save in Edit Details
		msg = "Click Save in Edit Details";
		try {
			WorkPage.clickSaveIconInDetails();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Hover over to BELL icon
		msg = "Hover over to BELL icon";
		try {
			WorkPage.hoverToBellIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify Changes in Job Card 1
		msg = "Verify Changes in Job Card";
		try {
			WorkPage.verifyChangeInJobCard();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on BELL icon
		msg = "Click on BELL icon";
		try {
			WorkPage.clickOnBellIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Hover over to Edit icon in Details collapse panel
		msg = "Hover over to Edit icon in Details collapse panel";
		try {
			// SikuliHelp.hoveronLocationSikuli("TS97_HoverToEditIcon_1280x786");
			WorkPage.hoverToEditPencilIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Edit icon in Details collapse panel
		msg = "Click on Edit icon in Details collapse panel";
		try {
			WorkPage.clickOnEditPencilIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Change Job Card Name
		msg = "Change Job Card Name";
		try {
			WorkPage.enterInputJobCardName("JOB_8");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Save Icon
		msg = "Click on Save Icon";
		try {
			WorkPage.clickOnSaveFloppyIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);

		// Hover over to BELL icon
		msg = "Hover over to BELL icon";
		try {
			WorkPage.hoverToBellIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify Changes in Job Card 2
		msg = "Verify Changes in Job Card";
		try {
			WorkPage.verifyChangeInJobCard();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on BELL icon
		msg = "Click on BELL icon";
		try {
			WorkPage.clickOnBellIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Edit Job Details
		msg = "Click Edit Job Details";
		try {
			WorkPage.clickEditJobDetails();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click Assignment Drop-down list
		msg = "Click Assignment Dropdown list";
		try {
			WorkPage.selectAssignmentDropDown("WMX User");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
	/*	
		
		// Select Assignment Drop-down list
		msg = "Select Assignment  Dropdown list";
		try {
			SikuliHelp.hoveronLocationSikuli("TS101_HoverWMXUser_1280x768");
			cfunction.sync(3);
			SikuliHelp.sikuliClick("TS101_HoverWMXUser_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);
*/
		// Click on Save Icon
		msg = "Click on Save Icon";
		try {
			WorkPage.clickSaveIconInDetails();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify Job Card Assignment changed
		msg = "Verify Job Card Assignment changed";
		try {
			WorkPage.verifyJobCardChangeMsg();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Hover over to Assign to self icon
		msg = "Hover over to Assign to self icon";
		try {
			WorkPage.hoverAssignToSelfIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify Assign to self icon displayed
		msg = "Verify Assign to self icon displayed";
		try {
			WorkPage.verifyAssignIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on 'Assign to self' icon
		msg = "Click on 'Assign to self' icon";
		try {
			WorkPage.clickOnAssignToSelfIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify Job Card returns to original shape
		msg = "Verify Job Card returns to original shape";
		try {
			WorkPage.verifyChangeInJobCard1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		
		// Click on Start button
		msg = "Click on Start button";
		try {
			WorkPage.clickOnCollapseRightPane();
			WorkPage.clickOnStartBtn();
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Proceed button
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Drop-down from step
		msg = "Click on Drop-down from step";
		try {
			WorkPage.clickOnCollapseRightPane();
			//WorkPage.selectDropDownInJobCard("Linked_url_New");
			WorkPage.selectStepFromDrpdwn2("Linked_url_New");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify changes in drop-down reflects in Details tab
		msg = "Verify changes in drop-down reflects in Details tab";
		try {
			WorkPage.verifyDropdownReflectsInDetails();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Start button
		msg = "Click on Start button";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Proceed button
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Drop-down from step
		msg = "Click on Drop-down from step";
		try {
			//WorkPage.selectDropDownInJobCard("Linked_url_general");
			WorkPage.selectStepFromDrpdwn2("Linked_url_general");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify changes in drop-down reflects in Details tab
		msg = "Verify changes in drop-down reflects in Details tab";
		try {
			WorkPage.verifyDropdownReflectsInDetails();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

	}
}