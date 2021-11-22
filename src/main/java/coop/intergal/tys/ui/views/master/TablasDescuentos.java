package coop.intergal.tys.ui.views.master;

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
import coop.intergal.ui.views.DynamicGridForPick;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Span;

@Tag("tablas-descuentos")
@JsModule("./src/views/master/tablas-descuentos.js")
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Route(value = "tablasDescuentos")
@NpmPackage(value = "@polymer/iron-pages", version = "3.0.1")  // when the view uses iron-pages, can be also be indicated in package.json file, but if is delete and regenerate will be loose
//public class DynamicForm extends PolymerTemplate<TemplateModel> implements BeforeEnterObserver, CrudForm<DynamicDBean> {
public class TablasDescuentos extends GenericDynamicForm implements BeforeEnterObserver {//, CrudForm<DynamicDBean> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//public class DynamicForm extends	Component implements BeforeEnterObserver, CrudForm<DynamicDBean> {


	
//		private BeanValidationBinder<DynamicDBean> binder;

	private DynamicDBean bean;

	private ArrayList<String[]> rowsColList;
	
	private DynamicGridForPick dynamicGridForPick = new DynamicGridForPick(); 


	private DdbDataBackEndProvider dataProvider;

	private Div divSubGrid;

	@Id("col1")
	private TextField col1;

	@Id("col0")
	private TextField col0;

	@Id("col16")
	private TextField col16;

	@Id("col13")
	private TextField col13;

	@Id("col14")
	private TextField col14;

	@Id("col15")
	private TextField col15;

	@Id("col2")
	private TextField col2;

	@Id("col3")
	private TextField col3;

	@Id("col4")
	private TextField col4;

	@Id("col5")
	private TextField col5;

	@Id("col6")
	private TextField col6;

	@Id("col7")
	private TextField col7;

	@Id("col8")
	private TextField col8;

	@Id("col9")
	private TextField col9;

	@Id("col10")
	private TextField col10;

	@Id("col11")
	private TextField col11;

	@Id("col32")
	private TextField col32;

	@Id("col33")
	private TextField col33;

	@Id("col31")
	private TextField col31;

	@Id("span")
	private Span span;

	@Id("span1")
	private Span span1;

	@Id("span2")
	private Span span2;

	@Id("span3")
	private Span span3;

	@Id("col19")
	private TextField col19;

	@Id("col20")
	private TextField col20;

	@Id("col21")
	private TextField col21;

	@Id("col22")
	private TextField col22;

	@Id("col23")
	private TextField col23;

	@Id("col24")
	private TextField col24;

	@Id("col25")
	private TextField col25;

	@Id("col26")
	private TextField col26;

	@Id("col27")
	private TextField col27;

	@Id("col28")
	private TextField col28;

	@Id("col29")
	private TextField col29;

	
    public Div getDivSubGrid() {
		return divSubGrid;
	}

	public void setDivSubGrid(Div divSubGrid) {
		this.divSubGrid = divSubGrid;
	}

	
	public TablasDescuentos () {
		super();
//		dialogForPick.setWidth(AppConst.DEFAULT_PICK_DIALOG_WITHD);
//		dialogForPick.setHeight(AppConst.DEFAULT_PICK_DIALOG_HEIGHT);
	}

//	@Override
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		bindFields(TablasDescuentos.class, this);
//		super.setDialogForPick(dialogForPick);
//		Element child = new Element ("div");
//		child.setText("XXX");
//		this.getElement().appendChild(child);
//		gridForPick
//		dialogForPick.add(components);
//		DynamicGridForPick dynamicGridForPick = new DynamicGridForPick(); 
//		
//		dialogForPick.add(dynamicGridForPick);

	}	
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
		binder.setBean(bean);
	}
	public DdbDataBackEndProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(DdbDataBackEndProvider dataProvider) {
		this.dataProvider = dataProvider;
	}
}
