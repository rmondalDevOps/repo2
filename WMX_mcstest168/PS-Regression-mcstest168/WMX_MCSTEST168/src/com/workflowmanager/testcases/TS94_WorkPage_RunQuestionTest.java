package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS94_WorkPage_RunQuestionTest extends TestBase {
	
	CommonFunction cfunction = new CommonFunction();
	String msg= "";
	String stepName= "";
	
	public void workflow_TS94_WorkPage_RunQuestionTest() {
		
CommonFunction.waitforHomePagetoload();
		
		
		//Click on Work
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
		msg = "Hover the cursor over the toggle";
		try{
				WorkPage.hoverCreateBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		
		msg = "Click the toggle";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Type \"Question Test\" in to the search bar in the panel";
		try {
			WorkPage.enterTemplateNameInSearch("Question Test");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Click on the "Attachment_Selenium" job template to create a new job.
		msg = "Click the 'Question Test' job template";
		try {

			boolean check = Coordinate.clickCreateDefaultOfTemplatePresent("Question Test");
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

		
		msg = "Verify toast notification should appear in the top right indicating job creation";
		try {
			String msg1="successfully";
			Design.verifySuccessMsg(msg1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click the toggle";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Run the first step for the job";
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
		
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class, 't-proceedBtn')]");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		//Click the Start step button
		msg = "Click the \"Start\" step button";
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
		
		msg = "Verify job card displays the question \"Can I Proceed?\"";
		try {
			if(WorkPage.verifyQuestion()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Verify job card displays the Answers \"Yes and No\"";
		try {
			if(WorkPage.verifyAnswers()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg= "Verify Cancel button is present";
		try {
			if(WorkPage.verifyCancelBtn()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Click on Cancel button";
		try {
			WorkPage.clickCancelButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		stepName= "Question 1";
		msg= "Verify Step Name is "+stepName+"";
		try {
			if(WorkPage.verifyStepName(stepName)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);	
		}
		
		//Click the Start step button
		msg = "Click the \"Start\" step button";
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

		msg = "Verify job card displays the question \"Can I Proceed?\"";
		try {
			if(WorkPage.verifyQuestion()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Verify job card displays the Answers \"Yes and No\"";
		try {
			if(WorkPage.verifyAnswers()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg= "Verify Cancel button is present";
		try {
			if(WorkPage.verifyCancelBtn()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Click Yes button";
		try {
			WorkPage.clickYesBtn();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		stepName= "Yes";
		msg= "Verify Step Name is "+stepName+"";
		try {
			if(WorkPage.verifyStepName(stepName)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);	
		}
		
		//Click the Start step button
		msg = "Click the \"Start\" step button";
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
		
		msg = "Click on Proceed button";
		try {
			cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class, 't-proceedBtn')]");;
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		stepName= "Question 2";
		msg= "Verify Step Name is "+stepName+"";
		try {
			if(WorkPage.verifyStepName(stepName)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);	
		}
		
		//Click the Start step button
		msg = "Click the \"Start\" step button";
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
		
		msg = "Verify job card displays the question \"Choose your answer:\"";
		try {
			if(WorkPage.verifyQuestion2()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Verify job card displays the Answers \"A, B and C\"";
		try {
			if(WorkPage.verifyAnswers2()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg= "Verify Cancel button is present";
		try {
			if(WorkPage.verifyCancelBtn()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		// Click on 'All Jobs'
		msg = "Click on 'ALL JOBS' Tab";
		try {
			WorkPage.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}		
		
		msg = "Verify previous step returns all the jobs present";
		try {
			if(WorkPage.verifyAllJobs())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		

		//Switch to Custom Query tab.
		msg = "Switch to Custom Query tab";
		try {
			WorkPage.clickOnCustomQueryTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//The previous custom query results are persistent.
		msg = "The previous custom query results are persistent";
		try {
			if(WorkPage.verifyAllJobs())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Verify Resume and Cancel button is present";
		try {
			if(WorkPage.verifyCancelBtn() && WorkPage.verifyResumeBtn()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Click on Cancel button";
		try {
			WorkPage.clickCancelButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		stepName= "Question 2";
		msg= "Verify Step Name is "+stepName+"";
		try {
			if(WorkPage.verifyStepName(stepName)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);	
		}
		
		//Click the Start step button
		msg = "Click the \"Start\" step button";
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
		
		
		
		msg = "Verify job card displays the question \"Choose your answer:\"";
		try {
			if(WorkPage.verifyQuestion2()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Verify job card displays the Answers \"A, B and C\"";
		try {
			if(WorkPage.verifyAnswers2()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg= "Verify Cancel button is present";
		try {
			if(WorkPage.verifyCancelBtn()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		// Click on 'All Jobs'
		msg = "Click on 'ALL JOBS' Tab";
		try {
			WorkPage.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}		
		
		msg = "Verify previous step returns all the jobs present";
		try {
			if(WorkPage.verifyAllJobs())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		

		//Switch to Custom Query tab.
		msg = "Switch to Custom Query tab";
		try {
			WorkPage.clickOnCustomQueryTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		//The previous custom query results are persistent.
		msg = "The previous custom query results are persistent";
		try {
			if(WorkPage.verifyAllJobs())
				CommonFunction.logStatus("PASS", msg);
			else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg= "Verify Resume and Cancel button is present";
		try {
			if(WorkPage.verifyCancelBtn() && WorkPage.verifyResumeBtn()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Click on Resume button";
		try {
			WorkPage.clickResumeButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Verify job card displays the question \"Choose your answer:\"";
		try {
			if(WorkPage.verifyQuestion2()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Verify job card displays the Answers \"A, B and C\"";
		try {
			if(WorkPage.verifyAnswers2()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg= "Verify Cancel button is present";
		try {
			if(WorkPage.verifyCancelBtn()) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		msg = "Click C answer";
		try {
			WorkPage.clickCstep();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
			
		}
		
		stepName= "C";
		msg= "Verify Step Name is "+stepName+"";
		try {
			if(WorkPage.verifyStepName(stepName)) {
				CommonFunction.logStatus("PASS", msg);
			}
			else {
				CommonFunction.logStatus("FAIL", msg);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);	
		}
		
		

		
		
		
		
	}
	
	
}
