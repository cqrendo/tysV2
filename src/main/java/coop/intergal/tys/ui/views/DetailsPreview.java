package coop.intergal.tys.ui.views;

import static coop.intergal.AppConst.STYLES_CSS;
import static coop.intergal.AppConst.STYLES_FORM_ITEM_CSS;
import static coop.intergal.AppConst.STYLES_FORM_LAYOUT_ITEM_CSS;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormItem;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Location;
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
import coop.intergal.tys.ui.util.FontSize;
import coop.intergal.tys.ui.util.LumoStyles;
import coop.intergal.tys.ui.util.TextColor;
import coop.intergal.tys.ui.util.UIUtils;
import coop.intergal.ui.util.UtilSessionData;
import coop.intergal.ui.utils.converters.CurrencyFormatter;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import coop.intergal.vaadin.rest.utils.RestData;

//@PageTitle("Payments")
@Route(value = "DetailsPreview", layout = MainLayout.class)
@CssImport(value = STYLES_CSS, themeFor="dynamic-grid-display")
@CssImport(value = STYLES_FORM_ITEM_CSS, themeFor = "vaadin-form-item")
@CssImport(value = STYLES_FORM_LAYOUT_ITEM_CSS, themeFor = "vaadin-form-item")
public class DetailsPreview extends SplitViewFrame implements HasDynamicTitle, BeforeEnterObserver {//, AfterNavigationListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final String RESOURCE_FIELD_TEMPLATE = "CR-FormTemplate.List-FieldTemplate";
	private Grid<DynamicDBean> grid;
 //   private ListDataProvider<Payment> dataProvider;
	private DdbDataBackEndProvider dataProvider;
    private DetailsDrawer detailsDrawer;
//	private Binder<DynamicDBean> binder;
	private FormLayout form;
	private ArrayList<String[]> rowsFieldList;
//	private ArrayList<String[]> rowsColListGrid;
	private CurrencyFormatter currencyFormatter = new CurrencyFormatter();
	private Hashtable<String, DynamicDBean> beansToSaveAndRefresh = new Hashtable<String, DynamicDBean>(); // to send DynamicDBean to be save and refresh, the name of the one to be save is send in another param

	private String title;
	private String resource;
	private Dialog dialogForFieldEdit = new Dialog();



    
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
    		
    		FlexBoxLayout content = new FlexBoxLayout(createDetails());
    //		content.setBoxSizing(BoxSizing.BORDER_BOX);
    //		content.setHeightFull();
    //		content.setPadding(Horizontal.RESPONSIVE_X, Top.RESPONSIVE_X);
//    		content.setWidthFull();
//    		content.setMaxWidth("1200px"); // if we want reposponsive we must uncomment this and previous, comment next
    		content.setWidth(AppConst.DEFAULT_WIDTH_FORM);
    		Div header = new Div(); 
    		header.setClassName("formTitle");
    		header.add(UIUtils.createH3Label(title));
    		Div headearAndForm = new Div(); 
    		headearAndForm.add(header);
    		headearAndForm.add(content);
    		return headearAndForm;
    		}
    	else
    		return new Label("resurso no configurado");
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

        DetailsDrawerHeader detailsDrawerHeader = new DetailsDrawerHeader("getPageTitle()");//), tabs);
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

