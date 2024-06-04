package com.github.msx80.omicron.basicutils.gui.drawers;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.Colors;

public class AlphaColor implements Background {

	private int color;
	private int margin;

	public AlphaColor(int margin, int color) {
		this.color = color;
		this.margin = margin;
	}

	@Override
	public void draw(Sys sys, int x, int y, int w, int h) {
		sys.color(color);
		sys.fill(0, 0, 0, w, h, Colors.WHITE);

	}

	@Override
	public int getMargin() {
		return margin;
	}

}
