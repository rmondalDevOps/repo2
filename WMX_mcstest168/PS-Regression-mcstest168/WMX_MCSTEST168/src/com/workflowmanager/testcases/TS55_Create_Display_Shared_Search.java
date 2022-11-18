package com.workflowmanager.testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;
public class TS55_Create_Display_Shared_Search extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS55_Create_Shared_Search() throws InterruptedException {
		// CommonFunction.waitforHomePagetoload();
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
		//Click on Settings tab.
		msg = "Click on Settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		// The Settings page has three tabs: Groups, Roles and Email Notifications.
				msg = "Verify the Settings page is visible";
				try {
					Design.verifyGroupTabPanel();
					// cfunction.sync(2);
					Design.verifyRoleTabPanel();
					// cfunction.sync(2);
					Design.verifyEmailNotificationTabPanel();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click on Shared Searches tab
				msg = "Click on Shared Searches";
				try {
					Design.clickOnSharedSearchesTab();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The Shared Searches view opens A list of searches should be visible on the left There should be two columns of information to fill out
		//Click on 'My Jobs'
				msg = "Click on 'My Jobs'";
				try {
					Design.clickOnSavedSearches("My Jobs");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2); 
		//Assert the name, filter, results, and display fields contents
		//Delete the contents of the 'Filter' box
				msg = "Delete the contents of the 'Filter' box";
				try {
					Design.clearFilterInputArea();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2); 
		//Save should light up
				msg = "Save should light up";
				try {
					Design.verifySaveButtonEnable();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click 'Discard Changes'
				msg = "Click 'Discard Changes'";
				try {
					Design.clickDiscardBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The contents should return to their previous state
				msg = "The contents should return to their previous state";
				try {
					if(Design.verifyFilterInputTextPresent()) {
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
		//Click on 'Create New'
				msg = "Click on 'Create New'";
				try {
					Design.clickOnSettingCreateNewBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);	
		//The fields should now be blank, except for results which should default to 25
				msg = "Verify fields should be blank now'";
				try {
					if(Design.verifyFilterInputIsEmpty()) {
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
		//Enter 'priority_rank=10 AND closed=' in the filter text box
				msg = "Enter 'priority_rank=10 AND closed=' in the filter text box";
				try {
					Design.enterFilterInput("priority_rank=10 AND closed=");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Search Name should highlight in red with an error indicator
				msg = "Verify \"Search Name\" should highlight in red with an error indicator";
				try {
					if(Design.verifySearchNameFieldIndicateRed()) {
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
		//Hover over the ! Icon
				msg = "Hover over the ! Icon";
				try {
					Design.hoverOnErrorIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Missing required value should appear
				msg = "\"Missing required value\" should appear";
				try {
					if(Design.verifyToolTipTextPresent("Missing required value")) {
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
		//Input 'High Priority Jobs' for the Search Name
				msg = "Input 'High Priority Jobs' for the Search Name";
				try {
					Design.enterSearchNameInput("High Priority Jobs");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The warning should disappear
				msg = "The warning should disappear";
				try {
					if(Design.verifySearchNameFieldIndicateRed()) {
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
		//Click 'Test Search' button
				msg = "Click 'Test Search' button";
				try {
					Design.clickOnTestBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
		//"A failure toast notification should appear and a ! Icon should appear next to Test Search"
				msg = "A failure toast notification should appear and a ! Icon should appear next to Test Search";
				try {
					String failureMessage="Error testing search: Feature layer call failed with 500: Syntax error [].";
					Design.verifySuccessMsg2(failureMessage);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Hover over the ! Icon
				msg = "Hover over the ! Icon";
				try {
					Design.hoverOnErrorIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Assert the message contents
				
		//Enter 'priority_rank=10 AND closed=0' in the filter text box
				msg = "Enter 'priority_rank=10 AND closed=0' in the filter text box";
				try {
					Design.enterFilterInput("priority_rank=10 AND closed=0");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click 'Test Search' button
				msg = "Click 'Test Search' button";
				try {
					Design.clickOnTestBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
		//"Success toast should appear Success icon should appear next to test search"
				msg = "Success toast should appear Success icon should appear next to test search";
				try {
					Design.verifySuccessMsg2("Search ran successfully");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click 'Add Display Field' four times
				msg = "Click 'Add Display Field' four times";
				try {
					Design.clickOnAddDisplayFieldBtn();
					cfunction.sync(2);
					Design.clickOnAddDisplayFieldBtn();
					cfunction.sync(2);
					Design.clickOnAddDisplayFieldBtn();
					cfunction.sync(2);
					Design.clickOnAddDisplayFieldBtn();
					cfunction.sync(2);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Three input boxes should appear
		//"Fill out the fields with the following:
		//jobName Job Name
				msg = "Fill out the first field with the following:'jobName' 'Job Name'";
				try {
					Design.enterDisplayFieldAndName(1,"jobName");
					cfunction.sync(2);
					Design.enterDisplayFieldAndName(2,"Job Name");
					
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//priorityRank Priority
				msg = "Fill out the second field with the following:'priorityRank' 'Priority'";
				try {
					Design.enterDisplayFieldAndName(3,"priorityRank");
					cfunction.sync(2);
					Design.enterDisplayFieldAndName(4,"Priority");
					
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//dueDate Due
				msg = "Fill out the third field with the following:'dueDate' 'Due'";
				try {
					Design.enterDisplayFieldAndName(5,"dueDate");
					cfunction.sync(2);
					Design.enterDisplayFieldAndName(6,"Due");
					
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The last field should be blank"
				/*msg = "Change Zoom level to 75%";
				//msg = "Zoom out to 90%";
				try {
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("document.body.style.zoom = '75%';");
					
					
					
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_MINUS);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_MINUS);
					
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_EQUALS);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_EQUALS);
					WebElement html = driver.findElement(By.tagName("html"));
					html.sendKeys(Keys.chord(Keys.COMMAND, Keys.ADD));

					//WebElement html = driver.findElement(By.tagName("html"));
					html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
					//html.sendKeys(Keys.chord(Keys.CONTROL, "1"));
					Robot robot = new Robot();
					Thread.sleep(5000);
					System.out.println("About to zoom out");
					for (int i = 0; i < 4; i++) {
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_SUBTRACT);
					robot.keyRelease(KeyEvent.VK_SUBTRACT);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					}
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);*/
		//Click the 'move field to top' button next to blank entry
				msg = "Hover 'move field to top' button next to blank entry";
				try {
					Design.hoverMoveToTopBtn(4);
					
					
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click the 'move field to top' button next to blank entry";
				try {
					
					Design.clickMoveToTopBtn(4);
					
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//Blank field should now be at the top
		//Click the 'move field to bottom' button next to blank entry
				msg = "Click the 'move field to bottom' button next to blank entry";
				try {
					Design.hoverMoveToDownBtn(1);
					cfunction.sync(2);
					Design.clickMoveToDownBtn(1);
					
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//Blank field should now be at the bottom
		//Click the trash can icon
				msg = "Click the trash can icon";
				try {
					Design.clickMoveToDeleteBtn(4);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*msg = "Change Zoom level to 100%";
				//msg = "Zoom out to 90%";
				
					try {
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("document.body.style.zoom = '100%';");
						Robot robot = new Robot();
						Thread.sleep(5000);
						System.out.println("About to zoom in");
						for (int i = 0; i < 4; i++) { 
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_ADD);
						robot.keyRelease(KeyEvent.VK_ADD);
						robot.keyRelease(KeyEvent.VK_CONTROL);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("document.body.style.zoom = '100%'");
						}
						CommonFunction.logStatus("PASS", msg);
				 } catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);*/
		//The field should be deleted
		//Click 'add sort field'
				msg = "Click 'add sort field'";
				try {
					Design.clickOnAddSortFieldBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A field should be added
		//"For the field, input 'dueDate'"
				msg = "For the field, input 'dueDate'";
				try {
					Design.enterSortFieldInput("dueDate");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click the dropdown
		//Ascending and Descending should be options
		//Click ascending
				msg = "Select ascending from the dropdown";
				try {
					Design.selectOptionDrpdwn("Ascending");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Under 'Share Search With', click the 'Group' radio button
				msg = "Under 'Share Search With', click the 'Group' radio button";
				try {
					Design.clickOnGroupRadioBtn1();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//"Please select at least one group should be visible with a warning icon A table of groups should appear"
				msg = "Verify warning message";
				try {
					if(Design.verifyErrorText("Please select at least one group")) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
					//CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*msg = "Change Zoom level to 75%";
				//msg = "Zoom out to 90%";
				try {
					CommonFunction.robotZoomOut(4);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);*/
		//Click the 'Aarthi Dwarakanth' Shared To Checkbox
				msg = "Click the 'Aarthi Dwarakanth' Shared To Checkbox";
				try {
					Design.checkGroupNameCheckbox("AarthiDwarakanath");
					//cfunction.CommmonJS_Click("(//div[@class='ui-chkbox ui-widget'])[47]");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*msg = "Change Zoom level to 100%";
				//msg = "Zoom out to 90%";
				
					try {
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("document.body.style.zoom = '100%';");
						Robot robot = new Robot();
						Thread.sleep(5000);
						System.out.println("About to zoom in");
						for (int i = 0; i < 4; i++) { 
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_ADD);
						robot.keyRelease(KeyEvent.VK_ADD);
						robot.keyRelease(KeyEvent.VK_CONTROL);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("document.body.style.zoom = '100%'");
						}
						CommonFunction.logStatus("PASS", msg);
				 }catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);*/
		//It should become checked
		//Click 'Save'
				msg = "Click 'Save'";
				try {
					Design.clickOnSaveBtnOfSharedSearched1();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
		//A successful toast notification should appear
				msg = "A successful toast notification should appear";
				try {
					Design.verifySuccessMsg2("successful");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Navigate to the work page
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The new search should be in the list of searches at the top
				msg = "The new search should be in the list of searches at the top";
				try {
					if(WorkPage.verifyTabCount()) {
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
		//Click on the 'High Priority Jobs' search (Not the filter)
				msg = "Click on the 'High Priority Jobs' search (Not the filter)";
				try {
					if(WorkPage.clickOnJobTabOption("High Priorit...")) {
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
		//The search should run and the job list should populate accordingly
		//Navigate back to the Shared Searches job
		//Select the 'High Priority Jobs' search
//}
	//public void workflow_TS55_Display_Shared_Search() throws InterruptedException {
	
		//Click on Manage tab
		msg = "Click on Manage tab";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The previously saved shared search is inserted into "Shared" category of Search tab. The default opened search is "My Jobs".
		msg = "Verify previously saved shared search is inserted into \"Shared\" category of Search tab";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			if(Coordinate.verifyNewSharedSearchVisible()) {
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
		//Click on the previously saved search.
		msg = "Click on previously saved search tab";
		try {
			Coordinate.clickOnSharedListOption("High Priority Jobs");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The search results are displayed in the Job List View. 
		//Verify the field names are displayed as Display Name saved in the search. 
		msg = "Verify the field names are displayed as Display Name saved in the search. ";
		try {
			if(Coordinate.verifyNewSharedSearchVisible(1,"Job Name")) {
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
		//The job search returns 25 by default in the Job List View. 
		msg = "The job search returns 25 by default in the Job List View. ";
		try {
			if(Coordinate.verifyJobCount(25)) {
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
		//Verify the Due field only displays date without time.
		msg = "Verify the Due field only displays date without time. ";
		try {
			if(Coordinate.verifydate()) {
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
		//Scroll to the bottom of Job List view and click "Show More"
		//More job results are returned in the Job List view.
		//Click on "All Jobs" search.
		msg = "Click on \"All Jobs\" search.";
		try {
			Coordinate.clickOnSharedListOption("All Jobs");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//It returns all jobs in Job List view. 
		//Click back on the saved search.
		msg = "Click on previously saved search tab";
		try {
			Coordinate.clickOnSharedListOption("High Priority Jobs");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The search results are displayed in the Job List View. 
		msg = "Verify the field names are displayed as Display Name saved in the search. ";
		try {
			if(Coordinate.verifyNewSharedSearchVisible(1,"Job Name")) {
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
		//The job search returns 25 by default in the Job List View. 
		msg = "The job search returns 25 by default in the Job List View. ";
		try {
			if(Coordinate.verifyJobCount(25)) {
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
		//Verify the Due field only displays date without time.
		msg = "Verify the Due field only displays date without time. ";
		try {
			if(Coordinate.verifydate()) {
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
		//Go to Settings - Shared Search
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on Settings tab.
		msg = "Click on Settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on Shared Searches tab
		msg = "Click on Shared Searches";
		try {
			Design.clickOnSharedSearchesTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on the previously saved search.
		msg = "Click on 'previously saved search'";
		try {
			Design.clickOnSavedSearches("High Priority Jobs");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2); 
		//Click the '…' button
		/*msg = "Change Zoom level to 75%";
		//msg = "Zoom out to 90%";
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.body.style.zoom = '75%';");
			Robot robot = new Robot();
			Thread.sleep(5000);
			System.out.println("About to zoom out");
			for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);*/
		//Click Delete Search
		msg = "Click Delete Search";
		try {
			Design.selectDeleteFromEllipseDrpdwn1();
			cfunction.sync(2);
			//cfunction.CommmonJS_Click("(//span[@class='ui-button-text'])[1]");
			cfunction.CommmonJS_Click("//button[@class='btn p-button']");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);  
		//A toast notification should appear and the first search should be selected
		msg = "Verify toast notification should appear for search delete";
		try {
			String failureMessage="Search deleted successfully";
			Design.verifySuccessMsg2(failureMessage);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		/*msg = "Change Zoom level to 100%";
		//msg = "Zoom out to 90%";
		
			try {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("document.body.style.zoom = '100%';");
				Robot robot = new Robot();
				Thread.sleep(5000);
				System.out.println("About to zoom in");
				for (int i = 0; i < 4; i++) { 
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ADD);
				robot.keyRelease(KeyEvent.VK_ADD);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.body.style.zoom = '100%'");
				}
				CommonFunction.logStatus("PASS", msg);
		 } catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);*/
		//Navigate to the work page
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The search should no longer be visible.
		msg = "The search should no longer be visible.";
		try {
			if(WorkPage.verifyTabCount()) {
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
		//Navigate to the Manage page
		msg = "Click on Manage tab";
		try {
			HomePage.clickOnCoordinate();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The search should no longer be visible.
		msg = "The search should no longer be visible.";
		try {
			Coordinate.clickOnLeftCollapseBtn();
			if(Coordinate.verifyNewSharedSearchVisible()) {
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
	}
}