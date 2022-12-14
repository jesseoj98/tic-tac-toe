package com.jesseoj98.tictactoe.util;

import com.jesseoj98.tictactoe.domain.Coordinate;

/**
 * Helper class defines several helpful functions
 */
public class Helper {

	/**
	 * Checks to see whether a space is already occupied
	 * 
	 * @param input The input to check
	 * 
	 * @return boolean for whether the space is occupied or not
	 */
	public boolean isSpaceAlreadyOccupied(char input) {
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
	public boolean isSpaceAlreadyOccupied(char[] gameBoard, int input) {
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
	public boolean isSpaceAlreadyOccupied(char[][] gameBoard, int xCoordinate, int yCoordinate) {
		return gameBoard[xCoordinate][yCoordinate] == 'X' || gameBoard[xCoordinate][yCoordinate] == 'O';
	}

	/**
	 * Inserts a playing character into the simple game board
	 * 
	 * @param gameBoard        The simple game board to insert into
	 * @param userInput        The user input to insert into
	 * @param playingCharacter The playing character to insert
	 */
	public void insertIntoGameBoard(char[] gameBoard, int userInput, char playingCharacter) {
		gameBoard[userInput] = playingCharacter;
	}

	/**
	 * Inserts a playing character into the coordinate game board
	 * 
	 * @param gameBoard        The coordinate game board
	 * @param coordinate       The coordinate to insert into
	 * @param playingCharacter The playing character to insert
	 */
	public void insertIntoGameBoard(char[][] gameBoard, Coordinate coordinate, char playingCharacter) {
		gameBoard[coordinate.getX()][coordinate.getY()] = playingCharacter;
	}

	/**
	 * Inserts a playing character into the coordinate game board
	 * 
	 * @param gameBoard        The coordinate game board
	 * @param xCoordinate      The x coordinate to insert into
	 * @param yCoordinate      The y coordinate to insert into
	 * @param playingCharacter The playing character to insert
	 */
	public void insertIntoGameBoard(char[][] gameBoard, int xCoordinate, int yCoordinate, char playingCharacter) {
		gameBoard[xCoordinate][yCoordinate] = playingCharacter;
	}

}
