package com.github.msx80.omicron.basicutils.text;

/**
 * Draws a text on the screen.
 * 
 */
public interface TextDrawer {
	
	public static enum Align {LEFT, CENTER, RIGHT};

	int print(String text, int x, int y, Align align);

	int print(String text, int x, int y);

	int width(String text);
	
	int height();

}