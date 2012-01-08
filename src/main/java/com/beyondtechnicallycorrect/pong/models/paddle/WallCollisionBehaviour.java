package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.wall.Wall;

final class WallCollisionBehaviour implements CollisionBehaviour<Wall> {

	private final InternalPaddle m_internalPaddle;
	
	public WallCollisionBehaviour(
			InternalPaddle internalPaddle
		) {
		
		m_internalPaddle = internalPaddle;
	}
	
	@Override
	public Class<Wall> getTypeCollidedWith() {
		return Wall.class;
	}

	/**
	 * Stop the paddle from moving in whatever direction it was
	 * moving in that caused the collision
	 */
	@Override
	public void collide(Placeable collidedWith) {
		int xAmountToMove = m_internalPaddle.getXAmountToMove();
		int yAmountToMove = m_internalPaddle.getYAmountToMove();
		
		int currentX1 = m_internalPaddle.getX1();
		int currentX2 = m_internalPaddle.getX2();
		int currentY1 = m_internalPaddle.getY1();
		int currentY2 = m_internalPaddle.getY2();
		int wallX1 = collidedWith.getX1();
		int wallX2 = collidedWith.getX2();
		int wallY1 = collidedWith.getY1();
		int wallY2 = collidedWith.getY2();
		boolean wallToLeft = wallX2 < currentX1;
		boolean wallToRight = currentX2 < wallX1;
		boolean wallToTop = wallY2 < currentY1;
		boolean wallToBottom = currentY2 < wallY1;
			
		int newXAmountToMove = wallToLeft || wallToRight ? 0 : xAmountToMove;
		int newYAmountToMove = wallToTop || wallToBottom ? 0 : yAmountToMove;
		int xFramesPerMove = m_internalPaddle.getXFramesPerMove();
		int yFramesPerMove = m_internalPaddle.getYFramesPerMove();
		
		// some part of the velocity should be changing
		assert(newXAmountToMove != xAmountToMove ||
				newYAmountToMove != yAmountToMove);
		
		m_internalPaddle.setVelocity(
				newXAmountToMove,
				xFramesPerMove,
				newYAmountToMove,
				yFramesPerMove
			);
	}

}
