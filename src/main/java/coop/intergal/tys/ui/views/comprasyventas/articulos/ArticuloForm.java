package coop.intergal.tys.ui.views.comprasyventas.articulos;

import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.AppConst;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.dialog.Dialog;
import coop.intergal.ui.views.DynamicViewGrid;

/**
 * A Designer generated component for the articulo-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("articulo-form")
@JsModule("./src/views/ComprasYVentas/Articulos/articulo-form.js")
@Route(value = "displayArticulo")
public class ArticuloForm extends GenericDynamicForm implements BeforeEnterObserver{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id("col0")
	private TextField col0;
	@Id("col1")
	private TextField col1;
	
	private DynamicDBean bean;
	@Id("dialogForPick")
	private Dialog dialogForPick;
//	@Id("dvgrticuloSituacion")
//	private DynamicViewGrid dvgrticuloSituacion;
//	Eliminado del fichero js: <dynamic-grid id="dvgrticuloSituacion"></dynamic-grid>
	private DdbDataBackEndProvider dataProvider;

	/**
     * Creates a new ArticuloForm.
     */
    public ArticuloForm() {
		super();
		dialogForPick.setWidth(AppConst.DEFAULT_PICK_DIALOG_WITHD);
		dialogForPick.setHeight(AppConst.DEFAULT_PICK_DIALOG_HEIGHT);

        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between ArticuloForm and articulo-form
     */
    public interface ArticuloFormModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (bean != null)
		{
			binder.setBean(bean);
//			dvgrticuloSituacion.setResourceName("CR-ARTICULOS.List-ARTICULO_SITUACION");
//			dvgrticuloSituacion.setFilter("CLAVE_ARTICULO="+bean.getCol0());
//			dvgrticuloSituacion.setupGrid(true,true);
		}

		
	}
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		bindFields(ArticuloForm.class, this);
		super.setDialogForPick(dialogForPick);
	}
	public DdbDataBackEndProvider getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(DdbDataBackEndProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public void setBean(DynamicDBean bean) {
		System.out.println("ArticuloForm.setBean()");
		this.bean = bean;
		if (bean != null)
		{
			binder.setBean(bean);
//			dvgrticuloSituacion.setResourceName("CR-ARTICULOS.List-ARTICULO_SITUACION");
//			dvgrticuloSituacion.setFilter("CLAVE_ARTICULO="+bean.getCol0());
//			dvgrticuloSituacion.setupGrid(true,true);
		}
//		binder.setBean(bean);
	}
}

