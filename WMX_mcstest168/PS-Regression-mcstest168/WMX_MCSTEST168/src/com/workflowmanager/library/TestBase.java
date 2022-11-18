package com.workflowmanager.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
//import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.natives.SysUtil;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.workflowmanager.dashboard.DashboardUtil;
import com.workflowmanager.dashboard.TestResultRequest;
import com.workflowmanager.datasource.Xls_Reader;
import com.workflowmanager.pages.HomePage;
import com.workflowmanager.powershell.Powershell;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public static CommonFunction cfunction = new CommonFunction();
	public boolean postToDashboard = true;
	public static String jobTemplateName="JOB TEMPLATE NAME_2022_01_04_0207";
	//public static String jobTemplateName3=cfunction.getUniqueName("CREATE_EXTENDED_PROPERTY");
	//public static String jobTemplateName = cfunction.getUniqueName("JOB TEMPLATE NAME");
	public static String DiagramName = cfunction.getUniqueName("Path arcade test");
	public static String jobTemplateName1 = cfunction.getUniqueName("Domain Extended Prop");
	//public static String jobTemplateName1="Domain Extended Prop_2021_10_07_0003";
	public static String tableName = cfunction.getUniqueName("table");
	public static String diagramName1 = cfunction.getUniqueName("Send Web Request");
	public static String tableAlias = tableName.replace("Table_", "Table ");
	//public static String itemID = "f70d55b12d974d968d78b7dd231c5afe";
	//public static String itemID = "2622166c9ccf46b9812f117dee07b8c9";
	
		  //public void main(String[] args) {
	//public static HomePage hp = new HomePage();

	//public final static  String itemID = hp.fetchItemID();	
	//public static String itemID = "e0f0e0e5dbd34975adb31f903459c744";
	public static String buildNo;
	public static String itemIdName="workflow";
	//public static String landingPageURL = "https://mcstest62.esri.com/portal/apps/workflowmanager/"+itemID+"/manage?content=0&leftPanel=false&rightPanel=true&queryId=L46soUSzRD62LqwFvp5pVQ";
	public static int extendedPropIndex = 1;
	public static String jobTemplateName2 = cfunction.getUniqueName("Automate Job Template");
	public static String propName = "Prop" + extendedPropIndex;
	public static String propAlias = "Property " + extendedPropIndex;
	public static String jobName="";
	public static String[][] extendedProperties = new String[4][];
	public static String workflowDiagramName = cfunction.getUniqueName("Sample Diagram");
	//public static String diagramName=cfunction.getUniqueName("TEST_DIAGRAM");	
	public static String diagramName=("TEST_DIAGRAM_2021_11_29_1028");
	public static String workflowDiagramName1 = cfunction.getUniqueName("Pro GP");
	public static RemoteWebDriver driver;
	public static String Locale="en";
	public static SoftAssert softAssert = new SoftAssert();
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static  Xls_Reader xls = null;
	public static WebElement element = null;
	public static boolean loggedIn=false;
	public static Date date = null;
	public static int totalFailStep=0;
	public SimpleDateFormat sdf =null;
	public String formattedDate=null;
	public  Calendar cal=null;
	public static String browser ="";
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentHtmlReporter htmlReporter_latest;
	public static String extentReportFilePath =null;
	public static String extentReportFilePath_BrowserNameOnly =null;
	public static int stepCount = 1;
	public static String locale;
	public static String testName;
	public static boolean screenshotEnabled = false;
	public static boolean logbrowserversion = true;
	//Dashboard: Request for Test Result
			public static TestResultRequest testResultRequest = new TestResultRequest();
	//public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger"); //devpinoyLogger

	public static void setLocale() {
		locale = xls.getCellData("Configuration", "Value", 2);
		if(locale.equalsIgnoreCase("default") ) {
			try {
				CommonFunction cfunction = new CommonFunction();
				String headerXpath = "//div[@id='geoevent_discovery_dijit_PageHeader_0']";
				String locale = cfunction.getElementAttribute(headerXpath, "lang");
				if(!locale.isEmpty())
					TestBase.locale = locale;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Locale set to : " + locale);
	}
	
	// Dynamic get browser version
		public static void extentReportbrowserversionSetup() {
			try {
				System.out.println("In extentReportbrowserversionSetup");

				System.out.println(
						"Browser Version is : " + ((RemoteWebDriver) driver).getCapabilities().getVersion().toString());
				/*
				 * Capabilities cap = driver.getCapabilities(); String browserversion =
				 * cap.getVersion().toString();
				 */
				String version = ((RemoteWebDriver) driver).getCapabilities().getVersion().toString();
				extent.setSystemInfo("Browser Version", version);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public static void excelSetup(){
		if(xls == null)
			xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\workflowmanager\\datasource\\DataSourceFile_WorkflowManager.xlsx");
	}

	@SuppressWarnings("deprecation")
	public static void setup(String platform, String browser, String version) throws Exception {
		String downloadFilepath = System.getProperty("user.home") + "\\Downloads\\";
		TestBase.browser = browser;
		// Load Excel Setup
		System.out.println("Load Excel");
		try {
			excelSetup();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		/*
		 * // Extent Report Setup System.out.println("Setup Extent Report");
		 * extentReportSetup( platform, browser, version);
		 */

		// Check if parameter passed from TestNG is 'firefox'
		if (((browser.equalsIgnoreCase("Firefox") && (platform.equalsIgnoreCase("Desktop"))))) {
			System.out.println("Setting path to Firefox");
			System.setProperty("webdriver.gecko.driver",
			 "C:\\Automation\\Workspace\\WorkflowManager\\WebDrivers\\geckodriver(version_0_31)\\geckodriver.exe");
			/*System.out.println("Setting path to Firefox");
			System.out.println(System.getProperty("user.dir"));
			WebDriverManager wdm = WebDriverManager.firefoxdriver()
					.cachePath(System.getProperty("user.dir") + "\\Webdriver\\").avoidOutputTree()
					.gitHubTokenName("automationtestuser")
					.gitHubTokenSecret(" d177a3c5824d30f06302b47496d90a041a5c5378");

			try {
				wdm.setup();
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			// WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("moz:useNonSpecCompliantPointerOrigin", true);
			// options.addArguments("--lang="+Locale);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("intl.accept_languages", Locale);
			/*
			 * profile.setPreference("browser.link.open_newwindow", 3);
			 * profile.setPreference("browser.link.open_newwindow.restriction", 0);
			 */

			// avoid the dialog that appears when saving zip files (e.g. for export)
			// profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
			// "application/zip");
			// options.setCapability(FirefoxDriver.PROFILE, profile);
			options.setProfile(profile);
			options.setCapability("moz:useNonSpecCompliantPointerOrigin", true);
			// FirefoxOptions options = new FirefoxOptions();
			options.addPreference("browser.download.dir", downloadFilepath);
			options.addPreference("browser.download.folderList", 2);
			/*
			 * options.addPreference("browser.link.open_newwindow", 3);
			 * options.addPreference("browser.link.open_newwindow.restriction", 0);
			 */
			options.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel,application/x-msexcel,application/x-compressed ,application/x-zip-compressed,application/zip,application/x-winzip, multipart/x-zip, application/x-gzip");
			options.addPreference("browser.download.manager.showWhenStarting", false);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();

		}
		// Check if parameter passed as 'chrome'
		else if ((browser.equalsIgnoreCase("Chrome") && (platform.equalsIgnoreCase("Desktop")))) {
			browser = "Chrome";
			// set path to chromedriver.exe
			// System.setProperty("webdriver.chrome.driver","C:\\Automation\\Workspace\\WorkflowManager\\Webdriver\\chromedriver.exe");
			System.out.println("Setting path to chrome");
			System.out.println(System.getProperty("user.dir"));
			WebDriverManager wdm = WebDriverManager.chromedriver()
					.cachePath(System.getProperty("user.dir") + "\\Webdriver\\").avoidOutputTree()
					.gitHubTokenName("automationtestuser")
					.gitHubTokenSecret(" d177a3c5824d30f06302b47496d90a041a5c5378");

			try {
				wdm.setup();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// create chrome instance
			// String downloadFilepath = System.getProperty("user.home") +"\\Downloads\\";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("safebrowsing.enabled", "false");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--lang=" + Locale);
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(cap);
			driver.manage().window().maximize();

		}
		// Check if parameter passed as 'Edge'
		else if ((browser.equalsIgnoreCase("Edge") && (platform.equalsIgnoreCase("Desktop")))) {

			// browserName = "";
			browser = "Edge";

			// set path to Edge.exe
			// System.setProperty("webdriver.edge.driver","C:\\Automation\\GIT2\\ps-software-release\\AllJar\\WebDrivers\\MicrosoftWebDriver.exe");
			System.out.println("Setting path to Edge");
			System.out.println(System.getProperty("user.dir"));
			WebDriverManager wdm = WebDriverManager.edgedriver()
					.cachePath(System.getProperty("user.dir") + "\\Webdriver\\").avoidOutputTree()
					.gitHubTokenName("automationtestuser")
					.gitHubTokenSecret(" d177a3c5824d30f06302b47496d90a041a5c5378");

			try {
				wdm.setup();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// create Edge instance
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else if ((browser.equalsIgnoreCase("InternetExplorer") && (platform.equalsIgnoreCase("Desktop")))) {

			// browserName = "";
			browser = "IE11";

			// set path to Edge.exe
			System.setProperty("webdriver.ie.driver",
					"C:\\Automation\\GIT2\\ps-software-release\\AllJar\\WebDrivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			// this line of code is to resolve protected mode issue
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
		} else if (platform.equalsIgnoreCase("crossbrowsertestingcloud")) {
			// set path to chromedriver.exe
			/*
			 * final String username = "gaurav.johri%40esriindia.com"; // Your username
			 * final String authkey = "u70a573cec76f564"; // Your authkey
			 */
			final String username = "CBANERJEE%40ESRI.COM"; // Your username
			final String authkey = "u8956e45347588eb"; // Your authkey
			String browserName = browser;
			String platformName = "Windows 10";
			if (browserName.contains("Safari")) {
				platformName = "Mac OSX 10.13";
			}

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("name", "WorkflowManagerTestAutomation");
			caps.setCapability("browserName", browserName);
			caps.setCapability("version", version); // If this cap isn't specified, it will just get the latest one
			caps.setCapability("platform", platformName);
			caps.setCapability("screenResolution", "1024x768");
			caps.setCapability("record_video", "true");
			caps.setCapability("record_network", "true");

			driver = new RemoteWebDriver(
					new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), caps);
			System.out.println(driver.getSessionId());
			driver.manage().window().maximize();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void extentReportSetup(String platform, String browser, String version, String url){
		// Extent Report constant values declaration
		String nameOS = "os.name";
		String versionOS = "os.version";
		//String architectureOS = "os.arch";
		String username= "user.name";
		String hostname= "COMPUTERNAME";
		//String appURL= url;
		String buildNo= Powershell.getBuildNo();
		String buildNoServer= Powershell.getBuildNoServer();
	      
		// Extent Report dynamic values extraction
		nameOS = System.getProperty(nameOS);
		
		//not used: since JAVA8 is showing wrong value
		//versionOS = System.getProperty(versionOS);
		
		//Get the version using Powershell
		versionOS = Powershell.getOSVersion();

		//versionOS = System.getProperty(versionOS);
		//architectureOS = System.getProperty(architectureOS);
		username = System.getProperty(username);
		hostname = System.getenv(hostname);

		// Conditional Code for KIOSK
		String browsername = browser;
		if(platform.equalsIgnoreCase("KIOSK")){
			browser="KIOSK";
		}

		// Extent report Configurations
		Date datef = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		extentReportFilePath= System.getProperty("user.dir") + "/test-output/ExtentReports/Archive/WorkflowManagerReport"+ "_" + browser+"_" +dateformat.format(datef)+ ".html";


		// For Latest folder for Browser Name Only
		extentReportFilePath_BrowserNameOnly= System.getProperty("user.dir") + "/test-output/ExtentReports/Latest/"+ browser+".html";

		// Reverting to browser
		if(platform.equalsIgnoreCase("KIOSK")){
			browser=browsername;
		}
		url = "<a href="+url+" target='_blank'>" + url + "</a>";
		htmlReporter = new ExtentHtmlReporter(extentReportFilePath);
		htmlReporter_latest = new ExtentHtmlReporter(extentReportFilePath_BrowserNameOnly);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.attachReporter(htmlReporter_latest);
		extent.setSystemInfo("URL", url);
		extent.setSystemInfo("Web Application Build", buildNo);
		extent.setSystemInfo("Server Build", buildNoServer);
		extent.setSystemInfo("Host Name", hostname);
		extent.setSystemInfo("Environment", "WorkFlow Manager Test Environment");
		extent.setSystemInfo("User Name", username);
		extent.setSystemInfo("Platform", platform);
		extent.setSystemInfo("Locale", Locale);
		//extent.setSystemInfo("Browser Version", version);
		extent.setSystemInfo("OS", nameOS);
		extent.setSystemInfo("OS Version", versionOS);
		//extent.setSystemInfo("OS Architecture", architectureOS);
		extent.setSystemInfo("Browser", browser);
		

		//Extent Report config setting
		htmlReporter.config().setDocumentTitle("WorkFlow Manager Automation Test Execution Report");
		htmlReporter.config().setReportName("WorkFlow Manager Automation Test Execution Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		//Extent Report config setting
		htmlReporter_latest.config().setDocumentTitle("WorkFlow Manager Automation Test Execution Report");
		htmlReporter_latest.config().setReportName("WorkFlow Manager Automation Test Execution Report");
		htmlReporter_latest.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter_latest.config().setTheme(Theme.STANDARD);
		//For dashboard : set the request parameters for Environment
		DashboardUtil.setEnvironmentParams(extentReportFilePath, platform, browser, version, nameOS, hostname);

	}
	public void setupzoom() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '1.5'");
	}

	/*public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;

		File src=ts.getScreenshotAs(OutputType.FILE);

		String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";

		File destination=new File(path);

		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		return path;
	}*/
	
	public static String getScreenshot(WebDriver driver) 
	{
		String path = "\\\\esri.com\\psdata\\PSProductsQA\\AutomationTestData\\ExtentReportImages\\Screenshot\\blank.png";
		String relativePath = "Screenshot/";
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String screenshot = System.currentTimeMillis()+".png";
			path="\\\\esri.com\\psdata\\PSProductsQA\\AutomationTestData\\ExtentReportImages\\WMX\\Screenshot\\"+screenshot;
			String localPath=System.getProperty("user.dir")+"/test-output/ExtentReports/Latest/Screenshot/"+screenshot;
			File destination=new File(path);
			File localDestination = new File(localPath);
			FileUtils.copyFile(src, destination);
			FileUtils.copyFile(src, localDestination);
			relativePath += screenshot;
			 //FileUtils.copyFile(src, destination);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return relativePath;
	}

	public static void waitforHomePagetoload() {
		// Wait for page to load
		//if(browser.equals("Firefox")) {cfunction.sync(120);}
		/*else {*/((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		
		//wait for the wmx header on homepage to load
		String locator = "//wmx-header";
		
		@SuppressWarnings("unused")
		WebElement element = (new WebDriverWait(driver, 360)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		cfunction.sync(20);
		
		/**/
		System.out.println("HomePage load complete");
		
	}
	public static void waitforpagetoload() {
		// Wait for page to load
		//if(browser.equals("Firefox")) {cfunction.sync(120);}
		/*else */((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

		//wait for the wmx header on homepage to load
		String locator = "//wmx-header";
		
		@SuppressWarnings("unused")
		WebElement element = (new WebDriverWait(driver, 360)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		cfunction.sync(20);
		}
	

	public void clickJS(WebElement element) {
		//WebElement element = driver.findElement(By.id("gbqfd"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public void resetStepCount() {
		// reset the step count to 1
		stepCount = 1;
	}
	public static String getScreenshotFailReport(WebDriver driver) throws IOException 
	{
		//1	
		String path = "\\\\esri.com\\psdata\\PSProductsQA\\AutomationTestData\\ExtentReportImages\\Screenshot\\blank.png";
		String relativePath = "";
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			//WebDriver augmentedDriver = new Augmenter().augment(driver);
			//File src = (File)((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			String screenshot = System.currentTimeMillis()+".png";
			path="\\\\esri.com\\psdata\\PSProductsQA\\AutomationTestData\\ExtentReportImages\\WorkflowManager\\Screenshot\\"+screenshot;
			String localPath=System.getProperty("user.dir")+"/test-output/ExtentReports/Latest/Screenshot/"+screenshot;
			File destination=new File(path);
			File localDestination = new File(localPath);
			FileUtils.copyFile(src, destination);
			FileUtils.copyFile(src, localDestination);
			relativePath += screenshot;
		} catch(Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return relativePath;
	}
	
public static String fetchItemID() throws IOException{
		
		String itemID1 = "";
          File myObj = new File("C:\\Automation\\ITEM_ID\\itemID.txt");
		
          BufferedReader br = new BufferedReader(new FileReader(myObj));
          itemID1 = br.readLine();
          System.out.println("Your Item ID is "+ itemID1);
         
          
          BufferedWriter f_write = new BufferedWriter(new FileWriter("C:\\Automation\\ITEM_ID\\archive_ITEM_ID.txt", true));
          f_write.newLine();
        
          f_write.write(cfunction.getUniqueName1(itemID1));
          
          br.close();
          f_write.close();
		return itemID1;
		
}
	
}
