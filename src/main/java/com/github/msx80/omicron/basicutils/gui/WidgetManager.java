package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.api.Omicron;
import com.github.msx80.omicron.api.Pointer;
import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.api.adv.AdvancedSys;
import com.github.msx80.omicron.api.adv.AdvancedSys.KeyboardListener;

public class WidgetManager extends ManagedParentWidget implements KeyboardListener {

	
	private int scrollBtn = 0;


	Scrollable scrolling;   // widget currently being scrolled
	int scrollpx;   		// scroll start position		  
	int scrollpy; 
	boolean scrollNotified; 
	Widget over;			// widget the mouse is over


	private KeyboardListenerWidget focused = null;
	
	/*
	public WidgetManager(Sys sys) {
		super(sys, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	*/

	
	public WidgetManager(int screenW, int screenH) {
		super(screenW, screenH);
	}
	

	@Override
	public void childInvalidated(Widget widget) {
		// nothing to do here
	}
	
	private void propagateclick(Widget from, int px, int py)
	{
		Widget w = from.find(px, py, true, a -> (a instanceof Clickable || a instanceof KeyboardListenerWidget));

		if(w!=null)
		{
			if(w instanceof KeyboardListenerWidget)
			{
				if(focused != null) focused.setFocused(false);
				focused  = (KeyboardListenerWidget) w;
				focused.setFocused(true);
			}
			if(w instanceof Clickable)
			{
				((Clickable) w).click(px-w.getAbsoluteX(), py-w.getAbsoluteY());
			}
		}
	}
	
	
	@Override
	public void ensureVisible(Widget child, int x, int y, int w, int h) {
		// nothing to do here
		
	}

	public void update() {
		
		Pointer mouse = Sys.pointers()[0];
		int mx = mouse.x();
		int my = mouse.y();
		
		
		handleUpdate(this, mouse, mx, my);
		
		handleControllables(this);
		
	}

	private void handleUpdate(Widget topWidget, Pointer mouse, int mx, int my) {
		if(scrolling != null)
		{
			Widget ws = (Widget) scrolling;
			if(!mouse.btn(scrollBtn))
			{
				if(scrollNotified)
				{
					scrolling.endScroll();
				}
				else
				{
					// scrolled too little, consider it a click instead (if same btn)
					if(scrollBtn == 0)
					{
						propagateclick(topWidget, mx, my);
					}
				}
				scrolling = null;
				scrollNotified = false;
			}
			else
			{
				// still scrolling
				int dx = mx - scrollpx;
				int dy = my - scrollpy;
				if(dx != 0 || dy != 0)
				{
					if(!scrollNotified)
					{
						scrolling.startScroll(mx-ws.getAbsoluteX(), my-ws.getAbsoluteY());
						scrollNotified = true;
					}
					scrolling.doScroll(dx, dy, mx-ws.getAbsoluteX(), my-ws.getAbsoluteY());
					scrollpx = mx;
					scrollpy = my;
				}
			}
		}
		else
		{
			if(mouse.btnp(scrollBtn))
			{
				scrolling = (Scrollable) topWidget.find(mx, my, false, w -> w instanceof Scrollable);
				if(scrolling != null)
				{
					scrollpx = mx;
					scrollpy = my;
					scrollNotified = false;
				}
				else
				{
					if (scrollBtn == 0 ) propagateclick(topWidget, mx, my);
				}
			}
			else
			{
				// mouse over something?
				over = topWidget.find(mx, my, true, a -> true);
			}
			if(scrollBtn!=0 && mouse.btnp(0)) {
				propagateclick(topWidget, mx, my);
			}
		}
	}

	private boolean handleControllables(Widget w) {
		if(w instanceof Controllable)
		{
			((Controllable) w).control(Sys.controllers()[0]);
			return true;
		}
		if(w instanceof ParentWidget)
		{
			for (Widget c : ((ParentWidget) w).children()) {
				if (handleControllables(c)) return true;
			}
		}
		return false;
	}

	public Widget getOver() {
		return over;
	}
	public int getScrollBtn() {
		return scrollBtn;
	}

	public void setScrollBtn(int scrollBtn) {
		this.scrollBtn = scrollBtn;
	}
	
	public Widget addModal(Widget w, int x, int y)
	{
		// w.setPosition(this.w / 2 - w.getW()/2, this.h / 2 - w.getH()/2);
		Modal mod = new Modal(this.w, this.h);
		mod.add(w, x, y);
		this.add(mod);
		return w;
	}
	
	public void enableKeyboardInput()
	{
		AdvancedSys a;
		a = (AdvancedSys) Omicron.sys();
		a.activateKeyboardInput(this);
	}


	@Override
	public boolean keyDown(int keycode) {
		if(focused == null)	return false; 
		return focused.keyDown(keycode);
	}


	@Override
	public boolean keyUp(int keycode) {
		if(focused == null)	return false; 
		return focused.keyUp(keycode);
	}


	@Override
	public boolean keyTyped(char character) {
		if(focused == null)	return false; 
		return focused.keyTyped(character);
	}
	
}
