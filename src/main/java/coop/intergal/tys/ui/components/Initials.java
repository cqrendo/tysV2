package coop.intergal.tys.ui.components;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.theme.lumo.Lumo;

import coop.intergal.tys.ui.util.FontSize;
import coop.intergal.tys.ui.util.FontWeight;
import coop.intergal.tys.ui.util.LumoStyles;
import coop.intergal.tys.ui.util.UIUtils;
import coop.intergal.tys.ui.util.css.BorderRadius;

public class Initials extends FlexBoxLayout {

    private String CLASS_NAME = "initials";

    public Initials(String initials) {
        setAlignItems(FlexComponent.Alignment.CENTER);
        setBorderRadius(BorderRadius.L);
        setClassName(CLASS_NAME);
        UIUtils.setFontSize(FontSize.S, this);
        UIUtils.setFontWeight(FontWeight._600, this);
        setHeight(LumoStyles.Size.M);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setTheme(Lumo.DARK);
        setWidth(LumoStyles.Size.M);

        add(initials);
    }

}
