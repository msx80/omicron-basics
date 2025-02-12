package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;

public class Wrap extends OnlyChildParent implements Backgrounded {

	private Background bg;

	public Wrap(Widget child, Background bg) {
		super(child, child.getW()+(bg.getMargin()*2), child.getH()+(bg.getMargin()*2));
		this.bg = bg;
		child.position(bg.getMargin(), bg.getMargin());
	}

	@Override
	public Background getBg() {
		
		return bg;
	}

	@Override
	public Backgrounded setBg(Background bg) {
		boolean shouldInvalidate = this.bg.getMargin() != bg.getMargin();
		this.bg = bg;
		if (shouldInvalidate) {
			child.position(bg.getMargin(), bg.getMargin());
			this.size(child.getW()+(bg.getMargin()*2), child.getH()+(bg.getMargin()*2));
			this.invalidate();
		}
		return this;
	}

	@Override
	protected void childInvalidated(Widget widget) {
		// child.position(bg.getMargin(), bg.getMargin());
		this.size(child.getW()+(bg.getMargin()*2), child.getH()+(bg.getMargin()*2));
		this.invalidate();
	}
	
	@Override
	public void draw() {
		bg.draw(0, 0, w, h);
		
		drawChildren();
	}

	@Override
	public Widget remove(Widget w) {
		
		throw new UnsupportedOperationException("Can't remove child!");
	}

	public static Wrap wrap(Widget w, Background bg)
	{
		return new Wrap(w, bg);
	}
}
