package coop.intergal.tys.ui.views.maestros.personasentidades;

import java.util.ArrayList;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.templatemodel.TemplateModel;

import coop.intergal.AppConst;
import coop.intergal.ui.components.QueryButtonsBar;
import coop.intergal.ui.util.UtilSessionData;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.ui.views.GenericDynamicQuery;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

/**
 * A Designer generated component for the visitas-query template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("visitas-query")
@JsModule("./src/views/Maestros/PersonasEntidades/visitas-query.js")
public class VisitasQuery extends GenericDynamicQuery implements BeforeEnterObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String RESOURCE_NAME = "CR-KITS";
	private DynamicViewGrid grid;
	@Id("title")
	private H3 title;
	@Id("queryButtonsBar")
	private QueryButtonsBar queryButtonsBar;
	
 	private DynamicDBean bean;
	private ArrayList<String[]> rowsColList;
	public DynamicViewGrid getGrid() {
		return grid;
	}
	public void setGrid(DynamicViewGrid grid) {
		this.grid = grid;
	}
	
   /**
     * Creates a new VisitasQuery.
     */
    public VisitasQuery() {
		super();
		super.preConfParam = UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM;
		queryButtonsBar.addSearchListener(e -> createFilterFromQryForm());
		queryButtonsBar.addClearSearchListener(e -> cleanQryForm());
	}

	private Object cleanQryForm() {
		cleanForm(VisitasQuery.class, this, RESOURCE_NAME, false);
		return null;
	}

	private Object createFilterFromQryForm() {
		stringFilter = "";
		keysFromParent = "";
		String filter = getFieldsDataForFilter(VisitasQuery.class, this, RESOURCE_NAME);
		System.out.println("VisitasQuery.createFilter()...." + filter);
		DdbDataBackEndProvider dataProvider = grid.getDataProvider();
		dataProvider.setFilter(filter);
		dataProvider.refreshAll();
		return null;
	}
//	protected LocalDate getLocalDateOf(String col42) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public Instant getInstantOf(String col4) {
//		return null;
//	}	
//	private String getDateString(Date toSet) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (bean != null)
			binder.setBean(bean);
		queryButtonsBar.addSearchListener(e -> System.out.println("VisitasQuery.beforeEnter() BUSCAR>>>>"));
	}

    /**
     * This model binds properties between VisitasQuery and visitas-query
     */
    public interface VisitasQueryModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
