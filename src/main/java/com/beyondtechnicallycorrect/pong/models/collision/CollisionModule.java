package com.beyondtechnicallycorrect.pong.models.collision;

import com.google.inject.AbstractModule;

public final class CollisionModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CollisionBehaviours.class)
			.to(CollisionBehavioursImpl.class);
		bind(OverlappingBehaviour.class).to(OverlappingBehaviourImpl.class);
	}

}
