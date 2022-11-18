package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;


public class TS09_DiagramSearchTest extends TestBase  {


	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS9_DiagramSearchTest() throws InterruptedException {
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

		// Click on the 'Diagrams' icon
		msg = "Click on the Diagrams icon";
		try {
			Design.clickOnDiagramsIcon();
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


		// The tab panel should switch to display workflow diagrams
		msg = "Tab panel should switch to display workflow diagrams";
		String tabName = "Workflow Diagrams";
		try {
			if(Design.verifyTabPanel(tabName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify Create New is visible
		msg = "Verify Create New is visible";
		try {
			if(Design.verifyCreateNewButton())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The header should display information for the first Workflow Diagram
		msg = "The header should display information for the First Workflow Diagram";
		int i =0;
		try {
			if(Design.verifyHeaderText(i))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);




		// The edit button should be enabled
		msg = "The edit button is enable";
		try {
			if(Design.verifyEditBtnIsEnabled())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);


		// Click the sort button
		msg = "Click the sort button";
		try {
			Design.clickOnSortBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// ' Survey Workflow' should be at the top of the list
		String WorkFlowName = "Update Properties Work";
		int WorkFlowIndex = -1;
		msg = "Verify the first job template is 'Update Properties Work'";
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


		// Click the sort button again
		msg = "Click the sort button";
		try {
			Design.clickOnSortBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The page should return to its previous state
		msg = "The page is returned to previous state";
		String WorkFlowName1 = "Add Comments";
		try {
			WorkFlowIndex = Design.getWorkFlowIndex(WorkFlowName1);
			if( WorkFlowIndex == 0)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Scroll to the bottom of the Workflow Diagrams panel
		msg="Workflow diagrams panel scrolled to the bottom";
		try {
			CommonFunction.ScrollBottom();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// 

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
		int WorkFlowIndex1 = -1;
		String WorkFlowName2 = "Data Edits Sample";
		try {
			WorkFlowIndex1 = Design.getWorkFlowIndex(WorkFlowName2);
			if( WorkFlowIndex1 > -1)
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
			Design.clickOnDiagram(WorkFlowName2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);



		// The header should populate with 'Active - Data Edits Sample'
		msg = "Header is populated with Active - Data Edits Sample";
		String diagramName = "Active - Data Edits Sample";
		try {
			Design.verifyHeader(diagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The diagram should populate with the corresponding canvas
		msg = "Diagram is populated in canvas";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);


		// Remove the search text
		searchText = ""; 
		msg = "Remove the search text";
		try {
			Design.clearSearchTextFrmWorkflow(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The search should update to show all diagrams again
		msg = "Verify the search is updated to show all diagrams";
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
