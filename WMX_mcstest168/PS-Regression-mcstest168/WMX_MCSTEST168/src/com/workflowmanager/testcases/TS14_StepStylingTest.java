package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS14_StepStylingTest extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS14_StepStylingTest() throws InterruptedException {

		CommonFunction.waitforHomePagetoload();
		cfunction.sync(5);
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
		msg ="Job Template list populated with results";
		try {
			if (Design.getAllJobsTemplateList() > 0)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
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
			if(Design.verifyTabPanel(tabName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Type 'Data' in to the search
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
		String diagram = "Data Edits Sample";
		try {
			WorkFlowIndex1 = Design.getWorkFlowIndex(diagram);
			if( WorkFlowIndex1 > -1)
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
			if(Design.verifyHeader(diagramName))
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
		//The diagram editing page should load with the toolbar visible
		msg = "The diagram editing page should load with the toolbar visible";
		try {
			if(Design.verifyCanvas())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//URL should contain workflowmanager/design/diagrams/AWd1cu3KJLQ4IgUE0i7p
		String diagramId = "AWd1cu3KJLQ4IgUE0i7p";
		msg = "URL should contain workflowmanager/design/diagrams/AWd1cu3KJLQ4IgUE0i7p";
		try {
			if(Design.validateUrlChange(diagramId))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		//In case of Firefox, zoom out to reach 51% zoom level
		Design.zoomToLevel(51);

		cfunction.sync(5);
		//Click the 'Define AOI' step	
		msg = "Click the 'Define AOI' step";
		try {
			String imgName = "TS14_DefineAOI";
			SikuliHelp.selectLocationOnMapSikuliClick(imgName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		//The Step Details panel should become visible
		msg = "The Step Details panel should become visible";
		tabName = "Step Details";
		try {
			if(Design.verifyRightPanel(tabName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Click the 'Style' tab on the Step Details panel
		msg = "Click the 'Style' tab on the Step Details panel";
		try {
			Design.clickOnStyleTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The panel should update to show styling options (Shape and Color)
		msg = "The panel should update to show styling options (Shape and Color)";
		try {
			if(Design.verifyShapeColor())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click the 'Shape' dropdown
		msg = "Click the 'Shape' dropdown";
		try {
			Design.clickOnShapeDropDown();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//A list of shapes should appear with a scrollbar
		msg = "A list of shapes should appear with a scrollbar";
		try {
			if(Design.verifyShapeDropdownMenu())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		String[] shapes = {"Triangle","Ellipse","Diamond","Trapezoid","Square","Circle","Rectangle"};
		
		for(int i = 0; i < shapes.length; i++) {
			
			//do not click  in the first iteration
			if(i > 0 )
				Design.clickOnShapeDropDown();
			String shape = shapes[i];
			cfunction.sync(2);

			//Select the 'Triangle' shape
			msg = "Select the '"+ shape+"' shape";
			try {
				Design.selectShapeFromDropdown(shape);
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			//The shape of the step should update on the canvas 
			msg = "The shape of the step should update to "+ shape +" on the canvas";
			try {
				String imgName = "TS14_"+ shape;
				if(SikuliHelp.verifyImageExists(imgName))
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			//The dropdown should show the triangle as being selected
			msg = "The dropdown should show the "+ shape +" as being selected";
			try {
				if(Design.verifySelectedShape(shape))
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);		
			
		}
		cfunction.sync(2);
		//Click the leftmost color (Red) in the Step Details pane	
		msg = "Click the leftmost color (Red) in the Step Details pane";
		try {
			Design.clickOnRedColor();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//The color of the step should update on the canvas
		msg = "The color of the step should update on the canvas";
		try {
			String imgName = "TS14_Red";
			if(SikuliHelp.verifyImageExists(imgName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//The color should become highlighted.
		msg = "The color should become highlighted";
		try {
			if(Design.verifyIfColorHighlighted())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Hover the cursor over the 'Color-wheel' icon 	
		msg = "Hover the cursor over the 'Color-wheel' icon";
		try {
			Design.hoverOnColorWheel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//'Use custom color' tooltip should become visible
		msg = "'Use custom color' tooltip should become visible";
		try {
			String imgName = "TS14_ColorToolTip";
			if(SikuliHelp.verifyImageExists(imgName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click the 'Color-wheel' icon 	
		msg = "Hover the cursor over the 'Color-wheel' icon";
		try {
			Design.clickOnColorWheel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The color picker should open
		msg = "The color picker should open";
		try {
			if(Design.verifyColorPicker())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Select a point near the center of the color gradient
		msg = "Select a point near the center of the color gradient";
		try {
			Design.selectColorFromPicker();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		
		//The color of the step should update on the canvas
		msg = "The color of the step should update on the canvas";
		try {
			String imgName = "TS14_ColorPickerSelected";
			if(SikuliHelp.verifyImageExists(imgName))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//The 'Color Wheel' icon should change to a 'Pencil' icon	
		/*msg = "The 'Color Wheel' icon should change to a 'Pencil' icon";
		try {
			//if(Design.verifyPencilIcon())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
	}
}
