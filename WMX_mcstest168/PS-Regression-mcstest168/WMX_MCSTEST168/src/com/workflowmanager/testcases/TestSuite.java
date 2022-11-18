package com.workflowmanager.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.workflowmanager.dashboard.DashboardUtil;
import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.TestBase;
import com.workflowmanager.pages.LoginPage;
import com.workflowmanager.util.GeneratetxtResultFile;

public class TestSuite extends TestBase {

	/*
	 * @BeforeTest
	 * 
	 * @Parameters({ "browser" }) public void setUpAutomation(String browser) throws
	 * Exception {
	 * 
	 * setup(browser); // setupzoom(); }
	 */

	ExtentHtmlReporter htmlReporter;

	// Static block that executes before execution begins, used for 'results-body'
	// cleanup
	static {
		String fileBodypath = System.getProperty("user.dir") + "/test-output/ResultFilesforCITool/results-body.txt";
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileBodypath);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Delete old webdriver executables
		String webDriverPath = System.getProperty("user.dir") + "\\Webdriver\\";
		try {
			// executing killDriver.bat
			String[] command = { "cmd.exe", "/C", "Start", System.getProperty("user.dir") + "\\KillDrivers.bat" };
			Process p = Runtime.getRuntime().exec(command);
			cfunction.sync(10);
			System.out.println("Execution KillDrivers.bat is complete");
			File dir = new File(webDriverPath);
			FileUtils.cleanDirectory(dir);
			System.out.println("Old executable deleted");
		} catch (IOException e) {
			e.printStackTrace();
		}

		String fileBodypathSubject = System.getProperty("user.dir")
				+ "/test-output/ResultFilesforCITool/results-subject.txt";
		PrintWriter writerSubject;
		try {
			writerSubject = new PrintWriter(fileBodypathSubject);
			writerSubject.print("");
			writerSubject.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Delete the screenshots in latest/screenshots folder
		String screenshotpath = System.getProperty("user.dir") + "/test-output/ExtentReports/Latest/Screenshot";
		//String screenshotpathArchive = System.getProperty("user.dir") + "/test-output/ExtentReports/Archive/Screenshot";
		try {
			File dir = new File(screenshotpath);
			//File arcdir = new File(screenshotpathArchive);
			//FileUtils.copyFile(dir, arcdir);
			FileUtils.cleanDirectory(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Delete the html files in latest folder
		File folder = new File(System.getProperty("user.dir") + "/test-output/ExtentReports/Latest");
		File[] files = folder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (!f.isDirectory()) {
					f.delete();
				}
			}
		}
	}

	@BeforeTest(groups = { "CHROME", "FIREFOX", "IE", "EDGE", "TEST" })
	@Parameters({ "platform", "browser", "version", "url" })
	public void SetUpAutomation(String platform, String browser, String version, String url) throws Exception {
		// Extent Report setup function
		System.out.println("Setup Extent Report");
		TestBase.extentReportSetup(platform, browser, version, url);
	}

	@BeforeMethod(groups = { "CHROME", "FIREFOX", "IE", "EDGE", "TEST" })
	@Parameters({ "platform", "browser", "version", "url" })
	public void setUpMethod(String platform, String browser, String version, String url) throws Exception {
		// TestBase.extentReportSetup(platform, browser, version);
		// Automation test execution setup function
		TestBase.setup(platform, browser, version);

		// code for getting dynamic browser version
		if (logbrowserversion) {
			System.out.println("calling dynamic extentReportbrowserversionSetup()");
			TestBase.extentReportbrowserversionSetup();
			logbrowserversion = false;
		}

		// Open URL
		driver.get(url);

		// Wait for page to load
		CommonFunction.waitforpagetoload();

		// Reset the step Count before each test case
		resetStepCount();
	}

