package coop.intergal.tys.ui;

import static coop.intergal.AppConst.PAGE_PRODUCTS;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.polymertemplate.TemplateParser;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.AppConst;
import coop.intergal.ui.utils.converters.CurrencyFormatter;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import coop.intergal.vaadin.rest.utils.RestData;

//@Tag("dynamic-view-grid")
@Tag("sub-menu")
@JsModule("./src/sub-menu.js")
@Route(value = AppConst.PAGE_SUBMENU, layout = MainLayout.class)
//@PageTitle(AppConst.TITLE_MENU_PRINCIPAL)
//@Secured(Role.ADMIN)
public class SubMenu extends PolymerTemplate<TemplateModel> implements BeforeEnterObserver,AfterNavigationObserver, HasDynamicTitle {
	private ArrayList<String[]> rowsColList; //= getRowsCnew String[] { "code_customer", "name_customer", "cif", "amountUnDisbursedPayments" };
	private String preConfParam = "GferPrueba";
	public ArrayList<String[]> getRowsColList() {
		return rowsColList;
	}

	public void setRowsColList(ArrayList<String[]> rowsColList) {
		this.rowsColList = rowsColList;
	}	

	public SubMenu() {
		super();
//		setupGrid();
		
	}

	public SubMenu(TemplateParser parser, VaadinService service) {
		super(parser, service);
		// TODO Auto-generated constructor stub
	}

