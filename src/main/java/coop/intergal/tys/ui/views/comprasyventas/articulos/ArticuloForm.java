package coop.intergal.tys.ui.views.comprasyventas.articulos;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.AppConst;
import coop.intergal.ui.components.EsDatePicker;
import coop.intergal.ui.util.UtilSessionData;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

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
	private IntegerField col0;
	@Id("col1")
	private TextField col1;
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
	@Id("col10")
	private TextField col10;
	@Id("col11")
	private TextField col11;
	@Id("col12")
	private IntegerField col12;
	@Id("col13")
	private TextField col13;
	@Id("col14")
	private TextField col14;
	@Id("col15")
	private TextField col15;
	@Id("col16")
	private TextField col16;
	@Id("col19")
	private TextField col19;
	@Id("col20")
	private ComboBox<DynamicDBean> col20;
	@Id("col21")
	private TextField col21;
	@Id("col22")
	private TextField col22;
	@Id("col23")
	private TextField col23;
	@Id("col24")
	private TextField col24;
	@Id("col25")
	private IntegerField col25;
	@Id("col26")
	private IntegerField col26;
	@Id("col27")
	private TextField col27;
	@Id("col28")
	private TextField col28;
	@Id("col36")
	private TextField col36;
	@Id("col37")
	private TextField col37;
	@Id("col38")
	private TextField col38;
	@Id("col39")
	private TextField col39;
	@Id("col40")
	private TextField col40;
	@Id("col41")
	private TextField col41;
	@Id("col42")
	private TextField col42;
	@Id("col43")
	private TextField col43;
	@Id("col44")
	private TextField col44;
	@Id("col45")
	private TextField col45;
	@Id("col46")
	private TextField col46;
	@Id("col47")
	private TextField col47;
	@Id("col48")
	private TextField col48;
	@Id("col49")
	private TextField col49;
	@Id("col50")
	private TextField col50;
	@Id("col51")
	private TextField col51;
	@Id("col52")
	private TextField col52;
	@Id("col53")
	private TextField col53;
	@Id("col54")
	private EsDatePicker col54;
	@Id("col55")
	private TextField col55;
	@Id("col56")
	private TextField col56;
	@Id("col57")
	private TextField col57;
	@Id("col58")
	private TextField col58;
	@Id("col59")
	private Checkbox col59;
	@Id("col60")
	private TextField col60;
	@Id("col61")
	private TextField col61;
	@Id("col62")
	private TextField col62;
	@Id("col63")
	private TextField col63;
	@Id("col64")
	private TextField col64;
	@Id("col65")
	private TextField col65;
	@Id("col66")
	private TextField col66;
	@Id("col67")
	private TextField col67;
	@Id("col68")
	private TextField col68;
	@Id("col69")
	private ComboBox<DynamicDBean> col69;
	@Id("col70")
	private TextField col70;
	@Id("col71")
	private TextField col71;
	@Id("col72")
	private TextField col72;
	@Id("col73")
	private EsDatePicker col73;
	@Id("col74")
	private TextField col74;
	@Id("col75")
	private TextField col75;
	@Id("col76")
	private TextField col76;
	@Id("col77")
	private TextField col77;
	@Id("col78")
	private TextField col78;
	@Id("col79")
	private TextField col79;
	@Id("col80")
	private TextField col80;
	@Id("col81")
	private TextField col81;
	@Id("col82")
	private TextField col82;
	@Id("col84")
	private TextField col84;
	@Id("col85")
	private TextField col85;
	@Id("col86")
	private TextField col86;
	@Id("col87")
	private TextField col87;
	@Id("col88")
	private TextField col88;
	@Id("col89")
	private TextField col89;
	@Id("col90")
	private TextField col90;
	@Id("col91")
	private TextField col91;
	@Id("col92")
	private TextField col92;
	@Id("col93")
	private TextField col93;
	@Id("col94")
	private TextField col94;
	@Id("col95")
	private TextField col95;
	@Id("col96")
	private EsDatePicker col96;
	@Id("col97")
	private TextField col97;
	@Id("col98")
	private TextField col98;
	@Id("col99")
	private Checkbox col99;
	@Id("col100")
	private TextField col100;
	@Id("col101")
	private TextField col101;
	@Id("col102")
	private Checkbox col102;
	@Id("col104")
	private TextField col104;
	@Id("col105")
	private TextField col105;
	@Id("col106")
	private TextField col106;
	@Id("col107")
	private TextField col107;
	@Id("col108")
	private TextField col108;
	@Id("col109")
	private TextField col109;
	@Id("col110")
	private TextField col110;
	@Id("col111")
	private TextField col111;
	@Id("col112")
	private TextField col112;
	@Id("col113")
	private TextField col113;
	@Id("col114")
	private TextField col114;
	@Id("col115")
	private TextField col115;
	@Id("col116")
	private TextField col116;
	@Id("col117")
	private ComboBox<DynamicDBean> col117;
	@Id("col118")
	private TextField col118;
	@Id("col119")
	private ComboBox<DynamicDBean> col119;
	@Id("col120")
	private TextField col120;
	@Id("col121")
	private TextField col121;
	@Id("col122")
	private TextField col122;
	@Id("col123")
	private TextField col123;
	@Id("col124")
	private TextField col124;
	@Id("col125")
	private TextField col125;

	private DdbDataBackEndProvider dataProvider;
	private DynamicDBean bean;
	@Id("dialogForPick")
	private Dialog dialogForPick;
	@Id("dgAlter")
	private DynamicViewGrid dgAlter;
	@Id("dgColec")
	private DynamicViewGrid dgColec;
	@Id("dgFicha")
	private DynamicViewGrid dgFicha;
	@Id("dgOfProv")
	private DynamicViewGrid dgOfProv;
	@Id("dgEvol")
	private DynamicViewGrid dgEvol;
	@Id("dgConsProv")
	private DynamicViewGrid dgConsProv;
	@Id("dgOferta1")
	private DynamicViewGrid dgOferta1;
	@Id("dgOferta2")
	private DynamicViewGrid dgOferta2;
	@Id("dgTrans1")
	private DynamicViewGrid dgTrans1;
	@Id("dgTrans2")
	private DynamicViewGrid dgTrans2;
	@Id("dgTarif1")
	private DynamicViewGrid dgTarif1;
	@Id("dgTarif2")
	private DynamicViewGrid dgTarif2;
	@Id("btDetalle")
	private Button btDetalle;
	@Id("btProv")
	private Button btProv;
	@Id("btEan")
	private Button btEan;
	@Id("btArtSus")
	private Button btArtSus;
	@Id("btProvAlter")
	private Button btProvAlter;

		private Div divSubGrid;	
	    public Div getDivSubGrid() {
			return divSubGrid;
		}

		public void setDivSubGrid(Div divSubGrid) {
			this.divSubGrid = divSubGrid;
		}

		private DynamicViewGrid dVGrid;
		@Id("b1")
		private Button b1;
