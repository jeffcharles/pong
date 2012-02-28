package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

interface CollidableToElementAdaptor {
	
	public Element getElementFromCollidable(Collidable collidable);
	public MovableElement getMovableElementFromMovableCollidable(
			MovableCollidable movableCollidable
		);

}
