package com.workflowmanager.testcases;

import java.util.HashMap;
import java.util.Map;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.Design;
import com.workflowmanager.pages.HomePage;


public class TS05_URLValidation extends TestBase{

	CommonFunction cfunction = new CommonFunction();
	String msg = "";


	public void workflow_TS5_URLValidation() throws InterruptedException {

		Map<String, String> jobTemplateMap = new HashMap<>();
		Map<String, String> diagramMap = new HashMap<>();
		//initialize maps
		jobTemplateMap.put("Execute GP Service", "AV9LT-bDK6YBHGiLSxzl");
		//diagramMap.put("Create Job Workflow", "AVZX-NbalT052yHTwU5Y");
		diagramMap.put("Data Edits Sample", "AWd1cu3KJLQ4IgUE0i7p");

		CommonFunction.waitforHomePagetoload();
		//Click on Design
		msg = "Click on Design Tab";
		try {
			HomePage.clickOnDesign();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}	
		cfunction.sync(2);

		//select and Validate the URL change
		selectAndValidateUrl(jobTemplateMap);

		cfunction.sync(2);
		//Click on Diagram in left menu
		msg = "Click on Diagram in left menu";
		try {
			Design.clickOnDiagramsIcon();
			CommonFunction.logStatus("PASS", msg);
		} catch (Exception e) {
			e.printStackTrace();
			CommonFunction.logStatus("FAIL", msg);
		}

		//select and Validate the URL change
		selectAndValidateUrl(diagramMap);

	}

	void selectAndValidateUrl(Map<String, String> jobTemplateMap) {
		for(Object name : jobTemplateMap.keySet()) {
			String id = jobTemplateMap.get(name);

			msg = "Click on '" + name + "'";;
			try {
				Design.selectItemFromList(name.toString());
				CommonFunction.logStatus("PASS", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}

			cfunction.sync(2);

			msg = "Validate URL Change, verify the url ends with id '" + id + "'";
			try {
				if(Design.validateUrlChange(id.toString()))
					CommonFunction.logStatus("PASS", msg);
				else
					CommonFunction.logStatus("FAIL", msg);
			} catch (Exception e) {
				e.printStackTrace();
				CommonFunction.logStatus("FAIL", msg);
			}
		}
	}
}
