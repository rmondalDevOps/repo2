package com.workflowmanager.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.Coordinate;

public class TS20_SendEmailStepConfig extends TestBase{
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS20_SendEmailStepConfig() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		// Click on Design Tab
		cfunction.sync(2);
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Verify workflow diagrams panel should be display
		cfunction.sync(2);
		msg = "Workflow Diagrams list populated with results";
		try {
			Design.getAllJobsTemplateList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click on create new
		cfunction.sync(2);
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(10);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// New diagram should open with a single step on the canvas
		cfunction.sync(2);
		msg = "New diagram should open with a single step on the canvas";
		try {
			boolean check = Design.verifyCanvas();
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click and Drag 'Send Email' step on to the canvas
		cfunction.sync(2);
		msg = "Click and Drag 'Send Email' step on to the canvas";

		try {
			//cfunction.Commmon_Click("xpath", "(//div[@class='ui-accordion-content ui-widget-content'])[2]");
			cfunction.ScrollToElement("(//div[@id='ui-accordiontab-5-content'])");
			//Design.clickOnStepLibrary();
			Design.dragStepToCanvas("SendEmail", "BlankCanvas");

			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(10);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify Step Details panel should be visible
		cfunction.sync(2);
		msg = "Verify Step Details panel should be visible";

		try {
			Design.verifyStepDetailsPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify Step Name with the text 'Send Email'
		cfunction.sync(2);
		msg = "Verify Step Name with the text 'Send Email'";
		try {
			
			boolean check = Design.verifyStepName("Send Email");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify Step Description with the text'Send an email to specified recipient'
		cfunction.sync(2);
		msg = "Verify Step Description with the text'Send an email to specified recipients'";
		try {
			Design.clickOnStepDetailAboutTab();
			String innerText = "Send an email to specified recipients. Job attachments can be included with the email.";
			boolean check = Design.verifyStepDesc(innerText);
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Enter 'diposable.style.email.with+symbol@example.com' into 'TO' input field
		cfunction.sync(2);
		msg = "Enter 'diposable.style.email.with+symbol@example.com' into 'TO' input field";

		try {
			Design.clickOnStepDetailPropertiesTab();
			Design.enterEmail("diposable.style.email.with+symbol@example.com");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Enter 'This is an email test' into 'SUBJECT' input field
		cfunction.sync(2);
		msg = "Enter 'This is an email test' into 'SUBJECT' input field";

		try {
			Design.enterSubject("This is an email test");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Enter 'This is a test for sending email jobStatus($job)' into 'BODY' input field
		cfunction.sync(2);
		msg = "Enter 'This is a test for sending email jobStatus($job)' into 'BODY' input field";

		try {
			Design.enterBody("This is a test for sending email jobStatus($job)");
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

	}

}
