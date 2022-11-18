package com.workflowmanager.testcases;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
//import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;

public class DataReloader extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	//DataReloader DR1 = new DataReloader();
	String msg = ""; 
	String url= "http://wmxsrv2.esri.com:5000/";
	public void DataReloadingProcess() throws InterruptedException {
		
		//Click Create Jobs Button
		msg = "Open URL";
		try {
			driver.get(url);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Load Data (from upload)";
		try {
			cfunction.Commmon_Click("xpath", "//a[@href='/loadForm']");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*msg = "Click on Choose files";
		try {
			cfunction.Commmon_Click("xpath", "//input[@id='data']");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		msg = "Click on files";
		try {
	/*		SikuliHelp.sikuliEnteringValue("DataReloaderFileName", "C:\\Automation\\BaseData\\SeleniumTestData");
			SikuliHelp.selectLocationOnMapSikuliClick("OpenButtn");
			SikuliHelp.selectLocationOnMapSikuliClick("DataReloader");*/
			/*Actions actionObj = new Actions(driver);
			actionObj.sendKeys(Keys.CONTROL, "a")*/;
			// actionObj.sendKeys("").perform();
			// Design.dragStepToCanvas("Question", "BlankCanvas");
			//SikuliHelp.selectLocationOnMapSikuliClick("DataReloaderFileName");
			WebElement chooseFile= driver.findElementByXPath("//input[@id='data']");
			chooseFile.sendKeys("C:\\Automation\\BaseData\\SeleniumTestData\\diagramsData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\ext_csRVsKBlRxaKA0mWLd6GAAData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\ext_eEX8WJqISfKUkRoRjnwvogData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\ext_JBh_r3HoSNS3qD3HFH5RbwData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\ext_kSSBg6TNTSel6bkMSta_4wData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobAOIData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobExtPropertyDefinitionsData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobExtPropertyTableDefinitionsData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobLOIData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobPOIData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobProgressData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobsData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobTemplatesData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\jobTemplatesToExtPropertyTableDefXrefData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\roleGroupsData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\rolesData.JSON"
					+ " \n C:\\Automation\\BaseData\\SeleniumTestData\\settingsData.JSON");
			//chooseFile.sendKeys("C:\\Automation\\BaseData\\SeleniumTestData\\settingsData.JSON");
			 /*Actions actionObj = new Actions(driver);
			 actionObj.sendKeys("300000").perform();*/
			 /*actionObj.keyDown(Keys.CONTROL)
			          .sendKeys(Keys.chord("A"))
			          .keyUp(Keys.CONTROL)
			          .perform();*/
			 //sendKeys(Keys.chord(Keys.CONTROL, "a"));
			 
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click Create Jobs Button
				msg = "Click Load data";
				try {
					cfunction.Commmon_Click("xpath", "//button");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(30);
				DataReloadingProcess1();
	}
	public void DataReloadingProcess1() throws InterruptedException {
				msg = "Verify Data Loads successfully";
				try {
					if(SikuliHelp.verifyImageExists("DataReloaderError")) {
						System.out.println("Data reloader process restarted");
						DataReloadingProcess();
					}
					else {
						CommonFunction.logStatus("PASS", msg);
						System.out.println("Data reloader process completed");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);

}
}