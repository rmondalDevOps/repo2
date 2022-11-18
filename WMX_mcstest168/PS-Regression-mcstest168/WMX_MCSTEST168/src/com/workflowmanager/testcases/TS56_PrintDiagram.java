package com.workflowmanager.testcases;

import java.util.ArrayList;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS56_PrintDiagram extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS56_PrintDiagram() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Go to Design tab and start editing of Data Edits Sample diagram.
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
				//Enter "create" in Search Textbox
				String searchText = "Data Edits Sample";
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
				cfunction.sync(2);
				//Use the diagram navigation tools to zoom to Edit Data step.
				msg = "Use the diagram navigation tools to zoom to Edit Data step.";
				try {
					Design.clickOnPlusSign(15);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The diagram is currently not displayed 100% in the canvas and zoomed to the Edit Data step.
		
		//The diagram is in editing mode. The Tools bar on the top of the diagram canvas has "Print" button available.
				msg = "Verify 'Print' button is visible";
				try {
					if(Design.verifyDiagramsPrintBtnVisible()) {
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
		//Hover over the Print button.
				msg = "Hover over the Print button.";
				try {
					Design.hoverOnDiagramPrintBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The tooltips indicate Print Diagram
				msg = "Verify The tooltips indicate Print Diagram";
				try {
					if(Design.verifyToolTipTextPresent("Print Diagram")) {
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
		//Click on Print button.
				msg = "Click on 'Print' button.";
				try {
					Design.clickOnPrintBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Two options are available: Print All and Print Visible
		//Click Print All option in Print Diagram drop down menu.
				msg = "Click Print All option in Print Diagram drop down menu.";
				try {
					Design.clickOnPrintAll();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//The browser opens another tab to display the Print Preview window and it displays the complete diagram for printing.
				msg = "The browser opens another tab to display the Print Preview window and it displays the complete diagram for printing.";
				if (browser.equalsIgnoreCase("firefox")) {
					try{
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						System.out.println("List is --"+tabs);
						//driver.switchTo().window(tabs.get(1));
						//Design.dragAndDrop("TS56_PrintWindowDrag", "TS56_PrintWindowDrop");
						cfunction.sync(2);
						if(SikuliHelp.verifyImageExists("TS56_DiagramPrintAll_Firefox_1280x768")) {
							cfunction.sync(5);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_FirefoxCancelBtn_1280x768");
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				}
				else{
					try {
				
					if(SikuliHelp.verifyImageExists("TS56_DiagramPrintAll_1280x768")) {
						cfunction.sync(2);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_CancelBtn_1280x768");
						CommonFunction.logStatus("PASS", msg);
					}
					else if (SikuliHelp.verifyImageExists("TS56_DiagramPrintAll_1280x768_Edge")) {
						cfunction.sync(2);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_CancelBtn_1280x768_Edge");
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}}
				cfunction.sync(2);
				msg = "Close the print tab";
				try {
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					
					if(!browser.equalsIgnoreCase("firefox"))
						{
						driver.switchTo().window(tabs.get(1));
						driver.close();
						driver.switchTo().window(tabs.get(0));
						}
					else {	
						driver.switchTo().window(tabs.get(0));
					}
				/*	if(!browser.equalsIgnoreCase("firefox")) {*/
					//driver.switchTo().window(tabs.get(0));
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click Print Visible option in Print Diagram drop down menu.
				msg = "Click Print Visible option in Print Diagram drop down menu.";
				try {
					Design.clickOnPrintBtn();
					cfunction.sync(2);
					Design.clickOnPrintVisible();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//The browser opens another tab to display the Print Preview window and it displays the current extent of the diagram for printing. It zoomed to Edit Data step but not completely displays the diagram.
				msg = "The browser opens another tab to display the Print Preview window and it displays the complete diagram for printing.";
				if (browser.equalsIgnoreCase("firefox")) {
					try{
						//Design.dragAndDrop("TS56_PrintWindowDrag", "TS56_PrintWindowDrop");
						cfunction.sync(5);
						if(SikuliHelp.verifyImageExists("TS56_DiagramPrintVisible_Firefox_1280x768")) {
							cfunction.sync(5);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_FirefoxCancelBtn_1280x768");
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				}
				
				else{
					try {
						cfunction.sync(5);
					if(SikuliHelp.verifyImageExists("TS56_DiagramPrintVisible_1280x768")) {
					cfunction.sync(5);
					SikuliHelp.selectLocationOnMapSikuliClick("TS56_CancelBtn_1280x768");
					cfunction.sync(5);
					/*ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					
					driver.close();
					driver.switchTo().window(tabs.get(0));*/
					CommonFunction.logStatus("PASS", msg);
					cfunction.sync(5);
					}
					else if (SikuliHelp.verifyImageExists("TS56_DiagramPrintVisible_1280x768_Edge")) {
						cfunction.sync(2);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_CancelBtn_1280x768_Edge");
						CommonFunction.logStatus("PASS", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}}
				cfunction.sync(2);
				msg = "Close the print tab";
				try {
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					driver.close();
					driver.switchTo().window(tabs.get(0));
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Make some edits in the diagram without saving, such as adding a new step.
				msg = "Delete \"Edit Data\" step.";
				if (browser.equalsIgnoreCase("firefox")) {
					try {
						cfunction.sync(5);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_EditData_Firefox_1280x768");
						cfunction.sync(2);
						cfunction.pressDeleterKey();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}}
				else{
					try {
						cfunction.sync(5);
					SikuliHelp.selectLocationOnMapSikuliClick("TS56_EditData_1280x768");
					cfunction.sync(2);
					cfunction.pressDeleterKey();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}}
				cfunction.sync(2);
		//Click Print All option in Print Diagram drop down menu.
				msg = "Click Print All option in Print Diagram drop down menu.";
				try {
					Design.clickOnPrintBtn();
					cfunction.sync(2);
					Design.clickOnPrintAll();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//The unsaved edits in the diagram is included into the print preview.
				msg = "Verify the unsaved edits in the diagram is included into the print preview.";
				if (browser.equalsIgnoreCase("firefox")) {
					try{
						//Design.dragAndDrop("TS56_PrintWindowDrag", "TS56_PrintWindowDrop");
						cfunction.sync(2);
						if(SikuliHelp.verifyImageExists("TS56_DiagramPrintAllWithoutEditData_Firefox_1280x768")) {
							cfunction.sync(5);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_FirefoxCancelBtn_1280x768");
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				}
				else{
					try {
						cfunction.sync(5);
					if(SikuliHelp.verifyImageExists("TS56_DiagramPrintAllWithoutEditData_1280x768")){
					cfunction.sync(5);
					SikuliHelp.selectLocationOnMapSikuliClick("TS56_CancelBtn_1280x768");
					/*cfunction.sync(5);
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					
					driver.close();
					driver.switchTo().window(tabs.get(0));*/
					CommonFunction.logStatus("PASS", msg);
					cfunction.sync(5);
					}
					else if (SikuliHelp.verifyImageExists("TS56_DiagramPrintAllWithoutEditData_1280x768_Edge")) {
						cfunction.sync(2);
						cfunction.sync(5);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_CancelBtn_1280x768_Edge");
						CommonFunction.logStatus("PASS", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}}
				cfunction.sync(2);
				msg = "Close the print tab";
				try {
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					driver.close();
					driver.switchTo().window(tabs.get(0));
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click Print Visible option in Print Diagram drop down menu.
				msg = "Click Print Visible option in Print Diagram drop down menu.";
				try {
					Design.clickOnPrintBtn();
					cfunction.sync(2);
					Design.clickOnPrintVisible();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//The unsaved edits in the diagram is included into the print preview.
				msg = "Verify the unsaved edits in the diagram is included into the print preview.";
				if (browser.equalsIgnoreCase("firefox")) {
					try{
						cfunction.sync(5);
						//Design.dragAndDrop("TS56_PrintWindowDrag", "TS56_PrintWindowDrop");
						cfunction.sync(2);
						if(SikuliHelp.verifyImageExists("TS56_DiagramPrintVisibleWithoutEditData_firefox_1280x768")) {
							cfunction.sync(5);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_FirefoxCancelBtn_1280x768");
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				}
				else{
					try {
						cfunction.sync(5);
					if(SikuliHelp.verifyImageExists("TS56_DiagramPrintVisibleWithoutEditData_1280x768")) {
					cfunction.sync(5);
					SikuliHelp.selectLocationOnMapSikuliClick("TS56_CancelBtn_1280x768");
					/*cfunction.sync(5);
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					
					
					driver.close();
					driver.switchTo().window(tabs.get(0));*/
					CommonFunction.logStatus("PASS", msg);
					}
					else if (SikuliHelp.verifyImageExists("TS56_DiagramPrintVisibleWithoutEditData_1280x768_Edge")) {
						cfunction.sync(2);
						cfunction.sync(5);
						SikuliHelp.selectLocationOnMapSikuliClick("TS56_CancelBtn_1280x768_Edge");
						CommonFunction.logStatus("PASS", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}}
				cfunction.sync(2);
				msg = "Close the print tab";
				try {
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					driver.close();
					driver.switchTo().window(tabs.get(0));
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Log out from the app.
	}
}
