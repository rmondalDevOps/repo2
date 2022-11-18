package com.workflowmanager.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppLib extends TestBase{

	//public void createDirectory() {
	//maritimeserver
	public Path createFileWithDir(String directory, String filename) throws Exception {
		/*File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdirs();
		}*/
		Files.createDirectories(Paths.get(directory+filename));
		return Paths.get(directory + File.separatorChar + filename);
	}
	public Path createDir(String directory, String filename) throws Exception {
		/*File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdirs();
		}*/
		Files.createDirectories(Paths.get(directory+filename));
		return Paths.get(directory + File.separatorChar + filename);
	}

	public void deleteFileWithDirWithServiceStop(String directory) throws Exception {
		//FileUtils.forceDelete(new File(directory));

		String SERVICE_NAME ="ArcGIS Server";
		String[] scriptStop = {"cmd.exe", "/c", "sc", "stop", SERVICE_NAME};
		//String[] scriptStopService = {"net", "stop", SERVICE_NAME};
		try {
			Process processstop = Runtime.getRuntime().exec(scriptStop);
			/*Runtime runtime = Runtime.getRuntime();
		    Process process = runtime.exec(scriptStopService);//or scriptStop
		    process.waitFor();
			 */
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		cfunction.sync(120);
		System.out.println("Delete directory after service stopped");
		FileUtils.deleteDirectory(new File(directory));

		/*SeleniumHelp.sync(50);
		String[] scriptStart = {"cmd.exe", "/c", "sc", "start", SERVICE_NAME};
		try {
			Process processstart = Runtime.getRuntime().exec(scriptStart);
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/

		cfunction.sync(120);
		// check if serveice is stopped:
		String[] scriptCheck = {"cmd.exe", "/c", "sc", "query", SERVICE_NAME, "|", "find", "/C", "\"RUNNING\""};
		Process processCheck = Runtime.getRuntime().exec(scriptCheck);
		BufferedReader input =  new BufferedReader(new InputStreamReader(processCheck.getInputStream()));  
		String line = input.readLine();
		System.out.println("line value: "+line);
		/*while ((line = input.readLine()) != null) {  
			System.out.println(line);  
		}  
		 */		//input.close(); 
		String Off = line;
		if(Off.equalsIgnoreCase("0")) {
			System.out.println("if(Off.equalsIgnoreCase(\"0\")) {");
			boolean b = true;
			while(b) {
				System.out.println("while(Off==\"0\") {");
				int i=1;
				String[] scriptStartagaininloop = {"cmd.exe", "/c", "sc", "start", SERVICE_NAME};
				try {
					Process processstartagaininloop = Runtime.getRuntime().exec(scriptStartagaininloop);

					cfunction.sync(50);
					String[] scriptCheckinloop = {"cmd.exe", "/c", "sc", "query", SERVICE_NAME, "|", "find", "/C", "\"RUNNING\""};
					Process processCheckinloop = Runtime.getRuntime().exec(scriptCheckinloop);
					BufferedReader inputinloop =  new BufferedReader(new InputStreamReader(processCheckinloop.getInputStream()));  
					String lineinloop = inputinloop.readLine();
					System.out.println("lineinloop: "+lineinloop);
					if ((lineinloop.equalsIgnoreCase("1"))||(i==5)) {
						System.out.println("in if ((lineinloop.equalsIgnoreCase(\"1\"))||(i==5)) {");
						b=false;
						break;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("i= "+i);
				/*if (i==5) {
				break;
			}
				 */			
				i++;
				System.out.println("value of i: "+ i);
			}
		}

		Runtime.getRuntime().exec("icacls %systemdrive%\\inetpub /grant  avworld\\pltstest:(OI)(CI)(F) /grant avworld\\pltstest:F");
		//System.out.println("Pre processCheck.exitValue()" +processCheck.exitValue()); 
		//String dirrr = "C:\\arcgisserver\\directories\\maritimeserver\\maritimechartservice\\sencs";

		/*String dirrr = "C:/arcgisserver/directories/maritimeserver/maritimechartservice/sencs";
		File direct = new File(dirrr);
		Process process = Runtime.getRuntime().exec("US5WA70M_0_102100_1_4.senc", null, direct);
		 */
		//Process p=Runtime.getRuntime().exec("cmd.exe /k rd /s /q C:\\\\arcgisserver\\\\directories\\\\maritimeserver\\\\maritimechartservice\\\\sencs");
		//Process p=Runtime.getRuntime().exec("cmd.exe /k rd /s /q C:\\\\arcgisserver\\\\directories\\\\maritimeserver");

		/*Files.walk(dirrr)
	    .sorted(Comparator.reverseOrder())
	    .map(Path::toFile)
	    .forEach(File::delete);
		 */		 
		/*File dir = new File(directory);
		if (dir.exists()) {
			String cmd = "rm -r " + dir.getAbsolutePath();
			System.out.println("cmd: "+cmd);
			Runtime.getRuntime().exec(cmd);
		}*/
		Thread.sleep(20000);
		System.out.println("S");
	}

	public void deleteFileWithDir(String directory) throws Exception {
		FileUtils.deleteDirectory(new File(directory));
	}


	public void copyDir(File srcDir, File destDir) throws IOException {
		//try {
		if((srcDir.exists()) && (destDir.exists())) {
			FileUtils.copyDirectory(srcDir, destDir);
		}else {
			String msg = "File Not Found";
			//CommonFunctions.logStatus("FAIL", msg);
		}
		/*} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public boolean copyDirbool(File srcDir, File destDir) throws IOException {
		boolean bool_copyDir = false;
		//try {
		if((srcDir.exists()) && (destDir.exists())) {
			FileUtils.copyDirectory(srcDir, destDir);
			bool_copyDir = true;
		}
		return bool_copyDir;
	}
	public void copyDir(File srcDir, File destDir, String filename) throws IOException {

		try {
			//if((srcDir.exists()) && (destDir.exists())) {
			//FileUtils.copyDirectory(srcDir, destDir);
			FileUtils.copyDirectory(srcDir, destDir);
			/*}else {
				String msg = "File Not Found";
				CommonFunctions.logStatus("FAIL", msg);
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}

		//Files.copy(Paths.get(srcDir +File.separator+filename),Paths.get(destDir));

	}

	public void copyFile(File srcFile, File destFile) throws IOException {
		//FileUtils.copyFile(srcFile, destFile);
		try {
			if((srcFile.exists()) && (destFile.exists())) {
				//FileUtils.copyDirectory(srcDir, destDir);
				//destFile.delete();
				//FileUtils.copyFile(srcFile, destFile);
				Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				//Files.move(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				// Files.copy(srcFile, srcFile,StandardCopyOption.REPLACE_EXISTING);
				/*Runtime runtime=Runtime.getRuntime();
			        try {
			            Process process= runtime.exec("cmd.exe /c  start cacls text.txt /e /d %username%");
			        } catch (IOException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
				 */			}else {
					 String msg = "File Not Found";
					 cfunction.logStatus("FAIL", msg);
				 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean copyFileBool(File srcFile, File destFile) throws Exception {
		boolean bool_copyFileBool= false;
		//FileUtils.copyFile(srcFile, destFile);
		try {
			if((srcFile.exists()) && (destFile.exists())) {
				//FileUtils.copyDirectory(srcDir, destDir);
				FileUtils.copyFile(srcFile, destFile);
				bool_copyFileBool = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool_copyFileBool;
	}

	/*public void createFilewithDirTS1TC1MCSCCB(String destMaritime, File srcMaritime) throws Exception {
		File[] files = srcMaritime.listFiles();
		if(files!=null) { 
			for(File f: files) {
				if(f.isDirectory()) {
					System.out.println("f.getName():  "+f.getName());
					if (ArcGISversion.contains("10.9")) {
						if((f.getName().equalsIgnoreCase("maritimechartservice")) || (f.getName().equalsIgnoreCase("customchartbuilder"))) {
							try {
								createFileWithDir(destMaritime, f.getName());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File to = new File(destMaritime+f.getName());
							FileUtils.copyDirectory(f, to);
						}
					} else {
						if((f.getName().equalsIgnoreCase("maritimechartservice")) || (f.getName().equalsIgnoreCase("productsondemand"))) {
							try {
								createFileWithDir(destMaritime, f.getName());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File to = new File(destMaritime+f.getName());
							FileUtils.copyDirectory(f, to);
						}

					}
				} 
			}
		}

	}*/

	public void createFilewithDirTS1TC1MCSCCB(File srcDirPod, String destDirPod) throws Exception {
		try {
			File[] filesPod = srcDirPod.listFiles();
			if(filesPod!=null) { 
				for(File f: filesPod) {
					if(f.isDirectory()) {
						if((f.getName().equalsIgnoreCase("ccb"))|| ((f.getName().equalsIgnoreCase("pod")))) {
							try {
								System.out.println("createFileWithDir(destDirPod, f.getName());");
								createFileWithDir(destDirPod, f.getName());
							} catch (IOException e) {
								e.printStackTrace();
							}
							File to = new File(destDirPod+f.getName());
							FileUtils.copyDirectory(f, to);
						}
					} 
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void replaceText(String filePath, String replceTextFrom, String replaceTextTo) {
		try {
			// input the file content to the StringBuffer "input"
			BufferedReader file = new BufferedReader(new FileReader(filePath));
			StringBuffer inputBuffer = new StringBuffer();
			String line;

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			file.close();
			String inputStr = inputBuffer.toString();

			System.out.println("inputStr    "+inputStr); // display the original file for debugging
			System.out.println("replceTextFrom    "+replceTextFrom); // display the original file for debugging
			// logic to replace lines in the string (could use regex here to be generic)
			if (inputStr.contains(replceTextFrom)) {
				inputStr = inputStr.replace(replceTextFrom,replaceTextTo); 
			}
			// display the new file for debugging
			//System.out.println("----------------------------------\n" + inputStr);

			// write the new string with the replaced line OVER the same file
			FileOutputStream fileOut = new FileOutputStream(filePath);
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("Problem reading file.");
		}
	}

	public static void copyFileToDirectory(File srcFile, File destFile) throws IOException {
		try {
			if((srcFile.exists()) && (destFile.exists())) {
				//FileUtils.copyDirectory(srcDir, destDir);
				//FileUtils.copyFile(srcFile, destFile);
				FileUtils.copyFileToDirectory(srcFile, destFile);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean copyFileToDirectoryBool(File srcFile, File destFile) throws Exception {
		boolean bool_copyFileToDirectoryBool = false;
		try {
			if((srcFile.exists()) && (destFile.exists())) {
				//FileUtils.copyDirectory(srcDir, destDir);
				//FileUtils.copyFile(srcFile, destFile);
				FileUtils.copyFileToDirectory(srcFile, destFile);
				bool_copyFileToDirectoryBool = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool_copyFileToDirectoryBool;



	}

	public void assignPermission(String directorypath, String foldername,String username) throws Exception {
		try {
			String yourCommand1 = "net share "+foldername+"="+directorypath+" /GRANT:"+username+",FULL";
			Process p1 = Runtime.getRuntime().exec(yourCommand1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void assignPermission2User(String directorypath, String foldername,String username1,String username2) throws Exception {
		try {
			String yourCommand = "net share "+foldername+"="+directorypath+" /GRANT:"+username1+",FULL /GRANT:"+username2+",FULL";
			Process p1 = Runtime.getRuntime().exec(yourCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void assignPermission3User(String directorypath, String foldername,String username1,String username2,String username3) throws Exception {
		try {
			String yourCommand = "net share "+foldername+"="+directorypath+" /GRANT:"+username1+",FULL /GRANT:"+username2+",FULL /GRANT:"+username3+",FULL";
			Process p3 = Runtime.getRuntime().exec(yourCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void executionCompletePopup(RemoteWebDriver driver) throws Exception {

		System.out.println( "Popup Code");
		try {

			JavascriptExecutor js=(JavascriptExecutor)driver;
			//String str1="MCS Test Setup Execution Complete.Please see reports " ;
			String str1="MCS Test Setup Execution Complete.Execution Report will be displayed automatically after 30 seconds" ;
			js.executeScript("alert(arguments[0]);",str1);

			Thread.sleep(30000);

			try {
				WebDriverWait wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.alertIsPresent());

				try {
					//Alert al = driver.switchTo().alert();
					driver.switchTo().alert().accept();
				}
				catch(NoAlertPresentException e) {
					System.out.println("Message accepted");
					//CommonFunction.logStatus("PASS", "Suit Completed");
				}
				Runtime rt = Runtime.getRuntime();
				//String url = "C:\\\\\\\\Automation\\\\\\\\MCSTestSetupPkg\\\\\\\\test-output\\\\\\\\ExtentReports\\\\\\\\Latest\\\\\\\\Chrome.html";
				String url = System.getProperty("user.dir") +"/test-output/ExtentReports/Latest/Chrome.html";
				rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
			}catch( Exception e )
			{
				System.out.println("Message accepted");
				//CommonFunction.logStatus("PASS", "Suit Completed");
			}
		}catch( Exception e )
		{
			System.out.println(e);
			//CommonFunction.logStatus("PASS", "Suit Completed");
		}

	}

	public static void executionCompleteConditionalPopup(RemoteWebDriver driver) throws Exception {

		System.out.println( "Popup Code");
		try {

			JavascriptExecutor js=(JavascriptExecutor)driver;
			//String str1="MCS Test Setup Execution Complete.Please see reports " ;
			String str1="MCS Test Setup Execution Complete.Execution Report will be displayed automatically after 30 seconds" ;
			//js.executeScript("alert(arguments[0]);",str1);
			js.executeScript("if (confirm('Are you sure you want to save this thing into the database?')) {\r\n" + 
					"  // Save it!\r\n" + 
					"  console.log('Thing was saved to the database.');\r\n" + 
					"}");


			Thread.sleep(30000);

			try {
				WebDriverWait wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.alertIsPresent());


			}catch( Exception e )
			{
				System.out.println("Message accepted");
				//CommonFunction.logStatus("PASS", "Suit Completed");
			}
		}catch( Exception e )
		{
			System.out.println(e);
			//CommonFunction.logStatus("PASS", "Suit Completed");
		}

	}

	public static long getFileSize(URL url) {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("HEAD");
			return conn.getContentLengthLong();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

}
