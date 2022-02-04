package coop.intergal.tys.ui.views.comprasyventas.articulos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.vaadin.flow.component.Tag;
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
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
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
@Tag("histograma-form")
@JsModule("./src/views/ComprasYVentas/Articulos/histograma-form.js")
@Route(value = "histogramaArticulo")
public class HistogramaForm extends GenericDynamicForm implements BeforeEnterObserver{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Id("col12")
	private TextField col12;
	@Id("col13")
	private TextField col13;
	@Id("col14")
	private TextField col14;
	@Id("col15")
	private TextField col15;
	private DdbDataBackEndProvider dataProvider;
	private DynamicDBean bean;
	@Id("dgSituacion")
	private DynamicViewGrid dgSituacion;
	@Id("dgProvLin")
	private DynamicViewGrid dgProvLin;
	@Id("dgProvAlt")
	private DynamicViewGrid dgProvAlt;
	@Id("char1")
	private Div char1;
	@Id("char2")
	private Div char2;
	@Id("char3")
	private Div char3;
	@Id("char4")
	private Div char4;
	private String almacenInicial = "20";
	private String claveArticulo;
	private DynamicDBean beanAlm = new DynamicDBean();
	@Id("alm8")
	private TextField alm8;
	@Id("alm9")
	private TextField alm9;
	@Id("alm7")
	private TextField alm7;
	@Id("alm6")
	private TextField alm6;
	@Id("alm5")
	private Span alm5;
	@Id("alm4")
	private Span alm4;
	@Id("alm3")
	private Span alm3;
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
     * Creates a new HistogramaForm.
     */
	   @EventHandler
	    private void handleClickTab1() {
	        System.out.println("handleClickTab1");
			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUMENSUAL","SALIDAS","ENTRADAS", char1, "CLAVEARTICULO="+claveArticulo+"%20AND%20CLAVEALMACEN="+almacenInicial, "Almacén "+almacenInicial);
	    }

	   @EventHandler
	    private void handleClickTab2() {
	        System.out.println("handleClickTab2");
			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUGLOBAL__MJ","TOTALSALIDAS","TOTALENTRADAS", char2, "CLAVEARTICULO="+claveArticulo, "Global");
	    }

	   @EventHandler
	    private void handleClickTab3() {
	        System.out.println("handleClickTab2");
			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUGALICIA__MJ","TOTALSALIDAS","TOTALENTRADAS", char3, "CLAVEARTICULO="+claveArticulo, "Galicia (G)");
	    }

	   @EventHandler
	    private void handleClickTab4() {
	        System.out.println("handleClickTab2");
			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUTODAGALICIA__MJ","TOTALSALIDAS","TOTALENTRADAS", char4, "CLAVEARTICULO="+claveArticulo, "Galicia (T)");
	    }
	   
	   
	   

    public HistogramaForm() {
		super();
    }

	/**
     * This model binds properties between ArticuloForm and articulo-form
     */
    public interface HistogramaFormModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
	}
	

	private void cambiaAlmacen(String alm) {
		almacenInicial=alm;
		calculaAlmacen();
		montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUMENSUAL","SALIDAS","ENTRADAS", char1, "CLAVEARTICULO="+claveArticulo+"%20AND%20CLAVEALMACEN="+almacenInicial, "Almacén "+almacenInicial );
	}

	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		if (bean != null)
			binder.setBean(bean);
		bindFields(HistogramaForm.class, this);
	}
	public DdbDataBackEndProvider getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(DdbDataBackEndProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public void setBean(DynamicDBean bean) {
		System.out.println("HistogramaForm.setBean()");
		this.bean = bean;
		if (bean != null)
		{
	//		binder.setBean(bean);
			dgProvAlt.setResourceName("CR-ARTICULOS__Histograma.Grid-ARTICULOSCONPROVALTERNATIVO");
			dgProvAlt.setFilter("CLAVEARTICULO="+bean.getCol16());
			dgProvAlt.setButtonsRowVisible(false);
			dgProvAlt.getGrid().setHeightByRows(true);
			dgProvAlt.setupGrid();

			dgProvLin.setResourceName("CR-ARTICULOS__Histograma.Grid-OFERTASPROVLIN");
			dgProvLin.setFilter("CLAVEARTICULO="+bean.getCol16());
			dgProvLin.setButtonsRowVisible(false);
			dgProvLin.getGrid().setHeightByRows(true);
			dgProvLin.setupGrid();

			dgSituacion.setResourceName("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION");
			dgSituacion.setFilter("CLAVE_ARTICULO="+bean.getCol16());
			dgSituacion.setButtonsRowVisible(false);
			dgSituacion.getGrid().setAllRowsVisible(true);
			dgSituacion.setupGrid();
			dgSituacion.getGrid().addSelectionListener(e -> {
			DynamicDBean selectedRow = null;
			if (e.getFirstSelectedItem().isPresent())
					selectedRow =(DynamicDBean)e.getFirstSelectedItem().get();
					if (selectedRow != null)
						{
						System.out.println("Registro seleccionado " + selectedRow.getCol0());
						cambiaAlmacen(selectedRow.getCol0()); 
						}
				});
			
			claveArticulo = bean.getCol16();
			calculaAlmacen();

			montaChar("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION.List-ARTISITUMENSUAL","SALIDAS","ENTRADAS", char1, "CLAVEARTICULO="+claveArticulo+"%20AND%20CLAVEALMACEN="+almacenInicial, "Almacén "+almacenInicial);
		}
	}

    private void calculaAlmacen() {
		beanAlm = RestData.getOneRow("CR-ARTICULOS__Histograma.Grid-ARTICULO_SITUACION", "CLAVE_ARTICULO="+claveArticulo+"%20AND%20CLAVE_ALMACEN="+almacenInicial, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM, null);
		if (beanAlm != null) {
			int a = Integer.parseInt(AppConst.CURRENT_YEAR)-1;
			desde = "20"+a+"01";//beanAlm.getCol3();
			hasta = beanAlm.getCol4();
			alm3.setText(desde); 
			alm4.setText(hasta); 
			alm5.setText(beanAlm.getCol5()); 
			alm6.setValue(beanAlm.getCol6()); 
			alm7.setValue(beanAlm.getCol7()); 
			alm8.setValue(beanAlm.getCol8()); 
			alm9.setValue(beanAlm.getCol9()); 
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

