package coop.intergal.tys.ui.components;

import com.vaadin.flow.component.html.Span;

import coop.intergal.tys.ui.util.UIUtils;
import coop.intergal.tys.ui.util.css.lumo.BadgeColor;
import coop.intergal.tys.ui.util.css.lumo.BadgeShape;
import coop.intergal.tys.ui.util.css.lumo.BadgeSize;

import static coop.intergal.tys.ui.util.css.lumo.BadgeShape.PILL;

import java.util.StringJoiner;

public class Badge extends Span {

    public Badge(String text) {
        this(text, BadgeColor.NORMAL);
    }

    public Badge(String text, BadgeColor color) {
        super(text);
        UIUtils.setTheme(color.getThemeName(), this);
    }

    public Badge(String text, BadgeColor color, BadgeSize size, BadgeShape shape) {
        super(text);
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(color.getThemeName());
        if (shape.equals(PILL)) {
            joiner.add(shape.getThemeName());
        }
        if (size.equals(BadgeSize.S)) {
            joiner.add(size.getThemeName());
        }
        UIUtils.setTheme(joiner.toString(), this);
    }

}
