package coop.intergal.tys.ui;

import java.util.stream.IntStream;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout.Orientation;
import com.vaadin.flow.component.textfield.TextField;

public class dummy extends Div  {

	  public dummy() {

	Grid<String> grid = new Grid<>();
	grid.addColumn(x->x);

	SplitLayout sl = new SplitLayout(new VerticalLayout(new TextField("Field")), grid);
	sl.setOrientation(Orientation.VERTICAL);
	    add(sl);    	
	    
	    grid.setItems(IntStream.range(0, 2000).mapToObj(Integer::toString));

	    sl.setSizeFull();
	    setSizeFull();
	  }

	}