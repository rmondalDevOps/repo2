package com.workflowmanager.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;
import com.workflowmanager.pages.Coordinate;

public class TS23_AssignToSelf extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS23_AssignToSelf() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Coordinate Tab
		msg = "Click on Coordinate Tab";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on All Jobs
		msg = "Click on All Jobs";
		try {
			Coordinate.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Click on 'Survey 32' in the job list
		msg = "Click on 'Survey 32' in the job list";
		try {
			Coordinate.clickOnJobListEntry("Survey 32");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Click on 'Assign to self' button
		msg = "Click on 'Assign to self' button";
		try {
			Coordinate.clickOnassignToSelf();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);
		// 'Step reassigned to current user' should appear in a toast notification
		msg = "'Step reassigned to current user' should appear in a toast notification";

		try {
			String successMsg = "Step reassigned to current user";
			Coordinate.verifySuccessMsg(successMsg);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		// Click on 'Create Jobs'
		msg = "Click on 'Create Jobs'";
		try {
			Coordinate.clickOnNewJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on 'Create Default' under 'Survey Workflow'
		msg = "Click on 'Create Default' under 'Survey Workflow'";
		try {
			Coordinate.clickCreateDefaultOfTemplatePresent("Survey Workflow");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);
		// 'Job created successfully should appear in a toast notification
		msg = "Verify Job should be created successfully";

		try {
			String successMsg = "successful";
			Coordinate.verifySuccessMsg(successMsg);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//As per client this below step can be removed
		
		/*// Click on 'Search Jobs'
		msg = "Click on 'Search Jobs'";

		try {
			Coordinate.clickOnSearchJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// Click on Work tab
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on 'All Jobs'
		msg = "Click on 'ALL JOBS' Tab";
		try {
			WorkPage.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the 'NEW' filter by
		msg = "Click on the 'NEW' filter by";
		try {
			WorkPage.clickOnNewFilterBy();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the job created in previous steps
		msg = "Click on the job created in previous steps";
		try {
			WorkPage.clickOnJobDetails(jobName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on 'Assign to self' button
		msg = "Click on 'Assign to self' button";
		try {
			WorkPage.clickOnCollapseRightPane();
			Coordinate.clickOnassignToSelf();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// 'Step reassigned to current user' should appear in a toast notification
		msg = "'Step reassigned to current user' should appear in a toast notification";

		try {
			String successMsg = "Step reassign to current user";
			Coordinate.verifySuccessMsg(successMsg);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Reseting assignment status
		msg = "Click on Ellipses button";

		try {
			/*HomePage.clickOnDesign();
			cfunction.sync(2);
			HomePage.clickOnWork();
			cfunction.sync(2);
			WorkPage.clickOnAllJobs();
			cfunction.sync(2);
			WorkPage.clickOnNewFilterBy();
			cfunction.sync(2);
			WorkPage.clickOnCollapseRightPane();
			cfunction.sync(2);
			WorkPage.clickOnJobDetails(jobName);
			cfunction.sync(5);*/
			Coordinate.clickEllipsesBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Delete button";

		try {
			Coordinate.clickDeleteBtn();
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on yes button of confirmation dialog box";

		try {
			
			Coordinate.clickDeleteConfirmBtnYes();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Coordinate tab";

		try {
			HomePage.clickOnCoordinate();
			System.out.println("Coordinate page loaded");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on All Jobs button";

		try {
			Coordinate.clickOnAllJobs();
			System.out.println("All Job clicked");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on job \"Survey 32\"";

		try {
			Coordinate.clickOnJobListEntry("Survey 32");
			System.out.println("Survey 32 selected");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Edit button of job";

		try {
			Coordinate.clickEditJobDetail();
			System.out.println("Edit job details clicked");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Select Assigned User as \"WMX User\"";

		try {
			Coordinate.selectAssignedUserFromDropdown("WMX User");
			System.out.println("WMX user selected for assignment");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on save button";

		try {
			Coordinate.clickSaveEditJobDetail();
			System.out.println("Edit data saved");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);


}
}