package com.beyondtechnicallycorrect.pong.models.game;

import java.util.ArrayList;
import java.util.Collection;

public class CourtViewModelChangeNotification implements
		CourtViewModelChangePublisher, CourtViewModelSubscription {

	private final Collection<CourtViewModelSubscriber> m_subscribers;
	
	public CourtViewModelChangeNotification() {
		m_subscribers = new ArrayList<CourtViewModelSubscriber>();
	}
	
	@Override
	public void subscribe(CourtViewModelSubscriber subscriber) {
		m_subscribers.add(subscriber);
	}

	@Override
	public void viewModelChange() {
		for(CourtViewModelSubscriber subscriber : m_subscribers) {
			subscriber.onViewModelChange();
		}
	}

}
