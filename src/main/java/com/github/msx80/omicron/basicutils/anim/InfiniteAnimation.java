package com.github.msx80.omicron.basicutils.anim;

/**
 * For things you want to terminate manually
 *
 */
public class InfiniteAnimation extends BaseAnimation {

	
	private boolean shouldStop = false;
	private boolean onBeginCalled = false;
	
	@Override
	public boolean finished() {
		return shouldStop;
	}

	
	public void terminate()
	{
		if(!shouldStop)
		{
			if (onEnd != null)onEnd.accept(this);
		}
		shouldStop = true;
	}


	@Override
	public boolean advance() {
		if(!onBeginCalled)
		{
			onBeginCalled = true;
			if(onBegin != null) onBegin.accept(this); 
		}
		
		return shouldStop;
	}



	
}
