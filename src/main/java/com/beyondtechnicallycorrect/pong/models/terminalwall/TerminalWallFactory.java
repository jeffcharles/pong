package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.player.Player;

public interface TerminalWallFactory {
	
	public TerminalWall create(
			int x1,
			int x2,
			int y1,
			int y2,
			Player player
		);

}
