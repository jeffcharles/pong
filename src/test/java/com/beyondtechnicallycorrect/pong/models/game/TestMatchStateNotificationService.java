package com.beyondtechnicallycorrect.pong.models.game;

import static org.mockito.Mockito.*;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.player.Player;

public final class TestMatchStateNotificationService {
	
	@Test
	public void testBroadcastMatchStarting() {
		MatchStateNotificationService service =
				new MatchStateNotificationService();
		MatchStateSubscriber subscriber = mock(MatchStateSubscriber.class);
		service.subscribe(subscriber);
		service.publishMatchStarting();
		verify(subscriber).matchStarting();
	}
	
	@Test
	public void testBroadcastMatchEndingWithNoWinner() {
		MatchStateNotificationService service =
				new MatchStateNotificationService();
		MatchStateSubscriber subscriber = mock(MatchStateSubscriber.class);
		service.subscribe(subscriber);
		service.publishMatchEndingWithNoWinner();
		verify(subscriber).matchEndingWithNoWinner();
	}
	
	@Test
	public void testBroadcastMatchEndingWithWinner() {
		MatchStateNotificationService service =
				new MatchStateNotificationService();
		MatchStateSubscriber subscriber = mock(MatchStateSubscriber.class);
		service.subscribe(subscriber);
		Player player = new PlayerStub();
		service.publishMatchEndingWithWinner(player);
		verify(subscriber).matchEndingWithWinner(player);
	}

}
