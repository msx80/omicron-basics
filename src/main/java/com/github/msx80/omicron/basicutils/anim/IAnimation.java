package com.github.msx80.omicron.basicutils.anim;

import java.util.function.Consumer;

public interface IAnimation 
{

	public boolean finished();
	
	/**
	 * Advance the animation, if it's the case the method should call onBegin and onEnd
	 * @returntrue if the animation is finished, false otherwise
	 */
	public boolean advance();
	
	default IAnimation addOnEnd(Consumer<IAnimation> e)
	{
		Consumer<IAnimation> onEnd = getOnEnd().andThen(e);
		setOnEnd(onEnd);
		return this;
	}	
	
	public Consumer<IAnimation> getOnEnd();
	
	public IAnimation setOnEnd(Consumer<IAnimation> e);
	
	public IAnimation setOnBegin(Consumer<IAnimation> e);
	
}
