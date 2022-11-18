package com.workflowmanager.testcases;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

import com.workflowmanager.library.AppLib;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS69_ConfigureCustomMapAsBaseMap extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS69_ConfigureCustomMapAsBaseMap() throws InterruptedException {
		//CommonFunction.waitforHomePagetoload();
		//driver.close();
		//Click on Design Tab
		msg = "Take a backup of \"appconfig\" file";
		try {
			File srcFile = new File("\\\\MCSTEST62\\c$\\Program Files\\ArcGIS\\Portal\\apps\\workflowmanager\\conf\\appconfig.json");
			File destFile=new File("C:\\Automation\\Workspace\\WorkflowManager\\testData\\TS69");
			AppLib.copyFileToDirectory(srcFile, destFile);
			if(AppLib.copyFileToDirectoryBool(srcFile, destFile)) {
				CommonFunction.logStatus("PASS", msg); 
			}else {
				CommonFunction.logStatus("FAIL", "appconfig File Not found, Please check source & destination location in excel");
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Update appconfig file with custom map ";
			try {
				File srcFile = new File("C:\\Automation\\Workspace\\WorkflowManager\\testData\\TS69\\appconfigCustomMap\\appconfig.json");
				File destFile=new File("\\\\MCSTEST62\\c$\\Program Files\\ArcGIS\\Portal\\apps\\workflowmanager\\conf");
				
				AppLib.copyFileToDirectory(srcFile, destFile);
				if(AppLib.copyFileToDirectoryBool(srcFile, destFile)) {
					CommonFunction.logStatus("PASS", msg); 
				}else {
					CommonFunction.logStatus("FAIL", "appconfig File Not found, Please check source & destination location in excel");
				}
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			msg = "Open Web application";
			try {
				LoginPage  lp = new LoginPage();
				lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));	
					CommonFunction.logStatus("PASS", msg); 
				
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			//Verify the Basemap option button isn't available if a custom map is configured.
			msg = "Verify the Basemap option button isn't available";
			try {
				if(Coordinate.verifyBasemapOptionVisible()) {
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
			//Verify a expandable "Manage Layers" button is available.
			msg = "Verify a expandable \"Manage Layers\" button is available.";
			try {
				Coordinate.clickOnManageLayers();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			//Expand it and it displays three job locations layers and the layers stored in the custom map.
			//Toggle on and off Gas_Utility_Network layers
			msg = "Toggle on and off Gas_Utility_Network layers";
			try {
				if(Coordinate.clickOnManageListOption("Gas_Utility_Network - Structure Junction")) {
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
			msg = "Click on Log out";
			try {
				HomePage.clickOnLogOut();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			//Update appconfig file with invalid map 
			msg = "Update appconfig file with invalid map ";
			try {
				File srcFile = new File("C:\\Automation\\Workspace\\WorkflowManager\\testData\\TS69\\appconfigInvalidMap\\appconfig.json");
				File destFile=new File("\\\\MCSTEST62\\c$\\Program Files\\ArcGIS\\Portal\\apps\\workflowmanager\\conf");
				
				AppLib.copyFileToDirectory(srcFile, destFile);
				if(AppLib.copyFileToDirectoryBool(srcFile, destFile)) {
					CommonFunction.logStatus("PASS", msg); 
				}else {
					CommonFunction.logStatus("FAIL", "appconfig File Not found, Please check source & destination location in excel");
				}
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			msg = "Open Web application";
			try {
				LoginPage  lp = new LoginPage();
				lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));	
					CommonFunction.logStatus("PASS", msg); 
				
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			//Verify that there is an error displayed in basemap.
			msg = "Verify that there is an error displayed in basemap.";
			try {
				if(Coordinate.verifyMapItemError("Map item 'invalidmapItemId' is unavailable. Please contact your Workflow Manager Administrator.")) {
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
			msg = "Click on Log out";
			try {
				HomePage.clickOnLogOut();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			//Update appconfig file with empty map 
			msg = "Update appconfig file with empty map ";
			try {
				File srcFile = new File("C:\\Automation\\Workspace\\WorkflowManager\\testData\\TS69\\appconfigEmptyMap\\appconfig.json");
				File destFile=new File("\\\\MCSTEST62\\c$\\Program Files\\ArcGIS\\Portal\\apps\\workflowmanager\\conf");
				
				AppLib.copyFileToDirectory(srcFile, destFile);
				if(AppLib.copyFileToDirectoryBool(srcFile, destFile)) {
					CommonFunction.logStatus("PASS", msg); 
				}else {
					CommonFunction.logStatus("FAIL", "appconfig File Not found, Please check source & destination location in excel");
				}
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			msg = "Open Web application";
			try {
				LoginPage  lp = new LoginPage();
				lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));	
					CommonFunction.logStatus("PASS", msg); 
				
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);
			//Verify the default base map is displayed. 
			msg = "Verify the Basemap option button is available";
			try {
				if(Coordinate.verifyBasemapOptionVisible()) {
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
			//Replace the appconfig.json with the original one.
			msg = "Replace the appconfig.json with the original one";
			try {
				File srcFile = new File("C:\\Automation\\Workspace\\WorkflowManager\\testData\\TS69\\appconfig.json");
				File destFile=new File("\\\\MCSTEST62\\c$\\Program Files\\ArcGIS\\Portal\\apps\\workflowmanager\\conf");
				
				AppLib.copyFileToDirectory(srcFile, destFile);
				if(AppLib.copyFileToDirectoryBool(srcFile, destFile)) {
					CommonFunction.logStatus("PASS", msg); 
				}else {
					CommonFunction.logStatus("FAIL", "appconfig File Not found, Please check source & destination location in excel");
				}
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
			cfunction.sync(2);

	}

}
