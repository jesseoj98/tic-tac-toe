package com.jesseoj98.tictactoe.util.helper.validator.printer;

import com.jesseoj98.tictactoe.domain.GameBoard;

public class PrinterValidator {

	public boolean endOfSimpleRowMatch(int index) {
		return index == 2 || index == 5 || index == 8;
	}

	public boolean endOfRowMatch(int index) {
		return index != GameBoard.GAME_BOARD_DIMENSION - 1;
	}

}
