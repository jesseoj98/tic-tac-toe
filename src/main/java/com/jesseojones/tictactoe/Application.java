package com.jesseojones.tictactoe;

import java.util.Scanner;

import com.jesseojones.tictactoe.util.Generator;
import com.jesseojones.tictactoe.util.Helper;
import com.jesseojones.tictactoe.util.Printer;
import com.jesseojones.tictactoe.util.Validator;

public class Application {

	private static Generator generator = new Generator();
	private static Helper helper = new Helper();
	private static Printer printer = new Printer();
	private static Scanner scanner = new Scanner(System.in);
	private static Validator validator = new Validator();

	public static void main(String[] args) {

		char userInput;
		char userPlayingCharacter;
		boolean letCpuGoFirst;

		System.out.println("Tic-tac-toe by Jesse Jones\n");

		System.out.print("Choose X or O: ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!validator.isUserInputPlayingCharacterValid(userInput));

		// userPlayingCharacter = Character.toUpperCase(userInput);
		userPlayingCharacter = userInput == 'x' || userInput == 'X' ? 'X' : 'O';

		char cpuPlayingCharacter = userPlayingCharacter == 'X' ? 'O' : 'X';

		System.out.print("Let the CPU go first? (y/n): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!validator.isUserInputLetCpuGoFirstValid(userInput));

		letCpuGoFirst = userInput == 'y' || userInput == 'Y';

		printer.printSimpleCoordinateSampleGameBoard();

		System.out.print("Choose a game board type (s/c): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!validator.isUserInputGameBoardTypeValid(userInput));

		if (userInput == 's' || userInput == 'S') {

			int userInputSimple;
			int cpuInputSimple;

			char[] gameBoard = generator.generateSimpleGameBoard();

			if (letCpuGoFirst) {
				helper.insertIntoGameBoard(gameBoard, generator.generateRandomSimpleCoordinate(), cpuPlayingCharacter);
			}

			do {

				System.out.println("Enter a spot to place your move: ");

				do {
					userInputSimple = scanner.nextInt();
				} while (!validator.isUserInputValid(userInputSimple)
						&& helper.isSpaceEmpty(gameBoard, userInputSimple - 1)
						&& !helper.isSpaceAlreadyOccupied(gameBoard, userInputSimple - 1));

				helper.insertIntoGameBoard(gameBoard, userInputSimple - 1, userPlayingCharacter);

				do {
					cpuInputSimple = generator.generateRandomSimpleCoordinate();
				} while (helper.isSpaceEmpty(gameBoard, cpuInputSimple - 1)
						&& !helper.isSpaceAlreadyOccupied(gameBoard, cpuInputSimple - 1));

				helper.insertIntoGameBoard(gameBoard, cpuInputSimple - 1, cpuPlayingCharacter);

			} while (!validator.ticTacToe(gameBoard) || !validator.allGameBoardSpacesFilled(gameBoard));

		} else {

			int userInputXCoordinate;
			int userInputYCoordinate;

			int cpuInputXCoordinate;
			int cpuInputYCoordinate;

			char[][] gameBoard = generator.generateCoordinateGameBoard();

			do {

				System.out.println("Enter an x coordinate to place your move: ");

				do {
					userInputXCoordinate = scanner.nextInt();
				} while (!validator.isUserInputCoordinatesValid(userInputXCoordinate));

				System.out.println("Enter a y coordinate to place your move: ");

				do {
					userInputYCoordinate = scanner.nextInt();
				} while (!validator.isUserInputCoordinatesValid(userInputYCoordinate)
						&& helper.isSpaceEmpty(gameBoard, userInputXCoordinate - 1, userInputYCoordinate - 1) && !helper
								.isSpaceAlreadyOccupied(gameBoard, userInputXCoordinate - 1, userInputYCoordinate - 1));

				do {
					cpuInputXCoordinate = generator.generateRandomCoordinate();
					cpuInputYCoordinate = generator.generateRandomCoordinate();
					helper.insertIntoGameBoard(gameBoard, generator.generateRandomCoordinate(),
							generator.generateRandomCoordinate(), cpuPlayingCharacter);
				} while (helper.isSpaceEmpty(gameBoard, cpuInputXCoordinate - 1, cpuInputYCoordinate - 1)
						&& !helper.isSpaceAlreadyOccupied(gameBoard, cpuInputXCoordinate - 1, cpuInputYCoordinate - 1));

			} while (!validator.ticTacToe(gameBoard) || !validator.allGameBoardSpacesFilled(gameBoard));
		}

		// collect game results
		// tic tac toe? user or cpu won?
		// no tic tac toe? -> game board is filled, no winner
	}

}
