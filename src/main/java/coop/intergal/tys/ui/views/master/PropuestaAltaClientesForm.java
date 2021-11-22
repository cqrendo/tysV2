package coop.intergal.tys.ui.views.master;

import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.ui.views.GenericDynamicForm;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the propuesta-alta-clientes-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("propuesta-alta-clientes-form")
@JsModule("./src/views/master/propuesta-alta-clientes-form.js")
public class PropuestaAltaClientesForm extends GenericDynamicForm {

    /**
     * Creates a new PropuestaAltaClientesForm.
     */
    public PropuestaAltaClientesForm() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between PropuestaAltaClientesForm and propuesta-alta-clientes-form
     */
    public interface PropuestaAltaClientesFormModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
