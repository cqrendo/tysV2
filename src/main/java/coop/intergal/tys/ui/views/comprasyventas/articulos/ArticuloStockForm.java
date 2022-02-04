package coop.intergal.tys.ui.views.comprasyventas.articulos;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

import coop.intergal.AppConst;
import coop.intergal.ui.components.EsDatePicker;
import coop.intergal.ui.components.FormButtonsBar;
import coop.intergal.ui.views.DynamicGridForPick;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

@Tag("articulo-stock-form")
@JsModule("./src/views/ComprasYVentas/Articulos/articulo-stock-form.js")
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Route(value = "displayStockArticulo")
@NpmPackage(value = "@polymer/iron-pages", version = "3.0.1")  // when the view uses iron-pages, can be also be indicated in package.json file, but if is delete and regenerate will be loose
//public class DynamicForm extends PolymerTemplate<TemplateModel> implements BeforeEnterObserver, CrudForm<DynamicDBean> {
public class ArticuloStockForm extends GenericDynamicForm implements BeforeEnterObserver {//, CrudForm<DynamicDBean> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//public class DynamicForm extends	Component implements BeforeEnterObserver, CrudForm<DynamicDBean> {
	@Id("title")
	private H3 title;
	
//	@Id("buttons")
//	private FormButtonsBar buttons;
	@Id("col2")
	private EsDatePicker col2;	
	@Id("col3")
	private IntegerField col3;
	@Id("col4")
	private TextField col4;
	@Id("col5")
	private TextField col5;
	@Id("col7")
	private TextField col7;
	@Id("col10")
	private TextField col10;
	@Id("col11")
	private TextField  col11;
	@Id("col12")
	private TextField  col12;	
	@Id("col13")
	private TextField col13;
	@Id("col18")
	private TextField col18;
	@Id("col21")
	private TextField col21;
	@Id("col25")
	private TextField col25;

	
//		private BeanValidationBinder<DynamicDBean> binder;

	private DynamicDBean bean;


	private DdbDataBackEndProvider dataProvider;

	
	public ArticuloStockForm() {
	}

//	@Override
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		if (bean != null)
			binder.setBean(bean);
		bindFields(ArticuloStockForm.class, this);
	}	
//	protected LocalDate getLocalDateOf(String col42) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public Instant getInstantOf(String col4) {
//					
//		return null;
//	}	
//	private String getDateString(Date toSet) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public FormButtonsBar getButtons() {
//		return buttons;
//	}

//	@Override
//	public HasText getTitle() {
//		return title;
//		
//	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
//		UI.getCurrent().getPage().addHtmlImport("frontend://src/views/admin/products/dynamic-form.html");
		if (bean != null)
			binder.setBean(bean);
		Element child = new Element ("div");
		child.setText("XXX");
		this.getElement().appendChild(child);
	}
	public DynamicDBean getBean() {
		return bean;
	}

	public void setBean(DynamicDBean bean) {
		this.bean = bean;
	}
	public DdbDataBackEndProvider getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(DdbDataBackEndProvider dataProvider) {
		this.dataProvider = dataProvider;
	}
}
