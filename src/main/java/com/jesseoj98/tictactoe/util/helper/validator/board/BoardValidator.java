package com.jesseoj98.tictactoe.util.helper.validator.board;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;

/**
 * Board validator class provides implementations to validate game boards
 */
public class BoardValidator {

	/** Instantiation of classes */
	private static final BoardOccupier bo = new BoardOccupier();
	
	/**
	 * Checks whether all spaces are filled on a simple game board
	 * 
	 * @param simpleGameBoard the simple game board
	 * 
	 * @return whether all spaces are filled on a simple game board
	 */
	public boolean areAllBoardSpacesFilled(char[] simpleGameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			if (!bo.isSpaceOccupied(simpleGameBoard[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks whether all spaces are filled on a coordinate game board
	 * 
	 * @param coordinateGameBoard the coordinate game board
	 * 
	 * @return whether all spaces are filled on a coordinate game board
	 */
	public boolean areAllBoardSpacesFilled(char[][] coordinateGameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
			for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
				if (!bo.isSpaceOccupied(coordinateGameBoard, i, j)) {
					return false;
				}
			}
		}
		return true;
	}

}
