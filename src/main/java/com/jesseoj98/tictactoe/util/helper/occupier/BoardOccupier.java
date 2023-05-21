package com.jesseoj98.tictactoe.util.helper.occupier;

/**
 * Board occupier class provides implementations to check game boards for space
 * occupancy
 */
public class BoardOccupier {

	/**
	 * Checks to see whether a space is already occupied
	 * 
	 * @param input The input to check
	 * 
	 * @return boolean for whether the space is occupied or not
	 */
	public boolean isSpaceOccupied(char input) {
		return input == 'X' || input == 'O';
	}

	/**
	 * Checks to see whether a space is already occupied on the simple game board
	 * 
	 * @param gameBoard The simple game board to check
	 * @param input     The input to check
	 * 
	 * @return boolean for whether the space is occupied or not on the simple game
	 *         board
	 */
	public boolean isSpaceOccupied(char[] gameBoard, int input) {
		return gameBoard[input] == 'X' || gameBoard[input] == 'O';
	}

	/**
	 * Checks to see whether a space is already occupied on the coordinate game
	 * board
	 * 
	 * @param gameBoard   The coordinate game board to check
	 * @param xCoordinate The x coordinate to check
	 * @param yCoordinate The y coordinate to check
	 * 
	 * @return boolean for whether the space is occupied or not on the coordinate
	 *         game board
	 */
	public boolean isSpaceOccupied(char[][] gameBoard, int xCoordinate, int yCoordinate) {
		return gameBoard[xCoordinate][yCoordinate] == 'X' || gameBoard[xCoordinate][yCoordinate] == 'O';
	}

}
