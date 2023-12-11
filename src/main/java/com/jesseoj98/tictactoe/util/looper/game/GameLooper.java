package com.jesseoj98.tictactoe.util.looper.game;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.generator.coordinate.CoordinateGenerator;
import com.jesseoj98.tictactoe.util.helper.inserter.BoardInserter;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.helper.validator.board.BoardValidator;
import com.jesseoj98.tictactoe.util.helper.validator.input.InputValidator;
import com.jesseoj98.tictactoe.util.helper.validator.tictactoe.TicTacToeValidator;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualCoordinateBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualSimpleBoardPrinter;

public class GameLooper {

	private static final ActualCoordinateBoardPrinter actualCoordinateBoardPrinter = new ActualCoordinateBoardPrinter();
	private static final ActualSimpleBoardPrinter actualSimpleBoardPrinter = new ActualSimpleBoardPrinter();

	private static final BoardInserter boardInserter = new BoardInserter();
	private static final BoardOccupier boardOccupier = new BoardOccupier();
	private static final BoardValidator boardValidator = new BoardValidator();

	private static final CoordinateGenerator coordinateGenerator = new CoordinateGenerator();

	private static final InputValidator inputValidator = new InputValidator();

	private static final Scanner scanner = new Scanner(System.in);

	private static final TicTacToeValidator ticTacToeValidator = new TicTacToeValidator();

	public void loopSimpleGame(char[] gameBoard, char userPlayingCharacter, char cpuPlayingCharacter) {

		int inputSimple;

		do {

			System.out.print("\nEnter a spot to place your move: ");

			do {
				inputSimple = scanner.nextInt();
			} while (!inputValidator.isValidBoardSpace(inputSimple)
					|| boardOccupier.isSpaceOccupied(gameBoard, inputSimple - 1));

			boardInserter.insertIntoBoard(gameBoard, inputSimple - 1, userPlayingCharacter);

			if (ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter)
					|| boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				inputSimple = coordinateGenerator.generateSimple();
			} while (boardOccupier.isSpaceOccupied(gameBoard, inputSimple - 1));

			boardInserter.insertIntoBoard(gameBoard, inputSimple - 1, cpuPlayingCharacter);

			System.out.println();
			actualSimpleBoardPrinter.printActualBoardSequence(gameBoard);

		} while (!ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter)
				&& !boardValidator.areAllBoardSpacesFilled(gameBoard));

	}

	public void loopCoordinatesGame(char[][] gameBoard, char userPlayingCharacter, char cpuPlayingCharacter) {

		int userInputXCoordinate;
		int userInputYCoordinate;

		int cpuInputXCoordinate;
		int cpuInputYCoordinate;

		do {

			do {

				System.out.print("\nEnter an x coordinate to place your move: ");

				do {
					userInputXCoordinate = scanner.nextInt();
				} while (!inputValidator.isValidCoordinatesSpace(userInputXCoordinate));

				System.out.print("Enter a y coordinate to place your move: ");

				do {
					userInputYCoordinate = scanner.nextInt();
				} while (!inputValidator.isValidCoordinatesSpace(userInputYCoordinate));

			} while (boardOccupier.isSpaceOccupied(gameBoard, userInputYCoordinate - 1, userInputXCoordinate - 1));

			boardInserter.insertIntoBoard(gameBoard, userInputYCoordinate - 1, userInputXCoordinate - 1,
					userPlayingCharacter);

			if (ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter)
					|| boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputXCoordinate = coordinateGenerator.generateCoordinate();
				cpuInputYCoordinate = coordinateGenerator.generateCoordinate();
			} while (boardOccupier.isSpaceOccupied(gameBoard, cpuInputYCoordinate - 1, cpuInputXCoordinate - 1));

			boardInserter.insertIntoBoard(gameBoard, cpuInputYCoordinate - 1, cpuInputXCoordinate - 1,
					cpuPlayingCharacter);

			System.out.println();
			actualCoordinateBoardPrinter.printActualBoardSequence(gameBoard);

		} while (!ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter)
				&& !boardValidator.areAllBoardSpacesFilled(gameBoard));

	}

}
