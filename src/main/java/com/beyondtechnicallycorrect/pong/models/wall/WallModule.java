package com.beyondtechnicallycorrect.pong.models.wall;

import com.google.inject.AbstractModule;

public final class WallModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(WallFactory.class).to(WallFactoryImpl.class);
	}

}
