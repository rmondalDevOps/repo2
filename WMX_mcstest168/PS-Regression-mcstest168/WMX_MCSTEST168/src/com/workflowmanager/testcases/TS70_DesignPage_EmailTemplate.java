package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS70_DesignPage_EmailTemplate extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS70_DesignPage_EmailTemplate() throws InterruptedException {
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
		
		//Navigate to Templates (the third tab in the sidebar, below 'Job Templates') 
		
				msg = "Click on Templates";
				try {
					Design.clickOnTemplatesIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//At the top of the Email Templates panel, select Create New.
				msg = "Click on 'Create New'";
				try {
					Design.clickOnCreateNewBtnOfEmail();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A blank email template should appear in the center and right of the page.
		//Under TEMPLATE NAME, enter 'test template'.  At the bottom-right of the page,
				msg = "Enter Email Template name 'Test Template'";
				String emailTemplateName = "Test Template";
				try {
					Design.enterEmailTemplateName(emailTemplateName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//hover over 'Save'. 
				msg = "Hover over 'Save'.";
				try {
					Design.hoverOnEmailSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
		//Hover text reads 'One of the following is required: TO, CC, BCC'
				msg = "Verify Hover text reads 'One of the following is required: TO, CC, BCC.'";
				try {
					if (Design.verifyToolTipTextPresent("One of the following is required: TO, CC, BCC."))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//"Under TO, CC, and BCC, enter 'placeholder@esri.com'.
				msg = "Under TO Enter 'placeholder@esri.com'";
				String email="placeholder@esri.com";
				try {
					
					Design.enterEmail_TO_TemplateName(email);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Under CC Enter 'placeholder@esri.com'";
				//String email="placeholder@esri.com";
				try {
					
					Design.enterEmail_CC_TemplateName(email);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Under BCC Enter 'placeholder@esri.com'";
				//String email="placeholder@esri.com";
				try {
					
					Design.enterEmail_BCC_TemplateName(email);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//At the bottom-right of the page, select 'Save'"
				msg = "Click on 'Save' button";
				try {
					
					Design.clickOnEmailSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The email template saves successfully
				msg = "Verify Success message is displayed.";
				String successMsg = emailTemplateName+" saved successfully";
				try {
					if(Design.verifySuccessMsg(successMsg))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//"Under SUBJECT enter the Arcade expression jobName($job).
				msg = "Under SUBJECT enter the Arcade expression 'jobName($job)'.";
				//String email="placeholder@esri.com";
				try {
					
					Design.enterEmail_SUBJECT_TemplateName("jobName($job)");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Under BODY enter the following HTML (including all quotes and line breaks): 
		/*'<h1>Message: </h1>
		<p>' + jobName($job) + '</p>'  */
				msg = "Under BODY enter the HTML";
				String body="'<h1>Message: </h1>\r\n<p>' + jobName($job) + '</p>'";
				try {
					
					Design.enterEmail_BODY_TemplateName(body);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Without saving your changes, select the Diagrams tab"
				msg = "Without saving your changes, select the Diagrams tab";
				try {
					Design.clickOnDiagramsIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);
		//A popup appears giving you the option to save your changes. 
				msg = "Verify popup appears giving you the option to save your changes";
				try {
					Design.verifyConfirmDialog();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//In the popup window, select 'Yes'
				msg = "Click 'Yes'";
				try {
					Design.clickYesOnConfirmDialog();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The email template saves successfully, and you navigate to the diagrams page.  
		//"Navigate back to your email template.  
				msg = "Navigate back to your email template.";
				try {
					Design.clickOnTemplatesIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Under PREVIEW EMAIL, enter the following job id:-X92l7cRSDS0_akz2ujYpA
				msg = "Under PREVIEW EMAIL, enter the following job id:\"-X92l7cRSDS0_akz2ujYpA\"";
				try {
					Design.enterEmailPreviewInput("-X92l7cRSDS0_akz2ujYpA");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Next to the text box, select the 'Preview' button."
				msg = "select the 'Preview' button.";
				try {
					Design.clickOnPreviewBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		/*An 'Email Preview' popup window appears with the following information: 

		To: placeholder@esri.com
		CC: placeholder@esri.com
		BCC: placeholder@esri.com 
		Subject: Data Extraction 1
		Body:

		    Message:

		    Data Extraction 1*/
				msg = "Verify An 'Email Preview' popup window appears.";
				try {
					if(Design.verifyPreviewDialogBoxVisible())
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
	}
}
