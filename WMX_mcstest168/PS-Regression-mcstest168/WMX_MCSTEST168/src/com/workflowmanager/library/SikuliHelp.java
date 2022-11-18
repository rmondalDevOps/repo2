package com.workflowmanager.library;

import java.awt.image.BufferedImage;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class SikuliHelp extends TestBase {

	public static Capabilities cap = (driver).getCapabilities();
	public static String browserName = cap.getBrowserName();

	public static void selectLocationOnMapSikuli(String imgName) throws FindFailed {
		// SeleniumHelp.sync(10);
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("Safari")) {
			Screen screenMap_1 = new Screen();
			Pattern imageClickMap_1 = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
			screenMap_1.wait(imageClickMap_1, 30);
			int x = screenMap_1.findBest(imageClickMap_1).getX();
			int y = screenMap_1.findBest(imageClickMap_1).getY();
			System.out.println("x: " + x);
			System.out.println("y: " + y);
			Actions builder = new Actions(driver);
			builder.moveByOffset(x / 4, y / 4).click().perform();
		} else {
			try {
				Screen screenMap_2 = new Screen();
				Pattern imageClickMap_2 = new Pattern(
						System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
				screenMap_2.wait(imageClickMap_2, 30);
				screenMap_2.setAutoWaitTimeout(10);
				screenMap_2.findBest(imageClickMap_2, 10);
				screenMap_2.click(imageClickMap_2, 10);
				// screenMap_2.findBest(imageClickMap_2,10);
			} catch (Exception e) {
				// logger.log(Status.FAIL,MarkupHelper.createLabel("Image is NOT on the screen",
				// ExtentColor.RED));
				e.printStackTrace();
				throw e;
			}
		}
	}

	public static void sikuliClick(String imgName) throws Exception {

		Thread.sleep(10);
		Screen screenMap_4 = new Screen();
		Pattern patternLineFromImg = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
		screenMap_4.find(patternLineFromImg).highlight(5);
		screenMap_4.click(patternLineFromImg);

	}

	public static void selectLocationOnMapSikuliClick(String imgName) throws Exception {
		try {
			Screen screen1 = new Screen();
			Pattern imageClick10 = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
			screen1.wait(imageClick10.similar(0.7f), 60);
			screen1.findBest(imageClick10);
			screen1.click(imageClick10);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	public static boolean rightClickOnMap(String imgName) throws Exception {

		// SeleniumHelp.sync(10);
		boolean verifyImageExistsBoolean = false;

		/*
		 * long start_time = System.currentTimeMillis(); long wait_time = 10000; long
		 * end_time = start_time + wait_time;
		 */
		try {
			Screen scrTS4_TC2_1 = new Screen();
			Pattern patternTS4_TC2_1 = new Pattern(
					System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
			try {
				scrTS4_TC2_1.wait(patternTS4_TC2_1, 50);
			} catch (FindFailed e1) {
				e1.printStackTrace();
				throw e1;
			}
			/*
			 * while (scrTS4_TC2_1.exists(patternTS4_TC2_1) != null) {
			 * if(System.currentTimeMillis() > end_time) { break; } }
			 */
			if (scrTS4_TC2_1.exists(patternTS4_TC2_1, 50) != null) {

				scrTS4_TC2_1.findBest(patternTS4_TC2_1).highlight(5);
				scrTS4_TC2_1.mouseMove(patternTS4_TC2_1);
				scrTS4_TC2_1.mouseDown(Button.RIGHT);
				scrTS4_TC2_1.mouseUp();
				verifyImageExistsBoolean = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		// softAssert.assertTrue(verifyImageExistsBoolean);
		return verifyImageExistsBoolean;
		// TODO Auto-generated method stub
	}

	public static void selectLocationOnMapSikuliRightClick(String imgName) throws Exception {
		try {
			Screen s = new Screen();
			s.mouseMove(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
			Thread.sleep(1000);
			s.mouseDown(Button.RIGHT);
			Thread.sleep(1000);
			s.mouseUp(Button.RIGHT);
			Thread.sleep(1000);

			if (s.exists(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png") != null) {
				Thread.sleep(3000);
				s.click(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
				/*
				 * Screen screen1 = new Screen(); Pattern imageClick10 = new
				 * Pattern(System.getProperty("user.dir") +"/Images/Input/"+imgName+".png");
				 * screen1.wait(imageClick10, 30); screen1.findBest(imageClick10);
				 * screen1.click(imageClick10);
				 */
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	public static void hoveronLocationSikuli(String imgName) throws Exception {
		try {
			Screen screen1 = new Screen();
			Pattern imageClick10 = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
			screen1.wait(imageClick10, 30);
			screen1.findBest(imageClick10);
			// screen1.similar(0.4f);
			screen1.hover();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public static boolean verifyImageisAtCenter(Screen screenTS2TC, Pattern imageTS2TC) {
		boolean imgFound = false;
		try {
			/*
			 * // Click on screen Screen screenTS2TC = new Screen(); Pattern imageTS2TC =
			 * new Pattern(
			 * "C:\\BackupFrom_PS0002794\\Automation\\Workspace\\IndoorsWebAutomation_Final\\Images\\Input\\TS2_TC_CheckLocation.png"
			 * ); screenTS2TC.wait(imageTS2TC, 10000);
			 */

			// Highlight the image
			Region imgRegion = screenTS2TC.findBest(imageTS2TC).highlight(7, "Green");

			// Capture whole screen
			Screen whloleScreen = new Screen();

			// Capture whole screen center location
			Location centerLocation = whloleScreen.getScreen().getCenter();

			// Extend center coordinate boundry
			Region centerCoordinateExtendedBoundry = Region.grow(centerLocation, 450, 450).highlight(2);

			// verify if imgRegion is aligned at the center of the screen
			imgFound = centerCoordinateExtendedBoundry.contains(imgRegion);
			// logger.log(Status.PASS,MarkupHelper.createLabel("Image is at the center of
			// the screen", ExtentColor.GREEN));

		} catch (Exception e) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel("Image is NOT at the center of the screen", ExtentColor.RED));
			throw e;
		}
		return imgFound;
	}

	public static boolean verifyImageExists(String imgName) throws Exception {
		boolean verifyImageExistsBoolean = false;
		Screen scrTS4_TC2_1 = new Screen();
		Pattern patternTS4_TC2_1 = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");

		if (scrTS4_TC2_1.exists(patternTS4_TC2_1) != null) {
			verifyImageExistsBoolean = true;
			System.out.println("Element exists -->> " + patternTS4_TC2_1);
		}
		return verifyImageExistsBoolean;
	}

	public static void dragndropSikuli(String fromImg, String toImg, boolean overwriteStep)
			throws FindFailed, Exception {
		// SeleniumHelp.sync(10);
		System.out.println(browserName);
		try {
			Screen screenMap_3 = new Screen();
			Pattern patternFromImg = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + fromImg + ".png");
			Pattern patternToImg = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + toImg + ".png");
			// screenMap_3.wait(patternFromImg, 50);
			// screenMap_3.wait(patternToImg, 50);
			if (screenMap_3.exists(patternFromImg) != null) {
				System.out.println("Element exists" + patternFromImg);
				// logger.log(Status.PASS, MarkupHelper.createLabel(msg+" - Passed",
				// ExtentColor.GREEN));
			}
			/*
			 * screenMap_3.find(imageClickMap_3);
			 * //screenMap_3.findBest(imageClickMap_3,30).highlight(5);
			 * screenMap_3.click(imageClickMap_3,30);
			 */
			screenMap_3.find(patternFromImg).highlight(5);
			int xF = screenMap_3.find(patternFromImg).getX();
			int yF = screenMap_3.find(patternFromImg).getY();
			System.out.println("x: " + xF);
			System.out.println("y: " + yF);

			// if overwrite step, then no offset required
			if (overwriteStep) {
				System.out.println("In IF Block");
				// screenMap_3.wait(patternToImg.similar(0.7f),50);
				// 0.4f
				// screenMap_3.dragDrop(patternToImg.similar(0.7f));
				screenMap_3.dragDrop(patternToImg.similar(0.3f));
			} else {
				System.out.println("In ELSE Block");
				// screenMap_3.wait(patternToImg,50);
				screenMap_3.dragDrop(patternToImg.similar(0.3f).targetOffset(xF, yF / 2));
			}
			// screenMap_3.dragDrop(patternFromImg, Location(x + 100, y + 100));
			// screenMap_3.dragDrop(patternFromImg, Location(x, y + 100));
			// screenMap_3.dragDrop(100, 200); // Not working

			/*
			 * int xT = screenMap_3.find(toImg).getX(); int yT =
			 * screenMap_3.find(toImg).getY(); System.out.println("x: "+ xT);
			 * System.out.println("y: "+ yT); //screenMap_3.dragDrop(x, y+100);
			 * screenMap_3.dragDrop(patternToImg.targetOffset(xF, yF/3));
			 */

		} catch (Exception e) {
			// logger.log(Status.FAIL,MarkupHelper.createLabel("Image is NOT on the screen",
			// ExtentColor.RED));
			e.printStackTrace();
			throw e;
		}
	}

	// div[@id='libGroup0']/canvas

	public static void dragndrop_New(String fromImg, String toImg) throws FindFailed, Exception {
		// SeleniumHelp.sync(10);
		System.out.println(browserName);
		try {
			Screen screenMap_3 = new Screen();
			Pattern patternFromImg = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + fromImg + ".png")
					.similar(0.6f);
			Pattern patternToImg = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + toImg + ".png");
			// screenMap_3.wait(patternFromImg, 30000);
			// Pattern pattern = new
			// Pattern("C:\some\path\image.png").similar(0.8f).targetOffset(100,5);

			if (screenMap_3.exists(patternFromImg) != null) {
				System.out.println("Element exists" + patternFromImg);
				// logger.log(Status.PASS, MarkupHelper.createLabel(msg+" - Passed",
				// ExtentColor.GREEN));
			}
			if (screenMap_3.exists(patternToImg) != null) {
				System.out.println("Element exists" + patternToImg);
				// logger.log(Status.PASS, MarkupHelper.createLabel(msg+" - Passed",
				// ExtentColor.GREEN));
			}
			/*
			 * screenMap_3.find(imageClickMap_3);
			 * //screenMap_3.findBest(imageClickMap_3,30).highlight(5);
			 * screenMap_3.click(imageClickMap_3,30);
			 */

			screenMap_3.find(patternFromImg).highlight(5);
			int xF = screenMap_3.find(patternFromImg).getX();
			int yF = screenMap_3.find(patternFromImg).getY();
			int wF = screenMap_3.find(patternFromImg).getW();
			int hF = screenMap_3.find(patternFromImg).getH();
			System.out.println("x: " + xF);
			System.out.println("y: " + yF);
			System.out.println("x: " + wF);
			System.out.println("y: " + hF);

			int xT = screenMap_3.find(patternToImg).getX();
			int yT = screenMap_3.find(patternToImg).getY();
			// int wT= screenMap_3.find(patternToImg).getW();
			// int hT= screenMap_3.find(patternToImg).getH();
			System.out.println("x: " + xT);
			System.out.println("y: " + yT);
			System.out.println("x: " + wF);
			System.out.println("y: " + hF);
			// patternFromImg.targetOffset(xT, yT);

			// WebElement LocatorFrom = CommonFunction.getWebElement("xpath",
			// "//div[@id='libGroup0']/canvas");

			/*
			 * Actions builder = new Actions(driver); builder.moveByOffset(x,
			 * y).clickAndHold().moveByOffset(100, 100).release().build().perform();
			 * System.out.println("moveByOffset "); //div[@id='libGroup0']/canvas
			 * 
			 * 
			 */
			/*
			 * // Get the mouse org.openqa.selenium.interactions.Mouse mouse =
			 * ((HasInputDevices)driver).getMouse();
			 * 
			 * // Clear previous mouse operations saved (if any) ((Object)
			 * mouse).clearActions(); // Add the operation in class A
			 * mouse.dragThumbnail(startPosition); // Add the operation in class B
			 * mouse.dropInDivider(endPosition); // Perform the operation now
			 * mouse.perform();
			 */

			/*
			 * ((JavascriptExecutor)driver).
			 * executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; "
			 * +
			 * "simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]);",LocatorFrom
			 * ,xT,yT);
			 */

			// get the WrapsDriver of the WebElement
			/*
			 * WrapsDriver wrapsDriver = (WrapsDriver) driver;
			 * 
			 * // get the entire screenshot from the driver of passed WebElement File screen
			 * = ((TakesScreenshot) wrapsDriver.getWrappedDriver())
			 * .getScreenshotAs(OutputType.FILE);
			 * 
			 * // create an instance of buffered image from captured screenshot
			 * BufferedImage img = ImageIO.read(screen);
			 * 
			 * // create a rectangle using width and height Rectangle rect = new
			 * Rectangle(xF,yF,wF, hF);
			 * 
			 * // create image for element using its location and size. // this will give
			 * image data specific to the WebElement BufferedImage dest =
			 * img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
			 */

			/*
			 * JavascriptExecutor executorImg = (JavascriptExecutor) driver;
			 * executorImg.executeScript("map.on('click', function(e){\r\n" +
			 * "  var coord = e.latlng;" +
			 * "  alert(\"You clicked the map at latitude: \" + coord.lat + \" and longitude: \" + coord.lng);"
			 * + "  });");
			 * 
			 * map.on('click', function(e) { alert("Lat, Lon : " + e.latlng.lat + ", " +
			 * e.latlng.lng) });
			 */

		} catch (Exception e) {
			// logger.log(Status.FAIL,MarkupHelper.createLabel("Image is NOT on the screen",
			// ExtentColor.RED));
			e.printStackTrace();
			throw e;
		}
	}

	public static Point match(BufferedImage subimage, BufferedImage image) {
		// brute force N^2 check all places in the image
		for (int i = 0; i <= image.getWidth() - subimage.getWidth(); i++) {
			check_subimage: for (int j = 0; j <= image.getHeight() - subimage.getHeight(); j++) {
				for (int ii = 0; ii < subimage.getWidth(); ii++) {
					for (int jj = 0; jj < subimage.getHeight(); jj++) {
						if (subimage.getRGB(ii, jj) != image.getRGB(i + ii, j + jj)) {
							continue check_subimage;
						}
					}
				}
				// if here, all pixels matched
				return new Point(i, j);
			}
		}
		return null;
	}

	// edited by sarath
	public static void selectLocationOnSikuliClick(String imgName) throws Exception {
		try {
			Screen screen1 = new Screen();
			Pattern imageClick10 = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + imgName + ".png");
			screen1.click(imageClick10);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	public static void connectStepsLine(String fromImg, String fromLineIconImg, String toImg, String toLineIconImg)
			throws FindFailed, Exception {
		// SeleniumHelp.sync(10);
		System.out.println(browserName);
		try {
			Screen screenMap_4 = new Screen();
			Pattern patternLineFromImg = new Pattern(
					System.getProperty("user.dir") + "/Images/Input/" + fromImg + ".png");
			Pattern patternLineIconFromImg = new Pattern(
					System.getProperty("user.dir") + "/Images/Input/" + fromLineIconImg + ".png");

			// Pattern patternLineToImg = new Pattern(System.getProperty("user.dir")
			// +"/Images/Input/"+toImg+".png");
			Pattern patternLineIconToImg = new Pattern(
					System.getProperty("user.dir") + "/Images/Input/" + toLineIconImg + ".png");
			screenMap_4.wait(patternLineFromImg, 30000);
			if (screenMap_4.exists(patternLineFromImg) != null) {
				System.out.println("Element exists" + patternLineFromImg);
				// logger.log(Status.PASS, MarkupHelper.createLabel(msg+" - Passed",
				// ExtentColor.GREEN));
			}
			screenMap_4.findBest(patternLineFromImg).highlight(5);
			// screenMap_4.find(patternLineFromImg).hover();
			screenMap_4.click(patternLineFromImg);

			screenMap_4.findBest(patternLineIconFromImg).highlight(5);
			screenMap_4.click(patternLineIconFromImg);
			screenMap_4.dragDrop(patternLineIconToImg);

			// screenMap_4.findBest(patternLineIconToImg).highlight(5);
			// screenMap_4.wait(5000);
			// screenMap_4.dragDrop(patternLineIconToImg);

			/*
			 * int xF = screenMap_4.find(patternLineIconFromImg).getX(); int yF =
			 * screenMap_4.find(patternLineIconFromImg).getY(); System.out.println("x: "+
			 * xF); System.out.println("y: "+ yF);
			 */
			/*
			 * screenMap_4.find(patternLineFromImg).highlight(5);
			 * screenMap_4.find(patternLineFromImg).hover();
			 * screenMap_4.click(patternLineFromImg);
			 */

		} catch (Exception e) {
			// logger.log(Status.FAIL,MarkupHelper.createLabel("Image is NOT on the screen",
			// ExtentColor.RED));
			e.printStackTrace();
			throw e;
		}
	}

	public static void connectStepsLineNew(String fromImg, String fromLineIconImg, String toImg, String toLineIconImg)
			throws FindFailed, Exception {
		// SeleniumHelp.sync(10);
		System.out.println(browserName);
		try {
			Screen screenMap_4 = new Screen();
			Pattern patternLineFromImg = new Pattern(
					System.getProperty("user.dir") + "/Images/Input/" + fromImg + ".png");
			Pattern patternLineIconFromImg = new Pattern(
					System.getProperty("user.dir") + "/Images/Input/" + fromLineIconImg + ".png");

			// Pattern patternLineToImg = new Pattern(System.getProperty("user.dir")
			// +"/Images/Input/"+toImg+".png").similar(0.6f);
			Pattern patternLineIconToImg = new Pattern(
					System.getProperty("user.dir") + "/Images/Input/" + toLineIconImg + ".png").similar(0.6f);
			// screenMap_4.wait(patternLineFromImg, 30000);
			if (screenMap_4.exists(patternLineFromImg) != null) {
				System.out.println("Element exists" + patternLineFromImg);
				// logger.log(Status.PASS, MarkupHelper.createLabel(msg+" - Passed",
				// ExtentColor.GREEN));
			}
			screenMap_4.find(patternLineFromImg).highlight(5);
			screenMap_4.click(patternLineFromImg);

			screenMap_4.find(patternLineIconFromImg).highlight(5);
			screenMap_4.click(patternLineIconFromImg);

			// screenMap_4.wait(patternLineIconToImg, 30000);
			screenMap_4.dragDrop(patternLineIconToImg);

		} catch (Exception e) {
			// logger.log(Status.FAIL,MarkupHelper.createLabel("Image is NOT on the screen",
			// ExtentColor.RED));
			e.printStackTrace();
			throw e;
		}
	}

	public static void dragNDrop(String fromImg, String toImg) throws Exception {
		try {
			Thread.sleep(10);
			Screen screenSaf_10 = new Screen();
			Pattern imageClick10 = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + fromImg + ".png");
			Pattern imageClick11 = new Pattern(System.getProperty("user.dir") + "/Images/Input/" + toImg + ".png");
			screenSaf_10.wait(imageClick10.similar(0.6f), 10000);
			// screenSaf_10.findBest(imageClick10).highlight(5);
			screenSaf_10.dragDrop(imageClick10.similar(0.6f), imageClick11.similar(0.6f));
			Thread.sleep(10);
		} catch (Exception e) {
			throw e;
		}
	}
}
