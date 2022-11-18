package com.workflowmanager.testcases;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.WorkPage;

public class TS106_JobPanelDiagramUIUpdate extends TestBase  {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	
	public void workflow_TS106_JobPanelDaigramUIUpdate() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
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
		msg = "Hover the cursor over the toggle";
		try{
			WorkPage.hoverCreateBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		cfunction.sync(2);
		msg = "Click the toggle";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Type \"Job Panel Update\" in to the search bar in the panel";
		try {
			WorkPage.enterTemplateNameInSearch("Job Panel Update");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on the \"Job Panel Update\" job template";
		try {
			if(WorkPage.clickOnJobTemplate("Job Panel Update")) {
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
		msg = "Click to the newly created "+ jobName +" job in the Job Tile list";
		try {
			if(WorkPage.clickOnJobDetails(jobName)) {
				WorkPage.clickOnCollapseRightPane();
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
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
		msg = "Right click on the 'Add attachment' step";
		try {
			
			//WorkPage.openPopWindow_inSelection();
			SikuliHelp.rightClickOnMap("TS106_clickonaddattachment");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Choose Set as current.";
		try {
			WorkPage.clickOnSetAsCurrentBtn();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on properties tab";
		try {
			WorkPage.clickOnProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on edit details";
		try {
			Coordinate.clickEditJobDetail();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Assign job to Organizational_1_WMX Role user";
		try {
			Coordinate.selectAssignedUserFromDropdown1("Organizational_1_WMX Role");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "save user assigned";
		try {
			Coordinate.clickSaveEditJobDetail();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		msg = "Click on the 'Diagram' tab.";
		try {
			WorkPage.clickOnDiagramAndMapTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify new assignment is displayed on current step";
		try {
			if(SikuliHelp.verifyImageExists("TS106_verifyAssignaddattachment")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on properties tab";
		try {
			WorkPage.clickOnProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on edit details";
		try {
			Coordinate.clickEditJobDetail();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Reassign job to current user";
		try {
			Coordinate.selectAssignedUserFromDropdown("admin admin");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "save user assigned";
		try {
			Coordinate.clickSaveEditJobDetail();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		msg = "Click on the 'Diagram' tab.";
		try {
			WorkPage.clickOnDiagramAndMapTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "Click on the maximaize diagram window.";
		try {
			WorkPage.openPopWindow_inSelection();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "Right click on the 'Add attachment' step";
		try {
			
			//WorkPage.openPopWindow_inSelection();
			SikuliHelp.rightClickOnMap("TS106_clickOnAddAttachment2");
			CommonFunction.logStatus("PASS", msg);
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
		msg = "Close maximize diagram window.";
		try {
			WorkPage.closePopWindow_inSelection();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on properties tab";
		try {
			WorkPage.clickOnProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on edit details";
		try {
			Coordinate.clickEditJobDetail();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Assign job to Organizational_1_WMX Role user";
		try {
			Coordinate.selectAssignedUserFromDropdown1("Organizational_1_WMX Role");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "save user assigned";
		try {
			Coordinate.clickSaveEditJobDetail();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		msg = "Click on the 'Diagram' tab.";
		try {
			WorkPage.clickOnDiagramAndMapTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on the maximaize diagram window.";
		try {
			WorkPage.openPopWindow_inSelection();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify new assignment is displayed on current step";
		try {
			if(SikuliHelp.verifyImageExists("TS106_verifyAssignAttachment2")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		
	}

}
