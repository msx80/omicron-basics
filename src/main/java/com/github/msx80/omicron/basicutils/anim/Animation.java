package com.github.msx80.omicron.basicutils.anim;


/**
 * Classic tweening animation
 *
 */
public abstract class Animation extends BaseAnimation implements IAnimation 
{
	
	Easing easing;
	
	int ttl; // in frames
	int frame; // current frame
	public double position; // position [0,1] , post easing
	public double percentage; // percentage of completition [0,1], pre easing 
	
	public Animation(Easing easing, int ttl) {
		this.easing = easing;
		this.ttl = ttl;
		this.frame = 0;
		this.position = 0f;
		this.percentage = 0f;
	}

	public abstract void update(double position);
	
	@Override
	public boolean finished()
	{
		return frame >= ttl;
	}
	
	@Override
	public boolean advance()
	{
		if(frame == 0 && onBegin != null) onBegin.accept(this);
		
		this.frame++;
		boolean finished = finished();
		if (finished)
		{
			percentage = 1d;
			position = 1d;
		}
		else
		{
			percentage = (double)frame / (double)ttl;
			position = easing.fun.apply(percentage);
		}
		
		update(position);

		if (finished())
		{
			onEnd.accept(this);
		}
		
		return finished;
	}
	
	
}
