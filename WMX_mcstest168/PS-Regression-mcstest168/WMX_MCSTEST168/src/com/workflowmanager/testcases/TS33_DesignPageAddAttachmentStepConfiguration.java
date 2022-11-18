package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS33_DesignPageAddAttachmentStepConfiguration extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName = cfunction.getUniqueName("Attachment");
	//String expectedCalendarUI = "TS29_CalendarGUI.png";

	public void workflow_TS33_DesignPageAddAttachmentStepConfiguration() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
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
		// Click on Diagram in left menu
		msg = "Click on Diagram in left menu";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click on create new button
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// The Diagram design canvas page is displayed.
		msg = "Verify Canvas is visible with start/End step";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter a diagram name for the new diagram "Attachment"
		msg = "Enter a diagram name for the new diagram "+uniqueName;
		try {
			Design.enterDiagramName(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on "Add Attachment" step in Step Library under "Advanced" category.
		/*msg = "Click on \"Add Attachment\" step in Step Library under \"Advanced\" category.";
		try {
			Design.clickOnAdvanceStepList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// Drag the step template into the diagram editing canvas.
		msg = "Drag \"Add Attachment\" step template into the diagram editing canvas.";
		try {
			Design.enterSearchStepTemplate("Add Attachment");
			Design.dragStepToCanvas("TS33_AddAttachment", "BlankCanvas");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Create path Between two steps";
		try {
			SikuliHelp.hoveronLocationSikuli("PathStart_1280x768");
			cfunction.sync(2);
			
			Design.dragStepToCanvas("PathDown", "AddAttachmentPath");
			cfunction.sync(2);
			SikuliHelp.selectLocationOnMapSikuliClick("ClickOnAddAttachment_1280x768");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify step Name text
		msg = "Verify step Name with the text 'Add Attachment'";
		try {
			boolean check = Design.verifyStepName("Add Attachment");
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
		cfunction.sync(2);
		// Verify step Description text
		msg = "Verify step description with the text 'Add an attachment'";
		try {
			Design.clickOnStepDetailAboutTab();
			boolean check = Design.verifyStepDesc("Add an attachment");
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
		cfunction.sync(2);
		// Check on step option for "Can be skipped"
		msg = "Check on step option for \"Can be skipped\"";
		try {
			Design.clickOnStepDetailOptionTab();
			Design.clickOnAutomaticallyexecutesBox(4);
			Design.clickOnOptioalCheckBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Update the User Prompt under step Logic into "Please add a PDF attachment."
		msg = "Update the User Prompt under step Logic into \"Please add a PDF attachment.\"";
		try {
			Design.clickOnStepDetailPropertiesTab();
			Design.enterUserPromptInput("Please add a PDF attachment");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Enter a folder name by entering any special character. Then hit Enter
		msg = "Enter a folder name by entering any special character. Then hit Enter";
		try {
			Design.enterFolderInput("@#$%");
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		/*// The folder name is invalid.
		msg = "Verify the folder name is invalid error is visible.";
		try {
			if (Design.verifyFolderNameErrorVisible()) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
*/
		// Save the diagram
		msg = "Save the diagram";
		try {
			Design.clickOnSaveWorkFlowDiagram();
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// A toast message is popped - Unable to save diagram - invalid input
		msg = "A toast message is popped - Unable to save diagram - invalid input";
		String successMsg = "Diagram created";
		try {
			if (Design.verifySuccessMsg1(successMsg))
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Update the Folder name without any special character. Ie. "PDF Attachment"
		msg = "Update the Folder name without any special character. Ie. \"PDF Attachment\"";
		try {
			Design.enterFolderInput("PDFAttachment");
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify the folder name is invalid error is removed.";
		try {
			if (Design.verifyFolderNameErrorVisible()) {
				CommonFunction.logStatus("FAIL", msg);
			} else {
				CommonFunction.logStatus("PASS", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(2);
		// Enter a file type for Accepted File Types, ie. *.PDF
		msg = "Enter a file type for Accepted File Types, ie. \".PDF\"";
		try {
			Design.enterFileTypeInput(".PDF");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Check on the options for View Existing
		/*msg = "Check on the options for View Existing";
		try {
			Design.clickOnViewExisting();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		// Save the diagram
		msg = "Save the diagram";
		try {
			Design.clickOnSaveWorkFlowDiagram();
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// After the diagram is saved, click on Add Attachment step.
		/*msg = "Click on Add Attachment step.";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick("ClickOnAddAttachment_128z768");
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/

		// Verify the step details are saved as entered in previous steps.
		// Update step name to Edit Attachment
		msg = "Update step name to \"Edit Attachment\"";
		try {
			 Design.enterStepName("Edit Attachment");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Update step option and check off "Can be skipped"
		msg = "Check off step option for \"Can be skipped\"";
		try {
			Design.clickOnStepDetailOptionTab();
			//Design.clickOnAutomaticallyexecutesBox();
			Design.clickOnOptioalCheckBox();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Check on Edit Existing under step Logic.
		/*msg = "Check on Edit Existing under step Logic.";
		try {
			Design.clickOnEditExisting();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);*/
		// Save the diagram.
		msg = "Save the diagram";
		try {
			Design.clickOnSaveWorkFlowDiagram();
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Activate the diagram and optionally create a job template using the diagram
		msg = "Click Activate button";
		try {
			Design.clickOnActivateWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(10);
		//Click Yes
		msg = "Click Yes button of confirmation to create job tamplate";
		try {
			Design.clickYesOnConfirmDialog();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Save the template";
		try {
			Design.clickOnSave();
			cfunction.pressEnterKey();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Click on Diagrams tab
		msg = "Click on Diagram in left menu";
		try {
			cfunction.sync(10);
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
	/*	msg="Save unsaved changes";
		try {
			Design.saveChanges();
			CommonFunction.logStatus("PASS", msg);
			
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			}*/
		/*msg = "Click on Diagram in left menu";
		try {
			cfunction.sync(7);
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		*/
		
		// Navigate to "Attachment" diagram and click Edit.
		msg = "Navigate to "+uniqueName+" diagram ";
		try {
			Design.enterSearchText_Diagram(uniqueName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
		// Click on "Edit Attachment" step.
		msg = "Click on Edit button.";
		try {
			//cfunction.Commmon_Click("xpath", "//button[@class='btn p-button']");
			Design.clickOnEditBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		cfunction.sync(2);
	
		
	msg = "Click on Add Attachment step.";
	try {
		SikuliHelp.selectLocationOnMapSikuliClick("EditAttachment_1280x768");
		CommonFunction.logStatus("PASS", msg);
		cfunction.sync(2);
	} catch (Exception e) {
		e.printStackTrace();
		CommonFunction.logStatus("FAIL", msg);
	}
	cfunction.sync(2);
	// Verify the step details are updated and saved as entered in previous steps.
	// Verify step Name text
			msg = "Verify step Name with the text 'Edit Attachment'";
			try {
				boolean check = Design.verifyStepName("Edit Attachment");
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
			cfunction.sync(2);
			// Verify step Description text
			msg = "Verify step description with the text 'Add an attachment'";
			try {
				Design.clickOnStepDetailAboutTab();
				boolean check = Design.verifyStepDesc("Add an attachment");
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
			cfunction.sync(2);
			/*msg = "Verify view existing is check on";
			try {
				boolean check = Design.verifyViewExistingCheckOn();
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
			cfunction.sync(2);*/
			/*msg = "Verify edit existing is check on";
			try {
				boolean check = Design.verifyEditExistingCheckOn();
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
			cfunction.sync(2);*/
			msg = "Verify Can be skipped is check off";
			try {
				Design.clickOnStepDetailOptionTab();
				boolean check = Design.verifyCanBeSkippedCheckOff();
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
			msg = "Deleting Created job template and diagram";
			try {
				HomePage.clickOnCoordinate();
			cfunction.sync(2);
			HomePage.clickOnDesign();
			cfunction.sync(2);
			Design.clickOnJobTemplatesIcon();
			cfunction.sync(2);
			Design.clickOnJobTemplate(uniqueName);
			cfunction.sync(2);
			Design.clickOnEllipsis3();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			cfunction.sync(2);
			Design.clickOnDiagramsIcon();
			cfunction.sync(2);
			Design.enterSearchText_Diagram(uniqueName);
			cfunction.sync(2);
			Design.clickOnEllipsis();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteBtn();
			cfunction.sync(2);
			Design.clickOnJobTemplateDeleteConfirmationYesBtn();
			cfunction.sync(2);
			try {
				if (Design.verifySuccessMsg(successMsg))
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
			
			
	
	}
}
