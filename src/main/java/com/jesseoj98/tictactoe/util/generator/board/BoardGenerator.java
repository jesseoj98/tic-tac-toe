package com.jesseoj98.tictactoe.util.generator.board;

import com.jesseoj98.tictactoe.domain.GameBoard;

public class BoardGenerator {

	public char[] generateSimple() {
		return new char[GameBoard.GAME_BOARD_SPACES];
	}

	public char[][] generateCoordinate() {
		return new char[GameBoard.GAME_BOARD_DIMENSION][GameBoard.GAME_BOARD_DIMENSION];
	}

}
