package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS88_UserDefinedSettings_Selenium extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflowManager_UserDefinedSettings_Selenium() {

		// Click on Design
		msg = "Clicked on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Settings
		msg = "Clicked on Settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on UserDefinedTabPanel
		msg = "Clicked on UserDefinedTabPanel";
		try {
			Design.clickOnUserDefinedTabPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Add Settings Step 1
		msg = "Clicked on Add Settings";
		try {
			Design.clickOnAddSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify Save Button Disabled
		msg = "Verified Save Button Disabled";
		try {
			Design.verifySaveBtnDisabled();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Outside the name text Box
		msg = "Clicked on Outside the name text Box";
		try {
			Design.clickOnOutsideBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify Name text box is highlighted in red with a red warning icon
		msg = "Verified the Name text box is highlighted in red with a red warning icon";
		try {
			Design.verifyErrorTextbox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Tool tip
		msg = "Cursor Hover to Tooltip";
		try {
			SikuliHelp.hoveronLocationSikuli("HoverOnMissingText");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify Tool tip Message 1
		msg = "Verified Missing required value";
		try {
			Design.verifyTooltip();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter invalid Text in NameTextbox
		msg = "Enter invalid Text in NameTextbox";
		try {
			Design.enterInputName("plain text");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter Valid Text in ValueTextbox
		msg = "Enter Valid Text in ValueTextbox";
		try {
			Design.enterInputValue("test text");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Tool tip
		msg = "Invalid characters.The field can only contain alphanumeric characters or underscore";
		try {
			SikuliHelp.hoveronLocationSikuli("HoverOnMissingText_2");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify Tool tip Message 2
		msg = " Verified Invalid characters.The field can only contain alphanumeric characters or underscore";
		try {
			Design.verifyTooltip2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Changing Invalid Text in NameTextbox
		msg = "Changing Invalid Text in NameTextbox";
		try {
			Design.enterInputName("plain_text");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Add Settings Step 2
		msg = "Click on Add Settings";
		try {
			Design.clickOnAddSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify A second row appears with text boxes under 'Name', 'Value', and
		// 'Encrypt'.
		msg = "Verified A second row appears with text boxes under 'Name', 'Value', and 'Encrypt'";
		try {
			SikuliHelp.verifyImageExists("VerifyNewRow");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter Valid Text1 in NameTextbox
		msg = "Enter Valid Text1 in NameTextbox";
		try {
			Design.enterInputName1("encrypted_text");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter Valid Text1 in ValueTextbox
		msg = "Enter Valid Text1 in ValueTextbox";
		try {
			Design.enterInputValue1("test text");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Encrypt Button
		msg = "Click on Encrypt Button";
		try {
			Design.clickOnEncryptBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		// To Verify Encrypt Text '*****' is Appeared
		msg = "Verified Encrypt Text '*****' is Appeared";
		try {
			SikuliHelp.verifyImageExists("EncryptTextVerify");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Save Button
		msg = "Click on Save Button";
		try {
			Design.clickOnSaveBtn2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify Saved Successfully Pop-up
		msg = "Verified Saved Successfully Pop-up ";
		try {
			Design.verifySaveSuccessPopup();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Add Settings Step 3
		msg = "Click on Add Settings";
		try {
			Design.clickOnAddSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter valid Text2 in NameTextbox
		msg = "Enter valid Text2 in NameTextbox";
		try {
			Design.enterInputName2("test_text");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter Valid Text2 in ValueTextbox
		msg = "Enter Valid Text2 in ValueTextbox";
		try {
			Design.enterInputValue2("test text");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Navigate to Diagram icon
		msg = "Navigate to Diagram icon";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify Save Pop-up Appeared
		msg = "Verified Save Pop-up Appeared";
		try {
			Design.verifySavePopup();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click On Save No
		msg = "Click On Save No";
		try {
			Design.clickOnSaveNo();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Navigate to Settings
		msg = "Navigate to Settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Navigate to UserDefinedTabPanel
		msg = "Navigate to UserDefinedTabPanel";
		try {
			Design.clickOnUserDefinedTabPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify Saved Text is Appeared
		msg = "Verified Saved Text is Appeared";
		try {
			SikuliHelp.verifyImageExists("VerifySavedText");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To hover Delete icon 1
		msg = "To hover Delete icon";
		try {
			SikuliHelp.hoveronLocationSikuli("TS82_DeleteIcon_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To click Delete icon 1
		msg = "To click Delete icon 1 row";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS82_ClickDeleteIcon_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click On Delete yes 1
		msg = "Click On delete yes";
		try {
			Design.clickOnDeleteYes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		// To hover Delete icon 2
		msg = "To hover Delete icon";
		try {
			SikuliHelp.hoveronLocationSikuli("TS82_DeleteIcon2_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To click Delete icon 2
		msg = "To click Delete icon 2 row";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS82_ClickDeleteIcon_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click On Delete yes 2
		msg = "Click On delete yes";
		try {
			Design.clickOnDeleteYes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

	}

}
