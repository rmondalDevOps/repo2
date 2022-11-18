package com.workflowmanager.pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;

public class WorkPage extends TestBase {

	// XPATH
	private static final String JOBSTAB_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])";
	// private static final String JOBSTAB_XPATH = "(//span[@class='ui-tabview-title
	// ng-star-inserted'])";
	// private static final String HEADER_TABS_LIST_XPATH =
	// "(//span[@class='ui-tabview-title ng-star-inserted'])";
	private static final String HEADER_TABS_LIST_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])";
	private static final String JOBDETAILS_XPATH = "(//span[@class='icon-ui-link-external'])";
	//private static final String JOBNAME_XPATH = "(//div[@class='c-jobCard__mainContainer ng-star-inserted']/div[2])";
	private static final String JOBNAME_XPATH = "(//div[contains(@class,'c-jobCard__mainContainer ng-star-inserted')]/div[2])";

	private static final String JOBNAME_XPATH_AFTERREFRESH = "(//div[@class='c-jobCard__mainContainer']/div[2])";
	//private static final String DIAGRAMMAP_XPATH = "(//div[@class='c-customTab c-customTab--iconOnly ng-star-inserted'])[3]";
	private static final String DIAGRAMMAP_XPATH = "(//div[contains(@class,'c-customTab c-customTab--iconOnly ng-star-inserted')])[3]";

	// Edited by Sandeep as previous one is not working
	//private static final String HISTORY_XPATH = "(//div[@class='c-customTab c-customTab--iconOnly ng-star-inserted'])[4]";
	private static final String HISTORY_XPATH = "(//div[contains(@class,'c-customTab c-customTab--iconOnly ng-star-inserted')])[7]";
	
	//edited sarath
	//private static final String COMMENTS_XPATH = "(//div[@class='c-customTab c-customTab--iconOnly ng-star-inserted'])[2]";
	private static final String COMMENTS_XPATH = "(//div[contains(@class,'c-customTab c-customTab--iconOnly ng-star-inserted')])[2]";
	
	//private static final String PROPERTIES_XPATH = "(//div[@class='c-customTab c-customTab--iconOnly ng-star-inserted'])[1]";
	private static final String PROPERTIES_XPATH = "(//div[contains(@class,'c-customTab c-customTab--iconOnly ng-star-inserted')])[1]";

	private static final String CLOSEPANEL_XPATH = "//span[@class='icon-ui-close']";
	private static final String WORKPAGE_XPATH = "//wmx-work";
	private static final String MYJOBSTAB_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[3]";
	private static final String CUSTOMSEARCHICON_XPATH = "//div[@class='searchSection']";
	// private static final String CUSTOMSEARCHINPUT_XPATH =
	// "//div[@class='searchSection']//div[@class='ui-inputgroup']//input";
	private static final String CUSTOMSEARCHINPUT_XPATH = "//div[@class='p-inputgroup']//input";
	// private static final String CUSTOMSEARCHCOLLAPSE_XPATH =
	// "//div[@class='searchSection']//button[@class='icon-ui-right-triangle-arrow
	// collapseBtn']";
	// private static final String CUSTOMQUERYX_XPATH =
	// "(//div[@class='ui-inputgroup']/calcite-button)[2]";
	private static final String CUSTOMQUERYX_XPATH = "(//div[@class='p-inputgroup']/calcite-button)[2]";
	private static final String CUSTOMQUERYTAB_XPATH = "(//div[@class='c-customQueryUI t-customQueryUI ng-star-inserted'])";
	private static final String JOBCARD_XPATH = "//wmx-work-job-card";
	private static final String JOBNAMELIST_XPATH = "//span[@class='headerText']//span[@class='text-inline-block text-ellipsis']";
	// private static final String SORT_XPATH =
	// "//div[@class='sortSection']//p-dropdown[@dropdownicon='icon-ui-down']";
	private static final String SORT_XPATH = "(//p-sorticon[@class='workPage__cardListHeaderSortIcon--single'])[2]";
	private static final String A_Z_XPATH = "(//p-dropdownitem//li)[5]";
	private static final String MYGROUPJOBSTAB_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[2]";
	private static final String ALLJOBSTAB_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[1]";
	//private static final String CUSTOMQUERYHISTORY_XPATH = "//calcite-button[@class='p-inputgroup-addon p-inputgroup-addon--end ng-star-inserted']";
	private static final String CUSTOMQUERYHISTORY_XPATH = "//calcite-button[contains(@class,'p-inputgroup-addon p-inputgroup-addon--end ng-star-inserted')]";
	// private static final String CUSTOMQUERYHISTORY_XPATH =
	// "//button[@class='p-button-secondary p-button p-component']";
	private static final String HISTORYITEM_XPATH = "//div[@class='searchHistoryUI']//span[contains(@class,'row')]";
	private static final String DISMISSCUSTOMQUERY_XPATH = "//calcite-icon[contains(@class,'t-customQueryUI__dismissBtn')]";
	private static final String CLOSE_JOB_DETAIL_PANEL_XPATH = "//span[@class='icon-ui-close']";
	private static final String NEW_FILTERBY_XPATH = "(//div[@class='statusToggle ng-star-inserted'])[2]";
	//private static final String COLLAPSE_SUMMARY_XPATH = "//div[@class='c-collapsiblePanel__handle c-collapsiblePanel__handle--left t-rightPanelHandle']";
	private static final String COLLAPSE_SUMMARY_XPATH = "//div[contains(@class,'c-collapsiblePanel__handle c-collapsiblePanel__handle--left t-rightPanelHandle')]";

	private static final String JOB_STEPLIST_XPATH = "//wmx-work-job-card/div/div[2]/div[3]";
	private static final String LASTJOBELEMENT_XPATH = "(//wmx-work-job-card)[24]";
	private static final String INTEGER_INPUT_XPATH = "//input[contains(@class,'p-inputnumber-input')]";
	private static final String ALLJOBLIST_XPATH = "//wmx-work-job-card/div/div[2]/div[2]";
	// private static final String COLLAPSE_JOB_DETAIL_XPATH
	// ="(//span[@class='c-collapsiblePanel__handleText ng-star-inserted'])[2]";
	//private static final String COLLAPSE_JOB_DETAIL_XPATH = "//calcite-button[@class='t-collaspePanelBtn ng-star-inserted']";
	private static final String COLLAPSE_JOB_DETAIL_XPATH = "//calcite-button[contains(@class,'t-collaspePanelBtn ng-star-inserted')]";

	
	// private static final String COMPLETE_BTN_XPATH ="//button[@class='icon-btn
	// icon-ui-check-mark green ng-star-inserted']";
	//private static final String COMPLETE_BTN_XPATH = "(//calcite-button[@class='icon-btn ng-star-inserted'])[2]";
	private static final String COMPLETE_BTN_XPATH = "(//calcite-button[contains(@class,'icon-btn ng-star-inserted')])[2]";

	
	private static final String JOBSTARTSTEP_XPATH = "//span[@class='icon-ui-play']";
	private static final String DISMISSMESSAGE_XPATH_XPATH = "//div[@class='c-jobCard__messageContainer']/span";
	private static final String DISMISSJOBTILE_BTN_XPATH = "//calcite-button[@data-name='dismissBtn']";
	private static final String RETURNTOJOB_BTN_XPATH = "//calcite-button[@class='btn-noWrap ng-star-inserted']";
	private static final String ASSIGN_USER_TO_JOB_XPATH = "//div[contains(@class,'jobAssignedTo__value')]";
	private static final String STEP_DRPDWN_XPATH = "//div[contains(@class,'c-dropdown__menuItem--input ng-star-inserted')]";
	private static final String OPEN_STEP_DRPDWN_XPATH = "//span[contains(@class,'c-dropdown__menuItemLabel')]";
	private static final String STEP_DRPDWN_OPTIONS_XPATH = "//span[@class='c-dropdown__menuItemLabel']";
	private static final String JOBDETAILS_TAB_NAME_XPATH = "//span[contains(@class,'c-advancedInput__input text')]";
	// private static final String EXTEND_PROPERTIES_EDIT_BTNS_XPATH
	// ="(//p-header[contains(@class,'t-extendedProperty')]/button)";
	// edited
	private static final String EXTEND_PROPERTIES_EDIT_BTNS_XPATH = "(//calcite-button[@t-itemname='addRecordBtn'])";

	private static final String START_BTN_XPATH = "//calcite-button[contains(@class,'c-jobCard__startBtn')]";
	private static final String EXTEND_PROPERTIES_Disable_EDIT_BTNS_XPATH = "(//button[contains(@class,'btn-showTooltipWhenDisabled btn-disabled ng-star-inserted')])";
	private static final String DISABLE_EXTEND_PROPERTIES_EDIT_BTNS_XPATH = "//button[contains(@class,'t-extendedProperty'/button) and @disabled]";
	private static final String COLLAPSED_JOB_DETAIL_WIDGET_XPATH = "//span[@class='dropArea tr']/span";
	// private static final String PAUSE_BTN_XPATH_1 =
	// "//button[@class='t-pauseBtn']";
	private static final String PAUSE_BTN_XPATH_1 = "//calcite-button[@class='t-pauseBtn']";
	private static final String JOB_PROMPT_TEXT_XPATH = "//div[@class='c-manualStepCard__promptText t-promptText']";
	private static final String JOB_PROMPT2_TEXT_XPATH = "//div[@class='c-jobCard__stepHelpText t-stepHelpText']";
	private static final String ERROR_ICON_XPATH = "//calcite-icon[contains(@icon,'exclamationMarkCircle')]";
	private static final String ERROR_ICON_XPATH1 = "//input[contains(@class,'dirty')]";
	// private static final String ERROR_ICON_XPATH ="//span[@class='tabGrid-column
	// tabGrid-column-large-1 input-validation isError']";
	private static final String INPUT_TEXTAREA_XPATH = "(//div[@class='c-jobPropsStepCard']//textarea)";
	private static final String DOMAIN1_DRPDWN_BTN_XPATH = "//button[contains(@class,'p-autocomplete-dropdown')]";
	private static final String DOMAIN1_DRPDWN_LIST_XPATH = "//ul[contains(@class,'p-autocomplete-items')]/li/span";
	private static final String CHAARACTER_COUNT_XPATH = "(//span[@class='input-validation ng-star-inserted']//span)";
	private static final String ROW_COUNT_XPATH = "(//span[@class='input-validation ng-star-inserted']//textarea)";
	private static final String JOB_PROPERTIES_STEP_DIALOG_XPATH = "//div[@class='jobListSection js-jobListSection']";
	private static final String PROCEED_DISABLE_XPATH = "(//calcite-button[contains(@class,'btn-showTooltipWhenDisabled')])[1]";
	private static final String DROPDOWN_XPATH = "(//button[contains(@class,'p-autocomplete-dropdown')])";
	private static final String CATEGORYDROPDOWNMENU_XPATH = "//li[contains(@class,'p-autocomplete-item')]";
	private static final String INPUT_HIGHLIGHTED_ERROR_XPATH = "(//input[contains(@class,'u-requiredTextInput')])[1]";
	private static final String REQUIRED_EDIT_WINDOW_XPATH = "//div[contains(@id,'p-accordiontab')]";
	private static final String PROCEED_BTN_XPATH = "//calcite-button[@class='p-element btn-showTooltipWhenDisabled t-proceedBtn ng-star-inserted']";
	private static final String PAUSE_BTN_XPATH = "//div[contains(@class,'c-jobCard__stepExecutionBtnContainer')]/calcite-button[2]";
	// private static final String REQUIRED_EXTEND_PROPERTIES_XPATH
	// ="(//div[contains(@class,'ui-accordion-content ui-widget-content')])[3]";
	// private static final String REQUIRED_EXTEND_PROPERTIES_XPATH
	// ="//button[@class='btn btn-transparent btn-dark-gray
	// c-jobDetailPanel__editPanelBtnControl t-editDetailsBtn
	// btn-showTooltipWhenDisabled ng-star-inserted']";
	private static final String REQUIRED_EXTEND_PROPERTIES_XPATH = "(//div[contains(@class,'ui-accordion ui-widget ui-helper-reset')]/p-accordiontab[2]/div[2])[2]";
	private static final String NORMAL_DEFAULT_EXTEND_PROPERTIES_XPATH = "(//div[contains(@class,'ui-accordion-content ui-widget-content')])[4]";
	private static final String ACTIVE_DATE_IN_CALENDAR = "//span[contains(@class,'p-highlight')]";
	private static final String ACTIVE_MONTH_IN_CALENDAR = "//button[contains(@class,'p-datepicker-month')]";
	private static final String ACTIVE_YEAR_IN_CALENDAR = "//button[contains(@class,'p-datepicker-year')]";	private static final String OPEN_CALENDAR = "//span[@class='p-button-icon pi pi-calendar']";
	private static final String DRPDWN_TEXT_XPATH = "//div[contains(@class,'p-dropdown p-component')]/span";
	private static final String EXTENDEDPROPERTIES_INPUTS_XPATH = "(//span[contains(@class,'p-inputnumber p-component')]/input)";
	private static final String SAVE_BTN_DISABLE_XPATH = "//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl t-saveExtPropsBtn')]";
	private static final String SAVE_BTN_ENABLE_XPATH = "//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl t-saveExtPropsBtn')]";
	private static final String CANCEL_BTN_REQUIRED_XPATH = "//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl t-closeExtPropsBtn')]";
	private static final String OPEN_DRPDWN_BOOL_XPATH1 = "((//p-dropdown[contains(@class,'p-element p-inputwrapper t-related')])//div)[3]";
	private static final String OPTIONS_DRPDWN_BOOL_XPATH = "//ul[contains(@class,'p-dropdown-items')]//li";
	private static final String CALENDER_INPUT_XPATH = "//input[contains(@class,'p-inputtext p-component ng-star-inserted')]";
	private static final String SUCCESSMSG_XPATH = "//wmx-toast//div";
	// private static final String DISABLE_EDIT_BTN_XPATH =
	// "//button[contains(@class,'TooltipWhenDisabled btn-disabled
	// ng-star-inserted')]";
	private static final String DISABLE_EDIT_BTN_XPATH = "//calcite-icon[contains(@class,'infoIcon float-right ng-star-inserted')]";

	private static final String NOTEDITABLE_EXTEND_PROPERTIES_XPATH = "(//div[contains(@class,'ui-accordion-content ui-widget-content')])[5]";
	//edited sarath
	private static final String COLLAPSELEFTPANEL_XPATH = "//div[contains(@class,'c-collapsiblePanel__handle c-collapsiblePanel__handle--right t-leftPanelHandle')]";
	//private static final String COLLAPSELEFTPANEL_XPATH = "//div[@class='c-collapsiblePanel__handle c-collapsiblePanel__handle--right t-leftPanelHandle']";
	private static final String CREATEJOBPANEL_XPATH = "//div[@class='c-advancedLeftPanel__header ng-star-inserted']";
	private static final String SEARCHJOBCREATE_XPATH = "(//input[@class='c-searchBar__searchInput t-searchInput'])";
	private static final String JOBTEMPLATELISTS_XPATH = "//h4[@class='c-thumbnailCard__title t-jobTemplateName']";
	private static final String MORE_XPATH = "(//span[contains(@class,'p-accordion-header-text')])";
	private static final String ASSIGNED_TAB_HEADER_XPATH = "(//th[contains(@class,'workPage__cardListHeaderCol')])[3]/div";
	private static final String ACTIVEJOBTAB_XPATH = "(//li[contains(@class,'p-highlight')])[2]//span";
	private static final String COMPLETE_CHECK_ICON_XPATH = "//span[@class='icon-ui-check-mark']";
	private static final String UPLOADED_FILE_NAME_XPATH = "(//span[@class='grid ng-star-inserted']//input)";
	// private static final String DELETE_UPLOADED_FILE_BTN_XPATH
	// ="(//button[@class='btn btn-transparent ng-star-inserted'])";
	private static final String DELETE_UPLOADED_FILE_BTN_XPATH = "(//calcite-button[@class='p-element ng-star-inserted'])";
	private static final String BROWSE_UPLOADED_FILE_BTN_XPATH = "//input[@type='file']";
	//edited sarath
	//private static final String ATTACHMENTS_XPATH = "(//div[@class='c-customTab c-customTab--iconOnly ng-star-inserted'])[4]";
	private static final String ATTACHMENTS_XPATH = "(//div[contains(@class,'c-customTab c-customTab--iconOnly ng-star-inserted')])[4]";

	
	// private static final String UPLOADED_FILE_AT_JOBDETAILS_XPATH
	// ="(//button[contains(@class,'btn btn-transparent btn-hyperlink')])";
	private static final String UPLOADED_FILE_AT_JOBDETAILS_XPATH = "(//button[contains(@class,'p-button-text btn-hyperlink')])";
	// private static final String i_ICON_XPATH
	// ="(//span[@class='icon-ui-description infoIcon is-hidden-until-hover'])";
	private static final String i_ICON_XPATH = "(//calcite-icon[contains(@class,'infoIcon ')])";
	private static final String UPLOADEDFILEDELETE_BTN_XPATH = "(//calcite-button[contains(@class,'t-deleteAttachmentBtn')])";
	// private static final String DOWNLOAD_UPLOADED_FILE_BTN_XPATH
	// ="(//button[@class='btn btn-transparent ng-star-inserted'])";
	private static final String DOWNLOAD_UPLOADED_FILE_BTN_XPATH = "(//calcite-button[@class='p-element ng-star-inserted'])[3]";
	private static final String CREATE_BUTTON_XPATH = "//div[contains(@class,'t-leftPanelHandle')]//span";
	private static final String JOB_EXECUTION_VIEW_XPATH = "//div[@class='c-jobCard__executionView ng-star-inserted']";
	// private static final String RUN_GP_BTN_XPATH ="(//div[@class='ui-button
	// ui-widget ui-state-default ui-button-text-only ng-star-inserted'])[1]";
	private static final String RUN_GP_BTN_XPATH = "(//div[@class='p-ripple p-element p-button p-component ng-star-inserted'])[1]";
	// private static final String
	// SET_AS_CURRENT_XPATH="//li[@class='ng-star-inserted']";
	private static final String SET_AS_CURRENT_XPATH = "//ul[@class='t-contextMenu']//li";
	private static final String SET_AS_CURRENT_XPATH2 = "(//li[@class='ng-star-inserted'])";

	
	// private static final String
	// DIAGRAM_AND_MAP_TAB_XPATH="(//div[@class='ui-tabview ui-widget
	// ui-widget-content ui-corner-all ui-tabview-top'])[3]/ul/li[3]";
	//private static final String DIAGRAM_AND_MAP_TAB_XPATH = "(//div[@class='p-tabview p-component'])[3]/ul/li[3]";
	
	private static final String DIAGRAM_AND_MAP_TAB_XPATH = "(//div[@class='p-tabview p-component'])[3]/div/div/ul/li[3]";
		
	private static final String STEP_CARD_CONTENT_XPATH = "//div[contains(@class,'c-jobPropsStepCard__contentSection')]";
	private static final String PARAMETER_NAME_XPATH = "//div[@class='c-jobPropsStepCard__propertyLabel ng-star-inserted']";
	// private static final String
	// PARAMETER_INPUT_XPATH="//input[@class='ui-inputnumber-input ui-inputtext
	// ui-corner-all ui-state-default ui-widget ui-state-filled']";
	//private static final String PARAMETER_INPUT_XPATH = "//input[@class='p-inputnumber-input p-inputtext p-component p-filled']";
	private static final String PARAMETER_INPUT_XPATH = "//input[contains(@class,'p-inputtext p-component p-element p-inputnumber-input p-filled')]";

	// private static final String LINK_BUTTON_XPATH="//button[@class='btn btn-clear
	// ng-star-inserted']";
	private static final String LINK_BUTTON_XPATH = "//calcite-button[@class='ng-star-inserted' and @icon-start='link']";
	// private static final String
	// URL_INPUT_XPATH="(//input[contains(@class,'ui-inputtext ui-corner-all
	// ui-state-default ui-widget')])[2]";
	private static final String URL_INPUT_XPATH = "//span[@class='tabGrid-column tabGrid-column-large-1 input-validation isError']//input";
	private static final String URL_INPUT_XPATH_AFTER_ERROR = "//input[@class='p-inputtext p-component ng-invalid p-filled ng-dirty ng-touched']";
	private static final String NAME_INPUT_XPATH = "(//input[contains(@class,'ui-inputtext ui-corner-all ui-state-default ui-widget')])[3]";
	// private static final String
	// SAVE_BTN_XPATH="//button[contains(@class,'ui-button noFill
	// t-addLinkSaveBtn')]";
	private static final String SAVE_BTN_XPATH = "//button[@class='p-button t-addLinkSaveBtn']";
	// private static final String
	// STEP_DROPDOWN_BTN_XPATH="(//div[contains(@class,'ui-dropdown-trigger
	// ui-state-default ui-corner-right')])[1]";
	private static final String STEP_DROPDOWN_BTN_XPATH = "(//div[contains(@class,'p-dropdown p-component')])[1]";
	private static final String STEP_DROPDOWN_LIST_XPATH = "(//ul[contains(@class,'p-dropdown-items')]//li/div/span)";
	// private static final String
	// JOBCARD_ACTION_BTN_XPATH="(//button[contains(@class,'btn
	// btn-transparent')])";
	private static final String JOBCARD_ACTION_BTN_XPATH = "(//calcite-button[contains(@class,'ng-star-inserted')])";
	// private static final String COPY_UPLOADED_FILE_BTN_XPATH
	// ="(//button[@class='btn btn-transparent t-copyFilePathBtn
	// ng-star-inserted'])";
	private static final String COPY_UPLOADED_FILE_BTN_XPATH = "//calcite-button[@class='p-element t-copyFilePathBtn ng-star-inserted']";
	// private static final String FINISH_BTN_XPATH ="//button[@class='btn btn-clear
	// btn-clear-green t-finishBtn']";
	private static final String FINISH_BTN_XPATH = "//calcite-button[@class='t-finishBtn']";
	private static final String EDITATTRIBUTES_XPATH = "//calcite-icon[@icon='editAttributes']";
	// private static final String NOTEDIT_XPATH =
	// "document.querySelector('#p-tabpanel-70 > wmx-job-panel-notes >
	// div.c-jobDetailPanel__sectionHeader > div >
	// calcite-button').shadowRoot.querySelector('button')";
	private static final String NOTEDIT_XPATH = "//calcite-button[@class='p-element t-editNotesBtn btn-showTooltipWhenDisabled ng-star-inserted']";
	private static final String TEXTAREA_XPATH = "//div[contains(@class,'c-jobDetailPanel__sectionContent')]/textarea";
	private static final String SAVENOTESPROMPT_XPATH = "//button[@class='btn p-button']/span";
	private static final String SAVENOTES_XPATH = "//calcite-button[@class='p-element btn-showTooltipWhenDisabled t-saveNotesBtn']";
	private static final String PAUSEBUTTON_XPATH = "//calcite-button[@class='btn-showTooltipWhenDisabled ng-star-inserted']";
	private static final String NOTESUPDATE_XPATH = "(//div[@class='c-grid__content c-grid__content--hoverColorEnabled ng-star-inserted'])[24]";
	private static final String SAVEROLESPRIVILEDGE_XPATH = "//calcite-button[@class='btn-saveBtn t-saveBtn']";
	private static final String VIEWNOTESDETAIL_XPATH = "//div[@class='c-grid__content c-grid__content--hoverColorEnabled ng-star-inserted'][49]";
	private static final String DETAILPANNELREFRESH_XPATH = "//calcite-button[@class='p-element t-refreshPanelBtn']";
	private static final String COMMENTTEXT_XPATH = "//div[@class='c-jobDetailPanel__commentControl']";
	private static final String SENDCOMMENT_XPATH = "//div[@class='actionBar']/calcite-button";
	private static final String VIEWMORE_XPATH = "(//calcite-button[@class='btnShowMore t-btnShowMore'])[3]";
	private static final String SIGNOUT_XPATH = "//calcite-dropdown-item";
	private static final String USERSECTION_XPATH = "//span[@class='flexbox-alignCenter header-account-name']";
	private static final String DISCARDCHANGES_XPATH = "//button[@class='btn p-button noFill ng-star-inserted']/span";
	private static final String COMMENTTEXTAREA_XPATH = "//div[@class='c-jobDetailPanel__commentControl']//textarea";
	private static final String ERRORMESSAGE_XPATH = "(//calcite-notice[@class='c-toast c-alert t-toast ng-star-inserted'])[1]";
	private static final String EDITPROPERTIES_XPATH = "//calcite-button[@class='c-jobDetailPanel__editPanelBtnControl t-editDetailsBtn btn-showTooltipWhenDisabled ng-star-inserted']";
	//edited sarath
	//private static final String ADD_ATTACHMENT_XPATH = "(//calcite-button[@class='c-jobDetailPanel__headerBtn c-jobDetailPanel__headerBtn--right t-addAttachment__btn ng-star-inserted'])";
	private static final String ADD_ATTACHMENT_XPATH ="(//calcite-button[contains(@class,'c-jobDetailPanel__headerBtn c-jobDetailPanel__headerBtn--right t-addAttachment__btn ng-star-inserted')])";

	private static final String ATTACHMENT_XPATH = "(//div[@class='c-propertyContainer__propertyRow ng-star-inserted'])";
	private static final String DELETE_ATTACHMENT_XPATH = "(//calcite-button[@class='is-hidden-until-hover t-deleteAttachmentBtn ng-star-inserted'])";
	private static final String DRAW_FEATURE_XPATH = "(//button[@class='p-element c-sketchToolPicker__actionButton btn btn-white ng-star-inserted'])[1]";
	private static final String SELECT_DRAW_FEATURE_XPATH = "(//span[@class='c-sketchToolPicker__optionItemLabel'])[2]";
	// TS78
	private static final String EDITGID_START = "//calcite-button[contains(@class,'t-editExtPropsBtn')]";
	private static final String EDITGID_INPUT = "//input[contains(@class,'value-stringInput js-propertyInput')]";
	private static final String SAVEGID_INPUT = "//calcite-button[contains(@class,'editPanelBtnControl t-saveExtPropsBtn')]";
	private static final String ATTACHMENT_SAVED_MSG_XPATH = "(//calcite-notice[@class='c-toast c-alert t-toast ng-star-inserted'])[1]";
	// TS94
	private static final String VERIFYQUESTION = "//div[contains(@class,'c-questionStepCard__questionText')]";
	private static final String VERIFYANSWER1 = "(//span[contains(@class,'selectButtonText')])[1]";
	private static final String VERIFYANSWER2 = "(//span[contains(@class,'selectButtonText')])[2]";
	private static final String VERIFYANSWER3 = "(//span[contains(@class,'selectButtonText')])[3]";
	private static final String CANCELBUTTON = "//calcite-button[@data-name='cancelBtn']";
	private static final String STEPNAME = "//span[@data-name='currentStep']";
	private static final String RESUMEBUTTON = "//calcite-button[@data-name='resumeBtn']";
	// TS 96
	private static final String NAME_BY_FILTER_XPATH = "(//div[@class='workPage__cardListHeaderText'])";
	private static final String TOOLTIP_SORT_FIELDS_XPATH = "//div[@class='p-tooltip-text']";
	private static final String HOVER_SORT_FIELDS_XPATH = "//calcite-icon[@icon='questionF']";
	private static final String CURRENT_STEP_XPATH = "(//div[@class='workPage__cardListHeaderText'])";
	private static final String OVERDUE_FILTERBY_XPATH = "(//div[@class='statusToggle ng-star-inserted'])[3]";
	private static final String HIGH_PRIORITY_FILTERBY_XPATH = "(//div[@class='statusToggle ng-star-inserted'])[1]";
	private static final String VERIFY_FIELDS_XPATH = "(//span[@class ='p-sortable-column-badge ng-star-inserted'])";
	private static final String SORT_FILTER_XPATH = "//div[@data-name='jobName']";
	private static final String SORT_FILTER_XPATH2 = "//div[@data-name='jobTemplateName']";
	private static final String SORT_FILTER_XPATH3 = "//div[@data-name='priority']";
	private static final String SORT_FILTER_XPATH4 = "//div[@data-name='dueDate']";
	private static final String SORT_FILTER_XPATH5 = "//div[@data-name='jobStatus']";
	
	//TS101
	private static final String EDIT_JOB_DETAILS_XPATH5 = "//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl')]";
	private static final String PRIORITY_DROP_DOWN_LIST_XPATH = "(//ul[contains(@id,'pr_id_')])//li";
	private static final String PRIORITY_DROP_DOWN_XPATH = "(//div[contains(@class,'p-dropdown-trigger')])";
	private static final String STATUS_DROP_DOWN_LIST_XPATH = "(//ul[contains(@id,'pr_id_')])//li";
	private static final String SAVE_ICON_IN_DETAILS_XPATH ="//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl btn-showTooltipWhenDisabled')]";
	private static final String VERIFY_TOOLTIP_BELL_ICON_XPATH = "//div[@class='p-tooltip-text']";
	private static final String CLICK_EDIT_ICON_XPATH = "//calcite-button[contains(@class,'c-advancedInput__iconBtn c-advancedInput__editBtn')]";
	private static final String INPUT_JOB_NAME_XPATH = "//input[contains(@class,'c-advancedInput__input t-advancedInput__input--editing')]";
	private static final String SAVE_FLOPPY_XPATH = "(//calcite-button[contains(@class,'c-advancedInput__iconBtn c-advancedInput__confirmBtn')])";
	//edited sarath
	//private static final String SELECT_DROPDOWN_XPATH = "//button[contains(@class,'p-element p-button-secondary p-button p-component ng-star-inserted')]";
	private static final String SELECT_DROPDOWN_XPATH = "//button[contains(@class,'p-element p-button-secondary')]";
	private static final String SELECT_DROPDOWN_LIST_XPATH = "//div[contains(@class,'optionBody')]//div";
	//private static final String SELECT_DROPDOWN_LIST_XPATH = "//div[contains(@class,'categorySection ng-star-inserted')]/div";

	private static final String VERIFY_JOB_CARD_MSG_XPATH = "//div[@class='c-jobCard__messageContainer']";
	private static final String BELL_ICON_XPATH = "//div[contains(@tooltipstyleclass,'p-tooltip-breakWord')]";
	private static final String ASSIGN_TO_SELF_ICON_XPATH = "//img[contains(@src,'assets/images/icons/icon_assign_to_self.svg')]";
	private static final String VERIFY_ASSIGN_ICON_XPATH = "//div[@class='p-tooltip-text']";
	//private static final String VERIFY_JOB_CARD_XPATH = "//div[contains(@class,'workPage__cardContainer workPage__cardContainer--hasHorizontalScrollBar')]";
	private static final String VERIFY_JOB_CARD_XPATH = "//div[contains(@class,'workPage__cardContainer')]";

	
	//private static final String SELECT_DROPDOWN_IN_JOB_CARD = "//div[contains(@class,'c-jobCard__properties--parallelStep')]";
	private static final String SELECT_DROPDOWN_IN_JOB_CARD = "//span[contains(@id,'pr_id_19_label')]";

	
	private static final String SELECT_DROPDOWN_LIST_IN_JOB_CARD = "(//ul[contains(@class,'p-dropdown-items')])//li";
	private static final String VERIFY_DROPDOWN_REFLECTS_IN_DETAILS = "(//span[contains(@class,'p-dropdown-label p-inputtext')])";
	private static final String CLICK_DETAILS_XPATH = "//div[contains(@class,'c-collapsiblePanel__handle c-collapsiblePanel__handle--left t-rightPanelHandle')]";

	//TS103
    private static final String OPENDIAGRAMPOPUP = "//calcite-icon[contains(@class,'maximizeDiagramBtn')]";	
    private static final String TOOLTIP_TEST = "//div[@class='p-tooltip-text']";
    private static final String SINGLEJOB_PROCEED = "//calcite-button[contains(@class,'t-startBtn')]";
    private static final String GRID_VALUE = "(//div[contains(@class,'t-promptText')])"; 
    private static final String SINGLEJOB_PROCEED_RUNNING = "//calcite-button[contains(@class,'t-proceedBtn')]";
	
	//TC 3484
    
    private static final String HISTORY_YES_BTN_QUESTION_STEP = "//span[text()='Yes']";
	
	private static final String HISTORY_START_END_COMPLETED_TEXT = "//*[text()='Start/End Completed']";
	
	private static final String HISTORY_START_END_COMPLETED_USER_TEXT = "//*[text()='Start/End Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_START_END_COMPLETED_TIME_TEXT = "//*[text()='Start/End Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_ADD_COMMENT_XPATH = "//*[text()='Add Comment Completed']";
	
	private static final String HISTORY_ADD_COMMENT_USER_XPATH = "//*[text()='Add Comment Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_ADD_COMMENT_TIME_XPATH = "//*[text()='Add Comment Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_MANUAL_STEP_COMPLETED_TEXT = "//*[text()='Manual Step Completed']";
	
	private static final String HISTORY_MANUAL_STEP_COMPLETED_USER_TEXT = "//*[text()='Manual Step Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_MANUAL_STEP_COMPLETED_TIME_TEXT = "//*[text()='Manual Step Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_QUESTION_COMPLETED_TEXT = "//*[text()='Question Completed']";
	
	private static final String HISTORY_QUESTION_COMPLETED_USER_TEXT = "//*[text()='Question Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_QUESTION_COMPLETED_TIME_TEXT = "//*[text()='Question Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_ADD_ATTACHMENT_COMPLETED_TEXT = "//*[text()='Add Attachment Completed']";
	
	private static final String HISTORY_ADD_ATTACHMENT_COMPLETED_USER_TEXT = "//*[text()='Add Attachment Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_ADD_ATTACHMENT_COMPLETED_TIME_TEXT = "//*[text()='Add Attachment Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_RUN_GP_SERVICES_COMPLETED_TEXT = "//*[text()='Run GP Service Completed']";
	
	private static final String HISTORY_RUN_GP_SERVICES_COMPLETED_USER_TEXT = "//*[text()='Run GP Service Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_RUN_GP_SERVICES_COMPLETED_TIME_TEXT = "//*[text()='Run GP Service Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_M_JOB_PROPERTIES_COMPLETED_TEXT = "//*[text()='Update 1-M Job Properties Completed']";
	
	private static final String HISTORY_M_JOB_PROPERTIES_COMPLETED_USER_TEXT = "//*[text()='Update 1-M Job Properties Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_M_JOB_PROPERTIES_COMPLETED_TIME_TEXT = "//*[text()='Update 1-M Job Properties Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_JOB_UPDATED_TEXT = "//*[text()='Job Updated']";
	
	private static final String HISTORY_JOB_UPDATED_USER_TEXT = "//*[text()='Job Updated']//following-sibling::span[2]";
	
	private static final String HISTORY_UPDATE_JOB_PROPERTIES_TEXT = "//*[text()='Update Job Properties Completed']";
	
	private static final String HISTORY_UPDATE_JOB_PROPERTIES_USER_TEXT = "//*[text()='Update Job Properties Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_UPDATE_JOB_PROPERTIES_TIME_TEXT = "//*[text()='Update Job Properties Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_OPEN_WEB_PAGE_TEXT = "//*[text()='Open Web Page Completed']";
	
	private static final String HISTORY_OPEN_WEB_PAGE_USER_TEXT = "//*[text()='Open Web Page Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_OPEN_WEB_PAGE_TIME_TEXT = "//*[text()='Open Web Page Completed']//following-sibling::div/calcite-chip[2]";
	
	private static final String HISTORY_SEND_WEB_REQUEST_TEXT = "//*[text()='Send Web Request Completed']";
	
	private static final String HISTORY_SEND_WEB_REQUEST_USER_TEXT = "//*[text()='Send Web Request Completed']//following-sibling::span[2]";
	
	private static final String HISTORY_SEND_WEB_REQUEST_TIME_TEXT = "//*[text()='Send Web Request Completed']//following-sibling::div/calcite-chip[2]";
	
    private static final String HISTORY_JOB_CLOSED_TEXT = "//*[text()='Job Closed']";
	
	private static final String HISTORY_JOB_CLOSED_USER_TEXT = "//*[text()='Job Closed']//following-sibling::span[2]";
	
	private static final String HISTORY_JOB_CLOSED_TIME_TEXT = "//*[text()='Job Closed']//following-sibling::div/calcite-chip[2]";
	
	private static final String JOB_CHECK_BOX_XPATH = "//wmx-work-job-card//wmx-work-job-card-content-job-props-step//p-checkbox/div/div[2]";
	
	private static final String JOB_NUMBER_INPUT_BOX_XPATH = "//wmx-work-job-card-content-job-props-step//p-inputnumber/span/input";
	
	private static final String HISTORY_JOB_CREATED_XPATH = "//wmx-job-panel-history/div/div[1]/calcite-card/h3";
	private static final String HISTORY_USER_XPATH = "//wmx-job-panel-history/div/div[1]/calcite-card/span[2]";
	
	
	
	static CommonFunction cfunction = new CommonFunction();

	//TC107
	public static boolean verifySetAsCurrentOption2() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(SET_AS_CURRENT_XPATH2 +"[10]"));
		if (rows.size() >= 1)
			return true;
		return false;
	}
	//TS103
	
		public static boolean verifyStepNameVersion(String input) throws Exception {
			boolean verified = false;
			try {
				cfunction.sync(75);
				String xpath = "(//span[contains(@class,'c-dropdown__menuItemLabel')])";
				//boolean check;
				String text=cfunction.getElementText(xpath);
				if (text.equalsIgnoreCase(input) )
				{
					System.out.println("Current Step is =="+text);
					verified = true;
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return verified;

		}
		
		public static void verifyDiagramSetJobVersionA() throws Exception {
			
			cfunction.Commmon_Click("xpath", OPENDIAGRAMPOPUP);
			cfunction.sync(19);
			SikuliHelp.verifyImageExists("TS103_SetJobVersionA_1280x768");
			
		}
		
		public static void selectStepFromDropDown(String text) {
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "(//wmx-step-parallel-control/p-dropdown//div)[4]");
			cfunction.sync(7);
			List<WebElement> menues = driver.findElements(By.xpath("//span[@class='c-dropdown__menuItemLabel']"));
			for (WebElement item : menues) {
				if (item.getText().equalsIgnoreCase(text)) {
					item.click();
					break;
				}
				
			}
			
		}
		
		public static void hoverOnWarning() {
			
			cfunction.hoverByAction("//div[contains(@class,'c-jobCard__notification')]/calcite-icon");
			cfunction.sync(17);
			
			
			
		}
		
		public static void clickProceedSingleJob() {
			cfunction.hoverByAction(SINGLEJOB_PROCEED);
			cfunction.Commmon_Click("xpath", SINGLEJOB_PROCEED);
			cfunction.sync(35);
		}
		
		public static void clickProceedSingleJobWhileRunning() {
			cfunction.hoverByAction(SINGLEJOB_PROCEED_RUNNING);
			cfunction.Commmon_Click("xpath", SINGLEJOB_PROCEED_RUNNING);
			cfunction.sync(35);
		}
		
		public static void verify_PopUpMessage(String msg) {
			List<WebElement> popUP = driver.findElements(By.xpath(TOOLTIP_TEST));
			 WebElement popUP1 = driver.findElement(By.xpath(TOOLTIP_TEST));
			int size =popUP.size();
			String message="";
			if(size>0) {
				message=popUP1.getText();
				 CommonFunction.logStatus("PASS", msg+"- "+message);
			} else {
				message="New pop up not here";
				System.out.println(message);
	       	 CommonFunction.logStatus("FAIL", msg+"- "+message);
			}
		}
		
		public static void verify_GridValueExist(String msg) {
			List<WebElement> popUP = driver.findElements(By.xpath(GRID_VALUE));
			 WebElement popUP1 = driver.findElement(By.xpath(GRID_VALUE));
			int size =popUP.size();
			String message="";
			if(size==1) {
				message=popUP1.getText();
				 CommonFunction.logStatus("PASS", msg+"- "+message);
			} else {
				message="Unable to locate One Grid Value";
				System.out.println(message);
	       	 CommonFunction.logStatus("FAIL", msg+"- "+message);
			}
		}
		
	

		
	
	//TS101
	public static void clickEditJobDetails() {
		cfunction.Commmon_Click("xpath", EDIT_JOB_DETAILS_XPATH5);
	}
	public static void selectPriorityDropDown(String option) throws Exception {
		cfunction.selectOptionFromDropDown(PRIORITY_DROP_DOWN_XPATH + "[1]", PRIORITY_DROP_DOWN_LIST_XPATH, option);
	}
	public static void selectStatusDropDown(String option) throws Exception {
		(new WebDriverWait(driver,60))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRIORITY_DROP_DOWN_XPATH + "[2]")));
		cfunction.selectOptionFromDropDown(PRIORITY_DROP_DOWN_XPATH + "[2]", STATUS_DROP_DOWN_LIST_XPATH, option);
	}
	public static void clickSaveIconInDetails() {
		cfunction.Commmon_Click("xpath", SAVE_ICON_IN_DETAILS_XPATH);
	}
	public static void verifyChangeInJobCard() {
		WebElement findElementByXPath = driver.findElementByXPath(VERIFY_TOOLTIP_BELL_ICON_XPATH);
		String text = findElementByXPath.getText();
		findElementByXPath.isDisplayed();
		System.out.println(text);
	}
	public static void hoverToEditPencilIcon() {
		cfunction.hoverByAction(CLICK_EDIT_ICON_XPATH);
	}
	public static void clickOnEditPencilIcon() {
		cfunction.Commmon_Click("xpath", CLICK_EDIT_ICON_XPATH);
	}
	public static void enterInputJobCardName(String text) throws Exception {
		cfunction.Commmon_Click("xpath", INPUT_JOB_NAME_XPATH);
		cfunction.CommonTextBox_Input(INPUT_JOB_NAME_XPATH, text);
	}
	public static void clickOnSaveFloppyIcon() {
		cfunction.Commmon_Click("xpath", SAVE_FLOPPY_XPATH + "[1]");
	}

