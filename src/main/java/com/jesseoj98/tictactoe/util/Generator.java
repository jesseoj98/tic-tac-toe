package com.jesseoj98.tictactoe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.tictactoe.domain.Coordinate;
import com.jesseoj98.tictactoe.domain.GameBoard;

/**
 * Generator class defines methods helpful for quick generation
 */
public class Generator {

	/**
	 * Generates a simple game board
	 * 
	 * @return a simple game board
	 */
	public char[] generateSimpleGameBoard() {
		return new char[GameBoard.GAME_BOARD_SPACES];
	}

	/**
	 * Generates a coordinate game board
	 * 
	 * @return a coordinate game board
	 */
	public char[][] generateCoordinateGameBoard() {
		return new char[GameBoard.GAME_BOARD_DIMENSION][GameBoard.GAME_BOARD_DIMENSION];
	}

	/**
	 * Generates simple coordinates
	 * 
	 * @return the simple coordinates
	 */
	public List<Integer> generateSimpleCoordinates() {
		final ArrayList<Integer> simpleCoordinates = new ArrayList<>();

		simpleCoordinates.add(0);
		simpleCoordinates.add(1);
		simpleCoordinates.add(2);
		simpleCoordinates.add(3);
		simpleCoordinates.add(4);
		simpleCoordinates.add(5);
		simpleCoordinates.add(6);
		simpleCoordinates.add(7);
		simpleCoordinates.add(8);

		return simpleCoordinates;
	}

	/**
	 * Generates simple winning coordinates
	 * 
	 * @return the simple winning coordinates
	 */
	public List<List<Integer>> generateSimpleWinningCoordinates() {
		final List<Integer> firstRow = Arrays.asList(0, 1, 2);
		final List<Integer> secondRow = Arrays.asList(3, 4, 5);
		final List<Integer> thirdRow = Arrays.asList(6, 7, 8);
		final List<Integer> firstColumn = Arrays.asList(0, 3, 6);
		final List<Integer> secondColumn = Arrays.asList(1, 4, 7);
		final List<Integer> thirdColumn = Arrays.asList(2, 5, 8);
		final List<Integer> backwardDiagonal = Arrays.asList(0, 4, 8);
		final List<Integer> forwardDiagonal = Arrays.asList(2, 4, 6);

		final List<List<Integer>> winningCoordinates = new ArrayList<>();

		winningCoordinates.add(firstRow);
		winningCoordinates.add(secondRow);
		winningCoordinates.add(thirdRow);
		winningCoordinates.add(firstColumn);
		winningCoordinates.add(secondColumn);
		winningCoordinates.add(thirdColumn);
		winningCoordinates.add(backwardDiagonal);
		winningCoordinates.add(forwardDiagonal);

		return winningCoordinates;
	}

	/**
	 * Generates coordinates
	 * 
	 * @return the coordinates
	 */
	public List<Coordinate> generateCoordinates() {
		final ArrayList<Coordinate> coordinates = new ArrayList<>();

		coordinates.add(new Coordinate(0, 0));
		coordinates.add(new Coordinate(0, 1));
		coordinates.add(new Coordinate(0, 2));
		coordinates.add(new Coordinate(1, 0));
		coordinates.add(new Coordinate(1, 1));
		coordinates.add(new Coordinate(1, 2));
		coordinates.add(new Coordinate(2, 0));
		coordinates.add(new Coordinate(2, 1));
		coordinates.add(new Coordinate(2, 2));

		return coordinates;
	}

	/**
	 * Generates winning coordinates
	 * 
	 * @return the winning coordinates
	 */
	public List<List<Coordinate>> generateWinningCoordinates() {
		final List<Coordinate> firstRow = Arrays.asList(new Coordinate(0, 0), new Coordinate(1, 0),
				new Coordinate(2, 0));
		final List<Coordinate> secondRow = Arrays.asList(new Coordinate(0, 1), new Coordinate(1, 1),
				new Coordinate(2, 1));
		final List<Coordinate> thirdRow = Arrays.asList(new Coordinate(0, 2), new Coordinate(1, 2),
				new Coordinate(2, 2));
		final List<Coordinate> firstColumn = Arrays.asList(new Coordinate(0, 0), new Coordinate(0, 1),
				new Coordinate(0, 2));
		final List<Coordinate> secondColumn = Arrays.asList(new Coordinate(1, 0), new Coordinate(1, 1),
				new Coordinate(1, 2));
		final List<Coordinate> thirdColumn = Arrays.asList(new Coordinate(2, 0), new Coordinate(2, 1),
				new Coordinate(2, 2));
		final List<Coordinate> backwardDiagonal = Arrays.asList(new Coordinate(0, 0), new Coordinate(1, 1),
				new Coordinate(2, 2));
		final List<Coordinate> forwardDiagonal = Arrays.asList(new Coordinate(2, 0), new Coordinate(1, 1),
				new Coordinate(0, 2));

		final List<List<Coordinate>> winningCoordinates = new ArrayList<>();

		winningCoordinates.add(firstRow);
		winningCoordinates.add(secondRow);
		winningCoordinates.add(thirdRow);
		winningCoordinates.add(firstColumn);
		winningCoordinates.add(secondColumn);
		winningCoordinates.add(thirdColumn);
		winningCoordinates.add(backwardDiagonal);
		winningCoordinates.add(forwardDiagonal);

		return winningCoordinates;
	}

	/**
	 * Generates a random simple coordinate
	 * 
	 * @return a random simple coordinate
	 */
	public int generateRandomSimpleCoordinate() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_SPACES);
	}

	/**
	 * Generates a random coordinate
	 * 
	 * @return a random coordinate
	 */
	public int generateRandomCoordinate() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_DIMENSION);
	}

	/**
	 * Generates a random coordinate object
	 * 
	 * @return a random coordinate object
	 */
	public Coordinate generateRandomCoordinateObject() {
		final int xCoordinate = ThreadLocalRandom.current().nextInt(0, GameBoard.GAME_BOARD_DIMENSION);
		final int yCoordinate = ThreadLocalRandom.current().nextInt(0, GameBoard.GAME_BOARD_DIMENSION);
		return new Coordinate(xCoordinate, yCoordinate);
	}
}
