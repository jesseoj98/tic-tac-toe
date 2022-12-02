package com.jesseojones.tictactoe.domain;

import java.util.List;
import java.util.Objects;

public class Results {

	private boolean playerWon;

	private boolean cpuWon;

	private List<Integer> winningSimpleCoordinates;

	private List<Coordinate> winningCoordinates;

	public Results(boolean playerWon, boolean cpuWon, List<Integer> winningSimpleCoordinates,
			List<Coordinate> winningCoordinates) {
		this.playerWon = playerWon;
		this.cpuWon = cpuWon;
		this.winningSimpleCoordinates = winningSimpleCoordinates;
		this.winningCoordinates = winningCoordinates;
	}

	public boolean isPlayerWon() {
		return playerWon;
	}

	public void setPlayerWon(boolean playerWon) {
		this.playerWon = playerWon;
	}

	public boolean isCpuWon() {
		return cpuWon;
	}

	public void setCpuWon(boolean cpuWon) {
		this.cpuWon = cpuWon;
	}

	public List<Integer> getWinningSimpleCoordinates() {
		return winningSimpleCoordinates;
	}

	public void setWinningSimpleCoordinates(List<Integer> winningSimpleCoordinates) {
		this.winningSimpleCoordinates = winningSimpleCoordinates;
	}

	public List<Coordinate> getWinningCoordinates() {
		return winningCoordinates;
	}

	public void setWinningCoordinates(List<Coordinate> winningCoordinates) {
		this.winningCoordinates = winningCoordinates;
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
		Results other = (Results) obj;
		return cpuWon == other.cpuWon && playerWon == other.playerWon
				&& Objects.equals(winningCoordinates, other.winningCoordinates)
				&& Objects.equals(winningSimpleCoordinates, other.winningSimpleCoordinates);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Results [playerWon=");
		builder.append(playerWon);
		builder.append(", cpuWon=");
		builder.append(cpuWon);
		builder.append(", winningSimpleCoordinates=");
		builder.append(winningSimpleCoordinates);
		builder.append(", winningCoordinates=");
		builder.append(winningCoordinates);
		builder.append("]");
		return builder.toString();
	}

}
