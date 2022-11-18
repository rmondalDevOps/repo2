package com.workflowmanager.testcases;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
//import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;

public class TS31_WorkPageCreateJob extends TestBase{
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName=cfunction.getUniqueName("New test delete");
	String expectedCalendarUI= "TS29_CalendarGUI.png";
	public void workflow_TS31_WorkPageCreateJob() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Work Tab
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify Work tab is opened. 
		msg = "Verify Work tab is opened";
		try {
			if(WorkPage.verifyWorkTabOpen())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Hover the cursor over the toggle
		msg = "Hover the cursor over the toggle";
		try{
				WorkPage.hoverCreateBtn();
				/*String collapse_Btn ="TS31_CollapseBtn2";
			SikuliHelp.hoveronLocationSikuli(collapse_Btn);*/
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		cfunction.sync(2);
		
		//A tooltip should appear "Expand Left Panel"
		msg = "Verify A tooltip should appear \"Expand Left Panel\"";
		try {
			WorkPage.verifyToolTip();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Click the toggle
		msg = "Click the toggle";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The create jobs panel should appear
		msg = "Verify The create jobs panel should appear";
		try {
			if(WorkPage.verifyCreateJobPanelVisible()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Type "Survey" in to the search bar in the panel
		msg = "Type \"Survey\" in to the search bar in the panel";
		try {
			WorkPage.enterTemplateNameInSearch("Survey");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//The Survey Workflow job template should appear
		msg = "The \"Survey Workflow\" job template should appearl";
		try {
			if(WorkPage.verifyJobTemplatePresent("Survey Workflow")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		
		//Click the tile
		msg = "Click on the \"Survey Workflow\" job template";
		try {
			if(WorkPage.clickOnJobTemplate("Survey Workflow")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);
		//toast notification should appear in the top right indicating job creation
		msg = "Verify toast notification should appear in the top right indicating job creation";
		try {
			String msg1="successfully";
			Design.verifySuccessMsg(msg1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click the toggle
		msg = "Click the toggle";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//A search for the newly created job should have been performed, such that it is the only one visible
		msg = "Click to the newly created"+ jobName +" job in the Job Tile list";
		try {
			WorkPage.clickOnJobDetails(jobName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The new job should be selected
		
		
	//	The Create jobs panel should collapse
		msg = "Verify The Create jobs panel should collapse";
		try {
			
			if(WorkPage.verifyJobTemplateListVisible()) {
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

	}
}
