package com.github.msx80.omicron.basicutils.gui;

import java.util.ArrayList;
import java.util.List;

import com.github.msx80.omicron.api.Sys;

/**
 * An abstract parent that manages the "list" of children and the add method.  
 *
 */
public abstract class ManagedParentWidget extends ParentWidget {

	public ManagedParentWidget(int w, int h) {
		super(w, h);
	}

	List<Widget> children = new ArrayList<Widget>();
	
	@Override
	public List<Widget> children() {
		return children;
	}

	/**
	 * Add the specified widget at the foremost, at the specified position
	 * @param <T>
	 * @param w
	 * @param x
	 * @param y
	 * @return
	 */
	public <T extends Widget> T add(T w, int x, int y)
	{
		children.add(w.parent(this).position(x, y));
		childInvalidated(w);
		return w;
	}
	
	public <T extends Widget> T add(T w)
	{
		children.add(w.parent(this));
		childInvalidated(w);
		return w;
	}
	
	@Override
	public Widget remove(Widget w)
	{
		children.remove(w);
		w.parent(null);
		return w;
	}
	

	
	
	
	public void zMove(Widget w, boolean up)
	{
		children.remove(w);
		if(up)
		{
			children.add(0, w);
		}
		else
		{
			children.add(w);
		}
	}
}
