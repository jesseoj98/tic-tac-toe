package com.jesseoj98.tictactoe.util.looper.game;

import com.jesseoj98.tictactoe.util.generator.coordinate.CoordinateGenerator;
import com.jesseoj98.tictactoe.util.helper.inserter.BoardInserter;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.helper.validator.board.BoardValidator;
import com.jesseoj98.tictactoe.util.helper.validator.tictactoe.TicTacToeValidator;
import com.jesseoj98.tictactoe.util.looper.input.CoordinateInputLooper;
import com.jesseoj98.tictactoe.util.looper.input.SimpleInputLooper;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualCoordinateBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualSimpleBoardPrinter;

public class GameLooper {

	private static final ActualCoordinateBoardPrinter actualCoordinateBoardPrinter = new ActualCoordinateBoardPrinter();
	private static final ActualSimpleBoardPrinter actualSimpleBoardPrinter = new ActualSimpleBoardPrinter();

	private static final BoardInserter boardInserter = new BoardInserter();
	private static final BoardOccupier boardOccupier = new BoardOccupier();
	private static final BoardValidator boardValidator = new BoardValidator();

	private static final CoordinateGenerator coordinateGenerator = new CoordinateGenerator();

	private static final CoordinateInputLooper coordinateInputLooper = new CoordinateInputLooper();
	private static final SimpleInputLooper simpleInputLooper = new SimpleInputLooper();

	private static final TicTacToeValidator ticTacToeValidator = new TicTacToeValidator();

	public void loopSimpleGame(char[] gameBoard, char userPlayingCharacter, char cpuPlayingCharacter) {

		int inputSimple;

		do {

			System.out.println();
			System.out.print("Enter a spot to place your move: ");

			inputSimple = simpleInputLooper.loopSimpleInput(gameBoard, true);

			boardInserter.insertIntoBoard(gameBoard, inputSimple - 1, userPlayingCharacter);

			if (ticTacToeValidator.isTicTacToe(gameBoard, userPlayingCharacter)
					|| boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			inputSimple = simpleInputLooper.loopSimpleInput(gameBoard, false);

			boardInserter.insertIntoBoard(gameBoard, inputSimple - 1, cpuPlayingCharacter);

			System.out.println();
			actualSimpleBoardPrinter.printActualBoard(gameBoard);

		} while (!ticTacToeValidator.isTicTacToe(gameBoard, cpuPlayingCharacter)
				&& !boardValidator.areAllBoardSpacesFilled(gameBoard));

	}

	public void loopCoordinatesGame(char[][] gameBoard, char userPlayingCharacter, char cpuPlayingCharacter) {

		int inputXCoordinate;
		int inputYCoordinate;

		do {

			do {

				System.out.println();
				System.out.print("Enter an x coordinate to place your move: ");

				inputXCoordinate = coordinateInputLooper.loopPlayerCoordinateInput(gameBoard);

				System.out.print("Enter a y coordinate to place your move: ");

				inputYCoordinate = coordinateInputLooper.loopPlayerCoordinateInput(gameBoard);

			} while (boardOccupier.isSpaceOccupied(gameBoard, inputYCoordinate - 1, inputXCoordinate - 1));

			boardInserter.insertIntoBoard(gameBoard, inputYCoordinate - 1, inputXCoordinate - 1, userPlayingCharacter);

			if (ticTacToeValidator.isTicTacToe(gameBoard, userPlayingCharacter)
					|| boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				inputXCoordinate = coordinateGenerator.generateCoordinate();
				inputYCoordinate = coordinateGenerator.generateCoordinate();
			} while (boardOccupier.isSpaceOccupied(gameBoard, inputYCoordinate - 1, inputXCoordinate - 1));

			boardInserter.insertIntoBoard(gameBoard, inputYCoordinate - 1, inputXCoordinate - 1, cpuPlayingCharacter);

			System.out.println();
			actualCoordinateBoardPrinter.printActualBoard(gameBoard);

		} while (!ticTacToeValidator.isTicTacToe(gameBoard, cpuPlayingCharacter)
				&& !boardValidator.areAllBoardSpacesFilled(gameBoard));

	}

}
