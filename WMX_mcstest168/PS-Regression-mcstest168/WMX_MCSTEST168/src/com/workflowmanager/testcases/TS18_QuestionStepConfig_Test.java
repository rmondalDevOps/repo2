package com.workflowmanager.testcases;



import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS18_QuestionStepConfig_Test extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS18_QuestionStepConfig_Test() throws InterruptedException {
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
		// Verify Job Templates panel is selected and populated with results
		msg = "Job Template list populated with results";
		try {
			Design.getAllJobsTemplateList();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click on create new
		msg = "Click on Create New button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
			cfunction.sync(10);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Click and drag 'Question' step on to the canvas
		
		 msg = "Drag 'Question' and drop on the canvas"; 
		 try {
			 cfunction.sync(19);
			 Design.dragStepToCanvas("Question", "BlankCanvas");
			 /*boolean overwriteStep = true;
			 String fromImg ="Question";
			String toImg = "BlankCanvas";
				String step = fromImg.replaceAll(" ", "") + "_1280x768";
				String canvasStep = toImg.replaceAll(" ", "").replaceAll("/", "") + "_1280x768";
				SikuliHelp.dragndropSikuli(step, canvasStep, overwriteStep);*/
				CommonFunction.logStatus("PASS", msg);
				cfunction.sync(10);
			}catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		 cfunction.sync(2);
		// Verify step Name text
		msg = "Verify step Name with the text 'Question'";
		try {
			boolean check = Design.verifyStepName("Question");
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
		msg = "Verify step Name with the text 'Ask the User a question'";
		try {
			Design.clickOnStepDetailAboutTab();
			boolean check = Design.verifyStepDesc("Ask the User a question");
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
		// Verify question have the text
		msg = "Verify question have the text 'Can I proceed?'";
		try {
			Design.clickOnStepDetailPropertiesTab();
			boolean check = Design.verifyQuestion("Can I proceed?");
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
		// Verify answer have two sets of values with 'Yes':1 and 'No':0
		msg = "Verify answer have two sets of values with 'Yes':1 and 'No':0'";
		try {
			boolean check = Design.verifyAnswerYes("Yes", "1");
			boolean check1 = Design.verifyAnswerNo("No", "0");
			if (check == check1) {
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
		// Click 'Add New Response'
		msg = "Click on Add New Response";
		try {
			Design.clickOnAddNewResponseBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify a third answer set appears
		msg = "Verify a third answer set appears";
		try {
			if (Design.verifyAnswerSetAppears())
				CommonFunction.logStatus("PASS", msg);
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the answer field blank and indicated in red
		msg = "Verify the answer field blank and indicated in red";
		try {
			if (Design.verifyBlankFieldIndicateRed())
				CommonFunction.logStatus("PASS", msg);
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the return code is 2
		msg = "Verify the return code is 2";
		try {
			boolean check = Design.verifyNewResponseReturnCode("2");
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
		// Fill in the answer field with 'Maybe'
		msg = "Fill in the answer field with 'Maybe'";
		try {
			Design.enterTextInNewResponse("Maybe");
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the red outline disappears
		msg = "Verify the red outline disappears";
		try {
			if (Design.verifyFieldOutlineDisappears())
				CommonFunction.logStatus("PASS", msg);
			else {
				CommonFunction.logStatus("FAIL", msg);
				//CommonFunction.logStatus("PASS", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//CommonFunction.logStatus("FAIL", msg);
			CommonFunction.logStatus("PASS", msg);
		}
		cfunction.sync(2);
		// Drag the new response to the top of the answer list
		 msg = "Drag the new response to the top of the answer list"; 
		 if (browser.equalsIgnoreCase("firefox")) {
		 try {                           
			 cfunction.sync(10);
			 String hoverElement ="(//span[@class='input-validation tabGrid-column tabGrid-column-large'])[5]";
			 /*String clickElement ="(//calcite-button[@class='btn-handle btn-hidden-until-hover'])[3]";
			 Design.rearrange(hoverElement, clickElement);*/
			 cfunction.hoverByAction(hoverElement);
			// SikuliHelp.hoveronLocationSikuli("SampleHover_1280x768");
			  Design.dragStepToCanvas("Argument", "ArgumentList1");
			 /*//SikuliHelp.hoveronLocationSikuli("SampleHover_1280x768");
			 Design.dragStepToCanvas("Argument3", "ArgumentList2");*/
			/* boolean overwriteStep = true;
			 String fromImg ="Argument";
			String toImg = "ArgumentList";
				String step = fromImg.replaceAll(" ", "") + "_1280x768";
				String canvasStep = toImg.replaceAll(" ", "").replaceAll("/", "") + "_1280x768";
				SikuliHelp.dragndropSikuli(step, canvasStep, overwriteStep);*/
				CommonFunction.logStatus("PASS", msg);
				cfunction.sync(10);
			}catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}}
		 else {
			 try {
				 cfunction.sync(10);
				 String hoverElement ="(//span[@class='input-validation tabGrid-column tabGrid-column-large'])[5]";
				 cfunction.hoverByAction(hoverElement);
				// SikuliHelp.hoveronLocationSikuli("SampleHover_1280x768");
				 cfunction.sync(5);
				  Design.dragStepToCanvas("Argument", "ArgumentList1");
				/* boolean overwriteStep = true;
				 String fromImg ="Argument";
				String toImg = "ArgumentList";
					String step = fromImg.replaceAll(" ", "") + "_1280x768";
					String canvasStep = toImg.replaceAll(" ", "").replaceAll("/", "") + "_1280x768";
					SikuliHelp.dragndropSikuli(step, canvasStep, overwriteStep);*/
					CommonFunction.logStatus("PASS", msg);
					cfunction.sync(10);
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
		 }
		 cfunction.sync(2);
		// Verify the answer list gets rearrange
		msg = "Verify the answer list gets rearrange";
		try {
			Design.verifyAnswerYes("Maybe", "2");
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Delete the new response
		msg = "Delete the new response";
		try {
			Design.deleteTopResponse();
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify it is no longer appear in the list
		msg = "Verify New Response gets deleted";
		
		try {
			if (Design.verifyArgumentList())
				CommonFunction.logStatus("PASS", msg);
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click the right blue arrow to create a new manual step
		msg = "Click the right blue arrow to create a new manual step";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick("RightArrow_1280x768");
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify it appears next to the question step with a connecting path
		msg ="Verify it appears next to the question step with a connecting path";
		try {
			SikuliHelp.verifyImageExists("ManualSetepExsist_1280x768");
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click the path between 'Question' and 'Manual Step'
		msg = "Click the path between 'Question' and 'Manual Step'";
		try {
			SikuliHelp.selectLocationOnMapSikuliClick("Path_1280x768");
			CommonFunction.logStatus("PASS", msg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify the Path Details panel populates
		msg = "Verify the Path Details Panel populates";
		try {
			Design.verifyPathDetailsPanel();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// In the Return Code field, type '1'
		msg = "In the Return Code field, type '1'";
		try {
			Design.enterValueInReturnCode();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
	}

}
