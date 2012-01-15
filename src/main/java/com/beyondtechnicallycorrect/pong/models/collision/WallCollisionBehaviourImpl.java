package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class WallCollisionBehaviourImpl implements WallCollisionBehaviour {

	@Override
	public void collide(
			MutableOnCollision internalModel,
			Placeable collidedWith,
			AdjustVelocityDelegate adjustVelocityDelegate
		) {
		
		int xAmountToMove = internalModel.getXAmountToMove();
		int yAmountToMove = internalModel.getYAmountToMove();
		
		int currentX1 = internalModel.getX1();
		int currentX2 = internalModel.getX2();
		int currentY1 = internalModel.getY1();
		int currentY2 = internalModel.getY2();
		int wallX1 = collidedWith.getX1();
		int wallX2 = collidedWith.getX2();
		int wallY1 = collidedWith.getY1();
		int wallY2 = collidedWith.getY2();
		boolean wallToLeft = wallX2 < currentX1;
		boolean wallToRight = currentX2 < wallX1;
		boolean wallToTop = wallY2 < currentY1;
		boolean wallToBottom = currentY2 < wallY1;
			
		int newXAmountToMove = wallToLeft || wallToRight ?
				adjustVelocityDelegate.getAdjustedAmountToMove(xAmountToMove) :
				xAmountToMove;
		int newYAmountToMove = wallToTop || wallToBottom ?
				adjustVelocityDelegate.getAdjustedAmountToMove(yAmountToMove) :
				yAmountToMove;
		int xFramesPerMove = internalModel.getXFramesPerMove();
		int yFramesPerMove = internalModel.getYFramesPerMove();
		
		// some part of the velocity should be changing
		assert(newXAmountToMove != xAmountToMove ||
				newYAmountToMove != yAmountToMove);
		
		internalModel.setVelocity(
				newXAmountToMove,
				xFramesPerMove,
				newYAmountToMove,
				yFramesPerMove
			);
	}

}
