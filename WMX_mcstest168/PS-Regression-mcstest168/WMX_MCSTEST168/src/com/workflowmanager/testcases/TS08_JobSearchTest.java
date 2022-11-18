package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.Coordinate;

public class TS08_JobSearchTest extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS8_JobSearchTest() throws InterruptedException {

		workflow_TS8_TC01_ProductionPageJobListSortingTest();
		workflow_TS8_TC02_ProductionPageJobListScrollingTest();
	}
	private void workflow_TS8_TC01_ProductionPageJobListSortingTest() {

		CommonFunction.waitforHomePagetoload();

		// Click on Production Tab
		msg = "Click on Production tab";
		try {
			cfunction.sync(5);
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Expand Job List'	
		/*msg = "Click the 'Expand Job List'";
		try {
			Coordinate.clickOnExpandJobList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should expand and cover the map
		msg = "The job list is expand ";
		try {
			if(Coordinate.verifyJobListExpanded())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		// Click the 'All Jobs' search from the Job Search panel
		msg = "Click the 'All Jobs' search from the Job Search panel";
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

		// The job list should sort from A-Z by job name
		msg = "The job list should sort from A-Z by job name";
		try {
			Coordinate.verifyJobList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Click the 'Job Name' header
		msg = "Click the 'Job Name' header";
		try {
			cfunction.sync(10);
			Coordinate.clickOnJobNameHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select the first job (Currently: CREATE_JOB_ReadyAPI_Tests)
		msg = "First job selected";
		try {
			Coordinate.selectFirstJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify job details panel is displayed
		msg = "Info panel is displayed";
		try {
			if(Coordinate.verifyInfoPanelIsDisplayed())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Job Name' header
		msg = "Click the 'Job Name' header";
		try {
			Coordinate.clickOnJobNameHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort from Z-A by job name
		msg = "The job list should sort from Z-A by job name";
		try {
			Coordinate.verifyReverseJobList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);


		// Click the 'Assigned To' header
		msg = "Click the 'Assigned To' header";
		try {
			Coordinate.clickOnAssignedtoHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort from A-Z by assignment
		msg = "The job list should sort from A-Z by assignment";
		try {
			Coordinate.verifyAssignmentList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Assigned To' header
		msg = "Click the 'Assigned To' header";
		try {
			Coordinate.clickOnAssignedtoHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort from Z-A by assignment
		msg = "The assigned to list should sort from Z-A by assignment";
		try {
			Coordinate.verifyReverseAssignmentList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		// Click the 'Due Date' header
		msg = "Click the 'Due Date' header";
		try {
			Coordinate.clickOnDueDateHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort earlier values first
		msg = "The job list should sort earlier values first";
		try {
			Coordinate.verifyDateList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Due Date' header
		msg = "Click the 'Due Date' header";
		try {
			Coordinate.clickOnDueDateHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort later values first
		msg = "The job list should sort later values first";
		try {
			Coordinate.verifyDateList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Status' header
		msg = "Click the 'Status' header";
		try {
			Coordinate.clickOnStatusHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort from A-Z by step status
		msg = "The job list should sort from A-Z by step status";
		try {
			Coordinate.verifyStatusList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Status' header
		msg = "Click the 'Status' header";
		try {
			Coordinate.clickOnStatusHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort from Z-A by step status
		msg = "The job list should sort from Z-A by step status";
		try {
			Coordinate.verifyReverseStatusList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
/*
		// Click the 'Current Step' header
		msg = "Click the 'Current Step' header";
		try {
			Production.clickOnCurrentHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort from A-Z by current step name
		msg = "The job list should sort from A-Z by current step name";
		try {
			Production.verifyCurrentStepList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Current Step' header
		msg = "Click the 'Current Step' header";
		try {
			Production.clickOnCurrentHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should sort from Z-A by current step name
		msg = "The job list should sort from Z-A by current step name";
		try {
			Production.verifyReverseCurrentStepList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
*/
		cfunction.sync(2);

		// Click the 'Priority' header
		msg = "Click the 'Priority' header";
		try {
			Coordinate.clickOnPriorityHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,2315);
		}
		cfunction.sync(2);

		// The job list should sort from High to Low priority
		msg = "The job list should sort from High to Low priority";
		try {
			Coordinate.verifyPriorityList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,2315);
		}
		cfunction.sync(2);


		// Click the 'Priority' header
		msg = "Click the 'Priority' header";
		try {
			Coordinate.clickOnPriorityHeader();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,2315);
		}
		cfunction.sync(2);

		// The job list should sort from Low to High priority
		msg = "The job list should sort from High to Low priority";
		try {
			Coordinate.verifyPriorityList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,2315);
		}
		cfunction.sync(2);

	}

	private void workflow_TS8_TC02_ProductionPageJobListScrollingTest() {

		// Click on Production Tab
		msg = "Click on Coordinate tab";
		try {
			cfunction.sync(5);
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Collapse Job List' button
		/*msg = "Click the 'Collapse Job List'";
		try {
			Coordinate.clickOnCollapseJobList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);


		// The job list should collapse down revealing more of the map
		msg = "The job list is collapsed down";
		try {
			if(Coordinate.verifyJobListCollapsed())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/



		// Click the 'Expand Job List' button
		/*msg = "Click the 'Expand Job List'";
		try {
			Coordinate.clickOnExpandJobList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The job list should expand and cover the map
		msg = "The job list is expand ";
		try {
			if(Coordinate.verifyJobListExpanded())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
*/
		// Scroll to the bottom of the Job List
		msg = "Scroll to the bottom of the Job List";
		try {
			Coordinate.clickOnRightTriangleArrow();
			Coordinate.clickOnCollapseLeftPanel();
			Coordinate.scrollToBottomOfJobList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// "Show More" should be visible at the bottom
		msg = "Show More is visible at the bottom";
		try {
			if(Coordinate.verifyShowMore())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click 'Show More'
		msg = "Click 'Show More'";
		try {
			Coordinate.clickOnShowMore();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// More jobs should load
		msg = "More jobs should load";
		try {
			Coordinate.verifyJobList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,2315);
		}
		cfunction.sync(2);
	}
}
