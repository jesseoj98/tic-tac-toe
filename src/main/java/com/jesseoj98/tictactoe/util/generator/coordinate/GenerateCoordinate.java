package com.jesseoj98.tictactoe.util.generator.coordinate;

import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.tictactoe.domain.GameBoard;

/**
 * Generate coordinate class provides implementations to generate game
 * coordinates
 */
public class GenerateCoordinate {

	/**
	 * Generates a random simple coordinate
	 * 
	 * @return a random simple coordinate
	 */
	public int generateSimple() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_SPACES + 1);
	}

	/**
	 * Generates a random coordinate
	 * 
	 * @return a random coordinate
	 */
	public int generateCoordinate() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_DIMENSION + 1);
	}

}
