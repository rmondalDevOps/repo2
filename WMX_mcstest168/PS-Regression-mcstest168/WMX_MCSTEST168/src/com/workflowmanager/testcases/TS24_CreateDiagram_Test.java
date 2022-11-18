package com.workflowmanager.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;
import com.workflowmanager.pages.Coordinate;

public class TS24_CreateDiagram_Test extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS24_CreateDiagram() throws InterruptedException {
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
					Design.enterDiagramName(workflowDiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter Diagram description
				msg = "Enter diagram description as 'Sample description'";
				try {
					Design.enterDiagramDescription("Sample Description");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click 'Add Data Source' under spatial data
				msg = "Click 'Add Data Source' under spatial data";
				try {
					Design.clickOnAddDataSource();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter 'test' for the URL and click 'Cancel'
				msg = "Enter 'test' for the URL and click 'Cancel'";
				try {
					Design.enterURL("test");
					cfunction.sync(2);
					Design.clickOnCancelButton();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click 'Add Data Source' under spatial data
				msg = "Click 'Add Data Source' under spatial data";
				try {
					Design.clickOnAddDataSource();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter 'test' for the URL and click 'OK'
				msg = "Enter 'test' for the URL and click 'OK'";
				try {
					Design.enterURL("test");
					cfunction.sync(2);
					Design.clickOnOKButton();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click the 'red source cloud' with the tooltip
				msg = "Verify the tooltip of 'red source cloud'";
				try {
					boolean check;
					String tooltip="Data source is invalid or inaccessible. Click to Edit";
					if(check=Design.verifyErrorButtonToolTip(tooltip)) {
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
				//span[@class='input-validation tabGrid-column tabGrid-column-large-1 isError']/input
				msg="Enter 'data source'";
				try {
					//cfunction.Commmon_Click("xpath","//calcite-icon[@class='icon-error ng-star-inserted']");
					Design.enterSearchStepTemplate("Create Version");
					cfunction.CommonTextBox_Input2("//span[@class='input-validation tabGrid-column tabGrid-column-large-1 isError']/input", "data source");
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//"For the URL, enter and hit ok https://mcstest62.esri.com/portal/home/item.html?id=a7b16095c1484d63928602ebac3eb8c1"
			/*	msg = "Enter valid for the URL and click 'OK'";
				try {
					String URL= "https://mcstest62.esri.com/portal/home/item.html?id=5e76618a83f448189bec4eba75b9da24";
					Design.clickOnDataSourceErrorButton();
					cfunction.sync(2);
					Design.enterURL(URL);
					cfunction.sync(2);
					Design.clickOnOKButton();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify the valid data source selected";
				try {
					boolean check;
					String tooltip="Data source is invalid or inaccessible. Click to Edit";
					if(check=Design.verifyErrorButtonToolTip(tooltip)) {
						CommonFunction.logStatus("FAIL", msg);
					}
					else {
						CommonFunction.logStatus("PASS", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
			*/	
				//Drag a couple of steps on to the canvas such that it looks like the diagram below
				msg = "Drag \"Create Version\" on to the canvas";
				try {
					//Design.clickOnStepLibrary();
					//cfunction.ScrollToElement("(//div[@class='ui-accordion-content ui-widget-content'])[4]");
					//String step="TS24_CreateVersion";
					cfunction.sync(19);
					String canvasStep="BlankCanvas";
					
					Design.dragStepToCanvas("TS24_CreateVersion", canvasStep);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				msg = "Drag \"Define Location\" on to the canvas";
				try {
					
					
					Design.enterSearchStepTemplate("Define Location");
					cfunction.sync(19);
					Design.dragStepToCanvas("DefineLocation", "DropOfDefineLocation");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				msg = "Drag\"Open Pro Project Items\" on to the canvas";
				try {
					
					//cfunction.Commmon_Click("xpath", "//p-accordion[@class='stepGroups']/div/p-accordiontab[2]/div[1]");;
					Design.enterSearchStepTemplate("Open Pro Project Items");
					cfunction.sync(19);
					Design.dragStepToCanvas("OpenProProjectItems1", "DropOfDefineLocation");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				msg = "Connect paths of \"Start/End\" and \"Create Version\" steps";
				try {
					
					SikuliHelp.hoveronLocationSikuli("PathStart_1280x768");
					cfunction.sync(2);
					Design.dragStepToCanvas("PathDown", "PathEnds");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				msg = "Connect paths of \"Create Version\" and \"Define Location\" steps";
				try {
					
					SikuliHelp.hoveronLocationSikuli("hoverOnCreateVersionCanvas1_1280x768");
					cfunction.sync(2);
					if (browser.equalsIgnoreCase("chrome")) {
						Design.dragStepToCanvas("CreateVersionPathStartChrome", "CreateVersionPathEnd");
					}
					else {
					Design.dragStepToCanvas("CreateVersionPathStart", "CreateVersionPathEnd");}
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				msg = "Connect paths of \"Define Location\" and \"Open Pro Project Items\" steps";
				try {
					
					
					SikuliHelp.hoveronLocationSikuli("HoverOnDefineLocation_1280x768");
					cfunction.sync(7);
					
					
					Design.dragStepToCanvas("DefineLocationPathStart1", "DefineLocationPathEnd");
					
					
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				//Click Save
				msg = "Click Save button";
				try {
					Design.clickOnSave1();
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
				
				//Continue from previous test
				



	}
}
