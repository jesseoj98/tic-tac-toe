package com.jesseoj98.tictactoe.util.generator.coordinate;

import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.tictactoe.domain.GameBoard;

public class CoordinateGenerator {

	public int generateSimple() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_SPACES + 1);
	}

	public int generateCoordinate() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_DIMENSION + 1);
	}

}
