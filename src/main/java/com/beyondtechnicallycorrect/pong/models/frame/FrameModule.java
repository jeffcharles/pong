package com.beyondtechnicallycorrect.pong.models.frame;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public final class FrameModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FrameRunner.class).to(FrameRunnerImpl.class).in(Singleton.class);
		bind(FrameProcessorFactory.class).to(FrameProcessorFactoryImpl.class);
	}

}
