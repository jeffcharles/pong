package com.beyondtechnicallycorrect.pong.ai;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.game.MovableElement;

public final class TestBallDestinationCalculatorImpl {
	
	@Test
	public void getXPosition_WhenBallIsOnTopOfPaddleAndHeadingStraightDown_ShouldReturnMiddleOfBall() {
		final int COURT_WIDTH = 1000;
		final int WALL_THICKNESS = 15;
		final int PADDLE_Y1 = 900;
		final int BALL_X1 = 495;
		final int BALL_X2 = 505;
		final double BALL_X_VELOCITY = 0.0;
		final double BALL_Y_VELOCITY = 3.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						0,
						5,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(500, destX);
	}
	
	@Test
	public void getXPosition_WhenBallIsMovingLeftWithNoWallCollisions() {
		final int COURT_WIDTH = 1000;
		final int WALL_THICKNESS = 15;
		final int PADDLE_Y1 = 20;
		final int BALL_X1 = 300;
		final int BALL_X2 = 310;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = -1.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(295, destX);
	}
	
	@Test
	public void getXPosition_WhenBallIsMovingRightWithNoWallCollisions() {
		final int COURT_WIDTH = 1000;
		final int WALL_THICKNESS = 15;
		final int PADDLE_Y1 = 20;
		final int BALL_X1 = 300;
		final int BALL_X2 = 310;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = 1.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(315, destX);
	}
	
	@Test
	public void getXPosition_WhenBallIsMovingLeftWithOneWallCollision() {
		final int COURT_WIDTH = 1000;
		final int WALL_THICKNESS = 15;
		final int PADDLE_Y1 = 50;
		final int BALL_X1 = 100;
		final int BALL_X2 = 110;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = -3.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(45, destX);
	}
	
	@Test
	public void getXPosition_WhenBallIsMovingRightWithOneWallCollision() {
		final int COURT_WIDTH = 1000;
		final int WALL_THICKNESS = 15;
		final int PADDLE_Y1 = 50;
		final int BALL_X1 = 890;
		final int BALL_X2 = 900;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = 3.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(955, destX);
	}
	
	@Test
	public void getXPosition_WhenBallIsMovingRightFromLeftSideWithOneWallCollision() {
		final int COURT_WIDTH = 100;
		final int WALL_THICKNESS = 10;
		final int PADDLE_Y1 = 30;
		final int BALL_X1 = 20;
		final int BALL_X2 = 30;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = 5.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(55, destX);
	}
	
	@Test
	public void getXPosition_WhenBallIsMovingLeftWithTwoWallCollisions() {
		final int COURT_WIDTH = 100;
		final int WALL_THICKNESS = 10;
		final int PADDLE_Y1 = 30;
		final int BALL_X1 = 20;
		final int BALL_X2 = 30;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = -5.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(85, destX);
	}
	
	@Test
	public void getXPosition_WhenBallIsMovingRightWithTwoWallCollisions() {
		final int COURT_WIDTH = 100;
		final int WALL_THICKNESS = 10;
		final int PADDLE_Y1 = 30;
		final int BALL_X1 = 70;
		final int BALL_X2 = 80;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = 5.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(15, destX);
	}
	
	@Test
	public void getXPosition_WhenThreeWallCollisions() {
		final int COURT_WIDTH = 100;
		final int WALL_THICKNESS = 10;
		final int PADDLE_Y1 = 46;
		final int BALL_X1 = 70;
		final int BALL_X2 = 80;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = 5.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(85, destX);
	}
	
	@Test
	public void getXPosition_WhenFourWallCollisions() {
		final int COURT_WIDTH = 100;
		final int WALL_THICKNESS = 10;
		final int PADDLE_Y1 = 62;
		final int BALL_X1 = 70;
		final int BALL_X2 = 80;
		final int BALL_Y1 = 0;
		final int BALL_Y2 = 10;
		final double BALL_X_VELOCITY = 5.0;
		final double BALL_Y_VELOCITY = 1.0;
		MovableElement ball =
				new MovableElementStub(
						BALL_X1,
						BALL_X2,
						BALL_Y1,
						BALL_Y2,
						BALL_X_VELOCITY,
						BALL_Y_VELOCITY
					);
		BallDestinationCalculator destCalc =
				new BallDestinationCalculatorImpl();
		
		int destX =
				destCalc.getXPositionOfBallDestination(
						COURT_WIDTH,
						WALL_THICKNESS,
						PADDLE_Y1,
						ball
					);
		
		Assert.assertEquals(15, destX);
	}

}
