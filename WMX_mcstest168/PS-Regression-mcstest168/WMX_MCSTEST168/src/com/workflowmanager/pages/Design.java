package com.workflowmanager.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;

import com.workflowmanager.library.CommonFunction;
import com.workflowmanager.library.SikuliHelp;
import com.workflowmanager.library.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class Design extends TestBase {
	static int count = 1;
	private static final String CREATENEW_XPATH = "//div[@class='titleSection']/calcite-button";
	private static final String EMAIL_CREATENEW_XPATH = "//div[@class='c-emailTemplate__listHeader']/calcite-button";
	// private static final String EMAIL_CREATENEW_XPATH =
	// "//div[@class='c-emailTemplate__listHeader']/button";
	private static final String CREATE_XPATH = "//div[contains(@class,'t-createJobTab')]";
	private static final String CREATE_BUTTON_DISABLE_XPATH = "//li[@class='p-disabled ng-star-inserted']";
	// private static final String JOBTEMPLATENAME_XPATH =
	// "//div[@class='ui-tabview-panel ui-widget-content
	// ng-star-inserted']//input[@class='ng-untouched ng-pristine ng-valid
	// ui-inputtext ui-corner-all ui-state-default ui-widget']";
	//private static final String JOBTEMPLATENAME_XPATH = "//div[@class='input-validation--template']/input";
	private static final String JOBTEMPLATENAME_XPATH = "(//div[@class='input-validation--template']/input)[1]";

	
	private static final String EMAIL_TEMPLATENAME_XPATH = "//input[contains(@class,'static t-templateNameInput')]";
	private static final String EMAIL_TO_TEMPLATENAME_XPATH = "(//input[contains(@class,'static t-arcadeInput')])[1]";
	private static final String EMAIL_CC_TEMPLATENAME_XPATH = "(//input[contains(@class,'static t-arcadeInput')])[2]";
	private static final String EMAIL_BCC_TEMPLATENAME_XPATH = "(//input[contains(@class,'static t-arcadeInput')])[3]";
	private static final String EMAIL_SUBJECT_TEMPLATENAME_XPATH = "(//input[contains(@class,'static t-arcadeInput')])[4]";
	private static final String EMAIL_BODY_TEMPLATENAME_XPATH = "//textarea[contains(@class,'t-arcadeInput')]";
	private static final String DEFAULTPROPERTIES_XPATH = "//button[contains(@class,'ui-button-secondary')]";
	private static final String SAVE_XPATH = "//div[@class='actionBarItem']/calcite-button";
	// private static final String EMAIL_SAVE_XPATH = "(//span[@class='text-white
	// btnText-withToolTip'])[1]";
	private static final String EMAIL_SAVE_XPATH = "//calcite-button[contains(@class,'t-saveBtn btn-showTooltipWhenDisabled')]";
	// private static final String ASSIGNTODROPDOWN_XPATH =
	// "//div[@class='advance-autocomplete-container']/button";
	// private static final String ASSIGNTODROPDOWNMENUITEM_XPATH =
	// "//div[@class='categoryItem ng-star-inserted']";
	private static final String OK_XPATH = "//div[@class='saveMessageDialog ng-star-inserted']/button[@class='btn']";
	private static final String SUCCESSMSG_XPATH = "//wmx-toast//div";
	private static final String SUCCESSMSG_XPATH1 = "//wmx-toast//div";
	private static final String DOMAIN_SAVE_XPATH = "(//span[@class='p-button-text'])[2]";
	private static final String XBUTTON_XPATH = "//div[@class='c-toast c-alert alert t-toast alert-green ng-star-inserted']/button";
	// private static final String CURRENTWORKFLOWDRPDWN_XPATH =
	// "//button[@class='ui-autocomplete-dropdown ng-tns-c3-21 ui-button ui-widget
	// ui-state-default ui-corner-all ui-button-icon-only ng-star-inserted']";
	private static final String CURRENTWORKFLOWDIAGRAMINPUT_XPATH = "//p-autocomplete[@field='diagramName']//input";
	private static final String CURRENTWORKFLOWDIAGRAMMENUITEM_XPATH = "(//p-autocomplete//li//span)";
	// private static final String DIAGRAM_XPATH =
	// "//ul[@class='subNavigationMenu']//li[contains(@routerlink,'diagram')]";
	private static final String NEWTABLE_2_NAME_XPATH = "(//input[contains(@class,'t-tableNameInput')])[2]";
	private static final String DIAGRAM_XPATH = "//ul[@class='subNavigationMenu']//li[contains(@data-name,'diagram')]";
	private static final String SETTINGS_XPATH = "//ul[@class='subNavigationMenu']//li[contains(@data-name,'settings')]";
	// private static final String JOBTEMPLATE_XPATH =
	// "//ul[@class='subNavigationMenu']//li[contains(@routerlink,'jobTemplate')]";
	private static final String JOBTEMPLATE_XPATH = "//ul[@class='subNavigationMenu']//li[@data-name='jobTemplateLinkBtn']";
	private static final String TEMPLATE_XPATH = "//ul[@class='subNavigationMenu']//li[4]";
	private static final String SEARCHDIAGRAMINPUT_XPATH = "//div[@class='c-searchBar c-searchBar--withRightIcon']/input";
	private static final String EDIT_XPATH = "//calcite-button[@id='EditButton']";
	private static final String SEARCHSTEPTEMPLATE_XPATH = "//input[@class='c-searchBar__searchInput c-searchBar__searchInput--withRightPadding t-searchInput']";
	// private static final String STEPLIBRARYCANVAS_XPATH =
	// "//div[@id='libSearchResults']/canvas";
	private static final String WORKFLOWDIAGRAMCANVAS_XPATH = "//div[@id='workflowDiagram']/canvas";
	private static final String WORKFLOWDIAGRAMSAVE_XPATH = "(//calcite-button[@class='ng-star-inserted'])[2]";
	private static final String WORKFLOWDIAGRAMACTIVATE_XPATH = "(//calcite-button[@class='ng-star-inserted'])[1]";
	private static final String EXTENDEDPROPERTIES_XPATH = "(//ul[@class='p-tabview-nav']/li)[2]";
	private static final String LISTITEMNAME_XPATH = "//div[@class='templateCard ng-star-inserted']//div[@class='templateName cell-item']";
	// private static final String JOBTEMPLATELIST_XPATH =
	// "//td[@class='ng-star-inserted']";
	private static final String JOBTEMPLATELIST_XPATH = "//tbody[contains(@class,'p-datatable-tbody')]/div/div[1]";
	// private static final String TABPANELNAME_XPATH = "//div[@class='titleText']";
	private static final String TABPANELNAME_XPATH = "//div[@class='titleText textOverflow']";
	//private static final String SORTBUTTON_XPATH = "//calcite-button[@class='c-searchBar__rightIcon t-sortButton ng-star-inserted']";
	private static final String SORTBUTTON_XPATH = "//calcite-button[contains(@class,'c-searchBar__rightIcon t-sortButton ng-star-inserted')]";

	
	private static final String WORKFLOWSEARCHTXTINPUT_XPATH = "//div[@class='c-searchBar c-searchBar--withRightIcon']//input";
	private static final String WORKFLOWDIAGRAMLIST_XPATH = "//div[@class='templateName cell-item']";
	private static final String WORKFLOWDIAGRAMITEMNAME_XPATH = "(//div[@class='templateName cell-item'])";
	private static final String DATAEDITSSAMPLE_XPATH = "(//div[@class='templateName cell-item'])[1]";
	private static final String HEADER_XPATH = "//span[@class='bannerTitle jobTemplateName active ng-star-inserted']";
	private static final String FILTERBUTTON_XPATH = "//calcite-button[contains(@class,'c-searchBar__rightIcon c-searchBar__rightIcon--small')]";
	private static final String FILTERHIGLIGHTBUTTON_XPATH = "//calcite-button[contains(@class,'c-searchBar__rightIcon c-searchBar__rightIcon--small c-searchBar__rightIcon--highlight')]";
	private static final String JOBTEMPLATEHEADER_XPATH = "//span[@class='bannerTitle jobTemplateName']";
	private static final String PROFILEHIGLIGHTBUTTON_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[1]";
	private static final String ADD_XPATH = "//button[.//span[@class='icon-ui-add-attachment icon-btn']]";
	private static final String PLUSSIGN_XPATH = "(//calcite-button[@icon-start='plus'])[1]";
	private static final String ACTIVEJOBS_XPATH = "(//span[@class='bannerTitle jobTemplateName'])[1]";
	private static final String MINUSSIGN_XPATH = "(//calcite-button[@icon-start='minus'])[1]";
	private static final String ALIGNDIAGRAMHORIZONTALLY_XPATH = "(//calcite-button[@icon-start='centerHorizontal'])";
	private static final String ALIGNDIAGRAMVERTICALLY_XPATH = "(//calcite-button[@icon-start='centerVertical'])";
	private static final String DIAGRAMTITLE_XPATH = "//span[@class='bannerTitle jobTemplateName active ng-star-inserted']";
	private static final String BACK_XPATH = "//calcite-button[contains(@class,'backBtn ng-star-inserted')]";
	// private static final String NO_XPATH = "//button[@class='ui-button noFill
	// ng-star-inserted']/span";
	// private static final String NO_XPATH = "//button[@class='btn ui-button noFill
	// ng-star-inserted']/span";
	private static final String NO_XPATH = "//button[@class='btn p-button noFill ng-star-inserted']/span";
	private static final String STEPLIBRARYLEFTSIDEPANELTRIANGLE_XPATH = "//div[@class='p-element c-collapsiblePanel__handle c-collapsiblePanel__handle--right t-leftPanelHandle']/calcite-icon";
	//private static final String STEPLIBRARYLEFTSIDEPANEL_XPATH = "//div[@class='c-diagramPage__leftPanel c-collapsiblePanel c-collapsiblePanel--left ng-star-inserted']";
	private static final String STEPLIBRARYLEFTSIDEPANEL_XPATH = "//div[contains(@class,'c-diagramPage__leftPanel c-collapsiblePanel c-collapsiblePanel--left ng-star-inserted')]";
	
	private static final String STEPLIBRARYLEFTSIDEPANEL_XPATH_COLLAPSE="//div[contains(@class,'c-diagramPage__leftPanel c-collapsiblePanel c-collapsiblePanel--left ng-star-inserted c-collapsiblePanel')]" ;
	private static final String DIAGRAMSETTINGRIGHTSIDEPANELTRIANGLE_XPATH = "//div[@class='p-element c-collapsiblePanel__handle c-collapsiblePanel__handle--left t-rightPanelHandle']/calcite-icon";
	private static final String DIAGRAMSETTINGRIGHTSIDEPANEL_XPATH = "//div[@class='c-diagramPage__rightPanel c-collapsiblePanel c-collapsiblePanel--right ng-star-inserted']";
	private static final String WORKFLOWDIAGRAMSLIST_XPATH = "//wmx-design-diagram-list";
	private static final String WORKFLOWDIAGRAMSBANNER_XPATH = "//div[contains(@class,'bannerItem')]";
	private static final String DIAGRAMEDITPAGE_XPATH = "//div[@class='bannerSection isEditMode']";
	// private static final String CONFIRMDIALOG_XPATH =
	// "//div[contains(@class,'ui-dialog-draggable ng-star-inserted')]";
	private static final String CONFIRMDIALOGYES_XPATH = "(//span[@class='p-button-text'])[2]";
	// private static final String CONFIRMDIALOGYES_XPATH =
	// "(//span[@class='p-button-text'])[1]";
	// private static final String CONFIRMDIALOG_XPATH =
	// "//div[contains(@class,'p-dialog p-component')]";
	private static final String CONFIRMDIALOG_XPATH = "//button[@class='btn p-button']";
	// button[@class='btn p-button noFill ng-star-inserted']
	private static final String CONFIRMDIALOGCANCEL_XPATH = "(//span[@class='p-button-text'])[1]";
	// private static final String URLTEXT_XPATH =
	// "(//div[@id='ui-tabpanel-4']//input)[4]";
	// private static final String URLTEXT_XPATH = "//textarea[@class='static
	// ng-untouched ng-pristine ng-valid p-inputtextarea p-inputtext p-component
	// p-filled']";
	// private static final String URLTEXT_XPATH =" //textarea[@class='static
	// c-autoExpandTextArea ng-untouched ng-pristine ng-valid p-inputtextarea
	// p-inputtext p-component p-filled']";
	private static final String URLTEXT_XPATH = "//textarea[contains(@class,'t-arcadeInput t-stepHelp t-textAreaInput')]";

	private static final String STEPNAME_XPATH = "//div[@class='l-contentPadding']/div/input";
	private static final String STEPDESC_XPATH = "//textarea[contains(@class,'c-panel__contentValue o-textArea')]";
	// private static final String STEPDESC_XPATH ="(//div[@class='ng-tns-c69-23
	// p-dialog-content']//span)[1]";
	private static final String UNDO_XPATH = "(//calcite-button[@icon-start='undo'])";
	private static final String REDO_XPATH = "(//calcite-button[@icon-start='redo'])";
	private static final String ARGUMENTSECTION_XPATH = "//wmx-pro-mapping-step-arg[@class='ng-star-inserted']";
	private static final String ZOOM_XPATH = "//div[@class='bannerSection isEditMode']//div[@class='bannerSection-right ng-star-inserted']//div[@class='label']";
	private static final String HORIZONTALVERTICALAUTOALIGN_XPATH = "//div[@class='dropdown js-dropdown is-active']//nav[@class='dropdown-menu modifier-class']";
	private static final String HORIZONTALAUTOALIGN_XPATH = "//div[@class='dropdown js-dropdown is-active']//nav[@class='dropdown-menu modifier-class']//a[1]";
	private static final String VERTICALAUTOALIGN_XPATH = "//div[@class='dropdown js-dropdown is-active']//nav[@class='dropdown-menu modifier-class']//a[2]";
	private static final String PRINT_XPATH = "//span[@class='icon-ui-printer icon-btn']";
	private static final String LEFTLAYOUT_XPATH = "//div[contains(@class,'t-leftPanelHandle')]";

	private static final String RIGHTLAYOUT_XPATH = "//div[contains(@class,'t-rightPanelHandle')]";
	private static final String WORKFLOWDIAGRAM_XPATH = "//div[@id='workflowDiagram']";
	private static final String STEPDETAILHEADER_XPATH = "(//div[@class='c-panel__headerTitle'])[2]";
	private static final String EXECUTESCHECKBOX_XPATH = "(//div[contains(@class,'p-radiobutton p')])";
	private static final String OPTIONAL_CHECKBOX_XPATH = "(//div[contains(@class,'p-checkbox-box')])[3]";
	private static final String RIGHTPANELNAME_XPATH = "//wmx-design-diagram-edit-panel//div[@class='c-panel__headerTitle']";
	private static final String STYLE_XPATH = "(//ul[@class='p-tabview-nav']//li/a)[3]";
	private static final String ABOUT_XPATH = "(//ul[@class='p-tabview-nav']//li/a)[4]";
	private static final String OPTION_XPATH = "(//ul[contains(@class,'p-tabview-nav')]//li/a)[2]";
	private static final String PROPERTIES_XPATH = "(//ul[@class='p-tabview-nav']//li/a)[1]";
	private static final String SHAPECOLOR_XPATH = "(//div[@class='l-contentPadding']/div/span)";
	private static final String SHAPEDROPDOWN_XPATH = "(//div[contains(@class,'p-dropdown-trigger')])[2]";
	private static final String SHAPEDROPDOWNMENU_XPATH = "//div[contains(@class,'p-dropdown-panel p-component ng-star-inserted')]";
	private static final String SHAPEDROPDOWNMENULABEL_XPATH = "//span[@class='c-dropdown__menuItemLabel']";
	private static final String COLORTILE_XPATH = "//div[contains(@class,'color-tile ng-star-inserted')]";
	private static final String REDCOLOR_XPATH = "//div[contains(@class,'color-tile ng-star-inserted isSelected')]";
	private static final String COLORWHEEL_XPATH = "//div[@class='p-element color-tile custom-color-tile']";
	private static final String COLORPICKER_XPATH = "//div[@class='color-picker open']";
	private static final String COLORPICKERCURSOR_XPATH = "//div[@class='saturation-lightness ng-star-inserted']/div[@class='cursor']";
	private static final String PENCILICON_XPATH = "//span[@class='icon-ui-edit ng-star-inserted']";
	private static final String ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH_DISABLE = "((//div[@class='grid grid-nogutter'])//p-checkbox[contains(@class,'t-privilegeEnabled')])";
	private static final String NEWJOBTEMPLATE_XPATH = "//div[@class='templateAttributeSection']";
	private static final String STATUS_XPATH = "(//p-dropdown//span)[1]";
	private static final String DIAGRAMPREVIEW_XPATH = "//div[@id='job_template_diagram']//canvas";
	private static final String EXTENDED_XPATH = "//wmx-extended-properties-tab";
	private static final String NEWTABLE_XPATH = "(//calcite-button[contains(@class,'t-addTableBtn')])[2]";
	private static final String NEWTABLE_XPATH1 = "(//calcite-button[contains(@class,'t-addTableBtn')])[1]";
	private static final String NEWEXTENDEDTABLE_XPATH = "//div[@class='c-itemGroup c-itemGroup--extendedProperties t-table c-itemGroup--new ng-star-inserted']";
	private static final String NEWTABLENAME_XPATH = "//input[contains(@class,'t-tableNameInput')]";
	private static final String NEWTABLEALIAS_XPATH = "//input[contains(@class,'t-tableAliasInput')]";
	private static final String ADDEXTENDEDPROPERTYBTN_XPATH = "//calcite-button[contains(@class,'t-addPropertyBtn')]";
	private static final String NEWEXTENDEDPROPERTY_XPATH = "//div[contains(@class,'c-itemList__contentRow c-itemList__contentRow--withHandleLeft')]";
	private static final String EXTPROPERTYNAME_XPATH = "(//input[contains(@class,'c-itemList__input t-propertyNameInput')])";
	private static final String EXTPROPERTYALIAS_XPATH = "(//input[contains(@class,'c-itemList__input t-propertyAliasInput')])";
	private static final String EXTPROPERTYTYPE_XPATH = "//ul[contains(@class,'p-dropdown-items')]//li/span";
	// private static final String FIELDLENGTH_XPATH =
	// "(//input[contains(@class,'t-propertyLengthInput')])";
	private static final String FIELDLENGTH_XPATH = "(//input[contains(@class,'p-inputtext p-component p-element p-inputnumber')])";
	private static final String DEFAULTVALUE_XPATH = "(//span[contains(@class,'input-validation')]//input)";// "(//input[@formcontrolname='defaultValue'])";
	private static final String ERROR_XPATH = "(//div[contains(@class,'c-itemList__contentRow c-itemList__contentRow--withHandleLeft')]//span[@class='icon-ui-error2 icon-error icon-error-rightMargin ng-star-inserted'])";
	private static final String EXTPROPERTYTYPEDD_XPATH = "(//p-dropdown[contains(@class,'t-propertyTypeDropdown')])";
	private static final String CURRENTDATE_XPATH = "//a[contains(@class,'ui-state-active ui-state-highlight')]";
	private static final String GROUP_NAME_LIST_XPATH = "//div[contains(@class,'contentWrapper')]//span";
	private static final String ADDEXTENDEDPROPERTYBTN2_XPATH = "(//calcite-button[contains(@class,'t-addPropertyBtn')])[2]";
	private static final String SAVEDIALOGTITLE_XPATH = "//span[contains(@class,'p-dialog-title')]";
	private static final String SAVEDIALOGSAVEBTN_XPATH = "//button[contains(@class,'btn p-button')][2]";
	private static final String PROGRESSBARMSG_XPATH = "//div[@class='c-sectionLoader c-sectionLoader--transparent ng-star-inserted']/calcite-loader";
	private static final String PROPNAMELABEL_XPATH = "(//span[contains(@class,'t-propertyNameLabel ng-star-inserted')])";
	private static final String PROPTYPELABEL_XPATH = "(//span[contains(@class,'t-propertyTypeLabel ng-star-inserted')])";
	private static final String PROPLENGTHLABEL_XPATH = "(//span[contains(@class,'t-propertyLengthLabel ng-star-inserted')])";
	private static final String DISPLAY_INPUT_FIELD_XPATH = "(//div[@class='rowItemContainer']//input)[6]";
	// New XPATH CREATED ON 19-09-19
	private static final String DIAGRAM_PRINT_ALL_XPATH = "//div[contains(@class,'ng-star-inserted')]/ul/li[2]";
	private static final String SAVED_SEARCHES_LIST_XPATH = "//span[contains(@class,'c-cardList__cardTitle col-8 t-cardList__cardTitle--searchName')]";
	private static final String QUESTION_XPATH = "(//textarea[contains(@class,'c-panel__contentValue')])[1]";
	private static final String WORKFLOW_AUTHOR_NAME_XPATH = "//div[@class='c-workflowItemCard__contentSection']/div[3]/div[2]";
	private static final String ANSWER_XPATH = "(//input[contains(@formcontrolname,'displayName')])";
	private static final String RETURNCODE = "(//p-inputnumber[contains(@formcontrolname,'value')]//input)";
	private static final String ADDNEWRESPONSE_XPATH = "//calcite-button[@class='btn-noPadding btn-small']";
	private static final String NEWANSWERSET_XPATH = "//div[@class='response-container']//div[3]";
	private static final String NEWTABLE_2_ALIAS_XPATH = "(//input[contains(@class,'t-tableAliasInput')])[2]";
	private static final String NEWRESPONSERETURNCODE_XPATH = "//div[@class='response-container']//div[3]//span[2]//input";
	private static final String NEWRESPONSEANSWER_XPATH = "(//div[@class='response-container']//div[3]//span[1])[1]//input";
	private static final String DELETERESPONSE_XPATH = "(//calcite-button[contains(@class,'btn-delete btn-hidden-until-hover')])[1]";
	// private static final String ARGUMENTANSWER = "//span[@class='input-validation
	// tabGrid-column tabGrid-column-large']";
	private static final String ARGUMENTANSWER = "//div[contains(@class,'rowItem draggbleItem draggbleItem--questionStep')]";
	private static final String PATHDETAILSPANEL_XPATH = "//div[contains(text(),' Path Details ')]";
	private static final String RETURNCODEINPUT = "(//input[contains(@class,'p-dropdown-label p-inputtext')])[2]";
	private static final String STEP_DETAIL_PANEL_XPATH = "//div[@class='c-panel c-panel--diagramEdit']";
	// private static final String EMAILINPUT_XPATH =
	// "//textarea[contains(@class,'emailInput')]";
	// private static final String SUBJECTINPUT_XPATH =
	// "//textarea[contains(@class,'subjectInput')]";
	// private static final String BODYINPUT_XPATH =
	// "//textarea[contains(@class,'bodyInput')]";
	private static final String EMAILINPUT_XPATH = "(//textarea[contains(@class,'t-arcadeInput t-textAreaInput')])[1]";
	private static final String SUBJECTINPUT_XPATH = "(//textarea[contains(@class,'t-arcadeInput t-textAreaInput')])[4]";
	private static final String BODYINPUT_XPATH = "(//textarea[contains(@class,'t-arcadeInput t-textAreaInput')])[5]";
	private static final String ADVANCED_STEP_LIBRARY_XPATH = "//div[@id='libGroup1']";
	// private static final String ELLIPSIS_XPATH =
	// "//div[contains(@class,'c-jobDetailPanel__actionBar')]//button";
	private static final String ELLIPSIS_XPATH2 = "//div[contains(@class,'actionBarSection')]/calcite-dropdown";
	private static final String ELLIPSIS_XPATH = "//div[contains(@class,'actionBarItem')]/calcite-dropdown";
	private static final String ELLIPSIS1_XPATH = "//calcite-button[@class='btn-more']";
	private static final String JOBTEMPLATEDELETE_BUTTON_XPATH = "(//calcite-dropdown-group[@selection-mode='none']/calcite-dropdown-item)[3]";
	private static final String CONFIRMATION_YES_XPATH = "(//button[@class='btn p-button'])";
	private static final String CONFIRMATION_NO_XPATH = "(//button[@class='btn p-button noFill ng-star-inserted'])";
	private static final String JOBTEMPLATENAMECLICK_XPATH = "//div[@class='templateName cell-item']";
	private static final String ACTIVECHECKBOX_XPATH = "//div[@class='p-checkbox p-component p-checkbox-checked']";
	private static final String DEACTIVECHECKBOX_XPATH = "(//div[@class='p-checkbox-box'])";
	private static final String EXTENDED_PROPERTIES_SAVE_CONFIRMSTION_BUTTON_XPATH = "//button[@class='btn p-button']";
	//private static final String DIAGRAM_NAME_XPATH = "//input[contains(@class,'o-textInput p-inputtext')]";
	private static final String DIAGRAM_NAME_XPATH = "//input[contains(@class,'p-inputtext p-component')]";

	
	private static final String DIAGRAM_DESCRIPTION_XPATH = "//textarea[contains(@class,'o-textArea')]";
	private static final String ADD_DATASOURCE_XPATH = "//calcite-button[contains(@class,'btn-small fit-content t-addBtn')]";
	private static final String URLINPUT_XPATH = "//div[@class='inputSection']/span/input";

	private static final String URLOKBUTTON_XPATH = "(//button[@class='p-button'])";
	private static final String URLCANCELBUTTON_XPATH = "(//button[@class='p-button noFill'])";
	private static final String DATASOURCEERROR_BUTTON_XPATH = "//calcite-button[contains(@class,'noHorizontalPadding ng-star-inserted')]";
	private static final String SAVEDIAGRAM_BUTTON_XPATH = "(//calcite-button[@class='ng-star-inserted'])[2]";
	private static final String DROPDOWN_PRIORITY_XPATH = "(//div[contains(@class,'p-dropdown-trigger')])[4]";
	//private static final String PRIORITYLIST_XPATH = "//li[contains(@class,'p-dropdown-item')]";
	private static final String PRIORITYLIST_XPATH = "(//li[contains(@class,'p-ripple p-element p-dropdown-item')]/span)";

	
	private static final String JOBSTARTDATECHECKBOX_XPATH = "(//div[@class='p-radiobutton-box'])[1]";
	private static final String JOBENDDATECHECKBOX_XPATH = "(//div[@class='p-radiobutton-box'])[2]";
	private static final String CATEGORYDROPDOWN_XPATH = "(//p-autocomplete[@dropdownicon='pi pi-chevron-down']//button)[1]";
	private static final String CATEGORYDROPDOWNMENU_XPATH = "//li[@role='option']";
	private static final String JOBTEMPLATESUMMARY_XPATH = "(//textarea[contains(@class,'p-inputtextarea p-inputtext')])[1]";
	private static final String DEFAULTJOBDESCRIPTION_XPATH = "(//textarea[contains(@class,'p-inputtextarea p-inputtext')])[2]";
	private static final String GP_SERVICE_URL_XPATH = "//input[@data-name='panel_serviceUrl']";
	private static final String SECURE_CHECKBOX_XPATH = "//div[contains(@class,'p-checkbox p-component p-checkbox-checked')]";
	private static final String GPSERVICE_URL_ERROR_XPATH = "//span[@class='icon-ui-error2 icon-error ng-star-inserted']";
	private static final String EDIT_ARGUMENT_BUTTON_XPATH = "//calcite-button[@data-name='panel_editBtn']";
	private static final String INPUT_RASTER_FUNCTION_XPATH = "//span[contains(@class,'col-4 input-validation c-itemList__rowCol isError')]//input";
	private static final String INPUT_RASTER_FUNCTION_ERROR_XPATH = "//span[contains(@ptooltip,'Missing required value')]";
	private static final String VISIBLE_AT_RUNTIME_XPATH = "(//div[contains(@class,'p-checkbox-box')])[3]";
	private static final String OPEN_NAME_DROPDOWN_XPATH = "(//div[contains(@class,'p-dropdown-trigger')])[2]";
	private static final String NAME_DROPDOWN_OPTIONS_XPATH = "(//li[contains(@class,'p-dropdown-item')])";
	private static final String ARGUMENTS_TABLE_XPATH = "//div[@class='argSection customTable']";
	private static final String ARGUMENTS_ROWS_XPATH = "(//div[contains(@class,'tableContent')]/div)";
	private static final String RADIO_BTN_XPATH = "(//div[contains(@class,'p-radiobutton-box')])";
	private static final String ADVANCE_STEPLIST_XPATH = "//div[@id='libGroup1']/canvas";
	private static final String STEPDETAIL_RADIO_BTN_XPATH = "(//div[contains(@class,'p-checkbox-box')])";
	private static final String USERPROMPT_XPATH = "//textarea[contains(@class,'t-arcadeInput t-textAreaInput')]";
	private static final String FOLDER_XPATH = "(//span[contains(@class,'input-validation')]/input)[1]";
	private static final String INVALID_FOLDERNAME_ERROR_XPATH = "//calcite-icon[@class='icon-error icon-error-rightMargin ng-star-inserted']";
	private static final String FILETYPE_XPATH = "(//span[contains(@class,'input-validation')]/input)[2]";
	private static final String ACTIVE_RADIO_BTN_XPATH = "(//div[contains(@class,' ui-state-default ui-state-active')])";
	private static final String DIALOGUE_BOX_NAME_XPATH = "//span[contains(@id,'pr_id_7-label')]";
	private static final String ARCGIS_ONLINE_RADIOBUTTON = "//p-radiobutton//label[text()='ArcGIS Online']";
	// private static final String
	// DIALOGUE_BOX_INPUT_XPATH="(//div[contains(@class,'c-itemList__contentRow
	// p-grid ng-star-inserted')]/input)";
	//edited sarath
	private static final String DIALOGUE_BOX_INPUT_XPATH = "(//div[@class='col-12 c-propertyGroup']/span/input)";
	// private static final String
	// USER_PROMPT_XPATH="(//div[(@class='p-grid')]/span/textarea)";
	private static final String USER_PROMPT_XPATH = "(//textarea)[1]";
	private static final String LOCATION_METHOD_XPATH = "(//span[contains(@class,'ui-dropdown-label')])[2]";
	// private static final String
	// JOB_LOCATION_GEOMATRY_XPATH="(//span[contains(@class,'ui-dropdown-label')])[3]";
	private static final String JOB_LOCATION_GEOMATRY_XPATH = "(//span[contains(@class,'p-dropdown-label')])[1]";
	// private static final String
	// LOCATION_METHOD_DROPDWN_LIST_XPATH="((//ul[contains(@class,'p-dropdown')])//li)[1]";
	private static final String LOCATION_METHOD_DROPDWN_LIST_XPATH = "(//ul[contains(@class,'p-dropdown')])//li";
	// private static final String
	// ARGUMENTS_VALUE1_XPATH="//div[@class='tableContent']//div[1]//div[2]";
	//edited sarath
	//private static final String ARGUMENTS_VALUE1_XPATH = "//div[@class='p-grid t-webMapInfo ng-star-inserted']/div[2]/input";
	private static final String ARGUMENTS_VALUE1_XPATH = "//div[@class='grid t-webMapInfo ng-star-inserted']/div[2]/input";

	
	// private static final String
	// ARGUMENTS_VALUE2_XPATH="//div[@class='tableContent']//div[2]//div[2]";
	//edited sarath
	//private static final String ARGUMENTS_VALUE2_XPATH = "//div[@class='p-grid t-webMapInfo ng-star-inserted']/div[2]/input";
	private static final String ARGUMENTS_VALUE2_XPATH = "//div[@class='grid t-webMapInfo ng-star-inserted']/div[2]/input";

	
	private static final String ARGUMENTS_VALUE3_XPATH = "(//textarea)[1]";
	// private static final String
	// ARGUMENTS_VALUE3_XPATH="//div[@class='tableContent']//div[3]//div[2]";
	// private static final String
	// ARGUMENTS_VALUE4_XPATH="//div[@class='tableContent']//div[4]//div[2]";
	private static final String ARGUMENTS_VALUE4_XPATH = "(//div[contains(@class,'p-dropdown p-component')])[1]/span";
	private static final String ERROR_TEXT1_XPATH = "//div[contains(@class,'input-validation')]/span";
	// private static final String
	// ARGUMENTS_VALUE5_XPATH="(//div[@class='row-item-layout']/span)[1]";
	private static final String ARGUMENTS_VALUE5_XPATH = "//span[text()=' Selection Method ']";
	// private static final String
	// ARGUMENTS_VALUE5_XPATH="//div[@class='tableContent']//div[5]//div[2]";
	// private static final String
	// DEFAULT_VALUE_XPATH"//span[@class='input-validation p-col-3
	// c-itemList__rowCol']";
	private static final String MISSING_VALUE_ICON_XPATH = "//span[@class='icon-ui-error2 icon-error ng-star-inserted']";
	private static final String ADD_DOMAIN_BTN_XPATH = "//calcite-button[contains(@class,'btn-noPadding btn-small t-addDomainBtn ng-star-inserted')]";
	private static final String GROUP_XPATH = "(//li[@role='presentation']//a)[1]";
	private static final String ROLE_XPATH = "(//li[@role='presentation']//a)[2]";
	private static final String SHARED_SEARCHES_XPATH = "(//li[@role='presentation']//a)[5]";
	private static final String EMAIL_NOTIFICATION_XPATH = "(//li[@role='presentation']//a)[3]";
	private static final String ROLE_CREATE_NEW_XPATH = "//calcite-button[@class='btn-headerAction']";
	private static final String SELECT_ALL_XPATH = "//span[contains(@class,'c-rolesAndPrivileges__propertyLabel')]/calcite-button";
	private static final String ROLE_NAME_VALIDATION_XPATH = "//span[contains(@class,'icon-ui-error2')]";
	private static final String ROLE_LIST_HEADER_XPATH = "//div[@class='c-rolesAndPrivileges__listHeader']/span";
	private static final String ROLE_WORKFLOW_PRIVILEGES_XPATH = "//div[@class='c-rolesAndPrivileges__propertyContent']/span";
	private static final String DISCARD_CHANGES_XPATH = "(//calcite-button[@class='t-discardBtn'])[2]";
	private static final String ROLE_SAVE_XPATH = "//div[@class='c-rolesAndPrivileges__buttonSection']/calcite-button[1]";
	private static final String ROLE_SAVE1_XPATH = "//div[@class='c-usersAndRoles__buttonSection']/calcite-button[1]";
	private static final String SHAREDSEARCHED_SAVE_BTN_XPATH = "(//calcite-button[@class='t-saveBtn'])[2]";
	private static final String ROLE_NAME_XPATH = "//div[@class='ng-star-inserted']//input";
	private static final String ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH = "((//div[@class='grid grid-nogutter'])/span[1])";
	private static final String ROLE_WORKFLOW_PRIVILEGES_LIST_CHECKBOX_XPATH = "((//div[@class='grid grid-nogutter'])/span[2])";
	private static final String ROLE_WORKFLOW_PRIVILEGES_LIST_ENABLE_CHECKBOX_XPATH = "//p-checkbox[contains(@class,'t-privilegeEnabledCheckbox ng-valid')]";
	private static final String ROLE_NAME_LIST_XPATH = "//span[@class='c-cardList__cardTitle col-8 t-cardList__cardTitle--roleName']";
	private static final String SHAREING_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[3]";
	private static final String WORKFLOW_GROUP_HEADER_XPATH = "(//div[@class='c-customTab__headerTitle'])[1]";
	private static final String ALL_GROUP_HEADER_XPATH = "(//div[@class='c-customTab__headerTitle'])[2]";
	private static final String GROUP_HEADER_XPATH = "//div[@class='c-customTab__headerTitle']";
	private static final String WORKFLOW_GROUP_LIST_XPATH = "(//span[@class='c-cardList__cardTitle col-8 t-cardList__cardTitle--groupName'])";
	private static final String DELETE_BUTTON_XPATH = "(//div[@class='c-rolesAndPrivileges__buttonSection'])/calcite-dropdown/calcite-dropdown-group/calcite-dropdown-item";
	private static final String DELETE_CONFIRMATION_BOX_XPATH = "//span[contains(@class,'p-dialog-title')]";
	private static final String ROLE_SEARCH_BOX_XPATH = "(//input[@class='c-searchBar__searchInput ng-star-inserted'])[2]";
	private static final String JOB_PROP_INPUT_XPATH = "(//input[contains(@id,'prop')])";
	private static final String ADD_NEW_JOB_PROP_XPATH = "//calcite-button[contains(@class,'btn-noPadding')]";
	private static final String DIAGRAM_PRINT_VISIBLE_XPATH = "//div[contains(@class,'ng-star-inserted')]/ul/li[3]";
	private static final String DOMAIN_PENCILICON_XPATH = "(//calcite-button[contains(@class,'t-editDomainBtn')])";
	private static final String EDIT_DOMAIN_DIALOG_HEADER_XPATH = "(//span[contains(@class,'ui-dialog-title')])";
	private static final String EDIT_DOMAIN_DIALOG_DELETE_XPATH = "(//div[contains(@class,'draggbleItem--endButtons')])";
	private static final String DEFAULT_VALUE_DRPDWN_XPATH = "(//div[contains(@class,'p-dropdown-trigger')])";
	private static final String PATH_LOGIC_EXPRESSION_XPATH = "((//p-radiobutton[contains(@name,'pathLogic')])/div)[2]";
	// private static final String PATH_LOGIC_EXPRESSION_INPUT_XPATH =
	// "(//input[contains(@class,'ng-untouched')])[2]";
	// private static final String PATH_LOGIC_EXPRESSION_INPUT_XPATH =
	// "//textarea[@class='static t-prompt c-autoExpandTextArea ng-pristine ng-valid
	// p-inputtextarea p-inputtext p-component ng-star-inserted ng-touched']";
	private static final String PATH_LOGIC_EXPRESSION_INPUT_XPATH = "//textarea[contains(@class,'c-autoExpandTextArea static t-arcadeInput')]";

	private static final String CURRENT_STEP_INPUT_XPATH = "(//div[@class='c-jobCard__summaryInfoPair']/div)[2]";
	private static final String MANAGEPAGE_XPATH = "//wmx-coordinate";
	private static final String TEMPLATE_TAB_LIST_XPATH = "//div[(@class='titleText textOverflow')]";
	private static final String OPTION_RADIO_BTN1 = "(//div[@class='p-radiobutton-box'])[1]";
	private static final String OPTION_RADIO_BTN2 = "(//div[@role='radio'])[2]";
	private static final String GROUPS_RADIO_BTN_XPATH = "(//div[@class='p-radiobutton-box'])[4]";
	private static final String PROMPT_TEXT_XPATH = "//div[@class='c-sharingContainer__promptText']";
	private static final String USER_PROMPT_INPUT_XPATH = "//textarea[contains(@class,'t-arcadeInput t-textAreaInput')]";
	private static final String SELECT_ALL_DESELECT_ALL_BTN_XPATH = "//div[contains(@class,'c-sharingContainer__groupListControl')]//calcite-button";
	private static final String GROUP_NAME_CHECKBOX_XPATH = "(//p-checkbox[contains(@class,'t-groupEnabledCheckbox')])";
	private static final String GROUP_RADIO_BTN_XPATH = "(//div[contains(@class,'p-radiobutton-box')])[2]";
	private static final String ERROR_TEXT_XPATH = "//span[@class='c-sharingContainer__errorMessageText']";
	private static final String SORT_ORDER_DROPDOWN_BTN_XPATH = "//div[contains(@class,'p-dropdown-trigger')]";
	private static final String SORT_ORDER_DROPDOWN_LIST_XPATH = "//div[contains(@class,'p-dropdown-items')]//li";
	private static final String SORT_FIELD_INPUT = "//input[contains(@class,'t-sort-name')]";
	private static final String ADD_SORT_FIELD_BTN_XPATH = "//div[@class='placeholderArea']/calcite-button";
	private static final String MOVE_TO_DELETE_BTN_XPATH = "(//div[contains(@class,'grid rowItem')]/calcite-button[4])";
	private static final String MOVE_TO_TOP_BTN_XPATH = "(//div[contains(@class,'grid rowItem')]/calcite-button[2])";
	private static final String MOVE_TO_DOWN_BTN_XPATH = "(//div[contains(@class,'grid rowItem')]/calcite-button[3])";
	private static final String DISPLAY_FIELDandNAME_INPUT_XPATH = "(//div[@wmx-hover-class]//input)";
	private static final String ADD_DISPLAY_FIELD_BTN_XPATH = "//calcite-button[contains(@class,'t-addDisplayFieldBtn')]";
	private static final String TEST_BTN_XPATH = "//calcite-button[contains(@class,'t-testBtn')]";
	private static final String ERROR_ICON_XPATH = "//calcite-icon[contains(@class,'icon-error')]";
	private static final String FILTER_INPUT_AREA_XPATH1 = "//textarea[contains(@class,'t-searchFilter')]";
	private static final String SEARCHNAME_XPATH = "//input[contains(@class,'t-searchName')]";
	private static final String EMPTY_FILTER_INPUT_AREA_XPATH = "//textarea[contains(@class,'t-searchFilter')]";
	private static final String SETTINGS_CREATENEW_XPATH = "//div[@class='c-sharedSearches__listHeader']/calcite-button";
	private static final String FILTER_INPUT_AREA_XPATH = "//textarea[contains(@class,'p-filled')]";
	private static final String SETTING_PAGE_DISCARD_BTN_XPATH = "(//div[contains(@class,'btnGroup')]/calcite-button)[2]";
	private static final String SETTING_PAGE_SAVE_BTN_XPATH = "(//div[contains(@class,'btnGroup')]/calcite-button)[1]";
	private static final String DIAGRAM_PRINT_BTN_XPATH = "//calcite-button[@class='p-element btn-print']";
	private static final String TOOLBOX_ALIAS_XPATH = "(//textarea[@pinputtextarea])[2]";
	private static final String TOOL_NAME_XPATH = "(//textarea[@pinputtextarea])[3]";
	private static final String ADD_NEW_PARAMETER_XPATH = "//calcite-button[contains(@class,'btn-noPadding btn-small')]";
	private static final String FIRST_PARAMETER_INPUT_XPATH = "//input[contains(@class,'t-prop_0')]";
	private static final String SECOND_PARAMETER_INPUT_XPATH = "//input[contains(@class,'t-prop_1')]";
	private static final String FIRST_PARAMETER_EXPAND_BTN_XPATH = "(//calcite-button[contains(@class,'vertical-align dropdownBtn')])";
	private static final String VALUE_INPUT_XPATH = "(//input[contains(@class,'t-property-stringInput')])";
	private static final String ARCADE_EXPRESSION_XPATH = "//input[@id='arcade1']";
	private static final String ARCADE_EXPRESSION_INPUT_XPATH = "(//input[contains(@class,'t-arcadeInput')])";
	// private static final String ATTACH_GP_LOG_XPATH
	// ="(//div[@class='p-checkbox-box'])[1]";
	private static final String ATTACH_GP_LOG_XPATH = "(//p-checkbox)[2]";
	private static final String ATTACH_GP_LOG_FOLDER_NAME_XPATH = "//input[contains(@class,'t-gpLogAttachmentInput')]";
	private static final String OTHER_TOOL_BOX_RADIO_BTN_XPATH = "//p-radiobutton[contains(@class,'t-toolboxTypeOtherBtn')]/div/div[2]";
	private static final String TOOL_BOX_PATH_INPUT_XPATH = "(//textarea[contains(@class,'t-textAreaInput')])[2]";
	// private static final String VISIBLE_RUNTIME_CHECKBOX_XPATH
	// ="//span[contains(@class,'ui-chkbox-icon ui-clickable pi pi-check')]";
	private static final String VISIBLE_RUNTIME_CHECKBOX_XPATH = "//span[contains(@class,'p-checkbox-icon pi pi-check')]";

	private static final String TOOLTIP_XPATH = "//div[contains(@class,'p-tooltip-text')]";
	// private static final String CREATE_BUTTONSHAREDCHARTS_XPATH
	// ="//button[@class='btn btn-transparent btn-headerAction t-createNewSearch']";
	private static final String CREATE_BUTTONSHAREDCHARTS_XPATH = "//calcite-button[@class='btn-headerAction t-createNewSearch']";
	private static final String SEARCHTEXT_INPUTCHARTNAME_XPATH = "//input[contains(@class,'input-validation t-searchName')]";
	private static final String SEARCHTEXT_DISPLAYFIELD_XPATH = "//input[contains(@class,'input-validation t-displayField')]";
	private static final String SEARCHTEXT_DISPLAYNAME_XPATH = "//*[contains(@class,'input-validation t-displayName')]";
	private static final String SELECT_COLOR_XPATH = "//div[contains(@class,'c-colorRampPicker__item')]/span";
	private static final String SELECT_SHARECHARTWITH_XPATH = "//*[contains(@class,'ui-radiobutton-box ui-widget')]]";
	private static final String SELECT_COLORRAMP_XPATH = "//*[contains(@class,'c-colorRampPicker__item')]/span";
	private static final String SAVE_BTN_XPATH = "(//tbody[@class='ui-table-tbody'])[4]//div/span";
	// private static final String DROPDOWN_CHARTS_XPATH
	// ="(//tbody[@class='ui-table-tbody'])[4]//div/span";
	private static final String DROPDOWN_CHARTS_XPATH = "(//div[@class='p-element c-cardList__card t-cardList__card selected ng-star-inserted'])[2]//div//div//span";
	private static final String SELECT_DROPDOWN_CHARTS_XPATH = "//div[@class='p-element c-cardList__card t-cardList__card ng-star-inserted'][2]//div//div//span";
	private static final String DROPDOWN_GROUPS_XPATH = "//div[@class='c-grid__contentWrapper']/div";
	// private static final String DROPDOWN_SORTDIRECTION_XPATH
	// ="(//*[contains(@class,'ui-dropdown-label ui-inputtext')])[1]";
	private static final String DROPDOWN_SORTDIRECTION_XPATH = "(//*[contains(@class,'p-dropdown-label p-inputtext ng-star-inserted')])[1]";
	// private static final String SETTINGSSIDE_XPATH
	// ="//li[@data-name='settingsLinkBtn']";
	// public static final String SETTINGSSIDE_XPATH
	// ="(//span[contains(@class,'icon-ui-settings')])[2]";
	public static final String SETTINGSSIDE_XPATH = "//ul[@class='subNavigationMenu']/li[5]";
	private static final String SHARED_CHARTS_XPATH = "(//li[@role='presentation']//a)[6]";
	private static final String WEBPAGE_URL_XPATH = "//textarea[contains(@class,'t-arcadeInput t-textAreaInput')]";
	private static final String PREVIEW_EMAIL_INPUT_XPATH = "//input[@class='c-panel__contentValue ng-untouched ng-pristine ng-invalid']";
	// private static final String PREVIEW_BUTTON_XPATH =
	// "//button[@class='btn-clear']";
	private static final String PREVIEW_BUTTON_XPATH = "//div[contains(@class,'c-emailTemplate__previewBtnSection')]/calcite-button";
	// private static final String PREVIEW_DIALOG_BOX_XPATH =
	// "//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]";
	private static final String PREVIEW_DIALOG_BOX_XPATH = "//div[contains(@class,'p-dialog p-component p-dialog-resizable')]";
	private static final String RUN_ON_SCHEDULE_EXPAND_WINDOW_XPATH = "//div[@class='tabSpace--left ng-star-inserted']";
	private static final String RUN_ON_SCHEDULE_SUB_RADIO_BTN_XPATH = "(//p-radiobutton[@name='scheduleOptionGroup']/div)";
	// private static final String WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH =
	// "(//input[@class='ui-inputnumber-input ui-inputtext ui-corner-all
	// ui-state-default ui-widget ui-state-filled'])";
	private static final String WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH = "(//input[@class='p-inputtext p-component p-element p-inputnumber-input p-filled'])";
	private static final String TIME_DROPDOWN_BTN_XPATH = "(//div[contains(@class,'p-dropdown-trigger')])[1]";
	private static final String TIME_DROPDOWN_OPTION_XPATH = "//ul[contains(@class,'p-dropdown-items')]//li/span";
	// private static final String TIME_DROPDOWN_OPTION_XPATH =
	// "//ul[contains(@class,'ui-dropdown-items ui-dropdown-list')]//li/span";
	private static final String TIME_INPUT_XPATH = "//p-calendar[contains(@class,'t-specificTime_hourAndminutes')]//input";
	private static final String DAY_DROPDOWN_BTN_XPATH = "(//div[contains(@class,'p-dropdown-trigger')])[2]";
	private static final String ARCADE_EXPRESSION_INPUTS_XPATH = "//input[@placeholder='Expression']";
	// private static final String ARCADE_EXPRESSION_INPUTS_XPATH =
	// "//input[contains(@class,'t-specificTime_expressionInput')]";

	/********************/
	private static final String DIAGRAM_SETTING_NAME_INPUTS_XPATH = "//span[@class='c-panel__contentLabel']/following-sibling::input";
	private static final String URL_INPUT_XPATH = "//input[contains(@class,'t-requestBaseUrl')]";
	private static final String URL_DROPDOWN_BUTTON_XPATH = "//p-dropdown[contains(@class,'t-requestTypeDropdown')]";
	private static final String URL_DROPDOWN_LIST_XPATH = "(//ul[@role='listbox']//li/span)";
	// private static final String TAB_NAVIGATION_ALL_XPATH =
	// "(//div[@pfocustrap]//ul[@p-tabviewnav]/li/a/span)";
	private static final String TAB_NAVIGATION_ALL_XPATH = "//div[@class='p-tabview p-component']//ul[@class='p-tabview-nav']/li";
	private static final String TAB_NAVIGATION_IS_SELECTED_XPATH = "(//div[@pfocustrap]//li[@role='presentation']/a)";
	// private static final String QUERYPARAM_ADDKEYVALUE_BUTTON_XPATH =
	// "//div[@class='NAText-basic t-queryParamsNAText']/following-sibling::button";
	private static final String QUERYPARAM_ADDKEYVALUE_BUTTON_XPATH = "//div[@class='NAText-basic t-queryParamsNAText']/following-sibling::calcite-button";
	// private static final String QUERYPARAM_ADDKEYVALUE_NOPADDING_XPATH =
	// "//button[@class='btn btn-transparent noPadding']";
	private static final String QUERYPARAM_ADDKEYVALUE_NOPADDING_XPATH = "//calcite-button[@class='noPadding']";
	private static final String AUTH_RADIO_BUTTON_STING_NAME_XPATH = "(//div[@class='grid']//p-radiobutton/div/following-sibling::label)";
	private static final String RADIOBUTTON_NOW_DROPDOWN ="(//span[contains(@class,'p-dropdown-label p-inputtext')])[3]";
	private static final String CLICK_DROPDOWN_LIST_XPATH = "//p-dropdownitem[contains(@class,'p-element')]/li";
	private static final String CLICK_DROPDOWN_NO_AUTH_XPATH = "(//div[contains(@class,'p-dropdown-trigger ')])[3]";

	private static final String DROPDOWNLIST ="(//p-dropdownitem/li/span)";
	private static final String AUTH_RADIO_BUTTON_XPATH = "(//div[@class='grid']//p-radiobutton/div)";
	// private static final String AUTH_RADIO_BUTTON_XPATH =
	// "(//div[@class='p-grid']//div[@role='radio'])";
	// private static final String BLUE_WARNING_MSG_SETTING_PAGE_LINK_XPATH =
	// "//div[@pfocustrap]//div[@class='customMessage']//a";
	private static final String BLUE_WARNING_MSG_SETTING_PAGE_LINK_XPATH = "//div[@class='authMsg ng-star-inserted']";
	private static final String CONTENT_LABEL_NAME_XPATH = "(//div[@pfocustrap]//span[@class='c-panel__contentLabel t-inputLabel'])";
	private static final String CONTENT_LABEL_INPUT_BOX_XPATH = "(//div[@class='ng-star-inserted']/input)";
	private static final String DROPDOWN_BTN_ADDEDTO_XPATH = "(//div[@pfocustrap]//div[@aria-haspopup='listbox'])[3]";
	private static final String DROPDOWN_BTN_ADDEDTO_LIST_XPATH = "(//ul[@role='listbox']/p-dropdownitem)";
	// private static final String EYE_BTN_XPATH =
	// "(//div[@pfocustrap]//span[@class='c-panel__contentLabel'])/..//button";
	private static final String EYE_BTN_XPATH = "//calcite-button[@class='btn-toggle btn-clear ng-star-inserted']";
	// private static final String ADDKEYVALUE_HEADER_TAB_BTN_XPATH =
	// "(//div[@pfocustrap]//button[@translate])[2]";
	private static final String ADDKEYVALUE_HEADER_TAB_BTN_XPATH = "//div[@class='NAText-basic t-headersNAText']/following-sibling::calcite-button";
	private static final String BODY_TEXT_AREA_XPATH = "(//div[@pfocustrap]//textarea)";
	// private static final String SAVEBTN_CONFIGURE_WEB_PAGE_XPATH =
	// "(//div[@pfocustrap]//button[@class='ui-button noFill t-saveBtn'])";
	// private static final String SAVEBTN_CONFIGURE_WEB_PAGE_XPATH =
	// "(//div[@pfocustrap]//button[@class='p-button noFill t-saveBtn'])";
	private static final String SAVEBTN_CONFIGURE_WEB_PAGE_XPATH = "//calcite-button[@class='t-saveBtn']";
	private static final String ARGUMENT_URL_XPATH = "//div[@class='row fitContent t-requestUrlValue']";
	private static final String TEMPLATE_NAME_LIST_XPATH = "(//div[@class='templateName cell-item'])";
	private static final String TEMPLATE_NAME_EDIT_BTN_XPATH = "(//button[@class='p-element diagramList__button p-button-text p-button p-component'])[1]";
	private static final String PATH_VARIABLE_COUNT_XPATH = "((//div[@class='grid grid-wrapper ng-star-inserted']/div[3])/div)";
	private static final String BANNER_TITLE_XPATH = "//span[@class='bannerTitle jobTemplateName draft ng-star-inserted']";
	// private static final String PROFILE_XPATH = "(//span[@class='ui-tabview-title
	// ng-star-inserted'])[1]";
	private static final String PROFILE_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[1]";
	// private static final String AUTOMATED_ACTION_XPATH =
	// "(//span[@class='ui-tabview-title ng-star-inserted'])[4]";
	private static final String AUTOMATED_ACTION_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[4]";
	// private static final String ADD_ACTIVITY_XPATH = "(//button[@class='btn
	// btn-clear'])[2]";
	private static final String ADD_ACTIVITY_XPATH = "(//div[contains(@class,'c-itemGroup__buttonContainer')])[3]/calcite-button";
	// private static final String ADD_ACTIVITY1_XPATH = "(//button[@class='btn
	// btn-transparent btn-small'])";
	private static final String ADD_ACTIVITY1_XPATH = "(//div[contains(@class,'c-itemGroup__buttonContainer')])[3]/calcite-button";
	// private static final String DELETE_ACTIVITY_XPATH =
	// "(//button[contains(@class,'icon-ui-trash icon-btn')])";
	private static final String DELETE_ACTIVITY_XPATH = "(//calcite-button[contains(@class,'icon-btn t-deleteActivityBtn')])";
	private static final String ACTION_DROPDOWN_LIST_XPATH = "//ul[contains(@class,'ui-dropdown-items ui-dropdown-list')]//li/span";
	// private static final String ACTION_DROPDOWN_XPATH =
	// "//p-dropdown[contains(@class,'t-activityActionDropdown ')]/div/div[3]";
	private static final String ACTION_DROPDOWN_XPATH = "//p-dropdown[contains(@class,'t-activityActionDropdown')]/div/div[2]";
	// private static final String TEMPLATE_DROPDOWN_LIST_XPATH =
	// "//ul[contains(@class,'ui-dropdown-items ui-dropdown-list')]//li/span";
	private static final String TEMPLATE_DROPDOWN_LIST_XPATH = "//ul[contains(@class,'p-dropdown-items')]//li/span";
	// private static final String TEMPLATE_DROPDOWN_XPATH =
	// "//p-dropdown[contains(@class,'t-activityTemplateDropdown ')]/div/div[3]";
	private static final String TEMPLATE_DROPDOWN_XPATH = "//p-dropdown[contains(@class,'t-activityTemplateDropdown')]/div/div[2]";
	// private static final String TYPE_DROPDOWN_LIST_XPATH =
	// "(//ul[contains(@class,'ui-dropdown-items')]//li/span)";
	private static final String TYPE_DROPDOWN_LIST_XPATH = "(//ul[contains(@class,'p-dropdown-items')]//li/span)";
	// private static final String TYPE_DROPDOWN_XPATH =
	// "//p-dropdown[contains(@class,'t-activityTypeDropdown ')]/div/div[3]";
	private static final String TYPE_DROPDOWN_XPATH = "//p-dropdown[contains(@class,'t-activityTypeDropdown')]/div/div[2]";

	// edited by pooja
	private static final String ASSIGNTODROPDOWN_XPATH = "//div[@class='p-inputgroup advance-autocomplete-container flexStretch']/button";
	private static final String ASSIGNTODROPDOWNMENUITEM_XPATH = "//div[@class='categoryItem t-categoryItem ng-star-inserted']";

	// edited by sarath
	private static final String USERDEFINEDSETTINGSTABPANEL_XPATH = "//span[@data-index='3']";
	private static final String ADDSETTINGS_XPATH = "//calcite-button[@class='noPadding t-addDisplayFieldBtn']";
	private static final String CLICKINGOUTSIDEBOX_XPATH = "//div[@class='c-userSettings__buttonSection']";
	private static final String TOOL_TIP_XPATH = "//div[@class='p-tooltip-text']";
	private static final String TOOL_TIP2_XPATH = "//div[text()='Invalid characters. The field can only contain alphanumeric characters or underscore.']";
	private static final String INPUT_NAME_TEXTBOX_XPATH = "(//input[contains(@class,'c-itemList__input t-settingName')])[5]";
	private static final String INPUT_VALUE_TEXTBOX_XPATH = "(//input[contains(@class,'c-itemList__input t-settingValue')])[5]";
	private static final String INPUT_NAME_TEXTBOX1_XPATH = "(//input[contains(@class,'c-itemList__input t-settingName')])[6]";
	private static final String INPUT_VALUE_TEXTBOX1_XPATH = "(//input[contains(@class,'c-itemList__input t-settingValue')])[6]";
	private static final String ENCRYPT_BUTTON_XPATH = "(//div[@class='p-checkbox-box'])[13]";
	private static final String SAVE_BUTTON_XPATH = "(//calcite-button[@class='t-saveBtn'])";
	private static final String INPUT_NAME_TEXTBOX2_XPATH = "(//input[contains(@class,'c-itemList__input t-settingName')])[7]";
	private static final String INPUT_VALUE_TEXTBOX2_XPATH = "(//input[contains(@class,'c-itemList__input t-settingValue')])[7]";
	private static final String UNSAVE_POPUP_XPATH = "(//span[@class='p-button-text'])[1]";
	private static final String ERROR_TEXTBOX_XPATH = "//span[contains(@class,'col-5 input-validation c-itemList__rowCol isError')]";
	private static final String ERROR_INPUT_TEXT_XPATH = "//input[@class ='c-itemList__input t-settingName p-inputtext p-component ng-touched ng-dirty p-filled ng-invalid']";
	private static final String SAVE_DISABLED_XPATH = "(//calcite-button[@aria-disabled='true'])[3]";
	private static final String SAVE_POPUP_XPATH = "//div[text()='There are unsaved changes, would you like to save them?']";
	private static final String SAVE_SUCCESS_POPUP_XPATH = "(//div[@slot='message'])[1]";
	private static final String ENTER_SEARCH_TEXT_XPATH = "//input[contains(@class,'t-searchInput')]";
	private static final String TOOL_TIP3_XPATH = "//div[@class='p-tooltip-text']";
	private static final String DROP_DOWN_ARCADE_XPATH = "//ul[@class='p-slidemenu-rootlist p-active-submenu']/li";
	private static final String SELECT_EXTENDED_PROPERTY_XPATH = "(//span[contains(@class,'p-menuitem-text')])[1]";
	private static final String SELECT_JOB_EXTENDED_PROPERTY_XPATH = "(//span[contains(@class,'p-menuitem-text')])[2]";
	private static final String DROP_DOWN_EXTENDED_XPATH = "(//p-slidemenusub[@class='p-element ng-tns-c59-61']/ul)[1]/li";
	private static final String VERIFY_TEXT_XPATH = "//textarea[contains(@class,'c-autoExpandTextArea static t-arcadeInput t-textAreaInput')]";
	private static final String SELECT_GLOBAL_XPATH = "(//a[@class = 'p-menuitem-link ng-star-inserted'])[4]";
	private static final String CLICK_LOCATION_XPATH = "(//span[contains(@class,'p-menuitem-text')])[30]";
	private static final String CLICK_JOB_PROPERTIES_XPATH = "(//span[contains(@class,'p-menuitem-text')])[10]";
	private static final String CLICK_PORTAL_XPATH = "(//span[contains(@class , 'p-menuitem-text')])[33]";
	private static final String CLICK_SETTINGS_XPATH = "(//span[contains(@class , 'p-menuitem-text')])[43]";
	private static final String CLICK_WORKFLOW_XPATH = "(//span[contains(@class , 'p-menuitem-text')])[45]";
	private static final String DROP_DOWN_GLOBLE_XPATH = "(//ul[@class='p-submenu-list p-active-submenu'])[2]/li";
	private static final String DROP_DOWN_LOCATION_XPATH = "(//ul[contains(@class,'p-submenu-list p-active-submenu')])[4]/li";
	private static final String DROP_DOWN_JOB_PROPERTIES_XPATH = "(//ul[contains(@class,'p-submenu-list p-active-submenu')])[3]/li";
	private static final String DROP_DOWN_JOB_PORTAL_XPATH = "(//ul[contains(@class,'p-submenu-list p-active-submenu')])[5]/li";
	private static final String DROP_DOWN_SETTINGS_XPATH = "(//ul[contains(@class,'p-submenu-list p-active-submenu')])[6]/li";
	private static final String DROP_DOWN_WORKFLOW_XPATH = "(//ul[contains(@class,'p-submenu-list p-active-submenu')])[7]/li";
	private static final String CLICK_RADIO_BTN_XPATH = "(//div[@class = 'p-radiobutton-box'])[1]";
	private static final String CLICK_PANEL_EDIT_BTN_XPATH = "//calcite-button[@data-name ='panel_editBtn']";
	private static final String CLICK_CANCEL_BTN_XPATH = "(//calcite-button[@appearance='outline'])[5]";
	private static final String CLICK_AUTHORIZATION_BTN_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[6]";
	private static final String CLICK_RADIO_BTN1_XPATH = "(//div[@class='p-radiobutton p-component'])[3]";
	private static final String CLICK_RADIO_BTN2_XPATH = "(//div[@class='p-radiobutton p-component'])[4]";
	private static final String CLICK_RADIO_BTN3_XPATH = "(//div[@class='p-radiobutton p-component'])[5]";
	private static final String CLICK_HEADERS_BTN_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[7]";
	private static final String SELECT_ARCADE_SYMBOLS_XPATH = "//div[@class='templateCard ng-star-inserted selected']";
	//private static final String SELECT_WEBHOOK_JOB_CREATION_XPATH = "(//calcite-button[@appearance='outline'])[11]";
	private static final String SELECT_WEBHOOK_JOB_CREATION_XPATH = "//calcite-button[text()=' Add Webhook ']";

	//private static final String CLICK_CANCEL_BTN2_XPATH = "(//calcite-button[@appearance='outline'])[14]";
	private static final String CLICK_CANCEL_BTN2_XPATH = "//calcite-button[text()='Cancel']";

	
	private static final String CLICK_ARCADE_ICON_XPATH = "(//calcite-button[contains(@class,'t-arcadeMenuIcon')])[4]";
	private static final String CLICK_ARCADE_ICON1_XPATH = "(//calcite-button[contains(@class,'t-arcadeMenuIcon')])[5]";
	private static final String CLICK_ARCADE_ICON2_XPATH = "(//calcite-button[contains(@class,'t-arcadeMenuIcon')])[1]";
	private static final String CLICK_ARCADE_ICON3_XPATH = "(//calcite-button[contains(@class,'t-arcadeMenuIcon')])[2]";
	private static final String CLICK_ARCADE_ICON4_XPATH = "(//calcite-button[contains(@class,'t-arcadeMenuIcon')])[3]";
	private static final String CLEAR_URL_INPUT_XPATH = "//div[@class='p-col-12 dropdownInput']";
	private static final String CLICK_DELETE_YES_BTN_XPATH = "//button[@class='btn p-button']";
	private static final String ENTER_TEXT_XPATH = "(//input[@type = 'text'])[3]";
	private static final String ENTER_SEARCH_TEXT_BOX_XPATH = "//textarea[@class = 'c-autoExpandTextArea c-itemList__input t-arcadeInput t-textAreaInput ng-untouched ng-pristine ng-valid p-inputtextarea p-inputtext p-component ng-star-inserted']";
	private static final String CREATE_NEW_JOB_TEMPLATES_XPATH = "(//calcite-button[@scale='m'])[3]";
	private static final String JOB_NAME_XPATH = "(//div[@class='input-validation--template']/input)[2]";

	// edited by arpit
	private static final String CREATE_WEBHOOK_VISIBLE = "//h3[text()='Create Webhook']";
	private static final String ADD_WEBHOOK_BUTTON = "//calcite-button[@icon-start='webhook']";
	private static final String WEBHOOKNAME_XPATH = "(//calcite-input)";
	private static final String ARCADEINPUT = "(//input[contains(@class,'t-arcadeInput')])";
	private static final String WEBHOOKSWITCH_TAB = "(//calcite-tab-title)";
	private static final String ATTACHMENT_LABEL = "//calcite-label[text()=' Attachment Name ']";
	private static final String FOLDER_NAME_LABEL = "//calcite-label/div";
	private static final String ADD_OUTPUT_PATH = "//calcite-button[text()=' Add Output & Path ']";
	private static final String ADD_OUTPUT_NOPADDING_PATH = "//calcite-button[contains(@class,'noPadding ')]";
	private static final String OUTPUT_EXTRACTIONVALUE = "(//div[@class='col-12 paramContent']//div//input)";
	//private static final String OUTPUT_EXTRACTIONPATH ="//div[@class='col-12 paramContent']//div[1]//div[3]//input";
	
	private static final String SAMPLE_TEXTAREA = "//textarea[contains(@class,'t-sampleResponseInput')]";
	private static final String SAMPLE_RESULT = "//div[@class='col-3 scroll-x']";
	private static final String ARCADE_MENU = "(//calcite-button[contains(@class,'t-arcadeMenu')])";
	private static final String ARCADE_MENU_PANEL = "(//ul[@class='p-slidemenu-rootlist p-active-submenu']/li)";
	private static final String ARCADE_MENU_PANEL_SETTING = "//ul[@class='p-submenu-list p-active-submenu']//span[text()='Setting']";
	private static final String CUSTOMNAME_PATH = "(//div[@class='p-radiobutton-box'])[4]";
	private static final String AUTOGENERATED_XPATH = "(//div[@class='p-radiobutton-box'])[4]";
	private static final String IDSPAN_XPATH = "//span[contains(@class,'t-webhookIDLabel')]";
	private static final String URLSPAN_XPATH = "//span[contains(@class,'t-webhookUrlLabel')]";
	private static final String WEBHOOKNAME_AFTERSAVE = "//input[contains(@class, 't-webhookNameInput')]";
	private static final String HOVERDELETE = "//calcite-button[contains(@class,'t-deleteTaskBtn')]";
	private static final String HOVERCOPY = "//calcite-button[contains(@icon-start,'copyToClipboard')]";
	private static final String HOVEREDIT = "//calcite-button[contains(@class,'t-editDetailsButton')]";
	private static final String SURVEY123ADD_BTN = "//calcite-button[contains(@class,'t-addSurveyBtn')]";
	private static final String ARCGISONLINERADIO = "(//p-radiobutton)[5]";
	// TS 78
	private static final String CLICK_GEOMETRY = "//p-radiobutton[2]/div";
	private static final String ARCADE_MENU_PANEL_JEP = "(//ul[@class='p-submenu-list p-active-submenu'])[1]/li[1]";
	private static final String ARCADEINPUT_TEXTAREA = "(//textarea[contains(@class,'t-arcadeInput')])";
	private static final String EXTENDED_PROPERTY_XPATH = "(//span[@class='p-tabview-title ng-star-inserted'])[2]";
	private static final String ADDFEATURE_SERVICE = "//calcite-button[contains(@class,'med t-addFeatureServiceBtn')]";
	//TS93
	private static final String ADD_SCHEDULETASK_BUTTON="//calcite-button[@icon-start='clock']";
	private static final String CREATE_SCHEDULE_VISIBLE="//div[@role='dialog']";
	//edited sarath
	//private static final String CLICKTIMERADIO="(//p-radiobutton[@class='ng-untouched ng-pristine ng-valid'])";
	private static final String CLICKTIMERADIO="(//p-radiobutton[contains(@class,'p-element ng-untouched ng-pristine ng-valid')])";
	//private static final String CLICKTIMERADIO1="(//p-radiobutton[@class='ng-untouched ng-pristine ng-valid'])";
	private static final String CLICKTIMERADIO1="(//p-radiobutton[contains(@class,'p-element ng-untouched ng-valid ng-pristine')])";
	//private static final String CLICKTIMERADIO2="(//p-radiobutton[@class='ng-untouched ng-pristine ng-valid'])";
	private static final String CLICKTIMERADIO2="(//p-radiobutton[contains(@class,'p-element ng-untouched ng-valid ng-dirty')])";
	
	
	private static final String DROPDOWN_ELEMENTS = "(//li[@class='p-dropdown-item p-ripple']/span)";
	
	//TS97
	private static final String FORCEGROUP_ASSGN_CHECKBOX = "//div[contains(@class,'p-checkbox-box')]";
	private static final String PUBLIC_ASSGN_DROPDOWN = "//button[contains(@class,'t-autocompleteInputSelectionButton')]";
	//TS100
	private static final String DIAFRAMTITLE = "(//div[@class='templateName cell-item'])";	
	//TS16_MODIFICATION
	private static final String TABLE_NAME = "//span[contains(@class,'t-tableNameLabel')]";
	//TS16_MODIFICATION
	private static final String MESSAGE_NAME = "//div[contains(@class,'authMsg')]";
	//TS103
		private static final String LOOKUP_TABLES = "(//span[contains(@class,'p-tabview-title ng-star-inserted')])";	
		private static final String STATUS_TYPES = "(//tbody[contains(@class,'p-element p-datatable-tbody')]/div)";	
		private static final String VERIFY_STATUS_TYPES = "//div[contains(@class,'c-lookupTables__rightSection')]";	
		private static final String ADD_STATUS_TYPE_BTN = "//calcite-button[contains(@class,'noPadding t-addStatusBtn ng-star-inserted')]";	
		private static final String VERIFY_NEW_INPUT_BOX = "//div[contains(@class,'col-6 c-propertyGroup ng-untouched ng-pristine ng-invalid')]";	
		private static final String CLICK_OUTSIDE_BOX = "//div[@class='col-4']";
		private static final String VERIFY_INPUT_BOX_RED = "//span[@class='c-propertyGroup__input input-validation isError']";	
		private static final String VERIFY_SAVE_N_DISCARD_BTN = "(//div[@class='btnGroup']/calcite-button)";
		private static final String ENTER_INPUT_TEXT = "//input[contains(@class,'p-inputtext p-component p-element t-statusNameInput ng-pristine')]";
		private static final String HOVER_I_ICON = "//calcite-icon[@class='p-element icon-error ng-star-inserted']";
		private static final String PRIORITIES_BTN = "(//div[contains(@class,'p-element c-cardList__card t-cardList__card ng-star-inserted')])[1]";
		private static final String PRIORITIES_CONTAINS_BTN = "//div[@class='c-lookupTables__rightSection--content ng-untouched ng-pristine ng-valid ng-star-inserted']";
		private static final String DELETE_BTN_IN_PRIORITIES = "(//calcite-button[contains(@class,'p-element icon-btn t-removeStatusBtn')])";
		private static final String ADD__PRIORITY_BTN = "//calcite-button[contains(@class,'noPadding t-addPriorityBtn ng-star-inserted')]";	
		private static final String ENTER_INPUT_TEXT2 = "//input[contains(@class,'p-inputtext p-component p-element t-priorityNameInput js-priorityNameInput3')]";
		private static final String ENTER_INPUT_TEXT3 = "//input[contains(@class,'p-inputtext p-component p-element t-priorityValueInput ng-untouched ng-pristine ng-valid')]";
		private static final String ENTER_INPUT_ERROR_TEXT4 = "//input[contains(@class,'p-inputtext p-component p-element t-priorityValueInput ng-touched ng-dirty ng-invalid p-filled')]";

		

	static CommonFunction cfunction = new CommonFunction();
	
	
	// TS103
		public static void clickOnLookupTables() {
			cfunction.Commmon_Click("xpath", LOOKUP_TABLES + "[2]");
		}

		public static boolean verifyStatusTypes() throws Exception {
			WebElement statusTypes = driver.findElement(By.xpath(STATUS_TYPES + "[1]"));
			System.out.println("Lookup Tables list includes ----" + statusTypes.getText());
			return CommonFunction.elementIsDisplayed(STATUS_TYPES + "[1]");

		}

		public static boolean verifyPriorities() throws Exception {
			WebElement priorities = driver.findElement(By.xpath(STATUS_TYPES + "[2]"));
			System.out.println("Lookup Tables list includes ----" + priorities.getText());
			return CommonFunction.elementIsDisplayed(STATUS_TYPES + "[2]");
		}

		public static boolean verifyStatusTypesVisibleRight() throws Exception {
			return CommonFunction.elementIsDisplayed(VERIFY_STATUS_TYPES);
		}

		public static void clickOnAddStatusType() {
			cfunction.Commmon_Click("xpath", ADD_STATUS_TYPE_BTN);
		}

		public static boolean verifyNewInputBoxAppear() throws Exception {
			return CommonFunction.elementIsDisplayed(VERIFY_NEW_INPUT_BOX);
		}

		public static void clickInputBox() {
			cfunction.Commmon_Click("xpath", VERIFY_NEW_INPUT_BOX);
		}

		public static void clickoutsideBox() {
			cfunction.Commmon_Click("xpath", CLICK_OUTSIDE_BOX);
		}

		public static boolean verifyBoxOutlineRed() {
			return CommonFunction.elementIsDisplayed(VERIFY_INPUT_BOX_RED);
		}

		public static boolean verifyToolTipText(String tooltip) {
			return cfunction.verifyToolTip("//div[contains(@class,'p-tooltip-text')]", tooltip);
		}

		public static void hoverOnI() {
			cfunction.hoverByAction(HOVER_I_ICON);
		}

		public static void enterInputText(String Text) {
			cfunction.Commmon_Click("xpath", ENTER_INPUT_TEXT);
			cfunction.CommonTextBox_Input(ENTER_INPUT_TEXT, Text);
		}

		public static boolean verifySaveBtnEnabled() {
			boolean verified = false;
			WebElement element = driver.findElement(By.xpath(VERIFY_SAVE_N_DISCARD_BTN + "[3]"));
			if (element.isEnabled()) {
				verified = true;
				System.out.println("Save button enabled");
			} else {
				System.out.println("Save button disabled");
			}
			return verified;
		}

		public static boolean verifyDiscardBtnEnabled() {
			boolean verified = false;
			WebElement element = driver.findElement(By.xpath(VERIFY_SAVE_N_DISCARD_BTN + "[4]"));
			if (element.isEnabled()) {
				verified = true;
				System.out.println("Discard Changes button enabled");
			} else {
				System.out.println("Discard Changes button disabled");
			}
			return verified;
		}

		public static void reorder() {
			WebElement From = driver.findElement(By.xpath("(//calcite-button[@class='p-element btn-handle-drag'])[10]"));
			// Element on which need to drop.
			WebElement To = driver.findElement(By.xpath("(//calcite-button[@class='p-element btn-handle-drag'])[8]"));
			// Using Action class for drag and drop.
			Actions act = new Actions(driver);
			// Dragged and dropped.
			act.dragAndDrop(From, To).build().perform();
		}

		public static void clickOnSaveBtnStatusType() {
			cfunction.Commmon_Click("xpath", SAVE_BUTTON_XPATH);
		}

		public static boolean verifySuccessTooltipMsg(String successMsg) {
			boolean verified = false;
			String msg = cfunction.getElementText("(//div[@slot='message'])[2]");
			String[] arrOfStr = msg.split(" ", 2);
			for (String a : arrOfStr) {
				System.out.println(arrOfStr[0]);
				jobName = arrOfStr[0];
			}
			System.out.println(msg);
			if (msg.contains("successful")) {
				verified = true;
			}
			return verified;
		}

		public static void reorder1() {
			WebElement From = driver.findElement(By.xpath("(//calcite-button[@class='p-element btn-handle-drag'])[8]"));
			// Element on which need to drop.
			WebElement To = driver.findElement(By.xpath("(//calcite-button[@class='p-element btn-handle-drag'])[6]"));
			// Using Action class for drag and drop.
			Actions act = new Actions(driver);
			// Dragged and dropped.
			act.dragAndDrop(From, To).build().perform();
		}

		public static void clickDiscardBtnStatusType() {
			cfunction.Commmon_Click("xpath", "//calcite-button[@class='t-discardBtn']");
		}

		public static void clickOnPriorities() {
			cfunction.Commmon_Click("xpath", PRIORITIES_BTN);
		}

		public static boolean verifyPrioritiesValues() {
			return CommonFunction.elementIsDisplayed(PRIORITIES_CONTAINS_BTN);
		}

		public static void clickOnDeleteBtnInPriorities() {
			cfunction.Commmon_Click("xpath", DELETE_BTN_IN_PRIORITIES + "[2]");
		}

		public static void clickOnAddPriority() {
			cfunction.Commmon_Click("xpath", ADD__PRIORITY_BTN);
		}

		public static void enterInputText2(String Text) {
			cfunction.Commmon_Click("xpath", ENTER_INPUT_TEXT2);
			cfunction.CommonTextBox_Input(ENTER_INPUT_TEXT2, Text);
		}

		public static void enterInputText3(String Text) {
			cfunction.Commmon_Click("xpath", ENTER_INPUT_TEXT3);
			cfunction.CommonTextBox_Input(ENTER_INPUT_TEXT3, Text);
		}
		public static void enterInputErrorText(String Text) {
			cfunction.Commmon_Click("xpath", ENTER_INPUT_ERROR_TEXT4);
			cfunction.CommonTextBox_Input(ENTER_INPUT_ERROR_TEXT4, Text);
		}

		public static boolean verifyDeletedRowDisable() throws Exception {
			cfunction.sync(5);
			boolean absent = false;
			WebElement element = driver.findElementByXPath(
					"//div[@class='c-lookupTables__rightSection--content ng-valid ng-star-inserted ng-touched ng-dirty']");
			absent = element.isDisplayed();
			/* element. */
			System.out.println("Element's presence " + absent);
			return absent;
		}
		public static boolean verifyDeletedRowEnabled() {
			return CommonFunction.elementIsDisplayed("//div[@class='c-lookupTables__rightSection--content ng-valid ng-star-inserted ng-untouched ng-pristine']");
		}
		public static boolean verifyRearrange() {
			return CommonFunction.elementIsDisplayed("(//div[@class='col-4'])[4]");
		}


	//TS16_MODIFICATION
	public static boolean tableExist(String label) {
		boolean value = false;
		cfunction.sync(7);
		WebElement element = driver.findElementByXPath(TABLE_NAME);
		String text= element.getText();
		cfunction.sync(19);
		if(text.contains(label)) {
			value = true;
		}else {
			value = false;
		}
		return value;
	}
	
	//TS77_MODIFICATION
	public static boolean messageExist(String label) {
		boolean value = false;
		cfunction.sync(7);
		WebElement element = driver.findElementByXPath(MESSAGE_NAME);
		String text= element.getText();
		cfunction.sync(19);
		if(text.contains(label)) {
			value = true;
		}else {
			value = false;
		}
		return value;
	}
	
	//TS100
		public static void clickLeftofEdit() {
			
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "//div[@class='actionBarItem']/calcite-dropdown");	
			
		}
		public static void verify_PopUp(String msg) {
			List<WebElement> popUP = driver.findElements(By.xpath("//div[@class='actionBarItem']/calcite-dropdown//calcite-dropdown-item"));
			int size=popUP.size();
			if(size>0) {
				 CommonFunction.logStatus("PASS", msg);
			} else {
				System.out.println("New pop up not here");
	       	 CommonFunction.logStatus("FAIL", msg);
			}
		}
		
		public static void clickOnDuplicate() {
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "//div[@class='actionBarItem']/calcite-dropdown//calcite-dropdown-item[1]");
			
		}
		
		public static boolean verifyJobDiagramHeader(String diagramName) {
			cfunction.sync(21);
			boolean verified = false;
			List<WebElement>  header = driver.findElements(By.xpath(DIAFRAMTITLE));
			for (WebElement item : header) {
				if (item.getText().equalsIgnoreCase(diagramName)) {
					verified = true;
					System.out.println(item.getText() + " found in List");
				}
				
			}
			return verified;
		}
	
	
	
	
	//TS97
		public static boolean verifyCheckBoxEnable() throws Exception {
			cfunction.sync(10);
			boolean absent = false;
			WebElement element = driver.findElementByXPath(FORCEGROUP_ASSGN_CHECKBOX);
			absent = element.isEnabled();
		/*	element.*/
			System.out.println("Element's presence "+absent);
			return absent;
			
		}
		
		public static boolean verifyCheckBoxDisable() throws Exception {
			cfunction.sync(10);
			boolean absent = false;
			WebElement element = driver.findElementByXPath("//div[@class='p-checkbox-box p-disabled']");
			absent = element.isDisplayed();
		/*	element.*/
			System.out.println("Element's presence "+absent);
			return absent;
			
		}
		
		public static void selectCheckBox() {
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", FORCEGROUP_ASSGN_CHECKBOX);
		}
		
		public static void selectPublicAssgn(String text) {
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", PUBLIC_ASSGN_DROPDOWN);
			cfunction.sync(7);
			List<WebElement> menues = driver.findElements(By.xpath("//div[@class='categoryItem']/span"));
			for (WebElement item : menues) {
				if (item.getText().equalsIgnoreCase(text)) {
					item.click();
					break;
				}}
			
			
			
		}
		
		
		public static void selectPublicAssgnValue(String text) {
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "(//button[contains(@class, 'p-button-secondary')])[2]");
			cfunction.sync(7);
			List<WebElement> menues = driver.findElements(By.xpath("//div[contains(@class,'t-categoryItem')]"));
			for (WebElement item : menues) {
				if (item.getText().equalsIgnoreCase(text)) {
					item.click();
					break;
				}}
			
			
			
		}
		
		public static void selectGroupRadioButton() {
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "//p-radiobutton[contains(@class,'t-pathArcadeAssignmentTypeGroup')]/div");
		}
		
	
	
	//TS93
	
		public static void clickAddScheduleTaskButton() throws Exception {
			 cfunction.Commmon_Click("xpath", ADD_SCHEDULETASK_BUTTON);
		}
		
		public static boolean verifyScheduleDialogVisible() throws Exception {
			return CommonFunction.elementIsDisplayed(CREATE_SCHEDULE_VISIBLE);
		}
		
		public static void clickOnRadioButtonSchedule(int i) throws Exception {
			cfunction.sync(7);
			 cfunction.Commmon_Click("xpath", CLICKTIMERADIO+"["+i+"]");
		}
		
		public static void clickOnRadioButtonSchedule1(int i) throws Exception {
			cfunction.sync(7);
			 cfunction.Commmon_Click("xpath", CLICKTIMERADIO1+"["+i+"]");
		}
		
		public static void clickOnRadioButtonSchedule2(int i) throws Exception {
			cfunction.sync(7);
			 cfunction.Commmon_Click("xpath", CLICKTIMERADIO2+"["+i+"]");
		}

		
		
		public static boolean pageChanged(String xpath, String label) {
			boolean value = false;
			cfunction.sync(7);
			WebElement element = driver.findElementByXPath(xpath);
			String text= element.getText();
			if(text.contains(label)) {
				value = true;
			}else {
				value = false;
			}
			return value;
		} 
		
		public static void clickButoonUpDown(String xpath, int clickTime) {
			WebElement element = driver.findElementByXPath(xpath);
			for(int i=1;i<= clickTime; i++) {
				element.click();
			}
		}
		
		public static void selectActionFrTime(int i, String shape) throws Exception {
			WebElement element = driver.findElementByXPath("(//div[@role='button'])"+"["+i+"]");
			element.click();
			cfunction.sync(7);
			List<WebElement> menues = driver.findElements(By.xpath(DROPDOWN_ELEMENTS));
			for (WebElement item : menues) {
				if (item.getText().equalsIgnoreCase(shape)) {
					item.click();
					break;
				}
			}
		}
		
		public static void selectEndDate(int i) {
			cfunction.Commmon_Click("xpath", "(//p-radiobutton[@name='endDateType']/div)"+"["+i+"]");
		}
		
		public static void enterEndDate() {
			cfunction.sync(7);
			cfunction.CommonTextBox_Input("(//p-calendar/span/input)[3]", "01/15/2030");
			WebElement ele = driver.findElementByXPath("//td/span[contains(@class, 'p-highlight')]");
			ele.click();
			
			
		}
		
		public static void enterSetTime(String text) {
			cfunction.sync(7);
			cfunction.CommonTextBox_Clear("(//p-calendar/span/input)[3]");
			cfunction.CommonTextBox_Input("(//p-calendar/span/input)[3]", text);
			WebElement ele = driver.findElementByXPath("(//button[contains(@class,'p-datepicker-trigger')])[3]");
			ele.click();
			
			
		}
		
		public static boolean saveButtonDisable() {
			boolean absent = true;
			WebElement element = driver.findElementByXPath("//button[@class='p-button t-saveModalBtn']");
			if(element.isEnabled()) {
				System.out.println("Save button Enabled");
				absent = false;
			}
			
			return absent;
		}
		
		public static void enterName(String text) {
			cfunction.sync(7);
			cfunction.CommonTextBox_Input("//span[contains(@class,'input-validation')]/input", text);
		}
		
		public static void clickOnCheckbox() {
			cfunction.Commmon_Click("xpath", "//div[contains(@class,'c-actionContainer')]//div[contains(@class, 'p-checkbox-box')]");
		}
		
		public static void clickOnOKBtn1() {
			cfunction.Commmon_Click("xpath", "//button[@class='p-button t-saveModalBtn']");
		}
		
		public static void clickOnCancelBtn1() {
			cfunction.Commmon_Click("xpath", "//button[@class='p-button noFill t-cancelModalBtn']");
		}
		
		public static void editButton() {
			cfunction.hoverByAction("//span[contains(@class,'t-creationCreatedByLabel')]");
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class,'t-editDetailsButton')]");
			cfunction.sync(7);
		}
		
		public static void deleteButton() {
			cfunction.hoverByAction("//span[contains(@class,'t-creationCreatedByLabel')]");
			cfunction.sync(7);
			cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class,'t-deleteTaskBtn')]");
			cfunction.sync(7);
		}

	
	
	
	
	// TS78
	public static void clickOnGeometry() {
		cfunction.Commmon_Click("xpath", CLICK_GEOMETRY);
	}

	public static void arcadeMenuSingle(int index, int index1) {
		cfunction.Commmon_Click("xpath", ARCADE_MENU + "[" + index + "]");
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", ARCADE_MENU_PANEL + "[" + index1 + "]");
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", ARCADE_MENU_PANEL_JEP);
	}

	public static void enterInArcadeTextArea(String username, int index1) {
		cfunction.sync(7);
		cfunction.CommonTextBox_Input(ARCADEINPUT_TEXTAREA + "[" + index1 + "]", username);
	}

	public static void changeStepManual() {
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "//ul[@class='p-tabview-nav']/li[2]/a");
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "//p-radiobutton[contains(@class,'t-manualRadioBtn')]");
	}

	public static void clickOnExtendedProperty() {
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", EXTENDED_PROPERTY_XPATH);
		cfunction.sync(7);
	}

	public static void switchFeatureServiceTable() {
		cfunction.Commmon_Click("xpath", ADDFEATURE_SERVICE);
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "(//div[@class='p-radiobutton-box'])[4]");
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "(//div[@class='p-radiobutton-box'])[6]");
		cfunction.sync(7);

	}

	public static void renameFeatureServiceTable(String txtValue) {

		cfunction.sync(7);
		//cfunction.CommonTextBox_Input("(//div[@class='p-col-12 c-propertyGroup']/span/input)[2]", txtValue);
		cfunction.CommonTextBox_Input("(//div[@class='col-12 c-propertyGroup']/span/input)[2]", txtValue);

	}

	public static void addFeatureServiceTable(String input) {
		cfunction.sync(2);
		WebElement ele = driver.findElementByXPath(DIALOGUE_BOX_INPUT_XPATH + "[1]");
		// ele.sendKeys(Keys.TAB);
		/*
		 * Robot robot= new Robot(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyPress(KeyEvent.VK_TAB);
		 */
		cfunction.CommonTextBox_Input2(DIALOGUE_BOX_INPUT_XPATH + "[1]", input);
		// WebElement urlTextField = driver.findElement(By.xpath("DIALOGUE_BOX_INPUT_XPATH+\"[1]\"");
		Actions builder = new Actions(driver);
		cfunction.sync(2);
		// Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(2);
		ele.sendKeys(Keys.BACK_SPACE);
		//  WebElement descPaste = driver.findElement(By.cssSelector("input[id=\"descriptioninput\"]");
		ele.click();
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		System.out.println(input);
	}

	public static void saveAndActivate1() {
		cfunction.Commmon_Click("xpath", "(//calcite-button[@class='ng-star-inserted'])[2]");
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "(//calcite-button[@class='ng-star-inserted'])[1]");
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "//button[@class='btn p-button']");
		cfunction.sync(19);
		// cfunction.Commmon_Click("xpath",
		// "//div[@class='actionBarItem']/calcite-button");
	}

	// edited by sarath
	public static void enterJobName(String jobTemplateName) {
		cfunction.CommonTextBox_Input(JOB_NAME_XPATH, jobTemplateName);
	}

	public static void ClickOnCreateNewJobTemplates() {
		cfunction.Commmon_Click("xpath", CREATE_NEW_JOB_TEMPLATES_XPATH);
	}

	public static void clickOnDeleteYes() {
		cfunction.Commmon_Click("xpath", CLICK_DELETE_YES_BTN_XPATH);
	}

	public static void enterTextInSearch(String searchText) {
		cfunction.Commmon_Click("xpath", ENTER_SEARCH_TEXT_BOX_XPATH);
		cfunction.CommonTextBox_Input(ENTER_SEARCH_TEXT_BOX_XPATH, searchText);
	}

	public static void enterTextArcGISPro(String searchText) {
		cfunction.Commmon_Click("xpath", ENTER_TEXT_XPATH);
		cfunction.CommonTextBox_Input(ENTER_TEXT_XPATH, searchText);
	}

	public static void clearURLFrmCofigureWebRequest() {
		cfunction.Commmon_Click("xpath", CLEAR_URL_INPUT_XPATH);
		WebElement remove = driver.findElement(By.xpath(CLEAR_URL_INPUT_XPATH));
		remove.clear();

		/*
		 * Actions a = new Actions(driver);
		 * a.moveToElement(remove).sendKeys(Keys.CONTROL).sendKeys("a",Keys.BACK_SPACE)
		 * .keyUp(Keys.CONTROL).perform(); }
		 */
	}

	public static void clickOnArcadeIcon4() {
		cfunction.Commmon_Click("xpath", CLICK_ARCADE_ICON4_XPATH);
	}

	public static void clickOnArcadeIcon3() {
		cfunction.Commmon_Click("xpath", CLICK_ARCADE_ICON3_XPATH);
	}

	public static void clickOnArcadeIcon2() {
		cfunction.Commmon_Click("xpath", CLICK_ARCADE_ICON2_XPATH);
	}

	public static void clickOnArcadeIcon1() {
		cfunction.Commmon_Click("xpath", CLICK_ARCADE_ICON1_XPATH);
	}

	public static void clickOnArcadeIcon() {
		cfunction.Commmon_Click("xpath", CLICK_ARCADE_ICON_XPATH);
	}

	public static void clickOnCancelBtnInCreateWebhook() {
		cfunction.Commmon_Click("xpath", CLICK_CANCEL_BTN2_XPATH);
	}

	public static void selectWebhookJobCreation() {
		cfunction.Commmon_Click("xpath", SELECT_WEBHOOK_JOB_CREATION_XPATH);
	}

	public static void selectArcadeSymbols() {
		cfunction.Commmon_Click("xpath", SELECT_ARCADE_SYMBOLS_XPATH);
	}

	public static void clickOnHeadersBtn() {
		cfunction.Commmon_Click("xpath", CLICK_HEADERS_BTN_XPATH);
	}

	public static void clickOnBasicAuth() {
		cfunction.Commmon_Click("xpath", CLICK_RADIO_BTN3_XPATH);
	}

	public static void clickOnBearerToken() {
		cfunction.Commmon_Click("xpath", CLICK_RADIO_BTN2_XPATH);
	}

	public static void clickOnApiKey() {
		cfunction.Commmon_Click("xpath", CLICK_RADIO_BTN1_XPATH);
	}

	public static void clickOnAuthorizationBtn() {
		cfunction.Commmon_Click("xpath", CLICK_AUTHORIZATION_BTN_XPATH);
	}

	public static void clickOnTab() {
		cfunction.Commmon_Click("xpath",
				"(//input[contains(@class , 'p-inputnumber-input p-filled')])[2]");

		Actions tab = new Actions(driver);
		tab.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

		/*
		 * for(int i =1;i>=7;i++) {
		 * 
		 * tab.sendKeys(Keys.TAB).perform(); }
		 * 
		 * tab.sendKeys(Keys.ENTER).build().perform();
		 */

	}

	public static void clickOnCancelBtnInConfigureWebRequest() {
		cfunction.Commmon_Click("xpath", CLICK_CANCEL_BTN_XPATH);
	}

	public static void clickOnPanelEditBtn() {
		cfunction.sync(19);
		cfunction.Commmon_Click("xpath", CLICK_PANEL_EDIT_BTN_XPATH);
	}

	public static void clickOnRadioBtn() {
		cfunction.Commmon_Click("xpath", CLICK_RADIO_BTN_XPATH);
	}

	public static void clickSettings() {
		cfunction.Commmon_Click("xpath", CLICK_SETTINGS_XPATH);
	}

	public static void clickWorkflow() {
		cfunction.Commmon_Click("xpath", CLICK_WORKFLOW_XPATH);
	}

	public static void clickPortal() {
		cfunction.Commmon_Click("xpath", CLICK_PORTAL_XPATH);
	}

	public static void clickLocation() {
		cfunction.Commmon_Click("xpath", CLICK_LOCATION_XPATH);
	}

	public static void clickJobProperties() {
		cfunction.Commmon_Click("xpath", CLICK_JOB_PROPERTIES_XPATH);
	}

	public static void clickGlobal() {
		cfunction.Commmon_Click("xpath", SELECT_GLOBAL_XPATH);
	}

	public static void clickJobExtendedProperty() {
		cfunction.Commmon_Click("xpath", SELECT_JOB_EXTENDED_PROPERTY_XPATH);
	}

	public static void clickExtendedProperty() {
		cfunction.Commmon_Click("xpath", SELECT_EXTENDED_PROPERTY_XPATH);
	}

	public static void verifyDropDownWorkFlowlist() {
		List<WebElement> ai = driver.findElements(By.xpath(DROP_DOWN_WORKFLOW_XPATH));
		int dropdown = ai.size();
		for (WebElement element : ai) {
			String alltexts = element.getText();
			System.out.println(alltexts);
		}

		System.out.println(" Workflow slider menu contains : " + dropdown);
		softAssert.assertEquals(dropdown, 4);
	}

	public static void verifyDropDownSettingslist() {
		List<WebElement> ai = driver.findElements(By.xpath(DROP_DOWN_SETTINGS_XPATH));
		int dropdown = ai.size();
		for (WebElement element : ai) {
			String alltexts = element.getText();
			System.out.println(alltexts);
		}

		System.out.println(" Settings slider menu contains : " + dropdown);
		softAssert.assertEquals(dropdown, 1);
	}

	public static void verifyDropDownPortallist() {
		List<WebElement> ai = driver.findElements(By.xpath(DROP_DOWN_JOB_PORTAL_XPATH));
		int dropdown = ai.size();
		for (WebElement element : ai) {
			String alltexts = element.getText();
			System.out.println(alltexts);
		}

		System.out.println(" Portal slider menu contains : " + dropdown);
		softAssert.assertEquals(dropdown, 9);
	}

	public static void verifyDropDownJobPropertieslist() {
		List<WebElement> ai = driver.findElements(By.xpath(DROP_DOWN_JOB_PROPERTIES_XPATH));
		int dropdown = ai.size();
		for (WebElement element : ai) {
			String alltexts = element.getText();
			System.out.println(alltexts);
		}

		System.out.println("Job Properties slider menu contains : " + dropdown);
		softAssert.assertEquals(dropdown, 19);
	}

	public static void verifyDropDownLocationlist() {
		List<WebElement> ai = driver.findElements(By.xpath(DROP_DOWN_LOCATION_XPATH));
		int dropdown = ai.size();
		for (WebElement element : ai) {
			String alltexts = element.getText();
			System.out.println(alltexts);
		}

		System.out.println("Location slider menu contains : " + dropdown);
		softAssert.assertEquals(dropdown, 2);
	}

	public static void verifyDropDownGloblelist() {
		List<WebElement> ai = driver.findElements(By.xpath(DROP_DOWN_GLOBLE_XPATH));
		int dropdown = ai.size();
		for (WebElement element : ai) {
			String alltexts = element.getText();
			System.out.println(alltexts);
		}

		System.out.println("Globle slider menu contains : " + dropdown);
		softAssert.assertEquals(dropdown, 5);
	}

	public static void verifyTextAppears() {
		List<WebElement> ai = driver.findElements(By.xpath(VERIFY_TEXT_XPATH));
		for (WebElement element : ai) {
			String alltexts = element.getText();
			System.out.println(alltexts);

			softAssert.assertEquals(alltexts, "jobExtendedProperty($job, '<table name>', '<field name>')");
		}
		cfunction.elementIsDisplayed(VERIFY_TEXT_XPATH);
	}

	public static void verifyDropDownArcadelist() {

		List<WebElement> ai = driver.findElements(By.xpath(DROP_DOWN_ARCADE_XPATH));
		int dropdown = ai.size();
		for (WebElement element : ai) {
			String alltexts = element.getText();
		}
		System.out.println("Arcade slider menu contains : " + dropdown);
		softAssert.assertEquals(dropdown, 7);

	}

	public static void verifyDropDownExtendedlist() {
		List<WebElement> ai = driver.findElements(By.xpath(DROP_DOWN_EXTENDED_XPATH));
		int dropdown2 = ai.size();
		for (WebElement element : ai) {
			String alltexts = element.getText();
			System.out.println(alltexts);
		}

		System.out.println("Extended slider menu contains : " + dropdown2);
		softAssert.assertEquals(dropdown2, 2);

	}

	public static boolean ArcadeIconExists(String ArcadeIcon) {
		boolean verified = false;
		WebElement ai = driver.findElement(By.xpath(TOOL_TIP3_XPATH));
		String tiptool = ai.getText();
		System.out.println(" Tooltip Message : " + tiptool);
		softAssert.assertEquals(verified, tiptool);
		return verified;
	}

	public static void enterSearchText(String searchText) {
		cfunction.CommonTextBox_Input(ENTER_SEARCH_TEXT_XPATH, searchText);
	}

	public static void clickOnUserDefinedTabPanel() {
		cfunction.Commmon_Click("xpath", USERDEFINEDSETTINGSTABPANEL_XPATH);
	}

	public static void clickOnAddSettings() {
		cfunction.Commmon_Click("xpath", ADDSETTINGS_XPATH);
	}

	public static void clickOnOutsideBox() {
		cfunction.Commmon_Click("xpath", CLICKINGOUTSIDEBOX_XPATH);
	}

	public static void verifyTooltip() {
		WebElement verifytooltip = driver.findElement(By.xpath(TOOL_TIP_XPATH));
		verifytooltip.getText();
	}

	public static void verifyTooltip2() {
		WebElement verifytooltip = driver.findElement(By.xpath(TOOL_TIP2_XPATH));
		verifytooltip.getText();
	}

	public static void enterInputName(String searchText) {
		cfunction.Commmon_Click("xpath", INPUT_NAME_TEXTBOX_XPATH);
		cfunction.CommonTextBox_Input(INPUT_NAME_TEXTBOX_XPATH, searchText);
	}

	public static void enterInputValue(String searchText) {
		cfunction.Commmon_Click("xpath", INPUT_VALUE_TEXTBOX_XPATH);
		cfunction.CommonTextBox_Input(INPUT_VALUE_TEXTBOX_XPATH, searchText);
	}

	public static void enterInputName1(String searchText) {
		cfunction.Commmon_Click("xpath", INPUT_NAME_TEXTBOX1_XPATH);
		cfunction.CommonTextBox_Input(INPUT_NAME_TEXTBOX1_XPATH, searchText);
	}

	public static void enterInputValue1(String searchText) {
		cfunction.Commmon_Click("xpath", INPUT_VALUE_TEXTBOX1_XPATH);
		cfunction.CommonTextBox_Input(INPUT_VALUE_TEXTBOX1_XPATH, searchText);
	}

	public static void clickOnEncryptBtn() {
		cfunction.Commmon_Click("xpath", ENCRYPT_BUTTON_XPATH);
	}

	public static void clickOnSaveBtn2() {
		cfunction.Commmon_Click("xpath", SAVE_BUTTON_XPATH + "[2]");
	}

	public static void enterInputName2(String searchText) {
		cfunction.Commmon_Click("xpath", INPUT_NAME_TEXTBOX2_XPATH);
		cfunction.CommonTextBox_Input(INPUT_NAME_TEXTBOX2_XPATH, searchText);
	}

	public static void enterInputValue2(String searchText) {
		cfunction.Commmon_Click("xpath", INPUT_VALUE_TEXTBOX2_XPATH);
		cfunction.CommonTextBox_Input(INPUT_VALUE_TEXTBOX2_XPATH, searchText);
	}

	public static void clickOnSaveNo() {
		cfunction.Commmon_Click("xpath", UNSAVE_POPUP_XPATH);
	}

	public static void verifyErrorTextbox() {
		cfunction.elementIsDisplayed(ERROR_TEXTBOX_XPATH);
	}

	public static void verifySaveBtnDisabled() {
		cfunction.elementIsDisplayed(SAVE_DISABLED_XPATH);
	}

	public static void verifySavePopup() {
		cfunction.elementIsDisplayed(SAVE_POPUP_XPATH);
	}

	public static void verifySaveSuccessPopup() {
		cfunction.elementIsDisplayed(SAVE_SUCCESS_POPUP_XPATH);
	}
	// ---end--

	// TS 85

	public static void duplicateTheTemplate() {

		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "//div[@class='actionBarItem']/calcite-dropdown");
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "//div[@class='actionBarItem']/calcite-dropdown//calcite-dropdown-item[1]");

	}

	public static boolean verifyWarning(String text) {
		boolean verified = false;
		String elementText = cfunction.getElementText1("//span[@class='c-infoMsg__text']");

		if (elementText.equals(text)) {
			System.out.println(text + " == " + elementText);
			verified = true;
		} else {
			System.out.println(text + " !== " + elementText);
			verified = false;
		}
		return verified;
	}

	public static void saveAndActivate() {
		cfunction.Commmon_Click("xpath", "(//calcite-button[@class='ng-star-inserted'])[2]");
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "(//calcite-button[@class='ng-star-inserted'])[1]");
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "//button[@class='btn p-button']");
		cfunction.sync(19);
		cfunction.Commmon_Click("xpath", "//div[@class='actionBarItem']/calcite-button");
	}

	public static void enterInputInWebApp2(String input) throws Exception {
		cfunction.sync(2);
		WebElement ele = driver.findElementByXPath(DIALOGUE_BOX_INPUT_XPATH + "[2]");
		// ele.sendKeys(Keys.TAB);
		/*
		 * Robot robot= new Robot(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyPress(KeyEvent.VK_TAB);
		 */
		cfunction.CommonTextBox_Input2(DIALOGUE_BOX_INPUT_XPATH + "[2]", input);
		// WebElement urlTextField = driver.findElement(By.xpath("DIALOGUE_BOX_INPUT_XPATH+\"[1]\"");
		Actions builder = new Actions(driver);
		cfunction.sync(2);
		// Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(2);
		ele.sendKeys(Keys.BACK_SPACE);
		//  WebElement descPaste = driver.findElement(By.cssSelector("input[id=\"descriptioninput\"]");
		ele.click();
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		System.out.println(input);
	}

	public static void clickAddSurvey() {
		cfunction.Commmon_Click("xpath", SURVEY123ADD_BTN);
	}

	public static void clickAddSurveyName(String txtValue) {
		cfunction.CommonTextBox_Input("(//div[@class='col-12 qa-panel__content--step'])[1]//input", txtValue);

	}

	public static void clickArcgisOnline() {
		cfunction.Commmon_Click("xpath", ARCGISONLINERADIO);
	}

	public static boolean verifyIDandURL() throws Exception {
		// cfunction.hoverByAction("");
		boolean present = false;
		if (CommonFunction.elementIsDisplayed(IDSPAN_XPATH) && CommonFunction.elementIsDisplayed(URLSPAN_XPATH)) {
			System.out.println("ID and URL both are present");
			present = true;

		} else {
			System.out.println("Either ID or URL not available");
			present = false;
		}

		return present;
	}

	public static boolean verifySuccessMsg21(String successMsg) {
		boolean verified = false;
		String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		String[] arrOfStr = msg.split(" ", 2);
		for (String a : arrOfStr) {
			System.out.println(arrOfStr[0]);
			jobName = arrOfStr[0];
		}
		System.out.println(msg);
		if (msg.contains("Successfully copied to clipboard")) {
			verified = true;
		}
		return verified;
	}

	public static boolean verifyHoverWebhook() throws Exception {
		cfunction.hoverByAction(WEBHOOKNAME_AFTERSAVE);
		boolean present = false;
		if (CommonFunction.elementIsDisplayed(HOVERCOPY) && CommonFunction.elementIsDisplayed(HOVERDELETE)
				&& CommonFunction.elementIsDisplayed(HOVEREDIT)) {
			System.out.println("Copy, Edit and Delete are present");
			present = true;

		} else {
			System.out.println("One of Copy, Edit and Delete not available");
			present = false;
		}

		return present;
	}
	public static void hoverOverCopyUrl() {
		cfunction.sync(5);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//calcite-button[contains(@icon-start,'copyToClipboard')]"));
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static void reorderOuput() {

		WebElement From = driver.findElement(By.xpath("(//div[@class='dragHandle'])[3]"));

		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("(//div[@class='dragHandle'])[2]"));

		// Using Action class for drag and drop.
		Actions act = new Actions(driver);

		// Dragged and dropped.
		act.dragAndDrop(From, To).build().perform();

	}

	public static void updateUsingArcdeSetting(int index, int index1, int index2) throws Exception {

		cfunction.Commmon_Click("xpath", ARCADE_MENU + "[" + index + "]");
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", ARCADE_MENU_PANEL + "[" + index1 + "]");
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", ARCADE_MENU_PANEL_SETTING);
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", ARCADE_MENU + "[" + index2 + "]");
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", ARCADE_MENU_PANEL + "[" + index2 + "]");
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", ARCADE_MENU_PANEL_SETTING);
	}

	public static void clickAddOutputButton() throws Exception {
		cfunction.Commmon_Click("xpath", ADD_OUTPUT_PATH);
	}

	public static void clickAddOutputButtonNoPadding() throws Exception {
		cfunction.Commmon_Click("xpath", ADD_OUTPUT_NOPADDING_PATH);
	}

	public static void clickCustomNameButton() throws Exception {
		cfunction.Commmon_Click("xpath", CUSTOMNAME_PATH);
	}

	public static void clickAutogeneratedNameButton() throws Exception {
		cfunction.Commmon_Click("xpath", AUTOGENERATED_XPATH);
	}

	public static void clickAddWebhookButton() throws Exception {
		cfunction.Commmon_Click("xpath", ADD_WEBHOOK_BUTTON);
	}

	public static void clickWebhookSwitchTab(int index) throws Exception {
		cfunction.Commmon_Click("xpath", WEBHOOKSWITCH_TAB + "[" + index + "]");
		cfunction.sync(7);
	}

	public static void deleteOneOutput(int index) throws Exception {
		cfunction.sync(10);
		cfunction.Commmon_Click("xpath", "(//calcite-button[contains(@class,'btn-delete')])" + "[" + index + "]");
	}

	public static boolean verifyWebhookDialogVisible() throws Exception {
		return CommonFunction.elementIsDisplayed(CREATE_WEBHOOK_VISIBLE);
	}

	public static String activeState_NewTemplate() throws Exception {

		WebElement element = driver
				.findElement(By.xpath("(//span[contains(@class,'p-dropdown-label p-inputtext')])[1]"));
		String text = element.getText();
		System.out.println("Active State is====>" + text);
		return text;
	}

	public static void verifySaveButtonEnabled() {
		WebElement btn = (new WebDriverWait(driver, 20)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='actionBarItem']/calcite-button")));

	}

	public static void enterWebhookField(String searchText, int index) throws AWTException, InterruptedException {
		cfunction.waitforpagetoload();
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", WEBHOOKNAME_XPATH + "[" + index + "]");

		// ngwebdriverHelp.CommonNG_WaitforAngularRequest();
		// cfunction.sync(50);

		// WebElement element= driver.findElementByXPath(WEBHOOKNAME_XPATH);

		String str = searchText;
		Robot robot = new Robot();
		// Press keys using robot
		// A gap of 200ms is added between each key press
		for (int i = 0; i < str.length(); i++) {
			// Check if the current character is a capital letter
			if (Character.isUpperCase(str.charAt(i))) {
				// Press shift key
				robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
				robot.keyPress(Character.toUpperCase(str.charAt(i)));
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
			}
			// else display the character as it is
			else
				robot.keyPress(Character.toUpperCase(str.charAt(i)));
			// wait for 200ms
			Thread.sleep(200);
		}

		// cfunction.CommonTextBoxJS_Input(WEBHOOKNAME_XPATH, searchText);

	}

	public static void enterOutputExtractionInput(String output, String extraction, int index1, int index2) {
		cfunction.CommonTextBox_Input(OUTPUT_EXTRACTIONVALUE +"["+index1+"]", output);
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath",OUTPUT_EXTRACTIONVALUE +"["+index2+"]" );
		cfunction.sync(2);
		cfunction.CommonTextBox_Input(OUTPUT_EXTRACTIONVALUE +"["+index2+"]", extraction);
}

	public static void enterInArcadeInput(String username, String password, int index1, int index2) {
		cfunction.CommonTextBox_Input(ARCADEINPUT + "[" + index1 + "]", username);
		cfunction.sync(5);
		cfunction.CommonTextBox_Input(ARCADEINPUT + "[" + index2 + "]", password);
	}

	public static void clearInArcadeInput(int index1, int index2) {
		cfunction.CommonTextBox_Clear(ARCADEINPUT + "[" + index1 + "]");
		cfunction.sync(5);
		cfunction.CommonTextBox_Clear(ARCADEINPUT + "[" + index2 + "]");
	}

	public static void clickpayload() throws Exception {
		cfunction.Commmon_Click("xpath", "(//p-inputswitch)[3]");
	}

	public static void clickTestMode() throws Exception {
		cfunction.Commmon_Click("xpath", "(//p-inputswitch)[4]");
	}

	public static void clickFallbackUserPass(int idx) throws Exception {
		cfunction.sync(10);
		cfunction.Commmon_Click("xpath", "(//p-inputswitch)["+ idx +"]");
	}

	public static void clickHeaderSecretKey() throws Exception {
		cfunction.sync(10);
		cfunction.Commmon_Click("xpath", "(//p-inputswitch)[2]");
	}

	public static void enterSampleText(String sampleText) {
		cfunction.sync(5);
		cfunction.CommonTextBox_Input(SAMPLE_TEXTAREA, sampleText);
	}

	public static boolean verifyWebhookData(String text, String XPATH) {
		boolean verified = false;
		cfunction.sync(7);
		WebElement element = CommonFunction.getWebElement("xpath", XPATH);
		String title = element.getAttribute("value");
		System.out.println("Value of Field is==" + title);
		if (text.contains(title)) {
			System.out.println(text + "==" + title);
			verified = true;
		} else {
			System.out.println("Values not SAME");
			verified = false;
		}
		return verified;
	}

	public static boolean verifyPresenceofFields(String field1, String field2) {
		boolean verified = false;
		WebElement headerElement1 = driver.findElement(By.xpath(FOLDER_NAME_LABEL));
		String txtItem1 = headerElement1.getText();
		WebElement headerElement2 = driver.findElement(By.xpath(ATTACHMENT_LABEL));
		String txtItem2 = headerElement2.getText();
		System.out.println(txtItem1 + "  --  " + field1);
		System.out.println(txtItem2 + "  --  " + field2);
		if (txtItem1.equalsIgnoreCase(field1) && txtItem2.equalsIgnoreCase(field2)) {
			verified = true;
			System.out.println(txtItem1 + " Field text found");
			System.out.println(txtItem2 + " Field text found");
		}
		return verified;

	}

	public static boolean verifySampleResult(String field1) {
		cfunction.sync(20);
		boolean verified = false;
		WebElement headerElement1 = driver.findElement(By.xpath(SAMPLE_RESULT));
		String txtItem1 = headerElement1.getText();
		System.out.println(txtItem1 + "  --  " + field1);
		if (txtItem1.equalsIgnoreCase(field1)) {
			verified = true;
			System.out.println(txtItem1 + " Field text found");

		}
		return verified;
	}

	public static boolean verifyWebhookName() {
		return CommonFunction.elementIsDisplayed("//input[contains(@class,'t-webhookNameInput')]");
	}

	public static boolean verifyWebhookNameAbsent() {
		boolean absent = true;
		List<WebElement> dynamicElement = driver.findElementsByXPath("//input[contains(@class,'t-webhookNameInput')]");
		if (dynamicElement.size() != 0) {
			// If list size is non-zero, element is present
			System.out.println("Element present");
			return absent = false;
		} else {
			// Else if size is 0, then element is not present
			System.out.println("Element not present");
			return absent = true;
		}
		// return
		// CommonFunction.elementIsDisplayed("//input[contains(@class,'t-webhookNameInput')]");
	}

	public static void editWebhookName() {
		WebElement element = driver.findElementByXPath("//input[contains(@class,'t-webhookNameInput')]");
		cfunction.sync(7);
		element.clear();
		element.sendKeys("Webhook Edit");

	}

	public static void clickWebhookSave() throws Exception {
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "(//calcite-button[text()=' Save '])[1]");
	}

	public static void clickWebhookEdit() throws Exception {
		cfunction.Commmon_Click("xpath", "//calcite-button[contains(@class,'t-editDetailsButton')]");
	}

	public static void hoverCreatedWebhook() {

		cfunction.hoverByAction("//div[contains(@class,'t-webhookRow')]");

	}

	public static void openActionDropdownMenu() throws Exception {
		cfunction.Commmon_Click("xpath", ACTION_DROPDOWN_XPATH);
	}

	public static void saveChanges() {
		cfunction.Commmon_Click("xpath", "//button[@class='btn p-button']");
	}

	public static void selectActionFromDropdown(String shape) throws Exception {
		List<WebElement> menues = driver.findElements(By.xpath(ACTION_DROPDOWN_LIST_XPATH));
		for (WebElement item : menues) {
			if (item.getText().equalsIgnoreCase(shape)) {
				item.click();
				break;
			}
		}
	}

	public static void openTemplateDropdownMenu() throws Exception {
		cfunction.Commmon_Click("xpath", TEMPLATE_DROPDOWN_XPATH);
	}

	public static boolean selectTemplateFromDropdown(String shape) throws Exception {
		boolean verified = false;
		List<WebElement> menues = driver.findElements(By.xpath(TEMPLATE_DROPDOWN_LIST_XPATH));
		for (WebElement item : menues) {
			if (item.getText().equalsIgnoreCase(shape)) {
				item.click();
				verified = true;
				break;
			}
		}
		return verified;
	}

	public static void hoverDeleteActivitybtn(int i) throws Exception {
		// WebElement rows = (WebElement)
		// driver.findElements(By.xpath(DELETE_ACTIVITY_XPATH+"["+i+"]"));
		// cfunction.hoverByJS(rows);
		// cfunction.hoverOnElement(DELETE_ACTIVITY_XPATH+"["+i+"]");
		// cfunction.hoverByAction("//div[@class='p-grid']/span[4]");
		cfunction.hoverByAction("(//calcite-button[@class='p-element icon-btn t-deleteActivityBtn btn-hidden-until-hover'])"+"["+i+"]");

		// cfunction.hoverByJS(DELETE_ACTIVITY_XPATH+"["+i+"]");
		// cfunction.Commmon_Click("xpath", DELETE_ACTIVITY_XPATH+"["+i+"]");
	}

	public static void clickDeleteActivitybtn(int i) throws Exception {
		// cfunction.Commmon_Click("xpath", DELETE_ACTIVITY_XPATH+"["+i+"]");
		cfunction.Commmon_Click("xpath",
				"(//calcite-button[@class='p-element icon-btn t-deleteActivityBtn btn-hidden-until-hover'])"+"["+i+"]");
	}

	public static void clearFilterInputArea() {
		WebElement txtBox = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(FILTER_INPUT_AREA_XPATH)));
		txtBox.clear();
		txtBox.sendKeys("1");
		txtBox.clear();
	}

	public static void verifySaveButtonEnable() {
		WebElement btn = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(SETTING_PAGE_SAVE_BTN_XPATH)));

	}

	public static void clickTYPEDropdown() throws Exception {
		cfunction.Commmon_Click("xpath", TYPE_DROPDOWN_XPATH);
	}

	public static void clickDiscardBtn() {
		WebElement element = driver.findElement(By.xpath(SETTING_PAGE_DISCARD_BTN_XPATH));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		cfunction.Commmon_Click("XPATH", SETTING_PAGE_DISCARD_BTN_XPATH);

	}

	public static boolean verifyFilterInputTextPresent() {
		boolean verified = false;
		try {
			WebElement workflowDiagram = driver.findElement(By.xpath(FILTER_INPUT_AREA_XPATH));
			if (workflowDiagram != null) {
				verified = true;
				System.out.println("text present in filter input box");
			}
		} catch (Exception ex) {
			System.out.println("text is NOT present in filter input box");
		}
		return verified;
	}

	public static void clickOnSettingCreateNewBtn() {
		cfunction.Commmon_Click("xpath", SETTINGS_CREATENEW_XPATH);
	}

	public static boolean verifyFilterInputIsEmpty() {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(EMPTY_FILTER_INPUT_AREA_XPATH));
		if (rows.size() == 1) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyErrorIconToolTip(String tooltip) {
		// return cfunction.verifyToolTip(ERROR_ICON_XPATH, tooltip);
		try {
			WebElement element = CommonFunction.getWebElement("xpath", ERROR_ICON_XPATH);
			String title = element.getAttribute("ptooltip");
			System.out.println(title);
			if (title.equalsIgnoreCase(tooltip)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public static void enterSearchNameInput(String searchText) {
		cfunction.CommonTextBox_Input(SEARCHNAME_XPATH, searchText);
	}

	public static boolean verifySearchNameFieldIndicateRed() throws Exception {
		// if (cfunction.verifyIfHighlighted1(SEARCHNAME_XPATH, "color", "#c86a4a"))
		List<WebElement> rows = driver.findElements(By.xpath(ERROR_ICON_XPATH));
		if (rows.size() == 1)
			// (cfunction.verifyIfHighlighted1(SEARCHNAME_XPATH, "border-color", "#c86a4a"))
			return true;
		return false;

	}

	public static void clickOtherToolBoxRadioBtn() {
		cfunction.Commmon_Click("XPATH", OTHER_TOOL_BOX_RADIO_BTN_XPATH);

	}

	public static void clickAddNewParameterBtn() {
		cfunction.Commmon_Click("XPATH", ADD_NEW_PARAMETER_XPATH);

	}

	public static void clickFirstParameterExpandBtn() {
		cfunction.Commmon_Click("XPATH", FIRST_PARAMETER_EXPAND_BTN_XPATH + "[1]");

	}

	public static void clickSecondParameterExpandBtn() {
		cfunction.Commmon_Click("XPATH", FIRST_PARAMETER_EXPAND_BTN_XPATH + "[2]");

	}

	public static void clickVisibleRuntimeCheckBoxBtn() {
		cfunction.Commmon_Click("XPATH", VISIBLE_RUNTIME_CHECKBOX_XPATH);

	}

	public static void clickSecondArcadeExpressionRadioBtn() {
		cfunction.Commmon_Click("XPATH", ARCADE_EXPRESSION_XPATH);

	}

	public static void clickAttachGpLogRadioBtn() {
		cfunction.ScrollToElement(ATTACH_GP_LOG_XPATH + "[1]");
		cfunction.Commmon_Click("XPATH", ATTACH_GP_LOG_XPATH + "[1]");

	}

	public static void clickAttachGpLogRadioBtn2() {
		cfunction.Commmon_Click("XPATH", ATTACH_GP_LOG_XPATH + "[2]");

	}

	public static void clickAttachGpLogBtn() {
		cfunction.ScrollToElement(ATTACH_GP_LOG_XPATH);
		cfunction.Commmon_Click("XPATH", ATTACH_GP_LOG_XPATH);

	}

	public static void enterAttachGpLogFolderNameInput(String searchText) {
		cfunction.ScrollToElement(ATTACH_GP_LOG_FOLDER_NAME_XPATH);
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", ATTACH_GP_LOG_FOLDER_NAME_XPATH);
		cfunction.sync(2);
		cfunction.CommonTextBox_Input(ATTACH_GP_LOG_FOLDER_NAME_XPATH, searchText);
	}

	public static void enterValueInput(String searchText) {
		cfunction.CommonTextBox_Input(VALUE_INPUT_XPATH, searchText);
	}

	public static void enterSecondValueInput(String searchText) {
		cfunction.CommonTextBox_Input(VALUE_INPUT_XPATH + "[2]", searchText);
	}

	public static void enterArcadeExpressionInput(String searchText) {
		cfunction.CommonTextBox_Input(ARCADE_EXPRESSION_INPUT_XPATH, searchText);
	}

	public static void enterFirstParameterInput(String searchText) {
		cfunction.CommonTextBox_Input(FIRST_PARAMETER_INPUT_XPATH, searchText);
	}

	public static void enterSecondParameterInput(String searchText) {
		cfunction.CommonTextBox_Input(SECOND_PARAMETER_INPUT_XPATH, searchText);
	}

	public static void enterToolBoxAliasInput(String searchText) {
		cfunction.CommonTextBox_Input(TOOLBOX_ALIAS_XPATH, searchText);
	}

	public static void enterToolNameInput(String searchText) {
		cfunction.CommonTextBox_Input(TOOL_NAME_XPATH, searchText);
	}

	public static void enterToolBoxPathInput(String searchText) {
		cfunction.CommonTextBox_Input(TOOL_BOX_PATH_INPUT_XPATH, searchText);
	}

	public static void hoverOnErrorIcon() {
		// cfunction.sync(2);
		cfunction.hoverByAction(ERROR_ICON_XPATH);
	}

	public static void enterFilterInput(String input) {
		cfunction.CommonTextBox_Input(FILTER_INPUT_AREA_XPATH1, input);
	}

	public static void clickOnTestBtn() {
		cfunction.Commmon_Click("xpath", TEST_BTN_XPATH);
	}

	public static void enterDisplayFieldAndName(int index, String name) {
		String xpath = DISPLAY_FIELDandNAME_INPUT_XPATH + "[" + index + "]";
		cfunction.CommonTextBox_Input(xpath, name);
	}

	public static void clickOnAddDisplayFieldBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", ADD_DISPLAY_FIELD_BTN_XPATH);
	}

	public static void hoverMoveToDownBtn(int index) {

		WebElement elementHover = driver.findElement(By.xpath(MOVE_TO_DOWN_BTN_XPATH + "[" + index + "]"));
		cfunction.hoverByJS(elementHover);
		// cfunction.hoverByAction(MOVE_TO_DOWN_BTN_XPATH+"["+index+"]");
	}

	public static void clickMoveToTopBtn(int index) {
		// cfunction.CommmonJS_Click(MOVE_TO_TOP_BTN_XPATH+"["+index+"]");
		cfunction.Commmon_Click("xpath", MOVE_TO_TOP_BTN_XPATH + "[" + index + "]");
		/*
		 * WebElement icon =
		 * driver.findElement(By.xpath(MOVE_TO_TOP_BTN_XPATH+"["+index+"]")); Actions ob
		 * = new Actions(driver); ob.click(icon); Action action = ob.build();
		 * action.perform();
		 */
	}

	public static void hoverMoveToTopBtn(int index) {
		// cfunction.hoverByAction(MOVE_TO_TOP_BTN_XPATH+"["+index+"]");
		/*
		 * List<WebElement> rows = driver.findElements(By.xpath(MOVE_TO_TOP_BTN_XPATH));
		 * cfunction.hoverByJS(rows.get(index));
		 */
		WebElement elementHover = driver.findElement(By.xpath(MOVE_TO_TOP_BTN_XPATH + "[" + index + "]"));
		cfunction.hoverByJS(elementHover);
		// cfunction.hoverOnElement(elementHover);
		// cfunction.hoverByAction(MOVE_TO_TOP_BTN_XPATH+"["+index+"]");
		// cfunction.hoverByJS(+"["+index+"]");
		// cfunction.hoverByAction("(//button[@ptooltip='Move Field To Top'])[4]");
	}

	public static void clickMoveToDownBtn(int index) {
		cfunction.CommmonJS_Click(MOVE_TO_DOWN_BTN_XPATH + "[" + index + "]");
	}

	public static void clickMoveToDeleteBtn(int index) {
		// cfunction.sync(2);
		cfunction.CommmonJS_Click(MOVE_TO_DELETE_BTN_XPATH + "[" + index + "]");

	}

	public static void clickOnAddSortFieldBtn() {
		// cfunction.sync(2);
		cfunction.CommmonJS_Click(ADD_SORT_FIELD_BTN_XPATH);
	}

	public static void enterSortFieldInput(String input) {
		cfunction.CommonTextBox_Input(SORT_FIELD_INPUT, input);
	}

	public static void clickOnGroupRadioBtn1() {
		cfunction.Commmon_Click("xpath", GROUP_RADIO_BTN_XPATH);
	}

	public static void clickOnStepDetailPropertiesTab() {
		cfunction.Commmon_Click("xpath", PROPERTIES_XPATH);
	}

	public static void selectOptionDrpdwn(String option) throws Exception {
		cfunction.selectOptionFromDropDown(SORT_ORDER_DROPDOWN_BTN_XPATH, SORT_ORDER_DROPDOWN_LIST_XPATH, option);
	}

	public static boolean verifyTemplateTabIsVisible(String title) throws Exception {
		String popupTitle = cfunction.getElementText(TEMPLATE_TAB_LIST_XPATH);
		if (popupTitle.equalsIgnoreCase(title))
			return true;
		return false;
	}

	public static void clickOnDiscardChangesBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", DISCARD_CHANGES_XPATH);
	}

	public static void openDefaultValueDropdown(String indexValue) {
		// cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", DEFAULT_VALUE_DRPDWN_XPATH + "[" + indexValue + "]");

	}

	public static void clickOnOptionRadioBtn1() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", OPTION_RADIO_BTN1);
	}

	public static void clickOnOptionRadioBtn2() {
		cfunction.Commmon_Click("xpath", OPTION_RADIO_BTN1);
	}

	public static void clickPathLogicExpression() {
		cfunction.Commmon_Click("XPATH", PATH_LOGIC_EXPRESSION_XPATH);

	}

	public static boolean verifyErrorText(String currentStep) {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(ERROR_TEXT1_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem + "  --  " + currentStep);
		if (txtItem.equalsIgnoreCase(currentStep)) {
			verified = true;
			System.out.println(txtItem + " Error text found");
		}
		return verified;
	}

	public static void clickSelectAllOrDeselectAllBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", SELECT_ALL_DESELECT_ALL_BTN_XPATH);

	}

	public static void clickOnGroupRadioBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", GROUPS_RADIO_BTN_XPATH);
	}

	public static void deleteCodeEntry(String numberOfEntry) {
		cfunction.Commmon_Click("XPATH",
				EDIT_DOMAIN_DIALOG_DELETE_XPATH + "[" + numberOfEntry + "]//calcite-button[2]");

	}

	public static void clickFirstEditDomainBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", DOMAIN_PENCILICON_XPATH + "[1]");
	}

	public static void clickSecondEditDomainBtn() {
		cfunction.Commmon_Click("xpath", DOMAIN_PENCILICON_XPATH + "[2]");
	}

	public static void clickThirdEditDomainBtn() {
		cfunction.Commmon_Click("xpath", DOMAIN_PENCILICON_XPATH + "[3]");
	}

	public static void clickOnSaveBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", ROLE_SAVE_XPATH);
	}

	public static void clickOnSaveBtn1() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", ROLE_SAVE1_XPATH);
	}

	public static void clickOnSaveBtnOfSharedSearched() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", SHAREDSEARCHED_SAVE_BTN_XPATH);
	}

	public static void clickOnExtendedPropertiesConfirmationSaveButtonBtn() {
		cfunction.Commmon_Click("xpath", EXTENDED_PROPERTIES_SAVE_CONFIRMSTION_BUTTON_XPATH);
	}

	public static void clickOnCreateNewBtn() {
		cfunction.Commmon_Click("xpath", CREATENEW_XPATH);
	}

	public static void clickOnCreateNewBtnOfEmail() {
		cfunction.Commmon_Click("xpath", EMAIL_CREATENEW_XPATH);
	}

	public static void clickOnGroupTab() {
		cfunction.Commmon_Click("xpath", GROUP_XPATH);
	}

	public static void clickOnRoleTab() {
		cfunction.Commmon_Click("xpath", ROLE_XPATH);
	}

	public static void clickOnSharedSearchesTab() {
		cfunction.Commmon_Click("xpath", SHARED_SEARCHES_XPATH);
	}

	public static void clickOnSharingTAb() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", SHAREING_XPATH);
	}

	public static void clickOnEmailNotificationTab() {
		cfunction.Commmon_Click("xpath", EMAIL_NOTIFICATION_XPATH);
	}

	public static void clickOnCreateNewRoleBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", ROLE_CREATE_NEW_XPATH);
	}

	public static void clickOnSelectAllBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", SELECT_ALL_XPATH);
	}

	public static void clickOnAddDomainBtn() {
		// cfunction.Commmon_Click("xpath", ADD_DOMAIN_BTN_XPATH);
		// cfunction.CommmonJS_Click("//calcite-button[contains(@class,'btn-noPadding
		// btn-small t-addDomainBtn ng-star-inserted')]");
		cfunction.CommmonJS_Click(ADD_DOMAIN_BTN_XPATH);
	}

	public static void enterJobTemplateName(String jobTemplateName) {
		cfunction.CommonTextBox_Input(JOBTEMPLATENAME_XPATH, jobTemplateName);
	}

	public static void enterEmailTemplateName(String emailTemplateName) {
		cfunction.CommonTextBox_Input(EMAIL_TEMPLATENAME_XPATH, emailTemplateName);
	}

	public static void enterEmail_TO_TemplateName(String text) {
		cfunction.CommonTextBox_Input(EMAIL_TO_TEMPLATENAME_XPATH, text);
	}

	public static void enterEmail_CC_TemplateName(String text) {
		cfunction.CommonTextBox_Input(EMAIL_CC_TEMPLATENAME_XPATH, text);
	}

	public static void enterEmail_BCC_TemplateName(String text) {
		cfunction.CommonTextBox_Input(EMAIL_BCC_TEMPLATENAME_XPATH, text);
	}

	public static void enterEmail_SUBJECT_TemplateName(String text) {
		cfunction.CommonTextBox_Input(EMAIL_SUBJECT_TEMPLATENAME_XPATH, text);
	}

	public static void enterEmail_BODY_TemplateName(String text) {
		cfunction.CommonTextBox_Input(EMAIL_BODY_TEMPLATENAME_XPATH, text);
	}

	public static void enterUserPromptInput1(String input) {
		cfunction.CommonTextBox_Input(USER_PROMPT_INPUT_XPATH, input);
	}

	public static void enterPathLogicInput(String pathLogicInput) {
		cfunction.Commmon_Click("xpath", PATH_LOGIC_EXPRESSION_INPUT_XPATH);
		cfunction.sync(2);
		cfunction.CommonTextBox_Input(PATH_LOGIC_EXPRESSION_INPUT_XPATH, pathLogicInput);
	}

	public static boolean verifyWorkflowAuthorName(String jobTemplate) throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(WORKFLOW_AUTHOR_NAME_XPATH));
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
			if (rowsItem.contains(jobTemplate)) {
				verified = true;
				System.out.println(jobTemplate + " is visible");
				break;
			} else {
				System.out.println(jobTemplate + " is not visible");
			}
		}
		return verified;

	}

	public static void clickOnDefaultProperties() {
		// cfunction.Commmon_Click("xpath", DEFAULTPROPERTIES_XPATH);

	}

	public static void setting_Button_Loading() {
		
		String HEADERNAV_BUTTON ="//calcite-button[@class='p-element t-homeBtn']";
		WebElement headNav= driver.findElementByXPath(HEADERNAV_BUTTON);
		headNav.click();
		List<WebElement> ItemIdCard = driver.findElements(By.xpath("//div[contains(@class,'c-workflowItemCard__contentTitle t-workflowItemTitle')]"));
		
		int size=ItemIdCard.size();
		for (int i=1;i<=size;i++) {
			String text=cfunction.getElementText("(//div[contains(@class,'c-workflowItemCard__contentTitle t-workflowItemTitle')])["+i+"]");
			cfunction.sync(2);
			if(text.equalsIgnoreCase(itemIdName)) {
				cfunction.hoverByAction("(//div[@class='c-workflowItemCard__thumbnailSection'])["+i+"]");
				cfunction.sync(5);
				cfunction.Commmon_Click("xpath", "(//div[@class='c-workflowItemCard__thumbnailBtns'])["+i+"]");
				break;
			}

		}
		
		TestBase.waitforHomePagetoload();
		HomePage.clickOnDesign();
		
	}

	public static void clickOnSettings() {
		cfunction.Commmon_Click("xpath", SETTINGS_XPATH);
	}

	public static void assignJob(String assignTo) {
		cfunction.Commmon_Click("xpath", ASSIGNTODROPDOWN_XPATH);
		cfunction.sync(1);
		cfunction.selectValueFromMenueItem(ASSIGNTODROPDOWNMENUITEM_XPATH, assignTo);
	}

	public static boolean verifyErrorTextVisible() {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ERROR_TEXT_XPATH));
		if (rows.size() == 1) {
			verified = true;

		}
		return verified;
	}

	public static void clickOnSave() {
		// cfunction.Commmon_Click("xpath", SAVE_XPATH);
		WebElement element = driver.findElementByXPath(SAVE_XPATH);
		element.click();
		// cfunction.CommmonJS_Click_ShadowPath("document.querySelector('div.actionBarSection
		// > calcite-button')");
	}

	public static void clickOnSave1() {
		// cfunction.Commmon_Click("xpath", SAVE_XPATH);
		cfunction.Commmon_Click("xpath", "(//div[@class='actionBarItem']/calcite-button)[2]");
	}

	public static void clickOnSave2() {
		// cfunction.Commmon_Click("xpath", SAVE_XPATH);
		cfunction.Commmon_Click("xpath", "(//div[@class='actionBarItem']/calcite-button)");
	}

	public static void clickOnEmailSave() {
		cfunction.Commmon_Click("xpath", EMAIL_SAVE_XPATH);
	}

	public static void hoverOnEmailSave() {
		cfunction.hoverByAction(EMAIL_SAVE_XPATH);
	}

	// public static String JobName="";
	public static boolean verifySuccessMsg(String successMsg) {
		boolean verified = false;
		String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		String[] arrOfStr = msg.split(" ", 2);
		for (String a : arrOfStr) {
			System.out.println(arrOfStr[0]);
			jobName = arrOfStr[0];
		}
		System.out.println(msg);
		if (msg.contains("successful")) {
			verified = true;
		}
		return verified;
	}

	public static boolean verifyPromptTextVisible() {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(PROMPT_TEXT_XPATH));
		if (rows.size() == 1) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifySuccessMsg1(String successMsg) throws Exception {
		boolean verified = false;
		String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		System.out.println(msg);
		if (msg.contains(successMsg)) {
			verified = true;
		}
		return verified;
	}

	public static boolean clickOnGroupNameCheckbox(String groupName) throws Exception {
		boolean verified = false;
		//List<WebElement> rows = driver.findElements(By.xpath("//div[@class='p-grid p-nogutter']/span[1]"));
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='grid grid-nogutter']/span[1]"));

		
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
			if (rowsItem.contains(groupName)) {
				cfunction.Commmon_Click("xpath", "//span[text()=' "+groupName+" ']/parent::div//p-checkbox");
				verified = true;
				break;
			} else {
				System.out.println(groupName + " is not clicked");
			}
		}
		return verified;

	}

	public static boolean verifySuccessMsg2(String successMsg) {
		boolean verified = false;
		// String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		String msg = cfunction.getElementText("(//wmx-toast//div)[2]");
		System.out.println(msg);
		if (msg.contains(successMsg)) {
			verified = true;
		}
		return verified;
	}

	public static boolean verifySuccessMsg3(String successMsg) {
		boolean verified = false;
		// String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		String msg = cfunction.getElementText("(//wmx-toast//div)[3]");
		System.out.println(msg);
		if (msg.contains(successMsg)) {
			verified = true;
		}
		return verified;
	}

	public static void clickOnOKBtn() {
		cfunction.Commmon_Click("xpath", OK_XPATH);
	}

	public static void clickOnXBtn() {
		cfunction.Commmon_Click("xpath", XBUTTON_XPATH);
	}

	public static void clickOnAutomatedAction() {
		cfunction.Commmon_Click("xpath", AUTOMATED_ACTION_XPATH);
	}

	public static void clickOnProfile() {
		cfunction.Commmon_Click("xpath", PROFILE_XPATH);
	}

	public static void clickOnAddActivity() {
		cfunction.Commmon_Click("xpath", ADD_ACTIVITY_XPATH);
	}

	public static void clickOnAddActivity1() {
		cfunction.Commmon_Click("xpath", ADD_ACTIVITY1_XPATH);
	}

	public static void selectCurrentWorkflowDiagram(String selectText) {
		/*cfunction.CommonTextBox_Input(CURRENTWORKFLOWDIAGRAMINPUT_XPATH, selectText.substring(0, 4));*/
		cfunction.CommonTextBox_Input(CURRENTWORKFLOWDIAGRAMINPUT_XPATH, selectText);
		// cfunction.sync(2);
		// cfunction.Commmon_Click("xpath", CURRENTWORKFLOWDRPDWN_XPATH);
		cfunction.sync(25);
		cfunction.selectValueFromMenueItem(CURRENTWORKFLOWDIAGRAMMENUITEM_XPATH, selectText);
	}

	public static void clickOnDiagramsIcon() {
		cfunction.Commmon_Click("xpath", DIAGRAM_XPATH);
	}

	public static void clickOnJobTemplatesIcon() {
		cfunction.Commmon_Click("xpath", JOBTEMPLATE_XPATH);
	}

	public static void clickOnTemplatesIcon() {
		cfunction.Commmon_Click("xpath", TEMPLATE_XPATH);
	}

	public static void clickOnPreviewBtn() {
		cfunction.Commmon_Click("xpath", PREVIEW_BUTTON_XPATH);
	}

	public static void enterEmailPreviewInput(String text) {
		cfunction.CommonTextBox_Input(PREVIEW_EMAIL_INPUT_XPATH, text);
	}

	public static void enterSearchText_Diagram(String searchText) {
		cfunction.sync(19);
		cfunction.CommonTextBox_Input(SEARCHDIAGRAMINPUT_XPATH, searchText);
		cfunction.sync(19);
		WebElement ele = driver.findElementByXPath(SEARCHDIAGRAMINPUT_XPATH);
		ele.sendKeys(Keys.ENTER);
		
		cfunction.sync(19);
	}

	public static void enterInputIntofield(String searchText) {
		cfunction.CommonTextBox_Input(DISPLAY_INPUT_FIELD_XPATH, searchText);
	}

	// click Edit Button
	public static void clickOnEditBtn() {
		cfunction.Commmon_Click("xpath", EDIT_XPATH);
		// cfunction.CommmonJS_Click(EDIT_XPATH);
	}

	public static void enterSearchStepTemplate(String searchText) {
		cfunction.Commmon_Click("xpath", SEARCHSTEPTEMPLATE_XPATH);
		cfunction.sync(4);
		cfunction.CommonTextBox_Input(SEARCHSTEPTEMPLATE_XPATH, searchText);
	}

	public static void enterURLAtWebPage(String url) {
		cfunction.CommonTextBox_Input(WEBPAGE_URL_XPATH, url);

	}

	public static void clickOnSaveWorkFlowDiagram() {
		// cfunction.ScrollToElement(WORKFLOWDIAGRAMSAVE_XPATH);
		cfunction.CommmonJS_Click(WORKFLOWDIAGRAMSAVE_XPATH);
	}

	public static void clickOnActivateWorkFlowDiagram() {
		// cfunction.ScrollToElement(WORKFLOWDIAGRAMSAVE_XPATH);
		cfunction.CommmonJS_Click(WORKFLOWDIAGRAMACTIVATE_XPATH);
	}

	/**********
	 * STEPS TO BE IMPLEMENTED
	 * 
	 * @return
	 * @throws Exception
	 ***************/
	public static boolean dragStepToCanvas() throws Exception {
		boolean overwriteStep = false;
		boolean verified = false;
		String fromImg = "TS1_TC1_QuestionQuad_1280x768";
		String toImg = "TS1_TC1_Flow_1_1280x768";
		// String toImg = "TS1_TC1_Flow_1280x1024";
		/* String toImg = "TS1_TC1_Flow_CBT_1280x1024"; */
		if (SikuliHelp.verifyImageExists(fromImg)) {
			SikuliHelp.dragndropSikuli(fromImg, toImg, overwriteStep);
			verified = true;
			return verified;
		}
		return verified;

		// SikuliHelp.dragndrop_New(fromImg, toImg);

		// SikuliHelp.dragdropOnMapSikuli(fromImg,toImg);

		/*
		 * WebElement dragStep = driver.findElement(By.xpath(STEPLIBRARYCANVAS_XPATH));
		 * cfunction.sync(5); WebElement dropStep =
		 * driver.findElement(By.xpath(WORKFLOWDIAGRAM_XPATH)); cfunction.sync(5);
		 * Actions act = new Actions(driver); act.dragAndDrop(dragStep,
		 * dropStep).build().perform();
		 */
	}

	public static boolean connectSteps() throws FindFailed, Exception {
		Thread.sleep(10000);
		boolean verified = false;
		String fromImg = "TS1_TC1_Flow_new_1280x768";
		String fromLineImg = "TS1_TC1_fromLineQuestion_new_1280x768";
		String toImg = "TS1_TC1_toFlowQuestion_new_1280x768";
		String toLineImg = "TS1_TC1_toLineQuestion_new_1280x1024";
		if (SikuliHelp.verifyImageExists(fromImg)) {
			SikuliHelp.connectStepsLine(fromImg, fromLineImg, toImg, toLineImg);
			Thread.sleep(5000);
			Actions actionTAB = new Actions(driver);
			actionTAB.sendKeys(Keys.TAB).build().perform();
			verified = true;
			return verified;
		}
		return verified;

		/*
		 * //String fromImg = "TS1_TC1_Flow_1280x1024"; //String fromImg =
		 * "TS1_TC1_Flow_CBT_1920x1024"; //String fromLineImg=
		 * "TS1_TC1_fromLineQuestion_1280x1024"; //String toLineImg=
		 * "TS1_TC1_toLineQuestion_1280x768"; //SikuliHelp.connectStepsLineNew(fromImg,
		 * fromLineImg,toImg,toLineImg);
		 */
	}

	public static void clickOnExtendedProperties() {
		cfunction.Commmon_Click("xpath", EXTENDEDPROPERTIES_XPATH);
	}

	public static void selectItemFromList(String itemName) {
		List<WebElement> rows = driver.findElements(By.xpath(LISTITEMNAME_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(itemName)) {
				row.click();
				break;
			}
		}
	}

	public static boolean verifyGroupTabOpens() {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(GROUP_HEADER_XPATH));
		if (rows.size() == 2) {
			verified = true;

		}
		return verified;
	}

	public static boolean verifyPreviewDialogBoxVisible() {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(PREVIEW_DIALOG_BOX_XPATH));
		if (rows.size() == 1) {
			verified = true;

		}
		return verified;
	}

	public static void selectWorkflowGroupFromList(String itemName) {
		List<WebElement> rows = driver.findElements(By.xpath(WORKFLOW_GROUP_LIST_XPATH));
		for (WebElement row : rows) {
			System.out.println(row.getText());
			if (row.getText().equalsIgnoreCase(itemName)) {
				row.click();
				break;
			}
		}
	}

	public static boolean validateUrlChange(String jobTemplateId) {
		boolean verified = false;
		String currentUrl = driver.getCurrentUrl();
		String[] urlArray = currentUrl.split("/");
		String id = urlArray[urlArray.length - 1];
		System.out.println("id : " + id);
		if (id.equalsIgnoreCase(jobTemplateId)) {
			verified = true;
		}
		softAssert.assertEquals(verified, true);
		return verified;
	}

	public static void clickTemplateFromeList(String templateName) throws Exception {
		List<WebElement> rows = driver
				.findElements(By.xpath("//tbody[contains(@class,'ui-table-tbody')]/div/div[1]/div"));
		for (WebElement item : rows) {
			System.out.println(item.getText());
			if (item.getText().equalsIgnoreCase(templateName)) {
				item.click();
				break;
			}
		}
	}

	public static int getAllJobsTemplateList() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(JOBTEMPLATELIST_XPATH));
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
		}
		return rows.size();
	}

	public static int getAllDiagramList() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(WORKFLOWDIAGRAMLIST_XPATH));
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
		}
		return rows.size();
	}

	public static boolean verifyCurrentStep(String currentStep) {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(CURRENT_STEP_INPUT_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem + "  --  " + currentStep);
		if (txtItem.equalsIgnoreCase(currentStep)) {
			verified = true;
			System.out.println(txtItem + " found in Search List");
		}
		return verified;
	}

	public static boolean verifyTabPanel(String tabName) {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(TABPANELNAME_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem + "  --  " + tabName);
		if (txtItem.equalsIgnoreCase(tabName)) {
			verified = true;
			System.out.println(txtItem + " found in Search List");
		}
		return verified;
	}

	public static boolean verifyGroupTabPanel() {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(GROUP_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem);
		if (txtItem.equalsIgnoreCase("Groups")) {
			verified = true;
			System.out.println(txtItem + " found in Search List");
		}
		return verified;
	}

	public static boolean verifyRoleTabPanel() {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(ROLE_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem);
		if (txtItem.equalsIgnoreCase("Roles")) {
			verified = true;
			System.out.println(txtItem + " found in Search List");
		}
		return verified;
	}

	public static boolean verifyEmailNotificationTabPanel() {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(EMAIL_NOTIFICATION_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem);
		if (txtItem.equalsIgnoreCase("Email Notifications")) {
			verified = true;
			System.out.println(txtItem + " found in Search List");
		}
		return verified;
	}

	public static boolean verifyRoleListHeader() {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(ROLE_LIST_HEADER_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem);
		if (txtItem.equalsIgnoreCase("Roles")) {
			verified = true;
			System.out.println(txtItem + " found in Search List");
		}
		return verified;
	}

	public static boolean verifyWorkflowPrivilegesListHeader() {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(ROLE_WORKFLOW_PRIVILEGES_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem);
		if (txtItem.equalsIgnoreCase("Roles")) {
			verified = true;
			System.out.println(txtItem + " found in Search List");
		}
		return verified;
	}

	public static boolean verifyCreateNewButton() throws Exception {
		cfunction.sync(10);
		return CommonFunction.elementIsDisplayed(CREATENEW_XPATH);
	}

	public static boolean verifyCreateButton() throws Exception {
		cfunction.sync(10);
		return CommonFunction.elementIsDisplayed(CREATE_XPATH);
	}

	public static boolean verifyCreateButtonDisable() throws Exception {
		cfunction.sync(10);
		return CommonFunction.elementIsDisplayed(CREATE_BUTTON_DISABLE_XPATH);
	}

	public static boolean verifyEditBtnIsEnabled() {
		boolean verified = false;
		WebElement element = driver.findElement(By.xpath(EDIT_XPATH));
		if (element.isEnabled()) {
			verified = true;
			System.out.println("Edit button enabled");
		} else {
			System.out.println("Edit button disabled");
		}
		return verified;
	}

	public static void clickOnSortBtn() {
		cfunction.sync(2);
		cfunction.Commmon_Click("xpath", SORTBUTTON_XPATH);
	}

	public static int getWorkFlowIndex(String itemName) {
		int index = -1;
		List<WebElement> rows = driver.findElements(By.xpath(WORKFLOWDIAGRAMITEMNAME_XPATH));
		for (int i = 1; i <= rows.size(); i++) {
			String header_xpath = WORKFLOWDIAGRAMITEMNAME_XPATH + "[" + i + "]";
			WebElement headerTitle = CommonFunction.getWebElement("xpath", header_xpath);
			if (headerTitle.getText().equalsIgnoreCase(itemName)) {
				System.out.println(headerTitle.getText());
				index = i - 1;
				break;
			}
		}
		return index;
	}

	public static void enterSearchTextInWorkflow(String txtValue) {
		cfunction.CommonTextBox_Input(WORKFLOWSEARCHTXTINPUT_XPATH, txtValue);
	}

	public static void enterSearchRoleTextInSearch(String txtValue) {
		cfunction.CommonTextBox_Input(ROLE_SEARCH_BOX_XPATH, txtValue);
	}

	public static void clearSearchTextFrmWorkflow(String txtValue) {
		cfunction.clearAndPressEnterKey(WORKFLOWSEARCHTXTINPUT_XPATH, txtValue);
	}

	public static boolean verifyAllDiagramsVisible(int count) throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(WORKFLOWDIAGRAMLIST_XPATH));
		System.out.println("Total Diagrams ==>" + count + " -- " + rows.size());
		if (rows.size() >= count)
			return true;
		return false;
	}

	public static void clickOnDataEditsSample() {
		cfunction.Commmon_Click("xpath", DATAEDITSSAMPLE_XPATH);
	}

	public static boolean verifyHeader(String diagramName) {
		boolean verified = false;
		WebElement header = driver.findElement(By.xpath(HEADER_XPATH));
		String diagram = header.getText();
		System.out.println(diagram + "  --  " + diagramName);
		if (diagram.equalsIgnoreCase(diagramName)) {
			verified = true;
			System.out.println(diagram + " found in header");
		}
		return verified;
	}

	// The header should display information for the first Workflow Diagram
	public static boolean verifyHeaderText(int i) {
		boolean verified = false;
		List<WebElement> elements = driver.findElements(By.xpath(WORKFLOWDIAGRAMITEMNAME_XPATH));
		String firstTxt = elements.get(i).getText();
		System.out.println(firstTxt);
		WebElement header = driver.findElement(By.xpath(HEADER_XPATH));
		String headerTxt = header.getText();
		System.out.println(headerTxt);
		if (headerTxt.contains(firstTxt)) {
			verified = true;
			System.out.println(firstTxt + " found in header");
		}
		// softAssert.assertEquals(firstTxt, headerTxt);
		return verified;
	}

	public static boolean verifyCanvas() {
		boolean verified = false;
		try {
			WebElement canvas = driver.findElement(By.xpath(WORKFLOWDIAGRAMCANVAS_XPATH));
			if (canvas != null) {
				verified = true;
				System.out.println("Diagram is present");
			}
		} catch (Exception ex) {
		}
		return verified;

	}

	public static void clickOnFilterButton() {
		cfunction.Commmon_Click("xpath", FILTERBUTTON_XPATH);
	}

	public static boolean verifyIfFilterHighlighted() throws Exception {
		boolean verified = false;
		// return cfunction.verifyIfHighlighted(PROFILEHIGLIGHTBUTTON_XPATH );
		WebElement element = driver.findElement(By.xpath(FILTERHIGLIGHTBUTTON_XPATH));
		if (element.isDisplayed()) {
			verified = true;
			System.out.println("Profile" + " is selected");
		} else {
			System.out.println("Profile" + " is not selected");
		}
		return verified;
	}

	public static boolean verifyJobTemplateHeader(String diagramName) {
		boolean verified = false;
		WebElement header = driver.findElement(By.xpath(JOBTEMPLATEHEADER_XPATH));
		String diagram = header.getText();
		System.out.println(diagram + "  --  " + diagramName);
		if (diagram.equalsIgnoreCase(diagramName)) {
			verified = true;
			System.out.println(diagram + " found in header");
		}
		return verified;
	}

	public static boolean verifyIfProfileHighlighted() throws Exception {
		boolean verified = false;
		// return cfunction.verifyIfHighlighted(PROFILEHIGLIGHTBUTTON_XPATH );
		WebElement element = driver.findElement(By.xpath(PROFILEHIGLIGHTBUTTON_XPATH));
		if (element.isDisplayed()) {
			verified = true;
			System.out.println("Profile" + " is selected");
		} else {
			System.out.println("Profile" + " is not selected");
		}
		return verified;
	}

	public static void clickOnAddExtendedPropertyBtn2() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", ADDEXTENDEDPROPERTYBTN2_XPATH);
	}

	public static boolean verifyJobTemplate(String jobTemplate) throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(JOBTEMPLATELIST_XPATH));
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
			if (rowsItem.contains(jobTemplate)) {
				verified = true;
				System.out.println(jobTemplate + " is visible");
				break;
			} else {
				System.out.println(jobTemplate + " is not visible");
			}
		}
		return verified;

	}

	public static boolean verifyManageTabOpen() {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath(MANAGEPAGE_XPATH));
			if (rows.size() > 0) {
				verified = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static boolean clickJobTemplateName(String jobTemplate) {
		int listcount = 1;
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(JOBTEMPLATELIST_XPATH));
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
			if (rowsItem.contains(jobTemplate)) {
				verified = true;
				System.out.println(jobTemplate + " is visible");
				cfunction.Commmon_Click("xpath", "(" + JOBTEMPLATELIST_XPATH + ")[" + listcount + "]");
				break;
			} else {
				System.out.println(jobTemplate + " is not visible");
			}
			listcount++;
		}
		return verified;

	}

	public static void hoverOnDiagramTitle() {
		cfunction.hoverByAction(DIAGRAMTITLE_XPATH);
	}

	public static void rearrange(String hover, String click) {
		cfunction.hoverByAction(hover);
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", click);
	}

	public static boolean verifyDiagramTitleToolTip(String tooltip) {
		return cfunction.verifyToolTip(DIAGRAMTITLE_XPATH, tooltip);
	}

	public static void hoverOnAdd() {
		cfunction.hoverByAction(ADD_XPATH);
	}

	public static boolean verifyAddToolTip(String tooltip) {
		return verifyDesignPageToolTip(ADD_XPATH, tooltip);
	}

	public static void hoverOnPlusSign() {
		cfunction.hoverByAction(PLUSSIGN_XPATH);

		// cfunction.CommmonJS_Hover_ShadowPath("document.querySelector(\"body >
		// wmx-root > wmx-dashboard > div > main > div > div.bannerSection.isEditMode >
		// div.bannerSection-right.ng-star-inserted > div > div.btnGroup >
		// calcite-button:nth-child(1)\").shadowRoot.querySelector(\"button\")");
	}

	public static void verifyZoomInToolTip(String tooltip) {
		// return verifyDesignPageToolTip(PLUSSIGN_XPATH, tooltip);
		try {
			WebElement tooltipElement = driver.findElement(By.xpath("TOOLTIP_XPATH"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean verifyToolTipTextPresent(String text) {
		try {
			cfunction.sync(5);
			List<WebElement> tooltip = driver.findElements(By.xpath(TOOLTIP_XPATH));
			System.out.println(tooltip.size());
	

			String toolTipText = cfunction.getElementText(TOOLTIP_XPATH);
			if (tooltip.size() == 1) {
				System.out.println(toolTipText);
				if (toolTipText.equalsIgnoreCase(text)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public static boolean verifyToolTipTextPresent1(String text) {
		try {
			cfunction.sync(5);
			List<WebElement> tooltip = driver.findElements(By.xpath("//div[contains(@class,'p-tooltip-text')]"));
			System.out.println(tooltip.size());

			String toolTipText = cfunction.getElementText("//div[contains(@class,'p-tooltip-text')]");
			if (tooltip.size() == 1) {
				System.out.println(toolTipText);
				if (toolTipText.equalsIgnoreCase(text)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public static int getActiveJobs() throws Exception {
		String Jobs = cfunction.getElementText(ACTIVEJOBS_XPATH);
		return Integer.parseInt(Jobs);
	}

	public static boolean verifyActiveJobs() {
		boolean verified = false;
		try {
			WebElement activeJobs = driver.findElement(By.xpath(ACTIVEJOBS_XPATH));
			if (activeJobs != null) {
				verified = true;
				System.out.println("Active jobs are present");
			}
		} catch (Exception ex) {
		}

		return verified;
	}

	public static void clickOnPlusSign() {
		cfunction.Commmon_Click("xpath", PLUSSIGN_XPATH);
	}

	public static void hoverOnMinusSign() {
		cfunction.hoverByAction(MINUSSIGN_XPATH);
	}

	public static boolean verifyZoomOutToolTip(String tooltip) {
		return verifyDesignPageToolTip(MINUSSIGN_XPATH, tooltip);
	}

	public static void clickOnMinusSign() {
		cfunction.Commmon_Click("xpath", MINUSSIGN_XPATH);
	}

	public static void hoverOnAlignDiagramHorizontally() {
		cfunction.hoverByAction(ALIGNDIAGRAMHORIZONTALLY_XPATH);
	}

	public static boolean verifyAlignDiagramHorizontallyToolTip(String tooltip) {
		return verifyDesignPageToolTip(ALIGNDIAGRAMHORIZONTALLY_XPATH, tooltip);
	}

	public static void clickOnAlignDiagramHorizontally() {
		cfunction.Commmon_Click("xpath", ALIGNDIAGRAMHORIZONTALLY_XPATH);
	}

	public static void hoverOnAlignDiagramVertically() {
		cfunction.hoverByAction(ALIGNDIAGRAMVERTICALLY_XPATH);
	}

	public static boolean verifyAlignDiagramVerticallyToolTip(String tooltip) {
		return verifyDesignPageToolTip(ALIGNDIAGRAMVERTICALLY_XPATH, tooltip);
	}

	public static void clickOnAlignDiagramVertically() {
		cfunction.Commmon_Click("xpath", ALIGNDIAGRAMVERTICALLY_XPATH);
	}

	public static void clickOnBack() {
		cfunction.Commmon_Click("xpath", BACK_XPATH);
	}

	public static void clickOnNo() {
		cfunction.Commmon_Click("xpath", NO_XPATH);
	}

	public static void hoverOnUndoButton() {
		cfunction.hoverByAction(UNDO_XPATH);
	}

	public static boolean verifyUndoToolTip(String tooltip) {
		return verifyDesignPageToolTip(UNDO_XPATH, tooltip);
	}

	public static void clickOnUndoButton() {
		cfunction.Commmon_Click("xpath", UNDO_XPATH);
	}

	public static void hoverOnRedoButton() {
		cfunction.hoverByAction(REDO_XPATH);
	}

	public static boolean verifyRedoToolTip(String tooltip) {
		return verifyDesignPageToolTip(REDO_XPATH, tooltip);
	}

	public static void clickOnRedoButton() {
		cfunction.Commmon_Click("xpath", REDO_XPATH);
	}

	public static void hoverOnPrintButton() {
		cfunction.hoverByAction(PRINT_XPATH);
	}

	public static boolean verifyPrintToolTip(String tooltip) {
		return verifyDesignPageToolTip(PRINT_XPATH, tooltip);
	}

	public static void clickOnPrintButton() {
		cfunction.Commmon_Click("xpath", PRINT_XPATH);
	}

	public static void hoverOnLeftLayoutButton() {
		cfunction.hoverByAction(LEFTLAYOUT_XPATH);
	}

	public static boolean verifyLeftLayoutToolTip(String tooltip) {
		return verifyDesignPageToolTip(LEFTLAYOUT_XPATH, tooltip);
	}

	public static void clickOnLeftLayoutButton() {
		cfunction.Commmon_Click("xpath", LEFTLAYOUT_XPATH);
	}

	public static void hoverOnRightLayoutButton() {
		cfunction.hoverByAction(RIGHTLAYOUT_XPATH);
	}

	public static boolean verifyRightLayoutToolTip(String tooltip) {
		return verifyDesignPageToolTip(RIGHTLAYOUT_XPATH, tooltip);
	}

	public static void clickOnRightLayoutButton() {
		cfunction.Commmon_Click("xpath", RIGHTLAYOUT_XPATH);
	}

	public static void clickOnDiagram(String diagram) {
		List<WebElement> rows = driver.findElements(By.xpath(WORKFLOWDIAGRAMITEMNAME_XPATH));
		for (int i = 1; i <= rows.size(); i++) {
			String header_xpath = WORKFLOWDIAGRAMITEMNAME_XPATH + "[" + i + "]";
			WebElement headerTitle = CommonFunction.getWebElement("xpath", header_xpath);
			if (headerTitle.getText().equalsIgnoreCase(diagram)) {
				System.out.println("Clicked ==>>" + headerTitle.getText());
				headerTitle.click();
				break;
			}
		}
	}

	public static boolean verifyWorkflowDiagramsPage() {
		boolean verified = false;
		try {
			WebElement workflowDiagram = driver.findElement(By.xpath(WORKFLOWDIAGRAMSLIST_XPATH));
			if (workflowDiagram != null) {
				verified = true;
				System.out.println("Workflow Diagram Page is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Workflow Diagram Page is NOT present in canvas");
		}
		return verified;
	}

	public static boolean verifyOpendWorkflowDiagramsBanner() {
		boolean verified = false;
		try {
			WebElement workflowDiagram = driver.findElement(By.xpath(WORKFLOWDIAGRAMSBANNER_XPATH));
			if (workflowDiagram != null) {
				verified = true;
				System.out.println("Workflow Diagram is opened");
			}
		} catch (Exception ex) {
			System.out.println("Workflow Diagram is not opened");
		}
		return verified;
	}

	public static boolean verifyEditDomainDialogOpen() {
		boolean verified = false;
		try {
			WebElement workflowDiagram = driver.findElement(By.xpath(EDIT_DOMAIN_DIALOG_HEADER_XPATH));
			if (workflowDiagram != null) {
				verified = true;
				System.out.println("Dialog is opened");
			}
		} catch (Exception ex) {
			System.out.println("Dialog is not opened");
		}
		return verified;
	}

	public static boolean verifyStepLibrary() {
		boolean verified = false;
		try {
			WebElement stepLib = driver.findElement(By.xpath(STEPLIBRARYLEFTSIDEPANELTRIANGLE_XPATH));
			if (stepLib != null) {
				verified = true;
				System.out.println("Step Library is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Step Library is NOT present in canvas");
		}
		return verified;
	}

	public static boolean verifyStepLibraryPanel() {
		boolean verified = false;
		try {
			WebElement stepLib = driver.findElement(By.xpath(STEPLIBRARYLEFTSIDEPANEL_XPATH_COLLAPSE));
			if (stepLib != null) {
				verified = true;
				System.out.println("Step Library is NOT present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Step Library is  present in canvas");
		}
		return verified;
	}

	public static boolean verifyDiagramEditPage() throws Exception {
		boolean verified = false;
		try {
			WebElement editPage = driver.findElement(By.xpath(DIAGRAMEDITPAGE_XPATH));
			if (editPage != null) {
				verified = true;
				System.out.println("Diagram Edit Page is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Diagram Edit Page is NOT present in canvas");
		}
		return verified;
	}

	public static boolean verifyDiagramSettings() throws Exception {
		boolean verified = false;
		try {
			WebElement diagramSetting = driver.findElement(By.xpath(DIAGRAMSETTINGRIGHTSIDEPANELTRIANGLE_XPATH));
			if (diagramSetting != null) {
				verified = true;
				System.out.println("Diagram Settings is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Diagram Settings is NOT present in canvas");
		}
		return verified;
	}

	public static boolean verifyDiagramSettingsPanel() throws Exception {
		boolean verified = false;
		try {
			WebElement diagramSetting = driver.findElement(By.xpath(DIAGRAMSETTINGRIGHTSIDEPANEL_XPATH));
			if (diagramSetting != null) {
				verified = true;
				System.out.println("Diagram Settings is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Diagram Settings is NOT present in canvas");
		}
		return verified;
	}

	public static void dragStepToCanvas(String step, String canvasStep) throws Exception {
		boolean overwriteStep = true;
		cfunction.sync(25);
		step = step.replaceAll(" ", "") + "_1280x768";
		canvasStep = canvasStep.replaceAll(" ", "").replaceAll("/", "") + "_1280x768";
		SikuliHelp.dragndropSikuli(step, canvasStep, overwriteStep);
	}

	public static boolean verifyConfirmDialog() throws Exception {
		return CommonFunction.elementIsDisplayed(CONFIRMDIALOG_XPATH);
	}

	public static void clickCancelOnConfirmDialog() throws Exception {
		cfunction.Commmon_Click("xpath", CONFIRMDIALOGCANCEL_XPATH);
	}

	public static void clickYesOnConfirmDialog() throws Exception {
		cfunction.Commmon_Click("xpath", CONFIRMDIALOGYES_XPATH);
	}

	public static boolean verifyURLSection(String uRLText) throws Exception {
		boolean verified = false;
		cfunction.Commmon_Click("xpath", "(//span[@class='p-tabview-title ng-star-inserted'])[2]");
		cfunction.sync(2);
		String urlText = cfunction.getElementAttribute(URLTEXT_XPATH, "value");
		System.out.println(urlText);
		if (urlText.equalsIgnoreCase(uRLText)) {
			verified = true;
		}
		return verified;
	}

	public static String getStepName() throws Exception {
		cfunction.Commmon_Click("xpath", "(//span[@class='p-tabview-title ng-star-inserted'])[1]");
		return cfunction.getElementAttribute(STEPNAME_XPATH, "value");
	}

	public static String getStepDesc() throws Exception {
		cfunction.Commmon_Click("xpath", "(//span[@class='p-tabview-title ng-star-inserted'])[4]");
		return cfunction.getElementAttribute(STEPDESC_XPATH, "value");
	}

	public static boolean verifyStepName(String stepName) throws Exception {
		boolean verified = false;
		String name = cfunction.getElementAttribute(STEPNAME_XPATH, "value");
		if (name.equalsIgnoreCase(stepName))
			verified = true;
		return verified;
	}

	public static boolean verifyStepDesc(String stepDesc) throws Exception {
		boolean verified = false;
		String desc = cfunction.getElementAttribute(STEPDESC_XPATH, "value");
		System.out.println(stepDesc + "-->>" + desc);
		if (desc.equalsIgnoreCase(stepDesc))
			verified = true;
		return verified;
	}

	public static void clickOnStepDetailAboutTab() throws Exception {
		cfunction.Commmon_Click("xpath", ABOUT_XPATH);
	}

	public static boolean verifyArgumentSection() {
		return CommonFunction.elementIsDisplayed(ARGUMENTSECTION_XPATH);
	}

	public static int getDiagramZoomLevel() throws Exception {
		int zoomLevel = 0;
		String zoom = cfunction.getElementText(ZOOM_XPATH);
		if (!zoom.isEmpty()) {
			zoom = zoom.replace("%", "");
			zoomLevel = Integer.parseInt(zoom);
			System.out.println("Current Zoom ==>> " + zoomLevel);
		}
		return zoomLevel;
	}

	public static boolean verifyHorizontalVerticalAutoAlignOption() throws Exception {
		return CommonFunction.elementIsDisplayed(HORIZONTALVERTICALAUTOALIGN_XPATH);
	}

	public static void clickOnHorizontalAutoAlign() throws Exception {
		cfunction.Commmon_Click("xpath", HORIZONTALAUTOALIGN_XPATH);
	}

	public static void clickOnVerticalAutoAlign() throws Exception {
		cfunction.Commmon_Click("xpath", VERTICALAUTOALIGN_XPATH);
	}

	public static boolean verifyDiagramAlignment(String alignment) throws Exception {
		boolean verified = false;
		WebElement charts = CommonFunction.getWebElement("xpath", WORKFLOWDIAGRAMCANVAS_XPATH);
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,
				charts);
		BufferedImage actualDiagram = screenshot.getImage();

		// Uncomment and run the test once to save the snapshots of the diagram in Input
		// Folder on the test machine
		ImageIO.write(actualDiagram, "PNG", new File(
				System.getProperty("user.dir") + "/Images/Input/TS13_Diagram_" + alignment + "_" + browser + ".png"));

		String path = System.getProperty("user.dir") + "/Images/Input/TS13_Diagram_" + alignment + "_" + browser
				+ ".png";
		BufferedImage expectedDiagram = ImageIO.read(new File(path));

		cfunction.sync(2);

		ImageDiff diff = new ImageDiffer().makeDiff(actualDiagram, expectedDiagram);
		if (diff.hasDiff())
			verified = false;
		else
			verified = true;
		return verified;
	}

	public static boolean verifyDiagramAlignmentSikuli(String alignment) {
		boolean verified = false;
		try {
			String imgName = "TS13_Diagram_" + alignment;
			if (SikuliHelp.verifyImageExists(imgName))
				verified = true;
			else
				verified = false;
		} catch (Exception e) {
		}
		return verified;
	}

	public static boolean verifyDesignPageToolTip(String xpath, String tooltip) {
		try {
			WebElement element = CommonFunction.getWebElement("xpath", xpath);
			String title = element.getAttribute("ptooltip");
			if (title.equalsIgnoreCase(tooltip)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public static void clickOnWorkflowDiagram() throws Exception {
		cfunction.Commmon_Click("xpath", WORKFLOWDIAGRAM_XPATH);
	}

	public static boolean verifyStepDetailsHeader(String title) {
		boolean verified = false;
		WebElement header = driver.findElement(By.xpath(STEPDETAILHEADER_XPATH));
		String titelValue = header.getText();
		System.out.println(titelValue + "  --  " + title);
		if (titelValue.equalsIgnoreCase(title)) {
			verified = true;
			System.out.println(titelValue + " found in header");
		}
		return verified;
	}

	public static void clickOnAutomaticallyexecutesBox(int i) throws Exception {
		cfunction.Commmon_Click("xpath", EXECUTESCHECKBOX_XPATH + "[" + i + "]");
	}

	public static void clickOnAutomaticallyexecutesBox1() throws Exception {
		cfunction.Commmon_Click("xpath", "(//div[@class='row-item-layout'])[2]/p-radiobutton/div");
	}

	public static void clickOnOptioalCheckBox() throws Exception {
		cfunction.Commmon_Click("xpath", OPTIONAL_CHECKBOX_XPATH);
	}

	public static void clickOnStepDetailOptionTab() throws Exception {
		cfunction.Commmon_Click("xpath", OPTION_XPATH);
	}

	public static void clickOnRunOnScheduleExecutesBox() throws Exception {
		cfunction.Commmon_Click("xpath", EXECUTESCHECKBOX_XPATH + "[3]");
	}

	public static void clickOnWaitAPeriodOfTimeRadioBtn() throws Exception {
		cfunction.Commmon_Click("xpath", RUN_ON_SCHEDULE_SUB_RADIO_BTN_XPATH + "[1]");
	}

	public static void clickOnWaitUntilASpecificTimeRadioBtn() throws Exception {
		cfunction.Commmon_Click("xpath", RUN_ON_SCHEDULE_SUB_RADIO_BTN_XPATH + "[2]");
	}

	public static void clickOnWaitUntilAnExactTimeRadioBtn() throws Exception {
		cfunction.Commmon_Click("xpath", RUN_ON_SCHEDULE_SUB_RADIO_BTN_XPATH + "[3]");
	}

	public static void clickOnoffsetInput() throws Exception {
		cfunction.Commmon_Click("xpath", WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[1]");
	}

	public static void enterMonthInput(int index, String text) throws Exception {
		/*
		 * WebElement txtBox = (new WebDriverWait(driver, 20))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH+"[1]"))); cfunction.sync(10);
		 * txtBox.clear();
		 */
		cfunction.CommonTextBox_Input1(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[" + index + "]", text);
	}

	public static void enterTimeInput(String text) throws Exception {
		/*
		 * WebElement txtBox = (new WebDriverWait(driver, 20))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(TIME_INPUT_XPATH)));
		 * cfunction.sync(10); txtBox.clear();
		 * cfunction.CommonTextBox_Input(TIME_INPUT_XPATH,text);
		 */
		
		cfunction.CommonTextBox_Input1(TIME_INPUT_XPATH, text);
		cfunction.sync(7);
		cfunction.Commmon_Click("xpath", "//span[@class='p-button-icon pi pi-clock']");
	}

	public static void enterDayInput(String text) throws Exception {
		cfunction.CommonTextBox_Input(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[2]", text);
	}

	public static void enterArcadeInput(String text) throws Exception {
		cfunction.CommonTextBox_Input1(ARCADE_EXPRESSION_INPUTS_XPATH, text);
	}

	public static void enterHoursInput(String text) throws Exception {
		cfunction.CommonTextBox_Input(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[3]", text);
	}

	public static void enterMinuteInput(String text) throws Exception {
		cfunction.CommonTextBox_Input(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[4]", text);
	}

	public static void enterOffsetInput(String text) throws Exception {
		cfunction.CommonTextBox_Input(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[5]", text);
	}

	public static boolean verifyInputValueOfMonth(String attribute) throws Exception {
		boolean verified = false;
		/*
		 * //String
		 * Value=cfunction.getElementAttribute(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH+"[1]",
		 * attribute); String
		 * Value=cfunction.getElementAttribute(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH+"[1]",
		 * "aria-valuenow");
		 */
		String xpath = WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[1]";
		WebElement item = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		// return element.getAttribute(attribute);
		String menuItem = item.getText();
		String menuItem2 = item.getAttribute("aria-valumin");
		String menuItem3 = item.getAttribute("aria-valuemax");
		String menuItem4 = item.getAttribute("aria-valuenow");
		String menuItem5 = item.getAttribute("innerText");
		String menuItem6 = item.getAttribute("outerText");
		System.out.println("menuItem: " + menuItem);
		System.out.println("menuItem2: " + menuItem2);
		System.out.println("menuItem3: " + menuItem3);
		System.out.println("menuItem4: " + menuItem4);
		/*
		 * System.out.println("menuItem5: "+menuItem5);
		 * System.out.println("menuItem6: "+menuItem6);
		 */
		if (attribute.equalsIgnoreCase(menuItem4)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static boolean verifyInputValueOfDay(String attribute) throws Exception {
		boolean verified = false;
		String Value = cfunction.getElementAttribute(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[2]", "aria-valuenow");
		if (attribute.equalsIgnoreCase(Value)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static boolean verifyInputValueOfHours(String attribute) throws Exception {
		boolean verified = false;
		String Value = cfunction.getElementAttribute(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[3]", "aria-valuenow");
		if (attribute.equalsIgnoreCase(Value)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static void selectTimeFromDropDown(String input) {
		cfunction.Commmon_Click("XPATH", TIME_DROPDOWN_BTN_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(TIME_DROPDOWN_OPTION_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(input)) {
				row.click();
				break;
			}
		}
	}

	public static void selectDayFromDropDown(String input) {
		cfunction.Commmon_Click("XPATH", DAY_DROPDOWN_BTN_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(TIME_DROPDOWN_OPTION_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(input)) {
				row.click();
				break;
			}
		}
	}

	public static boolean verifyInputValueOfMinute(String attribute) throws Exception {
		boolean verified = false;
		String Value = cfunction.getElementAttribute(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[4]", "aria-valuenow");
		if (attribute.equalsIgnoreCase(Value)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static boolean verifyInputValueOfOffest(String attribute) throws Exception {
		boolean verified = false;
		String Value = cfunction.getElementAttribute(WAIT_A_PERIOD_OF_TIME_INPUTS_XPATH + "[5]", "aria-valuenow");
		if (attribute.equalsIgnoreCase(Value)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static boolean verifyRunOnSceduleExpands() {
		boolean verified = false;
		try {
			WebElement element = driver.findElement(By.xpath(RUN_ON_SCHEDULE_EXPAND_WINDOW_XPATH));
			if (element != null) {
				verified = true;
				System.out.println("Window visible");
			}
		} catch (Exception ex) {
			System.out.println("Window Not Visible");
		}
		return verified;
	}

	public static boolean verifyRightPanel(String tabName) {
		boolean verified = false;
		WebElement headerElement = driver.findElement(By.xpath(RIGHTPANELNAME_XPATH));
		String txtItem = headerElement.getText();
		System.out.println(txtItem + "  --  " + tabName);
		if (txtItem.equalsIgnoreCase(tabName)) {
			verified = true;
			System.out.println(txtItem + " found in Search List");
		}
		return verified;
	}

	public static void zoomToLevel(int level) {
		try {
			int zoom = getDiagramZoomLevel();
			while (zoom > level) {
				clickOnMinusSign();
				cfunction.sync(2);
				zoom = getDiagramZoomLevel();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean verifyShapeDropdownMenu() throws Exception {
		return CommonFunction.elementIsDisplayed(SHAPEDROPDOWNMENU_XPATH);
	}

	public static void selectShapeFromDropdown(String shape) throws Exception {
		List<WebElement> menues = driver.findElements(By.xpath(SHAPEDROPDOWNMENULABEL_XPATH));
		for (WebElement item : menues) {
			if (item.getText().equalsIgnoreCase(shape)) {
				item.click();
				break;
			}
		}
	}

	public static boolean verifySelectedShape(String shape) throws Exception {
		String selectedShape = cfunction.getElementText(SHAPEDROPDOWNMENULABEL_XPATH);
		if (selectedShape.equalsIgnoreCase(shape))
			return true;
		return false;
	}

	public static void clickOnRedColor() {
		cfunction.Commmon_Click("xpath", COLORTILE_XPATH);
	}

	public static boolean verifyIfColorHighlighted() throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			String imgName = "TS14_RedTileHighlighted";
			if (SikuliHelp.verifyImageExists(imgName))
				return true;
			else
				return false;
		} else
			return cfunction.verifyIfHighlighted(REDCOLOR_XPATH, "border");
	}

	public static void hoverOnColorWheel() {
		cfunction.hoverByAction(COLORWHEEL_XPATH);
	}

	public static void clickOnColorWheel() {
		cfunction.Commmon_Click("xpath", COLORWHEEL_XPATH);
	}

	public static boolean verifyColorPicker() throws Exception {
		return CommonFunction.elementIsDisplayed(COLORPICKER_XPATH);
	}

	public static void selectColorFromPicker() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = CommonFunction.getWebElement("xpath", COLORPICKERCURSOR_XPATH);
		js.executeScript("arguments[0].setAttribute('style', 'top:50px;left:100px')", element);
		cfunction.sync(2);
		element.click();
	}

	public static boolean verifyPencilIcon() {
		return CommonFunction.elementIsDisplayed(PENCILICON_XPATH);
	}

	public static void clickOnStyleTab() {
		cfunction.Commmon_Click("xpath", STYLE_XPATH);
	}

	public static boolean verifyShapeColor() {
		boolean verified = false;
		try {
			WebElement element = CommonFunction.getWebElement("xpath", SHAPECOLOR_XPATH + "[3]");
			String text = element.getText();
			if (text.equalsIgnoreCase("shape")) {
				element = CommonFunction.getWebElement("xpath", SHAPECOLOR_XPATH + "[4]");
				text = element.getText();
				if (text.equalsIgnoreCase("color")) {
					verified = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return verified;
	}

	public static void clickOnShapeDropDown() {
		cfunction.Commmon_Click("xpath", SHAPEDROPDOWN_XPATH);
	}

	public static boolean verifyNewJobTempate() {
		boolean verified = false;
		try {
			WebElement element = driver.findElement(By.xpath(NEWJOBTEMPLATE_XPATH));
			if (element != null) {
				verified = true;
				System.out.println("New Job Template is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("New Job Template is NOT present in canvas");
		}
		return verified;
	}

	public static boolean verifyState(String statusText) throws Exception {
		return cfunction.verifyElementText(STATUS_XPATH, statusText);
	}

	public static boolean verifyDiagramIsDisplayed() {
		boolean verified = false;
		try {
			WebElement element = driver.findElement(By.xpath(DIAGRAMPREVIEW_XPATH));
			if (element.isDisplayed()) {
				verified = true;
				System.out.println("Diagram Preview is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Diagram is NOT present in canvas");
		}
		return verified;
	}
	
	
	

	public static boolean verifyExtendedProperties() {
		boolean verified = false;
		try {
			WebElement element = driver.findElement(By.xpath(EXTENDED_XPATH));
			if (element != null) {
				verified = true;
				System.out.println("Extended Properties is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("Extended Properties is NOT present in canvas");
		}
		return verified;
	}

	public static boolean verifyNewTable() {
		boolean verified = false;
		try {
			WebElement element = driver.findElement(By.xpath(NEWTABLE_XPATH));
			if (element != null) {
				verified = true;
				System.out.println("New Table Button is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("New Table Button is NOT present in canvas");
		}
		return verified;
	}

	public static void clickOnNewTable() {
		cfunction.Commmon_Click("xpath", NEWTABLE_XPATH);
	}

	public static void clickOnNewTable1() {
		cfunction.Commmon_Click("xpath", NEWTABLE_XPATH1);
	}

	public static boolean verifyNewExtendedTableAdded() {
		boolean verified = false;
		try {
			WebElement element = driver.findElement(By.xpath(NEWEXTENDEDTABLE_XPATH));
			if (element != null) {
				verified = true;
				System.out.println("New Table Button is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("New Table Button is NOT present in canvas");
		}
		return verified;
	}

	public static boolean verifyNewExtendedTable2Added() {
		boolean verified = false;
		try {
			WebElement element = driver.findElement(By.xpath(NEWEXTENDEDTABLE_XPATH + "[2]"));
			if (element != null) {
				verified = true;
				System.out.println("New Table Button is present in canvas");
			}
		} catch (Exception ex) {
			System.out.println("New Table Button is NOT present in canvas");
		}
		return verified;
	}

	public static void enterTable2Name(String name) {
		cfunction.CommonTextBox_Input(NEWTABLE_2_NAME_XPATH, name);
	}

	public static void enterTableName(String name) {
		cfunction.CommonTextBox_Input(NEWTABLENAME_XPATH, name);
	}

	public static void enterTableAlias(String alias) {
		cfunction.CommonTextBox_Input(NEWTABLEALIAS_XPATH, alias);
	}

	public static void clickOnAddExtendedProperty() {
		cfunction.Commmon_Click("xpath", ADDEXTENDEDPROPERTYBTN_XPATH);
	}

	public static boolean verifyNewExtendedPropertyAdded(int count) {
		boolean verified = false;
		try {
			List<WebElement> rows = driver.findElements(By.xpath(NEWEXTENDEDPROPERTY_XPATH));
			if (rows.size() == count) {
				verified = true;
			}
			System.out.println("Total ExtendedProperties -->" + rows.size());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static void enterExtendedPropertyName(int index, String name) {
		String xpath = EXTPROPERTYNAME_XPATH + "[" + index + "]";
		cfunction.CommonTextBox_Input(xpath, name);
	}

	public static void enterExtendedPropertyAlias(int index, String alias) {
		String xpath = EXTPROPERTYALIAS_XPATH + "[" + index + "]";
		cfunction.CommonTextBox_Input(xpath, alias);
	}

	public static void selectExtendedPropertyType(int index, String type) {
		try {
			String xpath = EXTPROPERTYTYPEDD_XPATH + "[" + index + "]";
			cfunction.Commmon_Click("xpath", xpath);
			cfunction.sync(2);
			List<WebElement> rows = driver.findElements(By.xpath(EXTPROPERTYTYPE_XPATH));
			for (WebElement option : rows) {
				if (option.getText().equalsIgnoreCase(type)) {
					option.click();
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean verifyFieldLength(String length) throws Exception {
		return cfunction.verifyElementText(FIELDLENGTH_XPATH, length);
	}

	public static void enterDefaultValue(int index, String value) {
		String xpath = DEFAULTVALUE_XPATH + "[" + index + "]";
		cfunction.CommonTextBox_Input(xpath, value);
	}

	public static boolean verifyDefaultValue(int index, String value) throws Exception {
		Boolean verified = false;
		try {
			String xpath = DEFAULTVALUE_XPATH + "[" + index + "]";
			boolean check;
			if (check = cfunction.verifyElementText(xpath, value)) {
				verified = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;

	}

	public static void dragAndDrop(String step, String canvasStep) throws Exception {
		boolean overwriteStep = true;
		step = step.replaceAll(" ", "") + "_1280x768";
		canvasStep = canvasStep.replaceAll(" ", "").replaceAll("/", "") + "_1280x768";
		SikuliHelp.dragndropSikuli(step, canvasStep, overwriteStep);
	}

	public static void clickOnPrintVisible() {
		cfunction.Commmon_Click("xpath", DIAGRAM_PRINT_VISIBLE_XPATH);
	}

	public static void clickOnPrintBtn() {
		cfunction.Commmon_Click("xpath", DIAGRAM_PRINT_BTN_XPATH);
	}

	public static void clickOnPrintAll() {
		cfunction.Commmon_Click("xpath", DIAGRAM_PRINT_ALL_XPATH);
	}

	public static void hoverOnDiagramPrintBtn() {
		cfunction.hoverByAction(DIAGRAM_PRINT_BTN_XPATH);
	}

	public static boolean verifyPrintBtnToolTip(String tooltip) {
		// return cfunction.verifyToolTip(ERROR_ICON_XPATH, tooltip);
		try {
			WebElement element = CommonFunction.getWebElement("xpath", DIAGRAM_PRINT_BTN_XPATH);
			String title = element.getAttribute("ptooltip");
			System.out.println(title);
			if (title.equalsIgnoreCase(tooltip)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public static void clickOnAddNewJobProp() {
		cfunction.Commmon_Click("xpath", ADD_NEW_JOB_PROP_XPATH);
	}

	public static void enterTable2Alias(String alias) {
		cfunction.CommonTextBox_Input(NEWTABLE_2_ALIAS_XPATH, alias);
	}

	public static void enterJobPropInput(int index, String input) {
		cfunction.CommonTextBox_Input(JOB_PROP_INPUT_XPATH + "[" + index + "]", input);
	}

	public static void enterFieldLength(int index, String value) {
		String xpath = FIELDLENGTH_XPATH + "[" + index + "]";
		cfunction.CommonTextBox_Input(xpath, value);
	}

	public static boolean verifyError_Tooltip(int index, String tooltip) {
		boolean verified = true;
		try {
			cfunction.hoverByAction(ERROR_XPATH + "[" + index + "]");
			cfunction.sync(5);
			verifyToolTipTextPresent(tooltip);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	public static boolean verifyRoleNameError_Tooltip() {
		boolean verified = false;
		try {
			String msg = "Missing required value";

			cfunction.hoverByAction("//calcite-icon[contains(@class,'icon-error icon-error-rightMargin')]");
			if (verifyToolTipTextPresent1(msg)) {
				verified = true;
				System.out.println(msg + "visible");
			} else {
				System.out.println(msg + "Not visible");
			}
			// return verified;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}

	/*
	 * WebElement element =
	 * driver.findElement(By.xpath(ROLE_NAME_VALIDATION_XPATH)); if
	 * (element.getAttribute("ptooltip").equalsIgnoreCase("Missing required value"))
	 * { verified = true; } } catch (Exception ex) { ex.printStackTrace(); } return
	 * verified; }
	 */

	public static void selectBooleanValueType(int index, String value) {
		try {
			String xpath = NEWEXTENDEDPROPERTY_XPATH + "[" + index + "]//p-dropdown[@formcontrolname='defaultValue']";
			cfunction.Commmon_Click("xpath", xpath);
			cfunction.sync(2);
			List<WebElement> rows = driver.findElements(By.xpath(EXTPROPERTYTYPE_XPATH));
			for (WebElement option : rows) {
				if (option.getText().equalsIgnoreCase(value)) {
					System.out.println("True or False==" + option.getText());
					option.click();
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void selectCurrentDate(int index) {
		String calXpath = "(" + NEWEXTENDEDPROPERTY_XPATH + ")[" + index + "]//p-calendar//button";
		WebElement element = driver.findElement(By.xpath(calXpath));
		element.click();

		/*
		 * cfunction.sync(2); cfunction.ScrollToElement(CURRENTDATE_XPATH);
		 * cfunction.Commmon_Click("xpath", CURRENTDATE_XPATH);
		 */
	}

	public static boolean verifySaveDialog(String title) throws Exception {
		return cfunction.verifyElementText(SAVEDIALOGTITLE_XPATH, title);
	}

	public static void ClickOnSaveDialog_SaveBtn() throws Exception {
		cfunction.Commmon_Click("xpath", SAVEDIALOGSAVEBTN_XPATH);
	}

	public static boolean verifyProgressBar(String msg) throws Exception {
		if (CommonFunction.elementIsDisplayed(PROGRESSBARMSG_XPATH))
			return true;
		return false;
		// return cfunction.(PROGRESSBARMSG_XPATH, msg);
	}

	public static boolean verifySavedTemplate(String[][] extendedProperties) throws Exception {
		HomePage.clickOnDesign();
		Design.clickOnJobTemplatesIcon();
		Design.verifyJobTemplate(jobTemplateName);
		boolean check = Design.verifyJobTemplate(jobTemplateName);
		if (check) {
			Design.clickJobTemplateName(jobTemplateName);
			// CommonFunction.logStatus("PASS", msg);
		}
		Design.clickOnExtendedProperties();
		boolean verified = true;
		int index = 1;
		try {
			for (String[] extProp : extendedProperties) {
				// verify name
				String name = cfunction.getElementText(PROPNAMELABEL_XPATH + "[" + index + "]");
				// String name =
				// cfunction.getElementText("//span[contains(@class,'t-propertyNameLabel
				// ng-star-inserted')]" + "[" + index + "]");

				if (!name.equalsIgnoreCase(extProp[0]))
					verified = false;
				// verify alias
				String alias = cfunction.getElementAttribute(EXTPROPERTYALIAS_XPATH + "[" + index + "]", "value");
				if (!alias.equalsIgnoreCase(extProp[1]))
					verified = false;
				// verify type
				String type = cfunction.getElementText(PROPTYPELABEL_XPATH + "[" + index + "]");
				if (!type.equalsIgnoreCase(extProp[2]))
					verified = false;
				// verify length
				if (!extProp[3].isEmpty()) {
					String length = cfunction.getElementText(PROPLENGTHLABEL_XPATH + "[" + index + "]");
					if (!length.equalsIgnoreCase(extProp[3]))
						verified = false;
				}
				// verify value
				String value = "";
				if (type.equalsIgnoreCase("string") || type.equalsIgnoreCase("integer")) {
					value = cfunction.getElementAttribute(DEFAULTVALUE_XPATH + "[" + 5 + "]", "value");

				} else if (type.equalsIgnoreCase("boolean")) {
					String xpath = "(" + NEWEXTENDEDPROPERTY_XPATH + ")[" + index
							+ "]//p-dropdown[@formcontrolname='defaultValue']";
					value = cfunction.getElementText(xpath);
					String strMain = value;
					String[] arrSplit = strMain.split("\n");
					for (int i = 0; i < arrSplit.length; i++) {
						System.out.println(arrSplit[i]);
						value = arrSplit[0];
					}

				} else {
					String calXpath = "(" + NEWEXTENDEDPROPERTY_XPATH + ")[" + index
							+ "]/span/span/span/span[5]/p-calendar/span/input";
					value = cfunction.getElementAttribute(calXpath, "value");
				}
				if (!value.equalsIgnoreCase(extProp[4]))
					verified = false;
				index++;
			}
		} catch (Exception ex) {
			verified = false;
			ex.printStackTrace();
		}
		return verified;
	}

	// New Methods By Kapil (19-09-19)
	public static boolean verifyQuestion(String text) throws Exception {
		boolean verified = false;
		String name = cfunction.getElementAttribute(QUESTION_XPATH, "value");
		if (name.equalsIgnoreCase(text))
			verified = true;
		return verified;
	}

	public static boolean verifyAnswerYes(String answer, String code) throws Exception {
		boolean verified = false;
		String answertext = cfunction.getElementAttribute((ANSWER_XPATH + "[1]"), "value");
		String resultcode = cfunction.getElementAttribute((RETURNCODE + "[1]"), "value");
		if (answertext.equalsIgnoreCase(answer) && resultcode.equalsIgnoreCase(code))
			verified = true;
		return verified;
	}

	public static boolean verifyAnswerNo(String answer, String code) throws Exception {
		boolean verified = false;
		String answertext = cfunction.getElementAttribute((ANSWER_XPATH + "[2]"), "value");
		String resultcode = cfunction.getElementAttribute((RETURNCODE + "[2]"), "value");
		if (answertext.equalsIgnoreCase(answer) && resultcode.equalsIgnoreCase(code))
			verified = true;
		return verified;
	}

	public static boolean verifyNewResponseReturnCode(String code) throws Exception {
		boolean verified = false;
		String name = cfunction.getElementAttribute(NEWRESPONSERETURNCODE_XPATH, "value");
		if (name.equalsIgnoreCase(code))
			verified = true;
		return verified;
	}

	public static void clickOnAddNewResponseBtn() {
		cfunction.Commmon_Click("xpath", ADDNEWRESPONSE_XPATH);
	}

	public static boolean verifyAnswerSetAppears() throws Exception {
		cfunction.sync(10);
		if (CommonFunction.elementIsDisplayed(NEWANSWERSET_XPATH))
			return true;
		return false;
	}

	public static void enterTextInNewResponse(String text) {
		cfunction.sync(10);
		cfunction.CommonTextBox_Input(NEWRESPONSEANSWER_XPATH, text);
	}

	public static void deleteTopResponse() {
		/*
		 * WebElement element = CommonFunction.getWebElement("xpath",
		 * DELETERESPONSE_XPATH); cfunction.hoverOnElement(element); element.click();
		 */
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(DELETERESPONSE_XPATH)));
	}

	public static boolean verifyBlankFieldIndicateRed() throws Exception {
		if (cfunction.verifyIfHighlighted1(NEWRESPONSEANSWER_XPATH, "color", "#d83020"))
			return true;
		return false;

	}

	public static boolean verifyFieldOutlineDisappears() throws Exception {
		if (driver.findElements(By.xpath(MISSING_VALUE_ICON_XPATH)).size() == 0) {
			System.out.println("Element is Present");
			return true;
		} else {
			System.out.println("Element is Absent");
			return false;
		}
	}

	public static boolean verifyArgumentList() throws Exception {
		List<WebElement> Argumentlist = driver.findElements(By.xpath(ARGUMENTANSWER));

		if (Argumentlist.size() < 3)
			return true;
		return false;
	}

	public static void verifyPathDetailsPanel() throws Exception {
		cfunction.sync(10);
		CommonFunction.elementIsDisplayed(PATHDETAILSPANEL_XPATH);
	}

	public static void enterValueInReturnCode() throws Exception {
		cfunction.sync(10);
		cfunction.CommonTextBox_Input(RETURNCODEINPUT, "1");
	}

	public static void verifyStepDetailsPanel() throws Exception {
		cfunction.sync(10);
		CommonFunction.elementIsDisplayed(STEP_DETAIL_PANEL_XPATH);
	}

	public static void enterEmail(String searchText) {
		cfunction.Commmon_Click("xpath", EMAILINPUT_XPATH);
		cfunction.sync(2);
		cfunction.CommonTextBox_Input(EMAILINPUT_XPATH, searchText);
	}

	public static void enterRoleName(String searchText) {
		cfunction.CommonTextBox_Input(ROLE_NAME_XPATH, searchText);
	}

	public static void enterSubject(String searchText) {
		cfunction.Commmon_Click("xpath", SUBJECTINPUT_XPATH);
		cfunction.sync(2);
		cfunction.CommonTextBox_Input(SUBJECTINPUT_XPATH, searchText);
	}

	public static void enterBody(String searchText) {
		cfunction.Commmon_Click("xpath", BODYINPUT_XPATH);
		cfunction.sync(2);
		cfunction.CommonTextBox_Input(BODYINPUT_XPATH, searchText);
	}

	public static void clickOnStepLibrary() {
		cfunction.Commmon_Click("xpath", ADVANCED_STEP_LIBRARY_XPATH);

	}

	public static boolean clickOnSavedSearches(String jobName) {
		int i = 1;
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(SAVED_SEARCHES_LIST_XPATH));
		for (WebElement item : items) {
			String menuItem = item.getText();
			String JabTemplateName = "(" + SAVED_SEARCHES_LIST_XPATH + ")" + "[" + i + "]";
			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				cfunction.Commmon_Click("xpath", JabTemplateName);
				verified = true;
				System.out.println(menuItem + " found in Search List");
				break;
			}
			System.out.println("Job Template Xpath:   " + JabTemplateName);
			i++;
		}

		return verified;
	}

	public static boolean verifySaveBtnIsDisabled() {
		boolean verified = false;
		WebElement element = driver
				.findElement(By.xpath("//div[@class='actionBarItem']/calcite-button[@aria-disabled]"));
		if (element.isDisplayed()) {
			verified = true;
			System.out.println("Edit button disbled");
		} else {
			System.out.println("Edit button enaabled");
		}
		return verified;
	}

	public static void clickOnEllipsis() {
		cfunction.sync(5);
		cfunction.Commmon_Click("xpath", ELLIPSIS_XPATH);
	}

	public static void clickOnEllipsis1() {
		// cfunction.Commmon_Click("xpath", "("+ELLIPSIS_XPATH+")[3]");
		cfunction.Commmon_Click("xpath", ELLIPSIS_XPATH);
	}

	public static void clickOnEllipsis3() {
		// cfunction.Commmon_Click("xpath", "("+ELLIPSIS_XPATH+")[3]");
		cfunction.Commmon_Click("xpath", ELLIPSIS_XPATH);
	}

	public static void clickOnEllipsis2() {
		// cfunction.Commmon_Click("xpath", "("+ELLIPSIS_XPATH+")[3]");
		cfunction.Commmon_Click("xpath", ELLIPSIS1_XPATH);
	}

	public static boolean verifyDeleteBtnIsDisplayed() {
		boolean verified = false;
		WebElement element = driver.findElement(By.xpath(JOBTEMPLATEDELETE_BUTTON_XPATH));
		if (element.isDisplayed()) {
			verified = true;
			System.out.println("Edit button visible");
		} else {
			System.out.println("Edit button not visible");
		}
		return verified;
	}

	public static void clickOnJobTemplateDeleteBtn() {
		cfunction.Commmon_Click("xpath", JOBTEMPLATEDELETE_BUTTON_XPATH);
	}

	public static boolean verifyDeleteBtnIsDisplayed1() {
		boolean verified = false;
		WebElement element = driver.findElement(By.xpath(DELETE_BUTTON_XPATH));
		if (element.isDisplayed()) {
			verified = true;
			System.out.println("Edit button visible");
		} else {
			System.out.println("Edit button not visible");
		}
		return verified;
	}

	public static void clickOnDeleteBtn() {
		// cfunction.Commmon_Click("xpath",
		// "(//div[@class='c-rolesAndPrivileges__buttonSection'])/calcite-dropdown/calcite-dropdown-group/calcite-dropdown-item");
		// cfunction.CommmonJS_Click(DELETE_BUTTON_XPATH);
		cfunction.Commmon_Click("xpath", DELETE_BUTTON_XPATH);
	}

	public static boolean verifyDeleteConfirmationBoxIsDisplayed() {
		boolean verified = false;
		WebElement element = driver.findElement(By.xpath(DELETE_CONFIRMATION_BOX_XPATH));
		if (element.isDisplayed()) {
			verified = true;
			System.out.println("Edit button visible");
		} else {
			System.out.println("Edit button not visible");
		}
		return verified;
	}

	public static void clickOnJobTemplateDeleteConfirmationNoBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", CONFIRMATION_NO_XPATH);
	}

	public static void clickOnJobTemplateDeleteConfirmationYesBtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", CONFIRMATION_YES_XPATH);
	}

	public static boolean clickOnJobTemplate(String jobName) {
		int i = 1;
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(JOBTEMPLATENAMECLICK_XPATH));
		for (WebElement item : items) {
			String menuItem = item.getText();
			String JabTemplateName = "(" + JOBTEMPLATENAMECLICK_XPATH + ")" + "[" + i + "]";
			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				cfunction.Commmon_Click("xpath", JabTemplateName);
				verified = true;
				System.out.println(menuItem + " found in Search List");
				break;
			}
			System.out.println("Job Template Xpath:   " + JabTemplateName);
			i++;
		}

		return verified;
	}

	public static void clickOnCheckBox(int index) {
		cfunction.Commmon_Click("xpath", "(" + ACTIVECHECKBOX_XPATH + ")[" + index + "]");
	}

	public static boolean verifyCheckboxDeactive(int index) throws InterruptedException {
		cfunction.sync(2);
		boolean verified = false;
		Design.clickOnExtendedProperties();
		WebElement element = driver.findElement(By.xpath(DEACTIVECHECKBOX_XPATH + "[" + index + "]"));
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", element);
		 * js.executeScript("arguments[0].click();", element);
		 */

		// WebElement element = driver.findElement(By.xpath("(//span[@class='p-col-4
		// p-col-align-center c-itemList__column--center
		// c-itemList__rowCol'])"+"["+index+"]"));

		if (element.isDisplayed()) {
			verified = true;
			System.out.println("Edit button visible");
		} else {
			System.out.println("Edit button not visible");
		}
		return verified;
	}

	public static boolean verifyExtendedPropertiesupdated() throws Exception {

		boolean verified = false;
		if (Design.verifyDefaultValue(1, "Test")) {
			if (Design.verifyCheckboxDeactive(3)) {
				if (Design.verifyDefaultValue(2, "")) {
					if (Design.verifyCheckboxDeactive(2)) {
						if (Design.verifyCheckboxDeactive(3)) {
							verified = true;
							System.out.println("All field verified");
						}
					}

				}
			}

		} else {
			System.out.println("Edit button not visible");
		}
		return verified;
	}

	public static void enterDiagramName(String text) {
		cfunction.CommonTextBox_Input(DIAGRAM_NAME_XPATH, text);

	}

	public static void enterDiagramDescription(String text) {
		cfunction.CommonTextBox_Input(DIAGRAM_DESCRIPTION_XPATH, text);

	}

	public static void clickOnAddDataSource() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", ADD_DATASOURCE_XPATH);

	}

	public static void enterURL(String text) {
		cfunction.CommonTextBox_Input(URLINPUT_XPATH, text);
		WebElement ele = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(URLINPUT_XPATH)));
		ele.clear();
		ele.sendKeys(text);
		Actions builder = new Actions(driver);
		cfunction.sync(2);
		// Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(2);
		ele.sendKeys(Keys.BACK_SPACE);
		//  WebElement descPaste = driver.findElement(By.cssSelector("input[id=\"descriptioninput\"]");
		ele.click();
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

	}

	public static void clickOnCancelButton() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", URLCANCELBUTTON_XPATH);

	}

	public static void clickOnOKButton() {
		cfunction.Commmon_Click("xpath", URLOKBUTTON_XPATH);

	}

	public static void clickOnDataSourceErrorButton() {
		cfunction.Commmon_Click("xpath", DATASOURCEERROR_BUTTON_XPATH);

	}

	public static boolean verifyErrorButtonToolTip(String msg) {
		boolean verified = false;
		cfunction.hoverByAction(DATASOURCEERROR_BUTTON_XPATH);
		cfunction.sync(5);
		if (verifyToolTipTextPresent1(msg)) {
			verified = true;
			System.out.println(msg + "visible");
		} else {
			System.out.println(msg + "Not visible");
		}
		return verified;
	}

	public static void clickOnSaveDiagramButton() {
		cfunction.Commmon_Click("xpath", SAVEDIAGRAM_BUTTON_XPATH);

	}

	public static void openDropDownMenuOfPriority() {
		//cfunction.sync(2);
		cfunction.CommonDropDown_Select(DROPDOWN_PRIORITY_XPATH);

	}

	public static void clickJobStartDateCheckbox() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", JOBSTARTDATECHECKBOX_XPATH);

	}

	public static void clickJobEndDateCheckbox() {
		cfunction.Commmon_Click("xpath", JOBENDDATECHECKBOX_XPATH);

	}

	public static void enterJobTemplateSummary(String text) {
		// cfunction.sync(2);
		cfunction.CommonTextBox_Input(JOBTEMPLATESUMMARY_XPATH, text);

	}

	public static void enterDefaultJobDescription(String text) {
		// cfunction.sync(2);
		cfunction.CommonTextBox_Input(DEFAULTJOBDESCRIPTION_XPATH, text);

	}

	/*public static boolean selecPriority(String priority) {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(PRIORITYLIST_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(priority)) {
				row.click();
				verified = true;
				break;
			}
		}
		return verified;
	}*/
	public static void selecPriority(String priority) {
		cfunction.selectValueFromMenueItem(PRIORITYLIST_XPATH, priority);
	}
	public static void selectCategory(String category) {
		// cfunction.sync(2);
		cfunction.Commmon_Click("xpath", CATEGORYDROPDOWN_XPATH);
		cfunction.sync(1);
		cfunction.selectValueFromMenueItem(CATEGORYDROPDOWNMENU_XPATH, category);
	}

	public static void selectValueFromDropDown(String value) {
		List<WebElement> items = driver.findElements(By.xpath("(//li[contains(@class,'p-dropdown-item')])"));
		for (WebElement item : items) {
			String menuItem = item.getText();

			System.out.println(menuItem + "  --  " + value);
			if (menuItem.equalsIgnoreCase(value)) {
				item.click();
				System.out.println(menuItem + " selected");
				break;
			}
		}
	}

	public static boolean verifyfilledinput() throws Exception {
		boolean verified = false;
		// boolean check;
		/*
		 * //List<WebElement> rows =
		 * driver.findElements(By.xpath("//input[contains(@class,'ui-state-filled')]"));
		 * WebElement rows=cfunction.getWebElement("xpath",
		 * "//input[contains(@class,'ui-state-filled')]");
		 * 
		 * //int size=rows.size();
		 */ String imgName = "TS22_BlankInputfield_1280x768_FF2";
		if (SikuliHelp.verifyImageExists(imgName)) {
			verified = true;
		} else {
			verified = false;
		}

		return verified;

	}

	public static void enterURLAtGPServices(String url) {
		cfunction.CommonTextBox_Input(GP_SERVICE_URL_XPATH, url);

	}

	public static void clickSecureCheckBox() {
		cfunction.Commmon_Click("XPATH", SECURE_CHECKBOX_XPATH);

	}

	public static void verifySecureCheckboxIsUncheck() {
		cfunction.elementIsDisplayed(SECURE_CHECKBOX_XPATH);

	}

	public static void clickOnPlusSign(int count) {

		for (int i = 0; i <= count; i++) {
			cfunction.Commmon_Click("xpath", PLUSSIGN_XPATH);
		}

	}

	public static boolean verifyDiagramsPrintBtnVisible() throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(DIAGRAM_PRINT_BTN_XPATH));
		System.out.println("Print Button visible");
		if (rows.size() == 1)
			return true;
		return false;
	}

	public static void clickOnSaveBtnOfSharedSearched1() {
		cfunction.CommmonJS_Click(SHAREDSEARCHED_SAVE_BTN_XPATH);
		// cfunction.Commmon_Click("xpath", SHAREDSEARCHED_SAVE_BTN_XPATH+"[2]");
	}

	public static boolean checkGroupNameCheckbox(String jobTemplate) {
		int listcount = 1;
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(GROUP_NAME_LIST_XPATH));
		for (WebElement item : rows) {
			String rowsItem = item.getText();
			System.out.println(rowsItem + "  --  ");
			if (rowsItem.contains(jobTemplate)) {
				verified = true;
				System.out.println(jobTemplate + " is visible");
				// String checkbox= GROUP_NAME_CHECKBOX_XPATH+"["+listcount+"]";
				// cfunction.CommmonJS_Click(GROUP_NAME_CHECKBOX_XPATH+"["+(listcount)+"]/div");
				// cfunction.Commmon_Click("xpath",
				// GROUP_NAME_CHECKBOX_XPATH+"["+(listcount)+"]/div");
				WebElement icon = driver.findElement(By.xpath(GROUP_NAME_CHECKBOX_XPATH + "[" + (listcount) + "]/div"));
				Actions ob = new Actions(driver);
				ob.click(icon);
				Action action = ob.build();
				action.perform();
				// break;
			} else {
				System.out.println(jobTemplate + " is not visible");
			}
			listcount++;
		}
		return verified;

	}

	public static void selectDeleteFromEllipseDrpdwn() throws Exception {
		// cfunction.CommmonJS_Click("//div[@class='btnGroup']/div/button");
		cfunction.CommmonJS_Click("//calcite-button[@class='btn-more']");
		cfunction.sync(2);/* ((//div[contains(@class,'dropdown js-dropdown')])[2]) */
		// cfunction.CommmonJS_Click("((//div[contains(@class,'dropdown js')])[2])//a");
		// String DELETE_SEARCH="//CALCITE-DROPDOWN-ITEM[TEXT()=' DELETE SEARCH ']"
		cfunction.CommmonJS_Click("//calcite-dropdown-item[text()=' Delete Search ']");
	}

	public static void selectDeleteFromEllipseDrpdwn1() throws Exception {
		// cfunction.CommmonJS_Click("//div[@class='btnGroup']/div/button");
		cfunction.CommmonJS_Click("//calcite-button[@class='btn-more']");
		cfunction.sync(2);/* ((//div[contains(@class,'dropdown js-dropdown')])[2]) */
		// cfunction.CommmonJS_Click("((//div[contains(@class,'dropdown js')])[2])//a");
		// String DELETE_SEARCH="//CALCITE-DROPDOWN-ITEM[TEXT()=' DELETE SEARCH ']"
		cfunction.CommmonJS_Click("//calcite-dropdown-item[text()=' Delete Search ']");
	}

	public static Boolean verifyURLErrorVisible() {
		Boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(GPSERVICE_URL_ERROR_XPATH));
		if (rows.size() == 1) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

	}

	public static void clickEditArgument() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", EDIT_ARGUMENT_BUTTON_XPATH);

	}

	public static void clickAddbtn() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", "//calcite-button[@class='btn-noPadding btn-small ng-star-inserted']");

	}

	public static void enterInputRasterFunction(String input) {
		cfunction.CommonTextBox_Input(INPUT_RASTER_FUNCTION_XPATH, input);

	}

	public static Boolean verifyInputRasterFunctionErrorVisible() {
		Boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(INPUT_RASTER_FUNCTION_ERROR_XPATH));
		if (rows.size() == 1) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

	}

	public static void clickVisibleAtRuntimeCheckBox() {
		// cfunction.sync(2);
		cfunction.Commmon_Click("XPATH", VISIBLE_AT_RUNTIME_XPATH);

	}

	public static void selectInputFromDropDown(String input) {
		cfunction.Commmon_Click("XPATH", OPEN_NAME_DROPDOWN_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(NAME_DROPDOWN_OPTIONS_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(input)) {
				row.click();
				break;
			}
		}
	}

	// (//button[@class='p-button noFill'])[1]
	public static void ClickOnSaveBtn() throws Exception {
		cfunction.Commmon_Click("xpath", "(//calcite-button[contains(@class,'ng-star-inserted')])[4]");
	}

	public static void ClickOnSaveBtn1() throws Exception {
		cfunction.Commmon_Click("xpath", "(//button[@class='p-button noFill'])[1]");
	}

	public static Boolean verifyArgumentsVisible() {
		Boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ARGUMENTS_TABLE_XPATH));
		if (rows.size() == 1) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;

	}

	public static boolean verifyinputRasterFunctionValue(String input) {
		boolean verified = false;
		String Value = cfunction.getElementText("(" + ARGUMENTS_ROWS_XPATH + "/div[2])[1]");
		if (input.equalsIgnoreCase(Value)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static boolean verifyinputRasterFunctionInvisible(String input) {
		boolean verified = false;
		String Value = cfunction.getElementText("(" + ARGUMENTS_ROWS_XPATH + "/div[3])[1]");
		if (input.equalsIgnoreCase(Value)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static boolean verifyOutputFormatInvisible(String input) {
		boolean verified = false;
		String Value = cfunction.getElementText("(" + ARGUMENTS_ROWS_XPATH + "/div[3])[2]");
		if (input.equalsIgnoreCase(Value)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static boolean verifyReturnValue(String input) {
		boolean verified = false;
		String Value = cfunction.getElementText("(" + ARGUMENTS_ROWS_XPATH + "/div[2])[3]");
		if (input.equalsIgnoreCase(Value)) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static void verifyPrivateRadioBtnVisible() {
		// cfunction.sync(2);
		cfunction.elementIsDisplayed(RADIO_BTN_XPATH + "[1]");

	}

	public static void verifyPublicRadioBtnVisible() {
		cfunction.elementIsDisplayed(RADIO_BTN_XPATH + "[2]");

	}

	public static void verifyProtectedRadioBtnVisible() {
		cfunction.elementIsDisplayed(RADIO_BTN_XPATH + "[3]");

	}

	public static void clickPrivateRadioBtn() {
		cfunction.Commmon_Click("xpath", RADIO_BTN_XPATH + "[1]");

	}

	public static void clickPublicRadioBtn() {
		cfunction.Commmon_Click("xpath", RADIO_BTN_XPATH + "[2]");

	}

	public static void clickProtectedRadioBtn() {
		cfunction.Commmon_Click("xpath", RADIO_BTN_XPATH + "[3]");

	}
	
	public static void clickDataSourceRadioBtn(int i) {
		cfunction.Commmon_Click("xpath", RADIO_BTN_XPATH + "["+i+"]");

	}
	
	public static void verifyDataSourceRadioBtnVisible(int i) {
		cfunction.elementIsDisplayed(RADIO_BTN_XPATH + "["+i+"]");

	}
	
	

	public static void clickOnAdvanceStepList() {
		cfunction.Commmon_Click("xpath", ADVANCE_STEPLIST_XPATH);

	}

	public static void clickOnCanBeSkipped() {
		cfunction.Commmon_Click("xpath", STEPDETAIL_RADIO_BTN_XPATH + "[3]");

	}

	public static void enterUserPromptInput(String input) {
		cfunction.CommonTextBox_Input(USERPROMPT_XPATH, input);
	}

	public static void enterFolderInput(String input) {
		cfunction.CommonTextBox_Input(FOLDER_XPATH, input);
	}

	public static boolean verifyFolderNameErrorVisible() {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(INVALID_FOLDERNAME_ERROR_XPATH)) {
			System.out.println("Error visible");
			verified = true;
		} else {
			System.out.println("Error not visible");
		}
		return verified;
	}

	public static void enterFileTypeInput(String input) {
		cfunction.CommonTextBox_Input(FILETYPE_XPATH, input);
	}

	public static void clickOnViewExisting() {
		cfunction.Commmon_Click("xpath", STEPDETAIL_RADIO_BTN_XPATH + "[3]");

	}

	public static void enterStepName(String name) {
		cfunction.CommonTextBox_Input(STEPNAME_XPATH, name);
	}

	public static void clickOnEditExisting() {
		cfunction.Commmon_Click("xpath", STEPDETAIL_RADIO_BTN_XPATH + "[4]");

	}

	public static boolean verifyViewExistingCheckOn() {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(ACTIVE_RADIO_BTN_XPATH + "[1]")) {
			System.out.println("element visible");
			verified = true;
		} else {
			System.out.println("Element not visible");
		}
		return verified;

	}

	public static boolean verifyEditExistingCheckOn() {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(ACTIVE_RADIO_BTN_XPATH + "[2]")) {
			System.out.println("element visible");
			verified = true;
		} else {
			System.out.println("Element not visible");
		}
		return verified;

	}

	public static boolean verifyCanBeSkippedCheckOff() {
		boolean verified = false;
		if (cfunction.elementIsDisplayed(STEPDETAIL_RADIO_BTN_XPATH + "[3]")) {
			System.out.println("element visible");
			verified = true;
		} else {
			System.out.println("Element not visible");
		}
		return verified;

	}

	public static boolean verifyDialogueBoxName(String name) throws Exception {
		boolean verified = false;

		WebElement dialogueWindow = driver.findElementByXPath(ARCGIS_ONLINE_RADIOBUTTON);
		String dialogueBoxName = dialogueWindow.getText();

		if (dialogueBoxName.equalsIgnoreCase(name)) {
			System.out.println("Correct dialogue box opened");
			verified = true;
		} else {
			System.out.println("Wrong dialogue box opened");
		}
		return verified;
	}

	public static boolean verifyDialogueBoxName1() throws Exception {
		boolean verified = false;

		WebElement dialogueWindow = driver.findElementByXPath(DIALOGUE_BOX_NAME_XPATH);
		verified = dialogueWindow.isDisplayed();
		return verified;
	}

	public static void enterMapID() {

	}

	public static void enterInputInWebApp(String input) throws Exception {
		cfunction.Commmon_Click("xpath", "//p-radiobutton//label[text()='ArcGIS Online']");
		cfunction.sync(2);
		WebElement ele = driver.findElementByXPath(DIALOGUE_BOX_INPUT_XPATH + "[1]");
		// ele.sendKeys(Keys.TAB);
		/*
		 * Robot robot= new Robot(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyPress(KeyEvent.VK_TAB);
		 */
		cfunction.CommonTextBox_Input2(DIALOGUE_BOX_INPUT_XPATH + "[1]", input);
		// WebElement urlTextField = driver.findElement(By.xpath("DIALOGUE_BOX_INPUT_XPATH+\"[1]\"");
		Actions builder = new Actions(driver);
		cfunction.sync(2);
		// Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		cfunction.sync(2);
		ele.sendKeys(Keys.BACK_SPACE);
		//  WebElement descPaste = driver.findElement(By.cssSelector("input[id=\"descriptioninput\"]");
		ele.click();
		cfunction.sync(2);
		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		System.out.println(input);
	}

	public static void enterInputInUserPrompt(String input) throws Exception {
		cfunction.CommonTextBox_Input(USER_PROMPT_XPATH, input);
	}

	public static void selectFromLocationMethodDrpdwn(String option) throws Exception {
		cfunction.selectOptionFromDropDown(LOCATION_METHOD_XPATH, LOCATION_METHOD_DROPDWN_LIST_XPATH, option);
	}

	public static void selectFromLocationMethod() throws Exception {
		cfunction.Commmon_Click("xpath", "//label[text()='Draw']");
	}

	public static void selectFromJobLocationGeomatryDrpdwn(String option) throws Exception {
		cfunction.selectOptionFromDropDown(JOB_LOCATION_GEOMATRY_XPATH, LOCATION_METHOD_DROPDWN_LIST_XPATH, option);
	}

	public static boolean verifyArgumentValue1(String name) throws Exception {
		boolean verified = false;
		WebElement value = driver.findElementByXPath(ARGUMENTS_VALUE1_XPATH);
		String ArgumentValue = value.getAttribute("value");
		System.out.println("Input Tag Value==" + ArgumentValue);
		// String ArgumentValue=value.getText();
		if (ArgumentValue.equalsIgnoreCase(name)) {
			System.out.println("Correct Argument value1");
			verified = true;
		} else {
			System.out.println("Wrong Argument value1");
		}
		return verified;
	}

	public static boolean verifyArgumentValue2(String name) throws Exception {
		boolean verified = false;
		WebElement value = driver.findElementByXPath(ARGUMENTS_VALUE2_XPATH);
		String ArgumentValue = value.getAttribute("value");
		System.out.println("Input Tag Value==" + ArgumentValue);
		if (ArgumentValue.equalsIgnoreCase(name)) {
			System.out.println("Correct Argument value2");
			verified = true;
		} else {
			System.out.println("Wrong Argument value2");
		}
		return verified;
	}

	public static boolean verifyArgumentValue3(String name) throws Exception {
		boolean verified = false;
		WebElement value = driver.findElementByXPath(ARGUMENTS_VALUE3_XPATH);
		// String ArgumentValue=value.getText();
		String ArgumentValue = value.getAttribute("value");
		System.out.println("Input Tag Value==" + ArgumentValue);
		if (ArgumentValue.equalsIgnoreCase(name)) {
			System.out.println("Correct Argument value3");
			verified = true;
		} else {
			System.out.println("Wrong Argument value3");
		}
		return verified;
	}

	public static boolean verifyArgumentValue4(String name) throws Exception {
		boolean verified = false;
		WebElement value = driver.findElementByXPath(ARGUMENTS_VALUE4_XPATH);
		String ArgumentValue = value.getText();
		if (ArgumentValue.equalsIgnoreCase(name)) {
			System.out.println("Correct Argument value4");
			verified = true;
		} else {
			System.out.println("Wrong Argument value4");
		}
		return verified;
	}

	public static boolean verifyArgumentValue5(String name) throws Exception {
		boolean verified = false;
		WebElement value = driver.findElementByXPath(ARGUMENTS_VALUE5_XPATH);
		/*
		 * String ArgumentValue=value.getAttribute("value");
		 * System.out.println("Input Tag Value=="+ArgumentValue);
		 */
		String ArgumentValue = value.getText();
		System.out.println("Input Tag Value==" + ArgumentValue);
		if (ArgumentValue.equalsIgnoreCase(name)) {
			System.out.println("Correct Argument value5");
			verified = true;
		} else {
			System.out.println("Wrong Argument value5");
		}
		return verified;
	}

	public static void ClickOnCancelBtn() throws Exception {
		cfunction.Commmon_Click("xpath", "(" + SAVEDIALOGSAVEBTN_XPATH + ")[2]");
	}

	public static void selectDataType(String type) {
		try {
			String xpath = "(//p-dropdown[contains(@class,'t-domainTypeDropdown')]//span)[2]";
			cfunction.Commmon_Click("xpath", xpath);
			cfunction.sync(2);
			// cfunction.selectOptionFromDropDown(xpath,
			// "//li[contains(@class,'p-dropdown-item')]//span", type);
			cfunction.sync(2);
			List<WebElement> rows = driver.findElements(By.xpath("//li[contains(@class,'p-dropdown-item')]//span"));
			for (WebElement option : rows) {
				if (option.getText().equalsIgnoreCase(type)) {
					option.click();
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void enterEditDomainValues(int index, String value) {
		String xpath1 = "(//div[contains(@class,'minMaxHeight')]//input)[" + index + "]";

		cfunction.CommonTextBox_Input1(xpath1, value);
		cfunction.Commmon_Click("xpath", xpath1);
		WebElement txtBox = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));
		cfunction.sync(2);
		txtBox.sendKeys(Keys.ARROW_UP);
		txtBox.sendKeys(Keys.ARROW_DOWN);

	}

	public static void ClickOnAddNewValue() throws Exception {
		cfunction.Commmon_Click("xpath", "//calcite-button[@class='btn-noPadding btn-small t-codedValue-addBtn']");
	}

	public static void ClickOnSaveBtnOfDomain() throws Exception {
		cfunction.Commmon_Click("xpath", DOMAIN_SAVE_XPATH);
	}

	public static void enableWorkflowPrivileges(String itemName) throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH));
		for (int i = 51; i <= rows.size(); i++) {
			String ListName_xpath = ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH + "[" + i + "]";
			WebElement headerTitle = CommonFunction.getWebElement("xpath", ListName_xpath);
			System.out.println(headerTitle.getText());
			if (headerTitle.getText().equalsIgnoreCase(itemName)) {
				cfunction.Commmon_Click("xpath",
						ROLE_WORKFLOW_PRIVILEGES_LIST_CHECKBOX_XPATH + "[" + i + "]/p-checkbox");
				// index = i - 1;
				break;
			}
		}
	}

	public static void disableWorkflowPrivileges(String itemName) throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH_DISABLE));
		for (int i = 51; i <= rows.size(); i++) {
			String ListName_xpath = ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH_DISABLE + "[" + i + "]";
			WebElement headerTitle = CommonFunction.getWebElement("xpath", ListName_xpath);
			System.out.println(headerTitle.getText());
			if (headerTitle.getText().equalsIgnoreCase(itemName)) {
				cfunction.Commmon_Click("xpath",
						ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH_DISABLE + "[" + i + "]/div");
				// index = i - 1;
				break;
			}
		}
	}

	public static void enableWorkflowPrivileges1(String itemName) throws Exception {
		List<WebElement> rows = driver.findElements(By.xpath(ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH));
		for (int i = 1; i <= rows.size(); i++) {
			String ListName_xpath = ROLE_WORKFLOW_PRIVILEGES_LIST_XPATH + "[" + i + "]";
			WebElement headerTitle = CommonFunction.getWebElement("xpath", ListName_xpath);
			System.out.println(headerTitle.getText());
			if (headerTitle.getText().equalsIgnoreCase(itemName)) {
				cfunction.sync(2);
				cfunction.Commmon_Click("xpath",
						ROLE_WORKFLOW_PRIVILEGES_LIST_CHECKBOX_XPATH + "[" + i + "]/p-checkbox/div");
				// index = i - 1;
				break;
			}
		}
	}

	public static boolean verifyEnableWorkflowPrivileges() throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ROLE_WORKFLOW_PRIVILEGES_LIST_ENABLE_CHECKBOX_XPATH));
		// List<WebElement>
		// rows1=driver.findElements(By.xpath(ROLE_WORKFLOW_PRIVILEGES_LIST_ENABLE_CHECKBOX_XPATH));
		if (rows.size() > 0) {
			verified = true;
		} else {
			return verified;
		}
		return verified;
	}

	public static boolean verifyAllCheckboxEnableWorkflowPrivileges() throws Exception {
		boolean verified = false;
		// List<WebElement>
		// rows=driver.findElements(By.xpath(ROLE_WORKFLOW_PRIVILEGES_LIST_CHECKBOX_XPATH));
		List<WebElement> rows1 = driver.findElements(By.xpath(ROLE_WORKFLOW_PRIVILEGES_LIST_ENABLE_CHECKBOX_XPATH));
		if (rows1.size() == 24) {
			verified = true;
		}

		else {
			return verified;
		}
		return verified;
	}

	public static boolean selectRoleFromList(String itemName) throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath(ROLE_NAME_LIST_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(itemName)) {
				row.click();
				verified = true;
				break;
			} else {
				verified = false;
			}

		}
		return verified;

	}

	public static boolean verifyNoRolePresent(String itemName) throws Exception {
		boolean verified = false;
		List<WebElement> rows = driver.findElements(By.xpath("(//span[@class='text ng-star-inserted'])[2]"));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase("Role Name: " + itemName)) {
				row.click();
				verified = true;
				break;
			} else {
				verified = false;
			}

		}
		return verified;

	}

	public static boolean verifyChartName(String jobName) {
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(SEARCHTEXT_INPUTCHARTNAME_XPATH));
		for (WebElement item : items) {
			String menuItem = item.getAttribute("value");
			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				verified = true;
				System.out.println(menuItem + " found in Search List");
				break;
			}
		}
		return verified;
	}

	public static boolean verifyDisplayField(String jobName) {
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(SEARCHTEXT_DISPLAYFIELD_XPATH));
		for (WebElement item : items) {
			String menuItem = item.getAttribute("value");
			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				verified = true;
				System.out.println(menuItem + " found in Search List");
				break;
			}
		}
		return verified;
	}

	public static boolean verifyDisplayName(String jobName) {
		boolean verified = false;
		List<WebElement> items = driver.findElements(By.xpath(SEARCHTEXT_DISPLAYNAME_XPATH));
		for (WebElement item : items) {
			String menuItem = item.getAttribute("value");
			System.out.println(menuItem + "  --  " + jobName);
			if (menuItem.equalsIgnoreCase(jobName)) {
				verified = true;
				System.out.println(menuItem + " found in Search List");
				break;
			}
		}
		return verified;
	}

	public static void selectSortDirectionFromDropdown(String sortdirection) throws Exception {
		cfunction.Commmon_Click("xpath", DROPDOWN_SORTDIRECTION_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(DROPDOWN_SORTDIRECTION_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(sortdirection)) {
				row.click();
				break;
			}
		}
	}

	public static boolean verifySortDirectionFromDropdown(String sortdirection) throws Exception {
		boolean match = false;
		List<WebElement> rows = driver.findElements(By.xpath(DROPDOWN_SORTDIRECTION_XPATH));
		if (rows.get(0).getText().equalsIgnoreCase(sortdirection)) {
			match = true;
		}
		return match;
	}

	public static void clickColorDroDownBtn() throws Exception {
		cfunction.Commmon_Click("xpath", SELECT_COLORRAMP_XPATH);
	}

	public static void selectColorDroDownBtn(String color) throws Exception {
		// cfunction.Commmon_Click("xpath", SELECT_COLOR_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(SELECT_COLOR_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(color)) {
				row.click();
				break;
			}
		}
	}

	public static void selectShareChartWithEveryone(String chart) throws Exception {
		// cfunction.Commmon_Click("xpath",
		// "(//span[contains(@class,'ui-radiobutton-icon')])[1]");
		cfunction.Commmon_Click("xpath", "//p-radiobutton[1]");
	}

	public static void selectShareChartWithGroup(String chart) throws Exception {
		// cfunction.Commmon_Click("xpath",
		// "(//span[contains(@class,'ui-radiobutton-icon')])[2]");
		cfunction.Commmon_Click("xpath", "//p-radiobutton[2]");
	}

	public static void selectChartName(String chart) throws Exception {
		// cfunction.Commmon_Click("xpath", SELECT_COLOR_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(SELECT_SHARECHARTWITH_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(chart)) {
				row.click();
				break;
			}
		}
	}

	public static boolean ChartNameInList(String chart) {
		boolean ifExist = false;
		List<WebElement> rows = driver.findElements(By.xpath(DROPDOWN_CHARTS_XPATH));
		for (WebElement row : rows) {
			if (row.getText().equalsIgnoreCase(chart)) {
				// row.click();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", row);
				ifExist = true;
				break;
			}
		}
		return ifExist;
	}
	public static boolean SelectChartNameInList(String chart) {
		boolean ifExist = false;
		List<WebElement> rows = driver.findElements(By.xpath(SELECT_DROPDOWN_CHARTS_XPATH));
		for (WebElement row : rows) {
			System.out.println(row.getText());
			if (row.getText().equalsIgnoreCase(chart)) {
				// row.click();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", row);
				ifExist = true;
				break;
			}
		}
		return ifExist;
	}
	
	public static boolean ClickChartNameInList(String chart) {
		boolean ifExist = false;
		WebElement row = driver.findElement(By.xpath("(//span[@class='c-cardList__cardTitle col-8 t-cardList__cardTitle--searchName'])[1]"));
		System.out.println(row.getText());
		if (row.getText().equalsIgnoreCase(chart)) {
				// row.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", row);
			ifExist = true;
		}
		return ifExist;
	}

	public static boolean verifyChartNamePosition(String Chartname, int Position) {
		boolean match = false;
		int counter = 0;
		List<WebElement> rows = driver.findElements(By.xpath(DROPDOWN_CHARTS_XPATH));
		for (WebElement row : rows) {
			counter++;
			if ((row.getText().equalsIgnoreCase(Chartname)) && (counter == Position)) {
				row.click();
				match = true;
				break;
			}
		}
		return match;
	}

	public static boolean verifyChartNamePositionLast(String Chartname) {
		boolean match = false;
		int counter = 0;
		List<WebElement> rows = driver.findElements(By.xpath(DROPDOWN_CHARTS_XPATH));
		for (WebElement row : rows) {
			counter++;
			System.out.println("rows.size()): " + (rows.size()));
			if ((row.getText().contains(Chartname)) && (counter == (rows.size()))) {
				// if ((row.getText().equalsIgnoreCase(Chartname)) && (counter==(rows.size())))
				// {
				row.click();
				match = true;
				break;
			}
		}
		return match;
	}

	public static boolean selectGroupItem(String groupname) {
		boolean ifExist = false;
		int counter = 0;
		List<WebElement> rows = driver.findElements(By.xpath(DROPDOWN_GROUPS_XPATH));
		for (WebElement row : rows) {
			counter++;
			System.out.println("row.getText(): " + row.getText());
			if (row.getText().equalsIgnoreCase(groupname)) {
				WebElement radioBtn = driver.findElement(
						By.xpath("(//span[contains(@class,'t-groupName')]/..//span[2]//span)[" + counter + "]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioBtn);
				ifExist = true;
				break;
			}
		}
		return ifExist;
	}

	public static boolean checkSavePrompt(String messagetext) {
		boolean verified = false;
		String msg = cfunction.getElementText(SUCCESSMSG_XPATH);
		System.out.println(msg);
		if (msg.contains(messagetext)) {
			verified = true;
		}
		return verified;
	}

	public static boolean verifySelectedColorDroDown(String color) throws Exception {
		boolean selectedcolor = false;
		// cfunction.Commmon_Click("xpath", SELECT_COLOR_XPATH);
		List<WebElement> rows = driver.findElements(By.xpath(SELECT_COLOR_XPATH));
		if (rows.get(0).getText().equalsIgnoreCase(color)) {
			selectedcolor = true;
		}
		return selectedcolor;
	}

	public static void clickOnSaveBtnSharedChart() {
		cfunction.Commmon_Click("xpath", SETTING_PAGE_SAVE_BTN_XPATH);
	}

	public static void clickOnSettingsSide() {
		cfunction.Commmon_Click("xpath", SETTINGSSIDE_XPATH);

	}

	public static void clickYesOnConfirmDialogSharedCharts() throws Exception {
		// cfunction.Commmon_Click("xpath", CONFIRMDIALOGYES_XPATH);
		List<WebElement> clickYES = driver.findElements(By.xpath(CONFIRMDIALOGYES_XPATH));
		if (clickYES.size() > 0) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickYES);
		}
	}

	public static void clickOnSharedChartTab() {
		cfunction.Commmon_Click("xpath", SHARED_CHARTS_XPATH);
	}

	public static void enterSearchTextChartName(String txtValue) {
		cfunction.CommonTextBox_Input(SEARCHTEXT_INPUTCHARTNAME_XPATH, txtValue);
	}

	public static void clickCreateNewSharedChartsBtn() throws Exception {
		cfunction.Commmon_Click("xpath", CREATE_BUTTONSHAREDCHARTS_XPATH);
	}

	public static void enterSearchTextDisplayField(String txtValue) {
		cfunction.CommonTextBox_Input(SEARCHTEXT_DISPLAYFIELD_XPATH, txtValue);
	}

	public static void enterSearchTextDisplayName(String txtValue) {
		cfunction.CommonTextBox_Input(SEARCHTEXT_DISPLAYNAME_XPATH, txtValue);
	}

	public static void verifyDiscardBtn() {
		WebElement btn = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(SETTING_PAGE_DISCARD_BTN_XPATH)));

	}

	/*************** test TS77 ************/
	public static void diagramSettingName(String txtValue) {
		cfunction.CommonTextBox_Input(DIAGRAM_SETTING_NAME_INPUTS_XPATH, txtValue);
	}

	public static void inputBaseURL(String baseURL) {
		cfunction.CommonTextBox_Input(URL_INPUT_XPATH, baseURL);
	}

	public static void inputAddParameterInURL(String queryParameterText) {
		WebElement txtBox = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(URL_INPUT_XPATH)));
		txtBox.sendKeys(queryParameterText);
	}

	public static void clickURLDropdown() throws Exception {
		cfunction.Commmon_Click("xpath", URL_DROPDOWN_BUTTON_XPATH);
	}

	public static boolean selectURLrequestType(String requestType) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(URL_DROPDOWN_LIST_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String requestTypeTextFetch = cfunction.getElementText(URL_DROPDOWN_LIST_XPATH + "[" + i + "]");
				if (requestType.equalsIgnoreCase(requestTypeTextFetch)) {
					cfunction.Commmon_Click("xpath", URL_DROPDOWN_LIST_XPATH + "[" + i + "]");
					verify = true;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean verifyURLrequestType(String[] requestType) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(URL_DROPDOWN_LIST_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String requestTypeTextFetch = cfunction.getElementText(URL_DROPDOWN_LIST_XPATH + "[" + i + "]");
				for (String a : requestType) {
					if (a.equalsIgnoreCase(requestTypeTextFetch)) {
						// cfunction.Commmon_Click("xpath", URL_DROPDOWN_LIST_XPATH + "[" + i + "]");
						System.out.println("request name verified: " + a);
						verify = true;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean selectNavTab1(String navigateToTab) throws Exception {
		boolean verify = false;
		try {

			// List<WebElement> requestTypeList =
			// driver.findElements(By.xpath(TAB_NAVIGATION_ALL_XPATH +"/a/span"));
			for (int i = 25; i <= 29; i++) {
				// String requestTypeTextFetch =
				// cfunction.getElementText(TAB_NAVIGATION_ALL_XPATH + "[" + i + "]");
				String requestTypeTextFetch = cfunction
						.getElementText(TAB_NAVIGATION_ALL_XPATH + "/a[@id='p-tabpanel-" + i + "-label']/span");
				// div[@class='p-tabview
				// p-component']//ul[@class='p-tabview-nav']/li/a[@id='p-tabpanel-"+j+"-label']/span
				System.out.println("Navigation Tab value is = " + requestTypeTextFetch);
				if (navigateToTab.equalsIgnoreCase(requestTypeTextFetch)) {
					cfunction.Commmon_Click("xpath",
							TAB_NAVIGATION_ALL_XPATH + "/a[@id='p-tabpanel-" + i + "-label']/span");
					verify = true;
					break;
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean selectNavTab(String navigateToTab) throws Exception {
		boolean verify = false;
		try {

			// List<WebElement> requestTypeList =
			// driver.findElements(By.xpath(TAB_NAVIGATION_ALL_XPATH +"/a/span"));
			for (int i = 12; i <= 16; i++) {
				// String requestTypeTextFetch =
				// cfunction.getElementText(TAB_NAVIGATION_ALL_XPATH + "[" + i + "]");
				String requestTypeTextFetch = cfunction
						.getElementText(TAB_NAVIGATION_ALL_XPATH + "/a[@id='p-tabpanel-" + i + "-label']/span");
				// div[@class='p-tabview
				// p-component']//ul[@class='p-tabview-nav']/li/a[@id='p-tabpanel-"+j+"-label']/span
				System.out.println("Navigation Tab value is = " + requestTypeTextFetch);
				if (navigateToTab.equalsIgnoreCase(requestTypeTextFetch)) {
					cfunction.Commmon_Click("xpath",
							TAB_NAVIGATION_ALL_XPATH + "/a[@id='p-tabpanel-" + i + "-label']/span");
					verify = true;
					break;
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean verifyWhichSelectNavTabIsSelected(String navigateToTabName) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(TAB_NAVIGATION_ALL_XPATH));
			for (int i = 12; i <= 16; i++) {
				String requestTypeTextFetch = cfunction
						.getElementText1(TAB_NAVIGATION_ALL_XPATH + "/a[@id='p-tabpanel-" + i + "-label']/span");
				System.out.println("All value are = " + requestTypeTextFetch);
				if (navigateToTabName.equalsIgnoreCase(requestTypeTextFetch)) {
					// i=i-4;

					String isTabIselected = cfunction.getElementAttribute1(
							TAB_NAVIGATION_ALL_XPATH + "/a[@id='p-tabpanel-" + i + "-label']/span", "textContent");
					if (isTabIselected.equalsIgnoreCase(navigateToTabName)) {
						System.out.println("Value is = " + isTabIselected);
						verify = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean verifyWhichSelectNavTabIsSelected1(String navigateToTabName) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(TAB_NAVIGATION_ALL_XPATH));
			for (int i = 25; i <= 29; i++) {
				String requestTypeTextFetch = cfunction
						.getElementText1(TAB_NAVIGATION_ALL_XPATH + "/a[@id='p-tabpanel-" + i + "-label']/span");
				System.out.println("All value are = " + requestTypeTextFetch);
				if (navigateToTabName.equalsIgnoreCase(requestTypeTextFetch)) {
					// i=i-4;

					String isTabIselected = cfunction.getElementAttribute1(
							TAB_NAVIGATION_ALL_XPATH + "/a[@id='p-tabpanel-" + i + "-label']/span", "textContent");
					if (isTabIselected.equalsIgnoreCase(navigateToTabName)) {
						System.out.println("Value is = " + isTabIselected);
						verify = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static void clickQueryParamAddKeyValueButton() throws Exception {
		cfunction.Commmon_Click("xpath", QUERYPARAM_ADDKEYVALUE_BUTTON_XPATH);
	}

	public static void inputQueryKey(String queryKey) {
		cfunction.CommonTextBox_Input("((//div[@wmx-hover-class])[" + count + "]//div/input)[1]", queryKey);
	}

	public static void inputQueryValue(String queryValue) {
		cfunction.CommonTextBox_Input("((//div[@wmx-hover-class])[" + count + "]//div/input)[2]", queryValue);
	}

	public static void clickQueryParamAddKeyValueNoPaddingButton() throws Exception {
		cfunction.Commmon_Click("xpath", QUERYPARAM_ADDKEYVALUE_NOPADDING_XPATH);
		count++;
	}

	public static void clickCeckBoxToUncheck() throws Exception {
		cfunction.Commmon_Click("xpath", "((//div[@wmx-hover-class])[" + count + "]/div/following-sibling::div//span)");
	}

	public static boolean selectRadioButton1(String radioButtonName) throws Exception {
		boolean verify = false;
		try {
			/*cfunction.sync(7);
			WebElement element = driver.findElementByXPath(RADIOBUTTON_NOW_DROPDOWN);*/
			//element.click();
			cfunction.sync(7);
			List<WebElement> requestTypeList = driver.findElements(By.xpath(AUTH_RADIO_BUTTON_STING_NAME_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String radioButtonTypeTextFetch = driver.findElement(By.xpath(AUTH_RADIO_BUTTON_STING_NAME_XPATH + "[" + i + "]")).getText();
				System.out.println("Value from Dropdown is=="+radioButtonTypeTextFetch);
				if (radioButtonName.equalsIgnoreCase(radioButtonTypeTextFetch)) {
					cfunction.Commmon_Click("xpath", AUTH_RADIO_BUTTON_XPATH + "[" + i + "]");
					verify = true;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}
	public static void clickOnApiKey(String option) throws Exception {
		//cfunction.selectOptionFromDropDown(CLICK_DROPDOWN_NO_AUTH_XPATH,CLICK_DROPDOWN_LIST_XPATH, option);
		cfunction.Commmon_Click("xpath", CLICK_DROPDOWN_NO_AUTH_XPATH);
		cfunction.sync(5);
		cfunction.selectValueFromMenueItem(CLICK_DROPDOWN_LIST_XPATH, option);
	}

	
	public static boolean selectRadioButton(String radioButtonName) throws Exception {
		boolean verify = false;
		try {
			cfunction.sync(19);
			WebElement element = driver.findElementByXPath(RADIOBUTTON_NOW_DROPDOWN);
			cfunction.sync(7);
			element.click();
			List<WebElement> requestTypeList = driver.findElements(By.xpath(DROPDOWNLIST));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String radioButtonTypeTextFetch = driver
						.findElement(By.xpath(DROPDOWNLIST + "[" + i + "]")).getText();
				System.out.println("Value from Dropdown is=="+radioButtonTypeTextFetch);
				if (radioButtonName.equalsIgnoreCase(radioButtonTypeTextFetch)) {
					cfunction.Commmon_Click("xpath", DROPDOWNLIST + "[" + i + "]");
					verify = true;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean verifyBlueWarningMsgSettingPageLink() throws Exception {
		boolean verify = cfunction.elementIsDisplayed(BLUE_WARNING_MSG_SETTING_PAGE_LINK_XPATH);
		return verify;
	}

	public static void rightClickBlueWarningMsgSettingPageLinkandVerify() throws Exception {
		try {
			Actions action = new Actions(driver);
			Action ac = action.contextClick(driver.findElement(By.xpath(BLUE_WARNING_MSG_SETTING_PAGE_LINK_XPATH)))
					.build();
			ac.perform();
			// cfunction.CommmonDouble_Click(BLUE_WARNING_MSG_SETTING_PAGE_LINK_XPATH);
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			driver.close();
			driver.switchTo().window(browserTabs.get(0));
		} catch (Exception e) {
			throw e;
		}

	}

	public static boolean verifyContentType(String contentType) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(CONTENT_LABEL_NAME_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String contentValueTextFetch = cfunction.getElementText(CONTENT_LABEL_NAME_XPATH + "[" + i + "]");
				if (contentType.equalsIgnoreCase(contentValueTextFetch)) {
					// cfunction.verifyElementAttribute_Value(CONTENT_LABEL_INPUT_BOX_XPATH,
					// "text");
					String textType = driver.findElement(By.xpath(CONTENT_LABEL_INPUT_BOX_XPATH + "[" + i + "]"))
							.getAttribute("type");
					if (textType.equalsIgnoreCase("text")) {
						verify = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean enterContentValue(String contentType, String contentValue) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(CONTENT_LABEL_NAME_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String contentValueTextFetch = cfunction.getElementText(CONTENT_LABEL_NAME_XPATH + "[" + i + "]");
				System.out.println("Value is==" + contentValueTextFetch);
				if (contentType.equalsIgnoreCase(contentValueTextFetch)) {

					cfunction.CommonTextBox_Input1(CONTENT_LABEL_INPUT_BOX_XPATH + "[" + i + "]", contentValue);
					verify = true;
					break;
				}

			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean enterContentValuePassword(String contentType, String contentValue) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(CONTENT_LABEL_NAME_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String contentValueTextFetch = cfunction.getElementText(CONTENT_LABEL_NAME_XPATH + "[" + i + "]");
				System.out.println("Value is==" + contentValueTextFetch);
				if (contentType.equalsIgnoreCase(contentValueTextFetch)) {

					cfunction.CommonTextBox_Input1("//input[@type='password']", contentValue);
					verify = true;
					break;
				}

			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean verifyAddedToIsDropDown() throws Exception {
		boolean verify = cfunction.elementIsDisplayed(DROPDOWN_BTN_ADDEDTO_XPATH);
		return verify;
	}

	public static void clickAddedToIsDropDown() throws Exception {
		cfunction.Commmon_Click("xpath", DROPDOWN_BTN_ADDEDTO_XPATH);
	}

	public static void clickEyeButton() throws Exception {
		cfunction.Commmon_Click("xpath", EYE_BTN_XPATH);
		cfunction.sync(7);
	}

	public static boolean verifyEyeButtonPasswordVisible() throws Exception {
		boolean verify = false;
		String attributeType = cfunction.getElementAttribute("(//div[@class='ng-star-inserted']/input)[2]", "type");
		if (attributeType.equalsIgnoreCase("password")) {
			verify = true;
		}
		return verify;
	}

	public static boolean selectAddedToTypeFromDropDown(String addedToType) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(DROPDOWN_BTN_ADDEDTO_LIST_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String contentValueTextFetch = cfunction
						.getElementText(DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i + "]");
				cfunction.sync(2);
				if (addedToType.equalsIgnoreCase(contentValueTextFetch)) {
					cfunction.Commmon_Click("xpath", DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i + "]");
					// cfunction.CommmonJS_Click(DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i + "]");
					verify = true;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean selectAddedToTypeFromDropDownFirefoxSecond(String addedToType) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(DROPDOWN_BTN_ADDEDTO_LIST_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String contentValueTextFetch = cfunction
						.getElementText(DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i + "]");
				cfunction.sync(2);
				if (addedToType.equalsIgnoreCase(contentValueTextFetch)) {
					cfunction.sync(5);
					// WebElement element= driver.findElementByXPath(DROPDOWN_BTN_ADDEDTO_LIST_XPATH
					// + "[" + i + "]");
					// element.click();
					Actions action = new Actions(driver);
					// action.sendKeys(Keys.ARROW_DOWN).build().perform();
					action.sendKeys(Keys.ENTER).build().perform();
					// cfunction.Commmon_Click("xpath", DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i +
					// "]");
					// cfunction.CommmonJS_Click(DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i + "]");
					verify = true;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean selectAddedToTypeFromDropDownFirefoxfirst(String addedToType) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(DROPDOWN_BTN_ADDEDTO_LIST_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String contentValueTextFetch = cfunction
						.getElementText(DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i + "]");
				cfunction.sync(2);
				if (addedToType.equalsIgnoreCase(contentValueTextFetch)) {
					cfunction.sync(5);
					// WebElement element= driver.findElementByXPath(DROPDOWN_BTN_ADDEDTO_LIST_XPATH
					// + "[" + i + "]");
					// element.click();
					Actions action = new Actions(driver);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
					action.sendKeys(Keys.ENTER).build().perform();
					// cfunction.Commmon_Click("xpath", DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i +
					// "]");
					// cfunction.CommmonJS_Click(DROPDOWN_BTN_ADDEDTO_LIST_XPATH + "[" + i + "]");
					verify = true;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static void clickAddKeyValueOnHeaerTab() throws Exception {
		cfunction.Commmon_Click("xpath", ADDKEYVALUE_HEADER_TAB_BTN_XPATH);
		count++;
	}

	public static void inputBodyText(String textBodyJSON) {
		cfunction.CommonTextBox_Input(BODY_TEXT_AREA_XPATH, textBodyJSON);
	}

	public static void clickSaveBtnConfingWebPage() throws Exception {
		cfunction.Commmon_Click("xpath", SAVEBTN_CONFIGURE_WEB_PAGE_XPATH);
	}

	public static boolean verifyArgumentedURL(String desiredArgumentedURL) throws Exception {
		boolean verify = false;
		String fetchedURL = cfunction.getElementText(ARGUMENT_URL_XPATH);
		if (desiredArgumentedURL.equalsIgnoreCase(fetchedURL)) {
			verify = true;
		}
		return verify;
	}

	public static boolean hoverOnTemplateName(String templateNameRequired) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> templateList = driver.findElements(By.xpath(TEMPLATE_NAME_LIST_XPATH));
			for (int i = 1; i <= templateList.size(); i++) {
				String nameTemp = cfunction.getElementText(TEMPLATE_NAME_LIST_XPATH + "[" + i + "]").trim();
				if (templateNameRequired.equalsIgnoreCase(nameTemp)) {
					cfunction.hoverByAction(TEMPLATE_NAME_LIST_XPATH + "[" + i + "]");
					cfunction.Commmon_Click("xpath", TEMPLATE_NAME_EDIT_BTN_XPATH + "[" + i + "]");
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static int countPathVariable() throws Exception {
		int countPathVar = driver.findElements(By.xpath(PATH_VARIABLE_COUNT_XPATH)).size();
		return countPathVar;
	}

	public static boolean deleteTemplate(String templateNameRequired) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> templateList = driver.findElements(By.xpath(TEMPLATE_NAME_LIST_XPATH));
			for (int i = 1; i <= templateList.size(); i++) {
				String nameTemp = cfunction.getElementText(TEMPLATE_NAME_LIST_XPATH + "[" + i + "]").trim();
				if (templateNameRequired.equalsIgnoreCase(nameTemp)) {
					cfunction.hoverByAction(TEMPLATE_NAME_LIST_XPATH + "[" + i + "]");
					cfunction.Commmon_Click("xpath", TEMPLATE_NAME_LIST_XPATH + "[" + i + "]");
					cfunction.Commmon_Click("xpath", "(//div[@class='actionBarSection']/div/button)");
					cfunction.sync(2);
					cfunction.Commmon_Click("xpath", "(//div[@class='actionBarSection']/div/nav/a)[1]");
					cfunction.Commmon_Click("xpath", "//button[@class='btn ui-button noFill']/span");
					verify = true;
					break;
				} else {
					System.out.println("Template not available");
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean verifyBannerTitle(String tooltip) {
		// return cfunction.verifyToolTip(ERROR_ICON_XPATH, tooltip);
		try {
			WebElement element = CommonFunction.getWebElement("xpath", BANNER_TITLE_XPATH);
			String title = element.getText();
			System.out.println(title);
			if (title.contains(tooltip)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public static boolean verifyTYPEdrpdwnList(String[] requestType) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(TYPE_DROPDOWN_LIST_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String requestTypeTextFetch = cfunction.getElementText(TYPE_DROPDOWN_LIST_XPATH + "[" + i + "]");
				for (String a : requestType) {
					if (a.equalsIgnoreCase(requestTypeTextFetch)) {
						// cfunction.Commmon_Click("xpath", URL_DROPDOWN_LIST_XPATH + "[" + i + "]");
						System.out.println("request name verified: " + a);
						verify = true;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static boolean selectTYPEdrpdwnList(String requestType) throws Exception {
		boolean verify = false;
		try {
			List<WebElement> requestTypeList = driver.findElements(By.xpath(TYPE_DROPDOWN_LIST_XPATH));
			for (int i = 1; i <= requestTypeList.size(); i++) {
				String requestTypeTextFetch = cfunction.getElementText(TYPE_DROPDOWN_LIST_XPATH + "[" + i + "]");

				if (requestType.equalsIgnoreCase(requestTypeTextFetch)) {
					cfunction.Commmon_Click("xpath", URL_DROPDOWN_LIST_XPATH + "[" + i + "]");
					System.out.println("request name verified: ");
					verify = true;
					break;
				}

			}
		} catch (Exception e) {
			throw e;
		}
		return verify;
	}

	public static void selectLocationOnMap(String step, String canvasStep) throws Exception {
		boolean overwriteStep = true;
		// cfunction.sync(5);
		step = step.replaceAll(" ", "") + "_1280x768";
		canvasStep = canvasStep.replaceAll(" ", "").replaceAll("/", "") + "_1280x768";
		SikuliHelp.dragndrop_New(step, canvasStep);
	}

}
