package coop.intergal.tys.ui.views.comprasyventas.compras;

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
import com.vaadin.flow.component.dialog.Dialog;
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

@Tag("pedido-proveedor-form")
@JsModule("./src/views/ComprasYVentas/Compras/pedido-proveedor-form.js")
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Route(value = "displayPedidoProveedor")
//public class DynamicForm extends PolymerTemplate<TemplateModel> implements BeforeEnterObserver, CrudForm<DynamicDBean> {
public class PedidoProveedorForm extends GenericDynamicForm implements BeforeEnterObserver {//, CrudForm<DynamicDBean> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//public class DynamicForm extends	Component implements BeforeEnterObserver, CrudForm<DynamicDBean> {
	@Id("title")
	private H3 title;
	
//	@Id("buttons")
//	private FormButtonsBar buttons;

	@Id("col0")
	private TextField col0;

	@Id("col1")
	private TextField col1;

	@Id("col2")
	private EsDatePicker col2;
	
	@Id("col3")
	private IntegerField col3;
	
	@Id("col4")
	private TextField col4;

	@Id("col5")
	private TextField col5;

	@Id("col6")
	private IntegerField col6;
	
	@Id("col7")
	private IntegerField col7;
	
	@Id("col8")
	private TextField col8;
	
	@Id("col9")
	private TextField col9;
	
	@Id("col10")
	private EsDatePicker col10;
	

	@Id("col12")
	private ComboBox<DynamicDBean>  col12;
	
	@Id("col13")
	private TextField col13;
	
	@Id("col14")
	private TextField col14;
	
	@Id("col15")
	private TextField col15;
	
	@Id("col16")
	private TextField col16;
	
	@Id("col17")
	private TextField col17;
	
	@Id("col18")
	private TextField col18;
	
	@Id("col19")
	private TextField col19;
	
	@Id("col20")
	private IntegerField col20;
	
	@Id("col21")
	private TextField col21;
	
	@Id("col22")
	private IntegerField col22;
	
	@Id("col23")
	private TextField col23;
	
	@Id("col24")
	private TextField col24;
	
	@Id("col25")
	private TextField col25;
			
	@Id("col27")
	private TextField col27;
	
	@Id("col28")
	private TextField col28;


	
//		private BeanValidationBinder<DynamicDBean> binder;

	private DynamicDBean bean;

	private ArrayList<String[]> rowsColList;
	
	private DynamicGridForPick dynamicGridForPick = new DynamicGridForPick(); 

	@Id("col26")
	private TextArea col26;
	
	@Id("vaadinButton")
	private Button vaadinButton;

	@Id("col11")
	private TextArea col11;

	@Id("col31")
	private Checkbox col31;
	
	@Id("col32")
	private TextField col32;
	
	@Id("col33")
	private TextField col33;
	
	@Id("col34")
	private TextField col34;
	
	@Id("col35")
	private TextField col35;

	@Id("col36")
	private TextField col36;

	@Id("col37")
	private TextField col37;

	@Id("col38")
	private TextField col38;
	
	@Id("col39")
	private TextField col39;

	@Id("dialogForPick")
	private Dialog dialogForPick;

	private DdbDataBackEndProvider dataProvider;
	
	public PedidoProveedorForm() {
		super();
		dialogForPick.setWidth(AppConst.DEFAULT_PICK_DIALOG_WITHD);
		dialogForPick.setHeight(AppConst.DEFAULT_PICK_DIALOG_HEIGHT);
	}

//	@Override
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		bindFields(PedidoProveedorForm.class, this);
		super.setDialogForPick(dialogForPick);
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
