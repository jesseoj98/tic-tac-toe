package com.jesseoj98.tictactoe.util.helper.occupier;

public class BoardOccupier {

	public boolean isSpaceOccupied(char input) {
		return input == 'X' || input == 'O';
	}

	public boolean isSpaceOccupied(char[] gameBoard, int input) {
		return gameBoard[input] == 'X' || gameBoard[input] == 'O';
	}

	public boolean isSpaceOccupied(char[][] gameBoard, int xCoordinate, int yCoordinate) {
		return gameBoard[xCoordinate][yCoordinate] == 'X' || gameBoard[xCoordinate][yCoordinate] == 'O';
	}

}
