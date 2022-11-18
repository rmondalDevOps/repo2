package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS89_ArcadeMenusSeleniumTestCase extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflowManager_ArcadeMenusSeleniumTestCase() {

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

		// Search For Arcade Symbols diagram
		msg = "Search For Arcade Symbols diagram";
		try {
			Design.enterSearchText("Arcade");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// click Edit Button
		msg = "click Edit Button";
		try {
			Design.clickOnEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// click Align Horizontally
		msg = "Align Horizontally";
		try {
			Design.clickOnAlignDiagramHorizontally();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the first step in the diagram, 'Start/End'
		msg = "Select the first step in the diagram, 'Start/End'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnStartEnd");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the User Prompt text box
		msg = "Cursor Hover to Arcade icon exists above the User Prompt text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Assert that in the Job Details panel, an Arcade icon exists above the User
		// Prompt text box
		msg = "Verified that in the Job Details panel, an Arcade icon exists above the User Prompt text box";
		try {
			Design.ArcadeIconExists("This input supports Arcade expressions");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon'
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on ExtendedProperties
		msg = "Click on ExtendedProperties";
		try {
			Design.clickExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Extended
		// Properties'
		msg = "Verified that a slider menu appears with all options when click on 'Extended Properties";
		try {
			Design.verifyDropDownExtendedlist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on JobExtendedProperty
		msg = "Click on JobExtendedProperty";
		try {
			Design.clickJobExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To verify that a slider menu disappears and the text appears in the
		// User Prompt
		msg = "Verified the slider menu disappears and the text appears in the User Prompt";
		try {
			Design.verifyTextAppears();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 2
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Global
		msg = " Click on Global";
		try {
			Design.clickGlobal();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify the options appear in the slider menu when click on Global
		msg = "Verified that a slider menu appears with all options when click on Global";
		try {
			Design.verifyDropDownGloblelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Back
		msg = "Click on Back Button";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickBack");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Job Properties
		msg = "Click on Job Properties";
		try {
			Design.clickJobProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify the options appear in the slider menu when click on Job Properties
		msg = "Verified that a slider menu appears with all options when click on Job Properties";
		try {
			Design.verifyDropDownJobPropertieslist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Back
		msg = "Click on Back Button";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickBack");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Location
		msg = "Click on Location";
		try {
			Design.clickLocation();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify the options appear in the slider menu when click on Location
		msg = "Verified that a slider menu appears with all options when click on Location";
		try {
			Design.verifyDropDownLocationlist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Back
		msg = "Click on Back Button";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickBack");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Portal
		msg = "Click on Portal";
		try {
			Design.clickPortal();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify the options appear in the slider menu when click on Portal
		msg = "Verified that a slider menu appears with all options when click on Portal";
		try {
			Design.verifyDropDownPortallist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Back
		msg = "Click on Back Button";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickBack");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Settings
		msg = "Click on Settings";
		try {
			Design.clickSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify the options appear in the slider menu when click on Settings
		msg = "Verified that a slider menu appears with all options when click on Settings";
		try {
			Design.verifyDropDownSettingslist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Back
		msg = "Click on Back Button";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickBack");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Work-flow
		msg = "Click on Workflow";
		try {
			Design.clickWorkflow();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify the options appear in the slider menu when click on Work-flow
		msg = "Verified that a slider menu appears with all options when click on Work-flow";
		try {
			Design.verifyDropDownWorkFlowlist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Back
		msg = "Click on Back Button";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickBack");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 3
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 3
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Outside the Diagram
		msg = "Click Outside the Diagram";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOutside_1280x760");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Select the Path leading out of the 'Start/End' step
		msg = "selecting the Path leading out of the 'Start/End' step";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickPath_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the radio button 'Arcade Expression'
		msg = "selecting the radio button 'Arcade Expression'";
		try {
			Design.clickOnRadioBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 4
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 4
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 4
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step, 'Add Comment'
		msg = "selecting the next step, 'Add Comment'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnAddComments");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 4
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 4
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 4
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 5
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 5
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 5
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Properties Tab
		msg = "Click on Properties Tab";
		try {
			Design.clickOnStepDetailPropertiesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step, 'Manual Step'
		msg = "selecting the next step, 'Manual Step'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnManual_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 6
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 6
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 6
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 6
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 6
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 6
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Properties Tab
		msg = "Click on Properties Tab";
		try {
			Design.clickOnStepDetailPropertiesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step, 'Question'
		msg = "selecting the next step, 'Question'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnQuestion_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 7
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 7
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 7
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 7
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 7
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 7
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Properties Tab
		msg = "Click on Properties Tab";
		try {
			Design.clickOnStepDetailPropertiesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step, 'Add Attachment'
		msg = "selecting the next step,'Add Attachment'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnAddAttachments_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 8
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 8
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 8
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 8
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 8
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 8
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Properties Tab
		msg = "Click on Properties Tab";
		try {
			Design.clickOnStepDetailPropertiesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step, 'Run GP Service'
		msg = "selecting the next step,'Run GP Service'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_RunGPService_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click On Panel Edit Button
		msg = "Click on Panel Edit Button";
		try {
			Design.clickOnPanelEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 9
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 9
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 9
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Cancel Using Tab in Step Arguments
		msg = "Click on Cancel Using Tab in Step Arguments";
		try {
			Design.clickOnTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 9
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 9
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 9
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on Properties Tab
		msg = "Click on Properties Tab";
		try {
			Design.clickOnStepDetailPropertiesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		/*
		 * // Click on Cancel in Step Arguments msg =
		 * "Click on Cancel in Step Arguments"; try {
		 * Design.clickOnCancelBtnInStepArguments(); CommonFunction.logStatus("PASS",
		 * msg); } catch (Exception e) { e.printStackTrace();
		 * CommonFunction.logStatus("FAIL", msg); } cfunction.sync(2);
		 */

		// Click on Align Diagram Vertically
		msg = "Click on Align Diagram Vertically";
		try {
			Design.clickOnAlignDiagramVertically();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step,'Update 1-M Job Properties'
		msg = "Selecting the next step,'Update 1-M Job Properties'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnUpdate1_M_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 10
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 10
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 10
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 10
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 10
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 10
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Properties Tab
		msg = "Click on Properties Tab";
		try {
			Design.clickOnStepDetailPropertiesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step,'Update Job Properties'
		msg = "Selecting the next step,'Update Job Properties'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnUpdateJobProperties_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 11
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 11
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 11
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 11
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 11
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 11
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Properties Tab
		msg = "Click on Properties Tab";
		try {
			Design.clickOnStepDetailPropertiesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step,'Open Web Page'
		msg = "Selecting the next step,'Open Web Page'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnOpenWebPage_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 12
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 12
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 12
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 12
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 12
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 12
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Properties Tab
		msg = "Click on Properties Tab";
		try {
			Design.clickOnStepDetailPropertiesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the next step,'Send Web Request'
		msg = "Selecting the next step,'Send Web Request'";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnSendWebRequest_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click On Panel Edit Button
		msg = "Click on Panel Edit Button";
		try {
			Design.clickOnPanelEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		/*
		 * // Cursor Hover to Arcade icon exists above the Step Help text box 13 msg =
		 * "Cursor Hover to Arcade icon exists above the Step Help text box"; try {
		 * SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip3");
		 * CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2);
		 */

		// Click on Arcade icon 13
		msg = "Click on Arcade icon";
		try {
			Design.clickOnArcadeIcon3();
			// SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnValue_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 13
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 14
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_HoverToValue_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 14
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ClickOnValue_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 14
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		/*
		 * // Remove the string '/:pathVariable' from the URL msg =
		 * "Remove the string '/:pathVariable' from the URL"; try {
		 * Design.clearURLFrmCofigureWebRequest(); CommonFunction.logStatus("PASS",
		 * msg); } catch (Exception e) { e.printStackTrace();
		 * CommonFunction.logStatus("FAIL", msg); } cfunction.sync(2);
		 */

		// Select the Authorization tab
		msg = "Select the Authorization tab";
		try {
			Design.clickOnAuthorizationBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on API Key radio button changed to DropDown

		msg = "Select API Key Dropdown";
		try {
			Design.clickOnApiKey("API Key");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * // Click on API Key radio button msg = "Click on API Key radio button"; try {
		 * Design.selectRadioButton("API Key"); //Design.clickOnApiKey();
		 * CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2);
		 */
		// Click on Arcade Icon button
		msg = "Click on Arcade Icon button";
		try {
			Design.clickOnArcadeIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 14
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade Icon button 2
		msg = "Click on Arcade Icon button 2";
		try {
			Design.clickOnArcadeIcon1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// To Verify that a slider menu appears when click on 'Arcade icon' 14
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select Bearer Token Dropdown
		msg = "Select Bearer Token Dropdown ";
		try {
			Design.clickOnApiKey("Bearer Token");
			// Design.clickOnBearerToken();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * // Click on Bearer Token radio button msg =
		 * "Click on Bearer Token radio button"; try {
		 * Design.selectRadioButton("Bearer Token"); //Design.clickOnBearerToken();
		 * CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2);
		 */

		// Cursor Hover to Arcade icon exists above the Step Help text box 14
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 14
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 14
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "Select Basic Auth Dropdown";
		try {
			Design.clickOnApiKey("Basic Auth");
			// Design.clickOnBasicAuth();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * // Click on Basic Auth radio button msg = "Click on Basic Auth radio button";
		 * try { Design.selectRadioButton("Basic Auth"); //Design.clickOnBasicAuth();
		 * CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2);
		 */
		// Click on Arcade Icon button
		msg = "Click on Arcade Icon button";
		try {
			Design.clickOnArcadeIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 14
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade Icon button
		msg = "Click on Arcade Icon button";
		try {
			Design.clickOnArcadeIcon1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 15
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the Headers tab
		msg = "Select the Headers tab";
		try {
			Design.clickOnHeadersBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// ClickOnCancelBtnInConfigureWebRequest
		msg = "Click On Cancel Btn In Configure Web Request";
		try {
			Design.clickOnCancelBtnInConfigureWebRequest();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Options Tab
		msg = "Click on Options Tab";
		try {
			Design.clickOnStepDetailOptionTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Cursor Hover to Arcade icon exists above the Step Help text box 3
		msg = "Cursor Hover to Arcade icon exists above the Step Help text box";
		try {
			SikuliHelp.hoveronLocationSikuli("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Arcade icon 3
		msg = "Click on Arcade icon";
		try {
			SikuliHelp.selectLocationOnSikuliClick("TS83_ArcadeToolTip");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Back button
		msg = "Click on Back button";
		try {
			Design.clickOnBack();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Save No
		msg = "Click on Save No";
		try {
			Design.clickOnSaveNo();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Job Templates
		msg = "Click on Job Templates";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		/*
		 * // Search For Arcade Symbols msg = "Search For Arcade Symbols"; try {
		 * Design.enterSearchText("Arcade Symbols"); Design.selectArcadeSymbols();
		 * CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2);
		 * 
		 */

		/*
		 * // Select Arcade Symbols msg = "Select Arcade Symbols"; try {
		 * Design.selectArcadeSymbols(); CommonFunction.logStatus("PASS", msg); } catch
		 * (Exception e) { e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2);
		 */

		// Select Automated Action
		msg = "Select Automated Action";
		try {
			Design.clickOnAutomatedAction();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select Web-hook Job Creation
		msg = "Select Webhook Job Creation";
		try {
			Design.selectWebhookJobCreation();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * // Select Web-hook Job Creation msg = "Select Webhook Job Creation"; try {
		 * Design.selectWebhookJobCreation(); CommonFunction.logStatus("PASS", msg); }
		 * catch (Exception e) { e.printStackTrace(); CommonFunction.logStatus("FAIL",
		 * msg); } cfunction.sync(2);
		 */
		// Click on Acrade Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnArcadeIcon2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Acrade Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnArcadeIcon3();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select Cancel on Create Web-hook
		msg = "Select Cancel on Create Web-hook";
		try {
			Design.clickOnCancelBtnInCreateWebhook();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Templates Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Acrade Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnArcadeIcon2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Acrade Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnArcadeIcon3();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Acrade Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnArcadeIcon4();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Acrade Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnArcadeIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Acrade Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnArcadeIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on Acrade Icon
		msg = "Click on Acrade Icon";
		try {
			Design.clickOnArcadeIcon1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// To Verify that a slider menu appears when click on 'Arcade icon' 3
		msg = "Verified that a slider menu appears with all options when click on Arcade icon";
		try {
			Design.verifyDropDownArcadelist();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

	}

}