/*	public static void selectAssignmentDropDown(String option) throws Exception {

		cfunction.selectOptionFromDropDown(SELECT_DROPDOWN_XPATH, SELECT_DROPDOWN_LIST_XPATH, option);
		// cfunction.Commmon_Click("xpath", SELECT_DROPDOWN_XPATH);
		for (int i = 0; i <= 2; i++) {
			try {
				driver.findElement(By.xpath(SELECT_DROPDOWN_LIST_XPATH));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}*/
	public static void selectAssignmentDropDown(String step) {
		cfunction.Commmon_Click("xpath", SELECT_DROPDOWN_XPATH);
		cfunction.sync(10);
		cfunction.selectValueFromMenueItem(SELECT_DROPDOWN_LIST_XPATH, step);
		for (int i = 0; i <= 2; i++) {
			try {
				driver.findElement(By.xpath(SELECT_DROPDOWN_LIST_XPATH));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void verifyJobCardChangeMsg() {
		WebElement findElementByXPath = driver.findElementByXPath(VERIFY_JOB_CARD_MSG_XPATH);
		String text = findElementByXPath.getText();
		findElementByXPath.isDisplayed();
		System.out.println(text);
	}
	public static void hoverToBellIcon() {
		cfunction.hoverByAction(BELL_ICON_XPATH);
	}
	public static void clickOnBellIcon() {
		cfunction.Commmon_Click("xpath",BELL_ICON_XPATH );
	}
	public static void hoverAssignToSelfIcon() {
		cfunction.hoverByAction(ASSIGN_TO_SELF_ICON_XPATH);
	}
	public static void clickOnAssignToSelfIcon() {
		cfunction.Commmon_Click("xpath",ASSIGN_TO_SELF_ICON_XPATH);
	}
	public static void verifyAssignIcon() {
		WebElement findElementByXPath = driver.findElementByXPath(VERIFY_ASSIGN_ICON_XPATH);
		String text = findElementByXPath.getText();
		findElementByXPath.isDisplayed();
		System.out.println(text);
	}
	public static void verifyChangeInJobCard1() {
		WebElement findElementByXPath = driver.findElementByXPath(VERIFY_JOB_CARD_XPATH);
		String text = findElementByXPath.getText();
		findElementByXPath.isDisplayed();
		System.out.println(text);
	}
	
	/*public static void selectDropDownInJobCard(String option) throws Exception {
		cfunction.selectOptionFromDropDown(SELECT_DROPDOWN_IN_JOB_CARD, SELECT_DROPDOWN_LIST_IN_JOB_CARD, option);
	}*/
	//TC101
	public static void selectStepFromDrpdwn2(String step) {
		cfunction.Commmon_Click("xpath", STEP_DROPDOWN_BTN_XPATH);
		cfunction.sync(10);
		cfunction.selectValueFromMenueItem(STEP_DROPDOWN_LIST_XPATH, step);
	}
	public static void verifyDropdownReflectsInDetails() {
		WebElement findElementByXPath = driver.findElementByXPath(VERIFY_DROPDOWN_REFLECTS_IN_DETAILS + "[2]");
		String text = findElementByXPath.getText();
		findElementByXPath.isDisplayed();
		System.out.println(text);
	}
	public static void clickExpandDetailsBtn() {
		cfunction.Commmon_Click("xpath", CLICK_DETAILS_XPATH);
	}

	//TS97
		public static void selectStep(String text) {
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "(//div[contains(@class,'p-dropdown-trigger')])[1]");
			cfunction.sync(7);
			List<WebElement> menues = driver.findElements(By.xpath("//span[@class='c-dropdown__menuItemLabel']"));
			for (WebElement item : menues) {
				if (item.getText().equalsIgnoreCase(text)) {
					item.click();
					break;
				}
				
			}
			
		}
		
		public static boolean checkJobAssignedTo(String xpath, String text) {
			boolean verified= false;
			cfunction.sync(7);
			String textAssign = cfunction.getElementText1(xpath);
			System.out.println("Test Assign to ==>"+textAssign);
			if(text.equals(textAssign)) {
				verified = true;
			}else {
				verified = false;
			}
			
			
			
			return verified;
		}
	
	
	
	// TS 96
	public static void clickNameByFilter() {
		cfunction.Commmon_Click("xpath", NAME_BY_FILTER_XPATH + "[2]");
	}
	public static void hoverOverSortFields() throws Exception {
		cfunction.hoverByAction(HOVER_SORT_FIELDS_XPATH);
	}

	public static void verifyTooltipSortFields() {
		WebElement verifytooltip = driver.findElement(By.xpath(TOOLTIP_SORT_FIELDS_XPATH));
		verifytooltip.getText();
	}

	public static void ClickOnCtrlCurrentStep() throws Exception {
		Actions builder = new Actions(driver);
		WebElement findElementByXPath = driver.findElementByXPath("(//div[@class='workPage__cardListHeaderText'])[3]");
		builder.keyDown(Keys.LEFT_CONTROL).click(findElementByXPath).build().perform();
	}

	public static void ClickOnCtrlType() throws Exception {
		Actions builder = new Actions(driver);
		WebElement findElementByXPath = driver.findElementByXPath("(//div[@class='workPage__cardListHeaderText'])[4]");
		builder.keyDown(Keys.LEFT_CONTROL).click(findElementByXPath).build().perform();

	}

	public static void ClickOnCtrlPriority() throws Exception {
		Actions builder = new Actions(driver);
		WebElement findElementByXPath = driver.findElementByXPath("(//div[@class='workPage__cardListHeaderText'])[5]");
		builder.keyDown(Keys.LEFT_CONTROL).click(findElementByXPath).build().perform();

	}

	public static void ClickOnCtrlDueDate() throws Exception {
		Actions builder = new Actions(driver);
		WebElement findElementByXPath = driver.findElementByXPath("//div[text()='Due Date ']");
		builder.keyDown(Keys.LEFT_CONTROL).click(findElementByXPath).build().perform();

	}

	public static void ClickOnCtrlStatus() throws Exception {
		Actions builder = new Actions(driver);
		WebElement findElementByXPath = driver.findElementByXPath("(//div[@class='workPage__cardListHeaderText'])[7]");
		builder.keyDown(Keys.LEFT_CONTROL).click(findElementByXPath).build().perform();

	}

	public static void clickOnOverDueFilterBy() {
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", OVERDUE_FILTERBY_XPATH);
	}

	public static void clickOnHighPriorityFilterBy() {
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", HIGH_PRIORITY_FILTERBY_XPATH);
	}

	public static void verifyFieldsInOrderCurrent() {
		WebElement verify = driver.findElement(By.xpath(VERIFY_FIELDS_XPATH + "[2]"));
		boolean displayed = verify.isDisplayed();
		boolean enabled = verify.isEnabled();
		System.out.println(displayed);
		System.out.println(enabled);
	}

	public static void verifyFieldsInOrderType() {
		WebElement verify = driver.findElement(By.xpath(VERIFY_FIELDS_XPATH + "[3]"));
		boolean displayed = verify.isDisplayed();
		boolean enabled = verify.isEnabled();
		System.out.println(displayed);
		System.out.println(enabled);
	}

	public static void verifyFieldsInOrderPriority() {
		WebElement verify = driver.findElement(By.xpath(VERIFY_FIELDS_XPATH + "[4]"));
		boolean displayed = verify.isDisplayed();
		boolean enabled = verify.isEnabled();
		System.out.println(displayed);
		System.out.println(enabled);
	}

	public static void verifyFieldsInOrder() {
		WebElement verify = driver.findElement(By.xpath(VERIFY_FIELDS_XPATH));
		boolean displayed = verify.isDisplayed();
		boolean enabled = verify.isEnabled();
		System.out.println(displayed);
		System.out.println(enabled);
	}

	public static boolean verifyOrderSortName() throws InterruptedException {
		return CommonFunction.checkSorting(SORT_FILTER_XPATH);
	}

	public static boolean verifyOrderSortType() throws InterruptedException {
		return CommonFunction.checkSorting(SORT_FILTER_XPATH2);
	}

	public static boolean verifyOrderSortpriority() throws InterruptedException {
		return CommonFunction.checkSorting(SORT_FILTER_XPATH3);
	}

	public static boolean verifyOrderSortDueDate() throws InterruptedException {
		return CommonFunction.checkSorting(SORT_FILTER_XPATH4);
	}

	public static boolean verifyOrderSortStatus() throws InterruptedException {
		return CommonFunction.checkSorting(SORT_FILTER_XPATH5);
	}

	// TS95
	public static boolean numberIsTwo() {
		int size = driver.findElements(By.xpath("//div[contains(@class,'c-jobPropsStepCard__propertyValue')]")).size();

		return (size == 2);
	}

	public static boolean verifyValues() {
		boolean present = false;
		cfunction.sync(7);
		String text1 = cfunction.getElementText1("(//div[contains(@class,'c-jobPropsStepCard__propertyLabel')])[1]");
		String text2 = cfunction.getElementText1("(//div[contains(@class,'c-jobPropsStepCard__propertyLabel')])[2]");
		System.out.println("Answer Text is=>" + text1);
		System.out.println("Answer Text is=>" + text2);
		if (text1.contains("Priority") && text2.contains("Status")) {
			present = true;
		}
		return present;
	}

	public static boolean verifyFieldValues() {
		boolean present = false;
		cfunction.sync(7);
		String text1 = cfunction.getElementText1("(//span[contains(@class,'p-dropdown-label p-inputtext')])[1]");
		String text2 = cfunction.getElementText1("(//span[contains(@class,'p-dropdown-label p-inputtext')])[2]");
		System.out.println("Answer Text is=>" + text1);
		System.out.println("Answer Text is=>" + text2);
		if (text1.contains("Medium") && text2.contains("Created")) {
			present = true;
		}
		return present;
	}

	public static void selectFromDropdown(/* String xpath1, */ String xpath, String value) throws Exception {
		/*
		 * WebElement element = driver.findElementByXPath(xpath1); element.click();
		 */
		cfunction.sync(7);
		List<WebElement> menues = driver.findElements(By.xpath(xpath));
		for (WebElement item : menues) {
			if (item.getText().equalsIgnoreCase(value)) {
				item.click();
				break;
			}
		}
	}

	public static boolean verifyDropdownValues(String xpath1, String xpath, List value) throws Exception {
		boolean verified = false;
		WebElement element = driver.findElementByXPath(xpath1);
		element.click();
		cfunction.sync(7);
		List<WebElement> menues = driver.findElements(By.xpath(xpath));
		List<String> values = new ArrayList<>();

		for (WebElement item : menues) {
			String text1 = item.getText();
			values.add(text1);
		}
		System.out.println("Captured list==>" + values);

		if (values.equals(value)) {
			verified = true;
		}

		return verified;

	}

	public static boolean verifyJobDetails(String xpath, String text) {
		boolean values = false;
		String textcap = cfunction.getElementText1(xpath);
		System.out.println("Valus is =>" + text);
		if (text.equals(textcap)) {
			values = true;
		}
		return values;
	}

	// TS 94

	public static void clickYesBtn() {
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", VERIFYANSWER1);

	}

	public static boolean verifyStepName(String stepName) {
		boolean present = false;
		cfunction.sync(7);
		String text = cfunction.getElementText1(STEPNAME);
		System.out.println("Step Name is => " + text);
		if (text.equals(stepName)) {
			present = true;
		}
		return present;
	}

	public static void clickCancelButton() {
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", CANCELBUTTON);

	}

	public static void clickResumeButton() {
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", RESUMEBUTTON);

	}

	public static boolean verifyCancelBtn() {
		boolean present = false;
		present = cfunction.isPageElementPresent("xpath", CANCELBUTTON);
		return present;
	}

	public static boolean verifyResumeBtn() {
		boolean present = false;
		present = cfunction.isPageElementPresent("xpath", RESUMEBUTTON);
		return present;
	}

	public static boolean verifyQuestion() {
		boolean present = false;
		cfunction.sync(7);
		String text = cfunction.getElementText1(VERIFYQUESTION);
		System.out.println("Question Text is=>" + text);
		if (text.contains("I Proceed")) {
			present = true;
		}
		return present;
	}

	public static boolean verifyQuestion2() {
		boolean present = false;
		cfunction.sync(7);
		String text = cfunction.getElementText1(VERIFYQUESTION);
		System.out.println("Question Text is=>" + text);
		if (text.contains("your answer")) {
			present = true;
		}
		return present;
	}

	public static boolean verifyAnswers() {
		boolean present = false;
		cfunction.sync(7);
		String text1 = cfunction.getElementText1(VERIFYANSWER1);
		String text2 = cfunction.getElementText1(VERIFYANSWER2);
		System.out.println("Answer Text is=>" + text1);
		System.out.println("Answer Text is=>" + text2);
		if (text1.contains("Yes") && text2.contains("No")) {
			present = true;
		}
		return present;
	}

	public static boolean verifyAnswers2() {
		boolean present = false;
		cfunction.sync(7);
		String text1 = cfunction.getElementText1(VERIFYANSWER1);
		String text2 = cfunction.getElementText1(VERIFYANSWER2);
		String text3 = cfunction.getElementText1(VERIFYANSWER3);
		System.out.println("Answer Text is=>" + text1);
		System.out.println("Answer Text is=>" + text2);
		System.out.println("Answer Text is=>" + text3);
		if (text1.contains("A") && text2.contains("B") && text3.contains("C")) {
			present = true;
		}
		return present;
	}

	public static void clickCstep() {
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", VERIFYANSWER3);
	}

	// TS 78
	public static void clickEditProperty() {
		cfunction.sync(10);
		cfunction.Commmon_Click("xpath", EDITGID_START);
	}

	public static void enterGID() throws AWTException, Exception {
		cfunction.sync(10);

		cfunction.Commmon_Click("xpath", EDITGID_INPUT);
		cfunction.CommonTextBox_Input8(EDITGID_INPUT, "9948842");

	}

	public static void clickSaveGIDProperty() {
		cfunction.sync(10);
		cfunction.Commmon_Click("xpath", SAVEGID_INPUT);
	}

	// Click on Open Job Details
	public static void clickOnDiagramAndMapTab() {
		// cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		cfunction.Commmon_Click("xpath", DIAGRAM_AND_MAP_TAB_XPATH);
	}

	public static void clickRunGPBtn() throws Exception {
		cfunction.Commmon_Click("XPATH", RUN_GP_BTN_XPATH);
	}

	public static void clickOnSetAsCurrentBtn() {
		cfunction.Commmon_Click("xpath", SET_AS_CURRENT_XPATH);
	}

	public static void clickOnSetAsCurrentBtn1() {
		cfunction.Commmon_Click("xpath", "//ul[@id='context_menu_expanded_view']/li[@class='ng-star-inserted']");
	}

	public static boolean verifySetAsCurrentOption() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(SET_AS_CURRENT_XPATH));
		if (rows.size() >= 1)
			return true;
		return false;
	}

	public static void downloadUploadedFile(String i) throws Exception {
		// cfunction.Commmon_Click("XPATH",DOWNLOAD_UPLOADED_FILE_BTN_XPATH+"["+i+"]");
		cfunction.Commmon_Click("XPATH", DOWNLOAD_UPLOADED_FILE_BTN_XPATH);
	}

	public static void clickUploadDeleteBtn(String i) throws Exception {
		cfunction.Commmon_Click("XPATH", UPLOADEDFILEDELETE_BTN_XPATH + "[" + i + "]");
	}

	public static void hoverUploadDeleteBtn(String i) throws Exception {
		cfunction.hoverByAction(UPLOADEDFILEDELETE_BTN_XPATH + "[" + i + "]");
	}

	public static void hoverErrorIcon() throws Exception {
		cfunction.hoverByAction(ERROR_ICON_XPATH);
	}

	public static void hoverCreateBtn() throws Exception {
		cfunction.hoverByAction(CREATE_BUTTON_XPATH);
	}

	public static void clickUploadedFile(String i) throws Exception {
		cfunction.Commmon_Click("xpath", UPLOADED_FILE_AT_JOBDETAILS_XPATH + "[" + i + "]");
		// driver.findElement(By.linkText(UPLOADED_FILE_AT_JOBDETAILS_XPATH+"["+i+"]")).click();
		/*
		 * cfunction.pressEnterKey(); cfunction.pressTAB(1); cfunction.pressEnterKey();
		 */
	}

	public static void hover_i_Icon(String i) throws Exception {
		cfunction.hoverByAction(i_ICON_XPATH + "[" + i + "]");
	}

	public static void hoverUploadedFile(String i) throws Exception {
		cfunction.hoverByAction(UPLOADED_FILE_AT_JOBDETAILS_XPATH + "[" + i + "]");
	}

	public static void clickOnAttachment() {
		cfunction.Commmon_Click("xpath", ATTACHMENTS_XPATH);
	}

	public static void deleteUploadedFile(String i) throws Exception {
		cfunction.Commmon_Click("XPATH", DELETE_UPLOADED_FILE_BTN_XPATH + "[" + i + "]");
	}

	public static void renameUploadedFile3(String i, String text) throws Exception {
		// cfunction.CommonTextBox_Input(UPLOADED_FILE_NAME_XPATH+"["+i+"]",text);
		WebElement ele = driver.findElementByXPath(UPLOADED_FILE_NAME_XPATH + "[" + i + "]");
		// ele.sendKeys(Keys.TAB);
		/*
		 * Robot robot= new Robot(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyPress(KeyEvent.VK_TAB);
		 */
		Actions builder = new Actions(driver);
		ele.sendKeys(Keys.BACK_SPACE);
		cfunction.CommonTextBox_Input2("//span[@class='grid ng-star-inserted']//input", text);
		// WebElement urlTextField = driver.findElement(By.xpath("DIALOGUE_BOX_INPUT_XPATH+\"[1]\"");
		// Actions builder = new Actions(driver);
		// Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		ele.sendKeys(Keys.BACK_SPACE);
		//  WebElement descPaste = driver.findElement(By.cssSelector("input[id=\"descriptioninput\"]");
		ele.click();
		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		System.out.println(text);

	}

	public static void renameUploadedFile(String i, String text) throws Exception {
		// cfunction.CommonTextBox_Input(UPLOADED_FILE_NAME_XPATH+"["+i+"]",text);
		WebElement ele = driver.findElementByXPath(UPLOADED_FILE_NAME_XPATH + "[" + i + "]");
		// ele.sendKeys(Keys.TAB);
		/*
		 * Robot robot= new Robot(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyPress(KeyEvent.VK_TAB);
		 */
		cfunction.CommonTextBox_Input2(UPLOADED_FILE_NAME_XPATH + "[" + i + "]", text);
		// WebElement urlTextField = driver.findElement(By.xpath("DIALOGUE_BOX_INPUT_XPATH+\"[1]\"");
		Actions builder = new Actions(driver);
		// Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		ele.sendKeys(Keys.BACK_SPACE);
		//  WebElement descPaste = driver.findElement(By.cssSelector("input[id=\"descriptioninput\"]");
		ele.click();
		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		System.out.println(text);

	}

	public static boolean textPresence(String compareText) {
		boolean present = true;
		String userPrompt = cfunction.getElementText1("(//div[@class='c-manualStepCard']/div)[1]");
		System.out.println("User Prompt Text==>" + userPrompt);
		String stepHelp = cfunction.getElementText1("(//div[@class='c-manualStepCard']/div)[2]");
		System.out.println("User Step Help==>" + stepHelp);
		if (compareText.equals(userPrompt) && compareText.equals(stepHelp)) {
			present = true;
		} else {
			present = false;
		}
		return present;
	}

	public static boolean textPresence2(String compareText) {
		boolean present = true;
		String userPrompt = cfunction.getElementText1("(//div[@class='c-questionStepCard']/div)[1]");
		System.out.println("User Prompt Text==>" + userPrompt);
		String stepHelp = cfunction.getElementText1("(//div[@class='c-questionStepCard']/div)[3]");
		System.out.println("User Step Help==>" + stepHelp);
		if (compareText.equals(userPrompt) && compareText.equals(stepHelp)) {
			present = true;
		} else {
			present = false;
		}
		return present;
	}

	public static boolean textPresence3(String compareText) {
		boolean present = true;
		String userPrompt = cfunction.getElementText1("(//div[@class='c-attachmentStepCard']/div)[1]");
		System.out.println("User Prompt Text==>" + userPrompt);
		String stepHelp = cfunction.getElementText1("((//div[@class='c-attachmentStepCard']/div)[2]/div)[3]");
		System.out.println("User Step Help==>" + stepHelp);
		if (compareText.equals(userPrompt) && compareText.equals(stepHelp)) {
			present = true;
		} else {
			present = false;
		}
		return present;
	}

	public static boolean textPresence5(String compareText) {
		boolean present = true;
		String userPrompt = cfunction.getElementText1("(//div[@class='c-manualStepCard']/div)[1]");
		System.out.println("User Prompt Text==>" + userPrompt);
		String stepHelp = cfunction.getElementText1("(//div[@class='c-manualStepCard']/div)[2]");
		System.out.println("User Step Help==>" + stepHelp);
		if (compareText.equals(userPrompt) && compareText.equals(stepHelp)) {
			present = true;
		} else {
			present = false;
		}
		return present;
	}

	public static boolean textPresence4(String compareText) {
		boolean present = true;
		String userPrompt = cfunction.getElementText1("(//div[@class='c-defineLocationStepCard']/div)[1]");
		System.out.println("User Prompt Text==>" + userPrompt);
		String stepHelp = cfunction.getElementText1("(//div[@class='c-defineLocationStepCard']/div)[3]");
		System.out.println("User Step Help==>" + stepHelp);
		if (compareText.equals(userPrompt) && compareText.equals(stepHelp)) {
			present = true;
		} else {
			present = false;
		}
		return present;
	}

	public static void selectAddJob() throws Exception {
		cfunction.waitforpagetoload();
		cfunction.sync(7);
		SikuliHelp.rightClickOnMap("TS84_AddJobComment_1280x768");
		cfunction.sync(7);
		clickOnSetAsCurrentBtn();
	}

	public static void pressContinue() {
		cfunction.Commmon_Click("xpath", "//p-selectbutton/div/div");
	}

	public static void pressCancel() {
		cfunction.Commmon_Click("xpath", "//calcite-button[@data-name='cancelBtn']");
	}

	// SURVEY123 TS83

	public static void submitForm() {
		cfunction.waitforpagetoload();
		cfunction.sync(7);
		WebElement frameEle = driver.findElementByXPath("//wmx-work-job-card-content-survey123-step/div//iframe");
		driver.switchTo().frame(frameEle);
		// cfunction.Commmon_Click("xpath",
		// "//wmx-work-job-card-content-survey123-step");
		/*
		 * WebElement wmxsformEle =
		 * driver.findElementByXPath("//wmx-work-job-card-content-survey123-step/div");
		 * wmxsformEle.click();
		 */// wmxsformEle.sendKeys(Keys.TAB);

		WebElement radioEle = driver.findElementByXPath("(//label[@role='presentation'])[1]");
		radioEle.click();
		// cfunction.Commmon_Click("xpath", "(//input[@type='radio'])[1]");
		cfunction.CommonTextBox_Input("//textarea", "Report Incident");
		WebElement ele = driver.findElementByXPath("//textarea");
		ele.sendKeys(Keys.TAB);
		cfunction.sync(10);
		cfunction.Commmon_Click("xpath", "//div[@class='esri-geo__deviceLocationRequiredMask']");
		cfunction.sync(7);
		cfunction.ScrollBottom();
		cfunction.Commmon_Click("xpath", "//button[@id='validate-form']");
		driver.switchTo().defaultContent();

	}

	public static boolean verifyJobCompleted() {
		boolean present = false;
		String text = cfunction.getElementText1("//calcite-button[@aria-label='Dismiss Job']");
		cfunction.sync(7);
		if (text.contains("Dismiss")) {
			cfunction.Commmon_Click("xpath", "//calcite-button[@aria-label='Dismiss Job']");
			present = true;
		} else {
			present = false;
		}
		return present;

	}

	public static void renameUploadedFile(String text) throws Exception {
		// cfunction.CommonTextBox_Input(UPLOADED_FILE_NAME_XPATH+"["+i+"]",text);
		//// WebElement ele=
		// driver.findElementByXPath(UPLOADED_FILE_NAME_XPATH+"["+i+"]");
		// ele.sendKeys(Keys.TAB);
		/*
		 * Robot robot= new Robot(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyPress(KeyEvent.VK_TAB);
		 */
		cfunction.CommonTextBox_Input(UPLOADED_FILE_NAME_XPATH, text);
		// cfunction.CommonTextBox_Input2(text,UPLOADED_FILE_NAME_XPATH+"["+i+"]");
		// WebElement urlTextField = driver.findElement(By.xpath("DIALOGUE_BOX_INPUT_XPATH+\"[1]\"");
		//// Actions builder = new Actions(driver);
		// Actions builder = new Actions(driver);
		//// builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

		//// builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		//// ele.sendKeys(Keys.BACK_SPACE);
		//  WebElement descPaste = driver.findElement(By.cssSelector("input[id=\"descriptioninput\"]");
		//// ele.click();
		//// builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		System.out.println(text);

	}

	public static void verifyPromptText(String value) throws Exception {
		// cfunction.sync(5);
		cfunction.verifyElementText(JOB_PROMPT_TEXT_XPATH, value);
	}

	public static boolean verifyParameterText(String value) throws Exception {
		return cfunction.verifyElementText(PARAMETER_NAME_XPATH, value);
	}

	public static void verifyPromptText2(String value) throws Exception {
		// cfunction.sync(5);
		cfunction.verifyElementText(JOB_PROMPT2_TEXT_XPATH, value);
	}

	public static void selectFileToUpload(String fileName) throws FindFailed, InterruptedException, IOException {

		// SeleniumHelp.Common_Click2("xpath", IMAGEWITHNOAPPEARANCE1BUTTON1_XPATH);
		// cfunction.skipWindowDialogBoxAfterClick();
		// cfunction.CommonTextBox_Input8("((//span[contains(@class,'ui-fileupload-choose')])//input)[1]",
		// System.getProperty("user.dir") + "\\testData\\"+fileName);
	//	cfunction.Commmon_Click("xpath", "");
		cfunction.sync(5);// wait
		cfunction.skipWindowDialogBoxAfterClick();
		/*cfunction.CommonTextBox_Input8("//span[@class='//span[@class='p-ripple p-element p-button p-component p-fileupload-choose']//input",
				System.getProperty("user.dir") + "\\testData\\WMX_TestData\\" + fileName);*/
		cfunction.CommonTextBox_Input8("//span[@pripple]//input",
				System.getProperty("user.dir") + "\\testData\\WMX_TestData\\" + fileName);
		// WebElement txtBox =
		// driver.findElement(By.xpath(BROWSE_UPLOADED_FILE_BTN_XPATH));
		/*
		 * WebElement txtBox = driver.findElement(By.
		 * xpath("//span[@class='p-button p-component p-fileupload-choose p-ripple']"));
		 * txtBox.clear(); txtBox.sendKeys(
		 * "C:\\Automation\\Workspace\\WorkflowManager\\testData\\WMX_TestData\\"+
		 * fileName);
		 */// txtBox.sendKeys("C:\\Automation\\GIT2\\ps-software-release\\WorkflowManager\\testData\\"+fileName);
			// txtBox.click();
			// cfunction.CommonTextBox_Input(
			// "((//span[contains(@class,'ui-fileupload-choose')])//input)[1]", fileName );

		/*
		 * WebElement browser = driver.findElement(By.
		 * xpath("//span[@class='p-button p-component p-fileupload-choose p-ripple']"));
		 * //Browse button /// WebElement browser = driver.findElement(By.
		 * xpath("//span[@class='p-button p-component p-fileupload-choose p-ripple']/input"
		 * )); //Browse button browser.click(); System.out.println("1");
		 * 
		 * 
		 * Runtime.getRuntime().exec(
		 * "C:\\Automation\\Workspace\\WorkflowManager\\testData\\WMX_TestData\\"+
		 * fileName); System.out.println("2"); Thread.sleep(3000);
		 * 
		 * WebElement upload = driver.findElement(By.id("btnSave")); //Upload button
		 * upload.click(); System.out.println("3");
		 * 
		 * System.out.println("File Uploaded Successfully"); // Confirmation message
		 */
	}

	public static boolean clickOnJobDetails(String jobName) throws Exception {
		boolean itemClicked = false;
		/*if(browser.equals("Firefox")) {
			
			cfunction.Commmon_Click("xpath", "//div[@title='"+jobName+"']");
			CommonFunction.waitforHomePagetoload();
			return itemClicked = true;
		}*//*
		else {*/
		Thread.sleep(19000);
		CommonFunction.waitforHomePagetoload();
		// cfunction.sync(10);
		// CommonFunction.ScrollBottom(); //div[@class='c-jobCard__mainContainer
		// ng-star-inserted']/div[2]
		// CommonFunction.ScrollToElement("(//div[@class='c-jobCard__mainContainer
		// ng-star-inserted']/div[@title='"+jobName+"'])");

		CommonFunction.ScrollToElement(
				"(//div[@class='c-jobCard__mainContainer ng-star-inserted']/div[@title='Always New Execute GP Service'])");
		System.out.println("scrolled");
		CommonFunction.waitforHomePagetoload();
		//CommonFunction.ScrollToElement1("//div[@title='"+jobName+"']");
		System.out.println("scrolled");
		// cfunction.ScrollToElement(JOBNAME_XPATH+"[50]");
		// cfunction.sync(10);
		List<WebElement> items = driver.findElements(By.xpath(JOBNAME_XPATH));
		cfunction.sync(2);
		for (int i = 0; i < items.size(); i++) {
			String job = items.get(i).getText();
			System.out.println(job);
			String openJobDetailsXpath = JOBNAME_XPATH + "[" + (i + 1) + "]";
			if (job.equalsIgnoreCase(jobName)) {
				// cfunction.CommmonJS_Click(openJobDetailsXpath);
				cfunction.Commmon_Click("xpath", openJobDetailsXpath);
				cfunction.sync(2);
				itemClicked = true;
				System.out.println(jobName + "------- Clicked on Open Job Details");
				break;
			} else {
				//System.out.println("Job Name did not matched");
				// cfunction.CommmonJS_Click(openJobDetailsXpath);
				// Commented by sandeep
				/*
				String openJobDetailsXpath1 = JOBNAME_XPATH + "[" + (i + 6) + "]";
				cfunction.Commmon_Click("xpath", openJobDetailsXpath1);
				List<WebElement> items1 = driver.findElements(By.xpath(JOBNAME_XPATH));
				items = items1;
				*/
				cfunction.sync(2);
			}
		}
		return itemClicked;
	}

	public static boolean clickOnJobDetailsAfterRefresh(String jobName) throws Exception {
		boolean itemClicked = false;
		CommonFunction.waitforHomePagetoload();
		// cfunction.sync(10);
		// CommonFunction.ScrollBottom(); //div[@class='c-jobCard__mainContainer
		// ng-star-inserted']/div[2]
		// CommonFunction.ScrollToElement("(//div[@class='c-jobCard__mainContainer
		// ng-star-inserted']/div[2])[49]");
		System.out.println("scrolled");
		CommonFunction.waitforHomePagetoload();
		// cfunction.ScrollToElement(JOBNAME_XPATH+"[50]");
		// cfunction.sync(10);
		List<WebElement> items = driver.findElements(By.xpath(JOBNAME_XPATH_AFTERREFRESH));
		cfunction.sync(2);
		for (int i = 0; i < items.size(); i++) {
			String job = items.get(i).getText();
			System.out.println(job);
			String openJobDetailsXpath = JOBNAME_XPATH_AFTERREFRESH + "[" + (i + 1) + "]";
			if (job.equalsIgnoreCase(jobName)) {
				// cfunction.CommmonJS_Click(openJobDetailsXpath);
				cfunction.Commmon_Click("xpath", openJobDetailsXpath);
				cfunction.sync(2);
				itemClicked = true;
				System.out.println(jobName + "------- Clicked on Open Job Details");
				break;
			} else {
				System.out.println("Job Name did not matched");
				// cfunction.CommmonJS_Click(openJobDetailsXpath);
				cfunction.Commmon_Click("xpath", openJobDetailsXpath);
				List<WebElement> items1 = driver.findElements(By.xpath(JOBNAME_XPATH_AFTERREFRESH));
				items = items1;
				// cfunction.sync(2);
			}
		}
		return itemClicked;
	}

	// Click on Disgram & map
	public static void clickOnDiagramMap() {
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", DIAGRAMMAP_XPATH);
	}

	// Click on 'NEW' filter by button
	public static void clickOnNewFilterBy() {
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", NEW_FILTERBY_XPATH);
	}

	// Click on History button
	public static void clickOnHistory() {
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", HISTORY_XPATH);
	}

	// Click on Comments button
	public static void clickOnComments() {
		cfunction.Commmon_Click("xpath", COMMENTS_XPATH);
	}

	public static void clickOnCompletCheckIcon() {
		cfunction.Commmon_Click("xpath", COMPLETE_CHECK_ICON_XPATH);
	}

	public static void clickOnStartBtn() {
		cfunction.Commmon_Click("xpath", START_BTN_XPATH);
	}

	public static void clickOnFinishBtn() {
		cfunction.Commmon_Click("xpath", FINISH_BTN_XPATH);

	}

	// Click on Properties button
	public static void clickOnProperties() {
		cfunction.Commmon_Click("xpath", PROPERTIES_XPATH);
	}

	// Click on Close Panel
	public static void clickOnClosePanel() {
		cfunction.Commmon_Click("xpath", CLOSEPANEL_XPATH);
	}

	public static boolean verifyWorkTabOpen() {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath(WORKPAGE_XPATH));
			if (rows.size() > 0) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean verifyMyJobsActive() {
		boolean verified = false;
		try {
			String title = cfunction.getElementText(ACTIVEJOBTAB_XPATH);
			if (title.equalsIgnoreCase("My Jobs")) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static boolean verifyAllJobsActive() {
		boolean verified = false;
		try {
			String title = cfunction.getElementText(ACTIVEJOBTAB_XPATH);
			if (title.equalsIgnoreCase("All Jobs")) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static void clickOnCustomeSearchIcon() {
		cfunction.Commmon_Click("xpath", CUSTOMSEARCHICON_XPATH);
	}

	public static void clickOnCustomSearchInput() {
		cfunction.Commmon_Click("xpath", CUSTOMSEARCHINPUT_XPATH);
	}

	public static boolean verifyCustomQueryStatement() {
		boolean verified = false;
		try {
			String username = xls.getCellData("en-us", 2, 2);
			String query = cfunction.getElementAttribute(CUSTOMSEARCHINPUT_XPATH, "value");
			if (query.contains(username)) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static void clickonCustomQueryX() {
		cfunction.Commmon_Click("xpath", CUSTOMQUERYX_XPATH);
	}

	public static boolean verifyCustomQueryCleared() {
		boolean verified = false;
		try {
			String query = cfunction.getElementAttribute(CUSTOMSEARCHINPUT_XPATH, "value");
			if (query.isEmpty()) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static void enterCustomSearch(String query) {
		cfunction.CommonTextBox_Input(CUSTOMSEARCHINPUT_XPATH, query);
	}

	public static void enterParameterInput(String query) {
		cfunction.CommonTextBox_Input(PARAMETER_INPUT_XPATH, query);
	}

	public static boolean verifyCustomQueryTab() {
		boolean verified = false;
		try {
			WebElement element = driver.findElement(By.xpath(CUSTOMQUERYTAB_XPATH));
			if (element != null) {
				verified = true;
				System.out.println("Custom Query Tab is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Custom Query Tab is NOT present in canvas");
		}
		return verified;
	}

	public static boolean verifyAllJobs() {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath(JOBCARD_XPATH));
			if (rows.size() > 0) {
				verified = true;
				System.out.println("Total Jobs -->> " + rows.size());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static boolean verifyJobsOrderAscending() throws InterruptedException {
		return CommonFunction.checkSorting(JOBNAMELIST_XPATH);
	}

	public static void sortOnJobNameAZ() throws InterruptedException {
		cfunction.Commmon_Click("xpath", SORT_XPATH);

	}

	public static void clickOnMyGroups() {
		// cfunction.Commmon_Click("xpath", MYGROUPJOBSTAB_XPATH);
		cfunction.CommmonJS_Click(MYGROUPJOBSTAB_XPATH);
	}

	public static void clickOnAllJobs() {
		cfunction.Commmon_Click("xpath", ALLJOBSTAB_XPATH);
	}

	public static void clickOnMyJobs() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", MYJOBSTAB_XPATH);
	}

	public static void clickOnCustomQueryTab() {
		cfunction.Commmon_Click("xpath", CUSTOMQUERYTAB_XPATH);
	}

	public static void clickOnCustomQueryHistory() {
		cfunction.Commmon_Click("xpath", CUSTOMQUERYHISTORY_XPATH);
	}

	public static int getCustomSearchHistory() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(HISTORYITEM_XPATH));
		return rows.size();
	}

	public static void clickOnRecentSearch() throws Exception {
		cfunction.Commmon_Click("xpath", HISTORYITEM_XPATH);
	}

	public static void clickOnDismissCustomQuery() throws Exception {
		cfunction.Commmon_Click("xpath", DISMISSCUSTOMQUERY_XPATH);
	}

	public static void clickOnCloseJobPanel() throws Exception {
		cfunction.Commmon_Click("xpath", CLOSE_JOB_DETAIL_PANEL_XPATH);
	}

	public static void clickOnCollapseSummaryBtn() throws Exception {
		cfunction.sync(19);
		cfunction.Commmon_Click("xpath", COLLAPSE_SUMMARY_XPATH);
	}

	public static boolean scrollToJob(String Jobname) throws Exception {
		boolean verified = false;
		int i = 0;
		try {

			List<WebElement> rows = driver.findElements(By.xpath(ALLJOBLIST_XPATH));
			System.out.println(rows.size());

			if (verified == false) {

				for (i = 0; i < 1000; i++) {
					String job = rows.get(i).getText();
					System.out.println(job);
					if (job.equalsIgnoreCase(Jobname)) {
						verified = true;
						// cfunction.ScrollToElement("("+JOBCARD_XPATH+")["+(i+1)+"]");
						cfunction.Commmon_Click("XPATH", "(" + JOBCARD_XPATH + ")[" + (i + 1) + "]");
						break;
					} else {
						cfunction.Commmon_Click("XPATH", "(" + JOBCARD_XPATH + ")[" + (i + 1) + "]");
						System.out.println("Not previously created job");
						List<WebElement> rows1 = driver.findElements(By.xpath(ALLJOBLIST_XPATH));
						rows = rows1;
						verified = false;

					}
				}
			} else {
				WorkPage.scrollToJob(Jobname);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static boolean verifyCurrentStepOfJob(String Jobname, String Step) throws Exception {
		boolean verified = false;
		try {
			// cfunction.Commmon_Click("XPATH",LASTJOBELEMENT_XPATH);
			cfunction.sync(5);
			List<WebElement> rows = driver.findElements(By.xpath(ALLJOBLIST_XPATH));
			cfunction.sync(5);
			List<WebElement> steps = driver.findElements(By.xpath(JOB_STEPLIST_XPATH));
			System.out.println(steps.size());
			for (int i = 0; i < rows.size(); i++) {
				String job = rows.get(i).getText();
				String step = steps.get(i).getText();
				System.out.println(job + "..........." + step);
				if (job.equalsIgnoreCase(Jobname)) {
					if (step.equalsIgnoreCase(Step)) {
						cfunction.sync(10);
						cfunction.CommmonJS_Click("(" + ALLJOBLIST_XPATH + ")[" + (i + 1) + "]");
						// cfunction.Commmon_Click("XPATH", "("+ALLJOBLIST_XPATH+")["+(i+1)+"]");
						verified = true;
						break;
					}
				} else {
					verified = false;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static boolean clickOnresumeStepOfJob(String Jobname) throws Exception {
		boolean verified = false;
		int i = 0;
		try {
			cfunction.sync(5);
			List<WebElement> rows = driver.findElements(By.xpath(ALLJOBLIST_XPATH));
			List<WebElement> steps = driver.findElements(By.xpath(JOB_STEPLIST_XPATH));
			cfunction.sync(5);
			System.out.println(steps.size());

			if (verified == false) {

				for (i = 0; i < rows.size(); i++) {
					String job = rows.get(i).getText();
					System.out.println(job);
					if (job.equalsIgnoreCase(Jobname)) {
						verified = true;
						// cfunction.ScrollToElement("("+JOBCARD_XPATH+")["+(i+1)+"]");
						cfunction.Commmon_Click("XPATH", "(" + JOBCARD_XPATH + ")[" + (i + 1) + "]");
						cfunction.sync(5);
						// cfunction.CommmonJS_Click("("+JOBSTARTSTEP_XPATH+")["+(i+1)+"]");
						cfunction.Commmon_Click("XPATH",
								"(" + JOBCARD_XPATH + ")[" + (i + 1) + "]/div/div[3]/div/calcite-button[1]");
						cfunction.sync(5);
						break;
					} else {
						cfunction.Commmon_Click("XPATH", "(" + JOBCARD_XPATH + ")[" + (i + 1) + "]");
						System.out.println("Not previously created job");
						verified = false;
					}
				}
			} else {
				WorkPage.scrollToJob(Jobname);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static boolean verifyMaximumLength(String length, int i, String rowcount) throws Exception {
		boolean verified = false;
		String maxLength = null;
		String rowsItem = null;
		List<WebElement> count = driver.findElements(By.xpath(CHAARACTER_COUNT_XPATH + "[" + i + "]"));
		List<WebElement> row = driver.findElements(By.xpath(ROW_COUNT_XPATH + "[" + i + "]"));
		for (WebElement rows : row) {
			rowsItem = rows.getAttribute("rows");
			System.out.println(rowsItem + "  --  ");
			// String drpdwnValue = count.get(i).getText();
		}
		for (WebElement rowCount : count) {
			maxLength = rowCount.getText();
			System.out.println(maxLength + "  --  ");

		}
		if (maxLength.contains(length) || rowsItem.contains(rowcount)) {
			verified = true;
		} else {
			verified = false;
		}

		return verified;
	}

	public static boolean verifyJobExecutionViewVisible() {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath(JOB_EXECUTION_VIEW_XPATH));
			if (rows.size() > 0) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean clickOnStartStepOfJob(String Jobname) throws Exception {
		boolean verified = false;
		int i = 0;
		try {
			cfunction.sync(5);
			List<WebElement> rows = driver.findElements(By.xpath(ALLJOBLIST_XPATH));
			List<WebElement> steps = driver.findElements(By.xpath(JOB_STEPLIST_XPATH));
			cfunction.sync(5);
			System.out.println(steps.size());
			System.out.println(jobName);
			if (verified == false) {

				for (i = 0; i < rows.size(); i++) {
					String job = rows.get(i).getText();
					System.out.println(job);
					if (job.equalsIgnoreCase(Jobname)) {
						verified = true;
						// cfunction.ScrollToElement("("+JOBCARD_XPATH+")["+(i+1)+"]");
						String jobname = "(" + JOBCARD_XPATH + ")[" + (i + 1) + "]";
						cfunction.Commmon_Click("XPATH", jobname);
						cfunction.sync(5);
						String Step = jobname + "/div/div[3]/div/calcite-button[1]";
						cfunction.CommmonJS_Click(Step);
						cfunction.sync(5);
						break;
					} else {
						cfunction.Commmon_Click("XPATH", "(" + JOBCARD_XPATH + ")[" + (i + 1) + "]");
						System.out.println("Not previously created job");
						verified = false;
					}
				}
			} else {
				WorkPage.scrollToJob(Jobname);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}
	/*
	 * boolean verified = false; try { cfunction.sync(5);
	 * //cfunction.CommmonJS_Click(LASTJOBELEMENT_XPATH);
	 * //cfunction.Commmon_Click("XPATH",LASTJOBELEMENT_XPATH); cfunction.sync(5);
	 * List<WebElement> rows = driver.findElements(By.xpath(ALLJOBLIST_XPATH));
	 * List<WebElement> steps = driver.findElements(By.xpath(JOB_STEPLIST_XPATH));
	 * System.out.println(steps.size()); for(int i = 0; i<rows.size(); i++){ String
	 * job = rows.get(i).getText(); String step=steps.get(i).getText();
	 * System.out.println(job+"...."+step); if(job.equalsIgnoreCase(Jobname)) {
	 * //cfunction.Commmon_Click("XPATH", "("+ALLJOBLIST_XPATH+")["+(i+1)+"]");
	 * cfunction.CommmonJS_Click("("+ALLJOBLIST_XPATH+")["+(i+1)+"]");
	 * cfunction.sync(5); //cfunction.Commmon_Click("XPATH",
	 * "("+JOBSTARTSTEP_XPATH+")["+(i+1)+"]");
	 * cfunction.CommmonJS_Click("("+JOBSTARTSTEP_XPATH+")["+(i+1)+"]"); verified =
	 * true; break; } else { verified=false; } } }catch(Exception ex) {
	 * ex.printStackTrace(); } return verified; }
	 */

	public static boolean verifyDismissMessage(String successMsg) {
		boolean verified = false;
		String msg1 = cfunction.getElementText("(" + DISMISSMESSAGE_XPATH_XPATH + ")[1]");
		String msg2 = cfunction.getElementText("(" + DISMISSMESSAGE_XPATH_XPATH + ")[2]");
		String msg = msg1 + " " + msg2;
		/*
		 * //String[] arrOfStr = msg.split(" ", 2); for (String a : arrOfStr) {
		 * System.out.println(arrOfStr[0]); //jobName = arrOfStr[0]; }
		 */
		System.out.println(msg);
		if (msg.contains(successMsg)) {
			verified = true;
		}
		return verified;
	}

	public static void clickOnDismissJobTileButton() throws Exception {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", DISMISSJOBTILE_BTN_XPATH);
	}

	public static boolean verifyDismissJobTileButtonVisible() throws Exception {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(DISMISSJOBTILE_BTN_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

	}

	public static void clickCompleteBtn() throws Exception {
		cfunction.Commmon_Click("xpath", COMPLETE_BTN_XPATH);
	}

	public static void clickCollapseJobDetailBtn() throws Exception {
		cfunction.Commmon_Click("xpath", COLLAPSE_JOB_DETAIL_XPATH);
	}

	public static void enterTextArea(String i, String text) throws Exception {
		cfunction.CommonTextBox_Input(INPUT_TEXTAREA_XPATH + "[" + i + "]", text);
	}

	public static boolean verifyCountHighlightedRed(int i) throws Exception {
		cfunction.sync(5);
		String xPath = CHAARACTER_COUNT_XPATH + "[" + i + "]";
		String color = cfunction.getCSSValue(xPath, "color");
		cfunction.sync(2);
		color = cfunction.getCSSValue(xPath, "color");
		String hex = cfunction.rgbToHex(color);
		System.out.println("Color ---> " + hex);
		//if (hex.equalsIgnoreCase("#c86a4a"))
			if (hex.equalsIgnoreCase("#d83020"))	
			return true;
		return false;
	}

	public static boolean verifyCollapsedJobDetailWidegetVisible() {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath(COLLAPSED_JOB_DETAIL_WIDGET_XPATH));
			if (rows.size() > 0) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static void enterDomain1Input(String input) throws Exception {
		// cfunction.selectValueFromDropdown_new(DOMAIN1_DRPDWN_BTN_XPATH,
		// DOMAIN1_DRPDWN_LIST_XPATH, input);
		// cfunction.CommmonJS_Click(DOMAIN1_DRPDWN_BTN_XPATH);
		cfunction.Commmon_Click("xpath", DOMAIN1_DRPDWN_BTN_XPATH);
		// cfunction.CommonTextBox_Input("(//div[@class='c-jobPropsStepCard__propertyValue
		// ng-star-inserted']//input)[2]", "Ten");
		cfunction.sync(2);

		List<WebElement> items = driver.findElements(By.xpath(DOMAIN1_DRPDWN_LIST_XPATH));
		for (WebElement item : items) {
			String menuItem = item.getText();
			// String menuItem = item.getAttribute("aria-label");
			if (menuItem.contains("  ")) {
				menuItem = menuItem.split("  ")[0];
			}
			System.out.println(menuItem + "  --  " + input);
			if (menuItem.equalsIgnoreCase(input)) {
				item.click();
				break;
			}
		}

	}

	public static void clickTextArea(String i) throws Exception {
		cfunction.Commmon_Click("XPATH", INPUT_TEXTAREA_XPATH + "[" + i + "]");
	}

	public static void enterIntegerInput(String input) throws Exception {
		// cfunction.sync(2);
		cfunction.CommonTextBox_Input(INTEGER_INPUT_XPATH, input);
	}

	public static boolean verifyJobPropertiesStepDialogVisible() throws Exception {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(JOB_PROPERTIES_STEP_DIALOG_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

	}

	public static void clickIntegerTextArea() throws Exception {
		cfunction.Commmon_Click("XPATH", INTEGER_INPUT_XPATH);
	}

	public static boolean verifyErrorHighlighted() throws Exception {
		cfunction.sync(5);
		boolean verified = false;
		if (cfunction.elementIsDisplayed(ERROR_ICON_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

		/*
		 * sd String xPath=ERROR_ICON_XPATH; String color = cfunction.getCSSValue(xPath,
		 * "color"); cfunction.sync(2); color = cfunction.getCSSValue(xPath, "color");
		 * String hex = cfunction.rgbToHex(color); System.out.println("Color ---> " +
		 * hex); if(hex.equalsIgnoreCase("#c86a4a")) return true; return false;
		 */
	}

	public static boolean verifyErrorvisible() {
		boolean verified = false;
		/*List<WebElement> rows = driver.findElements(
				By.xpath("//div[@class='c-jobCard__notification c-jobCard__notification--red ng-star-inserted']"));
		*/
		List<WebElement> rows = driver.findElements(
				By.xpath("//div[@class='p-element c-jobCard__notification c-jobCard__notification--red ng-star-inserted']"));
		
		if (rows.size() == 1) {
			verified = true;

		}
		return verified;

		/*
		 * List<WebElement> rows = driver.findElements(By.
		 * xpath("//div[@class='c-jobCard__notification c-jobCard__notification--red ng-star-inserted']"
		 * )); WebElement headerElement = driver.findElement(By.
		 * xpath("//div[@class='c-jobCard__notification c-jobCard__notification--red ng-star-inserted']"
		 * )); String txtItem = headerElement.getText(); String
		 * txtItem1=headerElement.getCssValue(txtItem); System.out.println(txtItem +
		 * "  --  " + currentStep); if (txtItem.equalsIgnoreCase(currentStep)) {
		 * verified = true; System.out.println(txtItem + " Error text found"); } return
		 * verified;
		 */
	}

	public static boolean clickOnJobTabOption(String jobTemplate) {
		int listcount = 1;
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(JOBSTAB_XPATH));
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
			if (rowsItem.contains(jobTemplate)) {
				verified = true;
				System.out.println(jobTemplate + " is visible");
				String checkbox = "(" + JOBSTAB_XPATH + ")[" + listcount + "]";
				cfunction.Commmon_Click("xpath", checkbox);
				// break;
			} else {
				System.out.println(jobTemplate + " is not visible");
			}
			listcount++;
		}
		return verified;

	}

	public static void clickOnReturnToJobButton() throws Exception {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", RETURNTOJOB_BTN_XPATH);
	}

	public static boolean verifyJobAssignmentName(String assignment) throws Exception {
		boolean verified = false;
		// String assignUser= cfunction.getElementAttribute(ASSIGN_USER_TO_JOB_XPATH,
		// "text");
		String assignUser1 = cfunction.getElementText(ASSIGN_USER_TO_JOB_XPATH);
		if (assignUser1.equalsIgnoreCase(assignment)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyStep(String step) throws Exception {
		boolean verified = false;
		// String assignUser= cfunction.getElementAttribute(ASSIGN_USER_TO_JOB_XPATH,
		// "text");
		String assignUser1 = cfunction.getElementText("//div[@class='c-jobCard__summaryInfoPair'][2]/div");
		if (assignUser1.equalsIgnoreCase(step)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

		/*
		 * boolean verified = false; try {
		 * //cfunction.Commmon_Click("XPATH",LASTJOBELEMENT_XPATH); cfunction.sync(5);
		 * List<WebElement> jobs = driver.findElements(By.xpath(ALLJOBLIST_XPATH));
		 * List<WebElement> assigns = driver.findElements(By.xpath(JOB_STEPLIST_XPATH));
		 * System.out.println(assigns.size()); for(int i = 0; i<jobs.size(); i++){
		 * String job = jobs.get(i).getText();
		 * System.out.println(jobs.get(i).getAttribute("title"));
		 * System.out.println(assigns.get(i).getAttribute("title")); String
		 * assign=assigns.get(i).getText(); System.out.println(jobs+"..........."+
		 * assign); if(job.equalsIgnoreCase(Jobname)) {
		 * if(assign.equalsIgnoreCase(assignment)) { cfunction.Commmon_Click("XPATH",
		 * "("+ALLJOBLIST_XPATH+")["+(i+1)+"]"); verified = true; break; }} else {
		 * verified=false; } } }catch(Exception ex) { ex.printStackTrace(); } return
		 * verified;
		 */
	}

	public static boolean verifyStepDrpdwnVisible() throws Exception {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(STEP_DRPDWN_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

	}

	public static void selectCategory(String category, int index) {
		cfunction.Commmon_Click("xpath", DROPDOWN_XPATH + "[" + index + "]");
		cfunction.sync(5);
		cfunction.selectValueFromMenueItem(CATEGORYDROPDOWNMENU_XPATH, category);
	}

	public static boolean verifyBlankFieldIndicateRed() throws Exception {
		if (cfunction.verifyIfHighlighted1(INPUT_HIGHLIGHTED_ERROR_XPATH, "color", "#c86a4a"))
			return true;
		return false;

	}

	public static void clickOnTitle() {
		cfunction.Commmon_Click("xpath", "//div[contains(@class,'c-jobPropsStepCard__promptText')]");

	}

	public static void openDropDown(int index) {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", DROPDOWN_XPATH + "[" + index + "]");

	}

	public static boolean verifyProceedIsDisable() {
		boolean verified = false;
		try {

			List<WebElement> rows = driver.findElements(By.xpath(PROCEED_DISABLE_XPATH));
			if (rows.size() == 1) {
				verified = true;
				System.out.println("Button Disable");
			}
		} catch (Exception ex) {
			System.out.println("Button is not enable");
		}
		return verified;
	}

	public static boolean verifyProceedIsVisible() {
		boolean verified = false;
		try {
			WebElement stepLib = driver.findElement(By.xpath(PROCEED_BTN_XPATH));
			if (stepLib != null) {
				verified = true;
				System.out.println("Button Visible");
			}
		} catch (Exception ex) {
			System.out.println("Button is not visible");
		}
		return verified;
	}

	public static void clickOnProceedBtn() {
		cfunction.Commmon_Click("xpath", PROCEED_BTN_XPATH);

	}

	public static void clickOnPauseBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", PAUSE_BTN_XPATH);

	}

	public static void clickCreateBtn() throws Exception {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL_XPATH);
		/*
		 * cfunction.sync(2); cfunction.Commmon_Click("xpath", CREATE_BUTTON_XPATH);
		 */
		// cfunction.CommmonJS_Click(CREATE_BUTTON_XPATH);
	}

	public static void clickCreateBtn1() throws Exception {
		cfunction.sync(2);
		// cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL_XPATH);

		// cfunction.Commmon_Click("xpath", CREATE_BUTTON_XPATH);
		// cfunction.CommmonJS_Click("//div[contains(@class,'t-leftPanelHandle')]");
		WebElement icon = driver.findElement(By.xpath("//div[contains(@class,'t-leftPanelHandle')]//span"));
		Actions ob = new Actions(driver);
		ob.click(icon);
		Action action = ob.build();
		cfunction.sync(2);
		action.perform();

	}

	public static void clickLocation() throws Exception {
		// cfunction.Commmon_Click("xpath",
		// "(//span[contains(@class,'ui-accordion-toggle-icon')])[4]");
		cfunction.Commmon_Click("xpath", "(//a[contains(@class,'p-accordion-header-link')])[4]");
		// cfunction.Commmon_Click("xpath",
		// "(//span[contains(@class,'p-accordion-toggle-icon')])[4]");
	}

	public static void clickOnPauseBtn1() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", PAUSE_BTN_XPATH_1);

	}

	public static void selectValueFromDropdown(String value) throws Exception {
		// cfunction.Commmon_Click("xpath",OPEN_STEP_DRPDWN_XPATH );
		cfunction.CommmonJS_Click(OPEN_STEP_DRPDWN_XPATH);
		cfunction.sync(2);
		List<WebElement> option = driver.findElements(By.xpath(STEP_DRPDWN_OPTIONS_XPATH));
		cfunction.sync(2);
		for (int i = 0; i < option.size(); i++) {
			String drpdwnValue = option.get(i).getText();
			// (WebElement row:option) {
			if (drpdwnValue.equalsIgnoreCase(value)) {
				cfunction.Commmon_Click("XPATH", "(" + STEP_DRPDWN_OPTIONS_XPATH + ")[" + (i + 1) + "]");
				break;
			}
		}
	}

	public static boolean verifyJobDetailWindow(String jobname) throws Exception {
		boolean verified = false;
		WebElement jobnameTag = driver.findElementByXPath(JOBDETAILS_TAB_NAME_XPATH);
		String jobnameTag1 = jobnameTag.getText();
		System.out.println(jobnameTag1);
		if (jobnameTag1.equalsIgnoreCase(jobname)) {
			System.out.println("Same Job's detail window open");
			verified = true;
		} else {
			System.out.println("Different job detail window");
		}
		return verified;

	}

	public static void clickOnEditBtnOfRequired() throws Exception {
		// cfunction.Commmon_Click("XPATH", EXTEND_PROPERTIES_EDIT_BTNS_XPATH+"[1]");
		cfunction.Commmon_Click("XPATH", EXTEND_PROPERTIES_EDIT_BTNS_XPATH);
	}

	public static void clickOnEditBtnOfRequired(int index) throws Exception {
		// cfunction.Commmon_Click("XPATH", EXTEND_PROPERTIES_EDIT_BTNS_XPATH+"[1]");
		cfunction.Commmon_Click("XPATH",
				"(//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl')])" + "[" + index + "]");
	}

	public static void clickOnAddNewRecordBtnOfNormalDefault(int index) throws Exception {
		cfunction.Commmon_Click("XPATH", EXTEND_PROPERTIES_EDIT_BTNS_XPATH + "[" + index + "]");

	}

	public static void OpenCalendar() throws Exception {
		// cfunction.Commmon_Click("XPATH", OPEN_CALENDAR);
		// cfunction.CommmonJS_Click(OPEN_CALENDAR);
		WebElement icon = driver.findElement(By.xpath(OPEN_CALENDAR));
		Actions ob = new Actions(driver);
		ob.click(icon);
		Action action = ob.build();
		action.perform();
	}

	public static void clickOnRequiredExtendproperties() throws Exception {
		// cfunction.Commmon_Click("xpath", "(//div[@class='c-propertyContainer__content
		// t-extendedProperty__value'])[15]");
		cfunction.Commmon_Click("XPATH", REQUIRED_EXTEND_PROPERTIES_XPATH);
	}

	public static boolean verifyEditBtnDisable() throws Exception {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(DISABLE_EDIT_BTN_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyRequiredWindowOpenInEdit() throws Exception {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(REQUIRED_EDIT_WINDOW_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyActiveDateInCalendar(String date) throws Exception {
		boolean verified = false;
		// WorkPage.OpenCalendar();
		WebElement defaultDate = driver
				.findElementByXPath("//input[contains(@class,'p-inputtext p-component ng-star-inserted')]");
		System.out.println("value :" + defaultDate.getAttribute("value"));
		System.out.println("placeholder :" + defaultDate.getAttribute("placeholder"));
		System.out.println("class :" + defaultDate.getAttribute("class"));
		String a = defaultDate.getAttribute("value");
		String b = defaultDate.getAttribute("placeholder");
		String c = defaultDate.getAttribute("class");
		/*
		 * String menuItem = defaultDate.getText(); String menuItem2 =
		 * defaultDate.getAttribute("innerHTML"); String menuItem3
		 * =defaultDate.getAttribute("textContent"); String menuItem4 =
		 * defaultDate.getAttribute("value"); String menuItem5 =
		 * defaultDate.getAttribute("innerText"); String menuItem6 =
		 * defaultDate.getAttribute("outerText");
		 * System.out.println("menuItem: "+menuItem);
		 * System.out.println("menuItem2: "+menuItem2);
		 * System.out.println("menuItem3: "+menuItem3);
		 * System.out.println("menuItem4: "+menuItem4);
		 * System.out.println("menuItem5: "+menuItem5);
		 * System.out.println("menuItem6: "+menuItem6);
		 */
		System.out.println(a + "........." + b + "................." + c);
		String Date = cfunction.getElementText(ACTIVE_DATE_IN_CALENDAR);
		String Month = cfunction.getElementText(ACTIVE_MONTH_IN_CALENDAR);
		String Year = cfunction.getElementText(ACTIVE_YEAR_IN_CALENDAR);
		String actualDate = Date + Month + Year;
		System.out.println("actualDate: " + actualDate + " date: " + date);
		if (actualDate.equalsIgnoreCase(date)) {
			System.out.println("Date verified");
			// WorkPage.OpenCalendar();
			verified = true;
		} else {
			System.out.println("Date not verified");
			// WorkPage.OpenCalendar();
		}
		return verified;

	}

	public static void verifyDropDwnValue(String value) throws Exception {
		// cfunction.sync(2);
		cfunction.verifyElementText(DRPDWN_TEXT_XPATH, value);
	}

	public static boolean verifyAllInputsAreRequired() throws Exception {
		Boolean check = false;
		for (int i = 1; i < 2; i++) {
			/*
			 * //cfunction.sync(5); WebElement element =
			 * driver.findElementByXPath(EXTENDEDPROPERTIES_INPUTS_XPATH+"["+i+"]");
			 * element.click();
			 */
			// element=cfunction.getWebElement("xpath",
			// EXTENDEDPROPERTIES_INPUTS_XPATH+"[i]").click();
			// String input=element.getAttribute("placeholder");
			String input = cfunction.getElementAttribute(EXTENDEDPROPERTIES_INPUTS_XPATH + "[" + i + "]",
					"placeholder");
			if (input.equalsIgnoreCase("*required")) {
				check = true;
				System.out.println("Input is ... " + input);
			} else {
				check = false;
			}
		}
		return check;
	}

	public static void verifySaveBtnDisable() throws Exception {
		// String menuItem = item.getAttribute("value");
		/*
		 * String textType = driver.findElement(By.
		 * xpath("//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl t-saveExtPropsBtn')]"
		 * )).getAttribute("type"); System.out.println(textType); String textType1 =
		 * driver.findElement(By.
		 * xpath("//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl t-saveExtPropsBtn')]"
		 * )).getAttribute("calcite-hydrated"); System.out.println(textType1); String
		 * textType2 = driver.findElement(By.
		 * xpath("//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl t-saveExtPropsBtn')]"
		 * )).getAttribute("type"); System.out.println(textType2); String textType3 =
		 * driver.findElement(By.
		 * xpath("//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl t-saveExtPropsBtn')]"
		 * )).getAttribute("type"); System.out.println(textType3);
		 */
		cfunction.elementIsDisplayed(SAVE_BTN_DISABLE_XPATH);
	}

	public static void verifySaveBtnEnable() throws Exception {
		cfunction.elementIsDisplayed(SAVE_BTN_ENABLE_XPATH);
	}

	public static void clickSaveBtn() throws Exception {
		cfunction.Commmon_Click("xpath", SAVE_BTN_ENABLE_XPATH);
	}

	public static void clickRequiredWindow() throws Exception {
		cfunction.Commmon_Click("xpath", "//div[@class='c-propertyContainer js-propertyContainer']");
	}

	public static void clickCancelBtn() throws Exception {
		// cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", CANCEL_BTN_REQUIRED_XPATH);
	}

	public static void enterIntInput(String input) throws Exception {
		cfunction.CommonTextBox_Input(EXTENDEDPROPERTIES_INPUTS_XPATH + "[1]", input);
	}

	public static void clearIntInput() throws Exception {
		// cfunction.Commmon_Click("XPATH", EXTENDEDPROPERTIES_INPUTS_XPATH+"[1]");
		cfunction.PressBackSpaceAndPressEnterKey(EXTENDEDPROPERTIES_INPUTS_XPATH + "[1]", 2);

		// cfunction.CommonTextBox_Input(EXTENDEDPROPERTIES_INPUTS_XPATH+"[1]", input);
	}

	public static void enterDoubleInput(String input) throws Exception {
		cfunction.CommonTextBox_Input(EXTENDEDPROPERTIES_INPUTS_XPATH + "[2]", input);
	}

	public static void enterSTRInput(String input) throws Exception {
		cfunction.CommonTextBox_Input("(//span[contains(@class,'input-validation')]/textarea)", input);
	}

	public static boolean verifyIntInput(String input) throws Exception {
		Boolean verified = false;
		try {
			String xpath = EXTENDEDPROPERTIES_INPUTS_XPATH + "[1]";
			boolean check;
			if (check = cfunction.verifyElementText(xpath, input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean verifyTabCount() {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath(HEADER_TABS_LIST_XPATH));
			if (rows.size() == 4) {
				verified = true;
				System.out.println("Total Jobs -->> " + rows.size());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static boolean verifyDoubleInput(String input) throws Exception {
		Boolean verified = false;
		try {
			String xpath = EXTENDEDPROPERTIES_INPUTS_XPATH + "[2]";
			boolean check;
			if (check = cfunction.verifyElementText(xpath, input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean verifySTRInput(String input) throws Exception {
		Boolean verified = false;
		try {
			String xpath = "(//span[contains(@class,'input-validation')]/textarea)";
			boolean check;
			if (check = cfunction.verifyElementText(xpath, input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static void selectValueFromDropdownBOOL(String value) throws Exception {
		cfunction.Commmon_Click("xpath", OPEN_DRPDWN_BOOL_XPATH1);
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

	public static boolean verifyBOOLInput(String input) throws Exception {
		Boolean verified = false;
		try {
			String xpath = "//span[contains(@class,'p-dropdown-label')]";
			boolean check;
			String text = cfunction.getElementText(xpath);
			if (text.equalsIgnoreCase(input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static void enterCurrentDate() throws Exception {
		Date datef = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		String date = dateformat.format(datef);
		WebElement input = driver.findElement(By.xpath(CALENDER_INPUT_XPATH));
		input.click();
		Actions builder = new Actions(driver);
		builder.click(driver.findElement(By.xpath(CALENDER_INPUT_XPATH))).keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		// builder.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL
		// ).build().perform();
		// input.clear();
		// input.sendKeys(Keys.BACK_SPACE);
		input.sendKeys(date);
		// cfunction.CommonTextBox_Input1(CALENDER_INPUT_XPATH, date);
		// cfunction.pressTAB(1);
	}

	public static boolean verifySuccessMsg(String successMsg) {
		boolean verified = false;
		String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		/*
		 * String[] arrOfStr = msg.split(" ",2); for (String a: arrOfStr) {
		 * System.out.println(arrOfStr[0]); jobName=arrOfStr[0]; }
		 */
		System.out.println(msg);
		if (msg.contains(successMsg)) {
			verified = true;
		}
		return verified;
	}

	public static void clickOnNormalDefaultExtendproperties() throws Exception {
		cfunction.Commmon_Click("xpath",
				"(//div[@class='c-propertyContainer__content t-extendedProperty__value'])[15]");
		cfunction.Commmon_Click("XPATH", NORMAL_DEFAULT_EXTEND_PROPERTIES_XPATH);
	}

	public static boolean verifyNormalDefaultWindowOpenInEdit() throws Exception {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(REQUIRED_EDIT_WINDOW_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static void clickOnEditPanel() throws Exception {
		cfunction.Commmon_Click("xpath", REQUIRED_EDIT_WINDOW_XPATH);
	}

	public static boolean verifyRequiredWindowVisible() throws Exception {
		boolean verified = false;
		cfunction.Commmon_Click("xpath", REQUIRED_EXTEND_PROPERTIES_XPATH);
		if (cfunction.elementIsDisplayed(REQUIRED_EXTEND_PROPERTIES_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyNormalDefaultWindowVisible() throws Exception {
		boolean verified = false;
		cfunction.Commmon_Click("xpath", NORMAL_DEFAULT_EXTEND_PROPERTIES_XPATH);
		if (cfunction.elementIsDisplayed(NORMAL_DEFAULT_EXTEND_PROPERTIES_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyNotEditableWindowVisible() throws Exception {
		boolean verified = false;
		cfunction.Commmon_Click("xpath", NOTEDITABLE_EXTEND_PROPERTIES_XPATH);
		if (cfunction.elementIsDisplayed(NOTEDITABLE_EXTEND_PROPERTIES_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyNotEditableWindowPenIconVisible() throws Exception {
		boolean verified = false;
		cfunction.Commmon_Click("xpath", NOTEDITABLE_EXTEND_PROPERTIES_XPATH);
		if (cfunction.elementIsDisplayed(EXTEND_PROPERTIES_Disable_EDIT_BTNS_XPATH + "[4]")) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyRequiredWindowPenIconVisible() throws Exception {
		boolean verified = false;
		cfunction.Commmon_Click("xpath", REQUIRED_EXTEND_PROPERTIES_XPATH);
		if (cfunction.elementIsDisplayed(EXTEND_PROPERTIES_Disable_EDIT_BTNS_XPATH + "[2]")) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyNormalDefaultWindowPenIconVisible() throws Exception {
		boolean verified = false;
		cfunction.Commmon_Click("xpath", NORMAL_DEFAULT_EXTEND_PROPERTIES_XPATH);
		if (cfunction.elementIsDisplayed(EXTEND_PROPERTIES_Disable_EDIT_BTNS_XPATH + "[3]")) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static boolean verifyToolTip() throws Exception {
		boolean verified = false;
		String imgName = "TS31_CollapseBtnToolTip";
		if (SikuliHelp.verifyImageExists(imgName)) {
			verified = true;
		} else {
			verified = false;
		}

		return verified;
	}

	public static void clickOnCollapseLeftPanel() {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL_XPATH);
	}

	public static boolean verifyCreateJobPanelVisible() {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(CREATEJOBPANEL_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	public static void enterTemplateNameInSearch(String templateName) {
		cfunction.CommonTextBox_Input(SEARCHJOBCREATE_XPATH, templateName);
	}

	public static boolean verifyJobTemplatePresent(String jobTemplateName) throws Exception {
		boolean verified = false;
		List<WebElement> option = driver.findElements(By.xpath(JOBTEMPLATELISTS_XPATH));
		for (int i = 0; i < option.size(); i++) {
			String drpdwnValue = option.get(i).getText();
			// (WebElement row:option) {
			if (drpdwnValue.equalsIgnoreCase(jobTemplateName)) {
				verified = true;
				break;
			} else {
				verified = false;
			}

		}
		return verified;
	}

	public static boolean clickOnJobTemplate(String jobTemplateName) throws Exception {
		boolean verified = false;
		List<WebElement> option = driver.findElements(By.xpath(JOBTEMPLATELISTS_XPATH));
		for (int i = 0; i < option.size(); i++) {
			String drpdwnValue = option.get(i).getText();
			// (WebElement row:option) {
			if (drpdwnValue.equalsIgnoreCase(jobTemplateName)) {
				cfunction.Commmon_Click("XPATH", "(" + JOBTEMPLATELISTS_XPATH + ")[" + (i + 1) + "]");
				verified = true;
				break;
			} else {
				verified = false;
			}

		}
		return verified;
	}

	public static boolean verifyJobTemplateListVisible() throws Exception {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(JOBTEMPLATELISTS_XPATH)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

	}

	public static void clickOnMoreBtn() throws Exception {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", MORE_XPATH);
	}

	public static void clickOnCollapseRightPane() throws Exception {
		cfunction.CommmonJS_Click(COLLAPSE_SUMMARY_XPATH);
		// cfunction.Commmon_Click("xpath", COLLAPSE_SUMMARY_XPATH);
	}

	public static boolean verifyAssignedHeaderText(String itemName) {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ASSIGNED_TAB_HEADER_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(itemName)) {
				row.click();
				verified = true;
				break;
			}

		}
		return verified;
	}

	public static boolean verifyDownloadISSuccessful(String filename) {
		String msg = "a";
		try {
			boolean flagfile = false;

			File folder2 = new File(System.getProperty("user.home") + "/Downloads");
			File[] files2 = folder2.listFiles();

			if (files2 != null) {
				for (File f : files2) {
					if (!f.isDirectory()) {
						BasicFileAttributes attr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);

						if (CommonFunction.formatfileDateTime(attr.creationTime())) {
							if (f.getName().contains(filename)) {
								flagfile = true;
								break;
							}
						}
					}
				}
			}

			if (flagfile) {
				CommonFunction.logStatus("PASS", msg);

			} else {
				cfunction.sync(20);
				folder2 = new File(System.getProperty("user.home") + "/Downloads");
				files2 = folder2.listFiles();
				if (files2 != null) {
					for (File f : files2) {
						if (!f.isDirectory()) {
							BasicFileAttributes attr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);

							if (CommonFunction.formatfileDateTime(attr.creationTime())) {
								if (f.getName().contains(filename)) {
									flagfile = true;
									break;
								}
							}
						}
					}
				}

				if (flagfile) {
					CommonFunction.logStatus("PASS", msg);

				} else {
					// CommonFunction.logStatus("FAIL", msg);
				}

				cfunction.sync(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// CommonFunction.logStatus("FAIL", msg + e);
		}
		return loggedIn;
	}

	public static void enterIntegerIN_Value(String input) {
		cfunction.CommonTextBox_Input(STEP_CARD_CONTENT_XPATH + "/div[1]//input", input);
	}

	public static boolean verifyDownloadIsDeleted(String filename, String filename1) throws IOException {
		File folder2 = new File(System.getProperty("user.home") + "/Downloads");
		File[] files2 = folder2.listFiles();

		if (files2 != null) {
			for (File f : files2) {
				if (!f.isDirectory()) {
					BasicFileAttributes attr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);

					if (CommonFunction.formatfileDateTime(attr.creationTime())) {

						if (f.getName().contains(filename) || f.getName().contains(filename1)) {
							f.delete();
						}
					}
				}
			}
		}
		return loggedIn;

	}

	public static void hoverDeleteUploadedFile(String i) throws Exception {
		cfunction.hoverByAction(DELETE_UPLOADED_FILE_BTN_XPATH + "[" + i + "]");
	}

	public static void clickOnLinkBtn() {
		cfunction.Commmon_Click("xpath", LINK_BUTTON_XPATH);
	}

	public static void enterURL_Input(String query) {
		//cfunction.sync(2);
		//cfunction.CommonTextBox_Input(URL_INPUT_XPATH, query);
		cfunction.CommonTextBox_Input2("(//span[contains(@class,'tabGrid-column tabGrid-column-large-1 input-validation')]//input)[1]", query);
		
	}

	public static void enterURL_Input_After_Error(String query) {
		// cfunction.CommonTextBox_Input("//input[@class='p-inputtext p-component
		// ng-invalid p-filled ng-dirty ng-touched']", query);

		//cfunction.Commmon_Click("xpath", URL_INPUT_XPATH);
		cfunction.CommonTextBox_Input(URL_INPUT_XPATH, query);
	}

	public static boolean verifyErrorIconVisible() {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath("//span[@class='tabGrid-column tabGrid-column-large-1 input-validation isError']"));
			if (rows.size() > 0) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean verifyErrorIconVisible1() {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath(ERROR_ICON_XPATH1));
			if (rows.size() > 0) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static void enterName_Input1(String query) {
		cfunction.CommonTextBox_Input("//input[@class='p-inputtext p-component ng-untouched ng-pristine ng-invalid']",
				query);
	}

	public static void enterName_Input(String query) {
		cfunction.Commmon_Click("xpath","(//span[contains(@class,'tabGrid-column tabGrid-column-large-1 input-validation')]//input)[2]" );
		cfunction.sync(2);
		cfunction.CommonTextBox_Input2("(//span[contains(@class,'tabGrid-column tabGrid-column-large-1 input-validation')]//input)[2]",query);
	}

	public static void clickOnSaveBtn() {
		// cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		cfunction.Commmon_Click("xpath", SAVE_BTN_XPATH);
	}

	public static void selectStepFromDrpdwn(String step) {
		cfunction.Commmon_Click("xpath", STEP_DROPDOWN_BTN_XPATH);
		cfunction.sync(10);
		/*
		 * List<WebElement> items =
		 * driver.findElements(By.xpath(STEP_DROPDOWN_LIST_XPATH)); for(WebElement item:
		 * items) { String menuItem = item.getText();
		 * 
		 * System.out.println(menuItem + "  --  " + step);
		 * if(menuItem.equalsIgnoreCase(step)) { item.click();
		 * System.out.println(menuItem + " selected" ); }
		 */
		cfunction.selectValueFromMenueItem(STEP_DROPDOWN_LIST_XPATH, step);
	}

	public static void clickCopyUploadedFile() throws Exception {
		cfunction.Commmon_Click("XPATH", COPY_UPLOADED_FILE_BTN_XPATH);
	}

	public static void clickOnViewAttachmentbtn(int index) {
		// cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		// index=index-1;
		cfunction.sync(4);
		cfunction.Commmon_Click("xpath", JOBCARD_ACTION_BTN_XPATH + "[" + index + "]");
	}

	public static void openPopWindow_inSelection() {
		// cfunction.Commmon_Click("xpath", "//div[@class='p-accordion-tab
		// ng-tns-c107-16 p-accordion-tab-active']//calcite-icon");
		//cfunction.CommmonJS_Click("//calcite-icon[@class='maximizeDiagramBtn t-maximizeBtn']");
		cfunction.CommmonJS_Click("//calcite-icon[contains(@class,'maximizeDiagramBtn t-maximizeBtn')]");
		cfunction.sync(25);
	}

	public static void closePopWindow_inSelection() {
		//cfunction.Commmon_Click("xpath", "//p-accordiontab[2]//div//div//a//span");
		cfunction.Commmon_Click("xpath", "//div[contains(@class,'p-dialog-header-icons')]");
		
		cfunction.sync(5);
	}
	public static void minimize_location() {
		cfunction.Commmon_Click("xpath", "//p-accordiontab[2]//div//div//a//span");
		cfunction.sync(5);
	}

	public static void clickOnEditAttributes() throws Exception {
		cfunction.Commmon_Click("XPATH", EDITATTRIBUTES_XPATH);
	}

	public static void clickOnNote() throws Exception {
		cfunction.sync(10);
		cfunction.Commmon_Click("XPATH", NOTEDIT_XPATH);
		cfunction.sync(2);

	}

	public static void clickOnTextArea() throws Exception {
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", TEXTAREA_XPATH);
		cfunction.sync(2);

	}

	public static void textForNoteTextArea(String text) throws Exception {
		Actions action = new Actions(driver); 
		element = driver.findElement(By.xpath(TEXTAREA_XPATH));

		action.moveToElement(element).click();
		// cfunction.CommonTextBox_Input("//div[contains(@class,'c-jobDetailPanel__sectionContent')]/textarea",
		// text);
		cfunction.CommonTextBox_Input(TEXTAREA_XPATH, text);

	}

	public static void saveNotesPrompt() throws Exception {
		cfunction.Commmon_Click("XPATH", SAVENOTESPROMPT_XPATH);
	}

	public static void saveNotes() throws Exception {
		WebElement ele = driver.findElement(By.xpath("//calcite-button[@class='p-element btn-showTooltipWhenDisabled t-discardNotesBtn' and @type='button']"));

		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		//cfunction.hoverByAction("//calcite-button[@class='p-element btn-showTooltipWhenDisabled t-discardNotesBtn' and @type='button']");
		cfunction.sync(5);
		WebElement ele1 = driver.findElement(By.xpath(SAVENOTES_XPATH));

		//Creating object of an Actions class
		Actions action1 = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action1.moveToElement(ele1).perform();
		cfunction.Commmon_Click("XPATH", SAVENOTES_XPATH);
	}
	public static void pause() throws Exception {
		// CommonFunction.ScrollToElement(PAUSEBUTTON_XPATH);
		WebElement ele = driver.findElement(By.xpath(PAUSEBUTTON_XPATH));
		ele.click();
		// cfunction.sync(2);
		// cfunction.Commmon_Click("XPATH", PAUSEBUTTON_XPATH);
	}

	public static void JobPause(String jobName) throws Exception {
		List<WebElement> items = driver.findElements(By.xpath(JOBNAME_XPATH));
		cfunction.sync(2);
		for (int i = 0; i < items.size(); i++) {
			String job = items.get(i).getText();
			System.out.println(job);
			// String openJobDetailsXpath = JOBNAME_XPATH + "["+(i+1)+"]";
			if (job.equalsIgnoreCase(jobName)) {
				// cfunction.CommmonJS_Click(openJobDetailsXpath);
				// cfunction.Commmon_Click("xpath",openJobDetailsXpath);
				cfunction.Commmon_Click("XPATH", PAUSEBUTTON_XPATH);
				cfunction.sync(2);
				System.out.println(jobName + "------- Clicked on job pause");
				break;
			}
		}

	}

	public static void notesUpdatePrivilage() throws Exception {
		CommonFunction.ScrollToElement(NOTESUPDATE_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", NOTESUPDATE_XPATH);
	}

	public static void savePriviledge() throws Exception {
		CommonFunction.ScrollToElement(SAVEROLESPRIVILEDGE_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", SAVEROLESPRIVILEDGE_XPATH);
	}

	public static void viewNotesDetail() throws Exception {
		CommonFunction.ScrollToElement(VIEWNOTESDETAIL_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", VIEWNOTESDETAIL_XPATH);
	}

	public static boolean verifyErrorUpdateNotes() throws Exception {
		cfunction.Commmon_Click("XPATH", SAVENOTES_XPATH);
		boolean verified = false;
		List<WebElement> rows = driver
				.findElements(By.xpath("/html/body/wmx-root/wmx-work/div/div/div[2]/wmx-toast/calcite-notice/div"));
		if (rows.size() == 1) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyErrorMessage() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ERRORMESSAGE_XPATH));
		if (rows.size() > 0) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyJobNotesVisible() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='c-propertyContainer__content c-propertyContainer__content--wrapTextPreserveSpaces t-notesText']"));
		String textNote = rows.get((int) (rows.size() - 1)).getText();
		if (textNote.length() > 1) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyEditNotesVisible() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(NOTEDIT_XPATH));
		System.out.println("size: " + rows.size());
		if (rows.size() > 0) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyEditNotesVisible1() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(
				"//calcite-button[@class='t-editNotesBtn btn-showTooltipWhenDisabled btn-disabled ng-star-inserted']"));
		// System.out.println("size: "+ rows.size());
		if (rows.size() > 0) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyScrollbarVisible() throws Exception {
		boolean verified = false;
		cfunction.Commmon_Click("XPATH", TEXTAREA_XPATH);
		cfunction.sync(2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,document.scrollHeight)");
		// WebElement container = driver.findElement(By.xpath(TEXTAREA_XPATH));
		js.executeScript("window.scrollBy(0,-document.scrollHeight)");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageYOffset;");
		// System.out.println("scroll output: "+ value);
		if (value == 0) {
			verified = true;
		}
		System.out.println("verified: " + verified);
		return verified;
	}

	public static boolean clickOnStartStepOfJob1(String Jobname) throws Exception {
		boolean verified = false;
		int i = 0;
		try {
			cfunction.sync(5);
			List<WebElement> rows = driver.findElements(By.xpath(ALLJOBLIST_XPATH));
			List<WebElement> steps = driver.findElements(By.xpath(JOB_STEPLIST_XPATH));
			cfunction.sync(5);
			System.out.println(steps.size());

			if (verified == false) {

				for (i = 0; i < rows.size(); i++) {
					String job = rows.get(i).getText();
					System.out.println(job);
					if (job.equalsIgnoreCase(Jobname)) {
						verified = true;
						// cfunction.ScrollToElement("("+JOBCARD_XPATH+")["+(i+1)+"]");
						String jobname = "(" + JOBCARD_XPATH + ")[" + (i + 1) + "]";
						cfunction.Commmon_Click("XPATH", jobname);
						cfunction.sync(5);
						String Step = jobname + "/div/div[3]/div/calcite-button[1]";
						cfunction.CommmonJS_Click(Step);
						cfunction.sync(2);
						break;
					} else {
						cfunction.Commmon_Click("XPATH", "(" + JOBCARD_XPATH + ")[" + (i + 1) + "]");
						System.out.println("Not previously created job");
						verified = false;
					}
				}
			} else {
				WorkPage.scrollToJob(Jobname);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static void textForCommentTextArea(String text) throws Exception {
		try {
			cfunction.sync(2);
			cfunction.CommonTextBox_Input(COMMENTTEXTAREA_XPATH, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendcomment() throws Exception {
		cfunction.Commmon_Click("xpath", SENDCOMMENT_XPATH);
	}

	public static boolean verifyShowMore() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(VIEWMORE_XPATH));
		if (rows.size() == 1) {
			verified = true;

		}
		return verified;
	}

	public static void clickOnSignout() throws Exception {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", USERSECTION_XPATH);
		cfunction.Commmon_Click("xpath", SIGNOUT_XPATH);
		cfunction.sync(5);
		driver.navigate().to("https://mcstest62.esri.com/portal/apps/workflowmanager/");
		cfunction.sync(5);
	}

	public static boolean verifyLastCommentUser() throws Exception {
		boolean verified = false;
		String rows = driver
				.findElement(By.xpath("(//span[@class='commentTextContent__username t-commentUserFullName'])[4]"))
				.getText();
		System.out.print("data : " + rows);
		if (rows.equals("WMX User")) {
			verified = true;
		}
		System.out.print("verify : " + verified);
		return verified;
	}

	public static boolean verifyTextOnTextBox() throws Exception {
		boolean verified = false;
		String rows = driver.findElement(By.xpath("//span[@class='counter ng-star-inserted']")).getText();
		int count = Integer.parseInt(rows.split("/")[0]);
		// System.out.println("text count : "+ count);
		if (count > 0) {
			verified = true;
		}
		return verified;
	}

	public static boolean verifySaveDialogue() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath("//div[@role='dialog']"));
		// System.out.println("dialogue :"+ rows.size());
		if (rows.size() == 1) {
			verified = true;
		}
		return verified;
	}

	public static boolean verifyCommentsTab() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath("//calcite-icon[@icon='speechBubbles']"));
		if (rows.size() == 1) {
			verified = true;

		}
		// System.out.println("verified = " + verified);
		return verified;
	}

	public static boolean clickOnAnotherJob(String jobName) throws Exception {
		boolean itemClicked = false;
		// CommonFunction.waitforHomePagetoload();
		// cfunction.sync(10);
		// CommonFunction.ScrollBottom(); //div[@class='c-jobCard__mainContainer
		// ng-star-inserted']/div[2]
		// CommonFunction.ScrollToElement("(//div[@class='c-jobCard__mainContainer
		// ng-star-inserted']/div[2])[49]");
		// System.out.println("scrolled");
		// CommonFunction.waitforHomePagetoload();
		// cfunction.ScrollToElement(JOBNAME_XPATH+"[50]");
		// cfunction.sync(10);
		List<WebElement> items = driver.findElements(By.xpath(JOBNAME_XPATH));
		cfunction.sync(2);
		for (int i = 0; i < items.size(); i++) {
			String job = items.get(i).getText();
			System.out.println(job);
			// String openJobDetailsXpath = JOBNAME_XPATH + "["+(i+1)+"]";
			if (job.equalsIgnoreCase(jobName)) {
				// cfunction.CommmonJS_Click(openJobDetailsXpath);
				// cfunction.Commmon_Click("xpath",openJobDetailsXpath);
				cfunction.Commmon_Click("XPATH", "(//div[@class='c-jobCard__mainContainer'])[" + (i + 1) + "]");
				cfunction.sync(2);
				itemClicked = true;
				System.out.println(jobName + "------- Clicked on Open Job Details");
				break;
			}
		}
		return itemClicked;
	}

	public static void clickOnAnotherJob1() throws Exception {
		// boolean itemClicked = false;
		cfunction.Commmon_Click("XPATH", "//div[@class='c-jobCard__mainContainer ng-star-inserted']");
	}

	public static boolean verifyIntInput1(String input, String index) throws Exception {
		Boolean verified = false;
		try {
			CommonFunction.ScrollBottom();
			String xpath = "((//div[contains(@class,'c-propertyContainer__groupContent ng-star-inserted')])/span/div)["
					+ index + "]/div[2]";
			boolean check;
			if (check = cfunction.verifyElementText(xpath, input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean verifyDate(String input, String index) throws Exception {
		Boolean verified = false;
		try {
			String xpath = "((//div[contains(@class,'c-propertyContainer__groupContent ng-star-inserted')])/span/div)["
					+ index + "]/div[2]";
			boolean check;
			if (check = cfunction.verifyElementText(xpath, input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean verifyDoubleInput1(String input, String index) throws Exception {
		Boolean verified = false;
		try {
			String xpath = "((//div[contains(@class,'c-propertyContainer__groupContent ng-star-inserted')])/span/div)["
					+ index + "]/div[2]";
			boolean check;
			if (check = cfunction.verifyElementText(xpath, input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean verifySTRInput1(String input, String index) throws Exception {
		Boolean verified = false;
		try {
			String xpath = "((//div[contains(@class,'c-propertyContainer__groupContent ng-star-inserted')])/span/div)["
					+ index + "]/div[2]";
			boolean check;
			if (check = cfunction.verifyElementText(xpath, input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean verifyBOOLInput1(String input, String index) throws Exception {
		Boolean verified = false;
		try {
			String xpath = "((//div[contains(@class,'c-propertyContainer__groupContent ng-star-inserted')])/span/div)["
					+ index + "]/div[2]";
			boolean check;
			String text = cfunction.getElementText(xpath);
			if (text.equalsIgnoreCase(input)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static void ClickDetailPanelRefresh() throws Exception {
		cfunction.Commmon_Click("XPATH", DETAILPANNELREFRESH_XPATH);
	}

	public static void assignJobToUser() throws Exception {
		cfunction.Commmon_Click("XPATH", PROPERTIES_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", EDITPROPERTIES_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH",
				"//input[contains(@class,'ng-pristine ng-valid ng-star-inserted ng-touched')]");
		cfunction.sync(2);
		cfunction.CommonTextBox_Input("//input[contains(@class,'ng-pristine ng-valid ng-star-inserted ng-touched')]",
				"WMX User");
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH",
				"//calcite-button[contains(@class,'c-jobDetailPanel__editPanelBtnControl btn-showTooltipWhenDisabled t-saveDetailsBtn')]");

	}

	public static void clickOnCommentTextArea() throws Exception {
		try {
			// cfunction.sync(2);
			cfunction.Commmon_Click("XPATH", COMMENTTEXTAREA_XPATH);
			// cfunction.sync(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void DiscardChanges() throws Exception {
		cfunction.Commmon_Click("XPATH", DISCARDCHANGES_XPATH);
	}

	public static boolean verifyNoComments() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='c-propertyContainer__NATextOverlay c-jobDetailPanel__NAText t-noCommentsFound']"));
		if (rows.size() > 0) {
			verified = true;

		}
		return verified;

	}

	public static boolean verifyComments(String text, String i) throws Exception {
		boolean verified = false;
		String comment = cfunction
				.getElementText("(//div[@class='commentTextContent__body t-commentBody'])[" + i + "]");
		if (comment.equalsIgnoreCase(text)) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyUserName(String text) throws Exception {
		boolean verified = false;
		String user = cfunction
				.getElementText("(//span[@class='commentTextContent__username t-commentUserFullName'])[1]");
		System.out.println(user);
		if (user.equalsIgnoreCase(text)) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyAvatar(String text) throws Exception {
		boolean verified = false;
		String avatar = cfunction
				.getElementText("(//div[@class='c-avatarCircle t-userInitialsCircle ng-star-inserted'])[2]");
		if (avatar.equalsIgnoreCase(text)) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyDateTime(String date1, String time1, String i) throws Exception {
		boolean verified = false;
		String actualDate = cfunction.getElementText("//span[@class='dateHeader t-dateHeader']");
		System.out.println(actualDate);
		System.out.println("formated Date: " + date1);
		String actualTime = cfunction
				.getElementText("(//span[@class='commentTextContent__timeStamp t-commentTimestamp'])[" + i + "]");
		System.out.println(actualTime);
		System.out.println("formated time:" + time1);
		if (actualDate.equals(date1)) {
			if (actualTime.equals(time1)) {
				verified = true;
			}
		}
		System.out.println("date_verified = " + verified);
		return verified;
	}

	public static boolean verifyCharacters() throws Exception {
		boolean verified = false;
		String counter = cfunction.getElementText("//span[@class='counter ng-star-inserted']");
		int count = Integer.parseInt(counter.split("/")[0]);
		if (count > 0) {
			verified = true;
		}
		return verified;
	}

	public static void RunStartStep() throws Exception {
		cfunction.Commmon_Click("XPATH","//calcite-button[@class='p-element c-jobCard__startBtn btn-showTooltipWhenDisabled t-startBtn ng-star-inserted']");
	}

	public static void addComments(String txtValue) throws Exception {
		cfunction.Commmon_Click("XPATH", "//span[@class='input-validation ng-star-inserted']//textarea");
		cfunction.sync(2);
		cfunction.CommonTextBox_Input("//span[@class='input-validation ng-star-inserted']//textarea", txtValue);
	}

	public static void DeleteUploadedFile(String i) throws Exception {
		cfunction.Commmon_Click("XPATH", DELETE_UPLOADED_FILE_BTN_XPATH + "[" + i + "]");
	}

	public static void clickOnSaveBtn1() {
		// cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		cfunction.Commmon_Click("XPATH", "//button[@class='p-button t-addLinkSaveBtn']");
	}

	public static void addAttachment(String i) {
		// cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		cfunction.Commmon_Click("XPATH", ADD_ATTACHMENT_XPATH + "[" + i + "]");
	}

	public static boolean verifyAttachmentAdded(String i) throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ATTACHMENT_XPATH + "[" + i + "]"));
		if (rows.size() > 0) {
			verified = true;

		}
		return verified;
	}

	public static void deleteAttachment(String i) {
		// cfunction.Commmon_Click("xpath", COLLAPSELEFTPANEL1_XPATH);
		cfunction.Commmon_Click("xpath", DELETE_ATTACHMENT_XPATH + "[" + i + "]");
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", "//span[@class='p-button-text'])[2]");
	}

	public static boolean verifyTotalAttachment() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ATTACHMENT_XPATH));
		if (rows.size() == 2) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyRenamedFile( int idx) throws Exception {
		boolean verified = false;
		String name = cfunction.getElementText(ATTACHMENT_XPATH + "["+idx+"]//div//button//span");
		System.out.println(name);
		if (name.equals( "renamed")) {
			System.out.println(name + " == renamed");
			verified = true;
		}
		return verified;
	}

	public static void drawFeature() {
		cfunction.Commmon_Click("XPATH", DRAW_FEATURE_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", SELECT_DRAW_FEATURE_XPATH);
	}

	public static void selectLocation(int p1, int p2) {
		WebElement element = driver.findElement(By.xpath("//wmx-define-location-map"));

		new Actions(driver).moveToElement(element, p1, p2).clickAndHold()
				.moveToElement(element, element.getSize().width - 1, 1).release().perform();
	}

	public static void deletePanelAttachment(String value) {
		cfunction.hoverByAction(
				"(//calcite-button[@class='p-element is-hidden-until-hover t-deleteAttachmentBtn ng-star-inserted'])[" + value
						+ "]");
		cfunction.Commmon_Click("XPATH",
				"(//calcite-button[@class='p-element is-hidden-until-hover t-deleteAttachmentBtn ng-star-inserted'])[" + value
						+ "]");
		cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", SAVENOTESPROMPT_XPATH);
	}

	public static void clickOnBrowse() {
		try {
			// Actions action = new Actions(driver);
			// element = driver.findElement(By.linkText("Get started free"));

			cfunction.hoverByAction("(//a[@role='menuitem'])[1]");
			cfunction.sync(2);
			// cfunction.Commmon_Click("XPATH", "(//a[@role='menuitem'])[1]");
			element = driver.findElement(By.xpath("(//a[@role='menuitem'])[1]"));
			element.click();
			// JavascriptExecutor executor = (JavascriptExecutor) driver;

			// executor.executeScript("arguments[0].click();", element);
			// cfunction.Commmon_Click("XPATH", "(//div[@class='ng-trigger
			// ng-trigger-overlayAnimation ng-tns-c116-50 p-menu p-component p-menu-overlay
			// ng-star-inserted']//ul//li)[2]");
			// element.submit();
			// action.moveToElement(element).click();
			System.out.println("browse  option clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void browseLocalFiles(String filename2) {

		// cfunction.Commmon_Click("XPATH", "(//span[@class='p-menuitem-text
		// ng-star-inserted'])[1]");
		// wait
		//cfunction.skipWindowDialogBoxAfterClick();
		String file = System.getProperty("user.dir") + "\\testData\\WMX_TestData\\" + filename2;
		System.out.println(2);
		cfunction.CommonTextBox_Input8("(//a[@role='menuitem'])[1]", file);
		
		//cfunction.uploadFile(file);
	}

	public static void browseLocalFiles1(String filename2) {

		// cfunction.Commmon_Click("XPATH", "(//span[@class='p-menuitem-text
		// ng-star-inserted'])[1]");
		// wait
		cfunction.skipWindowDialogBoxAfterClick();
		String file = System.getProperty("user.dir") + "\\testData\\WMX_TestData\\" + filename2;
		System.out.println(file);
		//cfunction.CommonTextBox_Input8("(//a[@role='menuitem'])[1]", file);
		
		cfunction.uploadFile(file);
	}

	public static void renameFile(String txtValue, String j) {
		//edited sarath
		//cfunction.hoverByAction("(//calcite-button[@class='is-hidden-until-hover ng-star-inserted'])[" + j + "]");
		cfunction.hoverByAction("(//calcite-button[contains(@class,'is-hidden-until-hover ng-star-inserted')])[" + j + "]");

		
		//cfunction.Commmon_Click("XPATH",
				//"(//calcite-button[@class='is-hidden-until-hover ng-star-inserted'])[" + j + "]");
		//edited sarath
		cfunction.Commmon_Click("XPATH",
				"(//calcite-button[contains(@class,'is-hidden-until-hover ng-star-inserted')])[" + j + "]");
		
		cfunction.sync(2);
		// cfunction.Commmon_Click("XPATH", "//input[@class='ng-pristine ng-valid
		// ng-touched']");
		// cfunction.sync(2);
		cfunction.CommonTextBox_Input("//div[@class='input-validation']//input", txtValue);
		cfunction.sync(2);
		// cfunction.Commmon_Click("XPATH",
		// "(//div[@class='c-propertyContainer__propertyRow
		// c-propertyContainer__propertyRow--paddingLeft is-hover t-aliasInput
		// ng-untouched ng-pristine ng-valid ng-star-inserted']//calcite-button)[1]");
		// cfunction.hoverByAction("(//div[@class='c-propertyContainer__propertyRow
		// c-propertyContainer__propertyRow--paddingLeft is-hover t-aliasInput
		// ng-pristine ng-valid ng-star-inserted ng-touched']//calcite-button)[1]");
		cfunction.Commmon_Click("XPATH", "//calcite-button[@icon-start='check']");
		// driver.findElementByXPath("(//div[@class='c-propertyContainer__propertyRow
		// c-propertyContainer__propertyRow--paddingLeft is-hover t-aliasInput
		// ng-pristine ng-valid ng-star-inserted
		// ng-touched']//calcite-button)[1]").sendKeys(Keys.RETURN);
		// WebElement ele=
		// driver.findElementByXPath("document.querySelector('wmx-job-panel-attachments>div>p-accordion>div>p-accordiantab>div>div>div>div>div>calcite-button').shadowRoot.querySelector('button')");

		// ele.click();
	}

	public static boolean verifyAttachmentSavedMsg() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ATTACHMENT_SAVED_MSG_XPATH));
		if (rows.size() == 1) {
			verified = true;

		}
		System.out.println("verified = " + verified);
		return verified;
	}
	
	// TC 3484
	
	public static boolean verifyJobCreatedByUser(String expectedUserName) {
		boolean verified = false;
		
		WebElement findElementByXPath = driver.findElementByXPath(HISTORY_USER_XPATH);
		findElementByXPath.isDisplayed();
		String actualUserText = findElementByXPath.getText();
		System.out.println(actualUserText);
		
		try {
			if(expectedUserName.equalsIgnoreCase(actualUserText))
				verified=true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	return verified;
	}
	
	public static boolean verifyStartEndStepCompleted() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_START_END_COMPLETED_TEXT);
				
				if(isElementPresent.size() > 0) {
					(new WebDriverWait(driver,60))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HISTORY_START_END_COMPLETED_TEXT)));
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_START_END_COMPLETED_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println("Activity -" + actualText);
					

					WebElement userTextXPath = driver.findElementByXPath(HISTORY_START_END_COMPLETED_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_START_END_COMPLETED_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					
					if(!actualText.equals("Start/End Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		while(counter<5);
		return verified;
	}
	public static boolean verifyAddComment() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_ADD_COMMENT_XPATH);
				
				if(isElementPresent.size() > 0) {
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_ADD_COMMENT_XPATH);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_ADD_COMMENT_USER_XPATH);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_ADD_COMMENT_TIME_XPATH);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					if(!actualText.equals("Add Comment Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			
			}
		while(counter<5);
		
		return verified;
		}
	
	public static boolean verifyManualStepCompleted() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_MANUAL_STEP_COMPLETED_TEXT);
				
				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_MANUAL_STEP_COMPLETED_TEXT);
					
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_MANUAL_STEP_COMPLETED_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_MANUAL_STEP_COMPLETED_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_MANUAL_STEP_COMPLETED_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					if(!actualText.equals("Manual Step Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		while(counter<5);
		
		return verified;
		}

	
	public static void clickOnYesInQuestionStep() {
		(new WebDriverWait(driver,60))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HISTORY_YES_BTN_QUESTION_STEP)));
        cfunction.Commmon_Click("xpath", HISTORY_YES_BTN_QUESTION_STEP);
    }

	public static boolean verifyQuestionCompleted() {
		boolean verified = false;
		int counter=0;
		
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_QUESTION_COMPLETED_TEXT);
			
				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_QUESTION_COMPLETED_TEXT);
				
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_QUESTION_COMPLETED_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_QUESTION_COMPLETED_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_QUESTION_COMPLETED_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					if(!actualText.equals("Question Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					counter++;
					cfunction.sync(2);
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		while(counter<5);
		
		return verified;
		}

	public static boolean verifyAddAttachmentCompleted() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_ADD_ATTACHMENT_COMPLETED_TEXT);

				if(isElementPresent.size() > 0) {
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_ADD_ATTACHMENT_COMPLETED_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_ADD_ATTACHMENT_COMPLETED_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_ADD_ATTACHMENT_COMPLETED_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					if(!actualText.equals("Add Attachment Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					counter++;
					cfunction.sync(2);
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		while(counter<5);
		
		return verified;
		}

	public static boolean verifyRunGPServicesCompleted() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_RUN_GP_SERVICES_COMPLETED_TEXT);

				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_RUN_GP_SERVICES_COMPLETED_TEXT);
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_RUN_GP_SERVICES_COMPLETED_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_RUN_GP_SERVICES_COMPLETED_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_RUN_GP_SERVICES_COMPLETED_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					if(!actualText.equals("Run GP Service Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			if(!verified) {
				Assert.assertTrue(verified, "Run GP Service activity not completed successfully.");
			}
			}
		while(counter<5);
		
		return verified;
		}

	public static boolean verifyMJobPropertiesCompleted() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_M_JOB_PROPERTIES_COMPLETED_TEXT);
				
				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_M_JOB_PROPERTIES_COMPLETED_TEXT);
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_M_JOB_PROPERTIES_COMPLETED_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_M_JOB_PROPERTIES_COMPLETED_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_M_JOB_PROPERTIES_COMPLETED_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					if(!actualText.equals("Update 1-M Job Properties Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			if(!verified) {
				Assert.assertTrue(verified, "Update 1-M Job Properties activity not completed successfully.");
			}
			}
		while(counter<5);
		return verified;
		}
	
	public static boolean verifyJobUpdated() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_JOB_UPDATED_TEXT);
				
				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_JOB_UPDATED_TEXT);
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_JOB_UPDATED_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_JOB_UPDATED_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					if(!actualText.equals("Job Update")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
			catch (Exception ex) {
					ex.printStackTrace();
				}
			
			}
		while(counter<5);
		if(!verified) {
			Assert.assertTrue(verified, "Job Updated activity not completed successfully.");
		}
		
		return verified;
		}

	public static boolean verifyUpdateJobProperties() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_UPDATE_JOB_PROPERTIES_TEXT);
				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_UPDATE_JOB_PROPERTIES_TEXT);
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_UPDATE_JOB_PROPERTIES_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_UPDATE_JOB_PROPERTIES_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_UPDATE_JOB_PROPERTIES_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					if(!actualText.equals("Update Job Properties Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		while(counter<5);
		
		if(!verified) {
			Assert.assertTrue(verified, "Update Job Properties activity not completed successfully.");
		}

		
		return verified;
		}

	
	public static boolean verifyOpenWebPageCompleted() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_OPEN_WEB_PAGE_TEXT);
				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_OPEN_WEB_PAGE_TEXT);
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_OPEN_WEB_PAGE_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_OPEN_WEB_PAGE_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_OPEN_WEB_PAGE_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					if(!actualText.equals("Open Web Page Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		while(counter<5);

		if(!verified) {
			Assert.assertTrue(verified, "Update Job Properties activity not completed successfully.");
		}
		
		return verified;
		}
	
	public static boolean verifySendWebRequestCompleted() {
		boolean verified = false;
		int counter=0;
		do {
			try {

				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_SEND_WEB_REQUEST_TEXT);
				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_SEND_WEB_REQUEST_TEXT);
					(new WebDriverWait(driver,60))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HISTORY_SEND_WEB_REQUEST_TEXT)));
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_SEND_WEB_REQUEST_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_SEND_WEB_REQUEST_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					WebElement completionTimeTextXPath = driver.findElementByXPath(HISTORY_SEND_WEB_REQUEST_TIME_TEXT);
					String actualCompletionTimeTextXPath = completionTimeTextXPath.getText();
					System.out.println("Completion Time  -" + actualCompletionTimeTextXPath);
					
					
					if(!actualText.equals("Send Web Request Completed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		while(counter<5);
		
		return verified;
		}
	

	public static boolean verifyJobClosed() {
		boolean verified = false;
		int counter=0;
		do {
			try {
				List<WebElement> isElementPresent = driver.findElementsByXPath(HISTORY_JOB_CLOSED_TEXT);
				if(isElementPresent.size() > 0) {
					// Scroll till Element
					CommonFunction.ScrollToElement(HISTORY_JOB_CLOSED_TEXT);
					(new WebDriverWait(driver,60))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HISTORY_JOB_CLOSED_TEXT)));
					WebElement findElementByXPath = driver.findElementByXPath(HISTORY_JOB_CLOSED_TEXT);
					String actualText = findElementByXPath.getText();
					System.out.println(actualText);
					
					WebElement userTextXPath = driver.findElementByXPath(HISTORY_JOB_CLOSED_USER_TEXT);
					String actualUserTextXPath = userTextXPath.getText();
					System.out.println("Activity by User -" + actualUserTextXPath);
					
					if(!actualText.equals("Job Closed")) {
						ClickDetailPanelRefresh();
						cfunction.sync(2);
						verified= false;
						counter++;
						continue;
					}
					else {
						verified= true;
						break;
					}
				}
				else {
					ClickDetailPanelRefresh();
					cfunction.sync(2);
					counter++;
					verified= false;
					continue;
				}

			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		while(counter<5);
		
		return verified;
		}

	public static void enterRequiredNum(String number) {
		WebElement findElementByXPath = driver.findElementByXPath(JOB_NUMBER_INPUT_BOX_XPATH);
		findElementByXPath.isEnabled();
		findElementByXPath.sendKeys(number);
	}
	
	public static void uncheckCheckBox() {
		boolean chkBoxStatus = false;
		WebElement findElementByXPath = driver.findElementByXPath(JOB_CHECK_BOX_XPATH);
		chkBoxStatus = findElementByXPath.isEnabled();
		if(!chkBoxStatus)
			findElementByXPath.click();
	}

	public static boolean verifyJobIsCreated(String expectedText) {
		boolean verified = false;
		
		WebElement findElementByXPath = driver.findElementByXPath(HISTORY_JOB_CREATED_XPATH);
		findElementByXPath.isDisplayed();
		String actualText = findElementByXPath.getText();
		System.out.println(actualText);
		
		try {
			if(expectedText.equalsIgnoreCase(actualText))
				verified=true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	return verified;
	}
	

	
	

}