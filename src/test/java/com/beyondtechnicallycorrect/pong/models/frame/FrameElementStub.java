package com.beyondtechnicallycorrect.pong.models.frame;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;

final class FrameElementStub implements FrameElement {

	@Override
	public boolean isOverlapping(FrameElement element) {
		// TODO Auto-generated method stub
		return false;
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
	public void collide(FrameElement collidedWith) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collidable getUnderlyingCollidable() {
		// TODO Auto-generated method stub
		return null;
	}

}
