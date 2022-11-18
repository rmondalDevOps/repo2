package com.workflowmanager.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;


public class TS02_EditDiagram extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS2_EditDiagram() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Design
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
		//Enter "create" in Search Textbox
		String searchText = "create Job Workflow";
		msg = "Enter '"+ searchText +"' in Search Textbox";
		try {
			Design.enterSearchText_Diagram(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		//Click on edit button
		msg = "Click on Edit button";
		try {
			Design.clickOnEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		

		/*//Enter "create" in Search Textbox
		searchText = "question";
		msg = "Enter '"+ searchText +"' in Search Step Template Textbox";
		try {
			Design.enterSearchStepTemplate(searchText);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);
		
		//Drag 'Question' and drop on the canvas
		msg = "Drag 'Question' and drop on the canvas";
		try {
			Design.zoomToLevel(91);
			//Design.enterSearchStepTemplate("Question");
			cfunction.sync(35);
		
			//cfunction.waitforpagetoload();
			if (browser.equalsIgnoreCase("chrome")) {
				Design.dragStepToCanvas("QuestionChrome", "TS1_TC1_Flow_1");
			}
			else {
				Design.dragStepToCanvas("Question", "TS1_TC1_Flow_1");
				}
			// cfunction.waitforpagetoload();
			 /*boolean overwriteStep = true;
			 String fromImg ="Question";
			String toImg = "BlankCanvas";
				String step = fromImg.replaceAll(" ", "") + "_1280x768";
				String canvasStep = toImg.replaceAll(" ", "").replaceAll("/", "") + "_1280x768";
				SikuliHelp.dragndropSikuli(step, canvasStep, overwriteStep);*/
			 Actions actionTAB = new Actions(driver);
				actionTAB.sendKeys(Keys.ARROW_DOWN).build().perform();
				//actionTAB.sendKeys(Keys.ARROW_DOWN).build().perform();
				CommonFunction.logStatus("PASS", msg);
				cfunction.sync(10);
			}catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		/*try {
			if(Design.dragStepToCanvas()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);
		//Click on Save Button
				msg = "Click on Save Button";
				try {
					Design.clickOnSaveWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				msg = "A toast message is popped - Diagram updated successfully";
				String successMsg = "Diagram updated successfully";
				try {
					if (Design.verifySuccessMsg1(successMsg))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
				//Click on Activate Button
				msg = "Click on Activate Button";
				try {
					Design.clickOnActivateWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//msg = "A toast message is popped - Unable to activate Workflow diagram - Diagram does not have a valid first step";
				msg = "A toast message is popped - Unable to activate Workflow diagram - Diagram does not have a valid first step";
				String successMsg1 = "Unable to activate workflow diagram";
				try {
					
					if (Design.verifySuccessMsg1(successMsg1))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Connect Steps
				//cfunction.sync(2);
		msg = "Connect Steps";
		if (browser.equalsIgnoreCase("firefox")) {
			try {
				cfunction.sync(15);
				SikuliHelp.hoveronLocationSikuli("TS1_TC1_Flow_1280x768_3");
				cfunction.sync(5);
				//SikuliHelp.selectLocationOnMapSikuli("TS1_TC1_Flow_1280x768_2");
				SikuliHelp.selectLocationOnMapSikuliClick("TS1_TC1_Flow_1280x768_3");
				cfunction.sync(5);
				//SikuliHelp.selectLocationOnMapSikuliClick("TS1_TC1_Flow_new_1280x768");
				Design.dragStepToCanvas("TS1_TC1_fromLineQuestion_new2", "TS1_TC1_toLineQuestion_new2");
				cfunction.sync(2);
				//Design.connectSteps();
				CommonFunction.logStatus("PASS", msg);
				
				/*else {
					CommonFunction.logStatus("FAIL", msg);
				}*/
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		}
		else {
		try {
			cfunction.sync(5);
			SikuliHelp.hoveronLocationSikuli("TS1_TC1_Flow_1280x768_3");
			cfunction.sync(5);
			//SikuliHelp.selectLocationOnMapSikuli("TS1_TC1_Flow_1280x768_2");
			SikuliHelp.selectLocationOnMapSikuliClick("TS1_TC1_Flow_1280x768_3");
			cfunction.sync(5);
			//SikuliHelp.selectLocationOnMapSikuliClick("TS1_TC1_Flow_new_1280x768");
			Design.dragStepToCanvas("TS1_TC1_fromLineQuestion_new2", "TS1_TC1_toLineQuestion_new2");
			cfunction.sync(2);
			//Design.connectSteps();
			CommonFunction.logStatus("PASS", msg);
			
			/*else {
				CommonFunction.logStatus("FAIL", msg);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		}
		cfunction.sync(2);
		//Click on Save Button
		msg = "Click on Save Button";
		try {
			Design.clickOnSaveWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//commented as the messages would be toast msg, will close automatically
		
/*		cfunction.sync(2);
		//Click on OK.
		msg = "Click on OK";
		try {
			Design.clickOnOKBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		cfunction.sync(2);
		//Click on Activate Button
		msg = "Click on Activate Button";
		try {
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Deleting Added Step for freash run";
		if (browser.equalsIgnoreCase("firefox")) {
			try {
				cfunction.sync(5);
				SikuliHelp.selectLocationOnMapSikuliClick("TS1_TC1_Flow_new_Firefox_1280x768");
			
				cfunction.sync(2);
				Actions action = new Actions(driver); 
				action.sendKeys(Keys.DELETE).build().perform();
				cfunction.sync(2);
				Design.clickOnSaveWorkFlowDiagram();
				cfunction.sync(2);
				Design.clickOnActivateWorkFlowDiagram();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		}
		
			
			
			else{
			try {
				cfunction.sync(5);
			SikuliHelp.selectLocationOnMapSikuliClick("TS1_TC1_Flow_new_1280x768");
		
			cfunction.sync(2);
			Actions action = new Actions(driver); 
			action.sendKeys(Keys.DELETE).build().perform();
			cfunction.sync(2);
			Design.clickOnSaveWorkFlowDiagram();
			cfunction.sync(2);
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}}
		cfunction.sync(2);
		

	}
}
