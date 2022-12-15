package com.jesseoj98.tictactoe;

import java.util.Scanner;

import com.jesseoj98.tictactoe.util.Generator;
import com.jesseoj98.tictactoe.util.Helper;
import com.jesseoj98.tictactoe.util.Printer;
import com.jesseoj98.tictactoe.util.Validator;

/**
 * Main application class
 */
public class Application {

	/** Instantiation of classes */
	private static Game game = new Game();
	private static Scanner scanner = new Scanner(System.in);
	private static Validator validator = new Validator();

	/**
	 * The main application method
	 * 
	 * @param args the String array args
	 */
	public static void main(String[] args) {

		char playAgain;

		do {

			game.ticTacToe();

			do {
				playAgain = scanner.next().charAt(0);
			} while (!validator.isInputValid(playAgain));

			System.out.println();

		} while (validator.playAgain(playAgain));

		System.out.println("Thanks for playing!");

	}

}
