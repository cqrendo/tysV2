package coop.intergal.ui.util;

import static coop.intergal.AppConst.PACKAGE_VIEWS;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.function.SerializableComparator;

import coop.intergal.AppConst;
import coop.intergal.espresso.presutec.utils.JSonClient;
import coop.intergal.ui.utils.ProcessParams;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.vaadin.rest.utils.DataService;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import coop.intergal.vaadin.rest.utils.RestData;

public class GenericClassForMethods {
	
	public Object processButtonForNavigation(String idButton, DynamicDBean bean, Div divSubGrid, DynamicViewGrid grid) {
//		String titleOption = rowSubMenu.get("optionName").asText();
		int idxIdMenu = idButton.indexOf("@IDM");
		boolean isPopup = idButton.indexOf("@POP") > -1;
		if (idxIdMenu == -1)
		{
			DataService.get().showError("Id de menu sin indicar, se debe de especificar en el formato nombreopcion#IDMnumero");
			return null; 
		}
		try {
		String idMenu = idButton.substring(idxIdMenu+4);
		
		String filter = "idMenu="+idMenu;
		JsonNode rowsList = JSonClient.get("menu",filter,false,AppConst.PRE_CONF_PARAM_METADATA,1+"");
		for (JsonNode rowSubMenu : rowsList)  
			{	
	
			String urlBase = "../dymanic";
			String hostName = InetAddress.getLocalHost().getHostName() ;
			if (hostName.indexOf(".local") == -1) // to diferent when is running in local (Maven) or in remote (tys.war -> tomcat)
				urlBase= "../tys/dymanic";
			String optionName = rowSubMenu.get("optionName").asText();	
			String resource = rowSubMenu.get("resource").asText();
			String queryFormClassName = rowSubMenu.get("queryFormClassName").asText();
			String displayFormClassName = rowSubMenu.get("displayFormClassName").asText();
			String layoutClassName = rowSubMenu.get("layout").asText();
			String filterForPopup = rowSubMenu.get("filterForPopup").asText();
			if (queryFormClassName.startsWith("coop.intergal.ui.views") == false)
				queryFormClassName = PACKAGE_VIEWS+queryFormClassName;
			if (displayFormClassName.startsWith("coop.intergal.ui.views") == false)
				displayFormClassName = PACKAGE_VIEWS+displayFormClassName;
		
//		titleOption = titleOption.replace(" ", "%20");
			if (isPopup)
			{
//				String filterForNavigation = "row.subgrid.CLAVEARTICULO=rowtarget.CLAVE_ARTICULO";
				if ( layoutClassName.indexOf("DynamicViewGrid") > -1)  // when is a grid list is send the origin row to filter the list in the target 
				{
					DynamicDBean sourceRow = getRowSelected(divSubGrid);
					showDialog(sourceRow, resource, layoutClassName, displayFormClassName, grid, filterForPopup );
				}
				else // // when is a Display is send the target row to be show as target
				{
				DynamicDBean beanToShow = getBeanToShow(bean, filterForPopup, resource, divSubGrid);
				if (beanToShow != null )
					showDialog(beanToShow, resource, layoutClassName, displayFormClassName, grid, filterForPopup );
				}
			}	
			else
				UI.getCurrent().getPage().executeJs("window.open('"+urlBase+"?resourceName="+resource+"&queryFormClassName="+queryFormClassName+"&displayFormClassName="+displayFormClassName+"&title="+optionName+"', '_blank');") ;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	private DynamicDBean getBeanToShow(DynamicDBean bean2, String filterForNavigation, String resource, Div divSubGrid) {
		if (filterForNavigation.startsWith("row.subgrid"))
		{				
			String filter = componFilterFromSubgridRowSelected(filterForNavigation, divSubGrid);
			if (filter != null)
				{
				DynamicDBean rowtoShow = RestData.getOneRow(resource, filter, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM);					
				return rowtoShow;
				}
		}
		return null;
	}

	private String componFilterFromSubgridRowSelected(String filterForNavigation, Div divSubGrid) { // @@ TODO prepare for multi filter
	
		return ProcessParams.componFilterFromParams(filterForNavigation,getRowSelected(divSubGrid));

		
		
	}

	private DynamicDBean getRowSelected(Div divSubGrid) {
		DynamicViewGrid dvGrid = (DynamicViewGrid) divSubGrid.getChildren().findFirst().get().getChildren().findFirst().get().getChildren().findFirst().get();
		Set<DynamicDBean> seletedItems = dvGrid.getGrid().getSelectedItems();
		if (seletedItems.isEmpty())
		{
			DataService.get().showError("Debe de selecionar un registro");
			return null;
		}
		return seletedItems.iterator().next();
	}
	private Object showDialog(DynamicDBean bean2, String resource2, String layoutClassName, String displayFormClassName, DynamicViewGrid grid, String filterForPopup) { 
		
		DdbDataBackEndProvider dataProvider = new DdbDataBackEndProvider();
		dataProvider.setPreConfParam(UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM);
		dataProvider.setResourceName(resource2);
//		dataProvider.setFilter(getFilter());

		
		grid.showBeaninPopup(bean2, resource2,layoutClassName, displayFormClassName, null, filterForPopup );

//			dialogForPick = new Dialog();
//		dialogForPick.removeAll();
//		dialogForPick.setCloseOnOutsideClick(false);
//		dialogForPick.add(new Label(bean.getCol0()));
//		dialogForPick.open();
		
		
		
		return null;
	}

	public Object processButtonForProcess(String idButton, DynamicDBean bean, Div divSubGrid, DynamicViewGrid grid)
	{
		int idxIdProcess = idButton.indexOf("@IDP");
		if (idxIdProcess == -1)
		{
			DataService.get().showError("Id de proceso sin indicar, se debe de especificar en el formato nombreopcion#IDPnumero");
			return null; 
		}
		try {
			String idMProcess = idButton.substring(idxIdProcess+4);
			String filter = "idProcess="+idMProcess;
			JsonNode rowsList;
			rowsList = JSonClient.get("CR-Process",filter,false,AppConst.PRE_CONF_PARAM_METADATA,1+"");
			for (JsonNode rowProcess : rowsList)  
				{	
				System.out.println("GenericClassForMethods.processButtonForProcess() "+ rowProcess.get("name").asText());
				JsonNode rowsSteps = rowProcess.get("List-ProcessStep");
				for (JsonNode rowStep : rowsSteps) 
					{
					System.out.println("GenericClassForMethods.processButtonForProcess() STEP "+ rowStep.get("name").asText());	
					String inputResourceForReadData = rowStep.get("inputResourceForReadData").asText();
					String inputResourceForAskData = rowStep.get("inputResourceForAskData").asText();
					DynamicDBean rowOfInputData = null;
//					if (inputResourceForAskData.isEmpty() == false  )
//						rowOfInputData = askInputData(inputResourceForAskData, grid);
					processInput(grid, inputResourceForReadData, rowOfInputData);
					JsonNode rowsStepOuput = rowStep.get("List-ProcessStepOutput");
					for (JsonNode rowStepOuput : rowsStepOuput) 
						{
						System.out.println("GenericClassForMethods.processButtonForProcess() STEP OUTPUT "+ rowStepOuput.get("resource").asText());
						}
					}
				}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		return null; 
	}
	private void processInput(DynamicViewGrid grid, String inputResourceForReadData, DynamicDBean rowOfInputData) {
		Stream<DynamicDBean> rowsStream = ((DataProvider<DynamicDBean, String>) grid.getGrid().getDataProvider()).fetch(createQuery(grid.getGrid()));
//		grid.getGrid().getSelectedItems();j
		Iterator<DynamicDBean> rows = rowsStream.iterator();
		DynamicDBean row = null;
		while (rows.hasNext()) {
			row = rows.next();
			System.out.println("GenericClassForMethods.processInput() EACH Row in grid " + row.getCol0() + " "+  row.getRowJSon().asText() );
		}
			
		
		
	}
	private DynamicDBean askInputData(String inputResourceForAskData, DynamicViewGrid grid) {
		DynamicDBean rowtoShow = RestData.getOneRow(inputResourceForAskData, null, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM);
		String layoutClassName=null;
		String displayFormClassName = null;
		String filterForPopup = null ;
		showDialog(rowtoShow, inputResourceForAskData, layoutClassName, displayFormClassName, grid, filterForPopup);
		return null;
		
	}

    /*
     * This method is needed if using Vaadin 14, which does not have DataView API yet
     */
    private Query<DynamicDBean, String> createQuery(Grid<DynamicDBean> grid) {
        List<GridSortOrder<DynamicDBean>> gridSort = grid.getSortOrder();
        List<QuerySortOrder> sortOrder = gridSort
            .stream()
            .map(order -> order.getSorted().getSortOrder(order.getDirection()))
            .flatMap(orders -> orders)
            .collect(Collectors.toList());

        BinaryOperator<SerializableComparator<DynamicDBean>> operator = (comparator1, comparator2) -> {
            return comparator1.thenComparing(comparator2)::compare;
        };
        SerializableComparator<DynamicDBean> inMemorySorter = gridSort
            .stream()
            .map(order -> order.getSorted().getComparator(order.getDirection()))
            .reduce(operator)
            .orElse(null);

        return new Query<DynamicDBean, String>(0, Integer.MAX_VALUE, sortOrder, inMemorySorter, null);
    }
}
