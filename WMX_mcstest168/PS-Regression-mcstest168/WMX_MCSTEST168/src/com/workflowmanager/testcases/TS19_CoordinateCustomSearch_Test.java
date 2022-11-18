package com.workflowmanager.testcases;


import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.Coordinate;


public class TS19_CoordinateCustomSearch_Test extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS19_CoordinateCustomSearch_Test() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();

		// By default it opens the Coordinate tab
		msg = "Verify by default it opens the Coordinate tab";
		cfunction.sync(2);
		try {
			//String URL = "https://mcstest62.esri.com/portal/apps/workflowmanager/554a740a715245118d322adf53c010db/coordinate";
			boolean check = HomePage.verifyLandingPage1("content=0");
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

		// My Jobs is active tab
		msg = "My Jobs is active tab";
		cfunction.sync(2);
		try {
			Coordinate.clickOnLeftCollapseBtn();
			cfunction.sync(2);
			Coordinate.clickOnAllJob();
			boolean check = Coordinate.verifyAllJobEnable();
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

		// In Search Jobs entry box, enter Priority = 'Medium' then hit Enter.
		msg = "In Search Jobs entry box, enter Priority = 'Medium' then hit Enter";
		cfunction.sync(2);
		try {
			Coordinate.enterSearchJob("Priority = 'Medium'");
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// A custom Search 1 is inserted into Recent category in Search Jobs tab
		msg = "Search 1 is inserted into Recent category";
		cfunction.sync(2);
		try {
			Coordinate.verifySearch_1IsDisplayed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// All the jobs with medium priority are returned in the Job List view
		msg = "All the jobs with medium priority are returned in the Job List view";
		cfunction.sync(5);
		try {
			boolean check = Coordinate.verifyPriority("Medium");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// In Search Jobs entry box, enter assignedTo = 'Administor'. Without hitting Enter.
		msg ="In Search Jobs entry box, enter assignedTo = 'admin'";
		cfunction.sync(2);
		try {
			Coordinate.enterSearchJob("assignedTo = 'admin'");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//Click 'X' to clear the query.
		msg ="Click 'X' to clear the query";
		cfunction.sync(2);
		try {
			Coordinate.clearSearch();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Query is cleared.
		msg ="Query is cleared";
		cfunction.sync(2);
		try {
			Coordinate.verifyClearSearch();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Enter the search assignedTo = 'Administor' in the custom search box and hit Enter.
		msg ="Enter the search assignedTo = 'admin' in the custom search box and hit Enter";
		cfunction.sync(2);
		try {
			Coordinate.enterSearchJob("assignedTo = 'admin'");
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// The custom Search 2 is inserted into Recent category
		msg = "Search 2 is inserted into Recent category";
		cfunction.sync(2);
		try {
			Coordinate.verifySearch_2IsDisplayed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Switch to Design tab.
		msg = "Switch to Design tab";
		cfunction.sync(2);
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Switch back to Coordinate tab.
		msg = "Switch back to Coordinate tab";
		cfunction.sync(2);
		try {
			HomePage.clickOnCoordinate();
			cfunction.sync(5);
			Coordinate.clickOnLeftCollapseBtn();
			cfunction.sync(2);
			Coordinate.clickOnAllJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		

		// The previous two custom searches are still available in Recent search category.
		msg = "Verify previous two custom searches are still available in Recent search category";
		cfunction.sync(2);
		try {
			Coordinate.verifySearch_1IsDisplayed();
			Coordinate.verifySearch_2IsDisplayed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Hover over Search 1.
		msg = "Hover over Search 1";
		cfunction.sync(2);
		try {
			Coordinate.hoverOnSearch1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// The search syntax is shown in the tooltips
		msg = "Verify the search syntax is shown in the tooltips";
		cfunction.sync(2);
		try {
			Coordinate.verifySearch1ToolTip();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Edit and Delete search options are available at hover.
		msg = "Edit and Delete search options are available at hover";
		cfunction.sync(2);
		try {
			Coordinate.verifyEditIsDisplayed();
			Coordinate.verifyDeleteIsDisplayed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Edit Search 1 to Priority = 'High'.
		msg = "Edit Search 1 to Priority = 'High'";
		cfunction.sync(2);
		try {
			Coordinate.editSearch1("Priority = 'High'");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Query syntax is updated.
		msg = "Query syntax is updated";
		cfunction.sync(2);
		try {
			Coordinate.verifyQuerySyntaxText("Priority = 'High'");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Click Cancel
		msg = "Click on cancel button of query syntax";
		cfunction.sync(2);
		try {
			Coordinate.clickCancelButtonQuerySyntax();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Edits in search isn't saved.
		msg = "Verify Edit in search should not saved";
		cfunction.sync(2);
		try {
			boolean check = Coordinate.verifyPriority("Medium");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Edit Search 1 to Priority = 'High' then Save.
		msg = "Edit Search 1 to Priority = 'High' then Save";
		cfunction.sync(2);
		try {
			Coordinate.editSearch1("Priority = 'High'");
			Coordinate.clickSaveButtonQuerySyntax();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// The Job List view is refreshed to return all high priority jobs
		
		msg ="The Job List view is refreshed to return all high priority jobs";
		cfunction.sync(2);
		try {
			boolean check = Coordinate.verifyPriority("High");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Select Search 2
		msg = "Select Search 2";
		cfunction.sync(10);
		try {
			Coordinate.clickSearch2();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Search 2 query is run. Job List view gets updated.
		msg="Search 2 query is run. Job List view gets updated";
		cfunction.sync(10);
		try {
			boolean check = Coordinate.verifyAssignedTo("Admin Admin");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Hover over Search 2 and delete the search.
		msg = "Hover over Search 2 and delete the search";
		cfunction.sync(2);
		try {
			Coordinate.hoverOnSearch2();
			cfunction.sync(5);
			Coordinate.clickDeleteSearch2();
			cfunction.sync(25);
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Search 2 is deleted from Recent category.
		msg = "Search 2 is deleted from Recent category";
		cfunction.sync(2);
		try {
			Coordinate.verifySearch_2IsDisplayed();
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		// Job List is cleared and shows: No data available
		/*msg = "Job List is cleared and shows: No records found";
		cfunction.sync(2);
		try {
			Coordinate.verifyNoDataAvailableIsDisplayed();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		
		// Click Search 1
		msg = "Click on Search 1";
		cfunction.sync(2);
		try {
			Coordinate.clickDeleteSearch1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Search 1 runs and jobs returned.
		cfunction.sync(2);
		msg ="Search 1 runs and jobs returned";
		try {
			boolean check = Coordinate.verifyPriority("High");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Log out of the web app.
		msg="Log out of the web app";
		cfunction.sync(2);
		try {
			Coordinate.clickOnSignout();
			cfunction.sync(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Log in again
		msg = "Log in again";
		try {
			
		//	CommonFunction.openNewTabsWithURL("https://mcstest62.esri.com/portal/apps/workflowmanager/");
			
			cfunction.sync(2);
			//driver.get("https://mcstest62.esri.com/portal/apps/workflowmanager/");
			cfunction.sync(2);
			LoginPage  lp = new LoginPage();
			//lp.loginToApplication1(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));
			lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Verify custom searches were not saved after log out
		msg = "Verify custom searches were not saved after log out";
		cfunction.sync(10);
		try {
			Coordinate.clickOnLeftCollapseBtn();
			cfunction.sync(2);
			Coordinate.clickOnAllJob();
			Coordinate.verifySearch_1IsDisplayed();
			Coordinate.verifySearch_2IsDisplayed();
			CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(2);

	}
}
