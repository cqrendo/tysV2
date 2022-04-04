package coop.intergal.tys.ui.views.maestros.personasentidades;

import java.util.ArrayList;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.AppConst;
import coop.intergal.ui.views.DynamicGridForPick;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

/**
 * A Designer generated component for the proveedores-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("proveedores-form")
@JsModule("./src/views/Maestros/PersonasEntidades/proveedores-form.js")
@NpmPackage(value = "@polymer/iron-pages", version = "3.0.1")  // when the view uses iron-pages, can be also be indicated in package.json file, but if is delete and regenerate will be loose
public class ProveedoresForm extends GenericDynamicForm implements BeforeEnterObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id("dialogForPick")
	private Dialog dialogForPick;
	@Id("col2")
	private IntegerField col2;
	@Id("col31")
	private TextField col31;
	@Id("col0")
	private TextField col0;
	@Id("col43")
	private TextField col43;
	@Id("col48")
	private TextField col48;
	@Id("col49")
	private IntegerField col49;
	@Id("dvgEventos")
	private DynamicViewGrid dvgEventos;	
	
	private DynamicGridForPick dynamicGridForPick = new DynamicGridForPick(); 
	
	private DynamicDBean bean;
	private DdbDataBackEndProvider dataProvider;
	private ArrayList<String[]> rowsColList;
	private Div divSubGrid;

    public Div getDivSubGrid() {
		return divSubGrid;
	}

	public void setDivSubGrid(Div divSubGrid) {
		this.divSubGrid = divSubGrid;
	}

	/**
     * Creates a new ProveedoresForm.
     */
    public ProveedoresForm() {
		super();
		dialogForPick.setWidth(AppConst.DEFAULT_PICK_DIALOG_WITHD);
		dialogForPick.setHeight(AppConst.DEFAULT_PICK_DIALOG_HEIGHT);
    }
    
    public void setupGridEventos() {
    	dvgEventos.setResourceName("CR-PROVEEDORES.02List-FormExt__CONTACTOSPROVEEDORES");
    	dvgEventos.setFilter("CLAVEPROVEEDOR="+ bean.getCol2());
    	dvgEventos.setupGrid(false, true); // false es que no es modificable el grid, true que si
    	dvgEventos.setHasSideDisplay(false);
    	dvgEventos.setButtonsRowVisible(false);
//    	dvgEventos.getGrid().addSelectionListener(e -> {
//			if (e.getFirstSelectedItem().isPresent())
//				showBeanEntidad((DynamicDBean)e.getFirstSelectedItem().get());
//		});
	}
    
//	@Override
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		if (bean != null)
			binder.setBean(bean);
		bindFields(ProveedoresForm.class, this);
		super.setDialogForPick(dialogForPick);
		setupGridEventos();
	}
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (bean != null)
			binder.setBean(bean);
		setupGridEventos();
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
     * This model binds properties between ProveedoresForm and proveedores-form
     */
    public interface ProveedoresFormModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
