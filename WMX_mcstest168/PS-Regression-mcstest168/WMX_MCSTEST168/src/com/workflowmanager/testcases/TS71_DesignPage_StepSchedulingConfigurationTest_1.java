package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS71_DesignPage_StepSchedulingConfigurationTest_1 extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	
	public void workflow_TS71_DesignPage_StepSchedulingConfigurationTest_1() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Design
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
				//Click on create new button
				msg = "Click on Create New button";
				try {
					Design.clickOnCreateNewBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
						//Enter Diagram Name
						msg = "Enter diagram name as '"+diagramName+"'";
						try {
							Design.enterDiagramName(diagramName);
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						//Enter Diagram description
						msg = "Enter diagram description as 'Sample description'";
						try {
							Design.enterDiagramDescription("Test Description");
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		
		 //A new diagram should open with a single step on the canvas
		//Click the 'Start/End' step 
				msg = "Click the 'Start/End' step";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS15_stepEnd_1366x768");
					/*cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS15_bottombluearrow_1366x768");*/
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
		//Click radio button on "Wait a period of time".
				msg = "Click radio button on \"Wait a period of time.\"";
				try {
					Design.clickOnWaitAPeriodOfTimeRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The option is expanded and provides Time in Month, Hours and Minutes, as well as offset in minutes.
		//Enter Month = 13 (not picking from the arrow) and move away the cursor
				msg = "Enter Month=13";
				try {
					Design.enterMonthInput(1,"13");
					cfunction.sync(2);
					Design.clickOnWaitAPeriodOfTimeRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Any Month greater than 13 is not accepted and automatically reset to 12.
				msg = "Verify Month greater than 12 is not accepted and automatically reset to 12.";
				try {
					if(Design.verifyInputValueOfMonth("12"))
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
		//Enter Day = 32 (not picking from the arrow) and move away the cursor
				msg = "Enter Day=32";
				try {
					Design.enterDayInput("32");
					cfunction.sync(2);
					Design.clickOnWaitAPeriodOfTimeRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Any Day greater than 31 is not accepted and automatically reset to 31.
				msg = "Verify Day greater than 31 is not accepted and automatically reset to 31.";
				try {
					if(Design.verifyInputValueOfDay("31"))
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
		//Enter Hour = 24 (not picking from the arrow) and move away the cursor
				msg = "Enter Hours=24";
				try {
					Design.enterHoursInput("24");
					cfunction.sync(2);
					Design.clickOnWaitAPeriodOfTimeRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Any Hour greater than 23 is not accepted and automatically reset to 23.
				msg = "Verify Hours greater than 23 is not accepted and automatically reset to 23.";
				try {
					if(Design.verifyInputValueOfHours("23"))
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
		//Enter Minute = 60 (not picking from the arrow) and move away the cursor
				msg = "Enter Minute=60";
				try {
					Design.enterMinuteInput("60");
					cfunction.sync(2);
					Design.clickOnWaitAPeriodOfTimeRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Any Minute greater than 59 is not accepted and automatically reset to 59.
				msg = "Verify Minute greater than 59 is not accepted and automatically reset to 59.";
				try {
					if(Design.verifyInputValueOfMinute("59"))
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
		//Enter Offset = 11 (not picking from the arrow) and move away the cursor
				msg = "Enter Offset=301";
				try {
					Design.enterOffsetInput("301");
					cfunction.sync(2);
					Design.clickOnWaitAPeriodOfTimeRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Any Offset greater than 10 is not accepted and automatically reset to 10.
				msg = "Verify Offset greater than 300 is not accepted and automatically reset to 300.";
				try {
					if(Design.verifyInputValueOfOffest("300"))
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
