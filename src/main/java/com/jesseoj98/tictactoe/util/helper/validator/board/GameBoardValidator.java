package com.jesseoj98.tictactoe.util.helper.validator.board;

/**
 * Game board validator interface supplies blueprints to validate game boards
 */
public interface GameBoardValidator {

	public boolean areAllBoardSpacesFilled(char[] simpleGameBoard);

	public boolean areAllBoardSpacesFilled(char[][] coordinateGameBoard);

}
