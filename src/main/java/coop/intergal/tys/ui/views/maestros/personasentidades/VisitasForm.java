package coop.intergal.tys.ui.views.maestros.personasentidades;

import java.util.ArrayList;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.AppConst;
import coop.intergal.ui.views.DynamicGridForPick;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

/**
 * A Designer generated component for the visitas-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("visitas-form")
@JsModule("./src/views/Maestros/PersonasEntidades/visitas-form.js")
@NpmPackage(value = "@polymer/iron-pages", version = "3.0.1")  // when the view uses iron-pages, can be also be indicated in package.json file, but if is delete and regenerate will be loose
public class VisitasForm extends GenericDynamicForm implements BeforeEnterObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id("title")
	private H3 title;
	@Id("dialogForPick")
	
	private Dialog dialogForPick;
	private DynamicGridForPick dynamicGridForPick = new DynamicGridForPick(); 
	
	private DynamicDBean bean;
	private DdbDataBackEndProvider dataProvider;
	private ArrayList<String[]> rowsColList;

	/**
     * Creates a new VisitasForm.
     */
    public VisitasForm() {
		super();
		dialogForPick.setWidth(AppConst.DEFAULT_PICK_DIALOG_WITHD);
		dialogForPick.setHeight(AppConst.DEFAULT_PICK_DIALOG_HEIGHT);
    }
//	@Override
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		if (bean != null)
			binder.setBean(bean);
		bindFields(VisitasForm.class, this);
		super.setDialogForPick(dialogForPick);
	}
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (bean != null)
			binder.setBean(bean);
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
	
    /**
     * This model binds properties between VisitasForm and visitas-form
     */
    public interface VisitasFormModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
