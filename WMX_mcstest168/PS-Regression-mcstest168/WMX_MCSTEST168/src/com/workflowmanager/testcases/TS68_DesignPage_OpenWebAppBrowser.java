package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS68_DesignPage_OpenWebAppBrowser extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS68_DesignPage_OpenWebAppBrowser() throws InterruptedException {
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
				msg = "Enter diagram name as 'Open Web App test1'";
				try {
					Design.enterDiagramName("Open Web App test1");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter Diagram description
				msg = "Enter diagram description as 'Open Web App test1 description'";
				try {
					Design.enterDiagramDescription("Open Web App test1 Description");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				//Add a new 'Open Web Page' Step to the diagram. 
				msg = "Drag \"Open Web Page\" on to the canvas";
				try {
					//Design.clickOnStepLibrary();
					//cfunction.ScrollToElement("(//div[@class='ui-accordion-content ui-widget-content'])[4]");
					//String step="TS24_CreateVersion";
					String canvasStep="BlankCanvas";
					Design.enterSearchStepTemplate("Open Web Page");
					Design.dragStepToCanvas("TS68_OpenWebPage", canvasStep);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				//In the Logic for this step, add http://wmxsrv1.esri.com/portal/apps/webappviewer/index.html?id=0cb9b6a808354d9bae4dd8d6cbf0a656 under Web Page URL. 
				msg = "Enter Web page URL";
				try {
					String url="http://wmxsrv1.esri.com/portal/apps/webappviewer/index.html?id=0cb9b6a808354d9bae4dd8d6cbf0a656";
					Design.enterURLAtWebPage(url);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Uncheck Open New Browser box if checked.
				//Add another 'Open Web Page' Step to the diagram. 
				msg = "Add another 'Open Web Page' Step to the diagram.";
				try {
					//Design.clickOnStepLibrary();
					//cfunction.ScrollToElement("(//div[@class='ui-accordion-content ui-widget-content'])[4]");
					//String step="TS24_CreateVersion";
					String canvasStep="TS68_OpenWebPageSecondDropPoint";
					Design.enterSearchStepTemplate("Open Web Page");
					Design.dragStepToCanvas("TS68_OpenWebPage", canvasStep);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				//In the Logic for this step, add http://wmxsrv1.esri.com/portal/apps/webappviewer/index.html?id=0cb9b6a808354d9bae4dd8d6cbf0a656 under Web Page URL.
				msg = "Enter Web page URL";
				try {
					String url="http://wmxsrv1.esri.com/portal/apps/webappviewer/index.html?id=0cb9b6a808354d9bae4dd8d6cbf0a656";
					Design.enterURLAtWebPage(url);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Check Open New Browser box if unchecked.
				//Rename this step 'Open New Browser.
				msg = "Update step name to \"Open New Browser\"";
				try {
					 Design.enterStepName("Open New Browser");
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Connect paths of \"Start/End\" and \"Create Version\" steps";
				try {
					
					SikuliHelp.hoveronLocationSikuli("PathStart_1280x768");
					cfunction.sync(2);
					Design.dragStepToCanvas("PathDown", "TS68_FirstPath");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				msg = "Connect paths of \"Start/End\" and \"Create Version\" steps";
				try {
					
					//SikuliHelp.hoveronLocationSikuli("PathStart_1280x768");
					cfunction.sync(2);
					Design.dragStepToCanvas("TS68_SecondPathStartingpoint", "TS68_SecondPathEndpoint");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
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
				msg = "Save the template";
				try {
					Design.clickOnSave();
					cfunction.pressEnterKey();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
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
				msg = "Click the 'Create' button";
				try {
					WorkPage.clickCreateBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter 'Open Web App test1' in Search Textbox";
				try {
					Coordinate.enterSearchText("Open Web App test1");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify 'Open Web App test1' is displayed in the list";
				try {
					if (Coordinate.verifyJobIsPresent("Open Web App test1"))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Create new job for Path arcade test
				msg = "Click the 'Open Web App test1' job template";
				try {

					boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Open Web App test1");
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
				
				//Run step 'Start/End'
						/*msg = "Run \"Start/End\" step for the job";
						try {
							WorkPage.clickOnStartBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Click on Proceed button";
						try {
							WorkPage.clickOnProceedBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(10);*/
				//Current step is 'Open Web Page'
				//Run step 'Open Web Page'

						msg = "Run \"Start/End\" step for the job";
						try {
							WorkPage.clickOnStartBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Click on Finish button";
						try {
							WorkPage.clickOnFinishBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(10);
				//The Web viewer takes over the workflow manager app. The job Panel is displayed on the side with all of the job information
				//Click Finish on the job Panel
				//You are taken back to the work page. The current step is now ' Open New Browser'
				//Run step 'Open New Browser'
						msg = "Run \"Start/End\" step for the job";
						try {
							WorkPage.clickOnStartBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Click on Finish button";
						try {
							WorkPage.clickOnFinishBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(10);
						msg = "Click on Dismiss button";
						try {
							WorkPage.clickOnDismissJobTileButton();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
				//A new tab is opened with the web map viewer. The existing web app is still present on the work page
				//Mark the step as finish in app window
	}
}
