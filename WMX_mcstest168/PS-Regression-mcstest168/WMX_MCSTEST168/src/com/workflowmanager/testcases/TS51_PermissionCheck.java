package com.workflowmanager.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.LoginPage;


public class TS51_PermissionCheck  extends TestBase{
	final String SIGNIN_XPATH = "//button[contains(@class,'btn')]";
	final String USERNAME_XPATH = "//input[@id='user_username']";
	final String PASSWORD_XPATH = "//input[@id='user_password']";
	final String SIGNINSUBMIT_XPATH  = "//button[@id='signIn']";
	final String ENTER_ID_INPUT_XPATH  = "//input[contains(@class, 'ng-pristine ng-valid')]";
	final String OPEN_ITEM_BTN_XPATH  = "//button[@class='btn']";
	String msg = "";
	CommonFunction cfunction = new CommonFunction();
	public void workflow_TS51_PermissionCheck() throws InterruptedException {
		//Click on Sign In button
		msg = "Login to application using 'aarthidw' username";
		try {
			LoginPage  lp = new LoginPage();
			lp.loginToApplication1("aarthidw", "JobTracking102");	
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		
		cfunction.sync(2);
		msg = "Verify No Workflow Item is  present";
		try {
			List<WebElement> workflowItem = driver.findElements(By.xpath("//div[@class='c-workflowItemCard__thumbnailSection']"));

			if (workflowItem.size() == 0) {
				CommonFunction.logStatus("PASS", msg);
		}else {
			CommonFunction.logStatus("FAIL", msg);
		}}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

	}
}