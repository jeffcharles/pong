package com.beyondtechnicallycorrect.pong.models.frame;

import com.google.inject.AbstractModule;

public final class FrameModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FrameRunner.class).to(FrameRunnerImpl.class);
		bind(FrameProcessorFactory.class).to(FrameProcessorFactoryImpl.class);
	}

}
