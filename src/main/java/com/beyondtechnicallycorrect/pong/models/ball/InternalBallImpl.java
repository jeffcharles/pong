package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.movement.MovementBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.OverlappingBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;

final class InternalBallImpl implements InternalBall {
	
	private final VelocityFactory m_velocityFactory;
	private final OverlappingBehaviour m_overlappingBehaviour;
	private final MovementBehaviour m_movementBehaviour;
	
	private Position m_position;
	private Velocity m_velocity;
	
	public InternalBallImpl(
			VelocityFactory velocityFactory,
			OverlappingBehaviour overlappingBehaviour,
			MovementBehaviour movementBehaviour,
			Position position,
			Velocity velocity
		) {
		
		m_velocityFactory = velocityFactory;
		m_overlappingBehaviour = overlappingBehaviour;
		m_movementBehaviour = movementBehaviour;
		m_position = position;
		m_velocity = velocity;
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
	public boolean isOverlapping(Placeable otherModel) {
		return m_overlappingBehaviour.isOverlap(otherModel, m_position);
	}

	@Override
	public void move() {
		m_position = m_movementBehaviour.move(m_position, m_velocity);
	}

	@Override
	public void unMove() {
		m_position = m_movementBehaviour.unMove(m_position, m_velocity);
	}

	@Override
	public int getXAmountToMove() {
		return m_velocity.getXAmountToMove();
	}

	@Override
	public int getXFramesPerMove() {
		return m_velocity.getXFramesPerMove();
	}

	@Override
	public int getYAmountToMove() {
		return m_velocity.getYAmountToMove();
	}

	@Override
	public int getYFramesPerMove() {
		return m_velocity.getYFramesPerMove();
	}

	@Override
	public void setVelocity(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		) {

		m_velocity = m_velocityFactory.create(
				xAmountToMove,
				xFramesPerMove,
				yAmountToMove,
				yFramesPerMove
			);
	}

}
