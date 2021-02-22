package coop.intergal.tys.ui.views;

import static coop.intergal.AppConst.STYLES_CSS;
import static coop.intergal.AppConst.STYLES_FORM_ITEM_CSS;
import static coop.intergal.AppConst.STYLES_FORM_LAYOUT_ITEM_CSS;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.LocalDateToDateConverter;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationListener;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Location;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;

import coop.intergal.AppConst;
import coop.intergal.tys.backend.Payment;
import coop.intergal.tys.ui.MainLayout;
import coop.intergal.tys.ui.components.FlexBoxLayout;
import coop.intergal.tys.ui.components.detailsdrawer.DetailsDrawer;
import coop.intergal.tys.ui.components.detailsdrawer.DetailsDrawerFooter;
import coop.intergal.tys.ui.components.detailsdrawer.DetailsDrawerHeader;
import coop.intergal.tys.ui.components.navigation.bar.AppBar;
import coop.intergal.tys.ui.layout.size.Horizontal;
import coop.intergal.tys.ui.layout.size.Top;
import coop.intergal.tys.ui.util.FontSize;
import coop.intergal.tys.ui.util.LumoStyles;
import coop.intergal.tys.ui.util.TextColor;
import coop.intergal.tys.ui.util.UIUtils;
import coop.intergal.tys.ui.util.css.BoxSizing;
import coop.intergal.ui.utils.TranslateResource;
import coop.intergal.ui.utils.converters.CurrencyFormatter;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

//@PageTitle("Payments")
@Route(value = "gridDetails", layout = MainLayout.class)
@CssImport(value = STYLES_CSS, themeFor="dynamic-grid-display")
@CssImport(value = STYLES_FORM_ITEM_CSS, themeFor = "vaadin-form-item")
@CssImport(value = STYLES_FORM_LAYOUT_ITEM_CSS, themeFor = "vaadin-form-item")
public class GenericGridDetails extends SplitViewFrame implements HasDynamicTitle, BeforeEnterObserver {//, AfterNavigationListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Grid<DynamicDBean> grid;
 //   private ListDataProvider<Payment> dataProvider;
	private DdbDataBackEndProvider dataProvider;
    private DetailsDrawer detailsDrawer;
	private Binder<DynamicDBean> binder;
	private FormLayout form;
	private ArrayList<String[]> rowsColList;
	private ArrayList<String[]> rowsFieldList;
//	private ArrayList<String[]> rowsColListGrid;
	private CurrencyFormatter currencyFormatter = new CurrencyFormatter();
	private Hashtable<String, DynamicDBean> beansToSaveAndRefresh = new Hashtable<String, DynamicDBean>(); // to send DynamicDBean to be save and refresh, the name of the one to be save is send in another param

	private String title;
	private String resource;



    
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
 //       initAppBar();
 
