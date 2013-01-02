package com.jinfinite.games.gwttictactoe.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtTicTacToe implements EntryPoint {
	
	private Player[] players;
	private int currentPlayer;
	private int availableSlots;
	private String playerSelectStyle = "highlightgreen";
	
	private VerticalPanel main;
	private HorizontalPanel body;
	private Board board;
	private VerticalPanel playerSection;
	private Label playerSectionTitle;
	private Label player1;
	private Label player2;
	private Label winner;
	private PlayerSetupForm form;
	VerticalPanel panel;
	
	public void onModuleLoad() {
		initializeFormattingElements();
		initializeHeader();
		askForPlayers();
	}
	
	private void initializeFormattingElements(){
		main = new VerticalPanel();
		main.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		body = new HorizontalPanel();
		board = new Board(this, 3);
		playerSection = new VerticalPanel();
		playerSectionTitle = new Label("Players");
		player1 = new Label();
		player2 = new Label();
		panel = new VerticalPanel();
		winner = new Label("Winner: ");
		availableSlots = 9;
		currentPlayer = 0;
	}
	
	private void initializeHeader() {
		Label title = new Label("Tic Tac Toe with GWT");
		Label verse1 = new Label("Hello hello! This is Tic Tac Toe.");
		Label verse2 = new Label("Get three in a row to beat your foe.");
		title.addStyleName("h1");
		title.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verse1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verse2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		RootPanel.get("header").add(title);
		RootPanel.get("header").add(verse1);		
		RootPanel.get("header").add(verse2);		
	}

	private void askForPlayers(){
		main.addStyleName("center");
		form = new PlayerSetupForm(this);
		main.add(form);
		RootPanel.get("gameArea").add(main);
	}
	
	public void setPlayersCallback(String name1, String name2){
		players = new Player[2];
		players[0] = new Player(name1, 'X');
		players[1] = new Player(name2, 'O');
		player1.setText("(X): " + name1);
		player2.setText("(O): " + name2);
		drawMainGame();
	}
	
	private void drawMainGame(){
		RootPanel.get("gameArea").clear();
		main.clear();
		RootPanel.get("gameArea").add(main);
		main.add(body);
		body.add(board);
		body.add(playerSection);
		playerSection.add(playerSectionTitle);
		playerSection.add(player1);
		playerSection.add(player2);
		playerSection.add(winner);
		player1.addStyleName(playerSelectStyle);
	}
	
	public void placeMarkerCallback(T3Cell button){
		button.setValue(Character.toString(players[currentPlayer].getCharacter()));
		if (board.foundWinner(button.getRow(), button.getCol())){
			Announcement announce = new Announcement(players[currentPlayer].getName() + " has won!");
			announce.center();
			winner.setText("Winner: " + players[currentPlayer].getName() + "!");
		} else if (availableSlots - 1 == 0) {
			Announcement announce = new Announcement("The game is tied!");
			announce.center();
			winner.setText("Tied Game!");
		} else {
			availableSlots--;
		}
		switchPlayers();			
	}
	
	private void switchPlayers(){
		if (currentPlayer== 0){
			currentPlayer++;
			player1.removeStyleName(playerSelectStyle);
			player2.addStyleName(playerSelectStyle);
		} else {
			currentPlayer--;
			player2.removeStyleName(playerSelectStyle);
			player1.addStyleName(playerSelectStyle);
		}
	}
	
}
