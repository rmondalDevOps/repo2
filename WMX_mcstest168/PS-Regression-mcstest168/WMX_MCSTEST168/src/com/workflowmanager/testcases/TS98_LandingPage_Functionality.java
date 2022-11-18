/**
 * 
 */
package com.workflowmanager.testcases;

import org.openqa.selenium.WebElement;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;

/**
 * @author arp97661
 *
 */
public class TS98_LandingPage_Functionality extends TestBase {
	private static final String RESOURCEELEMENT ="(//div[@class='rightSection']/a)[1]";
	WebElement resourceElement = driver.findElementByXPath(RESOURCEELEMENT);
	WebElement learnResourceElement = driver.findElementByXPath("//p/a");
	String msg = "";
	CommonFunction cfunction = new CommonFunction();
	
	public void workflow_TS98_LandingPage_Functionality() throws InterruptedException {
		
		msg = "Click 'Learn more about Workflow Manager'";
		try {
			learnResourceElement.click();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify new tab launched";
		try {
			HomePage.verifyNewTab(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on 'Resources'";
		try {
			resourceElement.click();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify new tab launched";
		try {
			HomePage.verifyNewTab(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		
		msg = "Verify Resources icon exist";
		try {
			cfunction.isPageElementPresent("xpath", RESOURCEELEMENT);
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
	}

}
