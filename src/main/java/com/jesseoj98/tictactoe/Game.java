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

	private static final BoardGenerator bg = new BoardGenerator();
	private static final BoardInserter bi = new BoardInserter();
	private static final BoardOccupier bo = new BoardOccupier();
	private static final BoardValidator bv = new BoardValidator();

	private static final SampleCoordinateBoardPrinter cbp = new SampleCoordinateBoardPrinter();
	private static final SampleSimpleBoardPrinter sbp = new SampleSimpleBoardPrinter();

	private static final CoordinateGenerator cg = new CoordinateGenerator();

	private static final InputValidator iv = new InputValidator();

	private static final ResultPrinter rp = new ResultPrinter();

	private static final TicTacToeValidator tttv = new TicTacToeValidator();

	private static final ActualCoordinateBoardPrinter acbp = new ActualCoordinateBoardPrinter();
	private static final ActualSimpleBoardPrinter asbp = new ActualSimpleBoardPrinter();
	private static final Scanner scanner = new Scanner(System.in);

	public void playGame() {

		char userInput;
		char userPlayingCharacter;
		boolean letCpuGoFirst;

		System.out.println("Tic-tac-toe by Jesse Jones\n");

		System.out.print("Choose X or O: ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!iv.isValidPlayingCharacter(userInput));

		userPlayingCharacter = Character.toUpperCase(userInput);

		char cpuPlayingCharacter = userPlayingCharacter == 'X' ? 'O' : 'X';

		System.out.print("Let the CPU go first? (y/n): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (iv.isYesOrNo(userInput));

		letCpuGoFirst = iv.isYes(userInput);

		sbp.printSampleBoardSequence();
		cbp.printSampleBoardSequence();

		System.out.print("\nChoose a game board type (s/c): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!iv.isValidBoardType(userInput));

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

		final char[] gameBoard = bg.generateSimple();

		if (letCpuGoFirst) {
			final int cpuFirstPlay = cg.generateCoordinate();
			bi.insertIntoBoard(gameBoard, cpuFirstPlay - 1, cpuPlayingCharacter);
		}

		System.out.println();
		asbp.printActualBoardSequence(gameBoard);

		do {

			System.out.print("\nEnter a spot to place your move: ");

			do {
				userInputSimple = scanner.nextInt();
			} while (!iv.isValidBoardSpace(userInputSimple) || bo.isSpaceOccupied(gameBoard, userInputSimple - 1));

			bi.insertIntoBoard(gameBoard, userInputSimple - 1, userPlayingCharacter);

			if (tttv.ticTacToe(gameBoard, userPlayingCharacter) || bv.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputSimple = cg.generateSimple();
			} while (bo.isSpaceOccupied(gameBoard, cpuInputSimple - 1));

			bi.insertIntoBoard(gameBoard, cpuInputSimple - 1, cpuPlayingCharacter);

			System.out.println();
			asbp.printActualBoardSequence(gameBoard);

		} while (!tttv.ticTacToe(gameBoard, cpuPlayingCharacter) && !bv.areAllBoardSpacesFilled(gameBoard));

		System.out.println();
		asbp.printActualBoardSequence(gameBoard);

		final boolean playerWon = tttv.ticTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = tttv.ticTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		rp.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

	private void playCoordinatesGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		int userInputXCoordinate;
		int userInputYCoordinate;

		int cpuInputXCoordinate;
		int cpuInputYCoordinate;

		final char[][] gameBoard = bg.generateCoordinate();

		if (letCpuGoFirst) {
			final int cpuFirstPlayXCoordinate = cg.generateCoordinate();
			final int cpuFirstPlayYCoordinate = cg.generateCoordinate();
			bi.insertIntoBoard(gameBoard, cpuFirstPlayYCoordinate - 1, cpuFirstPlayXCoordinate - 1,
					cpuPlayingCharacter);
		}

		System.out.println();
		acbp.printActualBoardSequence(gameBoard);

		do {

			System.out.print("\nEnter an x coordinate to place your move: ");

			do {
				do {
					userInputXCoordinate = scanner.nextInt();
				} while (iv.isValidCoordinatesSpace(userInputXCoordinate));

				System.out.print("Enter a y coordinate to place your move: ");

				do {
					userInputYCoordinate = scanner.nextInt();
				} while (iv.isValidCoordinatesSpace(userInputYCoordinate));
			} while (bo.isSpaceOccupied(gameBoard, userInputYCoordinate - 1, userInputXCoordinate - 1));

			bi.insertIntoBoard(gameBoard, userInputYCoordinate - 1, userInputXCoordinate - 1, userPlayingCharacter);

			if (tttv.ticTacToe(gameBoard, userPlayingCharacter) || bv.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputXCoordinate = cg.generateCoordinate();
				cpuInputYCoordinate = cg.generateCoordinate();
			} while (bo.isSpaceOccupied(gameBoard, cpuInputYCoordinate - 1, cpuInputXCoordinate - 1));

			bi.insertIntoBoard(gameBoard, cpuInputYCoordinate - 1, cpuInputXCoordinate - 1, cpuPlayingCharacter);

			System.out.println();
			acbp.printActualBoardSequence(gameBoard);

		} while (!tttv.ticTacToe(gameBoard, cpuPlayingCharacter) && !bv.areAllBoardSpacesFilled(gameBoard));

		System.out.println();
		acbp.printActualBoardSequence(gameBoard);

		final boolean playerWon = tttv.ticTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = tttv.ticTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		rp.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

}
