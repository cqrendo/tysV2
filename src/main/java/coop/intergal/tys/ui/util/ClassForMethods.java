package coop.intergal.tys.ui.util;

import java.util.stream.Collectors;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;

import coop.intergal.AppConst;
import coop.intergal.ui.util.GenericClassForMethods;
import coop.intergal.ui.utils.ProcessParams;
import coop.intergal.ui.utils.UtilSessionData;
import coop.intergal.ui.views.DynamicViewGrid;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import coop.intergal.vaadin.rest.utils.RestData;

public class ClassForMethods extends GenericClassForMethods{
	
	public void refreshOpenPopups(DynamicDBean dB, DynamicViewGrid dVGrid)
	{
		System.out.println("ClassForMethods.refreshOpenPopups() " + dB.getCol0());
//		Stream<Component> streamOpenDialogs = UI.getCurrent().getChildren().filter(c->c instanceof Dialog);
//		if (streamOpenDialogs != null && streamOpenDialogs.count() > 0)
//			{
//			Iterator<Component> itOpenDialogs = streamOpenDialogs.iterator();
//			while (itOpenDialogs.hasNext())
//				{
//				Dialog dialog = (Dialog) itOpenDialogs.next();
//				System.out.println("ClassForMethods.refreshOpenPopups() Dialog ID" + dialog.getId());
//				}
//			}
		
//		Object searchid = null;
//		for (Component child : UI.getCurrent().getChildren().collect(Collectors.toList()))
//		{
//			String id = child.getId().get();
//			
//			if (id.equals(searchid))
//				break;
//			else
//			{
//				for (Component child2 :child.getChildren().collect(Collectors.toList()))
//				{
//					id = child2.getId().get();
//					
//					if (id.equals(searchid))
//						break;
//					else
//					{
//						for (Component child3:child.getChildren().collect(Collectors.toList()))
//						{
//							id = child2.getId().get();
//							
//							if (id.equals(searchid))
//								break;
//							else
//							{
//					//			and so on..
//							}		
//					}	
//			}
//		}
		for (Component child : UI.getCurrent().getChildren().filter(c->c instanceof Dialog).collect(Collectors.toList())) {
			Dialog dialog = (Dialog) child;
			String paramsInId = dialog.getId().get(); // format ResourceNama@DFC@"displayFormClassNamePopup);
			int idxDFC = paramsInId.indexOf("@DFC@");
			int idxFilter = paramsInId.indexOf("@F@");
			int idxLayout = paramsInId.indexOf("@L@");
			String resourceName = paramsInId.substring(0,idxDFC);
			String displayFormClassNamePopup = paramsInId.substring(idxDFC+5, idxFilter );
			String filterForPopup = paramsInId.substring(idxFilter + 3,idxLayout);
			String filter = ProcessParams.componFilterFromParams(filterForPopup, dB);
			String layoutClassName= paramsInId.substring(idxLayout + 3);
			System.out.println("ClassForMethods.refreshOpenPopups() Dialog ID " + dialog.getId());
//			String filter = "CLAVE_ARTICULO="+dB.getRowJSon().get("CLAVEARTICULO");
			if (layoutClassName.indexOf("DynamicViewGrid") > -1) // when is a grid list is send the origin row to filter the list in the target 0'9o
			{
				dVGrid.showBeaninPopup(dB, resourceName,layoutClassName, displayFormClassNamePopup, dialog, filterForPopup);
			}
			else // when is a Display is send the target row to be show as target
			{
				DynamicDBean rowtoShow = RestData.getOneRow(resourceName, filter, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM);
				dVGrid.showBeaninPopup(rowtoShow, resourceName,layoutClassName, displayFormClassNamePopup, dialog, filterForPopup);
			}



		}
//		UI.getCurrent().getChildren().filter(c->c instanceof Dialog).iterator()
//		.filter(c->c.getId().equals("CR_ARTICULOS"))
//		Dialog dialog = dVGrid.getDialogForShow();
//		if (dialog != null && dialog.isOpened())
//		{
//			String resource = dVGrid.getDialogForShow().getId().get();
//			String filter = "CLAVE_ARTICULO="+dB.getRowJSon().get("CLAVEARTICULO");
//			DynamicDBean rowtoShow = RestData.getOneRow(resource, filter, UtilSessionData.getCompanyYear()+AppConst.PRE_CONF_PARAM);					
//
//			dVGrid.showBeaninPopup(rowtoShow, null,null );
//		}
//		else
//		{
//			System.out.println("ClassForMethods.refreshOpenPopups() NO DIALOG OPEN TO REFRESH");
//		}
	}


}
