package com.jinfinite.games.gwttictactoe.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PlayerSetupForm extends FormPanel {

	private VerticalPanel panel;
	private TextBox player1Name;
	private TextBox player2Name;
	private Button submit;
	private String player1;
	private String player2;
	private GwtTicTacToe owner;

	public PlayerSetupForm(GwtTicTacToe owner) {
		this.owner = owner;
		initializeElements();
	}
	
	private void initializeElements(){
		panel = new VerticalPanel();
		player1Name = new TextBox();
		player2Name = new TextBox();
		submit = new Button("Play!", new ClickHandler() {
			public void onClick(ClickEvent event) {
				PlayerSetupForm.this.owner.setPlayersCallback(player1Name.getText(), player2Name.getText());
			}
		});
		this.add(panel);
		panel.add(new Label("Player 1 will be (X). What is Player 1's name?"));
		panel.add(player1Name);
		panel.add(new Label("Player 2 will be (O). What is Player 2's name?"));
		panel.add(player2Name);
		panel.add(submit);
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
}
