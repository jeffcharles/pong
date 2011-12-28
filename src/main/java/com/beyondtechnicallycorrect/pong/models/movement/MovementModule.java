package com.beyondtechnicallycorrect.pong.models.movement;

import com.google.inject.AbstractModule;

public final class MovementModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MovementBehaviour.class).to(MovementBehaviourImpl.class);
	}

}
