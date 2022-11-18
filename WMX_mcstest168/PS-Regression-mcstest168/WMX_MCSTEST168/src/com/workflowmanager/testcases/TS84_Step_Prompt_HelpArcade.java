package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS84_Step_Prompt_HelpArcade {
	
	CommonFunction cfunction = new CommonFunction();
	String msg= "";
	/*String text="This job is assigned to admin\r\n" + 
			"Priority: Low\r\n" + 
			"Status: Ready to Work\r\n" + 
			"Type: Step Prompt Help Arcade";*/
String text ="This job is assigned to admin\n" + 
		"Priority: Low\n" + 
		"Status: Ready to Work\n" + 
		"Type: Step Prompt Help Arcade";
/*This job is assigned to admin
Priority: Low
Status: Ready to Work
Type: Step Prompt Help Arcade
*/	
	public void workflow_TS84_Step_Prompt_HelpArcade() {
		cfunction.waitforpagetoload();
		//Click on Design Page
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Expand Custom Search.
		msg = "Expand Custom Search";
				try {
					WorkPage.clickOnCustomeSearchIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
	
				//The custom search box is expanded to allow to enter search query.
		msg = "Verify the custom search box is expanded to allow to enter search query";
				try {
					WorkPage.clickOnCustomSearchInput();
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

				//Verify the custom query textbox is empty : as per new changes in build(as discussed with Xiaomeng)
		msg = "Verify the custom query textbox is empty";
				try {
					if(WorkPage.verifyCustomQueryCleared())
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Enter new search query Search in the custom search box.
		msg = "Enter new search query Search in the custom search box";
				try {
					String query = "job_template_name='Step Prompt Help Arcade'";
					WorkPage.enterCustomSearch(query);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Hit Enter.
		msg = "Hit Enter";
				try {
					cfunction.pressEnterKey();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//A new Custom Query tab is opened next to All Jobs tab. 
		msg = "It returns a single job with the type 'Step Prompt Help Arcade'";
				try {
					if(WorkPage.verifyAllJobs())
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Run first step
	    msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
		
		 
		 System.out.println(text);
		msg="Verify "+text+ " appears in both the User Prompt and the Step Help";
		try {
			if(WorkPage.textPresence(text)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch(Exception e) {
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
		
		//Run Second step
	    msg = "Run \"Start/End\" step for the job";
				try {
					cfunction.waitforpagetoload();
					cfunction.sync(19);
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.waitforpagetoload();
				
	
		msg="Verify "+text+ " appears in both the User Prompt and the Step Help";
				try {
					if(WorkPage.textPresence2(text)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
		msg="Press 'Continue' button";
		try {
			WorkPage.pressContinue();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Run Third step
	    msg = "Run \"Start/End\" step for the job";
				try {
					cfunction.waitforpagetoload();
					cfunction.sync(19);
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
			
		msg="Verify "+text+ " appears in both the User Prompt and the Step Help";
					try {
						if(WorkPage.textPresence3(text)) {
							CommonFunction.logStatus("PASS", msg);
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}catch(Exception e) {
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
		
		msg = "Run \"Start/End\" step for the job";
		try {
			cfunction.waitforpagetoload();
			cfunction.sync(19);
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
	msg="Verify "+text+ " appears in both the User Prompt and the Step Help";
			try {
				if(WorkPage.textPresence4(text)) {
					CommonFunction.logStatus("PASS", msg);
				}
				else {
					CommonFunction.logStatus("FAIL", msg);
				}
			}catch(Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		
		msg="Cancel the current step";
		try {
			WorkPage.pressCancel();
			CommonFunction.logStatus("PASS", msg);
		} catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL",msg);
		}
		
		msg = "Open Right Panel";
		try {
			WorkPage.clickOnCollapseRightPane();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on 'Diagram and Map' tab";
		try {
			WorkPage.clickOnDiagramAndMapTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Select 'Add Job Comment' as Current Step";
		try {
			WorkPage.selectAddJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "A green message is displayed ' Set current step successfully";

		try {
			String successMsg = "successfully";
			if(Coordinate.verifySuccessMsg1(successMsg)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
			
		msg = "Run \"Start/End\" step for the job";
		try {
			cfunction.waitforpagetoload();
			cfunction.sync(19);
			WorkPage.clickOnStartBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		msg="Verify "+text+ " appears in both the User Prompt and the Step Help";
		try {
			if(WorkPage.textPresence5(text)) {
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
