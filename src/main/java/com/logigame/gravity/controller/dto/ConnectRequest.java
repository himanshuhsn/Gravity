package com.logigame.gravity.controller.dto;

import com.logigame.gravity.model.Player;

public class ConnectRequest {
	private Player player;
	private String gameId;
	
	public ConnectRequest() {
		
	}
	public ConnectRequest(Player player, String gameId) {
		super();
		this.player = player;
		this.gameId = gameId;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
}
