package com.beyondtechnicallycorrect.pong.models.velocity;

import org.junit.*;

public final class VelocityFactoryImplIT {
	
	@Test
	public void testCreate_WithSaneInput_ShouldProduceObjectWithSameOutput() {
		final int X_AMOUNT = 1;
		final int X_FRAMES = 2;
		final int Y_AMOUNT = 3;
		final int Y_FRAMES = 4;
		Sanitizer sanitizer = new Sanitizer();
		VelocityFactory factory = new VelocityFactoryImpl(sanitizer);
		
		Velocity vel = factory.create(X_AMOUNT, X_FRAMES, Y_AMOUNT, Y_FRAMES);
		
		Assert.assertEquals(
				"X amount should match",
				X_AMOUNT, vel.getXAmountToMove());
		Assert.assertEquals(
				"X frames should match",
				X_FRAMES, vel.getXFramesPerMove());
		Assert.assertEquals(
				"Y amount should match",
				Y_AMOUNT, vel.getYAmountToMove());
		Assert.assertEquals(
				"Y frames should match",
				Y_FRAMES, vel.getYFramesPerMove());
	}
	
	@Test
	public void testCreate_WithInsaneInput_ShouldProduceObjectWithSaneOutput() {
		final int X_AMOUNT = 4;
		final int X_FRAMES = 2;
		final int SANE_X_AMOUNT = 2;
		final int SANE_X_FRAMES = 1;
		Sanitizer sanitizer = new Sanitizer();
		VelocityFactory factory = new VelocityFactoryImpl(sanitizer);
		
		Velocity vel = factory.create(X_AMOUNT, X_FRAMES, 5, 6);
		
		Assert.assertEquals(
				"X amount should be sane",
				SANE_X_AMOUNT, vel.getXAmountToMove());
		Assert.assertEquals(
				"X frames should be sane",
				SANE_X_FRAMES, vel.getXFramesPerMove());
	}

}
