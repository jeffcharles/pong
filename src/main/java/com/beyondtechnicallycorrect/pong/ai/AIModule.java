package com.beyondtechnicallycorrect.pong.ai;

import com.google.inject.AbstractModule;

public final class AIModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BallDestinationCalculator.class).to(BallDestinationCalculatorImpl.class);
		bind(AIRunnerFactory.class).to(AIRunnerFactoryImpl.class);
	}

}
