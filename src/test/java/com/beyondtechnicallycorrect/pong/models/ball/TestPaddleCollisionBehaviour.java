package com.beyondtechnicallycorrect.pong.models.ball;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.paddle.Paddle;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public final class TestPaddleCollisionBehaviour {
	
	@Test
	public void testGetTypeCollidedWith() {
		InternalBall ball = new InternalBallStub();
		CollisionBehaviour<Paddle> pcb = new PaddleCollisionBehaviour(ball);
		Assert.assertEquals(Paddle.class, pcb.getTypeCollidedWith());
	}
	
	@Test
	public void testCollide_WhenBallCentreAboveHorizontalPaddle_ShouldBounceStraightUp() {
		final int BALL_Y_POS = 1;
		final int POSITIVE_Y_VELOCITY = 1;
		InternalBallStub ball = new InternalBallStub(
				1, 1, BALL_Y_POS, BALL_Y_POS, 0, 1, POSITIVE_Y_VELOCITY, 1);
		final int PADDLE_Y_POS = BALL_Y_POS + POSITIVE_Y_VELOCITY;
		Placeable paddle = new PlaceableStub(0, 2, PADDLE_Y_POS, PADDLE_Y_POS);
		CollisionBehaviour<Paddle> pcb = new PaddleCollisionBehaviour(ball);
		
		pcb.collide(paddle);
		
		assertVelocity(0, 1, -6, 5, ball);
	}
	
	@Test
	public void testCollide_WhenBallCentreBelowHorizontalPaddle_ShouldBounceStraightDown() {
		final int BALL_Y_POS = 2;
		final int NEGATIVE_Y_VELOCITY = -1;
		InternalBallStub ball = new InternalBallStub(
				1, 1, BALL_Y_POS, BALL_Y_POS, 0, 1, NEGATIVE_Y_VELOCITY, 1);
		final int PADDLE_Y_POS = BALL_Y_POS + NEGATIVE_Y_VELOCITY;
		Placeable paddle = new PlaceableStub(0, 2, PADDLE_Y_POS, PADDLE_Y_POS);
		CollisionBehaviour<Paddle> pcb = new PaddleCollisionBehaviour(ball);
		
		pcb.collide(paddle);
		
		assertVelocity(0, 1, 6, 5, ball);
	}
	
	@Test
	public void testCollide_WhenBallCentreRightOfVerticalPaddle_ShouldBounceStraightLeft() {
		final int BALL_X_POS = 2;
		final int NEGATIVE_X_VELOCITY = -1;
		InternalBallStub ball = new InternalBallStub(
				BALL_X_POS, BALL_X_POS, 1, 1, NEGATIVE_X_VELOCITY, 1, 0, 1);
		final int PADDLE_X_POS = BALL_X_POS + NEGATIVE_X_VELOCITY;
		Placeable paddle = new PlaceableStub(PADDLE_X_POS, PADDLE_X_POS, 0, 2);
		CollisionBehaviour<Paddle> pcb = new PaddleCollisionBehaviour(ball);
		
		pcb.collide(paddle);
		
		assertVelocity(6, 5, 0, 1, ball);
	}
	
	@Test
	public void testCollide_WhenBallCentreLeftOfVerticalPaddle_ShouldBounceStraightRight() {
		final int BALL_X_POS = 1;
		final int POSITIVE_X_VELOCITY = 1;
		InternalBallStub ball = new InternalBallStub(
				BALL_X_POS, BALL_X_POS, 1, 1, POSITIVE_X_VELOCITY, 1, 0, 1);
		final int PADDLE_X_POS = BALL_X_POS + POSITIVE_X_VELOCITY;
		Placeable paddle = new PlaceableStub(PADDLE_X_POS, PADDLE_X_POS, 0, 2);
		CollisionBehaviour<Paddle> pcb = new PaddleCollisionBehaviour(ball);
		
		pcb.collide(paddle);
		
		assertVelocity(-6, 5, 0, 1, ball);
	}
	
	@Test
	public void testCollide_WhenBallLeftOfBottomHorizontalPaddle_ShouldBounceToLeft() {
		InternalBallStub ball = new InternalBallStub(1, 1, 1, 1, 2, 1, 2, 1);
		Placeable paddle = new PlaceableStub(0, 8, 3, 3);
		CollisionBehaviour<Paddle> pcb = new PaddleCollisionBehaviour(ball);
		
		pcb.collide(paddle);
		
		assertVelocity(-3, 1, -12, 5, ball);
	}
	
	@Test
	public void testCollide_WhenBallBottomOfLeftVerticalPaddle_ShouldBounceDown() {
		InternalBallStub ball = new InternalBallStub(3, 3, 7, 7, -2, 1, -2, 1);
		Placeable paddle = new PlaceableStub(1, 1, 0, 8);
		CollisionBehaviour<Paddle> pcb = new PaddleCollisionBehaviour(ball);
		
		pcb.collide(paddle);
		
		assertVelocity(12, 5, 3, 1, ball);
	}
	
	private void assertVelocity(
			int expectedXAmount,
			int expectedXFrames,
			int expectedYAmount,
			int expectedYFrames,
			InternalBallStub ball
		) {
		
		Assert.assertEquals(
				"X amount should match",
				expectedXAmount, ball.getSetVelocityXAmountArg()
			);
		Assert.assertEquals(
				"X frames should match",
				expectedXFrames, ball.getSetVelocityXFramesArg()
			);
		Assert.assertEquals(
				"Y amount should match",
				expectedYAmount, ball.getSetVelocityYAmountArg()
			);
		Assert.assertEquals(
				"Y frames should match",
				expectedYFrames, ball.getSetVelocityYFramesArg()
			);
	}

}
