package com.jesseoj98.tictactoe.util.helper.inserter;

import com.jesseoj98.tictactoe.domain.Coordinate;

/**
 * Game board inserter interface supplies blueprints to insert into a game board
 */
public interface GameBoardInserter {

	public void insertIntoBoard(char[] gameBoard, int userInput, char playingCharacter);

	public void insertIntoBoard(char[][] gameBoard, Coordinate coordinate, char playingCharacter);

	public void insertIntoBoard(char[][] gameBoard, int xCoordinate, int yCoordinate, char playingCharacter);

}
