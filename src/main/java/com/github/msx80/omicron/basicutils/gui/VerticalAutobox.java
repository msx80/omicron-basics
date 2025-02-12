package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;

public class VerticalAutobox extends ManagedParentWidget implements Backgrounded {

	private Background bg;
	private int spacing;

	public VerticalAutobox(Background bg, int spacing) {
		super(10, 10);
		this.bg = bg;
		this.spacing = spacing;

	}

	@Override
	public void draw() {
		bg.draw(0, 0, w, h);
		drawChildren();
	}
	
	@Override
	protected void childInvalidated(Widget widget) {
		

	}

	@Override
	public <T extends Widget> T add(T w, int x, int y) {
		
		T c = super.add(w, x, y);
		repositionComponents();
		return c;
	}

	private void repositionComponents() {
		int y = bg.getMargin();
		int maxW = 0;
		for (Widget w : this.children) {
			w.position(bg.getMargin(), y);
			y+=w.getH()+spacing;
			maxW = Math.max(maxW, w.getW());
		}
		y=y-spacing+bg.getMargin();
		this.size(maxW+(bg.getMargin()*2), y);
		invalidate();
	}

	@Override
	public <T extends Widget> T add(T w) {
		
		T c = super.add(w);
		repositionComponents();
		return c;
	}

	@Override
	public Background getBg() {
		return bg;
	}

	@Override
	public Backgrounded setBg(Background bg) {
		this.bg = bg;
		repositionComponents();
		return this;
	}

	
	
	
}
