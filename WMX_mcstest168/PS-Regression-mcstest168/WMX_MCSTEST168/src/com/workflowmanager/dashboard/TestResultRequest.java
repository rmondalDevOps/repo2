package com.workflowmanager.dashboard;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;
import com.workflowmanager.library.TestBase;

public class TestResultRequest   {

	String testResultsID;
	String teamsID;
	String testingPlatform;
	String testCategory;
	String browser;
	int browserVersion;
	String os;
	String arcGISProduct;
	String productVersion;
	int productBuild;
	int totalTestCases;
	int pass;
	int fail;
	int skip;
	int status35;
	int status70;
	int status100;
	Date startTime;
	Date endTime;
	String duration;
	String machineName;
	
	public TestResultRequest(){
		teamsID = "WMX-NextGen";
		testCategory = "Web";
		arcGISProduct = "WMX NextGen 168";
		/*
		Map<String, String> config = new HashMap<String, String>();
	       config.put("maxWait", "80000");
	       PowerShell powerShell = PowerShell.openSession();
	       //Execute script
	       String path = System.getProperty("user.dir") +"/src/com/workflowmanager/powershell/VersionNo.ps1";
	       PowerShellResponse response = powerShell.configuration(config).executeScript(path);
	       
	       //Print results if the script
	      String builNo = response.getCommandOutput();
	      System.out.println("Build value is=="+builNo);
	       String[] list= builNo.split("\\.");
	       String buildNo = list[2];
	       productBuild=Integer.parseInt(buildNo);
	       productVersion = list[0]+"."+list[1];
	       */
		/*productVersion = "11.1";
		productBuild =2316;*/
		status100 = 0;
		status70 = 0;
		status35 = 0;
		startTime = DashboardUtil.getCurrentDate();
	}

	public String getTestResultsID() {
		return testResultsID;
	}
	public void setTestResultsID(String testResultsID) {
		this.testResultsID = testResultsID;
	}
	public String getTeamsID() {
		return teamsID;
	}
	public void setTeamsID(String teamsID) {
		this.teamsID = teamsID;
	}
	public String getTestingPlatform() {
		return testingPlatform;
	}
	public void setTestingPlatform(String testingPlatform) {
		this.testingPlatform = testingPlatform;
	}
	public String getTestCategory() {
		return testCategory;
	}
	public void setTestCategory(String testCategory) {
		this.testCategory = testCategory;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public int getBrowserVersion() {
		return browserVersion;
	}
	public void setBrowserVersion(int browserVersion) {
		this.browserVersion = browserVersion;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getArcGISProduct() {
		return arcGISProduct;
	}
	public void setArcGISProduct(String arcGISProduct) {
		this.arcGISProduct = arcGISProduct;
	}
	public String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(String productArea) {
		this.productVersion = productArea;
	}
	public int getProductBuild() {
		return productBuild;
	}
	public void setProductBuild(int productBuild) {
		this.productBuild = productBuild;
	}
	public int getTotalTestCases() {
		return totalTestCases;
	}
	public void setTotalTestCases(int totalTestCases) {
		this.totalTestCases = totalTestCases;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	public int getStatus35() {
		return status35;
	}
	public void setStatus35(int status35) {
		this.status35 = status35;
	}
	public int getStatus70() {
		return status70;
	}
	public void setStatus70(int status70) {
		this.status70 = status70;
	}
	public int getStatus100() {
		return status100;
	}
	public void setStatus100(int status100) {
		this.status100 = status100;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}	
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

}
