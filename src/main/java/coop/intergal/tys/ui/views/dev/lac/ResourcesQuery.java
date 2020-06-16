package coop.intergal.tys.ui.views.dev.lac;


import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;

import coop.intergal.AppConst;
import coop.intergal.tys.ui.components.QueryButtonsBar;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.ui.views.GenericDynamicQuery;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

@Tag("resources-query")
@JsModule("./src/views/dev/lac/resources-query.js")
//@SpringComponent
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Route(value = "queryPedidoProveedor")
//public class DynamicForm extends PolymerTemplate<TemplateModel> implements BeforeEnterObserver, CrudForm<DynamicDBean> {
public class ResourcesQuery extends GenericDynamicQuery {//implements BeforeEnterObserver, CrudForm<DynamicDBean> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String RESOURCE_NAME = "CR-resources";
	private DynamicViewGrid grid;

	public ResourcesQuery() {
		super();
		super.preConfParam = AppConst.PRE_CONF_PARAM;
		queryButtonsBar.addSearchListener(e -> createFilterFromQryForm());
		queryButtonsBar.addClearSearchListener(e -> cleanQryForm());//System.out.println("PedidoProveedorQuery.beforeEnter() BUSCAR>>>>"));
	}

	private Object cleanQryForm() {
		cleanForm(ResourcesQuery.class, this, RESOURCE_NAME, false);
		return null;
	}

	private Object createFilterFromQryForm() {
		stringFilter = "";
		keysFromParent = "";
		String filter = getFieldsDataForFilter(ResourcesQuery.class, this, RESOURCE_NAME);
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
	
	
//		private BeanValidationBinder<DynamicDBean> binder;

	private DynamicDBean bean;

	private ArrayList<String[]> rowsColList;

//	private FormButtonsBar buttons;

	@Id("queryButtonsBar")
	private QueryButtonsBar queryButtonsBar;




	@Id("col1")
	private TextField col1;






//	@Override
//	public void setBinder(BeanValidationBinder<DynamicDBean> binder2) {
//		super.binder = binder2;
//		bindFields(PedidoProveedorQuery.class, this);
//		Element child = new Element ("div");
//		child.setText("XXX");
//		this.getElement().appendChild(child);
//	}	
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
//	@Override
//	public FormButtonsBar getButtons() {
//		return buttons;
//	}

//	@Override
//	public HasText getTitle() {
//		return title;
//		
//	}

//	@Override
//	public void beforeEnter(BeforeEnterEvent event) {
////		UI.getCurrent().getPage().addHtmlImport("frontend://src/views/admin/products/dynamic-form.html");
//		if (bean != null)
//			binder.setBean(bean);
//		Element child = new Element ("div");
//		child.setText("XXX");
//		this.getElement().appendChild(child);
//		queryButtonsBar.addSearchListener(e -> System.out.println("PedidoProveedorQuery.beforeEnter() BUSCAR>>>>"));
//	}

	public DynamicDBean getBean() {
		return bean;
	}

	public void setBean(DynamicDBean bean) {
		this.bean = bean;
		binder.setBean(bean);
	}

}
