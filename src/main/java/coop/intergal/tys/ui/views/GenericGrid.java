package coop.intergal.tys.ui.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import coop.intergal.AppConst;
import coop.intergal.tys.backend.BankAccount;
import coop.intergal.tys.backend.DummyData;
import coop.intergal.tys.ui.MainLayout;
import coop.intergal.tys.ui.components.Badge;
import coop.intergal.tys.ui.components.FlexBoxLayout;
import coop.intergal.tys.ui.components.ListItem;
import coop.intergal.tys.ui.layout.size.Horizontal;
import coop.intergal.tys.ui.layout.size.Right;
import coop.intergal.tys.ui.layout.size.Top;
import coop.intergal.tys.ui.layout.size.Vertical;
import coop.intergal.tys.ui.util.*;
import coop.intergal.tys.ui.util.css.*;
import coop.intergal.tys.ui.util.css.lumo.BadgeColor;
import coop.intergal.tys.ui.util.css.lumo.BadgeShape;
import coop.intergal.tys.ui.util.css.lumo.BadgeSize;
import coop.intergal.ui.utils.TranslateResource;
import coop.intergal.ui.utils.converters.CurrencyFormatter;
import coop.intergal.vaadin.rest.utils.DdbDataBackEndProvider;
import coop.intergal.vaadin.rest.utils.DynamicDBean;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Accounts")
@Route(value = "genericgrid", layout = MainLayout.class)
public class GenericGrid extends ViewFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int MOBILE_BREAKPOINT = 480;
    private Grid<DynamicDBean> grid;
    private Registration resizeListener;
	private DdbDataBackEndProvider dataProvider;
	private ArrayList<String[]> rowsColListGrid;
	private CurrencyFormatter currencyFormatter = new CurrencyFormatter();

    public GenericGrid() {
        setViewContent(createContent());
    }

    private Component createContent() {
        FlexBoxLayout content = new FlexBoxLayout(createGrid());
        content.setBoxSizing(BoxSizing.BORDER_BOX);
        content.setHeightFull();
        content.setPadding(Horizontal.RESPONSIVE_X, Top.RESPONSIVE_X);
        return content;
    }

    private Grid createGrid() {
  		dataProvider = new DdbDataBackEndProvider();
		dataProvider.setPreConfParam(AppConst.PRE_CONF_PARAM);
		dataProvider.setResourceName("CR-autobus");
		dataProvider.setFilter("");

        grid = new Grid<DynamicDBean>();
        
        grid.addSelectionListener(event -> event.getFirstSelectedItem().ifPresent(this::viewDetails));
        grid.addThemeName("mobile");
        grid.setDataProvider(dataProvider);
        grid.setId("accounts");
        grid.setSizeFull();
        rowsColListGrid = dataProvider.getRowsColList();
        int numberOFCols = rowsColListGrid.size();
		for (int i=0;i<numberOFCols; i++)
		{
			addFormatedColumn(i);
		}

		grid.getColumns().forEach(column -> column.setAutoWidth(true));
        return grid;
    }
    private void addFormatedColumn(int i) {
		String colName = "col"+i;
		String[] colData = rowsColListGrid.get(i);
		String colType = colData[3];
		boolean isNotAParentField = colData[1].indexOf("#SORT")>-1; // parent field for now can not be use as sort column
		boolean isCOlEditable = true;;
		if (colData[1].indexOf("#CNoEDT#")>-1)
			isCOlEditable = false;
		if (colData[1].indexOf("#SIG#")>-1) { // #SIG# = Show In Grid
			String header = TranslateResource.getFieldLocale(colData[0], AppConst.PRE_CONF_PARAM);
			if (isDate(header, colType)) {
				if (header.indexOf("#")>0)
					header = header.substring(2); // to avoid date typ indicator "D#"
					if (isNotAParentField)
						grid.addColumn(new LocalDateRenderer<>(d -> d.getColLocalDate(colName), "dd/MM/yyyy")).setHeader(header).setSortProperty(colData[0])
						.setResizable(true).setSortProperty(colData[0]);
					else
						grid.addColumn(new LocalDateRenderer<>(d -> d.getColLocalDate(colName), "dd/MM/yyyy")).setHeader(header).setSortProperty(colData[0])
						.setResizable(true);
						
				
//		grid.addColumn(d ->d.getCol(i)).setHeader(header).setResizable(true);
			} else if (isCurrency(header,colType)) {
				if (header.indexOf("#")>0)
					header = header.substring(2);
					if (isNotAParentField)
						{
						grid.addColumn(d -> currencyFormatter.encode(currencyFormatter.getCents(d.getCol(colName)))).setHeader(header)
						.setTextAlign(ColumnTextAlign.END).setResizable(true).setSortProperty(colData[0]);
						}
					else
						{
						grid.addColumn(d -> currencyFormatter.encode(currencyFormatter.getCents(d.getCol(colName)))).setHeader(header)
						.setTextAlign(ColumnTextAlign.END).setResizable(true);
						}

			}  else if (isBoolean(header,colType)) {
				if (header.indexOf("#")>0)
					header = header.substring(2);
					if (isNotAParentField)
						{
						grid.addColumn(d -> currencyFormatter.encode(currencyFormatter.getCents(d.getCol(colName)))).setHeader(header)
						.setTextAlign(ColumnTextAlign.END).setResizable(true).setSortProperty(colData[0]);
						}
					else
						{
						grid.addColumn(d -> currencyFormatter.encode(currencyFormatter.getCents(d.getCol(colName)))).setHeader(header)
						.setTextAlign(ColumnTextAlign.END).setResizable(true);
						}

			}
			else

			{
				grid.addColumn(d -> d.getCol(colName)).setHeader(header).setResizable(true).setSortProperty(colData[0]) ;
			}
		}

	}
    private boolean isCurrency(String header, String colType) {
    	if (header.startsWith("C#")) // when there is nmot the type defined in FiledTemplate it can be defined in the name with the prefix "d#"
    		return true; 
    	if (colType.equals("3"))
    		return true;
    	return false;
    }


    private boolean isDate(String header, String colType) {
    	if (header.startsWith("D#")) // when there is nmot the type defined in FiledTemplate it can be defined in the name with the prefix "d#"
    		return true; 
    	if (colType.equals("1"))
    		return true;
    	return false;
    }
    private boolean isBoolean(String header, String colType) {
    	if (colType.equals("4"))
    		return true;
    	return false;
    }

    private BankAccountMobileTemplate getMobileTemplate(BankAccount bankAccount) {
        return new BankAccountMobileTemplate(bankAccount);
    }

    private Component createBankInfo(BankAccount bankAccount) {
        return new ListItem(bankAccount.getAccount(), bankAccount.getBank());
    }

    private Component createAvailability(BankAccount bankAccount) {
        Double availability = bankAccount.getAvailability();
        Label label = UIUtils.createAmountLabel(availability);
        if (availability > 0) {
            UIUtils.setTextColor(TextColor.SUCCESS, label);
        } else {
            UIUtils.setTextColor(TextColor.ERROR, label);
        }
        return label;
    }

    private void viewDetails(DynamicDBean dynamicDBean) {
  //      UI.getCurrent().navigate(AccountDetails.class, bankAccount.getId());
    	String ulrParams = "CR-autobus"; // resourceName;
    	ulrParams = ulrParams+"&ID="+dynamicDBean.getCol0()+"&&";
        UI.getCurrent().navigate(GenericDetails.class, ulrParams);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        getUI().ifPresent(ui -> {
            Page page = ui.getPage();
            resizeListener = page.addBrowserWindowResizeListener(event -> updateVisibleColumns(event.getWidth()));
            page.retrieveExtendedClientDetails(details -> updateVisibleColumns(details.getBodyClientWidth()));
        });
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        resizeListener.remove();
        super.onDetach(detachEvent);
    }

    private void updateVisibleColumns(int width) {
        boolean mobile = width < MOBILE_BREAKPOINT;
        List<Column<DynamicDBean>> columns = grid.getColumns();

        // "Mobile" column
        columns.get(0).setVisible(mobile);

        // "Desktop" columns
        for (int i = 1; i < columns.size(); i++) {
            columns.get(i).setVisible(!mobile);
        }
    }

    /**
     * A layout for displaying BankAccount info in a mobile friendly format.
     */
    private class BankAccountMobileTemplate extends FlexBoxLayout {

        private BankAccount bankAccount;

        public BankAccountMobileTemplate(BankAccount bankAccount) {
            this.bankAccount = bankAccount;

            UIUtils.setLineHeight(LineHeight.M, this);
            UIUtils.setPointerEvents(PointerEvents.NONE, this);

            setPadding(Vertical.S);
            setSpacing(Right.L);

            Image logo = getLogo();
            FlexBoxLayout owner = getOwner();
            Label account = getAccount();
            FlexBoxLayout availability = getAvailability();

            FlexBoxLayout column = new FlexBoxLayout(owner, account, availability);
            column.setFlexDirection(FlexDirection.COLUMN);
            column.setOverflow(Overflow.HIDDEN);

            add(logo, column);
            setFlexGrow(1, column);
        }

        private Image getLogo() {
            Image logo = DummyData.getLogo();
            setFlexShrink("0", logo);
            logo.setHeight(LumoStyles.IconSize.M);
            logo.setWidth(LumoStyles.IconSize.M);
            return logo;
        }

        private FlexBoxLayout getOwner() {
            Label owner = UIUtils.createLabel(FontSize.M, TextColor.BODY, bankAccount.getOwner());
            UIUtils.setOverflow(Overflow.HIDDEN, owner);
            UIUtils.setTextOverflow(TextOverflow.ELLIPSIS, owner);

            Badge id = new Badge(String.valueOf(bankAccount.getId()), BadgeColor.NORMAL, BadgeSize.S, BadgeShape.PILL);

            FlexBoxLayout wrapper = new FlexBoxLayout(owner, id);
            wrapper.setAlignItems(Alignment.CENTER);
            wrapper.setFlexGrow(1, owner);
            wrapper.setFlexShrink("0", id);
            wrapper.setSpacing(Right.M);
            return wrapper;
        }

        private Label getAccount() {
            Label account = UIUtils.createLabel(FontSize.S, TextColor.SECONDARY, bankAccount.getAccount());
            account.addClassNames(LumoStyles.Margin.Bottom.S);
            UIUtils.setOverflow(Overflow.HIDDEN, account);
            UIUtils.setTextOverflow(TextOverflow.ELLIPSIS, account);
            return account;
        }

        private FlexBoxLayout getAvailability() {
            Label availability = UIUtils.createH4Label("$" + UIUtils.formatAmount(bankAccount.getAvailability()));
            UIUtils.setLineHeight(LineHeight.S, availability);

            Label updated = UIUtils.createLabel(FontSize.XS, TextColor.TERTIARY, UIUtils.formatDate(bankAccount.getUpdated()));

            FlexBoxLayout wrapper = new FlexBoxLayout(availability, updated);
            wrapper.setAlignItems(Alignment.BASELINE);
            wrapper.setFlexGrow(1, availability);
            return wrapper;
        }
    }
}
