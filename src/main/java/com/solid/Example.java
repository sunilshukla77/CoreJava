package com.solid;

public class Example implements Shape, Rectangle {

	public static void main(String[] args) {

	}

	@Override
	public int getArea(int length, int width) {
		return length * width;
	}

	@Override
	public int getParameter(int length, int width) {
		return 2 * (length + width);
	}

	@Override
	public void draw(int r, int g, int b) {
		System.out.println("Blue color ");
	}

}
