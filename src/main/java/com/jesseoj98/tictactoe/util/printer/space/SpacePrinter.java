package com.jesseoj98.tictactoe.util.printer.space;

public class SpacePrinter {

	public String printSpace(char space, int index) {
		if (!(space == 'X' || space == 'O')) {
			return switch (index) {
			case 0 -> "1";
			case 1 -> "2";
			case 2 -> "3";
			case 3 -> "4";
			case 4 -> "5";
			case 5 -> "6";
			case 6 -> "7";
			case 7 -> "8";
			case 8 -> "9";
			default -> " ";
			};
		} else {
			return Character.toString(space);
		}
	}

}
