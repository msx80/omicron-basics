package com.github.msx80.omicron.basicutils.gui;

public interface Placeable 
{
	int getX();
	
	int getY();

	public Placeable position(int x, int y);

}
