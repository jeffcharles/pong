package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.player.Player;

public interface MatchStateSubscriber {
	
	public void matchStarting();
	public void matchEnding(Player winningPlayer);

}
