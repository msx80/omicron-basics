package com.github.msx80.omicron.basicutils.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.msx80.omicron.api.Sys;


/**
 * A widget that has some child widgets.
 * It should draw the widget accordingly, handle the "pick" picking, etc.
 * Note that there's no add() method to add children as this is an implementation specific operation that
 * different parents can implement differently 
 *
 */
public abstract class ParentWidget extends BaseWidget implements Iterable<Widget> {

	public ParentWidget(int w, int h) {
		super(w, h);
	}

	public void drawChildren() {
		//sys.offset(padding.top, padding.left);
		for (Widget w : this) {
			Sys.offset(w.getX(), w.getY());
			w.draw();
			Sys.offset(-w.getX(), -w.getY());
		}
		//sys.offset(-padding.top, -padding.left);
	}
	
	@Override
	public void draw() {
		drawChildren();
	}
	
	protected abstract void childInvalidated(Widget widget);

	public abstract List<Widget> children();
	
	/*
	public Widget pick(int px, int py)
	{
		for (int i = children().size() -1 ; i >= 0 ; i--) {
			Widget w = children().get(i);
			if(w.isInside(px, py))
			{
				if(w instanceof ParentWidget)
				{
					return ((ParentWidget) w).pick(px-w.x, py-w.y);
				}
				else
				{
					return w;
				}
			}
		}
		return this;
	}*/
	

	/**
	 * For scrolling or partially visible parents, ensure the visible area of the child includes the specified area
	 */
	public void ensureVisible(Widget child, int x, int y, int w, int h) {

		parent.ensureVisible(this, child.getX()+x, child.getY()+y, w, h);
		
	}

	@Override
	public Iterator<Widget> iterator() {
		
		return children().iterator();
	}

	public abstract Widget remove(Widget w) ;
	
	
	public void removeAll()
	{
		List<Widget> ch = new ArrayList<>(this.children()); 
		for (Widget widget : ch) {
			this.remove(widget);
		}
	}

	
}