//		@Id("tbTab1")
//		private Tabs tbTab1;
		public DynamicViewGrid getDVGrid() {
			return dVGrid;
		}

		public void setDVGrid(DynamicViewGrid dVGrid) {
			this.dVGrid = dVGrid;
			super.setDVGrid(dVGrid);
		}
	/**
     * Creates a new ArticuloForm.
     */
		@EventHandler
		 private void handleClickTabStock() {
			keepSelectedPage("0");			
		}
		@EventHandler
		 private void handleClickTabValores() {
			keepSelectedPage("1");			
		}
		@EventHandler
		 private void handleClickTabImportes() {
			keepSelectedPage("2");			
		}
		@EventHandler
		 private void handleClickTabDatos() {
			keepSelectedPage("3");			
		}
	   @EventHandler
	    private void handleClickTabEvol() {
	        System.out.println("Click Tab Evol");
			dgEvol.setResourceName("CR-ARTICULOS.List-CONTROLSTOCKDIARIO__MJ");
			dgEvol.setFilter("CLAVEARTICULO="+bean.getCol0());
			dgEvol.getElement().getStyle().set("display", "block");
			dgEvol.setButtonsRowVisible(false);
			dgEvol.getGrid().setAllRowsVisible(true);
			dgEvol.setupGrid(true,true);
			keepSelectedPage("4");//tbTab1.getSelectedIndex();
	    }
		@EventHandler
		 private void handleClickTabVar() {
			keepSelectedPage("5");			
		}
	   @EventHandler
	    private void handleClickTabAlter() {
	        System.out.println("Click Tab Alter");
			dgAlter.setResourceName("CR-ARTICULOS.List-ARTICULOSCONPROVALTERNATIVO");
			dgAlter.setFilter("CLAVEARTICULO="+bean.getCol0());
			dgAlter.getElement().getStyle().set("display", "block");
			dgAlter.setButtonsRowVisible(false);
			dgAlter.getGrid().setAllRowsVisible(true);
			dgAlter.setupGrid(true,true);
			keepSelectedPage("6");//tbTab1.getSelectedIndex();
	    }



	@EventHandler
	    private void handleClickTabTarif() {
	        System.out.println("Click Tab Tar.Clie");
			dgTarif1.setResourceName("CR-ARTICULOS.List-TARIFACLIENTELIN");
			dgTarif1.setFilter("CLAVEARTICULO="+bean.getCol0());
			dgTarif1.getElement().getStyle().set("display", "block");
			dgTarif1.setButtonsRowVisible(false);
			dgTarif1.getGrid().setAllRowsVisible(true);
			dgTarif1.setupGrid(true,true);
			
			dgTarif2.setResourceName("CR-ARTICULOS.List-TARIFAOFERTASLIN__TARIFACLIENTE");
			dgTarif2.setFilter("CLAVEARTICULO="+bean.getCol0());
			dgTarif2.getElement().getStyle().set("display", "block");
			dgTarif2.setButtonsRowVisible(false);
			dgTarif2.getGrid().setAllRowsVisible(true);
			dgTarif2.setupGrid(true,true);
			keepSelectedPage("7");//tbTab1.getSelectedIndex();
	    }
	   @EventHandler
	    private void handleClickTabAlterOfertas() {
	        System.out.println("Click Tab ofertas");
			dgOferta1.setResourceName("CR-ARTICULOS.List-TARIFAOFERTASLIN__SINCLIENTE");
			dgOferta1.setFilter("CLAVEARTICULO="+bean.getCol0());
			dgOferta1.getElement().getStyle().set("display", "block");
			dgOferta1.setButtonsRowVisible(false);
			dgOferta1.getGrid().setAllRowsVisible(true);
			dgOferta1.setupGrid(true,true);
			
			dgOferta2.setResourceName("CR-ARTICULOS.List-TARIFAVENDEDORLIN");
			dgOferta2.setFilter("CLAVEARTICULO="+bean.getCol0());
			dgOferta2.getElement().getStyle().set("display", "block");
			dgOferta2.setButtonsRowVisible(false);
			dgOferta2.getGrid().setAllRowsVisible(true);
			dgOferta2.setupGrid(true,true);
			keepSelectedPage("8");//tbTab1.getSelectedIndex();
	    }
	   @EventHandler
	    private void handleClickTabOfProv() {
	        System.out.println("Click Tab Of.Prov");
			dgOfProv.setResourceName("CR-ARTICULOS.List-OFERTASPROVLIN");
			dgOfProv.setFilter("CLAVEARTICULO="+bean.getCol0());
			dgOfProv.getElement().getStyle().set("display", "block");
			dgOfProv.setButtonsRowVisible(false);
			dgOfProv.getGrid().setAllRowsVisible(true);
			dgOfProv.setupGrid(true,true);
			keepSelectedPage("9");//tbTab1.getSelectedIndex();
	    }
	   @EventHandler
	    private void handleClickTabConsProv() {
	        System.out.println("Click Tab Cons.Prov");
			dgConsProv.setResourceName("CR-ARTICULOS.List-CONSULTAPROVLIN");
			dgConsProv.setFilter("CLAVEARTICULO="+bean.getCol0());
			dgConsProv.getElement().getStyle().set("display", "block");
			dgConsProv.setButtonsRowVisible(false);
			dgConsProv.getGrid().setAllRowsVisible(true);
			dgConsProv.setupGrid(true,true);
			keepSelectedPage("10");//tbTab1.getSelectedIndex();
	    }
	   @EventHandler
	    private void handleClickTabColec() {
	        System.out.println("Click Tab Coleccion");
			dgColec.setResourceName("CR-ARTICULOS.List-COLECCION");
			dgColec.setFilter("ARTICULO="+bean.getCol0());
			dgColec.getElement().getStyle().set("display", "block");
			dgColec.setButtonsRowVisible(false);
			dgColec.getGrid().setAllRowsVisible(true);
			dgColec.setupGrid(true,true);
			keepSelectedPage("11");//tbTab1.getSelectedIndex();
	    }
	   @EventHandler
	    private void handleClickTabTrans() {
	        System.out.println("Click Tab Transformados");
			dgTrans1.setResourceName("CR-ARTICULOS.List-ARTICULOSTRANSFORMADOS__ORIGEN");
			dgTrans1.setFilter("ARTICULOORIGEN="+bean.getCol0());
			dgTrans1.getElement().getStyle().set("display", "block");
			dgTrans1.setButtonsRowVisible(false);
			dgTrans1.getGrid().setAllRowsVisible(true);
			dgTrans1.setupGrid(true,true);
			
			dgTrans2.setResourceName("CR-ARTICULOS.List-ARTICULOSTRANSFORMADOS__TRANSF");
			dgTrans2.setFilter("ARTICULOTRANSFORMADO="+bean.getCol0());
			dgTrans2.getElement().getStyle().set("display", "block");
			dgTrans2.setButtonsRowVisible(false);
			dgTrans2.getGrid().setAllRowsVisible(true);
			dgTrans2.setupGrid(true,true);
			keepSelectedPage("12");//tbTab1.getSelectedIndex();
	    }
	   @EventHandler
	    private void handleClickTabFicha() {
	        System.out.println("Click Tab Ficha");
			dgFicha.setResourceName("CR-ARTICULOS.List-ARTICULOSDETALLE");
			dgFicha.setFilter("CLAVE_ARTICULO="+bean.getCol0());
			dgFicha.getElement().getStyle().set("display", "block");
			dgFicha.setButtonsRowVisible(false);
			dgFicha.getGrid().setAllRowsVisible(true);
			dgFicha.setupGrid(true,true);
			keepSelectedPage("13");//tbTab1.getSelectedIndex();
	    }
	   
	   private void keepSelectedPage(String page) {
		String key = "ArticuloForm.keepSelectedPage";
		UtilSessionData.setFormParams(key, page);
	   }

    public ArticuloForm() {
		super();
		dialogForPick.setWidth(AppConst.DEFAULT_PICK_DIALOG_WITHD);
		dialogForPick.setHeight(AppConst.DEFAULT_PICK_DIALOG_HEIGHT);
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
			setBean(bean);
		}

		
	}
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		if (bean != null)
			binder.setBean(bean);
