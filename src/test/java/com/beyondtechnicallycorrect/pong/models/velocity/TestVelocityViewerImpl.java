package com.beyondtechnicallycorrect.pong.models.velocity;

import org.junit.Assert;
import org.junit.Test;

public final class TestVelocityViewerImpl {
	
	@Test
	public void testGetXVelocity() {
		final int X_AMOUNT = 1;
		final int X_FRAMES = 4;
		final double EXPECTED_X_VELOCITY = 0.25;
		VelocityInfo velInfo = new VelocityInfoStub(X_AMOUNT, X_FRAMES, 0, 1);
		VelocityViewer vel = new VelocityViewerImpl(velInfo);
		Assert.assertEquals(EXPECTED_X_VELOCITY, vel.getXVelocity(), 0.1);
	}
	
	@Test
	public void testGetYVelocity() {
		final int Y_AMOUNT = 5;
		final int Y_FRAMES = 2;
		final double EXPECTED_Y_VELOCITY = 2.5;
		VelocityInfo velInfo = new VelocityInfoStub(0, 1, Y_AMOUNT, Y_FRAMES);
		VelocityViewer vel = new VelocityViewerImpl(velInfo);
		Assert.assertEquals(EXPECTED_Y_VELOCITY, vel.getYVelocity(), 0.1);
	}

}
