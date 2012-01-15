package com.beyondtechnicallycorrect.pong.models.paddle;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;

public final class TestWallCollisionAdjustVelocityDelegate {
	
	@Test
	public void testGetAdjustedAmountToMove_WhenPositiveNumber_ShouldReturnZero() {
		AdjustVelocityDelegate del = new WallCollisionAdjustVelocityDelegate();
		final int POSITIVE_NUMBER = 3;
		Assert.assertEquals(0, del.getAdjustedAmountToMove(POSITIVE_NUMBER));
	}
	
	@Test
	public void testGetAdjustedAmountToMove_WhenNegativeNumber_ShouldReturnZero() {
		AdjustVelocityDelegate del = new WallCollisionAdjustVelocityDelegate();
		final int NEGATIVE_NUMBER = -3;
		Assert.assertEquals(0, del.getAdjustedAmountToMove(NEGATIVE_NUMBER));
	}
	
	@Test
	public void testGetAdjustedAmountToMove_WhenZero_ShouldReturnZero() {
		AdjustVelocityDelegate del = new WallCollisionAdjustVelocityDelegate();
		final int ZERO = 0;
		Assert.assertEquals(0, del.getAdjustedAmountToMove(ZERO));
	}

}
