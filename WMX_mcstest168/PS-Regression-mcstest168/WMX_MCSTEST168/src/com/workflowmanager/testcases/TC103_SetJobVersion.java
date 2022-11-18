package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

/**
 * @author arp97661
 *
 */


public class TC103_SetJobVersion extends TestBase {
	
	CommonFunction cfunction = new CommonFunction();
	String msg= "";
	
	public void workflow_TC103_SetJobVersion() {
		CommonFunction.waitforHomePagetoload();
		msg = "Click on 'Work' Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(22);
		msg = "Click the 'Create' button";
		try {
			WorkPage.clickCreateBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter 'Set Job Version A' in Search Textbox";
		try {
			Coordinate.enterSearchText("Set Job Version A");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify 'Set Job Version A' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent("Set Job Version A"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
				//Click the Set Job Version A job template
		msg = "Click the 'Set Job Version A' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Set Job Version A");
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

					if(Coordinate.verifySuccessMsg("successfully"))
					CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//Click on the job card of the newly created job and expand the Job Details panel as needed.
				msg = "Click on the job card of the newly created job and expand the Job Details panel as needed.";
				try {

					WorkPage.clickOnCollapseSummaryBtn();
					cfunction.sync(2);
					WorkPage.clickCreateBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The new job's details are displayed.
				msg = "Verify it opens job details panel.";
				try {
					if(Coordinate.verifyJobNameAtInfoPanel(jobName)) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Go to Diagram & Map tab.
				msg = "Click on the 'Diagram & Map' tab.";
				try {
					WorkPage.clickOnDiagramAndMapTab();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The tab displays the selected job's diagram.
				msg = "Verify the tab displays the selected job's diagram.";
				try {
					if(Coordinate.verifyDiagramVisibleOnDiagramAndMapTap()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg= "Verify Diagram of Set Job Version A";
				try {
					WorkPage.verifyDiagramSetJobVersionA();
					CommonFunction.logStatus("PASS", msg);
					
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Close the Diagram";
				try {
					WorkPage.closePopWindow_inSelection();
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Select Step 'Set Job Version - No Version'";
				try {
					WorkPage.selectStepFromDropDown("Set Job Version - No Version");
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
		
				msg = "Run \"Set Job Version - No Version\" step for the job";
				try {
					WorkPage.clickProceedSingleJob();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Hover on warning";
				try {
					WorkPage.hoverOnWarning();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg= "Verify Step Failed with warning ";
				try {
					WorkPage.verify_PopUpMessage(msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				msg = "Select Step 'Set Job Version - Bad Version'";
				try {
					WorkPage.selectStepFromDropDown("Set Job Version - Bad Version");
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
		
				msg = "Run \"Set Job Version - Bad Version\" step for the job";
				try {
					WorkPage.clickProceedSingleJob();
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Hover on warning";
				try {
					WorkPage.hoverOnWarning();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg= "Verify Step Failed with warning ";
				try {
					WorkPage.verify_PopUpMessage(msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Select Step 'Send Web Request - Working'";
				try {
					WorkPage.selectStepFromDropDown("Send Web Request - Working");
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
		
				msg = "Run \"Send Web Request - Working\" step for the job";
				try {
					WorkPage.clickProceedSingleJob();
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg="Verify the Grid Value Exist and it's value is ";
				try {
					WorkPage.verify_GridValueExist(msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Run \"Manual Step - Working\" step for the job";
				try {
					WorkPage.clickProceedSingleJobWhileRunning();
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Run \"Claim Version\" step for the job";
				try {
					WorkPage.clickProceedSingleJob();
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Hover on warning";
				try {
					WorkPage.hoverOnWarning();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg= "Verify Step Failed with warning ";
				try {
					WorkPage.verify_PopUpMessage(msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Click the 'Create' button";
				try {
					WorkPage.clickCreateBtn1();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter 'Extract Data' in Search Textbox";
				try {
					Coordinate.enterSearchText("Set Job Version A");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify 'Set Job Version A' is displayed in the list";
				try {
					if (Coordinate.verifyJobIsPresent("Set Job Version A"))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
						//Click the Set Job Version A job template
				msg = "Click the 'Set Job Version A' job template";
				try {

					boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Set Job Version A");
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

							if(Coordinate.verifySuccessMsg("successfully"))
							CommonFunction.logStatus("PASS", msg);
							else
								CommonFunction.logStatus("FAIL", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(5);
				//Click on the job card of the newly created job and expand the Job Details panel as needed.
						msg = "Click on the job card of the newly created job and expand the Job Details panel as needed.";
						try {

							//WorkPage.clickOnCollapseSummaryBtn();
							cfunction.sync(2);
							WorkPage.clickCreateBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
				//The new job's details are displayed.
						msg = "Verify it opens job details panel.";
						try {
							if(Coordinate.verifyJobNameAtInfoPanel(jobName)) {
								CommonFunction.logStatus("PASS", msg);
							}else {
								CommonFunction.logStatus("FAIL", msg);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						
						msg = "Select Step 'Send Web Request - Working Too'";
						try {
							WorkPage.selectStepFromDropDown("Send Web Request - Working Too");
							CommonFunction.logStatus("PASS", msg);
							
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
				
						msg = "Run \"Send Web Request - Working Too\" step for the job";
						try {
							WorkPage.clickProceedSingleJob();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						
						msg="Verify the Grid Value Exist and it's value is ";
						try {
							WorkPage.verify_GridValueExist(msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						
						msg = "Run \"Manual Step - Working Too\" step for the job";
						try {
							WorkPage.clickProceedSingleJobWhileRunning();
							CommonFunction.logStatus("PASS", msg);
							
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						
						
						msg = "Verify Current step is 'Send Web Request - No Permission'";
						try {

							if(WorkPage.verifyStepNameVersion("Send Web Request - No Permission"))
							CommonFunction.logStatus("PASS", msg);
							else
								CommonFunction.logStatus("FAIL", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
				
				
				
				
				
	}
	

}
