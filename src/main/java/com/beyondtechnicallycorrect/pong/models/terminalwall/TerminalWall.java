package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.player.Player;

public interface TerminalWall extends Placeable {
	
	public Player getPlayer();

}
