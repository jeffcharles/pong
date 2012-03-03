package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.google.inject.AbstractModule;

public class TerminalWallModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(TerminalWallFactory.class).to(TerminalWallFactoryImpl.class);
	}

}
