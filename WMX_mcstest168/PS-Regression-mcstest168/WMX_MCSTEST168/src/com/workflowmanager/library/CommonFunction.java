package com.workflowmanager.library;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.workflowmanager.testcases.TestSuite;




public class CommonFunction extends TestBase {

	/*static Method m;
	static String testName = m.getName();
	public static ExtentTest logger;*/
	/**********************************************************************************************
	 * <b>Method Signature Name:</b> getWebElement <br>
	 * <br>
	 * <b>Description:</b> Retrieves the element.
	 * 
	 * @param locator
	 *            The locator text
	 * @param locatorType
	 *            The locator type (e.g. <i>id, name, css, xpath, class, linkText, partialLinkText, tagName</i>)
	 * @return The web element success, null on failure
	 *********************************************************************************************/
	public static WebElement getWebElement( String locatorType, String locator ) {

		String type = locatorType.trim().toLowerCase();
		WebElement element = null;
		
		try {

			if (type.equals("id")) {
				element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.id(locator)));
			} else if (type.equals("name")) {
				element = (new WebDriverWait(driver,50)).until(ExpectedConditions.elementToBeClickable(By.name(locator)));
			} else if (type.equals("css")) {
				element = (new WebDriverWait(driver,50)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
			} else if (type.equals("class")) {
				element = (new WebDriverWait(driver,50)).until(ExpectedConditions.elementToBeClickable(By.className(locator)));
			} else if (type.equals("xpath")) {
				element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			} else if (type.equals("tagname")) {
				element = (new WebDriverWait(driver,50)).until(ExpectedConditions.elementToBeClickable(By.tagName(locator)));
			} else if (type.equals("linktext")) {
				element = (new WebDriverWait(driver,50)).until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
			} else if (type.equals("partiallinktext")) {
				element = (new WebDriverWait(driver,50)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locator)));
			} else {
				String msg =
						"isElementPresent(): Invalid locator type.  Supported types are id, name, css, xpath, class, linkText, partialLinkText, tagName";
				System.out.println(msg);
			}

		} catch (NoSuchElementException e) {
			System.out.println("getWebElement(): The WebElement was not found");
			return null;
		}

		return element;
	}
	
	public void CommonTextBox_Clear( String XPATH) {
		WebElement txtBox = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
		txtBox.click();
		//txtBox.sendKeys(txtValue);
		//txtBox.sendKeys(Keys.CONTROL);
		Actions builder = new Actions(driver);
		builder.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
		txtBox.sendKeys(Keys.DELETE);
	}
	
	// Button click function
		public void Commmon_Click(String xpath,String locator) {
			/*WebElement clickButton = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));*/
			WebElement clickButton = getWebElement(xpath,locator);
			clickButton.click();
		}
		//Button double click function

		public void CommmonDouble_Click(String XPATH) {
			WebElement doubleClick = (new WebDriverWait(driver,50))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));			

			((JavascriptExecutor) driver).executeScript("var evt = document.createEvent('MouseEvents');"+ 
					"evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"+ 
					"arguments[0].dispatchEvent(evt);", doubleClick);
		}

		public void CommmonJS_Click(String XPATH) {
			WebElement doubleClick = (new WebDriverWait(driver,50))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", doubleClick);
		}
		public void CommmonJS_Click_ShadowPath(String XPATH) {
			String JSPATH = XPATH;
			WebElement elm5 = getWebelement_JSpath(JSPATH);
			/*WebElement elm5 = (new WebDriverWait(driver,50))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));	
						*/	
			cfunction.sync(5);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm5);
			/*WebElement elm5 = getWebelement_JSpath(JSPATH);
			elm5.click();
			Actions act = new Actions(driver);
			//act.sendKeys(elm5, AddFromWebLayerTitle).build().perform();
			act.click(elm5);*/
		}
		public void CommmonJS_Hover_ShadowPath(String XPATH) {
			String JSPATH = XPATH;
			WebElement elm5 = getWebelement_JSpath(JSPATH);
			/*WebElement elm5 = (new WebDriverWait(driver,50))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));	
						*/	
			cfunction.sync(5);
			((JavascriptExecutor)driver).executeScript("arguments[0].onmouseover();",elm5);
			
			
		/*	String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
	         ((JavascriptExecutor) driver).executeScript(mouseOverScript,elm5);*/
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm5);
			/*WebElement elm5 = getWebelement_JSpath(JSPATH);
			elm5.click();
			Actions act = new Actions(driver);
			//act.sendKeys(elm5, AddFromWebLayerTitle).build().perform();
			act.click(elm5);*/
		}
		
		public WebElement getWebelement_JSpath(String JSPATH) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement element = (WebElement)js.executeScript("return "+ JSPATH);
			return element;
			}

		public void waitForProgressBarToEnd() {
			String XPATH = "//div[@class='esriLoading' and contains(@style,'display:none')]";
			WebElement progressbar = (new WebDriverWait(driver,500))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH)));			
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", progressbar);
			if(progressbar.isDisplayed()) {
				System.out.println("Done");
			}

		}

		// Check box check function
		public void CommonCheckBox_Check( String XPATH) {
			WebElement checkBoxCheck = (new WebDriverWait(driver,50))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
			checkBoxCheck.click();
		}

		// get Text of element
		public String getElementText( String XPATH) {
			WebElement element = (new WebDriverWait(driver,50))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
			return element.getText();
		}
		public String getElementText1( String XPATH) {
			WebElement element = driver.findElementByXPath(XPATH);
			return element.getText();
		}

		// get Attribute of element
		public String getElementAttribute( String XPATH, String attribute) throws Exception{
			WebElement element = (new WebDriverWait(driver,50))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
			return element.getAttribute(attribute);
		}
		public String getElementAttribute1( String XPATH, String attribute) throws Exception{
			WebElement element = driver.findElementByXPath(XPATH);
			return element.getAttribute(attribute);
		}

		// Pass/Insert/Input value in textbox
		public void CommonTextBox_Input( String XPATH, String txtValue) {
			WebElement txtBox = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
			txtBox.clear();
			txtBox.sendKeys(txtValue);
		}
		public void CommonTextBox_Input2( String XPATH, String txtValue) {
			//WebElement txtBox = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
			//txtBox.clear();
			WebElement txtBox = driver.findElementByXPath(XPATH);
			txtBox.clear();
			txtBox.sendKeys(txtValue);
		}

		// Click on dropdown and select value from dropdown
		public void CommonDropDown_Select( String XPATH) {
			WebElement select_dropdown = (new WebDriverWait(driver,50))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
			select_dropdown.click();
		}
	// Select data in dropdown by name
	// public void DropDown_SelectById(WebDriver driver, String XPATH, String drpId,
	// String drpOption) {
	// Select SelectByName = new Select(driver.findElement(By.id(drpId)));
	// SelectByName.selectByVisibleText(drpOption);
	// }

	public void DropDown_SelectByText( String Text) {

		List<WebElement> optionList = driver
				.findElements(By.xpath("//*[@id='syncGeoServiceName']/tbody/tr/td[2]/input"));

		for (int i = 0; i < optionList.size(); i++) {
			if (optionList.get(i).getText() == Text) {
				optionList.get(i).click();
			}
		}
	}

	public void DefDropDwn() {
		List<WebElement> allOptions = driver.findElements(By.xpath("//input[@id='dijit_form_FilteringSelect_9']"));

		for (WebElement option : allOptions) {
			if (option.getText().equals("*")) {
				option.click();
			}
		}
	}

	public String getTextFromTd( String XPATH)	{
		String returnValue= "";		
		returnValue = driver.findElement(By.xpath(XPATH)).getText();
		return returnValue;
		//WebElement getTextValue = (new WebDriverWait(driver, 55))
		//		.until(ExpectedConditions.findElement(By.xpath(XPATH)));
	}
	public String checkString(String compValue)	{
		String[] notificationZoneName = new String[] {"Alpha","Bravo","Charlie","Delta","Echo"};
		String returnString = ""; 
		for (String compair : notificationZoneName) {
			if(compair == compValue) {
				returnString = "";
				returnString = compValue;		    	
			}		    
		}
		return returnString;
	}
	public  void sync(int time){
		int waittime = time*1000;
		try {
			Thread.sleep(waittime);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Sync Failed");
		}
	}

	public static void ScrollToElement(String xpath) {
		try {
			WebElement scrollElement = (new WebDriverWait(driver,50)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
			Thread.sleep(500); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ScrollToElement1(String xpath) {
		try {
			Thread.sleep(5000);
			WebElement scrollElement = driver.findElementByXPath(xpath);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
			Thread.sleep(500); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void logStatus(String status, String msg) {
		msg = stepCount++ + " - " + msg;
		
		try {
			if(status.equals("PASS")) {
				msg = msg+ " -  Passed";
				totalFailStep=0;
				//totalFailStep= totalFailStep+1;
				if(screenshotEnabled) {
					String screenshot = TestBase.getScreenshot(driver);
					logger.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
				}else {
					logger.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				}
			}
			else if(status.equals("FAIL")){
				totalFailStep= totalFailStep+1;
				msg = msg+ " - Failed" + "<br />"+ submitDefectDevtopia();
				//if(screenshotEnabled) {
				String screenshot = TestBase.getScreenshot(driver);
				logger.fail(msg, MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
				/*if(totalFailStep==5){
					logger.log(Status.SKIP,	MarkupHelper.createLabel(msg + " - Test Case Skipped", ExtentColor.ORANGE));
					extent.flush();
					driver.close();
					//extent.flush();
					driver.close();
					return;
					
					
					CommonFunction.logStatus("SKIP", msg);
					driver.close();
				}
					msg="Failed steps exceeds the maximum limit";
					CommonFunction.logStatus("SKIP", msg);
					String locator = "//wmx-header";
					@SuppressWarnings("unused")
					WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
					System.out.println("HomePage load complete");
					
					//TestSuite TS =new TestSuite();
					try {
						//GeneratetxtResultFile.generatetxtResultFileforCITool(extentReportFilePath_BrowserNameOnly);
						extent.flush();
						softAssert.assertAll();
					} catch(Exception e) {
						e.printStackTrace();
					}
					driver.close();
					return;
					
				}*/
				
			}else if(status.equals("SKIP")) {
				logger.log(Status.SKIP,	MarkupHelper.createLabel(msg + " - Test Case Skipped", ExtentColor.ORANGE));
				driver.close();
				extent.flush();
				
			//extent.flush();
			}/*else if(totalFailStep==5) {
				msg="Failed steps exceeds the maximum limit";
				CommonFunction.logStatus("SKIP", msg);
				driver.close();
				//logger.log(Status.SKIP,	MarkupHelper.createLabel(msg + " - Test Case Skipped", ExtentColor.ORANGE));
				//driver.close();
				extent.flush();
			}*/
			extent.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(totalFailStep>=5) {
			msg="Failed steps exceeds the maximum limit";
			logger.log(Status.SKIP,	MarkupHelper.createLabel(msg + " - Test Case Skipped", ExtentColor.ORANGE));
			driver.close();
			extent.flush();
			//extent.flush();
			//driver.quit();
			System.out.println("Closing chrome browser after every test");
			driver.close();
			// extent.flush();
			softAssert.assertAll();
			/*String locator = "//wmx-header";
			@SuppressWarnings("unused")
			WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			System.out.println("HomePage load complete");*/
			
			/*TestSuite TS =new TestSuite();
			try {
				TS.endReport();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}}
		
	
	public static void logStatus(String status, String msg, int bugId) {
		msg = stepCount++ + " - " + msg;
		//String bugLink = "Devtopia Bug Reference : <a href='https://github.com/arcgis/indoors-webapp/issues/" + bugId+"' target='_blank'> #"+ bugId + " </a>";
		System.out.println("Entered in log");
		try {
			if(status.equals("PASS")) {
				msg = msg+ " -  Passed";
				if(screenshotEnabled) {
					String screenshot = TestBase.getScreenshot(driver);
					logger.pass(msg+ " -  Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
				}else {
					logger.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				}
			}
			else if(status.equals("FAIL")){
				if(bugId == 0)
					msg = msg+ " - Failed" + "<br />"+ submitDefectDevtopia();
				else
					msg = msg+ " - Failed" + "<br />"+ addBugId(bugId);
				String screenshot = TestBase.getScreenshot(driver);
				//CommonFunction.expectedImage("expectedTextImage.png", imgStored);
				/*CommonFunction.observedImage("actualTextImage.png",screenshot);
				String finalCapture = CommonFunction.finalImage("combined.png", "combined1.png");
				String finalCapture1 = "Screenshot/"+ finalCapture;*/
				logger.fail( msg, MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
				
			}else if(status.equals("SKIP")) {
				logger.log(Status.SKIP,	MarkupHelper.createLabel(msg + " - Test Case Skipped", ExtentColor.ORANGE));
			}
			extent.flush();
		} catch (IOException e) {
			e.printStackTrace();
			extent.flush();
		}
	}  

	public boolean verifyElementText(String xpath, String text) throws Exception{
		boolean verified = false;
		String elementText = getElementText(xpath);
		System.out.println("---"+ elementText);

		//In case of INPUT getText() returns ""(empty String), try getting the attribute value 
		if(elementText.equals(""))
			elementText = getElementAttribute(xpath, "value");
		System.out.println("---"+ elementText);
		//check if expected text is same as the actual	
		if(elementText.equalsIgnoreCase(text))
			verified = true;

		return verified;
	}
	public boolean verifyElementAttribute_Value(String xpath, String text) throws Exception{
		boolean verified = false;
		String elementText = getElementAttribute(xpath, "value");
		System.out.println("---"+ elementText);

		//In case of INPUT getText() returns ""(empty String), try getting the attribute value 
		if(elementText.equalsIgnoreCase(text))
			verified = true;

		return verified;
	}
	// finds if the test suite is runnable 
	public static boolean isTestExecutable(String testName){
		boolean isExecutable=false;
		try {
			String excelSheet ="Executable Suite"; 

			for(int i=2; i <= xls.getRowCount(excelSheet) ;i++ ){
				String testcase = xls.getCellData(excelSheet, "Test Scenario", i);
				String runmode = xls.getCellData(excelSheet, "Runmode", i);

				if(testName.equalsIgnoreCase(testcase)){
					if(runmode.equalsIgnoreCase("Y")){
						isExecutable=true;
						break;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isExecutable;
	}


	public void closeAllOtherTabs() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for(int i = 1; i < tabs.size(); i++) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}
		driver.switchTo().window(tabs.get(0));
	}

	public void selectValueFromDropdown(String geoeventdefinitiondropdownXpath, String value) {
		CommonDropDown_Select(geoeventdefinitiondropdownXpath);
		sync(2);
		String MENUITEM_XPATH = geoeventdefinitiondropdownXpath.replace("']", "_dropdown']") + "//tr//td[@class='dijitReset dijitMenuItemLabel']";
		//String MENUITEM_XPATH = geoeventdefinitiondropdownXpath.replace("']", "_dropdown']") + "//tr[contains(@id,'dijit_MenuItem_')]";

		List<WebElement> items = driver.findElements(By.xpath(MENUITEM_XPATH));
		for(WebElement item: items) {
			String menuItem = item.getText();
			//String menuItem = item.getAttribute("aria-label");
			if(menuItem.contains("  ")) {
				menuItem = menuItem.split("  ")[0];
			}
			System.out.println(menuItem + "  --  " + value);
			if(menuItem.equalsIgnoreCase(value)) {
				item.click();
				break;
			}
		}
	}

	public void selectValueFromMenueItem(String assigntodropdownmenuitemXpath, String value) {
		List<WebElement> items = driver.findElements(By.xpath(assigntodropdownmenuitemXpath));
		for(WebElement item: items) {
			String menuItem = item.getText();

			System.out.println(menuItem + "  --  " + value);
			if(menuItem.equalsIgnoreCase(value)) {
				item.click();
				System.out.println(menuItem + " selected" );
				break;
			}
		}
	}

	public static boolean elementIsDisplayed(String xPath) {
		boolean iselementPresent = false;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		iselementPresent = driver.findElement(By.xpath(xPath)).isDisplayed();
		System.out.println("iselementPresent: " + iselementPresent);
		return iselementPresent;
	}
	public static boolean checkSorting(String JOBLIST_XPATH) throws InterruptedException
	{

		System.out.println("checkSorting: Webelement");
		// Get All Weblement from List
		List<WebElement> itemListTags = driver.findElements(By.xpath(JOBLIST_XPATH));

		// Check Size
		System.out.println("itemListTags size: "+ itemListTags.size());

		//Take an Array List of type String
		//List<String> itemListString= new ArrayList<String>();
		ArrayList < String > alist = new ArrayList < String >();

		// Add Text of all weblements to arraylist
		for (int i = 0; i< itemListTags.size(); i++) {
			alist.add(itemListTags.get(i).getText().toString());
		}
		// Confrom All elements are added
		System.out.println("All items added");

		//Make copy of unsoted arraylist
		List<String> presort = alist;

		// Sort the array list 
		Collections.sort(presort);

		boolean sorted = false;
		// Alternate method to check id list is sorted
		// sorted = checkAscendingOrder(alist);


		// Check if Sorted and unsorted arraylist match
		if(alist.toString().equals(presort.toString())) {
			// if (sorted== true){
			sorted = true;
			//System.out.println("Products names are Sorted in ascending Order");
		}
		else {
			//System.out.println("Products names are not Sorted in ascending Order");
		}
		return sorted;
	}

	public static boolean checkAscendingOrder(ArrayList<String> texts)
	{
		System.out.println("In checkAscendingOrder: ");

		String previous = ""; // empty string

		for (String current: texts) {
			if (current.compareTo(previous) < 0)
			{
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static void ScrollBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.scrollHeight)");
	}

	public static boolean verifylowToHigh(String PRIORITYLIST_XPATH) throws InterruptedException

	{         
		List<WebElement> priorityListTags = driver.findElements(By.xpath(PRIORITYLIST_XPATH));
		System.out.println(priorityListTags.size());
		ArrayList < String > alist = new ArrayList < String >();
		//for (int i = 0; i<priorityListTags.size(); i=i+1) 
		{

			// Add Text of all weblements to arraylist
			for (int i = 0; i< priorityListTags.size(); i++) {
				System.out.println(priorityListTags.get(i).getText()); 
				alist.add(priorityListTags.get(i).getText().toString());
				System.out.println(priorityListTags.get(i).getText());  
			}
			// Confrom All elements are added
			System.out.println("All items added");

			//Make copy of unsoted arraylist
			//List<String> presort = alist;

			// Sort the array list 
			Collections.sort(alist);
		}
		return true; 
	}

	public void clearAndPressEnterKey( String XPATH, String txtValue) {
		WebElement txtBox = (new WebDriverWait(driver,50))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
		txtBox.clear();
		sync(2);
		txtBox.sendKeys(Keys.ENTER);
	}
	public void PressBackSpaceAndPressEnterKey( String XPATH,int numberOfPresses) {
		WebElement txtBox = (new WebDriverWait(driver,50))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
		txtBox.click();
		sync(2);
		/*txtBox.sendKeys(Keys.ENTER);*/
		for(int i=1;i<=numberOfPresses;i++) {
			txtBox.sendKeys(Keys.BACK_SPACE);
		}
		
	}
	public void pressEnterKey( ) {
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER).build().perform();
	}
	public static void robotZoomOut(int count ) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.body.style.zoom = '75%';");
	/*Robot robot = new Robot();
	Thread.sleep(5000);
	System.out.println("About to zoom out");
	for (int i = 0; i < count; i++) {
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_SUBTRACT);
	robot.keyRelease(KeyEvent.VK_SUBTRACT);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	}*/
	}
		catch (Exception e) {
			e.printStackTrace();
			}}
	public boolean verifyToolTip(String xpath, String tooltip) {
		try {
			WebElement element = CommonFunction.getWebElement("xpath", xpath);
			String title = element.getAttribute("title");
			if(title.equalsIgnoreCase(tooltip)) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public void hoverOnElement(WebElement elementHover) {
		String strJavaScript = "var element = arguments[0];"
				+ "var mouseEventObj = document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );"
				+ "element.dispatchEvent(mouseEventObj);";
		((JavascriptExecutor) driver).executeScript(strJavaScript, elementHover);
	}
	public void hoverByJS(WebElement elementHoverV) {
		/*String strJavaScript = "var element = arguments[0];"
				+ "var mouseEventObj = document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );"
				+ "element.dispatchEvent(mouseEventObj);";
		 */
		String strJavaScript = "var evObj = document.createEvent('MouseEvents');" +
				"evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
				"arguments[0].dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(strJavaScript, elementHoverV);
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();",elementHoverV);
		//elementHoverV.click();

		/*String strJavaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].onmouseover();";
		((JavascriptExecutor) driver).executeScript(strJavaScript, elementHoverV);*/

		/*		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(mouseOverScript, elementHoverV);
		 */		//System.out.println("strJavaScript"+ strJavaScript);


		/*JavascriptExecutor jsHover = (JavascriptExecutor)driver;
		jsHover.executeScript("var evObj = document.createEvent('MouseEvents');" +
		                    "evObj.initMouseEvent('mouseover',true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
		                    "arguments[0].dispatchEvent(evObj);", element);
		jsHover.executeScript("arguments[0].click();",element);*/

		/*try 
	     {
	         String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
	         ((JavascriptExecutor) driver).executeScript(mouseOverScript,elementHover);
	         Thread.sleep(1000);
	         ((JavascriptExecutor)driver).executeScript("arguments[0].click();",elementHover);


	    } catch (Exception e) {
	        // TODO: handle exception
	    }*/
	}

	public void hoverByAction(String createDefault_xpath) {
		//WebElement hoverElem = CommonFunction.getWebElement("xpath", createDefault_xpath);
		WebElement hoverElem = driver.findElement(By.xpath(createDefault_xpath));
		Actions builder = new Actions (driver);							
		builder.moveToElement(hoverElem).build().perform();

		/*Actions builder = new Actions(driver);
		builder.moveToElement(hoverElem).click(hoverElem).build().perform();*/
		//builder.moveToElement(hoverElem).perform();
		//By locator = By.id("clickElementID");
		//builder.click(hoverElem);

	}



	public static String getCSSValue(String xpath, String css) throws Exception{
		String value = "";
		WebElement element = getWebElement("xpath", xpath);
		value = element.getCssValue(css);
		return value;
	}

	public static String rgbToHex(String colorString) {
		String hex = null;
		//check the rgb
		int rgbStartIndex = colorString.indexOf("rgb");
		int rgbEndIndex = colorString.indexOf(")") + 1;
		if( rgbStartIndex > 0) {
			colorString = colorString.substring(rgbStartIndex, rgbEndIndex);
		}
		System.out.println("=> Color is : " + colorString);
		hex = org.openqa.selenium.support.Color.fromString(colorString).asHex();
		System.out.println("=> The hex conversion is : " + hex);

		return hex;
	}

	public boolean verifyIfHighlighted(String xPath) throws Exception{		
		cfunction.sync(5);
		String color = getCSSValue(xPath, "color");
		cfunction.sync(2);
		color = getCSSValue(xPath, "color");
		String hex = rgbToHex(color);
		System.out.println("Color ---> " + hex);
		if(hex.equalsIgnoreCase("#005e95"))
			return true;
		return false;
	}
	public void skipWindowDialogBoxAfterClick() {
		// TODO Auto-generated method stub

        ((JavascriptExecutor)driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                "};                                                                  " );
	}
	public static void CommonTextBox_Input8( String XPATH, String txtValue) {
        WebElement txtBox = getWebElement2("xpath", XPATH);
        txtBox.sendKeys(txtValue);
    }
	public static WebElement getWebElement2(String locatorType, String locator) {
		String type = locatorType.trim().toLowerCase();
		WebElement webElement = null;
		
		try {
			switch(type) {
			case "xpath":
				if(isPageElementPresent(locatorType, locator)){
					return driver.findElementByXPath(locator);
				}
				break;
			case "id":
				webElement = driver.findElementById(locator);
				break;
			case "css":
				webElement = driver.findElementByCssSelector(locator);
				break;
			}
			
		} catch(Exception e) {
			webElement =  null;
		}
		
		return webElement;
	}
	public static boolean isPageElementPresent(String locatorType, String locator) {
		int size = driver.findElements(By.xpath(locator)).size();
		
		return (size != 0);
		
		/*WebElement element = getWebElement(locatorType, locator);	
		
		return (element != null);*/
	}
	public boolean verifyIfHighlighted(String xPath, String attribute) throws Exception{
		String color = getCSSValue(xPath, "background-color");
		if(attribute.equals("border"))
			color = getCSSValue(xPath, "border");
		String hex = rgbToHex(color);
		System.out.println("Color ---> " + hex);
		if(hex.equalsIgnoreCase("#007ac2"))
			return true;
		return false;
	}

	public String getUniqueName(String name) {
		Date datef = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy_MM_dd_HHmm");
		name = name + "_" + dateformat.format(datef);
		System.out.println("Service name  --- " + name);
		return name;
	}
	
	public String getUniqueName1(String name) {
		Date datef = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy_MM_dd_HHmm");
		name = name + "_TimeStamp_" + dateformat.format(datef);
		System.out.println("Service name  --- " + name);
		return name;
	}

	// get the Devtopia Reference from Excel for each test 
	public static String getDevtopiaReference(String testName){
		String devtopiaRef = "Devtopia Reference : No Reference Found";
		try {
			String excelSheet ="Executable Suite"; 

			for(int i=2; i <= xls.getRowCount(excelSheet) ;i++ ){
				String testscenario = xls.getCellData(excelSheet, "Test Scenario", i);
				if(testName.equalsIgnoreCase(testscenario)){
					int ref = (int) Double.parseDouble(xls.getCellData(excelSheet, "Devtopia", i));
					devtopiaRef =  "Devtopia Reference : <a href='https://devtopia.esri.com/ArcGISPro/ps-software-release/issues/" + ref+"' target='_blank'> #"+ ref + " </a>";
					break;
				}
			}
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return devtopiaRef;
	}

	private static String getName(String testName) {
		String name = "";
		try {
			String excelSheet ="Executable Suite"; 
			for(int i=2; i <= xls.getRowCount(excelSheet) ;i++ ){
				String testscenario = xls.getCellData(excelSheet, "Test Scenario", i);
				if(testName.equalsIgnoreCase(testscenario)){
					name = xls.getCellData(excelSheet, "Name", i);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public static ExtentTest parent;
	public static void setUpTest() {
		testName = new Throwable().getStackTrace()[1].getMethodName();
		System.out.println("Test -->> " + testName );
		String name = getName(testName);
		String devtopiaReference = getDevtopiaReference(testName);
		String githubReference = getGitHubReference(testName);
		String description = devtopiaReference + githubReference ;
		
		//create category
		String category = getTestCategory(testName);
		logger = extent.createTest(name, githubReference);
		logger.assignCategory(category);
		
		/*String name = getName(testName);
		String devtopiaReference = getDevtopiaReference(testName);
		String category = getTestCategory(testName);
		parent = extent.createTest(name, devtopiaReference);
		parent.assignCategory(category);*/
		
	}
	
////get the GitHun Reference from Excel for each test 
	public static String getGitHubReference(String testName){
		String devtopiaRef = "Devtopia Reference : No Reference Found";
		try {
			String excelSheet ="Executable Suite"; 

			for(int i=2; i <= xls.getRowCount(excelSheet) ;i++ ){
				String testscenario = xls.getCellData(excelSheet, "Test Scenario", i);
				if(testName.equalsIgnoreCase(testscenario)){
					int ref = (int) Double.parseDouble(xls.getCellData(excelSheet, "GitHub", i));
					devtopiaRef =  "GitHub Reference : <a href='https://github.com/EsriPS/PS-Regression/issues/" + ref+"' target='_blank'> #"+ ref + " </a>";
					break;
				}
			}
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return devtopiaRef;
	}
	// Get test category 
		public static String getTestCategory(String testName){
			String category = "General";
			try {
				String excelSheet ="Executable Suite"; 
				for(int i=2; i <= xls.getRowCount(excelSheet) ;i++ ){
					String testcase = xls.getCellData(excelSheet, "Test Scenario", i);
					if(testName.equalsIgnoreCase(testcase)){
						category = xls.getCellData(excelSheet, "Category", i);
						break;
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return category;
		}
 public void spaceBar(String xpath) {
		WebElement ele= driver.findElementByXPath(xpath);
		ele.sendKeys(Keys.SPACE);
 }
	public void pressTAB(int input) {
		for(int i=1;i<=input;i++) {
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.TAB).build().perform();
		sync(1);
		}}
		/*Actions action = new Actions(driver); 
		action.sendKeys(Keys.TAB).build().perform();
		sync(1);
		action.sendKeys(Keys.TAB).build().perform();		
		sync(1);
		action.sendKeys(Keys.TAB).build().perform();		
		sync(1);
		action.sendKeys(Keys.TAB).build().perform();
		sync(1);
		action.sendKeys(Keys.TAB).build().perform();
		sync(1);
		action.sendKeys(Keys.TAB).build().perform();
	}*/

	public String getCurrentDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String currentDate = simpleDateFormat.format(new Date());
		System.out.println("Current Date -- >" + currentDate);
		return currentDate;
	}
	public void pressDeleterKey( ) {
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.DELETE).build().perform();
	}

	public boolean verifyIfHighlighted1(String xPath, String attribute, String Bcolor) throws Exception{
		String color = getCSSValue(xPath, "background-color");
		if(attribute.equals("color"))
			color = getCSSValue(xPath, "border-bottom-color");
		String hex = rgbToHex(color);
		System.out.println("Color ---> " + hex);
		if(hex.equalsIgnoreCase(Bcolor))
			return true;
		return false;
	}
	/********************Log Status with actual and expected Screenshots  & Submit Defect
	 * @throws Exception ******************************************/
	public static void logStatus(String status, String msg, String imgStored, int bugId) {
		msg = stepCount++ + " - " + msg;
		//String bugLink = "Devtopia Bug Reference : <a href='https://github.com/arcgis/indoors-webapp/issues/" + bugId+"' target='_blank'> #"+ bugId + " </a>";
		System.out.println("Entered in log");
		try {
			if(status.equals("PASS")) {
				msg = msg+ " -  Passed";
				if(screenshotEnabled) {
					String screenshot = TestBase.getScreenshot(driver);
					logger.pass(msg+ " -  Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
				}else {
					logger.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				}
			}
			else if(status.equals("FAIL")){
				if(bugId == 0)
					msg = msg+ " - Failed" + "<br />"+ submitDefectDevtopia();
				else
					msg = msg+ " - Failed" + "<br />"+ addBugId(bugId);
				String screenshot = TestBase.getScreenshotFailReport(driver);
				CommonFunction.expectedImage("expectedTextImage.png", imgStored);
				CommonFunction.observedImage("actualTextImage.png",screenshot);
				String finalCapture = CommonFunction.finalImage("combined.png", "combined1.png");
				String finalCapture1 = "Screenshot/"+ finalCapture;
				logger.fail( msg, MediaEntityBuilder.createScreenCaptureFromPath(finalCapture1).build());
			}else if(status.equals("SKIP")) {
				logger.log(Status.SKIP,	MarkupHelper.createLabel(msg + " - Test Case Skipped", ExtentColor.ORANGE));
			}
			extent.flush();
		} catch (IOException e) {
			e.printStackTrace();
			extent.flush();
		}
	}    

	public static void  observedImage(String image1,String image2) throws IOException {

		String path =System.getProperty("user.dir") +"/Images/ReportScreenshot";
		String path2=System.getProperty("user.dir") +"/test-output/ExtentReports/Latest/Screenshot";

		//String screenshot = TestBase.getScreenshot(driver);
		// load source images
		BufferedImage image = ImageIO.read(new File(path, image1));
		BufferedImage overlay = ImageIO.read(new File(path2, image2));

		///do some calculate first
		int offset  = 50;
		int wid = image.getWidth()+overlay.getWidth()+offset;
		int height = Math.max(image.getHeight(),overlay.getHeight())+offset;
		//create a new buffer and draw two image into the new image
		BufferedImage combined = new BufferedImage(wid,height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = combined.createGraphics();
		Color oldColor = g2.getColor();
		//fill background
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0, wid, height);
		//draw image
		g2.setColor(oldColor);
		g2.drawImage(image, null, 350, 0);
		g2.drawImage(overlay, null, image.getWidth()+offset, 100);
		g2.dispose();
		ImageIO.write(combined, "PNG", new File(path, "combined.png"));


	}  	
	public static void expectedImage(String image1,String image2) throws IOException {
		String path1 =System.getProperty("user.dir") +"/Images/ReportScreenshot";

		// load source images
		BufferedImage overlay = ImageIO.read(new File(path1, image2));
		BufferedImage image = ImageIO.read(new File(path1, image1));


		//do some calculate first
		int offset  = 50;
		int wid = image.getWidth()+overlay.getWidth()+offset;
		int height = Math.max(image.getHeight(),overlay.getHeight())+offset;
		//create a new buffer and draw two image into the new image
		BufferedImage combined1 = new BufferedImage(wid,height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = combined1.createGraphics();

		g2.drawImage(image, null, 250, 10);
		g2.drawImage(overlay, null, image.getWidth()+offset, 100);
		g2.dispose();
		ImageIO.write(combined1, "PNG", new File(path1, "combined1.png"));
	}

	public static String finalImage(String image1,String image2) throws IOException {

		String path = System.getProperty("user.dir") +"/Images/ReportScreenshot";
		String savedScreenShotPath=System.getProperty("user.dir") +"/test-output/ExtentReports/Latest/Screenshot";
		// load source images
		BufferedImage image = ImageIO.read(new File(path, image1));
		BufferedImage overlay = ImageIO.read(new File(path, image2));

		//IndexColorModel cm = new IndexColorModel()
		//do some calculate first
		int offset  = 100;
		int wid = image.getWidth()+overlay.getWidth()+offset;
		int height = Math.max(image.getHeight(),overlay.getHeight())+offset;
		//create a new buffer and draw two image into the new image

		BufferedImage screenshot = new BufferedImage(wid,height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = screenshot.createGraphics();

		Color oldColor = g2.getColor();
		//fill background
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0, wid, height);
		//draw image
		g2.setColor(oldColor);
		g2.drawImage(image, null, 150, 0);
		g2.drawImage(overlay, null, image.getWidth()+offset, 0);
		g2.dispose();
		String FinalScreenShot="FinalScreenShot_"+System.currentTimeMillis()+".png";
		ImageIO.write(screenshot, "PNG", new File(savedScreenShotPath, FinalScreenShot));
		return FinalScreenShot;
	}



	public static String submitDefectDevtopia(){
		String devtopiaRef = "Submit Defect : No Reference Found";
		try {
			devtopiaRef =  "<a href='https://github.com/esrips/ps-regression/issues/new' target='_blank'> Submit Defect </a>";
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return devtopiaRef;
	}
	/********************Log Status with actual and expected Screenshots ******************************************/
	private static String addBugId(int bugId) {
		String bug ;
		try {
			bug = "Bug ID : <a href='https://devtopia.esri.com/WebGIS/workflow-manager/issues/" +bugId +"' target='_blank'> WebGIS/workflow-manager#"+ bugId+" </a>";
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return bug;
	}
	public void CommonTextBox_Input1( String XPATH, String txtValue) {
		/*WebElement txtBox = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));*/
		WebElement txtBox = driver.findElementByXPath(XPATH);
		sync(7);
		txtBox.clear();
		txtBox.click();
		Actions builder = new Actions(driver);
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(7);
		txtBox.sendKeys(Keys.BACK_SPACE);
		//txtBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		sync(2);
		txtBox.sendKeys(txtValue);
		txtBox.click();
		
}
	public static void selectOptionFromDropDown(String DropDownXpath, String DropDownList, String option) throws Exception {
	// cfunction.Commmon_Click("xpath", LOCATION_METHOD_XPATH);
	cfunction.CommonDropDown_Select(DropDownXpath);
	List<WebElement> rows = driver.findElements(By.xpath(DropDownList));
	for (WebElement options : rows) {
		if (options.getText().equals(option)) {
			cfunction.sync(2);
			options.click();
		}
	}
}
	public void selectValueFromDropdown_new(String dropdownXpath,String dropdownValueList, String value) {
		//CommonDropDown_Select(dropdownXpath);
		//cfunction.Commmon_Click("xpath", dropdownXpath);
		cfunction.CommmonJS_Click(dropdownXpath);
		sync(2);
		
		List<WebElement> items = driver.findElements(By.xpath(dropdownValueList));
		for(WebElement item: items) {
			String menuItem = item.getText();
			//String menuItem = item.getAttribute("aria-label");
			if(menuItem.contains("  ")) {
				menuItem = menuItem.split("  ")[0];
			}
			System.out.println(menuItem + "  --  " + value);
			if(menuItem.equalsIgnoreCase(value)) {
				item.click();
				break;
			}
		}
	}
	
	public static void enterRobotTypes(String searchText, String  xpath) throws AWTException, InterruptedException {
		cfunction.waitforpagetoload();
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath",xpath);

		// ngwebdriverHelp.CommonNG_WaitforAngularRequest();
		// cfunction.sync(50);

		// WebElement element= driver.findElementByXPath(WEBHOOKNAME_XPATH);

		String str = searchText;
		Robot robot = new Robot();
		// Press keys using robot
		// A gap of 200ms is added between each key press
		for (int i = 0; i < str.length(); i++) {
			// Check if the current character is a capital letter
			if (Character.isUpperCase(str.charAt(i))) {
				// Press shift key
				robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
				robot.keyPress(Character.toUpperCase(str.charAt(i)));
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
			}
			// else display the character as it is
			else
				robot.keyPress(Character.toUpperCase(str.charAt(i)));
			// wait for 200ms
			Thread.sleep(200);
		}

		// cfunction.CommonTextBoxJS_Input(WEBHOOKNAME_XPATH, searchText);

	}
	
	public static void openNewTabsWithURL(String url) {
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(url);
		cfunction.sync(5);
	}
	public static boolean formatfileDateTime(FileTime fileTime) {
		Date datef = new Date();
		SimpleDateFormat dateformat1 = new SimpleDateFormat("MM/dd/yyyy");
		String Date1 = dateformat1.format(datef);
		final DateTimeFormatter DATE_FORMATTER =
		DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		LocalDateTime localDateTime = fileTime
		.toInstant()
		.atZone(ZoneId.systemDefault())
		.toLocalDateTime();
		if (localDateTime.format(DATE_FORMATTER).contains(Date1))
		return true;
		else return false;
		}
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
        	setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
}

