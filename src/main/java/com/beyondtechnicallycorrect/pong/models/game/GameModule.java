package com.beyondtechnicallycorrect.pong.models.game;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public final class GameModule extends AbstractModule {
	
	private MatchStateNotificationService m_service;

	@Override
	protected void configure() {
		
	}
	
	@Provides
	public MatchStatePublisher providePublisher() {
		if(m_service == null) {
			m_service = new MatchStateNotificationService();
		}
		return m_service;
	}
	
	@Provides
	public MatchStateSubscription provideSubscription() {
		if(m_service == null) {
			m_service = new MatchStateNotificationService();
		}
		return m_service;
	}

}
