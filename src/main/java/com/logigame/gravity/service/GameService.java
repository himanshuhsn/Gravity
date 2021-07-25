package com.logigame.gravity.service;

import java.util.UUID;

import com.logigame.gravity.exception.InvalidGameException;
import com.logigame.gravity.exception.InvalidParamException;
import com.logigame.gravity.exception.NotFoundException;
import com.logigame.gravity.model.Game;
import com.logigame.gravity.model.GameStatus;
import com.logigame.gravity.model.Gameplay;
import com.logigame.gravity.model.Player;
import com.logigame.gravity.model.TicToe;
import com.logigame.gravity.storage.GameStorage;

public class GameService {

	public Game createGame(Player player) {
		Game game = new Game();
		game.setBoard(new int [7][7]);
		game.setGameId(UUID.randomUUID().toString());
		game.setPlayer1(player);
		game.setStatus(GameStatus.NEW);
		GameStorage.getInstance().setGame(game);
		return game;
	}

	public Game connectToGame(Player player2, String gameId) throws InvalidParamException, InvalidGameException {
		if(!GameStorage.getInstance().getGames().containsKey(gameId)) {
			throw new InvalidParamException("Game with id does not exists!");
		}
		Game game = GameStorage.getInstance().getGames().get(gameId);
		
		if(game.getPlayer2() != null) {
			throw new InvalidGameException("Game is going on!");
		}
		
		game.setPlayer2(player2);
		game.setStatus(GameStatus.IN_PROGRESS);
		GameStorage.getInstance().setGame(game);
		return game;
	}

	public Game connectToRandomGame(Player player2) throws NotFoundException{
		Game game = GameStorage.getInstance().getGames().values().stream()
				.filter(it -> it.getStatus().equals(GameStatus.NEW))
				.findFirst().orElseThrow(() -> new NotFoundException("Game not Found!"));
		
		game.setPlayer2(player2);
		game.setStatus(GameStatus.IN_PROGRESS);
		GameStorage.getInstance().setGame(game);
		return game;
	}

	public Game gamePlay(Gameplay gamePlay) throws InvalidParamException, InvalidGameException {
		if(!GameStorage.getInstance().getGames().containsKey(gamePlay.getGameId())) {
			throw new InvalidParamException("Game with id does not exists!");
		}
		Game game = GameStorage.getInstance().getGames().get(gamePlay.getGameId());
		
		if(game.getStatus().equals(GameStatus.FINISHED)) {
			throw new InvalidGameException("Game is already finished!");
		}
		
		int[][] board = game.getBoard();
		board[gamePlay.getxCoordinate()][gamePlay.getyCoordinate()] = gamePlay.getType().getValue();
		
		if(gamePlay.getType() == TicToe.X) {
			if(checkWinner(game.getBoard(), gamePlay)) {
				game.setWinner(TicToe.X);
			}
		} else {
			if(checkWinner(game.getBoard(), gamePlay)) {
				game.setWinner(TicToe.O);
			}
		}
		
		GameStorage.getInstance().setGame(game);
		
		return game;
	}

	private boolean checkWinner(int[][] board, Gameplay gamePlay) {
		// O(N) implementation
		
		int xCoordinate = gamePlay.getxCoordinate();
		int yCoordinate = gamePlay.getyCoordinate();
		int cellValue = board[xCoordinate][yCoordinate];
		
		int countValidCell=1;
		
		// Assuming start index (0,0) at top left
		// right and left
		int x=xCoordinate;
		int y=yCoordinate;
		while(y+1 < 7 && board[xCoordinate][++y] == cellValue) { //right
			countValidCell++;
		}
		x=xCoordinate;
		y=yCoordinate;
		while(y-1 >= 0 && board[xCoordinate][--y] == cellValue) { //left
			countValidCell++;
		}
		
		// up and down
		x=xCoordinate;
		y=yCoordinate;
		while(x-1 >= 0 && board[--x][yCoordinate] == cellValue) { //up
			countValidCell++;
		}
		x=xCoordinate;
		y=yCoordinate;
		while(x+1 < 7 && board[++x][yCoordinate] == cellValue) { //down
			countValidCell++;
		}
		
		// top-left to bottom-right diagonal
		x = xCoordinate;
		y = yCoordinate;
		while(x-1 >= 0 && y-1>= 0 && board[--x][--y] == cellValue) { // top-left
			countValidCell++;
		}
		x=xCoordinate;
		y=yCoordinate;
		while(x+1 < 7 && y+1 < 7 && board[++x][++y] == cellValue) { // bottom-right
			countValidCell++;
		}
		
		// top-right to bottom-left diagonal
		x = xCoordinate;
		y = yCoordinate;
		while(x+1 < 7 && y-1 >= 0 && board[++x][--y] == cellValue) { // top-right
			countValidCell++;
		}
		x=xCoordinate;
		y=yCoordinate;
		while(x-1 >= 0 && y+1 < 7 && board[--x][++y] == cellValue) { // bottom-left
			countValidCell++;
		}
		
		if(countValidCell>=4) return true;
		
		return false;
	}
	
}
