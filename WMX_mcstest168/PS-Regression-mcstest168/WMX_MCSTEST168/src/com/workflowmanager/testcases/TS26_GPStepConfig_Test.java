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

public class TS26_GPStepConfig_Test extends TestBase {
	CommonFunction cfunction = new CommonFunction();

	String msg = "";

	public void workflow_TS26_GPStepConfig_Test() throws InterruptedException {
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
		// Click on Diagram in left menu
		msg = "Click on Diagram in left menu";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on create new button
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click and drag 'Run GP Service' step on to the canvas
		
		msg = "Click and drag 'Run GP Service' step on to the canvas";
		try {
			//Design.clickOnStepLibrary();
			cfunction.Commmon_Click("xpath", "//p-accordion[@class='p-element stepGroups']/div/p-accordiontab[1]/div[1]");
			String canvasStep="BlankCanvas";
			Design.dragStepToCanvas("RunGPService", canvasStep);
			//cfunction.sync(2);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		
		// Verify Step Name with the text 'Run GP Service'
		msg = "Verify Step Name with the text 'Run GP Service'";
		try {
			boolean check = Design.verifyStepName("Run GP Service");
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
		cfunction.sync(2);

		// Verify Step Description with the text 'Step to run a GP service with interface to update service arguments'
		msg = "Verify step Description with the text 'Step to run a GP service with inferface to update service arguments'";
		try {
			String DescText="Step to run a GP service with interface to update service arguments";
			Design.clickOnStepDetailAboutTab();
			boolean check = Design.verifyStepDesc(DescText);
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
		cfunction.sync(2);
		// Verify GP Service Url should be blank with a red warning
		msg = "Verify GP Service Url should be blank with a red warning";
		try {
			Design.clickOnStepDetailPropertiesTab();
			Design.verifyURLErrorVisible();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify Secure should be unchecked
		msg = "Verify Secure should be unchecked";
		try {
			Design.verifySecureCheckboxIsUncheck();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Verify Arguments should be blank except for Return Value"
		//Enter URL at GP serivces
		msg = "Enter URL at GP service";
		try {
			String url="https://mcstest62.esri.com/server/rest/services/Utilities/RasterUtilities/GPServer/ConvertRasterFunctionTemplate";
			Design.enterURLAtGPServices(url);
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Verify The arguments should populate and the warning should disappear
		msg = "Verify the warning should disappear";
		try {
			if(Design.verifyURLErrorVisible()) {
				CommonFunction.logStatus("FAIL", msg);
			}
			else{
				CommonFunction.logStatus("PASS", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify The arguments should populate";
		try {
			
			if(Design.verifyArgumentsVisible()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Check the Secure box
		msg = "Check the Secure box";
		try {
			Design.clickSecureCheckBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Click 'Edit' next to Arguments
		msg = "Click 'Edit' next to Arguments";
		try {
			Design.clickEditArgument();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// For inputRasterFunction set the parameter value to 'testRaster'
		msg = "Enter inputRasterFunction parameter value to 'testRaster'";
		try {
			Design.enterInputRasterFunction("testRaster");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// It should validate and remove the warning
		msg = "Verify warning should disappear";
		try {
			if(Design.verifyInputRasterFunctionErrorVisible()) {
				CommonFunction.logStatus("FAIL", msg);
			}
			else{
				CommonFunction.logStatus("PASS", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Check the box next to visible at runtime
		msg = "Check the box next to visible at runtime";
		try {
			Design.clickVisibleAtRuntimeCheckBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// Click the 'Name' dropdown under Return Value and select outputRasterFunction
		msg = "Click the 'Name' dropdown under Return Value and select 'outputRasterFunction'";
		try {
			Design.selectInputFromDropDown("outputRasterFunction");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		

		// Click save
		msg = "Click save";
		try {
			Design.ClickOnSaveBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// The arguments in the step details panel should update
		msg = "Verify the arguments in the step details panel should update";
		try {
			Design.verifyArgumentsVisible();
			Design.verifyinputRasterFunctionValue("testRaster");
			Design.verifyinputRasterFunctionInvisible("true");
			Design.verifyOutputFormatInvisible("true");
			Design.verifyReturnValue("outputRasterFunction");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

	}
}