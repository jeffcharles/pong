package com.beyondtechnicallycorrect.pong.models.frame;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

final class FrameElementImpl implements FrameElement {
	
	private final Collidable m_collidable;
	private final MovableCollidable m_movableCollidable;
	
	public FrameElementImpl(
			MovableCollidable movableCollidable
		) {
		
		m_movableCollidable = movableCollidable;
		m_collidable = movableCollidable;
	}
	
	public FrameElementImpl(
			Collidable collidable
		) {
		
		m_collidable = collidable;
		m_movableCollidable = null;
	}

	@Override
	public boolean isOverlapping(FrameElement element) {
		assert(m_movableCollidable != null);
		Collidable otherElement = element.getUnderlyingCollidable();
		boolean overlapping = m_movableCollidable.isOverlapping(otherElement);
		return overlapping;
	}

	@Override
	public void move() {
		if(m_movableCollidable != null) {
			m_movableCollidable.move();
		}
	}

	@Override
	public void unMove() {
		if(m_movableCollidable != null) {
			m_movableCollidable.unMove();
		}
	}

	@Override
	public void collide(FrameElement collidedWith) {
		Collidable otherElement = collidedWith.getUnderlyingCollidable();
		m_collidable.collide(otherElement);
	}

	@Override
	public Collidable getUnderlyingCollidable() {
		return m_collidable;
	}

}
