package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.player.Player;

final class TerminalWallImpl implements TerminalWall {
	
	private final InternalTerminalWall m_internalTerminalWall;
	private final CollisionBehaviours m_collisionBehaviours;
	
	public TerminalWallImpl(
			InternalTerminalWall internalTerminalWall,
			CollisionBehaviours collisionBehaviours
		) {
		
		m_internalTerminalWall = internalTerminalWall;
		m_collisionBehaviours = collisionBehaviours;
	}

	@Override
	public int getX1() {
		return m_internalTerminalWall.getX1();
	}

	@Override
	public int getX2() {
		return m_internalTerminalWall.getX2();
	}

	@Override
	public int getY1() {
		return m_internalTerminalWall.getY1();
	}

	@Override
	public int getY2() {
		return m_internalTerminalWall.getY2();
	}

	@Override
	public Player getPlayer() {
		return m_internalTerminalWall.getPlayer();
	}

	@Override
	public void collide(Placeable objectCollidedWith) {
		m_collisionBehaviours.collide(objectCollidedWith);
	}

}
