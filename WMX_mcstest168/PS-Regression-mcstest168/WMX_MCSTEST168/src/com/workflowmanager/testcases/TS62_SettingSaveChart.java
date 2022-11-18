package com.workflowmanager.testcases;
import java.util.ArrayList;

import org.openqa.selenium.By;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS62_SettingSaveChart extends TestBase {
	CommonFunction cfunction = new CommonFunction();

	String msg = "";
	public void workflow_TS62_SettingSaveChart() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();

		/*// 1Log into the web app as admin user
		cfunction.sync(10);
		try {
			LoginPage  lp = new LoginPage();
			//lp.loginToApplication1(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));
			lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));
			//CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(10);

		//Go to Design 
		msg = "Click on Design Tab";
		try {
			CommonFunction.waitforHomePagetoload();
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//Go to Job Templates
		msg = "Click on setings  Tab";
		try {
			CommonFunction.waitforHomePagetoload();
			Design.clickOnSettingsSide();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//Go to Shared Charts
		msg = "Click on ' Shared Charts' Tab";
		try {
			CommonFunction.waitforHomePagetoload();
			Design.clickOnSharedChartTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//Create new chart
		cfunction.sync(10);
		msg = "Click Create new chart";
		try {
			Design.clickCreateNewSharedChartsBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//Enter the new chart's name as 'Job Assignment Chart'
		cfunction.sync(10);
		msg = "Enter the new chart's name as Job Assignment Chart";
		try {
			Design.enterSearchTextChartName("Job Assignment Chart");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Verify The chart's name is entered
		cfunction.sync(10);
		msg = "Verify The chart's name is entered";
		try {
			if (Design.verifyChartName("Job Assignment Chart"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//Enter Display field = assignedTo
		cfunction.sync(10);
		msg = "Enter Display field = assignedTo";
		try {
			Design.enterSearchTextDisplayField("assignedTo");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Verify The chart's name is entered
		cfunction.sync(10);
		msg = "Verify Display field = assignedTo";
		try {
			if (Design.verifyDisplayField("assignedTo"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//Enter Display Name = Job Assignment
		cfunction.sync(10);
		msg = "Enter Display Name = Job Assignment";
		try {
			Design.enterSearchTextDisplayName("Job Assignment");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Verify The chart's name is entered
		cfunction.sync(10);
		msg = "Verify Display Name = Job Assignment";
		try {
			if (Design.verifyDisplayName("Job Assignment"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//Sort direction = ascending
		msg = "Sort direction = ascending";
		try {
			Design.selectSortDirectionFromDropdown("ascending");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Verify Sort direction = ascending
		msg = "Verify Sort direction = ascending";
		try {
			if(Design.verifySortDirectionFromDropdown("ascending"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//Choose color ramp from the drop down list = Deep Ocean
		msg = "Click color ramp";
		try {
			Design.clickColorDroDownBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//Choose color ramp from the drop down list = Deep Ocean
		msg = "Choose color ramp from the drop down list = Deep Ocean";
		try {
			Design.selectColorDroDownBtn("Deep Ocean");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//The chosen color ramp preview is displayed
		msg = "Verify The chosen color ramp preview is displayed";
		try {
			if(Design.verifySelectedColorDroDown("Deep Ocean")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//Share chart with = Everyone
		msg = "Click Share chart with = Everyone";
		try {
			Design.selectShareChartWithEveryone("Everyone");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*cfunction.sync(10);
		//The sort direction is as chosen
		msg = "Verify the tab displays the selected job's diagram.";
		try {
			if(Coordinate.verifyDiagramVisibleOnDiagramAndMapTap()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(10);

		//Save the new chart.
		msg = "Save the new chart.";
		try {
			Design.clickOnSaveBtnSharedChart();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//The new chart is saved and by default inserted to the last in the list.
		msg = "Verify The new chart is saved and by default inserted to the last in the list.";
		try {
			if(Design.verifyChartNamePositionLast("Job Assignment Chart")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//Reorder the newly saved chart to the top of the list.
		msg = "Reorder the newly saved chart to the top of the list.";
		/*if (browser.equalsIgnoreCase("firefox")) {
			try{
				cfunction.Commmon_Click("xpath", "(//calcite-button[@type='button' and @class='p-element col-1 t-displayField-upBtn visible-when-selected'])[4]");
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}}
			else{
			*/try {
			//SikuliHelp.dragNDrop("TS62_DragJobAssignment1_1280x768_FF", "TS62_DragJobAssignment1_1280x768_To_FF");
			//SikuliHelp.dragNDrop("TS62_DragJobAssignment1_1280x768_New", "TS62_DragJobAssignment1_1280x768_To_New");
				//cfunction.CommmonJS_Click_ShadowPath("document.querySelector('#pr_id_4-table > tbody > div.p-element.c-cardList__card.t-cardList__card.selected.ng-star-inserted > div > calcite-button.p-element.col-1.t-displayField-upBtn.visible-when-selected').shadowRoot.querySelector('button')");
				cfunction.Commmon_Click("xpath", "(//calcite-button[@type='button' and @class='p-element col-1 t-displayField-upBtn visible-when-selected'])[4]");
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//This enables Save and Discard changes buttons.
		msg = "This enables Save button";
		try {
			Design.verifySaveButtonEnable();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//This enables Discard changes buttons.
		msg = "This enables Discard changes buttons.";
		try {
			Design.verifyDiscardBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//Click Discard changes.
		msg = "Click Discard changes.";
		try {
			Design.clickDiscardBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		/*//The reorder change is reverted.
		msg = "The reorder change is reverted.";
		try {
			//if(Design.verifyChartNamePositionLast("Job Assignment Chart")) {
			if(Design.verifyChartNamePosition("Job Assignment Chart", 4)) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/

		cfunction.sync(10);
		//The new chart is saved and by default inserted to the last in the list.
		msg = "Verify The new chart is saved and by default inserted to the last in the list.";
		try {
			if(Design.verifyChartNamePositionLast("Job Assignment Chart")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//Update the Share chart with = group 
		msg = "Update the Share chart with = group";
		try {
			Design.selectShareChartWithGroup("group");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		// check on "Administrator_wmx_ReadyAPI_test"
		msg = " check on Administrator_wmx_ReadyAPI_test";
		try {
			Design.selectGroupItem("Administrator_wmxuser_ReadyAPI_Tests");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//Reorder the newly saved chart to the top of the list.This enables Save and Discard changes buttons.
		cfunction.sync(10);
		//Reorder the newly saved chart to the top of the list.
		msg = "Reorder the newly saved chart to the top of the list.";
		/*if (browser.equalsIgnoreCase("firefox")) {
			try{
				cfunction.Commmon_Click("xpath", "(//calcite-button[@class='p-col-1 t-displayField-upBtn visible-when-selected'])[4]");
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}}
			else{
			*/try {
			//SikuliHelp.dragNDrop("TS62_DragJobAssignment1_1280x768_FF", "TS62_DragJobAssignment1_1280x768_To_FF");
			//SikuliHelp.dragNDrop("TS62_DragJobAssignment1_1280x768_New", "TS62_DragJobAssignment1_1280x768_To_New");
			//cfunction.CommmonJS_Click_ShadowPath("document.querySelector('div.p-datatable-wrapper>table>tbody>div:nth-child(5)>div>calcite-button:nth-child(2)').shadowRoot.querySelector('button')");
			cfunction.Commmon_Click("xpath", "(//calcite-button[@type='button' and @class='p-element col-1 t-displayField-upBtn visible-when-selected'])[4]");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(10);
		cfunction.sync(10);
		//This enables Save and Discard changes buttons.
		msg = "This enables Save button";
		try {
			Design.verifySaveButtonEnable();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//This enables Discard changes buttons.
		msg = "This enables Discard changes buttons.";
		try {
			Design.verifyDiscardBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		/*cfunction.sync(10);
		//Click Discard changes.
		msg = "Click Discard changes.";
		try {
			Design.clickDiscardBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/

		/*//The reorder change is reverted.
		msg = "The reorder change is reverted.";
		try {
			if(Design.verifyChartNamePosition("", 4)) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/

		/*cfunction.sync(10);
		//The new chart is saved and by default inserted to the last in the list.
		msg = "Verify The new chart is saved and by default inserted to the last in the list.";
		try {
			if(Design.verifyChartNamePositionLast("Job Assignment Chart")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/

		cfunction.sync(10);
		//Save the edits.
		msg = "Save the edits.";
		try {
			Design.clickOnSaveBtnSharedChart();
			//Design.clickOnDataEditsSample();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(15);
		//Save the edits.
		msg = "click on Yes";
		try {
			Design.clickYesOnConfirmDialogSharedCharts();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//cfunction.sync(10);
		//TThe new chart now is shared with only Administrator_wmx_ReadyAPI_test group and reordered to the top in the list.
		msg = "Verify The new chart now is shared with only Administrator_wmx_ReadyAPI_test group and reordered to the top in the list.";
		//The reorder change is reverted.
		//msg = "The reorder change is reverted.";
		try {
			if(Design.verifyChartNamePosition("Job Assignment Chart", 1)) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}


		cfunction.sync(10);
		//Choose color ramp from the drop down list = Deep Ocean
		msg = "Click color ramp";
		try {
			Design.clickColorDroDownBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//Choose color ramp from the drop down list = Default
		msg = "Choose color ramp from the drop down list = Default";
		try {
			Design.selectColorDroDownBtn("Default");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(10);
		//This enables Discard changes buttons.
		msg = "This enables Discard changes buttons.";
		try {
			Design.verifyDiscardBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		/*cfunction.sync(10);
		//Click Discard changes.
		msg = "Click Discard changes.";
		try {
			Design.clickDiscardBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/

		cfunction.sync(2);
		//Click on another chart "My Job Status Chart" in the list 
		msg = "Click on another chart Job Status Chart in the list ";
		if(browser.equalsIgnoreCase("firefox")) {
			try {
				cfunction.Commmon_Click("xpath", "(//div[@class='p-element c-cardList__card t-cardList__card ng-star-inserted'][2]//div//div//span)[3]");
				CommonFunction.logStatus("PASS", msg);
			} catch(Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		}
		else {
		try {
			if(Design.SelectChartNameInList("Job Status Chart")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		}
		cfunction.sync(2);
		/*cfunction.sync(10);
		//The prompt of saving the unsaved edits pops up.
		msg = "The prompt of saving the unsaved edits pops up.";
		try {
			if(Design.checkSavePrompt("")) {
				CommonFunction.logStatus("PASS", msg);
			}else  {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		//cfunction.sync(10);
		//Click No to not save the edit of color ramp.
		msg = "Click No to not save the edit of color ramp.";
		try {
			Design.clickOnNo();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*cfunction.sync(10);
		//The chart dialog is refreshed to display "My Job Status Chart"
		msg = "The chart dialog is refreshed to display Job Status Chart";
		try {
			Design.verifyDialogueBoxName("Job Status Chart");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);
		//Click on "Job Assignment Chart" to open the dialog. 
		msg = "Click on Job Assignment Chart to open the dialog.";
		try {
			Design.ClickChartNameInList("Job Assignment Chart");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the color ramp is still Deep Ocean.
		msg = "Verify the color ramp is still Deep Ocean.";
		try {
			if(Design.verifySelectedColorDroDown("Deep Ocean")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);

		}

	}
}
