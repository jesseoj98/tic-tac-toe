package com.jesseoj98.tictactoe.util.helper.validator.board;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;

public class BoardValidator {

	private static final BoardOccupier bo = new BoardOccupier();

	public boolean areAllBoardSpacesFilled(char[] simpleGameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			if (!bo.isSpaceOccupied(simpleGameBoard[i])) {
				return false;
			}
		}
		return true;
	}

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
