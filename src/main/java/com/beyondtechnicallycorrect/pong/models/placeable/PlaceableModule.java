package com.beyondtechnicallycorrect.pong.models.placeable;

import com.google.inject.AbstractModule;

final class PlaceableModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PlaceableBehaviour.class).to(PlaceableBehaviourImpl.class);
	}

}
