package com.beyondtechnicallycorrect.pong.models.movement;

import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityBehaviour;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityResult;

final class MovementBehaviourImpl implements MovementBehaviour {

	private final PositionFactory m_positionFactory;
	
	public MovementBehaviourImpl(
			PositionFactory positionFactory
		) {
		
		m_positionFactory = positionFactory;
	}
	
	@Override
	public Position move(Position startingPosition, VelocityBehaviour velocity) {
		VelocityResult result = velocity.move();
		int endingX1 = startingPosition.getX1() + result.getXAmountMoved();
		int endingX2 = startingPosition.getX2() + result.getXAmountMoved();
		int endingY1 = startingPosition.getY1() + result.getYAmountMoved();
		int endingY2 = startingPosition.getY2() + result.getYAmountMoved();
		Position endingPosition = 
				m_positionFactory.create(
						endingX1, endingX2, endingY1, endingY2);
		return endingPosition;
	}

	@Override
	public Position unMove(Position endingPosition, VelocityBehaviour velocity) {
		VelocityResult result = velocity.unMove();
		int startingX1 = endingPosition.getX1() + result.getXAmountMoved();
		int startingX2 = endingPosition.getX2() + result.getXAmountMoved();
		int startingY1 = endingPosition.getY1() + result.getYAmountMoved();
		int startingY2 = endingPosition.getY2() + result.getYAmountMoved();
		Position startingPosition =
				m_positionFactory.create(
						startingX1, startingX2, startingY1, startingY2);
		return startingPosition;
	}

}