//	private void showDetails(DynamicDBean dynamicDBean) {
//		beansToSaveAndRefresh.clear();	
//		beansToSaveAndRefresh.put(dynamicDBean.getResourceName(), dynamicDBean);
//        detailsDrawer.setContent(createDetails(dynamicDBean));
//        detailsDrawer.setWidthFull();
//        detailsDrawer.setMaxWidth("1150px");
//        detailsDrawer.show();
//       
//    }

    private Component createDetails() {
//		this.binder = new Binder<DynamicDBean>(DynamicDBean.class);
   		dataProvider = new DdbDataBackEndProvider();
		dataProvider.setPreConfParam(UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM);
		dataProvider.setResourceName( resource);
		dataProvider.setFilter(""); 
		rowsFieldList = dataProvider.getRowsFieldList();
//	    if (dynamicDBean != null)
//			binder.setBean(dynamicDBean);

		Iterator<String[]> itRowsFieldList = rowsFieldList.iterator();
		if (form == null)
			form = new FormLayout();
//		form.setWidth("1100px"); //@@ TODO set by param
	
		form.removeAll();
		form.setResponsiveSteps(
				calculateResponsiveStep(1),
				calculateResponsiveStep(2),
				calculateResponsiveStep(3),
				calculateResponsiveStep(4),
				calculateResponsiveStep(5),
				calculateResponsiveStep(6),
				calculateResponsiveStep(7),
				calculateResponsiveStep(8),
				calculateResponsiveStep(9),
				calculateResponsiveStep(10),
				calculateResponsiveStep(11),
				calculateResponsiveStep(12),
				calculateResponsiveStep(13),
				calculateResponsiveStep(14),
				calculateResponsiveStep(15),
				calculateResponsiveStep(16),
				calculateResponsiveStep(17),
				calculateResponsiveStep(18),
				calculateResponsiveStep(19),
				calculateResponsiveStep(20),
				calculateResponsiveStep(21),
				calculateResponsiveStep(22),
				calculateResponsiveStep(23),
				calculateResponsiveStep(24),
				calculateResponsiveStep(25),
				calculateResponsiveStep(26),
				calculateResponsiveStep(27),
				calculateResponsiveStep(28),
				calculateResponsiveStep(29),
				calculateResponsiveStep(30),
				calculateResponsiveStep(31),
				calculateResponsiveStep(32),
		calculateResponsiveStep(33),
		calculateResponsiveStep(34),
		calculateResponsiveStep(35),
		calculateResponsiveStep(36),
		calculateResponsiveStep(37),
		calculateResponsiveStep(38),
		calculateResponsiveStep(39),
		calculateResponsiveStep(40));
		int i = 0;
		int ii = 0;
		Div div = new Div();
	//	FormLayout.FormItem item = formLayout.addFormItem(phoneLayout, "Phone");
//		form.setColSpan(item, 2);
		Span sT = new Span();
//		s.setWidthFull();
//		s.setId(fieldNameInUI);
//		s.addClickListener(e ->ShowFieldToEdit(e.getSource().getId()));
		
		int nRow = 0;
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
			String deFaultValue = rowField[5];
			String fieldWidth = rowField[7];
			String classNames =  rowField[8];
			String classNamesForm = ""; 
			String classNamesItem = ""; 
			String [] tokens = classNames.split(Pattern.quote("."));
			int iii = 0;
			while (tokens.length > iii)
			{ 
				if (tokens[iii].indexOf("form") > -1 )  // form CSS must include form in his name
					classNamesForm = classNamesForm + "." + tokens[iii];
				else
					classNamesItem = classNamesItem + "." + tokens[iii];
				iii ++;
			}
			if (nRow == 0)
			{
				form = addClassNames(form,classNamesForm.trim());
				title = rowField[9];
				
			}
			classNamesItem = classNamesItem.replace("..", ".");
			nRow ++;
			
			System.out.println("DetailsPreview.createDetails()" +" filedName " + filedName + " "+classNames  );
			
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
			tf.addThemeVariants(TextFieldVariant.LUMO_SMALL);
			tf.setReadOnly(isReadOnly);
			if (filedName.equals("#SPACE#"))
			{
				Span s = new Span();
				FormLayout.FormItem item = form.addFormItem(s, label );
				item = addClassNames(item, classNamesItem);
				item.setId(fieldNameInUI);
				item.addClickListener(e ->ShowFieldToEdit(e.getSource().getId()));
				form.setColspan(item, colspan);
				
			}
//			else if (idFieldType.equals("1")) // is Date
//			{
//				DatePicker dp = new DatePicker();
//				boolean isRightLabel = false;
//				dp.setId(fieldNameInUI);
//				dp.addFocusListener(e ->ShowFieldToEdit(e.getSource().getId()));
//				Div l = alingLabel(label); 
//				FormLayout.FormItem item = form.addFormItem(dp, l );
//					item.addClassName("style1");
//				form.setColspan(item, colspan);
//				dp.setWidth(fieldWidth);
//			}
			else
			{
//				binder.bind(tf, fieldNameInUI);
//			form.add(fi);
//				boolean isRightLabel = false;
//				if (label.endsWith("#"))isRightLabel = true;
				Div l = alingLabel(label); 
				FormLayout.FormItem item = form.addFormItem(tf, l );
				item.setId(fieldNameInUI);
				item.addClickListener(e ->ShowFieldToEdit(e.getSource().getId()));

//				if (isRightLabel)
//					item.addClassName("filabelright");
//				else
				item = addClassNames(item, classNamesItem);
				form.setColspan(item, colspan);
				tf.setWidth(fieldWidth);
				if (deFaultValue.isEmpty() == false)	
					{
					tf.setValue(deFaultValue);
					}
			}
			i++;
			
		}
		return form;
    }
	private FormItem addClassNames(FormItem item, String classNames) {
		StringTokenizer tokens = new StringTokenizer(classNames,".");
		while (tokens.hasMoreElements())
		{
			String eachClass = tokens.nextToken();
			item.addClassName(eachClass);
		}
	return item;
}
	private FormLayout addClassNames(FormLayout formLayout, String classNames) {
		StringTokenizer tokens = new StringTokenizer(classNames,".");
		while (tokens.hasMoreElements())
		{
			String eachClass = tokens.nextToken();
			formLayout.addClassName(eachClass);
		}
	return formLayout;
}

	private Object ShowFieldToEdit(Optional<String> id) {
		System.out.println("DetailsPreview.ShowFieldToEdit()......." + id.get());
		
		Binder<DynamicDBean> binder = new Binder<DynamicDBean>(DynamicDBean.class);
		
		String filter =  "tableName='"+resource+"'%20AND%20FieldNameInUI='"+id.get()+"'";
		DynamicDBean dynamicDBean = RestData.getOneRow(RESOURCE_FIELD_TEMPLATE,filter, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM, null);
		beansToSaveAndRefresh.clear();	
		beansToSaveAndRefresh.put(dynamicDBean.getResourceName(), dynamicDBean);

		FormLayout formEditField = new FormLayout();
	    if (dynamicDBean != null)
			binder.setBean(dynamicDBean);
		TextField tfColName = new TextField();
		tfColName.setLabel("Npmbre campo");
		TextField tfFieldOrder = new TextField();
		tfFieldOrder.setLabel("Orden # etiqueta");
		TextField tfFieldWidth = new TextField();
		tfFieldWidth.setLabel("Tamaño campo");
		TextField tfFieldCSSClass = new TextField();
		tfFieldCSSClass.setLabel("CSS Class");
		TextField tfFieldDefault = new TextField();
		tfFieldDefault.setLabel("Valor por defecto");

	    binder.bind(tfColName, "col0");
	    binder.bind(tfFieldOrder, "col3");
	    binder.bind(tfFieldWidth, "col5");
	    binder.bind(tfFieldCSSClass, "col17");
	    binder.bind(tfFieldDefault, "col7");
		formEditField.add(tfColName);
		formEditField.add(tfFieldOrder);
		formEditField.add(tfFieldWidth);
		formEditField.add(tfFieldCSSClass);
		formEditField.add(tfFieldDefault);		
		Button save = UIUtils.createPrimaryButton("Save");
		save.addClickListener(e -> saveRow());
		formEditField.add(save);
		dialogForFieldEdit.removeAll();
		dialogForFieldEdit.add(new Label("Editar campo") );
		dialogForFieldEdit.add(formEditField);
		dialogForFieldEdit.open();
		return null;
}

	private Object saveRow() {
		dataProvider.save(RESOURCE_FIELD_TEMPLATE, beansToSaveAndRefresh );
		dialogForFieldEdit.close();
		createDetails();
		return null;
	}

	private ResponsiveStep calculateResponsiveStep(int i) {
		int em = i * 22;
		String strEm =  em +"";
		strEm = strEm.substring(0,strEm.length()-1 ); 
//		System.out.println("GenericGridDetails.calculateResponsiveStep()......"+ strEm + "em");
		return new ResponsiveStep(strEm+"em",i);
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
		
//	       title = parametersMap.get("title").get(0);	
	       resource = parametersMap.get("resource").get(0);
	       setViewContent(createContent(resource));
	//        setViewDetails(createDetailsDrawer());

		
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
