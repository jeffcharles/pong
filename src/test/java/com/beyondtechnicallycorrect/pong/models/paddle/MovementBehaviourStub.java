package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.movement.MovementBehaviour;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityBehaviour;

final class MovementBehaviourStub implements MovementBehaviour {
	
	private final Position m_endingPos;
	private final Position m_startingPos;
	
	public MovementBehaviourStub() {
		m_endingPos = null;
		m_startingPos = null;
	}
	
	public MovementBehaviourStub(
			Position endingPos
		) {
		
		m_endingPos = endingPos;
		m_startingPos = null;
	}
	
	public MovementBehaviourStub(
			Position startingPos,
			String randomJunkSoCompilerDoesntComplain
		) {
		
		m_endingPos = null;
		m_startingPos = startingPos;
	}

	@Override
	public Position move(Position startingPosition, VelocityBehaviour velocity) {
		return m_endingPos;
	}

	@Override
	public Position unMove(Position endingPosition, VelocityBehaviour velocity) {
		return m_startingPos;
	}

}
