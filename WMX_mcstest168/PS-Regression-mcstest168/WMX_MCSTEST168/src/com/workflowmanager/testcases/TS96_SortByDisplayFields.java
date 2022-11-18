package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS96_SortByDisplayFields {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflowManager_SortByDisplayFields_TestCase() {

		// Click on Work Page
		msg = "Click on Work Page";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on All Jobs
		msg = "Click on All Jobs";
		try {
			WorkPage.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Name by filter Z-A
		msg = "Click on Name by filter";
		try {
			WorkPage.clickNameByFilter();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify the Sort Order
		msg = "Verify the Sort Order Name";
		try {
			WorkPage.verifyOrderSortName();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Name by filter A-Z
		msg = "Click on Name by filter";
		try {
			WorkPage.clickNameByFilter();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Hover over to Sort Fields
		msg = "Hover over to Sort Fields";
		try {
			WorkPage.hoverOverSortFields();
			//SikuliHelp.hoveronLocationSikuli("TS96_HovertoSortFields_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// To Verify the tool-tip message
		msg = "Verify the tool-tip message";
		try {
			WorkPage.verifyTooltipSortFields();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Ctrl + Current Step (Z-A)
		msg = "Click on Ctrl + Current Step";
		try {
			WorkPage.ClickOnCtrlCurrentStep();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// To Verify the numbers are enable beside the attribute fields
		msg = "Verify the numbers are enable beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrderCurrent();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Ctrl + Current Step (A-Z)
		msg = "Click on Ctrl + Current Step";
		try {
			WorkPage.ClickOnCtrlCurrentStep();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Ctrl + Type (Z-A)
		msg = "Click on Ctrl + Type";
		try {
			WorkPage.ClickOnCtrlType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// To Verify the numbers are enable beside the attribute fields
		msg = "Verify the numbers are enable beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrderType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify the Sort Order Current
		msg = "Verify the Sort Order Current";
		try {
			WorkPage.verifyOrderSortType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Ctrl + Type (A-Z)
		msg = "Click on Ctrl + Type";
		try {
			WorkPage.ClickOnCtrlType();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// Click on Ctrl + Priority (Z-A)
		msg = "Click on Ctrl + Priority";
		try {
			WorkPage.ClickOnCtrlPriority();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// To Verify the numbers are enable beside the attribute fields
		msg = "Verify the numbers are enable beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrderPriority();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify the Sort Order Priority
		msg = "Verify the Sort Order Priority ";
		try {
			WorkPage.verifyOrderSortpriority();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Ctrl + Priority (A-Z)
		msg = "Click on Ctrl + Priority";
		try {
			WorkPage.ClickOnCtrlPriority();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// Click on Ctrl + Due Date (Z-A)
		msg = "Click on Ctrl + Due Date";
		try {
			WorkPage.ClickOnCtrlPriority();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// To Verify the numbers are enable beside the attribute fields
		msg = "Verify the numbers are enable beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrder();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify the Sort Order Due Date
		msg = "Verify the Sort Order Due Date ";
		try {
			WorkPage.verifyOrderSortDueDate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Ctrl + Due Date (A-Z)
		msg = "Click on Ctrl + Due Date";
		try {
			WorkPage.ClickOnCtrlPriority();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// Click on Ctrl + Status (Z-A)
		msg = "Click on Ctrl + Status (Z-A)";
		try {
			WorkPage.ClickOnCtrlStatus();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// To Verify the numbers are enable beside the attribute fields
		msg = "Verify the numbers are enable beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrder();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Verify the Sort Order Status
		msg = "Verify the Sort Order Status";
		try {
			WorkPage.verifyOrderSortStatus();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Ctrl + Status (A-Z)
		msg = "Click on Ctrl + Status (A-Z)";
		try {
			WorkPage.ClickOnCtrlStatus();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// Click on 'High Priority' filter by button
		msg = "Click on 'High Priority' filter by button";
		try {
			WorkPage.clickOnHighPriorityFilterBy();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(7);

		// To Verify the numbers are enable beside the attribute fields
		msg = "Verify the numbers are enable beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrder();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on 'New' filter by button
		msg = "Click on 'New' filter by button";
		try {
			WorkPage.clickOnNewFilterBy();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(7);

		// To Verify the numbers are enable beside the attribute fields
		msg = "Verify the numbers are enable beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrder();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on 'OverDue' filter by button
		msg = "Click on 'OverDue' filter by button";
		try {
			WorkPage.clickOnOverDueFilterBy();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(7);

		// To Verify the numbers are enable beside the attribute fields
		msg = "Verify the numbers are enable beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrder();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on Name by filter Z-A
		msg = "Click on Name by filter";
		try {
			WorkPage.clickNameByFilter();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// To Verify the numbers are disabled beside the attribute fields
		msg = "Verify the numbers are disabled beside the attribute fields";
		try {
			WorkPage.verifyFieldsInOrder();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click on My Job
		msg = "Click on My Job";
		try {
			WorkPage.clickOnMyJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

	}
}