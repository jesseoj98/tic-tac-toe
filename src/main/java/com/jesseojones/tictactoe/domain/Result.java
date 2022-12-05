package com.jesseojones.tictactoe.domain;

import java.util.List;
import java.util.Objects;

/**
 * Result class defines information about the game results
 */
public class Result {

	/**
	 * Indicator for if the player won
	 */
	private boolean playerWon;

	/**
	 * Indicator for if the cpu won
	 */
	private boolean cpuWon;

	/**
	 * The winning simple coordinates
	 */
	private List<Integer> winningSimpleCoordinates;

	/**
	 * The winning coordinates
	 */
	private List<Coordinate> winningCoordinates;

	/**
	 * Constructor to create a results
	 * 
	 * @param playerWon                whether the player won
	 * @param cpuWon                   whether the cpu won
	 * @param winningSimpleCoordinates the winning simple coordinates
	 * @param winningCoordinates       the winning coordinates
	 */
	public Result(boolean playerWon, boolean cpuWon, List<Integer> winningSimpleCoordinates,
			List<Coordinate> winningCoordinates) {
		this.playerWon = playerWon;
		this.cpuWon = cpuWon;
		this.winningSimpleCoordinates = winningSimpleCoordinates;
		this.winningCoordinates = winningCoordinates;
	}

	/**
	 * Returns if the player won
	 * 
	 * @return if the player won
	 */
	public boolean isPlayerWon() {
		return playerWon;
	}

	/**
	 * Sets if the player won
	 * 
	 * @param playerWon the player won
	 */
	public void setPlayerWon(boolean playerWon) {
		this.playerWon = playerWon;
	}

	/**
	 * Returns if the cpu won
	 * 
	 * @return if the cpu won
	 */
	public boolean isCpuWon() {
		return cpuWon;
	}

	/**
	 * Sets if the cpu won
	 * 
	 * @param cpuWon the cpu won
	 */
	public void setCpuWon(boolean cpuWon) {
		this.cpuWon = cpuWon;
	}

	/**
	 * Returns the winning simple coordinates
	 * 
	 * @return the winning simple coordinates
	 */
	public List<Integer> getWinningSimpleCoordinates() {
		return winningSimpleCoordinates;
	}

	/**
	 * Sets the winning simple coordinates
	 * 
	 * @param winningSimpleCoordinates the winning simple coordinates
	 */
	public void setWinningSimpleCoordinates(List<Integer> winningSimpleCoordinates) {
		this.winningSimpleCoordinates = winningSimpleCoordinates;
	}

	/**
	 * Returns the winning coordinates
	 * 
	 * @return the winning coordinates
	 */
	public List<Coordinate> getWinningCoordinates() {
		return winningCoordinates;
	}

	/**
	 * Sets the winning coordinates
	 * 
	 * @param winningCoordinates the winning coordinates
	 */
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
		builder.append("]");
		return builder.toString();
	}

}
