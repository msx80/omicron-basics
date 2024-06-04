package com.github.msx80.omicron.basicutils.anim;

public class Parallel extends Animation {

	private Animation a1;
	private Animation a2;

	public Parallel(Animation a1, Animation a2) {
		super(Easing.LINEAR, Math.max(a1.ttl, a2.ttl));
		this.a1 = a1;
		this.a2 = a2;
	}

	@Override
	public void update(double position) {
		if(!a1.finished()) a1.advance();
		if(!a2.finished()) a2.advance();
	}


}
