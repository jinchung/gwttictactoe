package com.jinfinite.games.gwttictactoe.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Announcement extends DialogBox {
	private VerticalPanel body;
	private Label message;
	private Button button;

	public Announcement(String msg) {
		this.body = new VerticalPanel();
		this.message = new Label(msg);
		this.button = new Button("OK");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Announcement.this.hide();
			}
		});
		this.setWidget(body);
		this.body.add(message);
		this.body.add(button);
	}

}
