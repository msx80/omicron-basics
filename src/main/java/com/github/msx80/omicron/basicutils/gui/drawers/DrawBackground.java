package com.github.msx80.omicron.basicutils.gui.drawers;

import com.github.msx80.omicron.api.Sys;

public class DrawBackground implements Background {

	private int surfaceNum;
	private int srcx;
	private int srcy;

	
	
	public DrawBackground(int surfaceNum, int srcx, int srcy) {
		super();
		this.surfaceNum = surfaceNum;
		this.srcx = srcx;
		this.srcy = srcy;
	}

	@Override
	public int getMargin() {
		return 0;
	}

	@Override
	public void draw(int x, int y, int w, int h) {
		Sys.draw(surfaceNum, x, y, srcx, srcy, w, h, 0, 0);

	}

}
