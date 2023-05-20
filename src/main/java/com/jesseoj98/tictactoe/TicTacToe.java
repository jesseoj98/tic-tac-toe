package com.jesseoj98.tictactoe;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.helper.validator.InputValidator;

/**
 * Main application class
 */
public class TicTacToe {

	/** Instantiation of classes */
	private static final InputValidator iv = new InputValidator();

	private static final Game game = new Game();
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * The main application method
	 * 
	 * @param args the String array args
	 */
	public static void main(String[] args) {

		char playAgain;

		do {

			game.playGame();

			do {
				playAgain = scanner.next().charAt(0);
			} while (!iv.isYesOrNo(playAgain));

			System.out.println();

		} while (iv.isYes(playAgain));

		System.out.println("Thanks for playing!");

	}

}
