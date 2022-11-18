package com.workflowmanager.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS37_View_EditDomainExtendedPropertiesInJobDetailsPanel extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS37_View_EditDomainExtendedPropertiesInJobDetailsPanel() throws InterruptedException {
		// CommonFunction.waitforHomePagetoload();
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
		msg = "Click on Job Templates";
		try {
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on 'Default Properties'
		msg = "Click on 'Extended Properties'";
		try {
			Design.clickOnDefaultProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify "Design" View Opens & Job Templates panel is selected and populated
		// with results
		msg = "Verify 'Design' View Opens & Job Templates panel is selected and populated with results";
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
		// Click on the 'Create New' job template icon
		msg = "Click on 'Create New' job template icon";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the new job template is displayed.
		msg = "Verify the new job template is displayed. ";
		try {
			if (Design.verifyNewJobTempate())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify in Profile tab, only "STATE" field is automatically populated with
		// "Active".
		msg = "Verify in Profile tab, only 'STATE' field is automatically populated with 'Active'";
		try {
			if (Design.verifyState("Active"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Enter "JOB TEMPLATE NAME" in "New Job Template"
		msg = "Enter Job Template name '" + jobTemplateName1 + "'";
		try {
			Design.enterJobTemplateName(jobTemplateName1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Select "CURRENT WORKFLOW DIAGRAM" from the drop down list as "Data Edits
		// Sample".
		String selectText = "Data Edits Sample";
		msg = "From 'Current Workflow Diagram' dropdown select '" + selectText + "'";
		try {
			Design.selectCurrentWorkflowDiagram(selectText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Verify the diagram is displayed in "PREVIEW".
		msg = "Verify the diagram is displayed in PREVIEW";
		try {
			if (Design.verifyDiagramIsDisplayed())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Click on "Extended Properties" tab.
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
		// Verify "Extended properties" tab is displayed.
		msg = "Verify the Extended properties is displayed";
		try {
			if (Design.verifyExtendedProperties())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Verify "New Table" button is available to allow user to add new extended
		// property tables.
		msg = "Verify 'New Table' button is available to allow user to add new extended property tables.";
		try {
			if (Design.verifyNewTable())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Click on "New Table".
		msg = "Click on 'New Table'";
		try {
			Design.clickOnNewTable();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify A new extended property table is added.
		msg = "Verify a new extended property table is added";
		try {
			if (Design.verifyNewExtendedTableAdded())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property table NAME as "Table1".
		msg = "Enter extended property table NAME as 'extproptab1'";
		try {
			Design.enterTableName("extproptab1");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property table ALIAS as "Table 1".
		msg = "Enter extended property table ALIAS as 'extpro'";
		try {
			Design.enterTableAlias("extpro");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on "Add Extended Property".
		msg = "Click on 'Add Extended Property'";
		try {
			Design.clickOnAddExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		int extendedPropIndex = 1;
		String propName = "extpropdomain" + extendedPropIndex;
		String propAlias = "extpropdmn" + extendedPropIndex;
		// Verify an extended property is added.
		msg = "Verify An extended property is added";
		try {
			if (Design.verifyNewExtendedPropertyAdded(extendedPropIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property NAME : "Prop1".
		msg = "Enter extended property NAME: '" + propName + "'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property ALIAS: "Property 1".
		msg = "Enter extended property ALIAS: '" + propAlias + "'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Select TYPE from the drop down as "Domain".
		msg = "Select TYPE from the drop down as 'Domain'";
		try {
			Design.selectExtendedPropertyType(extendedPropIndex, "Domain");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Zoom out to 90%";
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.body.style.zoom = '90%'");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add Domain
		msg = "Click on Add Domain";
		try {
			Design.clickOnAddDomainBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		msg = "Zoom out to 100%";
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.body.style.zoom = '100%'");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Select Data type from the drop down
		msg = "Select Data type from the drop down";
		try {
			Design.selectDataType("Integer");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter first value
		msg = "Enter first value";
		try {
			Design.enterEditDomainValues(1, "One");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter first code
		msg = "Enter first code";
		try {
			Design.enterEditDomainValues(2, "100");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Second value
		msg = "Enter Second value";
		try {
			Design.enterEditDomainValues(3, "Two");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Second code
		msg = "Enter Second code";
		try {
			Design.enterEditDomainValues(4, "200");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter third value
		msg = "Enter third value";
		try {
			Design.enterEditDomainValues(5, "Three");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter third code
		msg = "Enter third code";
		try {
			Design.enterEditDomainValues(6, "300");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter forth value
		msg = "Enter forth value";
		try {
			Design.enterEditDomainValues(7, "Zero");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter forth code
		msg = "Enter forth code";
		try {
			Design.enterEditDomainValues(8, "0");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Save Button
		msg = "Click on Save Button";
		try {
			Design.ClickOnSaveBtnOfDomain();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		cfunction.sync(2);
		extendedPropIndex = extendedPropIndex + 1;
		propName = "extpropdomain" + extendedPropIndex;
		propAlias = "extpropdmn " + extendedPropIndex;
		// Click on "Add Extended Property".
		msg = "Click on 'Add Extended Property'";
		try {
			Design.clickOnAddExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		// Verify an extended property is added.
		msg = "Verify An extended property is added";
		try {
			if (Design.verifyNewExtendedPropertyAdded(extendedPropIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property NAME : "Prop1".
		msg = "Enter extended property NAME: '" + propName + "'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property ALIAS: "Property 1".
		msg = "Enter extended property ALIAS: '" + propAlias + "'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Select TYPE from the drop down as "Domain".
		msg = "Select TYPE from the drop down as 'Domain'";
		try {
			Design.selectExtendedPropertyType(extendedPropIndex, "Domain");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		msg = "Zoom out to 90%";
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.body.style.zoom = '90%'");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add Domain
		msg = "Click on Add Domain";
		try {
			Design.clickOnAddDomainBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		msg = "Zoom out to 100%";
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.body.style.zoom = '100%'");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Select Data type from the drop down
		msg = "Select Data type from the drop down";
		try {
			Design.selectDataType("Double");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter first value
		msg = "Enter first value";
		try {
			Design.enterEditDomainValues(1, "Old");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter first code
		msg = "Enter first code";
		try {
			Design.enterEditDomainValues(2, "10.7");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Second value
		msg = "Enter Second value";
		try {
			Design.enterEditDomainValues(3, "Current");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Second code
		msg = "Enter Second code";
		try {
			Design.enterEditDomainValues(4, "10.8");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter third value
		msg = "Enter third value";
		try {
			Design.enterEditDomainValues(5, "Future");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter third code
		msg = "Enter third code";
		try {
			Design.enterEditDomainValues(6, "10.9");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Save Button
		msg = "Click on Save Button";
		try {
			Design.ClickOnSaveBtnOfDomain();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// cfunction.sync(2);

		// Click on "New Table".
		msg = "Click on 'New Table'";
		try {
			Design.clickOnNewTable1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify A new extended property table is added.
		msg = "Verify a new extended property table 2 is added";
		try {
			if (Design.verifyNewExtendedTable2Added())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property table NAME as "Table1".
		msg = "Enter extended property table NAME as 'extproptab2'";
		try {
			Design.enterTable2Name("extproptab2");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property table ALIAS as "Table 1".
		msg = "Enter extended property table ALIAS as 'extpro'";
		try {
			Design.enterTable2Alias("extpro2");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on "Add Extended Property".
		msg = "Click on 'Add Extended Property'";
		try {
			Design.clickOnAddExtendedPropertyBtn2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		extendedPropIndex = extendedPropIndex + 1;
		propName = "extpropdomain" + extendedPropIndex;
		propAlias = "extpropdmn " + extendedPropIndex;
		// Verify an extended property is added.
		msg = "Verify An extended property is added";
		try {
			if (Design.verifyNewExtendedPropertyAdded(extendedPropIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property NAME : "Prop1".
		msg = "Enter extended property NAME: '" + propName + "'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property ALIAS: "Property 1".
		msg = "Enter extended property ALIAS: '" + propAlias + "'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Select TYPE from the drop down as "Domain".
		msg = "Select TYPE from the drop down as 'Domain'";
		try {
			Design.selectExtendedPropertyType(extendedPropIndex, "Domain");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		msg = "Zoom out to 90%";
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.body.style.zoom = '90%'");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add Domain
		msg = "Click on Add Domain";
		try {
			Design.clickOnAddDomainBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		msg = "Zoom out to 100%";
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.body.style.zoom = '100%'");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Select Data type from the drop down
		msg = "Select Data type from the drop down";
		try {
			Design.selectDataType("String");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter first value
		msg = "Enter first value";
		try {
			Design.enterEditDomainValues(1, "Agricultural");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter first code
		msg = "Enter first code";
		try {
			Design.enterEditDomainValues(2, "A");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Second value
		msg = "Enter Second value";
		try {
			Design.enterEditDomainValues(3, "Residential");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter Second code
		msg = "Enter Second code";
		try {
			Design.enterEditDomainValues(4, "R");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter third value
		msg = "Enter third value";
		try {
			Design.enterEditDomainValues(5, "Commercial");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter third code
		msg = "Enter third code";
		try {
			Design.enterEditDomainValues(6, "C");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Add New Value Button
		msg = "Click on Add New Value Button";
		try {
			Design.ClickOnAddNewValue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter forth value
		msg = "Enter forth value";
		try {
			Design.enterEditDomainValues(7, "Transport");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter forth code
		msg = "Enter forth code";
		try {
			Design.enterEditDomainValues(8, "T");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on Save Button
		msg = "Click on Save Button";
		try {
			Design.ClickOnSaveBtnOfDomain();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// cfunction.sync(2);
		// Click on "Add Extended Property".
		msg = "Click on 'Add Extended Property'";
		try {
			Design.clickOnAddExtendedPropertyBtn2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		extendedPropIndex = extendedPropIndex + 1;
		propName = "extpropdomain" + extendedPropIndex;
		propAlias = "extpropdmn " + extendedPropIndex;
		// Verify an extended property is added.
		msg = "Verify An extended property is added";
		try {
			if (Design.verifyNewExtendedPropertyAdded(extendedPropIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property NAME : "Prop1".
		msg = "Enter extended property NAME: '" + propName + "'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter extended property ALIAS: "Property 1".
		msg = "Enter extended property ALIAS: '" + propAlias + "'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Select TYPE from the drop down as "String".
		msg = "Select TYPE from the drop down as 'String'";
		try {
			Design.selectExtendedPropertyType(extendedPropIndex, "String");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		cfunction.sync(2);
		// Verify The FIELD LENGTH is by default populated as 100.
		msg = "Verify The FIELD LENGTH is by default populated as 100";
		try {
			if (Design.verifyFieldLength("50"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Update FIELD LENGTH to 10.
		msg = "Update FIELD LENGTH to 10";
		try {
			Design.enterFieldLength(1, "10");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Enter VALUE as "Invalid".
		msg = "Enter VALUE as 'Read Only'";
		try {
			Design.enterDefaultValue(16, "Read Only");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on 'Save' to save the job template
		msg = "Click on 'Save' to save the job template";
		try {
			Design.clickOnSave();
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
		// Click Save on the proceed confirmation message.
		msg = "Click Save on the proceed confirmation message";
		try {
			Design.ClickOnSaveDialog_SaveBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// cfunction.sync(2);
		// Verify a progress bar is shown indicating the saving process.
		/*msg = "Verify a progress bar is shown indicating the saving process";
		try {
			if (Design.verifyProgressBar("Saving your changes..."))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		// cfunction.sync(2);
		// Verify Success message is displayed.
		msg = "Verify Success message is displayed.";
		String successMsg = "Job template: " + jobTemplateName + " created successfully";
		try {
			if (Design.verifySuccessMsg(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// **********************************************************************
		// Creating job using the template created above
		// **********************************************************************
		// Click on Production tab
		msg = "Click on Manage tab";
		try {
			HomePage.clickOnDesign();
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on 'New Job' Tab
		msg = "Click on 'New Job' Tab";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			Coordinate.clickOnNewJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Enter "Some" in Search Textbox
		// String searchText = xls.getCellData("en-us", 3,3);
		msg = "Enter '" + jobTemplateName1 + "' in Search Textbox";
		try {
			Coordinate.enterSearchText(jobTemplateName1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify 'Some Job Template' is displayed in the list
		msg = "Verify '" + jobTemplateName1 + "' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent(jobTemplateName1))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on 'Create Default' button of 'New test delete' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent(jobTemplateName1);
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
		// Verify New Job created successfully
		msg = "Verify New Job created successfully";
		try {

			Coordinate.verifySuccessMsg("successful");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		/******************************************************************************
		 * View edit at coordinate page
		 ********************************************************************************/
		msg = "Click on Manage tab";
		try {
			HomePage.clickOnDesign();
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on 'My Jobs'";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			Coordinate.clickOnMyJobs();
			;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on" + jobName;
		try {
			cfunction.waitforpagetoload();
			driver.navigate().refresh();
			Coordinate.clickOnJobListEntry(jobName);
			System.out.println(jobName + "selected");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Edit extproptab1 table by clicking on the pencil icon.
		msg = "Click on pencil icon of 'extpro'";
		try {

			Coordinate.clickOnFirstEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Open the drop down list for extpropdomain1
		msg = "Open the drop down list for extpropdomain1";
		try {

			Coordinate.openDropdown1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * Do not select a value in drop down and move away the cursor to other
		 * properties. The extpropdomain1 is highlighted in red to indicate this is a
		 * required property. Save button is disabled. Re-open the drop down list and
		 * type in "Zero".
		 */

		// Choose "Zero" for extpropdomain1
		msg = "Open the drop down list Choose 'Zero' for extpropdomain1";
		try {
			Coordinate.selectValueFromDropdown("Zero");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Open drop down for extpropdomain2.
		msg = "Open drop down for extpropdomain2.";
		try {

			Coordinate.openDropdown2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Choose "Current" for extpropdomain2
		msg = "Open the drop down list Choose 'Current' for extpropdomain1";
		try {
			Coordinate.selectValueFromDropdown("Current");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify the Save button is enabled";
		try {
			WorkPage.verifySaveBtnEnable();
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Save the updates.
		msg = "Click Save button";
		try {
			WorkPage.clickSaveBtn();
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Verify New Details updated successfully";
		try {

			WorkPage.verifySuccessMsg("successfully");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Edit extproptab2 table by clicking on the pencil icon.
		msg = "Click on pencil icon of 'extpro2'";
		try {
			cfunction.waitforpagetoload();
			driver.navigate().refresh();
			Coordinate.clickOnJobListEntry(jobName);
			//WorkPage.clickOnCollapseRightPane();
			Coordinate.clickOnSecondEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Open the drop down list for extpropdomain3
		msg = "Open the drop down list for extpropdomain3";
		try {

			Coordinate.openDropdown1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * In drop down list, enter an invalid value. Move away the cursor.
		 */
		// Choose "T" for extpropdomain3
		msg = "Open the drop down list Choose 'Transport' for extpropdomain1";
		try {
			Coordinate.selectValueFromDropdown("Transport");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Update value for extprop4
		// Save the updates.
		msg = "Click Save button";
		try {
			WorkPage.clickSaveBtn();
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Verify Toast message for Details updated successfully";
		try {

			WorkPage.verifySuccessMsg("successfully");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/******************************************************************************
		 * View edit at Work page
		 ********************************************************************************/
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on 'All Jobs'
		msg = "Click on 'ALL JOBS' Tab";
		try {
			WorkPage.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the 'NEW' filter by
		msg = "Click on the 'NEW' filter by";
		try {
			WorkPage.clickOnNewFilterBy();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Open Right Panel of Details";
		try {
			WorkPage.clickOnCollapseRightPane();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on the job created in previous steps
		msg = "Click on the job created in previous steps";
		try {
			cfunction.sync(19);
			WorkPage.clickOnJobDetails(jobName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Edit extproptab1 table by clicking on the pencil icon.
		msg = "Click on pencil icon of 'extpro'";
		try {
			cfunction.waitforpagetoload();
			Coordinate.clickOnFirstEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Open the drop down list for extpropdomain1
		msg = "Open the drop down list for extpropdomain1";
		try {

			Coordinate.openDropdown1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * Do not select a value in drop down and move away the cursor to other
		 * properties. The extpropdomain1 is highlighted in red to indicate this is a
		 * required property. Save button is disabled. Re-open the drop down list and
		 * type in "Zero".
		 */

		// Choose "Zero" for extpropdomain1
		msg = "Open the drop down list Choose 'One' for extpropdomain1";
		try {
			Coordinate.selectValueFromDropdown("One");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Open drop down for extpropdomain2.
		msg = "Open drop down for extpropdomain2.";
		try {

			Coordinate.openDropdown2();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Choose "Current" for extpropdomain2
		msg = "Open the drop down list Choose 'Old' for extpropdomain1";
		try {
			Coordinate.selectValueFromDropdown("Old");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify the Save button is enabled";
		try {
			WorkPage.verifySaveBtnEnable();
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Save the updates.
		msg = "Click Save button";
		try {
			WorkPage.clickSaveBtn();
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Verify Toast message for Details updated successfully";
		try {

			WorkPage.verifySuccessMsg("successfully");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Edit extproptab2 table by clicking on the pencil icon.
		msg = "Click on pencil icon of 'extpro2'";
		try {
			//driver.navigate().refresh();
			cfunction.sync(19);
			WorkPage.clickOnCollapseRightPane();
			WorkPage.clickOnJobDetails(jobName);
			
			WorkPage.clickOnCollapseRightPane();
			Coordinate.clickOnSecondEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Open the drop down list for extpropdomain3
		msg = "Open the drop down list for extpropdomain3";
		try {

			Coordinate.openDropdown1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*
		 * In drop down list, enter an invalid value. Move away the cursor.
		 */
		// Choose "T" for extpropdomain3
		msg = "Open the drop down list Choose 'Agricultural' for extpropdomain1";
		try {
			Coordinate.selectValueFromDropdown("Agricultural");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Update value for extprop4
		// Save the updates.
		msg = "Click Save button";
		try {
			WorkPage.clickSaveBtn();
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Verify Toast message for Details updated successfully";
		try {

			WorkPage.verifySuccessMsg("successfully");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

	}
}