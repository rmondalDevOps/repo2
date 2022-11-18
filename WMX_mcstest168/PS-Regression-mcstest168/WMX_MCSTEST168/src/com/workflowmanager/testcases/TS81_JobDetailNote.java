package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;


public class TS81_JobDetailNote extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS81_JobDetailNote() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		
		
		//Click on Work
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
		msg = "Type \"Data Edits Sample\" in to the search bar in the panel";
		try {
			WorkPage.enterTemplateNameInSearch("Data Edits Sample");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on the \"Data Edits Sample\" job template";
		try {
			if(WorkPage.clickOnJobTemplate("Data Edits Sample")) {
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
		// In Job List click on job "Medium Priority Data Extraction"
		/*msg = "Select job \"Data Edits 12\" from Job List";
		try {
			if(WorkPage.clickOnJobDetails("Data Edits 12")) {
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
		// The Job Details panel has title as job name.
		*/msg = "Verify the Job Details panel has title as job name.";
		try {
			if (Coordinate.verifyJobNameAtInfoPanel(jobName)) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*msg = "Click on properties tab";
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
		msg = "Assign job to wmx user";
		try {
			Coordinate.selectAssignedUserFromDropdown("WMX User");
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
		*/// click on edit button.
		msg = "click on edit button in details";
		try {
			WorkPage.clickOnEditAttributes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "click on edit notes";
		try {
			WorkPage.clickOnNote();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "enter text for notes text area";
		String text = "this is a sample text";
		try {
			WorkPage.textForNoteTextArea(text);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on another tab in details";
		try {
			WorkPage.clickOnComments();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "Switch back to notes tab";
		try {
			WorkPage.clickOnEditAttributes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "enter text for notes text area";
		String text2 = " another line";
		try {
			WorkPage.textForNoteTextArea(text2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "save notes when prompts";
		try {
			WorkPage.saveNotesPrompt();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Switch back to work tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		
		// In Job List click on job "Medium Priority Data Extraction"
		msg = "Select job \"Data Edits 12\" from Job List";
		try {
				WorkPage.clickOnJobDetails(jobName);
				CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
	
		msg = "Select job and run current step in job";
		try {
			WorkPage.clickOnStartStepOfJob(jobName);
			cfunction.sync(2);
			WorkPage.clickOnCollapseRightPane();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Switch back to notes tab";
		try {
			WorkPage.clickOnEditAttributes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "click on edit notes";
		try {
			WorkPage.clickOnNote();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "enter another text";
		String text3 = " another line ";
		try {
			WorkPage.textForNoteTextArea(text3);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "save notes";
		try {
			WorkPage.saveNotes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "verify error message";
		try {
			if(WorkPage.verifyErrorMessage()) {
			CommonFunction.logStatus("PASS", msg);
			}else {
			CommonFunction.logStatus("FAIL", msg);	
			}
		} catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on pause button";
		try {
			//WorkPage.clickOnJobDetails("jobName");
			//cfunction.sync(2);
			WorkPage.pause();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "save notes";
		try {
			WorkPage.saveNotes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "click on edit notes";
		try {
			WorkPage.clickOnNote();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "enter long text for notes text area";
		String text6 = " another line \r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" + 
				"another line\r\n" +
				 "another line \r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" + 
					"another line\r\n" +
				"another line";
		try {
			WorkPage.textForNoteTextArea(text6);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "verify if scrollbar is visible";
		try {
			if(WorkPage.verifyScrollbarVisible()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "save notes";
		try {
			WorkPage.saveNotes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "signout user";
		try {
			WorkPage.clickOnSignout();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "log in as another user";
		try {
			LoginPage  lp = new LoginPage();
			lp.loginToApplication(xls.getCellData("en-us",2, 12), xls.getCellData("en-us", 3,12));
			CommonFunction.waitforHomePagetoload();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "Select job "+jobName+" from Job List";
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
		msg = "click on edit button in details";
		try {
			WorkPage.clickOnEditAttributes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "verify job notes should be visible";
		try {
			if(WorkPage.verifyJobNotesVisible()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "verify edit button should not visible";
		try {
			if (!WorkPage.verifyEditNotesVisible()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}	
		} catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on roles";
		try {
			Design.clickOnRoleTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Add job notes priviledge for user";
		try {
			Design.enableWorkflowPrivileges("jobUpdateNotes");
			cfunction.sync(2);
			Design.clickOnSaveBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		
		}
		cfunction.sync(2);
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "Select job "+jobName+" from Job List";
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
		msg = "click on notes in details";
		try {
			WorkPage.clickOnEditAttributes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "verify job notes should visible";
		try {
			if(WorkPage.verifyJobNotesVisible()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "verify edit button should be visible";
		try {
			if(WorkPage.verifyEditNotesVisible1()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}	
		} catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on roles";
		try {
			Design.clickOnRoleTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "remove job update notes priviledge for user";
		try {
			Design.enableWorkflowPrivileges("jobUpdateNotes");
			cfunction.sync(2);
			Design.clickOnSaveBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		
		}
		cfunction.sync(2);
	}
}