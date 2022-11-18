package com.workflowmanager.testcases;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;


public class TS63_ManagePageURL_Parameters extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS63_ManagePageURL_Parameters() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
	
		msg = "Verify by default it opens the Coordinate tab";
		try {
			//String URL = "https://mcstest62.esri.com/portal/apps/workflowmanager/554a740a715245118d322adf53c010db/coordinate";
			boolean check = HomePage.verifyLandingPage();
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
		 
		
		//Verify the url contains content=0, rightPanel=true, and leftPanel=true
		msg = "Verify the url contains \"content=0\"";
		try {
			String inputURL = "content=0";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		msg = "Verify the url contains \"rightPanel=true\"";
		try {
			String inputURL = "rightPanel=true";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		msg = "Verify the url contains \"leftPanel=false\"";
		try {
			String inputURL = "leftPanel=false";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		//Select the My Group Jobs search
		msg = "Click on 'My Group Jobs'";
		try {
			Coordinate.clickOnCollapseLeftPanel1();
			cfunction.sync(2);
			Coordinate.clickOnMyGroupJobs();
			//Coordinate.clickOnCollapseLeftPanel1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the URL updates to include the correct queryID
		msg = "Verify the url contains \"queryId=OnjS_8SoR6-iLE3oMCN44A\"";
		try {
			String inputURL = "queryId=OnjS_8SoR6-iLE3oMCN44A";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		//Collapse the left panel
		msg = "Collapse the left panel";
		try {
			Coordinate.clickOnCollapseLeftPanel1();
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the URL updates to leftPanel=false
		msg = "Verify the url contains \"leftPanel=false\"";
		try {
			String inputURL = "leftPanel=false";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		//Collapse the right panel
		msg = "Collapse the right panel";
		try {
			Coordinate.clickOnCollapseRightPanel1();
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the URL updates to rightPanel = false
		msg = "Verify the url contains \"rightPanel=false\"";
		try {
			String inputURL = "rightPanel=false";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		//Expand the left panel
		msg = "Expand the left panel";
		try {
			Coordinate.clickOnCollapseLeftPanel1();
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the URL updates to leftPanel=true
		msg = "Verify the url contains \"leftPanel=true\"";
		try {
			String inputURL = "leftPanel=true";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		//Expand the right panel
		msg = "Expand the right panel";
		try {
			Coordinate.clickOnCollapseRightPanel1();
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the URL updates to rightPanel = true
		msg = "Verify the url contains \"rightPanel=true\"";
		try {
			String inputURL = "rightPanel=true";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		//Expand the Map & List View dropdown and click Map view
		msg = "Expand the Map & List View dropdown and click Map view";
		try {
			Coordinate.selectUpdateViewFromDropdown("Map");
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify assert the job list is no longer visible
		//Verify the url updates to content=1
		msg = "Verify the url contains \"content=1\"";
		try {
			String inputURL = "content=1";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		// Edited by Sarath
		//Verify that the map takes up the full middle section
		msg = "Verify that the map takes up the full middle section";
		if (browser.equalsIgnoreCase("firefox")) {
			try {
			//String inputURL1 = "width: 1260px; height: 805px; display: block;";
			String inputURL1 = "width: 1198px; height: 845px; display: block;";

			
			boolean check = Coordinate.verifyCanvasStyle(inputURL1);
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		else if(browser.equalsIgnoreCase("Edge")) {
			try {
				//String inputURL = "width: 1260px; height: 776px; display: block;";
				String inputURL2 = "width: 1151px; height: 816px; display: block;";
				
				boolean check = Coordinate.verifyCanvasStyle(inputURL2);
				if (check) {
					CommonFunction.logStatus("PASS", msg);
				}

				else {
					CommonFunction.logStatus("FAIL", msg);
				}

			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}}
		
		else {
			try {
				
				//String inputURL3 = "width: 1260px; height: 774px; display: block;";
				//String inputURL3 = "width: 1431px; height: 816px; display: block;";
				String inputURL3 = "width: 1198px; height: 859px; display: block;";

				
				boolean check = Coordinate.verifyCanvasStyle(inputURL3);
				if (check) {
					CommonFunction.logStatus("PASS", msg);
				}

				else {
					CommonFunction.logStatus("FAIL", msg);
				}

			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}}
		
		cfunction.sync(2);
		//Expand the Map View dropdown and click List view
		msg = "Expand the Map & List View dropdown and click List view";
		try {
			Coordinate.selectUpdateViewFromDropdown("List");
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify "assert the map is no longer visible
		//Verify "the url updates to content=2
		msg = "Verify the url contains \"content=2\"";
		try {
			String inputURL = "content=2";
			boolean check = HomePage.verifyLandingPage1(inputURL);
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
		//Verify assert that the job list takes up the full middle section"
		//Collapse the right panel
		msg = "Collapse the right panel";
		try {
			Coordinate.clickOnCollapseRightPanel1();
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Refresh the page
		//Verify assert that the Manage page opens with the List view taking up the full middle section and the right panel collapsed

}
}
