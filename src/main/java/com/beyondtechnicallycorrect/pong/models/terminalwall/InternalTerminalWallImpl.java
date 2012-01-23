package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.position.Position;

final class InternalTerminalWallImpl implements InternalTerminalWall {
	
	private final Position m_position;
	private final Player m_player;
	
	public InternalTerminalWallImpl(
			Position position,
			Player player
		) {
		
		m_position = position;
		m_player = player;
	}

	@Override
	public int getX1() {
		return m_position.getX1();
	}

	@Override
	public int getX2() {
		return m_position.getX2();
	}

	@Override
	public int getY1() {
		return m_position.getY1();
	}

	@Override
	public int getY2() {
		return m_position.getY2();
	}

	@Override
	public Player getPlayer() {
		return m_player;
	}

}
