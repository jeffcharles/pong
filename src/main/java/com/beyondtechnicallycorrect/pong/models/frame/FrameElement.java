package com.beyondtechnicallycorrect.pong.models.frame;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;

interface FrameElement {
	
	public boolean isOverlapping(FrameElement element);
	public void move();
	public void unMove();
	public void collide(FrameElement collidedWith);
	
	Collidable getUnderlyingCollidable();

}
