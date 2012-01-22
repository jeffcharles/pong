package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class BallImpl implements Ball {
	
	private final InternalBall m_internalBall;
	private final CollisionBehaviours m_collisionBehaviours;
	
	public BallImpl(
			InternalBall internalBall,
			CollisionBehaviours collisionBehaviours
		) {
		
		m_internalBall = internalBall;
		m_collisionBehaviours = collisionBehaviours;
	}

	@Override
	public void collide(Placeable objectCollidedWith) {
		m_collisionBehaviours.collide(objectCollidedWith);
	}

	@Override
	public int getX1() {
		return m_internalBall.getX1();
	}

	@Override
	public int getX2() {
		return m_internalBall.getX2();
	}

	@Override
	public int getY1() {
		return m_internalBall.getY1();
	}

	@Override
	public int getY2() {
		return m_internalBall.getY2();
	}

	@Override
	public boolean isOverlapping(Placeable otherModel) {
		return m_internalBall.isOverlapping(otherModel);
	}

	@Override
	public void move() {
		m_internalBall.move();
	}

	@Override
	public void unMove() {
		m_internalBall.unMove();
	}

}
