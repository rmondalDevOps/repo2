/**
 * 
 */
package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

/**
 * @author arp97661
 *
 */
public class TS85_Duplicate_Job_Template {
	CommonFunction cfunction = new CommonFunction();
	String msg= "";
	
	public void workflow_TS85_Duplicate_Job_Template() {
		
		cfunction.waitforpagetoload();
		//Click on Design Page
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Click on Job Templates
		msg = "Click on Job Templates";
		try {
			cfunction.waitforpagetoload();
			cfunction.sync(21);
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg="Click on Data Edits Sample from Job Template";
		try {
			cfunction.sync(7);
			Design.selectItemFromList("Data Edits Sample");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify Data Edits Sample job template is open";
		try {
			cfunction.sync(21);
			if(Design.verifyJobTemplateHeader("Data Edits Sample")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Duplicate the Data Edit Sample Job Template";
		try {
			Design.duplicateTheTemplate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify Data Edits Sample job template has '- Copy' appended to the end of the name";
		try {
			cfunction.sync(21);
			if(Design.verifyJobTemplateHeader("Data Edits Sample - Copy")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Click on "Extended Properties" tab.
		msg = "Click on 'Extended Properties' tab";
		try {
			Design.clickOnExtendedProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
		    e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
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

	
		//Click on "New Table".	
		msg = "Click on 'New Table'";
		try {
			Design.clickOnNewTable();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
	
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
		
		//Enter extended property table NAME as "Table1".	
		msg = "Enter extended property table NAME as 'table_Data'";
		try {
			Design.enterTableName("table_Data");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Enter extended property table ALIAS as "Table 1".	
		msg = "Enter extended property table ALIAS as 'Table Data'";
		try {
			Design.enterTableAlias("Table Data");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Click on "Add Extended Property".
		msg = "Click on 'Add Extended Property'";
		try {
			Design.clickOnAddExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
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

		
		//Enter extended property NAME : "Prop1".
		msg = "Enter extended property NAME: '"+ propName+"'";
		try {
			Design.enterExtendedPropertyName(extendedPropIndex, propName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		
		//Enter extended property ALIAS: "Property 1".
		msg = "Enter extended property ALIAS: '"+ propAlias +"'";
		try {
			Design.enterExtendedPropertyAlias(extendedPropIndex, propAlias);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg="Click on Save Button for Job Template";
		try {
			cfunction.sync(5);
			Design.clickOnSave();
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		
		
		msg="Save changes";
		try {
			cfunction.sync(7);
			Design.saveChanges();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify Success message is displayed.";
		String successMsg = "Job template updated successfully";
		try {
			if(Design.verifySuccessMsg(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
				
		msg= "Duplicate the Data Edit Sample - Copy Job Template";
		try {
			Design.duplicateTheTemplate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		
		

		msg = "Verify Data Edits Sample job template has '- Copy (1)' appended to the end of the name";
		try {
			cfunction.sync(21);
			if(Design.verifyJobTemplateHeader("Data Edits Sample - Copy (1)")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click on "Extended Properties" tab.
		msg = "Click on 'Extended Properties' tab";
		try {
			Design.clickOnExtendedProperties();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
		    e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		String warning= "This is a shared table across multiple job templates. Any changes to this table will affect other templates.";
		msg = "Verify this text '"+warning+ "' is available";
		try {
			cfunction.sync(21);
			if(Design.verifyWarning(warning)) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		
		
		
	}
	
}
