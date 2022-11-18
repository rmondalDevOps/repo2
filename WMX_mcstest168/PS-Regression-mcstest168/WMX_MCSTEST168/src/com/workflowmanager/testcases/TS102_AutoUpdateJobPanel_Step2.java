package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;
import com.workflowmanager.pages.LoginPage;


public class TS102_AutoUpdateJobPanel_Step2 extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	
	public void workflow_TS102_AutoUpdateJobPanel_Step2() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		msg = "Click on manage tab";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "Click All Jobs under Search Jobs tab.";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			cfunction.sync(2);
			Coordinate.clickOnAllJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//String jobName ="JOB_14714";
		// In Job List click on job "Survey 34"
		msg = "Select job" +jobName+ "from Job List";
		System.out.println(jobName);
		//msg = "Select job \"JOB_45990\" from Job List";
		try {
			Coordinate.clickOnJobListEntry(jobName);
			//Coordinate.clickOnJobListEntry(jobName);
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
		String text = "First test comment added";
		try {
			WorkPage.clickOnCommentTextArea();
			cfunction.sync(2);
			WorkPage.textForCommentTextArea(text);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on send button";
		try {
			WorkPage.sendcomment();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg="verify comments added without refreshing page";
		
		try {
			if(Coordinate.verifyComments(text, "2")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
				}
			}
			catch (Exception e) {
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
		msg = "click on add attachment";
		try {
			WorkPage.addAttachment("1");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(20);
		msg = "click on browse file option";
		try {
			WorkPage.clickOnBrowse();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		msg = "Click Browse and navigate to the \"This_is_a_text.txt\" testing attachment file.";
		try {
			WorkPage.browseLocalFiles1("TextAttachment.txt");
			//WorkPage.browseLocalFiles("C:\\Automation\\Workspace\\WorkflowManager\\testData\\WMX_TestData\\This_is_a_text.txt");
			//cfunction.sync(2);
			//WorkPage.selectFileToUpload("This_is_a_text.txt");
			//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify attachment is added";
		try {
			if(WorkPage.verifyAttachmentAdded( "2")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		 msg = "rename attachment file";
		try {
			WorkPage.renameFile("renamed", "2");
			//WorkPage.renameUploadedFile4("rename Uploaded File");
			//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify file name got renamed";
		try {
			if(WorkPage.verifyRenamedFile(1)) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		
		msg = "delete attachment in new folder";
		try {
			WorkPage.deletePanelAttachment("3");
			//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify attachment got deleted";
		try {
			if(WorkPage.verifyTotalAttachment()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
				}
			}
			catch (Exception e) {
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
		msg="verify comments added without refreshing page";
		//String text = "First test comment added";
		try {
			if(Coordinate.verifyComments(text, "1")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
				}
			}
			catch (Exception e) {
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
		
		msg = "verify two files in general folder and file in new folder is deleted";
		try {
			if(WorkPage.verifyTotalAttachment()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
				}
			}
			catch (Exception e) {
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
		

			

}
}
