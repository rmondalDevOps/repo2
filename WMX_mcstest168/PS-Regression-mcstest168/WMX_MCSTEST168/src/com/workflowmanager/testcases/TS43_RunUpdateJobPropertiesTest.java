package com.workflowmanager.testcases;

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

public class TS43_RunUpdateJobPropertiesTest extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	public void workflow_TS43_RunUpdateJobPropertiesTest() throws InterruptedException {
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
		//Click on Work Tab
		//Work Page Opens
		//Click on the Custom Search bar and type 'Update_Job_Properties'
		//The search should execute and the 'Update_Job_Properties' job should be visible
		//Click the 'Start Step' button
		//The step should run, and the new step should be 'All Properties'
		//Click the 'Start Step' button
		/*"The job tile should expand and look like the image below.
		Check that *required is visible in the first 'STR' box
		'Different Alias' should be displayed instead of the field name
		The value for 'Different Alias' should default to 'Hello World!'
		The step help text should be visible at the bottom of the tile"*/
		//Hover over the 'Cancel' button
		//A tooltip should appear with 'Cancel Step'
		//Click the 'Cancel' button
		//The job tile should return to the original state (not expanded)
		//Click the 'Start Step' button
		//The job tile should expand and look like the image below.
		//Hover over 'Update_Job_Properties' 
		//A tooltip should appear with 'Update_Job_Properties' 
		//Hover over 'Please update the following values'
		//A tooltip should appear with 'Please update the following values' 
		//In the 'INT' field that is required, type 1 and then delete it
		//The styling should update to indicate that the field needs a value
		//Hover over the 'error' icon
		//"Missing required value' should appear as the tooltip"
		//In the 'INT' field that is required, type 2
		//"The red outline and error icon should go away"
		//Fill in 'Test' for the required STR field and 3.4 for the 'DOUBLE' field
		//The proceed button should enable
		//Scroll the the bottom of the job tile
		//The value for the bottom BOOL should be 'False' in the drop down
		//Click the dropdown and change the value to true
		//The value should update
		//Click the date picker for the date field and change the value to 12/11/1994
		//The value should update
		//Hover over the 'Proceed' button
		//A tooltip should appear with 'Proceed Step'
		//Click the 'Proceed' button
		/*"The job tile should return to it's original state (not expanded)
		The 'Dismiss Job' button should become visible"*/


	}
}