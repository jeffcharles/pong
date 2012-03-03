package com.beyondtechnicallycorrect.pong.models.player;

import com.beyondtechnicallycorrect.pong.models.game.MatchStateSubscriber;

public class ScoringSubscriber implements MatchStateSubscriber {

	@Override
	public void matchStarting() {
		// do nothing
	}

	@Override
	public void matchEnding(Player winningPlayer) {
		winningPlayer.incrementScore();
	}

}
