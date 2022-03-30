package coop.intergal.tys.ui.views.comprasyventas.compras;


import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

import coop.intergal.AppConst;
import coop.intergal.ui.components.QueryButtonsBar;
import coop.intergal.ui.util.UtilSessionData;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.ui.views.GenericDynamicQuery;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

@Tag("pedido-proveedor-query")
@JsModule("./src/views/ComprasYVentas/Compras/pedido-proveedor-query.js")
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Route(value = "queryPedidoProveedor")
//public class DynamicForm extends PolymerTemplate<TemplateModel> implements BeforeEnterObserver, CrudForm<DynamicDBean> {
public class PedidoProveedorQuery extends GenericDynamicQuery implements BeforeEnterObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String RESOURCE_NAME = "CR-ped_proveed_cab";
	private DynamicViewGrid grid;

	public PedidoProveedorQuery() {
		super();
		super.preConfParam = UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM;
		queryButtonsBar.addSearchListener(e -> createFilterFromQryForm());
		queryButtonsBar.addClearSearchListener(e -> cleanQryForm());//System.out.println("PedidoProveedorQuery.beforeEnter() BUSCAR>>>>"));
	}

	private Object cleanQryForm() {
		cleanForm(PedidoProveedorQuery.class, this, RESOURCE_NAME, false);
		return null;
	}

	private Object createFilterFromQryForm() {
		stringFilter = "";
		keysFromParent = "";
		String filter = getFieldsDataForFilter(PedidoProveedorQuery.class, this, RESOURCE_NAME);
		System.out.println("PedidoProveedorQuery.createFilter()...." + filter);
		DdbDataBackEndProvider dataProvider = grid.getDataProvider();
		dataProvider.setFilter(filter);
		dataProvider.refreshAll();
		return null;
	}
	public DynamicViewGrid getGrid() {
		return grid;
	}

	public void setGrid(DynamicViewGrid grid) {
		this.grid = grid;
	}

	//public class DynamicForm extends	Component implements BeforeEnterObserver, CrudForm<DynamicDBean> {
	@Id("title")
	private H3 title;
	@Id("queryButtonsBar")
	private QueryButtonsBar queryButtonsBar;
	@Id("col0")
	private TextField col0;
	@Id("col1")
	private TextField col1;
	@Id("col2")
	private TextField col2;
	@Id("col3")
	private TextField col3;
	@Id("col10")
	private TextField col10;
	@Id("col7")
	private TextField col7;
	@Id("col28")
	private TextField col28;
	@Id("col22")
	private TextField col22;
	@Id("col24")
	private TextField col24;
	@Id("col4")
	private TextField col4;
	
	private DynamicDBean bean;
	private ArrayList<String[]> rowsColList;

	protected LocalDate getLocalDateOf(String col42) {
		// TODO Auto-generated method stub
		return null;
	}
	public Instant getInstantOf(String col4) {
					
		return null;
	}	
	private String getDateString(Date toSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (bean != null)
			binder.setBean(bean);
		queryButtonsBar.addSearchListener(e -> System.out.println("PedidoProveedorQuery.beforeEnter() BUSCAR>>>>"));
	}

	public DynamicDBean getBean() {
		return bean;
	}

	public void setBean(DynamicDBean bean) {
		this.bean = bean;
		binder.setBean(bean);
	}

}
