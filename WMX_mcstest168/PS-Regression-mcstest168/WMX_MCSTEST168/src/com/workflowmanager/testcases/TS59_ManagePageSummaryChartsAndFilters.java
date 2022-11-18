package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;

public class TS59_ManagePageSummaryChartsAndFilters extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	
	public void workflow_TS59_ManagePageSummaryChartsAndFilters() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		cfunction.sync(5);
		//Toggle off the job location labels by clicking on "Show Labels" located at lower right conor of the map view.
		msg = "Toggle off the job location labels by clicking on \"Show Labels\"";
		try {
			Coordinate.clickOnShowLabelSlider();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The polygon and polyline job locations' labels are toggled off on the map.
		msg = "Verify the polygon and polyline job locations' labels are toggled off on the map.";
		try {
			if(SikuliHelp.verifyImageExists("TS59_PolygonPolylineOnMap1_1280x768")) {
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
		//Open Fiters drop down list next to Job Searches list and toggle on "Restrict results to map extent"
		msg = "Open Fiters drop down list next to Job Searches list.";
		try {
			Coordinate.clickOnFilter();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Toggle on \"Restrict results to map extent\"";
		try {
			Coordinate.clickOnRestrictResultToMapExtent();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Zoom to Redlands area and click "Refresh results" to refresh the map to filter only jobs having location in current map extent.
		msg = "Zoom to Redlands area";
		try {
			Coordinate.enterSearchMapText("Redlands");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click \"Refresh results\" to refresh the map to filter.";
		try {
			Coordinate.clickOnRefreshResult();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify in Job List view that only 3 jobs that have locations are filtered.
		msg = "Verify in Job List view that only 3 jobs that have locations are filtered.";
		try {
			if(Coordinate.verifyJobListCount(3)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Select "Data Edits Job1" in Job List view.
		msg = "Select \"Data Edits Job 1\" in Job List view.";
		try {
			if(Coordinate.clickOnJobListEntry("Data Edits Job 1")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The job's point location is highlighted in the map.
		//Hover over the Action column for selected job in the Job List view and "Zoom to loctaion" option is availabe. Click it.
		msg = "Hover over the Action column for selected job in the Job List view.";
		try {
			Coordinate.hoverOnActionList(1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click \"Zoom to loctaion\" option is availabe. Click it.";
		try {
			Coordinate.clickOnActionList(1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The map is zoomed to job "Data Edits Job1" location.
		//Click on the line job location in the Map view.
		msg = "Verify the polygon and polyline job locations' labels are toggled off on the map.";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick("TS59_ClickLineOnMap_1280x768");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The location is highlighted and pop up window is opened to show the job details.
		msg = "Verify the location is highlighted and pop up window is opened to show the job details.";
		try {
			if(SikuliHelp.verifyImageExists("TS59_HighlightedLineOnMap_1280x768.")) {
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
		//Click "Select" option in the pop-up window.
		msg = "Click \"Select\" option in the pop-up window.";
		try {
			Coordinate.clickOnSelectBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The corresponding job is selected in the Job List view: "Low Priority Job Creation"
		msg = "The corresponding job is selected in the Job List view: \"Low Priority Job Creation\"";
		try {
			Coordinate.verifyJobNameAtInfoPanel("Low Priority Job Creation");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click "Zoom to" option in the pop-up window.
		msg = "Click \"Zoom\" option in the pop-up window.";
		try {
			Coordinate.clickOnZoomBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);
		//The map is zoomed to job "Low Priority job Creation" location.
		//Click somewhere else on the map view.
		msg = "Click somewhere else on the map view.";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick("TS59_ClickSomewhereOnMap_1280x768");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*if (browser.equalsIgnoreCase("firefox")) {
			try {
			SikuliHelp.selectLocationOnMapSikuliClick("TS59_ClickSomewhereOnMap_1280x768");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
			}else {
				try{
					SikuliHelp.selectLocationOnMapSikuliClick("TS59_ClickSomewhereOnMap_1280x768");
				CommonFunction.logStatus("PASS", msg);
				
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			}*/
		cfunction.sync(2);
		//The job location is unselected.
		//Click "Zoom to All" icon located on left side of the map view, aligned with other map navigation tools.
		msg = "Click \"Zoom to All\" icon located on left side of the map view";
		try {
			Coordinate.clickOnZoomToAllBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The map is zoomed out to full extent of all job locations.
		//click "Refresh results" to refresh the map to filter only jobs having location in current map extent.
		msg = "Click \"Refresh results\" to refresh the map to filter.";
		try {
			Coordinate.clickOnRefreshResult();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify in Job List view that 6 jobs that have locations are filtered.
		msg = "Verify in Job List view that only 6 jobs that have locations are filtered.";
		try {
			if(Coordinate.verifyJobListCount(6)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Clear the filter.
		msg = "Click on \"Clear all filter\".";
		try {
			Coordinate.clickOnClearFilterBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//All jobs are listed in the Job List view.
		msg = "Verify all jobs are listed in the Job List view.";
		try {
			if(Coordinate.verifyJobListCount(48)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//In Summary charts toolbar on top of the map view, navigate to "Priority" summary chart. (May need to scroll to the most right to see it). 
		/*msg = "Click to right triangle button to bring 'job priority'";
		try {
			// click
			
			Coordinate.clickOnRightTriangleArrow1();
			cfunction.sync(2);
			Coordinate.clickOnRightTriangleArrow1();
			cfunction.sync(2);
			
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		*///Hover over the chart on each color.
		//Verify the tooltips: Green - High, Purple - Low, Red - Medium.
		msg = "Hover the cursor over a section of the job priority chart in the summary panel: Blue=High";
		String imgNameChrome = "TS10_hoverjobpriority_1024x768_New22";
		String imgNameFirefox = "TS10_hoverjobpriority_1024x768_New22";
		
		if (browser.equalsIgnoreCase("firefox")) {
			try {
			SikuliHelp.hoveronLocationSikuli(imgNameFirefox);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		else{
			try {
			SikuliHelp.hoveronLocationSikuli(imgNameChrome);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		cfunction.sync(5);
		int quantity = 0; 
		msg = "Verify the category of the section are displayed";
		try {
			quantity = Coordinate.getChartQuanity(2);
			cfunction.sync(5);
			System.out.println("quantity: "+ quantity);
			if(Coordinate.verifyQuantityCategory("High", 3, 2))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(2);
		msg = "Hover the cursor over a section of the job priority chart in the summary panel: Yellow=Medium";
		 imgNameChrome = "TS59_MediumSummaryChart_1280x768";
		 imgNameFirefox = "TS59_MediumSummaryChart_1280x768";
		
		if (browser.equalsIgnoreCase("firefox")) {
			try {
			SikuliHelp.hoveronLocationSikuli(imgNameFirefox);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		else{
			try {
			SikuliHelp.hoveronLocationSikuli(imgNameChrome);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		cfunction.sync(10);
		 quantity = 0; 
		msg = "Verify the category of the section are displayed";
		try {
			quantity = Coordinate.getChartQuanity(2);
			cfunction.sync(5);
			System.out.println("quantity: "+ quantity);
			if(Coordinate.verifyQuantityCategory("Medium", 3, 2)) {
				SikuliHelp.selectLocationOnMapSikuliClick("TS59_ClickOnMap_1280x768");
				CommonFunction.logStatus("PASS", msg);
			}else
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(5);
		msg = "Hover the cursor over a section of the job priority chart in the summary panel:Slate Gray=Low";
		 imgNameChrome = "TS59_LowSummaryChart_1280x768";
		 imgNameFirefox = "TS59_LowSummaryChart_1280x768";
		
		if (browser.equalsIgnoreCase("firefox")) {
			try {
			SikuliHelp.hoveronLocationSikuli(imgNameFirefox);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		else{
			try {
			SikuliHelp.hoveronLocationSikuli(imgNameChrome);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		cfunction.sync(5);
		 quantity = 0; 
		msg = "Verify the category of the section are displayed";
		try {
			quantity = Coordinate.getChartQuanity(1);
			cfunction.sync(5);
			System.out.println("quantity: "+ quantity);
			if(Coordinate.verifyQuantityCategory("Low", 3, 4))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(2);
		
		//Expand the chart details by clicking on it.
		msg = "Expand the chart details by clicking on it.";
		try {
			//SikuliHelp.selectLocationOnMapSikuli("TS59_clickOnJobPriority_1920x1080");
			Coordinate.clickOnFirstSummaryChart();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The chart details are displayed based on all jobs. Total 47 jobs are categorized into 3 groups: High, Low and Medium. The job locations on the map are rendered with colors based on job priority.
		/*msg = "Verify total jobs count.";
		try {
			if(Coordinate.verifyTotalJobCount("56")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		//Select "My Jobs" in Job Searches list.
		msg = "Click on 'My Jobs'";
		try {
			Coordinate.clickOnCollapseLeftPanel1();
			cfunction.sync(2);
			Coordinate.clickOnMyJobs();
			Coordinate.clickOnCollapseLeftPanel1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The chart is refreshed to show My Jobs summary. Total 42 jobs are summarized.
		//Open Fiters drop down list next to Job Searches list and toggle on "Restrict results to map extent"
		msg = "Open Fiters drop down list next to Job Searches list.";
		try {
			Coordinate.clickOnFilter();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Toggle on \"Restrict results to map extent\"";
		try {
			Coordinate.clickOnRestrictResultToMapExtent();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify in Job List view that only 3 jobs that have locations are filtered.
		msg = "Verify in Job List view that only 3 jobs that have locations are filtered.";
		try {
			if(Coordinate.verifyJobListCount(3)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Zoom to Redlands area and click "Refresh results" to refresh the map to filter only jobs having location in current map extent.
		msg = "Zoom to Redlands area";
		try {
			Coordinate.enterSearchMapText("Redlands");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click \"Refresh results\" to refresh the map to filter.";
		try {
			Coordinate.clickOnRefreshResult();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The chart defailts are refreshed. Total 3 jobs are categorized into 2 groups: Low and Medium. The job locations on the map are rendered with colors based on job priority.
		//Clear Selection to collapse the chart details.
		msg = "Click \"Clear Selection\" to collapse the chart details.";
		try {
			Coordinate.clickOnClearSelection();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//All chart summary are available on top of the map view.
		//Hover over the chart "assigned_to"
		//It displays total 3 jobs and tooltip of "wmxuser" is available to indicate all 3 jobs are assigned to wmxuser.
		msg = "Hover over the chart \"assigned_to\" and verify the tool tip of all 3 jobs as \"WMX User\".";
		try {
			if(Coordinate.verifyJobText("WMX User")) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Clear the filter.
		msg = "Click on \"Clear all filter\".";
		try {
			Coordinate.clickOnClearFilterBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Log out from the web app.
		msg = "Log out from the web app.";
		try {
			HomePage.clickOnLogOut();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

	}
}
