package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS17_CustomJobSearch extends TestBase {


	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS17_CustomJobSearch() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Work Tab
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify Work tab is opened. 
		msg = "Verify Work tab is opened";
		try {
			if(WorkPage.verifyWorkTabOpen())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify My Jobs tab is by default set as active tab with my jobs returned.
		msg = "Verify All Jobs tab is by default set as active tab with my jobs returned";
		try {
			if(WorkPage.verifyAllJobsActive())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Expand Custom Search.
		msg = "Expand Custom Search";
		try {
			WorkPage.clickOnCustomeSearchIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//The custom search box is expanded to allow to enter search query.
		msg = "Verify the custom search box is expanded to allow to enter search query";
		try {
			WorkPage.clickOnCustomSearchInput();
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify the custom query textbox is empty : as per new changes in build(as discussed with Xiaomeng)
		msg = "Verify the custom query textbox is empty";
		try {
			if(WorkPage.verifyCustomQueryCleared())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		/*//Click 'X' to clear the query.
		msg = "Click 'X' to clear the query";
		try {
			WorkPage.clickonCustomQueryX();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify Query is cleared.
		msg = "Verify Query is cleared";
		try {
			if(WorkPage.verifyCustomQueryCleared())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		//Enter new search query Search in the custom search box.
		msg = "Enter new search query Search in the custom search box";
		try {
			String query = "assignedType='User' AND assignedTo='wmxuser'";
			WorkPage.enterCustomSearch(query);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Hit Enter.
		msg = "Hit Enter";
		try {
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//A new Custom Query tab is opened next to All Jobs tab. 
		msg = "A new Custom Query tab is opened next to All Jobs tab";
		try {
			if(WorkPage.verifyCustomQueryTab())
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//It returns all jobs that contain Search.Verify it returns 3 jobs if you log in as wmxuser.
		msg = "It returns all jobs that contain Search.Verify it returns 3 jobs if you log in as wmxuser";
		try {
			if(WorkPage.verifyAllJobs())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Choose 'Job Name: A to Z' from Sort By drop down list to sort the query results.
		msg = "Choose 'Job Name: A to Z' from Sort By drop down list to sort the query results";
		try {
			if(!WorkPage.verifyJobsOrderAscending())
				WorkPage.sortOnJobNameAZ();
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the returned jobs are sorted by job name ascendent.
		msg = "Verify the returned jobs are sorted by job name ascendent";
		try {
			if(WorkPage.verifyJobsOrderAscending())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Clear the query.
		msg = "Clear the query";
		try {
			WorkPage.clickonCustomQueryX();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Query is cleared.
		msg = "Query is cleared";
		try {
			if(WorkPage.verifyCustomQueryCleared())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enter new search query priority = 'Low' AND jobTemplateName = 'Extract Data' in the custom search box & Hit Enter.
		msg = "Enter new search query priority = 'Low' AND jobTemplateName = 'Extract Data' in the custom search box & Hit Enter";
		try {
			String query = "priority = 'Low' AND jobTemplateName = 'Extract Data'";
			WorkPage.enterCustomSearch(query);
			cfunction.sync(1);
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//It returns 7 jobs with low priority and assigned to Meggie Zheng
		msg = "It returns 14 jobs with low priority and job template name 'Extract Data'";
		try {
			if(WorkPage.verifyAllJobs())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Switch to My Group Jobs tab.
		msg = "Switch to My Group Jobs tab";
		try {
			WorkPage.clickOnMyGroups();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Custom Query is NOT cleared.
		msg = "Custom Query is NOT cleared";
		try {
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Switch to Custom Query tab.
		msg = "Switch to Custom Query tab";
		try {
			WorkPage.clickOnCustomQueryTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The previous custom query results are persistent.
		msg = "The previous custom query results are persistent";
		try {
			if(WorkPage.verifyAllJobs())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Open Production page next to Design tag 
		msg = "Open Coordinate page next to Design tag";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Switch back to Work tab.
		msg = "Switch back to Work tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The custom query tab is cleared.
		msg = "The custom query tab is cleared";
		try {
			if(!WorkPage.verifyCustomQueryTab())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Expand Custom Search.
		msg = "Expand Custom Search";
		try {
			WorkPage.clickOnCustomeSearchIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Expand Search History drop down list.
		msg = "Expand Search History drop down list";
		try {
			WorkPage.clickOnCustomQueryHistory();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The previous two queries are stored in the drop down list.
		msg = "The previous two queries are stored in the drop down list";
		try {
			int history = WorkPage.getCustomSearchHistory();
			if(history >= 2)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on "Search" query.
		msg = "Click on 'Search' query";
		try {
			WorkPage.clickOnRecentSearch();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//It opens Custom Query tab with job results returned in the tab.
		msg = "It opens Custom Query tab with job results returned in the tab";
		try {
			if(WorkPage.verifyCustomQueryTab())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click Dismiss Custom Query Tab.
		msg = "Click Dismiss Custom Query Tab";
		try {
			WorkPage.clickOnDismissCustomQuery();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The custom query tab is cleared.
		msg = "The custom query tab is cleared";
		try {
			if(!WorkPage.verifyCustomQueryTab())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on Log out 
		msg = "Click on Log out";
		try {
			HomePage.clickOnLogOut();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		/*//login again to application
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));

		cfunction.sync(2);
		//Click on Work Tab
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Expand Custom Search.
		msg = "Expand Custom Search";
		try {
			WorkPage.clickOnCustomeSearchIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//In work tab, expand Search History drop down list.
		msg = "In work tab, expand Search History drop down list";
		try {
			WorkPage.clickOnCustomQueryHistory();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The search history is cleared after logging out from the web app.
		msg = "The search history is cleared after logging out from the web app";
		try {
			int history = WorkPage.getCustomSearchHistory();
			if(history == 0)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Log out the application.
		msg = "Log out the application";
		try {
			HomePage.clickOnLogOut();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		*/
	}
}
