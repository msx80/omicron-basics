package com.github.msx80.omicron.basicutils.gui.drawers;

import com.github.msx80.omicron.api.Sys;

public class SolidColor implements Background {

	private int color;
	private int margin;

	public SolidColor(int margin, int color) {
		this.color = color;
		this.margin = margin;
	}

	@Override
	public void draw(Sys sys, int x, int y, int w, int h) {
		sys.fill(0, 0, 0, w, h, color);

	}

	@Override
	public int getMargin() {
		return margin;		
	}

}
