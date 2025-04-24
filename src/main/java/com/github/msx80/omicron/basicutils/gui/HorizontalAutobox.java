package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;

public class HorizontalAutobox extends ManagedParentWidget{


	private int spacing;

	public HorizontalAutobox(int spacing) {
		super(10, 10);
		this.spacing = spacing;

	}

	@Override
	public <T extends Widget> T add(T w, int x, int y) {
		
		T c = super.add(w, x, y);
		repositionComponents();
		return c;
	}
	public HorizontalAutobox addSpacer(int size)
	{
		this.add(new Spacer(size, 1));
		return this;
	}
	
	private void repositionComponents() {
		int x = 0;
		int maxH = 0;
		for (Widget w : this.children) {
			w.position(x, 0);
			x+=w.getW()+spacing;
			maxH = Math.max(maxH, w.getH());
		}
		x=x-spacing;
		this.size(x, maxH);
		invalidate();
	}

	@Override
	public <T extends Widget> T add(T w) {
		
		T c = super.add(w);
		repositionComponents();
		return c;
	}

	@Override
	protected void childInvalidated(Widget widget) {
	
	}
	public static HorizontalAutobox of(int spacing, Widget... widgets)
	{
		HorizontalAutobox v = new HorizontalAutobox(spacing);
		for (Widget widget : v) {
			v.add(widget);
		}
		return v;
	}	
}
