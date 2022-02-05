package coop.intergal.tys.ui.views.comprasyventas.articulos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.AxisTitle;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataLabels;
import com.vaadin.flow.component.charts.model.ListSeries;
import com.vaadin.flow.component.charts.model.PlotOptionsBar;
import com.vaadin.flow.component.charts.model.Tooltip;
import com.vaadin.flow.component.charts.model.VerticalAlign;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.AppConst;
import coop.intergal.ui.util.UtilSessionData;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import coop.intergal.vaadin.rest.utils.RestData;


/**
 * A Designer generated component for the articulo-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("histograma-evol-mes-form")
@JsModule("./src/views/ComprasYVentas/Articulos/histograma-evol-mes-form.js")
@Route(value = "histogramaArticuloEvol")
public class HistogramaEvolMesForm extends GenericDynamicForm implements BeforeEnterObserver{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id("cols2")
	private TextField cols2;
	@Id("cols3")
	private TextField cols3;
	@Id("cols5")
	private TextField cols5;
	@Id("cols11")
	private TextField cols11;
	@Id("cols12")
	private TextField cols12;
	@Id("cols13")
	private TextField cols13;
	@Id("cols14")
	private TextField cols14;
	@Id("cols15")
	private TextField cols15;
	@Id("cols20")
	private TextField cols20;
	@Id("cols21")
	private TextField cols21;
	@Id("cols22")
	private TextField cols22;
	@Id("cols23")
	private TextField cols23;
	@Id("cols27")
	private TextField cols27;
	@Id("cols29")
	private TextField cols29;
	@Id("cols30")
	private TextField cols30;
	@Id("cols31")
	private TextField cols31;
	@Id("cols32")
	private TextField cols32;
	@Id("cols36")
	private TextField cols36;
	@Id("cols37")
	private TextField cols37;
	@Id("cols38")
	private TextField cols38;
	@Id("cols39")
	private TextField cols39;
	@Id("cols48")
	private TextField cols48;
	@Id("cols49")
	private TextField cols49;
	@Id("cols50")
	private TextField cols50;
	@Id("alm3")
	private TextField alm3;
	@Id("alm7")
	private TextField alm7;
	@Id("alm10")
	private TextField alm10;
	@Id("alm17")
	private TextField alm17;
	@Id("alm18")
	private TextField alm18;
	@Id("alm19")
	private TextField alm19;
	@Id("alm20")
	private TextField alm20;
	@Id("alm21")
	private TextField alm21;
	@Id("alm34")
	private TextField alm34;
	@Id("alm35")
	private TextField alm35;
	@Id("alm36")
	private TextField alm36;
	@Id("alm37")
	private TextField alm37;
	@Id("alm38")
	private TextField alm38;
	@Id("alm40")
	private TextField alm40;
	@Id("alm41")
	private TextField alm41;
	@Id("alm42")
	private TextField alm42;
	@Id("char1")
	private Div char1;
	@Id("char2")
	private Div char2;
	@Id("char3")
	private Div char3;
	@Id("char4")
	private Div char4;
	@Id("col13")
	private TextField col13;
	@Id("col14")
	private TextField col14;
	@Id("col15")
	private Checkbox col15;
	@Id("btActualizar")
	private Button btActualizar;
	
	private String almacenInicial;
	private String claveArticulo;
	private DdbDataBackEndProvider dataProvider;
	private DynamicDBean bean;
	private DynamicDBean beanAlm = new DynamicDBean();
	private DynamicDBean beanGen = new DynamicDBean();
	private String desde;
	private String hasta;
	private Div divSubGrid;
	public Div getDivSubGrid() {
		return divSubGrid;
	}
	public void setDivSubGrid(Div divSubGrid) {
		this.divSubGrid = divSubGrid;
	}
	private DynamicViewGrid dVGrid;
	public DynamicViewGrid getDVGrid() {
		return dVGrid;
	}
	public void setDVGrid(DynamicViewGrid dVGrid) {
		this.dVGrid = dVGrid;
		super.setDVGrid(dVGrid);
	}
	
	/**
     * Creates a new HistogramaEvolMesForm.
     */
	   @EventHandler
	    private void handleClickTab1() {
	        System.out.println("handleClickTab1");
//			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUMENSUAL","SALIDAS","ENTRADAS", char1, "CLAVEARTICULO="+claveArticulo+"%20AND%20CLAVEALMACEN="+almacenInicial, "Almacén "+almacenInicial);
			montaChar("CR-ARTICULOS.0List-FormExt__ARTICULO_SITUACION.00List-FormExt__ARTICULO_SITUACION__EvolMes.01List-ARTISITUMENSUAL","SALIDAS","ENTRADAS", char1, "CLAVEARTICULO="+claveArticulo+"%20AND%20CLAVEALMACEN="+almacenInicial, "Almacén "+almacenInicial);
	    }

	   @EventHandler
	    private void handleClickTab2() {
	        System.out.println("handleClickTab2");
//			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUGLOBAL__MJ","TOTALSALIDAS","TOTALENTRADAS", char2, "CLAVEARTICULO="+claveArticulo, "Global");
			montaChar("CR-ARTICULOS.0List-FormExt__ARTICULO_SITUACION.00List-FormExt__ARTICULO_SITUACION__EvolMes.02List-ARTISITUGLOBAL__MJ","TOTALSALIDAS","TOTALENTRADAS", char2, "CLAVEARTICULO="+claveArticulo, "Global");
	    }

	   @EventHandler
	    private void handleClickTab3() {
	        System.out.println("handleClickTab2");
//			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUGALICIA__MJ","TOTALSALIDAS","TOTALENTRADAS", char3, "CLAVEARTICULO="+claveArticulo, "Galicia (G)");
			montaChar("CR-ARTICULOS.0List-FormExt__ARTICULO_SITUACION.00List-FormExt__ARTICULO_SITUACION__EvolMes.03List-ARTISITUGALICIA__MJ","TOTALSALIDAS","TOTALENTRADAS", char3, "CLAVEARTICULO="+claveArticulo, "Galicia (G)");
	    }

	   @EventHandler
	    private void handleClickTab4() {
	        System.out.println("handleClickTab2");
//			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUTODAGALICIA__MJ","TOTALSALIDAS","TOTALENTRADAS", char4, "CLAVEARTICULO="+claveArticulo, "Galicia (T)");
			montaChar("CR-ARTICULOS.0List-FormExt__ARTICULO_SITUACION.00List-FormExt__ARTICULO_SITUACION__EvolMes.04List-ARTISITUTODAGALICIA__MJ","TOTALSALIDAS","TOTALENTRADAS", char4, "CLAVEARTICULO="+claveArticulo, "Galicia (T)");
	    }

    public HistogramaEvolMesForm() {
		super();
    }

	/**
     * This model binds properties between ArticuloForm and articulo-form
     */
    public interface HistogramaEvolMesFormModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
	}

	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		if (bean != null)
			binder.setBean(bean);
		bindFields(HistogramaEvolMesForm.class, this);
	}
	public DdbDataBackEndProvider getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(DdbDataBackEndProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public void setBean(DynamicDBean bean) {
		System.out.println("HistogramaEvolMesForm.setBean()");
		this.bean = bean;
		if (bean != null)
		{
			claveArticulo = bean.getCol51();
			almacenInicial = bean.getCol52();
			calculaAlmacen();
			montaChar("CR-ARTICULOS.0List-FormExt__ARTICULO_SITUACION.00List-FormExt__ARTICULO_SITUACION__EvolMes.01List-ARTISITUMENSUAL","SALIDAS","ENTRADAS", char1, "CLAVEARTICULO="+claveArticulo+"%20AND%20CLAVEALMACEN="+almacenInicial, "Almacén "+almacenInicial);
		}
	}

    private void calculaAlmacen() {
//		beanAlm = RestData.getOneRow("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION", "CLAVE_ARTICULO="+claveArticulo+"%20AND%20CLAVE_ALMACEN="+almacenInicial, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM, null);
		beanAlm = RestData.getOneRow("CR-ARTICULOS.0List-FormExt__ARTICULO_SITUACION", "CLAVE_ARTICULO="+claveArticulo+"%20AND%20CLAVE_ALMACEN="+almacenInicial, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM, null);
		if (beanAlm != null) {
			int a = Integer.parseInt(AppConst.CURRENT_YEAR)-1;
			desde = "20"+a+"01";//beanAlm.getCol14();
			hasta = beanAlm.getCol15();
			alm3.setValue(beanAlm.getCol3()); 
			alm7.setValue(beanAlm.getCol7()); 
			alm10.setValue(beanAlm.getCol10());
			alm17.setValue(beanAlm.getCol17());
			alm18.setValue(beanAlm.getCol18());
			alm19.setValue(beanAlm.getCol19());
			alm20.setValue(beanAlm.getCol20());
			alm21.setValue(beanAlm.getCol21());
			alm34.setValue(beanAlm.getCol34());
			alm35.setValue(beanAlm.getCol35());
			alm36.setValue(beanAlm.getCol36());
			alm37.setValue(beanAlm.getCol37());
			alm38.setValue(beanAlm.getCol38());
			alm40.setValue(beanAlm.getCol40());
			alm41.setValue(beanAlm.getCol41());
			alm42.setValue(beanAlm.getCol42());
		}
		beanGen = RestData.getOneRow("CR-ARTICULOS.List-ARTICULOS_CONTROL_STOCK", "CLAVE_ARTICULO="+claveArticulo, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM, null);
		if (beanGen != null) {
			col13.setValue(bean.getCol13()); 
			col14.setValue(bean.getCol14()); 
			if (bean.getCol15().equals("1"))
				col15.setValue(true);
			else 
				col15.setValue(false);
			cols2.setValue(beanGen.getCol2());
			cols3.setValue(beanGen.getCol3());
			cols5.setValue(beanGen.getCol5());
			cols11.setValue(beanGen.getCol11());
			cols12.setValue(beanGen.getCol12());
			cols13.setValue(beanGen.getCol13());
			cols14.setValue(beanGen.getCol14());
			cols15.setValue(beanGen.getCol15());
			cols20.setValue(beanGen.getCol20());
			cols21.setValue(beanGen.getCol21());
			cols22.setValue(beanGen.getCol22());
			cols23.setValue(beanGen.getCol23());
			cols27.setValue(beanGen.getCol27());
			cols29.setValue(beanGen.getCol29());
			cols30.setValue(beanGen.getCol30());
			cols31.setValue(beanGen.getCol31());
			cols32.setValue(beanGen.getCol32());
			cols36.setValue(beanGen.getCol36());
			cols37.setValue(beanGen.getCol37());
			cols38.setValue(beanGen.getCol38());
			cols39.setValue(beanGen.getCol39());
			cols48.setValue(beanGen.getCol48());
			cols49.setValue(beanGen.getCol49());
			cols50.setValue(beanGen.getCol50());
		}
	}

	private void montaChar(String recurso, String salen, String entran, Div elDiv, String filter, String titulo) {
		elDiv.removeAll();
    	Chart chart = new Chart(ChartType.BAR);
        Configuration configuration = new Configuration();
        configuration = chart.getConfiguration();
        configuration.setSubTitle(titulo);
 
        ListSeries salidas = new ListSeries("Salidas");
        ListSeries entradas = new ListSeries("Entradas");
                
        XAxis x = new XAxis();
        
    	ArrayList<String[]> rowsColList = new ArrayList<String[]>(); 	
    	String[] fieldArr = new String[6];
    	fieldArr[0] = "ANOMES"; //el id
    	fieldArr[1] = "";
    	fieldArr[2] = "";
    	fieldArr[3] = "";
    	fieldArr[4] = "";
    	fieldArr[5] = "";
		rowsColList.add(fieldArr);
		
    	fieldArr = new String[6];
    	fieldArr[0] = salen;  // el display
    	fieldArr[1] = "";
    	fieldArr[2] = "";
    	fieldArr[3] = "";
    	fieldArr[4] = "";
    	fieldArr[5] = "";
		rowsColList.add(fieldArr);
		
    	fieldArr = new String[6];
    	fieldArr[0] = entran;  // el display
    	fieldArr[1] = "";
    	fieldArr[2] = "";
    	fieldArr[3] = "";
    	fieldArr[4] = "";
    	fieldArr[5] = "";
		rowsColList.add(fieldArr);
        
		filter = filter + "%20AND%20ANOMES%3e%3d"+desde+"%20AND%20ANOMES%3c%3d"+hasta;
//		System.out.println("filter histograma " + filter);
		Collection<DynamicDBean> collect = RestData.getResourceData(0, 300, recurso, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM, rowsColList, filter, false, false, null);   
        Iterator<DynamicDBean> itAnos = collect.iterator();
        while (itAnos.hasNext()){
        	DynamicDBean beanEntradas = itAnos.next();
        	String ano = beanEntradas.getCol0();
        	double entrada = Double.parseDouble(beanEntradas.getCol1());
        	double salida = Double.parseDouble(beanEntradas.getCol2());
        	
        	x.addCategory(ano); 
        	salidas.addData(salida);
        	entradas.addData(entrada);
        }
        configuration.addSeries(salidas);
        configuration.addSeries(entradas);
        configuration.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        AxisTitle yTitle = new AxisTitle();
        yTitle.setText("Unidades");
        yTitle.setAlign(VerticalAlign.HIGH);
        y.setTitle(yTitle);
        configuration.addyAxis(y);

        Tooltip tooltip = new Tooltip();
        tooltip.setValueSuffix("");
        configuration.setTooltip(tooltip);

        PlotOptionsBar plotOptions = new PlotOptionsBar();
        DataLabels dataLabels = new DataLabels();
        dataLabels.setEnabled(true);
        plotOptions.setDataLabels(dataLabels);
        configuration.setPlotOptions(plotOptions);

        elDiv.add(chart);
	}
}

