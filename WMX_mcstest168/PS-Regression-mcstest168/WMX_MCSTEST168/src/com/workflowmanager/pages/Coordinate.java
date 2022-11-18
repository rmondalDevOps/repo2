package com.workflowmanager.pages;

import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.compiler.custom_proxymaker.CustomAnnotation.Priority;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class Coordinate extends TestBase {

	private static final String SEARCHTEXTINPUT_XPATH = "//div[@class='c-searchBar c-searchBar--noRightBtn t-searchBar ng-star-inserted']//input[@class='c-searchBar__searchInput t-searchInput']";
	private static final String NEWJOB_XPATH = "//div[contains(@class,'c-customTab c-custotmTab--borderTop t-createJobTab')]";
	private static final String SEARCHJOB_XPATH = "(//div[contains(@class,'c-customTab__headerTitle')])[1]";
	private static final String SEARCHEDLISTITEM_XPATH = "//h4[@class='c-thumbnailCard__title t-jobTemplateName']";
	private static final String JOBPRIORITY_XPATH = "//div[@id='chart6']//*[@class=' c3-shape c3-shape c3-arc c3-arc-setosa']";
	private static final String ALLJOB_XPATH = "//ul[@class='p-listbox-list']/li[1]";
	private static final String EXPANDJOBLIST_XPATH = "//div[contains(@class,'bottomPanelExpandHandle')]";
	private static final String JOBNAMEHEADER_XPATH = "//thead[@class='p-datatable-thead']//th[2]";
	private static final String INFOPANELHEADER_XPATH = "//wmx-advanced-input[@class='c-jobDetailPanel__headerText t-jobTitleText ng-star-inserted']";
	private static final String ASSIGNEDTOHEADER_XPATH = "//thead[@class='p-datatable-thead']//th[1]";
	private static final String PRIORITYHEADER_XPATH = "//thead[@class='p-datatable-thead']//th[4]";
	private static final String DUEDATEHEADER_XPATH = "//thead[@class='p-datatable-thead']//th[6]";
	private static final String STATUSHEADER_XPATH = "//thead[@class='p-datatable-thead']//th[5]";
	private static final String SHOWMORE_XPATH = "//td[contains(@class,' t-btnShowMore')]";
	private static final String EXTEND_PROPERTIES_EDIT_BTNS_XPATH = "(//calcite-button[@class='p-element c-jobDetailPanel__editPanelBtnControl t-editExtPropsBtn ng-star-inserted'])";
	private static final String DROPDOWN_BTNS_XPATH = "(//button[contains(@class,'p-autocomplete-dropdown')])";
	//private static final String JOBNAMELIST_XPATH = "//tbody[@class='p-datatable-tbody']/tr/td[2]/span";
	private static final String JOBNAMELIST_XPATH = "//tbody[@class='p-element p-datatable-tbody']/tr/td[2]/span";

	
	private static final String JOBNAMELIST1_XPATH = "s";
	private static final String JOBLIST_TITLES_XPATH = "((//thead)/tr/th)";
	private static final String FIRSTJOBNAME = "(//th[@class='ui-resizable-column ng-star-inserted'])[2]";
	private static final String DROPDOWN_VALUES_XPATH = "//li[contains(@class,'p-autocomplete')]/span";
	private static final String COLLAPSEJOBLIST_XPATH = "//div[contains(@class,'t-bottomPanelCollapseHandle')]";
	private static final String CURRENTHEADER_XPATH = "//thead[@class='ui-table-thead']//th[6]";
	//private static final String ELLIPSIS_XPATH = "//button[@class='btn btn-transparent dropdown-btn js-dropdown-toggle'] ";
	private static final String ELLIPSIS_XPATH = "//button[contains(@class,'icon-btn--gray t-moreActionBtn')]";
	private static final String ELLIPSIS_SHADOW_XPATH = "document.querySelector('calcite-button.t-moreActionBtn').shadowRoot.querySelector('button')";
	private static final String ASSIGNMENTLIST_XPATH = "//tbody[@class='p-element p-datatable-tbody']/tr/td[1]/span";
	private static final String STATUSLIST_XPATH = "//tbody[@class='p-element p-datatable-tbody']/tr/td[6]/span";
	private static final String CURRENTSTEPLIST_XPATH = "//td[6][@class='ng-star-inserted']";
	private static final String PRIORITYLIST_XPATH = "//tbody[@class='p-element p-datatable-tbody']/tr/td[4]/span";
	private static final String ASSIGNEDTO_XPATH = "//tbody[@class='p-element p-datatable-tbody']/tr/td[1]/span";
	
	//private static final String RIGHTTRIANGLE_XPATH = "//div[@class='c-collapsiblePanel__handle c-collapsiblePanel__handle--left t-rightPanelHandle']";
	private static final String RIGHTTRIANGLE_XPATH = "//div[contains(@class,'c-collapsiblePanel__handle c-collapsiblePanel__handle--left t-rightPanelHandle')]";

	
	private static final String CARDCONTENT_XPATH = "(//div[@class='c-cardList ng-star-inserted']//div[@class='c-thumbnailCard__content'])";
	private static final String CARDITEMNAME_XPATH = "//div[@class='c-cardList ng-star-inserted']//div[@class='c-thumbnailCard__content']/h4";
	// private static final String ALERT_XPATH = "//div[@class='c-alert alert
	// alert-green is-active ng-star-inserted']";
	private static final String CREATEDEFAULT_XPATH = "//button[@class='c-thumbnailCard__button btn btn-transparent btn-create-job t-btnCreateJob ng-star-inserted']";
	private static final String ADVANCED_XPATH = "//button[@class='c-thumbnailCard__button btn btn-transparent btn-create-job ng-star-inserted']";
	private static final String TITLE_XPATH = "//h4[@class='c-thumbnailCard__title t-jobTemplateName']";
	// private static final String JOBNAMELIST_XPATH =
	// "//td[1][@class='ng-star-inserted']";
	private static final String DESCRIPTION_XPATH = "//p[@class='c-thumbnailCard__des font-size--1 ng-star-inserted']";
	private static final String CHARTTITLE_XPATH = "//div[contains(@class,'RightPanel__chartTitle')]";
	private static final String ALLJOBS_XPATH = "//ul[@class='p-listbox-list']/li[1]";
	private static final String CHARTQUANTITY_XPATH = "(//div[@class='tooltipContainer']//div[@class='tooltip-value'])";
	private static final String CHARTCATEGORY_XPATH = "(//div[@class='c-coordinateSummaryPanel__chartBottom']/div//div)";
	//private static final String SHARED_SEARCH_XPATH = "//ul[@class='ui-listbox-list']/li";
	private static final String SHARED_SEARCH_XPATH = "//ul[@class='p-listbox-list']/li";
	private static final String CHARTDETAIL_XPATH = "//span[contains(@class,'summaryStatsNum')]";
	private static final String MYJOB_XPATH = "//ul[@class='p-listbox-list']/li[3]";
	private static final String ACTIVE_MYJOB_XPATH = "//ul[@class='ui-listbox-list']/li[@aria-label='My Jobs' and @class='ng-star-inserted ui-listbox-item ui-corner-all ui-state-highlight']";
	private static final String CHARTSPANEL_XPATH = "//div[@class='c-productionRightPanel__chart'][2]";
	private static final String SEARCH_JOB_XPATH = "//input[contains(@placeholder,'Search Jobs')]";
	private static final String SEARCH_1_XPATH = "((//ul[@class='p-listbox-list'])[2]//li)[1]";
	private static final String SEARCH_2_XPATH = "((//ul[@class='p-listbox-list'])[2]//li)[2]";
	private static final String CLEAR_SEARCH_XPATH = "//calcite-button[@class='p-element c-searchBar__clearFilterBtn ng-star-inserted']";
	//private static final String NEW_SHARED_SEARCH_XPATH = "//ul[@class='ui-listbox-list']/li[4]";
	private static final String NEW_SHARED_SEARCH_XPATH = "//ul[@class='p-listbox-list']/li[4]";
	private static final String EDIT_SEARCH1_XPATH = "(//div[@class='c-queryTab--btnContainer ng-star-inserted']/div[@class='p-element c-iconBtn t-queryEditBtn'])[1]";
	private static final String DELETE_SEARCH1_XPATH = "(//div[@class='c-queryTab--btnContainer ng-star-inserted']/div[@class='p-element c-iconBtn t-queryDeleteBtn'])[1]";
	private static final String DELETE_SEARCH2_XPATH = "(//div[@class='c-queryTab--btnContainer ng-star-inserted']/div[@class='p-element c-iconBtn t-queryDeleteBtn'])[2]";
	private static final String EDIT_SYNTAX_SEARCH1_XPATH = "//input[@placeholder='Edit Syntax']";
	private static final String CANCEL_QUERY_SYNTAX_XPATH = "(//div[@class='c-queryTab--btnContainer ng-star-inserted']/div[@class='p-element c-iconBtn t-cancelEditBtn'])";
	private static final String SAVE_QUERY_SYNTAX_XPATH = "(//div[@class='c-queryTab--btnContainer ng-star-inserted']/div[@class='p-element c-iconBtn t-saveEditBtn'])";
	private static final String NO_DATA_AVAILABLE_XPATH = "//div[@class='c-coordinateJobPanel__NAText ng-star-inserted']";
	//private static final String USERSECTION_BUTTON_XPATH = "//span[@class='header-account-name']";
	private static final String USERSECTION_BUTTON_XPATH = "//span[@class='flexbox-alignCenter header-account-name']";
	//private static final String SIGNOUT_BUTTON_XPATH = "//a[@class='dropdown-link']";
	private static final String SIGNOUT_BUTTON_XPATH = "//calcite-dropdown-item[text()=' Sign Out ']";
	private static final String TEMPLATELIST_XPATH = "//div[@class='p-element c-thumbnailCard card card-wide t-jobTemplateCard ng-star-inserted']";
	private static final String ELLIPSEBUTTON_XPATH = "//span[@class='icon-ui-handle-vertical']";
	private static final String DELETEJOBBUTTON_XPATH = "(//span[@class='p-menuitem-text ng-star-inserted'])[2]";
	private static final String SUCCESSMSG_XPATH = "//wmx-toast//div";
	private static final String CONFIRM_DELETEJOBBUTTON_YES_XPATH = "(//span[@class='p-button-text'])[2]";
	private static final String CONFIRM_DELETEJOBBUTTON_NO_XPATH = "(//span[@class='p-button-text'])[1]";
	private static final String ASSIGNTOSELF_XPATH = "//calcite-button[@class='p-element']";
	private static final String EDITJOBDETAIL_XPATH = "(//span[@class='icon-ui-edit'])[2]";
	private static final String EDITJOBDETAIL_XPATH_NEW = "//calcite-button[contains(@class,'t-editDetailsBtn')]";
	private static final String EDITJOBDETAIL_SHADOW_XPATH = "document.querySelector('p-header > calcite-button').shadowRoot.querySelector('button')";
	//private static final String ASSIGNMENTDROPDOWNLIST_XPATH = "//div[@class='categoryItem ng-star-inserted']";
	private static final String ASSIGNMENTDROPDOWNLIST_XPATH = "//div[@class='categoryItem t-categoryItem ng-star-inserted']";
	
	private static final String ASSIGNMENTDROPDOWNOPEN_XPATH = "//button[contains(@class,'p-button-secondary')]";
	private static final String SAVE_EDIT_DETAILS_XPATH = "//calcite-button[contains(@class,'t-saveDetailsBtn')]";
	private static final String SAVE_EDIT_DETAILS_SHADOW_XPATH = "document.querySelector('calcite-button.c-jobDetailPanel__editPanelBtnControl.btn-showTooltipWhenDisabled.t-saveDetailsBtn').shadowRoot.querySelector('button')";
	private static final String DRPDWN_TEXT_XPATH = "(//span[contains(@class,' ui-dropdown-label')])[3]";
	private static final String REQUIRED_EXTEND_PROPERTIES_XPATH = "(//div[contains(@class,'ui-accordion-content ui-widget-content')])[3]";
	private static final String OPTIONS_DRPDWN_BOOL_XPATH = "//ul[contains(@class,'p-dropdown-items')]//li";
	private static final String OPEN_DRPDWN_BOOL_XPATH = "(//div[contains(@class,'p-dropdown-trigger')])[3]";
	private static final String NORMAL_DEFAULT_EXTEND_PROPERTIES_XPATH = "(//div[contains(@class,'ui-accordion-content ui-widget-content')])[6]";
	private static final String INFOPANEL_NAME_XPATH = "//span[@class='c-advancedInput__input text-ellipsis t-advancedInput__input--normal']";
	private static final String JOBPANEL_PROPERTIES_VALUE_XPATH = "(//div[contains(@class,'c-propertyContainer__content')])";
	private static final String MORE_XPATH = "(//span[contains(@class,'p-accordion-header-text')])[3]";
	private static final String UPGRADE_JOB_BTN_XPATH = "//div[contains(@class,'c-jobDetailPanel__actionMenu')]/ul/li[4]";
	private static final String COLLAPSELEFTPANEL_XPATH = "(//div[contains(@class,'c-collapsiblePanel__handle')])[1]";
	private static final String COLLAPSELEFTPANEL1_XPATH = "(//div[contains(@class,'c-collapsiblePanel__handle')])[1]";
	private static final String COLLAPSERIGHTPANEL1_XPATH = "(//div[contains(@class,'c-collapsiblePanel__handle')])[2]";
	private static final String RIGHT_TRIANGLE_ARROW_XPATH = "//div[@class='c-collapsiblePanel__handle c-collapsiblePanel__handle--left t-rightPanelHandle']";
	private static final String LEFT_TRIANGLE_ARROW_XPATH = "(//span[contains(@class,'icon-ui-left-triangle-arrow')])[2]";
	private static final String FIRST_SUMMARY_CHART_XPATH = "(//div[@class='c-coordinateSummaryPanel__chartTitleContainer'])[3]/calcite-button";
	private static final String TOTAL_JOBS_SUMMARY_CHART_XPATH = "(//span[contains(@class,'c-coordinateSummaryPanel__summaryStatsNum')])[1]";
	private static final String CLEAR_SUMMARY_CHART_SELECTION_XPATH = "//calcite-button[@class='btn-noWrap t-clearExpandedChartBtn']";
	private static final String SELECT_BTN_XPATH="(//div[@class='esri-popup__button esri-popup__action'])[1]";
	private static final String ZOOM_BTN_XPATH="(//div[@class='esri-popup__button esri-popup__action'])[2]";
	private static final String ZOOM_TO_ALL_BTN_XPATH="//calcite-button[@class='c-coordinateMapContainer__floatingMapZoomToAll']";
	private static final String CLEAR_FILTER_BTN_XPATH="//calcite-button[@class='p-element t-clearAllBtn ng-star-inserted']";
	private static final String SHOW_LABEL_SLIDER_XPATH = "(//span[@class='p-inputswitch-slider'])";
	private static final String FILTER_XPATH="//calcite-button[@class='p-element t-filterBtn']";
	private static final String SEARCH_MAP_XPATH="//input[@class='esri-input esri-search__input']";
	private static final String REFRESH_RESULT_XPATH="//div[@class='c-coordinateMapContainer__floatingMapButton ng-star-inserted']//calcite-chip";
	private static final String ACTION_LIST_XPATH="//calcite-button[@class='p-element c-coordinateJobPanel__gridActionBtn ng-star-inserted']";
	//private static final String DIAGRAM_AND_MAP_TAB_XPATH="(//ul[@class='ui-tabview-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all ng-star-inserted']/li)[5]";
	private static final String DIAGRAM_AND_MAP_TAB_XPATH="(//ul[@class='p-tabview-nav']/li)[6]";
	private static final String DIAGRAM_XPATH="//div[@id='job_diagram']";
	private static final String SET_AS_CURRENT_DISABLE_XPATH="//li[@class='p-element disabled ng-star-inserted']";
	private static final String SET_AS_CURRENT_DISABLE_XPATH_POPUP="(//li[@class='disabled ng-star-inserted'])[2]";
	//private static final String UPDATE_VIEW_XPATH="(//div[contains(@class,'ui-dropdown-trigger')])[1]";
	private static final String UPDATE_VIEW_XPATH="(//div[contains(@class,'p-dropdown-trigger')])[1]";
	//private static final String UPDATE_VIEW_DROPDOWN_LIST_XPATH="(//ul[contains(@class,'ui-dropdown-items')]//li/div)";
	private static final String UPDATE_VIEW_DROPDOWN_LIST_XPATH="(//ul[contains(@class,'p-dropdown-items')]//li/div)";
	//private static final String MYGROUPJOB_XPATH = "//ul[@class='ui-listbox-list']/li[2]";
	private static final String MYGROUPJOB_XPATH = "//ul[@class='p-listbox-list']/li[2]";
	private static final String  BASEMAP_XPATH= "//div[@title='Change Basemap']";
	private static final String EXPAND_PANEL_BTNS_XPATH= "(//div[@class='esri-expand__panel'])";
	private static final String MANAGE_LAYER_LIST_XPATH = "//ul[@class='esri-layer-list__list esri-layer-list__list--root esri-layer-list__list--independent']/li";
	private static final String MAP_ITEM_ERROR_XPATH = "//div[@class='c-sectionError t-sectionError ng-star-inserted']";
	private static final String CANCEL_BTN_REQUIRED_XPATH ="//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl t-closeExtPropsBtn')]";
	private static final String DOCK_BTN_XPATH ="//div[@class='esri-popup__button esri-popup__button--dock']";	
	
	private static final String DISABLE_EDIT_BTN_XPATH ="//calcite-icon[contains(@class,'infoIcon float-right ng-star-inserted')]";
	
	
	
	
	
	static CommonFunction cfunction = new CommonFunction();
	
	
	//#3279 edited by arpit(GitHub)
	
	public static void clickEllipseVerifyUpgradePresence1(String msg) {
			
			cfunction.CommmonJS_Click_ShadowPath(ELLIPSIS_SHADOW_XPATH);
			cfunction.sync(7);
			//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a
			cfunction.isPageElementPresent("xpath", "//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a");
			cfunction.sync(7);
			List<WebElement> elements = driver.findElementsByXPath("(//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a)[contains(@class,'disabled')]");
			int ele = elements.size();
			if(ele==1) {
				cfunction.sync(7);
				CommonFunction.logStatus("PASS", msg + " it passed because Upgrade Button is Enabled");
				cfunction.Commmon_Click("xpath", "(//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a)[3]");
			}  else {
				CommonFunction.logStatus("FAIL", msg + " but it failed because Upgrade Button is Disabled");
				System.out.println("Element is disbled");
			}
				
		}
		
	public static void clickEllipseVerifyUpgradePresence2(String msg) {
			
			cfunction.CommmonJS_Click_ShadowPath(ELLIPSIS_SHADOW_XPATH);
			cfunction.sync(7);
			//(//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a)[3]
			//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a
			cfunction.isPageElementPresent("xpath", "//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a");
			cfunction.sync(7);
			List<WebElement> elements = driver.findElementsByXPath("(//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a)[contains(@class,'disabled')]");
			int ele = elements.size();
			if(ele==1) {
				cfunction.sync(7);
				CommonFunction.logStatus("FAIL", msg + " but it failed because Upgrade Button is Enabled");
				//cfunction.Commmon_Click("xpath", "(//div[contains(@class, 't-jobDetailPanel__actionMenu')]/ul/li/a)[3]");
			}  else {
				CommonFunction.logStatus("PASS", msg + "it passed because Upgrade Button is Disabled");
				System.out.println("Element is disbled");
			}
				
		}
		
	
	
	//
	
	
	
	
	
	public static boolean verifyDiagramVisibleOnDiagramAndMapTap() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(DIAGRAM_XPATH));
		if (rows.size()>=1)
			return true;
		return false;
	}
	public static boolean verifyJobExtendPropertiesSectionVisible() throws Exception {
		boolean verified=false;
		List<WebElement> rows = driver.findElements(By.xpath("//span[@class='leftContent']"));
		if (rows.size()==4)
			return true;
		return false;
	}
	public static boolean verifyEditBtnDisable() throws Exception {
		boolean verified=false;
		if(cfunction.elementIsDisplayed(DISABLE_EDIT_BTN_XPATH)) {
			verified=true;
		}
		else {
			verified=false;
		}
		return verified;
		}
	public static boolean verifyAddRecordDisable() throws Exception {
		boolean verified=false;
		List<WebElement> rows = driver.findElements(By.xpath("//button[@t-itemname='addRecordBtn']"));
		if (rows.size()==2)
			return true;
		return false;
	}
	public static boolean verifyMapItemError(String error) throws Exception {
		boolean verified=true;
		WebElement rows = driver.findElementByXPath(MAP_ITEM_ERROR_XPATH);
		//WebElement rows = driver.findElements(By.xpath(MAP_ITEM_ERROR_XPATH));
		System.out.println(rows.getText());
		/*for (WebElement row : rows) {
			System.out.println(row.getText());*/
			System.out.println(error);
			if (rows.getText().equalsIgnoreCase(error)) {
				verified= true;
			}
			else {
				verified= false;
			}
			return verified;
		}
		
	
	public static boolean clickOnManageListOption(String option) throws Exception {
		boolean verified=true;
		List<WebElement> rows = driver.findElements(By.xpath(MANAGE_LAYER_LIST_XPATH));
		for (WebElement row : rows) {
			System.out.println(row.getText());
			if (row.getText().equalsIgnoreCase(option)) {
				row.click();
				verified= true;
				break;
			}
			else {
				verified= false;
			}
		}
		return verified;
	}
	
	public static boolean verifyBasemapOptionVisible() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(EXPAND_PANEL_BTNS_XPATH));
		if (rows.size()>2)
			return true;
		return false;
	}
	public static void clickOnManageLayers() {
		cfunction.Commmon_Click("xpath", EXPAND_PANEL_BTNS_XPATH+"[1]");
	}
	public static boolean verifyCanvasStyle(String style) {
		boolean verified = false;
		//List<WebElement> items = driver.findElements(By.xpath(SEARCHEDLISTITEM_XPATH));
		WebElement items = driver.findElementByXPath("//canvas");
		String b=items.getAttribute("style");
			if (b.equalsIgnoreCase(style)) {
				verified = true;
				System.out.println(b + " found in Search List");
				verified=true;
			}
			else {
				verified=false;
			}
		return verified;
	}
	public  static boolean verifyCurrentPageURL(String expectedURL) {
		boolean verified = false;
		String landingPageURL = driver.getCurrentUrl();
		System.out.println(landingPageURL);
		System.out.println(expectedURL);
		if(landingPageURL.contains(expectedURL)) {
			verified = true;
		}
		return verified;
	
	}
	public static void selectUpdateViewFromDropdown(String username) throws Exception {
		cfunction.Commmon_Click("xpath", UPDATE_VIEW_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(UPDATE_VIEW_DROPDOWN_LIST_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(username)) {
				row.click();
				break;
			}
		}
	}
	public static void cursorHoverOnSetAsCurrentBtn() {
		/*element = CommonFunction.getWebElement("xpath", SET_AS_CURRENT_DISABLE_XPATH);
		cfunction.hoverOnElement(element);
		cfunction.sync(5);*/
		cfunction.hoverByAction(SET_AS_CURRENT_DISABLE_XPATH);
		/*cfunction.sync(5);
		cfunction.hoverByJS(element);
		System.out.println(element);
		Actions hover = new Actions(driver);
		hover.moveToElement(element);
		hover.build();
		hover.perform();*/
		System.out.println("Mouse hover");
	}
	public static void cursorHoverOnSetAsCurrentBtn1() {
		/*element = CommonFunction.getWebElement("xpath", SET_AS_CURRENT_DISABLE_XPATH);
		cfunction.hoverOnElement(element);
		cfunction.sync(5);*/
		cfunction.hoverByAction(SET_AS_CURRENT_DISABLE_XPATH_POPUP);
		/*cfunction.sync(5);
		cfunction.hoverByJS(element);
		System.out.println(element);
		Actions hover = new Actions(driver);
		hover.moveToElement(element);
		hover.build();
		hover.perform();*/
		System.out.println("Mouse hover");
	}
	public static boolean verifySetAsCurrentOptionDisable() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(SET_AS_CURRENT_DISABLE_XPATH));
		if (rows.size()>=1)
			return true;
		return false;
	}
	// click on New Job Tab
	public static void clickOnNewJob() {
		//cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		//cfunction.Commmon_Click("xpath", NEWJOB_XPATH);
		cfunction.CommmonJS_Click(NEWJOB_XPATH);
	}
	public static void clickOnRightTriangleArrow1() {
		cfunction.Commmon_Click("xpath", RIGHT_TRIANGLE_ARROW_XPATH);
	}
	public static void clickOnSelectBtn() {
		cfunction.Commmon_Click("xpath", SELECT_BTN_XPATH);
	}
	public static void clickOnFirstSummaryChart() {
		//cfunction.Commmon_Click("xpath", FIRST_SUMMARY_CHART_XPATH);
		cfunction.hoverByAction("(//div[@class='c-coordinateSummaryPanel__chartTitleContainer'])[3]");
		cfunction.sync(2);
		cfunction.CommmonJS_Click(FIRST_SUMMARY_CHART_XPATH);
	}
	public static void clickOnLeftTriangleArrow1() {
		cfunction.Commmon_Click("xpath", LEFT_TRIANGLE_ARROW_XPATH);
	}
	public static void clickOnZoomBtn() {
		cfunction.Commmon_Click("xpath", ZOOM_BTN_XPATH);
	}
	public static void clickOnZoomToAllBtn() {
		cfunction.Commmon_Click("xpath", ZOOM_TO_ALL_BTN_XPATH);
	}
	public static void clickOnClearFilterBtn() {
		cfunction.Commmon_Click("xpath", CLEAR_FILTER_BTN_XPATH);
	}
	public static void clickOnShowLabelSlider() {
//		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", SHOW_LABEL_SLIDER_XPATH);
	}
	public static void clickOnMyGroupJobs() {
		cfunction.Commmon_Click("xpath", MYGROUPJOB_XPATH);
	}
	public static void clickOnRestrictResultToMapExtent() {
		cfunction.Commmon_Click("xpath", SHOW_LABEL_SLIDER_XPATH+"[2]");
	}
	public static void clickOnClearSelection() {
		cfunction.Commmon_Click("xpath", CLEAR_SUMMARY_CHART_SELECTION_XPATH);
	}
	public static void clickOnRefreshResult() {
		//cfunction.sync(2);
		cfunction.Commmon_Click("xpath", REFRESH_RESULT_XPATH);
	}
	public static void clickOnFilter() {
//		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", FILTER_XPATH);
	}
	public static void clickOnCollapseLeftPanel1() {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
	}
	public static void clickOnCollapseRightPanel1() {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", COLLAPSERIGHTPANEL1_XPATH);
	}
	
	public static void clickOnLeftCollapseBtn() {
		cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
	}

	public static void clickOnassignToSelf() {
		cfunction.Commmon_Click("xpath", ASSIGNTOSELF_XPATH);
		//cfunction.CommmonJS_Click_ShadowPath("document.querySelector('div:nth-child(3) > div.c-propertyContainer__contentCombo.t-jobAssignedTo__control.ng-star-inserted > calcite-button').shadowRoot.querySelector('button')");
	}

	public static void enterSearchText(String txtValue) {
		cfunction.CommonTextBox_Input(SEARCHTEXTINPUT_XPATH, txtValue);
	}
	public static void clickUpgradeJob() throws Exception {
		cfunction.Commmon_Click("xpath", UPGRADE_JOB_BTN_XPATH);

	}
	public static boolean verifyJobIsPresent(String jobName) {
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(SEARCHEDLISTITEM_XPATH));
		for (WebElement item : items) {
			String menuItem = item.getText();

			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				verified = true;
				System.out.println(menuItem + " found in Search List");
				break;
			}
		}
		return verified;
	}
	public static boolean verifyTotalJobCount(String Count) {
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(TOTAL_JOBS_SUMMARY_CHART_XPATH));
		for (WebElement item : items) {
			String menuItem = item.getText();

			System.out.println(menuItem + "  --  " + Count);
			if (menuItem.equalsIgnoreCase(Count)) {
				verified = true;
				System.out.println(menuItem + " Count matched");
				break;
			}
		}
		return verified;
	}
	public static boolean verifyJobText(String toolTip) {
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(ASSIGNEDTO_XPATH));
		int size=items.size();
		for (int i=1;i<=size;i++) {
			String list="("+ASSIGNEDTO_XPATH+")["+i+"]";
			//cfunction.hoverByAction(list);
			WebElement elementHover = driver.findElement(By.xpath(list));
			cfunction.hoverByJS(elementHover);
			String text=cfunction.getElementText(list);
			cfunction.sync(2);
			if(text.equalsIgnoreCase(toolTip)) {
				verified=true;
			}
			else {
				verified=false;
			}}return verified;
	}

	// Mouse hovering over the section of Job Priority
	public static void cursorHoverOnJobPriority() {
		element = CommonFunction.getWebElement("xpath", JOBPRIORITY_XPATH);

		System.out.println(element);
		Actions hover = new Actions(driver);
		hover.moveToElement(element);
		hover.build();
		hover.perform();
		System.out.println("Mouse hover");
	}

	// click on All Job Tab
	public static void clickOnAllJob() {
		/*cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		cfunction.sync(2);*/
		cfunction.Commmon_Click("xpath", ALLJOB_XPATH);
	}
	public static boolean selectTemplateFromList(String itemName) {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(TEMPLATELIST_XPATH + "/div/h4"));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(itemName)) {
				verified = true;
				break;
			}else {
				verified =false;
			}
		}
		return verified;
	}

	// click on My Jobs tab
	public static void clickOnMyJobs() {
		cfunction.Commmon_Click("xpath", MYJOB_XPATH);
	}

	// Click the 'Expand Job List' button
	public static void clickOnExpandJobList() {
		cfunction.Commmon_Click("xpath", EXPANDJOBLIST_XPATH);

	}

	// Click the 'Collapse Job List' button
	public static void clickOnCollapseJobList() {
		cfunction.Commmon_Click("xpath", COLLAPSEJOBLIST_XPATH);

	}

	// Click the 'Job Name' header
	public static void clickOnJobNameHeader() {
		cfunction.Commmon_Click("xpath", JOBNAMEHEADER_XPATH);

	}

	// Select the first job (Currently: CREATE_JOB_ReadyAPI_Tests)
	public static void selectFirstJob() {
		cfunction.Commmon_Click("xpath", JOBNAMELIST_XPATH);
	}

	// Verify info panel is displayed
	public static boolean verifyInfoPanelIsDisplayed() throws Exception {
		cfunction.sync(10);
		return CommonFunction.elementIsDisplayed(INFOPANELHEADER_XPATH);
	}

	public static void clickSeeMore() throws Exception {
		for (int i = 0; i < 2; i++) {
			// if(CommonFunction.elementIsDisplayed("//tr[@class='buttonRow']")) {
			cfunction.Commmon_Click("xpath", "//tr[@class='buttonRow']");
			cfunction.sync(2);
		}
		/*
		 * else { return; } }
		 */

	}
	public static void enterSearchMapText(String txtValue) {
		WebElement txtBox = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_MAP_XPATH)));
		
		cfunction.CommonTextBox_Input(SEARCH_MAP_XPATH, txtValue);
		cfunction.sync(2);
		cfunction.pressEnterKey();
		cfunction.sync(5);
		txtBox.clear();
		cfunction.Commmon_Click("xpath", "//canvas");
	}
	public static boolean verifyJobListCount(int listSize) throws Exception {
		boolean verified = false;
		List<WebElement> JobNameList = driver.findElementsByXPath(JOBNAMELIST_XPATH);
		int Size=JobNameList.size();
			if (listSize<=Size) {
				verified = true;
				
			} else {
				verified = false;
			}
			
		return verified;
	}
	public static void hoverOnActionList(int i) {
		String createDefault_xpath = ACTION_LIST_XPATH + "[" + (i) + "]";
		cfunction.hoverByAction(createDefault_xpath);
	}

	// Click the 'Assigned To' header
	public static void clickOnAssignedtoHeader() {
		cfunction.Commmon_Click("xpath", ASSIGNEDTOHEADER_XPATH);
	}

	// Click the 'Priority' header
	public static void clickOnPriorityHeader() {
		cfunction.CommmonJS_Click(PRIORITYHEADER_XPATH);
	}

	// Click the 'Due date ' header
	public static void clickOnDueDateHeader() {
		// cfunction.Commmon_Click("xpath",DUEDATEHEADER_XPATH );
		// cfunction.CommmonJS_Click(DUEDATEHEADER_XPATH);
		WebElement icon = driver.findElement(By.xpath(DUEDATEHEADER_XPATH));
		Actions ob = new Actions(driver);
		ob.click(icon);
		Action action = ob.build();
		action.perform();
	}

	// Click the 'Status' header
	public static void clickOnStatusHeader() {
		//cfunction.Commmon_Click("xpath", STATUSHEADER_XPATH);
		cfunction.CommmonJS_Click(STATUSHEADER_XPATH);
	}

	// Scroll to the bottom of the Job List
	public static void scrollToBottomOfJobList() {
		cfunction.ScrollToElement(SHOWMORE_XPATH);
	}

	// Click 'Show More'
	public static void clickOnShowMore() {
		cfunction.Commmon_Click("xpath", SHOWMORE_XPATH);
	}
	public static void clickOnActionList(int i) {
		String createDefault_xpath = ACTION_LIST_XPATH + "[" + (i) + "]";
		cfunction.CommmonJS_Click(createDefault_xpath);
	}
	public static void clickOnDockBtn() {
		String createDefault_xpath = DOCK_BTN_XPATH ;
		//cfunction.CommmonJS_Click(createDefault_xpath);
		//cfunction.Commmon_Click("xpath", createDefault_xpath);
		WebElement dockButton= driver.findElementByXPath(createDefault_xpath);
		dockButton.click();
	}
	

	// The job list should sort from A-Z by job name
	public static boolean verifyJobList() throws Exception {
		boolean verified=false;
		if(CommonFunction.checkSorting(JOBNAMELIST_XPATH)) {
			verified=true;
		}
		else {
			return verified;
		}
				return verified;
	}

	// Click the 'Current Step' header
	public static void clickOnCurrentHeader() {
		cfunction.Commmon_Click("xpath", CURRENTHEADER_XPATH);
	}

	// The job list should sort from A-Z by Assignment name
	public static boolean verifyAssignmentList() throws Exception {
		return CommonFunction.checkSorting(ASSIGNMENTLIST_XPATH);
	}

	// The job list should sort from A-Z by Step status
	public static boolean verifyStatusList() throws Exception {
		return CommonFunction.checkSorting(STATUSLIST_XPATH);
	}

	// The job list should sort from A-Z by Current step name
	public static boolean verifyCurrentStepList() throws Exception {
		return CommonFunction.checkSorting(CURRENTSTEPLIST_XPATH);
	}

	// The job list should sort from High to Low priority
	public static boolean verifyPriorityList() throws Exception {
		return CommonFunction.verifylowToHigh(PRIORITYLIST_XPATH);
	}

	public static void verifyDateList() throws Exception {

		List<Date> listDates = new ArrayList<Date>();
		List<WebElement> lstMMMDD = driver.findElements(By.xpath("//tbody[@class='ui-table-tbody']/tr/td[5]/span"));
		// List<WebElement> listMMMDD_Date = null;
		// DateFormat dateFormatter = new SimpleDateFormat("MMM-dd");
		System.out.println("lstMMMDD: " + lstMMMDD.toString());
		/*
		 * try { for(int i=0;i<lstMMMDD.size();i++) {
		 * 
		 * listMMMDD_Date = for(WebElement el:lstMMMDD) {
		 * listDates.add(dateFormatter.parse(lstMMM+"-"+listDD));
		 * //listDates.add(dateFormatter.parse("Aug-28")); }
		 * 
		 * 
		 * } catch (ParseException ex) { System.err.print(ex); }
		 */

		System.out.println("Before sorting: " + lstMMMDD.toString());

		Collections.sort(listDates);

		System.out.println("After sorting: " + listDates);

	}

	// The job list should sort from Z-A by job name
	public static boolean verifyReverseJobList() throws Exception {
		return CommonFunction.checkSorting(JOBNAMELIST_XPATH);
	}

	// The job list should sort from Z-A by Assignment name
	public static boolean verifyReverseAssignmentList() throws Exception {
		return CommonFunction.checkSorting(ASSIGNMENTLIST_XPATH);
	}

	// The job list should sort from Z-A by Step status
	public static boolean verifyReverseStatusList() throws Exception {
		return CommonFunction.checkSorting(STATUSLIST_XPATH);
	}

	// The job list should sort from Z-A by Current step name
	public static boolean verifyReverseCurrentStepList() throws Exception {
		return CommonFunction.checkSorting(CURRENTSTEPLIST_XPATH);
	}

	// The job list should collapse down
	public static boolean verifyJobListCollapsed() throws Exception {
		cfunction.sync(10);
		return CommonFunction.elementIsDisplayed(EXPANDJOBLIST_XPATH);
	}

	// The job list should expand
	public static boolean verifyJobListExpanded() throws Exception {
		cfunction.sync(10);
		return CommonFunction.elementIsDisplayed(COLLAPSEJOBLIST_XPATH);
	}

	// "Show More" should be visible at the bottom
	public static boolean verifyShowMore() throws Exception {
		cfunction.sync(20);
		return CommonFunction.elementIsDisplayed(SHOWMORE_XPATH);
	}

	// Click on right triangle arrow
	public static void clickOnRightTriangleArrow() {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", RIGHTTRIANGLE_XPATH);
	}

	// Click on Left panel
	public static void clickOnCollapseLeftPanel() {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL_XPATH);
	}

	public static boolean verifyAllJobsVisible(int count) throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(CARDCONTENT_XPATH));
		System.out.println("Total Jobs ==>" + count + " -- " + rows.size());
		if (rows.size() <= count)
			return true;
		return false;
	}

	public static void clearSearchText(String txtValue) {
		cfunction.clearAndPressEnterKey(SEARCHTEXTINPUT_XPATH, txtValue);
	}

	public static boolean verifyTitleToolTip(int i, String tooltip) {
		String xpath = CARDCONTENT_XPATH + "[" + (i + 1) + "]" + TITLE_XPATH;
		return cfunction.verifyToolTip(xpath, tooltip);
	}

	public static int getAllJobsCount() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(CARDCONTENT_XPATH));
		return rows.size();
	}

	public static int getJobTemplateIndex(String itemName) {
		int index = -1;
		List<WebElement> rows = driver.findElements(By.xpath(CARDITEMNAME_XPATH));
		for (int i = 1; i <= rows.size(); i++) {
			String header_xpath = CARDCONTENT_XPATH + "[" + i + "]//h4";
			WebElement headerTitle = CommonFunction.getWebElement("xpath", header_xpath);
			if (headerTitle.getText().equalsIgnoreCase(itemName)) {
				index = i - 1;
				break;
			}
		}
		return index;
	}

	public static void hoverOnJobTemplate(int i) {
		List<WebElement> rows = driver.findElements(By.xpath(CARDCONTENT_XPATH));
		cfunction.hoverByJS(rows.get(i));

		// String createDefault_xpath = CARDCONTENT_XPATH + "[" + (i + 1) + "]" ;
		// cfunction.hoverByAction(createDefault_xpath);
	}

	public static boolean verifyCreateDefaultAndAdvanced(int i) {
		String xpath = CARDCONTENT_XPATH + "[" + i + 1 + "]" + CREATEDEFAULT_XPATH;
		try {
			WebElement element = CommonFunction.getWebElement("xpath", xpath);
			if (element.isDisplayed())
				return true;
		} catch (Exception ex) {
		}
		return false;
	}

	public static void hoverOnCreateDefault(int i) {
		String createDefault_xpath = CARDCONTENT_XPATH + "[" + (i + 1) + "]" + CREATEDEFAULT_XPATH;
		cfunction.hoverByAction(createDefault_xpath);
	}

	public static boolean verifyIfCreateDefaultHighlighted(int i) throws Exception {
		String xpath = CARDCONTENT_XPATH + "[" + (i + 1) + "]" + CREATEDEFAULT_XPATH;
		return cfunction.verifyIfHighlighted(xpath);
	}

	public static void hoverOnAdvanced(int i) {
		String createDefault_xpath = CARDCONTENT_XPATH + "[" + (i + 1) + "]" + ADVANCED_XPATH;
		cfunction.hoverByAction(createDefault_xpath);
	}

	public static boolean verifyIfAdvancedHighlighted(int i) throws Exception {
		String xpath = CARDCONTENT_XPATH + "[" + (i + 1) + "]" + ADVANCED_XPATH;
		return cfunction.verifyIfHighlighted(xpath);
	}

	public static void hoverOnTitle(int i) {
		String xpath = CARDCONTENT_XPATH + "[" + (i + 1) + "]" + TITLE_XPATH;
		cfunction.hoverByAction(xpath);
	}

	public static void hoverOnDescription(int i) {
		String xpath = CARDCONTENT_XPATH + "[" + (i + 1) + "]" + DESCRIPTION_XPATH;
		cfunction.hoverByAction(xpath);
	}

	// find the index of the chart -- starts from 0
	public static int getChartIndex(String name) {
		int index = -1;
		List<WebElement> charts = driver.findElements(By.xpath(CHARTTITLE_XPATH));
		for (int i = 1; i < charts.size(); i++) {
			if (charts.get(i).getText().equalsIgnoreCase(name)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void hoverOnChart(String chart, String section) {
		String HOVERELEMENT_XPATH = "//div[@id='" + chart
				+ "']//*[@class='c3-chart-arcs']//*[@class=' c3-shapes c3-shapes-" + section + " c3-arcs c3-arcs-"
				+ section + "']" + "//*";
		System.out.println("HOVERELEMENT_XPATH: " + HOVERELEMENT_XPATH.toString());
		List<WebElement> elements = driver.findElements(By.xpath(HOVERELEMENT_XPATH));
		System.out.println("elements.size: " + elements.size());
		WebElement elementHover = driver.findElement(By.xpath(HOVERELEMENT_XPATH));
		cfunction.hoverByJS(elementHover);
		/*
		 * Actions builder = new Actions(driver);
		 * builder.click(elementHover).build().perform();
		 */
		/*
		 * Actions act = new Actions(driver); act.dragAndDrop(elementHover,
		 * elementHover).build().perform(); System.out.println("Hovered on Chart");
		 */
	}

	public static void hoverOnChart1(String chartvalue, String section) {
		String HOVERELEMENT1_XPATH = "//div[@id='" + chartvalue
				+ "']//*[@class='c3-chart-arcs']//*[@class=' c3-shapes c3-shapes-" + section + " c3-arcs c3-arcs-"
				+ section + "']" + "//*";
		WebElement elementHover = driver.findElement(By.xpath(HOVERELEMENT1_XPATH));
		System.out.println("HOVERELEMENT_XPATH" + HOVERELEMENT1_XPATH.toString());
		cfunction.hoverByJS(elementHover);
		/*
		 * Actions clickAction = new Actions(driver).click(element);
		 * clickAction.build().perform();
		 */
		Actions act = new Actions(driver);
		act.dragAndDrop(elementHover, elementHover).build().perform();
		System.out.println("Hovered on Chart");

	}

	public static void clickOnHoverElement1() {
		String HOVERELEMENT_XPATH = "//*[@class='c3-chart-arc c3-target c3-target-High']";
		WebElement element = driver.findElement(By.xpath(HOVERELEMENT_XPATH));
		Actions builder = new Actions(driver);
		builder.click(element).build().perform();
	}

	public static void clickOnHoverElement2() {
		String HOVERELEMENT_XPATH = "//*[@class=' c3-shapes c3-shapes-Extract-Data c3-arcs c3-arcs-Extract-Data']";
		WebElement element = driver.findElement(By.xpath(HOVERELEMENT_XPATH));
		Actions builder = new Actions(driver);
		builder.click(element).build().perform();
	}

	public static void clickOnAllJobs() {
		cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", ALLJOBS_XPATH);
	}

	public static boolean verifyQuantityCategory(String category, int chartIndex, int textIndex) throws Exception {
		boolean verified = false;
		String categoryText = cfunction.getElementText(CHARTCATEGORY_XPATH + "["+chartIndex+"]");
		//String quantity = cfunction.getElementText(CHARTQUANTITY_XPATH+"["+textIndex+"]");
		int quant= getChartQuanity(textIndex);
		String quantity= Integer.toString(quant);
		System.out.println("categoryText: " + categoryText);
		System.out.println("quantity: " + quantity);
		if ((categoryText.equalsIgnoreCase(category)) && (!quantity.isEmpty()))
			verified = true;
		return verified;
	}

	public static String getChartDetail() throws Exception {
		return cfunction.getElementText(CHARTDETAIL_XPATH);
	}
	public static void clickCancelBtn() throws Exception{
		//cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", CANCEL_BTN_REQUIRED_XPATH);
	}
	public static boolean verifySuccessMsg1(String successMsg) {
		boolean verified = false;
		String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		System.out.println(msg);
		if (msg.contains(successMsg)) {
			verified = true;
		}
		else {
			verified=false;
		}
		return verified;
	}
	public static int getChartQuanity(int index) throws Exception {
	//	String quantity = cfunction.getElementText("(" + CHARTQUANTITY_XPATH + ")[" + index + "]");
	
				String quantity = cfunction.getElementText("(//div[@class='c3'])[" + index + "]//div[@class='tooltip-value']");		
				System.out.println("Quantity-->" + quantity);
		return Integer.parseInt(quantity);
	}

	public static BufferedImage getChartImage() throws Exception {
		WebElement charts = CommonFunction.getWebElement("xpath", CHARTSPANEL_XPATH);
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,
				charts);

		// Screenshot ss = new AShot().takeScreenshot(driver, charts);
		return screenshot.getImage();
	}
	public static boolean clickOnSharedListOption(String jobTemplate) {
		int listcount = 1;
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(SHARED_SEARCH_XPATH));
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
			if (rowsItem.contains(jobTemplate)) {
				verified = true;
				System.out.println(jobTemplate + " is visible");
				String checkbox= "(" + SHARED_SEARCH_XPATH + ")[" + listcount + "]";
				cfunction.Commmon_Click("xpath",checkbox);
				//break;
			} else {
				System.out.println(jobTemplate + " is not visible");
			}
			listcount++;
		}
		return verified;

	}

	public static boolean verifyMyJobEnable() {
		boolean verified = false;
		WebElement myjob = CommonFunction.getWebElement("xpath", ACTIVE_MYJOB_XPATH);
		if (myjob.isDisplayed()) {
			verified = true;
		}
		return verified;
	}
	public static boolean verifydate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy");
		Calendar c = Calendar.getInstance();
		System.out.println(sdf);
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 10); // Adding 10 days
		String output = sdf.format(c.getTime());
		System.out.println(output);
		
		
		
		boolean verified = false;
		//WebElement AssignedToList = driver.findElements(By.xpath("((//tbody)/tr/td[3])/span"));
		WebElement AssignedToList = driver.findElement(By.xpath("((//tbody)/tr/td[3])/span"));
		String text = AssignedToList.getText();
		System.out.println(text);
		Date date = sdf.parse(text);
		//System.out.println(diagram + "  --  " + diagramName);
