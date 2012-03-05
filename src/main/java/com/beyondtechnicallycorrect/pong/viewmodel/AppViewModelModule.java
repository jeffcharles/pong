package com.beyondtechnicallycorrect.pong.viewmodel;

import com.google.inject.AbstractModule;

public final class AppViewModelModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AppViewModelFactory.class).to(AppViewModelFactoryImpl.class);
	}

}
