package com.workflowmanager.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS45_RedirectUrls extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public static String itemIDtake() {
		String itemID ="";
		try {
			 itemID = TestBase.fetchItemID();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemID;
	}
	String itemID = itemIDtake();
	String appDefaultURL = "https://mcstest62.esri.com/portal/apps/workflowmanager/"+itemID+"/";
	String appDefaultURL1 = "https://mcstest62.esri.com/portal/apps/workflowmanager/";
	public void workflow_TS45_RedirectUrls() throws InterruptedException {
		 CommonFunction.waitforHomePagetoload();
		// Click on Design Tab
		
		//Open the Work page directly
		 msg = "Open the Work page directly";
			try {
				
				driver.get(appDefaultURL+"work?queryId=L46soUSzRD62LqwFvp5pVQ");
				cfunction.sync(5);
				if(WorkPage.verifyWorkTabOpen())
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the Manage page directly
			msg = "Open the Manage page directly";
			try {
				driver.get(appDefaultURL+"manage?queryId=L46soUSzRD62LqwFvp5pVQ");
				cfunction.sync(5);
				if(Design.verifyManageTabOpen())
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the Design page directly
			msg = "Open the Design page directly";
			try {
				driver.get(appDefaultURL+"design/diagrams");
				cfunction.sync(5);
				if(Design.verifyWorkflowDiagramsPage())
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the Setting page directly
			msg = "Open the Setting page directly";
			try {
				driver.get(appDefaultURL+"design/settings");
				cfunction.sync(5);
				if(Design.verifyGroupTabPanel())
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the Diagrams page directly
			msg = "Open the Diagrams page directly";
			try {
				driver.get(appDefaultURL+"design/diagrams");
				cfunction.sync(5);
				if(Design.verifyWorkflowDiagramsPage())
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the Data Edits Sample diagram directly
			msg = "Open the Data Edits Sample diagram directly";
			try {
				driver.get(appDefaultURL+"design/diagrams/AWd1cu3KJLQ4IgUE0i7p");
				cfunction.sync(5);
				if(Design.verifyOpendWorkflowDiagramsBanner())
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the Jobtemplates page directly
			msg = "Open the Jobtemplates page directly";
			try {
				driver.get(appDefaultURL+"design/jobTemplates/ZmN1qa46QwOEqqotPEz7ZA");
				cfunction.sync(5);
				if(Design.verifyTemplateTabIsVisible("Job Templates"))
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the Data Edits Sample job template directly
			msg = "Open the Data Edits Sample job template directly";
			try {
				driver.get(appDefaultURL+"design/jobTemplates/AWd1czm4JLQ4IgUE0i7q");
				cfunction.sync(5);
				if(Design.verifyJobTemplateHeader("Data Edits Sample"))
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the My Jobs query in the Work page directly
			msg = "Open the My Jobs query in the Work page directly";
			try {
				driver.get(appDefaultURL+"work?queryId=rrUF60TFQCe2K0vtgSsYpA");
				cfunction.sync(5);
				if(WorkPage.verifyMyJobsActive())
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
		//Open the All Jobs query in the Work page and filtered with Overdue
			msg = "Open the All Jobs query in the Work page and filtered with Overdue";
			try {
				driver.get(appDefaultURL+"work?queryId=L46soUSzRD62LqwFvp5pVQ&filter=overdue");
				cfunction.sync(5);
				if(WorkPage.verifyAllJobsActive())
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
				
				} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			//Open the initial page to create workflow items.
			msg = "Open the initial page to create workflow items.";
			try {
				driver.get(appDefaultURL1);
				cfunction.sync(5);
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);

	}
}