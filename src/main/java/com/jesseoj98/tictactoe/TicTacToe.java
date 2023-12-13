package com.jesseoj98.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	private static final Game game = new Game();

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		char playAgain;

		do {

			game.playGame();

			do {
				playAgain = scanner.next().charAt(0);
			} while (playAgain != 'y' && playAgain != 'Y' && playAgain != 'n' && playAgain != 'N');

			System.out.println();

		} while (playAgain == 'y' || playAgain == 'Y');

		System.out.println("Thanks for playing!");

	}

}
