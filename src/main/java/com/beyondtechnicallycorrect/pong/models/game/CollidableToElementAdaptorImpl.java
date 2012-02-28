package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

final class CollidableToElementAdaptorImpl implements
		CollidableToElementAdaptor {

	@Override
	public Element getElementFromCollidable(Collidable collidable) {
		Element elem = new ElementImpl(
				collidable.getX1(),
				collidable.getX2(),
				collidable.getY1(),
				collidable.getY2()
			);
		return elem;
	}

	@Override
	public MovableElement getMovableElementFromMovableCollidable(
			MovableCollidable movableCollidable
		) {
		
		assert(movableCollidable.getXFramesPerMove() != 0);
		assert(movableCollidable.getYFramesPerMove() != 0);
		
		double xVelocity =
				(double)movableCollidable.getXAmountToMove() /
				movableCollidable.getXFramesPerMove();
		double yVelocity =
				(double)movableCollidable.getYAmountToMove() /
				movableCollidable.getYFramesPerMove();
		MovableElement me = new MovableElementImpl(
				movableCollidable.getX1(),
				movableCollidable.getX2(),
				movableCollidable.getY1(),
				movableCollidable.getY2(),
				xVelocity,
				yVelocity
			);
		
		return me;
	}

}
