package com.jesseojones.tictactoe.util;

public class Helper {

	public boolean isSpaceEmpty(char[] gameBoard, int userInput) {
		return gameBoard[userInput] == ' ';
	}

	public boolean isSpaceAlreadyOccupied(char[] gameBoard, int userInput) {
		return gameBoard[userInput] == 'X' || gameBoard[userInput] == 'O';
	}

	public boolean isSpaceEmpty(char[][] gameBoard, int xCoordinate, int yCoordinate) {
		return gameBoard[xCoordinate][yCoordinate] == ' ';
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
