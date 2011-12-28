package com.beyondtechnicallycorrect.pong.models.velocity;

import com.google.inject.AbstractModule;

public final class VelocityModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Sanitizer.class);
		bind(VelocityFactory.class).to(VelocityFactoryImpl.class);
	}

}
