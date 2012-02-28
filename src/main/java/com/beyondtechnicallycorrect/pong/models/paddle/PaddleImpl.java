package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class PaddleImpl implements Paddle {

	private final InternalPaddle m_internalPaddle;
	private final CollisionBehaviours m_collisionBehaviours;
	
	public PaddleImpl(
			InternalPaddle internalPaddle,
			CollisionBehaviours collisionBehaviours
		) {
		
		m_internalPaddle = internalPaddle;
		m_collisionBehaviours = collisionBehaviours;
	}
	
	@Override
	public void move() {
		m_internalPaddle.move();
	}

	@Override
	public void unMove() {
		m_internalPaddle.unMove();
	}

	@Override
	public boolean isOverlapping(Placeable otherModel) {
		boolean overlapping = m_internalPaddle.isOverlapping(otherModel);
		return overlapping;
	}

	@Override
	public void collide(Placeable objectCollidedWith) {
		m_collisionBehaviours.collide(objectCollidedWith);
	}

	@Override
	public int getX1() {
		return m_internalPaddle.getX1();
	}

	@Override
	public int getX2() {
		return m_internalPaddle.getX2();
	}

	@Override
	public int getY1() {
		return m_internalPaddle.getY1();
	}

	@Override
	public int getY2() {
		return m_internalPaddle.getY2();
	}

	@Override
	public int getXAmountToMove() {
		return m_internalPaddle.getXAmountToMove();
	}

	@Override
	public int getXFramesPerMove() {
		return m_internalPaddle.getXFramesPerMove();
	}

	@Override
	public int getYAmountToMove() {
		return m_internalPaddle.getYAmountToMove();
	}

	@Override
	public int getYFramesPerMove() {
		return m_internalPaddle.getYFramesPerMove();
	}

}
