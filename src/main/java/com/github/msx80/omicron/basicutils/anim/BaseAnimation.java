package com.github.msx80.omicron.basicutils.anim;

import java.util.function.Consumer;

public abstract class BaseAnimation implements IAnimation {

	Consumer<IAnimation> onEnd = e->{};
	Consumer<IAnimation> onBegin = e->{};

	@Override
	public Consumer<IAnimation> getOnEnd() {
		return onEnd;
	}

	@Override
	public BaseAnimation setOnEnd(Consumer<IAnimation> e) {
		this.onEnd = e;
		return this;
	}

	@Override
	public BaseAnimation setOnBegin(Consumer<IAnimation> e) {
		this.onBegin = e;
		return this;
	}

}
