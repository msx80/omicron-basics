package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.api.Sys;

import com.github.msx80.omicron.basicutils.ShapeDrawer;
import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;
import com.github.msx80.omicron.basicutils.gui.drawers.OutlineRectangle;
import com.github.msx80.omicron.basicutils.palette.Tic80;

public class Container extends ManagedParentWidget implements Backgrounded {

	protected Sys sys;
	Background bg = new OutlineRectangle(Tic80.BLUE_GRAY, Tic80.BROWN);
	
	public Container(Sys sys)
	{
		super(sys, 0, 0);
		this.sys = sys;
	}
	
	
	@Override
	public void draw() {
		bg.draw(sys, 0, 0, w, h);
		
		drawChildren();
	}

	@Override
	protected void childInvalidated(Widget widget) {
		int mw = 0;
		int mh = 0;
		for (Widget w : children()) {
			int cx = w.getX() + w.getW();
			int cy = w.getY() + w.getH();
			if (cx>mw) {
				mw = cx;
			}
			if (cy>mh) {
				mh = cy;
			}
		}
		this.w = mw;
		this.h = mh;
		invalidate();
	}


	@Override
	public Background getBg() {
		return this.bg;
	}


	@Override
	public Container setBg(Background bg) {
		this.bg = bg;
		return this;
	}




}
