package com.workflowmanager.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS78_DesignPage_ConfigureDefineLocationStepWithArcade extends TestBase {
	
	CommonFunction cfunction = new CommonFunction();
	String DiagramName = cfunction.getUniqueName("Define Location Arcade");

	String msg = "";
	
	public void workflow_TS78_DesignPage_ConfigureDefineLocationStepWithArcade() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Design Page
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.waitforpagetoload();
		msg = "Click on Create New button";
		try {
			cfunction.sync(19);
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//Enter Diagram Name
		msg = "Enter diagram name as '"+DiagramName+"'";
		try {
			cfunction.sync(19);
			Design.enterDiagramName(DiagramName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//Enter Diagram description
		msg = "Enter diagram description as 'Test Define Location Arcade'";
		try {
			Design.enterDiagramDescription("Test Define Location Arcade");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Drag \"Define Location\" on to the canvas";
		try {
			Design.enterSearchStepTemplate("Loc");
			cfunction.sync(10);
			Design.dragStepToCanvas("TS78_DefineLocation", "TS83_BlankCanvas");
			 Actions actionTAB = new Actions(driver);
			actionTAB.sendKeys(Keys.ARROW_DOWN).build().perform();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Check for Geometry if it is Polygon, in our case it is, otherwise change it to Polygon Geometry
		msg = "Click on Geometry Radio Button";
		try {
			Design.clickOnGeometry();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Configure the Define Location to use Arcade";
		try {
			Design.arcadeMenuSingle(2,1);
			Design.enterInArcadeTextArea("jobExtendedProperty($job, 'flurgrenzen', 'shape')", 2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg ="Change Step Option to Manual";
		try {
			Design.changeStepManual();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Connect paths of \"Define Location\" and \"StartEnd\" steps";
		try {
			
			SikuliHelp.hoveronLocationSikuli("TS83_Start_1280x768");
			cfunction.sync(2);
			Design.dragStepToCanvas("TS83_PathStart", "TS78_Path_End_DefineLocation");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg ="Save and Activate the diagram";
		try {
			Design.saveAndActivate1();
			CommonFunction.logStatus("PASS", msg);
		} catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg="Switch to Extended Property Tab";
		try {
			Design.clickOnExtendedProperty();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		
		msg = "Switch to Feature Service Table";
		try {
			Design.switchFeatureServiceTable();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		
		msg = "Add Feature Service Table";
		try {
			Design.addFeatureServiceTable("680a1c8c2b374dc3bebab57e2cc2a18c");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}		
		
		msg = "Rename the Table Name";
		try {
			Design.renameFeatureServiceTable("flurgrenzen");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		
		msg="Click OK after entering Item ID";
		try {
			cfunction.Commmon_Click("xpath", "//button[@class='p-button t-featureServiceModalOkBtn']");
			cfunction.sync(7);
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
						
		msg="Click on Save Button for Job Template";
		try {
			cfunction.sync(5);
			Design.clickOnSave();
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "//button[@class='btn p-button']");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}		
		
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			cfunction.Commmon_Click("xpath", "//button[@class='btn p-button']");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		HomePage.clickOnWork();
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
				msg = "Type "+ DiagramName +" in to the search bar in the panel";
				try {
					WorkPage.enterTemplateNameInSearch(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//The Survey Workflow job template should appear
				msg = "The "+ DiagramName +" job template should appear";
				try {
					if(WorkPage.verifyJobTemplatePresent(DiagramName)) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}	
				
				msg = "Click on the "+ DiagramName +" job template";
				try {
					if(WorkPage.clickOnJobTemplate(DiagramName)) {
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
				
				msg ="Click on Right Pane";
				msg = "Open Right Panel";
				try {
					WorkPage.clickOnCollapseRightPane();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}			
				
				msg ="Click Edit Property to update GID";
				try {
					WorkPage.clickEditProperty();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg = "Update GID";
				try {
					WorkPage.enterGID();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				
				msg = "Save Notes";
				try {
					WorkPage.clickSaveGIDProperty();
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
				
				msg = "Click on Diagram and Map Tab";
				try {
					WorkPage.clickOnDiagramAndMapTab();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg= "Verify Job Location is created";
				try {
					cfunction.sync(19);
					SikuliHelp.verifyImageExists("TS78_VerifyLocation_1280x768");
					CommonFunction.logStatus("PASS", msg);

				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				msg ="Logout from the page";
				try {
					WorkPage.clickOnSignout();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
	
	}
	
	
}