 //       setViewContent(createContent());
 //       setViewDetails(createDetailsDrawer());
 //       filter();
    }

    private void initAppBar() {
        AppBar appBar = MainLayout.get().getAppBar();
        for (Payment.Status status : Payment.Status.values()) {
            appBar.addTab(status.getName());
        }
        appBar.addTabSelectionListener(e -> {
 //           filter();
            detailsDrawer.hide();
        });
        appBar.centerTabs();
    }

    private Component createContent(String resource) {
    	if (resource != null)
    		{
    		FlexBoxLayout content = new FlexBoxLayout(createGrid(resource));
    		content.setBoxSizing(BoxSizing.BORDER_BOX);
    		content.setHeightFull();
    		content.setPadding(Horizontal.RESPONSIVE_X, Top.RESPONSIVE_X);
    		return content;
    		}
    	else
    		return new Label("resurso no configurado");
    }

    private Grid<DynamicDBean> createGrid(String resource) {
//        dataProvider = DataProvider.ofCollection(DummyData.getPayments());
//    	System.out.println("GenericGridDetails.createGrid()........." + ComponentUtil.getData(UI.getCurrent(), "resource"));
    		dataProvider = new DdbDataBackEndProvider();
    		dataProvider.setPreConfParam(AppConst.PRE_CONF_PARAM);
    		dataProvider.setResourceName( resource);
    		dataProvider.setFilter("");
    		grid = new Grid<DynamicDBean>();
	        
	        grid.addSelectionListener(event -> event.getFirstSelectedItem().ifPresent(this::showDetails));
	 

//        grid = new Grid<>();
//        grid.addSelectionListener(event -> event.getFirstSelectedItem().ifPresent(this::showDetails));
	        grid.setDataProvider(dataProvider);
	        grid.setHeightFull();
	        rowsColList = dataProvider.getRowsColList();
	        int numberOFCols = rowsColList.size();
	        for (int i=0;i<numberOFCols; i++)
	        {
	        	addFormatedColumn(i);
	        }

	        grid.getColumns().forEach(column -> column.setAutoWidth(true));
	        return grid;
    }
    private void addFormatedColumn(int i) {
//		String colName = "col"+i;
		String[] colData = rowsColList.get(i);
		String colName = colData[2];
		String colType = colData[3];
		String colHeader = colData[6];
		boolean isNotAParentField = colData[1].indexOf("#SORT")>-1; // parent field for now can not be use as sort column
		boolean isCOlEditable = true;;
		if (colData[1].indexOf("#CNoEDT#")>-1)
			isCOlEditable = false;
		if (colData[1].indexOf("#SIG#")>-1) { // #SIG# = Show In Grid
			String header = colHeader;
			if (header.isEmpty())
				TranslateResource.getFieldLocale(colData[0], AppConst.PRE_CONF_PARAM);
			if (isDate(header, colType)) {
				if (header.indexOf("#")>0)
					header = header.substring(2); // to avoid date typ indicator "D#"
					if (isNotAParentField)
						grid.addColumn(new LocalDateRenderer<>(d -> d.getColLocalDate(colName), "dd/MM/yyyy")).setHeader(header).setSortProperty(colData[0])
						.setResizable(true).setSortProperty(colData[0]);
					else
						grid.addColumn(new LocalDateRenderer<>(d -> d.getColLocalDate(colName), "dd/MM/yyyy")).setHeader(header).setSortProperty(colData[0])
						.setResizable(true);
						
				
//		grid.addColumn(d ->d.getCol(i)).setHeader(header).setResizable(true);
			} else if (isCurrency(header,colType)) {
				if (header.indexOf("#")>0)
					header = header.substring(2);
					if (isNotAParentField)
						{
						grid.addColumn(d -> currencyFormatter.encode(currencyFormatter.getCents(d.getCol(colName)))).setHeader(header)
						.setTextAlign(ColumnTextAlign.END).setResizable(true).setSortProperty(colData[0]);
						}
					else
						{
						grid.addColumn(d -> currencyFormatter.encode(currencyFormatter.getCents(d.getCol(colName)))).setHeader(header)
						.setTextAlign(ColumnTextAlign.END).setResizable(true);
						}

			}  else if (isBoolean(header,colType)) {
				if (header.indexOf("#")>0)
					header = header.substring(2);
					if (isNotAParentField)
						{
						grid.addColumn(d -> currencyFormatter.encode(currencyFormatter.getCents(d.getCol(colName)))).setHeader(header)
						.setTextAlign(ColumnTextAlign.END).setResizable(true).setSortProperty(colData[0]);
						}
					else
						{
						grid.addColumn(d -> currencyFormatter.encode(currencyFormatter.getCents(d.getCol(colName)))).setHeader(header)
						.setTextAlign(ColumnTextAlign.END).setResizable(true);
						}

			}
			else

			{
				grid.addColumn(d -> d.getCol(colName)).setHeader(header).setResizable(true).setSortProperty(colData[0]) ;
			}
		}

	}
    private boolean isCurrency(String header, String colType) {
    	if (header.startsWith("C#")) // when there is nmot the type defined in FiledTemplate it can be defined in the name with the prefix "d#"
    		return true; 
    	if (colType.equals("3"))
    		return true;
    	return false;
    }


    private boolean isDate(String header, String colType) {
    	if (header.startsWith("D#")) // when there is nmot the type defined in FiledTemplate it can be defined in the name with the prefix "d#"
    		return true; 
    	if (colType.equals("1"))
    		return true;
    	return false;
    }
    private boolean isBoolean(String header, String colType) {
    	if (colType.equals("4"))
    		return true;
    	return false;
    }
 
    private DetailsDrawer createDetailsDrawer() {
        detailsDrawer = new DetailsDrawer(DetailsDrawer.Position.RIGHT);

        // Header
//        Tab details = new Tab("Details");
//        Tab attachments = new Tab("Attachments");
//        Tab history = new Tab("History");
//
//        Tabs tabs = new Tabs(details, attachments, history);
//        tabs.addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS);
//        tabs.addSelectedChangeListener(e -> {
//            Tab selectedTab = tabs.getSelectedTab();
//            if (selectedTab.equals(details)) {
//                detailsDrawer.setContent(createDetails(grid.getSelectionModel().getFirstSelectedItem().get()));
//            } else if (selectedTab.equals(attachments)) {
//                detailsDrawer.setContent(createAttachments());
//            } else if (selectedTab.equals(history)) {
//                detailsDrawer.setContent(createHistory());
//            }
//        });

        DetailsDrawerHeader detailsDrawerHeader = new DetailsDrawerHeader(getPageTitle());//), tabs);
        detailsDrawerHeader.addCloseListener(buttonClickEvent -> detailsDrawerHide());
        detailsDrawer.setHeader(detailsDrawerHeader);
        // Footer
        DetailsDrawerFooter footer = new DetailsDrawerFooter();
        footer.addSaveListener(e -> {
        	dataProvider.save(resource, beansToSaveAndRefresh );
        	detailsDrawerHide();
            UIUtils.showNotification("Changes saved.");
        });
        footer.addCancelListener(e -> detailsDrawerHide());
        detailsDrawer.setFooter(footer);
        return detailsDrawer;
    }

    private Object detailsDrawerHide() {
    	detailsDrawer.setMaxWidth("0px");
    	detailsDrawer.hide();
		return null;
	}

	private void showDetails(DynamicDBean dynamicDBean) {
		beansToSaveAndRefresh.clear();	
		beansToSaveAndRefresh.put(dynamicDBean.getResourceName(), dynamicDBean);
        detailsDrawer.setContent(createDetails(dynamicDBean));
        detailsDrawer.setWidthFull();
        detailsDrawer.setMaxWidth("1150px");
        detailsDrawer.show();
       
    }

    private Component createDetails(DynamicDBean dynamicDBean) {
		this.binder = new Binder<DynamicDBean>(DynamicDBean.class);
		rowsFieldList = dataProvider.getRowsFieldList();
	    if (dynamicDBean != null)
			binder.setBean(dynamicDBean);

		Iterator<String[]> itRowsFieldList = rowsFieldList.iterator();
		if (form == null)
			form = new FormLayout();
		form.removeAll();
		form.setResponsiveSteps(
			new ResponsiveStep("31em",1),
			new ResponsiveStep("32em",2),
			new ResponsiveStep("33em",3),
			new ResponsiveStep("34em",4),
			new ResponsiveStep("45em",5),
			new ResponsiveStep("46em",6),
			new ResponsiveStep("47em",7),
			new ResponsiveStep("48em",8),
			new ResponsiveStep("49em",9),
			new ResponsiveStep("50em",10),
			new ResponsiveStep("51em",11),
			new ResponsiveStep("52em",12),
			new ResponsiveStep("63em",13),
			new ResponsiveStep("64em",14),
			new ResponsiveStep("65em",15),
			new ResponsiveStep("66em",16));
		int i = 0;
		int ii = 0;
		Div div = new Div();
	//	FormLayout.FormItem item = formLayout.addFormItem(phoneLayout, "Phone");
//		form.setColSpan(item, 2);
		while (itRowsFieldList.hasNext())
		{
//			Label label = new Label(itRowsColList.next()[0]);
//			label.setWidth("500px");
			String[] rowField = itRowsFieldList.next();
			String filedName = rowField[0];
			boolean isReadOnly = isReadOnly( rowField [1]);
			String label = rowField[6];
			String fieldNameInUI = rowField[2];
			String idFieldType = rowField[3];
			String fieldWidth = rowField[7];
			if( fieldWidth.isEmpty())
				fieldWidth = "10";
			
			int idxMark = fieldWidth.indexOf("#");
			Integer colspan = 0;
			if (idxMark == -1)
			{
				colspan = new Integer (fieldWidth);
				fieldWidth = (colspan*2)+1+"em";
			}
			else
			{
				colspan = new Integer (fieldWidth.substring(0,idxMark));
				fieldWidth = fieldWidth.substring(idxMark+1)+"em";
			}
			
			TextField tf = new TextField();//itRowsColList.next()[0]);
			tf.setReadOnly(isReadOnly);
//			FormItem fi = new FormItem(label);
//			fi.add(tf);
//	//		tf.setWidth("100px");
			if (filedName.equals("#SPACE#"))
			{
				Label l = new Label(); 
				FormLayout.FormItem item = form.addFormItem(l, label );
		//		item.addClassName("style1");
				form.setColspan(item, colspan);
			}
			else if (idFieldType.equals("1")) // is Date
			{
				DatePicker dp = new DatePicker();
				boolean isRightLabel = false;
//				if (label.endsWith("#"))isRightLabel = true;
				Div l = alingLabel(label); 
				binder.forField((DatePicker) dp)
				.withConverter(new LocalDateToDateConverter( ZoneId.systemDefault()))
				.bind(d-> d.getColDate(fieldNameInUI), (d,v)-> d.setColDate(v,fieldNameInUI));//DynamicDBean::setCol2Date);	
				FormLayout.FormItem item = form.addFormItem(dp, l );
//				if (isRightLabel)
//					item.addClassName("filabelright");
//				else
					item.addClassName("style1");
				form.setColspan(item, colspan);
				dp.setWidth(fieldWidth);
			}
			else
			{
				binder.bind(tf, fieldNameInUI);
//			form.add(fi);
				boolean isRightLabel = false;
//				if (label.endsWith("#"))isRightLabel = true;
				Div l = alingLabel(label); 
				FormLayout.FormItem item = form.addFormItem(tf, l );
//				if (isRightLabel)
//					item.addClassName("filabelright");
//				else
					item.addClassName("style1");
				form.setColspan(item, colspan);
				tf.setWidth(fieldWidth);
			}
//			form.addFormItem(tf, label);
			i++;
			
		}
//		while (itRowsColList.hasNext())
//		{
//			TextField tf = new TextField(itRowsColList.next()[0]);
//			tf.setWidth("100px");
//			if (ii < 4)
//			{
//				
//				div.add(tf);
//				ii++;
//				
//			}
//			else
//			{
//				div = new Div();
//				div.setWidth("1100px");
//				ii=0;
//			}
//
//			binder.bind(tf, "col"+i);
//			form.add(div);
//			i++;
//			
//		}

//        Div details = new Div(status, from, to, amount, date);
//        details.addClassName(LumoStyles.Padding.Vertical.S);
//        return details;
		return form;
    }
	private Div alingLabel(String label) {
		Div l = new Div();
		l.add(label);
		if (label.endsWith("#"))
			{
			l.addClassName("labelright");
			label=label.substring(0,label.length()-1);
			l.setText(label);
			}
		return l;
	}

	private boolean isReadOnly(String params) {
		
		if (params == null)
			return false;
		if (params.indexOf("#CNoEDT#")>-1)
			return true;
		else 
			return false;
			
	}

    private Component createAttachments() {
        Label message = UIUtils.createLabel(FontSize.S, TextColor.SECONDARY, "Not implemented yet.");
        message.addClassNames(LumoStyles.Padding.Responsive.Horizontal.L, LumoStyles.Padding.Vertical.L);
        return message;
    }

    private Component createHistory() {
        Label message = UIUtils.createLabel(FontSize.S, TextColor.SECONDARY, "Not implemented yet.");
        message.addClassNames(LumoStyles.Padding.Responsive.Horizontal.L, LumoStyles.Padding.Vertical.L);
        return message;
    }

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		if(title == null)
			return "SIN TITULO";
		return title;
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		System.out.println("GenericGridDetails.beforeEnter()");
		Location location = event.getLocation();
	    QueryParameters queryParameters = location
	            .getQueryParameters();

	    Map<String, List<String>> parametersMap =
	            queryParameters.getParameters();
	    System.out.println("beforeEnter.....parametersMap.get(\"resource\")"+parametersMap.get("resource"));
		
	       title = parametersMap.get("title").get(0);	
	       resource = parametersMap.get("resource").get(0);
	       setViewContent(createContent(resource));
	        setViewDetails(createDetailsDrawer());

		
	}



//	@Override
//	public void afterNavigation(AfterNavigationEvent event) {
//		Location location = event.getLocation();
//	    QueryParameters queryParameters = location
//	            .getQueryParameters();
//
//	    Map<String, List<String>> parametersMap =
//	            queryParameters.getParameters();
//	    System.out.println("afterNavigation.setParameter()....."+parametersMap.get("resource"));
//		
//
//		
//	}

 
}
