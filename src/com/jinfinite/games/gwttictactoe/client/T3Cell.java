package com.jinfinite.games.gwttictactoe.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class T3Cell extends Button {
	
	private int row;
	private int col;
	private String value = "";
	private Board parentBoard;
	
	public T3Cell(Board parent, int row, int col){
		this.parentBoard = parent;
		this.row = row;
		this.col = col;
		this.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				parentBoard.getController().placeMarkerCallback(T3Cell.this);
			}			
		});
		this.setWidth("25px");
	}
	
	public boolean hasSameValueAs(T3Cell button){
		return (this.getValue().equals(button.getValue())) ? true : false;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Board getParentBoard() {
		return parentBoard;
	}

	public void setParentBoard(Board parentBoard) {
		this.parentBoard = parentBoard;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {;
		this.setText(value);
		this.setEnabled(false);
		this.value = value;
	}

}
