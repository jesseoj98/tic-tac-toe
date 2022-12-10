package com.jesseoj98.tictactoe.domain;

/**
 * Game board position enum defines simple game board positions
 */
public enum GameBoardPositions {

	/**
	 * The positions
	 */
	FIRST_POSITION(0), SECOND_POSITION(1), THIRD_POSITION(2), FOURTH_POSITION(3), FIFTH_POSITION(4), SIXTH_POSITION(5),
	SEVENTH_POSITION(6), EIGHTH_POSITION(7), NINTH_POSITION(8);

	/**
	 * The position
	 */
	final int position;

	/**
	 * Constructor to set positions
	 * 
	 * @param position the position
	 */
	GameBoardPositions(int position) {
		this.position = position;
	}

}
