package com.jinfinite.games.gwttictactoe.client;

import com.google.gwt.user.client.ui.Grid;

public class Board extends Grid{

	private GwtTicTacToe controller;
	
	public Board(GwtTicTacToe controller, int size) {
		super(size, size);
		this.controller = controller;
		this.setStyleName("");
		setCellButtons();
	}
	
	private void setCellButtons() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				this.setWidget(row, col, new T3Cell(this, row, col));
		}
	}

	public T3Cell getCellAt(int row, int col){
		return (T3Cell) this.getWidget(row, col);
	}
	
	public boolean foundWinner(int row, int col) {
		if ((getCellAt(row, 0).hasSameValueAs(getCellAt(row, 1))) && (getCellAt(row, 1).hasSameValueAs(getCellAt(row, 2)))) {
			return true;
		}
		if ((getCellAt(0, col).hasSameValueAs(getCellAt(1, col))) && (getCellAt(1, col).hasSameValueAs(getCellAt(2, col)))) {
			return true;
		}
		if (row == col) {
			if (getCellAt(0, 0).hasSameValueAs(getCellAt(1, 1)) && getCellAt(1, 1).hasSameValueAs(getCellAt(2, 2))) {
				return true;
			}
		}
		if (row + col == 2) {
			if (getCellAt(0, 2).hasSameValueAs(getCellAt(1, 1)) && getCellAt(1, 1).hasSameValueAs(getCellAt(2, 0))) {
				return true;
			}
		}
		return false;
	}
	
	public GwtTicTacToe getController() {
		return controller;
	}

	public void setController(GwtTicTacToe controller) {
		this.controller = controller;
	}
	
}
