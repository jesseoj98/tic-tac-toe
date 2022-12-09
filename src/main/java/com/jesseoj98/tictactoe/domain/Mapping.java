package com.jesseoj98.tictactoe.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapping class defines helpful mapping information regarding the game board
 */
public class Mapping {

	/**
	 * Generates a mapping from Integer to Coordinate conversion
	 * 
	 * @return the mapping from Integer to Coordinate conversion
	 */
	public Map<Integer, Coordinate> integerToCoordinate() {
		final Map<Integer, Coordinate> map = new HashMap<>();

		map.put(0, new Coordinate(0, 0));
		map.put(1, new Coordinate(1, 0));
		map.put(2, new Coordinate(2, 0));
		map.put(3, new Coordinate(0, 1));
		map.put(4, new Coordinate(1, 1));
		map.put(5, new Coordinate(2, 1));
		map.put(6, new Coordinate(0, 2));
		map.put(7, new Coordinate(1, 2));
		map.put(8, new Coordinate(2, 2));

		return map;
	}

	/**
	 * Generates a mapping from Coordinate to Integer conversion
	 * 
	 * @return the mapping from Coordinate to Integer conversion
	 */
	public Map<Coordinate, Integer> coordinateToInteger() {
		final Map<Coordinate, Integer> map = new HashMap<>();

		map.put(new Coordinate(0, 0), 0);
		map.put(new Coordinate(1, 0), 1);
		map.put(new Coordinate(2, 0), 2);
		map.put(new Coordinate(0, 1), 3);
		map.put(new Coordinate(1, 1), 4);
		map.put(new Coordinate(2, 1), 5);
		map.put(new Coordinate(0, 2), 6);
		map.put(new Coordinate(1, 2), 7);
		map.put(new Coordinate(2, 2), 8);

		return map;
	}

}