package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS35_DesignPageDefineLocationConfig  extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName = cfunction.getUniqueName("Attachment");
	
	public void workflow_TS35_DesignPageDefineLocationConfig() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on Diagram in left menu
		msg = "Click on Diagram in left menu";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on create new button
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//edited by sarath
		// Enter the Diagram Name
		msg = "Enter the Diagram Name";
		try {
			Design.enterDiagramName("TEST DIAGRAM");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Verify a new diagram should open with a single step on the canvas
		msg = "Verify Canvas is visible with start/End step";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click and drag 'Define Location' step
		msg = "Click on \"Define Location\" step in Step Library under \"Advanced\" category.";
		try {
			Design.clickOnAdvanceStepList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Drag the step template into the diagram editing canvas.
		msg = " Drag the step template into the diagram editing canvas.";
		try {
			Design.enterSearchStepTemplate("Define Location");
			cfunction.sync(2);
			Design.dragStepToCanvas("TS35_DefineLocation", "BlankCanvas");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify step Name text
		msg = "Verify step Name with the text 'Define Location'";
		try {
			boolean check = Design.verifyStepName("Define Location");
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
		// Verify step Description text
		msg = "Verify step description with the text 'Define a location for the job'";
		try {
			Design.clickOnStepDetailAboutTab();
			boolean check = Design.verifyStepDesc("Define a location for the job");
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
		// Under logic, click 'Edit' to edit the arguments
		msg = "Click 'Edit' to edit the arguments";
		try {
			Design.clickOnStepDetailPropertiesTab();
			//Design.clickEditArgument();
			Design.clickAddbtn();
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(6);

		// Verify the ' Define Location Step' dialog opens up
		msg = "Verify the 'Define Location Step' dialog opens";
		try {
			boolean check = Design.verifyDialogueBoxName("ArcGIS Online");
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
		//cfunction.Commmon_Click("xpath", "//button[@class='p-button noFill t-featureServiceModalCancelBtn']");
		cfunction.sync(2);
		// Add 'test' under In the web app open the following map.
		//msg = "Add 'test' under In the web app open the following map.";
		msg= "Choose ArcGIS Online option and enter the ItemID";
		try {
			Design.enterInputInWebApp("b6d2a1a1a782497a8453006189a270fa");
			/*Design.enterInputInWebApp("test");*/
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);	
		msg="Click OK after entering Item ID";
		try {
			cfunction.Commmon_Click("xpath", "//button[@class='p-button t-featureServiceModalOkBtn']");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		}
		catch(Exception e){
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Add 'Please, define a location' under User Prompt. Set
		msg = "Add 'Please, define a location' under User Prompt.";
		try {
			Design.enterInputInUserPrompt("Please, define a location");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Location Method to 'Select and Draw'.
		/*msg = "Set Location Method to 'Select or Draw'";
		try {
			Design.selectFromLocationMethodDrpdwn("Select or Draw");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);

		// Set Job Location Geometry to Polygon
		msg = "Set Job Location Geometry to 'Polygon'";
		try {
			Design.selectFromJobLocationGeomatryDrpdwn("Polygon");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Save
		msg = "Click Save";
		try {
			Design.ClickOnSaveBtn();
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify the dialog is closed
/*		msg = "Verify the 'Define Location Step' dialog closed";
		try {
			boolean check = Design.verifyDialogueBoxName1();
			if (check) {
				CommonFunction.logStatus("FAIL", msg);
			}

			else {
				CommonFunction.logStatus("PASS", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}*/
		cfunction.sync(2);
/*		msg = "Verify Argument value 'Map Name' is 'blank'";
		try {
			boolean check = Design.verifyArgumentValue1("");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);
		msg = "Verify Argument value 'URL' is 'CaliMap'";
		try {
			boolean check = Design.verifyArgumentValue2("CaliMap");
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
		msg = "Verify Argument value 'User Prompt' is 'Please, define a location'";
		try {
			boolean check = Design.verifyArgumentValue3("Please, define a location");
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
		msg = "Verify Argument value 'Job Location Geometry Type' is 'Polygon'";
		try {
			boolean check = Design.verifyArgumentValue4("Polygon");
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
		msg = "Verify Argument value 'Location Method' is 'Select or Draw'";
		try {
			boolean check = Design.verifyArgumentValue5("SELECTION METHOD");
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

		// Click Edit
		/*msg = "Click 'Edit' to edit the arguments";
		try {
			Design.clickEditArgument();
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// Set Location Method to Select
		msg = "Set Location Method to 'Select'";
		try {
			Design.selectFromLocationMethod();
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Set Job Location Geometry to Point.
		msg = "Set Job Location Geometry to 'Point'";
		try {
			Design.selectFromJobLocationGeomatryDrpdwn("Point");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click Cancel
		/*msg = "Click Cancel";
		try {
			Design.ClickOnCancelBtn();
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);

		// Verify the arguments are not saved and the dialog is closed

/*		msg = "Verify the 'Define Location Step' dialog closed";
		try {
			boolean check = Design.verifyDialogueBoxName("Define Location Step");
			if (check) {
				CommonFunction.logStatus("FAIL", msg);
			}

			else {
				CommonFunction.logStatus("PASS", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}*/
		cfunction.sync(2);
		// Verify The arguments are saved
		msg = "Verify Argument value 'Map Name' is 'CaliMap'";
		try {
			boolean check = Design.verifyArgumentValue1("CaliMap");
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
/*		cfunction.sync(2);
		msg = "Verify Argument value 'URL' is 'CaliMap'";
		try {
			boolean check = Design.verifyArgumentValue2("CaliMap");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);
		msg = "Verify Argument value 'User Prompt' is 'Please, define a location'";
		try {
			boolean check = Design.verifyArgumentValue3("Please, define a location");
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
/*		msg = "Verify Argument value 'Job Location Geometry Type' is 'Polygon'";
		try {
			boolean check = Design.verifyArgumentValue4("Polygon");
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);
		msg = "Verify Argument value 'Location Method' is 'Select or Draw'";
		try {
			boolean check = Design.verifyArgumentValue5("SELECTION METHOD");
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
	}
}
