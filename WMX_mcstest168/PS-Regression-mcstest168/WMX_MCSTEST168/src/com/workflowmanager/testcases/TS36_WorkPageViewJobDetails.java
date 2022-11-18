package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Coordinate;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.WorkPage;

public class TS36_WorkPageViewJobDetails  extends TestBase {
	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	String uniqueName = cfunction.getUniqueName("Attachment");
	
	public void workflow_TS36_WorkPageViewJobDetails() throws InterruptedException {
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
		// In Job List click on job "Medium Priority Data Extraction"
		msg = "Select job \"Data Edits 1\" from Job List";
		try {
			if(WorkPage.clickOnJobDetails("Data Edits 1")) {
				WorkPage.clickOnCollapseRightPane();
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// The Job Details panel has title as job name.
		msg = "Verify the Job Details panel has title as job name.";
		try {
			if (Coordinate.verifyJobNameAtInfoPanel("Data Edits 1")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click More… to display all job properties in the pane.
		msg = "Click \"More…\" to display all job properties in the pane.";
		try {
			WorkPage.clickOnMoreBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify the job properties for selected job.
		// Verify STEP: Prepare,
		msg = "Verify \"STEP: Check LOI\" the job properties for selected job.";
		try {
			if (Coordinate.verifyStepValue("Check LOI")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify PRIORITY: Medium,
		msg = "Verify \"PRIORITY: Low\" the job properties for selected job.";
		try {
			if (Coordinate.verifyPriorityValue("Low")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify ASSIGNMENT: WMX User,
		msg = "Verify \"ASSIGNMENT: WMX User\" the job properties for selected job.";
		try {
			if (Coordinate.verifyAssignmentValue("WMX User")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify TYPE: Survey Workflow,
		msg = "Verify \"TYPE: Data Edits Sample\" the job properties for selected job.";
		try {
			if (Coordinate.verifyTypeValue("Data Edits Sample")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify STATUS: Ready to work,
		msg = "Verify \"STATUS: Ready to work\" the job properties for selected job.";
		try {
			if (Coordinate.verifyStatusValue("Ready to work")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify JOB OWNER: WMX User
		msg = "Verify \"JOB OWNER: WMX User\" the job properties for selected job.";
		try {
			if (Coordinate.verifyJobOwnerValue("WMX User")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Click Less…
		msg = "Click Less… to collapse job properties in the panel.";
		try {
			WorkPage.clickOnMoreBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Collapse Right pane.
		msg = "Collapse Right pane";
		try {
			WorkPage.clickOnCollapseRightPane();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Expand Right pane.
				msg = "Expand Right pane";
				try {
					WorkPage.clickOnCollapseRightPane();
					CommonFunction.logStatus("PASS", msg);
				} catch (Exception e) {
					e.printStackTrace();
					CommonFunction.logStatus("FAIL", msg);
				}
				cfunction.sync(2);

		// Click All Jobs under Search Jobs tab.
		msg = "Click All Jobs under Search Jobs tab.";
		try {
			WorkPage.clickOnAllJobs();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// In Job List click on job "Survey 34"
		msg = "Select job \"Survey 34\" from Job List";
		try {
			if(WorkPage.scrollToJob("Survey 34")) {
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
		// Repeat the above step to verify Survey 34's job properties.
		// The Job Details panel has title as job name.
		msg = "Verify the Job Details panel has title as job name.";
		try {
			if (Coordinate.verifyJobNameAtInfoPanel("Survey 34")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Click More… to display all job properties in the pane.
		msg = "Click More… to display all job properties in the pane.";
		try {
			WorkPage.clickOnMoreBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify STEP: Start, PRIORITY: High, ASSIGNMENT: Administrator, TYPE: Survey
		// Workflow, STATUS: Ready to work, and JOB OWNER: Administrator
		// Verify STEP: Start,
		msg = "Verify \"STEP: Start\" the job properties for selected job.";
		try {
			if (Coordinate.verifyStepValue("Start")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);

		// Verify PRIORITY: High,
		msg = "Verify \"PRIORITY: High\" the job properties for selected job.";
		try {
			if (Coordinate.verifyPriorityValue("High")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify ASSIGNMENT: wmx admin,
		msg = "Verify \"ASSIGNMENT: Administrator\" the job properties for selected job.";
		try {
			if (Coordinate.verifyAssignmentValue("admin admin")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify TYPE: Survey Workflow,
		msg = "Verify \"TYPE: Survey Workflow\" the job properties for selected job.";
		try {
			if (Coordinate.verifyTypeValue("Survey Workflow")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify STATUS: Ready to work,
		msg = "Verify \"STATUS: Ready to work\" the job properties for selected job.";
		try {
			if (Coordinate.verifyStatusValue("Ready to work")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Verify JOB OWNER: wmx admin
		msg = "Verify \"JOB OWNER: Administrator\" the job properties for selected job.";
		try {
			if (Coordinate.verifyJobOwnerValue("admin admin")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// Do not close the job details panel and click another job from Job List.
		msg = "Select job \"Survey 7\" from Job List";
		try {
			if(WorkPage.scrollToJob("Survey 7")) {
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
		// Verify The job details panel is refreshed to display the newly selected job's
		// properties.
		msg = "Verify the Job Details panel has title as job name.";
		try {
			if (Coordinate.verifyJobNameAtInfoPanel("Survey 7")) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "Log out the application";
		try {
			HomePage.clickOnLogOut();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

	}
}
