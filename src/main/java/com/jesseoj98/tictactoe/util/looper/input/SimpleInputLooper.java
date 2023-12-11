package com.jesseoj98.tictactoe.util.looper.input;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.generator.coordinate.CoordinateGenerator;
import com.jesseoj98.tictactoe.util.helper.occupier.BoardOccupier;
import com.jesseoj98.tictactoe.util.helper.validator.input.InputValidator;

public class SimpleInputLooper {

	private static final BoardOccupier boardOccupier = new BoardOccupier();

	private static final CoordinateGenerator coordinateGenerator = new CoordinateGenerator();

	private static final InputValidator inputValidator = new InputValidator();

	private static final Scanner scanner = new Scanner(System.in);

	public int loopSimpleInput(char[] gameBoard, boolean isPlayer) {

		int inputSimple;

		do {
			inputSimple = isPlayer ? scanner.nextInt() : coordinateGenerator.generateSimple();
		} while (!inputValidator.isValidBoardSpace(inputSimple)
				|| boardOccupier.isSpaceOccupied(gameBoard, inputSimple - 1));

		return inputSimple;

	}

}
