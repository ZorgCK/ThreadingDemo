
package com.company.threadingdemo.ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Future;

import com.company.threadingdemo.dal.CategoryDAO;
import com.company.threadingdemo.entities.Category;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;
import com.xdev.Application;
import com.xdev.ui.XdevAbsoluteLayout;
import com.xdev.ui.XdevButton;
import com.xdev.ui.XdevHorizontalLayout;
import com.xdev.ui.XdevLabel;
import com.xdev.ui.XdevVerticalLayout;
import com.xdev.ui.XdevView;

public class MainView extends XdevView {

	Integer left = 10;
	Integer top = 7;

	/**
	 * 
	 */
	public MainView() {
		super();
		this.initUI();
	}

	public class buttonMoveTask extends TimerTask {
		@Override
		public void run() {
			absoluteLayout.removeComponent(button);

			left = left + 3;
			StringBuilder builder = new StringBuilder();
			builder.append("left:");
			builder.append(left);
			builder.append("px; ");
			builder.append("top:");
			builder.append(top);
			builder.append("px");

			absoluteLayout.addComponent(button, builder.toString());

			UI.getCurrent().push();
		}
	}

	public class myClockTask extends TimerTask {
		@Override
		public void run() {
			label.setValue(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			UI.getCurrent().push();
		}
	}

	public class dataCounterTask extends TimerTask {
		@Override
		public void run() {

			Future<List<Category>> categoryCall = Application.getExecutorService().submit(() -> {
				List<Category> findAll = new CategoryDAO().findAll();
				return findAll;
			});

			try {
				List<Category> list = categoryCall.get();
				int size = list.size();
				label2.setValue("Es sind genau " + size + " Kategorien verfügbar");
				System.out.println("geladen");
				UI.getCurrent().push();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #button2}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button2_buttonClick(Button.ClickEvent event) {
		Timer buttonMoveTimer = new Timer();
		buttonMoveTimer.schedule(new buttonMoveTask(), 1000, 500);
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #button3}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button3_buttonClick(Button.ClickEvent event) {
		Timer clockTimer = new Timer();
		clockTimer.schedule(new myClockTask(), 1000, 1000);
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #button4}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button4_buttonClick(Button.ClickEvent event) {
		Timer dataCounter = new Timer();
		dataCounter.schedule(new dataCounterTask(), 5000, 5000);
	}

	/*
	 * WARNING: Do NOT edit!<br>The content of this method is always regenerated
	 * by the UI designer.
	 */
	// <generated-code name="initUI">
	private void initUI() {
		this.verticalLayout = new XdevVerticalLayout();
		this.horizontalLayout = new XdevHorizontalLayout();
		this.button2 = new XdevButton();
		this.absoluteLayout = new XdevAbsoluteLayout();
		this.button = new XdevButton();
		this.gridLayout = new XdevHorizontalLayout();
		this.button3 = new XdevButton();
		this.label = new XdevLabel();
		this.horizontalLayout2 = new XdevHorizontalLayout();
		this.button4 = new XdevButton();
		this.label2 = new XdevLabel();

		this.horizontalLayout.setMargin(new MarginInfo(false));
		this.button2.setCaption("Button Start");
		this.button.setCaption("Button");
		this.gridLayout.setMargin(new MarginInfo(false));
		this.button3.setCaption("Uhr Start");
		this.label.setStyleName("h1");
		this.label.setValue("Label");
		this.horizontalLayout2.setMargin(new MarginInfo(false));
		this.button4.setCaption("Daten zählen");
		this.label2.setStyleName("h1");
		this.label2.setValue("Label");

		this.absoluteLayout.addComponent(this.button, "left:10px; top:7px");
		this.button2.setSizeUndefined();
		this.horizontalLayout.addComponent(this.button2);
		this.horizontalLayout.setComponentAlignment(this.button2, Alignment.MIDDLE_LEFT);
		this.absoluteLayout.setWidth(100, Unit.PERCENTAGE);
		this.absoluteLayout.setHeight(50, Unit.PIXELS);
		this.horizontalLayout.addComponent(this.absoluteLayout);
		this.horizontalLayout.setComponentAlignment(this.absoluteLayout, Alignment.MIDDLE_CENTER);
		this.horizontalLayout.setExpandRatio(this.absoluteLayout, 10.0F);
		this.button3.setSizeUndefined();
		this.gridLayout.addComponent(this.button3);
		this.gridLayout.setComponentAlignment(this.button3, Alignment.MIDDLE_LEFT);
		this.label.setSizeUndefined();
		this.gridLayout.addComponent(this.label);
		this.gridLayout.setComponentAlignment(this.label, Alignment.MIDDLE_LEFT);
		CustomComponent gridLayout_spacer = new CustomComponent();
		gridLayout_spacer.setSizeFull();
		this.gridLayout.addComponent(gridLayout_spacer);
		this.gridLayout.setExpandRatio(gridLayout_spacer, 1.0F);
		this.button4.setSizeUndefined();
		this.horizontalLayout2.addComponent(this.button4);
		this.horizontalLayout2.setComponentAlignment(this.button4, Alignment.MIDDLE_CENTER);
		this.label2.setSizeUndefined();
		this.horizontalLayout2.addComponent(this.label2);
		this.horizontalLayout2.setComponentAlignment(this.label2, Alignment.MIDDLE_CENTER);
		CustomComponent horizontalLayout2_spacer = new CustomComponent();
		horizontalLayout2_spacer.setSizeFull();
		this.horizontalLayout2.addComponent(horizontalLayout2_spacer);
		this.horizontalLayout2.setExpandRatio(horizontalLayout2_spacer, 1.0F);
		this.horizontalLayout.setWidth(100, Unit.PERCENTAGE);
		this.horizontalLayout.setHeight(131, Unit.PIXELS);
		this.verticalLayout.addComponent(this.horizontalLayout);
		this.verticalLayout.setComponentAlignment(this.horizontalLayout, Alignment.MIDDLE_CENTER);
		this.gridLayout.setWidth(100, Unit.PERCENTAGE);
		this.gridLayout.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.gridLayout);
		this.verticalLayout.setComponentAlignment(this.gridLayout, Alignment.MIDDLE_CENTER);
		this.horizontalLayout2.setWidth(100, Unit.PERCENTAGE);
		this.horizontalLayout2.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.horizontalLayout2);
		this.verticalLayout.setComponentAlignment(this.horizontalLayout2, Alignment.MIDDLE_CENTER);
		CustomComponent verticalLayout_spacer = new CustomComponent();
		verticalLayout_spacer.setSizeFull();
		this.verticalLayout.addComponent(verticalLayout_spacer);
		this.verticalLayout.setExpandRatio(verticalLayout_spacer, 1.0F);
		this.verticalLayout.setSizeFull();
		this.setContent(this.verticalLayout);
		this.setSizeFull();

		button2.addClickListener(event -> this.button2_buttonClick(event));
		button3.addClickListener(event -> this.button3_buttonClick(event));
		button4.addClickListener(event -> this.button4_buttonClick(event));
	} // </generated-code>
		// <generated-code name="variables">

	private XdevButton button2, button, button3, button4;
	private XdevLabel label, label2;
	private XdevHorizontalLayout horizontalLayout, gridLayout, horizontalLayout2;
	private XdevAbsoluteLayout absoluteLayout;
	private XdevVerticalLayout verticalLayout; // </generated-code>

}
