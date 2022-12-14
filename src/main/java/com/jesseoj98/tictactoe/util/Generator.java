package com.jesseoj98.tictactoe.util;

import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.tictactoe.domain.Coordinate;
import com.jesseoj98.tictactoe.domain.GameBoard;

/**
 * Generator class defines methods helpful for quick generation
 */
public class Generator {

	/**
	 * Generates a simple game board
	 * 
	 * @return a simple game board
	 */
	public char[] generateSimpleGameBoard() {
		return new char[GameBoard.GAME_BOARD_SPACES];
	}

	/**
	 * Generates a coordinate game board
	 * 
	 * @return a coordinate game board
	 */
	public char[][] generateCoordinateGameBoard() {
		return new char[GameBoard.GAME_BOARD_DIMENSION][GameBoard.GAME_BOARD_DIMENSION];
	}

	/**
	 * Generates a random simple coordinate
	 * 
	 * @return a random simple coordinate
	 */
	public int generateRandomSimpleCoordinate() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_SPACES + 1);
	}

	/**
	 * Generates a random coordinate
	 * 
	 * @return a random coordinate
	 */
	public int generateRandomCoordinate() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_DIMENSION + 1);
	}

	/**
	 * Generates a random coordinate object
	 * 
	 * @return a random coordinate object
	 */
	public Coordinate generateRandomCoordinateObject() {
		final int xCoordinate = ThreadLocalRandom.current().nextInt(0, GameBoard.GAME_BOARD_DIMENSION);
		final int yCoordinate = ThreadLocalRandom.current().nextInt(0, GameBoard.GAME_BOARD_DIMENSION);
		return new Coordinate(xCoordinate, yCoordinate);
	}
}
