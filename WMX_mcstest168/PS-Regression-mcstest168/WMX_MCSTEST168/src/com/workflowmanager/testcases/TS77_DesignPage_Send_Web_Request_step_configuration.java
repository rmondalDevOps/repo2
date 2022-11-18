package com.workflowmanager.testcases;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;

public class TS77_DesignPage_Send_Web_Request_step_configuration extends TestBase {

	CommonFunction cfunction = new CommonFunction();
	String msg = "";

	public void workflow_TS77_DesignPage_Send_Web_Request_step_configuration() throws InterruptedException {
		CommonFunction.waitforHomePagetoload();
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		// "Design View Opens //Diagram panel is selected and populated with results"

		msg = "Verify canvas";
		try {
			Design.verifyCanvas();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		/*msg = "Delete old template if there any with name: ";
		try{
			Design.deleteTemplate("Send Web Request");
			CommonFunction.logStatus("PASS", msg+"Send Web Request");
		}catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg+"Send Web Request");
		}*/
		// Click 'Create New'
		cfunction.sync(2);
		msg = "Click create new button";
		try {
			Design.clickOnCreateNewBtn();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Name the new workflow diagram 'Send Web Request'
		cfunction.sync(2);
		msg = "Enter new name for workflow diagram";
		try {
			Design.diagramSettingName(diagramName1);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Drag a Send Web Request step into the workflow canvas and select it.
		cfunction.sync(2);
		msg = "Drag a Send Web Request step into the workflow canvas and select it";
		try {
			Design.enterSearchStepTemplate("Send Web Request");
			cfunction.sync(2);
			SikuliHelp.dragNDrop("SendWebRequest_1920x1080", "BlankCanvas_1280x768");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click on the Edit button next to Arguments
		cfunction.sync(2);
		msg = "Click on the Edit button next to Arguments";
		try {
			Design.clickEditArgument();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click on the drop down under URL
		cfunction.sync(2);
		msg = "Click on the drop down under URL ";
		try {
			Design.clickURLDropdown();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// You will see different request types like GET, POST, PUT, DELETE, HEAD,
		// PATCH, OPTIONS
		cfunction.sync(2);
		msg = "Verify different request types like GET, POST, PUT, DELETE, HEAD, PATCH, OPTIONS ";
		String requestTypes[] = { "GET", "POST", "PUT", "DELETE", "HEAD", "PATCH", "OPTIONS" };
		try {
			if (Design.verifyURLrequestType(requestTypes)) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Select 'POST' as your request type
		cfunction.sync(2);
		msg = "Select 'POST' as your request type: ";
		String requestType = "POST";
		try {
			if (Design.selectURLrequestType(requestType)) {
				CommonFunction.logStatus("PASS", msg + requestType);
			} else
				CommonFunction.logStatus("FAIL", msg + requestType);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + requestType);
		}
		// Enter URL ' HTTP://API.SHOUTCLOUD.IO/V1/SHOUT'
		cfunction.sync(2);
		String baseURL = "HTTP://API.SHOUTCLOUD.IO/V1/SHOUT";
		msg = "Input base URL as: ";
		try {
			Design.inputBaseURL(baseURL);
			CommonFunction.logStatus("PASS", msg + baseURL);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + baseURL);
		}
		// In the url text box, type :test1/:test2/:test3
		cfunction.sync(2);
		String inputAddParameterInURL = "/:test1/:test2/:test3";
		msg = "In the url text box, type :test1: ";
		try {
			Design.inputAddParameterInURL(inputAddParameterInURL);
			CommonFunction.logStatus("PASS", msg + inputAddParameterInURL);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + inputAddParameterInURL);
		}
		// test1, test2 and test3 are added under path variables
		cfunction.sync(2);
		msg = "Verify path variable count is 3: ";
		try {
			if (Design.countPathVariable() == 3) {
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click the Add Key & Value button under query parameters
		cfunction.sync(2);
		msg = "Click \"Add key and value\" button";
		try {
			Design.clickQueryParamAddKeyValueButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// In the first query parameter box add key as 'key1' and value as
		// 'jobName($job)'
		cfunction.sync(2);
		msg = "In the first query parameter box add key as 'key1' and value as 'jobName($job)";
		try {
			Design.inputQueryKey("Key1");
			cfunction.sync(2);
			Design.inputQueryValue("jobName($job)");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// In the second query parameter box add key as 'Key2' and value as 'test4' and
		// uncheck the enabled box
		cfunction.sync(2);
		msg = "Click \"Add key and value\" button";
		try {
			Design.clickQueryParamAddKeyValueNoPaddingButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Enter query parameter key";
		try {
			Design.inputQueryKey("Key2");
			cfunction.sync(2);
			Design.inputQueryValue("test4)");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Click to \"uncheck\" checkbox";
		try {
			Design.clickCeckBoxToUncheck();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click on the Authorization tab
		cfunction.sync(2);
		msg = "Select request type: ";
		String navigateToTab = "Authorization";
		try {
			if (Design.selectNavTab(navigateToTab)) {
				CommonFunction.logStatus("PASS", msg + requestType);
			} else
				CommonFunction.logStatus("FAIL", msg + requestType);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + requestType);
		}
		cfunction.sync(2);
		msg = "Validate selected tab name is: ";
		try {
			if (Design.verifyWhichSelectNavTabIsSelected(navigateToTab)) {
				CommonFunction.logStatus("PASS", msg + navigateToTab);
			} else {
				CommonFunction.logStatus("FAIL", msg + navigateToTab);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Click the API Key radio button
		cfunction.sync(2);
		msg = "Click the API Key from dropdown: ";
		String radioButtonName = "API Key";
		try {
			if (Design.selectRadioButton(radioButtonName)) {
				CommonFunction.logStatus("PASS", msg + radioButtonName);
			} else
				CommonFunction.logStatus("FAIL", msg + radioButtonName);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + radioButtonName);
		}

		/*
		 * In the warning message, right-click the word 'here' and select 'open in a new
		 * // tab' =====================> cfunction.sync(2); msg =
		 * "In the warning message, right-click the word 'here' and select 'open in a new tab"
		 * ; try { Design.rightClickBlueWarningMsgSettingPageLinkandVerify();
		 * CommonFunction.logStatus("PASS", msg); } catch (Exception e) {
		 * e.printStackTrace(); CommonFunction.logStatus("FAIL", msg); }
		 */
		// Text boxes for 'Key' and 'Value' appear, as well as a dropdown menu labeled
		// 'Added To'. There will also be blue information box with a warning under the
		// radio buttons.

		cfunction.sync(2);
		msg = "Text boxes for 'Key' and 'Value' appear, as well as a dropdown menu labeled 'Added To'.  There will also be blue information box with a warning under the radio buttons.";
		try {
			if ((Design.verifyContentType("key")) && (Design.verifyContentType("value"))) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Verify \"Added to\" is a dropdown";
		try {
			Design.verifyAddedToIsDropDown();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Add a key 'testKey' and a value 'testValue'. Switch the 'Added To' option to
		// Query Parameters.
		cfunction.sync(2);
		msg = "Add a key 'testKey' and a value 'testValue'";
		try {
			if ((Design.enterContentValue("key", "testKey")) && (Design.enterContentValue("Value", "testValue"))) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(2);
		msg = "Switch the 'Added To' option to Query Parameters";
		try {
			Design.clickAddedToIsDropDown();
			cfunction.sync(5);
			if(browser.equals("Firefox")) {
				if (Design.selectAddedToTypeFromDropDownFirefoxfirst("Query Parameters")) {
					CommonFunction.logStatus("PASS", msg);
				} 
				else
				CommonFunction.logStatus("FAIL", msg);
			}
			else 
			{
				if (Design.selectAddedToTypeFromDropDown("Query Parameters")) {
					CommonFunction.logStatus("PASS", msg);
				} else
					CommonFunction.logStatus("FAIL", msg);
				}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click the Bearer Token radio button
		cfunction.sync(2);
		msg = "Click the Bearer Token from dropdown:  ";
		radioButtonName = "Bearer Token";
		try {
			if (Design.selectRadioButton(radioButtonName)) {
				CommonFunction.logStatus("PASS", msg + radioButtonName);
			} else
				CommonFunction.logStatus("FAIL", msg + radioButtonName);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + radioButtonName);
		}
		// With the Bearer Token radio button selected, the warning remains in place but
		// the other text boxes are replaced with one text box labeled 'Token'.
		cfunction.sync(2);
		msg = "Verify with the Bearer Token radio button selected, the warning remains in place but the other text boxes are replaced with one text box labeled 'Token'";
		try {
			if ((Design.verifyContentType("TOKEN")) && (Design.verifyBlueWarningMsgSettingPageLink())) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Add a token 'abc123'
		cfunction.sync(2);
		msg = "Enter TOKEN value as: testValue";
		try {
			if (Design.enterContentValue("TOKEN", "abc123")) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click the Basic Auth radio button
		cfunction.sync(2);
		msg = "Click the Basic Auth from dropdown: ";
		radioButtonName = "Basic Auth";
		try {
			if (Design.selectRadioButton(radioButtonName)) {
				CommonFunction.logStatus("PASS", msg + radioButtonName);
			} else
				CommonFunction.logStatus("FAIL", msg + radioButtonName);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + radioButtonName);
		}
		// The warning remains in place but the token text box is replaced with two text
		// boxes labeled 'Username' and 'Password'
		cfunction.sync(2);
		msg = "Verify input type of USERNAME is text";
		try {
			if ((Design.verifyContentType("USERNAME")) /*&& (Design.verifyContentType("PASSWORD"))*/
					&& (Design.verifyBlueWarningMsgSettingPageLink())) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Enter a username 'user123' and a password 'pass123'
		cfunction.sync(2);
		msg = "Enter a username 'user123' and a password 'pass123'";
		try {
			if ((Design.enterContentValue("USERNAME", "user123"))
					&& (Design.enterContentValuePassword("PASSWORD", "pass123"))) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click the Digest Auth radio button
		cfunction.sync(2);
		msg = "Click the Digest Auth from drop down: ";
		radioButtonName = "Digest Auth";
		try {
			if (Design.selectRadioButton(radioButtonName)) {
				CommonFunction.logStatus("PASS", msg + radioButtonName);
			} else
				CommonFunction.logStatus("FAIL", msg + radioButtonName);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + radioButtonName);
		}
		// All the same elements are in place as when the Basic Auth button was
		// selected, including the username and password you entered.

		cfunction.sync(2);
		msg = "All the same elements are in place as when the Basic Auth button was selected, including the username and password you entered.";
		try {
			if ((Design.verifyEyeButtonPasswordVisible()) && (Design.verifyContentType("USERNAME"))
					&& (!Design.verifyContentType("PASSWORD"))) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Click the eye-shaped button next to the password
		cfunction.sync(2);
		msg = "Click the eye-shaped button next to the password";
		try {
			Design.clickEyeButton();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// The password is no longer visible.

		cfunction.sync(2);
		msg = "Verify the password is longer visible. ";
		try {
			if (!Design.verifyEyeButtonPasswordVisible()) {
				CommonFunction.logStatus("PASS", msg);
			} else
				CommonFunction.logStatus("FAIL", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		msg = "Click the Federated Token from drop down: ";
		radioButtonName = "Federated Token";
		try {
			if (Design.selectRadioButton(radioButtonName)) {
				CommonFunction.logStatus("PASS", msg + radioButtonName);
			} else
				CommonFunction.logStatus("FAIL", msg + radioButtonName);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + radioButtonName);
		}
		
		msg= "Verify Federated Token's message is coming";
		try {
			
			Design.messageExist(tableName);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		
		// Select 'No Auth', 'API Key', 'Bearer Token', 'Basic Auth', and 'Digest Auth'
		// again.===================================================>
		cfunction.sync(2);
		msg = "Select 'No Auth', 'API Key', 'Bearer Token', 'Basic Auth', 'Digest Auth' and 'Federated Token' again.";
		// String[] radioButtonNameAll = { "No Auth", "API Key", "Bearer Token", "Basic
		// Auth", "Digest Auth" };
		try {
			Design.selectRadioButton("No Auth");
			Design.selectRadioButton("API Key");
			Design.verifyContentType("value");
			Design.selectRadioButton("Bearer Token");
			Design.verifyContentType("TOKEN");
			Design.selectRadioButton("Basic Auth");
			Design.verifyContentType("USERNAME");
			Design.selectRadioButton("Digest Auth");
			Design.verifyContentType("USERNAME");
			Design.selectRadioButton("Federated Token");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Back in your worklfow diagram, click on the Headers tab.
		cfunction.sync(2);
		msg = "Click on the Headers tab: ";
		navigateToTab = "Headers";
		try {
			if (Design.selectNavTab(navigateToTab)) {
				CommonFunction.logStatus("PASS", msg + requestType);
			} else
				CommonFunction.logStatus("FAIL", msg + requestType);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + requestType);
		}
		// The modal will switch over to the Headers tab
		cfunction.sync(2);
		msg = "Validate selected tab name is: ";
		try {
			if (Design.verifyWhichSelectNavTabIsSelected(navigateToTab)) {
				CommonFunction.logStatus("PASS", msg + requestType);
			} else
				CommonFunction.logStatus("FAIL", msg + requestType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Click the Add Key & Value button under custom Headers
		cfunction.sync(2);
		msg = "Click the Add  Key & Value button under custom Headers";
		try {
			Design.clickAddKeyValueOnHeaerTab();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Add a key 'Content-Type' and value application/json
		cfunction.sync(2);
		msg = "Add a key 'Content-Type' and value application/json";
		try {
			Design.inputQueryKey("Content-Type");
			cfunction.sync(2);
			Design.inputQueryValue("application/json");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click on the Body tab
		cfunction.sync(2);
		msg = "Select request tab name type: ";
		navigateToTab = "Body";
		try {
			if (Design.selectNavTab(navigateToTab)) {
				CommonFunction.logStatus("PASS", msg + navigateToTab);
			} else
				CommonFunction.logStatus("FAIL", msg + navigateToTab);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + navigateToTab);
		}

		// The modal will switch over to the body tab. Different options available are
		// None, form Data, URL Encoded, Raw
		cfunction.sync(2);
		msg = "Validate selected tab name is body: ";
		try {
			if (Design.verifyWhichSelectNavTabIsSelected(navigateToTab)) {
				CommonFunction.logStatus("PASS", msg + navigateToTab);
			} else {
				CommonFunction.logStatus("FAIL", msg + navigateToTab);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Select ' Raw' radio button
		cfunction.sync(2);
		msg = "Select ' Raw' radio button: ";
		radioButtonName = "Raw";
		try {
			if (Design.selectRadioButton1(radioButtonName)) {
				CommonFunction.logStatus("PASS", msg + radioButtonName);
			} else
				CommonFunction.logStatus("FAIL", msg + radioButtonName);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + radioButtonName);
		}
		// A big text-box is visible with a content Type drop down
		/*
		 * "In the textbox, enter { ""INPUT"": ""hello world"" }"
		 */
		cfunction.sync(2);
		msg = "Enter JSON body text";
		String textBodyJSON = "{\r\n" + "  \"INPUT\": \"hello world\"\r\n" + "}";
		try {
			Design.inputBodyText(textBodyJSON);
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// Change content type to JSON
		cfunction.sync(2);
		msg = "Click \"Content type\" dropdown";
		try {
			Design.clickAddedToIsDropDown();
			cfunction.sync(2);
			if(browser.equals("Firefox")) {
				if (Design.selectAddedToTypeFromDropDownFirefoxSecond("JSON")) {
					CommonFunction.logStatus("PASS", msg);
				} 
				else
				CommonFunction.logStatus("FAIL", msg);
			}
			else 
			{
				if (Design.selectAddedToTypeFromDropDown("JSON")) {
					CommonFunction.logStatus("PASS", msg);
				} else
					CommonFunction.logStatus("PASS", msg);
				}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click Save
		cfunction.sync(2);
		msg = "Click \"Save\" on config web request tab";
		try {
			Design.clickSaveBtnConfingWebPage();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// The Configure Web Request modal is closed. You will see the request url under
		// Arguments
		cfunction.sync(2);
		msg = "Verify argumented URL as: ";
		try {
			if (Design.verifyArgumentedURL(baseURL + inputAddParameterInURL)) {
				CommonFunction.logStatus("PASS", msg + baseURL + inputAddParameterInURL);
			} else
				CommonFunction.logStatus("FAIL", msg + baseURL + inputAddParameterInURL);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg + baseURL + inputAddParameterInURL);
		}
		// Click Save on the diagram
		cfunction.sync(2);
		msg = "Click \"Save\" on workflow diagram";
		try {
			Design.clickOnSaveWorkFlowDiagram();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// The diagram is saved in draft mode
		cfunction.sync(2);
		msg = "The diagram is saved in draft mode";
		try {
			Design.clickOnBack();
			cfunction.sync(2);
			Design.enterSearchStepTemplate(diagramName1);
			cfunction.sync(8);
			Design.hoverOnTemplateName(diagramName1);
			cfunction.sync(2);
			Design.verifyBannerTitle("Draft - "+diagramName1);
			cfunction.sync(8);
			SikuliHelp.selectLocationOnMapSikuliClick("TS77_Send_Web_Request_1920x1080");
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		// Click Edit on the arguments for Send Web Request step
		cfunction.sync(2);
		msg = "Click on the Edit button next to Arguments";
		try {
			Design.clickEditArgument();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		// The modal opens up with all of the pre-populated values.
		// test1, test2 and test3 are added under path variables
		cfunction.sync(2);
		msg = "Verify path variable count is 3: ";
		try {
			if (Design.countPathVariable() == 3) {
				Design.selectNavTab1("Authorization");
				cfunction.sync(2);
				Design.selectRadioButton("API Key");
				cfunction.sync(2);
				Design.verifyContentType("value");
				cfunction.sync(2);
				Design.selectRadioButton("Bearer Token");
				cfunction.sync(2);
				Design.verifyContentType("TOKEN");
				cfunction.sync(2);
				Design.selectRadioButton("Basic Auth");
				cfunction.sync(2);
				Design.verifyContentType("USERNAME");
				cfunction.sync(2);
				Design.selectRadioButton("Digest Auth");
				cfunction.sync(2);
				Design.verifyContentType("USERNAME");
				CommonFunction.logStatus("PASS", msg);
			} else {
				CommonFunction.logStatus("FAIL", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}
		cfunction.sync(5);
	}

}
