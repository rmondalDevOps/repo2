package com.workflowmanager.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;


public class TS87_AutoUpdateJobPanel extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	
	public void workflow_TS87_AutoUpdateJobPanel() throws InterruptedException {
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
		msg = "Run start step of new job created automatically";
		try {
			WorkPage.RunStartStep();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "open comments tab";
		try {
			WorkPage.clickOnComments();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "add comments";
		String txtValue = "First test comment added";
		try {
			WorkPage.addComments(txtValue);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click to proceed";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify comment is added in the comment tab";
		try {
			if(WorkPage.verifyComments(txtValue, "1")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		cfunction.sync(2);
		msg = "open attachment tab";
		try {
			WorkPage.clickOnAttachment();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Run Add Attachment step to add an embedded job attachment";
		try {
			WorkPage.RunStartStep();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click Browse and navigate to the \"TextAttachment.txt\" testing attachment file.";
		try {
			WorkPage.selectFileToUpload("TextAttachment.txt");
			//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Delete the attachment in the step";
		try {
			WorkPage.DeleteUploadedFile("2");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Add another attachment in the step.";
		try {
			WorkPage.selectFileToUpload("This_is_a_text.txt");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click to proceed";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Run Add Attachment 2 step to add a linked job attachment.";
		try {
			WorkPage.RunStartStep();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on the Link button";
		try {
			WorkPage.clickOnLinkBtn();
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter 'http://esri.com' as url input";
		try {
			WorkPage.enterURL_Input("http://esri.com");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter 'This is a URL' as Name input";
		try {
			WorkPage.enterName_Input("This is a URL");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Save button";
		try {
			WorkPage.clickOnSaveBtn1();
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click to proceed";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "open diagram and map tab";
		try {
			WorkPage.clickOnDiagramAndMapTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Run Define Location step to define a job location.";
		try {
			WorkPage.RunStartStep();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select feature";
		try {
			WorkPage.drawFeature();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "select \"location\" on the map";
		try {
			//Design.dragStepToCanvas("TS85_SelectLocationOnMap1", "TS85_SelectLocationOnMap2");
			WorkPage.selectLocation(0,0);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		msg = "click to proceed";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Run Define Location2 step to define a job location.";
		try {
			WorkPage.RunStartStep();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select feature";
		try {
			WorkPage.drawFeature();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "select \"location\" on the map";
		try {
			//Design.dragStepToCanvas("TS85_SelectLocationOnMap1", "TS85_SelectLocationOnMap2");
			WorkPage.selectLocation(1,1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		msg = "click to proceed";
		try {
			WorkPage.clickOnProceedBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
			}
}
		