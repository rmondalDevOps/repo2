package com.workflowmanager.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.pages.WorkPage;


public class TS86_CommentsJobPanel extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";
	
	public void workflow_TS86_CommentsJobPanel() throws InterruptedException {
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
				//String collapse_Btn ="TS31_CollapseBtn2";
			//SikuliHelp.hoveronLocationSikuli(collapse_Btn);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		cfunction.sync(2);
		msg = "Click the toggle";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Type \"Data\" in to the search bar in the panel";
		try {
			WorkPage.enterTemplateNameInSearch("Data");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on the \"Data Edits Sample\" job template";
		try {
			if(WorkPage.clickOnJobTemplate("Data Edits Sample")) {
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
		msg = "Verify toast notification should appear in the top right indicating job creation";
		try {
			String msg1="successfully";
			Design.verifySuccessMsg(msg1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//Click the toggle
		msg = "Click the toggle";
		try {
			WorkPage.clickOnCollapseLeftPanel();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		//A search for the newly created job should have been performed, such that it is the only one visible
		msg = "Click to the newly created "+ jobName +" job in the Job Tile list";
		try {
			if(WorkPage.clickOnJobDetails(jobName)) {
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
		msg = "click on comments";
		try {
			WorkPage.clickOnComments();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify no comments found";
		try {
			if(WorkPage.verifyNoComments()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch(Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		cfunction.sync(2);
		msg = "Enter text on comments text area";
		String text = "test comment 1";
		try {
			WorkPage.clickOnCommentTextArea();
			WorkPage.textForCommentTextArea(text);
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on send button";
		try {
			WorkPage.sendcomment();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		Date datef = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("M/d/yyyy");
		String date1 =dateformat.format(datef);
		System.out.println(datef);
		SimpleDateFormat timeformat = new SimpleDateFormat("h:mm aa");
		String time1 = timeformat.format(datef);
		msg = "Verify comments, UserName, avatar and dateTime";
		try {
			if(WorkPage.verifyComments(text, "1")) {
				if(WorkPage.verifyUserName("admin admin")) {
					if(WorkPage.verifyAvatar("AA")) {
						if(WorkPage.verifyDateTime(date1, time1, "1")) {
							CommonFunction.logStatus("PASS", msg);
							}
							else {
								CommonFunction.logStatus("FAIL", msg+" Date didnot matched");
							}
						}
						else {
							CommonFunction.logStatus("FAIL", msg+" avatar did not matched");
						}
					}
					else {
						CommonFunction.logStatus("FAIL", msg+" Username did not matched");
					}
				}
				else {
					CommonFunction.logStatus("FAIL", msg+" comments did not matched");
				}
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		
		msg = "Enter second comment in text area";
		String text2 = "test comment 2";
		try {
			WorkPage.clickOnCommentTextArea();
			cfunction.sync(2);
			WorkPage.textForCommentTextArea(text2);
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on send button";
		try {
			WorkPage.sendcomment();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		
		Date dateNext = new Date();
		SimpleDateFormat dateformat2 = new SimpleDateFormat("M/d/yyyy");
		String date2 =dateformat2.format(dateNext);
		SimpleDateFormat timeformat2 = new SimpleDateFormat("h:mm aa");
		String time2 =timeformat2.format(dateNext);
		msg = "Verify second comments and dateTime in feed";
		try {
			if(WorkPage.verifyComments(text2, "2")) {
				if(WorkPage.verifyDateTime(date2, time2, "2")) {
					CommonFunction.logStatus("PASS", msg);
					}
				else {
					CommonFunction.logStatus("FAIL", msg+" Date didnot matched");
					}
				}
				else {
					CommonFunction.logStatus("FAIL", msg+" comments did not matched");
				}
			} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "Enter 200 plus characters in text area";
		String text3 = "Enter text of 200 plus characters.\r\n" + 
				"Enter text of 200 plus characters.\r\n" + 
				"Enter text of 200 plus characters.\r\n" + 
				"Enter text of 200 plus characters.\r\n" + 
				"Enter text of 200 plus characters.\r\n" + 
				"Enter text of 200 plus characters.\r\n" + 
				"Enter text of 200 plus characters. ";
		try {
			WorkPage.clickOnCommentTextArea();
			cfunction.sync(2);
			WorkPage.textForCommentTextArea(text3);
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify number of characters";
		try {
			if (WorkPage.verifyCharacters()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		
		msg = "click on send button";
		try {
			WorkPage.sendcomment();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "verify show more comments tab";
		try {
			if (WorkPage.verifyShowMore()){
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "signout user";
		try {
			WorkPage.clickOnSignout();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "log in as another user";
		try {
			LoginPage  lp = new LoginPage();
			lp.loginToApplication(xls.getCellData("en-us",2, 12), xls.getCellData("en-us", 3,12));
			CommonFunction.waitforHomePagetoload();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
			cfunction.sync(2);
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		final String newjobname = jobName;
		msg = "Click to the newly created "+ jobName +" job in the Job Tile list";
		try {
			if(WorkPage.clickOnJobDetails(jobName)) {
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
		msg = "click on comments";
		try {
			WorkPage.clickOnComments();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on text box";
		try {
			WorkPage.clickOnCommentTextArea();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Add comment as user number 2";
		String text4 = "add comment as user number 2";
		try {
			WorkPage.textForCommentTextArea(text4);
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on send button";
		try {
			WorkPage.sendcomment();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "signout user";
		try {
			WorkPage.clickOnSignout();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "log in as user number 1";
		try {
			LoginPage  lp = new LoginPage();
			lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
			CommonFunction.waitforHomePagetoload();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
			cfunction.sync(2);
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		msg = "Click to the newly created "+ jobName +" job in the Job Tile list";
		try {
			if(WorkPage.clickOnJobDetails(jobName)) {
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
		msg = "click on comments";
		try {
			WorkPage.clickOnComments();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		
		msg = "Check comment from User number 2";
		try {
			if(WorkPage.verifyLastCommentUser()){
				CommonFunction.logStatus("PASS", msg);
			}else{
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		msg = "click on text box";
		try {
			WorkPage.clickOnCommentTextArea();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Add comment without sending";
		String text5 = "add comment without sending";
		try {
			WorkPage.textForCommentTextArea(text5);
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on attachments";
		try {
			WorkPage.clickOnAttachment();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on comments";
		try {
			WorkPage.clickOnComments();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg="verify text in textbox";
		try {
			if(WorkPage.verifyTextOnTextBox()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg="Click on another job";
		try {
			WorkPage.clickOnAnotherJob1();
			CommonFunction.logStatus("PASS", msg);	
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify dialogue box to save comment";
		try {
			if(WorkPage.verifySaveDialogue()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "save changes";
		try {
			WorkPage.saveNotesPrompt();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click to the newly created "+ newjobname +" job in the Job Tile list";
		try {
			if(WorkPage.clickOnJobDetails(newjobname)) {
				//WorkPage.clickOnCollapseRightPane();
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "click on comments";
		try {
			WorkPage.clickOnComments();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Add comment without sending";
		String text6 = "add comment without sending";
		try {
			WorkPage.textForCommentTextArea(text6);
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg="Click on another job";
		try {
			WorkPage.clickOnAnotherJob1(); 
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "verify dialogue box to save comment";
		try {
			if(WorkPage.verifySaveDialogue()) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Discard changes";
		try {
			WorkPage.DiscardChanges();
			CommonFunction.logStatus("PASS", msg);
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on roles";
		try {
			Design.clickOnRoleTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "select role from list";
		String roleName = "viewVisibility";
		try {
			if(Design.selectRoleFromList(roleName)) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "remove viewDetailsPanelComments priviledge on user";
		String itemName = "viewDetailsPanelComments";
		try {
			Design.enableWorkflowPrivileges(itemName);
			//WorkPage.notesUpdatePrivilage();
			WorkPage.savePriviledge();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		
		}
		cfunction.sync(2);
		msg = "Click on Work Tab";
		try {
			HomePage.clickOnWork();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);
		
		msg = "Click to the newly created "+ jobName +" job in the Job Tile list";
		try {
			if(WorkPage.clickOnJobDetails(jobName)) {
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
		msg = "verify comment tab should not visible";
		try {
			if(WorkPage.verifyCommentsTab()) {
				CommonFunction.logStatus("FAIL", msg);
			}else {
				CommonFunction.logStatus("PASS", msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);	
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on settings";
		try {
			Design.clickOnSettings();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click on roles";
		try {
			Design.clickOnRoleTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "select role from list";
		try {
			if(Design.selectRoleFromList(roleName)) {
				CommonFunction.logStatus("PASS", msg);
			}else {
				CommonFunction.logStatus("FAIL", msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Add privilidge again to user";
		try {
			Design.enableWorkflowPrivileges(itemName);
			//WorkPage.notesUpdatePrivilage();
			WorkPage.savePriviledge();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		
		}
		cfunction.sync(2);
	}
}
