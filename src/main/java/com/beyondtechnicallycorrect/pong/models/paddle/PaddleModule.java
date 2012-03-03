package com.beyondtechnicallycorrect.pong.models.paddle;

import com.google.inject.AbstractModule;

public final class PaddleModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PaddleFactory.class).to(PaddleFactoryImpl.class);
		bind(PaddleInstructionHolder.class).to(PaddleInstructionHolderImpl.class);
	}

}
