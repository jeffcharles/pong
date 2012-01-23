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
	public void testBroadcastMatchEnding() {
		MatchStateNotificationService service =
				new MatchStateNotificationService();
		MatchStateSubscriber subscriber = mock(MatchStateSubscriber.class);
		service.subscribe(subscriber);
		Player player = new PlayerStub();
		service.publishMatchEnding(player);
		verify(subscriber).matchEnding(player);
	}

}
