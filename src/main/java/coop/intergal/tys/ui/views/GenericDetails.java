package coop.intergal.tys.ui.views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.ListSeries;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexDirection;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import coop.intergal.AppConst;
import coop.intergal.tys.backend.DummyData;
import coop.intergal.tys.ui.MainLayout;
import coop.intergal.tys.ui.components.FlexBoxLayout;
import coop.intergal.tys.ui.components.ListItem;
import coop.intergal.tys.ui.components.navigation.bar.AppBar;
import coop.intergal.tys.ui.layout.size.Bottom;
import coop.intergal.tys.ui.layout.size.Horizontal;
import coop.intergal.tys.ui.layout.size.Top;
import coop.intergal.tys.ui.layout.size.Vertical;
import coop.intergal.tys.ui.util.BoxShadowBorders;
import coop.intergal.tys.ui.util.LumoStyles;
import coop.intergal.tys.ui.util.TextColor;
import coop.intergal.tys.ui.util.UIUtils;
import coop.intergal.tys.ui.util.css.BorderRadius;
import coop.intergal.tys.ui.util.css.WhiteSpace;
import coop.intergal.vaadin.rest.utils.DynamicDBean;
import coop.intergal.vaadin.rest.utils.RestData;

@PageTitle("Account Details")
@Route(value = "generic-details", layout = MainLayout.class)
public class GenericDetails extends ViewFrame implements HasUrlParameter<String> {

    public int RECENT_TRANSACTIONS = 4;

    private ListItem availability;
    private ListItem bankAccount;
    private ListItem updated;

    private DynamicDBean dynamicDBean;

	private ArrayList<String[]> rowsColList;
	private Binder<DynamicDBean> binder;
	private FormLayout form;

    @Override
    public void setParameter(BeforeEvent beforeEvent, String params) {
  //      setViewContent(createContent());
        // resourceName=CR-autobus&filter=ID=1
        
        String resourceName = params.substring(0, params.indexOf("&"));
        String filter = params.substring(params.indexOf("&")+1, params.indexOf("&&"));
        dynamicDBean = RestData.getOneRow(resourceName, filter, AppConst.PRE_CONF_PARAM, null);
        rowsColList = RestData.getRowsColList(null, resourceName, AppConst.PRE_CONF_PARAM);
        setBinder();
        if (dynamicDBean != null)
			binder.setBean(dynamicDBean);

        setViewContent(createContent());
    }

