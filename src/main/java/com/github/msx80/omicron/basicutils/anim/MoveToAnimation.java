package com.github.msx80.omicron.basicutils.anim;

import com.github.msx80.omicron.basicutils.gui.Placeable;

public class MoveToAnimation extends CoordAnimation {

	private Placeable p;

	public MoveToAnimation(Easing easing, int ttl, Placeable p, int tox, int toy) {
		super(easing, ttl, p.getX(), p.getY(), tox, toy);
		this.p = p;
	}

	@Override
	public void update(int x, int y) {
		p.setPosition(x, y);
	}

	@Override
	public void end() {
	}

}
