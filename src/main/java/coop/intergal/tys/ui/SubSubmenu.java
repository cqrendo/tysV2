package coop.intergal.tys.ui;

import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.AppConst;
import coop.intergal.ui.utils.converters.CurrencyFormatter;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import coop.intergal.vaadin.rest.utils.RestData;

import static coop.intergal.AppConst.PAGE_PRODUCTS;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.polymertemplate.TemplateParser;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;

/**
 * A Designer generated component for the sub-submenu template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("sub-submenu")
@JsModule("./src/sub-submenu.js")
@Route(value = "ssubmenu", layout = MainLayout.class)
public class SubSubmenu extends PolymerTemplate<TemplateModel> implements AfterNavigationObserver, HasDynamicTitle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id("butomGroup1")
	private VerticalLayout vlButomsGroup1;

	private String losThemes;
	private String filter = "";
	private final BeanValidationBinder<DynamicDBean> binder = new BeanValidationBinder<>(DynamicDBean.class);
	
	private ArrayList<String[]> rowsColList; 
	public ArrayList<String[]> getRowsColList() {return rowsColList;}
	public void setRowsColList(ArrayList<String[]> rowsColList) {this.rowsColList = rowsColList;}	

	private String title = AppConst.TITLE_MENU_PRINCIPAL;

	private int esTab = 0;

	public SubSubmenu() {
		super();
	}

	public SubSubmenu(String filter2) {
		filter = filter2;
		esTab  = 1;
		setupButtons();
	}
	private void setupButtons() {
		vlButomsGroup1.removeAll();
		
		DdbDataBackEndProvider dataProvider = new DdbDataBackEndProvider();
		dataProvider.setPreConfParam(AppConst.PRE_CONF_PARAM);
		dataProvider.setResourceName("CR-menu");
		rowsColList = dataProvider.getRowsColList();
		
		Collection<DynamicDBean> menuList = RestData.getResourceData(0,0,"CR-menu", AppConst.PRE_CONF_PARAM_METADATA, rowsColList, filter, false, false, null);
		Iterator<DynamicDBean> itMenuList = menuList.iterator();
		while (itMenuList.hasNext())
		{	
			Div div= new Div();
			div.getStyle().set("display", "table");
			div.getStyle().set("width", "100%");
			DynamicDBean rowMenu = itMenuList.next();
			String optionName = rowMenu.getCol0().toString();
			String resourceName = rowMenu.getCol4();
			if (resourceName.equals("null") || resourceName.length() == 0)
			{
				Button  titulo = new Button(optionName);
				losThemes = rowMenu.getRowJSon().get("theme").asText();
				titulo.addThemeNames(losThemes);
				div.add(titulo);
				JsonNode rowNode = rowMenu.getRowJSon();
				Iterator<JsonNode> subMenus = rowNode.get("List-menu").elements();
				while (subMenus.hasNext())
				{
					Paragraph div2 = new Paragraph();
					div2.getStyle().set("margin", "0");
					JsonNode rowSubMenu = subMenus.next();
					String optionNameSubmenu = rowSubMenu.get("optionName").asText();
					Button  button1 = new Button(optionNameSubmenu, evt -> processButon(evt,rowSubMenu ));
					losThemes = rowSubMenu.get("theme").asText();
					button1.addThemeNames(losThemes);
					div2.add(button1);
					div.add(div2);
				}
			}
			else
			{
				Button  button1 = new Button(optionName, evt -> processButon(evt,rowMenu.getRowJSon() ));
				String losThemes = rowMenu.getRowJSon().get("theme").asText();
				button1.addThemeNames(losThemes);
				div.add(button1);
			}
			vlButomsGroup1.add(div);	
		}
	}
	
	private Object processButon(ClickEvent<Button> evt, JsonNode rowSubMenu) {
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
		UI.getCurrent().getPage().executeJs("window.open('"+urlBase+"?resourceName="+resource+"&queryFormClassName="+queryFormClassName+"&displayFormClassName="+displayFormClassName+"&title="+titleOption+"', '_blank');") ;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		if (esTab == 0) {
			QueryParameters queryParameters = event.getLocation().getQueryParameters();
			filter = queryParameters.getParameters().get("filter").get(0);
			filter=filter.replace("EEQQ", "=");
			title=queryParameters.getParameters().get("title").get(0);
			setupButtons();
		}
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return title;
	}
}
