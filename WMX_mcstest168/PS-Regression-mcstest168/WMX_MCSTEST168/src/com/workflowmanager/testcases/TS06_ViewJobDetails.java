package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS06_ViewJobDetails extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS6_ViewJobDetails() throws InterruptedException {
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

		// etails
		msg = "Click on Open Job Details";
		//String jobName= xls.getCellData("en-us", 2,8);
		String jobName="Survey 34";
		/*try {
			//CommonFunction.ScrollBottom();
			WorkPage.clickOnJobDetails(jobName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		try {
			boolean check = WorkPage.clickOnJobDetails(jobName);
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
		cfunction.sync(2);

		// Click on Diagram & Map
		msg = "Click on Diagram & Map";
		try {
			WorkPage.clickOnCollapseRightPane();
			WorkPage.clickOnDiagramMap();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Click on History button
		/*msg = "Click on History button";
		try {
			WorkPage.clickOnComments();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/

		// Click on Properties	
		msg = "Click on Properties button";
		try {
			WorkPage.clickOnProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click on Close Panel
		/*msg= "Click on Close Panel";
		try {
			WorkPage.clickOnClosePanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		
		
		
		
		
		






	}
}
