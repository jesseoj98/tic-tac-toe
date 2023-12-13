package com.jesseoj98.tictactoe;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.tictactoe.domain.GameBoard;
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

	private static final GameLooper gameLooper = new GameLooper();

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
		} while (!(userInput == 'x' || userInput == 'X' || userInput == 'o' || userInput == 'O'));

		userPlayingCharacter = Character.toUpperCase(userInput);

		char cpuPlayingCharacter = userPlayingCharacter == 'X' ? 'O' : 'X';

		System.out.print("Let the CPU go first? (y/n): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (userInput != 'y' && userInput != 'Y' && userInput != 'n' && userInput != 'N');

		letCpuGoFirst = userInput == 'y' || userInput == 'Y';

		sampleSimpleBoardPrinter.printSampleBoardSequence();
		sampleCoordinateBoardPrinter.printSampleBoardSequence();

		System.out.println();
		System.out.print("Choose a game board type (s/c): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!(userInput == 's' || userInput == 'S' || userInput == 'c' || userInput == 'C'));

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

		final char[] gameBoard = new char[GameBoard.GAME_BOARD_SPACES];

		if (letCpuGoFirst) {
			final int cpuFirstPlay = ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_SPACES + 1);
			gameBoard[cpuFirstPlay - 1] = cpuPlayingCharacter;
		}

		System.out.println();
		actualSimpleBoardPrinter.printActualBoard(gameBoard);

		gameLooper.loopSimpleGame(gameBoard, userPlayingCharacter, cpuPlayingCharacter);

		System.out.println();
		actualSimpleBoardPrinter.printActualBoard(gameBoard);

		final boolean playerWon = ticTacToeValidator.isTicTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = ticTacToeValidator.isTicTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		resultHandler.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

	private void playCoordinatesGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		final char[][] gameBoard = new char[GameBoard.GAME_BOARD_DIMENSION][GameBoard.GAME_BOARD_DIMENSION];

		if (letCpuGoFirst) {
			final int cpuFirstPlayXCoordinate = ThreadLocalRandom.current().nextInt(1,
					GameBoard.GAME_BOARD_DIMENSION + 1);
			final int cpuFirstPlayYCoordinate = ThreadLocalRandom.current().nextInt(1,
					GameBoard.GAME_BOARD_DIMENSION + 1);
			gameBoard[cpuFirstPlayYCoordinate - 1][cpuFirstPlayXCoordinate - 1] = cpuPlayingCharacter;
		}

		System.out.println();
		actualCoordinateBoardPrinter.printActualBoard(gameBoard);

		gameLooper.loopCoordinatesGame(gameBoard, userPlayingCharacter, cpuPlayingCharacter);

		System.out.println();
		actualCoordinateBoardPrinter.printActualBoard(gameBoard);

		final boolean playerWon = ticTacToeValidator.isTicTacToe(gameBoard, userPlayingCharacter);
		final boolean cpuWon = ticTacToeValidator.isTicTacToe(gameBoard, cpuPlayingCharacter);

		System.out.println();
		resultHandler.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

}
