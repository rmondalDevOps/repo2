package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;


public class TS10_SummaryChartsTest extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String expectedImage = "TS10_SummaryCharts_MyJobs.png";
	String expectedImage1 = "TS10_SummaryCharts_AllJobs.png";
	public void workflow_TS10_SummaryChartsTest() throws InterruptedException {

		CommonFunction.waitforHomePagetoload();
		System.out.println("DEBUG Point");
		//fetch the chart index and set the chart ID
		String chart = "chart3";
		try {
			int chartIndex = Coordinate.getChartIndex("JOB PRIORITY");
			if(chartIndex > -1)
				chart = "chart" + chartIndex;
			System.out.println("chartIndex: "+ chartIndex);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		cfunction.sync(2);
		msg = "Click on 'My Jobs'";
		try {
			Coordinate.clickOnCollapseLeftPanel1();
			cfunction.sync(2);
			Coordinate.clickOnMyJobs();
			;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Hover the cursor over a section of the job priority chart in the summary panel
		msg = "Click to right triangle button to bring 'job priority'";
		try {
			// click
			Coordinate.clickOnCollapseRightPanel1();
			cfunction.sync(2);
			Coordinate.clickOnCollapseLeftPanel1();
			cfunction.sync(2);
			Coordinate.clickOnAllJobs();
			cfunction.sync(2);
			Coordinate.clickOnMyJobs();
			cfunction.sync(2);
			Coordinate.clickOnCollapseLeftPanel1();
			/*Coordinate.clickOnRightTriangleArrow1();
			Coordinate.clickOnRightTriangleArrow1();
			cfunction.sync(2);
			Coordinate.clickOnRightTriangleArrow1();
			cfunction.sync(2);
			Coordinate.clickOnRightTriangleArrow1();*/
			System.out.println("click High");
			//cfunction.Commmon_Click("xpath", "//*[@class=' c3-shape c3-shape c3-arc c3-arc-High']");
			//Production.hoverOnChart(chart, "High");
			//SikuliHelp.hoveronLocationSikuli(imgName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			//CommonFunction.logStatus("FAIL", msg, expectedImage, 2137);
		}
		cfunction.sync(2);
		Coordinate.clickOnCollapseLeftPanel1();
		cfunction.sync(2);
		msg = "Hover the cursor over a section of the job priority chart in the summary panel";
		String imgNameChrome = "TS10_hoverjobpriority_1024x768_New22";
		//String imgNameFirefox = "TS10_hoverjobpriority_1024x768_Newfirefox";
		String imgNameFirefox = "TS10_hoverjobpriority_1024x768_New22";
		
		if (browser.equalsIgnoreCase("firefox")) {
			try {
			SikuliHelp.hoveronLocationSikuli(imgNameFirefox);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			//CommonFunction.logStatus("FAIL", msg, expectedImage, 2137);
		}}
		else{
			try {
				SikuliHelp.hoveronLocationSikuli(imgNameFirefox);
			//SikuliHelp.hoveronLocationSikuli(imgNameChrome);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			//CommonFunction.logStatus("FAIL", msg, expectedImage, 2137);
		}}
		cfunction.sync(5);
		int quantity = 0;
		//Verify the quantity and category of the section are displayed
		msg = "Verify the quantity and category of the section are displayed";
		try {
			quantity = Coordinate.getChartQuanity(3);
			cfunction.sync(5);
			System.out.println("quantity: "+ quantity);
			if(Coordinate.verifyQuantityCategory("High", 3, 3))
				CommonFunction.logStatus("PASS", msg);
			else {
				//CommonFunction.logStatus("FAIL", msg,2065);
				CommonFunction.logStatus("FAIL", msg);
				}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			//CommonFunction.logStatus("FAIL", msg, 2065);
		}
		cfunction.sync(2);
		//fetch the job details
		String chartDetail = null;
		try {
			 chartDetail = Coordinate.getChartDetail();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		cfunction.sync(5);
		//Click on 'All Jobs' in the Job Search panel
		msg = "Click on 'All Jobs' in the Job Search panel";
		try {
			Coordinate.clickOnCollapseLeftPanel1();
			cfunction.sync(2);
			Coordinate.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Verify the charts are updated
		msg = "Verify the charts are updated";
		try {
			String chartDetailUpdated = Coordinate.getChartDetail();
			if(!chartDetailUpdated.equals(chartDetail))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click to right triangle button to bring 'job priority'";
		try {
			// click
			
			/*Coordinate.clickOnRightTriangleArrow1();
			cfunction.sync(2);
			Coordinate.clickOnRightTriangleArrow1();
			cfunction.sync(2);*/
			/*Coordinate.clickOnRightTriangleArrow1();
			Coordinate.clickOnRightTriangleArrow1();
			cfunction.sync(2);
			Coordinate.clickOnRightTriangleArrow1();
			cfunction.sync(2);
			Coordinate.clickOnRightTriangleArrow1();*/
			System.out.println("click High");
			//cfunction.Commmon_Click("xpath", "//*[@class=' c3-shape c3-shape c3-arc c3-arc-High']");
			//Production.hoverOnChart(chart, "High");
			//SikuliHelp.hoveronLocationSikuli(imgName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			//CommonFunction.logStatus("FAIL", msg, expectedImage, 2137);
		}
		cfunction.sync(2);
		//Hover the cursor over the same section of the job priority chart as before
		msg = "Hover the cursor over the same section of the job priority chart as before";
		//String jobPriorityimgChrome = "TS10_hoverjobpriority2_1024x768_New22";
		String jobPriorityimgChrome = "TS10_hoverjobpriority2_1024x768_New";
		String jobPriorityimgFirFox = "TS10_hoverjobpriority2_1024x768_New";
		
			//Production.hoverOnChart(chart, "High");
			if (browser.equalsIgnoreCase("firefox")) {
				try {
					SikuliHelp.hoveronLocationSikuli(jobPriorityimgFirFox);
				CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					//CommonFunction.logStatus("FAIL", msg, expectedImage1, 2137);
				}
			} else {
				try{
					SikuliHelp.hoveronLocationSikuli(jobPriorityimgChrome);
				CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					//CommonFunction.logStatus("FAIL", msg, expectedImage1, 2137);
				}
			}

			/*SikuliHelp.hoveronLocationSikuli(jobPriorityimg);
			CommonFunction.logStatus("PASS", msg);*/
		
		cfunction.sync(5);
		
		//The quantity and category of the section should display with new values
		msg = "Verify the quantity and category of the section should display with new values";
		try {
			int quantityNew = Coordinate.getChartQuanity(3);
			cfunction.sync(5);
			if(Coordinate.verifyQuantityCategory("High", 3, 3) && quantityNew != quantity)
				CommonFunction.logStatus("PASS", msg);
			else
				{
				//CommonFunction.logStatus("FAIL", msg, expectedImage1, 2137);
				CommonFunction.logStatus("FAIL", msg);
				}
		} catch (Exception e) {
			e.printStackTrace();
			//CommonFunction.logStatus("FAIL", msg, expectedImage1, 2137);
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//cfunction.sync(5);
		
		//Production.clickOnMyJobs();
		//Production.clickOnAllJob();
		
		cfunction.sync(2);
		//Hover the cursor over a section of the job type chart
		String chartvalue = "chart1";
		try {
			int chartIndex = Coordinate.getChartIndex("JOB TYPE");
			if(chartIndex > -1)
				chart = "chartvalue" + chartIndex;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		cfunction.sync(2);
		msg = "Hover the cursor over a section of the job type chart";
		String jobTypeimgNameChrome = "TS10_hoverjobType3_1024x768_New";
		String jobTypeimgNameFirFox = "TS10_hoverjobType3_1024x768_New";
		//Coordinate.clickOnLeftTriangleArrow1();
		//cfunction.sync(2);
		//Coordinate.clickOnLeftTriangleArrow1();
		cfunction.sync(2);
		/*Coordinate.clickOnLeftTriangleArrow1();
		cfunction.sync(2);
		Coordinate.clickOnLeftTriangleArrow1();
		cfunction.sync(2);
		Coordinate.clickOnLeftTriangleArrow1();
		cfunction.sync(2);*/
			//Production.hoverOnChart1(chartvalue, "Survey-Workflow");
			if (browser.equalsIgnoreCase("firefox")) {
				try {
					SikuliHelp.hoveronLocationSikuli(jobTypeimgNameFirFox);
				CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					//CommonFunction.logStatus("FAIL", msg, expectedImage1, 2137);
					CommonFunction.logStatus("FAIL", msg);
				}
			} else {
				try {
					SikuliHelp.hoveronLocationSikuli(jobTypeimgNameChrome);
				CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					//CommonFunction.logStatus("FAIL", msg, expectedImage1, 2137);
					CommonFunction.logStatus("FAIL", msg);
				}
			
			
		} 
		cfunction.sync(5);
		
		//The quantity and category of the section should display
		msg = "The quantity and category of the section should display";
		try {
			quantity = Coordinate.getChartQuanity(1);
			cfunction.sync(5);
			if(Coordinate.verifyQuantityCategory("Survey Workflow", 1, 1))
				CommonFunction.logStatus("PASS", msg);
			else {
				//CommonFunction.logStatus("FAIL", msg, expectedImage1, 2137);
			    CommonFunction.logStatus("FAIL", msg);
			    }
		} catch (Exception e) {
			e.printStackTrace();
			//CommonFunction.logStatus("FAIL", msg, expectedImage1, 2137);
			CommonFunction.logStatus("FAIL", msg);
		}
	}
}
