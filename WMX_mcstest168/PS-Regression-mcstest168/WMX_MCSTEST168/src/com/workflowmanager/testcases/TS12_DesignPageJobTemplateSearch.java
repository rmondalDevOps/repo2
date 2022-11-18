package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS12_DesignPageJobTemplateSearch extends TestBase  {


	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS12_DesignPageJobTemplateSearch() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();

		// Click on Design Tab
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		//Click on Job Templates
		msg = "Click on Job Templates";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		int totalDiagrams = 0;
		try {
			totalDiagrams = Design.getAllDiagramList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		cfunction.sync(2);

		// Verify Job Templates panel is selected and populated with results
		msg ="Job Template list populated with results";
		try {
			Design.getAllJobsTemplateList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the filter button
		msg = "Click the filter button";
		try {
			Design.clickOnFilterButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Draft Workflow is visible
		String WorkFlowName = "Draft Workflow";
		int WorkFlowIndex = -1;
		msg = "Draft Workflow is visible";
		try {
			WorkFlowIndex = Design.getWorkFlowIndex(WorkFlowName);
			if( WorkFlowIndex == 0)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 	The Filter button is higlighted
		msg = "The Filter button is higlighted";
		try {
			if(Design.verifyIfFilterHighlighted())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click the filter button
		msg = "Click the filter button";
		try {
			Design.clickOnFilterButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);		
		// The page should return to its previous state
		msg = "The page is returned to previous state";
		String WorkFlowName1 = "Attachment_Selenium";
		try {
			WorkFlowIndex = Design.getWorkFlowIndex(WorkFlowName1);
			if( WorkFlowIndex == 1)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Scroll to the bottom of the Job Template panel
		msg="Job Template panel scrolled to the bottom";
		try {
			CommonFunction.ScrollBottom();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Survey Workflow should be visible
		msg = "Verify 'Survey Workflow' is visible";
		String jobTemplate = "Survey Workflow";
		try {
			if(Design.verifyJobTemplate(jobTemplate))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);


		// Type 'data' in to the search
		String searchText = xls.getCellData("en-us", 2,9);
		msg = "Enter '"+ searchText +"' in Search Textbox";
		try {
			Design.enterSearchTextInWorkflow(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify 'Data Edits Sample' is visible
		msg = "Verify 'Data Edits Sample' is visible";
		int WorkFlowIndex2 = -1;
		try {
			String WorkFlowName3 = "Data Edits Sample";
			WorkFlowIndex2 = Design.getWorkFlowIndex(WorkFlowName3);
			if( WorkFlowIndex2 > -1)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click 'Data Edits Sample'
		msg = "Click on Data Edits Sample";
		try {
			Design.clickOnDataEditsSample();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The header should populate with 'Data Edits Sample' and the number of active jobs
		msg = "Header is populated with Data Edits Sample";
		String diagramName = "Data Edits Sample";
		try {
			Design.verifyJobTemplateHeader(diagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//removing the check : based on inputs from Sam 
		/*msg = "Header is populated with number of active jobs";
		try {
			Design.getActiveJobs();
			if(Design.verifyActiveJobs())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		//The 'Profile' tab should be selected and populated with job template information
		msg = "The 'Profile' tab is selected and populated with job template information";
		try {
			if(Design.verifyIfProfileHighlighted())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}


		//Type 'For surveying' in to the search
		//String searchTxt = xls.getCellData("en-us", 2,12);
		String searchTxt = "For surveying";
		msg = "Enter '"+ searchTxt +"' in Search Textbox";
		try {
			Design.enterSearchTextInWorkflow(searchTxt);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Survey Workflow should be visible in the search
		msg = "Verify 'Survey Workflow' is visible";
		int WorkFlowIndex3 = -1;
		try {
			String WorkFlowName4 = "Survey Workflow";
			WorkFlowIndex3 = Design.getWorkFlowIndex(WorkFlowName4);
			if( WorkFlowIndex3 > -1)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click 'Survey Workflow'
		msg = "Click on Survey Workflow";
		try {
			Design.clickOnDataEditsSample();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//The view on the right should update with properties for Survey Workflow
		msg = "The view on the right is updated with properties for Survey Workflow";
		String JobTemplate = "Survey Workflow";
		try {
			Design.verifyJobTemplateHeader(JobTemplate);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);



		//Remove the search text
		searchText = ""; 
		msg = "Remove the search text";
		try {
			Design.clearSearchTextFrmWorkflow(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);

		//The search should update to show all job templates again
		msg = "Verify The search is updated to show all job templates again";
		try {
			if(Design.verifyAllDiagramsVisible(totalDiagrams))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);	
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}




	}

}

