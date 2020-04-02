package coop.intergal.tys.ui.views.dev.lac;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import coop.intergal.AppConst;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.ui.views.DynamicGridForPick;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

@Tag("resources-form")
@JsModule("./src/views/dev/lac/resources-form.js")
//@SpringComponent
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Route(value = "displayResources")
//public class DynamicForm extends PolymerTemplate<TemplateModel> implements BeforeEnterObserver, CrudForm<DynamicDBean> {
public class ResourcesForm extends GenericDynamicForm implements BeforeEnterObserver {//, CrudForm<DynamicDBean> {
	

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
	private TextField col2;
	
	@Id("col3")
	private TextField col3;
	
	@Id("col4")
	private TextField col4;


	
//		private BeanValidationBinder<DynamicDBean> binder;

	private DynamicDBean bean;

	private ArrayList<String[]> rowsColList;
	
	private DynamicGridForPick dynamicGridForPick = new DynamicGridForPick(); 

	
	@Id("dialogForPick")
	private Dialog dialogForPick;
	
	public ResourcesForm() {
		super();
		dialogForPick.setWidth(AppConst.DEFAULT_PICK_DIALOG_WITHD);
		dialogForPick.setHeight(AppConst.DEFAULT_PICK_DIALOG_HEIGHT);
	}

//	@Override
//	public void setBinder(BeanValidationBinder<DynamicDBean> binder2) {
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		bindFields(ResourcesForm.class, this);
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

}
