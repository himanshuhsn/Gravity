package com.logigame.gravity.model;

public class Gameplay {
	private TicToe type;
	private Integer xCoordinate;
	private Integer yCoordinate;
	private String gameId;
	
	public Gameplay() {
		
	}
	public Gameplay(TicToe type, Integer xCoordinate, Integer yCoordinate, String gameId) {
		super();
		this.type = type;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.gameId = gameId;
	}
	public TicToe getType() {
		return type;
	}
	public void setType(TicToe type) {
		this.type = type;
	}
	public Integer getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public Integer getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
}
