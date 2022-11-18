package com.workflowmanager.testcases;

import org.openqa.selenium.WebElement;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS60_DesignPageProGpStepConfiguration extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS60_DesignPageProGpStepConfiguration() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Design Tab
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
				msg = "Enter diagram name as 'Sample Diagram'";
				try {
					Design.enterDiagramName(workflowDiagramName1);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter Diagram description
				msg = "Enter diagram description as 'Sample description'";
				try {
					Design.enterDiagramDescription("test Description");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Leave the first "Start/End" as default first step and drag and drop a 2nd step "Run Pro GP Tool"
				String fromStep = "TS60_RunGPTool";
				String toStep = "BlankCanvas";
				msg = "Search for step '" + fromStep + "' in step library";
				try {
					Design.enterSearchStepTemplate("Run Pro GP Tool");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				// Drag an 'Run Pro GP Tool' step below the 'Start/End' step
				msg = "Drag an 'Run Pro GP Tool' step below the 'Start/End' step";
				try {
					Design.dragStepToCanvas(fromStep, toStep);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
				msg = "Join Paths";
				try {
					SikuliHelp.hoveronLocationSikuli("TS41_HoverOnStart_1280x768");
					cfunction.sync(2);
					Design.dragStepToCanvas("PathDown", "TS60_PathToRunGPTool1");
					cfunction.sync(5);
					SikuliHelp.selectLocationOnMapSikuliClick("TS60_ClickRunGPTool_1280x768");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Toolbox Alias = management
				msg = "Enter Toolbox Alias = 'management'";
				try {
					Design.enterToolBoxAliasInput("management");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Tool Name = CreateFolder
				msg = "Enter Tool Name = 'CreateFolder'";
				try {
					Design.enterToolNameInput("CreateFolder");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Leave the `Visible at Runtime` radiobutton on as default.
				//Click '+' to add a new parameter and enter "out_folder_path" as parameter name.
				msg = "Click '+' to add a new parameter";
				try {
					Design.clickAddNewParameterBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter \"out_folder_path\" as parameter name.";
				try {
					Design.enterFirstParameterInput("out_folder_path");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Expand the parameter and add parameter value = c:\Data
				msg = "Expand the parameter.";
				try {
					Design.clickFirstParameterExpandBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "add parameter value \"c:\\Data\"";
				try {
					Design.enterValueInput("c:\\Data");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Collapse the parameter.";
				try {
					Design.clickFirstParameterExpandBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click '+' to add a new parameter and enter "out_name" as parameter name.
				msg = "Click '+' to add a new parameter";
				try {
					Design.clickAddNewParameterBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter \"out_name\" as parameter name.";
				try {
					Design.enterSecondParameterInput("out_name");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Expand the parameter and add arcade expression = jobName($job)
				msg = "Expand the parameter.";
				try {
					Design.clickSecondParameterExpandBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on \"Arcade Expression\" radio button";
				try {
					Design.clickSecondArcadeExpressionRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter Return Value = jobName($job)
				msg = "Add parameter value \"jobName($job)\"";
				try {
					Design.enterArcadeExpressionInput("jobName($job)");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Check on Attach GP Log and provide an attachment folder name = GP Log
				msg = "Check on Attach GP Log";
				try {
					Design.clickAttachGpLogRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter attachment folder name \"GP Log\"";
				try {
					Design.enterAttachGpLogFolderNameInput("GP Log");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Add another Run Pro GP Step as next step in the diagram
				msg = "Drag an 'Run Pro GP Tool' step below the 'Start/End' step";
				try {
					Design.dragStepToCanvas(fromStep, "BlankCanvas1");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
				
				//Configure the 2nd Pro GP step as:
				//Select Other Toolbox and Toolbox Path = c:\test\testFGDB.gdb\NewToolBox
				msg = "Select Other Toolbox radio button";
				try {
					Design.clickOtherToolBoxRadioBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter Toolbox Path \"c:\\test\\testFGDB.gdb\\NewToolBox\"";
				try {
					String input="c:\\test\\testFGDB.gdb\\NewToolBox";
					Design.enterToolBoxPathInput(input);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Tool Name = Get Count
				msg = "Enter Tool Name = 'Get Count'";
				try {
					Design.enterToolNameInput("Get Count");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Check off `Visible at Runtime`
				msg = "Check off `Visible at Runtime`";
				try {
					Design.clickVisibleRuntimeCheckBoxBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Add a new parameter without providing theparameter name.
				msg = "Click '+' to add a new parameter";
				try {
					Design.clickAddNewParameterBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Do not enter any parameter name";
				try {
					Design.enterFirstParameterInput("");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//It indicates Missing required value.
				//Try to click away from the current Pro GP step.
				//A discard changes message pops up.
				//Click Cancel.
				//Add new parameter: in_row = c:\test\testFGDB.gdb\boundaries
				msg = "Enter \"in_row = c:\\test\\testFGDB.gdb\\boundaries\" as parameter name.";
				try {
					Design.enterFirstParameterInput("in_row = c:\\test\\testFGDB.gdb\\boundaries");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Expand the parameter.";
				try {
					Design.clickFirstParameterExpandBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Return Value = row_count
				msg = "add parameter value \"row_count\"";
				try {
					Design.enterValueInput("row_count");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Check on Attach GP Log";
				try {
				
				//	cfunction.spaceBar("//calcite-button[@class='btn-noPadding btn-small']");
					
					Design.clickAttachGpLogBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter attachment folder name \"GP Log\"";
				try {
					Design.enterAttachGpLogFolderNameInput("GP Log");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Connect path between two GP steps
				msg = "Join Paths between two GP steps";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS60_ClickRunGPTool_1280x768");
					cfunction.sync(2);
					SikuliHelp.hoveronLocationSikuli("TS60_ClickRunGPTool_1280x768");
					cfunction.sync(2);
					Design.dragStepToCanvas("TS60_PathBetween2GP", "TS60_PathToRunGPTool2");
					cfunction.sync(5);
					
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Configure the path between two GP step return code expression as $retVal == 'c:\\Data\\tempfolder'
				msg = "Set path logic to expression and add   \"$retVal == 'c:\\Data\\tempfolder'\"";
				try {
					Design.clickPathLogicExpression();
					cfunction.sync(2);
					Design.enterPathLogicInput("$retVal == 'c:\\Data\\tempfolder'");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Add a manual step after the 2nd GP step and configure the path: $retVal == 5
				msg = "Add a manual step after the 2nd GP step";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS60_ClickRunGPTool2_1280x768");
					cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliClick("TS41_DownArrow_1280x768");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Select path between 2nd GP tool and Manual step";
				try {
					SikuliHelp.selectLocationOnMapSikuliClick("TS60_ClickGPandManualPath_1280x768");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Set path logic to expression and add   \"$retVal == 5\"";
				try {
					Design.clickPathLogicExpression();
					cfunction.sync(2);
					Design.enterPathLogicInput("$retVal == 5");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Check on Attach GP Log and provide an attachment folder name = GP Log
				
				//Click Save.
				//The diagram is saved properly.
				//Follow the prompt to create a job template using the diagram with same name
				msg = "Click Save button";
				try {
					Design.clickOnSaveDiagramButton();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				
				//Click Activate
				msg = "Click Activate button";
				try {
					Design.clickOnActivateWorkFlowDiagram();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
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
				msg = "Click on Save Button";
				try {
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
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
				cfunction.sync(2);
				//Go back to Design - Diagrams page and navigate to the saved diagram. 
				//Edit the diagram and verify thw two Pro GP steps are configured as previously saved.
				//Go to Work page and create a new job using the job template.
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click the 'Create' button";
				try {
					WorkPage.clickCreateBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
						//A list of job templates should become visible in the Create panel
						//Search for 'Open Web App Test'
				msg = "Enter "+workflowDiagramName1+ " in Search Textbox";
				try {
					Coordinate.enterSearchText(workflowDiagramName1);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify "+workflowDiagramName1+" is displayed in the list";
				try {
					if (Coordinate.verifyJobIsPresent(workflowDiagramName1))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
						//Click the Open Web App Test job template
				msg = "Click the "+workflowDiagramName1+" job template";
				try {

					boolean check = Coordinate.clickCreateDefaultOfTemplatePresent(workflowDiagramName1);
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
				msg = "Verify New Job created successfully";
				try {

					Coordinate.verifySuccessMsg("successful");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click "Finish" on the first step.
				msg = "Click the Collapse panel button";
				try {

					WorkPage.clickOnCollapseLeftPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*msg = "Run \"Start Step\" step for the job";
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
				//Run the Pro GP step.
				msg = "Run \"Start Step\" Pro GP step for the job";
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
				cfunction.sync(2);
				msg = "The step fails to run with warning (orange) message: UnsupportedStepOnClient.";
				try {
					String warning= "Step is not supported on the client";
					if(WorkPage.verifyErrorvisible()) {
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
				//The step fails to run with warning (orange) message: UnsupportedStepOnClient.
				//Log out the application.
				msg = "Log out from the web app.";
				try {
					HomePage.clickOnLogOut();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

	}
}
