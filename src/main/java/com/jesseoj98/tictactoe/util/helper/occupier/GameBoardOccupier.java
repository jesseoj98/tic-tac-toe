package com.jesseoj98.tictactoe.util.helper.occupier;

/**
 * Game board occupier interface supplies blueprints to check game boards for
 * space occupancy
 */
public interface GameBoardOccupier {

	public boolean isSpaceOccupied(char input);

	public boolean isSpaceOccupied(char[] gameBoard, int input);

	public boolean isSpaceOccupied(char[][] gameBoard, int xCoordinate, int yCoordinate);

}
