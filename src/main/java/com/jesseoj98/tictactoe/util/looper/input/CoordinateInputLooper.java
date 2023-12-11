package com.jesseoj98.tictactoe.util.looper.input;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.helper.validator.input.InputValidator;

public class CoordinateInputLooper {

	private static final InputValidator inputValidator = new InputValidator();

	private static final Scanner scanner = new Scanner(System.in);
	
	public int loopPlayerCoordinateInput(char[][] gameBoard) {
		
		int inputCoordinate;

		do {
			inputCoordinate = scanner.nextInt();
		} while (!inputValidator.isValidCoordinatesSpace(inputCoordinate));

		return inputCoordinate;
		
	}

}
