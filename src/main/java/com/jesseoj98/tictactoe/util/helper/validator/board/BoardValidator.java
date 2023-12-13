package com.jesseoj98.tictactoe.util.helper.validator.board;

import com.jesseoj98.tictactoe.domain.GameBoard;

public class BoardValidator {

	public boolean areAllBoardSpacesFilled(char[] simpleGameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			if (!(simpleGameBoard[i] == 'X' || simpleGameBoard[i] == 'O')) {
				return false;
			}
		}
		return true;
	}

	public boolean areAllBoardSpacesFilled(char[][] coordinateGameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_DIMENSION; i++) {
			for (int j = 0; j < GameBoard.GAME_BOARD_DIMENSION; j++) {
				if (!(coordinateGameBoard[i][j] == 'X' || coordinateGameBoard[i][j] == 'O')) {
					return false;
				}
			}
		}
		return true;
	}

}
