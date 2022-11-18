package com.workflowmanager.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;

public class HomePage extends TestBase {

	//XPATH
	private static final String COORDINATE_XPATH = "(//button[contains(@class,'top-nav-link')])[2]";
	private static final String DESIGN_XPATH = "(//button[contains(@class,'top-nav-link')])[1]";
	private static final String WORK_XPATH = "(//button[contains(@class,'top-nav-link')])[3]";
	private static final String USERSECTION_XPATH = "//div[@class='ng-star-inserted']";
	private static final String LOGOUT_XPATH = "//div[@class='ng-star-inserted']//calcite-dropdown-item";
	/*private static final String USERSECTION_XPATH = "//div[@class='userSection ']";
	private static final String LOGOUT_XPATH = "//div[@class='userSection ']//nav//a";*/

	static CommonFunction cfunction = new CommonFunction();


	//click on Design Button
	public static void clickOnDesign() {
		cfunction.sync(10);
		//cfunction.Commmon_Click("xpath",DESIGN_XPATH);
		cfunction.Commmon_Click("xpath", "(//calcite-tab-title)[1]");
		
	}
	//click on Coordinate Button
	public static void clickOnCoordinate() {
		cfunction.sync(20);
		//cfunction.Commmon_Click("xpath", COORDINATE_XPATH);
		cfunction.Commmon_Click("xpath", "//calcite-tab-title[2]");
	}

	// Click on Work Button
	public static void clickOnWork() {
		cfunction.sync(10);
	//	cfunction.Commmon_Click("xpath",WORK_XPATH);
		cfunction.Commmon_Click("xpath", "(//calcite-tab-title)[3]");
		cfunction.sync(5);
	}

	// Click on Log Out Button
	public static void clickOnLogOut() {
		cfunction.Commmon_Click("xpath",USERSECTION_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath",LOGOUT_XPATH);
		//cfunction.CommmonJS_Click_ShadowPath(LOGOUT_XPATH);
	}
	public  static boolean verifyLandingPage1(String expectedURL) {
		boolean verified = false;
		try {
		String landingPageURL = driver.getCurrentUrl();
		System.out.println("landingPageURL: "+landingPageURL);
		System.out.println("expectedURL: "+expectedURL);
		if(landingPageURL.contains(expectedURL)) {
			verified = true;
		}
		}catch (Exception e) {
			e.printStackTrace();
			//CommonFunction.logStatus("FAIL", msg);
		
		}
		return verified;
	}
	// Edited by Sarath
	public  static boolean verifyLandingPage() {
		boolean verified = false;
		try {
 
		String	itemID = TestBase.fetchItemID();
		String	expectedURL = "https://mcstest62.esri.com/portal/apps/workflowmanager/"+itemID+"/manage?content=0&leftPanel=false&rightPanel=true&queryId=L46soUSzRD62LqwFvp5pVQ";
		String	expectedURL2 = "https://mcstest62.esri.com/portal/apps/workflowmanager/"+itemID+"/manage?queryId=L46soUSzRD62LqwFvp5pVQ&content=0&leftPanel=false&rightPanel=true";
		
		String landingPageURL = driver.getCurrentUrl();
		
		if(landingPageURL.contains(expectedURL)) {
			System.out.println("landingPageURL: "+landingPageURL);
			System.out.println("expectedURL: "+expectedURL);
			verified = true;
		}else if(landingPageURL.contains(expectedURL2)) {
			System.out.println("landingPageURL: "+landingPageURL);
			System.out.println("expectedURL: "+expectedURL2);
			verified = true;	
		}
		}catch (Exception e) {
			e.printStackTrace();
			//CommonFunction.logStatus("FAIL", msg);
		}
		return verified;
	}
	
	public static void verifyNewTab(String msg) {
		 if (driver.getCurrentUrl().contains("workflow")) {
            System.out.println("New tab here");
            CommonFunction.logStatus("PASS", msg);
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            cfunction.sync(7);
            driver.close();
            cfunction.sync(7);
            driver.switchTo().window(tabs2.get(0));
        } else {
       	 System.out.println("New tab not here");
       	 CommonFunction.logStatus("FAIL", msg);
        }
	}
	
	public static void verify_itemPage(String msg) {
		List<WebElement> ItemIdCard = driver.findElements(By.xpath("//div[contains(@class,'c-workflowItemCard__contentTitle t-workflowItemTitle')]"));
		int size=ItemIdCard.size();
		if(size>0) {
			 CommonFunction.logStatus("PASS", msg);
		} else {
			System.out.println("New tab not here");
       	 CommonFunction.logStatus("FAIL", msg);
		}
	}
	
	
}

