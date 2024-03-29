package com.jesseoj98.tictactoe.domain;

import java.util.Objects;

public class Coordinate {

	private final int x;

	private final int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Coordinate other = (Coordinate) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coordinate [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(']');
		return builder.toString();
	}

}
