package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.player.Player;

public interface MatchStatePublisher {
	
	public void publishMatchStarting();
	public void publishMatchEnding(Player winningPlayer);

}
