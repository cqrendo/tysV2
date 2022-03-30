package coop.intergal;

import java.util.Locale;





public class AppConst {   // @@ TODO this class for now is copy and represents the default values, for generic utils class as converters, if you want to have different per project you must consider this 

	
	public static final String PRE_CONF_PARAM = "TYSLac0";//"GferJetty";
	public static final String PRE_CONF_PARAM_METADATA = "metadataLac0";
	public static final String CLEAR_REPORT_SERVER = "http://lac0.intergal.coop:9000/";
//	public static final String PRE_CONF_PARAM_METADATA = "metadataVMTYS";
//	public static final String PRE_CONF_PARAM = "VMTYS";//
//	public static final String CLEAR_REPORT_SERVER = "http://192.168.100.05:9000/";

	public static final String CURRENT_YEAR = "22";
	public static final Locale APP_LOCALE = new Locale("es","ES");

	public static final String PAGE_ROOT = "";
	public static final String PAGE_SUBMENU = "submenu";
	public static final String PAGE_STOREFRONT = "storefront";
	public static final String PAGE_STOREFRONT_EDIT = "storefront/edit";
	public static final String PAGE_DASHBOARD = "dashboard";
	public static final String PAGE_USERS = "users";
	public static final String PAGE_PRODUCTS = "products";
	public static final String PAGE_DYNAMIC_QGD	="dynamicQGD";
	public static final String PAGE_DYNAMIC_QG	="dynamicQG";
	public static final String PAGE_DYNAMIC_TREE = "dymanicTree";
	public static final String PAGE_LOGOUT = "logout";
	public static final String PAGE_DEFAULT = PAGE_STOREFRONT;

	public static final String ICON_STOREFRONT = "edit";
	public static final String ICON_DASHBOARD = "clock";
	public static final String ICON_USERS = "user";
	public static final String ICON_PRODUCTS = "calendar";
	public static final String ICON_LOGOUT = "arrow-right";

	public static final String TITLE_STOREFRONT = "Storefront";
	public static final String TITLE_DASHBOARD = "Dashboard";
	public static final String TITLE_USERS = "Users";
	public static final String TITLE_PRODUCTS = "Products";
	public static final String TITLE_LOGOUT = "Logout";
	public static final String TITLE_NOT_FOUND = "Page was not found";
	public static final String TITLE_ACCESS_DENIED = "Access denied";
	public static final String TITLE_MENU_PRINCIPAL = "Menu principal";
	public static final String PACKAGE_VIEWS = "coop.intergal.tys.ui.views.";
	

	public static final String[] ORDER_SORT_FIELDS = {"dueDate", "dueTime", "id"};
//	public static final Sort.Direction DEFAULT_SORT_DIRECTION = Sort.Direction.ASC;

	public static final String VIEWPORT = "width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes";
	public static final String DEFAULT_PICK_DIALOG_WITHD = "1024px";
	public static final String DEFAULT_PICK_DIALOG_HEIGHT = "800px";
	public static final String DEFAULT_API_NAME = "GFER";
	
	public static final String STYLES_CSS = "./styles/tysstyle.css";
	public static final String STYLES_FORM_ITEM_CSS= "./styles/tysstyle-form-item.css";
	public static final String STYLES_FORM_LAYOUT_ITEM_CSS= "./styles/tysstyle-form-layout.css";
	public static final String QUERY_FIELD_DEFAULT_SIZE = "25#25";
	public static final String DEFAULT_CSS_STYLE_QRY_FIELD =  ".labelM";
	public static final String LOGIN_NAME = "LOGIN_NAME";
	public static final String LOGIN_DESCRIPTION = "LOGIN_DESCRIPTION";
	public static final int MAX_NUMBER_OF_FIELDS_PER_TABLE = 150;
	public static final boolean INCLUDE_MAIN_LAYOUT = false;
	public static final String LOGIN_FORGETPASS_CONTENT ="Contraseña olvidada";
	public static final String LOGIN_FORGETPASS_ERROR = "LOGIN_FORGETPASS_ERROR";
	public static final String LOGIN_FORGETPASS_NOTEMAIL = "LOGIN_FORGETPASS_NOTEMAIL";
	public static final boolean DEBUG_GET_DATA_FROM_BACK_END = false;
	
	public static final String EMAIL_REMITENTE = "ampafacil.com@gmail.com";
	public static final String EMAIL_CLAVE = "Susita123%";
	public static final String EMAIL_HOST = "smtp.gmail.com";
	public static final String EMAIL_PORT = "587";
	public static final String LDAP_BASE = ",ou=central,ou=gfer,ou=tys,ou=groups";
	public static final String COUNT_USED_BY_DB = "COUNT(*)";// depending on DB the result for count is different by example  "count(*)"; para mysql y COUNT(*) para Oracle //
	public static final String DEFAULT_WIDTH_FORM = "1360px";
	public static final String DEFAULT_WIDTH_FORM_MONBUS = "1160px"; // change name for apply
	public static final String DEFAULT_FIELD_HEIGHT = "70px";
	
	public static final String TAGS_LIST = "company;user;row;ldap";
	public static final double DEFAULT_SPLIT_POS_QUERY_GRID = 200;
	public static final double DEFAULT_SPLIT_POS_GRID_DISPLAY = 5;
	public static final double DEFAULT_SPLIT_POS_DISPLAY_SUBGRID = 50;
	public static final String CLASS_FOR_METHODS = "coop.intergal.tys.ui.util.ClassForMethods";
	public static final String VALUE_TRUE_FOR_BOOLEANS = "1"; // Depends on database by Example ORACLE = 1, MySQL = true
	public static final String VALUE_FALSE_FOR_BOOLEANS = "0";
	public static final String FORMAT_FOR_DATETIME_FOR_JOIN = "TO_TIMESTAMP_TZ%28'#value#','YYYY-MM-DD%22T%22hh24:mi:ss'%29"; // is use in Oracle for JOIN as the parent data includes T by example 2021-01-13T17:26:36 , left empty for Mysql
	public static final String FORMAT_FOR_DATETIME = "TO_TIMESTAMP_TZ%28'#value#','YYYY-MM-DD hh24:mi:ss'%29"; // is use in Oracle (when you write a date with time in Query Form you don't use T  left empty for Mysql
	public static final String FORMAT_FOR_SHORTDATETIME = "TO_TIMESTAMP_TZ%28'#value#','YYYY-MM-DD'%29"; // is use in Oracle, left empty for Mysql
	public static final String RESOURCES_WITH_USER = "CR-ARTICULOS,CR-PED_PROVEED_CAB";
	public static final boolean CONFIRM_DELETE = true;
	public static final String REPORT_PATH = "c:/reports/<<company>>/";
	public static final String USER_PK = "lOGIN='<<user>>'";
	public static final String USER_TABLE = "FISCALEURO:USUARIOS";
	public static final String DEFAULT_COMPANY = "GFER";

//	public static final String FORMAT_FOR_DATETIME = "TO_TIMESTAMP_TZ('#value#','YYYY-MM-DD\"T\"hh24:mi:ss')"; // is use in Oracle, left empty for Mysql
	
	



	// Mutable for testing.
	public static int NOTIFICATION_DURATION = 4000;


}
