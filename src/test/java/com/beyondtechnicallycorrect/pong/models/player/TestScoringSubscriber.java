package com.beyondtechnicallycorrect.pong.models.player;

import static org.mockito.Mockito.*;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.game.MatchStateSubscriber;

public final class TestScoringSubscriber {
	
	@Test
	public void matchEnding_ShouldIncrementWinningPlayersScore() {
		MatchStateSubscriber subscriber = new ScoringSubscriber();
		
		Player winningPlayer = mock(Player.class);
		
		subscriber.matchEndingWithWinner(winningPlayer);
		
		verify(winningPlayer).incrementScore();
	}

}
