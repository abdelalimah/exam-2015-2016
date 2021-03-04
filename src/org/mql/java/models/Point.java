package org.mql.java.models;

import org.mql.java.annotations.IntRange;

import java.io.Serializable;

public class Point implements Serializable {

	@IntRange(min = 10, max = 20)
	private double x;
	private double y;
	private String outputValue = "";

	public Point(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public Point() {
		this(4, 5);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setOutputValue(String outputValue) {
		this.outputValue = outputValue;
	}

	@Override
	public String toString() {
		return "The point value/values are : " + outputValue;
	}
}
