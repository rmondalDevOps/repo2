package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.LoginPage;


public class TS03_SignIn extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS3_SignIn() throws InterruptedException {
		LoginPage  lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));
		CommonFunction.waitforHomePagetoload();
		cfunction.sync(2);
	}
}
