package com.logigame.gravity.model;

public class Game implements Cloneable{
	private Player player1;
	private Player player2;
	private String gameId;
	private int[][] board;
	private GameStatus status;
	private Winner winner;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	
	public Game() {
		
	}
	public Game(Player player1, Player player2, String gameId, int[][] board, GameStatus status, Winner winner) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.gameId = gameId;
		this.board = board;
		this.status = status;
		this.winner = winner;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public GameStatus getStatus() {
		return status;
	}
	public void setStatus(GameStatus status) {
		this.status = status;
	}
	public Winner getWinner() {
		return winner;
	}
	public void setWinner(Winner winner) {
		this.winner = winner;
	}
}
