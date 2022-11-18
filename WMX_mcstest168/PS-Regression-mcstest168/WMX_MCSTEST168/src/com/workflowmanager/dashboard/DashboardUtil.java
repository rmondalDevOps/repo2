package com.workflowmanager.dashboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.Assert;

import com.workflowmanager.library.TestBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Extract a tag from a line of HTML .
 */
public class DashboardUtil extends TestBase{
	
	private static final String restURL = "http://psqadashboard.esri.com/DashboardService/rest/dashboardapi/savetestresult";
//	private static final String restURL = "http://psqacrtapp.esri.com:8080/DashboardService/rest/dashboardapi/savetestresult";
	static String[] results = {"0","0","0"};


	public static void setResultStats() throws IOException {
		File input = new File(extentReportFilePath);
		Document docChrome = Jsoup.parse(input, "UTF-8");
		Elements spansChrome = docChrome.select("span"); 
		results = new String[spansChrome.size()];
		int i=0;
		for(Element span:spansChrome){
			if(span.attr("class").contains("strong") ) {
				results[i] = span.select("span").text();
				i++;
			}
		}

		//set the result stats parameters
		int pass = Integer.parseInt(results[0]);
		int fail = Integer.parseInt(results[1]);
		int skip = Integer.parseInt(results[2]);
		int total = pass + fail + skip;
		testResultRequest.setPass(pass);
		testResultRequest.setFail(fail);
		testResultRequest.setSkip(skip);
		testResultRequest.setTotalTestCases(total);

		//get the time stats from extent report
		spansChrome = docChrome.select("div"); 
		results = new String[5];
		i=0;
		for(Element span:spansChrome){
			if(span.attr("class").contains("panel-lead") ) {
				results[i] = span.select("div").text();
				i++;
			}
		}

		String startTime = results[2];
		String endTime = results[3];
		System.out.println("StartTime : " + startTime + "EndTime : " +endTime );
		testResultRequest.setDuration(results[4]);
	}


	public static void setEnvironmentParams(String extentReportFilePath, String platform, String browser,
			String version, String nameOS, String machineName) {

		try {
			String[] pathArr = extentReportFilePath.split("/");
			if(pathArr.length > 0) {
				String fileName = (pathArr[pathArr.length - 1]).replaceAll(".html", "");
				testResultRequest.setTestResultsID(fileName);
			}
			testResultRequest.setBrowser(browser);
			testResultRequest.setBrowserVersion(Integer.parseInt(version));
			testResultRequest.setOs(nameOS);
			testResultRequest.setTestingPlatform(platform);
			testResultRequest.setMachineName(machineName);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public static Date getDateFromString(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM DD, yyyy hh:mm:ss");
		//String dateInString = "Jan 20, 2020 10:17:26 AM";
		return (Date) sdf.parse(Calendar.getInstance().getTime().toString());
	}
	public static Date getCurrentDate() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	public static String getRequestParameter(){
		String jsonParameter = "";
		//setStats and time
		testResultRequest.setEndTime(getCurrentDate());
		try {
			setResultStats();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			// Create ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);

			jsonParameter = mapper.writeValueAsString(testResultRequest);
			System.out.println(jsonParameter);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return jsonParameter;
	}
	public static void saveTestResultforDashboardTest() {
		RestAssured.baseURI = "http://localhost:8080/DashboardService/rest/dashboardapi";
		RequestSpecification request = RestAssured.given();

		request.body(getRequestParameter());
		Response response = request.post("/savetestresult");

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		String output = response.jsonPath().get("body");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		
		System.out.println("Result saved..." + output);
	}


	public static void saveTestResultforDashboard() {
		String jsonParameter = getRequestParameter();
		if(!jsonParameter.isEmpty()) {
			try {
				URL url = new URL(restURL);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("Accept","application/json");
				//connection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonParameter);
				out.close();

				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String currentLine;
				while ((currentLine = in.readLine()) != null) {
					response.append(currentLine);
				}
				in.close();
				String output =  response.toString();
				connection.disconnect();
				
				System.out.println("REST Service response ----" + output);
				in.close();
			} catch (Exception e) {
				System.out.println("Error while calling REST Service");
				e.printStackTrace();
			}
		}
	}
}
