package com.workflowmanager.testcases;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS67_Add_Attachment_step_Linked  extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS67_Add_Attachment_step_Linked() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
	
		msg = "Click on 'Work' Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		//Click on the create job panel and click on the ' Attachment_Selenium' job template
				//A new custom search is opened up with the new job
		msg = "Click the 'Create' button";
		try {
			WorkPage.clickCreateBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter 'Attachment_Selenium' in Search Textbox";
		try {
			Coordinate.enterSearchText("Attachment_Selenium");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The job template is returned.
		msg = "Verify 'Attachment_Selenium' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent("Attachment_Selenium"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on the "Attachment_Selenium" job template to create a new job.
		msg = "Click the 'Attachment_Selenium' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Attachment_Selenium");
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
		// Verify New Job created successfully
				msg = "Verify New Job created successfully";
				try {

					if(Coordinate.verifySuccessMsg("successful"))
					CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		
		//Run the first step 'Embedded_only'
				msg = "Run \"Embedded_only\" step for the job";
				try {
					if(WorkPage.clickOnStartStepOfJob(jobName)) {
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
		//The Job card expands to show +Browse button
		//Click the browse button to add an attachment 
				msg = "Click Browse and navigate to the \"This_is_a_text.txt\" testing attachment file.";
				try {
					WorkPage.selectFileToUpload("This_is_a_text.txt");
					//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Add the attached text file 'This_is_a_text.txt'
		//Confirm that the tool tips for download and delete buttons appear correctly and that you can update the alias for the attachment 
				msg = "Verify tool tip for Delete button";
				try {
					WorkPage.hoverDeleteUploadedFile("2");
					Design.verifyToolTipTextPresent("Delete attachment");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify tool tip for Download button";
				try {
					WorkPage.hoverDeleteUploadedFile("1");
					Design.verifyToolTipTextPresent("Download Attachment");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify Alias textbox is editable";
				try {
					WorkPage.renameUploadedFile("This_is_a_text_1.txt");
					
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//Tool tip for Download : Download attachment, Delete: Delete attachment and Alias textbox is editable
		//Click Proceed 
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//Current step is now, Linked_url_general and Linked_url_new
				msg = "Verify the job's current step is 'End'";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName, "Linked_url_general")) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Run Linked_url_general
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Job Card expands, you should see the attachment from step 1 already there. The alias should not be editable and download and delete attachments should be available
		//Click on the Link button
				msg = "Click on the Link button";
				try {
					WorkPage.clickOnLinkBtn();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A new dialog to enter url is displayed
		//Type ' Test' for URL
				msg = "Enter 'Test' as url input";
				try {
					WorkPage.enterURL_Input("Test");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A red exclamation mark should appear indicating the url is invalid
				msg = "Verify Error icon visible";
				try {

					if(WorkPage.verifyErrorIconVisible1())
					CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
				
		//Enter http://esri.com for Url and Alias as This is a URL. Click Save
				msg = "Enter 'Test' as url input";
				try {
					WorkPage.enterURL_Input_After_Error("http://esri.com");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter 'This is a URL' as Name input";
				try {
					WorkPage.enterName_Input("This is a URL");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on Save button";
				try {
					WorkPage.clickOnSaveBtn();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The new attachment is added to the list with icons View attachment and Delete attachment. The alias for this attachment should be editable 
		//Click Proceed 
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//Current steps are Linked_File_path_General and Linked_url_New
				msg = "Verify the job's current step is 'Linked_File_path_General'";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName,"Linked_File_path_General")) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Select Step from Dropdown";
				try {
					WorkPage.selectStepFromDrpdwn("Linked_url_New");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Run Linked_url_new
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//Job Card expands, you should not see any of the previous attachments Only the Link button should be available
		//Click Proceed 
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//Current steps are Linked_File_path_General and Linked_File_Path_new
				msg = "Verify the job's current step is 'Linked_File_Path_new'";
				try {
					if(WorkPage.verifyCurrentStepOfJob(jobName,"Linked_File_Path_new")) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Run Linked_File_Path_new
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Job Card expands with link button and no existing attachments
		//Click on the Link button
				msg = "Click on the Link button";
				try {
					WorkPage.clickOnLinkBtn();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Dialog opens up
		//Type 'C:/test' for file path and File_path for alias. Hit Save
				msg = "Enter 'C:/test' as url input";
				try {
					WorkPage.enterURL_Input("C:/test");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter 'File_path' as Name input";
				try {
					WorkPage.enterName_Input("File_path");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on Save button";
				try {
					WorkPage.clickOnSaveBtn();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Attachment gets added to the job Card with Copy File path button and Delete button to the right
		//Click on the Copy file Path
				cfunction.sync(2);
				msg = "Click on the Copy file Path";
				try {
					WorkPage.clickCopyUploadedFile();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
			//	cfunction.sync(2);
		//A notifcaiton that File Path : C:/test has been copied to clipboard is displayed
				msg = "Verify A notifcaiton that File Path : C:/test has been copied to clipboard is displayed";
				try {

					if(Coordinate.verifySuccessMsg("Successfully copied to clipboard: C:/test"))
					CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//Click Proceed 
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//Current step is now, Linked_File_path_general and Linked_text_new
		//Dismiss the notification on the top right by clicking the X button
		//Run step Linked_File_path_general
				msg = "Select Step from Dropdown";
				try {
					WorkPage.selectStepFromDrpdwn("Linked_File_Path_General");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Job Card expands with attachments from step 2 and step 3
		//Click on  the view attachment button for 'This is a url' 
				msg = "Click on  the view attachment button for 'This is a url'";
				try {
					cfunction.sync(7);
					WorkPage.clickOnViewAttachmentbtn(4);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A new tab is opened in the browser that navigates to http://esri.com
				msg = "A new tab is opened in the browser that navigates to 'http://esri.com'";
				try {
					/*((JavascriptExecutor)driver).executeScript("window.open()");*/
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					//driver.get(url);
					String expectedURL="https://www.esri.com/en-us/home";
					String currentURL = driver.getCurrentUrl();
					System.out.println(currentURL);
					System.out.println(expectedURL);
					if(currentURL.contains(expectedURL)) {
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
				msg = "Close the current tab";
				try {
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					driver.close();
					driver.switchTo().window(tabs.get(0));
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Click Proceed 
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//Current step is now Linked_text_new and Linked_text
		//Run Linked_text_new
				msg = "Select Step from Dropdown";
				try {
					WorkPage.selectStepFromDrpdwn("Linked_Text_New");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The Job card expands to show +Link button and file_path attachment
		//Click on the Link button
				msg = "Click on the Link button";
				try {
					WorkPage.clickOnLinkBtn();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A new Dialog is diaplayed
		//Add ' Document-27' for attachment text and text for alias
				msg = "Enter 'Document-27' as attachment text";
				try {
					WorkPage.enterURL_Input("Document-27");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter 'text' as Name input";
				try {
					WorkPage.enterName_Input("text");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on Save button";
				try {
					WorkPage.clickOnSaveBtn();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The attachment is added to the liast with alias editable, Copy File Path and delet buttons
		//Click Proceed 
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//Current step is Linked_text
		//Click Run and Proceed
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//Current step is Embedded only_restrict
		//Click Run
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Job Card expands to show existing attachments
		//Click +Browse button 
				msg = "Click Browse and navigate to the \"This_is_a_text.txt\" testing attachment file.";
				try {
					WorkPage.selectFileToUpload("This_is_a_text.txt");
					//WorkPage.selectFileToUpload("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\AOIEdits.zip");
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Confirm only JPEG are allow to be attached to the step
		//Click Proceed 
				msg = "Click on Proceed button";
				try {
					WorkPage.clickOnProceedBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//Current step is Embedded _linked_url
		//Run the step
				msg = "Run \"Start/End\" step for the job";
				try {
					WorkPage.clickOnStartBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Both Browse and Link buttons should be available
		//Click Pause
				msg = "Click \"Pause\" in the step dialog.";
				try {
					WorkPage.clickOnPauseBtn();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Job card should go back to original size
				
			//***********************Update job template*************************
				
				//Click on Design tab
				msg = "Click on Design Tab";
				try {
					HomePage.clickOnDesign();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}	
				cfunction.sync(2);
				//"Design View Opens Diagram panel is selected and populated with results"
				//Click on job Templates Icon 
				msg = "Click on Job Templates";
				try {
					Design.clickOnJobTemplatesIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Job templates panel is selected and populated with results
				msg ="Job Template list populated with results";
				try {
					Design.getAllJobsTemplateList();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Search for ' path arcade test'
				msg = "Search for '"+DiagramName+"'";
				try {
					Design.clickTemplateFromeList(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg ="Click on"+ DiagramName;
				try {
					Design.clickTemplateFromeList(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Update job priority for Path arcade test to High
				msg = "Set the Job Priority to 'High'";
				try {
					Design.openDropDownMenuOfPriority();
					Design.selecPriority("High");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click 'save' button";
				try {
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				

				//************************Create New***************************
				
				
				
				//Go to Work page
				msg = "Click on 'Work' Tab";
				
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*msg = "Click Yes button of confirmation to create job tamplate";
				try {
					Design.clickYesOnConfirmDialog();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
				//Under create job panel search ' Path arcade test' 
				msg = "Click the 'Create' button";
				try {
					WorkPage.clickCreateBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter '"+DiagramName+"' in Search Textbox";
				try {
					Coordinate.enterSearchText(DiagramName);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Path arcade job template is displayed
				msg = "Verify '"+DiagramName+"' is displayed in the list";
				try {
					if (Coordinate.verifyJobIsPresent(DiagramName))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Create new job for Path arcade test
				msg = "Click the 'Path arcade test' job template";
				try {

					boolean check = Coordinate.clickCreateDefaultOfTemplatePresent(DiagramName);
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
				// Verify New Job created successfully
						msg = "Verify New Job created successfully";
						try {

							if(Coordinate.verifySuccessMsg("successful"))
							CommonFunction.logStatus("PASS", msg);
							else
								CommonFunction.logStatus("FAIL", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(5);
				//A new custom query is created with Path arcade test template
				//Run step 'Start/End'
						/*msg = "Run \"Start/End\" step for the job";
						try {
							WorkPage.clickOnStartBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);*/
						//Current step is 'Manual Step 1'
						msg = "Verify the job's current step is 'Manual Step 1'";
						try {
							if(WorkPage.verifyStep( "Manual Step 1")) {
								CommonFunction.logStatus("PASS", msg);
							}
							else {
								CommonFunction.logStatus("FAIL", msg);
							}
						}catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Click on Proceed button";
						try {
							WorkPage.clickOnProceedBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(10);
				
				//Run step Manual step 1
						/*msg = "Run \"Start/End\" step for the job";
						try {
							WorkPage.clickOnStartBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);*/
						//Current step is now High
						msg = "Verify the job's current step is 'High'";
						try {
							if(WorkPage.verifyStep("High")) {
								CommonFunction.logStatus("PASS", msg);
							}
							else {
								CommonFunction.logStatus("FAIL", msg);
							}
						}catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Click on Proceed button";
						try {
							WorkPage.clickOnProceedBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(10);
				
	}
}
