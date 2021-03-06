package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.player.Player;

public interface TerminalWall extends InternalTerminalWall, Collidable {
	
	public Player getPlayer();

}
