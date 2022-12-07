package com.jesseojones.tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

import com.jesseojones.tictactoe.domain.Coordinate;
import com.jesseojones.tictactoe.util.Generator;
import com.jesseojones.tictactoe.util.Helper;
import com.jesseojones.tictactoe.util.Printer;
import com.jesseojones.tictactoe.util.Validator;

/**
 * Main application class
 */
public class Application {

	/** Instantiation of classes */
	private static Generator generator = new Generator();
	private static Helper helper = new Helper();
	private static Printer printer = new Printer();
	private static Scanner scanner = new Scanner(System.in);
	private static Validator validator = new Validator();

	/** Declaration of variables */
	static ArrayList<Integer> playerPositions = new ArrayList<>();
	static ArrayList<Integer> cpuPositions = new ArrayList<>();

	static ArrayList<Coordinate> playerCoordinatePositions = new ArrayList<>();
	static ArrayList<Coordinate> cpuCoordinatePositions = new ArrayList<>();

	/**
	 * The main application method
	 * 
	 * @param args the String array args
	 */
	public static void main(String[] args) {

		char playAgain;

		do {

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

				int userInputSimple;
				int cpuInputSimple;

				final char[] gameBoard = generator.generateSimpleGameBoard();

				if (letCpuGoFirst) {
					final int cpuFirstPlay = generator.generateRandomSimpleCoordinate();
					helper.insertIntoGameBoard(gameBoard, cpuFirstPlay, cpuPlayingCharacter);
					cpuPositions.add(cpuFirstPlay);
					System.out.println();
				}

				printer.printSimpleCoordinateGameBoard(gameBoard);

				do {

					System.out.print("\nEnter a spot to place your move: ");

					do {
						userInputSimple = scanner.nextInt();
					} while (!validator.isInputValid(userInputSimple)
							&& helper.isSpaceAlreadyOccupied(gameBoard, userInputSimple - 1));

					helper.insertIntoGameBoard(gameBoard, userInputSimple - 1, userPlayingCharacter);
					playerPositions.add(userInputSimple - 1);

					do {
						cpuInputSimple = generator.generateRandomSimpleCoordinate();
					} while (helper.isSpaceAlreadyOccupied(gameBoard, cpuInputSimple - 1));

					helper.insertIntoGameBoard(gameBoard, cpuInputSimple - 1, cpuPlayingCharacter);
					cpuPositions.add(cpuInputSimple - 1);

					System.out.println();
					printer.printSimpleCoordinateGameBoard(gameBoard);

				} while (!validator.ticTacToeSimple(cpuPositions) || !validator.ticTacToeSimple(playerPositions)
						|| !validator.allGameBoardSpacesFilled(gameBoard));

			} else {

				int userInputXCoordinate;
				int userInputYCoordinate;

				int cpuInputXCoordinate;
				int cpuInputYCoordinate;

				final char[][] gameBoard = generator.generateCoordinateGameBoard();

				if (letCpuGoFirst) {
					final int cpuFirstPlayXCoordinate = generator.generateRandomCoordinate();
					final int cpuFirstPlayYCoordinate = generator.generateRandomCoordinate();
					helper.insertIntoGameBoard(gameBoard, cpuFirstPlayXCoordinate, cpuFirstPlayYCoordinate,
							cpuPlayingCharacter);
					cpuCoordinatePositions.add(new Coordinate(cpuFirstPlayXCoordinate, cpuFirstPlayYCoordinate));
					System.out.println();
				}

				do {

					System.out.print("\nEnter an x coordinate to place your move: ");

					do {
						userInputXCoordinate = scanner.nextInt();
					} while (!validator.isInputCoordinatesValid(userInputXCoordinate));

					System.out.print("Enter a y coordinate to place your move: ");

					do {
						userInputYCoordinate = scanner.nextInt();
					} while (!validator.isInputCoordinatesValid(userInputYCoordinate) && !helper
							.isSpaceAlreadyOccupied(gameBoard, userInputXCoordinate - 1, userInputYCoordinate - 1));

					helper.insertIntoGameBoard(gameBoard, userInputXCoordinate - 1, userInputYCoordinate - 1,
							cpuPlayingCharacter);
					playerCoordinatePositions.add(new Coordinate(userInputXCoordinate - 1, userInputYCoordinate - 1));

					do {
						cpuInputXCoordinate = generator.generateRandomCoordinate();
						cpuInputYCoordinate = generator.generateRandomCoordinate();
					} while (!helper.isSpaceAlreadyOccupied(gameBoard, cpuInputXCoordinate - 1,
							cpuInputYCoordinate - 1));

					helper.insertIntoGameBoard(gameBoard, cpuInputXCoordinate - 1, cpuInputYCoordinate - 1,
							cpuPlayingCharacter);
					cpuCoordinatePositions.add(new Coordinate(userInputXCoordinate - 1, userInputYCoordinate - 1));

					System.out.println();
					printer.printCoordinatesGameBoard(gameBoard);

				} while (!validator.ticTacToeCoordinate(cpuCoordinatePositions)
						|| !validator.ticTacToeCoordinate(playerCoordinatePositions)
						|| !validator.allGameBoardSpacesFilled(gameBoard));
			}

			System.out.print("Play again? (y/n): ");

			do {
				playAgain = scanner.next().charAt(0);
			} while (validator.isInputValid(playAgain));

		} while (validator.playAgain(playAgain));

		// collect game results
		// tic tac toe? user or cpu won?
		// no tic tac toe? -> game board is filled, no winner
	}

}
