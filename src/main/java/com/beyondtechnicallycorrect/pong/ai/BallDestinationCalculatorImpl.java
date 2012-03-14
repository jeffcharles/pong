package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.models.game.MovableElement;

public class BallDestinationCalculatorImpl implements BallDestinationCalculator {
	
	@Override
	public int getXPositionOfBallDestination(
			int fullCourtWidth,
			int wallThickness,
			int paddleY1,
			MovableElement ball
		) {
		
		assert(ball.getYVelocity() > 0);
		
		int courtWidth = fullCourtWidth - 2 * wallThickness;
		int middleOfBall = (ball.getX1() + ball.getX2()) / 2;
		int framesToCollision =
				(int)((paddleY1 - ball.getY2()) / Math.abs(ball.getYVelocity()));
		int ballXVelocity = (int)ball.getXVelocity();
		int numOfWallCollisions =
				calculateNumberOfWallCollisions(
						courtWidth,
						wallThickness,
						framesToCollision,
						middleOfBall,
						ballXVelocity
					);
		final int DEFAULT_COLLIDING_X = fullCourtWidth / 2;
		int collidingX = DEFAULT_COLLIDING_X;
		if(numOfWallCollisions < 1) {
			collidingX =
					middleOfBall + (framesToCollision * ballXVelocity);
		} else {
			int framesToCrossCourt = courtWidth / Math.abs(ballXVelocity);
			if(numOfWallCollisions > 1 && numOfWallCollisions % 2 == 1) {
				framesToCollision %= framesToCrossCourt;
				numOfWallCollisions = 1;
			}
			if(numOfWallCollisions > 2 && numOfWallCollisions % 2 == 0) {
				framesToCollision %= framesToCrossCourt;
				framesToCollision += framesToCrossCourt;
				numOfWallCollisions = 2;
			}
			int framesToWall =
					ballXVelocity > 0 ?
							(fullCourtWidth - wallThickness - middleOfBall) / ballXVelocity :
							(middleOfBall - wallThickness) / Math.abs(ballXVelocity);
			if(numOfWallCollisions == 1) {
				collidingX =
						middleOfBall + ballXVelocity * (2 * framesToWall - framesToCollision);
			} else if(numOfWallCollisions == 2) {
				boolean firstWallCollisionOnRight = ballXVelocity > 0;
				int remainingFrames =
						framesToCollision - framesToWall - framesToCrossCourt;
				if(firstWallCollisionOnRight) {
					collidingX =
							wallThickness + remainingFrames * ballXVelocity;
				} else {
					collidingX =
							courtWidth + wallThickness + (remainingFrames * ballXVelocity);
				}
			}
		}
		return collidingX;
	}
	
	private int calculateNumberOfWallCollisions(
			int courtWidth,
			int wallThickness,
			int framesToCollision,
			int ballX,
			int ballXVelocity
		) {
		
		int totalAmountToMove = (int)(framesToCollision * ballXVelocity);
		int amountUntilWall =
				ballXVelocity > 0 ?
						courtWidth + wallThickness - ballX :
						ballX - wallThickness;
		int amountRemaining =
				Math.abs(totalAmountToMove) > amountUntilWall ?
						totalAmountToMove - amountUntilWall :
						0;
		int numberOfWallCollisions = Math.abs(amountRemaining / courtWidth);
		if(ballX + totalAmountToMove < wallThickness ||
				ballX + totalAmountToMove > courtWidth + wallThickness
			) {
			
			++numberOfWallCollisions;
		}
		return numberOfWallCollisions;
	}

}
