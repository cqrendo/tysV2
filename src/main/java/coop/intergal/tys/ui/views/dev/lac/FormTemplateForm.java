package coop.intergal.tys.ui.views.dev.lac;

import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import coop.intergal.AppConst;
import coop.intergal.ui.views.GenericDynamicForm;
import coop.intergal.ui.views.DynamicGridForPick;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import coop.intergal.vaadin.rest.utils.RestData;
import com.vaadin.flow.component.textfield.TextArea;

@Tag("form-template-form")
@JsModule("./src/views/dev/lac/form-template-form.js")
//@SpringComponent
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Route(value = "displayFormTemplate")
//public class DynamicForm extends PolymerTemplate<TemplateModel> implements BeforeEnterObserver, CrudForm<DynamicDBean> {
public class FormTemplateForm extends GenericDynamicForm implements BeforeEnterObserver{//, CrudForm<DynamicDBean> {
	

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
	
	@Id("preview")
	private Button preview;
	
	@Id("update")
	private Button update;


//	@Id("tabs")
//	private Tabs tabs;
	
//		private BeanValidationBinder<DynamicDBean> binder;

	private DynamicDBean bean;

	private ArrayList<String[]> rowsColList;
	
	private DynamicGridForPick dynamicGridForPick = new DynamicGridForPick(); 

	
	@Id("dialogForPick")
	private Dialog dialogForPick;

	private DdbDataBackEndProvider dataProvider;

	@Id("col4")
	private TextArea col4;

	@Id("col5")
	private TextArea col5;

	@Id("col6")
	private TextArea col6;

	@Id("col2")
	private TextField col2;

	@Id("col13")
	private TextField col13;

	@Id("col12")
	private TextField col12;

	@Id("col11")
	private TextField col11;

	@Id("col10")
	private TextField col10;

//	@Id("reload")
//	private Button reload;
	
	public FormTemplateForm() {
		super();
		dialogForPick.setWidth(AppConst.DEFAULT_PICK_DIALOG_WITHD);
		dialogForPick.setHeight(AppConst.DEFAULT_PICK_DIALOG_HEIGHT);
		preview.addClickListener(e -> preview());
		update.addClickListener(e -> update());
	}

private Object update() {
		String resource = col1.getValue();
		DynamicDBean beanToSave = bean;
//		filter="apiversion_ident"=2006 AND "name"='CR-entradas_cab'
		if (bean.getColBoolean("col3"))
			bean.setColBoolean(false, "col3");
		else
			bean.setColBoolean(true, "col3");
		Hashtable<String, DynamicDBean> beansToSaveAndRefresh = new Hashtable<String, DynamicDBean>();
		beansToSaveAndRefresh.clear();
		beansToSaveAndRefresh.put(beanToSave.getResourceName(), beanToSave);
		dataProvider.save(beanToSave.getResourceName(), beansToSaveAndRefresh);	
		dataProvider.refreshAll();
//		((Binder<DynamicDBean>) display).setBean(selectedRow);
//		keepRowBeforChanges =  RestData.copyDatabean(selectedRow);
//		try {
//			setBean.invoke(display,selectedRow);
//		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		showBean(beanToSave);
			
		return null;
	}

//	@Override
//	public void setBinder(BeanValidationBinder<DynamicDBean> binder2) {
	public void setBinder(Binder<DynamicDBean> binder2) {
		super.binder = binder2;
		bindFields(FormTemplateForm.class, this);
		super.setDialogForPick(dialogForPick);
//		tabs.addSelectedChangeListener(event -> {
//			System.out.println("FormTemplateForm.setBinder()");
//	//	    Component selectedPage = tabs.getSelectedTab();
	//	    selectedPage.setVisible(true);
//		});
	
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

		//		Element child = new Element ("div");
//		child.setText("XXX");
//		this.getElement().appendChild(child);

		
//		tabs.add(miTab);
	}
	
	private Object preview() {
	// TODO Auto-generated method stub
		try {
			String urlBase = "../DetailsPreview";
			String hostName = InetAddress.getLocalHost().getHostName() ;
			if (hostName.startsWith("MacBook-Air-de-Cesar.local") == false) // to diferent when is running in local (Maven) or in remote (tys.war -> tomcat)
				urlBase= "../MetaConfig/DetailsPreview";
		String resource = col1.getValue();
		
//		titleOption = titleOption.replace(" ", "%20");
//		UI.getCurrent().getPage().executeJavaScript("window.open('http://localhost:8080/dymanic?resourceName="+resource+"&title="+titleOption+"', '_blank');") ;
		UI.getCurrent().getPage().executeJavaScript("window.open('"+urlBase+"?resource="+resource+"', '_blank');") ;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
}

	public DynamicDBean getBean() {
		return bean;
	}

	public void setBean(DynamicDBean bean) {
		this.bean = bean;
		binder.setBean(bean);
	}
	@Tag("vaadin-tab")
	public class miTab extends Component {
	    public Registration addChangeListener(
	         ComponentEventListener<ChangeEvent> listener) {
	        return addListener(ChangeEvent.class, listener);
	    }

	    // Other component methods omitted
	}
	@DomEvent("selected-changed")
	public class ChangeEvent
	        extends ComponentEvent<Tab> {
	    private final int button;

	    public ChangeEvent(Tab source,
	            boolean fromClient,
	            @EventData("event.button") int button) {
	        super(source, fromClient);
	        this.button = button;
	    }

	    public int getButton() {
	        return button;
	    }
	}
	public DdbDataBackEndProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(DdbDataBackEndProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

}
