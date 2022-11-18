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
public class TS100_DuplicateDiagram {
	
	CommonFunction cfunction = new CommonFunction();
	String msg= "";

	
	public void workflow_TS100_DuplicateDiagram() {
		
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
		
		//Enter "create" in Search Textbox
		String searchText = "Data Edit Sample";
		msg = "Enter '"+ searchText +"' in Search Textbox";
		try {
			Design.enterSearchText_Diagram(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Click on button left of Edit Button";
		try {
			Design.clickLeftofEdit();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify a Pop-Up came";
		try {
			Design.verify_PopUp(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Click on Duplicate Diagram button";
		try {
			Design.clickOnDuplicate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify Data Edits Sample Diagram has '- Copy' appended to the end of the name";
		try {
			
			if(Design.verifyJobDiagramHeader("Data Edits Sample - Copy")) {
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
