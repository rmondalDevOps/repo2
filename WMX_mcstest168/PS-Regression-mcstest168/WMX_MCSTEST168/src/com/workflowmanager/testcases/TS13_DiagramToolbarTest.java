package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS13_DiagramToolbarTest extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS13_DiagramToolbarTest() throws InterruptedException {

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

		// Verify Job Templates panel is selected and populated with results
		msg = "Job Template list populated with results";
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

		// The tab panel should switch to display workflow diagrams
		msg = "Tab panel should switch to display workflow diagrams";
		String tabName = "Workflow Diagrams";
		try {
			if (Design.verifyTabPanel(tabName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Type 'Data' in to the search
		String searchText = xls.getCellData("en-us", 2, 9);
		msg = "Enter '" + searchText + "' in Search Textbox";
		try {
			Design.enterSearchTextInWorkflow(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify 'Data Edits Sample' is visible
		msg = "Verify 'Data Edits Sample' is visible";
		int WorkFlowIndex1 = -1;
		String diagram = "Data Edits Sample";
		try {
			WorkFlowIndex1 = Design.getWorkFlowIndex(diagram);
			if (WorkFlowIndex1 > -1)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Data Edits Sample' diagram
		msg = "Click on Data Edits Sample";
		try {
			Design.clickOnDiagram(diagram);
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
			if (Design.verifyHeader(diagramName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click the 'Edit' button
		msg = "Click the 'Edit' button";
		try {
			Design.clickOnEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The diagram editing page should load with the toolbar visible
		msg = "The diagram editing page should load with the toolbar visible";
		try {
			if (Design.verifyCanvas())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// URL should contain workflowmanager/design/diagrams/AWd1cu3KJLQ4IgUE0i7p
		String diagramId = "AWd1cu3KJLQ4IgUE0i7p";
		msg = "URL should contain workflowmanager/design/diagrams/AWd1cu3KJLQ4IgUE0i7p";
		try {
			if (Design.validateUrlChange(diagramId))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Hover over 'Active - Data Edits Sample'
		msg = "Hover the cursor over 'Data Edits Sample'";

		try {
			Design.hoverOnDiagramTitle();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'Data Edits Sample' tooltip should appear
		msg = "Verify a tooltip appears with 'Data Edits Sample'";
		try {
			if (Design.verifyDiagramTitleToolTip("Data Edits Sample"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*
		 * cfunction.sync(2);
		 * 
		 * // Hover over 'Add' button msg = "Hover over 'Add' button"; try {
		 * Design.hoverOnAdd(); CommonFunction.logStatus("PASS", msg); } catch
		 * (Exception e) { e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2);
		 * 
		 * // 'Add Step' tooltip should appear msg = "'Add Step' tooltip should appear";
		 * try { if(Design.verifyAddToolTip("Add Step"))
		 * CommonFunction.logStatus("PASS", msg); else CommonFunction.logStatus("FAIL",
		 * msg); } catch (Exception e) { e.printStackTrace();
		 * CommonFunction.logStatus("FAIL", msg); }
		 */
		cfunction.sync(2);
		// get the zoom level of the diagram
		int originalZoom = 0;
		try {
			originalZoom = Design.getDiagramZoomLevel();
		} catch (Exception ex) {
			System.out.println("Unable to get Zoom Level");
			ex.printStackTrace();
		}

		// Hover over '+' button
		msg = "Hover over '+' button";
		try {
			Design.hoverOnPlusSign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'Zoom In' tooltip should appear
		msg = "'Zoom In' tooltip should appear";
		try {
			//if (Design.verifyZoomInToolTip("Zoom In"))
			if (Design.verifyToolTipTextPresent("Zoom In"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click '+' button
		msg = "Click '+' button";
		try {
			Design.clickOnPlusSign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Diagram should zoom in
		msg = "Diagram should zoom in";
		try {
			int zoomIn = Design.getDiagramZoomLevel();
			if (zoomIn > originalZoom)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Hover over '-'
		msg = "Hover over '-' button";
		try {
			Design.hoverOnMinusSign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'Zoom Out' tooltip should appear
		msg = "'Zoom Out' tooltip should appear";
		try {
			//if (Design.verifyZoomOutToolTip("Zoom Out"))
			if (Design.verifyToolTipTextPresent("Zoom Out"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click '-' button
		msg = " Click '-' button";
		try {
			Design.clickOnMinusSign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Diagram should zoom out
		msg = "Diagram should zoom out";
		try {
			int zoomOut = Design.getDiagramZoomLevel();
			if (zoomOut <= originalZoom)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Hover over 'Align Diagram' button
		msg = "Hover over 'Align Diagram Horizontally' button";
		try {
			Design.hoverOnAlignDiagramHorizontally();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'Align Diagram Horizontally' tooltip should appear
		msg = "'Align Diagram Horizontally' tooltip should appear";
		try {
			//if (Design.verifyAlignDiagramHorizontallyToolTip("Align Diagram Horizontally"))
			if (Design.verifyToolTipTextPresent("Align Diagram Horizontally"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click 'Align Diagram Horizontally' button
		msg = " Click 'Align Diagram Horizontally' button";
		try {
			Design.clickOnAlignDiagramHorizontally();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

	/*	// Horizontal and Vertical Auto Align options should appear
		msg = "Horizontal and Vertical Auto Align options should appear";
		try {
			if (Design.verifyHorizontalVerticalAutoAlignOption())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'Horizontal Auto Align'
		msg = "Click 'Horizontal Auto Align'";
		try {
			Design.clickOnHorizontalAutoAlign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		// The diagram should align horizontally
		msg = "The diagram should align horizontally";
		try {
			if (Design.verifyDiagramAlignment("horizontal"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Hover over 'Align Diagram' button
				msg = "Hover over 'Align Diagram Vertically' button";
				try {
					Design.hoverOnAlignDiagramVertically();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

				// 'Align Diagram Vertically' tooltip should appear
				msg = "'Align Diagram Vertically' tooltip should appear";
				try {
					//if (Design.verifyAlignDiagramVerticallyToolTip("Align Diagram Vertically"))
					if (Design.verifyToolTipTextPresent("Align Diagram Vertically"))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

				// Click 'Align Diagram Vertically' button
				msg = " Click 'Align Diagram Vertically' button";
				try {
					Design.clickOnAlignDiagramVertically();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
	/*	// Click 'Align Diagram' button
		msg = "Click 'Align Diagram Vertically' button";
		try {
			Design.clickOnAlignDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		/*// 'Horizontal and Vertical Auto Align options should appear
		msg = "Horizontal and Vertical Auto Align options should appear";
		try {
			if (Design.verifyHorizontalVerticalAutoAlignOption())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click 'Vertical Auto Align'
		msg = "Click 'Vertical Auto Align'";
		try {
			Design.clickOnVerticalAutoAlign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// 'The diagram should align vertically
		msg = "The diagram should align vertically";
		try {
			if (Design.verifyDiagramAlignment("vertical"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Hover over '<' button
		msg = "Hover over '<' button";
		try {
			Design.hoverOnUndoButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'Undo' tooltip should appear
		msg = "'Undo' tooltip should appear";
		try {
			//if (Design.verifyUndoToolTip("Undo"))
			if (Design.verifyToolTipTextPresent("Undo"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click '<' button
		msg = "Click '<' button";
		try {
			Design.clickOnUndoButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'The diagram should align horizontally
		msg = "The diagram should align horizontally";
		try {
			if (Design.verifyDiagramAlignment("horizontal_2"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Hover over '>' button
		msg = "Hover over '>' button";
		try {
			Design.hoverOnRedoButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'Redo' tooltip should appear
		msg = "'Redo' tooltip should appear";
		try {
			//if (Design.verifyRedoToolTip("Redo"))
			if (Design.verifyToolTipTextPresent("Redo"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click '>' button
		msg = "Click '>' button";
		try {
			Design.clickOnRedoButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'The diagram should align vertically
		msg = "The diagram should align vertically";
		try {
			if (Design.verifyDiagramAlignment("vertical_2"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*
		 * 
		 * cfunction.sync(2); // Hover over 'Print' button msg =
		 * "Hover over 'Print' button"; try { Design.hoverOnPrintButton();
		 * CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2); // 'Print Diagram' tooltip should appear msg =
		 * "'Print Diagram' tooltip should appear"; try {
		 * if(Design.verifyPrintToolTip("Print Diagram"))
		 * CommonFunction.logStatus("PASS", msg); else CommonFunction.logStatus("FAIL",
		 * msg); } catch (Exception e) { e.printStackTrace();
		 * CommonFunction.logStatus("FAIL", msg); }
		 */
		cfunction.sync(2);

		// Hover over 'Left Layout' button
		msg = "Hover over 'Left Layout' button";
		try {
			Design.hoverOnLeftLayoutButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// 'Toggle Left Panel' tooltip should appear
		/*msg = "'Toggle Left Panel' tooltip should appear";
		try {
			if (Design.verifyLeftLayoutToolTip("Collapse Panel"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		// Click 'Left Layout' button
		msg = "Click 'Left Layout' button";
		try {
			Design.clickOnLeftLayoutButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'The Step Library should no longer be visible
		msg = "The 'Step Library' should no longer be visible";
		try {
			if (Design.verifyStepLibraryPanel())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'Left Layout' button
		msg = "Click 'Left Layout' button";
		try {
			Design.clickOnLeftLayoutButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The Step Library should be visible
		msg = "The 'Step Library' should be visible";
		try {
			if (Design.verifyStepLibrary())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Hover over 'Right Layout' button
		msg = "Hover over 'Right Layout' button";
		try {
			Design.hoverOnRightLayoutButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// 'Toggle Right Panel' tooltip should appear
		/*msg = "'Toggle Right Panel' tooltip should appear";
		try {
			if (Design.verifyRightLayoutToolTip("Collapse Panel"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		// Click 'Right Layout' button
		msg = "Click 'Right Layout' button";
		try {
			Design.clickOnRightLayoutButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'The Diagram Settings should no longer be visible
		msg = "The 'Diagram Settings' should no longer be visible";
		try {
			if (!Design.verifyDiagramSettingsPanel())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'Right Layout' button
		msg = "Click 'Right Layout' button";
		try {
			Design.clickOnRightLayoutButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// 'The Diagram Settings should be visible
		msg = "The 'Diagram Settings' should be visible";
		try {
			if (Design.verifyDiagramSettings())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'Back' button
		msg = "Click 'Back' button";
		try {
			Design.clickOnBack();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click 'Back' button
		/*msg = "Click 'No' button";
		try {
			Design.clickOnNo();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		// 'The Workflow Diagram page should be visible
		msg = "The 'Workflow Diagram' page should be visible";
		try {
			if (Design.verifyWorkflowDiagramsPage())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
	}
}
