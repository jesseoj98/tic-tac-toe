package com.jesseoj98.tictactoe.util.helper.occupier;

/**
 * Game board occupier interface supplies blueprints to check game boards for
 * space occupancy
 */
public interface GameBoardOccupier {

	public boolean isSpaceAlreadyOccupied(char input);

	public boolean isSpaceAlreadyOccupied(char[] gameBoard, int input);

	public boolean isSpaceAlreadyOccupied(char[][] gameBoard, int xCoordinate, int yCoordinate);

}
