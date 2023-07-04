package com.jesseoj98.tictactoe;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.helper.validator.input.InputValidator;

public class TicTacToe {

	private static final InputValidator inputValidator = new InputValidator();

	private static final Game game = new Game();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		char playAgain;

		do {

			game.playGame();

			do {
				playAgain = scanner.next().charAt(0);
			} while (inputValidator.isYesOrNo(playAgain));

			System.out.println();

		} while (inputValidator.isYes(playAgain));

		System.out.println("Thanks for playing!");

	}

}
