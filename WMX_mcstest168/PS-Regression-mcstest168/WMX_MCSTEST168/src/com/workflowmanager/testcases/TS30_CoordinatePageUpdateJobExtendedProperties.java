package com.workflowmanager.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
//import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;

public class TS30_CoordinatePageUpdateJobExtendedProperties extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName=cfunction.getUniqueName("New test delete");
	String expectedCalendarUI= "TS29_CalendarGUI.png";
	public void workflow_TS30_CoordinatePageUpdateJobExtendedProperties() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		//Click Create Jobs Button
		msg = "Click Create Jobs Button";
		try {
			Coordinate.clickOnCollapseLeftPanel1();
			Coordinate.clickOnNewJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Click on "Update Properties Work" job template.
		msg = "Click on \"Update Properties Work\" job template.";
		try {
			if(Coordinate.clickCreateDefaultOfTemplatePresent("Update Properties Work")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);
		//A toast message indicates that the new job is created.
		msg = "A toast message indicates that the new job is created.";
		try {
			if(Coordinate.verifySuccessMsg("successfully")) {
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
		
		//Click on Search Jobs tab
		msg = "Click on Search Jobs";
		try {
			Coordinate.clickOnSearchJob();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click on My Jobs- New filter
		msg = "Refresh My Jobs query";
		try {
			Coordinate.clickOnAllJob();
			Coordinate.clickOnMyJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click to the newly created "Update Properties Work" job in the Job Tile list
		msg = "Click to the newly created \"Update Properties Work\" job in the Job Tile list";
		try {
			Coordinate.clickOnJobListEntry(jobName);
			//Coordinate.clickOnJobListEntry("JOB_11264");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The selected job's details panel is opened on the right hand side.
		msg = "The selected job's details panel is opened on the right hand side.";
		try {
			if(WorkPage.verifyJobDetailWindow(jobName)) {
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
		
		//Click on pen icon of table "Required"
		msg = "Click on pen icon of table \"Required\"";
		try {
			
			//Coordinate.clickOnRequiredExtendproperties();
			WorkPage.clickOnEditBtnOfRequired();
			CommonFunction.logStatus("PASS", msg);
			}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Verify it should display the extended properties in editing mode
		msg = "Verify it should display the extended properties in editing mode.";
		try {
			if(WorkPage.verifyRequiredWindowOpenInEdit()) {
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
		
		//Verify DATE property has default value 11/19/2019 populated.
		msg = "Verify DATE property has default value 11/19/2019 populated.";
		try {
			//WorkPage.verifyActiveDateInCalendar();
			WorkPage.OpenCalendar();
			if(WorkPage.verifyActiveDateInCalendar("19November2019")) {
			CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg,expectedCalendarUI, 2185);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg,expectedCalendarUI, 2185);
		}
		cfunction.sync(2);
		//Close calendar
				msg="Close Calendar";
				try {
					WorkPage.OpenCalendar();
					CommonFunction.logStatus("PASS", msg);
				}catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
		//Verify BOOL has True default value populated.
		msg = "Verify BOOL has True default value populated.";
		try {
			WorkPage.verifyDropDwnValue("True");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Verify All properties in this table are required.
		msg = "Verify All properties in this table are required.";
		try {
			//WorkPage.verifyActiveDateInCalendar();
			if(WorkPage.verifyAllInputsAreRequired()) {
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
		
		//Verify The Save button in the editing dialog is disabled.
		msg = "Verify The Save button in the editing dialog is disabled.";
		try {
			WorkPage.verifySaveBtnDisable();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Click 'X' to cancel the editing.
		msg = "Click 'X' to cancel the editing.";
		try {
			//WorkPage.clickOnEditPanel();
			WorkPage.clickCancelBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Click the pen icon again.
		msg = "Click the pen icon again.";
		try {
			
			//Coordinate.clickOnRequiredExtendproperties();
			WorkPage.clickOnEditBtnOfRequired();
			CommonFunction.logStatus("PASS", msg);
			}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//The editing dialog is opened for editing.
		msg = "Verify the editing dialog is opened for editing.";
		try {
			if(WorkPage.verifyRequiredWindowOpenInEdit()) {
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
		//Pick current date from calendar to update DATE value.
		msg = "Pick current date from calendar to update DATE value";
		try {
			WorkPage.enterCurrentDate();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//DATE property is populated with current date.
		msg = "Verify DATE property is populated with current date.";
		try {
			//WorkPage.verifyActiveDateInCalendar();
			Date datef = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dMMMMyyyy");
			String date =dateformat.format(datef);
			System.out.println(date);
			//WorkPage.OpenCalendar();
			if(WorkPage.verifyActiveDateInCalendar(date)) {
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
		msg="Close Calendar";
		try {
			WorkPage.OpenCalendar();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Fill in a value "TEST" into INT.
		msg = "Fill in a value \"TEST\" into INT.";
		try {
			WorkPage.enterIntInput("TEST");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify nothing is populated since it has to be an integer value.
		msg = "Verify nothing is populated since it has to be an integer value.";
		try {
			if(WorkPage.verifyIntInput("")) {
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
		//Fill in a value 50 into INT
		msg = "Fill in a value 50 into INT";
		try {
			WorkPage.enterIntInput("50");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//INT property is populated with 50.
		msg = "Verify INT property is populated with 50.";
		try {
			if(WorkPage.verifyIntInput("50")) {
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
		//Fill in a value "TEST" into DOUBLE.
		msg = "Fill in a value \"TEST\" into DOUBLE.";
		try {
			WorkPage.enterDoubleInput("TEST");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify nothing is populated since it has to be an double value.
		msg = "Verify nothing is populated since it has to be an double value.";
		try {
			if(WorkPage.verifyDoubleInput("")) {
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
		//Fill in a value 10.8 into DOUBLE
		msg = "Fill in a value 10.8 into DOUBLE";
		try {
			WorkPage.enterDoubleInput("10.8");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//DOUBLE property is populated with 10.8
		msg = "Verify DOUBLE property is populated with 10.8";
		try {
			if(WorkPage.verifyDoubleInput("10.80")) {
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
		//Fill in a value "TEST" into STR
		msg = "Fill in a value \"TEST\" into STR";
		try {
			WorkPage.enterSTRInput("TEST");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//STR property is populated with TEST.
		msg = "Verify STR property is populated with TEST.";
		try {
			if(WorkPage.verifySTRInput("TEST")) {
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
		//Update the BOOL value from True to False
		msg = "Update the BOOL value from True to False";
		try {
			Coordinate.selectValueFromDropdownBOOL("False");;
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//BOOL property is populated with False
		msg = "Verify BOOL property is populated with False";
		try {
			Coordinate.verifyBOOLInput("False");
			//WorkPage.verifyBOOLInput("False");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
	
		//Verify the Save button is enabled
		msg = "Verify the Save button is enabled";
		try {
			WorkPage.verifySaveBtnEnable();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Clear the value from INT property.
		msg = "Clear the value from INT property.";
		try {
			WorkPage.clearIntInput();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Verify the Save button is disabled.
		msg = "Verify the Save button is disabled.";
		try {
		//	Coordinate.clickOnRequiredExtendproperties();
			WorkPage.verifySaveBtnDisable();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Fill in a value"60" into INT
		msg = "Fill in a value\"60\" into INT";
		try {
			WorkPage.enterIntInput("60");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//INT property is populated with 60.
		msg = "Verify INT property is populated with 60.";
		try {
			if(WorkPage.verifyIntInput("60")) {
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
		
		//Click Save.
		msg = "Click Save button";
		try {
			//Coordinate.clickOnRequiredExtendproperties();
			WorkPage.clickSaveBtn();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);
		
		//Verify a toast message indicate the job properties have been updated.
		msg = "Verify a toast message indicate the job properties have been updated.";
		try {
			WorkPage.verifySuccessMsg("updated");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		
		//Verify the extended properties updates in the Required extended property table.
		msg = "Verify the extended properties updates in the Required extended property table";
		try {
			//cfunction.ScrollToElement("//span[@title='JOB_54']");
			//cfunction.Commmon_Click("xpath", "//span[@title='JOB_54']");
			cfunction.ScrollToElement("//span[@title='"+jobName+"']");
			/*Coordinate.moverowUpDown();
			cfunction.Commmon_Click("xpath", "//span[@title='"+jobName+"']");
			*/WorkPage.ClickDetailPanelRefresh();
			cfunction.sync(2);
			Date datef = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("M/d/yyyy");
			String date =dateformat.format(datef);
			System.out.println(date);
			if(WorkPage.verifyIntInput1("60", "1")) {
				if(WorkPage.verifyDate(date, "3")) {
					if(WorkPage.verifyDoubleInput1("10.8", "5")) {
						if(WorkPage.verifySTRInput1("TEST", "7")) {
							if(WorkPage.verifyBOOLInput1("False", "9")) {
								CommonFunction.logStatus("PASS", msg);
								}
								else {
									CommonFunction.logStatus("FAIL", msg+" BOOL value not updated");
								}
							}
							else {
								CommonFunction.logStatus("FAIL", msg+" STR value not updated");
							}
						}
						else {
							CommonFunction.logStatus("FAIL", msg+" DOUBLE value not updated");
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg+" DATE value not updated");
					}
				}
				else {
					CommonFunction.logStatus("FAIL", msg+" INT value not updated");
				}
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*msg = "Verify the extended properties updates in the Required extended property table.";
		try {
			//WorkPage.clickOnRequiredExtendproperties();
			WorkPage.clickOnEditBtnOfRequired(2);
			//cfunction.Commmon_Click("xpath", "(//button[contains(@class,'btn btn-transparent btn-dark-gray')])[2]");
			if(WorkPage.verifyRequiredWindowOpenInEdit()) {
				Date datef = new Date();
				SimpleDateFormat dateformat = new SimpleDateFormat("dMMMMyyyy");
				String date =dateformat.format(datef);
				System.out.println(date);
				if(WorkPage.verifyIntInput("60")) {
					WorkPage.OpenCalendar();
				if(WorkPage.verifyActiveDateInCalendar(date)) {
					WorkPage.OpenCalendar();
						if(WorkPage.verifyDoubleInput("10.80")) {
							if(WorkPage.verifySTRInput("TEST")) {
								if(Coordinate.verifyBOOLInput("False")) {
									CommonFunction.logStatus("PASS", msg);
								}
								else {
									CommonFunction.logStatus("FAIL", msg);
								}
							}
							else {
								CommonFunction.logStatus("FAIL", msg);
							}
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}
				else {
					CommonFunction.logStatus("FAIL", msg);
				}
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
				}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Close calendar
		msg="Close Calendar";
		try {
			WorkPage.OpenCalendar();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click Cancel button
		msg= "Click Cancel button";
		try {
			Coordinate.clickCancelBtn();
			CommonFunction.logStatus("PASS", msg);
		}catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		*/
		
		//Click on the pen icon of table "Normal w/ Default"
		msg = "Click on the pen icon of table \"Normal w/ Default\"";
		try {
			
			//Coordinate.clickOnNormalDefaultExtendproperties();
			WorkPage.clickOnAddNewRecordBtnOfNormalDefault(2);
			CommonFunction.logStatus("PASS", msg);
			}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		
		//Verify it should display the extended properties in editing mode
		msg = "Verify it should display the extended properties in editing mode.";
		try {
			if(WorkPage.verifyNormalDefaultWindowOpenInEdit()) {
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
		
		//Verify the Save button is enabled
		msg = "Verify the Save button is enabled";
		try {
			WorkPage.verifySaveBtnEnable();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		//Update a new value in each property.
		msg = "Update a new value for BOOL.";
		try {
			Coordinate.selectValueFromDropdownBOOL("False");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Update a new value for INT.";
		try {
			WorkPage.enterIntInput("1235");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Update a new value for DOUBLE.";
		try {
			WorkPage.enterDoubleInput("10.8");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Update a new value for STR.";
		try {
			WorkPage.enterSTRInput("TEST");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Update current date on Calendar.";
		try {
			WorkPage.enterCurrentDate();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg="Close Calendar";
		try {
			WorkPage.OpenCalendar();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click Save.
		msg = "Click Save button";
		try {
			WorkPage.clickSaveBtn();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//cfunction.sync(2);
		//Verify a toast message indicate the job properties have been updated.
		msg = "Verify a toast message indicate the job properties have been updated.";
		try {
			WorkPage.verifySuccessMsg("updated");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
		//Verify the extended properties updates in the 2nd extended property table.
		msg = "Verify the extended properties updates in the 2nd extended property table.";
		try {
			//cfunction.ScrollToElement("//span[@title='JOB_54']");
			//cfunction.Commmon_Click("xpath", "//span[@title='JOB_54']");
			cfunction.ScrollToElement("//span[@title='"+jobName+"']");
			//cfunction.Commmon_Click("xpath", "//span[@title='"+jobName+"']");
			WorkPage.ClickDetailPanelRefresh();
			cfunction.sync(2);
				Date datef = new Date();
				SimpleDateFormat dateformat = new SimpleDateFormat("M/d/yyyy");
				String date =dateformat.format(datef);
				System.out.println(date);
				if(WorkPage.verifyIntInput1("1,235", "13")) {
					if(WorkPage.verifyDate(date,"19")) {
						if(WorkPage.verifyDoubleInput1("10.8", "15")) {
							if(WorkPage.verifySTRInput1("TEST", "17")) {
								if(WorkPage.verifyBOOLInput1("False", "11")) {
									CommonFunction.logStatus("PASS", msg);
								}
								else {
									CommonFunction.logStatus("FAIL", msg+" BOOL value not updated");
								}
							}
							else {
								CommonFunction.logStatus("FAIL", msg+" STR value not updated");
							}
						}
						else {
							CommonFunction.logStatus("FAIL", msg+" DOUBLE value not updated");
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg+" Calendar value not updated");
					}
				}
				else {
					CommonFunction.logStatus("FAIL", msg+" INT value not updated");
				}
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*msg = "Verify the extended properties updates in the 2nd extended property table.";
		try {
			//WorkPage.clickOnNormalDefaultExtendproperties();
			//WorkPage.clickOnAddNewRecordBtnOfNormalDefault(2);
			WorkPage.clickOnEditBtnOfRequired(3);
			
			if(WorkPage.verifyRequiredWindowOpenInEdit()) {
				Date datef = new Date();
				SimpleDateFormat dateformat = new SimpleDateFormat("dMMMMyyyy");
				String date =dateformat.format(datef);
				System.out.println(date);
				if(WorkPage.verifyIntInput("1,235")) {
					WorkPage.OpenCalendar();
				if(WorkPage.verifyActiveDateInCalendar(date)) {
					WorkPage.OpenCalendar();
						if(WorkPage.verifyDoubleInput("10.80")) {
							if(WorkPage.verifySTRInput("TEST")) {
								if(Coordinate.verifyBOOLInput("True")) {
									CommonFunction.logStatus("PASS", msg);
								}
								else {
									CommonFunction.logStatus("FAIL", msg);
								}
							}
							else {
								CommonFunction.logStatus("FAIL", msg);
							}
						}
						else {
							CommonFunction.logStatus("FAIL", msg);
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg);
					}
				}
				else {
					CommonFunction.logStatus("FAIL", msg);
				}
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Close calendar
		/*msg="Close Calendar";
		try {
			WorkPage.OpenCalendar();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click Cancel button
		msg= "Click Cancel button";
		try {
			Coordinate.clickCancelBtn();
			CommonFunction.logStatus("PASS", msg);
		}catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}*/
		//Verify the third table "Not Editable" has the pen icon disabled with tooltips "No properties are editable".
		msg = "Verify the third table \"Not Editable\" has the pen icon disabled with tooltips \"No properties are editable";
		try {
			CommonFunction.ScrollToElement("(//calcite-button[@t-itemname='addRecordBtn'])[4]");
			WorkPage.clickOnAddNewRecordBtnOfNormalDefault(4);
			if(Coordinate.verifyEditBtnDisable()) {
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
		//Log out the app 
		msg = "Click on Log out";
		try {
			HomePage.clickOnLogOut();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		//Log in as wmxuser
		LoginPage lp = new LoginPage();
		driver.get("https://mcstest62.esri.com/portal/apps/workflowmanager/");
		lp.loginToApplication(xls.getCellData("en-us",2, 12), xls.getCellData("en-us", 3,12));

		cfunction.sync(2);
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
				//Expand Custom Search.
				msg = "Expand Custom Search";
				try {
					WorkPage.clickOnCustomeSearchIcon();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Enter new search query Search in the custom search box.
				msg = "Enter new search query Search in the custom search box";
				try {
					String query = "Update_Job_Properties";
					WorkPage.enterCustomSearch(query);
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				//Hit Enter.
				msg = "Hit Enter";
				try {
					cfunction.pressEnterKey();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//A custom search is run and the job named "Update_Job_Properties" is displayed in Job List.
		//Click on the job to open its job details panel.
				msg = "Click on the job to open its job details panel.";
				try {
					WorkPage.clickOnJobDetails("Update_Job_Properties");
					WorkPage.clickOnCollapseRightPane();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
		//Verify the three extended properties table visible
				msg = "Verify Required extend properties table visible";
				try {
					if(Coordinate.verifyJobExtendPropertiesSectionVisible()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify Normal w/ Default extend properties table visible";
				try {
					if(Coordinate.verifyJobExtendPropertiesSectionVisible()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify Not Editable extend properties table visible";
				try {
					if(Coordinate.verifyJobExtendPropertiesSectionVisible()) {
						CommonFunction.logStatus("PASS", msg);
					}else {
						CommonFunction.logStatus("FAIL", msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				
		//Verify no pen icon is available on each table due to the wmxuser is missing job UPdateExtendedProperties privilege.
				msg = "Verify Required extend properties pen icon not visible";
				try {
					if(Coordinate.verifyAddRecordDisable()) {
						CommonFunction.logStatus("FAIL", msg);
					}
					else{
						CommonFunction.logStatus("PASS", msg);
					};
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);
				msg = "Verify Normal w/ Default extend properties pen icon not visible";
				try {
					if(Coordinate.verifyAddRecordDisable()) {
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
				msg = "Verify Not Editable extend properties pen icon not visible";
				try {
					if(Coordinate.verifyAddRecordDisable()) {
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