//		tbTab1.addSelectedChangeListener(e -> System.out.println("Click Tab "+ e.getSelectedTab()));
//		handleClickTabAlter();
//  		if (keepSelectedPage != 0)
//  			tbTab1.setSelectedIndex(keepSelectedPage);
		String keepSelectedPage = UtilSessionData.getFormParams("ArticuloForm.keepSelectedPage");
		if (keepSelectedPage == null)
			keepSelectedPage = "0";
		this.getElement().setProperty("page1", keepSelectedPage); // select the last tab that was ckicked
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
//		if (bean != null)
//		{
//			binder.setBean(bean);
		
//			dgAlter.setResourceName("CR-ARTICULOS.List-ARTICULOSCONPROVALTERNATIVO");
//			dgAlter.setFilter("CLAVEARTICULO="+bean.getCol0());
//			dgAlter.setupGrid(true,true);

//			dgColec.setResourceName("CR-ARTICULOS.List-COLECCION");
//			dgColec.setFilter("ARTICULO="+bean.getCol0());
//			dgColec.setupGrid(true,true);

//			dgFicha.setResourceName("CR-ARTICULOS.List-ARTICULOSDETALLE");
//			dgFicha.setFilter("CLAVE_ARTICULO="+bean.getCol0());
//			dgFicha.setupGrid(true,true);
			
