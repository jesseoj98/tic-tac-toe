package com.jesseoj98.tictactoe.util.looper.game;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.generator.coordinate.CoordinateGenerator;
import com.jesseoj98.tictactoe.util.helper.inserter.BoardInserter;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.helper.validator.board.BoardValidator;
import com.jesseoj98.tictactoe.util.helper.validator.input.InputValidator;
import com.jesseoj98.tictactoe.util.helper.validator.tictactoe.TicTacToeValidator;
import com.jesseoj98.tictactoe.util.printer.board.actual.ActualSimpleBoardPrinter;

public class GameLooper {

	private static final ActualSimpleBoardPrinter actualSimpleBoardPrinter = new ActualSimpleBoardPrinter();

	private static final BoardInserter boardInserter = new BoardInserter();
	private static final BoardOccupier boardOccupier = new BoardOccupier();
	private static final BoardValidator boardValidator = new BoardValidator();

	private static final CoordinateGenerator coordinateGenerator = new CoordinateGenerator();

	private static final InputValidator inputValidator = new InputValidator();

	private static final Scanner scanner = new Scanner(System.in);

	private static final TicTacToeValidator ticTacToeValidator = new TicTacToeValidator();

	public void loopSimpleGame(char[] gameBoard, char userPlayingCharacter, char cpuPlayingCharacter) {

		int userInputSimple;
		int cpuInputSimple;

		do {

			System.out.print("\nEnter a spot to place your move: ");

			do {
				userInputSimple = scanner.nextInt();
			} while (!inputValidator.isValidBoardSpace(userInputSimple)
					|| boardOccupier.isSpaceOccupied(gameBoard, userInputSimple - 1));

			boardInserter.insertIntoBoard(gameBoard, userInputSimple - 1, userPlayingCharacter);

			if (ticTacToeValidator.ticTacToe(gameBoard, userPlayingCharacter)
					|| boardValidator.areAllBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputSimple = coordinateGenerator.generateSimple();
			} while (boardOccupier.isSpaceOccupied(gameBoard, cpuInputSimple - 1));

			boardInserter.insertIntoBoard(gameBoard, cpuInputSimple - 1, cpuPlayingCharacter);

			System.out.println();
			actualSimpleBoardPrinter.printActualBoardSequence(gameBoard);

		} while (!ticTacToeValidator.ticTacToe(gameBoard, cpuPlayingCharacter)
				&& !boardValidator.areAllBoardSpacesFilled(gameBoard));

	}

}
