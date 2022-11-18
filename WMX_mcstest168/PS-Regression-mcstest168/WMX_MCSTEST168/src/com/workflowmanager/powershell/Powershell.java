package com.workflowmanager.powershell;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;

public class Powershell {

	public static void main(String[] args) {
		System.out.println("GeoEvent Build:  " + getBuildNo());
		System.out.println("OS Version:  " + getOSVersion());
	}

	public static String getBuildNo() {
		String buildNo = "";
		String builNo= "";
		try (PowerShell powerShell = PowerShell.openSession()) {       
		       //Increase timeout to give enough time to the script to finish
		       Map<String, String> config = new HashMap<String, String>();
		       config.put("maxWait", "80000");
		       
		       //Execute script
		       String path = System.getProperty("user.dir") +"/src/com/workflowmanager/powershell/VersionNoWebApp.ps1";
		       PowerShellResponse response = powerShell.configuration(config).executeScript(path);
		       
		       //Print results if the script
		       builNo = response.getCommandOutput();
		       String[] list= builNo.split("\\.");
		       buildNo = list[2];
		       //productBuild=Integer.parseInt(buildNo);
		       
		       ///buildNo = response.getCommandOutput();
		       
		   } catch(PowerShellNotAvailableException ex) {
		       ex.printStackTrace();
		   }
		return buildNo;
	}
	public static String getBuildNoServer() {
		String buildNo = "";
		String builNo= "";
		try (PowerShell powerShell = PowerShell.openSession()) {       
		       //Increase timeout to give enough time to the script to finish
		       Map<String, String> config = new HashMap<String, String>();
		       config.put("maxWait", "80000");
		       
		       //Execute script
		       String path = System.getProperty("user.dir") +"/src/com/workflowmanager/powershell/VersionNo.ps1";
		       PowerShellResponse response = powerShell.configuration(config).executeScript(path);
		       
		       //Print results if the script
		       builNo = response.getCommandOutput();
		       String[] list= builNo.split("\\.");
		       buildNo = list[2];
		 
		       ///buildNo = response.getCommandOutput();
		       
		   } catch(PowerShellNotAvailableException ex) {
		       ex.printStackTrace();
		   }
		return buildNo;
	}
	
	public static String getOSVersion() {
		String version = "";
		try (PowerShell powerShell = PowerShell.openSession()) {       
		       //Increase timeout to give enough time to the script to finish
		       Map<String, String> config = new HashMap<String, String>();
		       config.put("maxWait", "80000");
		       
		       //Execute script
		       PowerShellResponse response = powerShell.executeCommand("(Get-ItemProperty \"HKLM:\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\").ReleaseId");
		       version = "Version " + response.getCommandOutput();
		       
		       PowerShellResponse buildResponse = powerShell.configuration(config).executeCommand("Get-ComputerInfo -property WindowsBuildLabEx");
		       
		       //Print results if the script
		       String build = buildResponse.getCommandOutput();
		       
		       Pattern regex = Pattern.compile("(\\d+\\.\\d+)");
		       Matcher matcher = regex.matcher(build);
		        while(matcher.find()){
		            build =  matcher.group(1);
		       }
		       
		       //Print results if the script
		       version = version + "(OS Build " + build + ")";
		       powerShell.close();
		       
		   } catch(PowerShellNotAvailableException ex) {
		       ex.printStackTrace();
		   }
		return version;
	}
	
	public static String getOSVersionOld() {
		String version = "";
		try (PowerShell powerShell = PowerShell.openSession()) {       
		       //Increase timeout to give enough time to the script to finish
		       Map<String, String> config = new HashMap<String, String>();
		       config.put("maxWait", "10000");
		       
		       //Execute script
		       PowerShellResponse response = powerShell.executeCommand("(Get-WmiObject Win32_OperatingSystem).Version");
		       
		       //Print results if the script
		       version = response.getCommandOutput();
		       
		   } catch(PowerShellNotAvailableException ex) {
		       ex.printStackTrace();
		   }
		return version;
	}

}
