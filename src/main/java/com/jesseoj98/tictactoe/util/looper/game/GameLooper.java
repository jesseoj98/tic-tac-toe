package com.jesseoj98.tictactoe.util.looper.game;

import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.tictactoe.domain.GameBoard;
import com.jesseoj98.tictactoe.util.helper.validator.board.BoardValidator;
import com.jesseoj98.tictactoe.util.helper.validator.tictactoe.TicTacToeValidator;
import com.jesseoj98.tictactoe.util.looper.input.CoordinateInputLooper;
import com.jesseoj98.tictactoe.util.looper.input.SimpleInputLooper;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualCoordinateBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualSimpleBoardPrinter;

public class GameLooper {

	private static final ActualCoordinateBoardPrinter actualCoordinateBoardPrinter = new ActualCoordinateBoardPrinter();
	private static final ActualSimpleBoardPrinter actualSimpleBoardPrinter = new ActualSimpleBoardPrinter();
	private static final BoardValidator boardValidator = new BoardValidator();

	private static final CoordinateInputLooper coordinateInputLooper = new CoordinateInputLooper();
	private static final SimpleInputLooper simpleInputLooper = new SimpleInputLooper();

	private static final TicTacToeValidator ticTacToeValidator = new TicTacToeValidator();

	public void loopSimpleGame(char[] gameBoard, char userPlayingCharacter, char cpuPlayingCharacter) {

		int index;

		do {

			System.out.println();
			System.out.print("Enter a spot to place your move: ");

			index = simpleInputLooper.loopSimpleInput(gameBoard, true);

			gameBoard[index - 1] = userPlayingCharacter;

			if (ticTacToeValidator.isTicTacToe(gameBoard, userPlayingCharacter)
					|| boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			index = simpleInputLooper.loopSimpleInput(gameBoard, false);

			gameBoard[index - 1] = cpuPlayingCharacter;

			System.out.println();
			actualSimpleBoardPrinter.printActualBoard(gameBoard);

		} while (!ticTacToeValidator.isTicTacToe(gameBoard, cpuPlayingCharacter)
				&& !boardValidator.areAllBoardSpacesFilled(gameBoard));

	}

	public void loopCoordinatesGame(char[][] gameBoard, char userPlayingCharacter, char cpuPlayingCharacter) {

		int column;
		int row;

		do {

			do {

				System.out.println();
				System.out.print("Enter an x coordinate to place your move: ");

				column = coordinateInputLooper.loopPlayerCoordinateInput(gameBoard);

				System.out.print("Enter a y coordinate to place your move: ");

				row = coordinateInputLooper.loopPlayerCoordinateInput(gameBoard);

			} while (gameBoard[row - 1][column - 1] == 'X'
					|| gameBoard[row - 1][column - 1] == 'O');

			gameBoard[row - 1][column - 1] = userPlayingCharacter;

			if (ticTacToeValidator.isTicTacToe(gameBoard, userPlayingCharacter)
					|| boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				column = ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_DIMENSION + 1);
				row = ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_DIMENSION + 1);
			} while (gameBoard[row - 1][column - 1] == 'X'
					|| gameBoard[row - 1][column - 1] == 'O');

			gameBoard[row - 1][column - 1] = cpuPlayingCharacter;

			System.out.println();
			actualCoordinateBoardPrinter.printActualBoard(gameBoard);

		} while (!ticTacToeValidator.isTicTacToe(gameBoard, cpuPlayingCharacter)
				&& !boardValidator.areAllBoardSpacesFilled(gameBoard));

	}

}
