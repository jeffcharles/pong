package com.beyondtechnicallycorrect.pong.models.position;

import com.google.inject.AbstractModule;

public final class PositionModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PositionFactory.class).to(PositionFactoryImpl.class);
	}

}
