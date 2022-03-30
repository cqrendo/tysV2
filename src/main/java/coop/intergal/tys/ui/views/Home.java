package coop.intergal.tys.ui.views;

import java.util.regex.Pattern;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexDirection;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import coop.intergal.AppConst;
import coop.intergal.tys.ui.MainLayout;
import coop.intergal.tys.ui.components.FlexBoxLayout;
import coop.intergal.tys.ui.layout.size.Horizontal;
import coop.intergal.tys.ui.layout.size.Uniform;
import coop.intergal.ui.security.SecurityUtils;
import coop.intergal.ui.util.UtilSessionData;
import coop.intergal.ui.utils.CheckMemory;
import coop.intergal.ui.utils.UiComponentsUtils;

@PageTitle("Inicio")
@Route(value = "", layout = MainLayout.class)
public class Home extends ViewFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -749873382421956413L;
//	private SplitLayout splitLayout;
//	private int position;

	public Home() {
        setId("home");
        setViewContent(createContent());
        setLateralTitle("ZZZ");
    }

    private Component createContent() {
        Html intro = new Html("<p>Usuario conectado: "+ SecurityUtils.getUsername()+ " en el ejercicio: " + AppConst.CURRENT_YEAR +"</p>");
        Image logofondo = new Image();
        logofondo.setSrc("images/logos/logoTys.png");
   //     avatar.setClassName(CLASS_NAME + "__avatar");
        
   //     logofondo.setAlt("User menu");

  //      Html fondo = new Html("<img src=\"images/logos/logoTys.png\"</img>");
 //       Html fondo = new Html("<img src=\"http://www.torresysaez.com/wp-content/uploads/2017/07/5.png\"</img>");
//        Html fondo = new Html("<p class=\"zn-bgSource-image\" style=\"background-image:url(http://www.torresysaez.com/wp-content/uploads/2017/07/Hierros-1.jpg);background-repeat:no-repeat;background-position:center center;background-size:cover;background-attachment:scroll\"></p>");

//        Html features = new Html("<p>The app comes with multiple list views to edit master-detail data. " +
//                        "Views can be divided horizontally or vertically to open up the details, and the details can " +
//                        "also be split into multiple tabs for extra space. The details can also be opened fullscreen " +
//                        "to maximize the use of space. Additionally there is an opt-in option for opening multiple " +
//                        "application views in tabs within the app, for quick comparison or navigation between data. " +
//                        "You enable this feature by setting <code>MainLayout.navigationTabs</code> to true.</p>");
//
//        Anchor documentation = new Anchor("https://vaadin.com/docs/business-app/overview.html", UIUtils.createButton("Read the documentation", VaadinIcon.EXTERNAL_LINK));
//        Anchor starter = new Anchor("https://vaadin.com/start/latest/business-app", UIUtils.createButton("Start a new project with Business App", VaadinIcon.EXTERNAL_LINK));
        
        MainLayout mL = (MainLayout) UiComponentsUtils.findComponent(UI.getCurrent(), "MainLayout");
		String companies = UtilSessionData.getCompanies();
        if (companies.equals("N/A"))
        {
        	return new Label("no esta autorizado");
        }
        FlexBoxLayout content = new FlexBoxLayout(intro, logofondo);
        String companyYear1;
		if (companies.indexOf(",") == -1) // only one company
        {
            companyYear1 = companies+AppConst.CURRENT_YEAR;
            UtilSessionData.setCompanyYear(companyYear1);
            UtilSessionData.setCompany(companies);
  //          setLateralTitle(companyYear1);
            

        }
        else
        {
            ComboBox<String> comboBox = new ComboBox<>();
      //      comboBox.setLabel("Escoge empresa");
            String actualCompany = UtilSessionData.getCompany();

        	String [] companiesItems = companies.split(Pattern.quote(","));
        	
        	comboBox.setItems(companiesItems);//"GFER","TYSH");
        	comboBox.setClearButtonVisible(true);
        
        	

        	Div value = new Div();
        
        	
			if (actualCompany != null && actualCompany.isEmpty() == false && mL != null)
        	{
        		comboBox.setValue(actualCompany);
        		value.setText("Seleccionado: " + actualCompany);
        		String companyYear = actualCompany+AppConst.CURRENT_YEAR;
        		setLateralTitle(companyYear);
        	}
        	else
        		value.setText("Escoge una empresa");
        	comboBox.addValueChangeListener(event -> {
        	if (event.getValue() == null) {
        		value.setText("nada selecionado");
        	} else {
        		value.setText("Seleccionado: " + event.getValue());
        		String companyYear = event.getValue()+AppConst.CURRENT_YEAR;
        		UtilSessionData.setCompanyYear(companyYear);
        		UtilSessionData.setCompany(event.getValue());
        		setLateralTitle(companyYear);
 //                ml.;
                CheckMemory.check();
            }
        });
        
//        FlexBoxLayout links = new FlexBoxLayout(documentation, starter);
//        links.setFlexWrap(FlexWrap.WRAP);
//        links.setSpacing(Right.S);

        content = new FlexBoxLayout(intro, comboBox, value, logofondo);
        }
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Uniform.RESPONSIVE_L);
      
//        splitLayout = new SplitLayout(new VerticalLayout(new Label("test")), new VerticalLayout(new Button("Adjust", e->{
//        	
//			splitLayout.setSplitterPosition(position);
//        	position -= 10;
//        	})));
//        	splitLayout.setWidth("600px");
//        	splitLayout.setOrientation(Orientation.VERTICAL);
//        	content.add(splitLayout);
//        	
//        	Label left = new Label("left");
//        	Label left2 = new Label("left2");
//        	Label left3 = new Label("left3");
//        	 Label right = new Label("right");
//        	HorizontalLayout hl = new HorizontalLayout(right);
//        	VerticalLayout vl = new VerticalLayout(left);
//        	vl.setWidth("100px");
//        	vl.add(left2);
//        	vl.add(left3);
//        	hl.add(vl);
//            left.getElement().getStyle().set("background","red");
//           
//            right .getElement().getStyle().set("background","green");
//             splitLayout = new SplitLayout(hl, vl);//new VerticalLayout(right));
//             
//              splitLayout.setWidthFull();
//              splitLayout.setSplitterPosition(0);
//              content.add(splitLayout, new Button("+", e->{
//                position += 10;
//                splitLayout.setSplitterPosition(position);
//               }), new Button("-", e->{
//                 position -= 10;
//                 splitLayout.setSplitterPosition(position);
//                }));
              
        return content;
    }


	private void setLateralTitle(String companyYear) {
		MainLayout mL = (MainLayout) UiComponentsUtils.findComponent(UI.getCurrent(), "MainLayout");
		if (mL != null)
		{	
			mL.setTitleLogo(companyYear);
			mL.initNaviItems();
		}
//		else if (this.getParent().isPresent())
//		{
//			FlexBoxLayout p1 = (FlexBoxLayout) this.getParent().get();
//			Component p2 = p1.getParent().get();
//			Component p3 = p2.getParent().get();
//			mL = (MainLayout) p3.getParent().get();
//			mL.setTitleLogo(companyYear);
//			mL.initNaviItems();
//		}	

		else
		{
			
		}
	}

}