	public SubMenu(TemplateParser parser) {
		super(parser);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id("butomGroup1")
	private VerticalLayout vlButomsGroup1;
  
	@Id("butomGroup2")
	private VerticalLayout vlButomsGroup2;

//	private CrudEntityPresenter<DynamicDBean> presenter;

	private final BeanValidationBinder<DynamicDBean> binder = new BeanValidationBinder<>(DynamicDBean.class);
	

	private CurrencyFormatter currencyFormatter = new CurrencyFormatter();

	private String resourceName;
	private String filter;
	private String title = AppConst.TITLE_MENU_PRINCIPAL;

//	@Autowired()
//	public DynamicViewGrid(CrudEntityPresenter<DynamicDBean> presenter, CrudForm<DynamicDBean> form) {
//		super(EntityUtil.getName(DynamicDBean.class), form);
//		this.presenter = presenter;
//		form.setBinder(binder);
//
//		setupEventListeners();
//		setupGrid();
////		presenter.setView(this);
//	}

	private void setupButtons() {
		vlButomsGroup1.removeAll();
	
//		DdbDataProvider dataProvider = new DdbDataProvider();
//		dataProvider.setPreConfParam("GferPrueba");
//		dataProvider.setResourceName(resourceName);
//		String filter = "isFKidMenu=1";//null ;//"name_serial is not nul";
		DdbDataBackEndProvider dataProvider = new DdbDataBackEndProvider();
		dataProvider.setPreConfParam(AppConst.PRE_CONF_PARAM);
		dataProvider.setResourceName("CR-menu");
//		grid.addColumn(DynamicDBean::getCol1).setHeader("Product Name").setFlexGrow(10);
		rowsColList = dataProvider.getRowsColList();
//		grid.removeAllColumns();
		int numberOFCols =rowsColList.size();//length;

		Collection<DynamicDBean> menuList = RestData.getResourceData(0,0,"CR-menu", AppConst.PRE_CONF_PARAM_METADATA , rowsColList, filter, false, false);
		Iterator<DynamicDBean> itMenuList = menuList.iterator();
		while (itMenuList.hasNext())
		{
			DynamicDBean rowMenu = itMenuList.next();
			String optionName = rowMenu.getCol0().toString();
			String resourceName = rowMenu.getCol4();
			if (resourceName.equals("null") || resourceName.length() == 0)
			{

				Button  titulo = new Button(optionName);
				String losThemes = rowMenu.getRowJSon().get("theme").asText();
				titulo.addThemeNames(losThemes);


				vlButomsGroup1.add(titulo);
				JsonNode rowNode = rowMenu.getRowJSon();
				Iterator<JsonNode> subMenus = rowNode.get("List-menu").elements();
				while (subMenus.hasNext())
				{
					JsonNode rowSubMenu = subMenus.next();
					String optionNameSubmenu = rowSubMenu.get("optionName").asText();
					Button  button1 = new Button(optionNameSubmenu, evt -> processButon(evt,rowSubMenu ));
					losThemes = rowSubMenu.get("theme").asText();
					button1.addThemeNames(losThemes);
					
					vlButomsGroup1.add(button1);
				}
			}
			else
			{
				Button  button1 = new Button(optionName, evt -> processButon(evt,rowMenu.getRowJSon() ));
				String losThemes = rowMenu.getRowJSon().get("theme").asText();
				button1.addThemeNames(losThemes);
				vlButomsGroup1.add(button1);
			}
			
		}
//		vlButomsGroup1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//		vlButomsGroup2.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//		Button  button1 = new Button("boton 1", evt -> processButon(evt));
//		Button  button2 = new Button("boton 2", evt -> processButon(evt));
//		button1.getElement().setAttribute("theme", "Text");
		
//		vlButomsGroup1.add(button1);
//		vlButomsGroup2.add(button2);
//		grid.setDataProvider(dataProvider);
//		grid.addColumn(DynamicDBean::getCol1).setHeader("Product Name").setFlexGrow(10);
//		rowsColList = dataProvider.getRowsColList();
		
//		grid.removeAllColumns();
//		int numberOFCols =rowsColList.size();//length;
	//       addColumn(Customer::getId, new NumberRenderer()).setCaption("Id");
	}
private Object processButon(ClickEvent<Button> evt, JsonNode rowSubMenu) {
	
//	String urlBase = UI.getCurrent().getRouter().getUrlBase(SubMenu.class);
	String titleOption = rowSubMenu.get("optionName").asText();
	try {
		String urlBase = "../dymanic";
		String hostName = InetAddress.getLocalHost().getHostName() ;
		if (hostName.indexOf(".local") == -1) // to diferent when is running in local (Maven) or in remote (tys.war -> tomcat)
			urlBase= "../tys/dymanic";
	String resource = rowSubMenu.get("resource").asText();
	String queryFormClassName = rowSubMenu.get("queryFormClassName").asText();
	String displayFormClassName = rowSubMenu.get("displayFormClassName").asText();
	
	titleOption = titleOption.replace(" ", "%20");
//	UI.getCurrent().getPage().executeJavaScript("window.open('http://localhost:8080/dymanic?resourceName="+resource+"&title="+titleOption+"', '_blank');") ;
	UI.getCurrent().getPage().executeJavaScript("window.open('"+urlBase+"?resourceName="+resource+"&queryFormClassName="+queryFormClassName+"&displayFormClassName="+displayFormClassName+"&title="+titleOption+"', '_blank');") ;
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	// para abrir Resources LAC
	// ../dymanic?resourceName=@resources&title=ResourcesLAC&queryFormClassName=comprasyventas.compras.PedidoProveedorQuery&displayFormClassName=comprasyventas.compras.PedidoProveedorForm
	// http://localhost:8080/dymanic?resourceName=CR-resources&title=ResourcesLAC&queryFormClassName=dev.lac.ResourcesQuery&displayFormClassName=dev.lac.ResourcesForm
	// http://localhost:8080/dymanic?resourceName=CR-FormTemplate&title=FormTemplate&queryFormClassName=dev.lac.FormTemplateQuery&displayFormClassName=dev.lac.FormTemplateForm
}

//	@Override
//	protected CrudEntityPresenterREST<DynamicDBean> getPresenter() {
//		return presenter;
//	}

//	@Override
	protected String getBasePage() {
		return PAGE_PRODUCTS;
	}

//	@Override
	protected BeanValidationBinder<DynamicDBean> getBinder() {
		return binder;
	}



//	@Override
//	protected CrudEntityPresenter<DynamicDBean> getPresenter() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		QueryParameters queryParameters = event.getLocation().getQueryParameters();
		filter = queryParameters.getParameters().get("filter").get(0);
		filter=filter.replace("EEQQ", "=");
		title=queryParameters.getParameters().get("title").get(0);

		
//		QueryParameters queryParameters = event.getLocation().getQueryParameters();
//		filter = queryParameters.getParameters().get("filter").get(0);
//		filter=filter.replace("EEQQ", "=");
////		title=queryParameters.getParameters().get("title").get(0);
		setupButtons();
		
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return title;
	}

//	@Override
//	public void setParameter(BeforeEvent event, Long parameter) {
//		title="par "+parameter;
//		
//	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		QueryParameters queryParameters = event.getLocation().getQueryParameters();
		filter = queryParameters.getParameters().get("filter").get(0);
		filter=filter.replace("EEQQ", "=");
		title=queryParameters.getParameters().get("title").get(0);
		// TODO Auto-generated method stub
		
	}

//	@Override
//	protected CrudEntityPresenter<DynamicDBean> getPresenter() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
