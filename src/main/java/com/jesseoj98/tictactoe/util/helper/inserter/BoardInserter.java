package com.jesseoj98.tictactoe.util.helper.inserter;

import com.jesseoj98.tictactoe.domain.Coordinate;

/**
 * Board inserter class provides implementations to insert into game boards
 */
public class BoardInserter implements GameBoardInserter {

	/**
	 * Inserts a playing character into the simple game board
	 * 
	 * @param gameBoard        The simple game board to insert into
	 * @param userInput        The user input to insert into
	 * @param playingCharacter The playing character to insert
	 */
	@Override
	public void insertIntoBoard(char[] gameBoard, int userInput, char playingCharacter) {
		gameBoard[userInput] = playingCharacter;
	}

	/**
	 * Inserts a playing character into the coordinate game board
	 * 
	 * @param gameBoard        The coordinate game board
	 * @param coordinate       The coordinate to insert into
	 * @param playingCharacter The playing character to insert
	 */
	@Override
	public void insertIntoBoard(char[][] gameBoard, Coordinate coordinate, char playingCharacter) {
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
	@Override
	public void insertIntoBoard(char[][] gameBoard, int xCoordinate, int yCoordinate, char playingCharacter) {
		gameBoard[xCoordinate][yCoordinate] = playingCharacter;
	}

}
