package com.github.msx80.omicron.basicutils.gui.drawers;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.Colors;

public class Pattern implements Background{

	private int side = 32;
	private int colorA = Colors.RED;
	private int colorB = Colors.BLUE;

	public Pattern(int side, int colorA, int colorB) {
		super();
		this.side = side;
		this.colorA = colorA;
		this.colorB = colorB;
	}

	@Override
	public int getMargin() {
		return 0;
	}

	@Override
	public void draw(int x, int y, int w, int h) {
		boolean start = false;
		for (int px = x; px < x+w; px+=side) {
			boolean flip = start;
			for (int py = y; py < y+h; py+=side) {
				flip = ! flip;
				if(flip) Sys.fill(0, px, py, side, side, colorB);
			}
			start = !start;
		}
		start = false;
		for (int px = x; px < x+w; px+=side) {
			boolean flip = start;
			for (int py = y; py < y+h; py+=side) {
				flip = ! flip;
				if(!flip) Sys.fill(0, px, py, side, side, colorA);
			}
			start = !start;
		}
		
	}

}
