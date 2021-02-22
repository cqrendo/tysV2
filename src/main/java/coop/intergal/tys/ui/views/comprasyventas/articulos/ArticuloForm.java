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
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;

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
	@Id("col43")
	private TextField col43;
	@Id("col42")
	private TextField col42;
	@Id("col15")
	private TextField col15;
	@Id("col13")
	private TextField col13;
	@Id("col50")
	private TextField col50;
	@Id("col44")
	private TextField col44;
//	@Id("col42")
//	private TextField col42;
	@Id("col47")
	private TextField col47;
	@Id("col45")
	private TextField col45;
	@Id("col46")
	private TextField col46;

	@Id("col79")
	private TextField col79;
	@Id("col81")
	private TextField col81;
	@Id("col94")
	private TextField col94;
	@Id("col97")
	private TextField col97;
	@Id("col100")
	private TextField col100;
	@Id("col80")
	private TextField col80;
	@Id("col98")
	private TextField col98;
	@Id("col82")
	private TextField col82;
	@Id("col103")
	private TextField col103;

	private DynamicDBean bean;
	@Id("dialogForPick")
	private Dialog dialogForPick;
//	@Id("dvgrticuloSituacion")
//	private DynamicViewGrid dvgrticuloSituacion;
//	Eliminado del fichero js: <dynamic-grid id="dvgrticuloSituacion"></dynamic-grid>
	private DdbDataBackEndProvider dataProvider;
	@Id("col99")
	private Checkbox col99;
	@Id("col102")
	private Checkbox col102;
	@Id("col125")
	private TextField col125;
	@Id("col40")
	private TextField col40;
	@Id("col16")
	private TextField col16;
	@Id("col41")
	private TextField col41;
	@Id("col117")
	private ComboBox<String> col117;
	@Id("col14")
	private TextField col14;
	@Id("col51")
	private TextField col51;
	@Id("col2")
	private TextField col2;
	@Id("col11")
	private TextField col11;
	@Id("col12")
	private TextField col12;
	@Id("col25")
	private TextField col25;
	@Id("col26")
	private TextField col26;

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

