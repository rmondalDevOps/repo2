package com.workflowmanager.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.Coordinate;

public class TS22_UpdateExtendedProperties extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String expectedImage ="TS22_UpdateExtendedProperties_StringValue.png";

	public void workflow_TS22_UpdateExtendedProperties() throws InterruptedException {
		cfunction.waitforHomePagetoload();

		System.out.println("this is a 22 test case variable   " + TestBase.jobTemplateName);

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
		// Click on Job Templates
		msg = "Click on Job Templates button";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on previously created Job Template from the list
		msg = "Click on previously created Job Template from the list";
		try {
			boolean check = Design.verifyJobTemplate(jobTemplateName);
			if (check) {
				Design.clickJobTemplateName(jobTemplateName);
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on 'Extended Properties' tab";
		try {
			Design.clickOnExtendedProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * //Verify A new extended property table is added. msg
		 * ="Verify a new extended property table is added"; try {
		 * if(Design.verifyNewExtendedTableAdded()) CommonFunction.logStatus("PASS",
		 * msg); else CommonFunction.logStatus("FAIL", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * 
		 * cfunction.sync(2);
		 */
		// Enter extended property table ALIAS as "Table ABC".
		msg = "Enter extended property table ALIAS as 'Table ABC";
		try {
			Design.enterTableAlias("Table ABC");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Enter extended property ALIAS: "Property 1".
		msg = "Enter extended property ALIAS as 'PropertyOne'";
		try {
			Design.enterExtendedPropertyAlias(1, "PropertyOne");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Enter VALUE as "Invalid".
		msg = "Enter VALUE as 'Invalid'";
		try {
			Design.enterDefaultValue(3, "Invalid");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Verify the VALUE field is highlighted in RED indicating with tooltips:
		// Default value exceeds field length.
		msg = "Verify the VALUE field is highlighted in RED indicating with tooltips: Default value exceeds field length";
		try {
			String tooltip = "Default value exceeds field length";
			if (Design.verifyError_Tooltip(1, tooltip))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter VALUE as "Test".
		msg = "Enter VALUE as 'Test'";
		try {
			Design.enterDefaultValue(3, "Test");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Check off the required box
		msg = "Check off the 'Required' box";
		try {
			Design.clickOnCheckBox(3);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify 'Required' box is checked off

		msg = "Verify 'Required' box is checked off";
		try {

			boolean check;
			if (check = Design.verifyCheckboxDeactive(1)) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Update "Prop2" property default value as string
		msg = "Verify property default value of Prop2 should not accept strings";
		try {
			Design.enterDefaultValue(5, "String");
			cfunction.sync(2);
			Design.clickOnExtendedProperties();
			cfunction.sync(2);
			boolean check;
			if (check = Design.verifyfilledinput()) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg, expectedImage, 2098);
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg, expectedImage, 2098);
		}
		cfunction.sync(2);
		// Check off 'EDITABLE' box
		msg = "Check off 'EDITABLE' box";
		try {
			Design.clickOnCheckBox(6);
			CommonFunction.logStatus("PASS", msg);
			// cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		cfunction.sync(2);
		/*
		 * //Update prop2 default value as '10.7'" try { Design.enterDefaultValue(2,
		 * "10.7"); CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 * cfunction.sync(2);
		 */
		// Check off 'EDITABLE' box

		msg = "Verify 'EDITABLE' box is checked off successfully";

		try {

			boolean check;
			if (check = Design.verifyCheckboxDeactive(2)) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Remove 'Prop3' property default value
		/*
		 * msg= "Remove 'Prop3' property default value"; try {
		 * Design.enterDefaultValue(3, ""); CommonFunction.logStatus("PASS", msg); }
		 * catch (Exception e) { e.printStackTrace(); CommonFunction.logStatus("FAIL",
		 * msg); }
		 */
		// Check off prop4 'VISIBLE' box
		msg = "Check off 'VISIBLE' box";
		try {
			Design.clickOnCheckBox(9);
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify 'VISIBLE' box is checked off successfully";

		try {

			boolean check;
			if (check = Design.verifyCheckboxDeactive(3)) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Update 'prop4' property default value as 'True'
		msg = "Update 'prop4' property default value as 'True'";
		try {
			Design.selectBooleanValueType(4, "True");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//extendedProperties[3] = new String[] { propName, propAlias, "Boolean", "", "True" };

		cfunction.sync(2);

		// click on TAB key to see the SAVE BUTTON ON VNC
		cfunction.pressTAB(6);

		// Click on 'Save' to save the job template
		msg = "Click on 'Save' to save the job template";
		try {
			Design.clickOnSave2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Verify a message pops up "Do you want to proceed?"
		msg = "Verify a message pops up 'Do you want to proceed?'";
		try {
			if (Design.verifySaveDialog("Do you want to proceed?"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Save on the proceed confirmation message
		msg = "Click on Save on the proceed confirmation message";
		try {
			Design.clickOnExtendedPropertiesConfirmationSaveButtonBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify a progress bar is shown indicating the saving process.
		/*msg = "Verify a progress bar is shown indicating the saving process";
		try {
			//if (Design.verifyProgressBar("Saving your changes..."))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		// Verify toast message pop up
		msg = "Verify toast message pop up for updates have been saved successfully";
		String successMsg = "Job template updated successfully";
		try {
			if (Design.verifySuccessMsg(successMsg))
				CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*
		 * cfunction.sync(2); // Verify the extend property table and properties are
		 * updated
		 * 
		 * msg= "Verify the extend property table and properties are updated"; try {
		 * Design.verifySuccessMsg("Job Template Updated Successfully");
		 * CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 */
		cfunction.sync(2);

		// Verify the edits made in previous steps have been saved properly
		/*msg = "Verify the edits made in previous steps have been saved properly";
		try {

			Design.clickJobTemplateName("Data Edits Sample");
			cfunction.sync(2);
			Design.clickJobTemplateName(jobTemplateName);
			Design.clickOnExtendedProperties();
		} catch (Exception e) {
			e.printStackTrace();

		}
		cfunction.sync(2);
		try {
			boolean check;
			if (check = Design.verifyExtendedPropertiesupdated()) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		//msg = "Incrementing jobTemplateName";
		try {

			/*cfunction.sync(2);
			Design.clickOnEllipsis();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			cfunction.sync(2);*/
			jobTemplateName=jobTemplateName+"_1";
			tableName=tableName+"_1";
			//CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			//CommonFunction.logStatus("FAIL", msg);
		}

	}
}
