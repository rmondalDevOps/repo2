package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS83_Survey123Test_step extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String diagramName = cfunction.getUniqueName(xls.getCellData("en-us", 2,18));
	String msg= "";
	
	public void workflow_TS83_Survey123Test_step() throws InterruptedException {
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
		
		//Click on Diagram in left menu
		msg = "Click on Diagram in left menu";
		try {
			cfunction.waitforpagetoload();
			cfunction.sync(30);
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on create new button
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enter Diagram Name
		msg = "Enter diagram name as "+diagramName;
		try {
			Design.enterDiagramName(diagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enter Diagram description
		msg = "Enter diagram description as 'Sample description'";
		try {
			Design.enterDiagramDescription("Survey123 test step");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Drag \"Survey123\" on to the canvas";
		try {
			Design.enterSearchStepTemplate("1");
			cfunction.sync(10);
			Design.dragStepToCanvas("TS83_Survey123", "TS83_BlankCanvas");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Add Survey123 Form";
		try {
			Design.clickAddSurvey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Choose ArcGIS Online option and enter the ItemID";
		try {
			Design.enterInputInWebApp("4e655a519edf48cb8a13a928be840afb");
			Design.enterInputInWebApp2("Test Survey123");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg="Click OK after entering Item ID";
		try {
			cfunction.Commmon_Click("xpath", "//button[@class='p-button t-featureServiceModalOkBtn']");
			cfunction.sync(7);
			if(browser.equals("Firefox")) {
				SikuliHelp.sikuliClick("TS83_BlankCanvasFF_1280x768");
			}
			else {
				SikuliHelp.sikuliClick("TS83_BlankCanvasClick_1280x768");
			}
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		}
		catch(Exception e){
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Connect paths of \"Survey123\" and \"StartEnd\" steps";
		try {
			
			SikuliHelp.hoveronLocationSikuli("TS83_Start_1280x768");
			cfunction.sync(2);
			Design.dragStepToCanvas("TS83_PathStart", "TS83_PathEnd");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Drag \"Survey123\" on to the canvas";
		try {
			Design.enterSearchStepTemplate("1");
			cfunction.sync(10);
			Design.dragStepToCanvas("TS83_Survey123", "TS83_BlankCanvas1");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Add Survey123 Form Name";
		try {
			Design.clickAddSurveyName("Survey123_2");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		msg = "Add Survey123 Form";
		try {
			Design.clickAddSurvey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Choose ArcGIS Online option and enter the ItemID";
		try {
			Design.enterInputInWebApp("4e655a519edf48cb8a13a928be840afb");
			Design.enterInputInWebApp2("Test Survey123_2");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg="Click OK after entering Item ID";
		try {
			cfunction.Commmon_Click("xpath", "//button[@class='p-button t-featureServiceModalOkBtn']");
			cfunction.sync(7);
			//SikuliHelp.sikuliClick("TS83_BlankCanvasClick_1280x768");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		}
		catch(Exception e){
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Change Step configuration to 1-M relationship and 'Create New' mode";
		
		try {
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "//p-inputswitch");
			cfunction.Commmon_Click("xpath", "//p-radiobutton[contains(@class,'t-surveyModeCreateBtn')]");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		}catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Connect paths of \"Survey123\" and \"StartEnd\" steps";
		try {
			//SikuliHelp.sikuliClick("TS83_BlankCanvasClick_1280x768");
			if(browser.equals("Firefox")) {
				SikuliHelp.sikuliClick("TS83_BlankCanvasFF_1280x768");
			}
			else {
				SikuliHelp.sikuliClick("TS83_BlankCanvasClick_1280x768");
			}
			SikuliHelp.hoveronLocationSikuli("TS83_Survey123Drag_1280x768");
			cfunction.sync(2);
			Design.dragStepToCanvas("TS83_PathStart1", "TS83_PathEnd1");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg ="Save and Activate the diagram";
		try {
			Design.saveAndActivate();
			CommonFunction.logStatus("PASS", msg);
		} catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
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
				
				//Hover the cursor over the toggle
				msg = "Hover the cursor over the toggle";
				try{
						WorkPage.hoverCreateBtn();
						/*String collapse_Btn ="TS31_CollapseBtn2";
					SikuliHelp.hoveronLocationSikuli(collapse_Btn);*/
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				cfunction.sync(2);
				
				//A tooltip should appear "Expand Left Panel"
				msg = "Verify A tooltip should appear \"Expand Left Panel\"";
				try {
					WorkPage.verifyToolTip();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Click the toggle
				msg = "Click the toggle";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The create jobs panel should appear
				msg = "Verify The create jobs panel should appear";
				try {
					if(WorkPage.verifyCreateJobPanelVisible()) {
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
				//Type "Survey" in to the search bar in the panel
				msg = "Type \"Survey\" in to the search bar in the panel";
				try {
					WorkPage.enterTemplateNameInSearch("Survey");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//The Survey Workflow job template should appear
				msg = "The \"Survey Workflow\" job template should appearl";
				try {
					if(WorkPage.verifyJobTemplatePresent(diagramName)) {
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
				
				
				//Click the tile
				msg = "Click on the \"Survey Workflow\" job template";
				try {
					if(WorkPage.clickOnJobTemplate(diagramName)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				//toast notification should appear in the top right indicating job creation
				msg = "Verify toast notification should appear in the top right indicating job creation";
				try {
					String msg1="successfully";
					Design.verifySuccessMsg(msg1);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Click the toggle
				msg = "Click the toggle";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Click on the job created in previous steps";
				try {
					WorkPage.clickOnJobDetails(jobName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Click the Start step button
				msg = "Run \"Start Step\" step for the job";
				try {
					if(WorkPage.clickOnStartStepOfJob(jobName)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg="Submit the form";
				try {
					WorkPage.submitForm();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Click the Start step button
				msg = "Run \"Start Step\" step for the job";
				try {

					cfunction.waitforpagetoload();
					cfunction.sync(15);
					if(WorkPage.clickOnStartStepOfJob(jobName)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}}catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
					
				
				msg="Submit the form";
					try {
						WorkPage.submitForm();
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
