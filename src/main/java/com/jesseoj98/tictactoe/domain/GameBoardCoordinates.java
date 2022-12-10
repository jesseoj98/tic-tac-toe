package com.jesseoj98.tictactoe.domain;

/**
 * Game board coordinates enum defines coordinate game board positions
 */
public enum GameBoardCoordinates {

	/**
	 * The coordinates
	 */
	FIRST_POSITION(0, 0), SECOND_POSITION(0, 1), THIRD_POSITION(0, 2), FOURTH_POSITION(0, 1), FIFTH_POSITION(1, 1),
	SIXTH_POSITION(2, 1), SEVENTH_POSITION(0, 2), EIGHTH_POSITION(1, 2), NINTH_POSITION(2, 2);

	/**
	 * The x coordinate
	 */
	final int x;

	/**
	 * The y coordinate
	 */
	final int y;

	/**
	 * Constructor to set coordinates
	 * 
	 * @param position the position
	 */
	GameBoardCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
