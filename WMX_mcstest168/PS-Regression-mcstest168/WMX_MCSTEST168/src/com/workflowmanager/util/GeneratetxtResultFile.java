package com.workflowmanager.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Extract a tag from a line of HTML .
 */
public class GeneratetxtResultFile{

	static String[] resultsChrome = {"0","0","0"};
	static String[] resultsFirefox= {"0","0","0"};
	static String[] resultsIE11= {"0","0","0"};
	static String[] resultsEdge= {"0","0","0"};




	public static void generatetxtResultFileforCITool(String extentReportFilePath) throws IOException {

		if(extentReportFilePath.contains("Chrome")) {
			File inputChrome = new File(extentReportFilePath);
			Document docChrome = Jsoup.parse(inputChrome, "UTF-8");
			Elements spansChrome = docChrome.select("span"); 
			resultsChrome = new String[spansChrome.size()];
			int i=0;
			for(Element span:spansChrome){
				if(span.attr("class").contains("strong") ) {
					resultsChrome[i] = span.select("span").text();
					i++;
				}
			}
			writeResultBody(resultsChrome,"Chrome" );
		}

		if(extentReportFilePath.contains("Firefox")) {
			File inputFirefox = new File(extentReportFilePath);
			Document docFirefox = Jsoup.parse(inputFirefox, "UTF-8");
			Elements spansFirefox = docFirefox.select("span"); 
			resultsFirefox = new String[spansFirefox.size()];
			int j=0;
			for(Element span:spansFirefox){
				if(span.attr("class").contains("strong") ) {
					resultsFirefox[j] = span.select("span").text();
					j++;
				}
			}
			writeResultBody(resultsFirefox,"FireFox" );
		}

		if(extentReportFilePath.contains("IE11")) {
			File inputIE11 = new File(extentReportFilePath);
			Document docIE11 = Jsoup.parse(inputIE11, "UTF-8");
			Elements spansIE11 = docIE11.select("span"); 
			resultsIE11 = new String[spansIE11.size()];
			int j=0;
			for(Element span:spansIE11){
				if(span.attr("class").contains("strong") ) {
					resultsIE11[j] = span.select("span").text();
					j++;
				}
			}
			writeResultBody(resultsIE11,"IE11" );
		}

		if(extentReportFilePath.contains("Edge")) {
			File inputEdge = new File(extentReportFilePath);
			Document docEdge = Jsoup.parse(inputEdge, "UTF-8");
			Elements spansEdge = docEdge.select("span"); 
			resultsEdge = new String[spansEdge.size()];
			int j=0;
			for(Element span:spansEdge){
				if(span.attr("class").contains("strong") ) {
					resultsEdge[j] = span.select("span").text();
					j++;
				}
			}
			writeResultBody(resultsEdge,"Edge" );
		}


		int ChromePassed =  Integer.parseInt(resultsChrome[0]);
		int ChromeFailed =  Integer.parseInt(resultsChrome[1]);
		int ChromeNotRun =  Integer.parseInt(resultsChrome[2]);

		int FirefoxPassed =  Integer.parseInt(resultsFirefox[0]);
		int FirefoxFailed =  Integer.parseInt(resultsFirefox[1]);
		int FirefoxNotRun =  Integer.parseInt(resultsFirefox[2]);

		int IE11Passed =  Integer.parseInt(resultsIE11[0]);
		int IE11Failed =  Integer.parseInt(resultsIE11[1]);
		int IE11NotRun =  Integer.parseInt(resultsIE11[2]);

		int EdgePassed =  Integer.parseInt(resultsEdge[0]);
		int EdgeFailed =  Integer.parseInt(resultsEdge[1]);
		int EdgeNotRun =  Integer.parseInt(resultsEdge[2]);




		int TotalPassed = ChromePassed + FirefoxPassed + IE11Passed + EdgePassed  ;
		int TotalFailed = ChromeFailed + FirefoxFailed + IE11Failed + EdgeFailed ;
		int TotalNotRun = ChromeNotRun + FirefoxNotRun + IE11NotRun + EdgeNotRun ;


		System.out.println("TotalPassed: "+TotalPassed);
		System.out.println("TotalFailed: "+TotalFailed);
		System.out.println("TotalNotRun: "+TotalNotRun);
		{
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(System.getProperty("user.dir") +"/test-output/ResultFilesforCITool/results-subject.txt"), "utf-8"))) {
				writer.write("PASSED: " +TotalPassed + ",");
				writer.write("FAILED: " +TotalFailed + ",");
				writer.write("NOT RUN: " +TotalNotRun);
			}

		}
	}

	public static void writeResultBody(String arr[],String browser) throws IOException
	{

		try
		{
			String fileBodypath = System.getProperty("user.dir") +"/test-output/ResultFilesforCITool/results-body.txt";

			File fileBodyText = new File(fileBodypath);

			FileWriter fileWriter = new FileWriter(fileBodyText,true);

			BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);

			fileWriter.append("<b>"+browser+"</b><br>"+ System.getProperty("line.separator"));
			fileWriter.append("PASSED: "+arr[0]+","+ "FAILED: "+ arr[1] + ","+"NOT RUN: " + arr[2]+ "<br><br>" + System.getProperty("line.separator"));

			bufferFileWriter.close();

		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public static void deleteResultBody()
	{
		try
		{
			String fileBodypath = System.getProperty("user.dir") +"/test-output/ResultFilesforCITool/results-body.txt";

			PrintWriter writer = new PrintWriter(fileBodypath);
			writer.print("");
			writer.close();

		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
