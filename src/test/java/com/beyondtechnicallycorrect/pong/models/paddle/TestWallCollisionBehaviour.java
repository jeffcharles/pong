package com.beyondtechnicallycorrect.pong.models.paddle;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.wall.Wall;

public final class TestWallCollisionBehaviour {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testGetTypeCollidedWith() {
		InternalPaddle paddle = new InternalPaddleStub();
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		Assert.assertEquals(Wall.class, cb.getTypeCollidedWith());
	}
	
	@Test
	public void testCollide_WhenWallToLeftAndPaddleMovingLeft_ShouldSetXVelocityToZero() {
		final int WALL_X2 = 2;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(1, WALL_X2, BOTH_YS, BOTH_YS);
		final int PADDLE_X1 = WALL_X2 + 1;
		final int PADDLE_X_AMOUNT = -1;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						PADDLE_X1,
						PADDLE_X1 + 1,
						BOTH_YS,
						BOTH_YS,
						PADDLE_X_AMOUNT,
						1,
						0,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving left",
				0, paddle.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenWallToRightAndPaddleMovingRight_ShouldSetXVelocityToZero() {
		final int WALL_X1 = 3;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(WALL_X1, WALL_X1 + 1, BOTH_YS, BOTH_YS);
		final int PADDLE_X2 = WALL_X1 - 1;
		final int PADDLE_X_AMOUNT = 1;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						PADDLE_X2 - 1,
						PADDLE_X2,
						BOTH_YS,
						BOTH_YS,
						PADDLE_X_AMOUNT,
						1,
						0,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving right",
				0, paddle.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenWallToTopAndPaddleMovingUp_ShouldSetYVelocityToZero() {
		final int WALL_Y2 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y2 - 1, WALL_Y2);
		final int PADDLE_Y1 = WALL_Y2 + 1;
		final int PADDLE_Y_AMOUNT = -1;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						BOTH_XS,
						BOTH_XS,
						PADDLE_Y1,
						PADDLE_Y1 + 1,
						0,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving up",
				0, paddle.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenWallToBottomAndPaddleMovingDown_ShouldSetYVelocityToZero() {
		final int WALL_Y1 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y1, WALL_Y1 + 1);
		final int PADDLE_Y2 = WALL_Y1 - 1;
		final int PADDLE_Y_AMOUNT = 1;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						BOTH_XS,
						BOTH_XS,
						PADDLE_Y2 - 1,
						PADDLE_Y2,
						0,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving down",
				0, paddle.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollides_WhenMovingLeftAndUpAndWallIsLeft_ShouldSetXVelocityToZeroAndKeepYVelocity() {
		final int WALL_X2 = 2;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(1, WALL_X2, BOTH_YS, BOTH_YS);
		final int PADDLE_X1 = WALL_X2 + 1;
		final int PADDLE_X_AMOUNT = -1;
		final int PADDLE_Y_AMOUNT = -2;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						PADDLE_X1,
						PADDLE_X1 + 1,
						BOTH_YS,
						BOTH_YS,
						PADDLE_X_AMOUNT,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving left",
				0, paddle.getSetVelocityXAmountToMoveArg());
		Assert.assertEquals(
				"Paddle should still be moving up",
				PADDLE_Y_AMOUNT, paddle.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollides_WhenMovingLeftAndDownAndWallIsLeft_ShouldSetXVelocityToZeroAndKeepYVelocity() {
		final int WALL_X2 = 2;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(1, WALL_X2, BOTH_YS, BOTH_YS);
		final int PADDLE_X1 = WALL_X2 + 1;
		final int PADDLE_X_AMOUNT = -1;
		final int PADDLE_Y_AMOUNT = 2;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						PADDLE_X1,
						PADDLE_X1 + 1,
						BOTH_YS,
						BOTH_YS,
						PADDLE_X_AMOUNT,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving left",
				0, paddle.getSetVelocityXAmountToMoveArg());
		Assert.assertEquals(
				"Paddle should still be moving down",
				PADDLE_Y_AMOUNT, paddle.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollides_WhenMovingRightAndUpAndWallIsRight_ShouldSetXVelocityToZeroAndKeepYVelocity() {
		final int WALL_X1 = 3;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(WALL_X1, WALL_X1 + 1, BOTH_YS, BOTH_YS);
		final int PADDLE_X2 = WALL_X1 - 1;
		final int PADDLE_X_AMOUNT = 1;
		final int PADDLE_Y_AMOUNT = -2;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						PADDLE_X2 - 1,
						PADDLE_X2,
						BOTH_YS,
						BOTH_YS,
						PADDLE_X_AMOUNT,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving right",
				0, paddle.getSetVelocityXAmountToMoveArg());
		Assert.assertEquals(
				"Paddle should still be moving up",
				PADDLE_Y_AMOUNT, paddle.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollides_WhenMovingRightAndDownAndWallIsRight_ShouldSetXVelocityToZeroAndKeepYVelocity() {
		final int WALL_X1 = 3;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(WALL_X1, WALL_X1 + 1, BOTH_YS, BOTH_YS);
		final int PADDLE_X2 = WALL_X1 - 1;
		final int PADDLE_X_AMOUNT = 1;
		final int PADDLE_Y_AMOUNT = 2;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						PADDLE_X2 - 1,
						PADDLE_X2,
						BOTH_YS,
						BOTH_YS,
						PADDLE_X_AMOUNT,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving right",
				0, paddle.getSetVelocityXAmountToMoveArg());
		Assert.assertEquals(
				"Paddle should still be moving down",
				PADDLE_Y_AMOUNT, paddle.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollides_WhenMovingUpAndLeftAndWallIsAbove_ShouldSetYVelocityToZeroAndKeepXVelocity() {
		final int WALL_Y2 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y2 - 1, WALL_Y2);
		final int PADDLE_Y1 = WALL_Y2 + 1;
		final int PADDLE_X_AMOUNT = -2;
		final int PADDLE_Y_AMOUNT = -1;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						BOTH_XS,
						BOTH_XS,
						PADDLE_Y1,
						PADDLE_Y1 + 1,
						PADDLE_X_AMOUNT,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving up",
				0, paddle.getSetVelocityYAmountToMoveArg());
		Assert.assertEquals(
				"Paddle should still be moving left",
				PADDLE_X_AMOUNT, paddle.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollides_WhenMovingUpAndRightAndWallIsAbove_ShouldSetYVelocityToZeroAndKeepXVelocity() {
		final int WALL_Y2 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y2 - 1, WALL_Y2);
		final int PADDLE_Y1 = WALL_Y2 + 1;
		final int PADDLE_X_AMOUNT = 2;
		final int PADDLE_Y_AMOUNT = -1;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						BOTH_XS,
						BOTH_XS,
						PADDLE_Y1,
						PADDLE_Y1 + 1,
						PADDLE_X_AMOUNT,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving up",
				0, paddle.getSetVelocityYAmountToMoveArg());
		Assert.assertEquals(
				"Paddle should still be moving right",
				PADDLE_X_AMOUNT, paddle.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollides_WhenMovingDownAndLeftAndWallIsBelow_ShouldSetYVelocityToZeroAndKeepXVelocity() {
		final int WALL_Y1 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y1, WALL_Y1 + 1);
		final int PADDLE_Y2 = WALL_Y1 - 1;
		final int PADDLE_X_AMOUNT = -2;
		final int PADDLE_Y_AMOUNT = 1;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						BOTH_XS,
						BOTH_XS,
						PADDLE_Y2 - 1,
						PADDLE_Y2,
						PADDLE_X_AMOUNT,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving down",
				0, paddle.getSetVelocityYAmountToMoveArg());
		Assert.assertEquals(
				"Paddle Should still be moving left",
				PADDLE_X_AMOUNT, paddle.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollides_WhenMovingDownAndRightAndWallIsBelow_ShouldSetYVelocityToZeroAndKeepXVelocity() {
		final int WALL_Y1 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y1, WALL_Y1 + 1);
		final int PADDLE_Y2 = WALL_Y1 - 1;
		final int PADDLE_X_AMOUNT = 2;
		final int PADDLE_Y_AMOUNT = 1;
		InternalPaddleStub paddle =
				new InternalPaddleStub(
						BOTH_XS,
						BOTH_XS,
						PADDLE_Y2 - 1,
						PADDLE_Y2,
						PADDLE_X_AMOUNT,
						1,
						PADDLE_Y_AMOUNT,
						1
					);
		CollisionBehaviour<Wall> cb = new WallCollisionBehaviour(paddle);
		
		cb.collide(wall);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				paddle.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Paddle should no longer be moving down",
				0, paddle.getSetVelocityYAmountToMoveArg());
		Assert.assertEquals(
				"Paddle Should still be moving right",
				PADDLE_X_AMOUNT, paddle.getSetVelocityXAmountToMoveArg());
	}

}
