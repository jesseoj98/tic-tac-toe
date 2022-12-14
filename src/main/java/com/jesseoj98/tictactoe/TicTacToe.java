package com.jesseoj98.tictactoe;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.Validator;

/**
 * Main application class
 */
public class TicTacToe {

	/** Instantiation of classes */
	private static final Game game = new Game();
	private static final Scanner scanner = new Scanner(System.in);
	private static final Validator validator = new Validator();

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
			} while (!validator.isInputValid(playAgain));

			System.out.println();

		} while (validator.playAgain(playAgain));

		System.out.println("Thanks for playing!");

	}

}
