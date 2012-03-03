package com.beyondtechnicallycorrect.pong.models.game;

import java.util.ArrayList;
import java.util.Collection;

import com.beyondtechnicallycorrect.pong.models.player.Player;

final class MatchStateNotificationService implements MatchStatePublisher,
		MatchStateSubscription {
	
	private final Collection<MatchStateSubscriber> m_subscribers;

	public MatchStateNotificationService() {
		m_subscribers = new ArrayList<MatchStateSubscriber>();
	}
	
	@Override
	public void subscribe(MatchStateSubscriber subscriber) {
		m_subscribers.add(subscriber);
	}

	@Override
	public void publishMatchStarting() {
		for(MatchStateSubscriber subscriber : m_subscribers) {
			subscriber.matchStarting();
		}
	}
	
	@Override
	public void publishMatchEndingWithNoWinner() {
		for(MatchStateSubscriber subscriber : m_subscribers) {
			subscriber.matchEndingWithNoWinner();
		}
	}

	@Override
	public void publishMatchEndingWithWinner(Player winningPlayer) {
		for(MatchStateSubscriber subscriber : m_subscribers) {
			subscriber.matchEndingWithWinner(winningPlayer);
		}
	}

}
