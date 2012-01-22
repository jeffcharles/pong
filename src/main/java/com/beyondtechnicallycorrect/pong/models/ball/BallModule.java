package com.beyondtechnicallycorrect.pong.models.ball;

import com.google.inject.AbstractModule;

public final class BallModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BallFactory.class).to(BallFactoryImpl.class);
	}

}
