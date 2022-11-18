package com.workflowmanager.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;



public class LoginPage extends TestBase{

	//XPath code
//	final String SIGNIN_XPATH = "document.querySelector('body > wmx-root > wmx-app > div > div.actionSection > calcite-button').shadowRoot.querySelector('button')";
	//final String SIGNIN_XPATH ="//button[@id='signIn']";
	final String SIGNIN_XPATH = "//calcite-button[@data-name='signInButton']";
	final String USERNAME_XPATH = "//input[@id='user_username']";
	final String PASSWORD_XPATH = "//input[@id='user_password']";
	final String SIGNINSUBMIT_XPATH  = "//button[@id='signIn']";
	final String ENTER_ID_INPUT_XPATH  = "//input[contains(@class, 'ng-pristine ng-valid')]";
	final String OPEN_ITEM_BTN_XPATH  = "//button[@class='btn']";
	String msg = "";
	CommonFunction cfunction = new CommonFunction();

	public void loginToApplication(String usernametxt, String pwdtxt) throws InterruptedException {
		CommonFunction.waitforpagetoload();
		boolean verified = true;
		cfunction.sync(10);
		
		
		//Click on Sign In button
		
		
		msg = "Click on Sign In button";
		try {
			cfunction.Commmon_Click("xpath",SIGNIN_XPATH);
			//cfunction.Commmon_Click("xpath","//calcite-button");
			//cfunction.CommmonJS_Click_ShadowPath(SIGNIN_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			verified = false;
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "Enter Username";
		try {
			cfunction.CommonTextBox_Input(USERNAME_XPATH, usernametxt);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			verified = false;
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Enter Password"; 
		try {
			cfunction.CommonTextBox_Input(PASSWORD_XPATH, pwdtxt);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			verified = false;
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Click on Sign In";
		try {
			WebElement element= driver.findElementByXPath(SIGNINSUBMIT_XPATH);
			element.submit();
			//cfunction.Commmon_Click("xpath",SIGNINSUBMIT_XPATH);
			//cfunction.CommmonJS_Click_ShadowPath(SIGNIN_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			verified = false;
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		System.out.println("Logged in as "+ usernametxt);
		cfunction.sync(10);
		
		msg = "Fetch Item ID from text file";
		try {
			TestBase.fetchItemID();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		msg = "Enter Item ID and click on Open Item";
		try {
			//List<WebElement> ItemIdCard = driver.findElements(By.xpath("//div[@class='c-workflowItemCard__contentTitle t-workflowItemTitle']"));
			List<WebElement> ItemIdCard = driver.findElements(By.xpath("//div[contains(@class,'c-workflowItemCard__contentTitle t-workflowItemTitle')]"));
			
			int size=ItemIdCard.size();
			for (int i=1;i<=size;i++) {
				String text=cfunction.getElementText("(//div[contains(@class,'c-workflowItemCard__contentTitle t-workflowItemTitle')])["+i+"]");
				cfunction.sync(2);
				if(text.equalsIgnoreCase(itemIdName)) {
					cfunction.hoverByAction("(//div[@class='c-workflowItemCard__thumbnailSection'])["+i+"]");
					cfunction.sync(5);
					cfunction.Commmon_Click("xpath", "(//div[@class='c-workflowItemCard__thumbnailBtns'])["+i+"]");
					break;
				}

			}

			//cfunction.Commmon_Click("xpath", "(//div[@class='c-workflowItemCard__thumbnailBtns'])[1]");

			/*String txtValue="364c8e3bb107476794dad79370fad5ba";
			cfunction.CommonTextBox_Input(ENTER_ID_INPUT_XPATH, txtValue);
			cfunction.Commmon_Click("xpath",OPEN_ITEM_BTN_XPATH);*/
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			verified = false;
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		
		
		msg = "Verify application loaded successfully";
		try {
			TestBase.waitforHomePagetoload();
			//String URL = "https://mcstest62.esri.com/portal/apps/workflowmanager/554a740a715245118d322adf53c010db/coordinate";
			
			boolean check = HomePage.verifyLandingPage();
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				verified = false;
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			verified = false;
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*msg = "Verify by default it opens the Coordinate tab";
		cfunction.sync(2);
		try {
			//String URL = "https://mcstest62.esri.com/portal/apps/workflowmanager/554a740a715245118d322adf53c010db/coordinate";
			boolean check = HomePage.verifyLandingPage(landingPageURL);
			if (check) {
				CommonFunction.logStatus("PASS", msg);
			}

			else {
				verified = false;
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			verified = false;
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		//set locale
		TestBase.setLocale();
		if(verified==false) {
			CommonFunction.logStatus("SKIP", msg);
			driver.close();
		}
	}
	public void loginToApplication1(String usernametxt, String pwdtxt) throws InterruptedException {
		CommonFunction.waitforpagetoload();
		cfunction.sync(10);
		//Click on Sign In button
		msg = "Click on Sign In button";
		try {
			//cfunction.CommmonJS_Click_ShadowPath(SIGNIN_XPATH);
			cfunction.Commmon_Click("xpath",SIGNIN_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "Enter Username";
		try {
			cfunction.CommonTextBox_Input(USERNAME_XPATH, usernametxt);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Enter Password"; 
		try {
			cfunction.CommonTextBox_Input(PASSWORD_XPATH, pwdtxt);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "Click on Sign In";
		try {
			//cfunction.Commmon_Click("xpath",SIGNINSUBMIT_XPATH);
			cfunction.CommmonJS_Click(SIGNINSUBMIT_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		System.out.println("Logged in as "+ usernametxt);
		cfunction.sync(2);
		/*msg = "Enter Item ID and click on Open Item";
		try {
			String txtValue="364c8e3bb107476794dad79370fad5ba";
			cfunction.CommonTextBox_Input(ENTER_ID_INPUT_XPATH, txtValue);
			cfunction.Commmon_Click("xpath",OPEN_ITEM_BTN_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		//set locale
		TestBase.setLocale();
	}
}
