package com.beyondtechnicallycorrect.pong.models.game;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public final class GameModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MatchStateNotificationService.class).in(Singleton.class);
		bind(MatchStatePublisher.class).to(MatchStateNotificationService.class);
		bind(MatchStateSubscription.class).to(MatchStateNotificationService.class);
		
		bind(CourtViewModelRepository.class).in(Singleton.class);
		bind(CourtViewModelGetter.class).to(CourtViewModelRepository.class);
		bind(CourtViewModelUpdater.class).to(CourtViewModelRepository.class);
		bind(CourtViewModelInitializer.class).to(CourtViewModelRepository.class);
		
		bind(MatchFactory.class).to(MatchFactoryImpl.class);
		
		bind(CollidableToElementAdaptor.class).to(CollidableToElementAdaptorImpl.class);
	}

}
