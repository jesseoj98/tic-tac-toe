package com.jesseoj98.tictactoe.util.looper.input;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.tictactoe.domain.GameBoard;

public class SimpleInputLooper {

	private static final Scanner scanner = new Scanner(System.in);

	public int loopSimpleInput(char[] gameBoard, boolean isPlayer) {

		int inputSimple;

		do {
			inputSimple = isPlayer ? scanner.nextInt()
					: ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_SPACES + 1);
		} while (inputSimple < 1 || inputSimple > 9 || gameBoard[inputSimple - 1] == 'X'
				|| gameBoard[inputSimple - 1] == 'O');

		return inputSimple;

	}

}
