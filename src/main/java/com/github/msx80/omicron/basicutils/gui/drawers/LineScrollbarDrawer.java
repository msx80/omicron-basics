package com.github.msx80.omicron.basicutils.gui.drawers;

import com.github.msx80.omicron.api.Sys;

import com.github.msx80.omicron.basicutils.ShapeDrawer;

/**
 * Draw a single line
 */
public class LineScrollbarDrawer implements ScrollbarDrawer {

	int curColor;
	int outlineColor;
	
	public LineScrollbarDrawer(int curColor, int outlineColor) {
		this.curColor = curColor;
		this.outlineColor = outlineColor;
	}

	public int getThickness()
	{
		return 1;
	}
	
	public void drawHorizontalScrollbar(Sys sys, int sx, int sy, int sw, int curPos, int curLen) {
		sys.fill(0, sx, sy,sw, 1, outlineColor);
		sys.fill(0, sx+curPos, sy, curLen, 1, curColor);
	}

	public void drawVerticalScrollbar(Sys sys, int sx, int sy, int sh, int curPos, int curLen) {
		sys.fill(0, sx, sy, 1, sh, outlineColor);
		sys.fill(0, sx, sy+curPos, 1, curLen, curColor);
	}

	@Override
	public int getBorder() {
		return 1;
	}

}
