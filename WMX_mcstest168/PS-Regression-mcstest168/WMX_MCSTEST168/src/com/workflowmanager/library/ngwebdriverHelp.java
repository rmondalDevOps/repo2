package com.workflowmanager.library;

import org.openqa.selenium.JavascriptExecutor;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class ngwebdriverHelp extends TestBase {
	private static NgWebDriver ngDriver;
	
	public static void CommonNG_Click() {
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
		
		
                driver.findElement(ByAngular.model("first")).sendKeys("2");
                driver.findElement(ByAngular.model("second")).sendKeys("2");
                //driver.findElement(By.id("gobutton")).click();
                driver.findElement(ByAngular.buttonText("Go!")).click();

	}
	
	public static void CommonNG_WaitforAngularRequest() {
		//NgWebDriver ngWebDriver = new NgWebDriver(driver);
		ngDriver.waitForAngularRequestsToFinish();

	}

}
