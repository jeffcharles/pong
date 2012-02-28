package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

final class CollidableToElementAdaptorStub implements
		CollidableToElementAdaptor {

	@Override
	public Element getElementFromCollidable(Collidable collidable) {
		return getMovableElementFromCollidable(collidable);
	}

	@Override
	public MovableElement getMovableElementFromMovableCollidable(
			MovableCollidable movableCollidable
		) {
		
		return getMovableElementFromCollidable(movableCollidable);
	}
	
	private MovableElement getMovableElementFromCollidable(
			Collidable collidable
		) {
		
		MovableElement elem = new MovableElementStub(collidable.getX1());
		return elem;
	}

}
