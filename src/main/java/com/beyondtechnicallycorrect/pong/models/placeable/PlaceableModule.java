package com.beyondtechnicallycorrect.pong.models.placeable;

import com.google.inject.AbstractModule;

public final class PlaceableModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(OverlappingBehaviour.class).to(OverlappingBehaviourImpl.class);
	}

}
