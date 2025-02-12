package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;

public class Panel extends ManagedParentWidget implements Backgrounded {

	private Background bg;

	public Panel(Background bg,  int w, int h) {
		super( w, h);
		this.bg = bg;
	}

	@Override
	public Background getBg() {
		
		return bg;
	}

	
	
	@Override
	public void draw() {
		bg.draw( 0, 0, w, h);
		drawChildren();
	}

	@Override
	public Panel setBg(Background bg) {
		this.bg = bg;
		return this;
	}

	@Override
	protected void childInvalidated(Widget widget) {
		// nothing

	}

}
