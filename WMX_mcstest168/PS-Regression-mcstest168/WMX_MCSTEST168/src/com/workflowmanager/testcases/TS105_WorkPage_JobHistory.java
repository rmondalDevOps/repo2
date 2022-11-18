package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS105_WorkPage_JobHistory  extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName = cfunction.getUniqueName("Attachment");
	
	public void workflow_TS105_JobHistory() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click on Work Tab
				msg = "Click on Work Tab";
				try {
					HomePage.clickOnWork();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

				//Verify Work tab is opened. 
				msg = "Verify Work tab is opened";
				try {
					if(WorkPage.verifyWorkTabOpen())
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
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
				msg = "Enter 'Arcade Symbols' in Search Textbox";
				try {
					Coordinate.enterSearchText("Arcade Symbols");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Arcade Symbols' is displayed in the list";
				try {
					if (Coordinate.verifyJobIsPresent("Arcade Symbols"))
						CommonFunction.logStatus("PASS", msg);
					else
						CommonFunction.logStatus("FAIL", msg);
				} catch (Exception e) {
					e.printStackTrace(); 
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Click the Arcade Symbols job template
				msg = "Click the 'Arcade Symbols' job template";
				try {

					boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Arcade Symbols");
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

					if(Coordinate.verifySuccessMsg("successfully"))
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
					//Click on Create button to Collapse
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
				//Go to History tab.
				msg = "Click on the 'History' tab.";
				try {
					WorkPage.clickOnHistory();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		
				//Go to History tab and verify job created
				msg = "Verify 'History' tab is opened and job created";
				try {
					WorkPage.verifyJobIsCreated("Job Created");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				// Verify Job created by user - admin admin
				msg = "Verify Job created by user - admin admin";
				try {
					WorkPage.verifyJobCreatedByUser("admin admin");
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				/*
				//Go to Holds tab
				msg = "Open 'Holds' tab";
				try {
					WorkPage.clickOnHolds();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				//Open Hold Tab
				msg = "Open 'Holds' tab";
				try {
					WorkPage.clickOnHolds();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				// Create Hold
				msg = "Create Hold";
				try {
					WorkPage.createHold();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				
				//Go to History tab.
				msg = "Click on the 'History' tab.";
				try {
					WorkPage.clickOnHistory();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				// Refresh Job Details
				msg = "Job details refreshed";
				try {
					WorkPage.ClickDetailPanelRefresh();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
				// Verify Hold Created
				msg = "Verify Hold Created";
				try {
					WorkPage.verifyHoldCreated();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				*/


			       msg = "Click on Proceed Button for Manual Step";
			        try {
			            WorkPage.clickOnProceedBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }

					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
			        
			     // Verify Start End Step Completed in History
			        msg = "Verify Start End Step Completed";
			        try {
			            WorkPage.verifyStartEndStepCompleted();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        
			        cfunction.sync(2);
			        
			        msg = "Click on Proced Button for Add Comment Step";
			        try {
			            WorkPage.clickOnProceedBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			      
					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(2);
				      
					// Verify Add Comment in History
			        msg = "Verify Add Comment";
			        try {
			            WorkPage.verifyAddComment();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        cfunction.sync(2);
			       msg = "Click on Proceed button for Manual Step";
			        try {
			            WorkPage.clickOnProceedBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        
					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(4);
					
					msg = "Verify Manual Step Completed";
			        try {
			            WorkPage.verifyManualStepCompleted();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        
			        cfunction.sync(4);
			        
					msg = "Click on 'Yes' in Question Step";
			        try {
			            WorkPage.clickOnYesInQuestionStep();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
		    		
					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(2);
					
					// Verify Question Completed
					msg = "Verify Question Completed";
					try {
						WorkPage.verifyQuestionCompleted();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(3);
					
					msg = "Click on Proceed for Attachement Step";
			        try {
			            WorkPage.clickOnProceedBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        
					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(3);
					
					// Verify Attachment Completed
					msg = "Verify Attachment Completed";
					try {
						WorkPage.verifyAddAttachmentCompleted();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}

					msg = "Click on Proceed button for Run GP Service Step";
			        try {
			            WorkPage.clickOnProceedBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        
					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(10);
					
					// Verify Run GP Service Completed
					msg = "Verify Run GP Service Completed";
					try {
						WorkPage.verifyRunGPServicesCompleted();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}

					msg = "Enter '1' on number field for Update 1-M Job Properties Step";
			        try {
			            WorkPage.enterRequiredNum("1");
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }

			        msg = "Uncheck Checkbox field for Update 1-M Job Properties Step";
			        try {
			        	WorkPage.uncheckCheckBox();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			       
			        msg = "Click on Proceed button for Update 1-M Job Properties Step";
			        try {
			            WorkPage.clickOnProceedBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        
					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(2);
					
					// Verify Update 1-M Job Properties Completed
					msg = "Verify Update 1-M Job Properties Completed";
					try {
						WorkPage.verifyMJobPropertiesCompleted();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					// Verify Job Updated
					msg = "Verify Job Updated";
					try {
						WorkPage.verifyJobUpdated();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					msg = "Click on Proceed button for Update Job Properties Step";
			        try {
			            WorkPage.clickOnProceedBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        
					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(2);
					
					// Verify Update Job Properties Completed
					msg = "Verify Update Job Properties Completed";
					try {
						WorkPage.verifyUpdateJobProperties();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
	
				   msg = "Click on 'Start Step button' of Open Web Page Step";
			        try {
			            WorkPage.clickOnStartBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        cfunction.sync(2);

					
					 // Switch child Tab to parent Tab
			        msg = "Switch Window";
			        try {
			            String wmx = driver.getWindowHandle();
			            driver.switchTo().window(wmx);
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        cfunction.sync(2);
			        
					msg = "Click on 'Finish Step button' of Open Web Page Step";
			        try {
			            WorkPage.clickOnFinishBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        cfunction.sync(2);
			        

					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(2);

			        // Verify Open Web Page Completed
					msg = "Verify Open Web Page Completed";
					try {
						WorkPage.verifyOpenWebPageCompleted();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
		/*
					msg = "Click on 'Start Step button' of Send Web Request Step";
			        try {
			            WorkPage.clickOnStartBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        cfunction.sync(2);
			        
			        msg = "Click on 'Finish Step button' of Send Web Request Step";
			        try {
			            WorkPage.clickOnFinishBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        
			*/      
					cfunction.sync(5);
					
			     // Verify Send Web Request Completed
					msg = "Verify Send Web Request Completed";
					try {
						WorkPage.verifySendWebRequestCompleted();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
			  /*      
					msg = "Click on 'Finish Step button'";
			        try {
			            WorkPage.clickOnFinishBtn();
			            CommonFunction.logStatus("PASS", msg);
			        } catch (Exception e) {
			            e.printStackTrace();
			            CommonFunction.logStatus("FAIL", msg);
			        }
			        cfunction.sync(5);
			    */    
					// Refresh Job Details
					msg = "Job details refreshed";
					try {
						WorkPage.ClickDetailPanelRefresh();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					
					cfunction.sync(2);
			        
					// Verify Job Closed
					msg = "Verify Job Closed";
					try {
						WorkPage.verifyJobClosed();
						CommonFunction.logStatus("PASS", msg);
					} catch (Exception e) {
						e.printStackTrace();
						CommonFunction.logStatus("FAIL", msg);
					}
					


			       
				
	}
}
