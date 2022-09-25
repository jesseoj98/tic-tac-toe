package com.jesseojones.tictactoe.util;

public class Helper {

	public boolean isSpaceAlreadyOccupied(char input) {
		return input == 'X' || input == 'O';
	}

	public boolean isSpaceAlreadyOccupied(char[] gameBoard, int input) {
		return gameBoard[input] == 'X' || gameBoard[input] == 'O';
	}

	public boolean isSpaceAlreadyOccupied(char[][] gameBoard, int xCoordinate, int yCoordinate) {
		return gameBoard[xCoordinate][yCoordinate] == 'X' || gameBoard[xCoordinate][yCoordinate] == 'O';
	}

	public void insertIntoGameBoard(char[] gameBoard, int userInput, char playingCharacter) {
		gameBoard[userInput] = playingCharacter;
	}

	public void insertIntoGameBoard(char[][] gameBoard, int xCoordinate, int yCoordinate, char playingCharacter) {
		gameBoard[xCoordinate][yCoordinate] = playingCharacter;
	}

}
