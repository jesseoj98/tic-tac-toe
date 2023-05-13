package com.jesseoj98.tictactoe.util.generator.board;

/**
 * Generate game board interface supplies blueprints to generate game boards
 */
public interface GenerateGameBoard {

	public char[] generateSimple();

	public char[][] generateCoordinate();

}
