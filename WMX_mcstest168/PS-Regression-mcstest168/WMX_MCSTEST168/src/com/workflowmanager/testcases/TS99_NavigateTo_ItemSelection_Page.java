/**
 * 
 */
package com.workflowmanager.testcases;

import org.openqa.selenium.WebElement;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.HomePage;

/**
 * @author arp97661
 *
 */
public class TS99_NavigateTo_ItemSelection_Page extends TestBase {


	String msg = "";
	CommonFunction cfunction = new CommonFunction();
	private static final String HEADERNAV_BUTTON ="//calcite-button[@class='p-element t-homeBtn']";
	WebElement headNav= driver.findElementByXPath(HEADERNAV_BUTTON);
	
	public void workflow_TS99_NavigateTo_ItemSelection_Page()
	{
		CommonFunction.waitforHomePagetoload();
		
		msg= "Click on header navigation button";
		try {
			headNav.click();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		msg ="Verify Item Page loaded properly";
		try {
			HomePage.verify_itemPage(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		
		
	}


}
