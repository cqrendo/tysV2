package coop.intergal.tys.ui.views;

import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexDirection;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import coop.intergal.AppConst;
import coop.intergal.tys.ui.MainLayout;
import coop.intergal.tys.ui.components.FlexBoxLayout;
import coop.intergal.tys.ui.layout.size.Horizontal;
import coop.intergal.tys.ui.layout.size.Right;
import coop.intergal.tys.ui.layout.size.Uniform;
import coop.intergal.tys.ui.util.UIUtils;
import coop.intergal.ui.security.SecurityUtils;
import coop.intergal.ui.utils.CheckMemory;
import coop.intergal.ui.utils.UiComponentsUtils;
import coop.intergal.ui.util.UtilSessionData;

@PageTitle("Inicio")
@Route(value = "", layout = MainLayout.class)
public class Home extends ViewFrame {

    public Home() {
        setId("home");
        setViewContent(createContent());
    }

    private Component createContent() {
        Html intro = new Html("<p>Usuario conectado: "+ SecurityUtils.getUsername()+ " en el ejercicio: " + AppConst.CURRENT_YEAR +"</p>");

        Html fondo = new Html("<img src=\"http://www.torresysaez.com/wp-content/uploads/2017/07/5.png\"</img>");
//        Html fondo = new Html("<p class=\"zn-bgSource-image\" style=\"background-image:url(http://www.torresysaez.com/wp-content/uploads/2017/07/Hierros-1.jpg);background-repeat:no-repeat;background-position:center center;background-size:cover;background-attachment:scroll\"></p>");

        Html features = new Html("<p>The app comes with multiple list views to edit master-detail data. " +
                        "Views can be divided horizontally or vertically to open up the details, and the details can " +
                        "also be split into multiple tabs for extra space. The details can also be opened fullscreen " +
                        "to maximize the use of space. Additionally there is an opt-in option for opening multiple " +
                        "application views in tabs within the app, for quick comparison or navigation between data. " +
                        "You enable this feature by setting <code>MainLayout.navigationTabs</code> to true.</p>");

        Anchor documentation = new Anchor("https://vaadin.com/docs/business-app/overview.html", UIUtils.createButton("Read the documentation", VaadinIcon.EXTERNAL_LINK));
        Anchor starter = new Anchor("https://vaadin.com/start/latest/business-app", UIUtils.createButton("Start a new project with Business App", VaadinIcon.EXTERNAL_LINK));
        ComboBox<String> comboBox = new ComboBox<>();
//        comboBox.setLabel("Escoge empresa");
        String actualCompany = UtilSessionData.getCompany();

        comboBox.setItems("GFER","TYSH");
        comboBox.setClearButtonVisible(true);
        
		MainLayout mL = (MainLayout) UiComponentsUtils.findComponent(UI.getCurrent(), "MainLayout");

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
        
        FlexBoxLayout links = new FlexBoxLayout(documentation, starter);
        links.setFlexWrap(FlexWrap.WRAP);
        links.setSpacing(Right.S);

        FlexBoxLayout content = new FlexBoxLayout(intro, comboBox, value, fondo);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }

	private void setLateralTitle(String companyYear) {
		MainLayout mL = (MainLayout) UiComponentsUtils.findComponent(UI.getCurrent(), "MainLayout");
////		if (this.getParent().isPresent())
//		{
//			FlexBoxLayout p1 = (FlexBoxLayout) this.getParent().get();
//			Component p2 = p1.getParent().get();
//			Component p3 = p2.getParent().get();
//			MainLayout mL = (MainLayout) p3.getParent().get();
		if (mL != null)
		{	
			mL.setTitleLogo(companyYear);
			mL.initNaviItems();
		}
		else
		{
			
		}
	}

}
