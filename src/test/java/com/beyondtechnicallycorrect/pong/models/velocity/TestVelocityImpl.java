package com.beyondtechnicallycorrect.pong.models.velocity;

import org.junit.*;

public final class TestVelocityImpl {

	@Test
	public void testGetXAmountToMove() {
		final int AMOUNT_TO_MOVE = 5;
		DirectionalVelocity velX =
				new DirectionalVelocityStub(AMOUNT_TO_MOVE, 0, 0, 0);
		DirectionalVelocity velY =
				new DirectionalVelocityStub(0, 0, 0, 0);
		Velocity vel = new VelocityImpl(velX, velY);
		Assert.assertEquals(AMOUNT_TO_MOVE, vel.getXAmountToMove());
	}
	
	@Test
	public void testGetXFramesPerMove() {
		final int FRAMES_PER_MOVE = 5;
		DirectionalVelocity velX =
				new DirectionalVelocityStub(0, FRAMES_PER_MOVE, 0, 0);
		DirectionalVelocity velY =
				new DirectionalVelocityStub(0, 0, 0, 0);
		Velocity vel = new VelocityImpl(velX, velY);
		Assert.assertEquals(FRAMES_PER_MOVE, vel.getXFramesPerMove());
	}
	
	@Test
	public void testGetYAmountToMove() {
		final int AMOUNT_TO_MOVE = 5;
		DirectionalVelocity velX =
				new DirectionalVelocityStub(0, 0, 0, 0);
		DirectionalVelocity velY =
				new DirectionalVelocityStub(AMOUNT_TO_MOVE, 0, 0, 0);
		Velocity vel = new VelocityImpl(velX, velY);
		Assert.assertEquals(AMOUNT_TO_MOVE, vel.getYAmountToMove());
	}
	
	@Test
	public void testGetYFramesPerMove() {
		final int FRAMES_PER_MOVE = 5;
		DirectionalVelocity velX =
				new DirectionalVelocityStub(0, 0, 0, 0);
		DirectionalVelocity velY =
				new DirectionalVelocityStub(0, FRAMES_PER_MOVE, 0, 0);
		Velocity vel = new VelocityImpl(velX, velY);
		Assert.assertEquals(FRAMES_PER_MOVE, vel.getYFramesPerMove());
	}
	
	@Test
	public void testMove() {
		final int X_MOVE_AMT = 3;
		final int Y_MOVE_AMT = 4;
		DirectionalVelocity velX =
				new DirectionalVelocityStub(0, 0, X_MOVE_AMT, 0);
		DirectionalVelocity velY =
				new DirectionalVelocityStub(0, 0, Y_MOVE_AMT, 0);
		Velocity vel = new VelocityImpl(velX, velY);
		
		VelocityResult result = vel.move();
		
		Assert.assertEquals(X_MOVE_AMT, result.getXAmountMoved());
		Assert.assertEquals(Y_MOVE_AMT, result.getYAmountMoved());
	}
	
	@Test
	public void testUnMove() {
		final int X_UNMOVE_AMT = 3;
		final int Y_UNMOVE_AMT = 4;
		DirectionalVelocity velX =
				new DirectionalVelocityStub(0, 0, 0, X_UNMOVE_AMT);
		DirectionalVelocity velY =
				new DirectionalVelocityStub(0, 0, 0, Y_UNMOVE_AMT);
		Velocity vel = new VelocityImpl(velX, velY);
		
		VelocityResult result = vel.unMove();
		
		Assert.assertEquals(X_UNMOVE_AMT, result.getXAmountMoved());
		Assert.assertEquals(Y_UNMOVE_AMT, result.getYAmountMoved());
	}
}