//			dgOfProv.setResourceName("CR-ARTICULOS.List-OFERTASPROVLIN");
//			dgOfProv.setFilter("CLAVEARTICULO="+bean.getCol0());
//			dgOfProv.setupGrid(true,true);
			
//			dgEvol.setResourceName("CR-ARTICULOS.List-CONTROLSTOCKDIARIO-MJ");
//			dgEvol.setFilter("CLAVEARTICULO="+bean.getCol0());
//			dgEvol.setupGrid(true,true);
			
//			dgConsProv.setResourceName("CR-ARTICULOS.List-CONSULTAPROVLIN");
//			dgConsProv.setFilter("CLAVEARTICULO="+bean.getCol0());
//			dgConsProv.setupGrid(true,true);
			
//			dgOferta1.setResourceName("CR-ARTICULOS.List-TARIFAOFERTASLIN__SINCLIENTE");
//			dgOferta1.setFilter("CLAVEARTICULO="+bean.getCol0());
//			dgOferta1.setupGrid(true,true);
//			
//			dgOferta2.setResourceName("CR-ARTICULOS.List-TARIFAVENDEDORLIN");
//			dgOferta2.setFilter("CLAVEARTICULO="+bean.getCol0());
//			dgOferta2.setupGrid(true,true);
			
//			dgTarif1.setResourceName("CR-ARTICULOS.List-TARIFACLIENTELIN");
//			dgTarif1.setFilter("CLAVEARTICULO="+bean.getCol0());
//			dgTarif1.setupGrid(true,true);
//			
//			dgTarif2.setResourceName("CR-ARTICULOS.List-TARIFAOFERTASLIN__TARIFACLIENTE");
//			dgTarif2.setFilter("CLAVEARTICULO="+bean.getCol0());
//			dgTarif2.setupGrid(true,true);
			
//			dgTrans1.setResourceName("CR-ARTICULOS.List-ARTICULOSTRANSFORMADOS-_ORIGEN_");
//			dgTrans1.setFilter("ARTICULOORIGEN="+bean.getCol0());
//			dgTrans1.setupGrid(true,true);
//			
//			dgTrans2.setResourceName("CR-ARTICULOS.List-ARTICULOSTRANSFORMADOS__TRANSF");
//			dgTrans2.setFilter("ARTICULOTRANSFORMADO="+bean.getCol0());
//			dgTrans2.setupGrid(true,true);
//		}
	}
}

