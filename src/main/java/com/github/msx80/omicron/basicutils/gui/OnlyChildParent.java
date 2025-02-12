package com.github.msx80.omicron.basicutils.gui;

import java.util.Arrays;
import java.util.List;

public abstract class OnlyChildParent extends ParentWidget {

	final Widget child;
	final private List<Widget> children;

	public OnlyChildParent(Widget child, int w, int h) 
	{
		super( w, h);
		this.child = child;
		this.children = Arrays.asList(child);
		this.child.parent(this);
	}
	
	@Override
	public List<Widget> children() {
		
		return children;
	}
	
	public Widget getChild()
	{
		return child;
	}

}
