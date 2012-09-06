package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StockWatcher implements EntryPoint{
	
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable stocksFlexTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox newSymbolTextBox = new TextBox();
	private Button addStockButton = new Button("Add");
	private Label lastUpsdatedLabel = new Label();
	private ArrayList<String> stocks = new ArrayList<String>();
	
	/**
	 * Entry point method
	 */
	
	public void onModuleLoad(){
		//create table for stock data
		stocksFlexTable.setText(0, 0, "Symbol");
		stocksFlexTable.setText(0, 1, "Price");
		stocksFlexTable.setText(0, 2, "Change");
		stocksFlexTable.setText(0, 3, "Remove");
		
		//Assemble Add Stock panel
		addPanel.add(addStockButton);
		addPanel.add(newSymbolTextBox);
		
		//Assemble Main Panel
		mainPanel.add(stocksFlexTable);
		mainPanel.add(addPanel);
		mainPanel.add(lastUpsdatedLabel	);
		
		//Associate Main panel with the HTML host page
		RootPanel.get("stockList").add(mainPanel);
		
		//Move cursor focus to input box
		newSymbolTextBox.setFocus(true);
		
		//Listen for mouse events on add button
		addStockButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				addStock();
			}
		});
		
		//Listen for keyboard
		newSymbolTextBox.addKeyPressHandler(new KeyPressHandler(){

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getCharCode() == KeyCodes.KEY_ENTER){
					addStock();
				}
				
			}
			
		});
		
	}

	protected void addStock() {
		// TODO Auto-generated method stub
		final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
		newSymbolTextBox.setFocus(true);
		
		if (!symbol.matches("^[0-9A-Za-z\\.]{1,10}$")){
			Window.alert("'" + symbol + "' is not a valid symbol");
			newSymbolTextBox.selectAll();
			return;
		}
		
		newSymbolTextBox.setText("");
		
		// dont add stock if its already in table
		if (stocks.contains(symbol))
			return;
		
		// add stock
		int row = stocksFlexTable.getRowCount();
		stocks.add(symbol);
		stocksFlexTable.setText(row, 0, symbol);
		
		//add button to remove stock
		Button removeStockButton = new Button("x");
		removeStockButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				int removedIndex = stocks.indexOf(symbol);
				stocks.remove(removedIndex);
				stocksFlexTable.removeRow(removedIndex+1);
				
			}
			
		});
		stocksFlexTable.setWidget(row, 3, removeStockButton);
		
		// get stock price
		
	}
	
	
	
}