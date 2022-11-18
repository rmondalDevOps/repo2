package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TC107_CreateVersionErrorMessages2 {
	CommonFunction cfunction = new CommonFunction();
	String msg = " ";

	public void workflowManager_TC107_CreateVersionErrorMessages2() {

		CommonFunction.waitforHomePagetoload();

		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		msg = "Click on Create Job Panel";
		try {
			WorkPage.clickCreateBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		msg = "Enter 'Create Version Error Message Test' in Search Textbox";
		try {
			Coordinate.enterSearchText("Create Version Error Message Test");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "Verify 'Create Version Error Message Test' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent("Create Version Error Message Test"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click the 'Create Version Error Message Test' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Create Version Error Message Test");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Verify New Job created successfully";
		try {

			if (Coordinate.verifySuccessMsg("successful"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(3);

		msg = "Click on Drop-down from step";
		try {
			WorkPage.selectStepFromDrpdwn2("Create Version 3");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		msg = "Click on 'Start Step' manually 2";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		msg = "Hover over to Error Icon";
		try {
			WorkPage.hoverErrorIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		msg = "Verify the Error Message";
		try {
			Design.verifyToolTipTextPresent1(
					"Could not create any versions. Job versions already exist for one or more data sources.");
			System.out.println("Result 1");
			Design.verifyToolTipTextPresent(
					"Could not create any versions. Job versions already exist for one or more data sources.");
			System.out.println("Result 2");
			Design.verifyTooltip();
			System.out.println("Result 3");
			Design.verifyToolTipText(
					"Could not create any versions. Job versions already exist for one or more data sources.");
			System.out.println("Result 4");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		msg = "Expand the Job Details panel as needed.";
		try {

			WorkPage.clickOnCollapseSummaryBtn();
			cfunction.sync(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "Click on the 'Diagram' tab.";
		try {
			WorkPage.clickOnDiagramAndMapTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "Verify the tab displays the selected job's diagram.";
		try {
			if (Coordinate.verifyDiagramVisibleOnDiagramAndMapTap()) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "Right click on the 'Edit Data' step";
		try {
			WorkPage.openPopWindow_inSelection();

			SikuliHelp.rightClickOnMap("TC107_RightClickCleanup_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "Verify the Set as current option is displayed.";
		try {
			if (WorkPage.verifySetAsCurrentOption2()) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "Choose Set as current.";
		try {
			WorkPage.clickOnSetAsCurrentBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		WorkPage.closePopWindow_inSelection();

		msg = "Click on 'Start Step' manually";
		try {
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

	}


}
