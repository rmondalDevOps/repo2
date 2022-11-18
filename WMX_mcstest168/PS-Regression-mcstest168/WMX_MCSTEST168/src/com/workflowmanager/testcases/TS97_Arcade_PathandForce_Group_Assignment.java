/**
 * 
 */
package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

/**
 * @author arp97661
 *
 */
public class TS97_Arcade_PathandForce_Group_Assignment extends TestBase {

	
	CommonFunction cfunction = new CommonFunction();
	String msg= "";
	
	public void workflow_TS97_Arcade_PathandForce_Group_Assignment(){
		
		cfunction.waitforpagetoload();
		//Click on Design Page
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Click on Diagram in left menu
		msg = "Click on Diagram in left menu";
		try {
			cfunction.sync(12);
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Enter "create" in Search Textbox
		String searchText = "Data Edits Sample";
		msg = "Enter '"+ searchText +"' in Search Textbox";
		try {
			Design.enterSearchText_Diagram(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		
		//Click on edit button
		msg = "Click on Edit button";
		try {
			Design.clickOnEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on the path between 'Check LOI' and 'Define AOI'";
		try{
			SikuliHelp.sikuliClick("TS97_clickLOI_AOIx1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Check 'Force Group Assignment' checkbox is disabled";
		try {
			
			if(Design.verifyCheckBoxDisable()==true) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Select 'Arcade Expression' from dropdown";
		try {
			Design.selectPublicAssgn("Arcade");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Select 'Group' radiobutton";
		try {
			Design.selectGroupRadioButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Check 'Force Group Assignment' checkbox is enabled";
		try {
			
			if(Design.verifyCheckBoxEnable()==true) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Select 'Selection' from dropdown";
		try {
			Design.selectPublicAssgn("Selection");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		msg = "Select 'AarthiDwarakanath' group from dropdown";
		try {
			Design.selectPublicAssgnValue("AarthiDwarakanath");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg ="Check on 'Force Group Assignment'";
		try {
			Design.selectCheckBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Activate the Diagram";
		try {
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		}  catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "A toast message is popped - Diagram activated successfully.";
		String successMsg1 = "successfully";
		try {
			if (Design.verifySuccessMsg1(successMsg1))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Create a new job by clicking on a job  in the left panel. 
		msg = "Click on the left create button to expand the left panel";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on template to create job Data Edits Sample
		//String Jobname="Path arcade test";
		msg = "Click on Data Edits Sample template to a create job";
		
		try {
			Coordinate.clickCreateDefaultOfTemplatePresent("Data Edits Sample");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);
		// 'Job created successfully should appear in a toast notification
		msg = "Verify Job should be created successfully";

		try {
			String successMsg = "successfully";
			Coordinate.verifySuccessMsg(successMsg);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		msg = "Open the Job Panel on the right";
		try {
			WorkPage.clickOnCollapseSummaryBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Current Assignment is to admin admin";
		try {
			if(WorkPage.checkJobAssignedTo("//div[contains(@class,'content t-jobAssignedTo')]","admin admin")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}
		catch (Exception e) {
		e.printStackTrace();
		CommonFunction.logStatus("FAIL", msg);
		}
					
		msg = "Run \"Start Step\" step for the job";
		try {
			if(WorkPage.clickOnStartStepOfJob(jobName)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Proceed button";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Change current step to 'Define AOI'";
		try {
			WorkPage.selectStep("Define AOI");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		msg = "Current Assignment is to admin admin";
		try {
			if(WorkPage.checkJobAssignedTo("//span[contains(@class,'content t-jobAssignedTo')]","AarthiDwarakanath")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}
		catch (Exception e) {
		e.printStackTrace();
		CommonFunction.logStatus("FAIL", msg);
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
