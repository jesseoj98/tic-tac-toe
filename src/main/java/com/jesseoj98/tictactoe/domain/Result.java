package com.jesseoj98.tictactoe.domain;

import java.util.List;
import java.util.Objects;

public class Result {

	private final boolean playerWon;

	private final boolean cpuWon;

	private final List<Integer> winningSimpleCoordinates;

	private final List<Coordinate> winningCoordinates;

	public Result(boolean playerWon, boolean cpuWon, List<Integer> winningSimpleCoordinates,
			List<Coordinate> winningCoordinates) {
		this.playerWon = playerWon;
		this.cpuWon = cpuWon;
		this.winningSimpleCoordinates = winningSimpleCoordinates;
		this.winningCoordinates = winningCoordinates;
	}

	public boolean isPlayerWon() {
		return playerWon;
	}

	public List<Integer> getWinningSimpleCoordinates() {
		return winningSimpleCoordinates;
	}

	public List<Coordinate> getWinningCoordinates() {
		return winningCoordinates;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpuWon, playerWon, winningCoordinates, winningSimpleCoordinates);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Result other = (Result) obj;
		return cpuWon == other.cpuWon && playerWon == other.playerWon
				&& Objects.equals(winningCoordinates, other.winningCoordinates)
				&& Objects.equals(winningSimpleCoordinates, other.winningSimpleCoordinates);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [playerWon=");
		builder.append(playerWon);
		builder.append(", cpuWon=");
		builder.append(cpuWon);
		builder.append(", winningSimpleCoordinates=");
		builder.append(winningSimpleCoordinates);
		builder.append(", winningCoordinates=");
		builder.append(winningCoordinates);
		builder.append(']');
		return builder.toString();
	}

}
