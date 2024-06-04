package com.github.msx80.omicron.basicutils.gui.drawers;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.ShapeDrawer;

public class OutlineRectangle implements Background {

	private int backgroundColor;
	private int borderColor;
	
	public OutlineRectangle(int backgroundColor, int borderColor) {
		super();
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
	}

	@Override
	public void draw(Sys sys, int x, int y, int w, int h) {
		sys.fill(0, x, y, w, h, backgroundColor);
		ShapeDrawer.outline(sys, x, y, w, h, 0, borderColor);

	}

	@Override
	public int getMargin() {
		return 2;
	}

}