    private Component createContent() {
        FlexBoxLayout content = new FlexBoxLayout(
 //               createLogoSection(),
        		createFormSection(),
                createRecentTransactionsHeader(),
                createRecentTransactionsList(),
                createMonthlyOverviewHeader(),
                createMonthlyOverviewChart()
        );
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO, Vertical.RESPONSIVE_L);
        content.setMaxWidth("840px");
        return content;
    }
	private Component createFormSection() {
		// TODO Auto-generated method stub
		return  new FlexBoxLayout(form);
	}

	public void setBinder() {//BeanValidationBinder<DynamicDBean> binder) {
	//	this.binder = binder;
		this.binder = new Binder<DynamicDBean>(DynamicDBean.class);
		Iterator<String[]> itRowsColList = rowsColList.iterator();
		if (form == null)
			form = new FormLayout();
		form.removeAll();
		int i = 0;
		while (itRowsColList.hasNext())
		{
			TextField tf = new TextField(itRowsColList.next()[0]);
			binder.bind(tf, "col"+i);
			form.add(tf);
			i++;
			
		}
	}
    private FlexBoxLayout createLogoSection() {
        Image image = DummyData.getLogo();
        image.addClassName(LumoStyles.Margin.Horizontal.L);
        UIUtils.setBorderRadius(BorderRadius._50, image);
        image.setHeight("200px");
        image.setWidth("200px");

        availability = new ListItem(UIUtils.createTertiaryIcon(VaadinIcon.DOLLAR), "", "Availability");
        availability.getPrimary().addClassName(LumoStyles.Heading.H2);
        availability.setDividerVisible(true);
        availability.setId("availability");
        availability.setReverse(true);

        bankAccount = new ListItem(UIUtils.createTertiaryIcon(VaadinIcon.INSTITUTION), "", "");
        bankAccount.setDividerVisible(true);
        bankAccount.setId("bankAccount");
        bankAccount.setReverse(true);
        bankAccount.setWhiteSpace(WhiteSpace.PRE_LINE);

        updated = new ListItem(UIUtils.createTertiaryIcon(VaadinIcon.CALENDAR), "", "Updated");
        updated.setReverse(true);

        FlexBoxLayout listItems = new FlexBoxLayout(availability, bankAccount, updated);
        listItems.setFlexDirection(FlexDirection.COLUMN);

        FlexBoxLayout section = new FlexBoxLayout(image, listItems);
        section.addClassName(BoxShadowBorders.BOTTOM);
        section.setAlignItems(FlexComponent.Alignment.CENTER);
        section.setFlex("1", listItems);
        section.setFlexWrap(FlexWrap.WRAP);
        section.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        section.setPadding(Bottom.L);
        return section;
    }

    private Component createRecentTransactionsHeader() {
        Label title = UIUtils.createH3Label("Recent Transactions");

        Button viewAll = UIUtils.createSmallButton("View All");
        viewAll.addClickListener(
                e -> UIUtils.showNotification("Not implemented yet."));
        viewAll.addClassName(LumoStyles.Margin.Left.AUTO);

        FlexBoxLayout header = new FlexBoxLayout(title, viewAll);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setMargin(Bottom.M, Horizontal.RESPONSIVE_L, Top.L);
        return header;
    }

    private Component createRecentTransactionsList() {
        Div items = new Div();
        items.addClassNames(BoxShadowBorders.BOTTOM, LumoStyles.Padding.Bottom.L);

        for (int i = 0; i < RECENT_TRANSACTIONS; i++) {
            Double amount = DummyData.getAmount();
            Label amountLabel = UIUtils.createAmountLabel(amount);
            if (amount > 0) {
                UIUtils.setTextColor(TextColor.SUCCESS, amountLabel);
            } else {
                UIUtils.setTextColor(TextColor.ERROR, amountLabel);
            }
            ListItem item = new ListItem(
                    DummyData.getLogo(),
                    DummyData.getCompany(),
                    UIUtils.formatDate(LocalDate.now().minusDays(i)),
                    amountLabel
            );
            // Dividers for all but the last item
            item.setDividerVisible(i < RECENT_TRANSACTIONS - 1);
            items.add(item);
        }

        return items;
    }

    private Component createMonthlyOverviewHeader() {
        Label header = UIUtils.createH3Label("Monthly Overview");
        header.addClassNames(LumoStyles.Margin.Vertical.L, LumoStyles.Margin.Responsive.Horizontal.L);
        return header;
    }

    private Component createMonthlyOverviewChart() {
        Chart chart = new Chart(ChartType.COLUMN);

        Configuration conf = chart.getConfiguration();
        conf.setTitle("");
        conf.getLegend().setEnabled(true);

        XAxis xAxis = new XAxis();
        xAxis.setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        conf.addxAxis(xAxis);

        conf.getyAxis().setTitle("Amount ($)");

        // Withdrawals and deposits
        ListSeries withDrawals = new ListSeries("Withdrawals");
        ListSeries deposits = new ListSeries("Deposits");

        for (int i = 0; i < 8; i++) {
            withDrawals.addData(DummyData.getRandomInt(5000, 10000));
            deposits.addData(DummyData.getRandomInt(5000, 10000));
        }

        conf.addSeries(withDrawals);
        conf.addSeries(deposits);

        FlexBoxLayout card = new FlexBoxLayout(chart);
        card.setHeight("400px");
        return card;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        initAppBar();
        UI.getCurrent().getPage().setTitle("account.getOwner()");

    }

    private AppBar initAppBar() {
        AppBar appBar = MainLayout.get().getAppBar();
        appBar.setNaviMode(AppBar.NaviMode.CONTEXTUAL);
        appBar.getContextIcon().addClickListener(e -> UI.getCurrent().navigate(GenericGrid.class));
        appBar.setTitle("account.getOwner()");
        return appBar;
    }
}
