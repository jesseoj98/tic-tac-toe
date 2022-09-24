package com.jesseojones.tictactoe.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.jesseojones.tictactoe.domain.Coordinate;

public class Generator {

	private static final int MAXIMUM_VALUE = 10;
	private static final int BOARD_SPACE_DIMENSION = 9;
	private static final int BOARD_AXIS_DIMENSION = 3;

	public char[] generateSimpleGameBoard() {
		return new char[BOARD_SPACE_DIMENSION];
	}

	public char[][] generateCoordinateGameBoard() {
		return new char[BOARD_AXIS_DIMENSION][BOARD_AXIS_DIMENSION];
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

	public int generateRandomSimpleCoordinate() {
		return ThreadLocalRandom.current().nextInt(0, BOARD_SPACE_DIMENSION);
	}

	public int generateRandomCoordinate() {
		return ThreadLocalRandom.current().nextInt(0, BOARD_AXIS_DIMENSION);
	}

	public Coordinate generateRandomCoordinateObject() {
		final int xCoordinate = ThreadLocalRandom.current().nextInt(0, BOARD_AXIS_DIMENSION);
		final int yCoordinate = ThreadLocalRandom.current().nextInt(0, BOARD_AXIS_DIMENSION);
		return new Coordinate(xCoordinate, yCoordinate);
	}
}
