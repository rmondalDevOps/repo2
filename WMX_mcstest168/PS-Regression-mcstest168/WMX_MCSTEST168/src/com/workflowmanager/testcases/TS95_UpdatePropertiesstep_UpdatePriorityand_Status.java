/**
 * 
 */
package com.workflowmanager.testcases;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

/**
 * @author arp97661
 *
 */
public class TS95_UpdatePropertiesstep_UpdatePriorityand_Status {
	
	CommonFunction cfunction = new CommonFunction();
	String msg= "";
	List<String> listUse =Collections.<String>emptyList();;
	
	
	
	
	public void workflow_TS95_UpdatePropertiesstep_UpdatePriorityand_Status() {
		
				CommonFunction.waitforHomePagetoload();
				//Click on Work
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}	
				cfunction.sync(2);
				
				//Verify Work tab is opened. 
				msg = "Verify Work tab is opened";
				try {
					if(WorkPage.verifyWorkTabOpen())
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Hover the cursor over the toggle";
				try{
						WorkPage.hoverCreateBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				
				msg = "Click the toggle";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Type \"Properties - Update Priority and Status\" in to the search bar in the panel";
				try {
					WorkPage.enterTemplateNameInSearch("Properties - Update Priority and Status");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Click on the "Attachment_Selenium" job template to create a new job.
				msg = "Click the 'Properties - Update Priority and Status' job template";
				try {

					boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Properties - Update Priority and Status");
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

				
				msg = "Verify toast notification should appear in the top right indicating job creation";
				try {
					String msg1="successfully";
					Design.verifySuccessMsg(msg1);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Click the toggle";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Verify two fields show up";
				try {
					if(WorkPage.numberIsTwo()) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}			
					
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					
				}
				
				msg = "Verify name of two fields are 'Status' and 'Priority'";
				try {
					if(WorkPage.verifyValues()) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}			
					
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					
				}
				
				msg = "Verify value of two fields are 'Medium' and 'Created'";
				try {
					if(WorkPage.verifyFieldValues()) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}			
					
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					
				}
				
				List<String> listUse = Arrays.asList("Low", "Medium", "High");
				//List<String> listTwo = Arrays.asList("Created", "Ready", "In Progress", "Incomplete", "Revised", "Pending", "On Hold", "Approved", "Completed");
				msg = "Verify first dropdown contains \"Low\", \"Medium\", \"High\" as values";
				try {
					if(WorkPage.verifyDropdownValues( "(//div[contains(@class,'p-dropdown-trigger')])[1]", "//ul/p-dropdownitem/li/span", listUse)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}			
					
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					
				}
				
				msg = "Select High";
				try {
					WorkPage.selectFromDropdown( "//ul/p-dropdownitem/li/span", "High");
					CommonFunction.logStatus("PASS", msg);
				
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				
				listUse = Arrays.asList("Created", "Ready", "In Progress", "Incomplete", "Revised", "Pending", "On Hold", "Approved", "Completed");
				msg = "Verify first dropdown contains \"Created\", \"Ready\", \"In Progress\", \"Incomplete\", \"Revised\", \"Pending\", \"On Hold\", \"Approved\", \"Completed\"' as values";
				try {
					cfunction.sync(7);
					if(WorkPage.verifyDropdownValues( "(//div[contains(@class,'p-dropdown-trigger')])[2]", "//ul/p-dropdownitem/li/span", listUse)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}			
					
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					
				}
				
				msg = "Select High";
				try {
					WorkPage.selectFromDropdown( "//ul/p-dropdownitem/li/span", "On Hold");
					CommonFunction.logStatus("PASS", msg);
				
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Click Proceed in the step dialog.
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
			
				msg = "Expand the Job Details panel.";
				try {
					cfunction.sync(7);
					WorkPage.clickOnCollapseSummaryBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg= "Verify Job Priority Value changed to High";
				try {
					WorkPage.verifyJobDetails("//div[contains(@class, 't-jobPriority__value')]","High");
					CommonFunction.logStatus("PASS", msg);
				} catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg= "Verify Job Status Value changed to On Hold";
				try {
					WorkPage.verifyJobDetails("(//div[contains(@class, 'c-propertyContainer__content')])[5]","On Hold");
					CommonFunction.logStatus("PASS", msg);
				} catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Click on Proceed button to complete the job";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				
				msg="Created Job got completed";
				try {
					if(WorkPage.verifyJobCompleted()) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				

		
		
		
		
		
		
		
		
	}

}