	//@Test(priority = 23, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS01_CreateNewJob(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS01_CreateNewJob ts1 = new TS01_CreateNewJob();
		ts1.workflow_TS1_CreateNewJob();
	}

	//@Test(priority = 2, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS02_EditDiagram(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS02_EditDiagram ts2 = new TS02_EditDiagram();
		ts2.workflow_TS2_EditDiagram();
	}

	@Test(priority = 3, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS03_SignIn(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		TS03_SignIn ts3 = new TS03_SignIn();
		ts3.workflow_TS3_SignIn();
	}

	//@Test(priority = 4, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS04_JobTemplateCreation(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS04_JobTemplateCreation ts4 = new TS04_JobTemplateCreation();
		ts4.workflow_TS4_JobTemplateCreation();
		;
	}

	//@Test(priority = 5, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS05_URLValidation(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS05_URLValidation ts5 = new TS05_URLValidation();
		ts5.workflow_TS5_URLValidation();
	}

	@Test(priority = 6, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS06_ViewJobDetails(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS06_ViewJobDetails ts6 = new TS06_ViewJobDetails();
		ts6.workflow_TS6_ViewJobDetails();
		;
	}

	@Test(priority = 7, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS07_JobTemplateSearchTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS07_JobTemplateSearchTest ts7 = new TS07_JobTemplateSearchTest();
		ts7.workflow_TS7_JobTemplateSearchTest();
		;
	}

	@Test(priority = 60, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS08_JobSearchTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS08_JobSearchTest ts8 = new TS08_JobSearchTest();
		ts8.workflow_TS8_JobSearchTest();
		;
	}

	//@Test(priority = 9, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS09_DiagramSearchTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS09_DiagramSearchTest ts9 = new TS09_DiagramSearchTest();
		ts9.workflow_TS9_DiagramSearchTest();
		;
	}

	@Test(priority = 2, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS10_SummaryChartsTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS10_SummaryChartsTest ts10 = new TS10_SummaryChartsTest();
		ts10.workflow_TS10_SummaryChartsTest();
	}

	//@Test(priority = 11, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS11_DesignOverwriteStep(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS11_DesignOverwriteStep ts11 = new TS11_DesignOverwriteStep();
		ts11.workflow_TS11_DesignOverwriteStep();
	}

	//@Test(priority = 12, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS12_DesginPageJobTemplateSearch(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS12_DesignPageJobTemplateSearch ts12 = new TS12_DesignPageJobTemplateSearch();
		ts12.workflow_TS12_DesignPageJobTemplateSearch();
	}

	//@Test(priority = 13, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS13_DiagramToolbarTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS13_DiagramToolbarTest ts13 = new TS13_DiagramToolbarTest();
		ts13.workflow_TS13_DiagramToolbarTest();
	}

	//@Test(priority = 14, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS14_StepStylingTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS14_StepStylingTest ts14 = new TS14_StepStylingTest();
		ts14.workflow_TS14_StepStylingTest();
	}

	//@Test(priority = 15, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS15_ManualStepConfigTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS15_ManualStepConfigTest ts15 = new TS15_ManualStepConfigTest();
		ts15.workflow_TS15_ManualStepConfigTest();
	}

	//@Test(priority = 16, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void WorkflowManager_TS16_CreateExtendedProperties(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS16_CreateExtendedProperties ts16 = new TS16_CreateExtendedProperties();
		ts16.workflow_TS16_CreateExtendedProperties();
	}

	@Test(priority = 17, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS17_CustomJobSearch(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS17_CustomJobSearch ts17 = new TS17_CustomJobSearch();
		ts17.workflow_TS17_CustomJobSearch();
	}

	//@Test(priority = 18, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS18_QuestionStepConfig_Test(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS18_QuestionStepConfig_Test ts18 = new TS18_QuestionStepConfig_Test();
		ts18.workflow_TS18_QuestionStepConfig_Test();
	}

	@Test(priority = 19, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS19_CoordinateCustomSearch_Test(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS19_CoordinateCustomSearch_Test ts19 = new TS19_CoordinateCustomSearch_Test();
		ts19.workflow_TS19_CoordinateCustomSearch_Test();
	}

	//@Test(priority = 20, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS20_SendEmailStepConfig(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS20_SendEmailStepConfig ts20 = new TS20_SendEmailStepConfig();
		ts20.workflow_TS20_SendEmailStepConfig();
	}

	//@Test(priority = 21, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS21_DeleteJobTemplate(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS21_DeleteJobTemplate ts21 = new TS21_DeleteJobTemplate();
		ts21.workflow_TS21_DeleteJobTemplateSuccess();
		ts21.workflow_TS21_DeleteJobTemplateFail();
	}

	//@Test(priority = 22, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS22_UpdateExtendedProperties(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS22_UpdateExtendedProperties ts22 = new TS22_UpdateExtendedProperties();
		ts22.workflow_TS22_UpdateExtendedProperties();

	}

	@Test(priority = 1, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS23_AssignToSelf(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS23_AssignToSelf ts23 = new TS23_AssignToSelf();
		ts23.workflow_TS23_AssignToSelf();

	}

	//@Test(priority = 24, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS24_CreateDiagram_Test(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS24_CreateDiagram_Test ts24 = new TS24_CreateDiagram_Test();
		ts24.workflow_TS24_CreateDiagram();

	}

	//@Test(priority = 25, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS25_CreateJobTemplate_Test(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS25_CreateJobTemplate_Test ts25 = new TS25_CreateJobTemplate_Test();
		ts25.workflow_TS25_CreateJobTemplate();

	}

	//@Test(priority = 26, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS26_GPStepConfig_Test(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS26_GPStepConfig_Test ts26 = new TS26_GPStepConfig_Test();
		ts26.workflow_TS26_GPStepConfig_Test();
	}

	//@Test(priority = 27, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS27_DeleteDiagram_Test(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS27_DeleteDiagram_Test ts27 = new TS27_DeleteDiagram_Test();
		ts27.workflow_TS27_DeleteDiagramSuccess();
		ts27.workflow_TS27_DeleteDiagramFail();
	}

	@Test(priority = 28, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS28_WorkPageDismissMessage(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
		TS28_WorkPageDismissMessage ts28 = new TS28_WorkPageDismissMessage();
		ts28.workflow_TS28_WorkPageDismissMessage();
	}

	@Test(priority = 29, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS29_WorkPageUpdateJobExtendedProperties(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS29_WorkPageUpdateJobExtendedProperties ts29 = new TS29_WorkPageUpdateJobExtendedProperties();
		ts29.workflow_TS29_WorkPageUpdateJobExtendedProperties();
	}

	@Test(priority = 30, groups = { "CHROME", "WEB"  })
	@Parameters({ "browser" })
	public void WorkflowManager_TS30_CoordinarePageUpdateJobExtendedProperties(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS30_CoordinatePageUpdateJobExtendedProperties ts30 = new TS30_CoordinatePageUpdateJobExtendedProperties();
		ts30.workflow_TS30_CoordinatePageUpdateJobExtendedProperties();
	}

	/*
	 * @Test(priority = 100,groups = { "CHROME", "WEB" })
	 * 
	 * @Parameters({ "browser"}) public void DataReloader(String browser) throws
	 * InterruptedException, IOException { CommonFunction.setUpTest(); //LoginPage
	 * lp = new LoginPage(); //lp.loginToApplication(xls.getCellData("en-us",2, 2),
	 * xls.getCellData("en-us", 3,2)); DataReloader DR = new DataReloader();
	 * DR.DataReloadingProcess(); DR.DataReloadingProcess1(); }
	 */
	@Test(priority = 31, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS31_WorkPageCreateJob(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS31_WorkPageCreateJob ts31 = new TS31_WorkPageCreateJob();
		ts31.workflow_TS31_WorkPageCreateJob();
	}

	//@Test(priority = 32, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS32_DesignPageCreateVersionStepConfig(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS32_DesignPageCreateVersionStepConfig ts32 = new TS32_DesignPageCreateVersionStepConfig();
		ts32.workflow_TS32_DesignPageCreateVersionStepConfig();
	}

	//@Test(priority = 33, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS33_DesignPageAddAttachmentStepConfiguration(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS33_DesignPageAddAttachmentStepConfiguration ts33 = new TS33_DesignPageAddAttachmentStepConfiguration();
		ts33.workflow_TS33_DesignPageAddAttachmentStepConfiguration();
	}

	@Test(priority = 34, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS34_CoordinatePageViewJobDetailsPanel(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
		TS34_CoordinatePageViewJobDetailsPanel ts34 = new TS34_CoordinatePageViewJobDetailsPanel();
		ts34.workflow_TS34_CoordinatePageViewJobDetailsPanel();
	}

	//@Test(priority = 35, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS35_DesignPageDefineLocationConfig(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS35_DesignPageDefineLocationConfig ts35 = new TS35_DesignPageDefineLocationConfig();
		ts35.workflow_TS35_DesignPageDefineLocationConfig();
	}

	@Test(priority = 36, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS36_WorkPageViewJobDetails(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
		TS36_WorkPageViewJobDetails ts36 = new TS36_WorkPageViewJobDetails();
		ts36.workflow_TS36_WorkPageViewJobDetails();
	}

	//@Test(priority = 37, groups = { "CHROME", "WEB"  })
	@Parameters({ "browser" })
	public void WorkflowManager_TS37_View_EditDomainExtendedPropertiesInJobDetailsPanel(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS37_View_EditDomainExtendedPropertiesInJobDetailsPanel ts37 = new TS37_View_EditDomainExtendedPropertiesInJobDetailsPanel();
		ts37.workflow_TS37_View_EditDomainExtendedPropertiesInJobDetailsPanel();
	}

	@Test(priority = 38, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS38_WorkPageDeleteJob_test(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS38_WorkPageDeleteJob_test ts38 = new TS38_WorkPageDeleteJob_test();
		ts38.workflow_TS38_WorkPageDeleteJob_test();
	}

	//@Test(priority = 39, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS39_SettingManageRolesPrivileges(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS39_SettingManageRolesPrivileges ts39 = new TS39_SettingManageRolesPrivileges();
		ts39.workflow_TS39_SettingManageRolesPrivileges();
	}

	@Test(priority = 40, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS40_WorkPageSearchQueryDisplayNames(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS40_WorkPageSearchQueryDisplayNames ts40 = new TS40_WorkPageSearchQueryDisplayNames();
		ts40.workflow_TS40_WorkPageSearchQueryDisplayNames();
	}

	//@Test(priority = 41, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS41_UpdateDomainExtendedPropertiesJobTemplate(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS41_UpdateDomainExtendedPropertiesJobTemplate ts41 = new TS41_UpdateDomainExtendedPropertiesJobTemplate();
		ts41.workflow_TS41_UpdateDomainExtendedPropertiesJobTemplate();
	}

	//@Test(priority = 42, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS42_SettingsPageViewVisibilityPrivileges(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS42_SettingsPageViewVisibilityPrivileges ts42 = new TS42_SettingsPageViewVisibilityPrivileges();
		ts42.workflow_TS42_SettingsPageViewVisibilityPrivileges();
	}

	// @Test(priority = 43,groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS43_RunUpdateJobPropertiesTest(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS43_RunUpdateJobPropertiesTest ts43 = new TS43_RunUpdateJobPropertiesTest();
		ts43.workflow_TS43_RunUpdateJobPropertiesTest();
	}

	//@Test(priority = 57, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void WorkflowManager_TS44_ArcadeExpressionsPathInWorkflowDiagram(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS44_ArcadeExpressionsPathInWorkflowDiagram ts44 = new TS44_ArcadeExpressionsPathInWorkflowDiagram();
		ts44.workflow_TS44_ArcadeExpressionsPathInWorkflowDiagram();
	}

	@Test(priority = 45, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS45_RedirectUrls(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS45_RedirectUrls ts45 = new TS45_RedirectUrls();
		ts45.workflow_TS45_RedirectUrls();
	}

	//@Test(priority = 46, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS46_ConfigAndRunningManualStep(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS46_ConfigAndRunningManualStep ts46 = new TS46_ConfigAndRunningManualStep();
		ts46.workflow_TS46_ConfigAndRunningManualStep();
	}

	//@Test(priority = 47, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS47_DesignPageUpgradeJob(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS47_DesignPageUpgradeJob ts47 = new TS47_DesignPageUpgradeJob();
		ts47.workflow_TS47_DesignPageUpgradeJob();
	}

	@Test(priority = 48, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS48_CreateWorkflowItem(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication1(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
		TS48_CreateWorkflowItem ts48 = new TS48_CreateWorkflowItem();
		ts48.workflow_TS48_CreateWorkflowItem();
	}

	//@Test(priority = 51, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS49_ShareJobTemplate(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS49_ShareJobTemplate ts49 = new TS49_ShareJobTemplate();
		ts49.workflow_TS49_ShareJobTemplate();
	}

	@Test(priority = 49, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS50_LicesnseCheck(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		TS50_LicesnseCheck ts50 = new TS50_LicesnseCheck();
		ts50.workflow_TS50_LicesnseCheck();
	}

	@Test(priority = 50, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS51_PermissionCheck(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		TS51_PermissionCheck ts51 = new TS51_PermissionCheck();
		ts51.workflow_TS51_PermissionCheck();
	}

	@Test(priority = 52, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS52_UpdateJobPropertiesStepWithFieldLengthLimit(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS52_UpdateJobPropertiesStepWithFieldLengthLimit ts52 = new TS52_UpdateJobPropertiesStepWithFieldLengthLimit();
		ts52.workflow_TS52_UpdateJobPropertiesStepWithFieldLengthLimit();
	}

	@Test(priority = 53, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS53_Work_Page_Manage_attachment_step1(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
		TS53_Work_Page_Manage_attachment_step1 ts53 = new TS53_Work_Page_Manage_attachment_step1();
		ts53.workflow_TS53_Work_Page_Manage_attachment_step1();
	}

	@Test(priority = 54, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS54_Work_Page_Manage_attachment_step2(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
		TS54_Work_Page_Manage_attachment_step2 ts54 = new TS54_Work_Page_Manage_attachment_step2();
		ts54.workflow_TS54_Work_Page_Manage_attachment_step2();
	}

	//@Test(priority = 55, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS55_Create_Display_Shared_Search(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS55_Create_Display_Shared_Search ts54 = new TS55_Create_Display_Shared_Search();
		ts54.workflow_TS55_Create_Shared_Search();
	}

	//@Test(priority = 56, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS56_PrintDiagram(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS56_PrintDiagram ts56 = new TS56_PrintDiagram();
		ts56.workflow_TS56_PrintDiagram();
	}

	@Test(priority = 44, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS57_ManualStepWorkflowTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS57_ManualStepWorkflowTest ts57 = new TS57_ManualStepWorkflowTest();
		ts57.workflow_TS57_ManualStepWorkflowTest();
	}

	@Test(priority = 58, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS58_WorkPage_RunOpenAppTest(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS58_WorkPage_RunOpenAppTest ts58 = new TS58_WorkPage_RunOpenAppTest();
		ts58.workflow_TS58_WorkPage_RunOpenAppTest();
	}

	@Test(priority = 59, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void WorkflowManager_TS59_ManagePageSummaryChartsAndFilters(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
		TS59_ManagePageSummaryChartsAndFilters ts59 = new TS59_ManagePageSummaryChartsAndFilters();
		ts59.workflow_TS59_ManagePageSummaryChartsAndFilters();
	}

	//@Test(priority = 60, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS60_DesignPageProGpStepConfiguration(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS60_DesignPageProGpStepConfiguration ts60 = new TS60_DesignPageProGpStepConfiguration();
		ts60.workflow_TS60_DesignPageProGpStepConfiguration();
	}

	@Test(priority = 61, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS61_WorkPageSetCurrentStepTest(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 12), xls.getCellData("en-us", 3, 12));
		TS61_WorkPageSetCurrentStepTest ts61 = new TS61_WorkPageSetCurrentStepTest();
		ts61.workflow_TS61_WorkPageSetCurrentStepTest();
	}

	//@Test(priority = 62, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS62_SettingSaveChart(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS62_SettingSaveChart ts62 = new TS62_SettingSaveChart();
		ts62.workflow_TS62_SettingSaveChart();
	}

	@Test(priority = 63, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void WorkflowManager_TS63_ManagePageURL_Parameters(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS63_ManagePageURL_Parameters ts63 = new TS63_ManagePageURL_Parameters();
		ts63.workflow_TS63_ManagePageURL_Parameters();
	}

	@Test(priority = 64, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS64_WorkPageAutoExecutionAtJobCreation(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS64_WorkPageAutoExecutionAtJobCreation ts64 = new TS64_WorkPageAutoExecutionAtJobCreation();
		ts64.workflow_TS64_WorkPageAutoExecutionAtJobCreation();
	}

	@Test(priority = 65, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void WorkflowManager_TS65_WorkPageRunProMappingStep(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS65_WorkPageRunProMappingStep ts65 = new TS65_WorkPageRunProMappingStep();
		ts65.workflow_TS65_WorkPageRunProMappingStep();
	}

	@Test(priority = 66, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS66_WorkPage_RunGPServiceStepWithVisibleParameters(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS66_WorkPage_RunGPServiceStepWithVisibleParameters ts66 = new TS66_WorkPage_RunGPServiceStepWithVisibleParameters();
		ts66.workflow_TS66_WorkPage_RunGPServiceStepWithVisibleParameters();
	}

	//@Test(priority = 67, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void WorkflowManager_TS67_Add_Attachment_step_Linked(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS67_Add_Attachment_step_Linked ts67 = new TS67_Add_Attachment_step_Linked();
		ts67.workflow_TS67_Add_Attachment_step_Linked();
	}

	//@Test(priority = 68, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS68_DesignPage_OpenWebAppBrowser(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS68_DesignPage_OpenWebAppBrowser ts68 = new TS68_DesignPage_OpenWebAppBrowser();
		ts68.workflow_TS68_DesignPage_OpenWebAppBrowser();
	}

	@Test(priority = 69, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS69_ConfigureCustomMapAsBaseMap(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		// lp.loginToApplication(xls.getCellData("en-us",2, 2), xls.getCellData("en-us",
		// 3,2));
		TS69_ConfigureCustomMapAsBaseMap ts68 = new TS69_ConfigureCustomMapAsBaseMap();
		ts68.workflow_TS69_ConfigureCustomMapAsBaseMap();
	}

	/*@Test(priority = 70, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS70_DesignPage_EmailTemplate(String browser) throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS70_DesignPage_EmailTemplate ts70 = new TS70_DesignPage_EmailTemplate();
		ts70.workflow_TS70_DesignPage_EmailTemplate();
	}

	@Test(priority = 71, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void WorkflowManager_TS71_DesignPage_StepSchedulingConfigurationTest_1(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS71_DesignPage_StepSchedulingConfigurationTest_1 ts71 = new TS71_DesignPage_StepSchedulingConfigurationTest_1();
		ts71.workflow_TS71_DesignPage_StepSchedulingConfigurationTest_1();
	}

	@Test(priority = 72, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS72_DesignPage_StepSchedulingConfigurationTest_2(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS72_DesignPage_StepSchedulingConfigurationTest_2 ts72 = new TS72_DesignPage_StepSchedulingConfigurationTest_2();
		ts72.workflow_TS72_DesignPage_StepSchedulingConfigurationTest_2();
	}

	@Test(priority = 73, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS73_DesignPage_StepSchedulingConfigurationTest_3(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS73_DesignPage_StepSchedulingConfigurationTest_3 ts73 = new TS73_DesignPage_StepSchedulingConfigurationTest_3();
		ts73.workflow_TS73_DesignPage_StepSchedulingConfigurationTest_3();
	}

	@Test(priority = 74, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS74_DesignPage_StepSchedulingConfigurationTest_4(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS74_DesignPage_StepSchedulingConfigurationTest_4 ts74 = new TS74_DesignPage_StepSchedulingConfigurationTest_4();
		ts74.workflow_TS74_DesignPage_StepSchedulingConfigurationTest_4();
	}

	@Test(priority = 75, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS75_DesignPage_StepSchedulingConfigurationTest_5(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS75_DesignPage_StepSchedulingConfigurationTest_5 ts75 = new TS75_DesignPage_StepSchedulingConfigurationTest_5();
		ts75.workflow_TS75_DesignPage_StepSchedulingConfigurationTest_5();
	}

	@Test(priority = 76, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS76_DesignPage_StepSchedulingConfigurationTest_6(String browser)
			throws InterruptedException, IOException {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS76_DesignPage_StepSchedulingConfigurationTest_6 ts76 = new TS76_DesignPage_StepSchedulingConfigurationTest_6();
		ts76.workflow_TS76_DesignPage_StepSchedulingConfigurationTest_6();
	}

	@Test(priority = 77, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void workflowManager_TS77_DesignPage_Send_Web_Request_step_configuration(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS77_DesignPage_Send_Web_Request_step_configuration ts77 = new TS77_DesignPage_Send_Web_Request_step_configuration();
		ts77.workflow_TS77_DesignPage_Send_Web_Request_step_configuration();
	}

	@Test(priority = 78, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void workflowManager_TS78_DesignPage_ConfigureDefineLocationStepWithArcade(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS78_DesignPage_ConfigureDefineLocationStepWithArcade ts78 = new TS78_DesignPage_ConfigureDefineLocationStepWithArcade();
		ts78.workflow_TS78_DesignPage_ConfigureDefineLocationStepWithArcade();
	}

	@Test(priority = 79, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS79_DesignPage_CreateAndUpdateAutomatedActionsJobTemplate(String browser)
			throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS79_DesignPage_CreateAndUpdateAutomatedActionsJobTemplate ts78 = new TS79_DesignPage_CreateAndUpdateAutomatedActionsJobTemplate();
		ts78.workflow_TS79_DesignPage_CreateAndUpdateAutomatedActionsJobTemplate();
	}
*/
	@Test(priority = 80, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS80_ManagePagePopupAndZoom(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS80_ManagePagePopupAndZoom ts78 = new TS80_ManagePagePopupAndZoom();
		ts78.workflow_TS80_ManagePagePopupAndZoom();
	}

	@Test(priority = 81, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void workflowManager_TS81_JobDetailNote(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS81_JobDetailNote ts78 = new TS81_JobDetailNote();
		ts78.workflow_TS81_JobDetailNote();
	}

	//@Test(priority = 82, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS82_JobTemplateWebhookConfiguration(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS82_JobTemplateWebhookConfiguration ts80 = new TS82_JobTemplateWebhookConfiguration();
		ts80.workflow_TS82_JobTemplateWebhookConfiguration();
	}

	//@Test(priority = 83, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS83_Survey123Test_step(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS83_Survey123Test_step ts81 = new TS83_Survey123Test_step();
		ts81.workflow_TS83_Survey123Test_step();
	}

	@Test(priority = 84, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS84_Step_Prompt_HelpArcade(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS84_Step_Prompt_HelpArcade ts82 = new TS84_Step_Prompt_HelpArcade();
		ts82.workflow_TS84_Step_Prompt_HelpArcade();
	}

	//@Test(priority = 85, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS85_Duplicate_Job_Template(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS85_Duplicate_Job_Template ts83 = new TS85_Duplicate_Job_Template();
		ts83.workflow_TS85_Duplicate_Job_Template();
	}

	@Test(priority = 86, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS86_CommentsJobPanel(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS86_CommentsJobPanel ts83 = new TS86_CommentsJobPanel();
		ts83.workflow_TS86_CommentsJobPanel();
	}

	@Test(priority = 87, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void workflowManager_TS87_AutoUpdateJobPanel(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS87_AutoUpdateJobPanel ts83 = new TS87_AutoUpdateJobPanel();
		ts83.workflow_TS87_AutoUpdateJobPanel();
	}
	@Test(priority = 88, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void workflowManager_TS102_AutoUpdateJobPanel_Step2(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS102_AutoUpdateJobPanel_Step2 ts83 = new TS102_AutoUpdateJobPanel_Step2();
		ts83.workflow_TS102_AutoUpdateJobPanel_Step2();
	}

	//@Test(priority = 89, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS88_UserDefinedSettings_Selenium(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS88_UserDefinedSettings_Selenium ts88 = new TS88_UserDefinedSettings_Selenium();
		ts88.workflowManager_UserDefinedSettings_Selenium();
	}

	//@Test(priority = 90, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void workflowManager_TS89_ArcadeMenusSeleniumTestCase(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS89_ArcadeMenusSeleniumTestCase ts89 = new TS89_ArcadeMenusSeleniumTestCase();
		ts89.workflowManager_ArcadeMenusSeleniumTestCase();
	}

	/*
	 * @Test(priority = 90, groups = { "CHROME", "WEB", "TEST" })
	 * 
	 * @Parameters({ "browser" }) public void
	 * workflowManager_TS90_DesignPageConfigStepComments(String browser) throws
	 * Exception { CommonFunction.setUpTest(); LoginPage lp = new LoginPage();
	 * lp.loginToApplication(xls.getCellData("en-us", 2, 2),xls.getCellData("en-us",
	 * 3, 2)); TS90_DesignPageConfigStepComments ts90 = new
	 * TS90_DesignPageConfigStepComments();
	 * ts90.workflow_TS90_DesignPageConfigStepComments(); }
	 * 
	 * @Test(priority = 91, groups = { "CHROME", "WEB" ,"TEST" })
	 * 
	 * @Parameters({ "browser" }) public void
	 * workflowManager_TS91_DefineLocationMapSearch_TestCase(String browser) throws
	 * Exception { CommonFunction.setUpTest(); LoginPage lp = new LoginPage();
	 * lp.loginToApplication(xls.getCellData("en-us", 2, 2),
	 * xls.getCellData("en-us", 3, 2)); TS91_DefineLocationMapSearch_TestCase ts91 =
	 * new TS91_DefineLocationMapSearch_TestCase();
	 * ts91.workflowManager_DefineLocationMapSearch_TestCase(); }
	 */
	@Test(priority = 93, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS92_AddUpdateAttachment(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS92_AddUpdateAttachment ts92 = new TS92_AddUpdateAttachment();
		ts92.workflow_TS92_AddUpdateAttachment();
	}

	//@Test(priority = 94, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS93_Job_SchedulingTest(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS93_Job_SchedulingTest ts93 = new TS93_Job_SchedulingTest();
		ts93.workflow_TS93_Job_SchedulingTest();
	}

	@Test(priority = 95, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS94_WorkPage_RunQuestionTest(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS94_WorkPage_RunQuestionTest ts94 = new TS94_WorkPage_RunQuestionTest();
		ts94.workflow_TS94_WorkPage_RunQuestionTest();
	}

	@Test(priority = 96, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS95_UpdatePropertiesstep_UpdatePriorityand_Status(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS95_UpdatePropertiesstep_UpdatePriorityand_Status ts95 = new TS95_UpdatePropertiesstep_UpdatePriorityand_Status();
		ts95.workflow_TS95_UpdatePropertiesstep_UpdatePriorityand_Status();
	}

	@Test(priority = 97, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void WorkflowManager_TS96_SortByDisplayFields(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS96_SortByDisplayFields ts97 = new TS96_SortByDisplayFields();
		ts97.workflowManager_SortByDisplayFields_TestCase();
	}

	//@Test(priority = 98, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS97_Arcade_PathandForce_Group_Assignment(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS97_Arcade_PathandForce_Group_Assignment ts97 = new TS97_Arcade_PathandForce_Group_Assignment();
		ts97.workflow_TS97_Arcade_PathandForce_Group_Assignment();
	}

	@Test(priority = 99, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS98_LandingPage_Functionality(String browser) throws Exception {
		CommonFunction.setUpTest();
		/*
		 * LoginPage lp = new LoginPage();
		 * lp.loginToApplication(xls.getCellData("en-us", 2, 2),
		 * xls.getCellData("en-us", 3, 2));
		 */
		TS98_LandingPage_Functionality ts98 = new TS98_LandingPage_Functionality();
		ts98.workflow_TS98_LandingPage_Functionality();
	}

	@Test(priority = 100, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS99_NavigateTo_ItemSelection_Page(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS99_NavigateTo_ItemSelection_Page ts99 = new TS99_NavigateTo_ItemSelection_Page();
		ts99.workflow_TS99_NavigateTo_ItemSelection_Page();
	}

	//@Test(priority = 101, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS100_DuplicateDiagram(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS100_DuplicateDiagram ts100 = new TS100_DuplicateDiagram();
		ts100.workflow_TS100_DuplicateDiagram();
	}

	@Test(priority = 102, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void workflowManager_TS101_JobPanel_JobCardReceivesUpdateMessages(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS101_JobPanel_JobCardReceivesUpdateMessages ts101 = new TS101_JobPanel_JobCardReceivesUpdateMessages();
		ts101.workflow_TS101_JobPanel_JobCardReceivesUpdateMessages();
	}
	
	@Test(priority = 103, groups = { "CHROME","WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TC103_SetJobVersion(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TC103_SetJobVersion ts103 = new TC103_SetJobVersion();
		ts103.workflow_TC103_SetJobVersion();
	}
	@Test(priority = 104, groups = { "CHROME", "WEB"})
	@Parameters({ "browser" })
	public void workflowManager_TC104_LookupTabels(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TC104_LookupTables ts100 = new TC104_LookupTables();
		ts100.workflowManager_TC104_LookupTabels();
	}
	
	@Test(priority = 105, groups = { "CHROME", "WEB", "TEST" })
	@Parameters({ "browser" })
	public void workflowManager_TS105_WorkPage_JobHistory(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS105_WorkPage_JobHistory ts105 = new TS105_WorkPage_JobHistory();
		ts105.workflow_TS105_JobHistory();
	}
	@Test(priority = 106, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TS106_JobPanelDiagramUIUpdate(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TS106_JobPanelDiagramUIUpdate ts106 = new TS106_JobPanelDiagramUIUpdate();
		ts106.workflow_TS106_JobPanelDaigramUIUpdate();
	}
	@Test(priority = 107, groups = { "CHROME", "WEB" })
	@Parameters({ "browser" })
	public void workflowManager_TC107_CreateVersionErrorMessages2(String browser) throws Exception {
		CommonFunction.setUpTest();
		LoginPage lp = new LoginPage();
		lp.loginToApplication(xls.getCellData("en-us", 2, 2), xls.getCellData("en-us", 3, 2));
		TC107_CreateVersionErrorMessages2 ts107 = new TC107_CreateVersionErrorMessages2();
		ts107.workflowManager_TC107_CreateVersionErrorMessages2();
	}
	

	@AfterMethod(groups = { "CHROME", "FIREFOX", "IE", "EDGE", "TEST" })
	public void getResult(ITestResult result) throws IOException {
		String msg = "";
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				// MarkupHelper is used to display the output in different colors

				String temp = TestBase.getScreenshot(driver);

				logger.fail(result.getThrowable().getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

				msg = result.getName() + " - Test Case Failed";
				CommonFunction.logStatus("FAIL", msg);

				msg = result.getThrowable() + " - Test Case Failed";
				CommonFunction.logStatus("FAIL", msg);

			} else if (result.getStatus() == ITestResult.SKIP) {
				msg = result.getName();
				CommonFunction.logStatus("SKIP", msg);
			}
			extent.flush();
			// driver.quit();
			System.out.println("Closing chrome browser after every test");
			driver.close();
			// extent.flush();
			softAssert.assertAll();

			// GeneratetxtResultFile.generatetxtResultFileforCITool(extentReportFilePath);
			// driver.quit();
			// GeneratetxtResultFile.generatetxtResultFileforCITool(extentReportFilePath);
		} catch (IOException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest(groups = { "CHROME", "FIREFOX", "IE", "EDGE", "TEST" })
	public void endReport() throws IOException {
		try {
			// GeneratetxtResultFile.generatetxtResultFileforCITool(extentReportFilePath_BrowserNameOnly);
			extent.flush();
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @AfterClass
	public void tearDown() {
		System.out.println("After Class");
		if (driver != null) {
			System.out.println("Closing browser");
			driver.close();
			driver.quit();

		}
	}

	@AfterSuite(alwaysRun = true, groups = { "CHROME", "FIREFOX", "IE", "EDGE", "TEST" })
	@Parameters({ "browser" })
	public void finishAll(String platform) throws Exception {
		System.out.println("After SUITE");
		try {
			GeneratetxtResultFile.generatetxtResultFileforCITool(extentReportFilePath_BrowserNameOnly);
			// Dashboard: save the test result in the dashboard Database
			// DashboardUtil.saveTestResultforDashboard();
			String dashboard = System.getProperty("dashboard");
			if (dashboard == null) {
				postToDashboard = false;
			}
			if (postToDashboard)
				DashboardUtil.saveTestResultforDashboard();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("quit");
		// driver.close();
		// driver.quit();
		driver.close();
		driver.quit();
		// closedriverinstance(browser,platform);
		System.out.println("close");
	}

}
