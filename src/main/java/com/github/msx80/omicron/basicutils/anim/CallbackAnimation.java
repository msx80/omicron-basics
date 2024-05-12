package com.github.msx80.omicron.basicutils.anim;

import java.util.function.Consumer;

public class CallbackAnimation extends Animation {

	private Consumer<? super Animation> onUpdate;
	private Consumer<? super Animation> onEnd;

	public CallbackAnimation(Easing easing, int ttl, Consumer<? super Animation> onEnd, Consumer<? super Animation> onUpdate) 
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

	@Override
	public void end() {
		if (onEnd != null) {
			onEnd.accept(this);
		}		

	}

}
