package com.workflowmanager.library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTHelp {

	// Verification using Using RestAssured, Response code & Body 
	public static String TestResponseWithRestAssured(String endpointwithparam) throws Exception
	{
		//RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		//RestAssured.baseURI = "https://geautotest1.esri.com:6443/arcgis/rest/services/Hosted/FlightsBDS/MapServer/0/query?where=1%3D1&objectIds=&time=&geometry=&geometryType=esriGeometryEnvelope&inSR=&spatialRel=esriSpatialRelIntersects&distance=&units=esriSRUnit_Foot&relationParam=&outFields=&returnGeometry=true&maxAllowableOffset=&geometryPrecision=&outSR=&having=&gdbVersion=&historicMoment=&returnDistinctValues=false&returnIdsOnly=false&returnCountOnly=true&returnExtentOnly=false&orderByFields=&groupByFieldsForStatistics=&outStatistics=&returnZ=false&returnM=false&multipatchOption=xyFootprint&resultOffset=&resultRecordCount=&returnTrueCurves=false&returnExceededLimitFeatures=false&quantizationParameters=&returnCentroid=false&sqlFormat=none&resultType=&f=json";
		//RestAssured.baseURI = "https://gistest1.rajasthan.gov.in/rajasthan/rest/services/Common/HQ/MapServer/0/query?where=1%3D1&returnCountOnly=true&f=json&token=sIQwYp289eIbEcZ1LE6AV5ERsfIlfvRjjTGDbOXB6N_2uVxJcqUfy12ugFvfHQXc";
		RestAssured.baseURI = endpointwithparam;
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Status message " + response.body().asString());
		String output = response.body().asString();
		return output;

	}
	// Verification using Rest Assurred POST request with Parameter example
	public String TestPOSTwithJSONParamExplicitly(String endpointwithparam) throws Exception
	{ 
		RestAssured.baseURI =endpointwithparam;
		RequestSpecification request = RestAssured.given();

		//JSONObject requestParams = JSONObject();
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Guarav"); // To be customized as per need
		requestParams.put("LastName", "Johri"); //To be customized as per need
		requestParams.put("UserName", "gau96548"); //To be customized as per need
		requestParams.put("Password", "xxxxxxx"); //To be customized as per need
		requestParams.put("Email",  "sample@gmail.com"); //To be customized as per need 


		request.body(requestParams.toString());
		Response response = request.post("/register");// To be customized as per need

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		String output = response.jsonPath().get("body");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");

		return output;
	}

	// Verification using HttpURLConnection 
	public static String TestResponseCodeNBody(String endpointwithparam) throws Exception{
		String output;
		//URL url = new URL("https://geautotest1.esri.com:6443/arcgis/rest/services/Hosted/FlightsBDS/MapServer/0/query?where=1%3D1&objectIds=&time=&geometry=&geometryType=esriGeometryEnvelope&inSR=&spatialRel=esriSpatialRelIntersects&distance=&units=esriSRUnit_Foot&relationParam=&outFields=&returnGeometry=true&maxAllowableOffset=&geometryPrecision=&outSR=&having=&gdbVersion=&historicMoment=&returnDistinctValues=false&returnIdsOnly=false&returnCountOnly=true&returnExtentOnly=false&orderByFields=&groupByFieldsForStatistics=&outStatistics=&returnZ=false&returnM=false&multipatchOption=xyFootprint&resultOffset=&resultRecordCount=&returnTrueCurves=false&returnExceededLimitFeatures=false&quantizationParameters=&returnCentroid=false&sqlFormat=none&resultType=&f=json");
		URL url = new URL(endpointwithparam);
		//URL url = new URL("https://gistest1.rajasthan.gov.in/rajasthan/rest/services/Common/HQ/MapServer/0/query?where=1%3D1&returnCountOnly=true&f=json&token=sIQwYp289eIbEcZ1LE6AV5ERsfIlfvRjjTGDbOXB6N_2uVxJcqUfy12ugFvfHQXc");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		System.out.println("Output from Server .... \n");
		StringBuilder response = new StringBuilder();
		String currentLine;
		while ((currentLine = br.readLine()) != null) {
			response.append(currentLine);
		}
		br.close();
		output =  response.toString();
		conn.disconnect();
		return output;
	}

	// Verification using SSL n Authentication + HttpsURLConnection
	public static String TestRESTResponseWithSSLnAuthentication(String endpointwithparam) throws Exception {
		String output;
		/* Start of Fix */
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
			public void checkClientTrusted(X509Certificate[] certs, String authType) { }
			public void checkServerTrusted(X509Certificate[] certs, String authType) { }

		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) { return true; }
		};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		/* End of the fix*/

		URL url = new URL(endpointwithparam);
		//URL url = new URL("https://gistest1.rajasthan.gov.in/rajasthan/rest/services/Common/HQ/MapServer/0/query?where=1%3D1&returnCountOnly=true&f=json&token=sIQwYp289eIbEcZ1LE6AV5ERsfIlfvRjjTGDbOXB6N_2uVxJcqUfy12ugFvfHQXc");
		//URL url = new URL("https://geautotest1.esri.com:6443/arcgis/rest/services/Hosted/FlightsBDS/MapServer/0/query?where=1%3D1&objectIds=&time=&geometry=&geometryType=esriGeometryEnvelope&inSR=&spatialRel=esriSpatialRelIntersects&distance=&units=esriSRUnit_Foot&relationParam=&outFields=&returnGeometry=true&maxAllowableOffset=&geometryPrecision=&outSR=&having=&gdbVersion=&historicMoment=&returnDistinctValues=false&returnIdsOnly=false&returnCountOnly=true&returnExtentOnly=false&orderByFields=&groupByFieldsForStatistics=&outStatistics=&returnZ=false&returnM=false&multipatchOption=xyFootprint&resultOffset=&resultRecordCount=&returnTrueCurves=false&returnExceededLimitFeatures=false&quantizationParameters=&returnCentroid=false&sqlFormat=none&resultType=&f=json");
		//URL url = new URL("https://geautotest1.esri.com:6443/arcgis/rest/services/Hosted/FlightsBDS/MapServer/0");
		URLConnection con = url.openConnection();

		//String userpass = "Anurag" + ":" + "India123";
		String userpass = "portaladmin" + ":" + "esri.123";
		String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

		con.setRequestProperty ("Authorization", basicAuth);
		BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
		System.out.println("Output from Server .... \n");
		StringBuilder response = new StringBuilder();
		String currentLine;
		while ((currentLine = br.readLine()) != null) {
			response.append(currentLine);
		}
		br.close();
		output =  response.toString();
		//con.disconnect();
		System.out.println(output);
		return output;	
	}
}
