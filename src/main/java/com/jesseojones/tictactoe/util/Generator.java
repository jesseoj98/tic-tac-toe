package com.jesseojones.tictactoe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.jesseojones.tictactoe.domain.Coordinate;

public class Generator {

	private static final int GAME_BOARD_DIMENSIONS = 3;

	private static final int GAME_BOARD_SPACES = 9;

	public char[] generateSimpleGameBoard() {
		return new char[GAME_BOARD_SPACES];
	}

	public char[][] generateCoordinateGameBoard() {
		return new char[GAME_BOARD_DIMENSIONS][GAME_BOARD_DIMENSIONS];
	}

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

	public int generateRandomSimpleCoordinate() {
		return ThreadLocalRandom.current().nextInt(1, GAME_BOARD_SPACES);
	}

	public int generateRandomCoordinate() {
		return ThreadLocalRandom.current().nextInt(1, GAME_BOARD_DIMENSIONS);
	}

	public Coordinate generateRandomCoordinateObject() {
		final int xCoordinate = ThreadLocalRandom.current().nextInt(0, GAME_BOARD_DIMENSIONS);
		final int yCoordinate = ThreadLocalRandom.current().nextInt(0, GAME_BOARD_DIMENSIONS);
		return new Coordinate(xCoordinate, yCoordinate);
	}
}