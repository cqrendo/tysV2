package coop.intergal.tys.ui.components.navigation.drawer;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;

import coop.intergal.tys.ui.util.UIUtils;
import coop.intergal.ui.util.UtilSessionData;

@CssImport("styles/components/brand-expression.css")
public class BrandExpression extends Div {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String CLASS_NAME = "brand-expression";

    private Image logo;
 //   private Label title;

    public BrandExpression(String text, Label title) {
        setClassName(CLASS_NAME);

        logo = new Image(UIUtils.IMG_PATH + "logos/tys1.png", "");
        logo.setAlt(text + " logo");
        logo.setClassName(CLASS_NAME + "__logo");
        logo.addClickListener(e -> showHome());

        String companyYear = UtilSessionData.getCompanyYear();
        if (companyYear.isEmpty())
        	companyYear="Empresa sin seleccionar (click Logo)";
 //       title = UIUtils.createH3Label(UtilSessionData.getCompanyYear());
        title.addClassName(CLASS_NAME + "__title");

       add(logo, title);
        
//        add(logo);
    }

	private Object showHome() {
		UI.getCurrent().navigate("");
		return null;
	}

}
