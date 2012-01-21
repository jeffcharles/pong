package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.paddle.Paddle;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class PaddleCollisionBehaviour implements CollisionBehaviour<Paddle> {

	private final InternalBall m_internalBall;
	
	public PaddleCollisionBehaviour(
			InternalBall internalBall
		) {
		
		m_internalBall = internalBall;
	}
	
	@Override
	public Class<Paddle> getTypeCollidedWith() {
		return Paddle.class;
	}

	@Override
	public void collide(Placeable collidedWith) {
		int ballX1 = m_internalBall.getX1();
		int ballX2 = m_internalBall.getX2();
		int ballY1 = m_internalBall.getY1();
		int ballY2 = m_internalBall.getY2();
		
		int paddleX1 = collidedWith.getX1();
		int paddleX2 = collidedWith.getX2();
		int paddleY1 = collidedWith.getY1();
		int paddleY2 = collidedWith.getY2();
		
		int paddleHorizontalSize = paddleX2 - paddleX1;
		int paddleVerticalSize = paddleY2 - paddleY1;
		
		// not exactly sure what should happen with a square paddle
		assert(paddleHorizontalSize != paddleVerticalSize);
		
		boolean paddleWider = paddleHorizontalSize > paddleVerticalSize;
		boolean paddleTaller = paddleVerticalSize > paddleHorizontalSize;
		
		int ballXAmount = m_internalBall.getXAmountToMove();
		int ballYAmount = m_internalBall.getYAmountToMove();
		
		int ballCentre = paddleWider ?
				(ballX1 + ballX2) / 2 :
				(ballY1 + ballY2) / 2;
		
		int distanceFromCentreOfPaddle = paddleWider ?
				ballCentre - (paddleX1 + paddleHorizontalSize / 2) :
				ballCentre - (paddleY1 + paddleVerticalSize / 2);
		
		int ballXFrames = m_internalBall.getXFramesPerMove();
		int ballYFrames = m_internalBall.getYFramesPerMove();
		
		// add 20% to the velocity
		final int MULTIPLIER = 100 / 20;
		
		int newXAmount = paddleTaller ?
				-ballXAmount * (1 + MULTIPLIER) :
				distanceFromCentreOfPaddle;
		int newYAmount = paddleWider ?
				-ballYAmount * (1 + MULTIPLIER) :
				distanceFromCentreOfPaddle;
		
		int newXFrames = paddleTaller ?
				ballXFrames * MULTIPLIER : ballXFrames;
		int newYFrames = paddleWider ?
				ballYFrames * MULTIPLIER : ballYFrames;
		
		m_internalBall.setVelocity(
				newXAmount,
				newXFrames,
				newYAmount,
				newYFrames
			);
	}

}