/*		if (output.equalsIgnoreCase(text)) {
			verified = true;
			
		}

			else {
				verified = false;
			}*/
		if (date == null) {
	        verified = false;
	    } else {
	        verified = true;
	    }

	    System.out.println(verified);
		return verified;
	}
	public static boolean verifyJobCount(int count) {
		boolean verified = false;
		//List<WebElement> AssignedToList = driver.findElements(By.xpath("((//tbody)/tr/th[2])"));
		List<WebElement> AssignedToList = driver.findElements(By.xpath("((//tbody)/tr/td[2])"));
		System.out.println(AssignedToList.size());
			if (AssignedToList.size()<=count) {
				verified = true;
			}


			else {
				verified = false;
			}
		return verified;
	}
	public static boolean verifyNewSharedSearchVisible(int i,String title) {
		boolean verified = false;
		try {
			WebElement sharedSearch = driver.findElement(By.xpath(JOBLIST_TITLES_XPATH+"["+i+"]"));
			String text = sharedSearch.getText();
			if (text.equalsIgnoreCase(title)) {
				verified = true;
				System.out.println("Shared Search is present");
			}
		} catch (Exception ex) {
		}
		return verified;

	}
	public static boolean verifyAllJobEnable() {
		boolean verified = false;
		WebElement myjob = CommonFunction.getWebElement("xpath", ALLJOB_XPATH);
		if (myjob.isDisplayed()) {
			verified = true;
		}
		return verified;
	}

	public static void enterSearchJob(String txtValue) {
		cfunction.CommonTextBox_Input(SEARCH_JOB_XPATH, txtValue);
	}

	public static void clickOnSearchJob() {
		cfunction.Commmon_Click("xpath", SEARCHJOB_XPATH);
	}

	public static boolean verifySearch_1IsDisplayed() throws Exception {
		cfunction.sync(2);
		return CommonFunction.elementIsDisplayed(SEARCH_1_XPATH);
	}

	public static boolean verifyPriority(String PriorityName) throws Exception {
		boolean verified = false;
		List<WebElement> PriorityList = driver.findElements(By.xpath(PRIORITYLIST_XPATH));
		System.out.println(PriorityList.size());

		for (int i = 0; i < PriorityList.size(); i++) {
			String priority=PriorityList.get(i).getText();
			System.out.println(priority);
			if (PriorityName.equals(PriorityList.get(i).getText())||"".equals(PriorityList.get(i).getText())) {
				verified = true;
			}

			else {
				verified = false;
			}
		}
		return verified;
	}

	public static void clearSearch() {
		cfunction.Commmon_Click("xpath", CLEAR_SEARCH_XPATH);
	}

	public static void verifyClearSearch() {
		// cfunction.Commmon_Click("xpath",SEARCH_JOB_XPATH);
		cfunction.getWebElement("xpath", SEARCH_JOB_XPATH).clear();
		/*
		 * WebElement searchbox = (new WebDriverWait(driver, 55))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath("SEARCH_JOB_XPATH")))
		 * ; searchbox.clear();
		 */
	}

	public static boolean verifySearch_2IsDisplayed() throws Exception {
		cfunction.sync(2);
		return CommonFunction.elementIsDisplayed(SEARCH_2_XPATH);
	}

	public static void hoverOnSearch1() throws Exception {
		/*
		 * WebElement search1=CommonFunction.getWebElement("xpath", SEARCH_1_XPATH);
		 * cfunction.hoverOnElement(search1);
		 */
		/*element = CommonFunction.getWebElement("xpath", "((//ul[@class='p-listbox-list'])[2]//li)[1]/div/span");

		System.out.println(element);
		Actions hover = new Actions(driver);
		hover.moveToElement(element);
		hover.build();
		hover.perform();
		System.out.println("Mouse hover");*/
		//WebElement element = driver.findElementByXPath(SEARCH_1_XPATH);
		cfunction.hoverByAction(SEARCH_1_XPATH);
		//SikuliHelp.hoveronLocationSikuli("Search1_1280x768");
	}

	public static void verifySearch1ToolTip() throws Exception {
		/*
		 * WebElement search1=CommonFunction.getWebElement("xpath", SEARCH_1_XPATH);
		 * cfunction.hoverOnElement(search1);
		 */
		SikuliHelp.verifyImageExists("Search1_1280x768");
	}

	public static boolean verifyEditIsDisplayed() throws Exception {
		cfunction.sync(2);
		return CommonFunction.elementIsDisplayed(EDIT_SEARCH1_XPATH);
	}

	public static boolean verifyDeleteIsDisplayed() throws Exception {
		cfunction.sync(2);
		return CommonFunction.elementIsDisplayed(DELETE_SEARCH1_XPATH);
	}

	public static void editSearch1(String txtValue) throws Exception {

		cfunction.Commmon_Click("xpath", EDIT_SEARCH1_XPATH);
		cfunction.Commmon_Click("xpath", EDIT_SYNTAX_SEARCH1_XPATH);
		cfunction.CommonTextBox_Input(EDIT_SYNTAX_SEARCH1_XPATH, txtValue);
	}

	public static void verifyQuerySyntaxText(String syntax) throws Exception {
		cfunction.verifyElementText(EDIT_SYNTAX_SEARCH1_XPATH, "syntax");

	}

	public static void clickCancelButtonQuerySyntax() throws Exception {
		cfunction.Commmon_Click("xpath", CANCEL_QUERY_SYNTAX_XPATH);

	}

	public static void clickSaveButtonQuerySyntax() throws Exception {
		cfunction.Commmon_Click("xpath", SAVE_QUERY_SYNTAX_XPATH);

	}

	public static void clickSearch2() throws Exception {
		cfunction.Commmon_Click("xpath", SEARCH_2_XPATH);

	}

	public static boolean verifyAssignedTo(String AssignedToName) throws Exception {
		boolean verified = false;
		List<WebElement> AssignedToList = driver.findElements(By.xpath(ASSIGNMENTLIST_XPATH));
		System.out.println(AssignedToList.size());

		for (int i = 0; i < AssignedToList.size(); i++) {
			System.out.println(AssignedToList.get(i).getText());
			if (AssignedToName.equalsIgnoreCase(AssignedToList.get(i).getText())) {
				verified = true;
			}

			else {
				verified = false;
			}
		}
		return verified;
	}

	public static void hoverOnSearch2() throws Exception {
		cfunction.hoverByAction("//li[contains(@class,'p-listbox-item p-highlight')]");
		//SikuliHelp.hoveronLocationSikuli("Search2_1280x768");
	}

	public static void clickDeleteSearch2() throws Exception {
		cfunction.Commmon_Click("xpath", DELETE_SEARCH2_XPATH);

	}

	public static void clickDeleteSearch1() throws Exception {
		cfunction.Commmon_Click("xpath", SEARCH_1_XPATH);

	}

	public static boolean verifyNoDataAvailableIsDisplayed() throws Exception {
		cfunction.sync(2);
		return CommonFunction.elementIsDisplayed(NO_DATA_AVAILABLE_XPATH);

	}
	public static void clickOnDiagramAndMapTab() {
		//cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		cfunction.Commmon_Click("xpath", DIAGRAM_AND_MAP_TAB_XPATH);
	}
	public static void clickOnSignout() throws Exception {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", USERSECTION_BUTTON_XPATH);
		cfunction.Commmon_Click("xpath", SIGNOUT_BUTTON_XPATH);
		cfunction.sync(5);
		driver.navigate().to("https://mcstest62.esri.com/portal/apps/workflowmanager/");
		cfunction.sync(5);
	}
	public static boolean verifyNewSharedSearchVisible() {
		boolean verified = false;
		try {
			WebElement sharedSearch = driver.findElement(By.xpath(NEW_SHARED_SEARCH_XPATH));
			if (sharedSearch != null) {
				verified = true;
				System.out.println("Shared Search is present");
			}
		} catch (Exception ex) {
		}
		return verified;

	}
	public static boolean verifyTemplateIsPresent(String jobName) {
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(TEMPLATELIST_XPATH + "/div/h4"));
		for (WebElement item : items) {
			String menuItem = item.getText();

			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				verified = true;
				System.out.println(menuItem + " found in Search List");
				break;
			}
		}
		return verified;
	}

	public static boolean clickCreateDefaultOfTemplatePresent(String jobName) {
		boolean verified = false;
		int i = 1;
		List<WebElement> TemplateName = driver.findElements(By.xpath(TEMPLATELIST_XPATH + "/div/h4"));
		for (WebElement item : TemplateName) {
			String menuItem = item.getText();
			String jobnameXpath = "(" + TEMPLATELIST_XPATH + ")[" + i + "]";
			System.out.println(jobnameXpath);
			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				verified = true;
				System.out.println(menuItem + " found in Search List");
				WebElement icon = driver.findElement(By.xpath(jobnameXpath));
				cfunction.sync(2);
				icon.click();
				System.out.println("Printing Xpath:  " + jobnameXpath);

				break;
			}
			System.out.println("Printing Xpath11111:  " + jobnameXpath);
			i++;
		}
		return verified;
	}

	public static boolean clickCreateDefaultOfTEmplatePresent_old(String jobName) {
		boolean verified = false;
		int i = 1;
		List<WebElement> TemplateName = driver.findElements(By.xpath(TEMPLATELIST_XPATH + "/div/h4"));
		for (WebElement item : TemplateName) {
			String menuItem = item.getText();
			String jobnameXpath = "(" + TEMPLATELIST_XPATH + "/div/div/button" + ")[" + i + "]";
			System.out.println(jobnameXpath);
			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				verified = true;
				System.out.println(menuItem + " found in Search List");
				WebElement icon = driver.findElement(By.xpath(jobnameXpath));
				cfunction.sync(2);
				icon.click();

				/*
				 * Actions ob = new Actions(driver); ob.click(icon); Action action = ob.build();
				 * action.perform();
				 */
				System.out.println("Printing Xpath:  " + jobnameXpath);

				break;
			}
			System.out.println("Printing Xpath11111:  " + jobnameXpath);
			i++;
		}
		return verified;
	}

	public static void clickEllipsesBtn2() throws Exception {
		cfunction.CommmonJS_Click_ShadowPath(ELLIPSIS_SHADOW_XPATH);
		/*	cfunction.hoverByAction(ELLIPSEBUTTON_XPATH);
		cfunction.sync(5);
		// cfunction.CommmonJS_Click(ELLIPSEBUTTON_XPATH);
		WebElement icon = driver.findElement(By.xpath(ELLIPSEBUTTON_XPATH));
		Actions ob = new Actions(driver);
		ob.click(icon);
		Action action = ob.build();
		action.perform();*/
		}
	public static void clickEllipsesBtn() {
		//cfunction.CommmonJS_Click(ELLIPSIS_XPATH);
		cfunction.CommmonJS_Click_ShadowPath(ELLIPSIS_SHADOW_XPATH);
		/*WebElement icon = driver.findElement(By.xpath(ELLIPSIS_XPATH));
		Actions ob = new Actions(driver);
		ob.click(icon);
		Action action = ob.build();
		action.perform();*/
		//cfunction.Commmon_Click("xpath", ELLIPSIS_XPATH);
		//cfunction.CommmonJS_Click("//div[contains(@class,'dropdown js-dropdown t-normalViewMenu')]//button");
		//cfunction.Commmon_Click("xpath", "//div[contains(@class,'t-normalViewMenu')]//button");
	}
	public static void clickEllipsesBtn1() throws Exception {
		cfunction.Commmon_Click("xpath", ELLIPSIS_XPATH);
		// cfunction.hoverByAction(ELLIPSEBUTTON_XPATH);
		//cfunction.sync(10);
		/*WebElement icon = driver.findElement(By.xpath(ELLIPSIS_XPATH));
		Actions ob = new Actions(driver);
		ob.click(icon);
		Action action = ob.build();
		action.perform();*/
		//cfunction.Commmon_Click("xpath", ELLIPSIS_XPATH);
		//cfunction.CommmonJS_Click(ELLIPSIS_XPATH);
		
	}

	public static void clickDeleteBtn() throws Exception {
		// cfunction.Commmon_Click("xpath", DELETEJOBBUTTON_XPATH);
		cfunction.CommmonJS_Click(DELETEJOBBUTTON_XPATH);

	}

	public static void clickDeleteConfirmBtnYes() throws Exception {
		cfunction.CommmonJS_Click(CONFIRM_DELETEJOBBUTTON_YES_XPATH);
		// cfunction.Commmon_Click("xpath", CONFIRM_DELETEJOBBUTTON_YES_XPATH);

	}

	public static void clickDeleteConfirmBtnNo() throws Exception {
		cfunction.Commmon_Click("xpath", CONFIRM_DELETEJOBBUTTON_NO_XPATH);

	}
	
	public static void moverowUpDown() {
		//pass the xpath variable if you want to include any element
		//WebElement elementMove = driver.findElementByXPath(xpath);
		Actions builder = new Actions(driver);
		//builder.sendKeys(Keys.ARROW_DOWN);
		builder.sendKeys(Keys.ARROW_UP);
		
		
	}

	public static boolean clickOnJobListEntry(String JobName) throws Exception {
		boolean verified = false;
		int jobquery = 0;
		for(int j=0;j>=0;j++) {
			if(verifyShowMore()) {
			//scrollToBottomOfJobList();
			clickOnShowMore();
		}else{
			break;}
		}
		List<WebElement> JobNameList = driver.findElementsByXPath(JOBNAMELIST_XPATH);
		cfunction.sync(5);
		for (int i = 0; i <= JobNameList.size(); i++) {
			System.out.println(JobNameList.get(i).getText());
			if (JobName.equals(JobNameList.get(i).getText())) {
				System.out.println("--------"+JobNameList.get(i).getText());
				System.out.println("(" + JOBNAMELIST_XPATH + ")" + "[" + (jobquery+1) + "]");
				verified = true;
				//WebElement job = driver.findElementByXPath("(" + JOBNAMELIST_XPATH + ")" + "[" + jobquery + "]");
				//WebElement job1 = driver.findElement(By.xpath("(" + JOBNAMELIST_XPATH + ")" + "[" + (jobquery+1) + "]"));
				cfunction.CommmonJS_Click("(" + JOBNAMELIST_XPATH + ")" + "[" + (jobquery+1) + "]");
				cfunction.sync(5);
				//job1.click();
				cfunction.sync(2);
				//job.click();
				break;
			} else {
				verified = false;
			}
			jobquery++;
		}
		return verified;
	}
	public static void clickOn3rdJobInJoblist() {
		//cfunction.Commmon_Click("xpath", STATUSHEADER_XPATH);
		//CommmonJS_Click("(" + JOBNAMELIST_XPATH + ")" + "[" + 3 + "]");
		//cfunction.Commmon_Click("xpath", "(" + JOBNAMELIST_XPATH + ")" + "[" + 3 + "]");
		WebElement icon = driver.findElement(By.xpath("(" + JOBNAMELIST_XPATH + ")" + "[" + 3 + "]"));
		Actions ob = new Actions(driver);
		ob.click(icon);
		Action action = ob.build();
		action.perform();
	}

	public static void selectNewlyCreatedJob(String itemName) throws Exception {
		// cfunction.Commmon_Click("xpath", "//tr[@class='buttonRow']");
		// Coordinate.clickSeeMore();
		List<WebElement> rows = driver.findElements(By.xpath(JOBNAMELIST_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(itemName)) {
				row.click();
				break;
			}
		}
	}

	public static void selectAssignedUserFromDropdown(String username) throws Exception {
		cfunction.Commmon_Click("xpath", ASSIGNMENTDROPDOWNOPEN_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(ASSIGNMENTDROPDOWNLIST_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(username)) {
				String value= row.getText();
				System.out.println("Selected Value is==>"+value);
				cfunction.sync(2);
				row.click();
				break;
			}
		}
	}
	public static void selectAssignedUserFromDropdown1(String username) throws Exception {
		//cfunction.Commmon_Click("xpath", "("+ASSIGNMENTDROPDOWNOPEN_XPATH+")[2]");
		cfunction.Commmon_Click("xpath", ASSIGNMENTDROPDOWNOPEN_XPATH);
		cfunction.sync(2);
		List<WebElement> rows = driver.findElements(By.xpath(ASSIGNMENTDROPDOWNLIST_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(username)) {
				row.click();
				break;
			}
		}
	}
	public static void clickLocation() throws Exception{
		cfunction.Commmon_Click("xpath", "(//span[contains(@class,'ui-accordion-toggle-icon')])[6]");
	}
	public static boolean verifySuccessMsg(String successMsg) {
		boolean verified = false;
		String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		 System.out.println(msg);
				String[] arrOfStr = msg.split(" ", 2);
		for (String a : arrOfStr) {
			System.out.println(arrOfStr[0]);
			jobName = arrOfStr[0];
		}
		System.out.println(msg);
		if (msg.contains(successMsg)) {
			verified = true;
		}
		return verified;
	}

	public static void clickEditJobDetail() throws Exception {
		/*
		 * boolean check; if(cfunction.Commmon_Click("xpath", EDITJOBDETAIL_XPATH)) {
		 * System.out.println("Normal click on Edit"); } else {
		 */
		cfunction.Commmon_Click("xpath", EDITJOBDETAIL_XPATH_NEW);
		//cfunction.CommmonJS_Click_ShadowPath(EDITJOBDETAIL_SHADOW_XPATH);

	}

	public static void clickSaveEditJobDetail() throws Exception {
		cfunction.Commmon_Click("xpath", SAVE_EDIT_DETAILS_XPATH);
		//cfunction.CommmonJS_Click_ShadowPath(SAVE_EDIT_DETAILS_SHADOW_XPATH);

	}

	public static void verifyDropDwnValue(String value) throws Exception {
		cfunction.verifyElementText(DRPDWN_TEXT_XPATH, value);
	}

	public static void clickOnRequiredExtendproperties() throws Exception {
		// cfunction.Commmon_Click("xpath", "(//div[@class='c-propertyContainer__content
		// t-extendedProperty__value'])[15]");
		cfunction.Commmon_Click("XPATH", REQUIRED_EXTEND_PROPERTIES_XPATH);
	}

	public static void selectValueFromDropdownBOOL(String value) throws Exception {
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath",OPEN_DRPDWN_BOOL_XPATH );
		cfunction.sync(5);
		List<WebElement> option = driver.findElements(By.xpath(OPTIONS_DRPDWN_BOOL_XPATH));
		for (int i = 0; i < option.size(); i++) {
			String drpdwnValue = option.get(i).getText();
			// (WebElement row:option) {
			if (drpdwnValue.equalsIgnoreCase(value)) {
				cfunction.Commmon_Click("XPATH", "(" + OPTIONS_DRPDWN_BOOL_XPATH + ")[" + (i + 1) + "]");
				break;
			}
		}
	}
	/*public static void clickCancelBtn() throws Exception{
		cfunction.Commmon_Click("XPATH", CANCEL_BTN_REQUIRED_XPATH);
	}*/

	public static boolean verifyBOOLInput(String input) throws Exception {
		Boolean verified = false;
		try {
			String xpath = "(//span[contains(@class,'p-dropdown-label')])[3]";
			boolean check;
			String text=cfunction.getElementText(xpath);
			if (text.equalsIgnoreCase(input) )
			{
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static void clickOnNormalDefaultExtendproperties() throws Exception {
		//.Commmon_Click("xpath","(//div[@class='c-propertyContainer__content t-extendedProperty__value'])[15]");
		cfunction.Commmon_Click("XPATH", NORMAL_DEFAULT_EXTEND_PROPERTIES_XPATH);
	}

	public static boolean verifyJobNameAtInfoPanel(String name) throws Exception {
		boolean verified = false;
		WebElement infoPanel = driver.findElementByXPath(INFOPANEL_NAME_XPATH);
		String jobName = infoPanel.getText();
		if (jobName.equalsIgnoreCase(name)) {
			System.out.println("Correct job panel is opened");
			verified = true;
		} else {
			System.out.println("Different job panel opened");
		}
		return verified;
	}

	public static void clickOnMoreBtn() throws Exception {
		//cfunction.sync(2);
		cfunction.Commmon_Click("xpath", MORE_XPATH);
	}

	public static boolean verifyStepValue(String value) throws Exception {
		boolean verified = false;
		 WebElement infoPanel=driver.findElementByXPath(JOBPANEL_PROPERTIES_VALUE_XPATH+"[1]");
		//WebElement infoPanel = driver.findElementByXPath("//div[contains(@class,'c-propertyContainxer__content')]");
		String jobName = infoPanel.getText();
		if (jobName.equalsIgnoreCase(value)) {
			System.out.println("Step Value is correct");
			verified = true;
		} else {
			System.out.println("Different Step Value");
		}
		return verified;
	}

	public static boolean verifyPriorityValue(String value) throws Exception {
		boolean verified = false;
		WebElement infoPanel = driver.findElementByXPath(JOBPANEL_PROPERTIES_VALUE_XPATH + "[2]");
		String jobName = infoPanel.getText();
		if (jobName.equalsIgnoreCase(value)) {
			System.out.println("Priority Value is correct");
			verified = true;
		} else {
			System.out.println("Different Priority Value");
		}
		return verified;
	}

	public static boolean verifyAssignmentValue(String value) throws Exception {
		boolean verified = false;
		WebElement infoPanel = driver.findElementByXPath(JOBPANEL_PROPERTIES_VALUE_XPATH + "[3]");
		String jobName = infoPanel.getText();
		if (jobName.equalsIgnoreCase(value)) {
			System.out.println("Assignment Value is correct");
			verified = true;
		} else {
			System.out.println("Different Assignment Value");
		}
		return verified;
	}

	public static boolean verifyTypeValue(String value) throws Exception {
		boolean verified = false;
		WebElement infoPanel = driver.findElementByXPath(JOBPANEL_PROPERTIES_VALUE_XPATH + "[4]");
		String jobName = infoPanel.getText();
		if (jobName.equalsIgnoreCase(value)) {
			System.out.println("Type Value is correct");
			verified = true;
		} else {
			System.out.println("Different Type Value");
		}
		return verified;
	}

	public static boolean verifyStatusValue(String value) throws Exception {
		boolean verified = false;
		WebElement infoPanel = driver.findElementByXPath(JOBPANEL_PROPERTIES_VALUE_XPATH + "[5]");
		String jobName = infoPanel.getText();
		if (jobName.equalsIgnoreCase(value)) {
			System.out.println(" Status value is correct");
			verified = true;
		} else {
			System.out.println("Different Status Value");
		}
		return verified;
	}

	public static boolean verifyJobOwnerValue(String value) throws Exception {
		boolean verified = false;
		WebElement infoPanel = driver.findElementByXPath(JOBPANEL_PROPERTIES_VALUE_XPATH + "[7]");
		String jobName = infoPanel.getText();
		if (jobName.equalsIgnoreCase(value)) {
			System.out.println("Job Owner value is correct");
			verified = true;
		} else {
			System.out.println("Different Job Owner Value");
		}
		return verified;
	}

	public static void clickOnFirstEditBtn() throws Exception {
	//	cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", EXTEND_PROPERTIES_EDIT_BTNS_XPATH + "[1]");

	}

	public static void clickOnSecondEditBtn() throws Exception {
		cfunction.Commmon_Click("XPATH", EXTEND_PROPERTIES_EDIT_BTNS_XPATH + "[2]");

	}

	public static void openDropdown1() throws Exception {
		//cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", DROPDOWN_BTNS_XPATH + "[1]");

	}

	public static void openDropdown2() throws Exception {
		cfunction.Commmon_Click("XPATH", DROPDOWN_BTNS_XPATH + "[2]");

	}
	public static void selectValueFromDropdown(String value) throws Exception {
		//cfunction.Commmon_Click("xpath", DROPDOWN_VALUES_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(DROPDOWN_VALUES_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(value)) {
				row.click();
				break;
			}
		}
	}
	public static boolean verifyComments(String text, String i) throws Exception{
		boolean verified = false;
		String comment = cfunction.getElementText("(//div[@class='commentTextContent__body t-commentBody'])["+i+"]");
		if (comment.equalsIgnoreCase(text)) {
			verified=true;
		
			}
		return verified;
	}

}
