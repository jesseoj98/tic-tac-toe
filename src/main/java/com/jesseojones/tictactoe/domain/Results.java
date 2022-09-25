package com.jesseojones.tictactoe.domain;

import java.util.List;

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
}
