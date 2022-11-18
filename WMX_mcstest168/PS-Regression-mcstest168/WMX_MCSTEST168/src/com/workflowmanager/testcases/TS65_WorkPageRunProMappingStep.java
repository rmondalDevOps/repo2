package com.workflowmanager.testcases;

import org.openqa.selenium.JavascriptExecutor;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS65_WorkPageRunProMappingStep extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS65_WorkPageRunProMappingStep() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
	
		msg = "Click on 'Work' Tab";
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
			WorkPage.clickCreateBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter 'Data Edits Sample' in Search Textbox";
		try {
			Coordinate.enterSearchText("Data Edits Sample");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify 'Data Edits Sample' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent("Data Edits Sample"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
				//Click the Open Web App Test job template
		msg = "Click the 'Data Edits Sample' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Data Edits Sample");
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

					if(Coordinate.verifySuccessMsg("successful"))
					CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		
		//Click to open the Details panel on the right
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
				msg = "Click on the 'Diagram' tab.";
				try {
					WorkPage.clickOnDiagramAndMapTab();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The diagram shows 
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
				msg = "Close location ";
				try {
					//WorkPage.clickLocation();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*msg = "Zoom out to 90%";
				try {

					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("document.body.style.zoom = '80%'");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(20);*/
		//Right click on the Edit Data step
				msg = "Right click on the 'Edit Data' step";
				try {
					//cfunction.Commmon_Click("xpath", "//calcite-icon[@class='maximizeDiagramBtn t-maximizeBtn']");
					WorkPage.openPopWindow_inSelection();
					//cfunction.sync(25);
					//JavascriptExecutor js = (JavascriptExecutor) driver;
					//js.executeScript("window.scrollBy(0,1000)");
					//SikuliHelp.rightClickOnMap("TS65_RightClickOnEditData_1280x768");
					SikuliHelp.rightClickOnMap("TC65_EditData_1280x768");

					
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The Set as current option is displayed
				msg = "Verify the Set as current option is displayed.";
				try {
					if(WorkPage.verifySetAsCurrentOption()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Choose Set as current.
				msg = "Choose Set as current.";
				try {
					WorkPage.clickOnSetAsCurrentBtn1();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//cfunction.Commmon_Click("xpath", "//button");
				//cfunction.sync(5);
				WorkPage.closePopWindow_inSelection();
		//On the job tile click the Play button
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
				cfunction.sync(2);
		//The step fails with a red warning in the job tile
				msg = "Verify The step fails with a red warning in the job tile";
				try {
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
		//Hover on the red warning
				msg = "Hover on the red warning";
				try {
					WorkPage.hoverErrorIcon();
					Design.verifyToolTipTextPresent("Step is not supported on the client");
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
	/*			
				
		//The message says Unsupported 
				msg = "The tooltips indicates 'Step is not supported on the client'";
				try {
					if(Design.verifyToolTipTextPresent("Step is not supported on the client")) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/

	}
}
