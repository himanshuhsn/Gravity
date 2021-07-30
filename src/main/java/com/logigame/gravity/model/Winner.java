package com.logigame.gravity.model;

import java.util.HashSet;
import java.util.Set;

public class Winner {
	private TicToe winner;
	private Set<Pair> winningCells;
	
	public Winner() {
		this.winningCells = new HashSet<Pair>();
	}
	public Winner(TicToe winner, Set<Pair> winningCells) {
		super();
		this.winner = winner;
		this.winningCells = winningCells;
	}
	public TicToe getWinner() {
		return winner;
	}
	public void setWinner(TicToe winner) {
		this.winner = winner;
	}
	public Set<Pair> getWinningCells() {
		return winningCells;
	}
	public void setWinningCells(Set<Pair> winningCells) {
		this.winningCells = winningCells;
	}
	
	public void addToWinningCells(Pair cell) {
		winningCells.add(cell);
	}
}
