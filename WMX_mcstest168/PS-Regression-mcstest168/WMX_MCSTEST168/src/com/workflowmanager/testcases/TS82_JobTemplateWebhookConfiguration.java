package com.workflowmanager.testcases;

import org.openqa.selenium.By;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS82_JobTemplateWebhookConfiguration extends TestBase {
	
	CommonFunction cfunction = new CommonFunction();
	String jobTemplateName = cfunction.getUniqueName(xls.getCellData("en-us", 2,17));

	String msg = "";
	
	public void workflow_TS82_JobTemplateWebhookConfiguration() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		
		//Click on Design Page
		msg = "Click on Design Tab";
		try {
				HomePage.clickOnDesign();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		
		
		// Click on Job Templates
		msg = "Click on Job Templates";
		try {
				cfunction.waitforpagetoload();
				cfunction.sync(30);
				Design.clickOnJobTemplatesIcon();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		
		//Click on 'Create New'
		msg = "Click on 'Create New'";
		try {
				Design.clickOnCreateNewBtn();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		//Verify STATE field is populated by 'Active'
		msg="Verify STATE field is populated by 'Active'";
		try {
			String value =Design.activeState_NewTemplate();
			if(value.contains("Active")) {
				CommonFunction.logStatus("PASS", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		
		//Enter Job Template name 'Some Job Template'
		//String jobTemplateName = xls.getCellData("en-us", 2,3);
		msg = "Enter Job Template name '"+ jobTemplateName +"'";
		try {
			cfunction.waitforpagetoload();
			Design.enterJobTemplateName(jobTemplateName);
			System.out.println("Test Webhook Job Template Name==>"+jobTemplateName);
			CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		//From 'Current Workflow Diagram' dropdown select 'Open Web App'
				String selectText = "Open Web App";
				msg = "From 'Current Workflow Diagram' dropdown select '"+ selectText + "'";
				try {
					Design.selectCurrentWorkflowDiagram(selectText);
					cfunction.sync(10);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
		
				cfunction.sync(2);
				msg="Switch to Automated Action Tab";
				try {
						Design.clickOnAutomatedAction();
						CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);		
		//Click on 'Add Webhook' Button
		msg="Click on 'Add Webhook' Button";
		try {
			Design.clickAddWebhookButton();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify Create Webhook dialog box is visible
		msg="Verify Create Webhook dialog box is visible";
		try {
			Design.verifyWebhookDialogVisible();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enter Webhook Name
		msg="Enter Webhook Name";
		try {
			Design.enterWebhookField("Webhook",1);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Enter Username and Password in Authorization Tab
		msg="Enter Username and Password in Authorization Tab";
		try {
			Design.enterInArcadeInput("admin", "esri.agp", 1, 2);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		/*msg="Enter fallback Username and Password in Authorization Tab";
		try {
			Design.enterInArcadeInput("admin", "esri.agp", 3, 4);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}*/
		//Enable Header Tag if not, in our case it is, hence no code for that
		//Enter Key and Value in Authorization Tab
		msg="Enter Key and Value in Authorization Tab";
		try {
			Design.enterInArcadeInput("secretkey", "password", 3, 4);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		//Click on 'Payload' Tab
		msg="Click on 'Payload' Tab";
		try {
			Design.clickWebhookSwitchTab(5);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Enable Attach Payload";
		try {
			Design.clickpayload();
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Verify presence of Folder Name and Attachment Name Visible";
		try {
			
			if(Design.verifyPresenceofFields("FOLDER NAME","ATTACHMENT NAME")) {
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
		msg="Enter Folder Name";
		try {
			Design.enterWebhookField("Webhook Attachment",2);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enable Autogenerated Name radio button if not, in our case it is on, hence no code for that
		msg="Click on 'Outputs' Tab";
		try {
			Design.clickWebhookSwitchTab(6);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Click 'Add Output & Path'";
		try {
			Design.clickAddOutputButton();
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		//Enter Key and Value in Authorization Tab
		msg="Enter Output and Extraction in Outputs Tab";
		try {
			Design.enterOutputExtractionInput("output1", "value1", 1, 2);
			CommonFunction.logStatus("PASS", msg);
				
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Enable Testmode and enter Sample Text";
		try {
			String sampleText="{\r\n" + 
					"  \"systemid\": 100,\r\n" + 
					"  \"value1\": \"value1_content\",\r\n" + 
					"  \"value2\": 2,\r\n" + 
					"  \"value3\": true,\r\n" + 
					"  \"value4\": {\r\n" + 
					"              \"firstName\": \"WMX\",\r\n" + 
					"              \"lastName\": \"USER\"\r\n" + 
					"            }\r\n" + 
					"}";
			Design.clickTestMode();
			Design.enterSampleText(sampleText);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Verify Sample Result";
		try {
			
			if(Design.verifySampleResult("[\"value1_content\"]")) {
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
		msg="Click on Save Button";
		try {
			Design.clickWebhookSave();
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Verify new Webhook is created in 'Webhook Job Creation' Section ";
		try {
			
			if(Design.verifyWebhookName()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
				}
			
			} catch(Exception e) {	
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Hover over newly created Webhook";
		try {
			Design.hoverCreatedWebhook();
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Click on Edit";
		try {
			Design.clickWebhookEdit();
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Click on 'Authorization' Tab";
		try {
			Design.clickWebhookSwitchTab(4);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Enable Fallback Username and Password";
		try {
			Design.clickFallbackUserPass(1);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Enter Username and Password in Authorization Tab";
		try {
			Design.enterInArcadeInput("wmxuser", "JobTracking102", 3, 4);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Enable Fallback Username and Password";
		try {
			Design.clickFallbackUserPass(2);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Update Header and Secret Key Value using Arcade Menu";
		try {
			cfunction.sync(10);
			Design.clearInArcadeInput(5, 6);
			Design.updateUsingArcdeSetting(5,6,6);
			Design.enterInArcadeInput("setting('keyname')", "setting('password')", 5, 6);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Click on 'Payload' Tab";
		try {
			Design.clickWebhookSwitchTab(5);
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Click 'Custom Name' Radio Button";
		try {
			Design.clickCustomNameButton();
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}
		cfunction.sync(2);
		msg="Enter Custom Name";
		try {
			cfunction.sync(7);
			Design.enterWebhookField("webhook attachment",3);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Enable Autogenerated Name radio button if not, in our case it is on, hence no code for that
				msg="Click on 'Outputs' Tab";
				try {
					Design.clickWebhookSwitchTab(6);
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click 'Add Output & Path'";
				try {
					Design.clickAddOutputButtonNoPadding();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				
				cfunction.sync(2);
				//Enter Key and Value in Authorization Tab
				msg="Enter Output and Extraction in Outputs Tab";
				try {
					Design.enterOutputExtractionInput("output2", "value2", 3, 4);
					CommonFunction.logStatus("PASS", msg);
						
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click on Save Button";
				try {
					Design.clickWebhookSave();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click on Save Button for Job Template";
				try {
					cfunction.sync(5);
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg = "Verify Success message is displayed.";
				String successMsg = "Job template: "+ jobTemplateName+" created successfully";
				try {
					if(Design.verifySuccessMsg(successMsg))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Design.clickOnAutomatedAction();
				cfunction.sync(2);
				msg="Verify ID and URL are updated";
				try {
					cfunction.sync(5);
					if(Design.verifyIDandURL()) {
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
				//Hover over added Webhook
				msg="Verify Copy URL, Edit and Delete options are available";
				try {
					if(Design.verifyHoverWebhook()) {
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
				msg="Hover over the URL and verify tooltip";
				try {
					cfunction.sync(5);
					cfunction.hoverByAction("//span[contains(@class,'t-webhookUrlLabel')]");
					String textURL= cfunction.getElementText1("//span[contains(@class,'t-webhookUrlLabel')]");
					if(textURL.equals(cfunction.getElementText1("//span[contains(@class,'t-webhookUrlLabel')]/span"))) {
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
				msg="Hover over the Copy URL and verify tooltip";
				try {
					//Design.hoverOverCopyUrl();
					cfunction.hoverByAction("//calcite-button[contains(@icon-start,'copyToClipboard')]");
					//cfunction.CommmonJS_Hover_ShadowPath("document.querySelector('span.col-3.c-itemList__rowCol.t-webhookUrlLabel>calcite-button').shadowRoot.querySelector('button')");
					/*WebElement element = CommonFunction.getWebElement("xpath", "//calcite-button[contains(@icon-start,'copyToClipboard')]" );
					String title = element.getAttribute("ptooltip");
					System.out.println("Copy URL Tooltip is=="+title);*/
					if(SikuliHelp.verifyImageExists("TS82_CopyURL_ToolTip")) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						System.out.println("Unable to locate");
						CommonFunction.logStatus("FAIL", msg);
					}
										
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				
				cfunction.sync(2);
				msg="Click on Copy URL Option";
				try {
					cfunction.sync(5);
					cfunction.Commmon_Click("xpath", "//calcite-button[contains(@icon-start,'copyToClipboard')]");
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg = "Verify Success message is displayed.";
				String textURL= cfunction.getElementText1("//span[contains(@class,'t-webhookUrlLabel')]");
				String successMsg1 = "Successfully copied to clipboard: "+ textURL ;
				try {
					if(Design.verifySuccessMsg21(successMsg1))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg="Click on 'Edit' button";
				try {
					cfunction.sync(5);
					cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class,'t-editDetailsButton')]");
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				//Verify Create Webhook dialog box is visible
				msg="Verify Create Webhook dialog box is visible";
				try {
					Design.verifyWebhookDialogVisible();
					CommonFunction.logStatus("PASS", msg);
				
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg="Disable Fallback Username and Password";
				try {
					Design.clickFallbackUserPass(1);
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Disable Header Secret Key";
				try {
					Design.clickHeaderSecretKey();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				//Click on 'Payload' Tab
				msg="Click on 'Payload' Tab";
				try {
					Design.clickWebhookSwitchTab(5);
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click 'Autogenerated Name' Radio Button";
				try {
					Design.clickCustomNameButton();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				//Click on 'Output' Tab
				msg="Click on 'Output' Tab";
				try {
					Design.clickWebhookSwitchTab(6);
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				//Reorder the outputs
				msg="Reorder the outputs";
				try {
				Design.reorderOuput();
				CommonFunction.logStatus("PASS", msg);
					
				cfunction.sync(2);	
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg="Click on Save Button";
				try {
					Design.clickWebhookSave();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click on Save Button for Job Template";
				try {
					cfunction.sync(5);
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click on 'Edit' button";
				try {
					cfunction.sync(5);
					cfunction.hoverByAction("//calcite-button[contains(@class,'t-editDetailsButton')]");
					cfunction.sync(10);
					cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class,'t-editDetailsButton')]");
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				
				cfunction.sync(2);
				msg="Click on 'Output' Tab";
				try {
					Design.clickWebhookSwitchTab(6);
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Delete one of the outputs";
				try {
					Design.deleteOneOutput(1);
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click on Save Button";
				try {
					Design.clickWebhookSave();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click on another Job template without saving the Current one";
				try {
					Design.selectItemFromList("Data Edits Sample");
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Save unsaved changes";
				try {
					Design.saveChanges();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Open" +jobTemplateName;
				try {
					cfunction.sync(7);
					Design.selectItemFromList(jobTemplateName);
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Switch to Automated Action Tab";
				try {
						cfunction.sync(7);
						Design.clickOnAutomatedAction();
						CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Click on 'Edit' button";
				try {
					cfunction.sync(5);
					cfunction.hoverByAction("//calcite-button[contains(@class,'t-editDetailsButton')]");
					cfunction.sync(5);
					cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class,'t-editDetailsButton')]");
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Verify privious edits are saved properly";
				try {
					Design.verifyWebhookData("Webhook", "(//calcite-input)[1]");
					Design.verifyWebhookData("admin", "(//input[contains(@class,'t-arcadeInput')])[1]");
					Design.verifyWebhookData("esri.agp", "(//input[contains(@class,'t-arcadeInput')])[2]");
					Design.clickWebhookSwitchTab(5);
					Design.verifyWebhookData("Webhook Attachment", "(//calcite-input)[2]");
					Design.clickWebhookSwitchTab(6);
					Design.verifyWebhookData("output1", "(//div[@class='col-12 paramContent']//div//input)[1]");
					Design.verifyWebhookData("value1", "(//div[@class='col-12 paramContent']//div//input)[2]");
					Design.clickWebhookSave();
					CommonFunction.logStatus("PASS", msg);
				} catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg="Edit Webhook name without opening the Dialog Box";
				try {
					
					Design.editWebhookName();
					CommonFunction.logStatus("PASS", msg);
				} catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg="Save button is enabled";
				try {
					Design.verifySaveButtonEnabled();
					CommonFunction.logStatus("PASS", msg);
				} catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg="Click on Save Button for Job Template";
				try {
					cfunction.sync(5);
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				
				cfunction.sync(2);
				msg="Verify Webhook name updated";
				try {
					Design.verifyWebhookData("Webhook Edit", "//input[contains(@class,'t-webhookNameInput')]");
					//Design.clickWebhookSave();
					CommonFunction.logStatus("PASS", msg);
				} catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg="Click on 'Delete' button";
				try {
					cfunction.sync(5);
					cfunction.hoverByAction("//calcite-button[contains(@class,'t-deleteTaskBtn')]");
					cfunction.sync(5);
					cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class,'t-deleteTaskBtn')]");
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Save button is enabled";
				try {
					Design.verifySaveButtonEnabled();
					CommonFunction.logStatus("PASS", msg);
				} catch(Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg="Click on Save Button for Job Template";
				try {
					cfunction.sync(5);
					Design.clickOnSave();
					CommonFunction.logStatus("PASS", msg);
					
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				cfunction.sync(2);
				msg="Verify Webhook is deleted in 'Webhook Job Creation' Section ";
				try {
					
					if(Design.verifyWebhookNameAbsent()) {
						CommonFunction.logStatus("PASS", msg);
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
						}
					
					} catch(Exception e) {	
						e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
					}
				
				
				cfunction.sync(2);
				
				
				
				
				
				
				
				
				
				
		
		/**/
	
	}

}
