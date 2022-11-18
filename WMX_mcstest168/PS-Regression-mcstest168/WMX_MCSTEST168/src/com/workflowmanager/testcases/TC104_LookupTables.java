package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TC104_LookupTables extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = " ";

	public void workflowManager_TC104_LookupTabels() {

		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click on Templates";
		try {
			Design.clickOnTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click on LookUp Tables";
		try {
			Design.clickOnLookupTables();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify the Lookup Tables list includes 'Status Types'";
		try {
			Design.verifyStatusTypes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify the Lookup Tables list includes 'Priorities'";
		try {
			Design.verifyPriorities();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify Status Types are visible on the right";
		try {
			Design.verifyStatusTypesVisibleRight();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click 'Add Status Type'";
		try {
			Design.clickOnAddStatusType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify new input box should appear";
		try {
			Design.verifyNewInputBoxAppear();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click in the input box";
		try {
			Design.clickInputBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click outside the box";
		try {
			Design.clickoutsideBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify It should become outlined in red";
		try {
			Design.verifyBoxOutlineRed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Hover over the 'i' ";
		try {
			Design.hoverOnI();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify 'Missing required value' should appear as a tooltip";
		try {
			Design.verifyToolTipText("Missing required value");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Enter Input 'Under Review'";
		try {
			Design.enterInputText("Under Review");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify Save and Discard Changes buttons should become enabled";
		try {
			Design.verifySaveBtnEnabled();
			cfunction.sync(3);
			Design.verifyDiscardBtnEnabled();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click the 'Reorder' button and drag the new status up a couple of spots";
		try {
			Design.reorder();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click on Save";
		try {
			Design.clickOnSaveBtnStatusType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify ' Lookup table updated successfully ' success message";
		try {
			Design.verifySuccessTooltipMsg(" Lookup table updated successfully ");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click the 'Reorder' button and drag the new status up a couple of spots again";
		try {
			Design.reorder1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click 'Discard Changes'";
		try {
			Design.clickDiscardBtnStatusType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click 'Priorities' on the left";
		try {
			Design.clickOnPriorities();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "To verify Priorities is displayed,values and ranks";
		try {
			Design.verifyPrioritiesValues();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Delete 'Medium' ";
		try {
			Design.clickOnDeleteBtnInPriorities();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify 'Medium'is gone from the list";
		try {
			Design.verifyDeletedRowDisable();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click 'Discard Changes' 2 ";
		try {
			Design.clickDiscardBtnStatusType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify 'Medium' has been added to the list";
		try {
			Design.verifyDeletedRowEnabled();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click 'Add Priority'";
		try {
			Design.clickOnAddPriority();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);
		
		msg = "Type in 'Medium' and set the rank to '5'";
		try {
			Design.enterInputText2("Medium");
			cfunction.sync(3);
			Design.enterInputText3("5");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);
		
		msg = "Verify the Error Message 'Value must be unique'";
		try {
			Design.hoverOnI();
			cfunction.sync(3);
			Design.verifyToolTipText("Value must be unique");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);
		
		msg = "Type in 'Medium High' and set the rank to '6'";
		try {
			Design.enterInputText2("Medium High");
			cfunction.sync(3);
			Design.enterInputErrorText("6");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click on Save";
		try {
			Design.clickOnSaveBtnStatusType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify the list rearranges to be sorted properly";
		try {
			Design.verifyRearrange();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

	}
}
