package com.github.msx80.omicron.basicutils.gui.drawers;

public interface ScrollbarDrawer {

	public int getThickness();

	/**
	 * The lateral borders, at the beginning and end of the scrollbar
	 * @return
	 */
	public int getBorder();
	
	public void drawHorizontalScrollbar(int sx, int sy, int sw, int curPos, int curLen);

	public void drawVerticalScrollbar(int sx, int sy, int sh, int curPos, int curLen);


}
