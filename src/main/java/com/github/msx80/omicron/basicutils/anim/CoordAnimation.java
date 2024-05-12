package com.github.msx80.omicron.basicutils.anim;

public abstract class CoordAnimation extends Animation 
{
	private int fromx;
	private int fromy;
	private int dx;
	private int dy;

	public CoordAnimation(Easing easing, int ttl, int fromx, int fromy, int tox, int toy) {
		super(easing, ttl);
		this.fromx = fromx;
		this.fromy = fromy;
		this.dx = tox - fromx;
		this.dy = toy - fromy;
	}

	@Override
	public void update(double position) 
	{
		int x = (int) (fromx + (dx * position));
		int y = (int) (fromy + (dy * position));
		
		update(x,y);
	}

	public abstract void update(int x, int y);

}
