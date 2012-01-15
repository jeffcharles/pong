package com.beyondtechnicallycorrect.pong.models.collision;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.wall.Wall;

public final class TestWallCollisionBehaviourImpl {
	
	@Test
	public void testCollide_WhenWallToLeftAndModelMovingLeft_ShouldSetXVelocityToDelegateValue() {
		final int WALL_X2 = 2;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(1, WALL_X2, BOTH_YS, BOTH_YS);
		final int MODEL_X1 = WALL_X2 + 1;
		final int MODEL_X_AMOUNT = -1;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						MODEL_X1,
						MODEL_X1 + 1,
						BOTH_YS,
						BOTH_YS,
						MODEL_X_AMOUNT,
						1,
						0,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_X_AMOUNT = 3;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_X_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model should have its X velocity adjusted",
				NEW_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenWallToRightAndModelMovingRight_ShouldSetXVelocityToDelegateValue() {
		final int WALL_X1 = 3;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(WALL_X1, WALL_X1 + 1, BOTH_YS, BOTH_YS);
		final int MODEL_X2 = WALL_X1 - 1;
		final int MODEL_X_AMOUNT = 1;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						MODEL_X2 - 1,
						MODEL_X2,
						BOTH_YS,
						BOTH_YS,
						MODEL_X_AMOUNT,
						1,
						0,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_X_AMOUNT = -3;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_X_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model should have its X velocity adjusted",
				NEW_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenWallToTopAndModelMovingUp_ShouldSetYVelocityToDelegateValue() {
		final int WALL_Y2 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y2 - 1, WALL_Y2);
		final int MODEL_Y1 = WALL_Y2 + 1;
		final int MODEL_Y_AMOUNT = -1;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						BOTH_XS,
						BOTH_XS,
						MODEL_Y1,
						MODEL_Y1 + 1,
						0,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_Y_AMOUNT = 4;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_Y_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model should have its Y velocity adjusted",
				NEW_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenWallToBottomAndModelMovingDown_ShouldSetYVelocityToDelegateValue() {
		final int WALL_Y1 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y1, WALL_Y1 + 1);
		final int MODEL_Y2 = WALL_Y1 - 1;
		final int MODEL_Y_AMOUNT = 1;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						BOTH_XS,
						BOTH_XS,
						MODEL_Y2 - 1,
						MODEL_Y2,
						0,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_Y_AMOUNT = -4;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_Y_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model should have its Y velocity adjusted",
				NEW_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenMovingLeftAndUpAndWallIsLeft_ShouldSetXVelocityAndKeepYVelocity() {
		final int WALL_X2 = 2;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(1, WALL_X2, BOTH_YS, BOTH_YS);
		final int MODEL_X1 = WALL_X2 + 1;
		final int MODEL_X_AMOUNT = -1;
		final int MODEL_Y_AMOUNT = -2;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						MODEL_X1,
						MODEL_X1 + 1,
						BOTH_YS,
						BOTH_YS,
						MODEL_X_AMOUNT,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_X_AMOUNT = 3;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_X_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model X velocity should have been changed",
				NEW_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
		Assert.assertEquals(
				"Model should still be moving up",
				MODEL_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenMovingLeftAndDownAndWallIsLeft_ShouldSetXVelocityAndKeepYVelocity() {
		final int WALL_X2 = 2;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(1, WALL_X2, BOTH_YS, BOTH_YS);
		final int MODEL_X1 = WALL_X2 + 1;
		final int MODEL_X_AMOUNT = -1;
		final int MODEL_Y_AMOUNT = 2;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						MODEL_X1,
						MODEL_X1 + 1,
						BOTH_YS,
						BOTH_YS,
						MODEL_X_AMOUNT,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_X_AMOUNT = 3;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_X_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model X velocity should have changed",
				NEW_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
		Assert.assertEquals(
				"Model should still be moving down",
				MODEL_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenMovingRightAndUpAndWallIsRight_ShouldSetXVelocityAndKeepYVelocity() {
		final int WALL_X1 = 3;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(WALL_X1, WALL_X1 + 1, BOTH_YS, BOTH_YS);
		final int MODEL_X2 = WALL_X1 - 1;
		final int MODEL_X_AMOUNT = 1;
		final int MODEL_Y_AMOUNT = -2;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						MODEL_X2 - 1,
						MODEL_X2,
						BOTH_YS,
						BOTH_YS,
						MODEL_X_AMOUNT,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_X_AMOUNT = -3;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_X_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model X velocity should be changed",
				NEW_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
		Assert.assertEquals(
				"Model should still be moving up",
				MODEL_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenMovingRightAndDownAndWallIsRight_ShouldSetXVelocityAndKeepYVelocity() {
		final int WALL_X1 = 3;
		final int BOTH_YS = 1;
		Wall wall = new WallStub(WALL_X1, WALL_X1 + 1, BOTH_YS, BOTH_YS);
		final int MODEL_X2 = WALL_X1 - 1;
		final int MODEL_X_AMOUNT = 1;
		final int MODEL_Y_AMOUNT = 2;
		MutableOnCollisionStub model=
				new MutableOnCollisionStub(
						MODEL_X2 - 1,
						MODEL_X2,
						BOTH_YS,
						BOTH_YS,
						MODEL_X_AMOUNT,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_X_AMOUNT = -3;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_X_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model X velocity should have changed",
				NEW_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
		Assert.assertEquals(
				"Model should still be moving down",
				MODEL_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenMovingUpAndLeftAndWallIsAbove_ShouldSetYVelocityAndKeepXVelocity() {
		final int WALL_Y2 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y2 - 1, WALL_Y2);
		final int MODEL_Y1 = WALL_Y2 + 1;
		final int MODEL_X_AMOUNT = -2;
		final int MODEL_Y_AMOUNT = -1;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						BOTH_XS,
						BOTH_XS,
						MODEL_Y1,
						MODEL_Y1 + 1,
						MODEL_X_AMOUNT,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_Y_AMOUNT = 4;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_Y_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model Y velocity should have been changed",
				NEW_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
		Assert.assertEquals(
				"Model should still be moving left",
				MODEL_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenMovingUpAndRightAndWallIsAbove_ShouldSetYVelocityAndKeepXVelocity() {
		final int WALL_Y2 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y2 - 1, WALL_Y2);
		final int MODEL_Y1 = WALL_Y2 + 1;
		final int MODEL_X_AMOUNT = 2;
		final int MODEL_Y_AMOUNT = -1;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						BOTH_XS,
						BOTH_XS,
						MODEL_Y1,
						MODEL_Y1 + 1,
						MODEL_X_AMOUNT,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_Y_AMOUNT = 4;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_Y_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model Y velocity should have been changed",
				NEW_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
		Assert.assertEquals(
				"Model should still be moving right",
				MODEL_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenMovingDownAndLeftAndWallIsBelow_ShouldSetYVelocityAndKeepXVelocity() {
		final int WALL_Y1 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y1, WALL_Y1 + 1);
		final int MODEL_Y2 = WALL_Y1 - 1;
		final int MODEL_X_AMOUNT = -2;
		final int MODEL_Y_AMOUNT = 1;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						BOTH_XS,
						BOTH_XS,
						MODEL_Y2 - 1,
						MODEL_Y2,
						MODEL_X_AMOUNT,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_Y_AMOUNT = 4;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_Y_AMOUNT);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model Y velocity should have been adjusted",
				NEW_Y_AMOUNT, model.getSetVelocityYAmountToMoveArg());
		Assert.assertEquals(
				"Model should still be moving left",
				MODEL_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
	}
	
	@Test
	public void testCollide_WhenMovingDownAndRightAndWallIsBelow_ShouldSetYVelocityAndKeepXVelocity() {
		final int WALL_Y1 = 2;
		final int BOTH_XS = 1;
		Wall wall = new WallStub(BOTH_XS, BOTH_XS, WALL_Y1, WALL_Y1 + 1);
		final int MODEL_Y2 = WALL_Y1 - 1;
		final int MODEL_X_AMOUNT = 2;
		final int MODEL_Y_AMOUNT = 1;
		MutableOnCollisionStub model =
				new MutableOnCollisionStub(
						BOTH_XS,
						BOTH_XS,
						MODEL_Y2 - 1,
						MODEL_Y2,
						MODEL_X_AMOUNT,
						1,
						MODEL_Y_AMOUNT,
						1
					);
		WallCollisionBehaviour cb = new WallCollisionBehaviourImpl();
		
		final int NEW_Y_VELOCITY = -4;
		AdjustVelocityDelegate del =
				new AdjustVelocityDelegateStub(NEW_Y_VELOCITY);
		
		cb.collide(model, wall, del);
		
		Assert.assertTrue(
				"setVelocity should have been called",
				model.getSetVelocityCalled()
			);
		Assert.assertEquals(
				"Model Y velocity should have changed",
				NEW_Y_VELOCITY, model.getSetVelocityYAmountToMoveArg());
		Assert.assertEquals(
				"Model should still be moving right",
				MODEL_X_AMOUNT, model.getSetVelocityXAmountToMoveArg());
	}

}
