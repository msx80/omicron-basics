package com.github.msx80.omicron.basicutils.anim;

public class Serial extends BaseAnimation {

	private IAnimation[] anims;
	int curr = 0;
	private boolean calledOnEnd = false;
	private boolean calledOnBegin = false;
	
	public Serial(IAnimation... anims) {
		this.anims = anims;
	}

	@Override
	public boolean finished() {
		
		return curr>=anims.length;
	}

	@Override
	public boolean advance() {
		if(!calledOnBegin)
		{
			calledOnBegin = true;
			if(onBegin!=null) onBegin.accept(this);
		}
		
		if(anims.length == 0) 
		{
			callOnEnd();
			return true;
		}
		
		boolean finished = anims[curr].advance();
		if(finished) curr++;
		
		if(curr>=anims.length)
		{
			callOnEnd();
			return true;
		}
			
		return false;
	}

	private void callOnEnd()
	{
		if(!calledOnEnd)
		{
			calledOnEnd = true;
			if(onEnd!=null) onEnd.accept(this);
		}

	}

}
