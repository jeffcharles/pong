package com.beyondtechnicallycorrect.pong.models.frame;

import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class MovableCollidableStub implements MovableCollidable {

	private final boolean m_isOverlapping;
	
	public MovableCollidableStub() {
		m_isOverlapping = false;
	}
	
	public MovableCollidableStub(
			boolean isOverlapping
		) {
		
		m_isOverlapping = isOverlapping;
	}
	
	@Override
	public void collide(Placeable objectCollidedWith) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isOverlapping(Placeable otherModel) {
		return m_isOverlapping;
	}

	@Override
	public int getXAmountToMove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getXFramesPerMove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYAmountToMove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYFramesPerMove() {
		// TODO Auto-generated method stub
		return 0;
	}

}
