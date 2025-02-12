package com.github.msx80.omicron.basicutils.anim;

import java.util.function.Consumer;

public class CallbackAnimation extends Animation {

	private Consumer<IAnimation> onUpdate;
	

	public CallbackAnimation(Easing easing, int ttl, Consumer<IAnimation> onEnd, Consumer<IAnimation> onUpdate) 
	{
		super(easing, ttl);
		this.onUpdate = onUpdate;
		this.onEnd = onEnd;
	}

	@Override
	public void update(double position) {
		if (onUpdate != null) {
			onUpdate.accept(this);
		}

	}


}
