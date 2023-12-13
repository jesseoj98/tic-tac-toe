package com.jesseoj98.tictactoe;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.generator.board.BoardGenerator;
import com.jesseoj98.tictactoe.util.generator.coordinate.CoordinateGenerator;
import com.jesseoj98.tictactoe.util.helper.inserter.BoardInserter;
import com.jesseoj98.tictactoe.util.helper.validator.input.InputValidator;
import com.jesseoj98.tictactoe.util.helper.validator.tictactoe.TicTacToeValidator;
import com.jesseoj98.tictactoe.util.looper.game.GameLooper;
import com.jesseoj98.tictactoe.util.helper.handler.ResultHandler;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualCoordinateBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualSimpleBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.sample.SampleCoordinateBoardPrinter;
import com.jesseoj98.tictactoe.util.printer.board.sample.SampleSimpleBoardPrinter;

public class Game {

	private static final ActualCoordinateBoardPrinter actualCoordinateBoardPrinter = new ActualCoordinateBoardPrinter();
	private static final ActualSimpleBoardPrinter actualSimpleBoardPrinter = new ActualSimpleBoardPrinter();

	private static final BoardGenerator boardGenerator = new BoardGenerator();
	private static final BoardInserter boardInserter = new BoardInserter();

	private static final CoordinateGenerator coordinateGenerator = new CoordinateGenerator();

	private static final GameLooper gameLooper = new GameLooper();

	private static final InputValidator inputValidator = new InputValidator();

	private static final ResultHandler resultHandler = new ResultHandler();

	private static final SampleCoordinateBoardPrinter sampleCoordinateBoardPrinter = new SampleCoordinateBoardPrinter();
	private static final SampleSimpleBoardPrinter sampleSimpleBoardPrinter = new SampleSimpleBoardPrinter();

	private static final Scanner scanner = new Scanner(System.in);

	private static final TicTacToeValidator ticTacToeValidator = new TicTacToeValidator();

	public void playGame() {

		char userInput;
		char userPlayingCharacter;
		boolean letCpuGoFirst;

		System.out.print("Tic-tac-toe by Jesse Jones");

		System.out.println();
		System.out.println();

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

		sampleSimpleBoardPrinter.printSampleBoardSequence();
		sampleCoordinateBoardPrinter.printSampleBoardSequence();

		System.out.println();
		System.out.print("Choose a game board type (s/c): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!inputValidator.isValidBoardType(userInput));

		System.out.println();
		System.out.print("---------------");

		if (userInput == 's' || userInput == 'S') {
			playSimpleGame(userPlayingCharacter, cpuPlayingCharacter, letCpuGoFirst);
		} else {
			playCoordinatesGame(userPlayingCharacter, cpuPlayingCharacter, letCpuGoFirst);
		}

		System.out.println();
		System.out.print("Play again? (y/n): ");

	}

	private void playSimpleGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		final char[] gameBoard = boardGenerator.generateSimple();

		if (letCpuGoFirst) {
			final int cpuFirstPlay = coordinateGenerator.generateCoordinate();
			boardInserter.insertIntoBoard(gameBoard, cpuFirstPlay - 1, cpuPlayingCharacter);
		}

		System.out.println();
		actualSimpleBoardPrinter.printActualBoardSequence(gameBoard);

		gameLooper.loopSimpleGame(gameBoard, userPlayingCharacter, cpuPlayingCharacter);

		System.out.println();
		actualSimpleBoardPrinter.printActualBoardSequence(gameBoard);

		final boolean playerWon = ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		resultHandler.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

	private void playCoordinatesGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		final char[][] gameBoard = boardGenerator.generateCoordinate();

		if (letCpuGoFirst) {
			final int cpuFirstPlayXCoordinate = coordinateGenerator.generateCoordinate();
			final int cpuFirstPlayYCoordinate = coordinateGenerator.generateCoordinate();
			boardInserter.insertIntoBoard(gameBoard, cpuFirstPlayYCoordinate - 1, cpuFirstPlayXCoordinate - 1,
					cpuPlayingCharacter);
		}

		System.out.println();
		actualCoordinateBoardPrinter.printActualBoard(gameBoard);

		gameLooper.loopCoordinatesGame(gameBoard, userPlayingCharacter, cpuPlayingCharacter);

		System.out.println();
		actualCoordinateBoardPrinter.printActualBoard(gameBoard);

		final boolean playerWon = ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		resultHandler.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

}
