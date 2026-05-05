package com.github.msx80.omicron.basicutils.gui;

public class VerticalAutobox extends ManagedParentWidget{


	private int spacing;

	public VerticalAutobox(int spacing) {
		super(10, 10);
		this.spacing = spacing;

	}

	@Override
	public <T extends Widget> T add(T w, int x, int y) {
		
		T c = super.add(w, x, y);
		repositionComponents();
		return c;
	}

	private void repositionComponents() {
		int y = 0;
		int maxW = 0;
		for (Widget w : this.children) {
			w.position(0, y);
			y+=w.getH()+spacing;
			maxW = Math.max(maxW, w.getW());
		}
		y=y-spacing;
		this.size(maxW, y);
		invalidate();
	}

	public VerticalAutobox addSpacer(int size)
	{
		this.add(new Spacer(1, size));
		return this;
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
	
	public static VerticalAutobox of(int spacing, Widget... widgets)
	{
		VerticalAutobox v = new VerticalAutobox(spacing);
		for (Widget widget : v) {
			v.add(widget);
		}
		return v;
	}
	
}
