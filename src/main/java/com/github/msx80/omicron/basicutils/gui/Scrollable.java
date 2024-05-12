package com.github.msx80.omicron.basicutils.gui;

/**
 * A widget that can get a "mouse down" and then can be dragged around
 *
 */
public interface Scrollable {
	void startScroll(int x, int y);
	void doScroll(int dx, int dy, int x, int y);
	void endScroll();
}
