package com.github.msx80.omicron.basicutils.anim;

import java.util.function.Consumer;

public class CallbackAnimation extends Animation {

	private Consumer<Animation> onUpdate;
	

	public CallbackAnimation(Easing easing, int ttl, Consumer<Animation> onEnd, Consumer<Animation> onUpdate) 
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
