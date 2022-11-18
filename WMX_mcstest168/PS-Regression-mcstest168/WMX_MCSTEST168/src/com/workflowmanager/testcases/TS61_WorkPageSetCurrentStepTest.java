package com.workflowmanager.testcases;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;

public class TS61_WorkPageSetCurrentStepTest extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	
	String msg = "";
	public void workflow_TS61_WorkPageSetCurrentStepTest() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
	
		//In Manage tab - Job List View table select a job.
		msg = "Click on 'Always New Execute GP Service' in the job list";
		try {
			Coordinate.clickOnJobListEntry("Always New Execute GP Service");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		//It opens job details panel.
		msg = "Verify it opens job details panel.";
		try {
			if(Coordinate.verifyJobNameAtInfoPanel("Always New Execute GP Service")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Go to Diagram & Map tab.
		msg = "Click on the 'Diagram & Map' tab.";
		try {
			Coordinate.clickOnDiagramAndMapTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The tab displays the selected job's diagram.
		msg = "Verify the tab displays the selected job's diagram.";
		try {
			if(Coordinate.verifyDiagramVisibleOnDiagramAndMapTap()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Right click on one step which is not the active step.
		msg = "Right click on one step which is not the active step.";
		try {
			SikuliHelp.rightClickOnMap("TS61_RightClickOnMap_1280x768");
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The Set as current option is displayed but disabled.
		msg = "Verify the Set as current option is displayed but disabled.";
		try {
			if(Coordinate.verifySetAsCurrentOptionDisable()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Hover over the Set as current option.
		msg = "Hover over the Set as current option.";
		try {
			Coordinate.cursorHoverOnSetAsCurrentBtn();
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The tooltips indicates Missing Privilege.
		msg = "The tooltips indicates Missing Privilege.";
		try {
			if(Design.verifyToolTipTextPresent("Missing privilege")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Log out from the web app.
		msg="Log out of the web app";
		
		try {
			Coordinate.clickOnSignout();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,3181);
		}
		cfunction.sync(2);
		//Log into the web app as a admin user.
		msg="Log in as 'admin'";
		try {
			
		//	CommonFunction.openNewTabsWithURL("https://mcstest62.esri.com/portal/apps/workflowmanager/");
			
			cfunction.sync(2);
			//driver.get("https://mcstest62.esri.com/portal/apps/workflowmanager/");
			cfunction.sync(2);
			LoginPage  lp = new LoginPage();
			//lp.loginToApplication1(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));
			lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us", 3,2));
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//The user is logged into the web app and the Manage tab is opened. The default job query "My Jobs" is run.
		//Go to Work page and create a new job using "Extract Data" job template.
		msg = "Click on 'Work' Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click the 'Create' button";
		try {
			WorkPage.clickCreateBtn1();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter 'Extract Data' in Search Textbox";
		try {
			Coordinate.enterSearchText("Extract Data");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify 'Extract Data' is displayed in the list";
		try {
			if (Coordinate.verifyJobIsPresent("Extract Data"))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
				//Click the Open Web App Test job template
		msg = "Click the 'Extract Data' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Extract Data");
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
		//Click on the job card of the newly created job and expand the Job Details panel as needed.
				msg = "Click on the job card of the newly created job and expand the Job Details panel as needed.";
				try {

					WorkPage.clickOnCollapseSummaryBtn();
					cfunction.sync(2);
					WorkPage.clickCreateBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The new job's details are displayed.
				msg = "Verify it opens job details panel.";
				try {
					if(Coordinate.verifyJobNameAtInfoPanel(jobName)) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Go to Diagram & Map tab.
				msg = "Click on the 'Diagram & Map' tab.";
				try {
					WorkPage.clickOnDiagramAndMapTab();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//The tab displays the selected job's diagram.
				msg = "Verify the tab displays the selected job's diagram.";
				try {
					if(Coordinate.verifyDiagramVisibleOnDiagramAndMapTap()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
			/*	msg = "Close location ";
				try {
					WorkPage.clickLocation();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//Right click on step "How to proceed"
				msg = "Right click on step \"How to proceed\"";
				try {
					SikuliHelp.rightClickOnMap("TS61_RightClickOnHowToProceed_1280x768");
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The Set as current option is displayed
				msg = "Verify the Set as current option is displayed.";
				try {
					if(WorkPage.verifySetAsCurrentOption()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Choose Set as current.
				msg = "Choose Set as current.";
				try {
					WorkPage.clickOnSetAsCurrentBtn();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The "How to proceed" step is set as current step. The Diagram tab is refreshed to display the proper active step with blue highlight and orange frame.
		//Run "How to proceed" step.
				msg = "Run \"How to proceed\" step for the job";
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
		//The question step is prompted for answered.
				msg = "Verify the question step is prompted for answered.";
				try {
					if(WorkPage.verifyJobExecutionViewVisible()) {
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
			/*	msg = "Close location ";
				try {
					WorkPage.clickLocation();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//Without providing answer of the question step, go to Diagram tab and right click on step "Prepare" and set as current step.
				msg = "Right click on step \"Prepare\"";
				try {
					Coordinate.clickOnDiagramAndMapTab();
					cfunction.sync(5);
					SikuliHelp.rightClickOnMap("TS61_RightClickOnPrepare_1280x768");
					/*cfunction.sync(2);
					SikuliHelp.selectLocationOnMapSikuliRightClick("TS61_RightClickOnPrepare1_1280x768");*/
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//cfunction.sync(2);
				msg = "Choose Set as current.";
				try {
					WorkPage.clickOnSetAsCurrentBtn();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//A toast error message is popped to indicate that the job is running. The current step isn't reset.
				msg = "Verify A toast error message is popped 'The specified step is currently running'";
				try {
					String errorText= "The specified step is currently running";
					Coordinate.verifySuccessMsg1(errorText);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Choose "Run GP" as the answer and click Proceed.
				msg = "Click on \"Run GP\" button";
				try {
					cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class,'c-jobCard__resumeBtn t-resumeBtn')]");
					WorkPage.clickRunGPBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Refresh the diagram tab of the job.
		//The diagram is refreshed to show the current step as "GP - Extract Data"
		//Right click on "GP - Extract Data" step and set as current.
				msg = "Right click on step \"GP - Extract Data\"";
				try {
					SikuliHelp.rightClickOnMap("TS61_RightClickOnGPExtractData_1280x768");
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Choose Set as current.";
				try {
					WorkPage.clickOnSetAsCurrentBtn();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//cfunction.sync(2);
		//A toast warning message is popped to indicate that the selected step is current step already.
				msg = "Verify A toast error message is popped 'The specified step is currently running'";
				try {
					String errorText= "The specified step is currently running";
					Coordinate.verifySuccessMsg1(errorText);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//In Manage tab, 
				msg = "Click on Manage tab";
				try {
					HomePage.clickOnCoordinate();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(10);
		//click All jobs query.
		//The job query returns all jobs.
		//Select the job "Data Edits 1" to open its job details panel.
				msg = "Select the job \"Data Edits 10\" to open its job details panel.";
				try {
					Coordinate.clickOnJobListEntry("Data Edits 10");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(5);
		//Go to Diagram & Map tab.
				msg = "Click on the 'Diagram & Map' tab.";
				try {
					Coordinate.clickOnDiagramAndMapTab();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*msg = "Close location ";
				try {
					Coordinate.clickLocation();
					CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);*/
		//Right click on step "Define AOI"
				msg = "Right click on step\"Define AOI\"";
				try {
					SikuliHelp.rightClickOnMap("TS61_RightClickOnMap1_1280x768");
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The Set as current option is displayed but disabled.
				msg = "Verify the Set as current option is displayed but disabled.";
				try {
					if(Coordinate.verifySetAsCurrentOptionDisable()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Hover over the Set as current option.
				msg = "Hover over the Set as current option.";
				try {
					Coordinate.cursorHoverOnSetAsCurrentBtn();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//The tooltips indicates No steps assigned to the user.
				msg = "The tooltips indicates No steps assigned to the user";
				try {
					if(Design.verifyToolTipTextPresent("No steps assigned to user")) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click on 'Work' Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Click the 'Create' button";
				try {
					WorkPage.clickCreateBtn();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Enter 'Survey Workflow' in Search Textbox";
				try {
					Coordinate.enterSearchText("Survey Workflow");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify 'Survey Workflow' is displayed in the list";
				try {
					if (Coordinate.verifyJobIsPresent("Survey Workflow"))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
						//Click the Open Web App Test job template
				msg = "Click the 'Survey Workflow' job template";
				try {

					boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Survey Workflow");
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
				//Click on the job card of the newly created job and expand the Job Details panel as needed.
						msg = "Click on the job card of the newly created job and expand the Job Details panel as needed.";
						try {

							WorkPage.clickOnCollapseSummaryBtn();
							cfunction.sync(2);
							WorkPage.clickCreateBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
				//The new job's details are displayed.
						msg = "Verify it opens job details panel.";
						try {
							if(Coordinate.verifyJobNameAtInfoPanel(jobName)) {
								CommonFunction.logStatus("PASS", msg);
							}else {
								CommonFunction.logStatus("FAIL", msg);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		
		//Go to Diagram & Map tab.
						msg = "Click on the 'Diagram & Map' tab.";
						try {
							WorkPage.clickOnDiagramAndMapTab();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		//The tab displays the selected job's diagram.
					/*	msg = "Close location ";
						try {
							WorkPage.clickLocation();
							CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);*/
		//Right click on step "End" and set as current
						msg = "Right click on step\"End\"";
						try {
							//cfunction.CommmonJS_Click("//calcite-icon[@class='maximizeDiagramBtn t-maximizeBtn']");
							//WorkPage.openPopWindow_inSelection();
							//cfunction.sync(5);
							WorkPage.minimize_location();
							SikuliHelp.rightClickOnMap("TS61_RightClickOnEnd_1280x768");
								CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						//The Set as current option is displayed but disabled.
						msg = "Verify the Set as current option is displayed but disabled.";
						try {
							if(Coordinate.verifySetAsCurrentOptionDisable()) {
								CommonFunction.logStatus("PASS", msg);
							}else {
								CommonFunction.logStatus("FAIL", msg);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(4);
						//Hover over the Set as current option.
						msg = "Hover over the Set as current option.";
						try {
							Coordinate.cursorHoverOnSetAsCurrentBtn();
								CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						//The tooltips indicates No steps assigned to the user.
						msg = "The tooltips indicates \"No steps assigned to the user\"";
						try {
							if(Design.verifyToolTipTextPresent("No steps assigned to user")) {
								CommonFunction.logStatus("PASS", msg);
							}else {
								CommonFunction.logStatus("FAIL", msg);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		
		//In Job details panel - properties - Assignment, assign the job to current user.
						msg = "Click on Properties button";
						try {
							//WorkPage.closePopWindow_inSelection();
							WorkPage.clickOnProperties();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						msg = "Click on Edit button of job";

						try {
							Coordinate.clickEditJobDetail();
							System.out.println("Edit job details clicked");
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Select Assigned User as \"admin admin\"";

						try {
							Coordinate.selectAssignedUserFromDropdown1("admin admin");
							System.out.println("admin admin user selected for assignment");
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Click on save button";

						try {
							Coordinate.clickSaveEditJobDetail();
							System.out.println("Edit data saved");
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		//Go to Diagram tab and set step "End" as  current.
						msg = "Click on the 'Diagram & Map' tab.";
						try {
							WorkPage.clickOnDiagramAndMapTab();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
				//Right click on step "Define AOI"
						msg = "Right click on step\"End\"";
						try {
							//cfunction.Commmon_Click("xpath", "//calcite-icon[@class='p-element maximizeDiagramBtn t-maximizeBtn']");
							//WorkPage.minimize_location();
							cfunction.sync(5);
							SikuliHelp.rightClickOnMap("TS61_RightClickOnEnd_1280x768");
								CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						msg = "Verify the Set as current option is displayed.";
						try {
							if(WorkPage.verifySetAsCurrentOption()) {
								CommonFunction.logStatus("PASS", msg);
							}else {
								CommonFunction.logStatus("FAIL", msg);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
				//Choose Set as current.
						msg = "Choose Set as current.";
						try {
							WorkPage.clickOnSetAsCurrentBtn();
								CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		//The Diagram is refreshed to show the current step as "End"
		//Run "End" step and  Proceed.
						msg = "Run \"End\" step for the job";
						try {
							//cfunction.Commmon_Click("xpath", "//button");
							//cfunction.sync(5);
						
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
						msg = "Click on Proceed button";
						try {
							WorkPage.clickOnProceedBtn();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
		//The Dismiss job option is displayed in the job card.
						msg = "Job is now complete and the Dismiss button is displayed";
						try {
							WorkPage.verifyDismissJobTileButtonVisible();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						/*msg = "Click the \"Dismiss\" button";
						try {
							WorkPage.clickOnDismissJobTileButton();
							CommonFunction.logStatus("PASS", msg);
						} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}*/
						cfunction.sync(2);
		//Do not refresh the diagram tab of the job and set step "Start" as current.
						msg = "Right click on step\"Start\"";
						try {
						//	cfunction.Commmon_Click("xpath", "//calcite-icon[@class='maximizeDiagramBtn t-maximizeBtn']");
							cfunction.sync(5);
//													SikuliHelp.rightClickOnMap("TS61_RightClickOnStart_1280x768");
							SikuliHelp.rightClickOnMap("TS61_RightClick_Start_Laststep");
								CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
						cfunction.sync(2);
						//Choose Set as current.
						msg = "Hover over Set as current.";
						try {
							Coordinate.cursorHoverOnSetAsCurrentBtn();
								CommonFunction.logStatus("PASS", msg);
							} catch (Exception e) {
							e.printStackTrace();
							CommonFunction.logStatus("FAIL", msg);
						}
					//	cfunction.Commmon_Click("xpath", "(//button)[2]");
						cfunction.sync(5);
					
						//cfunction.sync(2);
		//A toast error message is popped to indicate that the job is closed. The current step isn't reset.
				msg = "Verify A toast error message is popped 'No steps assigned to user'";
				try {
					String errorText= "No steps assigned to user";
					if(Design.verifyToolTipTextPresent("No steps assigned to user")) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
	}

}
