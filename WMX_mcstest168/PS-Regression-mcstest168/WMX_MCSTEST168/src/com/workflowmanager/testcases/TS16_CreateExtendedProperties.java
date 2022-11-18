package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS16_CreateExtendedProperties extends TestBase {


	CommonFunction cfunction = new CommonFunction();
	String msg = "";
    
	public void workflow_TS16_CreateExtendedProperties() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();

		
		//		extendedProperties[0] = new String[]{"Prop1", "Property 1", "String",  "5", "valid"};
		//		extendedProperties[1] = new String[]{"Prop2", "Property 2", "Integer", "", "50"};
		//		extendedProperties[2] = new String[]{"Prop3", "Property 3", "DateTime", "", cfunction.getCurrentDate()};
		//		extendedProperties[3] = new String[]{"Prop4", "Property 4", "Boolean", "", "False"};

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
		//Click on 'Default Properties'
		msg = "Click on 'Default Properties'";
		try {
			Design.clickOnDefaultProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Verify "Design" View Opens & Job Templates panel is selected and populated with results
		msg ="Verify 'Design' View Opens & Job Templates panel is selected and populated with results";
		try {
			if(Design.getAllJobsTemplateList() > 0)
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on the 'Create New' job template icon	
		msg = "Click on 'Create New' job template icon";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the new job template is displayed. 
		msg ="Verify the new job template is displayed. ";
		try {
			if(Design.verifyNewJobTempate())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify in Profile tab, only "STATE" field is automatically populated with "Active".
		msg ="Verify in Profile tab, only 'STATE' field is automatically populated with 'Active'";
		try {
			if(Design.verifyState("Active"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		//Enter "JOB TEMPLATE NAME" in "New Job Template"	
		msg = "Enter Job Template name '" + jobTemplateName + "'";
		try {
			Design.enterJobTemplateName(jobTemplateName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Select "CURRENT WORKFLOW DIAGRAM" from the drop down list as "Data Edits Sample".	
		String selectText = "Data Edits Sample";
		msg = "From 'Current Workflow Diagram' dropdown select '"+ selectText + "'";
		try {
			Design.selectCurrentWorkflowDiagram(selectText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		//Verify the diagram is displayed in "PREVIEW".
		msg ="Verify the diagram is displayed in PREVIEW";
		try {
			if(Design.verifyDiagramIsDisplayed())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		//Click on "Extended Properties" tab.	
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
		//Verify "Extended properties" tab is displayed. 
		msg ="Verify the Extended properties is displayed";
		try {
			if(Design.verifyExtendedProperties())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		//Verify "New Table" button is available to allow user to add new extended property tables.
		msg ="Verify 'New Table' button is available to allow user to add new extended property tables.";
		try {
			if(Design.verifyNewTable())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);

		//Click on "New Table".	
		msg = "Click on 'New Table'";
		try {
			Design.clickOnNewTable();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify A new extended property table is added.
		msg ="Verify a new extended property table is added";
		try {
			if(Design.verifyNewExtendedTableAdded())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property table NAME as "Table1".	
		msg = "Enter extended property table NAME as '"+tableName+"'";
		try {
			Design.enterTableName(tableName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property table ALIAS as "Table 1".	
		msg = "Enter extended property table ALIAS as '"+ tableAlias+"'";
		try {
			Design.enterTableAlias("table 1");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on "Add Extended Property".
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
		String propName = "prop" + extendedPropIndex;
		String propAlias = "Property " + extendedPropIndex;
		//Verify an extended property is added.
		msg = "Verify An extended property is added";
		try {
			if(Design.verifyNewExtendedPropertyAdded(extendedPropIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property NAME : "Prop1".
		msg = "Enter extended property NAME: '"+ propName+"'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property ALIAS: "Property 1".
		msg = "Enter extended property ALIAS: '"+ propAlias +"'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Select TYPE from the drop down as "String".	
		msg = "Select TYPE from the drop down as 'String'";
		try {
			Design.selectExtendedPropertyType(extendedPropIndex, "String");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Verify The FIELD LENGTH is by default populated as 100.
		msg ="Verify The FIELD LENGTH is by default populated as 50";
		try {
			if(Design.verifyFieldLength("50"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Update FIELD LENGTH to 5.	
		msg ="Update FIELD LENGTH to 5";
		try {
			Design.enterFieldLength(extendedPropIndex, "5");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter VALUE as "Invalid".	
		msg ="Enter VALUE as 'Invalid'";
		try {
			Design.enterDefaultValue(5, "Invalid");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Verify the VALUE field is highlighted in RED indicating with tooltips: Default value exceeds field length. 
		msg = "Verify the VALUE field is highlighted in RED indicating with tooltips: Default value exceeds field length";
		try {
			String tooltip = "Default value exceeds field length";
			if(Design.verifyError_Tooltip(extendedPropIndex, tooltip))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter Correct the VALUE as "Valid".
		msg ="Enter Correct the VALUE as 'Valid'";
		try {
			Design.enterDefaultValue(5, "Valid");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		TestBase.extendedProperties[0] = new String[]{propName, propAlias, "String",  "5", "valid"};

		cfunction.sync(2);
		//Click on "Add Extended Property".
		msg = "Click on 'Add Extended Property'";
		try {
			Design.clickOnAddExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		extendedPropIndex = extendedPropIndex + 1;
		propName = "prop" + extendedPropIndex;
		propAlias = "Property " + extendedPropIndex;


		cfunction.sync(2);
		//Verify An extended property is added.
		msg = "Verify An extended property is added";
		try {
			if(Design.verifyNewExtendedPropertyAdded(extendedPropIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property NAME : "Prop2".
		msg = "Enter extended property NAME: '"+ propName+"'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property ALIAS: "Property 2".
		msg = "Enter extended property ALIAS: '"+propAlias+"'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Select TYPE from the drop down as "Integer".
		msg = "Select TYPE from the drop down as 'Integer'";
		try {
			Design.selectExtendedPropertyType(extendedPropIndex, "Integer");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter VALUE as "50".
		msg = "Enter VALUE as '50'";
		try {
			Design.enterDefaultValue(8, "50");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		extendedProperties[1] = new String[]{propName, propAlias, "Integer", "", "50"};

		cfunction.sync(2);
		//Click on "Add Extended Property".
		msg = "Click on 'Add Extended Property'";
		try {
			Design.clickOnAddExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		extendedPropIndex = extendedPropIndex + 1;
		propName = "prop" + extendedPropIndex;
		propAlias = "Property " + extendedPropIndex;


		cfunction.sync(2);
		//Verify An extended property is added.
		msg = "Verify An extended property is added";
		try {
			if(Design.verifyNewExtendedPropertyAdded(extendedPropIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property NAME : "Prop3".
		msg = "Enter extended property NAME: '"+ propName+"'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property ALIAS: "Property 3".
		msg = "Enter extended property ALIAS: '"+propAlias+"'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Select TYPE from the drop down as "Date".
		msg = "Select TYPE from the drop down as 'Date'";
		try {
			Design.selectExtendedPropertyType(extendedPropIndex, "Date");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Select current date
		msg = "Select current date";
		try {
			Design.selectCurrentDate(extendedPropIndex);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		extendedProperties[2] = new String[]{propName, propAlias, "DateTime", "", cfunction.getCurrentDate()};

		cfunction.sync(2);
		//Click on "Add Extended Property".
		msg = "Click on 'Add Extended Property'";
		try {
			Design.clickOnAddExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		extendedPropIndex = extendedPropIndex + 1;
		propName = "prop" + extendedPropIndex;
		propAlias = "Property " + extendedPropIndex;


		cfunction.sync(2);
		//Verify An extended property is added.
		msg = "Verify An extended property is added";
		try {
			if(Design.verifyNewExtendedPropertyAdded(extendedPropIndex))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property NAME : "Prop4".
		msg = "Enter extended property NAME: '"+ propName+"'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Enter extended property ALIAS: "Property 4".
		msg = "Enter extended property ALIAS: '"+propAlias+"'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Select TYPE from the drop down as "Boolean".
		msg = "Select TYPE from the drop down as 'Boolean'";
		try {
			Design.selectExtendedPropertyType(extendedPropIndex, "Boolean");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Select value 'False' from dropdown
		msg = "Select value 'False' from dropdown";
		try {
			Design.selectBooleanValueType(extendedPropIndex, "False");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		extendedProperties[3] = new String[]{propName, propAlias, "Boolean", "", "False"};

		cfunction.sync(2);

		//click on TAB key to see the SAVE BUTTON ON VNC
		cfunction.pressTAB(6);

		//Click on 'Save' to save the job template	
		msg = "Click on 'Save' to save the job template";
		try {
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Verify a message pops up "Do you want to proceed?"
		msg = "Verify a message pops up 'Do you want to proceed?'";
		try {
			if(Design.verifySaveDialog("Do you want to proceed?"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Click Save on the proceed confirmation message.
		msg = "Click Save on the proceed confirmation message";
		try {
			Design.ClickOnSaveDialog_SaveBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//cfunction.sync(2);
		//Verify a progress bar is shown indicating the saving process.
	/*	msg = "Verify a progress bar is shown indicating the saving process";
		try {
			if(Design.verifyProgressBar("Saving your changes..."))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		//cfunction.sync(2);
		//Verify Success message is displayed.
		msg = "Verify Success message is displayed.";
		String successMsg = "Job template: "+ jobTemplateName+" created successfully";
		try {
			if(Design.verifySuccessMsg(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);

		/*//Click on OK.
		msg = "Click on X button";
		try {
			Design.clickOnXBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/

		cfunction.sync(2);
		//Once the job template is saved, verify the extend property table and extended properties are populated as entered.	
		/*msg = "Once the job template is saved, verify the extend property table and extended properties are populated as entered";
		try {
			if(Design.verifySavedTemplate(extendedProperties))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		System.out.println(jobTemplateName);
		System.out.println(jobTemplateName);
		System.out.println(jobTemplateName);
		System.out.println(jobTemplateName);
		//TestBase.jobTemplateName1=jobTemplateName;
		
		msg = "Search "+ jobTemplateName+" in Search Job Template filter";
		try {
			Design.enterSearchStepTemplate(jobTemplateName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on "+jobTemplateName+" and verify Extended Property tab is visible";
		try {
			Design.clickOnJobTemplate(jobTemplateName);
			if (Design.verifyExtendedProperties())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Search "+ jobTemplateName+" in Search Job Template filter and verify Extended Property Table exists";
		try {
			Design.enterSearchStepTemplate("JOB ");
			Design.clickOnJobTemplate(jobTemplateName);
			Design.tableExist(tableName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
