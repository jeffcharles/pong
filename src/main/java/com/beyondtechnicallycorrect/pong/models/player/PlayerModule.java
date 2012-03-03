package com.beyondtechnicallycorrect.pong.models.player;

import com.google.inject.AbstractModule;

public final class PlayerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Player.class).to(PlayerImpl.class);
	}

}
