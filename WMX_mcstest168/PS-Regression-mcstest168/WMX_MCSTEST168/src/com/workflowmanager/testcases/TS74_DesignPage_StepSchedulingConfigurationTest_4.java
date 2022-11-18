package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS74_DesignPage_StepSchedulingConfigurationTest_4 extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS74_DesignPage_StepSchedulingConfigurationTest_4() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on Diagram in left menu
				msg = "Click on Diagram in left menu";
				try {
					Design.clickOnDiagramsIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Workflow Diagrams list populated with results";
				try {
					Design.getAllDiagramList();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				// Search for ' New test delete' workflow diagram in the list
				msg = "Search for "+diagramName+" workflow diagram in the list";
				try {
					Design.enterSearchText_Diagram(diagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);
				msg = "Click on Edit button";
				try {
					Design.clickOnEditBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Add a new "Manual Step"
				msg = "Add a new \"Manual Step\"";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS73_ManualStepB_1366x768");
					cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS15_bottombluearrow_1366x768");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter Step name as \"Manual Step C\"";
				try {
					Design.enterStepName("Manual Step C");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//In Step Details - Options tab choose "Run on a schedule" option.
				msg = "In Step Details - Options tab choose \"Run on a schedule\" option.";
				try {
					Design.clickOnStepDetailOptionTab();
					Design.clickOnRunOnScheduleExecutesBox();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The option is expanded and provides 3 options: Wait a period of time, Wait until a specific time and Wait until an exact time defined by an arcade expression.
				msg = "Verify Run On Schedule window expands";
				try {
					if(Design.verifyRunOnSceduleExpands())
					{
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click radio button on "Wait until a specific time".
				msg = "Click radio button on \"Wait until a specific time\".";
				try {
					Design.clickOnWaitUntilASpecificTimeRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The option is expanded and provides Time to run the step, as well as offset in minutes.
				//Open Time drop down list and choose "Day of Month"
				msg = "Open Time drop down list and choose \"Day of Month\"";
				try {
					Design.selectTimeFromDropDown("Day of Month");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The Day of Month is selected. The Day picker is available. The default time to run the step is 00:00.
				//Pick a day of month as "1" from the list
				
				//Set the run time to 5:00 
				msg = "Pick a time to run the step by opening the time picker: 5:00";
				try {
					Design.enterTimeInput("05:00");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Set Offset to 5
				msg = "Enter Offset=5";
				try {
					Design.enterMonthInput(2,"5");
					cfunction.sync(2);
					Design.clickOnWaitUntilASpecificTimeRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Save
				msg = "Click Save button";
				try {
					Design.clickOnSaveDiagramButton();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				
				
				
			
	}
}
