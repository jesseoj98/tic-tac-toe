package com.jesseoj98.tictactoe;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.Helper;
import com.jesseoj98.tictactoe.util.Printer;
import com.jesseoj98.tictactoe.util.Validator;
import com.jesseoj98.tictactoe.util.generator.board.GenerateBoard;
import com.jesseoj98.tictactoe.util.generator.coordinate.GenerateCoordinate;

/**
 * Tic-tac-toe class represents the tic-tac-toe game
 */
public class Game {

	/** Instantiation of classes */
	private static final GenerateBoard gb = new GenerateBoard();
	private static final GenerateCoordinate gc = new GenerateCoordinate();

	private static final Helper helper = new Helper();
	private static final Printer printer = new Printer();
	private static final Scanner scanner = new Scanner(System.in);
	private static final Validator validator = new Validator();

	/**
	 * Plays the tic-tac-toe game
	 */
	public void playGame() {

		char userInput;
		char userPlayingCharacter;
		boolean letCpuGoFirst;

		System.out.println("Tic-tac-toe by Jesse Jones\n");

		System.out.print("Choose X or O: ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!validator.isInputPlayingCharacterValid(userInput));

		userPlayingCharacter = Character.toUpperCase(userInput);

		char cpuPlayingCharacter = userPlayingCharacter == 'X' ? 'O' : 'X';

		System.out.print("Let the CPU go first? (y/n): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!validator.isInputValid(userInput));

		letCpuGoFirst = validator.letCpuGoFirst(userInput);

		printer.printSimpleCoordinateSampleGameBoard();
		printer.printCoordinatesSampleGameBoard();

		System.out.print("\nChoose a game board type (s/c): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!validator.isInputGameBoardTypeValid(userInput));

		System.out.println("\n---------------");

		if (userInput == 's' || userInput == 'S') {

			playSimpleGame(userPlayingCharacter, cpuPlayingCharacter, letCpuGoFirst);

		} else {

			playCoordinatesGame(userPlayingCharacter, cpuPlayingCharacter, letCpuGoFirst);

		}

		System.out.print("\nPlay again? (y/n): ");

	}

	/**
	 * Plays a simple game of tic-tac-toe
	 * 
	 * @param userPlayingCharacter the user playing character
	 * @param cpuPlayingCharacter  the cpu playing character
	 * @param letCpuGoFirst        whether the cpu is to go first
	 */
	private void playSimpleGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		int userInputSimple;
		int cpuInputSimple;

		final char[] gameBoard = gb.generateSimple();

		if (letCpuGoFirst) {
			final int cpuFirstPlay = gc.generateCoordinate();
			helper.insertIntoGameBoard(gameBoard, cpuFirstPlay - 1, cpuPlayingCharacter);
		}

		System.out.println();
		printer.printSimpleCoordinateGameBoard(gameBoard);

		do {

			System.out.print("\nEnter a spot to place your move: ");

			do {
				userInputSimple = scanner.nextInt();
			} while (!validator.isInputValid(userInputSimple)
					&& helper.isSpaceAlreadyOccupied(gameBoard, userInputSimple - 1));

			helper.insertIntoGameBoard(gameBoard, userInputSimple - 1, userPlayingCharacter);

			if (validator.ticTacToe(gameBoard, userPlayingCharacter) || validator.allGameBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputSimple = gc.generateSimple();
			} while (helper.isSpaceAlreadyOccupied(gameBoard, cpuInputSimple - 1));

			helper.insertIntoGameBoard(gameBoard, cpuInputSimple - 1, cpuPlayingCharacter);

			System.out.println();
			printer.printSimpleCoordinateGameBoard(gameBoard);

		} while (!validator.ticTacToe(gameBoard, cpuPlayingCharacter)
				&& !validator.allGameBoardSpacesFilled(gameBoard));

		System.out.println();
		printer.printSimpleCoordinateGameBoard(gameBoard);

		final boolean playerWon = validator.ticTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = validator.ticTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		validator.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

	/**
	 * Plays a coordinate game of tic-tac-toe
	 * 
	 * @param userPlayingCharacter the user playing character
	 * @param cpuPlayingCharacter  the cpu playing character
	 * @param letCpuGoFirst        whether the cpu is to go first
	 */
	private void playCoordinatesGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		int userInputXCoordinate;
		int userInputYCoordinate;

		int cpuInputXCoordinate;
		int cpuInputYCoordinate;

		final char[][] gameBoard = gb.generateCoordinate();

		if (letCpuGoFirst) {
			final int cpuFirstPlayXCoordinate = gc.generateCoordinate();
			final int cpuFirstPlayYCoordinate = gc.generateCoordinate();
			helper.insertIntoGameBoard(gameBoard, cpuFirstPlayYCoordinate - 1, cpuFirstPlayXCoordinate - 1,
					cpuPlayingCharacter);
		}

		System.out.println();
		printer.printCoordinatesGameBoard(gameBoard);

		do {

			System.out.print("\nEnter an x coordinate to place your move: ");

			do {
				userInputXCoordinate = scanner.nextInt();
			} while (!validator.isInputCoordinatesValid(userInputXCoordinate));

			System.out.print("Enter a y coordinate to place your move: ");

			do {
				userInputYCoordinate = scanner.nextInt();
			} while (!validator.isInputCoordinatesValid(userInputYCoordinate)
					&& helper.isSpaceAlreadyOccupied(gameBoard, userInputYCoordinate - 1, userInputXCoordinate - 1));

			helper.insertIntoGameBoard(gameBoard, userInputYCoordinate - 1, userInputXCoordinate - 1,
					userPlayingCharacter);

			if (validator.ticTacToe(gameBoard, userPlayingCharacter) || validator.allGameBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputXCoordinate = gc.generateCoordinate();
				cpuInputYCoordinate = gc.generateCoordinate();
			} while (helper.isSpaceAlreadyOccupied(gameBoard, cpuInputYCoordinate - 1, cpuInputXCoordinate - 1));

			helper.insertIntoGameBoard(gameBoard, cpuInputYCoordinate - 1, cpuInputXCoordinate - 1,
					cpuPlayingCharacter);

			System.out.println();
			printer.printCoordinatesGameBoard(gameBoard);

		} while (!validator.ticTacToe(gameBoard, cpuPlayingCharacter)
				&& !validator.allGameBoardSpacesFilled(gameBoard));

		System.out.println();
		printer.printCoordinatesGameBoard(gameBoard);

		final boolean playerWon = validator.ticTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = validator.ticTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		validator.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

}
