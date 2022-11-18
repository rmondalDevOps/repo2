/**
 * 
 */
package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

/**
 * @author arp97661
 *
 */
public class TS93_Job_SchedulingTest {
	CommonFunction cfunction = new CommonFunction();
	String msg= "";
	
	public void workflow_TS93_Job_SchedulingTest() {
		
		cfunction.waitforpagetoload();
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
			cfunction.sync(21);
			Design.clickOnJobTemplatesIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg="Click on Data Edits Sample from Job Template";
		try {
			cfunction.sync(7);
			Design.selectItemFromList("Data Edits Sample");
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify Data Edits Sample job template is open";
		try {
			cfunction.sync(21);
			if(Design.verifyJobTemplateHeader("Data Edits Sample")) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg="Switch to Automated Action Tab";
		try {
			Design.clickOnAutomatedAction();
			CommonFunction.logStatus("PASS", msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on 'Add Schedule Task' Button";
		try {
			Design.clickAddScheduleTaskButton();
			CommonFunction.logStatus("PASS", msg);	
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);			
		}
		
		msg="Verify Create Schedule dialog box is visible";
		try {
			Design.verifyScheduleDialogVisible();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Hourly button";
		try {
			Design.clickOnRadioButtonSchedule(7);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Elements has changed";
		try {
			Design.pageChanged("(//div[contains(@class, 'flexbox-alignCenter')])[6]", "minutes after");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Set repeat at every 3 hours";
		try {
			Design.clickButoonUpDown("//button[contains(@class, 'p-inputnumber-button-up')]", 2);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Set to start 15 minutes after the hour";
		try {
			Design.selectActionFrTime(6, "15");
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Select 'On a specific day button'";
		try {
			Design.selectEndDate(2);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Enter a End Date";
		try {
			Design.enterEndDate();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Check save button is disabled";
		try {
			
			if(Design.saveButtonDisable()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Enter Name";
		try {
			Design.enterName("Every morning");
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Check save button is Enabled";
		try {
			
			if(Design.saveButtonDisable()) {
				CommonFunction.logStatus("FAIL", msg);
			}
			else {
				CommonFunction.logStatus("PASS", msg);
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Uncheck the checkbox ";
		try {
			Design.clickOnCheckbox();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click Save button";
		//which in our case is OK
		try {
			Design.clickOnOKBtn1();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Edit Button";
		try {
			Design.editButton();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Values hasn't changed";
		try {
			Design.pageChanged("(//div[contains(@class, 'flexbox-alignCenter')])[6]", "minutes after");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Daily button";
		try {
			Design.clickOnRadioButtonSchedule1(2);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Elements hasn changed";
		try {
			Design.pageChanged("(//div[contains(@class, 'flexbox-alignCenter')])[4]", "days");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Set repeat at every 2 hours";
		try {
			Design.clickButoonUpDown("//button[contains(@class, 'p-inputnumber-button-up')]", 1);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Set to run at 05:30";
		try {
			Design.enterSetTime("05:30");
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Select 'After several occurences'";
		try {
			Design.selectEndDate(3);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Set Occurrences to 3";
		try {
			Design.clickButoonUpDown("(//button[contains(@class, 'p-inputnumber-button-up')])[2]", 3);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click Cancel button";
		try {
			Design.clickOnCancelBtn1();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Edit Button";
		try {
			Design.editButton();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Weekly button";
		try {
			Design.clickOnRadioButtonSchedule1(3);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Elements hasn changed";
		try {
			Design.pageChanged("(//div[contains(@class, 'flexbox-alignCenter')])[4]", "Run at");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//msg = "Set to repeat every Monday";
		//here it is already at monday
		msg= "Set to run Every Monday at 09:00";
		try {
			Design.enterSetTime("09:00");
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Select end date to 'Never'";
		try {
			Design.selectEndDate(1);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click Save button";
		//which in our case is OK
		try {
			Design.clickOnOKBtn1();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Edit Button";
		try {
			Design.editButton();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Monthly button";
		try {
			Design.clickOnRadioButtonSchedule1(4);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Elements hasn changed";
		try {
			Design.pageChanged("(//div[contains(@class, 'flexbox-alignCenter')])[4]", "months");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Set repeat at every 3rd month";
		try {
			Design.clickButoonUpDown("//button[contains(@class, 'p-inputnumber-button-up')]", 2 );
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Set to run on 9th day of month";
		try {
			Design.selectActionFrTime(6, "9");
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Yearly button";
		try {
			Design.clickOnRadioButtonSchedule2(5);
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Set to run on every September";
		try {
			Design.selectActionFrTime(6, "September");
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Set to run on 29th day of month";
		try {
			Design.selectActionFrTime(7, "29");
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click Cancel button";
		try {
			Design.clickOnCancelBtn1();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click on Delete Button";
		try {
			Design.deleteButton();
			CommonFunction.logStatus("PASS", msg);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		
		
	}
	
}
