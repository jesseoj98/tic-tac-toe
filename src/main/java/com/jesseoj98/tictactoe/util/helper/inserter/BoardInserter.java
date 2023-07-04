package com.jesseoj98.tictactoe.util.helper.inserter;

public class BoardInserter {

	public void insertIntoBoard(char[] gameBoard, int userInput, char playingCharacter) {
		gameBoard[userInput] = playingCharacter;
	}

	public void insertIntoBoard(char[][] gameBoard, int xCoordinate, int yCoordinate, char playingCharacter) {
		gameBoard[xCoordinate][yCoordinate] = playingCharacter;
	}

}
