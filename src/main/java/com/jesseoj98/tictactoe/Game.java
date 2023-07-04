package com.jesseoj98.tictactoe;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.generator.board.BoardGenerator;
import com.jesseoj98.tictactoe.util.generator.coordinate.CoordinateGenerator;
import com.jesseoj98.tictactoe.util.helper.inserter.BoardInserter;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.helper.validator.board.BoardValidator;
import com.jesseoj98.tictactoe.util.helper.validator.input.InputValidator;
import com.jesseoj98.tictactoe.util.helper.validator.tictactoe.TicTacToeValidator;
import com.jesseoj98.tictactoe.util.printer.ResultPrinter;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualCoordinateBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualSimpleBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.sample.SampleCoordinateBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.sample.SampleSimpleBoardPrinter;

public class Game {

	private static final BoardGenerator boardGenerator = new BoardGenerator();
	private static final BoardInserter boardInserter = new BoardInserter();
	private static final BoardOccupier boardOccupier = new BoardOccupier();
	private static final BoardValidator boardValidator = new BoardValidator();

	private static final SampleCoordinateBoardPrinter cbp = new SampleCoordinateBoardPrinter();
	private static final SampleSimpleBoardPrinter sbp = new SampleSimpleBoardPrinter();

	private static final CoordinateGenerator coordinateGenerator = new CoordinateGenerator();

	private static final InputValidator inputValidator = new InputValidator();

	private static final ResultPrinter resultPrinter = new ResultPrinter();

	private static final TicTacToeValidator ticTacToeValidator = new TicTacToeValidator();

	private static final ActualCoordinateBoardPrinter actualCoordinateBoardPrinter = new ActualCoordinateBoardPrinter();
	private static final ActualSimpleBoardPrinter actualSimpleBoardPrinter = new ActualSimpleBoardPrinter();
	private static final Scanner scanner = new Scanner(System.in);

	public void playGame() {

		char userInput;
		char userPlayingCharacter;
		boolean letCpuGoFirst;

		System.out.println("Tic-tac-toe by Jesse Jones\n");

		System.out.print("Choose X or O: ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!inputValidator.isValidPlayingCharacter(userInput));

		userPlayingCharacter = Character.toUpperCase(userInput);

		char cpuPlayingCharacter = userPlayingCharacter == 'X' ? 'O' : 'X';

		System.out.print("Let the CPU go first? (y/n): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (inputValidator.isYesOrNo(userInput));

		letCpuGoFirst = inputValidator.isYes(userInput);

		sbp.printSampleBoardSequence();
		cbp.printSampleBoardSequence();

		System.out.print("\nChoose a game board type (s/c): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!inputValidator.isValidBoardType(userInput));

		System.out.println("\n---------------");

		if (userInput == 's' || userInput == 'S') {
			playSimpleGame(userPlayingCharacter, cpuPlayingCharacter, letCpuGoFirst);
		} else {
			playCoordinatesGame(userPlayingCharacter, cpuPlayingCharacter, letCpuGoFirst);
		}

		System.out.print("\nPlay again? (y/n): ");

	}

	private void playSimpleGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		int userInputSimple;
		int cpuInputSimple;

		final char[] gameBoard = boardGenerator.generateSimple();

		if (letCpuGoFirst) {
			final int cpuFirstPlay = coordinateGenerator.generateCoordinate();
			boardInserter.insertIntoBoard(gameBoard, cpuFirstPlay - 1, cpuPlayingCharacter);
		}

		System.out.println();
		actualSimpleBoardPrinter.printActualBoardSequence(gameBoard);

		do {

			System.out.print("\nEnter a spot to place your move: ");

			do {
				userInputSimple = scanner.nextInt();
			} while (!inputValidator.isValidBoardSpace(userInputSimple) || boardOccupier.isSpaceOccupied(gameBoard, userInputSimple - 1));

			boardInserter.insertIntoBoard(gameBoard, userInputSimple - 1, userPlayingCharacter);

			if (ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter) || boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputSimple = coordinateGenerator.generateSimple();
			} while (boardOccupier.isSpaceOccupied(gameBoard, cpuInputSimple - 1));

			boardInserter.insertIntoBoard(gameBoard, cpuInputSimple - 1, cpuPlayingCharacter);

			System.out.println();
			actualSimpleBoardPrinter.printActualBoardSequence(gameBoard);

		} while (!ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter) && !boardValidator.areAllBoardSpacesFilled(gameBoard));

		System.out.println();
		actualSimpleBoardPrinter.printActualBoardSequence(gameBoard);

		final boolean playerWon = ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		resultPrinter.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

	private void playCoordinatesGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		int userInputXCoordinate;
		int userInputYCoordinate;

		int cpuInputXCoordinate;
		int cpuInputYCoordinate;

		final char[][] gameBoard = boardGenerator.generateCoordinate();

		if (letCpuGoFirst) {
			final int cpuFirstPlayXCoordinate = coordinateGenerator.generateCoordinate();
			final int cpuFirstPlayYCoordinate = coordinateGenerator.generateCoordinate();
			boardInserter.insertIntoBoard(gameBoard, cpuFirstPlayYCoordinate - 1, cpuFirstPlayXCoordinate - 1,
					cpuPlayingCharacter);
		}

		System.out.println();
		actualCoordinateBoardPrinter.printActualBoardSequence(gameBoard);

		do {

			do {

				System.out.print("\nEnter an x coordinate to place your move: ");

				do {
					userInputXCoordinate = scanner.nextInt();
				} while (inputValidator.isValidCoordinatesSpace(userInputXCoordinate));

				System.out.print("Enter a y coordinate to place your move: ");

				do {
					userInputYCoordinate = scanner.nextInt();
				} while (inputValidator.isValidCoordinatesSpace(userInputYCoordinate));

			} while (boardOccupier.isSpaceOccupied(gameBoard, userInputYCoordinate - 1, userInputXCoordinate - 1));

			boardInserter.insertIntoBoard(gameBoard, userInputYCoordinate - 1, userInputXCoordinate - 1, userPlayingCharacter);

			if (ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter) || boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputXCoordinate = coordinateGenerator.generateCoordinate();
				cpuInputYCoordinate = coordinateGenerator.generateCoordinate();
			} while (boardOccupier.isSpaceOccupied(gameBoard, cpuInputYCoordinate - 1, cpuInputXCoordinate - 1));

			boardInserter.insertIntoBoard(gameBoard, cpuInputYCoordinate - 1, cpuInputXCoordinate - 1, cpuPlayingCharacter);

			System.out.println();
			actualCoordinateBoardPrinter.printActualBoardSequence(gameBoard);

		} while (!ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter) && !boardValidator.areAllBoardSpacesFilled(gameBoard));

		System.out.println();
		actualCoordinateBoardPrinter.printActualBoardSequence(gameBoard);

		final boolean playerWon = ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		resultPrinter.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

}
