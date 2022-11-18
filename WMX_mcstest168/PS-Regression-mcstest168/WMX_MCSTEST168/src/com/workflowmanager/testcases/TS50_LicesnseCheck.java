package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.LoginPage;


public class TS50_LicesnseCheck extends TestBase{

	final String SIGNIN_XPATH = "document.querySelector('body > wmx-root > wmx-app > div > div.actionSection > calcite-button').shadowRoot.querySelector('button')";
	//final String SIGNIN_XPATH = "//button[contains(@class,'btn')]";
	final String USERNAME_XPATH = "//input[@id='user_username']";
	final String PASSWORD_XPATH = "//input[@id='user_password']";
	//final String SIGNINSUBMIT_XPATH  = "//button[@id='signIn']";
	final String SIGNINSUBMIT_XPATH = "//calcite-button[@data-name='signInButton']";
	final String SIGNINSUBMIT_XPATH2 = "//button[@id='signIn']";
	final String ENTER_ID_INPUT_XPATH  = "//input[contains(@class, 'ng-pristine ng-valid')]";
	final String OPEN_ITEM_BTN_XPATH  = "//button[@class='btn']";
	String msg = "";
	CommonFunction cfunction = new CommonFunction();

	public void workflow_TS50_LicesnseCheck() throws InterruptedException {
		//Click on Sign In button
		cfunction.sync(10);
				msg = "Click on Sign In button";
				try {
					//cfunction.CommmonJS_Click_ShadowPath(SIGNIN_XPATH);
					
					cfunction.Commmon_Click("xpath",SIGNINSUBMIT_XPATH);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}	
				cfunction.sync(2);
				msg = "Enter Username";
				try {
					cfunction.CommonTextBox_Input(USERNAME_XPATH, "dummyuser");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter Password"; 
				try {
					cfunction.CommonTextBox_Input(PASSWORD_XPATH, "JobTracking102");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on Sign In";
				try {
					cfunction.CommmonJS_Click(SIGNINSUBMIT_XPATH2);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify Error message";
				String textMsg= " Current user is not licensed to access Workflow Manager server. Please contact your Administrator.";
				try {
					cfunction.verifyElementText("//div[@class='c-sectionError t-sectionError']",textMsg);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
	}
}
