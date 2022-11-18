package com.workflowmanager.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS44_ArcadeExpressionsPathInWorkflowDiagram extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS44_ArcadeExpressionsPathInWorkflowDiagram() throws InterruptedException {
		 CommonFunction.waitforHomePagetoload();
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
		//Click on Diagram in left menu
				msg = "Click on Diagram in left menu";
				try {
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
				msg = "Enter diagram name as '"+DiagramName+"'";
				try {
					Design.enterDiagramName(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter Diagram description
				msg = "Enter diagram description as 'Path arcade test description'";
				try {
					Design.enterDiagramDescription("Path arcade test Description");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		
	
		//Add a new manual step to the diagram and name it manual step 1
				msg = "Add a new manual step to the diagram and name it manual step 1";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS44_StartStep_1280x768");
					cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
					Design.enterStepName("Manual Step 1");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//Add 2 new manual steps to the diagram connected with a path to manual step 1
				msg = "Add 2 new manual steps to the diagram connected with a path to manual step 1";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
					cfunction.sync(5);
					Actions action = new Actions(driver); 
					action.sendKeys(Keys.ARROW_LEFT).build().perform();
					action.sendKeys(Keys.ARROW_LEFT).build().perform();
					cfunction.sync(2);
					Design.enterStepName("Low");
					cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS44_ManualStep1_1280x768");
					cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
					cfunction.sync(5);
					//Actions action = new Actions(driver); 
					action.sendKeys(Keys.ARROW_RIGHT).build().perform();
					action.sendKeys(Keys.ARROW_RIGHT).build().perform();
					cfunction.sync(2);
					Design.enterStepName("High");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Rename the step on left as low and step on right as high
		//Select the path between Manual step1 and Low
				msg = "Select the path between Manual step1 and Low";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS44_LowStepPath_1280x768");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Set path logic to expression and add   jobPriority($job)=='Low'
				msg = "Set path logic to expression and add   jobPriority($job)=='Low'";
				try {
					Design.clickPathLogicExpression();
					cfunction.sync(2);
					Design.enterPathLogicInput("jobPriority($job)=='Low'");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Select the path between Manual step1 and High
				msg = "Select the path between Manual step1 and High";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS44_HighStepPath_1280x768");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Set path logic to expression and add   jobPriority($job)=='High'
				msg = "Set path logic to expression and add   jobPriority($job)=='High'";
				try {
					Design.clickPathLogicExpression();
					Design.enterPathLogicInput("jobPriority($job)=='High'");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click Activate
				msg = "Click on Activate Button";
				try {
					Design.clickOnActivateWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
		//Create job template dialog is displayed
			/*	msg = "A toast message is popped - Diagram activated uccessfully.";
				String successMsg1 = "Successfully";
				try {
					if (Design.verifySuccessMsg1(successMsg1))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}*/
				
				cfunction.sync(5);
				//Click Yes
				msg = "Click Yes button of confirmation to create job tamplate";
				try {
					Design.clickYesOnConfirmDialog();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Job Template panel will be displayed with the new job template 'Path arcade test'
				msg = "Job Template panel will be displayed with the new job template "+DiagramName;
				try {
					Design.verifyJobTemplateHeader(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//Click Save
				msg = "Click Save";
				try {
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//Go to Work page
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Create a new job by clicking on a job  in the left panel. 
				msg = "Click on the left create button to expand the left panel";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click on template to create job Data Edits Sample
				//String Jobname="Path arcade test";
				msg = "Click on "+DiagramName+" template to a create job";
				
				try {
					Coordinate.clickCreateDefaultOfTemplatePresent(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				// 'Job created successfully should appear in a toast notification
				msg = "Verify Job should be created successfully";

				try {
					String successMsg = "successfully";
					Coordinate.verifySuccessMsg(successMsg);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		
		//A new custom query is created with Path arcade test template
		//Run step 'Start/End'
				/*msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();

				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
			/*	msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//Current step is 'Manual Step 1'
				msg = "Current step is now Manual Step 1";
				try {
					if(Design.verifyCurrentStep("Manual Step 1")) {
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
		//Run step Manual step 1
			/*	msg = "Run \"Manual step 1\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Current step is now Low
				msg = "Current step is now Low";
				try {
					if(Design.verifyCurrentStep("Low")) {
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
		//Job templates panel is selected and populated with results
		//Search for ' path arcade test'
				msg = "Job templates panel is selected and populated with results";
				try {
					Design.clickJobTemplateName(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Update job priority for Path arcade test to High
				msg = "Click on Drop-Down";
				try {
					Design.openDropDownMenuOfPriority();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Set the Job Priority to 'High'";
				try {
					Design.selecPriority("High");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click Save
				msg = "Click Save";
				try {
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Go to Work page
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Create a new job by clicking on a job  in the left panel. 
				msg = "Click on the left create button to expand the left panel";
				try {
					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click on template to create job Data Edits Sample
				//String Jobname="Path arcade test";
				msg = "Click on "+DiagramName+" template to a create job";
				
				try {
					Coordinate.clickCreateDefaultOfTemplatePresent(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
				// 'Job created successfully should appear in a toast notification
				msg = "Verify Job should be created successfully";

				try {
					String successMsg = "successfully";
					Coordinate.verifySuccessMsg(successMsg);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Under create job panel search ' Path arcade test' 
		//Path arcade job template is displayed
		//Create new job for Path arcade test
		//A new custom query is created with Path arcade test template
		//Run step 'Start/End'
				/*msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();

				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				/*msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//Current step is 'Manual Step 1'
				msg = "Current step is 'Manual Step 1'";
				try {
					if(Design.verifyCurrentStep("Manual Step 1")) {
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
		//Run step Manual step 1
				/*msg = "Run \"Manual step 1\" step for the job";
				try {
					WorkPage.clickOnStartBtn();

				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Current step is now High
				msg = "Current step is now High";
				try {
					if(Design.verifyCurrentStep("High")) {
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
	}
}