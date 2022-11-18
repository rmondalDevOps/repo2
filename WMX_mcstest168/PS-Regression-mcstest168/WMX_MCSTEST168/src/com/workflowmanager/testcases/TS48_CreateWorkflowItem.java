package com.workflowmanager.testcases;

import java.util.List;

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

public class TS48_CreateWorkflowItem extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	private static final String SIGNINSUBMIT_XPATH  = "//button[@id='signIn']";
	private static final String CREATE_WORKFLOW_ITEM_XPATH = "//calcite-button[contains(@class,'t-createWorkflowItemBtn')]";
	private static final String PROMPT_USER_DIALOG_XPATH = "//div[contains(@class,'p-dialog p-component')]";
	private static final String WORKFLOW_NAME_INPUT_XPATH = "//input[contains(@class,'p-inputtext')]";
	private static final String NAME_INPUT_ERROR_XPATH = "//calcite-icon[contains(@class,'icon-error')]";
	private static final String CANCEL_BTN_XPATH = "//button[contains(@class,'cancelBtn')]";
	private static final String OK_BTN_XPATH = "//button[contains(@class,'saveBtn')]";
	private static final String PROGRESS_BAR_XPATH = "//wmx-loader";
	private static final String PORTAL_CONTENT_XPATH = "(//div[@class='esri-header-menus-menu']/ul/li[6]/a)[2]";
	private static final String LAYERLIST_XPATH = "//div[@role='rowgroup']/div";
	private static final String SELECT_ALL_CHECKBOX_XPATH = "//label[@class='table-select-cell-sort table-select-check-all']/input";
	private static final String SHARE_BTN_XPATH = "//button[contains(@class,'btn-link btn-link-black margin-left-0 margin-right-1 font-size--2 js-share-items js-share')]";
	private static final String ORGANISATION_RADIO_BTN_XPATH = "//label[@id='share-level-org']/input";
	private static final String SHARE_SAVE_BTN_XPATH = "//button[@id='share-modal-primary']";
	private static final String PORTAL_ACCOUNT_CONTROL_BTN_XPATH = "//button[@id='esri-header-account-control']";
	private static final String PORTAL_SIGNOUT_BTN_XPATH = "//div[@id='esri-header-account-menu']/ul[2]/li[2]";
	private static final String PORTAL_CONTENT_FIRSTLAYER_XPATH = "((//div[@role='rowgroup']/div)[2]//span/span/span)[1]";
	private static final String PORTAL_LAYER_SETTING_XPATH = "//a[@data-tab='settings']";
	private static final String PORTAL_SIGNIN_BTN_XPATH = "//button[contains(@class,'signin')]";
	private static final String PORTAL_LAYER_DELETE_PROTECTION_CHKBOX_XPATH = "//input[@class='delete-prevention-checkbox']";
	private static final String WORKFLOW_AUTHOR_NAME_XPATH = "//div[@class='c-workflowItemCard__contentSection']/div[3]/div[2]";
	private static final String WORKFLOW_PREVILLAGE_ERROR_XPATH = "//div[@class='c-sectionError']";
	final String USERNAME_XPATH = "//input[@id='user_username']";
	final String PASSWORD_XPATH = "//input[@id='user_password']";
	//final String SIGNINSUBMIT_XPATH  = "//button[@id='signIn']";
	
	public void workflow_TS48_CreateWorkflowItem() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		String portalURL="https://mcstest62.esri.com/portal/";
		String appURL="https://mcstest62.esri.com/portal/apps/workflowmanager/";
		// Click on Create Workflow button
		msg = "Click on Create Workflow button";
		try {
			//cfunction.Commmon_Click("xpath", CREATE_WORKFLOW_ITEM_XPATH);
			cfunction.CommmonJS_Click(CREATE_WORKFLOW_ITEM_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Prompt user to enter the name of the workflow item to be created.
		msg = "Prompt user to enter the name of the workflow item to be Visible.";
		try {
			List<WebElement> items = driver.findElements(By.xpath(PROMPT_USER_DIALOG_XPATH));

			if (items != null) {
				CommonFunction.logStatus("PASS", msg);
			} else {

				CommonFunction.logStatus("FAIL", msg,3181);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Enter name as "workflow"
		msg = "Enter name as \"workflow\"";
		try {
			cfunction.CommonTextBox_Input(WORKFLOW_NAME_INPUT_XPATH, "workflow");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// It indicates duplicate
		msg = "Verify it indicates duplicate";
		try {
			List<WebElement> items = driver.findElements(By.xpath(NAME_INPUT_ERROR_XPATH));

			if (items != null) {
				CommonFunction.logStatus("PASS", msg);
			} else {

				CommonFunction.logStatus("FAIL", msg,3181);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Enter a new name "newworkflow"
		msg = "Enter name as \"newworkflow\"";
		try {
			cfunction.CommonTextBox_Input(WORKFLOW_NAME_INPUT_XPATH, "newworkflow");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Click Cancel
		msg = "Click Cancel";
		try {
			cfunction.Commmon_Click("xpath", CANCEL_BTN_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Click on Create Workflow button
		msg = "Click on Create Workflow button";
		try {
			cfunction.Commmon_Click("xpath", CREATE_WORKFLOW_ITEM_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Prompt user to enter the name of the workflow item to be created.
		msg = "Prompt user to enter the name of the workflow item to be Visible.";
		try {
			List<WebElement> items = driver.findElements(By.xpath(PROMPT_USER_DIALOG_XPATH));

			if (items != null) {
				CommonFunction.logStatus("PASS", msg);
			} else {

				CommonFunction.logStatus("FAIL", msg,3181);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Enter name as "workflow"
		msg = "Enter name as \"workflow\"";
		try {
			cfunction.CommonTextBox_Input(WORKFLOW_NAME_INPUT_XPATH, "workflow");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// It indicates duplicate
		msg = "Verify It indicates duplicate name";
		try {
			List<WebElement> items = driver.findElements(By.xpath(NAME_INPUT_ERROR_XPATH));

			if (items != null) {
				CommonFunction.logStatus("PASS", msg);
			} else {

				CommonFunction.logStatus("FAIL", msg,3181);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Enter a new name "newworkflow"
		msg = "Enter name as \"newworkflow\"";
		try {
			cfunction.CommonTextBox_Input(WORKFLOW_NAME_INPUT_XPATH, "newworkflow");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// click OK
		msg = "Click OK";
		try {
			cfunction.Commmon_Click("xpath", OK_BTN_XPATH);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// A progress bar is indicating that the workflow item is being created.
		msg = "A progress bar is indicating that the workflow item is being created.";
		try {
			List<WebElement> items = driver.findElements(By.xpath(PROGRESS_BAR_XPATH));

			if (items != null) {
				CommonFunction.logStatus("PASS", msg);
			} else {

				CommonFunction.logStatus("FAIL", msg,3181);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(90);
		
		//  Once the workflow item has been created, the web app is directed to the newly created workflow web app's coordinate page.
		msg = "Once the workflow item has been created, the web app is directed to the newly created workflow web app's coordinate page.";
		try {
			CommonFunction.waitforHomePagetoload();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Log out from the web app.
		msg="Log out of the web app";
		
		try {
			HomePage.clickOnLogOut();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		// Accessing https://mcstest62.esri.com/portal/apps/workflowmanager
		// Prompt user to log in
		// Log in as nmishra
		msg="Log in as nmishra";
		
		try {
			//driver. get(appURL);
			cfunction.openNewTabsWithURL(appURL);
			cfunction.sync(2);
			LoginPage  lp = new LoginPage();
			lp.loginToApplication1(xls.getCellData("en-us",2, 13), xls.getCellData("en-us", 3,12));	
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(10);
				
		
		// The web app displays the workflow items available for wmxuser. There should
		// be only one workflow item named "workflow". The Create Workflow button is
		// enabled.
		// Click on Create Workflow button
				msg = "Click on Create Workflow button";
				try {
					cfunction.Commmon_Click("xpath", CREATE_WORKFLOW_ITEM_XPATH);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Prompt user to enter the name of the workflow item to be created.
				msg = "Prompt user to enter the name of the workflow item to be Visible.";
				try {
					List<WebElement> items = driver.findElements(By.xpath(PROMPT_USER_DIALOG_XPATH));

					if (items != null) {
						CommonFunction.logStatus("PASS", msg);
					} else {

						CommonFunction.logStatus("FAIL", msg,3181);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Enter name as "workflow"
				msg = "Enter name as \"workflow\"";
				try {
					cfunction.CommonTextBox_Input(WORKFLOW_NAME_INPUT_XPATH, "workflow");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				
				// It indicates duplicate
				
				msg = "Verify it indicates duplicate";
				try {
					List<WebElement> items = driver.findElements(By.xpath(NAME_INPUT_ERROR_XPATH));

					if (items != null) {
						CommonFunction.logStatus("PASS", msg);
					} else {

						CommonFunction.logStatus("FAIL", msg,3181);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Enter a new name "newworkflow"
				msg = "Enter name as \"newworkflow\"";
				try {
					cfunction.CommonTextBox_Input(WORKFLOW_NAME_INPUT_XPATH, "newworkflow");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Click Cancel
				msg = "Click Cancel";
				try {
					cfunction.Commmon_Click("xpath", CANCEL_BTN_XPATH);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Click on Create Workflow button
				msg = "Click on Create Workflow button";
				try {
					cfunction.Commmon_Click("xpath", CREATE_WORKFLOW_ITEM_XPATH);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Prompt user to enter the name of the workflow item to be created.
				msg = "Prompt user to enter the name of the workflow item to be Visible.";
				try {
					List<WebElement> items = driver.findElements(By.xpath(PROMPT_USER_DIALOG_XPATH));

					if (items != null) {
						CommonFunction.logStatus("PASS", msg);
					} else {

						CommonFunction.logStatus("FAIL", msg,3181);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Enter name as "workflow"
				msg = "Enter name as \"workflow\"";
				try {
					cfunction.CommonTextBox_Input(WORKFLOW_NAME_INPUT_XPATH, "workflow");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// It indicates duplicate
				msg = "Verify It indicates duplicate name";
				try {
					List<WebElement> items = driver.findElements(By.xpath(NAME_INPUT_ERROR_XPATH));

					if (items != null) {
						CommonFunction.logStatus("PASS", msg);
					} else {

						CommonFunction.logStatus("FAIL", msg,3181);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Enter a new name "newworkflow"
				msg = "Enter name as \"newworkflow\"";
				try {
					cfunction.CommonTextBox_Input(WORKFLOW_NAME_INPUT_XPATH, "newworkflow");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// click OK
				msg = "Click OK";
				try {
					cfunction.Commmon_Click("xpath", OK_BTN_XPATH);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// A progress bar is indicating that the workflow item is being created.
				msg = "A progress bar is indicating that the workflow item is being created.";
				try {
					List<WebElement> items = driver.findElements(By.xpath(PROGRESS_BAR_XPATH));

					if (items != null) {
						CommonFunction.logStatus("PASS", msg);
					} else {

						CommonFunction.logStatus("FAIL", msg,3181);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(90);
				
				//  Once the workflow item has been created, the web app is directed to the newly created workflow web app's coordinate page.
				msg = "Once the workflow item has been created, the web app is directed to the newly created workflow web app's coordinate page.";
				try {
					CommonFunction.waitforHomePagetoload();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Log into https://mcstest62.esri.com/portal as nmishra then go to Content
				msg = "Log into https://mcstest62.esri.com/portal as nmishra then go to Content";
				try {
					cfunction.openNewTabsWithURL(portalURL);
					//driver. get(portalURL);
					//CommonFunction.openNewTabsWithURL("https://mcstest62.esri.com/portal");
					cfunction.sync(15);
					cfunction.Commmon_Click("xpath", PORTAL_CONTENT_XPATH);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// There are 3 items created by create workflow item process: workflow item with
		// name provided, location feature layer and workflow data model. 
				msg = "There are 3 items created by create workflow item process: workflow item with name provided, location feature layer and workflow data model.";
				try {
					List<WebElement> items = driver.findElements(By.xpath(LAYERLIST_XPATH));

					if (items != null) {
						CommonFunction.logStatus("PASS", msg);
					} else {

						CommonFunction.logStatus("FAIL", msg,3181);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Share each of 3 items within organinzation.
				msg = "Click on Title checkbox to select all layers.";
				try {
					cfunction.Commmon_Click("xpath",SELECT_ALL_CHECKBOX_XPATH );
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				msg = "Click on share button.";
				try {
					cfunction.Commmon_Click("xpath",SHARE_BTN_XPATH );
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				msg = "Click on Organization button.";
				try {
					cfunction.Commmon_Click("xpath",ORGANISATION_RADIO_BTN_XPATH );
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				msg = "Click on save button.";
				try {
				cfunction.Commmon_Click("xpath",SHARE_SAVE_BTN_XPATH );
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Log out from portal.
				msg = "Log out from portal.";
				try {
				cfunction.Commmon_Click("xpath",PORTAL_ACCOUNT_CONTROL_BTN_XPATH );
				cfunction.sync(2);
				cfunction.Commmon_Click("xpath",PORTAL_SIGNOUT_BTN_XPATH );
				
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(5);
		// Log in https://mcstest62.esri.com/portal as wmxuser
				msg = "Log in https://mcstest62.esri.com/portal as wmxuser";
				try {
				cfunction.Commmon_Click("xpath",PORTAL_SIGNIN_BTN_XPATH );
				cfunction.sync(5);
				cfunction.sync(2);
				msg = "Enter Username";
				try {
					cfunction.CommonTextBox_Input(USERNAME_XPATH, "wmxuser");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				msg = "Enter Password"; 
				try {
					cfunction.CommonTextBox_Input(PASSWORD_XPATH, "JobTracking102");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				msg = "Click on Sign In";
				try {
					cfunction.Commmon_Click("xpath",SIGNINSUBMIT_XPATH);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				System.out.println("Logged in as "+ "wmxuser");
				cfunction.sync(2);
				cfunction.Commmon_Click("xpath", PORTAL_CONTENT_XPATH);
				LoginPage  lp = new LoginPage();
					//lp.loginToApplication1(xls.getCellData("en-us",2, 12), xls.getCellData("en-us", 3,12));	
					//cfunction.Commmon_Click("xpath",SIGNINSUBMIT_XPATH);
					cfunction.sync(15);
					cfunction.Commmon_Click("xpath", PORTAL_CONTENT_XPATH);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(5);
		// The newly created two workflow items are available.
				msg = "The newly created two workflow items are available.";
				try {
					List<WebElement> items = driver.findElements(By.xpath(LAYERLIST_XPATH));

					if (items != null) {
						CommonFunction.logStatus("PASS", msg);
					} else {

						CommonFunction.logStatus("FAIL", msg,3181);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Click on one of the newly created workflow items
				msg = "Click on one of the newly created workflow items";
				try {
				cfunction.Commmon_Click("xpath",PORTAL_CONTENT_FIRSTLAYER_XPATH );
				
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(5);
		// Click on the Settings tab
				msg = "Click on one of the newly created workflow items";
				try {
				cfunction.Commmon_Click("xpath",PORTAL_LAYER_SETTING_XPATH );
				
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Under 'Delete Protection', the Prevent this item from being accidentally deleted box should be checked
				msg = "Under 'Delete Protection', the Prevent this item from being accidentally deleted box should be checked";
				try {
					List<WebElement> items = driver.findElements(By.xpath(PORTAL_LAYER_DELETE_PROTECTION_CHKBOX_XPATH));

					if (items != null) {
						CommonFunction.logStatus("PASS", msg);
					} else {

						CommonFunction.logStatus("FAIL", msg,3181);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);	
				// Log out from portal.
				msg = "Log out from portal.";
				try {
				cfunction.Commmon_Click("xpath",PORTAL_ACCOUNT_CONTROL_BTN_XPATH );
				cfunction.sync(2);
				cfunction.Commmon_Click("xpath",PORTAL_SIGNOUT_BTN_XPATH );
				
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(5);
		// Log in https://mcstest62.esri.com/portal/apps/workflowmanager as nmishra
				msg = "Log in https://mcstest62.esri.com/portal/apps/workflowmanager as nmishra";
				try {
					//driver. get(appURL);
					cfunction.openNewTabsWithURL(appURL);
					//CommonFunction.openNewTabsWithURL("https://mcstest62.esri.com/portal/apps/workflowmanager");
					LoginPage  lp = new LoginPage();
					lp.loginToApplication1(xls.getCellData("en-us",2, 13), xls.getCellData("en-us", 3,12));	
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(10);
		// The workflow item created by wmxuser isn't available since it is not shared with nmishra.
				msg="The workflow item created by wmxuser isn't available since it is not shared with nmishra.";
				try {
					boolean check = Design.verifyWorkflowAuthorName("WMX User");
					if (check) {
						CommonFunction.logStatus("FAIL", msg,3181);
					}

					else {
						CommonFunction.logStatus("PASS", msg);
					}
					}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				
		// Log out from the web app workflows page.
				msg="Log out of the web app";
				
				try {
					HomePage.clickOnLogOut();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Accessing https://mcstest62.esri.com/portal/apps/workflowmanager
		// Log in as testuser, password is JobTracking102.
				msg = "Log in https://mcstest62.esri.com/portal/apps/workflowmanager as testuser";
				try {
					//driver. get(appURL);
					cfunction.openNewTabsWithURL(appURL);
					LoginPage  lp = new LoginPage();
					lp.loginToApplication1(xls.getCellData("en-us",2, 14), xls.getCellData("en-us", 3,12));	
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// The web app displays the workflows page. There should be only one workflow item created by nmishra avalable. The Create Workflow button is not available.
				msg="There should be only one workflow item created by nmishra available";
				try {
					boolean check = Design.verifyWorkflowAuthorName("Nishi Mishra");
					if (check) {
						CommonFunction.logStatus("PASS", msg);
					}

					else {
						CommonFunction.logStatus("FAIL", msg,3181);
					}
					}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				// Open the workflow item.
				msg = "Open the workflow item.";
				try {
				
				//	cfunction.hoverByAction("(//div[@class='c-workflowItemCard__thumbnailSection'])[2]");
					cfunction.hoverByAction("//div[@class='c-workflowItemCard__thumbnailBtns']");
				//	cfunction.Commmon_Click("xpath", "(//div[@class='c-workflowItemCard__thumbnailBtns'])[2]");
					cfunction.Commmon_Click("xpath", "//div[@class='c-workflowItemCard__thumbnailBtns']");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					//CommonFunction.logStatus("FAIL", msg,3181);
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		// The web app display error that the current user is missing privileges to access.
				msg="The web app display error that the current user is missing privileges to access.";
				try {
					String text= "Current user does not have privileges to view any application pages. Please contact your Workflow Manager Administrator.";
					List<WebElement> rows = driver.findElements(By.xpath(WORKFLOW_PREVILLAGE_ERROR_XPATH));
				for (WebElement item : rows) {
					String rowsItem = item.getText();
					System.out.println(rowsItem + "  --  ");
					if (rowsItem.contains(text)) {
						CommonFunction.logStatus("PASS", msg);
						System.out.println("wmxuser is visible");
						break;
					} else {
						CommonFunction.logStatus("FAIL", msg,3181);
						System.out.println("wmxuser is not visible");
					}
				}}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Log out from the web app.
				msg="Log out of the web app";
				
				try {
					cfunction.openNewTabsWithURL(appURL);
					//driver. get(appURL);
					HomePage.clickOnLogOut();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Log in as wmxuser
				msg = "Log in https://mcstest62.esri.com/portal/apps/workflowmanager as wmxuser";
				try {
				
					LoginPage  lp = new LoginPage();
					lp.loginToApplication1(xls.getCellData("en-us",2, 12), xls.getCellData("en-us", 3,12));	
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// newworkflow should be visible
				msg="There should be only one workflow item created by wmxuser available";
				try {
					boolean check = Design.verifyWorkflowAuthorName("WMX User");
					if (check) {
						CommonFunction.logStatus("PASS", msg);
					}

					else {
						CommonFunction.logStatus("FAIL", msg,3181);
					}
					}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(5);
		// Hover over the Workflow item and click the Delete Workflow button
				msg = "Hover over the Workflow item and Click the Delete Workflow button";
				try {
					List<WebElement> rows = driver.findElements(By.xpath("//div[@class='c-workflowItemCard__contentValue t-workflowItemOwnerName ng-star-inserted']"));
				for( int i = 0; i<rows.size(); i++){
					String author = rows.get(i).getText();
					if(author.equalsIgnoreCase("WMX User")) {
						cfunction.hoverByAction("(//div[@class='c-workflowItemCard__thumbnailSection'])["+(i+1)+"]");
						cfunction.sync(2);
						
						CommonFunction.logStatus("PASS", msg);
						break;
					}
				}}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				
				/*if (browser.equalsIgnoreCase("firefox")) {
						try {
							cfunction.hoverByAction("//div[@class='c-workflowItemCard__contentValue t-workflowItemOwnerName ng-star-inserted']");
						//cfunction.sync(2);
						//cfunction.Commmon_Click("xpath", "(//button[@class='btn btn-transparent t-deleteItemBtn ng-star-inserted'])");
						CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg,3181);
						}
					} else {
						try {
						cfunction.hoverByAction("//div[@class='c-workflowItemCard__contentValue t-workflowItemOwnerName ng-star-inserted']");
				//	cfunction.sync(2);
				//	cfunction.Commmon_Click("xpath", "(//button[@class='btn btn-transparent t-deleteItemBtn ng-star-inserted'])");
					CommonFunction.logStatus("PASS", msg);
						}catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg,3181);
						}
					
				} 
				CommonFunction.logStatus("FAIL", msg);
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}*/
				cfunction.sync(2);
				
/*				
				msg = "Click the Delete Workflow button";
				try {
					if (browser.equalsIgnoreCase("firefox")) {
						//cfunction.hoverByAction("(//div[@class='c-workflowItemCard__thumbnailSection'])[2]");
					//	cfunction.sync(2);
					//	cfunction.Commmon_Click("xpath", "(//calcite-button[@class='t-deleteItemBtn ng-star-inserted'])[2]");
						cfunction.CommmonJS_Click("(//div[@class='c-workflowItemCard__thumbnailBtns--topRightCorner'])[2]/calcite-button");
						CommonFunction.logStatus("PASS", msg);
					} else
				//		cfunction.hoverByAction("(//div[@class='c-workflowItemCard__thumbnailSection'])[3]");
				//	cfunction.sync(2);
						cfunction.Commmon_Click("xpath", "(//calcite-button[@class='t-deleteItemBtn ng-star-inserted'])");
					CommonFunction.logStatus("PASS", msg);
				
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				
				*/
				msg = "Click the Delete Workflow button";
				try {
					if (browser.equalsIgnoreCase("firefox")) {
				//cfunction.CommmonJS_Click("(//div[@class='c-workflowItemCard__thumbnailBtns--topRightCorner'])[2]/calcite-button");
						CommonFunction.logStatus("PASS", msg);
					} else
						cfunction.hoverByAction("(//div[@class='c-workflowItemCard__thumbnailSection'])[2]");
				
						cfunction.Commmon_Click("xpath", "(//calcite-button[contains(@class,'t-deleteItemBtn ng-star-inserted')])");
					CommonFunction.logStatus("PASS", msg);
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
				
				
				//Check the confirm checkbox and click on delete button
				msg = "Check the confirm checkbox and click on delete button";
				try {
				
					cfunction.Commmon_Click("xpath","//div[@class='p-checkbox-box']");
					cfunction.sync(2);
					cfunction.Commmon_Click("xpath", "//button[@class='p-button t-comfirmDeleteBtn']");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(30);
		// "A loading progressor should appear.Once done, it should indicate the item was deleted successfully"
		// Log out from the web app.
                msg="Log out of the web app";
				
				try {
					HomePage.clickOnLogOut();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(2);
		// Log in as nmishra
				msg = "Log in https://mcstest62.esri.com/portal/apps/workflowmanager as nmishra";
				try {
				
					LoginPage  lp = new LoginPage();
					lp.loginToApplication1(xls.getCellData("en-us",2, 13), xls.getCellData("en-us", 3,12));	
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(5);
		// newworkflow should be visible
				msg = "Hover over the Workflow item and Click the Delete Workflow button";
				try {
					List<WebElement> rows = driver.findElements(By.xpath("//div[@class='c-workflowItemCard__contentValue t-workflowItemOwnerName ng-star-inserted']"));
				for( int i = 0; i<rows.size(); i++){
					String author = rows.get(i).getText();
					if(author.equalsIgnoreCase("Nishi Mishra")) {
						cfunction.hoverByAction("(//div[@class='c-workflowItemCard__thumbnailSection'])["+(i+1)+"]");
						cfunction.sync(2);
						cfunction.Commmon_Click("xpath", "(//calcite-button[contains(@class,'t-deleteItemBtn ng-star-inserted')])");
						//cfunction.Commmon_Click("xpath", "(//calcite-button[@class='t-deleteItemBtn ng-star-inserted'])");
						CommonFunction.logStatus("PASS", msg);
						break;
					}
				}}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//Check the confirm checkbox and click on delete button
				msg = "Check the confirm checkbox and click on delete button";
				try {
				
					cfunction.Commmon_Click("xpath","//div[@class='p-checkbox-box']");
					cfunction.sync(2);
					cfunction.Commmon_Click("xpath", "//button[@class='p-button t-comfirmDeleteBtn']");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg,3181);
				}
				cfunction.sync(30);
				// Log out from the web app.
		// Navigate to the portal content page while signed in as the admin user
		// Verify that the newworkflow items have been deleted

	}
}
