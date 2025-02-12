package com.github.msx80.omicron.basicutils.anim;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class AnimationManager {
	private LinkedList<IAnimation> animations = new LinkedList<IAnimation>();
	
	
	public void update()
	{
		if ( animations.isEmpty() ) return;
		IAnimation a = animations.getFirst();
		
		boolean finished = a.advance();
		if(finished)
		{
			animations.removeFirst();
		}
		
	}
	
	public Animation add(Easing easing, int ttl, Consumer<IAnimation> onEnd, Consumer<IAnimation> onUpdate)
	{
		return this.add(new CallbackAnimation(easing, ttl, onEnd, onUpdate));
	}
	
	public Animation add(Easing easing, int ttl, Consumer<IAnimation> onEnd, int start, int end, IntConsumer onUpdate )
	{
		return this.add(new CallbackAnimation(easing, ttl, onEnd, an -> {
			CallbackAnimation a = (CallbackAnimation) an;
			double f = ((double)end)*a.position + ((double)start)*(1d -a.position);
			onUpdate.accept(  (int) f ); 
		}));
	}
	public Animation add(Animation a)
	{
		animations.add(a);
		return a;
	}	
	public IAnimation add(IAnimation... a)
	{
		animations.addAll(Arrays.asList(a));
		return animations.getFirst();
	}
	public boolean isRunning() {
		
		return !animations.isEmpty();
	}
	
	public IAnimation current()
	{
		if (animations.isEmpty()) {
			return null;
		}
		else
		{
			return animations.getFirst();
		}
	}
}
